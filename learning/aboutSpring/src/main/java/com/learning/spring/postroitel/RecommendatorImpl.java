package com.learning.spring.postroitel;

public class RecommendatorImpl implements Recommendator {

    @InjectProperty("wisky")
    private String alcohol;

    @Override
    public void recommend() {
        System.out.println("some adv-s " + alcohol);
    }
}
