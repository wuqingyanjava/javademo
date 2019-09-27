package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) //作用在属性
@Retention(RetentionPolicy.RUNTIME)
public @interface CompanyTarget {

    public String name() default "默认公司";

    public int age() default 10;

    public String address() default  " " ;

}
