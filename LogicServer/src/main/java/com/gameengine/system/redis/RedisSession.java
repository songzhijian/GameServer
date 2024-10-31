package com.gameengine.system.redis;

import org.redisson.api.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Redis封装
 */
public class RedisSession {
    RedissonClient redisson = null;
    private RedisSession(){
    }

    public RedissonClient getRedisson() {
        return redisson;
    }

    public static RedisSession buildRedisSession(RedissonClient redisson) {
        RedisSession rs = new RedisSession();
        rs.redisson = redisson;
        return rs;
    }

    public String get(String key) {
        RBucket<String> bucket = redisson.getBucket(key);
        String ret = bucket.get();
        return ret;
    }

    public void set(String key, String field) {
        RBucket<String> bucket = redisson.getBucket(key);
        bucket.set(field);
    }

    /**
     * 使用 `trySet` 方法设置键值，如果键不存在则返回 true，否则返回 false
     * @param key
     * @param value
     * @return
     */
    public boolean setnx(String key, String value) {
        RBucket<String> rBucket = redisson.getBucket(key);
        return rBucket.trySet(value);
    }

    /**
     * set 一个存活时长为expire秒的key
     * @param key
     * @param value
     * @param expire 设置key 存活时长
     * @return
     */
    public boolean setNxAndEx(String key, String value, int expire) {
        RBucket<String> bucket = redisson.getBucket(key);
        bucket.set(value);
        return bucket.expire(expire, TimeUnit.SECONDS);
    }

    /**
     * key 剩余存活时间 单位毫秒
     * @param key
     * @return
     */
    public long remainTimeToLive(String key) {
        RBucket<String> bucket = redisson.getBucket(key);
        return bucket.remainTimeToLive();
    }

    /**
     *  使用 `remainTimeToLive` 方法获取键的剩余生存时间，单位为秒
     * @param key
     * @return
     */
    public long ttl(String key) {
        RKeys rKeys = redisson.getKeys();
        long result = rKeys.remainTimeToLive(key);
        return result;
    }

    /**
     * 使用 `countExists` 方法判断键是否存在
     * @param key
     * @return
     */
    public boolean exists(String key) {
        RKeys rKeys = redisson.getKeys();
        return rKeys.countExists(key) > 0;
    }


    /**
     *  使用 RKeys 对象的 delete 方法删除多个 key
     * @param keys
     */
    public long deleteKeys(String... keys) {
        return redisson.getKeys().delete(keys);
    }

    /**
     * 删除多个key
     * @param keys
     * @return
     */
    public long deleteKeys(List<String> keys) {
        if(keys == null || keys.isEmpty()){
            return 0;
        }
        String[] keyArr = keys.toArray(new String[keys.size()]);
        return redisson.getKeys().delete(keyArr);
    }

    /**
     * 删除某种格式的key
     * @param pattern
     */
    public long deleteByPattern(String pattern) {
        return redisson.getKeys().deleteByPattern(pattern);
    }


    /**
     * 使用 `getKeysByPattern` 方法获取匹配模式的键
     * @param prefix
     * @return
     */
    public List<String> getKeysStartingWith(String prefix) {
        RKeys rKeys = redisson.getKeys();
        Iterable<String> keysIterable = rKeys.getKeysByPattern((prefix + "*"), 1000);

        // 将Iterable转换为List
        List<String> keysList = new ArrayList<>();
        keysIterable.forEach(keysList::add);
        return keysList;
    }

    public Iterable<String> getKeysByPattern(String prefix) {
        RKeys rKeys = redisson.getKeys();
        return rKeys.getKeysByPattern((prefix + "*"), 1000);
    }

    /**
     * map放置到redis
     * @param key
     * @param map
     */
    public void hMSet(String key, Map<String, String> map) {
        Objects.requireNonNull(key, "Key cannot be null");
        Objects.requireNonNull(map, "Map cannot be null");
        RMap<String, String> rmap = redisson.getMap(key);
        rmap.putAll(map);
    }

    /**
     * 根据key 和 field 获取对应的值
     * key 不存在返回空map
     * field不存在返回的map里不包含field
     * @param key
     * @param field
     * @return
     */
    public Map<String, String> hMGet(String key, String ... field) {
        Set<String> items = new HashSet<>(Arrays.asList(field));
        RMap<String, String> map = redisson.getMap(key);
        return map.getAll(items);
    }

    public Map<String, String> hMGet(String key, List<String> list) {
        Set<String> items = new HashSet<>(list);
        RMap<String, String> map = redisson.getMap(key);
        return map.getAll(items);
    }

    /**
     * fastPut 方法用于将单个键值对添加到 RMap 中，你需要提供字段名和字段值
     * @param key
     * @param field
     * @param value
     * @return
     */
    public boolean hMSet(String key, String field, String value) {
        return redisson.getMap(key).fastPut(field, value);
    }

    /**
     *
     * @param key
     * @return
     */
    public Map<String, String> hMGetAll(String key) {
        RMap<String, String> map = redisson.getMap(key);
        return map;
    }

    /**
     * 使用 `fastPut` 方法设置字段值，如果字段不存在
     * 将field 进行put 则返回 true，否则不做元数据覆盖 返回 false
     * @param key
     * @param field
     * @param value
     * @return
     */
    public boolean hMSetnx(String key, String field, String value) {
        RMap<String, String> rMap = redisson.getMap(key);
        return rMap.fastPutIfAbsent(field, value);
    }

    /**
     * 根据 key field 获取value
     * @param key
     * @param field
     * @return
     */
    public String hGet(String key, String field) {
        RMap<String, String> map = redisson.getMap(key);
        return map.get(field);
    }

    /**
     * 列表头部插入元素
     * @param key
     * @param value
     */
    public void addFirst(String key, String value) {
        RList<String> rList = redisson.getList(key);// 获取 RList 实例
        rList.add(0, value);  // 在列表头部插入元素
    }

    public void addFirst(String key, String ... values){
        RList<String> rList = redisson.getList(key);// 获取 RList 实例
        rList.addAll(Arrays.asList(values));
    }

    /**
     * 将多个元素按顺序插入到列表的队头
     * @param key
     * @param list
     */
    public void addFirst(String key,  List<String> list) {
        RList<String> rList = redisson.getList(key);
        rList.addAll(0, list);
    }

    /**
     * 获取列表
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> lRange(String key, int start, int end){
        RList<String> redisList = redisson.getList(key);
        List<String> elementsInRange = redisList.range(start, end);
        return elementsInRange;
    }


    /**
     * 从队列尾部弹出元素
     * @param key
     * @return
     */
    public String rPop(String key) {
        RDeque<String> rDeque = redisson.getDeque(key);
        return rDeque.pollLast();
    }

    /**
     *  从队列头部弹出元素
     * @param key
     * @return
     */
    public String lPop(String key) {
        RQueue<String> rQueue = redisson.getQueue(key);
        return rQueue.poll();
    }

    /**
     *
     * @param key
     * @param index
     * @param value
     */
    public void lSet(String key, int index, String value) {
        RList<String> rList = redisson.getList(key);
        rList.set(index, value);// 使用 `set` 方法设置列表指定位置的元素
    }

    /**
     * 取指定索引位置的元素
     * @param key
     * @param index
     * @return
     */
    public String getElementAtIndex(String key, int index) {
        RList<String> rList = redisson.getList(key);
        return rList.get(index);
    }

    public List<String> getElementsInRange(String key, int start, int end) {
        RList<String> rList = redisson.getList(key);
        return rList.range(start, end);
    }

    /**
     *  向List的右侧添加元素
     * @param key
     * @param value
     */
    public void addLast(String key, String value) {
        RList<String> rList = redisson.getList(key);
        rList.add(value);
    }

    /**
     * 向List的右侧添加元素
     * @param key
     * @param values
     */
    public void addLast(String key, String... values) {
        RList<String> rList = redisson.getList(key);
        rList.addAll(Arrays.asList(values));
    }

    /**
     * 向List的右侧添加元素
     * @param key
     * @param list
     */
    public void addLast(String key, List<String> list) {
        RList<String> rList = redisson.getList(key);
        rList.addAll(list);
    }


    /**
     * 使用 `readAll` 方法获取集合中的所有成员
     * @param key
     * @return
     */
    public Set<String> sMembers(String key) {
        RSet<String> rSet = redisson.getSet(key);
        Set<String> set = rSet.readAll();
        return set;
    }

    /**
     * 使用 `remove` 方法从集合中移除一个或多个成员
     * @param key
     * @param values
     * @return
     */
    public boolean sRem(String key, String... values) {
        if(values.length == 0)
            return false;
        RSet<String> rSet = redisson.getSet(key);
        return rSet.removeAll(Arrays.asList(values));
    }

    public boolean sRem(String key, String field) {
        if(Objects.isNull(field))
            return false;
        RSet<String> rSet = redisson.getSet(key);
        return rSet.remove(field);
    }

    /**
     * 使用 `contains` 方法判断集合中是否包含某个成员
     * @param key
     * @param member
     * @return
     */
    public boolean sIsMember(String key, String member) {
        RSet<String> rSet = redisson.getSet(key);
        return rSet.contains(member);
    }

    /**
     * 使用 `add` 方法向集合中添加一个或多个成员
     * @param key
     * @param values
     * @return
     */
    public boolean sAdd(String key, String... values) {
        RSet<String> rSet = redisson.getSet(key);
        return rSet.addAll(Arrays.asList(values));
    }

    /**
     *使用 `addAll` 方法将集合中的所有元素添加到指定的集合中
     * @param key
     * @param list
     * @return
     */
    public boolean sAdd(String key, List<String> list) {
        RSet<String> rSet = redisson.getSet(key);
        return rSet.addAll(list);
    }

    /**
     * 使用 `size` 方法获取集合的基数
     * @param key
     * @return
     */
    public int setSize(String key) {
        RSet<String> rSet = redisson.getSet(key);
        return rSet.size();
    }


    public long incrBy(String key, long incValue) {
        RAtomicLong atomicLong = redisson.getAtomicLong(key);
        return atomicLong.addAndGet(incValue);
    }

    public long incr(String key) {
        RAtomicLong atomicLong = redisson.getAtomicLong(key);
        return atomicLong.incrementAndGet();
    }

    public long decr(String key) {
        RAtomicLong atomicLong = redisson.getAtomicLong(key);
        return atomicLong.decrementAndGet();
    }
    public long decrBy(String key, long decrValue) {
        RAtomicLong atomicLong = redisson.getAtomicLong(key);
        return atomicLong.addAndGet(-decrValue);
    }


    /**
     * expire 方法用于设置 key 的过期时间
     * @param key
     * @param expire
     */
    public void setExpireTime(String key, long expire, TimeUnit unit) {
        redisson.getBucket(key).expire(expire, unit);
    }



    public void shutDown() {
        try {
            if(!Objects.isNull(redisson))
                redisson.shutdown();
        } catch (Exception e) {

        }
    }
}
