package com.gameengine.system.mybatis.sql_stat;

import com.dreamfun.opg.GameServer;
import com.dreamfun.opg.utils.GameLoggerFactory;
import com.gameengine.system.mybatis.MybatisUtils;
import com.jolbox.bonecp.BoneCP;
import org.slf4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SqlStatUtils {
    private static final Logger logger = GameLoggerFactory.getLogger(SqlStatUtils.class);

    public static int SLOW_LIMIT = 500; // ms

    public static int SQL_EXEC_LIMIT = 45000;

    public static volatile long periodValidTime = 0;

    public static boolean open = true;

    public static boolean bPrintLog = false; // 是否打印日志

    private static Map<String, Map<String, SqlStat>> sqlStatMap = new ConcurrentHashMap<>();

    private static volatile int poolStatCount = 0;
    private static Map<String, Integer> sqlStatCountPeriod = new ConcurrentHashMap<>();
    private static Map<String, Integer> sqlPeriodStatPeriod = new ConcurrentHashMap<>();

    public static void stat(String tableName, String operation, boolean slow) {
        Map<String, SqlStat> map = sqlStatMap.computeIfAbsent(tableName, k -> new ConcurrentHashMap<>());
        SqlStat stat = map.computeIfAbsent(operation, k -> new SqlStat(tableName, operation));
        if (slow) {
            stat.addSlowNum();
        }
        stat.addTotalNum();

        if( bPrintLog ) {
            logger.info(" sql table " + tableName + " " + operation);
        }
    }

    public static void resetPeriodStat() {
        long currentTime = System.currentTimeMillis();
        if(currentTime < periodValidTime) {
            return;
        }
        periodValidTime = System.currentTimeMillis() + 5 * 50 * 1000;
        sqlStatCountPeriod.clear();
        sqlPeriodStatPeriod.clear();
        poolStatCount = 0;
    }

    /**
     *  5分钟, 出现150次 连接池耗光, 自动打开session泄露日志打印
     * @param pool
     */
    public static void periodPoolStat(BoneCP pool) {
        if(MybatisUtils.useProxy == true) {
            return;
        }

        int freeCount = pool.getTotalFree();
        if(freeCount > 0) {
            poolStatCount = 0;
            return;
        }
        poolStatCount ++;
        if(poolStatCount < 150) {
            return;
        }
        logger.info("BoneCP Pool: Leased ConnectionHandle is Max, MyBatisSessionUtil useProxy is open");
        MybatisUtils.useProxy = true;
        poolStatCount = 0;
    }

    /**
     *  5分钟,出现单表操作达到45000数量级3次报警    150w / (12 * 3)
     *  golbal正常tps是1300左右, 赛季服, 普通服 200左右,
     *  异常情况记录:UserAttainmentsTask,操作频繁 global tps达到正常情况的10倍以上 14000左右
     * @param tableName
     */
    public static void periodStat(String tableName) {
        int sqlPeriodStatCount = sqlPeriodStatPeriod.computeIfAbsent(tableName, r -> 0);
        sqlPeriodStatPeriod.put(tableName, ++ sqlPeriodStatCount);
        if(sqlPeriodStatCount < SQL_EXEC_LIMIT) {
            return;
        }
        sqlPeriodStatPeriod.remove(tableName);

        int count = sqlStatCountPeriod.computeIfAbsent(tableName, r -> 0);
        sqlStatCountPeriod.put(tableName, ++ count);
        if(count < 3) {
            return;
        }
        logger.warn("sql table exec often tableName: {}", tableName);
        sqlStatCountPeriod.remove(tableName);
        // 报警
//        CommonScheduler.getCommonScheduler().getStatStatisticalService().execute(() ->
//                sendWarning(statContent(tableName)));
    }

    public static String statContent(String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append("数据库表: ").append(tableName).append(" 操作频繁, 服务器Id: ").append(GameServer.getInstance().getServerId()).append("\n");
        return sb.toString();
    }

//    public static void sendWarning(String text){
//        try {
//            String mindUrl ="https://mind.im30.net/api/hooks/cf3espcropbi3xpzbmazxb679a";
//            Map<String, String> paramMind = new HashMap<>();
//            paramMind.put("text", text);
//            String ret = HttpUtil.postJson(mindUrl, paramMind);
//            LoggerUtil.getInstance().logBySFS(ret);
//        } catch (Exception e) {
//            LoggerUtil.getInstance().recordException(e);
//        }
//    }

    static class SqlStat {
        SqlStat(String tableName, String operation) {
            this.tableName = tableName;
            this.operation = operation;
        }

        private String tableName;

        private String operation;

        private int totalNum;

        private int slowNum;

        public void addTotalNum() {
            totalNum += 1;
        }

        public void addSlowNum() {
            slowNum += 1;
        }

        public int getTotalNum() {
            return totalNum;
        }

        public String toString() {
            String logFormat = "sql stat, tableName = %s,  operation = %s,  totalNum = %d,  slowNum = %d";
            return String.format(logFormat, tableName, operation, totalNum, slowNum);
        }
    }

    public static void recordStatLog() {
//        sqlStatMap.values().stream()
//                .flatMap(m -> m.values().stream())
//                .sorted(Comparator.comparing(SqlStat::getTotalNum).reversed())
//                .map(SqlStat::toString)
//                .forEach(s -> logger.info(s));
    }

    /**
     * 第三方工具获得当都表的 统计信息
     * @param tableName
     * @return
     */
    public static String getSqlStatInfo(String tableName) {
        StringBuilder sb = new StringBuilder();
//        Map<String,SqlStat> map = sqlStatMap.get(tableName);
//        if(CollectionUtils.isEmpty(map)) {
//            return sb.toString();
//        }
//        map.values().stream()
//                .sorted(Comparator.comparing(SqlStat::getTotalNum).reversed())
//                .map(SqlStat::toString)
//                .forEach(s-> {
//                    sb.append(s);
//                    sb.append('\n');
//                });
        return sb.toString();
    }

    /**
     * 第三方工具调用接口打印 获得详细信息
     * @return
     */
    public static String getSqlStatInfo() {
        StringBuilder sb = new StringBuilder();
//        sqlStatMap.values().stream()
//                .flatMap(m -> m.values().stream())
//                .sorted(Comparator.comparing(SqlStat::getTotalNum).reversed())
//                .map(SqlStat::toString)
//                .forEach(s-> {
//                    sb.append(s);
//                    sb.append('\n');
//                });
        return sb.toString();
    }


    /**
     * 定时器不断的打印日志
     */
    public static void startSqlStatTask() {
//        CommonScheduler.getCommonScheduler().getStatStatisticalService().scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    if (open) {
//                        recordStatLog();
//                        sqlStatMap.clear();
//                    }
//                } catch (Exception e) {
//                    logger.error("error", e);
//                }
//            }
//        }, 60, 60, TimeUnit.MINUTES);
    }

}