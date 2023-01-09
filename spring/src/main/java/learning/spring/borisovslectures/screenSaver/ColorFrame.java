package learning.spring.borisovslectures.screenSaver;

import org.springframework.stereotype.Component;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.Random;

@Component
public abstract class ColorFrame extends JFrame {

    public ColorFrame() throws HeadlessException {
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace(){
        Random random = new Random();
        setLocation(random.nextInt(1000), random.nextInt(500));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();
}
