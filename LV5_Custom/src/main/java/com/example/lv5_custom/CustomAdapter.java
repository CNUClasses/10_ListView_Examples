package com.example.lv5_custom;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	private String TAG = "CustomAdapter_LV5";
	private LayoutInflater inflater;
	private MainActivity context;
	private static final int NUMB_ITEMS = 1000;

	public CustomAdapter(MainActivity context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Leave this as 0 and you will have nothing in your list
		return NUMB_ITEMS;
	}

	@Override
	public Object getItem(int arg0) {
		return arg0;
	}

	@Override
	public long getItemId(int position) {
		// do you want the result?
		return (long) position;
	}

	private static class ViewHolder {
		TextView tv1;
		TextView tv2;
		TextView tv3;
		int myNumberToDouble;
	}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder myVh;

		if (convertView == null) {
			LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.cl, null);

			myVh = new ViewHolder();
			myVh.tv1 = (TextView) convertView.findViewById(R.id.tv1);
			myVh.tv2 = (TextView) convertView.findViewById(R.id.tv2);
			myVh.tv3 = (TextView) convertView.findViewById(R.id.tv3);

			// this is sort of a primary key
			myVh.myNumberToDouble = position;

			convertView.setTag(myVh);
		} else {
			myVh = (ViewHolder) convertView.getTag();
		}

		// multiply these 2 numbers
		myVh.tv1.setText(Integer.toString(position));
		myVh.tv2.setText(Integer.toString(position));

		// to get this number
		
		//the main thread way
//		myVh.tv3.setText(Integer.toString(position + position));
		
		//the asynctask way
		new CalculateValueTask(myVh).execute(position);
		Log.d(TAG,"Launching " + Integer.toString(position));

		return convertView;
	}

	
	public class CalculateValueTask extends AsyncTask<Integer, Void, Integer> {
		private ViewHolder myVh;
		private int myNumberToDouble;

		public CalculateValueTask(ViewHolder myVh) {
			this.myVh = myVh;
			this.myNumberToDouble = myVh.myNumberToDouble;
		}

		@Override
		protected void onPostExecute(Integer result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			// if the following are NOT equal
			// then the view has been recycled and is being used by another
			// number
			if (myVh.myNumberToDouble == myNumberToDouble) {
				// hooray it has not been reused yet
				//although it may be in the scrapheap
				
//				if (context.isVisible(myNumberToDouble))
					myVh.tv3.setText(Integer.toString(result));
//				else
//					Log.e(TAG,"Position " + myNumberToDouble+ " not visible");
			}

		}

		@Override
		protected Integer doInBackground(Integer... arg0) {

//			try {
//				//
//				Thread.sleep(20);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			Integer myInt = arg0[0] + arg0[0];
			return myInt;
		}
	}
}
