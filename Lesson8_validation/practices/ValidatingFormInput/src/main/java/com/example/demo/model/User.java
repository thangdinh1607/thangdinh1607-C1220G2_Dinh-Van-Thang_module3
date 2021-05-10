package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "khong duoc rong")
    @Size(min=2,max=30,message ="2<name<30" )
    private String name;
    @Min(value = 18 ,message = ">18")
    private int age;

    public User() {
    }

    public User(int id, @NotEmpty @Size(min = 2, max = 30) String name, @Min(18) int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(@NotEmpty @Size(min = 2, max = 30) String name, @Min(18) int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
