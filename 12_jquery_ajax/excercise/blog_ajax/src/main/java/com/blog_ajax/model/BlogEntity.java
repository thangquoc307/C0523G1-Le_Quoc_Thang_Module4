package com.blog_ajax.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blogs")
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String owner;
    @Column(nullable = false)
    private Date releaseDate;
    @Column(nullable = false)
    private String title;

    public BlogEntity() {
    }

    public BlogEntity(Integer id, String content, String owner, Date releaseDate, String title) {
        this.id = id;
        this.content = content;
        this.owner = owner;
        this.releaseDate = releaseDate;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
