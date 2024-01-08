package com.demo.dto;

import com.demo.model.NewsTypeEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class NewsDto {
    private int id;
    @NotBlank(message = "Không được bỏ trống")
    private String title;
    @NotBlank(message = "Không được bỏ trống")
    private String content;
    private String postDate;
    @NotBlank(message = "Không được bỏ trống")
    private String own;
    private NewsTypeEntity newsTypeEntity;

    public NewsDto(int id, String title, String content, String postDate, String own, NewsTypeEntity newsTypeEntity) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.postDate = postDate;
        this.own = own;
        this.newsTypeEntity = newsTypeEntity;
    }

    public NewsDto() {
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
