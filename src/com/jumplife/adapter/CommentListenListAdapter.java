package com.jumplife.adapter;

import java.io.InputStream;
import java.util.ArrayList;

import com.joint.cinemapp.R;
import com.joint.cinemapp.entity.Album;
import com.joint.cinemapp.entity.Comment;
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

public class CommentListenListAdapter extends BaseAdapter{
	
    private Activity mActivity;
    private ArrayList<Comment> comments;
	
	public CommentListenListAdapter(Activity mActivity, ArrayList<Comment> comments){
		this.comments = comments;
		this.mActivity = mActivity;
	}

	public int getCount() {
		
		return comments.size();
	}

	public Object getItem(int position) {

		return comments.get(position);
	}

	public long getItemId(int position) {
	
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater myInflater = LayoutInflater.from(mActivity);
		View converView = myInflater.inflate(R.layout.listview_comment, null);
		
		ImageView ivCommentOwner = (ImageView)converView.findViewById(R.id.iv_comment_owner);
		TextView commentOwner = (TextView)converView.findViewById(R.id.comment_owner);
		TextView commentTitle = (TextView)converView.findViewById(R.id.comment_title);
		
		commentOwner.setText(comments.get(position).getTitle());
		commentTitle.setText(comments.get(position).getContent());
		//imageLoader.DisplayImage(movies.get(position).getYoutubeId(), itemView.poster, displayMetrics.widthPixels);
		InputStream inputStream = mActivity.getResources().openRawResource(comments.get(position).getPosterUrl());
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, ImageLoader.getBitmapOptions());
        ivCommentOwner.setImageBitmap(bitmap);
		return converView;

	}
}
