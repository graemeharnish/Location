package com.graemeharnish.services.rest;


import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by graemeharnish on 10/29/17.
 */

public class RESTService {
    public static final String API_BASE_URL = "http://api.geonames.org/";

    private static OkHttpClient.Builder httpClient;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, new Object());
    }

    public static <S> S createService(Class<S> serviceClass, final Object token) {
        if(httpClient == null){
            httpClient = new OkHttpClient.Builder();
            if (token != null) {
                httpClient.addInterceptor(chain -> {
                    Request original = chain.request();

                    final HttpUrl originalHttpUrl = original.url();
                    final HttpUrl url = originalHttpUrl.newBuilder()
                            .addQueryParameter("username", "graemeharnish")
                            .addQueryParameter("type", "json")
                            .build();


                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Accept", "application/json")
                            //.header("Authorization", token.getTypeTokenAndToken())
                            .method(original.method(), original.body())
                            .url(url);
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                });
            }
            httpClient.connectTimeout(50, TimeUnit.SECONDS);
            httpClient.addInterceptor(addLoggin());
        }

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }

    private static HttpLoggingInterceptor addLoggin(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return logging;
    }
}
