package com.dotin.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employee")
public class Employee extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="lastName")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="age")
    private Integer age;

    @Column(name="role")
    private int role;

    @Column(name="managerId")
    private int managerId;

    @Column(name="address")
    private String address;

    public Employee() {
    }

    public Employee(String name, String lastName, String email, String phone, Integer age, int role, int managerId, String address) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.role = role;
        this.managerId = managerId;
        this.address = address;
    }
    public Employee(int id ,String name, String lastName, String email, String phone, Integer age, int role, int managerId, String address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.role = role;
        this.managerId = managerId;
        this.address = address;
    }

    public Employee(int id, boolean isActive, boolean isDisabled, int version, Date modification, String name, String lastName, String email, String phone, Integer age, int role, int managerId, String address) {
        super(id, isActive, isDisabled, version, modification);
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.role = role;
        this.managerId = managerId;
        this.address = address;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee[" +
                "id=" + id + ", name='" + name + ", lastName='" + lastName +
                ", email='" + email +
                ", phone='" + phone +
                ", age=" + age +
                ", role=" + role +
                ", managerId=" + managerId +
                ", address='" + address +
                ']';
    }
}
