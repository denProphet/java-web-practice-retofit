package com.company;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TinyUrlService {
    @POST("random")
    @FormUrlEncoded
    Call<String> getShortUrlAsString(
            @Field("format") String format,
            @Field("url") String url);

    @POST("random")
    @FormUrlEncoded
    Call<TinyUrlResponse> getShortUrlAsTinyUrlResponseInstance(
            @Field("format") String format,
            @Field("url") String url);
}
