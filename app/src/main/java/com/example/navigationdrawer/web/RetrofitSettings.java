package com.example.navigationdrawer.web;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitSettings {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.1.113:8090/";
    private static  OkHttpClient client;



    public static Retrofit getRetrofit(String userName, String password) {
        if (retrofit == null) {
            client =  new OkHttpClient.Builder()
                    .addInterceptor(new AuthenticationInterceptor(userName, password))
                    .build();
            retrofit = new Retrofit. Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(new NullOnEmptyConverterFactory())
                    .addConverterFactory(JacksonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    private static class NullOnEmptyConverterFactory extends Converter.Factory {

            @Override
            public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                final Converter<ResponseBody, ?> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
                return (Converter<ResponseBody, Object>) body -> {
                    if (body.contentLength() == 0) return null;
                    return delegate.convert(body);
                };
            }
        }

    }

