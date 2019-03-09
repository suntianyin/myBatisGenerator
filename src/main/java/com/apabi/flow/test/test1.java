package com.apabi.flow.test;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class test1 {
    public static void main(String[] args) throws DocumentException {
//        List<File> fileList = new ArrayList<>();
//        String path = "/Users/suntianyin/Downloads/PDFceshi2";
//        List<File> files = getFiles(fileList, path);
//        List<String> filesName=files.stream().map(itme->itme.getName()).collect(Collectors.toList());
//        List<File> fileList2 = new ArrayList<>();
//        //xml目录
//        List<File> files2 = getFiles(fileList2, "/Users/suntianyin/Downloads/201902011136");
//        List<String> filesName2=files2.stream().map(itme->itme.getName()).collect(Collectors.toList());
//        String s="978-7-5162-1673-6.pdf".replace(".pdf",".xml");
//        boolean a1=filesName2.contains(s);
//        List<File> files3=files.stream().filter(item->!filesName2.contains(item.getName().replace(".pdf",".xml"))).collect(Collectors.toList());
//        int a=0;

        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read(new File("/Users/suntianyin/Downloads/978-7-5162-1538-8.xml"));
        Element root = doc.getRootElement();
        //判断exe生成xml是否成功
        if (root.attributeValue("Code").equals("0")) {
            List<Element> childElements = root.elements();
            Element element = childElements.get(0);
            String textTrim = element.getTextTrim();
            textTrim=ToDBC(textTrim);
            textTrim=replaceBlank(textTrim);
            int i = textTrim.indexOf("图书在版编目");
            String ciptext = textTrim.substring(i + 13);
            String[] split = ciptext.split("/", 2);
            if(split.length!=2){
                split = ciptext.split("∕", 2);
            }
            if(split.length!=2){
                split = ciptext.split("⁄", 2);
            }
            String title = replaceBlank(split[0]);
            String[] split1 = split[1].split("[.]", 2);
            String author = replaceBlank(split1[0]);
            String[] split2 = split1[1].split(":", 2);
            if(split2.length!=2){
                split2 = split1[1].split("〯", 2);
            }
            if(split2.length!=2){
                split2 = split1[1].split("﹕", 2);
            }
            String[] split3 = split2[1].split(",", 2);
            if(split3.length!=2){
                split3 = split2[1].split("﹐", 2);
            }
            String publisherTitle = replaceBlank(split3[0]);
            String[] split4 = split3[1].split("ISBN", 2);
            String str=split4[0];
            str=str.replace((char) 108, '1');
            str=str.replace((char) 79, '0');
            if(str.length()<=6){
                str = str.substring(0,6);
            }else{
                char c = str.charAt(6);
                boolean b = StringUtils.isNumeric(String.valueOf(c));
                if(b){
                    str = str.substring(0,7);
                }else {
                    str = str.substring(0,6);
                }
            }
            String publishTime = replaceBlank(str);
            String[] split5 = split4[1].split("[.]", 2);
            String isbn = replaceBlank(split5[0].substring(0,split5[0].length()-1));
            isbn=isbn.replace((char) 108, '1');
            isbn=isbn.replace((char) 79, '0');
            isbn=isbn.replace((char)19968,' ');
            isbn=isbn.replace((char)45,' ');
            isbn=getNumber(isbn);
            if (!IsbnCheck.CheckISBN(isbn)) {
                isbn = "";
            }
        }
    }

    public static String author(String author) {
        if (author.endsWith("主编") || author.endsWith("汇编") || author.endsWith("选编")) {
            author = author.substring(0, author.length() - 2);
        }
        if (author.endsWith("编") || author.endsWith("著")) {
            author = author.substring(0, author.length() - 1);
        }
        return author;
    }

    public static String putong(int i) {
        if (i < 10) {
            return "000" + i;
        } else if (i >= 10 && i <= 99) {
            return "00" + i;
        } else if (i >= 100 && i <= 999) {
            return "0" + i;
        } else
            return String.valueOf(i);
    }

    // 半角转全角
    public static String ToSBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = '\u3000';
            } else if (c[i] < '\177') {
                c[i] = (char) (c[i] + 65248);

            }
        }
        return new String(c);
    }

    //全角转半角
    public static String ToDBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\u3000') {
                c[i] = ' ';
            } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
                c[i] = (char) (c[i] - 65248);
            }
        }
        String returnString = new String(c);
        return returnString;
    }

    public static String replaceBlank(String str) {
        String dest = "";
        str = str.replace((char) 12288, ' ').trim();
        str = str.replace((char) 65104, ',');
        str = str.replace('﹕', ':');
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }


    //递归获取里面的文件 排除隐藏文件
    private static List<File> getFiles(List<File> fileList, String path) {
        File[] allFiles = new File(path).listFiles();
        for (int i = 0; i < allFiles.length; i++) {
            File file = allFiles[i];
            if (file.isHidden()) {
            } else if (file.isFile()) {
                fileList.add(file);
            } else {
                getFiles(fileList, file.getAbsolutePath());
            }
        }
        return fileList;
    }
    //保留数字
    private static String getNumber( String a) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(a);
        return m.replaceAll("").trim();
    }
}
