package com.example.xiaomaivideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button mBtnNearby;
    private Button mBtnMessage;
    private Button mBtnMe;
    private ImageButton mBtnUpload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnNearby=findViewById(R.id.btn_nearby);
        mBtnMessage=findViewById(R.id.btn_message);
        mBtnMe=findViewById(R.id.btn_me);
        mBtnUpload=findViewById(R.id.btn_upload);

        mBtnNearby.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,NearbyActivity.class);
                startActivity(intent);
            }
        });
        mBtnMessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
        mBtnMe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MeActivity.class);
                startActivity(intent);
            }
        });
        mBtnUpload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,UploadVideoActivity.class);
                startActivity(intent);
            }
        });
    }
}