package com.learning.demo.Java.JavaSix;

import ch.qos.logback.core.encoder.JsonEscapeUtil;

class Parents{
    public static void staticMethod() {System.out.println("Static Method");}
    public void add(){System.out.println("Parent add method");}
}
class Child extends Parents{
    public static void staticMethod() {System.out.println("Static Method Child");}
    @Override
    public void add(){System.out.println("Child add method");}

}
public class StaticMethodVideo {
    public static void main(String[] args) {
        Parents c = new Child();
        c.staticMethod();
        c.add();
    }
}
