package com.learning.spring.postroitel;

public class AngryPoliceman implements Policeman {

    @InjectByType
    private Recommendator recommendator;
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("angry policeman" + recommendator.getClass());
    }
}
