package com.joint.cinemapp.entity;

public class Album {
	private int id;
	private String chineseName;
	private String englishName;
	private int runningTime;
	
	public Album fakeData1() {
		Album album = new Album(1, "Postcard from the zoo", "Postcard from the zoo", 15);
		return album;
	}
	
	public Album fakeData2_1() {
		Album album = new Album(1, "Una Che_1", "Una Che_1", 15);
		return album;
	}
	
	public Album fakeData2_2() {
		Album album = new Album(1, "Una Che_2", "Una Che_1", 15);
		return album;
	}
	
	public Album fakeData3() {
		Album album = new Album(1, "Just the Wind", "Just the Wind", 15);
		return album;
	}
	
	public Album() {
		this(-1, "", "", -1);
	}
	
	public Album (int id, String chineseName, String englishName, int runningTime) {
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
