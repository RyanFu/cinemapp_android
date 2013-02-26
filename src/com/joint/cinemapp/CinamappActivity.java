package com.joint.cinemapp;

import java.io.InputStream;
import java.util.ArrayList;

import com.joint.cinemapp.R;
import com.jumplife.adapter.MoviePosterViewPagerAdapter;
import com.jumplife.imageload.ImageLoader;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;

public class CinamappActivity extends Activity {
	
	private ArrayList<Bitmap> moviePosters;
	private RelativeLayout rlViewpager;
	private MoviePosterViewPagerAdapter mAdapter;
	private ViewPager mPager;
	private PageIndicator mIndicator;
	private LoadDataTask loadtask;
	private boolean isPlay = false;
	private ImageButton play;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinamapp);

        initView();
        
        loadtask = new LoadDataTask();
	    if(Build.VERSION.SDK_INT < 11)
	    	loadtask.execute();
        else
        	loadtask.executeOnExecutor(LoadDataTask.THREAD_POOL_EXECUTOR, 0);
    }
	
	private void initView() {
		rlViewpager = (RelativeLayout)findViewById(R.id.rl_viewpager);
		play = (ImageButton)findViewById(R.id.play);
		play.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				isPlay = !isPlay;
				if(isPlay)
					play.setImageResource(R.drawable.pause);
				else
					play.setImageResource(R.drawable.play);
			}			
		});
		
		LinearLayout movieinfo = (LinearLayout)findViewById(R.id.ll_movieinfo);
		movieinfo.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent newAct = new Intent();
	            newAct.setClass(CinamappActivity.this, MovieInfoViewPagerActivity.class);
	            CinamappActivity.this.startActivity(newAct);
			}			
		});
		
		LinearLayout movielisten = (LinearLayout)findViewById(R.id.ll_movielisten);
		movielisten.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent newAct = new Intent();
	            newAct.setClass(CinamappActivity.this, MovieListenGridViewActivity.class);
	            CinamappActivity.this.startActivity(newAct);				
			}			
		});
	}
	
	private void fetchData() {
		InputStream inputStream = this.getResources().openRawResource(R.drawable.movie1_slider_1);
        Bitmap bitmap1 = BitmapFactory.decodeStream(inputStream, null, ImageLoader.getBitmapOptions());
        inputStream = this.getResources().openRawResource(R.drawable.movie2_slider_2);
        Bitmap bitmap2 = BitmapFactory.decodeStream(inputStream, null, ImageLoader.getBitmapOptions());
        inputStream = this.getResources().openRawResource(R.drawable.movie3_slider_3);
        Bitmap bitmap3 = BitmapFactory.decodeStream(inputStream, null, ImageLoader.getBitmapOptions());
        
		moviePosters = new ArrayList<Bitmap>();
		moviePosters.add(bitmap1);
		moviePosters.add(bitmap2);
		moviePosters.add(bitmap3);
	}
	
	@SuppressWarnings("deprecation")
	private void setView() {
		mAdapter = new MoviePosterViewPagerAdapter(this, moviePosters);

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        
        LayoutParams rlLayout = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
        DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        if(moviePosters.get(0).getHeight() != 0) {
        	double height = (double)(screenWidth * ((double)moviePosters.get(0).getHeight() / (double)moviePosters.get(0).getWidth()));
	        rlLayout.height = (int) height;
        } else 
        	rlLayout.height = screenWidth * 420 / 720;
        rlLayout.addRule(RelativeLayout.BELOW, R.id.topbar);
        
        rlViewpager.setLayoutParams(rlLayout);
        
        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
	}
	
	class LoadDataTask extends AsyncTask<Integer, Integer, String>{  
        
    	@Override  
        protected void onPreExecute() {
    		super.onPreExecute();  
        }  
          
        @Override  
        protected String doInBackground(Integer... params) {
        	Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        	fetchData();
            return "progress end";  
        }  
  
        @Override  
        protected void onProgressUpdate(Integer... progress) {    
            super.onProgressUpdate(progress);  
        }  
  
        @Override  
        protected void onPostExecute(String result) {
        	if(moviePosters != null && moviePosters.size() > 0){
        		setView();
        	}
        	super.onPostExecute(result);
        }
    }
}
