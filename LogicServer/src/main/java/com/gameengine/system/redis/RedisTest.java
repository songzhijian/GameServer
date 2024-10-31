package com.gameengine.system.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class RedisTest {
    private final static Logger logger = LoggerFactory.getLogger(RedisTest.class);

    public static void main(String[] args) throws InterruptedException {
        init();
        //testSetAndGet();
       // testMap();
      //  testList();
        testSet();
        shutDown();
    }

    private static void testSetAndGet() throws InterruptedException {
        RedisSession redisSession = RedisService.instance.getLocalRedis();
        String key = "aaaaaaaaaa";
        redisSession.set("aaaaaaaaaaa", "ssssssss");
        logger.info("redis set aaaaaaaaaaa success ");
       // Thread.sleep(1000l);
        //long delResult = redisSession.deleteKeys(key);

       // long delResult = redisSession.deleteKeys(Arrays.asList(key));
        List<String> list =redisSession.getKeysStartingWith("aaa");


        //iterable.forEach(keys ->{logger.info("redis get aaaaaaaaaaa result {}",keys);});
        long delResult = redisSession.deleteByPattern("bbbb*");
        String result = redisSession.get("aaaaaaaaaaa");

        logger.info("redis get aaaaaaaaaaa result {} size {}",result);
        long remainingTimeInSeconds = redisSession.remainTimeToLive("aaaaaaaaaaa");
        logger.info("Remaining Time to Live: " + remainingTimeInSeconds);
    }

    private static void testMap() throws InterruptedException {
        String key = "testMap";
        Map<String, String> map = new HashMap<>();
        RedisSession localRedis = RedisService.instance.getLocalRedis();
        if(localRedis.exists(key)) {
            localRedis.deleteKeys(key);
        }

        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        localRedis.hMSet(key, map);
        logger.info("redis set map success !!!");
        Map<String, String> redisMap = localRedis.hMGetAll(key);
        //redisSession.hMSet();
        // Thread.sleep(1000l);
        //long delResult = redisSession.deleteKeys(key);

        // long delResult = redisSession.deleteKeys(Arrays.asList(key));
        localRedis.hMSet(key, "d","4");
        redisMap = localRedis.hMGetAll(key);
        localRedis.hMSetnx(key, "d", "5");
        redisMap = localRedis.hMGetAll(key);

        redisMap = localRedis.hMGet("aaaaaaaaaaaaaaaaa","ff");


        redisMap = localRedis.hMGet(key, Arrays.asList("a", "b","c"));
        String a = localRedis.hGet(key, "a");
        redisMap.forEach((rediskey,value) -> {logger.info("redis get map key {} value {}", rediskey, value);});
    }


    private static void testList() throws InterruptedException {
        String key = "testList";
        RedisSession localRedis = RedisService.instance.getLocalRedis();
        if(localRedis.exists(key)) {
            localRedis.deleteKeys(key);
        }
        localRedis.addFirst(key, "a");
        List<String> list  = localRedis.lRange(key, 0, -1);

        localRedis.addFirst(key, "a","b","c");

        list  = localRedis.lRange(key, 0, -1);

        localRedis.lSet(key, 1, "d");
        list  = localRedis.lRange(key, 0, -1);

        String value = localRedis.lPop(key);
        list  = localRedis.lRange(key, 0, -1);

        List<String> addList = Arrays.asList("e","f","g");
        localRedis.addFirst(key, addList);
        list  = localRedis.lRange(key, 0, -1);


        localRedis.rPop(key);
        list  = localRedis.lRange(key, 0, -1);
        value = localRedis.getElementAtIndex(key, 2);
        list  = localRedis.getElementsInRange(key, 2,3);
        localRedis.addLast(key, "dddd");
        list  = localRedis.lRange(key, 0, -1);
        localRedis.addLast(key, "i", "k");
        list  = localRedis.lRange(key, 0, -1);
        localRedis.addLast(key, Arrays.asList("u","v"));
        list  = localRedis.lRange(key, 0, -1);
        System.out.println();
      }

    private static void testSet() throws InterruptedException {
        String key = "testSet";
        RedisSession localRedis = RedisService.instance.getLocalRedis();
        if(localRedis.exists(key)) {
            localRedis.deleteKeys(key);
        }
       localRedis.sAdd(key, "a", "b");
       int size  = localRedis.setSize(key);
        Set<String> set = localRedis.sMembers(key);
        localRedis.sAdd(key, Arrays.asList("c", "d"));
        set = localRedis.sMembers(key);
        boolean remove = localRedis.sRem(key, "c","f");
        set = localRedis.sMembers(key);
        boolean exist = localRedis.sIsMember(key, "c");
        exist = localRedis.sIsMember(key, "e");
        System.out.println();
    }



    private static void init() {
        logger.info("redis init start");
        RedisService.instance.init();
        logger.info("redis init success !!!!");
    }

    private static void shutDown() {
        logger.info("redis shutDown start");
        RedisService.instance.shutDownAll();
        logger.info("redis shutDown success !!!!");

    }
}
