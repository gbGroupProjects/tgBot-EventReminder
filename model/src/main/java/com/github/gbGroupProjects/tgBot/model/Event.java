package com.github.gbGroupProjects.tgBot.model;
import java.time.LocalDate;

/*
    Само событие Event конкретного Юзера, конкретного некоего типа
 */
public class Event {
    private Integer userId;
    private Integer eventId;
    private LocalDate dateOfEvent;
    private boolean regular;  //  разово, в дату с годом, или регулярно.. (тогда год не нужен)
    private Integer categoryId;
    private String commentToDo;

    public Integer userId() {
        return userId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public boolean getRegular() {
        return regular;
    }

    public LocalDate getDateOfEvent() {
        return dateOfEvent;
    }
//    public void setDateOfEvent(LocalDate date) {
//        this.dateOfEvent = date;
//    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
