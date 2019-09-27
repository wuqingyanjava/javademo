package com.example.annotation;

import lombok.Data;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/9/26 14:25
 * Modify Log
 **/
@Data
public class Company {

    @CompanyTarget(name="杰威尔公司")
    private String name;

    @CompanyTarget
    private int age;

    @CompanyTarget(address="台北中路18号")
    private String address;
}
