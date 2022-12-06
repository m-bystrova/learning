package com.learning.spring.postroitel;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> ifc);

}
