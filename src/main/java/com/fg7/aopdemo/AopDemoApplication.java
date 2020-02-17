package com.fg7.aopdemo;

import com.fg7.aopdemo.another.pkg.AnotherClass;
import com.fg7.aopdemo.another.pkg.YetAnotherClass;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@Aspect
@Component
class MyAspect {

    @Before("execution(!public * com.fg7.aopdemo.another.pkg.AnotherClass.*(..))")
    public void myAdvice(JoinPoint joinPoint) {
        System.out.println(" -> Aspect intercepted call to" + joinPoint.getSignature().toLongString() + " method in " + joinPoint.getSignature().getDeclaringType());
    }
}

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class AopDemoApplication {

    @Bean
    AnotherClass anotherClass(){
        return new AnotherClass();
    }

    @Bean
    YetAnotherClass yetAnotherClass(){
        return new YetAnotherClass();
    }

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(AopDemoApplication.class, args);
        YetAnotherClass yac = ctx.getBean(YetAnotherClass.class);
        yac.go();
        ctx.close();
    }

}
