package com.jumplife.adapter;

import java.io.InputStream;

import com.joint.cinemapp.PhotoGridViewActivity;
import com.joint.cinemapp.R;
import com.joint.cinemapp.TrailerListViewActivity;
import com.joint.cinemapp.entity.MovieInfo;
import com.jumplife.imageload.ImageLoader;
import com.viewpagerindicator.IconPagerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoViewPagerAdapter extends PagerAdapter implements IconPagerAdapter{

    protected static final String[] CONTENT = new String[] { "電影簡介", "電影介紹" };
	private Activity mActivty;
	private MovieInfo movieInfo;

	public InfoViewPagerAdapter(Activity activty, MovieInfo movieInfo) {
		this.mActivty = activty;
		this.movieInfo = movieInfo.fakeData1();
	}
	
	public int getCount() {
		return CONTENT.length;
	}
	
	public void destroyItem(View pager, int position, Object view) {
		((ViewPager) pager).removeView(((ViewPager)pager).getChildAt(position));
	}

	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == (arg1);
	}	
	
	@Override
	public Object instantiateItem(View pager, int pos) {
        
		Log.d(null, "movies position : " + pos + ", child count" + ((ViewPager)pager).getChildCount());
		View view = null;
		
		switch (pos) {
			case 0:
				view = View.inflate(mActivty, R.layout.movieintro_viewpage_item, null);	
				
				TextView movieName = (TextView)view.findViewById(R.id.movie_name);
				TextView movieNameEn = (TextView)view.findViewById(R.id.movie_name_en);
				TextView movieRunningTime = (TextView)view.findViewById(R.id.movie_runningtime);
				TextView movieReleaseDate = (TextView)view.findViewById(R.id.release_date);
				TextView movieDirectors = (TextView)view.findViewById(R.id.director);
				TextView movieActors = (TextView)view.findViewById(R.id.actor);
				ImageView poster = (ImageView)view.findViewById(R.id.movie_poster);
				
				movieName.setText(movieInfo.getChineseName());
				movieNameEn.setText(movieInfo.getEnglishName());
				movieRunningTime.setText("片長:" + movieInfo.getRunningTime() + "分");
				movieReleaseDate.setText("上映日期 : " + movieInfo.getRunningTime());
				movieDirectors.setText("導演 : " + movieInfo.getDirectors());
				movieActors.setText("演員 : " + movieInfo.getActors());
				DisplayMetrics displayMetrics = new DisplayMetrics();
				mActivty.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
				InputStream inputStream = mActivty.getResources().openRawResource(movieInfo.getPosterUrl());
		        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, ImageLoader.getBitmapOptions());
		        bitmap = Bitmap.createScaledBitmap(bitmap, displayMetrics.widthPixels, 
		        		bitmap.getWidth() * bitmap.getHeight() / displayMetrics.widthPixels, true);
				poster.setImageBitmap(bitmap);
				
				Button buttonPhoto = (Button)view.findViewById(R.id.photo);
				buttonPhoto.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {
						Intent newAct = new Intent();
			            newAct.setClass(mActivty, PhotoGridViewActivity.class);
			            mActivty.startActivity(newAct);
					}			
				});		
				
				Button buttonTrailer = (Button)view.findViewById(R.id.trailer);
				buttonTrailer.setOnClickListener(new OnClickListener() {
		            public void onClick(View arg0) {
		            	Intent newAct = new Intent();
			            newAct.setClass(mActivty, TrailerListViewActivity.class);
			            mActivty.startActivity(newAct);
		            }
		        });
		    
		        break;
			
			default:
				view = View.inflate(mActivty, R.layout.moviecontent_viewpage_item, null);
				TextView movieContent = (TextView)view.findViewById(R.id.movie_introduction_content);
				movieContent.setText(movieInfo.getIntroduction());
				Log.d("", "Movie Content : " + movieInfo.getIntroduction());
		        
		        break;
		}        
        
        ((ViewPager)pager).addView(view, ((ViewPager)pager).getChildCount() > pos ? pos : ((ViewPager)pager).getChildCount());
	    
        return view;
	}

	public CharSequence getPageTitle(int position) {
      return CONTENT[position % CONTENT.length];
    }
	
	public int getIconResId(int index) {
		// TODO Auto-generated method stub
		return 0;
	}
}