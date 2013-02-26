package com.joint.cinemapp.entity;

import java.util.ArrayList;
import java.util.Date;

public class MovieInfo {
	private int id;
	private String chineseName;
	private String englishName;
	private String introduction;
	private Date releaseDate;
	private String posterUrl;
	private int runningTime;
	private String levelUrl;
	private ArrayList<String> actors;
	private ArrayList<String> directors;
	
	private String youtubeId;
	private String hall;
	
	public MovieInfo() {
		this(-1, "", "", "", new Date(), "", -1, "", new ArrayList<String>(10), new ArrayList<String>(10), "");
	}
	
	public MovieInfo (int id, String chineseName, String englishName, String introduction, Date releaseDate, String posterUrl, 
			  int runningTime, String levelUrl, ArrayList<String> actors, ArrayList<String> directors, String youtubeId) {
		this.id = id;
		this.chineseName = chineseName;
		this.englishName = englishName;
		this.releaseDate = releaseDate;
		this.posterUrl = posterUrl;
		this.runningTime = runningTime;
		this.levelUrl = levelUrl;
		this.actors = actors;
		this.directors = directors;
		this.youtubeId = youtubeId;		
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
	public String getIntroduction(){
		return introduction;
	}
	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}
	public Date getReleaseDate(){
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate){
		this.releaseDate = releaseDate;
	}
	public String getPosterUrl(){
		return posterUrl;
	}
	public void setPosterUrl(String posterUrl){
		this.posterUrl = posterUrl;
	}
	public int getRunningTime(){
		return runningTime;
	}
	public void setRunningTime(int runningTime){
		this.runningTime = runningTime;
	}
	public String getLevelUrl(){
		return levelUrl;
	}
	public void setLevelUrl(String levelUrl){
		this.levelUrl = levelUrl;
	}
	public ArrayList<String> getActors(){
		return actors;
	}
	public void setActors(ArrayList<String> actors){
		this.actors = actors;
	}
	public ArrayList<String> getDirectors(){
		return directors;
	}
	public void setDirectors(ArrayList<String> directors){
		this.directors = directors;
	}
	public void setYoutubeId(String youtube){
		this.youtubeId = youtube;
	}
	public String getYoutubeId(){
		return youtubeId;
	}
	public String getYoutubeVideoUrl(){
		return "http://www.youtube.com/watch?v="+youtubeId;
	}
	public String getYoutubeVideoImage(){
		return "http://img.youtube.com/vi/" + youtubeId +"/0.jpg";
	}

	public void setHall(String hall){
		this.hall = hall;
	}
	public String getHall(){
		return hall;
	}
}
