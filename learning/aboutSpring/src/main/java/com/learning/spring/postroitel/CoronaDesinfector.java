package com.learning.spring.postroitel;

public class CoronaDesinfector {
    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);

    public void start(Room room){
        announcer.announce("will start");
        policeman.makePeopleLeaveRoom();
        desinfector(room);
        announcer.announce("can enter");
    }

    private void desinfector(Room room){
        System.out.println("todo");
    }
}
