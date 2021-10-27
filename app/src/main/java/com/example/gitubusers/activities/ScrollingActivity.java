package com.example.gitubusers.activities;

import static com.example.gitubusers.activities.MainActivity.FAVORITE_LIST_KEY;
import static com.example.gitubusers.activities.MainActivity.USER_LIST_DESCRIPTION;
import static com.example.gitubusers.activities.MainActivity.USER_LIST_KEY;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.gitubusers.R;
import com.example.gitubusers.SharedPreferencesManager;
import com.example.gitubusers.model.User;

import java.util.ArrayList;

public class ScrollingActivity extends AppCompatActivity {

    private ImageView scrollPhoto;
    private TextView  scrollLogin;
    private TextView scrollUrl;
    private Button scrollBtnFavory;
    private User user;
    private ArrayList<User>myFavoriteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        user=(User) getIntent().getSerializableExtra(USER_LIST_DESCRIPTION);
        scrollPhoto=findViewById(R.id.datailPhotoUser);
        scrollLogin=findViewById(R.id.datailLoginUser);
        scrollUrl=findViewById(R.id.datailUrlUser);
        scrollBtnFavory=findViewById(R.id.datailBtnFavor);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setViewItem();
    }

    private void setViewItem(){
        scrollLogin.setText(user.getLogin());
        scrollUrl.setText(user.getUrl());
        Glide.with(this)
                .load(user.getAvatar_url())
                .into(scrollPhoto);

        scrollBtnFavory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(scrollBtnFavory==view){
                   scrollLogin.setText(user.getLogin());
                   scrollUrl.setText(user.getUrl());
                   Glide.with(ScrollingActivity.this)
                           .load(user.getAvatar_url())
                           .into(scrollPhoto);
                   myFavoriteList.add(user);
                   SharedPreferencesManager.getInstance(ScrollingActivity.this).addUsersFavoriteToList(user,FAVORITE_LIST_KEY);
                    finish();
                }

            }
        });

    }



}
