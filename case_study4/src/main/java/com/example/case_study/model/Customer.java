package com.example.case_study.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 5,message = "character >5")
    private String name;
    @NotEmpty(message = "input birthday")
    private String birthday;
    private boolean gender;
    @Pattern(regexp = "^\\d{9}$" ,message = "0-9")
    private String idCard;
    @Pattern(regexp = "^((090)|(091))\\d{7}",message = "090x-xxx-xxx")
    private String phone;
    @Email(message = "abc@abc.abc")
    private String email;
    @NotBlank(message = "not blank ne`")
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_type_id" ,referencedColumnName = "id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Contract> contracts;


    public Customer(String name, String birthday, boolean gender, String idCard, String phone, String email, String address, CustomerType customerType, List<Contract> contracts) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Customer() {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
