package com.GoTo.app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.beardedhen.androidbootstrap.BootstrapEditText;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView headerText;
	private RadioButton oneWay;
	private RadioButton rturn;
	private RadioButton custom;
	private Spinner fromStations;
	private Spinner toStations;
	private ImageButton calendarButton;
	private BootstrapEditText timeEditText;
	private BootstrapEditText dateEditText;
	private Button takeMe;
	
	private TableLayout table;
	private TableRow tablerow1,tablerow2,tablerow3,tablerow4,tablerow5,tablerow6;
	private TextView minutes,arrival,line,operator,cost;
	private TextView minutesRow1,minutesRow2,minutesRow3,minutesRow4,minutesRow5;
	private TextView arrivalRow1,arrivalRow2,arrivalRow3,arrivalRow4,arrivalRow5;
	private TextView lineRow1,lineRow2,lineRow3,lineRow4,lineRow5;
	private TextView operatorRow1,operatorRow2,operatorRow3,operatorRow4,operatorRow5;
	private TextView costRow1,costRow2,costRow3,costRow4,costRow5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

	    //Remove title bar
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		
		headerText = (TextView)findViewById(R.id.headerTxt);
		oneWay = (RadioButton)findViewById(R.id.oneWayButton);
		rturn = (RadioButton)findViewById(R.id.returnButton);
		custom = (RadioButton)findViewById(R.id.customButton);
		dateEditText = (BootstrapEditText)findViewById(R.id.dateEditText);
		
		//Drop Down Boxes
		fromStations = (Spinner)findViewById(R.id.fromSpinner);
		toStations = (Spinner)findViewById(R.id.toSpinner);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.fromStations, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		fromStations.setAdapter(adapter);
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
		        R.array.toStations, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		toStations.setAdapter(adapter2);
		//**
		
		//Date Box
		timeEditText = (BootstrapEditText)findViewById(R.id.timeEditText);
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	    timeEditText.setText(timeFormat.format(new Date()));
		
		calendarButton = (ImageButton)findViewById(R.id.calendarButton);
		calendarButtonClick();
		
		//TABLE
		table = (TableLayout)findViewById(R.id.stationTable);
		tablerow1 = (TableRow)findViewById(R.id.tableRow1);
		minutes = (TextView)findViewById(R.id.minutes);
		arrival = (TextView)findViewById(R.id.arrival);
		line = (TextView)findViewById(R.id.line);
		operator = (TextView)findViewById(R.id.operator);
		cost = (TextView)findViewById(R.id.cost);

		tablerow2 = (TableRow)findViewById(R.id.tableRow2);
		minutesRow1 = (TextView)findViewById(R.id.minutes1);
		arrivalRow1 = (TextView)findViewById(R.id.arrival1);
		lineRow1 = (TextView)findViewById(R.id.line1);
		operatorRow1 = (TextView)findViewById(R.id.operator1);
		costRow1 = (TextView)findViewById(R.id.cost1);

		tablerow3 = (TableRow)findViewById(R.id.tableRow3);
		tablerow4 = (TableRow)findViewById(R.id.tableRow4);
		tablerow5 = (TableRow)findViewById(R.id.tableRow5);
		tablerow6 = (TableRow)findViewById(R.id.tableRow6);

		takeMe = (Button)findViewById(R.id.takeMeButton);
		takeMeClick();
	}
	
	private void calendarButtonClick() {
		
		calendarButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				dateEditText.setVisibility(View.VISIBLE);
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			    dateEditText.setText(dateFormat.format(new Date()));
			}
			
		});
	}

	private void takeMeClick() {
		
		takeMe.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				
				table.setVisibility(View.VISIBLE);
				minutesRow1.setText("30");
				arrivalRow1.setText("30");
				lineRow1.setText("Komercijala");
				operatorRow1.setText("Centrotrans");
				costRow1.setText("2.3");
			}
			
		});
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
