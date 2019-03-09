package com.apabi.flow.test1;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * http://bbs.csdn.net/topics/190181198
 * 从最后一行开始读取
 */
public class FromEndRF {
  
    /** 
     *  
     * @param filename 目标文件 
     * @param charset 目标文件的编码格式 
     */  
    public static void read(String filename, String charset) {  
  
        RandomAccessFile rf = null;
        try {  
            rf = new RandomAccessFile(filename, "r");  
            long len = rf.length();
            long start = rf.getFilePointer();
            long nextend = start + len - 1;  
            String line;  
            rf.seek(nextend);  
            int c = -1;
            int count=1;
            while (nextend > start) {  
                c = rf.read();  
                if (c == '\n' || c == '\r') {  
                    line = rf.readLine();  
                    if (line != null) {
                        count++;
                        System.out.println(new String(line  
                                .getBytes("ISO-8859-1"), charset));  
                    }
                    if(count==100)
                        return;
                    nextend--;  
                }  
                nextend--;  
                rf.seek(nextend);  
//                if (nextend == 0) {// 当文件指针退至文件开始处，输出第一行
                if (nextend == 0){
                    // System.out.println(rf.readLine());
                    System.out.println(new String(rf.readLine().getBytes(  
                            "ISO-8859-1"), charset));  
                }  
            }  
        } catch (FileNotFoundException e) {
            e.printStackTrace();  
        } catch (IOException e) {
            e.printStackTrace();  
        } finally {  
            try {  
                if (rf != null)  
                    rf.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    public static void main(String args[]) {
        read("/Users/suntianyin/Downloads/log-2019-01-28.log", "UTF-8");
    }  
}  
