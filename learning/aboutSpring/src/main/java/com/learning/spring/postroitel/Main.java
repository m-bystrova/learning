package com.learning.spring.postroitel;

public class Main {
    public static void main(String[] args) {
        CoronaDesinfector desinfector = ObjectFactory.getInstance().createObject(CoronaDesinfector.class);
        desinfector.start(new Room());
    }
}
