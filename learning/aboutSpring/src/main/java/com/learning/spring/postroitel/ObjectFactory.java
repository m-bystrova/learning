package com.learning.spring.postroitel;

import lombok.SneakyThrows;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {

    private final ApplicationContext context;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
        this.context = context;
        //скаринурем пакет, чтобы найти все конфигураторы
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {
        T t = create(implClass); //тут вызывается конст-ор

        configure(t);//даем возможность настроить объект. тк настраивается 1 раз, то норм, что все будут

        invokeMethod(implClass, t); //фабрика дергает конст-ор

        return t; //возр-ет донастроенный объект
    }

    private <T> void invokeMethod(Class<T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        for (Method method : implClass.getMethods()) {
            if(method.isAnnotationPresent(PostConstruct.class)){
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        configurators.forEach(objectConfigurator -> objectConfigurator.configure(t, context));
    }

    private <T> T create(Class<T> implClass)
        throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
        return implClass.getDeclaredConstructor().newInstance();
    }
}
