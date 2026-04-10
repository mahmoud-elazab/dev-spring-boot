package com.melazab.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    // define fields

    // define constructors

    // define getter/setter

    // create toString

    // annotate fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public Course(){

    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public Course setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Course setTitle(String title) {
        this.title = title;
        return this;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Course setInstructor(Instructor instructor) {
        this.instructor = instructor;
        return this;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
