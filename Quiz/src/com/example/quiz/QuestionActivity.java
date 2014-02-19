package com.example.quiz;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends Activity {

	public static final String NAME = "name";
	public static final String SURNAME = "surname";
	public static final String SCORE = "score";
	public static  String name;
	public static String surname;
	public static int count =0;
	public static int score = 0;
	class Question{
		String[] ultimateQuestion = {"Czy podoba Ci siê broda prowadz¹cego?","Jaka jest Twoja ulubiona pora roku?", "Czy Aga kocha Piotra?"};
		String [][] answers = {{"Tak.", "Zdecydowanie tak.", "Sam(a) chcia³(a)bym tak¹ mieæ."},{"Tak","Wiosna","Zima"},{"Oczywiœcie", "Tak", "Kocha kocha <3"}};
		int [][] correctAnswers = {{0,1,2},{2,1,0},{3,3,3}};
		int answer = -1;
	}
	
    Question q;
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		Intent i = getIntent();
		String info = i.getStringExtra(MainActivity.NAME);		
		String info2 = i.getStringExtra(MainActivity.SURNAME);		

		Toast.makeText(this.getApplicationContext(), "Witaj "+info+" "+info2+" ;)", Toast.LENGTH_LONG).show();
	    
		q = new Question();
		
		
		 Bundle extras = getIntent().getExtras();
		 name = extras.getString(MainActivity.NAME);
		 surname = extras.getString(MainActivity.SURNAME);
		 Log.d("sds", name);
		 
		 TextView question = (TextView) findViewById(R.id.questionText);
		 RadioButton ans1 = (RadioButton) findViewById(R.id.answer1);
		 RadioButton ans2 = (RadioButton) findViewById(R.id.answer2);
		 RadioButton ans3 = (RadioButton) findViewById(R.id.answer3); 
		 
		 question.setText(q.ultimateQuestion[0]);
		 ans1.setText(q.answers[0][0]);
		 ans2.setText(q.answers[0][1]);
		 ans3.setText(q.answers[0][2]);
		 
		 Button b1 = (Button) findViewById(R.id.button1);
		 b1.setVisibility(View.VISIBLE);
		 Button b2 = (Button) findViewById(R.id.button2);
		 b2.setVisibility(View.VISIBLE);
		 Button b3 = (Button) findViewById(R.id.button3);
		 b3.setVisibility(View.GONE);
		 
	}
	
	public void next(View view){
		
		if(count != q.ultimateQuestion.length-1){
			count +=1;
			 TextView question = (TextView) findViewById(R.id.questionText);
			 RadioButton ans1 = (RadioButton) findViewById(R.id.answer1);
			 RadioButton ans2 = (RadioButton) findViewById(R.id.answer2);
			 RadioButton ans3 = (RadioButton) findViewById(R.id.answer3); 
			 
			 question.setText(q.ultimateQuestion[count]);
			 ans1.setText(q.answers[count][0]);
			 ans2.setText(q.answers[count][1]);
			 ans3.setText(q.answers[count][2]);
			 
			 Button b1 = (Button) findViewById(R.id.button1);
			 b1.setVisibility(View.VISIBLE);
			 Button b2 = (Button) findViewById(R.id.button2);
			 b2.setVisibility(View.VISIBLE);
			 Button b3 = (Button) findViewById(R.id.button3);
			 b3.setVisibility(View.GONE);
			 
		}
		 if(count == q.ultimateQuestion.length-1){
			 Button b3 = (Button) findViewById(R.id.button3);
			 b3.setVisibility(View.VISIBLE);
			 Button b1 = (Button) findViewById(R.id.button1);
			 b1.setVisibility(View.GONE);
			 Button b2 = (Button) findViewById(R.id.button2);
			 b2.setVisibility(View.GONE);
		 }
		 
		 RadioGroup r = (RadioGroup) findViewById(R.id.ans);
		 View v = r.findViewById(r.getCheckedRadioButtonId());
		 
		 score += q.correctAnswers[count][r.indexOfChild(v)];
		 Log.d(""+score+"","sds");
		 r.clearCheck();
		 
		 
	}
	
	public void prev(View view){
		if(count != 0){
			count-=1;
			 TextView question = (TextView) findViewById(R.id.questionText);
			 RadioButton ans1 = (RadioButton) findViewById(R.id.answer1);
			 RadioButton ans2 = (RadioButton) findViewById(R.id.answer2);
			 RadioButton ans3 = (RadioButton) findViewById(R.id.answer3); 
			 
			 question.setText(q.ultimateQuestion[count]);
			 ans1.setText(q.answers[count][0]);
			 ans2.setText(q.answers[count][1]);
			 ans3.setText(q.answers[count][2]);
		}
	}
	
	public void end(View view){
		Intent intent = new Intent(this, EndActivity.class);
		
		intent.putExtra(NAME, name);
		intent.putExtra(SURNAME, surname);
		intent.putExtra(SCORE, Integer.toString(score));
		startActivity(intent);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
