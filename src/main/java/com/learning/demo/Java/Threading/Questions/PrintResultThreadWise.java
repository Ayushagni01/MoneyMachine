package com.learning.demo.Java.Threading.Questions;
class Printing extends Thread{

    @Override
    public void run() {

        for(int i = 1 ; i<=5; i++ ) {
            System.out.println(Thread.currentThread().getName()+ "-> "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}


public class PrintResultThreadWise {

    public static void main(String[] args) throws InterruptedException {
        Printing p1 = new Printing();
        Printing p2 = new Printing();
        p1.start();
        p1.join();
        p2.start();
        p2.join();
    }

}
