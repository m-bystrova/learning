package learning.spring.borisovslectures.postroitel;

@Deprecated
public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

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
