package com.github.gbGroupProjects.tgBot.model.dto;
/*

 */
public class UserDto {
    private String userName;
    int userId;
    int telegramUserId;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String Name) {
        this.userName = Name;
    }

    public int getUserid() {
        return userId;
    }
    public void setUserId(int id) {
        this.userId = id;
    }

    public int getTelegramUserid() {
        return telegramUserId;
    }
    public void setTelegramUserId(int id) {
        this.telegramUserId = id;
    }

    @Override
    public String toString() {
        return "TelegramUserDto{" +
                "Name='" + userName + '\'' +
                ", id=" + telegramUserId +
                '}';
    }
}

