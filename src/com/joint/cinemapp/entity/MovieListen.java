package com.joint.cinemapp.entity;

import java.util.ArrayList;

public class MovieListen {
	private int id;
	private String chineseName;
	private String englishName;
	private String posterUrl;
	private int songsNo;
	private int commentsNo;
	private ArrayList<Album> albums;
	private ArrayList<Comment> comments;
	
	public MovieListen() {
		this(-1, "", "", "", new ArrayList<Album>(10), new ArrayList<Comment>(10));
	}
	
	public MovieListen (int id, String chineseName, String englishName, String posterUrl, 
			ArrayList<Album> albums, ArrayList<Comment> comments) {
		this.id = id;
		this.chineseName = chineseName;
		this.englishName = englishName;
		this.posterUrl = posterUrl;
		this.albums = albums;
		this.comments = comments;		
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
	public String getPosterUrl(){
		return posterUrl;
	}
	public void setPosterUrl(String posterUrl){
		this.posterUrl = posterUrl;
	}
	public int getSongsNo(){
		return songsNo;
	}
	public void setSongsNo(int songsNo){
		this.songsNo = songsNo;
	}
	public int getCommentsNo(){
		return commentsNo;
	}
	public void setCommentsNo(int commentsNo){
		this.commentsNo = commentsNo;
	}
	public ArrayList<Album> getAlbums(){
		return albums;
	}
	public void setAlbums(ArrayList<Album> albums){
		this.albums = albums;
	}
	public ArrayList<Comment> getComments(){
		return comments;
	}
	public void setComments(ArrayList<Comment> comments){
		this.comments = comments;
	}
}
