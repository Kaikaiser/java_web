package com.practice.springwebquick.pojo;

public class Emp {
    private Integer age;
    private String name;
    private String gender;

    public Emp(Integer age, String gender, String name) {
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    public Emp() {
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
