package com.learning.spring.postroitel;

public class ConsoleAnnouncer implements Announcer{

    private Recommendator recommendator = ObjectFactory.getInstance().createObject(Recommendator.class);

    @Override
    public void announce(String msg) {
        System.out.println(msg);
        recommendator.recommend();
    }
}
