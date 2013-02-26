package com.joint.cinemapp.entity;

import com.joint.cinemapp.R;

public class MovieInfo {
	private int id;
	private String chineseName;
	private String englishName;
	private String introduction;
	private String releaseDate;
	//private String posterUrl;
	private int posterUrl;
	private int runningTime;
	private String levelUrl;
	private String actors;
	private String directors;	
	private String youtubeId;
	
	public MovieInfo fakeData1() {
		MovieInfo movieInfo = new MovieInfo(1, "長頸鹿女孩", "Postcards from the Zoo", 
				"拉娜3歲時被父親遺棄在動物園，被園區的好心人帶大。待她亭亭玉立，愛上了漂泊的魔術師，決定跟隨他到雅加達賣藝維生。兩人隨後被地方有力人士挖掘，但魔術師在一次演練中，從著了火的木箱消失無蹤，拉娜的幸福被迫中止。礙於生計，拉娜淪為情色按摩師，在慾望充斥的場域，用寂寞餵養寂寞，引頸企盼愛情歸來。最終她能找到真正的歸宿嗎？", 
				"2013/1/18", R.drawable.movie1_movie_out_1, 95, "限制級", "艾德溫", "尼可拉斯‧撒普特拉  拉迪雅‧喬利  海帝‧崔絲塔娜‧崔斯望", "");
		return movieInfo;		
	}
	
	public MovieInfo fakeData2() {
		MovieInfo movieInfo = new MovieInfo(1, "漂流古巴", "Una Noche", 
				"性格精實的勞爾，正值生命中最繽紛的花樣年華，但為了幫患愛滋的娼妓母親弄到藥，他必須忍辱兼差男妓。在地人都知道，想在哈瓦那生存，若不出賣勞力，就得出賣肉體。勞爾受夠了，他想投奔美國，於是說服死黨艾利歐，計畫自製木筏橫越90英里的海洋。放不下家人的艾利歐，對同性的勞爾抱著友達以上的感情，默默協助他準備啟航，然而一切卻被雙胞胎姊姊麗拉發現，並決定加入出走行列。這次冒險，即將成為三人永世難忘的驚險挑戰！", 
				"2013/1/18", R.drawable.movie2_movie_out_2, 90, "限制級", "露西‧穆洛伊", "拉里葉‧阿雷恰尬  安納以琳‧狄拉露雅‧狄拉托瑞  哈維爾‧努涅茲‧佛羅瑞安", "");
		return movieInfo;		
	}
	
	public MovieInfo fakeData3() {
		MovieInfo movieInfo = new MovieInfo(1, "隨風而弒", "Just the wind", 
				"本片改編自真實社會事件：一個純樸的匈牙利鄉村，一戶戶吉普賽家庭接連慘遭滅門。無冤無仇卻白白喪命，大家知道這是純粹的種族仇殺，警察幫不上忙，村人選擇沉默。吉普賽人只能自組自衛隊，盼能嚇阻恐怖組織的犯行。鄰近命案現場的另一戶吉普賽家庭，雖毫髮無傷，但仍籠罩在死亡陰影，冀望加拿大的一家之主，儘快將他們接過去團聚。在此之前，每個人只能懸著心，維持表面的平靜。當夜幕低垂，真正的恐懼才要來臨……", 
				"2013/1/18", R.drawable.movie3_movie_out_3, 98, "保護級", "班內狄克‧弗立高夫", "卡塔林‧托爾迪  拉奇斯‧薩坎尼", "");
		return movieInfo;		
	}
	
	public MovieInfo() {
		this(-1, "", "", "", "", -1, -1, "", "", "", "");
	}
	
	public MovieInfo (int id, String chineseName, String englishName, String introduction, String releaseDate, int posterUrl, 
			  int runningTime, String levelUrl, String directors, String actors, String youtubeId) {
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
	public String getReleaseDate(){
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
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
	public String getLevelUrl(){
		return levelUrl;
	}
	public void setLevelUrl(String levelUrl){
		this.levelUrl = levelUrl;
	}
	public String getActors(){
		return actors;
	}
	public void setActors(String actors){
		this.actors = actors;
	}
	public String getDirectors(){
		return directors;
	}
	public void setDirectors(String directors){
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
}
