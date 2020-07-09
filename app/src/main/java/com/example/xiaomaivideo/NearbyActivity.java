package com.example.xiaomaivideo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NearbyActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnMain;
    private Button mBtnMessage;
    private Button mBtnMe;
    private ImageButton mBtnUpload;

    private ViewPager viewPager;
    private TextView followers;
    private TextView neighbors;
    private ArrayList<View> pageView;
    //滚动条图片
    private ImageView scrollbar;
    //滚动条初始偏移量
    private int offset = 0;
    //当前页编号
    private int currentIndex=0;
    //滚动条宽度
    private int bmpW;
    //一倍滚动量
    private int one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);
        mBtnMain=findViewById(R.id.btn_main);
        mBtnMessage=findViewById(R.id.btn_message);
        mBtnMe=findViewById(R.id.btn_me);
        mBtnUpload=findViewById(R.id.btn_upload);

        mBtnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NearbyActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NearbyActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
        mBtnMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NearbyActivity.this,MeActivity.class);
                startActivity(intent);
            }
        });
        mBtnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NearbyActivity.this,UploadVideoActivity.class);
                startActivity(intent);
            }
        });

        viewPager=findViewById(R.id.viewpager);
        //LayoutInflater.inflate用于查找布局文件
        LayoutInflater inflater=getLayoutInflater();
        View view1=inflater.inflate(R.layout.follower,null);
        View view2=inflater.inflate(R.layout.neighborhood,null);
        followers=findViewById(R.id.follower_id);
        neighbors=findViewById(R.id.neighbor_id);
        scrollbar=findViewById(R.id.scrollbar);
        followers.setOnClickListener(this);
        neighbors.setOnClickListener(this);
        pageView =new ArrayList<View>();
        //添加要切换的界面
        pageView.add(view1);
        pageView.add(view2);
        //数据适配器
        PagerAdapter mPagerAdapter=new PagerAdapter() {
            @Override
            //获取当前窗体界面数
            public int getCount() {
                return pageView.size();
            }

            @Override
            //判断是否由对象生成界面
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }

            //使从ViewGroup中移出当前View
            public void destroyItem(View arg0, int arg1, Object arg2) {
                ((ViewPager) arg0).removeView(pageView.get(arg1));
            }

            //返回一个对象，这个对象表明了PagerAdapter适配器选择哪个对象放在当前的ViewPager中
            public Object instantiateItem(View arg0, int arg1){
                ((ViewPager)arg0).addView(pageView.get(arg1));
                return pageView.get(arg1);
            }
        };
        //绑定适配器
        viewPager.setAdapter(mPagerAdapter);
        //设置viewPager的初始界面为第一个界面
        viewPager.setCurrentItem(0);
        //添加切换界面的监听器
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());
        // 获取滚动条的宽度
        bmpW= BitmapFactory.decodeResource(getResources(),R.drawable.scrollbar).getWidth();
        //为了获取屏幕宽度，新建一个DisplayMetrics对象
        DisplayMetrics displayMetrics = new DisplayMetrics();
        //将当前窗口的一些信息放在DisplayMetrics类中
        //getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //得到屏幕的宽度
        int screenW = displayMetrics.widthPixels;
        //计算出滚动条初始的偏移量
        offset = (screenW / 2 - bmpW) / 2;
        //计算出切换一个界面时，滚动条的位移量
        one = offset * 2 + bmpW;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        //将滚动条的初始位置设置成与左边界间隔一个offset
        scrollbar.setImageMatrix(matrix);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.follower_id:
                //点击时切换到第一页
                viewPager.setCurrentItem(0);
                break;
            case R.id.neighbor_id:
                //点击时切换到第二页
                viewPager.setCurrentItem(1);
                break;
        }
    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Animation animation = null;
            switch (position) {
                case 0:
                    animation = new TranslateAnimation(one, 0, 0, 0);
                    break;
                case 1:
                    animation = new TranslateAnimation(offset, one, 0, 0);
                    break;
            }
            //arg0为切换到的页的编码
            currentIndex = position;
            // 将此属性设置为true可以使得图片停在动画结束时的位置
            assert animation != null;
            animation.setFillAfter(true);
            //动画持续时间，单位为毫秒
            animation.setDuration(200);
            //滚动条开始动画
            scrollbar.startAnimation(animation);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}