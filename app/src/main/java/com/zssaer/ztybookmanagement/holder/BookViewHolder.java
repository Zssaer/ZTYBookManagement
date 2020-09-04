package com.zssaer.ztybookmanagement.holder;

import android.view.View;
import android.widget.TextView;

import com.zssaer.ztybookmanagement.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookViewHolder extends RecyclerView.ViewHolder {
    public TextView vName;
    public TextView vAuthor;
    public TextView vAbout;
    public TextView vPrice;
    public TextView vPages;

    public BookViewHolder(@NonNull View itemView) {
        super(itemView);
        vName=itemView.findViewById(R.id.name);
        vAuthor=itemView.findViewById(R.id.author);
        vAbout=itemView.findViewById(R.id.about);
        vPrice=itemView.findViewById(R.id.price);
        vPages=itemView.findViewById(R.id.pages);
    }

}
