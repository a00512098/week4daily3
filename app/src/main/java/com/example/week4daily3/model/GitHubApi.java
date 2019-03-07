package com.example.week4daily3.model;

import com.example.week4daily3.model.apiobjects.Repositories;
import com.example.week4daily3.model.apiobjects.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi {
    String REPOS_URL = "/users/{username}/repos";
    String USERNAME_URL = "/users/{username}";

    @GET(USERNAME_URL)
    Call<User> getUserInfo(@Path("username") String username);

    @GET(REPOS_URL)
    Call<ArrayList<Repositories>> getUserRepos(@Path("username") String username);
}
