package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_WebServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_web_services);

        Button btnPosts = (Button) findViewById(R.id.btn1);

        btnPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent (Menu_WebServices.this,MainActivity.class);
                startActivity(i);
            }
        });

        Button btnComments = (Button) findViewById(R.id.btn2);

        btnComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent (Menu_WebServices.this,WebServicesComements.class);
                startActivity(i);
            }
        });

        Button btnAlbums = (Button) findViewById(R.id.button5);

        btnAlbums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent (Menu_WebServices.this,WebServicesAlbums.class);
                startActivity(i);
            }
        });

        Button btnUsers = (Button) findViewById(R.id.btn4);

        btnUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent (Menu_WebServices.this,WebServicesUsers.class);
                startActivity(i);
            }
        });

        
    }
}