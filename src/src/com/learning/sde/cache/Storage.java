package com.learning.sde.cache;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, String> map;

    public Storage() {
        map = new HashMap<>();
    }

    public void add(String key, String value) {
        map.put(key, value);
    }

    public String get(String key) {
        return map.get(key);
    }

    public void delete(String key) {
        map.remove(key);
    }

    public int cacheSize() {
        return map.size();
    }
}
