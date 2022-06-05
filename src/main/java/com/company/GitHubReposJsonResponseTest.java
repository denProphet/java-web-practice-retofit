package com.company;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

public class GitHubReposJsonResponseTest {
    public static void main(String[] args) {

        GitHubService s = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(GitHubService.class);

        Response<String> r = null;
        try {
           r  = s.getGitHubReposListByUsername("DenProphet").execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (r!=null&&r.isSuccessful()){
            System.out.println(r.body());
        }else if(r!=null){
            try {
                System.out.println(r.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
