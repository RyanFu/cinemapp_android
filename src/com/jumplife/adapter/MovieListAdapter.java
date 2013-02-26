package com.jumplife.adapter;

import java.util.ArrayList;

import com.joint.cinemapp.R;
import com.joint.cinemapp.entity.MovieInfo;
import com.jumplife.imageload.ImageLoader;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieListAdapter extends BaseAdapter{
	
    private Activity mActivity;
    private ArrayList<MovieInfo> movies;
	private ImageLoader imageLoader;
	
	private class ItemView {
		ImageView poster;
		TextView movieChName;
		TextView movieEnName;
		TextView movieReleaseDate;
	}
	
	public MovieListAdapter(Activity mActivity, ArrayList<MovieInfo> movies){
		this.movies = movies;
		this.mActivity = mActivity;
		imageLoader = new ImageLoader(mActivity, 0);
	}

	public int getCount() {
		
		return movies.size();
	}

	public Object getItem(int position) {

		return movies.get(position);
	}

	public long getItemId(int position) {
	
		return position;
	}

	@SuppressWarnings("deprecation")
	public View getView(int position, View convertView, ViewGroup parent) {
		
		/*LayoutInflater myInflater = LayoutInflater.from(mActivity);
		View converView = myInflater.inflate(R.layout.listview_movie, null);
		
		ImageView poster = (ImageView)converView.findViewById(R.id.poster);
		DisplayMetrics displayMetrics = new DisplayMetrics();
		mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels - 60;
		
        int tmp = (int)( (Math.random() * 2 ) + 1 );
        Bitmap bitmap;
        
        if(tmp == 1)
        	bitmap = BitmapFactory.decodeResource(mActivity.getResources(), R.drawable.ads_1);
        else
        	bitmap = BitmapFactory.decodeResource(mActivity.getResources(), R.drawable.ads_2);
        	
		poster.setScaleType(ImageView.ScaleType.FIT_CENTER);        
        double height = (double)(screenWidth * ((double)bitmap.getHeight() / (double)bitmap.getWidth()));        
        poster.getLayoutParams().height = (int)height;
        poster.getLayoutParams().width = screenWidth;    	
		poster.setImageBitmap(bitmap);*/
        

		ItemView itemView = new ItemView();;
		
		if (convertView != null) {
			itemView = (ItemView) convertView.getTag();
		} else {
			LayoutInflater myInflater = LayoutInflater.from(mActivity);
			convertView = myInflater.inflate(R.layout.listview_movie, null);
			itemView.movieChName = (TextView)convertView.findViewById(R.id.movie_name);
			itemView.movieEnName = (TextView)convertView.findViewById(R.id.movie_name_en);
			itemView.movieReleaseDate = (TextView)convertView.findViewById(R.id.release_date);
			itemView.poster = (ImageView)convertView.findViewById(R.id.poster);
			
			convertView.setTag(itemView);
		}
				
		DisplayMetrics displayMetrics = new DisplayMetrics();
		mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		
		/*itemView.movieChName.setText(movies.get(position).getChineseName());
		itemView.movieEnName.setText(movies.get(position).getEnglishName());
		itemView.movieReleaseDate.setText((movies.get(position).getReleaseDate().getYear() + 1900) + " / " +
				(movies.get(position).getReleaseDate().getMonth() + 1) + " / " +
				(movies.get(position).getReleaseDate().getDate()));*/
		imageLoader.DisplayImage(movies.get(position).getYoutubeId(), itemView.poster, displayMetrics.widthPixels);
		
		return convertView;

	}
}
