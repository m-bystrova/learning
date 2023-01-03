package com.learning.spring.borisovslectures.postroitel;

public interface ProxyConfigurator {
    Object replaceWithProxyIfNeeded(Object t, Class implClass);
}
