package com.dotin.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name ="personId")
    private long personId;

    @Column(name ="subject")
    private String subject;

    @Column(name ="message")
    private String message;

    @Column(name ="date")
    private Date date;

    @Column(name ="receiver")
    private String receiver;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
