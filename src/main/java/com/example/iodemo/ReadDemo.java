package com.example.iodemo;

import java.io.*;

/**
 * @Description TODO
 * @Author wuqingyan
 * Date 2020/1/7 9:57
 * Modify Log
 **/
public class ReadDemo {

    public static void main(String[] args) {
        InputStreamDemo();
    }

    /** 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。 */
    public static void InputStreamDemo(){
        File f = new File("E:"+File.separator+"testupload"+File.separator+"text.txt");
        try {
            FileInputStream in = new FileInputStream(f);
            int b =0;
            while((b = in.read()) != -1){
                System.out.print((char)(b));
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /** 一次读取所有内容 */
    public static void InputStreanReaderDemo(){
        File f = new File("E:"+File.separator+"testupload"+File.separator+"text.txt");
        try {
            InputStreamReader sr = new InputStreamReader(new FileInputStream(f));
            int temp =0;
            while ((temp = sr.read()) != -1){
                System.out.println((char) temp);
            }
            sr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /** 以行为单位读取文件，常用于读面向行的格式化文件 */
    private static void BufferedReaderReadFile(String filepath)
    {
        try
        {
            File f = new File("E:"+File.separator+"testupload"+File.separator+"text.txt");

            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = br.readLine()) != null)
            {
                sb.append(readLine + "\n");
            }
            br.close();
            System.out.print(sb.toString());
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void FileInputStreamReadFile(String filepath)
    {
        try
        {
            File file = new File("E:"+File.separator+"testupload"+File.separator+"text.txt");
            FileInputStream fis = new FileInputStream(file);

            long filelength = file.length();
            byte[] bb = new byte[(int)filelength];

            fis.read(bb);
            fis.close();
            System.out.println(new String(bb));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
