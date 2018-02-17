package com.example.riza.projekiak;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PesanWrBurger(View view) {
        Intent InfoBurger = new Intent(MainActivity.this, burgerActivity.class);
        startActivity(InfoBurger);
    }

    public void callWarung(View view) {
        String nomortelepon = "7724567";
        Intent dialPhone = new Intent(Intent.ACTION_DIAL);
        dialPhone.setData(Uri.parse("tel:" + nomortelepon));
        startActivity(dialPhone);
    }

    public void mapsBurger(View view) {
    }
}
