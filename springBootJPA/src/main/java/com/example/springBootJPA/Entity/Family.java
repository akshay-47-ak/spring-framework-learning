package com.example.springBootJPA.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Family {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
    @JoinColumn(name = "brothers_id")
    @JsonBackReference
    Brothers brothers;

    private String relationShip;

    public Family() {
    }

    public Brothers getBrothers() {
        return brothers;
    }

    public void setBrothers(Brothers brothers) {
        this.brothers = brothers;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public String getRelationShip() {
        return relationShip;
    }

    public void setRelationShip(String relationShip) {
        this.relationShip = relationShip;
    }

    public Family(String relationShip) {
        this.relationShip = relationShip;
    }
}
