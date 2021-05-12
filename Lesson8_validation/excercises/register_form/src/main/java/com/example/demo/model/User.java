package com.example.demo.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 5,max = 45)
    private String firstName;
    @Size(min = 5,max = 45)
    private String lastName;
    @Pattern(regexp = "^0\\d{9,10}$")
    private String phoneNumber;
    @Min(18)
    private int age;
    @NotBlank
    @Column(columnDefinition = "date")
    private String birthDay;
    @Email
    @Pattern(regexp = "^\\w{5,20}@\\w{5,10}(.(\\w{1,5})){1,2}$")
    private String email;

    public User() {
    }

    public User(int id, @Size(min = 5, max = 45) String firstName, @Size(min = 5, max = 45) String lastName, @Pattern(regexp = "^0\\d{9,10}$") String phoneNumber, @Min(18) int age, String birthDay, @Email String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.birthDay = birthDay;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
