package org.tasafo.mobile.palestrascoletivas;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventsListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_events_list);

	List<Event> list = new FakeEventsDatasource().getAll();
	ArrayAdapter<Event> adapter = new ArrayAdapter<Event>(this, android.R.layout.simple_list_item_1, list);
	ListView eventsList = (ListView) findViewById(R.id.events_list);
	eventsList.setAdapter(adapter);

	eventsList.setOnItemClickListener(new OnItemClickListener() {
	    @Override
	    public void onItemClick(AdapterView<?> adapter, View view, int pos, long id) {
		Intent gotoEvent = new Intent(EventsListActivity.this, EventActivity.class);
		Event event = (Event) adapter.getItemAtPosition(pos);
		gotoEvent.putExtra("selected", event);
		startActivity(gotoEvent);
	    }
	});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
    }
}
