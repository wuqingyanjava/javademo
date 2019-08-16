package com.example.ureport.bean;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestBean {
    public List<Map<String,Object>> loadReportData(String dsName, String datasetName, Map<String,Object> parameters){
        List<Map<String,Object>> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            Map<String,Object> objectMap = new HashMap<>();
            objectMap.put("id",i);
            objectMap.put("salary",i*100);
            list.add(objectMap);
        }
        return list;
    }
    public List<Map<String,Object>> buildReport(String dsName, String datasetName, Map<String,Object> parameters){
        List<Map<String,Object>> list = new ArrayList<>();
            Map<String,Object> objectMap = new HashMap<>();
            objectMap.put("code",123321);
            list.add(objectMap);
        return list;
    }
}