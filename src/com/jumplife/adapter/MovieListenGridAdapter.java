package com.jumplife.adapter;

import java.io.InputStream;
import java.util.ArrayList;

import com.joint.cinemapp.R;
import com.joint.cinemapp.entity.MovieListen;
import com.jumplife.imageload.ImageLoader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieListenGridAdapter extends BaseAdapter{

	private ArrayList<MovieListen> movieListens;
	private Activity mActivity;
	private ImageLoader imageLoader;
	
	private int width;
	private int height;

	private class ItemView {
		ImageView poster;
		TextView name;
		TextView songs;
		TextView comments;
	}
	
	public MovieListenGridAdapter(Activity mActivity, ArrayList<MovieListen> movieListens){
		this.movieListens = movieListens;
		this.mActivity = mActivity;
		width = 80;
		height = 80;		
		imageLoader = new ImageLoader(mActivity, width);
	}
	
	public MovieListenGridAdapter(Activity mActivity, ArrayList<MovieListen> movieListens, int width, int height){
		this.movieListens = movieListens;
		this.mActivity = mActivity;
		this.width = width;
		this.height = height;
		imageLoader = new ImageLoader(mActivity, width, R.drawable.album_background);
	}
	
	public int getCount() {
		return movieListens.size();
	}

	public Object getItem(int position) {
		return movieListens.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ItemView itemView = new ItemView();;
		
		if (convertView != null) {
			itemView = (ItemView) convertView.getTag();
		} else {
			LayoutInflater myInflater = LayoutInflater.from(mActivity);
			convertView = myInflater.inflate(R.layout.gridview_movielisten_item, null);
			itemView.name = (TextView)convertView.findViewById(R.id.movie_name);
			itemView.songs = (TextView)convertView.findViewById(R.id.song_number);
			itemView.comments = (TextView)convertView.findViewById(R.id.comment_number);
			itemView.poster = (ImageView)convertView.findViewById(R.id.movie_poster);
			
			convertView.setTag(itemView);
		}
		
		itemView.poster.getLayoutParams().height = height;
		itemView.poster.getLayoutParams().width = width;
		itemView.poster.setScaleType(ImageView.ScaleType.FIT_CENTER);
		itemView.name.setText(movieListens.get(position).getChineseName());
		itemView.songs.setText(movieListens.get(position).getAlbums().size() + " " + mActivity.getResources().getString(R.string.song_number));
		itemView.comments.setText(movieListens.get(position).getComments().size() + " " + mActivity.getResources().getString(R.string.comment_number));
		//imageLoader.DisplayImage(movieListens.get(position).getPosterUrl(), itemView.poster, width);
		InputStream inputStream = mActivity.getResources().openRawResource(movieListens.get(position).getPosterUrl());
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, ImageLoader.getBitmapOptions());
		itemView.poster.setImageBitmap(bitmap);
		
		return convertView;
	}

}
