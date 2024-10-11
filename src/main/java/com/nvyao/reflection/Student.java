package com.nvyao.reflection;

public class Student {
    private String name;
    private Integer age;
    private String address;

    public Student(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void study(String subject) {
        System.out.println(this.name + "来自" + this.address + "，今年" +this.age+ "岁了！" + "他正在学习" + subject);
    }
}
