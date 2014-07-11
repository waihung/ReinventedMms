package com.android.mms.reinvented.mms.adapter;

import com.android.mms.R;
import com.android.mms.reinvented.mms.model.Icons;

import java.util.ArrayList;

import android.widget.ImageView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MDAdapter extends BaseAdapter {
	
	private Context context;
	private ArrayList<Icons> navDrawerItems;
	
	public MDAdapter(Context context, ArrayList<Icons> navDrawerItems){
		this.context = context;
		this.navDrawerItems = navDrawerItems;
	}

	@Override
	public int getCount() {
		return navDrawerItems.size();
	}

	@Override
	public Object getItem(int position) {		
		return navDrawerItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.adapter_stuff, null);
        }
         
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.iconPicture);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.MDText);
         
        imgIcon.setImageResource(navDrawerItems.get(position).getIcon());        
        txtTitle.setText(navDrawerItems.get(position).getTitle());
        
        return convertView;
	}

}
