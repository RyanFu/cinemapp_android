package com.joint.cinemapp.entity;

import java.util.ArrayList;

import com.joint.cinemapp.R;

public class Festival {
	private int id;
	private String festivalName;
	private String festivalDate;
	private String introduction;
	private String introductionName;
	//private String posterUrl;
	private int posterUrl;
	private ArrayList<MovieInfo> movieInfos;
	private MovieListen movieListen;

	public Festival fakeData1() {
		Festival festival = new Festival();
		ArrayList<MovieInfo> lvMovies = new ArrayList<MovieInfo>(10);
		lvMovies.add(new MovieInfo().fakeData1());
		lvMovies.add(new MovieInfo().fakeData2());
		lvMovies.add(new MovieInfo().fakeData3());
		
		festival.setFestivalName("第63屆 柏林影展");
		festival.setFestivalDate("2013/02/07~2013/02/17");
		festival.setPosterUrl(R.drawable.film_festival_1);
		festival.setMovieInfos(movieInfos);
		return festival;
	}
	
	public Festival fakeData2() {
		Festival festival = new Festival();
		ArrayList<MovieInfo> lvMovies = new ArrayList<MovieInfo>(10);
		lvMovies.add(new MovieInfo().fakeData1());
		lvMovies.add(new MovieInfo().fakeData2());
		lvMovies.add(new MovieInfo().fakeData3());
		
		festival.setFestivalName("日舞影展");
		festival.setFestivalDate("2013/02/07~2013/02/17");
		festival.setPosterUrl(R.drawable.film_festival_2);
		festival.setMovieInfos(movieInfos);
		return festival;
	}
	
	public Festival() {
		this(-1, "", "", "", "", -1, new ArrayList<MovieInfo>(10), new MovieListen());
	}
	
	public Festival (int id, String festivalName, String festivalDate, String introduction, String introductionName, int posterUrl,
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
	public int getPosterUrl(){
		return posterUrl;
	}
	public void setPosterUrl(int posterUrl){
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
