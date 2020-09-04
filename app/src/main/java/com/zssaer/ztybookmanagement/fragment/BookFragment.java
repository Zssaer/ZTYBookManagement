package com.zssaer.ztybookmanagement.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zssaer.ztybookmanagement.MainActivity;
import com.zssaer.ztybookmanagement.R;
import com.zssaer.ztybookmanagement.adapter.BookCardRecordAdapter;
import com.zssaer.ztybookmanagement.add.BookAdd;
import com.zssaer.ztybookmanagement.bean.Book;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class BookFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private BookCardRecordAdapter mAdapter;
    private Handler mHandler;
    private int page = 1;
    private View view;
    private List<Book> bookList = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;

    private boolean isCreated=false;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.book_fragment,container,false);
        Toast.makeText(getContext(), "下拉列表刷新数据", Toast.LENGTH_SHORT).show();
        FloatingActionButton fab =(FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), BookAdd.class);
                startActivity(intent);
            }
        });

        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
                MainActivity activity= (MainActivity) getActivity();
                activity.BookreLoadFragView();
            }
        });
        mRecyclerView = (RecyclerView)view.findViewById(R.id.card_list);
        mRecyclerView.setHasFixedSize(true);
        bookList= LitePal.findAll(Book.class);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter=new BookCardRecordAdapter(bookList);
        mAdapter.setOnItemClickListener(new BookCardRecordAdapter.OnItemClickListener(){

            @Override
            public void onClick(int position) {
                Toast.makeText(getContext(), "click " + position, Toast.LENGTH_SHORT).show();
            }
        });
        mAdapter.setOnItemLongClickListener(new BookCardRecordAdapter.OnItemLongClickListener() {
            @Override
            public void onClick(final int position) {
                AlertDialog alertDialog=new AlertDialog.Builder(getContext())
                        .setTitle("图书管理")
                        .setMessage("请选择对其图书的操作！")
                        .setPositiveButton(" 删除", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SQLiteDatabase db = LitePal.getDatabase();
                                LitePal.deleteAll(Book.class,"name = ?",bookList.get(position).getName());
                                Toast.makeText(getContext(), "删除图书成功", Toast.LENGTH_SHORT).show();
                                refresh();
                                MainActivity activity= (MainActivity) getActivity();
                                activity.BookreLoadFragView();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(), "取消操作成功", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("编辑", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(), "...", Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                alertDialog.show();
            }
        });
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }
    private void refresh(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }


}
