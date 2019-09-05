package com.example.ureport.datasorce;

import java.sql.Connection;

public interface BuildinDatasource {
    /**
     * @return 返回数据源名称
     */
    String name();

    /**
     * @return 返回当前采用数据源的一个连接
     */
    Connection getConnection() throws Exception;
}