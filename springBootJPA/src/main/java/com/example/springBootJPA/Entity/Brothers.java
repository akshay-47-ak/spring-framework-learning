package com.example.springBootJPA.Entity;

import jakarta.persistence.*;

@Entity
public class Brothers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    public Brothers() {
    }

    @OneToOne(mappedBy = "brothers",cascade =CascadeType.ALL)
    Family family;


    public Brothers(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
