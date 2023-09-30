package com.blogresrful.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<BlogEntity> blogEntityList;

    public CategoryEntity(Integer id, String name, List<BlogEntity> blogEntityList) {
        this.id = id;
        this.name = name;
        this.blogEntityList = blogEntityList;
    }

    public CategoryEntity() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BlogEntity> getBlogEntityList() {
        return blogEntityList;
    }

    public void setBlogEntityList(List<BlogEntity> blogEntityList) {
        this.blogEntityList = blogEntityList;
    }
}
