package com.learning.spring.postroitel;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {

    private static ObjectFactory ourInstance = new ObjectFactory();
    private final ApplicationContext context;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
//        config = new JavaConfig("com.learning.spring.postroitel", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));

        this.context = context;
        //скаринурем пакет, чтобы найти все конфигураторы
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {
        T t = implClass.getDeclaredConstructor().newInstance();

        //даем возможность настроить объект. тк настраивается 1 раз, то норм, что все будут
        configurators.forEach(objectConfigurator -> objectConfigurator.configure(t, context));
        return t;
    }
}
