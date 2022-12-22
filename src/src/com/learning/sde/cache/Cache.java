package com.learning.sde.cache;

public class Cache {
    // EvictionPolicy and Storage classes ensure Single Responsibility.
    private EvictionPolicy evictionPolicy;
    private Storage storage;

    private int capacity;

    public Cache(int capacity) {
        this.evictionPolicy = new EvictionPolicy();
        this.storage = new Storage();
        this.capacity = capacity;
    }

    public void add(String key, String value) {
        if (storage.cacheSize() >= capacity) {
            String keyRemoved = evictionPolicy.evict();
            storage.delete(keyRemoved);
        }
        evictionPolicy.insert(key);
        storage.add(key, value);
    }

    public String get(String key) {
        String val = storage.get(key);
        if (key != null) {
            evictionPolicy.access(key);
        }
        System.out.println("Got value: " + val);
        return val;
    }
}
