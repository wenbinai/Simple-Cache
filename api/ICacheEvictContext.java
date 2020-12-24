package cache.api;

/**
 * 执行过期的缓存上下文
 *
 * @param <K>
 * @param <V>
 */
public interface ICacheEvictContext<K, V> {
    K key();

    ICache<K, V> cache();

    int size();
}
