package com.learning.demo.Java.coding;

public class TwoSum {
    public static void main(String[] args) {
        int a [] = {2, 7 ,11, 15};
        int target  = 9;
        for( int i = 0 ; i < a.length; i++) {
            for( int j = i+1 ; j < a.length ; j++) {
                if( a[i] + a[j] == target) {
                    System.out.println("first Indices" +i+ "Second Indices"+ j);
                    break;
                }
            }
        }
    }
}
