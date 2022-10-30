package com.learning.sde.cache;

import java.util.Deque;
import java.util.LinkedList;

public class EvictionPolicy {
    Deque<String> dll;

    public EvictionPolicy() {
        this.dll = new LinkedList<>();
    }

    public void insert(String key) {
        dll.addFirst(key);
    }

    public void access(String key) {
        dll.remove(key);
        insert(key);
    }

    public String evict() {
        return dll.removeLast();
    }

}
