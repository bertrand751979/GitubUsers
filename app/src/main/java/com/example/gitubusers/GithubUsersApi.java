package com.example.gitubusers;

import com.example.gitubusers.model.User;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class GithubUsersApi {
    public interface GithubUsersService {
        @GET("users")
        Call<List<User>> getUsers();
    }
    private final static String BASE_URL="https://api.github.com/";
    private static GithubUsersApi INSTANCE = null;
    private GithubUsersApi(){}
    public static GithubUsersApi getInstance(){
        if (INSTANCE == null){
            INSTANCE = new GithubUsersApi();
        }
        return INSTANCE;
    }
    public Retrofit getClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }
}
