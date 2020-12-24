//package cache.core;
//
//import cache.api.ICacheEvict;
//
///**
// * Cache Api 引导类
// * 1. 提供流式Api
// * 2. 建造者模
// *
// * @param <K>
// * @param <V>
// */
//public class CacheBs<K, V> {
//    private CacheBs() {
//    }
//
//    public static <K, V> CacheBs<K, V> newInstance() {
//        return new CacheBs<>();
//    }
//
//    private int size = Integer.MAX_VALUE;
//
//    private ICacheEvict<K, V> evict() {
//
//    }
//
//    public CacheBs<K, V> size(int size) {
//        this.size = size;
//    }
//
//    public CacheBs<K, V> build() {
//        Cache<K, V> cache = new Cache<>();
//        cache.map(map);
//        cache.evict(evict);
//        cache.sizeLimit(size);
//        cache.removeListeners(removeListeners);
//        cache.load(load);
//        cache.persist(persist);
//        cache.slowListeners(slowListeners);
//
//        cache.init();
//        return CacheProxy.getProxy(cache);
//    }
//}
