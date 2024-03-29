package com.example.healthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
	public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase){
		String qry1 = "create table users(Username text, email text, password text)";
		sqLiteDatabase.execSQL(qry1);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

	}
	public void register(String username,String email, String Password){
		ContentValues cv = new ContentValues();
		cv.put("username", username);
		cv.put("mail", email);
		cv.put("password", Password);
		SQLiteDatabase db = getWritableDatabase();
		db.insert("users", null, cv);
		db.close();
	}
	public  int login(String username, String Password){
		int result =0;
		String str[]  = new String[2];
		str[0] = username;
		str[1] = Password;
		SQLiteDatabase db = getReadableDatabase();
		Cursor c = db.rawQuery("select * from users where username=?and Password=?", str);
		if (c.moveToFirst()){
			result=1;
		}
		return result;
	}
}
