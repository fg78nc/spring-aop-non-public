package com.fg7.aopdemo;

import com.fg7.aopdemo.another.pkg.AnotherClass;
import com.fg7.aopdemo.another.pkg.YetAnotherClass;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
class MyAspect {

    @Before("execution(!public * com.fg7.aopdemo.another.pkg.AnotherClass.*(..))")
    public void myAdvice() {
        System.out.println("Non public in another package has been adviced");
    }
}

@SpringBootApplication
@EnableAspectJAutoProxy
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
    }

}
