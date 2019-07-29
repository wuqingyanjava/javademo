package com.example.jarsperreport.service;


import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class ReportProperties {

    private Boolean cache;
    private String templateLoaderPath;

}
