package com.test.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pigs")
public class PigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String code;
    @Column(nullable = false)
    private LocalDate inDate;
    @Column(nullable = true)
    private LocalDate outDate;
    @Column(nullable = false)
    private int inHeight;
    @Column(nullable = true)
    private Integer outHeight;
    @Column(nullable = false)
    private String origin;

    public PigEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getInDate() {
        return inDate;
    }

    public void setInDate(LocalDate inDate) {
        this.inDate = inDate;
    }

    public LocalDate getOutDate() {
        return outDate;
    }

    public void setOutDate(LocalDate outDate) {
        this.outDate = outDate;
    }

    public int getInHeight() {
        return inHeight;
    }

    public void setInHeight(int inHeight) {
        this.inHeight = inHeight;
    }

    public Integer getOutHeight() {
        return outHeight;
    }

    public void setOutHeight(Integer outHeight) {
        this.outHeight = outHeight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "PigEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", inDate=" + inDate +
                ", outDate=" + outDate +
                ", inHeight=" + inHeight +
                ", outHeight=" + outHeight +
                ", origin='" + origin + '\'' +
                '}';
    }
}
