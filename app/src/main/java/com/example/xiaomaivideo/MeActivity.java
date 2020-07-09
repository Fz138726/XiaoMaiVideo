package com.example.xiaomaivideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MeActivity extends AppCompatActivity {
    private Button mBtnMain;
    private Button mBtnNearby;
    private Button mBtnMessage;
    private ImageButton mBtnUpload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        mBtnMain=findViewById(R.id.btn_main);
        mBtnNearby=findViewById(R.id.btn_nearby);
        mBtnMessage=findViewById(R.id.btn_message);
        mBtnUpload=findViewById(R.id.btn_upload);

        mBtnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        mBtnNearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MeActivity.this,NearbyActivity.class);
                startActivity(intent);
            }
        });
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MeActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
        mBtnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MeActivity.this,UploadVideoActivity.class);
                startActivity(intent);
            }
        });
    }
}