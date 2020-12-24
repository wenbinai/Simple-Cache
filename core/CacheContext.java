package cache.core;

import cache.api.ICacheContext;
import cache.api.ICacheEvict;

import java.util.Map;

public class CacheContext<K, V> implements ICacheContext<K, V> {
    /**
     * map 信息
     *
     * @since 0.0.2
     */
    private Map<K, V> map;

    /**
     * 大小限制
     *
     * @since 0.0.2
     */
    private int size;

    /**
     * 驱除策略
     *
     * @since 0.0.2
     */
    private ICacheEvict<K, V> cacheEvict;

    @Override
    public Map<K, V> map() {
        return map;
    }

    public CacheContext<K, V> map(Map<K, V> map) {
        this.map = map;
        return this;
    }

    @Override
    public int size() {
        return size;
    }

    public CacheContext<K, V> size(int size) {
        this.size = size;
        return this;
    }

    @Override
    public ICacheEvict<K, V> cacheEvict() {
        return cacheEvict;
    }

    public CacheContext<K, V> cacheEvict(ICacheEvict<K, V> cacheEvict) {
        this.cacheEvict = cacheEvict;
        return this;
    }

    @Override
    public String toString() {
        return "CacheContext{" +
                "map=" + map +
                ", size=" + size +
                ", cacheEvict=" + cacheEvict +
                '}';
    }
}
