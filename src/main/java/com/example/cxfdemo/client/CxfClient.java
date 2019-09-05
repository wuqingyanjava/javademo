package com.example.cxfdemo.client;

import net.sf.json.JSONObject;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/5/17 11:09
 * Modify Log
 **/
public class CxfClient {
    public static void main(String[] args) {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://127.0.0.1:8090/cxf/service?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("sayJson" , "周杰伦");
            JSONObject json = JSONObject.fromObject(objects[0]);
            System.out.println("返回数据:" + json);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
