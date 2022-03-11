package com.example.assessment.AdapterClass;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;


import com.example.assessment.Module.NewsModule;
import com.example.assessment.NewsDetails;
import com.example.assessment.R;
import com.example.assessment.SQL_lite.MyDatabaseHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class NewsModuleAdapter extends RecyclerView.Adapter<NewsModuleAdapter.ViewHolder> {
    List<NewsModule.Article> imageLists;
    Context context;

    public NewsModuleAdapter(List<NewsModule.Article> imageLists, Context context) {
        this.imageLists = imageLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.job_seeker_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsModule.Article imageList=imageLists.get(position);

//        int Accept_job_id =imageList.getId();

        holder.name.setText(imageList.getSource().getName());
        holder.author.setText(imageList.getAuthor());
        holder.description.setText(imageList.getDescription());
        holder.title.setText(imageList.getTitle());
        holder.url.setText((imageList.getUrl()));
        holder.publishedAt.setText((imageList.getPublishedAt()));

        Picasso.get()
                .load(imageList.getUrlToImage())
                .into(holder.urlToImage);

        holder.View.setOnClickListener(view -> {


            Intent intent = new Intent(context, NewsDetails.class);
            intent.putExtra("name", String.valueOf(imageList.getSource().getName()));
            intent.putExtra("author", String.valueOf(imageList.getAuthor()));
            intent.putExtra("title", String.valueOf(imageList.getTitle()));
            intent.putExtra("description", String.valueOf(imageList.getDescription()));
            intent.putExtra("url", String.valueOf(imageList.getUrl()));
            intent.putExtra("urlToImage", String.valueOf(imageList.getUrlToImage()));
            intent.putExtra("publishedAt", String.valueOf(imageList.getPublishedAt()));
            intent.putExtra("content", String.valueOf(imageList.getContent()));
            context.startActivity(intent);

        });

        holder.Save.setOnClickListener(view -> {

            MyDatabaseHelper myDB = new MyDatabaseHelper(view.getContext());
            myDB.addBook((String.valueOf(imageList.getSource().getName())),
            ( String.valueOf(imageList.getAuthor())),
            ( String.valueOf(imageList.getTitle())),
            ( String.valueOf(imageList.getDescription())),
            ( String.valueOf(imageList.getUrl())),
            ( String.valueOf(imageList.getUrlToImage())),
            (String.valueOf(imageList.getPublishedAt())),
            ( String.valueOf(imageList.getContent())));

//            imageLists.remove(position);
//            notifyItemRemoved(position);
//            notifyItemRangeChanged(position, imageLists.size());

        });

//        holder.linear.setOnClickListener(view1 -> {
//
//            Intent intent = new Intent(context, JobSeekerDetails.class);
//            intent.putExtra("id", String.valueOf(Accept_job_id));
//            context.startActivity(intent);
//        });
    }

    @Override
    public int getItemCount() {
        return imageLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,author,publishedAt,url,title,description;
        private ImageView urlToImage;
        Button View;
        private LinearLayout linear;
        AppCompatButton Save;
        public ViewHolder(View itemView) {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.name);
            author=(TextView)itemView.findViewById(R.id.author);
            publishedAt=(TextView)itemView.findViewById(R.id.publishedAt);
            url=(TextView)itemView.findViewById(R.id.url);
            title=(TextView)itemView.findViewById(R.id.title);
            urlToImage=(ImageView)itemView.findViewById(R.id.urlToImage);
            description=(TextView)itemView.findViewById(R.id.description);

            View=(Button) itemView.findViewById(R.id.View);
            Save=(AppCompatButton) itemView.findViewById(R.id.Save);
            View.setVisibility(View.VISIBLE);
            Save.setVisibility(View.VISIBLE);

            linear=(LinearLayout) itemView.findViewById(R.id.linear);


        }
    }



}