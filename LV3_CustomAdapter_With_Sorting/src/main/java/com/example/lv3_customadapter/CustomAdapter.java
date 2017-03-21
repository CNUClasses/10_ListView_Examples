package com.example.lv3_customadapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	private static final 	CharSequence IS_PLANET = "Is a planet";
	private static final 	CharSequence AINT_PLANET = "Aint a planet";
	public static final 	int ISPLANET = 0;
	public static final 	int ALPHA = 1;
	private 				List<MyData> myList;
	private 				Activity activity;
	private 				int layoutId;
	private 				LayoutInflater inflater;

	/**
	 * @param activity
	 *            what the view is attached to
	 * @param layoutId
	 *            defines how each row looks
	 * 
	 */
	public CustomAdapter(Activity activity, int layoutId) {
		this.activity = activity;
		this.layoutId = layoutId;

		// notice again with the getSystemService, its used in a lot of Android
		// APIs
		if (activity != null)
			this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.myList = attachData();
	}

	/**
	 * @param iSort
	 *            for java the param is better off as an enum which is an object
	 *            for android objects have a cost so use int
	 */
	public void sortList(int iSort) {
		switch (iSort) {
		case ISPLANET:
			Collections.sort(myList, new MyDataIsPlanetComparator());
			break;
		case ALPHA:
			Collections.sort(myList, new MyDataNameUPComparator());
			break;
		default:
			Collections.sort(myList, new MyDataNameDOWNComparator());
			break;
		}
		notifyDataSetChanged();
	}

	// can do this any number of ways this is just convenient
	private List<MyData> attachData() {
		// create our souped up list of MyDatas cannot use default adapter now
		// can just as easily get this entirely in the adapter so activity has
		// no knowledge
		// of type of data
		List<MyData> ml = new ArrayList<MyData>();

		ml.add(new MyData("Mercury"));
		ml.add(new MyData("Venus"));
		ml.add(new MyData("Earth"));
		ml.add(new MyData("Mars"));
		ml.add(new MyData("Jupiter"));
		ml.add(new MyData("Saturn"));
		ml.add(new MyData("Uranus"));
		ml.add(new MyData("Neptune"));
		ml.add(new MyData("Ceres", false));
		ml.add(new MyData("Pluto"));
		ml.add(new MyData("Haumea", false));
		ml.add(new MyData("Makemake", false));
		ml.add(new MyData("Eris", false));
		return ml;
	}

	@Override
	public int getCount() {
		return (myList != null) ? myList.size() : 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return (myList != null) ? myList.get(arg0) : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getView(int, android.view.View,
	 * android.view.ViewGroup) this function called every time a row is
	 * populated in the listview
	 */
	@Override
	public View getView(int pos, View convertView, ViewGroup parentView) {
		View view = null;
		if (convertView == null) {
			view = inflater.inflate(layoutId, parentView, false);
		} else {
			view = convertView;
		}

		// set the name
		TextView textView = (TextView) view.findViewById(R.id.name);
		textView.setText(myList.get(pos).name);

		// is it a planet
		TextView textView1 = (TextView) view.findViewById(R.id.isPlanet);
		if (myList.get(pos).isPlanet) {
			textView1.setTextColor(activity.getResources().getColor(R.color.Black));
			textView1.setText(IS_PLANET);
		} else {
			textView1.setTextColor(activity.getResources().getColor(R.color.Red));
			textView1.setText(AINT_PLANET);
		}

		return view;
	
	
//	//the slow way
//	public View getView(int pos, View convertView, ViewGroup parentView) {
//		//inflate every time very expensive!
//		View view = inflater.inflate(layoutId, parentView, false);
//
//		// set the name
//		TextView textView = (TextView) view.findViewById(R.id.name);
//		textView.setText(myList.get(pos).name);
//
//		// is it a planet
//		TextView textView1 = (TextView) view.findViewById(R.id.isPlanet);
//		if (myList.get(pos).isPlanet) {
//			textView1.setTextColor(activity.getResources().getColor(R.color.Black));
//			textView1.setText(IS_PLANET);
//		} else {
//			textView1.setTextColor(activity.getResources().getColor(R.color.Red));
//			textView1.setText(AINT_PLANET);
//		}
//
//		return view;
//	}

}}

