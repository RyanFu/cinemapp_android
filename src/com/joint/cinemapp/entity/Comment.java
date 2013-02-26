package com.joint.cinemapp.entity;

import com.joint.cinemapp.R;

public class Comment {
	private int id;
	private String title;
	private String content;
	//private String posterUrl;
	private int posterUrl;
	private int runningTime;
	
	public Comment fakeData1() {
		Comment comment = new Comment(1, "", "", R.drawable.people1, 15);
		return comment;
	}
	
	public Comment fakeData2() {
		Comment comment = new Comment(1, "", "", R.drawable.people2, 15);
		return comment;
	}
	
	public Comment fakeData3() {
		Comment comment = new Comment(1, "", "", R.drawable.people3, 15);
		return comment;
	}
	
	public Comment() {
		this(-1, "", "", -1, -1);
	}
	
	public Comment (int id, String title, String content, int posterUrl, int runningTime) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.posterUrl = posterUrl;
		this.runningTime = runningTime;		
	}
	
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content = content;
	}
	public int getPosterUrl(){
		return posterUrl;
	}
	public void setPosterUrl(int posterUrl){
		this.posterUrl = posterUrl;
	}
	public int getRunningTime(){
		return runningTime;
	}
	public void setRunningTime(int runningTime){
		this.runningTime = runningTime;
	}
}
