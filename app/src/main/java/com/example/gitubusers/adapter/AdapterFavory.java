package com.example.gitubusers.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gitubusers.OnCrossClickedAction;
import com.example.gitubusers.R;
import com.example.gitubusers.model.User;
import com.example.gitubusers.viewHolder.ViewHolderFavory;

import java.util.ArrayList;

public class AdapterFavory extends RecyclerView.Adapter<ViewHolderFavory> {
    private ArrayList<User>listAdapterFavory;
    private OnCrossClickedAction onCrossClickedAction;

    public AdapterFavory(ArrayList<User> listAdapterFavory, OnCrossClickedAction onCrossClickedAction) {
        this.listAdapterFavory = listAdapterFavory;
        this.onCrossClickedAction = onCrossClickedAction;
    }

    public void setListAdapterFavory(ArrayList<User> listAdapterFavory) {
        this.listAdapterFavory = listAdapterFavory;
    }

    @NonNull
    @Override
    public ViewHolderFavory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.raw_favory,parent,false);
        return new ViewHolderFavory(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFavory holder, int position) {
        holder.bind(listAdapterFavory.get(position),onCrossClickedAction);
    }

    @Override
    public int getItemCount() {
        return listAdapterFavory.size();
    }
}
