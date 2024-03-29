package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity2 extends AppCompatActivity {

	EditText UserName, Password, ConfirmPassword, Email;
	Button btn;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register2);

		UserName = findViewById(R.id.editTextRegUsername);
		Password = findViewById(R.id.editTextRegPassword);
		Email = findViewById(R.id.editTextRegEmail);
		ConfirmPassword = findViewById(R.id.editTextRegConfirmPassword);
		btn = findViewById(R.id.buttonRegisteration);
		tv = findViewById(R.id.textView3HaveAccount);
		DataBase db = new DataBase(getApplicationContext(), "HealthCare",null, 1);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String Username = UserName.getText().toString();
				String Pass_word = Password.getText().toString();
				String mail = Email.getText().toString();
				String Confirm_password = ConfirmPassword.getText().toString();
				if(Pass_word.equals(Confirm_password)){
					db.register(Username, mail, Pass_word);
					Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
					startActivity(new Intent(RegisterActivity2.this, LogginActivity.class));
				}else{
					Toast.makeText(getApplicationContext(), "Check Password", Toast.LENGTH_SHORT).show();
				}
				if(Username.length() == 0 || Pass_word.length()==0 || Confirm_password.length()==0 || mail.length()==0){
					Toast.makeText(getApplicationContext(), "Empty Credentials", Toast.LENGTH_SHORT).show();
				}else {
					Toast.makeText(getApplicationContext(), "Successful Registration", Toast.LENGTH_SHORT).show();
				}
			}
		});
		tv.setOnClickListener((new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(RegisterActivity2.this, LogginActivity.class));

			}
		}));


	}
}