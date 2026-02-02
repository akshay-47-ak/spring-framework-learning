package com.example.springBootJPA.Entity;

import jakarta.persistence.*;

@Entity
public class Family {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
    @JoinColumn(name = "brothers_id")
    Brothers brothers;

}
