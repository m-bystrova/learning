package com.learning.spring.screenSaver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.awt.Color;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "com.learning.spring.screenSaver")
public class Config {

    @Bean
    @Scope(value = "periodical") //prototype - новый, singleton - старый
    public Color color(){
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFrame frame(){
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        while (true){
            applicationContext.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(150);
        }
    }
}
