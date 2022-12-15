package com.learning.spring.postroitel;

//@Singleton
public class RecommendatorImpl implements Recommendator {

    @InjectProperty("wisky")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("recommendator was created");
    }

    @Override
    public void recommend() {
        System.out.println("some adv-s " + alcohol);
    }
}
