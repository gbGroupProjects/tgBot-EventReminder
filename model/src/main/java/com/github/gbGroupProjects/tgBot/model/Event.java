package com.github.gbGroupProjects.tgBot.model;
import java.time.LocalDate;

/*
    Само событие Event конкретного Юзера, конкретного некоего типа
 */
public class Event {
    private Integer userId;
    private Integer eventId;
    private LocalDate dateOfEvent;
    private boolean regular;  // =0 разово, в дату с годом, или =1 регулярно.. (тогда год не нужен)
    private boolean OffOn;    // t - Off
    private Integer categoryId;
    private String commentToDo;

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEventId() {
        return eventId;
    }
    public void setEventId(Integer userId) {
        this.eventId = eventId;
    }

    public LocalDate getDateOfEvent() {
        return dateOfEvent;
    }
    public void setDateOfEvent(LocalDate dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public boolean getRegular() { return this.regular; }
    public void setRegular(boolean b) { this.regular = b;  }

    public boolean getOffOn() { return this.OffOn; }
    public void setOffOn(boolean b) { this.OffOn = b;  }

    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCommentToDo() {
        return commentToDo;
    }
    public void setCommentToDo(String str) {
        this.commentToDo = str;
    }

    @Override
    public String toString() {
        return "Event{" +
                "Id=" + eventId +
                ", dateOfEvent='" + dateOfEvent + '\'' +
                ", categoryId=" + categoryId +
                ", regular=" + regular +
                ", commentToDo=" + commentToDo +
                '}';
    }
}
