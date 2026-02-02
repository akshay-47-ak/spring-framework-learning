package com.example.springBootJPA.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    @ManyToOne
    @JoinColumn(name = "brothers_id")
    @JsonBackReference
    Brothers brothers;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "WorkTags",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    List<Tag> tags;

    private String position;

    public Work(List<Tag> tags, String position) {
        this.tags = tags;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Brothers getBrothers() {
        return brothers;
    }

    public void setBrothers(Brothers brothers) {
        this.brothers = brothers;
    }

    public Work() {
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

}
