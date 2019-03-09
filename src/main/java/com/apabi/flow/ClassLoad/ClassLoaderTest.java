package com.apabi.flow.ClassLoad;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest extends ClassLoader {

    private String name;
    private String path;


    public ClassLoaderTest(String name, String path) {
        super();
        this.name = name;
        this.path = path;
    }
    public ClassLoaderTest(ClassLoader classLoader,String name, String path) {
        super(classLoader);
        this.name = name;
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
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
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}  
