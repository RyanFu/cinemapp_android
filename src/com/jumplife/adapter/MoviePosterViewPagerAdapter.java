package com.jumplife.adapter;

import java.util.ArrayList;
import com.joint.cinemapp.R;
import com.viewpagerindicator.IconPagerAdapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MoviePosterViewPagerAdapter extends PagerAdapter implements IconPagerAdapter{

	private Activity mActivty;
	private ArrayList<Bitmap> moviePosters;

	public MoviePosterViewPagerAdapter(Activity activty, ArrayList<Bitmap> moviePosters) {
		this.mActivty = activty;
		this.moviePosters = moviePosters;
	}
	
	@Override
	public int getCount() {
		return moviePosters.size();
	}
	
	@Override
	public void destroyItem(View pager, int position, Object view) {
		((ViewPager) pager).removeView(((ViewPager)pager).getChildAt(position));
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == (arg1);
	}	
	
	@Override
	public Object instantiateItem(View pager, int pos) {
        
		DisplayMetrics displayMetrics = new DisplayMetrics();
		mActivty.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        
        Bitmap bitmap = moviePosters.get(pos);
        View view = View.inflate(mActivty, R.layout.movieposter_viewpage_item, null);
        ImageView imageViewMoviePoster = (ImageView)view.findViewById(R.id.imageview_movieposter);
        
        imageViewMoviePoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
        
        double height = (double)(screenWidth * ((double)bitmap.getHeight() / (double)bitmap.getWidth()));
        bitmap = Bitmap.createScaledBitmap(bitmap, screenWidth, (int) height, true);
        imageViewMoviePoster.getLayoutParams().height = (int)height;
        imageViewMoviePoster.getLayoutParams().width = screenWidth;    	
        imageViewMoviePoster.setImageBitmap(bitmap);
        
		/*imageLoader.DisplayImage(dramas.get(position).getPosterUrl(), imageViewMoviePoster);*/
        
        ((ViewPager)pager).addView(view, ((ViewPager)pager).getChildCount() > pos ? pos : ((ViewPager)pager).getChildCount());
        
	    return view;
	}

	public int getIconResId(int index) {
		// TODO Auto-generated method stub
		return index;
	}
}