package com.jumplife.adapter;

import java.util.ArrayList;

import com.joint.cinemapp.R;
import com.joint.cinemapp.entity.Album;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AlbumListenListAdapter extends BaseAdapter{
	
    private Activity mActivity;
    private ArrayList<Album> albums;
	
	public AlbumListenListAdapter(Activity mActivity, ArrayList<Album> albums){
		this.albums = albums;
		this.mActivity = mActivity;
	}

	public int getCount() {
		
		return albums.size();
	}

	public Object getItem(int position) {

		return albums.get(position);
	}

	public long getItemId(int position) {
	
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater myInflater = LayoutInflater.from(mActivity);
		View converView = myInflater.inflate(R.layout.listview_album, null);
		
		TextView albumNo = (TextView)converView.findViewById(R.id.album_no);
		TextView albumChName = (TextView)converView.findViewById(R.id.album_ch_name);
		TextView albumEnName = (TextView)converView.findViewById(R.id.album_en_name);
		
		albumNo.setText("0" + (position + 1));
		albumChName.setText(albums.get(position).getChineseName());
		albumEnName.setText(albums.get(position).getEnglishName());
		
		return converView;

	}
}
