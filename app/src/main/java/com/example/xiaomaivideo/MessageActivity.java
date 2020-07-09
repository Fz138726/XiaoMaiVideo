package com.example.xiaomaivideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MessageActivity extends AppCompatActivity {

    private Button mBtnMain;
    private Button mBtnNearby;
    private Button mBtnMe;
    private ImageButton mBtnUpload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        mBtnMain=findViewById(R.id.btn_main);
        mBtnNearby=findViewById(R.id.btn_nearby);
        mBtnMe=findViewById(R.id.btn_me);
        mBtnUpload=findViewById(R.id.btn_upload);

        mBtnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MessageActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        mBtnNearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MessageActivity.this,NearbyActivity.class);
                startActivity(intent);
            }
        });
        mBtnMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MessageActivity.this,MeActivity.class);
                startActivity(intent);
            }
        });
        mBtnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MessageActivity.this,UploadVideoActivity.class);
                startActivity(intent);
            }
        });
    }
}