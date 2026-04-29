package com.learning.demo.Java.eight;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Question {


    public static void checkAnyOfNumberIsPrimeOrNot(){
        List<Integer> list1 = Arrays.asList(4,6,8,9,15,16);
        boolean b = list1.stream().anyMatch(x -> isPrimeNumber(x));
        System.out.println(b);
    }

    private static boolean isPrimeNumber(int n ){

        //Replace below logic using java 8
        return IntStream.rangeClosed(2, n/2).noneMatch(x -> n%x==0);

//        for( int i = 2; i <= n/2; i++ ){
//            if(n%i == 0){
//                return false;
//            }
//        }
        //return true;
    }

    public static void mergeTwoListIntoSingleList(){
        List<Integer> list1 = Arrays.asList(1,5,6,4);
        List<Integer> list2 = Arrays.asList(2,3,1);
        List<Integer> res = Stream.concat(list1.stream(), list2.stream()).sorted().toList();
        res.forEach(System.out::println);
    }
    public static void concatTwoStream(){
        List<Integer> list1 = Arrays.asList(1,2,3,4);
        List<Integer> list2 = Arrays.asList(5,6);
        Stream<Integer> res = Stream.concat(list1.stream(), list2.stream());
        res.toList().forEach(System.out::println);
    }

    public static  void findAllNumberStartingWith1(){
        List<Integer> list = Arrays.asList(10, 21, 13, 41, 15, 2, 1, 100, 23);
        //Convert it into String and then call .startsWithMethod
        list.stream().filter(x -> String.valueOf(x).startsWith("1")).collect(Collectors.toList()).forEach(System.out::println);
    }


    public static  void removeDuplicateFromList(){
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        //Way 1: Use Distinct, which is a intermediate Operations.
        list.stream().distinct().forEach(System.out::println);
        //Way2: Convert it into set, collect & forEach is a terminal operation.
        //ByDefault toSet uses hashMap, if you want to print using linkedhashMap check below example
        list.stream().collect(Collectors.toSet()).forEach(System.out::println);
        //Any SetType
        list.stream().collect(Collectors.toCollection(LinkedHashSet::new)).forEach(System.out::println);
    }



    public static void main(String[] args) {
        Java8Question.checkAnyOfNumberIsPrimeOrNot();
    }
}
