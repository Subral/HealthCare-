package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FindDoctorActivity2 extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_doctor2);

		CardView exit = findViewById(R.id.FDBack);
		exit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(FindDoctorActivity2.this, HomeActivity.class));
			}
		});

		CardView familyphisicion = findViewById(R.id.FDfamily);
		familyphisicion.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent it = new Intent(FindDoctorActivity2.this, DoctorDetailsActivity.class);
				it.putExtra("title", "Family Physicians");
				startActivity(it);
			}
		});

		CardView deitecion = findViewById(R.id.FDDeiticion);
		deitecion.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent it = new Intent(FindDoctorActivity2.this, DoctorDetailsActivity.class);
				it.putExtra("title", "Dietcion");
				startActivity(it);
			}
		});

		CardView dentist = findViewById(R.id.FDDentist);
		dentist.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent it = new Intent(FindDoctorActivity2.this, DoctorDetailsActivity.class);
				it.putExtra("title", "Dentist");
				startActivity(it);
			}
		});

		CardView surgeon = findViewById(R.id.FDsurgeon);
		surgeon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent it = new Intent(FindDoctorActivity2.this, DoctorDetailsActivity.class);
				it.putExtra("title", "Surgeon");
				startActivity(it);
			}
		});

		CardView cardiologist = findViewById(R.id.FDCardiologists);
		cardiologist.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent it = new Intent(FindDoctorActivity2.this, DoctorDetailsActivity.class);
				it.putExtra("title", "Cardiologist");
				startActivity(it);
			}
		});

	}
}