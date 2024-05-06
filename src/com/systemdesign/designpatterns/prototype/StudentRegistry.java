package com.systemdesign.designpatterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {

    private final Map<String, Student> registry = new HashMap<>();

    public Student getPrototype(String key) {
        return registry.get(key);
    }

    public void register(String key, Student student) {
        this.registry.put(key, student);
    }
}
