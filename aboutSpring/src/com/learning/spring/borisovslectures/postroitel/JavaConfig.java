package com.learning.spring.borisovslectures.postroitel;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config{

    @Getter
    private Reflections scanner;
    private Map<Class, Class> icf2ImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> icf2ImplClass){
        this.scanner = new Reflections(packageToScan);
        this.icf2ImplClass = icf2ImplClass;
    }
    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
       return icf2ImplClass.computeIfAbsent(ifc, aClass -> { //todo - ?
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if(classes.size() != 1){
                throw new RuntimeException(ifc + " has 0 or more than one impl, pls upd your config");
            }
            return classes.iterator().next();
        });
    }
}
