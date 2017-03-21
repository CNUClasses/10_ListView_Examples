package com.example.lv4_filtering;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class LV4_SearchBoxActivity extends ListActivity {

    private EditText filterText = null;
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_lv4__search_box);

	filterText = (EditText) findViewById(R.id.search_box);
	filterText.addTextChangedListener(filterTextWatcher);

	String[] values = new String[] { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Ceres", "Pluto", "Haumea", "Makemake", "Eris" };

	adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, values);
	setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.activity_lv4__search_box, menu);
	return true;
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        filterText.removeTextChangedListener(filterTextWatcher);
    }
    

    private TextWatcher filterTextWatcher = new TextWatcher() {
	    public void beforeTextChanged(CharSequence s, int start, int count,
	            int after) {
	    }
	    
	    
	    /* (non-Javadoc)
	     * @see android.text.TextWatcher#onTextChanged(java.lang.CharSequence, int, int, int)
	     * when text changes apply built in adapter filter to list using the following syntax
	     */
	    public void onTextChanged(CharSequence s, int start, int before,
	            int count) {
	        adapter.getFilter().filter(s);
	    }
	    @Override
	    public void afterTextChanged(Editable arg0) {
		// TODO Auto-generated method stub
		
	    }
	};    
}
