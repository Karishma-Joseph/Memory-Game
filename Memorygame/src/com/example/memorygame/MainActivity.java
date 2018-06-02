package com.example.memorygame;



import android.app.Activity;
import java.util.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageButton imageButton[] = new ImageButton[9];
	Button button1;
	TextView textview;
	String mix[]={"tyrion","sansa","daenerys","jaime","cersei","arya","bran","sam","jon"};
	String ques[]={"tyrion","sansa","daenerys","jaime","cersei","arya","bran","sam","jon"};
	int i = (int )(Math.random() * 8 + 0);
	int x;
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ShuffleArray(mix);
		
		
		addListenerOnButton();
		
		

	}
	public void addListenerOnButton() {
		
		textview = (TextView) findViewById(R.id.textview);
		button1 = (Button) findViewById(R.id.button1);
		
		imageButton[0] = (ImageButton) findViewById(R.id.imageButton1);
		imageButton[1] = (ImageButton) findViewById(R.id.imageButton2);
		imageButton[2] = (ImageButton) findViewById(R.id.imageButton3);
		imageButton[3] = (ImageButton) findViewById(R.id.imageButton4);
		imageButton[4] = (ImageButton) findViewById(R.id.imageButton5);
		imageButton[5] = (ImageButton) findViewById(R.id.imageButton6);
		imageButton[6] = (ImageButton) findViewById(R.id.imageButton7);
		imageButton[7] = (ImageButton) findViewById(R.id.imageButton8);
		imageButton[8] = (ImageButton) findViewById(R.id.imageButton9);
		
        for(x=0;x<9;x++)
        {
		int resID = getResources().getIdentifier(mix[x], "drawable", "com.example.memorygame");
		imageButton[x].setImageResource(resID);
        }
		

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				//Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mkyong.com"));
				//startActivity(browserIntent);
		
				textview.setVisibility(View.VISIBLE);
				textview.setText(ques[i]);
				
				for(x=0;x<9;x++)
				{
					imageButton[x].setImageResource(R.drawable.card);
				}
				
				
			}
			
		});
		
		
		
		imageButton[0].setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        check(0);
		    }
		});
		imageButton[1].setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        check(1);
		    }
		});
		
		imageButton[2].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				check(2);
			}
		});
		imageButton[3].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				check(3);
			}
		});
		imageButton[4].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				check(4);
			}
		});
		imageButton[5].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				check(5);
			}
		});
		imageButton[6].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				check(6);
			}
		});
		imageButton[7].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				check(7);
			}
		});
		imageButton[8].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				check(8);
			}
		});
		
	}
	   
	
		
	
		
		
	
	public void check(int n) {

		 

		if(mix[n].equals(ques[i])) 
		{
			int resID1 = getResources().getIdentifier(ques[i], "drawable", "com.example.memorygame");
			imageButton[n].setImageResource(resID1);
		}
		 else
		 {
			 Toast.makeText(MainActivity.this,
					"OOPS! Wrong answer", Toast.LENGTH_SHORT).show();

		 }

	}
	
	private void ShuffleArray(String[] array)
	{
	    int index;
	    String temp;
	    Random random = new Random();
	    for (int i = mix.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = mix[index];
	        mix[index] = mix[i];
	        mix[i] = temp;
	    }
	}
}