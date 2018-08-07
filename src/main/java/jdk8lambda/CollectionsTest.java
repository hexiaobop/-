package jdk8lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

    public static void main(String[] args) {
        /**接口只有一个实现且实现方法无参数**/
        new Thread(() ->  System.out.println("Hello lambda!")).start();
        List<Student> list = Arrays.asList(new Student(12, "ming"),new Student(24, "qiang"));
        /**(排序)接口只有一个实现且方法有参数**/
        Collections.sort(list, (s1, s2) -> { return s2.getAge() - s1.getAge(); });
        list.forEach(name -> System.out.println(name.getAge()));
    }

    static class Student {

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
