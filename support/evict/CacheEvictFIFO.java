package cache.support.evict;

import cache.api.ICache;
import cache.api.ICacheEvict;
import cache.api.ICacheEvictContext;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 按照先进先出算法删除元素
 */
public class CacheEvictFIFO<K, V> implements ICacheEvict<K, V> {

    private Queue<K> queue = new LinkedList<>();

    @Override
    public void evict(ICacheEvictContext context) {
        ICache<K, V> cache = context.cache();
        if (cache.size() >= context.size()) {
            K evictKey = queue.remove();
            cache.remove(evictKey);
        }

        K key = (K) context.key();
        queue.add(key);
    }
}
