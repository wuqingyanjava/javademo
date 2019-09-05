package com.example.jarsperreport.service;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.sf.jasperreports.engine.*;
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
import java.util.*;

@Slf4j
@Service
public class ReportService {

    @SneakyThrows
    private JasperReport loadTemplate(final String template) {
        val path = "/report" + template;
        log.info(String.format("Invoice templates path : %s" , path));

        //@Cleanup final InputStream reportInputStream = getClass().getResourceAsStream(templates);

        val resource = new DefaultResourceLoader().getResource(path);
        @Cleanup val s = resource.getInputStream();
        final JasperDesign jasperDesign = JRXmlLoader.load(s);
        return JasperCompileManager.compileReport(jasperDesign);
    }

    /**
     * 从指定的模板位置载入打印模板文件，并用map传递数据给报表，渲染为pdf报表
     *
     * @param path
     * @param parameters
     */
    public void response(String path, Map<String, Object> parameters, List<?> list) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequestt request = servletRequestAttributes.getRequest();
        val report = loadTemplate(path);
        val response = servletRequestAttributes.getResponse();

        OutputStream out = null;
        try {
            out = response.getOutputStream();
            JasperReportsUtils.renderAsPdf(report, parameters, new JRBeanCollectionDataSource(list), out);

        } catch (Exception e) {
            log.error("error at response " + path, e);

        } finally {
            IOUtils.closeQuietly(out);
        }
    }


    /**
     * 打印方法
     *
     * @param templateId 模板id
     * @param o          汇总实体类
     * @param list       表单明细集合
     */
//    public void print(String templateId, Object o, List<?> list) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        long begintime = System.currentTimeMillis();
//        JasperReport report = wmsReportService.getReportTemplateRedis(templateId);
//        long endtime = System.currentTimeMillis();
//        log.info("装载report消耗时间："+(endtime-begintime)/1000+"秒");
//        val response = HttpUtils.currentResponse();
//        Map<String, Object> parameters = object2Map(o);
//        parameters.put("printTime", dateFormat.format(new Date()));//打印时间
//        OutputStream out = null;
//        try {
//            out = response.getOutputStream();
//            long begintime1 = System.currentTimeMillis();
//            JasperReportsUtils.renderAsPdf(report, parameters, new JRBeanCollectionDataSource(list), out);
//            long endtime1 = System.currentTimeMillis();
//            log.info("渲染pdf消耗时间："+(endtime1-begintime1)/1000+"秒");
//        } catch (Exception e) {
//            log.error("error at response ", e);
//
//        } finally {
//            IOUtils.closeQuietly(out);
//        }
//    }
    //实体转map
//    public static Map<String, Object> object2Map(Object obj) {
//        Map<String, Object> map = new HashMap<>();
//        if (obj == null) {
//            return map;
//        }
//        Class clazz = obj.getClass();
//        Field[] fields = clazz.getDeclaredFields();
//        try {
//            for (Field field : fields) {
//                field.setAccessible(true);
//                map.put(field.getName(), field.get(obj));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return map;
//    }
}
