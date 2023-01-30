package learning.spring.stepik.externaltask.threebeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BWoIface {

    private final List<I> iList;

    @Autowired
    public BWoIface(List<I> iList){
        this.iList = iList;
    }

    public List<I> getiList() {
        return iList;
    }
}
