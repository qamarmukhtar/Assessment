package com.example.assessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewsDetails extends AppCompatActivity {

    TextView name, author, title, description, url , publishedAt, content;
    CircleImageView urlToImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);


        name = findViewById(R.id.name);
        author = findViewById(R.id.author);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        url = findViewById(R.id.url);
        urlToImage = findViewById(R.id.urlToImage);
        publishedAt = findViewById(R.id.publishedAt);
        content = findViewById(R.id.content);


        Intent intent = getIntent();
        String Name = intent.getStringExtra("name");
        String Author = intent.getStringExtra("author");
        String Title = intent.getStringExtra("title");
        String Description = intent.getStringExtra("description");
        String Url = intent.getStringExtra("url");
        String UrlToImage = intent.getStringExtra("urlToImage");
        String PublishedAt = intent.getStringExtra("publishedAt");
        String Content = intent.getStringExtra("content");
        System.out.println("id jobseeker"+name);


        name.setText(Name);
        author.setText(Author);
        title.setText(Title);
        description.setText(Description);
        url.setText(Url);
        publishedAt.setText(PublishedAt);
        content.setText(Content);
        Picasso.get().load(String.valueOf(UrlToImage)).into(urlToImage);
    }
}