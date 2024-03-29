package com.example.healthcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
		String Username = sharedpreferences.getString("Username", "").toString();
		Toast.makeText(getApplicationContext(), "Welcome"+Username, Toast.LENGTH_SHORT).show();

		CardView exit = findViewById(R.id.cardexit);
		exit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				SharedPreferences.Editor editor = sharedpreferences.edit();
				editor.clear();
				editor.apply();
				startActivity(new Intent(HomeActivity.this, LogginActivity.class));

			}
		});
		CardView FindDoctor = findViewById(R.id.cardFindDoctor);
		FindDoctor.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(HomeActivity.this, FindDoctorActivity2.class));
			}
		});

	}
}