package com.learning.demo.Java.JavaSix;

import java.util.*;
public class ImmutableClass {

    private final String name;
    private final List<String> alist;

    public ImmutableClass(String name, List<String> alist) {
        this.name = name;
        this.alist = new ArrayList<>(alist);
    }


    public String getName() {
        return name;
    }

    public List<String> getAlist() {
        List<String> res = new ArrayList<>(alist);
        return res;
    }

    public static void main(String[] args) {
        String name = "Ayush";
        List<String> alist = new ArrayList<>();
        alist.add("Lucknow");
        ImmutableClass ic = new ImmutableClass(name, alist);
        System.out.println(ic);
        alist = ic.getAlist();
        alist.add("Banglore");
        System.out.println(ic);
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "name='" + name + '\'' +
                ", alist=" + alist +
                '}';
    }
}
