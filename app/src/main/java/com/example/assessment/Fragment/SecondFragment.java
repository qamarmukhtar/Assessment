package com.example.assessment.Fragment;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assessment.AdapterClass.CustomAdapter;
import com.example.assessment.R;
import com.example.assessment.SQL_lite.MyDatabaseHelper;

import java.util.ArrayList;


public class SecondFragment extends Fragment {
    RecyclerView recyclerView;

    ImageView empty_imageview;
    TextView no_data;

    MyDatabaseHelper myDB;
    ArrayList<String> news_id, news_title, news_author, news_name,news_publishedAt,news_url,news_urlToImage,news_description,news_content;
    CustomAdapter customAdapter;


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_second, container, false);



        View view = inflater.inflate(R.layout.fragment_second, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
//        RecyclerView.LayoutManager manager1 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
//        recyclerView.setLayoutManager(manager1);

        empty_imageview = view.findViewById(R.id.empty_imageview);
        no_data = view.findViewById(R.id.no_data);


        myDB = new MyDatabaseHelper(getContext());
        news_title = new ArrayList<>();
        news_author = new ArrayList<>();
        news_name = new ArrayList<>();
        news_publishedAt = new ArrayList<>();
        news_url = new ArrayList<>();
        news_urlToImage = new ArrayList<>();
        news_description = new ArrayList<>();
        news_content = new ArrayList<>();



        customAdapter = new CustomAdapter((Activity) getContext(), getContext(), news_id,
                news_title,
                news_author,
                news_name,
                news_publishedAt,
                news_url,
                news_urlToImage,
                news_description,
                news_content);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter( customAdapter );
//        recyclerView.setAdapter(customAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//        RecentlyNews();

        return view;
    }

//    void storeDataInArrays(){
//        Cursor cursor = myDB.readAllData();
//        if(cursor.getCount() == 0){
//            empty_imageview.setVisibility(View.VISIBLE);
//            no_data.setVisibility(View.VISIBLE);
//        }else{
//            while (cursor.moveToNext()){
//                book_id.add(cursor.getString(0));
//                book_title.add(cursor.getString(1));
//                book_author.add(cursor.getString(2));
//                book_pages.add(cursor.getString(3));
//            }
//
//        }
//    }
}