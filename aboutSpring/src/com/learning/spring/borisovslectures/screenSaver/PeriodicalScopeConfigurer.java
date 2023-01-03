package com.learning.spring.borisovslectures.screenSaver;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalTime;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;

public class PeriodicalScopeConfigurer implements Scope {

    Map<String, SimpleEntry<LocalTime, Object>> map = new HashMap<>();

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        if (map.containsKey(s)) {
            SimpleEntry<LocalTime, Object> pair = map.get(s);
            int seconds = LocalTime.now().getSecond() - pair.getKey().getSecond();
            if (seconds > 3) {
                map.put(s, new SimpleEntry(LocalTime.now(), objectFactory.getObject()));
            }
        } else {
            map.put(s, new SimpleEntry(LocalTime.now(), objectFactory.getObject()));
        }
        return map.get(s).getValue();
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
