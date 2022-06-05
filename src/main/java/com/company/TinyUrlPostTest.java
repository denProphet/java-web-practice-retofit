package com.company;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

public class TinyUrlPostTest {
    public static void main(String[] args) {
        TinyUrlPostTest test = new TinyUrlPostTest();
        //test.getShortUrlAsString();
        test.getShortUrlAsTinyUrlResponseInstance();

    }

    public void getShortUrlAsString() {
        TinyUrlService s = new Retrofit.Builder()
                .baseUrl("http://tiny-url.info/api/v1/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(TinyUrlService.class);

        Response<String> r = null;
        try {
            r = s.getShortUrlAsString("json", "https://www.google.com.ua/maps/place/" +
                    "Куренёвка,+Киев,+02000/@50.4869619,30.4275107,14z/data=!3m1!4b1!4m5!3m4!1s0x40d4cd981d377bd9:" +
                    "0xa785750d36e9fe63!8m2!3d50.4945835!4d30.4305804?hl=ru").execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (r != null && r.isSuccessful()) {
            System.out.println(r.body());
        } else if (r != null) {
            try {
                System.out.println(r.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getShortUrlAsTinyUrlResponseInstance() {
        TinyUrlService s = new Retrofit.Builder()
                .baseUrl("http://tiny-url.info/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TinyUrlService.class);

        Response<TinyUrlResponse> r = null;
        try {
            r = s.getShortUrlAsTinyUrlResponseInstance("json", "https://www.google.com.ua/maps/place/" +
                    "Куренёвка,+Киев,+02000/@50.4869619,30.4275107,14z/data=!3m1!4b1!4m5!3m4!1s0x40d4cd981d377bd9:" +
                    "0xa785750d36e9fe63!8m2!3d50.4945835!4d30.4305804?hl=ru").execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (r != null && r.isSuccessful()) {
            System.out.println("Short url: " + r.body().shortUrl);
        } else if (r != null) {
            try {
                System.out.println(r.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
