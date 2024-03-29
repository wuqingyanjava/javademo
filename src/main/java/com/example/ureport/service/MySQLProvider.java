package com.example.ureport.service;

import com.bstek.ureport.provider.report.ReportFile;
import com.bstek.ureport.provider.report.ReportProvider;
import com.example.ureport.dao.UreportFileMapper;
import com.example.ureport.entity.UreportFileEntity;
import lombok.Setter;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Mysql 报表存储
 *
 * @author qiaolin
 * @version 2018年5月9日
 */

@Setter
@Component
// 该注解可以利用其 prefix属性值 + 类的属性名 在yml中配置属性值
@ConfigurationProperties(prefix = "ureport.mysql.provider")
public class MySQLProvider implements ReportProvider {
    private static final String NAME = "mysql-存储";

    // 特定前缀，ureport底层会调用 getPrefix 方法来获取报表操作的Provier类
    private String prefix = "mysql:";

    // 是否禁用
    private boolean disabled;

    @Autowired
    private UreportFileMapper ureportFileMapper;

    //打开指定名称模板进行编辑
    @Override
    public InputStream loadReport(String file) {
        UreportFileEntity ureportFileEntity = ureportFileMapper.queryUreportFileEntityByName(getCorrectName(file));
        byte[] content = ureportFileEntity.getContent();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(content);
        return inputStream;
    }

    @Override
    public void deleteReport(String file) {
        ureportFileMapper.deleteReportFileByName(getCorrectName(file));
    }

    @Override
    public List<ReportFile> getReportFiles() {
        xmlToString();
        List<UreportFileEntity> list = ureportFileMapper.queryReportFileList();
        List<ReportFile> reportList = new ArrayList<>();
        for (UreportFileEntity ureportFileEntity : list) {
            reportList.add(new ReportFile(ureportFileEntity.getName(), ureportFileEntity.getUpdateTime()));
        }
        return reportList;
    }

    //保存模板
    @Override
    public void saveReport(String file, String content) {
        file = getCorrectName(file);
        UreportFileEntity ureportFileEntity = ureportFileMapper.queryUreportFileEntityByName(file);
        Date currentDate = new Date();
        if (ureportFileEntity == null) {
            ureportFileEntity = new UreportFileEntity();
            ureportFileEntity.setName(file);
            ureportFileEntity.setContent(content.getBytes());
            ureportFileEntity.setCreateTime(currentDate);
            ureportFileEntity.setUpdateTime(currentDate);
            ureportFileMapper.insertReportFile(ureportFileEntity);
        } else {
            ureportFileEntity.setContent(content.getBytes());
            ureportFileEntity.setUpdateTime(currentDate);
            ureportFileMapper.updateReportFile(ureportFileEntity);
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean disabled() {
        return disabled;
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    /**
     * 获取没有前缀的文件名
     *
     * @param name
     * @return
     */
    private String getCorrectName(String name) {
        if (name.startsWith(prefix)) {
            name = name.substring(prefix.length());
        }
        return name;
    }

//	public String xmlToString(){
//		SAXReader saxReader=new SAXReader();
//		Document document;
//		String xmlString="";
//		try {
//			InputStream in = ClassLoader.getSystemResourceAsStream("template.xml");
//			document = saxReader.read(in);
//			xmlString=document.asXML();//将xml内容转化为字符串
//		} catch (Exception e) {
//			e.printStackTrace();
//			xmlString="";
//		}
//		return xmlString;
//	}

    public String xmlToString() {
        String xmlString = "";
        try {
            StringBuffer content = new StringBuffer();
            InputStream stream = getClass().getClassLoader().getResourceAsStream("template.xml");
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            String s = "";
            while ((s = br.readLine()) != null) {
                xmlString = xmlString + s;
            }
            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return xmlString;
    }
}
