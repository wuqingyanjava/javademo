package com.example.servicedemo.service;

import com.example.ureport.dao.UreportFileMapper;
import com.example.ureport.entity.UreportFileEntity;
import io.swagger.annotations.ApiOperation;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.ui.jasperreports.JasperReportsUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TestReportService {

    @Autowired
    private UreportFileMapper ureportFileMapper;

    /**
     * 打印方法
     *
     */
    public List<UreportFileEntity> print() {

        List<UreportFileEntity> list = ureportFileMapper.queryReportFileList();
        return list;
    }

}
