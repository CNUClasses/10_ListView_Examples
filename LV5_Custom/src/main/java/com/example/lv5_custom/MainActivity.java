package com.example.lv5_custom;

import android.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends ListActivity {

	private CustomAdapter myAdapter;
	ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// a custom data adapter
		myAdapter = new CustomAdapter(this);
		setListAdapter(myAdapter);
		
		listView = getListView();
	}
	
	public boolean isVisible(int pos)
	{
//	    if(pos < 0 || pos >= listView.getCount())
//	        return false;

	    int first = listView.getFirstVisiblePosition();
	    int last = listView.getLastVisiblePosition();

	    return (pos>=first && pos<=last);
	}


}
