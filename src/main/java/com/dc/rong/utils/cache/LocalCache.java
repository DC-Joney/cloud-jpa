package com.dc.rong.utils.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;

public class LocalCache<K extends Object,V extends Object> {

    private LoadingCache<K,V> cacheLoader;

    private LocalCache(){
        init();
    }

    private void init(){
        cacheLoader = (LoadingCache<K, V>) CacheBuilder
                .newBuilder()
                .maximumSize(1000)
                .build();
    }



    public void put(K key,V value){
        cacheLoader.put(key,value);
    }


    public void computeIfAbsent(){

    }

    public static <K,V> LocalCache<K,V> getShareInstance(){
        return LoadingCacheHolder.INSTANCE;
    }

    private static class LoadingCacheHolder{
        private static final LocalCache INSTANCE = new LocalCache();
    }

}
