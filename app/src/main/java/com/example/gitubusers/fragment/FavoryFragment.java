package com.example.gitubusers.fragment;

import static com.example.gitubusers.activities.MainActivity.FAVORITE_LIST_KEY;
import static com.example.gitubusers.activities.MainActivity.USER_LIST_KEY;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gitubusers.OnImageClickedAction;
import com.example.gitubusers.R;
import com.example.gitubusers.SharedPreferencesManager;
import com.example.gitubusers.adapter.AdapterFavory;
import com.example.gitubusers.adapter.AdapterUser;
import com.example.gitubusers.model.User;

import java.util.ArrayList;

public class FavoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private AdapterFavory adapterFavory;
    private ArrayList<User> ListFavory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_list_favory, container, false);

    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListFavory = new ArrayList<User>(SharedPreferencesManager.getInstance(FavoryFragment.this.getContext()).getUserList(FAVORITE_LIST_KEY));
        recyclerView=view.findViewById(R.id.recycler_view_list_favory);
        setViewitem();
    }
    private void setViewitem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapterFavory =new AdapterFavory(ListFavory);
        Log.e("La taille des favoris:", String.valueOf(ListFavory.size()));
        recyclerView.setAdapter(adapterFavory);

    }






}
