package com.example.healthcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.usb.UsbRequest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogginActivity extends AppCompatActivity {

	EditText edUsername, edPassword;
	Button btn;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loggin);

		edUsername = findViewById(R.id.editTextLoginUsername);
		edPassword = findViewById(R.id.editTextLoginPassword);
		btn = findViewById(R.id.buttonLogin);
		tv = findViewById(R.id.textView3Newuser);
		DataBase db = new DataBase(getApplicationContext(), "HealthCare", null, 1);

		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String Username = edUsername.getText().toString();
				String Password = edPassword.getText().toString();
				if(Username.length() == 0 || Password.length()==0){
					Toast.makeText(getApplicationContext(), "Empty Credentials", Toast.LENGTH_SHORT).show();
				}else {
					if(db.login(Username, Password)==1){
						SharedPreferences sharedpreferences =  getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
						SharedPreferences.Editor editor = sharedpreferences.edit();
						editor.putString("username", Username);
						editor.apply();
						Toast.makeText(getApplicationContext(), "Successful Login", Toast.LENGTH_SHORT).show();
						startActivity(new Intent(LogginActivity.this, HomeActivity.class));
					}else{
						Toast.makeText(getApplicationContext(), "Invalid User", Toast.LENGTH_SHORT).show();
					}

				}
				btn.setOnClickListener((new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						startActivity(new Intent(LogginActivity.this, HomeActivity.class));

					}
				}));
			}
		});

		tv.setOnClickListener((new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(LogginActivity.this, RegisterActivity2.class));

			}
		}));
	}
}