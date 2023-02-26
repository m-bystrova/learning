package learning.spring.stepik.externaltask.threebeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FreeList {

    private final List<Abracadabra> abracadabraList;

    @Autowired
    public FreeList(List<Abracadabra> abracadabraList) {
        this.abracadabraList = abracadabraList;
    }

    public List<Abracadabra> getAbracadabraList() {
        return abracadabraList;
    }
}
