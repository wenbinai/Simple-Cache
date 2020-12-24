package cache.api;

public interface ICacheEvict<K, V> {
    /**
     * 缓存的删除策略
     *
     * @param context: 缓存的上下文
     */
    void evict(ICacheEvictContext<K, V> context);
}
