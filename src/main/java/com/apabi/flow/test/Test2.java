package com.apabi.flow.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {
 
    /**
     * 测试类main方法 <br>
     * Author：BluesLee <br>
     * CreateDate：2008-9-23 <br>
     * Modifier：BluesLee <br>
     * ModifyDate：2008-9-23 <br>
     * Version:1.1<br>
     * All right reserved.<br>
     * 
     * @param args
     */
    public static void main(String[] args) {
        //"03/2-3 03小时3:3"
//        String a="2018-1";
//        Test2 test=new Test2();
//        try {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-ss");
//            System.out.println(simpleDateFormat.format(test.parseStringToDate(a)));
//        } catch (ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        DecimalFormat df=new DecimalFormat("0.00");
//        double format = (double) 11 / 21;
//       int cebxPage = Integer.parseInt(null);
//       int a=1;
//        String str="metaId锛歮.20181206-TJDX-KXSJ-0114,鎻掑叆鏁版嵁搴撹�楁椂4330ms";
//        try {
//            str=new String(str.getBytes("ISO-8859-1"), "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            File file=new File("/Users/suntianyin/Downloads/fetchPage.2019-02-02_01.log");
            Long filelength = file.length();
            byte[] filecontent=new byte[filelength.intValue()];
            FileInputStream in= null;
            in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
            String s=new String(filecontent, "UTF-8");
            String[] split = s.split("\n");
            if(split.length<3) {
                for (int i = split.length-1; i >=0 ; i--) {
                    stringBuffer2.append(split[i]).append("\n");
                }
            }else {
                for (int i = split.length-1; i >=split.length-3; i--) {
                    stringBuffer2.append(split[i]).append("\n");
                }
            }
            String s1=stringBuffer2.toString();
            System.out.println(s1);
            String property = System.getProperty("line.separator");
            System.out.println(property);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String s="2019-01-30 15:59:20.070 logback [pool-2-thread-16] INFO  c.a.f.b.fetchPage.FetchPageConsumer - 获取图书：m.20181206-HBGL-XRTO-1443,总页数136,第123页,请求接口耗时 1069ms, url = http://cebxol.apabi.com/command/htmlpage.ashx?ServiceType=htmlpage&objID=m.20181206-HBGL-XRTO-1443.ft.cebx.1&metaId=m.20181206-HBGL-XRTO-1443&OrgId=iyzhi&width=450&height=600&pageid=123&username=iyzhi&rights=1-0_00&time=2019-01-31+15%3A59%3A19&sign=09568E19750C1AB0A19E92B1B03A8FAF\n" +
                "2019-01-30 15:59:20.079 logback [pool-2-thread-20] INFO  c.a.f.b.fetchPage.FetchPageConsumer - 记录表pageCrawledTemp：m.20181211-HBGL-XRTO-0369 的第42页时超时或出现错误\n";
    }
    /**
     * 将未指定格式的日期字符串转化成java.util.Date类型日期对象 <br>
     * Author：BluesLee <br>
     * CreateDate：2008-9-25 <br>
     * Modifier：BluesLee <br>
     * ModifyDate：2008-9-25 <br>
     * Version:1.1<br>
     * All right reserved.<br>
     *
     * @param date,待转换的日期字符串
     * @return
     * @throws ParseException
     */
    public Date parseStringToDate(String date) throws ParseException{
        Date result=null;
        String parse=date;
        parse=parse.replaceFirst("^[0-9]{4}([^0-9])", "yyyy$1");
        parse=parse.replaceFirst("^[0-9]{2}([^0-9])", "yy$1");
        parse=parse.replaceFirst("([^0-9])[0-9]{1,2}([^0-9])", "$1MM$2");
        parse=parse.replaceFirst("([^0-9])[0-9]{1,2}( ?)", "$1dd$2");
        parse=parse.replaceFirst("( )[0-9]{1,2}([^0-9])", "$1HH$2");
        parse=parse.replaceFirst("([^0-9])[0-9]{1,2}([^0-9])", "$1mm$2");
        parse=parse.replaceFirst("([^0-9])[0-9]{1,2}([^0-9]?)", "$1ss$2");
         
        DateFormat format=new SimpleDateFormat(parse);
 
        result=format.parse(date);
         
        return result;
    }
}