package com.example.ureport.datasorce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/8/6 17:48
 * Modify Log
 **/
@Service
public class TestBuildinDataSource implements BuildinDatasource {

    @Autowired
    private DataSource dataSource;
    @Override
    public String name() {
        return "测试内置数据源";
    }

    @Override
    public Connection getConnection() throws Exception{
        return dataSource.getConnection();
    }
}
