package com.screening.solution.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="screen_category")
public class Category {

//     defining fields and mapping them to appropriate database columns
    @Id
    @Column(name="id")
    private int id;

     @Column(name="title")
    private String title;

    @Column(name="created_at")
    private Date created_at;
    @Column(name="updated_at")
    private Date updated_at;
    @Column(name="clues_count")
    private int clues_count;

//    defining constructors
    public Category(){

    }

    public Category(int id, String title, Date created_at, Date updated_at, int clues_count) {
        this.id = id;
        this.title = title;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.clues_count = clues_count;
    }



//    defining getters/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getcreated_at() {
        return created_at;
    }

    public void setcreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getupdated_at() {
        return updated_at;
    }

    public void setupdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getclues_count() {
        return clues_count;
    }

    public void setclues_count(int clues_count) {
        this.clues_count = clues_count;
    }

    //    defining toString() method


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", clues_count=" + clues_count +
                '}';
    }
}
