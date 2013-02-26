package com.jumplife.adapter;

import com.joint.cinemapp.PhotoGridViewActivity;
import com.joint.cinemapp.R;
import com.joint.cinemapp.TrailerListViewActivity;
import com.joint.cinemapp.entity.MovieInfo;
import com.viewpagerindicator.IconPagerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class InfoViewPagerAdapter extends PagerAdapter implements IconPagerAdapter{

    protected static final String[] CONTENT = new String[] { "電影簡介", "電影介紹" };
	private Activity mActivty;
	private MovieInfo movieInfo;

	public InfoViewPagerAdapter(Activity activty, MovieInfo movieInfo) {
		this.mActivty = activty;
		this.movieInfo = movieInfo;
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
				TextView tvMovieContent = (TextView)view.findViewById(R.id.movie_introduction_content);
				tvMovieContent.setText(movieInfo.getIntroduction());
		        
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