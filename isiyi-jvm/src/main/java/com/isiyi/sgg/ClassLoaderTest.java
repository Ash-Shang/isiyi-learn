package com.isiyi.sgg;

/**
 * @ClassName ClassLoaderTest
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/4/24 21:08
 * @Version 1.0
 */
public class ClassLoaderTest {


    public static void main(String[] args) {

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);


        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);


        //系统的核心类库都是使用引导类加载的（bootstrap classload）
        System.out.println("****************");
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);
    }

}
