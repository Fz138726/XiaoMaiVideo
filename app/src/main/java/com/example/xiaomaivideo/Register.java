package com.example.xiaomaivideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.util.Log;

import com.example.xiaomaivideo.service.UserService;

public class Register extends AppCompatActivity {

    private Button mbtnRes;//注册按钮
    private ImageButton Ibtnback;//返回按钮
    private EditText username;//用户名输入框
    private EditText password;//密码输入框
    private EditText confirm;//确认密码输入框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mbtnRes=findViewById(R.id.btn_resgister);
        Ibtnback=findViewById(R.id.btn_back);
        username=findViewById(R.id.et_User);
        password=findViewById(R.id.et_password);
        confirm=findViewById(R.id.et_again);
        Ibtnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Register.this,MainActivity.class);
                //整合的时候跳转到登陆界面
                startActivity(intent);
            }
        });
        mbtnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=username.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String again=confirm.getText().toString().trim();
                if(!pass.equals(again)){
                    Toast.makeText(Register.this,"验证密码不正确",Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    UserService userService=new UserService(Register.this);
                    boolean flag_name=userService.queryName(name);
                    if(flag_name==true){
                        Toast.makeText(Register.this,"用户名重复",Toast.LENGTH_SHORT).show();
                    }else{
                        User user=new User();
                        user.setUsername(name);
                        user.setPassword(pass);
                        userService.register(user);
                        Toast.makeText(Register.this, "注册成功", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(Register.this,LoginActivity.class);
                        //整合的时候跳转到登陆界面
                        startActivity(intent);
                    }
                }

            }
        });

    }

}