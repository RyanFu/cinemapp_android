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
		MovieInfo movieInfo = new MovieInfo();
		lvMovies.add(movieInfo.fakeData1());
		lvMovies.add(movieInfo.fakeData2());
		lvMovies.add(movieInfo.fakeData3());
		
		festival.setFestivalName("第63屆 柏林影展");
		festival.setFestivalDate("2013/02/07~2013/02/17");
		festival.setPosterUrl(R.drawable.film_festival_1);
		festival.setIntroductionName("影展介紹");
		festival.setIntroduction("囊括三部獲柏林肯定，出自不同地域、文化的傑出電影：來自東歐匈牙利、榮獲柏林銀熊獎評審團大獎的《隨風而弒》，改編驚駭入骨的社會案件；來自南亞印尼、角逐柏林金熊獎的競賽片《長頸鹿女孩》，細述魔幻人生的迷幻愛情；來自拉美古巴、獲選柏林新世代單元的《漂流古巴》，激放投奔自由的海上歷險。三部風格迥異、各擅勝場，不但全面體現柏林精神，更開拓出觀者的「自由之窗」，撼動沉睡的感官與心靈。");
		festival.setMovieInfos(lvMovies);
		festival.setMovieListen(new MovieListen().fakeData1());
		return festival;
	}
	
	public Festival fakeData2() {
		Festival festival = new Festival();
		ArrayList<MovieInfo> lvMovies = new ArrayList<MovieInfo>(10);
		MovieInfo movieInfo = new MovieInfo();
		lvMovies.add(movieInfo.fakeData1());
		lvMovies.add(movieInfo.fakeData2());
		lvMovies.add(movieInfo.fakeData3());
		
		festival.setFestivalName("日舞影展");
		festival.setFestivalDate("2013/02/07~2013/02/17");
		festival.setPosterUrl(R.drawable.film_festival_2);
		festival.setMovieInfos(lvMovies);
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
