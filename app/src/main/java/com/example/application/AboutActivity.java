package com.example.application;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AboutActivity extends Activity {

    public static String Name = "Name";
    public static String LastName = "LastName";
    public static String Email = "Email";
    public static String Phone = "Phone";
    public static  String Age = "Age";

    EditText et_user_name, et_user_lastname, et_user_age, et_user_email, et_user_phone;
    Editor editor;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        sharedPreferences = getPreferences(MODE_PRIVATE);
        editor = sharedPreferences.edit();
        et_user_name = findViewById(R.id.et_user_name);
        et_user_lastname = findViewById(R.id.et_user_lastname);
        et_user_age = findViewById(R.id.et_user_age);
        et_user_email = findViewById(R.id.et_user_email);
        et_user_phone = findViewById(R.id.et_user_phone);
        setInfo();
    }


    public void saveInfo(View view){
        editor.putString(Name, String.valueOf(et_user_name.getText()));
        editor.putString(LastName, String.valueOf(et_user_lastname.getText()));
        editor.putString(Age, String.valueOf(et_user_age.getText()));
        editor.putString(Email, String.valueOf( et_user_email.getText()));
        editor.putString(Phone, String.valueOf(et_user_phone.getText()));
        editor.commit();

    }

    public void setInfo(){
        et_user_name.setText(sharedPreferences.getString(Name, ""));
        et_user_lastname.setText(sharedPreferences.getString(LastName, ""));
        et_user_phone.setText(sharedPreferences.getString(Phone, ""));
        et_user_age.setText(sharedPreferences.getString(Age,""));
        et_user_email.setText(sharedPreferences.getString(Email, ""));
        editor.clear();
        editor.commit();
    }

    public void transferToMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Name, et_user_name.getText().toString());
        intent.putExtra(LastName, et_user_lastname.getText().toString());
        startActivity(intent);
    }
}

