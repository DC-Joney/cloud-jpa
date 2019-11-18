package com.dc.rong.utils.cache;


import com.google.common.cache.CacheLoader;

import java.util.Map;

public class CompositeCacheLoader<K,V> extends CacheLoader<K,V> {

    private ComputeCacheLoader<K,V> cacheLoader;

    protected CompositeCacheLoader(ComputeCacheLoader<K,V> cacheLoader){
        this.cacheLoader = cacheLoader;
    }

    public static <K,V>  CompositeCacheLoader<K,V> fromCacheLoader(ComputeCacheLoader<K,V> cacheLoader){
        return new CompositeCacheLoader<>(cacheLoader);
    }

    @Override
    public V load(K key) throws Exception {
        return cacheLoader.loadCache(key);
    }

    @Override
    public Map<K, V> loadAll(Iterable<? extends K> keys) throws Exception {
        return super.loadAll(keys);
    }
}
