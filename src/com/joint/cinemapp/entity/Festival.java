package com.joint.cinemapp.entity;

import java.util.ArrayList;

public class Festival {
	private int id;
	private String festivalName;
	private String festivalDate;
	private String introduction;
	private String introductionName;
	private String posterUrl;
	private ArrayList<MovieInfo> movieInfos;
	private MovieListen movieListen;

	
	public Festival() {
		this(-1, "", "", "", "", "", new ArrayList<MovieInfo>(10), new MovieListen());
	}
	
	public Festival (int id, String festivalName, String festivalDate, String introduction, String introductionName, String posterUrl,
			  ArrayList<MovieInfo> movieInfos, MovieListen movieListen) {
		this.id = id;
		this.festivalName = festivalName;
		this.festivalDate = festivalDate;
		this.introduction = introduction;
		this.introductionName = introductionName;
		this.posterUrl = posterUrl;
		this.movieInfos = movieInfos;
		this.movieListen = movieListen;
	}
	
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getFestivalName(){
		return festivalName;
	}
	public void setFestivalName(String festivalName){
		this.festivalName = festivalName;
	}
	public String getFestivalDate(){
		return festivalDate;
	}
	public void setFestivalDate(String festivalDate){
		this.festivalDate = festivalDate;
	}
	public String getIntroduction(){
		return introduction;
	}
	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}
	public String getIntroductionName(){
		return introductionName;
	}
	public void setIntroductionName(String introductionName){
		this.introductionName = introductionName;
	}
	public String getPosterUrl(){
		return posterUrl;
	}
	public void setPosterUrl(String posterUrl){
		this.posterUrl = posterUrl;
	}
	public ArrayList<MovieInfo> getMovieInfos(){
		return movieInfos;
	}
	public void setMovieInfos(ArrayList<MovieInfo> movieInfos){
		this.movieInfos = movieInfos;
	}
	public MovieListen getMovieListen(){
		return movieListen;
	}
	public void setMovieListen(MovieListen movieListen){
		this.movieListen = movieListen;
	}
}
