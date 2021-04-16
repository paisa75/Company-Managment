package com.dotin.model;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
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
    private Long role;

    @Column(name="managerId")
    private Long managerId;

    @Column(name="address")
    private String address;

    public Employee() {
    }

    public Employee(String name, String lastName, String email, String phone, Integer age, Long role, Long managerId, String address) {
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

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
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
