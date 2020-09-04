package com.zssaer.ztybookmanagement;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zssaer.ztybookmanagement.bean.Admin;
import com.zssaer.ztybookmanagement.bean.Book;

import org.litepal.LitePal;

import java.util.List;

/**
 * 登录界面
 */
public class Login extends AppCompatActivity {
    private Button Login;
    private Button register;
    private EditText name;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //判断Api是否为5.0以上
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //隐藏原状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        //初始化应用
        init();
        SQLiteDatabase db = LitePal.getDatabase();
        //用户注册
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String PassWord = password.getText().toString();
                List<Admin> admins=LitePal.where("name = ?",Name).find(Admin.class);
                if (!admins.isEmpty()){
                    Toast.makeText(Login.this, "该用户名已经注册，请重新注册！", Toast.LENGTH_SHORT).show();
                }else{
                    Admin admin=new Admin(Name,PassWord);
                    admin.save();
                    Toast.makeText(Login.this, "注册成功，请登录！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //用户登录
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String PassWord = password.getText().toString();
                List<Admin> admins=LitePal.where("name = ?",Name).find(Admin.class);
                if (!admins.isEmpty()){
                    Admin admin=admins.get(0);
                    if (PassWord.equals(admin.getPassword())){
                        String data=Name;
                        Intent intent=new Intent(Login.this,MainActivity.class);
                        intent.putExtra("data",data);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(Login.this, "用户密码输入错误，请重新尝试后登录！", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Login.this, "该用户不存在，请注册！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        Login = (Button) findViewById(R.id.login);
        register =(Button) findViewById(R.id.register);
        name = (EditText) findViewById(R.id.name);
        password = (EditText)findViewById(R.id.password);
    }
}
