package com.jby.MyAOPusingInterceptorchain;

public class Student implements Person {

    public String getName() {
        System.out.println("service method calling ");
        return "student :jby";
    }
}
