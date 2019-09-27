package com.example.annotation;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/9/26 14:11
 * Modify Log
 **/
@MyTarget
public class TargetTest {

    public static void main(String[] args) {

        if(TargetTest.class.isAnnotationPresent(MyTarget.class)){ //判断一个类是否有某个注解
            System.out.println("有符合条件的注解 我要处理你");
        }
    }

}
