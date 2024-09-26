package com.github.gbGroupProjects.tgBot.model;
import java.time.LocalDate;

/*
    Само событие Event конкретного Юзера, конкретного некоего типа
 */
public class Event {
    private Integer userId;
    private Integer eventId;
    private LocalDate dateOfEvent;
    private Integer categoryId;

    private boolean regular;  // =0 разово, в дату с годом, или =1 регулярно.. (тогда год не нужен)
    private boolean active;    // F - Off

    private String commentToDo;

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer v) {
        this.userId = v;
    }

    public Integer getEventId() {
        return eventId;
    }
    public void setEventId(Integer val) {
        this.eventId = val;
    }

    public LocalDate getDateOfEvent() {
        return dateOfEvent;
    }
    public void setDateOfEvent(LocalDate d) {
        this.dateOfEvent = d;
    }

    public boolean getRegular() { return this.regular; }
    public void setRegular(boolean b) { this.regular = b;  }

    public boolean getOActive() { return this.active; }
    public void setOActive(boolean b) { this.active = b;  }

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
