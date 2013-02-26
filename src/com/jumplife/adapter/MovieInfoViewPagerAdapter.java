package com.jumplife.adapter;

import java.util.ArrayList;
import java.util.List;

import com.joint.cinemapp.FestivalViewPagerActivity;
import com.joint.cinemapp.InfoViewPagerActivity;
import com.joint.cinemapp.R;
import com.joint.cinemapp.entity.Festival;
import com.joint.cinemapp.entity.MovieInfo;
import com.viewpagerindicator.IconPagerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MovieInfoViewPagerAdapter extends PagerAdapter implements IconPagerAdapter{

    protected static final String[] CONTENT = new String[] { "現正熱映", "近期上映", "影展焦點", "經典電影"};
	private Activity mActivty;
	private List<ArrayList<MovieInfo>> movies;
	private ArrayList<Festival> festivals;

	public MovieInfoViewPagerAdapter(Activity activty, List<ArrayList<MovieInfo>> movies, ArrayList<Festival> festivals) {
		this.mActivty = activty;
		this.movies = movies;
		this.festivals = festivals;
	}
	
	public int getCount() {
		return movies.size();
	}
	
	public void destroyItem(View pager, int position, Object view) {
		((ViewPager) pager).removeView(((ViewPager)pager).getChildAt(position));
	}

	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == (arg1);
	}	
	
	@Override
	public Object instantiateItem(View pager, int pos) {
        
		View view;
        switch (pos) {
			case 2:
				view = View.inflate(mActivty, R.layout.movieinfo_festival_viewpage_item, null);
				ListView lvFestival = (ListView)view.findViewById(R.id.lv_festival);
		        
		        FestivalListAdapter festivaladapter = new FestivalListAdapter(mActivty, festivals);
		        lvFestival.setAdapter(festivaladapter);
		        lvFestival.setOnItemClickListener(new festivalItemOnClickListener());
		    
		        break;
			
			default:
				view = View.inflate(mActivty, R.layout.movieinfo_viewpage_item, null);
				ListView lvMovie = (ListView)view.findViewById(R.id.lv_movie);
		        
		        MovieListAdapter adapter = new MovieListAdapter(mActivty, movies.get(pos));
		        lvMovie.setAdapter(adapter);
		        lvMovie.setOnItemClickListener(new movieItemOnClickListener(pos));
		        
		        break;
		}		
        
        ((ViewPager)pager).addView(view, ((ViewPager)pager).getChildCount() > pos ? pos : ((ViewPager)pager).getChildCount());
	    
        return view;
	}
	
	public class movieItemOnClickListener implements OnItemClickListener {
		private int index = 0;
		public movieItemOnClickListener(int i) {
			index = i;
		}
		
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Intent newAct = new Intent();
            newAct.setClass(mActivty, InfoViewPagerActivity.class);
            mActivty.startActivity(newAct);
		}
	};

	public class festivalItemOnClickListener implements OnItemClickListener {
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Intent newAct = new Intent();
            newAct.setClass(mActivty, FestivalViewPagerActivity.class);
            mActivty.startActivity(newAct);
		}
	};
	
	public CharSequence getPageTitle(int position) {
      return CONTENT[position % CONTENT.length];
    }
	
	public int getIconResId(int index) {
		// TODO Auto-generated method stub
		return 0;
	}
}