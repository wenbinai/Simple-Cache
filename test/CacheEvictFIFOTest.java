package cache.test;

import cache.core.Cache;
import cache.core.CacheContext;
import cache.support.evict.CacheEvictFIFO;
import org.junit.Test;

import java.util.HashMap;

public class CacheEvictFIFOTest {
    @Test
    public void test_FIFO() {
        CacheContext<String, String> cacheContext = new CacheContext<String, String>()
                .map(new HashMap<>())
                .size(2)
                .cacheEvict(new CacheEvictFIFO<>());

        System.out.println(cacheContext.toString());

        Cache cache = new Cache(cacheContext);

        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.put("4", "4");


    }
}
