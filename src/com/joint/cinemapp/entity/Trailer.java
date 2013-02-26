package com.joint.cinemapp.entity;

public class Trailer {
	private int id;
	private String title;
	private String singer;
	private String youtubeId;
	private int runningTime;
	
	public Trailer() {
		this(-1, "", "", "", -1);
	}
	
	public Trailer (int id, String title, String singer, String youtubeId, int runningTime) {
		this.id = id;
		this.title = title;
		this.singer = singer;
		this.youtubeId = youtubeId;
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
	public String getSinger(){
		return singer;
	}
	public void setSinger(String singer){
		this.singer = singer;
	}
	public String getYoutubeId(){
		return youtubeId;
	}
	public void setYoutubeId(String youtubeId){
		this.youtubeId = youtubeId;
	}
	public int getRunningTime(){
		return runningTime;
	}
	public void setRunningTime(int runningTime){
		this.runningTime = runningTime;
	}
}
