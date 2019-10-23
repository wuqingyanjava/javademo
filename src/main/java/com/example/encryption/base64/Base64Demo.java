package com.example.encryption.base64;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2019/10/23 13:59
 * Modify Log
 **/
@Slf4j
public class Base64Demo {
    // 字符串编码
    private static final String UTF_8 = "UTF-8";

    /**
     * 解密加密后的字符串
     * @param inputData
     * @return
     */
    public static String decodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.decodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            log.error(inputData, e);
            return null;
        }
    }
    /**
     * 加密字符串
     * @param inputData
     * @return
     */
    public static String encodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.encodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            log.error(inputData, e);
            return null;
        }
    }

    public static void main(String[] args) {
        String msg = "你好再见";
        String temp_msg = Base64Demo.encodeData(msg);
        System.out.println("加密后："+temp_msg);
        System.out.println("解密后："+Base64Demo.decodeData(temp_msg));

    }
}
