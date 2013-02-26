package com.jumplife.adapter;

import java.io.InputStream;
import java.util.ArrayList;

import com.joint.cinemapp.R;
import com.jumplife.imageload.ImageLoader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class PhotoGridAdapter extends BaseAdapter{

	private ArrayList<String> photoUrls;
	private Activity mActivity;
	private ImageLoader imageLoader;
	
	private int width;
	private int height;

	public class ItemView {
		ImageView poster;
	}
	
	public PhotoGridAdapter(Activity mActivity, ArrayList<String> photoUrls){
		this.photoUrls = photoUrls;
		this.mActivity = mActivity;
		width = 80;
		height = 80;		
		imageLoader = new ImageLoader(mActivity, width);
	}
	
	public PhotoGridAdapter(Activity mActivity, ArrayList<String> photoUrls, int width, int height){
		this.photoUrls = photoUrls;
		this.mActivity = mActivity;
		this.width = width;
		this.height = height;
		imageLoader = new ImageLoader(mActivity, width, R.drawable.album_background);
	}
	
	public int getCount() {
		return photoUrls.size();
	}

	public Object getItem(int position) {
		return photoUrls.get(position);
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
			convertView = myInflater.inflate(R.layout.gridview_photo_item, null);
			itemView.poster = (ImageView)convertView.findViewById(R.id.photo);
			
			convertView.setTag(itemView);
		}
		
		itemView.poster.getLayoutParams().height = height;
		itemView.poster.getLayoutParams().width = width;
		itemView.poster.setScaleType(ImageView.ScaleType.FIT_CENTER);
		//imageLoader.DisplayImage(photoUrls.get(position), itemView.poster, width);
		int[] photo = {R.drawable.girl_1, R.drawable.girl_2, R.drawable.girl_3, R.drawable.girl_4,
				R.drawable.girl_5, R.drawable.girl_6};
		InputStream inputStream = mActivity.getResources().openRawResource(photo[position]);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, ImageLoader.getBitmapOptions());
		itemView.poster.setImageBitmap(bitmap);
		
		return convertView;
	}

}
