package com.tejas.womensafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class HelplineNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline_number);
    }
public void f1(View view){
    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:1091"));
    startActivity(intent);
}
public void f2(View view){
    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:181"));
    startActivity(intent);
}
public void f3(View view){
    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:100"));
    startActivity(intent);
}
public void f4(View view){
    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:1098"));
    startActivity(intent);
}
    public void f5(View view){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:108"));
        startActivity(intent);
    }
    public void f6(View view){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:101"));
        startActivity(intent);
    }
    public void back(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}