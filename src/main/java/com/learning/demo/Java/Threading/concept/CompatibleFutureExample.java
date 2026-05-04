package com.learning.demo.Java.Threading.concept;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompatibleFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = CompletableFuture.
                supplyAsync(() -> "Run Task Seperately");
        System.out.println(cf.join()+ " "+cf);

        //Example second with chained without returing anything
        CompletableFuture cf1 = CompletableFuture.
                                        supplyAsync(() -> "Ayush").
                                        thenApply(name -> name + " Agnihotri").
                                        thenApply(petName-> petName+ " Shivam").
                                        thenAccept(System.out::println);

        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> result = f1.thenCombine(f2, (a, b) -> a + b);

        System.out.println(result.join()); // 30

        //Exception in CompatileFuture
        CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Error!");
            return 10;
        }).exceptionally(ex -> {
            System.out.println("Handled: " + ex.getMessage());
            return 0;
        });
     }
}
