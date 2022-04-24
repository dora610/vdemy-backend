package com.proect.vdemy.entities;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "description")
    private String desc;
    private Integer price;

    public Course() {
    }

    public Course(String title, String desc, Integer price) {
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                '}';
    }
}
