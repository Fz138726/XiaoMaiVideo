package com.example.xiaomaivideo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button mBtnMain;
    private Button mBtnNearby;
    private Button mBtnMessage;
    private Button mBtnMe;
    private ImageButton mBtnUpload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnMain=findViewById(R.id.btn_main);
        mBtnNearby=findViewById(R.id.btn_nearby);
        mBtnMessage=findViewById(R.id.btn_message);
        mBtnMe=findViewById(R.id.btn_me);
        mBtnUpload=findViewById(R.id.btn_upload);

        mBtnMain.setOnClickListener(onClickListener);
        mBtnNearby.setOnClickListener(onClickListener);
        mBtnMessage.setOnClickListener(onClickListener);
        /*mBtnMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果未登录，跳转到MeFragment；已登录→LoggedinFragment
            }
        });*/
        mBtnMe.setOnClickListener(onClickListener);

        mBtnUpload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,UploadVideoActivity.class);
                startActivity(intent);
            }
        });

        MainFragment mainFragment=new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl,mainFragment).commitAllowingStateLoss();

        int id=getIntent().getIntExtra("id",0);
        if (id==1){
            LoggedinFragment loggedinFragment=new LoggedinFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fl,loggedinFragment).commitAllowingStateLoss();
        }
    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            Fragment f=null;
            switch (view.getId()){
                case R.id.btn_main:
                    f=new MainFragment();
                    break;
                case R.id.btn_nearby:
                    f=new NearbyFragment();
                    break;
                case R.id.btn_message:
                    f=new MessageFragment();
                    break;
                case R.id.btn_me:
                    f=new MeFragment();
                    break;
                default:
                    break;
            }
            ft.replace(R.id.fl,f);
            ft.commitAllowingStateLoss();
        }
    };
}