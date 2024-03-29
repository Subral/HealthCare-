package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

	private String[][] Doctor_Details1={
			{"Doctor Name: Ajit Yadav", "Hospital Address:Lucknow", "Exp:5Years","Mobile No.:1234567890", "600"}
	};
	private String[][] Doctor_Details2={
			{"Doctor Name: Ajit Yadav", "Hospital Address:Lucknow", "Exp:5Years","Mobile No.:1234567890", "600"}
	};
	private String[][] Doctor_Details3={
			{"Doctor Name: Ajit Yadav", "Hospital Address:Lucknow", "Exp:5Years","Mobile No.:1234567890", "600"}
	};
	private String[][] Doctor_Details4={
			{"Doctor Name: Ajit Yadav", "Hospital Address:Lucknow", "Exp:5Years","Mobile No.:1234567890", "600"}
	};
	private String[][] Doctor_Details5={
			{"Doctor Name: Ajit Yadav", "Hospital Address:Lucknow", "Exp:5Years","Mobile No.:1234567890", "600"}
	};

	TextView tv;
		String[][] doctor_details={};
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctor_details);
		tv = findViewById(R.id.textView3DDTitle);
		btn = findViewById(R.id.buttonback);
		HashMap<String,String> item;
		ArrayList list;
		SimpleAdapter sa;

		Intent it = getIntent();
		String title = it.getStringExtra("title");
		tv.setText(title);

		if(title.compareTo("Family physicion")==0){
			doctor_details = Doctor_Details1;
		}
		else if(title.compareTo("Dietcion")==0){
			doctor_details = Doctor_Details2;
		}
		else if(title.compareTo("Dentist")==0){
			doctor_details = Doctor_Details3;
		}
		else if(title.compareTo("Surgeon")==0){
			doctor_details = Doctor_Details4;
		}
		else if(title.compareTo("Cardiologist")==0){
			doctor_details = Doctor_Details5;
		}

		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity2.class));
			}
		});

		list = new ArrayList();
		for(int i=0;i<doctor_details.length;i++){
			item = new HashMap<String, String>();
			item.put("line1", doctor_details[i][0]);
			item.put("line5", "cons fee"+doctor_details[i][4]+"/-");
			list.add(item);
		}
		sa = new SimpleAdapter(this,list,R.layout.multi_lines,
				new String []{"Line1","Line2","Line3","Line4","Line5",},
					new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
				);
		ListView lst = findViewById(R.id.ListviewDD);
		lst.setAdapter(sa);

	}
}