package com.screening.solution.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;

@Entity
@Table(name="screen_question")
public class Question {
//    defining fields and mapping them to the appropriate database columns
    @Id
    @Column(name="id")
    private int id;
    @Column(name="answer")
    private String answer;
    @Column(name="question")
    private String question;
    @Column(name="value")
    private int value;
    @Column(name="airdate")
    private Date airdate;



    @Column(name="created_at")
    private Date created_at;



    @Column(name="updated_at")
    private Date updated_at;
    @Column(name="category_id")
    private int category_id;
    @Column(name="game_id")
    private int game_id;
    @Column(name="invalid_count")
    private Integer invalid_count;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="screen_category_id")
    private Category category;


//    defining constructors
public Question(){

}

    public Question(int id, String answer, String question, int value, Date airdate, Date created_at, Date updated_at, int category_id, int game_id, Integer invalid_count, Category category) {
        this.id = id;
        this.answer = answer;
        this.question = question;
        this.value = value;
        this.airdate = airdate;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.category_id = category_id;
        this.game_id = game_id;
        this.invalid_count = invalid_count;
        this.category = category;
    }


//    defining getter/setters

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getAirdate() {
        return airdate;
    }

    public void setAirdate(Date airdate) {
        this.airdate = airdate;
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

    public int getcategory_id() {
        return category_id;
    }

    public void setcategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getgame_id() {
        return game_id;
    }

    public void setgame_id(int game_id) {
        this.game_id = game_id;
    }

    public Integer getinvalid_count() {
        return invalid_count;
    }

    public void setinvalid_count(Integer invalid_count) {
        this.invalid_count = invalid_count;
    }

//    defining toString() method


    @Override
    public String  toString() {
        return "Question{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", question='" + question + '\'' +
                ", value=" + value +
                ", airdate=" + airdate +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", category_id=" + category_id +
                ", game_id=" + game_id +
                ", invalid_count=" + invalid_count +
                '}';
    }
}
