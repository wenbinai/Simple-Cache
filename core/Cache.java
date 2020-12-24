package cache.core;

import cache.api.ICache;
import cache.api.ICacheContext;
import cache.api.ICacheEvict;
import cache.exception.CacheRuntimeException;
import cache.support.evict.CacheEvictContext;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 缓存的定义
 * 1. 数据存储结构
 * <p>
 * 2. 数据过期策略
 * <p>
 * 3. 最大存储大小
 *
 * @param <K>
 * @param <V>
 */
public class Cache<K, V> implements ICache<K, V> {

    private Map<K, V> map;

    private ICacheEvict<K, V> cacheEvict;

    private int maxSize = Integer.MAX_VALUE;

    /**
     * Cache 被CacheContext包装
     *
     * @param context
     */
    public Cache(ICacheContext context) {
        this.map = context.map();
        this.cacheEvict = context.cacheEvict();
        this.maxSize = context.size();
    }

    /**
     * 设置步骤:
     *
     * @param key         键
     * @param timeInMills 多少秒
     */
    @Override
    public void expire(K key, long timeInMills) {
        throw new UnsupportedOperationException();
    }

    /**
     * 每次put数据之前,
     * 先执行删除策略,
     * 在判断队列是否已满,
     * 已满, 就抛出异常
     * 否则, 添加数据
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key, V value) {
        CacheEvictContext<K, V> context = new CacheEvictContext<>();
        context.key(key)
                .size(maxSize)
                .cache(this);
        cacheEvict.evict(context);

        if (this.size() > maxSize) {
            throw new CacheRuntimeException("当前队列已满, 添加数据失败");
        }
        return map.put(key, value);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }


    @Override
    public V remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }
}
