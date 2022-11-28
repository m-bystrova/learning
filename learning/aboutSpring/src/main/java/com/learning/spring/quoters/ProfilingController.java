package com.learning.spring.quoters;

public class ProfilingController implements ProfilingControllerMBean{

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
