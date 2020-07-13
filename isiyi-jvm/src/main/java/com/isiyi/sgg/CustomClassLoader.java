package com.isiyi.sgg;

import java.io.FileNotFoundException;

/**
 * @ClassName CustomClassLoader
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/4/24 21:31
 * @Version 1.0
 */
public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

//        try {
//            byte[] clazzes = getClassFromCustomPath(name);
//            if(null == clazzes){
//                throw new FileNotFoundException();
//            }
//        }

        return super.findClass(name);
    }

    private byte[] getClassFromCustomPath(String path){

        return new byte[3];
    }
}
