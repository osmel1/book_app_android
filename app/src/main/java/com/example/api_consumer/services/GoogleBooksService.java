package com.example.api_consumer.services;

import com.example.api_consumer.models.GoogleBooksResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleBooksService {
    @GET("v1/volumes")
    Call<GoogleBooksResponse> searchBooks(@Query("q") String query);
}
