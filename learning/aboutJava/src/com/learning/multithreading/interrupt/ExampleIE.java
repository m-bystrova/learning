package com.learning.multithreading.interrupt;

import static java.util.concurrent.TimeUnit.SECONDS;

class ChildThread extends Thread {
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
                System.out.println("\n" + e.getMessage());
                return;
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
            } catch (InterruptedException e) {
            }
            childThread.changeSign();
        }
        childThread.interrupt();
    }
}