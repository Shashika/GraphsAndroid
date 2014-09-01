package com.shashika.graphsachartengine;

import com.example.graphsachartengine.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button bView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bView = (Button)findViewById(R.id.button1);
	}

	public void graphHandler(View view){
		
		DrawGraph drawGraph = new DrawGraph();
		Intent lineIntent = drawGraph.getIntent(this);
		startActivity(lineIntent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
