package com.learning.spring.postroitel;

import javax.annotation.PostConstruct;

public class AngryPoliceman implements Policeman {

    @InjectByType
    private Recommendator recommendator;

    @PostConstruct //вторичный конст-ор
    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("angry policeman");
    }
}
