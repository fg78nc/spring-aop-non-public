package com.fg7.aopdemo.another.pkg;

import org.springframework.aop.framework.AopContext;

public class AnotherClass {

    void defaultAdvisedMethod() {
        System.out.println("AnotherClass.defaultAdvisedMethod() has been called");
    }

    protected void protectedAdvisedMethod() {
        System.out.println("AnotherClass.protectedAdvisedMethod() is called");
        ((AnotherClass) (AopContext.currentProxy())).internalTargetCallOnItself();
    }

     void internalTargetCallOnItself(){
        System.out.println("Internal method on itself has been called");
    }
}
