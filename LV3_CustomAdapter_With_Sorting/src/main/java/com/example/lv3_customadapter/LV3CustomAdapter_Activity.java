package com.example.lv3_customadapter;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;

public class LV3CustomAdapter_Activity extends ListActivity {
	OnSharedPreferenceChangeListener listener;
	SharedPreferences myPreference;
	CustomAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// notice no setcontent view
        adapter = new CustomAdapter(this,R.layout.listview_row_layout);
		// a custom data adapter
		setListAdapter(adapter);

		myPreference = PreferenceManager.getDefaultSharedPreferences(this);

		// listen for a change to the listPref key,
		// its the key part of the key value pair that holds the URL to load
		// when this key changes then the URL has changed to so reload it
		// make this listener an instance var so it is not GCed due to it being
		// saved as a weak reference
		listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
			public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
				if (key.equals("listPref")) {

					String sortorder = myPreference.getString("listPref", "1");
					LV3CustomAdapter_Activity.this.adapter.sortList(Integer.parseInt(sortorder));
				}
			}
		};

		// gotta register the listener
		myPreference.registerOnSharedPreferenceChangeListener(listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_lv3_custom_adapter_, menu);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			Intent myIntent = new Intent(this, activityPreference.class);
			startActivity(myIntent);
		default:
			break;
		}
		return true;
	}

}
