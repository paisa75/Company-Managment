package com.dotin.model;

import com.dotin.model.enums.CategoryElementType;

import javax.persistence.*;

@Entity
@Table(name = "categorianElement")
public class CategoryElement {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "value")
    private String value;

    @Column(name="name")
    private String name;

    @Column(name = "dType")
    private CategoryElementType dType;

    public CategoryElement() {
    }

    public CategoryElement(String value, String name, CategoryElementType dType) {
        this.value = value;
        this.name = name;
        this.dType = dType;
    }

    public CategoryElement(int id , String value, String name, CategoryElementType dType) {
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

    public CategoryElementType getdType() {
        return dType;
    }

    public void setdType(CategoryElementType dType) {
        this.dType = dType;
    }
}
