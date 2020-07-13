package com.isiyi.compare;

/**
 * @author Ash-Shang
 */
public class ComparableTest {


    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("s1");
        s1.setAge(30);

        Student s2 = new Student();
        s2.setName("s2");
        s2.setAge(40);
        Student max = (Student) getMax(s1, s2);

        System.out.println(max.getName());
    }

    public static Comparable getMax(Comparable c1, Comparable c2){
        int i = c1.compareTo(c2);
        //i > 0 ==> c1 > c2
        if (i >= 0){
            return c1;
        }else {
            return c2;
        }
    }
}
