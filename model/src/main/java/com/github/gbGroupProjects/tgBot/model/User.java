package com.github.gbGroupProjects.tgBot.model;

/*
    Категория User - телеграм-юзер
 */
public class User {
    private Integer userId;
    private Integer telegramUserId;
    private String userName;

    public Integer getUserId() {
        return userId;
    }
    public Integer getTelegramUserId() {
        return telegramUserId;
    }
    public String userName() {
        return userName;
    }

    public void setUserId(Integer id) {
        this.userId = id;
    }
    public void setTelegramUserId(Integer id) {
        this.telegramUserId = id;
    }
    public void setUserName(String name) {
        this.userName = name;
    }

    @Override
    public String toString() {
        return "Event Category{" +
                "IdUser=" + userId +
                "IdTelegram=" + telegramUserId +
                ", User Name='" + userName + '\'' +
                '}';
    }
}
