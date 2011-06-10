/**
 * Copyright 2011 Saurabh Gangarde & Rohit Ghatol (http://code.google.com/p/droidtwit/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.tutorial.service;

import com.tutorial.service.services.simple.SimpleService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SimpleServiceExample extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_service);
		final EditText valueEditText = (EditText) findViewById(R.id.value_edittext);
		Button addButton = (Button) findViewById(R.id.add_button);
		Button substractButton = (Button) findViewById(R.id.substract_button);
		

			addButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					try {
						final int value = Integer.valueOf(valueEditText.getText()
								.toString());
						Intent serviceIntent = new Intent(getApplicationContext(), SimpleService.class);
						serviceIntent.putExtra("Action", "add");
						serviceIntent.putExtra("Data", value);
						startService(serviceIntent);
					} catch (NumberFormatException ex) {
						valueEditText.setText("");
					}

				}
			});

			substractButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					try {
						final int value = Integer.valueOf(valueEditText.getText()
								.toString());
						Intent serviceIntent = new Intent(getApplicationContext(), SimpleService.class);
						serviceIntent.putExtra("Action", "substract");
						serviceIntent.putExtra("Data", value);
						startService(serviceIntent);

					} catch (NumberFormatException ex) {
						valueEditText.setText("");
					}

				}
			});
		

	}
}