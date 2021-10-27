package com.example.gitubusers.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gitubusers.OnImageClickedAction;
import com.example.gitubusers.R;
import com.example.gitubusers.model.User;
import com.example.gitubusers.viewHolder.ViewHolderUser;

import java.util.ArrayList;

public class AdapterUser extends RecyclerView.Adapter<ViewHolderUser> {
    private ArrayList<User>listAdapterUser;
    private OnImageClickedAction onImageClickedAction;

    public AdapterUser(ArrayList<User> listAdapterUser, OnImageClickedAction onImageClickedAction) {
        this.listAdapterUser = listAdapterUser;
        this.onImageClickedAction = onImageClickedAction;
    }

    public void setListAdapterUser(ArrayList<User> listAdapterUser) {
        this.listAdapterUser = listAdapterUser;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderUser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.raw_list,parent,false);
        return new ViewHolderUser(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUser holder, int position) {
        holder.bind(listAdapterUser.get(position),onImageClickedAction);
    }

    @Override
    public int getItemCount() {
        return listAdapterUser.size();
    }
}
