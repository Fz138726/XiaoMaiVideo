package com.example.xiaomaivideo.service;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.xiaomaivideo.User;
public class UserService {
    private DatabaseHelper dbHelper;
    public UserService(Context context){
        dbHelper=new DatabaseHelper(context);
    }

    public boolean login(String username,String password){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="select * from user where username=? and password=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username,password});
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;
    }
    public boolean register(User user){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String register_user="insert into user(username,password) values(?,?)";
        Object obj[]={user.getUsername(),user.getPassword()};
        sdb.execSQL(register_user, obj);
        return true;
    }
    public boolean queryName(String username){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String user_name_query="select * from user where username=?";
        Cursor cursor=sdb.rawQuery(user_name_query,new String[]{username});
        if(cursor.moveToFirst()==true){
            cursor.close();
        return true;}
        return false;
    }//用于验证没有重复的用户名，重复名会提示注册失败
}
