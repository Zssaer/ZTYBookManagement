package com.zssaer.ztybookmanagement.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zssaer.ztybookmanagement.R;
import com.zssaer.ztybookmanagement.bean.Book;
import com.zssaer.ztybookmanagement.holder.BookViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 图书适配器
 */
public class BookCardRecordAdapter extends RecyclerView.Adapter<BookViewHolder> {
    private List<Book> bookList;
    View bookView;

    public BookCardRecordAdapter(List<Book> bookList) {
        this.bookList=bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.holder_book,parent,false);

        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, final int position) {
        Book book = bookList.get(position);
        holder.vName.setText(book.getName());
        holder.vAuthor.setText(book.getAuthor());
        holder.vAbout.setText(book.getAbout());
        holder.vPrice.setText("售价:"+(int) book.getPrice()+"元");
        holder.vPages.setText("页数:"+(int) book.getPages()+"页");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longClickListener != null) {
                    longClickListener.onClick(position);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    //第一步 定义接口
    public interface OnItemClickListener {
        void onClick(int position);
    }

    private OnItemClickListener listener;

    //第二步， 写一个公共的方法
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public interface OnItemLongClickListener {
        void onClick(int position);
    }

    private OnItemLongClickListener longClickListener;

    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

}
