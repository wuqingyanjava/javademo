package com.example.iodemo;

import java.io.*;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2020/1/7 11:38
 * Modify Log
 **/
public class ReadAndWriteDemo {

    public static void main(String[] args) throws Exception {
        method02();
    }

    //字符流适合读取文本 字符串
    public static void method01() throws Exception {
        File f = new File("E:"+File.separator+"testupload"+File.separator+"text.txt");

        FileReader fr = new FileReader(f);
        FileWriter fw = new FileWriter("E:"+File.separator+"testupload"+File.separator+"text1.txt");
        int ch;
        while (-1 != (ch = fr.read())) {
            System.out.print((char)ch);
            fw.write((char)ch);
            fw.flush();
        }
        fw.close();
        fr.close();
    }
    //读取视频 文件 图片
    public static void method02() throws Exception {
        File f = new File("E:"+File.separator+"testupload"+File.separator+"aa.pptx");

        InputStream fr = new FileInputStream(f);
        OutputStream out = new FileOutputStream("E:"+File.separator+"testupload"+File.separator+"bb.pptx");
        byte[] bytes = new byte[2048];
        int temp =0;
        //read 返回读入缓冲区的字节总数
        while ((temp = fr.read(bytes,0,bytes.length)) != -1){
            out.write(bytes,0,temp);
        }
        fr.close();
        out.close();
    }

}
