package com.company.svt.LSVdeveloper;

import java.util.Vector;

public class Main {
    private Vector data;

    public static void main(String[] args) {
        new Main().go();
    }

    private void go() {
        data = new Vector();
        new Thread(new RunnableNote()).start();
        new Thread(new RunnableRead()).start();
    }

    private int createSleep() {
        return (int) (Math.random() * 1600);
    }

    private class RunnableNote implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i<20; i++) {
                data.add(i);
                try {
                    Thread.sleep(createSleep());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class RunnableRead implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; ; i++) {
                    if (data.size()>i){
                    System.out.print(data.get(i)+" ");
                }else throw new RuntimeException();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}