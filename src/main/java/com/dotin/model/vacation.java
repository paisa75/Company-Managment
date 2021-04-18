package com.dotin.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "column")
public class vacation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "state")
    private int state;

    @Column(name = "personId")
    private int personId;

    @Column(name = "from")
    private Date from;

    @Column(name = "to")
    private Date to;

    public vacation() {
    }

    public vacation(int state, int personId, Date from, Date to) {
        this.state = state;
        this.personId = personId;
        this.from = from;
        this.to = to;
    }
    public vacation(int id , int state, int personId, Date from, Date to) {
        this.id = id;
        this.state = state;
        this.personId = personId;
        this.from = from;
        this.to = to;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
