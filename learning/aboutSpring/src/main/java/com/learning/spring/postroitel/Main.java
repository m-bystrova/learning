package com.learning.spring.postroitel;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = Application.run("com.learning.spring.postroitel", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
        CoronaDesinfector desinfector = context.getObject(CoronaDesinfector.class);
        desinfector.start(new Room());
    }
}
