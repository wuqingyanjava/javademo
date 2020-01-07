package com.example.iodemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2020/1/7 9:50
 * Modify Log
 **/
public class OutputStreamDemo {

    public static void main(String[] args) {
        File f = new File("E:"+File.separator+"testupload"+File.separator+"text.txt");
        OutputStream out = null;
        try {
           out = new FileOutputStream(f);
            String str = "hello io";
            out.write(str.getBytes());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
