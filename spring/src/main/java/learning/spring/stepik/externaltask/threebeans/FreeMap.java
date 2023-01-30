package learning.spring.stepik.externaltask.threebeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FreeMap {

    private final Map<String, Abracadabra> abracadabraMap;

    @Autowired
    public FreeMap(Map<String, Abracadabra> abracadabraMap) {
        this.abracadabraMap = abracadabraMap;
    }

    public Map<String, Abracadabra> getAbracadabraMap() {
        return abracadabraMap;
    }
}
