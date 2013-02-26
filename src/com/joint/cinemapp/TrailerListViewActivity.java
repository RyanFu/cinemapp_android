package com.joint.cinemapp;

import java.util.ArrayList;

import com.joint.cinemapp.entity.Trailer;
import com.jumplife.adapter.TrailerListAdapter;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

public class TrailerListViewActivity extends Activity {
	
	private ArrayList<Trailer> trailers;
	private ListView trailerListView;
    private TrailerListAdapter adapter;
	private LoadDataTask loadtask;
	private boolean isPlay = false;
	private ImageButton play;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trailer);

        initView();
        
        loadtask = new LoadDataTask();
	    if(Build.VERSION.SDK_INT < 11)
	    	loadtask.execute();
        else
        	loadtask.executeOnExecutor(LoadDataTask.THREAD_POOL_EXECUTOR, 0);
    }
	
	private void initView() {
		trailerListView = (ListView)findViewById(R.id.lv_trailer);
		
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
		trailers = new ArrayList<Trailer>(10);
		
		Trailer trailer = new Trailer();
		trailers.add(trailer);
		trailers.add(trailer);
	}
	
	private void setView() {		
		trailerListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	
            }
        });
		
		adapter = new TrailerListAdapter(TrailerListViewActivity.this, trailers);
        trailerListView.setAdapter(adapter);
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
        	if(trailers != null && trailers.size() > 0){
        		setView();
        	}
        	super.onPostExecute(result);
        }
    }
}
