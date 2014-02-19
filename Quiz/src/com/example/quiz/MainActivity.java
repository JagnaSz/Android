package com.example.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static final String NAME = "name";
	public static final String SURNAME = "surname";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void start(View view){
		
		EditText name = (EditText) findViewById(R.id.editText1);
		EditText lastname = (EditText) findViewById(R.id.editText2);
		
		if(name.getText().toString().length()==0){
			Toast.makeText(this.getApplicationContext(), "Wpisz imiê", Toast.LENGTH_LONG).show();
			return;
		}
		if(lastname.getText().toString().length()==0){
			Toast.makeText(this.getApplicationContext(), "Wpisz nazwisko", Toast.LENGTH_LONG).show();
			return;
		}
		
		Intent intent = new Intent(this, QuestionActivity.class);
		intent.putExtra(NAME, name.getText().toString());
		intent.putExtra(SURNAME, lastname.getText().toString());
		
		startActivity(intent);
		
		Log.d("MainActivity","Start!");
		
		
		
	}
}
