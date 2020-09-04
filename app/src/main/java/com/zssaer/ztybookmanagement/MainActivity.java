package com.zssaer.ztybookmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zssaer.ztybookmanagement.fragment.AboutFragment;
import com.zssaer.ztybookmanagement.fragment.AdminFragment;
import com.zssaer.ztybookmanagement.fragment.BookFragment;
import com.zssaer.ztybookmanagement.fragment.UserFragment;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity {
    private TextView name_login;
    private Button book_button;
    private Button order_button;
    private Button about_button;
    private Button admin_button;
    private FloatingActionButton drawer_show;
    private DrawerLayout drawerLayout;

    private BookFragment bookFragment;
    private UserFragment orderFragment;
    private AboutFragment aboutFragment;
    private AdminFragment adminFragment;
    private Fragment mContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //隐藏原状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        final Intent intent=getIntent();
        String name=intent.getStringExtra("data");
        //初始化应用
        init();
        name_login.setText(name+"欢迎你！");

        aboutFragment=new AboutFragment();
        mContent = aboutFragment;
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.content_frame, aboutFragment);
        ft.commit();
        //切换图书界面
        book_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookFragment = new BookFragment();
                switchContent(bookFragment);
                drawerLayout.closeDrawers();

            }
        });
        order_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderFragment = new UserFragment();
                switchContent(orderFragment);
                drawerLayout.closeDrawers();
            }
        });
        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutFragment = new AboutFragment();
                switchContent(aboutFragment);
                drawerLayout.closeDrawers();
            }
        });
        admin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminFragment= new AdminFragment();
                switchContent(adminFragment);
                drawerLayout.closeDrawers();
            }
        });
        drawer_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 点击按钮打开侧滑菜单
                    drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    private void init(){
        name_login=(TextView) findViewById(R.id.name_main);
        book_button=(Button)findViewById(R.id.book_button);
        order_button=(Button)findViewById(R.id.order_book);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        about_button=(Button) findViewById(R.id.abuout);
        admin_button=(Button)findViewById(R.id.user_info);
        drawer_show=(FloatingActionButton)findViewById(R.id.drawer_show);
    }

    /**
     * 修改显示的内容 不会重新加载
     **/
    public void switchContent(Fragment to) {
        if (mContent != to) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.hide(mContent).add(R.id.content_frame, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(mContent).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
            mContent = to;
        }
    }
    /*重新加载Book布局*/
    public void BookreLoadFragView(){
        bookFragment = new BookFragment();
        switchContent(bookFragment);
    }



}
