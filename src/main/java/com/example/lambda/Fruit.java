package com.example.lambda;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/9/9 14:47
 * Modify Log
 **/
@Data
public class Fruit {

    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;
    private String ownerId;
    public Fruit(Integer id, String name, BigDecimal money, Integer num, String ownerId) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
        this.ownerId = ownerId;
    }
}
