package com.example.hp0331.objview.activity;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hp0331.objview.R;

public class MyAdapter extends BaseAdapter {
	private LayoutInflater minflater;
	private List list;
	private Context mcontext;
	public MyAdapter(Context context,List mlist){
		this.list=mlist;
		this.mcontext=context;
		minflater=LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView=minflater.inflate(R.layout.item, null);
		((TextView)convertView.findViewById(R.id.textview)).setText(list.get(position).toString());
		return convertView;
	}

}
