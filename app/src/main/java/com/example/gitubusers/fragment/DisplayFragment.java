package com.example.gitubusers.fragment;

import static com.example.gitubusers.activities.MainActivity.USER_LIST_DESCRIPTION;
import static com.example.gitubusers.activities.MainActivity.USER_LIST_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gitubusers.retrofit.GithubUsersApi;
import com.example.gitubusers.OnImageClickedAction;
import com.example.gitubusers.R;
import com.example.gitubusers.repository.Repository;
import com.example.gitubusers.SharedPreferencesManager;
import com.example.gitubusers.activities.ScrollingActivity;
import com.example.gitubusers.adapter.AdapterUser;
import com.example.gitubusers.model.User;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayFragment extends Fragment {
    private RecyclerView recyclerView;
    private AdapterUser adapterUser;
    private ArrayList<User> myListUser = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_list_users, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        callService();
        recyclerView=view.findViewById(R.id.recycler_view_list_user);
        setViewitem();
    }

    private void setViewitem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        OnImageClickedAction onImageClickedAction = new OnImageClickedAction() {
            @Override
            public void intentDescription(User user) {
                Intent intent =new Intent(DisplayFragment.this.getContext(), ScrollingActivity.class);
                intent.putExtra(USER_LIST_DESCRIPTION,user);
                startActivity(intent);

                Toast.makeText(DisplayFragment.this.getContext(),"Vers détail", Toast.LENGTH_SHORT).show();
            }
        };
        adapterUser =new AdapterUser(myListUser,onImageClickedAction);
        Log.e("taille de ma liste: ", String.valueOf(myListUser.size()));

        recyclerView.setAdapter(adapterUser);

    }

    public void callService(){
        GithubUsersApi.GithubUsersService service =  GithubUsersApi.getInstance().getClient().create(GithubUsersApi.GithubUsersService.class);
        Call<List<User>> call= service.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                updateView(response);
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
            }
        });
    }

  /*  private void updateView(Response<List<User>> response) {
       if (response.body().size() > 0) {
            myListUser = (ArrayList<User>) response.body();
            //il faut mettre a jour la liste qui est null au depart du fragment on fait un notifydatachange avec la method setAdapter de l'adapter
            adapterUser.setListAdapterUser(myListUser);
            //Log.e("la liste", String.valueOf(myListUser.size()));
            Toast.makeText(DisplayFragment.this.getContext(), "Reponse du serveur", Toast.LENGTH_SHORT).show();
       // }
    }*/

    private void updateView(Response<List<User>> response){
        Repository.getInstance().update(response,adapterUser);
        SharedPreferencesManager.getInstance(DisplayFragment.this.getContext()).saveListUser(myListUser,USER_LIST_KEY);
        Toast.makeText(DisplayFragment.this.getContext(), "Reponse du serveur", Toast.LENGTH_SHORT).show();
    }

}
