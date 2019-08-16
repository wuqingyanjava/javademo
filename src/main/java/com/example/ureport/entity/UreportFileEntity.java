package com.example.ureport.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/8/2 10:02
 * Modify Log
 **/
@Data
public class UreportFileEntity {

    private Long id;
    private String name;
    private byte[] content;
    private Date createTime;
    private Date updateTime;

}


