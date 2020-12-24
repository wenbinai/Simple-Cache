package cache.api;

import java.util.Map;

public interface ICache<K, V> extends Map<K, V> {

    /**
     * 设置键的存活时间为多少秒
     *
     * @param key         键
     * @param timeInMills 多少秒
     */
    void expire(K key, long timeInMills);
}