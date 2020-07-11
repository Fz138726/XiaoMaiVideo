package com.example.xiaomaivideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xiaomaivideo.service.UserService;

public class LoginActivity extends AppCompatActivity {
    private Button mBtnButton;
    private EditText username;
    private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mBtnButton=findViewById(R.id.btn_login);
        username=findViewById(R.id.et_username);
        pass=findViewById(R.id.et_pass);
        mBtnButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String password=pass.getText().toString();
                UserService userService=new UserService(LoginActivity.this);
                boolean flag=userService.login(user,password);
                if(flag==true){
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent();
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setClass(LoginActivity.this,MainActivity.class);
                    intent.putExtra("id",1);
                    startActivity(intent);}else{
                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}