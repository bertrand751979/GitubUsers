package com.example.gitubusers.repository;

import static com.example.gitubusers.activities.MainActivity.USER_LIST_DESCRIPTION;



import com.example.gitubusers.adapter.AdapterUser;
import com.example.gitubusers.model.User;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class Repository {
    private static Repository instance;
    public ArrayList<User> myListUser = new ArrayList<>();
    public ArrayList<User> ListFavory;
    private Repository(){
    }
    public static Repository getInstance() {
        if(instance == null){
            instance = new Repository();
        }
        return instance;
    }

    public void update(Response<List<User>> response, AdapterUser adapterUser){
        if (response.body().size() > 0) {
            myListUser = (ArrayList<User>) response.body();
            //il faut mettre a jour la liste qui est null au depart du fragment on fait un notifydatachange avec la method setAdapter de l'adapter
            adapterUser.setListAdapterUser(myListUser);
        }
    }








}
