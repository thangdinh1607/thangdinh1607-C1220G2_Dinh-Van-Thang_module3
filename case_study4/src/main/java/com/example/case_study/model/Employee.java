package com.example.case_study.model;


import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String date;
    private String idCard;
    private Double salary;
    private String phone;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "educattionDegree_id",referencedColumnName = "id")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    private Division division;
    @ManyToOne
    @JoinColumn(name = "username",referencedColumnName = "user")
    private User user;

    public Employee() {
    }

    public Employee(String name, String date, String idCard, Double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division, User user) {
        this.name = name;
        this.date = date;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
