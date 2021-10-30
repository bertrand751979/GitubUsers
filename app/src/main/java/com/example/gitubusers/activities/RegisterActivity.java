package com.example.gitubusers.activities;

import static com.example.gitubusers.activities.MainActivity.PROFIL_REGISTER_LIST_KEY;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gitubusers.R;
import com.example.gitubusers.SharedPreferencesManager;
import com.example.gitubusers.model.Profil;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {
    private EditText editLoginRegister;
    private EditText editPasswordRegister;
    private Button btnSaveLogin;
    private ArrayList<Profil>myProfilRegisterList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editLoginRegister=findViewById(R.id.edit_register_login);
        editPasswordRegister=findViewById(R.id.edit_register_mdp);
        btnSaveLogin=findViewById(R.id.button_register_profil);
        btnSaveLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProfilOnDataBase();
            }
        });
    }

    private void addProfilOnDataBase(){
        Profil registerProfil =new Profil();
        registerProfil.setLoginProfil(editLoginRegister.getText().toString());
        registerProfil.setPasswordProfil(editPasswordRegister.getText().toString());
        myProfilRegisterList.add(registerProfil);
        SharedPreferencesManager.getInstance(this).saveProfil(myProfilRegisterList,PROFIL_REGISTER_LIST_KEY);
        Toast.makeText(RegisterActivity.this, "Enregistré", Toast.LENGTH_SHORT).show();
        Toast.makeText(RegisterActivity.this, "Le nombre d'enregistrement est de: "+myProfilRegisterList.size(), Toast.LENGTH_SHORT).show();
    }




}
