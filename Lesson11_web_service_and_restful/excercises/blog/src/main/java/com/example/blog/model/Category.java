package com.example.blog.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="categories")
public class Category {
    @Id
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Blog> blog;

    public Category() {
    }

    public Category(String name, List<Blog> blog) {
        this.name = name;
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlog() {
        return blog;
    }

    public void setBlog(List<Blog> blog) {
        this.blog = blog;
    }
}
