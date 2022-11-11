package com.learning.multithreading.interrupt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

class ChildThread extends Thread {
    private static final Logger log = LoggerFactory.getLogger(ChildThread.class);
    private volatile boolean isIncrement = true;

    public void changeSign() {
        isIncrement = !isIncrement;
    }

    @Override
    public void run()
    {
        while (!Thread.interrupted()) {
            if (isIncrement) {
                ExampleIE.value++;
            } else {
                ExampleIE.value--;
            }
            System.out.print(ExampleIE.value + " ");

            try {
                SECONDS.sleep(6);
            } catch (InterruptedException e) {
                log.info("\n Thread is interrupted", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}

class ExampleIE {
    public static int value = 0;
    static ChildThread childThread;

    public static void main(String[] args)
    {
        childThread = new ChildThread();

        System.out.print("Value = ");

        childThread.start();

        for (int i = 1; i <= 3; i++) {
            try {
                SECONDS.sleep(i * 2);
            } catch (InterruptedException ignored) {
            }
            childThread.changeSign();
        }
        childThread.interrupt();
    }
}