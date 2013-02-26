package com.jumplife.adapter;

import java.io.InputStream;

import com.joint.cinemapp.R;
import com.joint.cinemapp.entity.MovieListen;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class ListenViewPagerAdapter extends PagerAdapter implements IconPagerAdapter{

    protected static final String[] CONTENT = new String[] { "電影原聲帶", "電影影評" };
	private Activity mActivty;
	private MovieListen movielistens;

	public ListenViewPagerAdapter(Activity activty, MovieListen movielistens) {
		this.mActivty = activty;
		this.movielistens = movielistens;
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
				view = View.inflate(mActivty, R.layout.albumlisten_viewpage_item, null);
				ListView lvAlbum = (ListView)view.findViewById(R.id.lv_album);
				ImageView albumPoster = (ImageView)view.findViewById(R.id.album_poster);
				
				DisplayMetrics displayMetrics = new DisplayMetrics();
				mActivty.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
				InputStream inputStream = mActivty.getResources().openRawResource(R.drawable.movie1_album_cover_big_1);
		        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, ImageLoader.getBitmapOptions());
		        bitmap = Bitmap.createScaledBitmap(bitmap, displayMetrics.widthPixels, 
		        		bitmap.getWidth() * bitmap.getHeight() / displayMetrics.widthPixels, true);
		        albumPoster.setImageBitmap(bitmap);
				
				AlbumListenListAdapter albumAdapter = new AlbumListenListAdapter(mActivty, movielistens.getAlbums());
				lvAlbum.setAdapter(albumAdapter);
				lvAlbum.setOnItemClickListener(new itemOnClickListener(pos));
		    
		        break;
			
			default:
				view = View.inflate(mActivty, R.layout.commentlisten_viewpage_item, null);
				ListView lvComment = (ListView)view.findViewById(R.id.lv_comment);
				CommentListenListAdapter commentAdapter = new CommentListenListAdapter(mActivty, movielistens.getComments());
				lvComment.setAdapter(commentAdapter);
				lvComment.setOnItemClickListener(new itemOnClickListener(pos));
		        
		        break;
		}        
        
        ((ViewPager)pager).addView(view, ((ViewPager)pager).getChildCount() > pos ? pos : ((ViewPager)pager).getChildCount());
	    
        return view;
	}
	
	public class itemOnClickListener implements OnItemClickListener {
		private int index = 0;
		public itemOnClickListener(int i) {
			index = i;
		}
		
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Intent newAct = new Intent();
            /*newAct.putExtra("variety_id", mVarietyLists.get(index).get(position).getId());
            newAct.putExtra("variety_name", mVarietyLists.get(index).get(position).getName());
            newAct.putExtra("variety_poster", mVarietyLists.get(index).get(position).getPosterUrl());
            newAct.setClass(mActivty, MovieListenGridViewActivity.class);
            mActivty.startActivity(newAct);*/
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