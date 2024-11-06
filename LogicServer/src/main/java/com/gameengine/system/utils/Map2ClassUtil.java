package com.gameengine.system.utils;

import com.gameengine.system.http.ClientParams;
import net.dreamlu.mica.core.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Map2ClassUtil {
    private static final Logger logger = GameLoggerFactory.getLogger(Map2ClassUtil.class);

    public static <T> T mapToEntity(Map<?, ?> map, Class<T> clazz) {
        // 验证Map和实体类Class对象是否为空
        Assert.notNull(map, "map cannot be null");
        Assert.notNull(clazz, "entity class cannot be null");
        try {
            List<Field> allFields = new ArrayList<>();
            T t = clazz.getDeclaredConstructor().newInstance();
            Class<?> aClass = clazz;
            do {
                // 利用Java反射获取自身属性以及父类属性
                allFields.addAll(Stream.of(aClass.getDeclaredFields()).toList());
                aClass = aClass.getSuperclass();
                // Object类为超级大类，到了Object类，继承关系已到了顶点，不需要处理了
            } while (!StringUtils.equals(aClass.getTypeName(), Object.class.getTypeName()));
            // 对实体类的属性进行遍历
            for (Field field : allFields) {
                // 获取属性名称
                String fieldName = field.getName();
                // 属性对应的实体类名称，这里需要一一对应，否则取不到值
                Object data = map.get(fieldName);
                if (data == null) {
                    continue;
                }
                // 按照Java约定的getter、setter方法命名规范，拼装setter方法名
                String methodName = StringUtil.format("set{}{}", fieldName.substring(0, 1).toUpperCase(), fieldName.substring(1));
                // 获取setter方法的Method对象
                Method method = clazz.getMethod(methodName, field.getType());
                // 利用Java反射调用实体对象的setter方法对属性进行赋值操作
                method.invoke(t, getData(data, field.getType()));
            }
            return t;
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException |
                 IllegalAccessException e) {
            logger.error("map error : {}", e.getMessage());
        }

        return null;
    }

    /**
     * 这里的这个方法是为了兼容Sql语句查询后返回的Map。
     * 在使用Mybatis查询后返回的数据类型为了兼容都使用了大类型，本来是int类型的数据
     * 但还是返回了long类型，在这里就做了特殊处理，如果实体类中属性为int，Map中类型为Long时，
     * 就对类型进行转换。在这里还可以做其他的兼容处理
     */
    private static Object getData(Object data, Class<?> type) {
        String typeName = type.getTypeName();
        if (StringUtils.equals(typeName, Integer.class.getTypeName())) {
            if (data instanceof Long) {
                return ((Long) data).intValue();
            }
        }
        return data;
    }

    public static void main(String[] args) {
        String param = "clientVersionCode=583, installTs=1691373078, country=NZ, city=新西兰 Auckland, isInstantExperienceLaunched=false, ip=14.1.64.66, platformType=, packageId=com.deedledoodle.io.survivor, OAID=, language=English, deviceOsVersion=Android OS 13 / API-33 (TKQ1.221013.002/V14.0.3.0.TJUMIXM), installServerTs=1691373077, clientVersion=1.0.0, clickTs=1691373066, deviceId=40e46e7c0dc11f67575f74adf0683d7f518934, installVersion=1.0.0, appsFlyerId=1691374122828-3319453982186760423, accountId=, GPIR=utm_source=apps.facebook.com&utm_campaign=fb4a&utm_content=%7B%22app%22%3A1953875928323010%2C%22t%22%3A1691373034%2C%22source%22%3A%7B%22data%22%3A%2251cabc577b3d9d80b08b2b1bfed0a3ba1689e1ba1d2059f78962a000120eca8df5e3f854cb62780029b50e8d9e0c1db0abb0243e59cb3263046b36d9318f1f44c206bbc45d930c49cfc493e96359e888eb4935f90d57e2c4df7794d7d159d8fbe3140873bd109a3454bb3a992a55167c7b719fd8b824cfe6e123fc14d6ffe6a8629cdc8fc273ac31d58678c414217c129c257d18e444ffcd4ecc0d63d3e42a7b31198e20b3a52610d1eacabd9e3b39580c241e56ddc9d4e8414926d378eb26e4962bc2055481fe8a7f01d8a32c6458fef0e1e9103d30bd89dac950a100b78e5fb2152a5f067b6693be8f0a1bb50f3ba01a04a97e09c88edb6239ed91cfc093c17d2af52dd23ef02d1e721cea245205cb1bcc18f162724d3e5da62f7bb948e3d030960a303496463703fbc316c655ccaa0ee592092c35eaaede34a0feddef2d33fdc4e2f3bc9f9c463d68b9cf2f3ae70b1f0aba418eb02354354b8aa61b951e82b6424d5578e49def583a3f6b311f621380c8976725af0958f6d5207270f0a6f75bec8d63d71432e38c2dce1ea0587a45d09cd1be4a2fe2c21e19aff1d30d72822e90c21a322b184a39851e6ef7a485f69ab29d5044d5978441e03c36e556d91099a00b2475435ee294%22%2C%22nonce%22%3A%225e984890ec69d36138327cf1%22%7D%7D, clickServerTs=1691373066, IDFA=, GAID=, deviceModelId=Xiaomi M2102J20SG, cmd=login";
        String[] array = param.split(", ");
        Map<String, Object> map = new HashMap<>();
        for (String str : array) {
            map.put(str.substring(0, str.indexOf("=")), str.substring(str.indexOf("=") + 1).trim());
        }

        System.out.println(map);

        ClientParams clientParams = Map2ClassUtil.mapToEntity(map, ClientParams.class);

        System.out.println(clientParams);
    }
}
