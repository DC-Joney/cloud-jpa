package com.dc.rong.utils.cache;

@FunctionalInterface
public interface ComputeCacheLoader<K,V> {
    V loadCache(K key) throws Exception;
}
