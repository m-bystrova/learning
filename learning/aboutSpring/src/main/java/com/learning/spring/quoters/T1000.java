package com.learning.spring.quoters;

public class T1000 extends TerminatorQuoter implements Quoter {
    @Override
    public void sayQuote() {
        System.out.println("t1000");
    }
}
