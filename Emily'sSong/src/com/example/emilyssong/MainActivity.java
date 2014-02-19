package com.example.emilyssong;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	MediaPlayer pink;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// pink.start();

	}

	protected void onResume() {
		pink = MediaPlayer.create(this, R.raw.pink);
		pink.start();
		super.onResume();
	}

	@Override
	protected void onPause() {
		pink.stop();
		pink.release();
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void openFB(View v) {
		String url = "http://joemonster.org/";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	}

	// public void openBC(View v){
	//
	// if(pink.isPlaying()){
	// pink.stop();
	// pink.prepareAsync();
	// }
	// else{
	// pink.start();
	//
	// }
	// }

}
