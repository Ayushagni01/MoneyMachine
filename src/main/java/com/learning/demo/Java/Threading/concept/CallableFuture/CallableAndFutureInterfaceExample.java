package com.learning.demo.Java.Threading.concept.CallableFuture;

import java.util.concurrent.*;


class CallableAndFuture implements Callable<Integer> {

    int n ;

    public CallableAndFuture(int number){
        this.n = number;
    }
    @Override
    public Integer call() throws Exception{
        Integer res = 1;
        for( int i  = 2; i <=n; i++) {
            res = res * i;
        }
        return res;
    }
}
public class CallableAndFutureInterfaceExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        ExecutorService service = Executors.newSingleThreadExecutor();
        CallableAndFuture obj = new CallableAndFuture(5);
        Future<Integer> fut = service.submit(obj);
        //Now get the result from the future
        Integer integer = fut.get();
        System.out.println(integer);
        service.shutdown();
    }
}
