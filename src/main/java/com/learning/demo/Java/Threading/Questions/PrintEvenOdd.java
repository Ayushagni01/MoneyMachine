package com.learning.demo.Java.Threading.Questions;

class PrintAlternativeEvenOdd extends Thread {
    @Override
    public void run() {
        for(int i = 1; i <=10; i++){
            if( i %2 == 0 && currentThread().getName().equals("even")) {
                try {
                    printEven(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else if(i %2 !=0 && currentThread().getName().equals("odd")) {
                    printOdd(i);
            }
        }
    }

    public synchronized void printEven(int num) throws InterruptedException {
        System.out.println("Even"+ " "+num);
        wait();
    }

    public synchronized void printOdd(int num){
        System.out.println("Odd"+ "  "+num);
        notify();
    }
}
public class PrintEvenOdd {
    public static void main(String[] args) {
        PrintAlternativeEvenOdd p1 = new PrintAlternativeEvenOdd();
        PrintAlternativeEvenOdd p2 = new PrintAlternativeEvenOdd();
        p1.setName("even");
        p2.setName("odd");
        p1.start();
        p2.start();

    }
}
