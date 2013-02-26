package com.joint.cinemapp.entity;

import com.joint.cinemapp.R;

public class Trailer {
	private int id;
	private String title;
	//private String posterUrl;
	private int posterUrl;
	private String youtubeId;
	private int runningTime;
	
	public Trailer fakeData() {
		Trailer trailer = new Trailer(1, "1/18《漂流古巴》柏林影展 新世代單元", R.drawable.trailer_girl_1, "", 60);
		return trailer;
	}
	
	public Trailer() {
		this(-1, "", -1, "", -1);
	}
	
	public Trailer (int id, String title, int posterUrl, String youtubeId, int runningTime) {
		this.id = id;
		this.title = title;
		this.posterUrl = posterUrl;
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
	public int getPosterUrl(){
		return posterUrl;
	}
	public void setPosterUrl(int posterUrl){
		this.posterUrl = posterUrl;
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
