package com.gameengine.system.http;

import com.gameengine.system.utils.GameLoggerFactory;
import com.gameengine.system.utils.Map2ClassUtil;
import com.google.common.collect.Maps;
import com.jx.config.type.ErrorCode;
import com.jx.exception.GameException;
import com.tool.utils.JsonUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static io.netty.buffer.Unpooled.copiedBuffer;

public class LoginLoginCmd{

    private static final Logger logger = GameLoggerFactory.getLogger(LoginLoginCmd.class);

    private static final LoginLoginCmd instance = new LoginLoginCmd();

    public static LoginLoginCmd getInstance() {
        return instance;
    }

    public void executeCmd(Map<String, Object> postParams, ChannelHandlerContext channelHandlerContext){
        String cmd = postParams.get("cmd").toString();
        Map<String, Object> returnParam = Maps.newHashMap();
        switch (cmd){
            case "login":
                login(postParams, returnParam);
                break;
            case "register":
                register(postParams, returnParam);
                break;
            case "getClientParam":
                getClientParam(postParams, returnParam);
                break;
            case "getLoginURL":
                getLoginURL(postParams, returnParam);
                break;
        }
        String param = ArrayUtils.toString(postParams);
        String returnContent = JsonUtil.toJson(returnParam);
        ByteBuf content = copiedBuffer(returnContent, CharsetUtil.UTF_8);
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
        response.headers().set("Content-Type", "application/json;charset=UTF-8");
        response.headers().set("Content_Length", response.content().readableBytes());
        logger.info("POST RETURN, param:{}, return:{}", param, returnContent);
        channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    @HttpCmd
    public void login(Map<String, Object> param, Map<String, Object> returnParam) {
        ClientParams clientParams = Map2ClassUtil.mapToEntity(param, ClientParams.class);
        if (clientParams == null) {
            returnErr(ErrorCode.ILLEGAL_PARAMETER.getValue(), "param error", null, returnParam);
            logger.error("login clientParams error {}", param);
            return;
        }
//        loginWithRegister(clientParams, returnParam, false);
    }

    @HttpCmd
    public void register(Map<String, Object> param, Map<String, Object> returnParam) {
        ClientParams clientParams = Map2ClassUtil.mapToEntity(param, ClientParams.class);
        if (clientParams == null) {
            returnErr(ErrorCode.ILLEGAL_PARAMETER.getValue(), "param error", null, returnParam);
            logger.error("register clientParams error {}", param);
            return;
        }
//        loginWithRegister(clientParams, returnParam, true);
    }

    @HttpCmd
    public void getClientParam(Map<String, Object> param, Map<String, Object> returnParam) {
//        returnParam.putAll(RedisTool.opsForHash().entries("CLIENT_PARAM"));
    }

    @HttpCmd
    public void getLoginURL(Map<String, Object> param, Map<String, Object> returnParam) {
        try {
            ClientParams clientParams = Map2ClassUtil.mapToEntity(param, ClientParams.class);
            if (clientParams == null) {
                throw new GameException(ErrorCode.ILLEGAL_PARAMETER.getValue(), "clientParams == null");
            }

            final String loginIP;
//            if (checkTestServer(clientParams)) {
//                if (AppManger.ENVIRONMENT != AppEnvironment.RELEASE && IPUtil.internalIp(clientParams.getClientVersion())) {//内网IP
//                    loginIP = "http://10.2.4.44";
//                } else {
//                    loginIP = "http://169.46.214.14";
//                }
//            } else {
//                loginIP = "https://uwlogin.im30app.com";
//            }
            loginIP = "http://192.168.230.52";

            returnParam.put("ip", loginIP);
            returnParam.put("port", 10501);

        } catch (Exception e) {
            returnParam.put("ip", ""); //TODO 默认ip
            returnParam.put("port", 10501);
            logger.error("getLoginURL clientParams error {}", param);
        }

    }

//    public void loginWithRegister(ClientParams clientParams, Map<String, Object> returnParam, boolean register) {
//
//        if (!IpWhiteListService.getInstance().checkIpWhite(clientParams.getIp())) {
//            if (!CountryService.getInstance().checkCountryWhite(clientParams.getCountry())) {
//                returnErr(ErrorCode.LOGIN_FAIL_REGION_NOT_OPEN.getValue(), String.format("checkCountryWhite fail! ip : %s, country : %s", clientParams.getIp(), clientParams.getCountry()), null, asyncResp);
//                return;
//            }
//        }
//
//        if (!register) {
//            if (clientParams.getAccountId() != null && StringUtils.isNotBlank(clientParams.getAccountId())) {
//                if (AppManger.ENVIRONMENT != AppEnvironment.RELEASE && StringUtils.isNumeric(clientParams.getAccountId())) {
//                    //开发环境可以uid登录
//                    long uid = Long.parseLong(clientParams.getAccountId());
//                    uidLogin(uid, clientParams, returnParam);
//                    return;
//                }
//                accountIdLogin(clientParams.getAccountId(), clientParams, returnParam, false);
//                return;
//            }
//        }
//
//        if (clientParams.getPlatformId() == null || StringUtils.isBlank(clientParams.getPlatformId())) {
//            if (clientParams.getDeviceId() == null || StringUtils.isBlank(clientParams.getDeviceId())) {
//                clientParams.setDeviceId(UuidUtils.getUuid());
//            }
//            clientParams.setPlatform(PlatformType.DEVICE.name());
//            clientParams.setPlatformId(clientParams.getDeviceId());
//        }
//
//
//        try {
//            PlatformType platformType = PlatformType.valueOf(clientParams.getPlatform().trim().toUpperCase());
//            String occupyKey = LockUtil.getPlatformIdMappingLockKey(platformType.name(), clientParams.getPlatformId());
//            String uuid = UuidUtils.getUuid();
//            RedisLock<String> platformIdRegisterOccupyLock = new RedisLock<>(occupyKey, uuid, String.class);
//            String occupyValue = platformIdRegisterOccupyLock.tryOccupy(DateUtils.MINUTE);
//            if (!uuid.equals(occupyValue)) {
//                // 这次http抢占失败，通知客户端有其他设备正在尝试登录注册/绑定同一个platformId。客户端可以自行选择后台重试；也可以选择通知用户
//                returnErr(ErrorCode.PLATFORM_ID_OCCUPY.getValue(), "platformId is occupy used", null, returnParam);
//                return;
//            }
//
//            //点了进入 又不发accountId的 用平台ID帮他去找 然后登录
//            PlayerMappingEntity mappingQuery = new PlayerMappingEntity(clientParams.getPlatformId().hashCode());
//            DBManager.getDbUtil().getList(DataSourceType.LOGIN, StaticValues.LOGIN_DB_ID, mappingQuery, () -> {
//                mappingQuery.setMappingType(platformType.name());
//                mappingQuery.setMappingValue(clientParams.getPlatformId());
//            }, selectResult -> {
//
//                PlayerMappingEntity lastMappingEntity = null;
//                if (selectResult != null && !selectResult.isEmpty()) {
//                    lastMappingEntity = selectResult.get(0);
//                }
//
//                if (lastMappingEntity == null) {//没号给他注册一个
//                    gameRegisterPlayer(clientParams, platformIdRegisterOccupyLock, returnParam);
//                    return;
//                }
//
//                // 查询到mapping，解除占有
//                platformIdRegisterOccupyLock.unOccupy();
//
//                if (lastMappingEntity.getActive() <= 0) {//没激活 让他等
//                    returnErr(ErrorCode.PLATFORM_ID_OCCUPY.getValue(), "lastMappingEntity.getActive() <= 0", null, returnParam);
//                    return;
//                }
//
//                accountIdLogin(lastMappingEntity.getAccountId(), clientParams, asyncResp, register);
//            });
//        } catch (Exception e) {
//            returnErr(ErrorCode.ILLEGAL_PARAMETER.getValue(), String.format("mappingType unknown, platform : %s", clientParams.getPlatform()), null, returnParam);
//        }
//    }

    private void returnErr(int errCode, String errMsg, Object[] params, Map<String, Object> returnParam) {
        returnParam.put("errorCode", errCode);
        returnParam.put("msg", errMsg);
        returnParam.put("params", params);
    }

    /**
     * 注册账号
     *
     * @param clientParams
     * @param platformIdRegisterOccupyLock
     * @param asyncResp
     */
//    private void gameRegisterPlayer(ClientParams clientParams, RedisLock<?> platformIdRegisterOccupyLock, Map<String, Object> returnParam) {
//        PlayerAccountEntity accountEntity = PlayerRegisterLoginUtil.createPlayerAccount(clientParams);
//        DBManager.getDbUtil().insert(DataSourceType.LOGIN, StaticValues.LOGIN_DB_ID, accountEntity, accountResult -> {
//            PlayerMappingEntity mappingEntity = PlayerRegisterLoginUtil.createMapping(accountEntity.getAccountId(), clientParams);
//            DBManager.getDbUtil().insert(DataSourceType.LOGIN, StaticValues.LOGIN_DB_ID, mappingEntity, mappingResult -> {
//                platformIdRegisterOccupyLock.unOccupy();
//                accountEntity.getMappingState().put(PlatformType.valueOf(clientParams.getPlatform()).getValue(), mappingEntity.getActive());
//                accountEntityLogin(accountEntity, clientParams, returnParam, true);
//            });
//        });
//    }


//    private void accountIdLogin(final String accountId, ClientParams clientParams, Map<String, Object> returnParam, boolean register) {
//        PlayerAccountEntity accountEntity = new PlayerAccountEntity(accountId.hashCode());
//        DBManager.getDbUtil().getOneByPrimaryKey(DataSourceType.LOGIN, StaticValues.LOGIN_DB_ID, accountEntity, () -> {
//            accountEntity.setAccountId(accountId);
//        }, accountSelectResult -> {
//            if (accountSelectResult == null || accountSelectResult.isEmpty()) {
//                returnErr(ErrorCode.LOGIN_FAIL_ACCOUNT_STATE_ERROR.getValue(), "no this accountId : " + accountId, null, asyncResp);
//                return;
//            }
//
//            // 校验账号状态
//            ErrorCode errorCode = accountStateCheck(accountSelectResult);
//            if (errorCode != null) {
//                Object[] params = null;
//                if (errorCode.equals(ErrorCode.LOGIN_FAIL_TEMP_BAN)) {
//                    params = new Object[1];
//                    params[0] = accountSelectResult.getBanTime() - DateUtils.getBusinessTime(); // 剩余多久解封
//                }
//                returnErr(errorCode.getValue(), String.format("login fail. this accountId:%s state:%d", accountId,
//                        accountSelectResult.getAccountState()), params, asyncResp);
//                return;
//            }
//
//            accountEntityLogin(accountSelectResult, clientParams, asyncResp, register);
//        });
//    }

//    private void accountEntityLogin(PlayerAccountEntity accountEntity, ClientParams clientParams, Map<String, Object> returnParam, boolean register) {
//
//        if (register) {
//            registerUidEntityAndLogin(accountEntity, clientParams, returnParam);
//            return;
//        }
//
//        long uid = 0;
//        try {
//            if (StringUtils.isNotBlank(clientParams.getUid())) {
//                uid = Long.parseLong(clientParams.getUid());
//            }
//        } catch (Exception e) {
//            LogUtils.logger.warn("ERROR clientParams.getUid() = {}", clientParams.getUid());
//        }
//        if (uid > 0) {//登录指定uid
//            final long finalUid = uid;
//            PlayerUidEntity playerUidEntity = new PlayerUidEntity(finalUid);
//            DBManager.getDbUtil().getOneByPrimaryKey(DataSourceType.LOGIN, StaticValues.LOGIN_DB_ID, playerUidEntity, () -> {
//                playerUidEntity.setUid(finalUid);
//            }, uidResult -> {
//                if (uidResult == null || uidResult.isEmpty() || uidResult.getDelete() == Constants.COMMON_TURE
//                        || !accountEntity.getAccountId().equals(uidResult.getAccountId())) {
//                    returnErr(ErrorCode.LOGIN_FAIL_ACCOUNT_STATE_ERROR.getValue(), String.format("login finalUid null : %d", finalUid), null, returnParam);
//                    return;
//                }
//
//                login(accountEntity, uidResult, clientParams, returnParam);
//            });
//        } else if (accountEntity.getLastUid() > 0) {//不指定默认登录最后的uid
//            PlayerUidEntity playerUidEntity = new PlayerUidEntity(accountEntity.getLastUid());
//            DBManager.getDbUtil().getOneByPrimaryKey(DataSourceType.LOGIN, StaticValues.LOGIN_DB_ID, playerUidEntity, () -> {
//                playerUidEntity.setUid(accountEntity.getLastUid());
//            }, uidResult -> {
//                if (uidResult == null) {
//                    returnErr(ErrorCode.LOGIN_FAIL_ACCOUNT_STATE_ERROR.getValue(), String.format("login uid null : %d , %s",
//                            accountEntity.getLastUid(), accountEntity.getAccountId()), null, returnParam);
//                    return;
//                }
//
//                if (uidResult.isEmpty()) {//有accountId 没有uid 注册一个
//                    registerUidEntityAndLogin(accountEntity, clientParams, returnParam);
//                    return;
//                }
//
//                // 账号删除了，选择新号 （正常不会出现这种情况，做个容错,万一删除了，直接新建角色）
//                if (uidResult.getDelete() == Constants.COMMON_TURE) {
//                    LogUtils.logger.error("player is delete.uid:{}", uidResult.getUid());
//                    registerUidEntityAndLogin(accountEntity, clientParams, returnParam);
//                    return;
//                }
//
//                login(accountEntity, uidResult, clientParams, returnParam);//找到最后登录的角色
//            });
//        } else {//注册一个
//            registerUidEntityAndLogin(accountEntity, clientParams, returnParam);
//        }
//    }

//    private void registerUidEntityAndLogin(final PlayerAccountEntity accountEntity, final ClientParams clientParams, Map<String, Object> returnParam) {
//        final int serverId = PlayerRegisterLoginUtil.generateServerId(clientParams);
//        final int roleCount;
//        if (!AppManger.isPublicTestUWServer()) {
//            roleCount = accountEntity.getServerPlayerCount().getMap().getOrDefault(serverId, 0);
//            if (roleCount >= GlobalConfig.RoleNumOneServer) {
//                returnErr(ErrorCode.SINGLE_SERVER_ROLES_LIMIT.getValue(), "LOGIN SINGLE_SERVER_ROLES_LIMIT ERROR accountId : "
//                        + accountEntity.getAccountId(), null, returnParam);
//                return;
//            }
//        } else {
//            roleCount = 0;
//        }
//        final PlayerUidEntity playerUidEntity = PlayerRegisterLoginUtil.createPlayerUid(accountEntity.getAccountId(), serverId, clientParams);
//        DBManager.getDbUtil().insert(DataSourceType.LOGIN, StaticValues.LOGIN_DB_ID, playerUidEntity, resultEntity -> {
//            accountEntity.getServerPlayerCount().put(serverId, roleCount + 1);
//            login(accountEntity, playerUidEntity, clientParams, returnParam);
//        });
//    }

//    private ErrorCode accountStateCheck(PlayerAccountEntity accountEntity) {
//        // 验证账号状态
//        int state = accountEntity.getAccountState();
//        AccountStateEnum accountState = AccountStateEnum.getType(state);
//        if (accountState == null) {
//            return ErrorCode.LOGIN_FAIL_ACCOUNT_STATE_ERROR;
//        }
//        switch (accountState) {
//            case TEMP_BAN -> {
//                // 临时封号时间到了，修改下账号状态(这边不需要写库，后面有更新的操作)
//                if (DateUtils.getBusinessTime() > accountEntity.getBanTime()) {
//                    accountEntity.setAccountState(AccountStateEnum.COMMON.getValue());
//                    accountEntity.setBanTime(0);
//                } else {
//                    return ErrorCode.LOGIN_FAIL_TEMP_BAN;
//                }
//            }
//            case FOREVER_BAN -> {
//                return ErrorCode.LOGIN_FAIL_FOREVER_BAN;
//            }
//            case DESTROY -> { // 目前只有删角色，没有删账号了
//                return ErrorCode.LOGIN_FAIL_ACCOUNT_DESTROY;
//            }
//        }
//
//        return null;
//    }

//    private void login(PlayerAccountEntity playerAccountEntity, PlayerUidEntity playerUidEntity, ClientParams clientParams, Map<String, Object> returnParam) {
//        if (playerUidEntity.getServerId() < 0) {
//            returnErr(ErrorCode.LOGIN_FAIL_ACCOUNT_STATE_ERROR.getValue(), String.format("login transferring server : %d , %s", playerAccountEntity.getLastUid(), playerAccountEntity.getAccountId()), null, asyncResp);
//            return;
//        }
//        repairOldData(playerUidEntity,clientParams);
//
//
//        RegisterParams registerParams = new RegisterParams();
//        registerParams.setRegCity(playerAccountEntity.getCity());
//        registerParams.setRegDeviceId(playerAccountEntity.getDeviceId());
//        registerParams.setRegTime(playerUidEntity.getRegTime());
//        registerParams.setRegFireBaseId(playerAccountEntity.getFirebaseId());
//        registerParams.setRegCountry(playerUidEntity.getCountry());
//        registerParams.setRegLanguage(playerUidEntity.getLanguage());
//        registerParams.setRegClientVersion(playerUidEntity.getClientVersion());
//        registerParams.setRegPlatformType(playerUidEntity.getPlatformType());
//
//        registerParams.setGAID(playerAccountEntity.getGAID());
//        registerParams.setAccountId(String.valueOf(playerAccountEntity.getAccountId()));
//        registerParams.setShowUid(playerUidEntity.getShowUid());
//        registerParams.setRegServerId(playerUidEntity.getServerId());
//        registerParams.setMappingState(playerAccountEntity.getMappingState().getMap());
//        clientParams.setZone(String.valueOf(playerUidEntity.getServerId()));
//
//        playerUidEntity.setLastLoginTime(DateUtils.getBusinessTime());
//        DBManager.getDbUtil().updateOneByPrimaryKey(DataSourceType.LOGIN, StaticValues.LOGIN_DB_ID, playerUidEntity, uidResult -> {
//
//            if (uidResult == null || !uidResult) {
//                LogUtils.logger.error("LOGIN ERROR accountId = {}, uid = {}, serverId = {}", playerUidEntity.getAccountId(), playerUidEntity.getUid(), playerUidEntity.getServerId());
//                returnErr(ErrorCode.LOGIN_FAIL_ACCOUNT_STATE_ERROR.getValue(), "LOGIN ERROR accountId : " + playerUidEntity.getAccountId(), null, returnParam);
//                return;
//            }
//
//            String token = TokenUtil.buildToken(playerUidEntity.getUid(), playerUidEntity.getServerId(), UuidUtils.getRandomUuid());
//            String registerJson = JsonUtil.toJson(registerParams);
//            String clientJson = JsonUtil.toJson(clientParams);
//            RedisTool.opsForValue().set(String.format("Token:%s", token), String.format("%s#####%s", registerJson, clientJson), 5, TimeUnit.MINUTES);
//
//            App gateApp = chooseGate();
//            returnParam.put("ip", gateApp.getAppData().getNetworkIp());
//            returnParam.put("port", AppManger.GATE_PORT);
//            returnParam.put("token", token);
//            returnParam.put("accountId", playerUidEntity.getAccountId());
//            String configVersion = RedisTool.opsForHash().get("CLIENT_VERSION_" + playerUidEntity.getServerId(), clientParams.getClientVersion());
//            returnParam.put("configVersion", configVersion);
//
//            playerAccountEntity.setLastUid(playerUidEntity.getUid());
//            if (StringUtils.isBlank(playerAccountEntity.getAppsflyerId()) && StringUtils.isNotBlank(clientParams.getAppsFlyerId())) {
//                playerAccountEntity.setAppsflyerId(clientParams.getAppsFlyerId());
//            }
//            if (StringUtils.isBlank(playerAccountEntity.getGAID()) && StringUtils.isNotBlank(clientParams.getGAID())) {
//                playerAccountEntity.setAppsflyerId(clientParams.getGAID());
//            }
//            DBManager.getDbUtil().updateOneByPrimaryKey(DataSourceType.LOGIN, StaticValues.LOGIN_DB_ID, playerAccountEntity, accountResult -> {
//                //TODO: 一些打点可以放在这
//                LogUtils.logger.info("LOGIN SUCCESS accountId = {}, uid = {}, serverId = {}", playerUidEntity.getAccountId(), playerUidEntity.getUid(), playerUidEntity.getServerId());
//            });
//        });
//    }

//    private void repairOldData(PlayerUidEntity playerUidEntity, ClientParams clientParams) {
//        boolean  needUpdate = false;
//        if(playerUidEntity.getLanguage() == null){
//            playerUidEntity.setLanguage(clientParams.getLanguage()==null?"en":clientParams.getLanguage());
//            needUpdate = true;
//        }
//
//        if(playerUidEntity.getPlatformType() == null){
//            playerUidEntity.setPlatformType(PlayerRegisterLoginUtil.getPlatformType(clientParams));
//            needUpdate = true;
//        }
//
//        if(needUpdate){
//            DBManager.getDbUtil().updateOneByPrimaryKey(DataSourceType.LOGIN, StaticValues.LOGIN_DB_ID, playerUidEntity,null);
//        }
//    }

    private final AtomicInteger gateIndexCounter = new AtomicInteger(0);

//    private App chooseGate() {
//        if (AppManger.isRelease()) {
//            return ServerStateManager.INSTANCE.chooseGate(gateIndexCounter.incrementAndGet());
//        } else {
//            App localLoginApp = AppManger.getLocalAppByType(AppType.LOGIN);
//            return AppManger.getApp(AppType.GATE, localLoginApp.getAppData().getAppId());
//        }
//    }

    /**
     * 开发环境专用 uid登录 线上禁用
     * @param uid
     * @param clientParams
     * @param asyncResp
     */
//    private void uidLogin(long uid, ClientParams clientParams, Map<String, Object> returnParam) {
//        PlayerUidEntity playerUidEntity = new PlayerUidEntity(uid);
//        DBManager.getDbUtil().getOneByPrimaryKey(DataSourceType.LOGIN, StaticValues.LOGIN_DB_ID, playerUidEntity, () -> {
//            playerUidEntity.setUid(uid);
//        }, uidResult -> {
//            if (uidResult == null || uidResult.isEmpty()) {
//                returnErr(ErrorCode.ILLEGAL_PARAMETER.getValue(), String.format("no this uid : %d", uid), null, returnParam);
//                return;
//            }
//
//            // 账号删除了，无法登录
//            if (uidResult.getDelete() == Constants.COMMON_TURE) {
//                returnErr(ErrorCode.LOGIN_FAIL_ACCOUNT_DESTROY.getValue(), String.format("this uid delete: %d", uid), null, returnParam);
//                return;
//            }
//
//            PlayerAccountEntity accountEntity = new PlayerAccountEntity(uidResult.getAccountId().hashCode());
//            DBManager.getDbUtil().getOneByPrimaryKey(DataSourceType.LOGIN, StaticValues.LOGIN_DB_ID, accountEntity, () -> {
//                accountEntity.setAccountId(uidResult.getAccountId());
//            }, accountSelectResult -> {
//                if (accountSelectResult == null || accountSelectResult.isEmpty()) {
//                    returnErr(ErrorCode.LOGIN_FAIL_ACCOUNT_STATE_ERROR.getValue(), "no this accountId", null, returnParam);
//                    return;
//                }
//                // 校验账号状态
//                ErrorCode errorCode = accountStateCheck(accountSelectResult);
//                if (errorCode != null) {
//                    returnErr(errorCode.getValue(), String.format("login fail. this accountId:%s state:%d",
//                            accountSelectResult.getAccountId(), accountSelectResult.getAccountState()), null, returnParam);
//                    return;
//                }
//                login(accountSelectResult, uidResult, clientParams, returnParam);
//            });
//        });
//    }

//    private boolean checkTestServer(ClientParams clientParams) {
//        if (AppManger.ENVIRONMENT != AppEnvironment.RELEASE) {
//            return true;
//        }
//
//        return DeviceQAService.getInstance().checkDeviceWhite(clientParams.getDeviceId());
//    }
}

