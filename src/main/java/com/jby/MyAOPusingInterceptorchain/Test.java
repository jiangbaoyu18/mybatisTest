package com.jby.MyAOPusingInterceptorchain;

public class Test {

    public static void main(String[] args) {

        MyInterceptorChain myInterceptorChain = new MyInterceptorChain();

        MyInterceptor myInterceptor = new MyInterceptor();
        MyInterceptor2 myInterceptor2 = new MyInterceptor2();
        myInterceptorChain.addInterceptor(myInterceptor);
        myInterceptorChain.addInterceptor(myInterceptor2);

        Person person = new Student();
        Person p = (Person)myInterceptorChain.pluginAll(person);
        System.out.println(p.getName());


    }
}
