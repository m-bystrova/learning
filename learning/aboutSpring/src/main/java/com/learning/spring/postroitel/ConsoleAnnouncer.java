package com.learning.spring.postroitel;

public class ConsoleAnnouncer implements Announcer{
    @Override
    public void announce(String msg) {
        System.out.println(msg);
    }
}
