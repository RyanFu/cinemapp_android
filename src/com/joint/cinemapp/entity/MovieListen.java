package com.joint.cinemapp.entity;

import java.util.ArrayList;

import com.joint.cinemapp.R;

public class MovieListen {
	private int id;
	private String chineseName;
	private String englishName;
	//private String posterUrl;
	private int posterUrl;
	private ArrayList<Album> albums;
	private ArrayList<Comment> comments;
	
	public MovieListen fakeData1() {
		ArrayList<Album> albums = new ArrayList<Album>(10);
		Album album = new Album();
		albums.add(album.fakeData1());
		
		ArrayList<Comment> comments = new ArrayList<Comment>(10);
		Comment comment = new Comment();
		comments.add(comment.fakeData1());
		comments.add(comment.fakeData2());
		comments.add(comment.fakeData3());
		
		MovieListen movieInfo = new MovieListen(1, "長頸鹿女孩", "Postcards from the Zoo", 
				R.drawable.movie1_album_cover_1, albums, comments);
		return movieInfo;		
	}
	
	public MovieListen fakeData2() {
		ArrayList<Album> albums = new ArrayList<Album>(10);
		Album album = new Album();
		albums.add(album.fakeData2_1());
		albums.add(album.fakeData2_2());
		
		ArrayList<Comment> comments = new ArrayList<Comment>(10);
		Comment comment = new Comment();
		comments.add(comment.fakeData1());
		comments.add(comment.fakeData2());
		comments.add(comment.fakeData3());
		
		MovieListen movieInfo = new MovieListen(1, "漂流古巴", "Una Noche", 
				R.drawable.movie2_album_cover_2, albums, comments);
		return movieInfo;		
	}
	
	public MovieListen fakeData3() {
		ArrayList<Album> albums = new ArrayList<Album>(10);
		Album album = new Album();
		albums.add(album.fakeData3());
		
		ArrayList<Comment> comments = new ArrayList<Comment>(10);
		Comment comment = new Comment();
		comments.add(comment.fakeData1());
		comments.add(comment.fakeData2());
		comments.add(comment.fakeData3());
		
		MovieListen movieInfo = new MovieListen(1, "隨風而弒", "Just the wind", 
				R.drawable.movie3_album_cover_3, albums, comments);
		return movieInfo;		
	}
	
	public MovieListen() {
		this(-1, "", "", -1,  new ArrayList<Album>(10), new ArrayList<Comment>(10));
	}
	
	public MovieListen (int id, String chineseName, String englishName, int posterUrl,
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
	public int getPosterUrl(){
		return posterUrl;
	}
	public void setPosterUrl(int posterUrl){
		this.posterUrl = posterUrl;
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
