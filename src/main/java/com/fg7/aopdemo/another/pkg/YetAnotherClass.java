package com.fg7.aopdemo.another.pkg;

import org.springframework.beans.factory.annotation.Autowired;

public class YetAnotherClass {

    @Autowired
    AnotherClass anotherClass;

    public void go(){
        anotherClass.defaultAdvisedMethod();
        anotherClass.protectedAdvisedMethod();
    }
}
