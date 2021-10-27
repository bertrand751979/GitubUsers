package com.example.gitubusers.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gitubusers.GithubUsersApi;
import com.example.gitubusers.SharedPreferencesManager;
import com.example.gitubusers.fragment.DisplayFragment;
import com.example.gitubusers.R;
import com.example.gitubusers.fragment.FavoryFragment;
import com.example.gitubusers.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
        private BottomNavigationView bottomNav;
        public static String USER_LIST_KEY = "userKeys";
        public static String USER_LIST_DESCRIPTION = "userDescriptionKeys";
        public static String FAVORITE_LIST_KEY = "favoriteKeys";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNav=findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_user_list:
                    selectedFragment = new DisplayFragment();

                    break;
            }

            switch (item.getItemId()) {
                case R.id.nav_favorite:
                    selectedFragment = new FavoryFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };

}