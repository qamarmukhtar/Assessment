package com.example.assessment.AdapterClass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assessment.NewsDetails;
import com.example.assessment.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList <String> news_id ,news_name, news_title, news_author, news_publishedAt,news_url,news_urlToImage,news_description,news_content;

    public CustomAdapter(Activity activity, Context context, ArrayList news_id, ArrayList news_title, ArrayList news_author,
                         ArrayList news_name,
                         ArrayList news_publishedAt,
                         ArrayList news_url,
                         ArrayList news_urlToImage,
                         ArrayList news_description,
                         ArrayList news_content){


        this.activity = activity;
        this.context = context;
        this.news_id = news_id;
        this.news_name = news_name;
        this.news_title = news_title;
        this.news_author = news_author;
        this.news_publishedAt = news_publishedAt;
        this.news_url = news_url;
        this.news_urlToImage = news_urlToImage;
        this.news_description = news_description;
        this.news_content = news_content;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.job_seeker_item, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.name.setText(String.valueOf(news_name.get(position)));
        holder.news_id.setText(String.valueOf(news_id.get(position)));
        holder.author.setText(String.valueOf(news_author.get(position)));
        holder.description.setText(String.valueOf(news_description.get(position)));
        holder.title.setText(String.valueOf(news_title.get(position)));
        holder.url.setText(String.valueOf(news_url.get(position)));
        holder.publishedAt.setText(String.valueOf(news_publishedAt.get(position)));

        Picasso.get()
                .load(String.valueOf(news_urlToImage.get(position)))
                .into(holder.urlToImage);

        holder.View.setOnClickListener(view -> {


            Intent intent = new Intent(context, NewsDetails.class);
            intent.putExtra("name", String.valueOf(news_name.get(position)));
            intent.putExtra("author", String.valueOf(news_name.get(position)));
            intent.putExtra("title", String.valueOf(news_name.get(position)));
            intent.putExtra("description", String.valueOf(news_name.get(position)));
            intent.putExtra("url", String.valueOf(news_name.get(position)));
            intent.putExtra("urlToImage", String.valueOf(news_name.get(position)));
            intent.putExtra("publishedAt", String.valueOf(news_name.get(position)));
            intent.putExtra("content", String.valueOf(news_name.get(position)));
            context.startActivity(intent);

        });


    }

    @Override
    public int getItemCount() {
        return news_id == null ? 0 : news_id.size();
    }

//    @Override
//    public int getItemCount() {
//        return news_id.size();
//    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name, author, publishedAt, url, title, description,news_id;
        private ImageView urlToImage;
        Button View;
        private LinearLayout linear;
        AppCompatButton Save;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            news_id = (TextView) itemView.findViewById(R.id.news_id);
            author = (TextView) itemView.findViewById(R.id.author);
            publishedAt = (TextView) itemView.findViewById(R.id.publishedAt);
            url = (TextView) itemView.findViewById(R.id.url);
            title = (TextView) itemView.findViewById(R.id.title);
            urlToImage = (ImageView) itemView.findViewById(R.id.urlToImage);
            description = (TextView) itemView.findViewById(R.id.description);

            View = (Button) itemView.findViewById(R.id.View);
            Save = (AppCompatButton) itemView.findViewById(R.id.Save);
            View.setVisibility(View.VISIBLE);
            Save.setVisibility(View.VISIBLE);

            linear = (LinearLayout) itemView.findViewById(R.id.linear);

        }



    }

}
