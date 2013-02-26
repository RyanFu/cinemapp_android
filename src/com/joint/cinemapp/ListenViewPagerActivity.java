package com.joint.cinemapp;

import java.util.ArrayList;

import com.joint.cinemapp.R;
import com.joint.cinemapp.entity.Album;
import com.joint.cinemapp.entity.Comment;
import com.joint.cinemapp.entity.MovieListen;
import com.jumplife.adapter.ListenViewPagerAdapter;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class ListenViewPagerActivity extends Activity {
	
	private MovieListen movielistens;
	private ListenViewPagerAdapter mAdapter;
	private ViewPager mPager;
    private PageIndicator mIndicator;
	private LoadDataTask loadtask;
    
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_infoviewpager);

        initView();
        
        loadtask = new LoadDataTask();
	    if(Build.VERSION.SDK_INT < 11)
	    	loadtask.execute();
        else
        	loadtask.executeOnExecutor(LoadDataTask.THREAD_POOL_EXECUTOR, 0);
    }
	
	private void initView() {
		
	}
	
	private void fetchData() {
		movielistens = new MovieListen();
		ArrayList<Album> albums = new ArrayList<Album>(10);
		ArrayList<Comment> comments = new ArrayList<Comment>(10);
		
		albums.add(new Album());
		albums.add(new Album());
		movielistens.setAlbums(albums);
		
		comments.add(new Comment());
		comments.add(new Comment());
		movielistens.setComments(comments);
	}
	
	private void setView() {		
		mAdapter = new ListenViewPagerAdapter(this, movielistens);
        
        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setOffscreenPageLimit(2);
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
        	if(movielistens != null){
        		setView();
        	}
        	super.onPostExecute(result);
        }
    }
}
