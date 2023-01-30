package learning.spring.stepik.externaltask.threebeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AWoIface {

    private final Map<String, I> iMap;

    @Autowired
    public AWoIface(Map<String, I> iMap){
        this.iMap = iMap;
    }

    public Map<String, I> getiMap() {
        return iMap;
    }
}
