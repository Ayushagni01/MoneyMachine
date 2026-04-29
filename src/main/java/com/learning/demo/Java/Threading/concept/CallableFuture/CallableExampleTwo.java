package com.learning.demo.Java.Threading.concept.CallableFuture;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

class CallableFuturePrintName implements Callable<String> {

    @Override
    public String call() throws InterruptedException, ExecutionException {
        return Thread.currentThread().getName();
    }
}
public class CallableExampleTwo {

    public static void main(String[] args) throws InterruptedException,ExecutionException{
        ExecutorService submit = Executors.newFixedThreadPool(5);
        //for storing the result
        List<Future<String>> futRes = new ArrayList<>();
        //Callable
        CallableFuturePrintName ct = new CallableFuturePrintName();
        for( int i = 0; i<= 9; i++) {
            Future<String> futTempResult = submit.submit(ct);
            futRes.add(futTempResult);
        }

        //Now Print the Result
        for(Future<String> s:futRes){
            System.out.println(s.get());
        }

        submit.shutdown();
    }

}
