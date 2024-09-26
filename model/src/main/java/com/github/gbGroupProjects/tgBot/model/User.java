package com.github.gbGroupProjects.tgBot.model;

/*
    Категория User - телеграм-юзер
 */
public class User {
    private Integer Id;
    private Long telegramId;
    private String Name;

    public Integer getUserId() {
        return Id;
    }
    public Long getTelegramId() {
        return telegramId;
    }
    public Object getName() { return Name;  }

    public void setId(Integer id) {
        this.Id = id;
    }
    public void setTelegramId(Long id) {
        this.telegramId = id;
    }
    public void setName(String name) {
        this.Name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "IdUser=" + Id +
                "IdTelegram=" + telegramId +
                ", Name='" + Name + '\'' +
                '}';
    }


}
