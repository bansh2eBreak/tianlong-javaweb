package com.nvyao.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflecDemo {
    public static void main(String[] args) throws Exception {
        // 1. 获取Student类的Class对象
        Class<?> studentClass = Class.forName("com.nvyao.reflection.Student"); // 替换成你的包名和类名

        // 2. 获取有参数构造方法
        Constructor<?> constructor = studentClass.getConstructor(String.class, Integer.class, String.class);

        // 3. 创建Student对象
        Object studentObject = constructor.newInstance("张三", 20, "北京");

        // 4. 获取study方法（有参数和无参数不同）
        Method studyMethod = studentClass.getMethod("study", String.class);
        studyMethod.setAccessible(true);

        // 5. 调用study方法
        studyMethod.invoke(studentObject, "Java");

        // 6. 反射读取Private私有属性
        Field usernameField = studentClass.getDeclaredField("name");
        Field ageField = studentClass.getDeclaredField("age");
        Field addressField = studentClass.getDeclaredField("address");

        usernameField.setAccessible(true);
        ageField.setAccessible(true);
        addressField.setAccessible(true);

        String usernameValue = (String) usernameField.get(studentObject);
        Integer ageValue = (Integer) ageField.get(studentObject);
        String addressValue = (String) addressField.get(studentObject);


        System.out.println("暴力反射读取私有属性：" + usernameValue + "|" + ageValue + "|" + addressValue);
    }
}
