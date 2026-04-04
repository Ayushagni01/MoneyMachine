package com.learning.demo.Java.JavaSix;

import java.util.ArrayList;
import java.util.List;

public class FinallyBlockQuestion {

    public static void main(String[] args) {
        List<Integer> res = test();
        res.forEach(System.out::println);
    }

    public static List<Integer> test(){
       List<Integer> res = new ArrayList<>();
        try{
            res.add(10);
            return res;
        }finally {
            res.add(20);
        }
    }
}
