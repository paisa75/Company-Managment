package com.dotin.model;

import javax.persistence.*;

@Entity
@Table(name = "attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "emailId")
    private int emailId;

    @Column(name = "filAddress" )
    private String filAddress;

    public Attachment() {
    }

    public Attachment(int emailId, String filAddress) {
        this.emailId = emailId;
        this.filAddress = filAddress;
    }

    public Attachment(int id , int emailId, String filAddress) {
        this.id = id;
        this.emailId = emailId;
        this.filAddress = filAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }

    public String getFilAddress() {
        return filAddress;
    }

    public void setFilAddress(String filAddress) {
        this.filAddress = filAddress;
    }
}
