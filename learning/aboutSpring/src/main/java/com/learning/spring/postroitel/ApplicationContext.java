package com.learning.spring.postroitel;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private ObjectFactory factory;
    private Map<Class, Object> cache = new HashMap<>();

    public <T> T getObject(Class<T> type) {
        return null;
    }
}
