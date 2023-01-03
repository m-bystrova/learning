package com.learning.spring.borisovslectures.postroitel;

public interface ObjectConfigurator {
    //только для настройки объкта, все равно откуда он появился
    void configure(Object t, ApplicationContext context);

}
