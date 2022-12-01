package com.learning.spring.screenSaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.Random;

@Component
public class ColorFrame extends JFrame {

    @Autowired
    private Color color;

    public ColorFrame() throws HeadlessException {
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace(){
        Random random = new Random();
        setLocation(random.nextInt(1000), random.nextInt(500));
        getContentPane().setBackground(color);
        repaint();
    }
}
