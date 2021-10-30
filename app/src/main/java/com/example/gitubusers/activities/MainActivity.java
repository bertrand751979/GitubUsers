package com.example.gitubusers.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.gitubusers.fragment.DisplayFragment;
import com.example.gitubusers.R;
import com.example.gitubusers.fragment.FavoryFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
        private BottomNavigationView bottomNav;
        public static String USER_LIST_KEY = "userKeys";
        public static String USER_LIST_DESCRIPTION = "userDescriptionKeys";
        public static String FAVORITE_LIST_KEY = "favoriteKeys";
        public static String PROFIL_REGISTER_LIST_KEY = "profilListKey";
        public static String PROFIL_LIST_EXTRA = "profilListExtra";
        public static String PROFIL_LIST_KEY= "profilListKey";



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