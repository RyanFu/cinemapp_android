package com.joint.cinemapp.entity;

import java.util.ArrayList;
import java.util.Date;

public class Album {
	private int id;
	private String chineseName;
	private String englishName;
	private int runningTime;
	
	public Album() {
		this(-1, "", "", "", new Date(), "", -1, "", new ArrayList<String>(10), new ArrayList<String>(10), "");
	}
	
	public Album (int id, String chineseName, String englishName, String introduction, Date releaseDate, String posterUrl, 
			  int runningTime, String levelUrl, ArrayList<String> actors, ArrayList<String> directors, String youtubeId) {
		this.id = id;
		this.chineseName = chineseName;
		this.englishName = englishName;
		this.runningTime = runningTime;		
	}
	
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getChineseName(){
		return chineseName;
	}
	public void setChineseName(String chineseName){
		this.chineseName = chineseName;
	}
	public String getEnglishName(){
		return englishName;
	}
	public void setEnglishName(String englishName){
		this.englishName = englishName;
	}	
	public int getRunningTime(){
		return runningTime;
	}
	public void setRunningTime(int runningTime){
		this.runningTime = runningTime;
	}
}
