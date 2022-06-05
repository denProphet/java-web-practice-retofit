package com.company;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    @GET("users/{username}/repos")
    Call<String> getGitHubReposListByUsername(@Path("username") String name);
}
