package com.nvyao.pojo;

import java.time.LocalDateTime;
import java.util.Date;

public class Hero {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String kongfu;
    private Short gender;
    private String image;
    private Short level;
    private Date birthdate;
    private Integer sectId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKongfu() {
        return kongfu;
    }

    public void setKongfu(String kongfu) {
        this.kongfu = kongfu;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getSectId() {
        return sectId;
    }

    public void setSectId(Integer sectId) {
        this.sectId = sectId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", kongfu='" + kongfu + '\'' +
                ", gender=" + gender +
                ", image='" + image + '\'' +
                ", level=" + level +
                ", birthdate=" + birthdate +
                ", sectId=" + sectId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
