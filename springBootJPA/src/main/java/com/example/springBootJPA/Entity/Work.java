package com.example.springBootJPA.Entity;

import jakarta.persistence.*;

@Entity
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "brothers_id")
    Brothers brothers;

}
