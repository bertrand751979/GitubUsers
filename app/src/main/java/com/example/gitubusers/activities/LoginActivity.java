package com.example.gitubusers.activities;
import static com.example.gitubusers.activities.MainActivity.PROFIL_LIST_KEY;
import static com.example.gitubusers.activities.MainActivity.PROFIL_REGISTER_LIST_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.gitubusers.R;
import com.example.gitubusers.SharedPreferencesManager;
import com.example.gitubusers.model.Profil;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private EditText txtLogin;
    private EditText txtPassword;
    private ImageView btnConnexion;
    private TextView linkConnexion;
    private ArrayList<Profil> myProfilList = new ArrayList<>();
    private ArrayList<Profil> registerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferencesManager.getInstance(this).getProfil(PROFIL_LIST_KEY);
        //myProfilList = new ArrayList<> (SharedPreferencesManager.getInstance(LoginActivity.this).getProfil(PROFIL_LIST_KEY));
        Log.e("La taille profil List: ", String.valueOf(myProfilList.size()));
        registerList = new ArrayList<>(SharedPreferencesManager.getInstance(this).getProfil(PROFIL_REGISTER_LIST_KEY));
        Log.e("La taille List: ", String.valueOf(registerList.size()));
        txtLogin = findViewById(R.id.edit_text_user_password);
        txtPassword = findViewById(R.id.edit_text_user_password);
        btnConnexion = findViewById(R.id.button_connexion);
        linkConnexion = findViewById(R.id.textview_register);
        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRegister();
                //Toast.makeText(LoginActivity.this, "La liste des profil est: "+myProfilList.size(), Toast.LENGTH_SHORT).show();
            }
        });
        linkConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    private void isRegister() {
        boolean resultat = false;
        for (Profil registerProfil : registerList) {
            if (txtLogin.getText().toString().equalsIgnoreCase(registerProfil.getLoginProfil()) &&
                    txtPassword.getText().toString().equalsIgnoreCase(registerProfil.getPasswordProfil())) {
                resultat = true;
            }
        }
        if (resultat == true) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(LoginActivity.this,"connecte",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(LoginActivity.this, "Inconnu", Toast.LENGTH_SHORT).show();
        }

    }


}