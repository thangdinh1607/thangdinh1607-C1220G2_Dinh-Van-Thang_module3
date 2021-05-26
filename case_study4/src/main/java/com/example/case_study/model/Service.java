package com.example.case_study.model;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 5,message = "character>5")
    private String name;
    @Min(value = 20 ,message = "> 20")
    @Max(value = 100 ,message = "> 20")
    private int area;
    @Min(value = 1)
    private double cost;
    @Min(value = 1 ,message = ">1")
    @Max(value = 20,message = "<20")
    private int maxPeople;
    @NotEmpty(message = "not empty ne`")
    private String standardRoom;
    @NotEmpty(message = "not empty ne`")
    private String Description;
    @Min(value = 20)
    @Max(value = 100)
    private double poolArea;
    @Min(1)
    private int numberOfFloor;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "id")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "id")
    private ServiceType serviceType;
    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Service(String name, int area, double cost, int maxPeople, String standardRoom, String description, double poolArea, int numberOfFloor, RentType rentType, ServiceType serviceType, List<Contract> contracts) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        Description = description;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.contracts = contracts;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Service() {
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
