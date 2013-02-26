package com.jumplife.adapter;

import java.io.InputStream;
import java.util.ArrayList;

import com.joint.cinemapp.R;
import com.joint.cinemapp.entity.Trailer;
import com.jumplife.imageload.ImageLoader;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TrailerListAdapter extends BaseAdapter{
	
    private Activity mActivity;
    private ArrayList<Trailer> trailers;
	private ImageLoader imageLoader;
	
	private class ItemView {
		ImageView poster;
		TextView title;
		TextView time;
	}
	
	public TrailerListAdapter(Activity mActivity, ArrayList<Trailer> trailers){
		this.trailers = trailers;
		this.mActivity = mActivity;
		imageLoader = new ImageLoader(mActivity, 0);
	}

	public int getCount() {
		
		return trailers.size();
	}

	public Object getItem(int position) {

		return trailers.get(position);
	}

	public long getItemId(int position) {
	
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {		
		ItemView itemView = new ItemView();;
		
		if (convertView != null) {
			itemView = (ItemView) convertView.getTag();
		} else {
			LayoutInflater myInflater = LayoutInflater.from(mActivity);
			convertView = myInflater.inflate(R.layout.listview_trailer, null);
			itemView.time = (TextView)convertView.findViewById(R.id.time);
			itemView.title = (TextView)convertView.findViewById(R.id.title);
			itemView.poster = (ImageView)convertView.findViewById(R.id.iv_trailer_photo);
			
			convertView.setTag(itemView);
		}
				
		itemView.title.setText(trailers.get(position).getTitle());
		itemView.time.setText(trailers.get(position).getRunningTime() + "s");
		//imageLoader.DisplayImage(trailers.get(position).getYoutubeId(), itemView.poster);
		InputStream inputStream = mActivity.getResources().openRawResource(trailers.get(position).getPosterUrl());
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, ImageLoader.getBitmapOptions());
		itemView.poster.setImageBitmap(bitmap);
		
		return convertView;

	}
}
