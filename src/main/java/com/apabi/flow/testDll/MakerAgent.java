package com.apabi.flow.testDll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 闫进兵
 * @ClassName: MakerAgent
 * @Description: Apabi MakerSDK 封装调用
 * @date 2014-3-10 上午11:23:17
 */
public class MakerAgent {

    private static final Logger logger = LoggerFactory.getLogger(MakerAgent.class);

    public static int nLen = 0;
    public static byte[] retKey ;
    public static String strIniKey;

//    static {
//        String dll = ApplicationConfig.getCebxMaker() + "/Runtime/Bin/MakerAgent.dll";
//        System.load(dll);
//        run();
//    }

    public static void init() {
        String dll ="/Users/suntianyin/Downloads/加密/dll/GenContentKey.dll";
        System.load(dll);
        run();
    }
    //生成原始密钥
    public native static  int CreateContentKey(byte[] retKey,  int nLen);
    //生成加密密钥
    public native static  int EncryptContentKey(String lpszEncryptKey, String lpszTKey, byte[] pContentKey,  int nLen);
    //创建加密文件
    public native static  int CreateKeyFile(String strCopyrightName, String strCopyrightKey,
            ENCRYPTFILEDATA[] arrDatas, int nSize,
    byte[] pContent,  int nLen);
//    public native static  boolean CreateKeyFile(String strCopyrightName, ENCRYPTFILEDATA[] arrDatas, int nSize,  String pContent,  String strIniKey);

    public static void run() {
        int i = CreateContentKey(retKey, nLen);
        System.out.println(retKey);
//        ENCRYPTFILEDATA[] encryptfiledata=new ENCRYPTFILEDATA[1];
//        ENCRYPTFILEDATA encryptfiledata1 = new ENCRYPTFILEDATA();
//        encryptfiledata[1]=encryptfiledata1;
//        int b = CreateKeyFile("sun","", encryptfiledata, 1, pContent, nLen);

    }

    public static void main(String[] args) {

        MakerAgent.init();

    }
   static class ENCRYPTFILEINIDATA{
        private String ObjID;
        private String InitContentKey;
        private int ContentKeyType;

        public String getObjID() {
            return ObjID;
        }

        public void setObjID(String objID) {
            ObjID = objID;
        }

        public String getInitContentKey() {
            return InitContentKey;
        }

        public void setInitContentKey(String initContentKey) {
            InitContentKey = initContentKey;
        }

        public int getContentKeyType() {
            return ContentKeyType;
        }

        public void setContentKeyType(int contentKeyType) {
            ContentKeyType = contentKeyType;
        }
    }
    static class ENCRYPTFILEDATA{
        private String ContentKey;
        private String ContentKeyType;
        private String ObjID;
        private String FileFormat;
        private String SrcPath;
        private String DestPath;

        public String getContentKey() {
            return ContentKey;
        }

        public void setContentKey(String contentKey) {
            ContentKey = contentKey;
        }

        public String getContentKeyType() {
            return ContentKeyType;
        }

        public void setContentKeyType(String contentKeyType) {
            ContentKeyType = contentKeyType;
        }

        public String getObjID() {
            return ObjID;
        }

        public void setObjID(String objID) {
            ObjID = objID;
        }

        public String getFileFormat() {
            return FileFormat;
        }

        public void setFileFormat(String fileFormat) {
            FileFormat = fileFormat;
        }

        public String getSrcPath() {
            return SrcPath;
        }

        public void setSrcPath(String srcPath) {
            SrcPath = srcPath;
        }

        public String getDestPath() {
            return DestPath;
        }

        public void setDestPath(String destPath) {
            DestPath = destPath;
        }
    }
}
