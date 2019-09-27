package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/9/26 13:56
 * Modify Log
 **/
@Target({ElementType.TYPE}) //表是注解使用在类上；
@Retention(RetentionPolicy.RUNTIME) //表示注解在程序运行状态下还有效；
public @interface MyTarget {

}
