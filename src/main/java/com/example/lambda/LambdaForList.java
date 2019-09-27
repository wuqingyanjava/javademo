package com.example.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/9/9 14:49
 * Modify Log
 **/
public class LambdaForList {

    public static void main(String[] args) {
        List<Fruit> appleList = new ArrayList<>();//存放apple对象集合
        Fruit apple1 =  new Fruit(1,"苹果",new BigDecimal("3.5"),10,"1111");
        Fruit apple2 =  new Fruit(2,"苹果",new BigDecimal("6.0"),5,"222");
        Fruit apple3 =  new Fruit(3,"香蕉",new BigDecimal("2.5"),10,"1111");
        Fruit apple4 =  new Fruit(4,"梨子",new BigDecimal("5.5"),10,"222");
        Fruit apple5 =  new Fruit(4,"西瓜",new BigDecimal("1.5"),10,"222");
        appleList.add(apple1);
        appleList.add(apple2);
        appleList.add(apple3);
        appleList.add(apple4);
        appleList.add(apple5);

        //根据list集合中某个字段进行分组
        Map<String, List<Fruit>> groupBy = appleList.stream().collect(Collectors.groupingBy(Fruit::getOwnerId));
        System.out.println(groupBy);

        /**
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key .... 解决办法见我的另一篇文章。。。
         *  apple1,apple12的id都为1。
         *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        Map<Integer, Fruit> appleMap = appleList.stream().collect(Collectors.toMap(Fruit::getId, a -> a,(k1,k2)->k1));
        System.out.println(appleMap);

        //过滤出符合条件的数据
        List<Fruit> filterList = appleList.stream().filter(a -> a.getName().equals("苹果")).collect(Collectors.toList());
        System.err.println("filterList:"+filterList);

    }

}
