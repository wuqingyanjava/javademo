package com.example.annotation;

import java.lang.reflect.Field;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/9/26 14:30
 * Modify Log
 **/
public class CompanyTargetUtil {

    public static void getCompany(Company company){
        //Company companyInfo = new Company();
        Field[] fields = company.getClass().getDeclaredFields();
        for(Field field:fields){
            if(field.isAnnotationPresent(CompanyTarget.class)){
                CompanyTarget companyTarget = field.getAnnotation(CompanyTarget.class);
                System.out.println(field.getName());
                if(field.getName().equals("name")){
                    company.setName(companyTarget.name());
                }else if(field.getName().equals("age")){
                    company.setAge(companyTarget.age());
                }else if(field.getName().equals("address")){
                    company.setAddress(companyTarget.address());
                }
            }

        }
    }

    public static void main(String[] args) {
        Company company = new Company();
        getCompany(company);
        System.out.println(company.toString());
    }
}


