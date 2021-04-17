package com.dotin.model;

import javax.persistence.*;

@Entity
@Table(name = "categorianElement")
public class CategorianElement {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "value")
    private String value;

    @Column(name="name")
    private String name;

    @Column(name = "dType")
    private String dType;

    public CategorianElement() {
    }

    public CategorianElement(String value, String name, String dType) {
        this.value = value;
        this.name = name;
        this.dType = dType;
    }

    public CategorianElement(int id , String value, String name, String dType) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.dType = dType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }
}
