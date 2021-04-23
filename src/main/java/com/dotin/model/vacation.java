package com.dotin.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "column")
public class vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "state")
    private Long state;

    @Column(name = "personId")
    private Long personId;

    @Column(name = "from")
    private Date from;

    @Column(name = "to")
    private Date to;

    public vacation() {
    }

    public vacation(Long state, Long personId, Date from, Date to) {
        this.state = state;
        this.personId = personId;
        this.from = from;
        this.to = to;
    }

    public vacation(Long id, Long state, Long personId, Date from, Date to) {
        this.id = id;
        this.state = state;
        this.personId = personId;
        this.from = from;
        this.to = to;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
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
