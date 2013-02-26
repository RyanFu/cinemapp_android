package com.jumplife.adapter;

import java.util.ArrayList;

import com.joint.cinemapp.R;
import com.joint.cinemapp.entity.Festival;
import com.jumplife.imageload.ImageLoader;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FestivalListAdapter extends BaseAdapter{
	
    private Activity mActivity;
    private ArrayList<Festival> festivals;
	private ImageLoader imageLoader;
	
	private class ItemView {
		ImageView poster;
		TextView movieChName;
		TextView movieDate;
	}
	
	public FestivalListAdapter(Activity mActivity, ArrayList<Festival> festivals){
		this.festivals = festivals;
		this.mActivity = mActivity;
		imageLoader = new ImageLoader(mActivity, 0);
	}

	public int getCount() {
		
		return festivals.size();
	}

	public Object getItem(int position) {

		return festivals.get(position);
	}

	public long getItemId(int position) {
	
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
		/*LayoutInflater myInflater = LayoutInflater.from(mActivity);
		View converView = myInflater.inflate(R.layout.listview_movie, null);
		
		ImageView poster = (ImageView)converView.findViewById(R.id.poster);
		DisplayMetrics displayMetrics = new DisplayMetrics();
		mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels - 60;
		
        int tmp = (int)( (Math.random() * 2 ) + 1 );
        Bitmap bitmap;
        
        if(tmp == 1)
        	bitmap = BitmapFactory.decodeResource(mActivity.getResources(), R.drawable.ads_1);
        else
        	bitmap = BitmapFactory.decodeResource(mActivity.getResources(), R.drawable.ads_2);
        	
		poster.setScaleType(ImageView.ScaleType.FIT_CENTER);        
        double height = (double)(screenWidth * ((double)bitmap.getHeight() / (double)bitmap.getWidth()));        
        poster.getLayoutParams().height = (int)height;
        poster.getLayoutParams().width = screenWidth;    	
		poster.setImageBitmap(bitmap);
        imageLoader.DisplayImage(movies.get(position).getImageUrl(), poster, displayMetrics.widthPixels);*/

		ItemView itemView = new ItemView();;
		
		if (convertView != null) {
			itemView = (ItemView) convertView.getTag();
		} else {
			LayoutInflater myInflater = LayoutInflater.from(mActivity);
			convertView = myInflater.inflate(R.layout.listview_festival, null);
			itemView.movieChName = (TextView)convertView.findViewById(R.id.festival_name);
			itemView.movieDate = (TextView)convertView.findViewById(R.id.festival_date);
			itemView.poster = (ImageView)convertView.findViewById(R.id.poster);
			
			convertView.setTag(itemView);
		}
			
		DisplayMetrics displayMetrics = new DisplayMetrics();
		mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        
		/*itemView.movieChName.setText(festivals.get(position).getFestivalName());
		itemView.movieDate.setText(festivals.get(position).getFestivalDate());*/
		imageLoader.DisplayImage(festivals.get(position).getPosterUrl(), itemView.poster, displayMetrics.widthPixels);
		
		return convertView;

	}
}
