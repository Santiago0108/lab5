package com.xv.consumeapi;
public class User {
 private Integer UserId;
 private Integer Id;
 private String Title;
 private boolean Completed;

public Integer getUserId() {
	return UserId;
}
public void setUserId(Integer userId) {
	UserId = userId;
}
public Integer getId() {
	return Id;
}
public void setId(Integer id) {
	Id = id;
}
public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}
public boolean isCompleted() {
	return Completed;
}
public void setCompleted(boolean completed) {
	Completed = completed;
}

 
 
}