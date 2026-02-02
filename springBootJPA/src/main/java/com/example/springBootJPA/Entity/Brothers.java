package com.example.springBootJPA.Entity;

import jakarta.persistence.*;

import java.util.List;

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

    @OneToMany(mappedBy = "brothers",cascade = CascadeType.ALL)
    List<Work> works;


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
