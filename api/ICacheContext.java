package cache.api;

import java.util.Map;

/**
 * 缓存的上下文
 */
public interface ICacheContext<K, V> {
    Map<K, V> map();

    int size();

    ICacheEvict<K, V> cacheEvict();

}
