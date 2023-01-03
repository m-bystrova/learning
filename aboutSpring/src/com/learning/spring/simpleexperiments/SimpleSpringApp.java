package com.learning.spring.simpleexperiments;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SimpleSpringApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SimpleConfiguration.class);
        ctx.refresh();

        ctx.close();
    }

}
