package com.example.rule_engine;

import java.util.HashMap;
import java.util.Map;

public class User {
    private Integer age;
    private Long salary;
    private Integer experience;
    private  String department;

    public User() {
    }

    public User(Integer age, Long salary, Integer experience, String department) {
        this.age = age;
        this.salary = salary;
        this.experience = experience;
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, Object> getUserMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("experience",experience);
        map.put("age",age);
        map.put("salary",salary);
        map.put("department", department);
        return map;
    }
}
