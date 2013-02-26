package com.joint.cinemapp;

import java.util.ArrayList;

import com.jumplife.adapter.PhotoGridAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.AdapterView.OnItemClickListener;

public class PhotoGridViewActivity extends Activity {
	
	private ArrayList<String> photoUrls;
	private GridView photoGridView;
    private PhotoGridAdapter adapter;
	private LoadDataTask loadtask;
	private boolean isPlay = false;
	private ImageButton play;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo);

        initView();
        
        loadtask = new LoadDataTask();
	    if(Build.VERSION.SDK_INT < 11)
	    	loadtask.execute();
        else
        	loadtask.executeOnExecutor(LoadDataTask.THREAD_POOL_EXECUTOR, 0);
    }
	
	private void initView() {
		photoGridView = (GridView)findViewById(R.id.gridview_photo);
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
		photoUrls = new ArrayList<String>(10);
		
		String photoUrl = "1";
		photoUrls.add(photoUrl);
		photoUrls.add(photoUrl);
		photoUrls.add(photoUrl);
		photoUrls.add(photoUrl);
		photoUrls.add(photoUrl);
		photoUrls.add(photoUrl);
	}
	
	private void setView() {		
		photoGridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	
            }
        });
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        
        adapter = new PhotoGridAdapter(PhotoGridViewActivity.this, photoUrls,
        		(int)(screenWidth / 2 - 80), (int)(screenWidth / 2 - 80));
        photoGridView.setAdapter(adapter);
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
        	if(photoUrls != null && photoUrls.size() > 0){
        		setView();
        	}
        	super.onPostExecute(result);
        }
    }
}
