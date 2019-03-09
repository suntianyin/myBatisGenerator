package com.apabi.flow.ClassLoad;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name)
                    throws ClassNotFoundException {
                InputStream is=null;
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1)
                            + ".class";
                     is= getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
//        ClassLoaderTest myLoader=new ClassLoaderTest("aa","com.apabi.flow.ClassLoad.ClassLoaderTest");
        Class c = myLoader.loadClass("com.apabi.flow.ClassLoad.Test");
        Object obj = c.newInstance();
//        System.out.println(obj.getClass());
//        System.out.println(ClassLoaderTest.class);
//        System.out.println(obj instanceof ClassLoaderTest);

    }
}
