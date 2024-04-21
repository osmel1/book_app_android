package com.example.api_consumer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.api_consumer.adapters.BookAdapter;
import com.example.api_consumer.models.Book;
import com.example.api_consumer.models.GoogleBooksResponse;
import com.example.api_consumer.services.GoogleBooksService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Book> books;
    Button button;
    EditText editTextQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Gson gson = new GsonBuilder().setLenient().create();
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button_search);
        editTextQuery=findViewById(R.id.editTextQuery);
        books=new ArrayList<>();
        BookAdapter bookAdapter = new BookAdapter(this,R.layout.list_book_item,books);
        ListView listViewBooks = findViewById(R.id.listViewBooks);
        listViewBooks.setAdapter(bookAdapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        GoogleBooksService booksService = retrofit.create(GoogleBooksService.class);
        button.setOnClickListener(view ->{
            button.setText("");
            String query=editTextQuery.getText().toString();
            Call<GoogleBooksResponse> call = booksService.searchBooks(query);
            call.enqueue(new Callback<GoogleBooksResponse>() {
                @Override
                public void onResponse(Call<GoogleBooksResponse> call, Response<GoogleBooksResponse> response) {

                    button.setText(R.string.button_search);
                    GoogleBooksResponse booksResponse = response.body();
                    books.clear();
                    books.addAll(booksResponse.getItems());
                    bookAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<GoogleBooksResponse> call, Throwable t) {

                    button.setText(R.string.button_search);
                    t.printStackTrace();
                    Toast.makeText(MainActivity.this,"Erreur de connexion",Toast.LENGTH_SHORT);
                }
            });
        });

}
}