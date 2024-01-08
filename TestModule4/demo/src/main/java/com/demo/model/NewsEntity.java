package com.demo.model;

import javax.persistence.*;

@Entity
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String postDate;
    private String own;
    @ManyToOne
    @JoinColumn(name = "typeId", referencedColumnName = "id")
    private NewsTypeEntity newsTypeEntity;

    public NewsEntity() {
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getOwn() {
        return own;
    }

    public void setOwn(String own) {
        this.own = own;
    }

    public NewsTypeEntity getNewsTypeEntity() {
        return newsTypeEntity;
    }

    public void setNewsTypeEntity(NewsTypeEntity newsTypeEntity) {
        this.newsTypeEntity = newsTypeEntity;
    }
}
