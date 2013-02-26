package com.joint.cinemapp;

import java.util.ArrayList;
import java.util.List;

import com.joint.cinemapp.R;
import com.joint.cinemapp.entity.Festival;
import com.joint.cinemapp.entity.MovieInfo;
import com.jumplife.adapter.MovieInfoViewPagerAdapter;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MovieInfoViewPagerActivity extends Activity {
	
	private List<ArrayList<MovieInfo>> movies;
	private ArrayList<Festival> festivals;
	private MovieInfoViewPagerAdapter mAdapter;
	private ViewPager mPager;
    private PageIndicator mIndicator;
	private LoadDataTask loadtask;
	private boolean isPlay = false;
	private ImageButton play;
    
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movieinfoviewpager);

        initView();
        
        loadtask = new LoadDataTask();
	    if(Build.VERSION.SDK_INT < 11)
	    	loadtask.execute();
        else
        	loadtask.executeOnExecutor(LoadDataTask.THREAD_POOL_EXECUTOR, 0);
    }
	
	private void initView() {
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
		
	}
	
	private void fetchData() {
		ArrayList<MovieInfo> lvMovies = new ArrayList<MovieInfo>(10);
		lvMovies.add(new MovieInfo().fakeData1());
		lvMovies.add(new MovieInfo().fakeData2());
		lvMovies.add(new MovieInfo().fakeData3());
		
		movies = new ArrayList<ArrayList<MovieInfo>>();
		
		movies.add(lvMovies);
		movies.add(lvMovies);
		movies.add(lvMovies);
		movies.add(lvMovies);		
		
		festivals = new ArrayList<Festival>(10);
		festivals.add(new Festival().fakeData1());
		festivals.add(new Festival().fakeData2());
	}
	
	private void setView() {		
		mAdapter = new MovieInfoViewPagerAdapter(this, movies, festivals);
        
        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setOffscreenPageLimit(4);
        mPager.setAdapter(mAdapter);

        mIndicator = (TitlePageIndicator)findViewById(R.id.indicator);
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
        	if(!(movies.get(0) == null || movies.get(1) == null || movies.get(2) == null || movies.get(3) == null) || festivals == null){
        		setView();
        	}
        	super.onPostExecute(result);
        }
    }
}
