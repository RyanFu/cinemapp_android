package com.jumplife.adapter;

import com.joint.cinemapp.InfoViewPagerActivity;
import com.joint.cinemapp.R;
import com.joint.cinemapp.entity.Festival;
import com.viewpagerindicator.IconPagerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class FestivalViewPagerAdapter extends PagerAdapter implements IconPagerAdapter{

    protected static final String[] CONTENT = new String[] { "主題介紹", "參展電影" };
	private Activity mActivity;
	private Festival festival;

	public FestivalViewPagerAdapter(Activity activity, Festival festival) {
		this.mActivity = activity;
		this.festival = festival.fakeData1();
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
				view = View.inflate(mActivity, R.layout.festivalcomment_viewpage_item, null);
				TextView tvFestivalContentTitle = (TextView)view.findViewById(R.id.festival_introduction_title);
				TextView tvFestivalContent = (TextView)view.findViewById(R.id.festival_introduction_content);
				ListView lvComment = (ListView)view.findViewById(R.id.lv_comment);
				CommentListenListAdapter commentAdapter = new CommentListenListAdapter(mActivity, festival.getMovieListen().getComments());
				lvComment.setAdapter(commentAdapter);
				lvComment.setOnItemClickListener(new commentItemOnClickListener());
		    
				tvFestivalContentTitle.setText(festival.getIntroductionName());
				tvFestivalContent.setText(festival.getIntroduction());
				
		        break;
			
			default:
				view = View.inflate(mActivity, R.layout.movieinfo_viewpage_item, null);
				ListView lvMovie = (ListView)view.findViewById(R.id.lv_movie);
		        Log.d("", "movie info size : " + festival.getMovieInfos().size());
		        MovieListAdapter adapter = new MovieListAdapter(mActivity, festival.getMovieInfos());
		        lvMovie.setAdapter(adapter);
		        lvMovie.setOnItemClickListener(new movieItemOnClickListener());
		        
		        break;
		}        
        
        ((ViewPager)pager).addView(view, ((ViewPager)pager).getChildCount() > pos ? pos : ((ViewPager)pager).getChildCount());
	    
        return view;
	}
	
	public class commentItemOnClickListener implements OnItemClickListener {
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Intent newAct = new Intent();
            /*newAct.putExtra("variety_id", mVarietyLists.get(index).get(position).getId());
            newAct.putExtra("variety_name", mVarietyLists.get(index).get(position).getName());
            newAct.putExtra("variety_poster", mVarietyLists.get(index).get(position).getPosterUrl());
            newAct.setClass(mActivty, MovieListenGridViewActivity.class);
            mActivty.startActivity(newAct);*/
		}
	};
	
	public class movieItemOnClickListener implements OnItemClickListener {
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Intent newAct = new Intent();
            newAct.setClass(mActivity, InfoViewPagerActivity.class);
            mActivity.startActivity(newAct);
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