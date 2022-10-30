package com.learning.sde.cache;

public class CacheClient {

    public static void main(String[] args) {
        Cache cache = new Cache(5);
        cache.add("1", "one");
        cache.add("2", "two");
        cache.add("3", "three");
        cache.add("4", "four");
        cache.add("5", "five");
        cache.add("6", "six");
        cache.add("7", "seven");
        cache.get("6");
        cache.get("4");

    }
}
