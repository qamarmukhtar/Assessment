package com.example.assessment.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.assessment.AdapterClass.NewsModuleAdapter;
import com.example.assessment.Api.RetrofitClient;
import com.example.assessment.Module.NewsModule;
import com.example.assessment.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment {

    private NewsModuleAdapter newsModuleAdapter;
    RecyclerView recentlyView;


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_first, container, false);
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        recentlyView = view.findViewById(R.id.recent_application);
        RecyclerView.LayoutManager manager1 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recentlyView.setLayoutManager(manager1);

        RecentlyNews();

        return view;

    }

    private void RecentlyNews() {


        String APIKEY = "5ae1e94a45f6454eace87a8894428750";
        String q = "bitcoin";

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        Call<NewsModule> call = RetrofitClient.getInstance().getApi().Recentlyjob(q,APIKEY);
        call.enqueue(new Callback<NewsModule>() {
            @Override
            public void onResponse(Call<NewsModule> call, Response<NewsModule> response) {

                if (response.body().getStatus().equals("ok")) {

                    Toast.makeText(getContext(), response.body().getStatus(), Toast.LENGTH_SHORT).show();
                    if (response.body().getArticles().size() != 0) {
                        newsModuleAdapter = new NewsModuleAdapter((List<NewsModule.Article>) response.body().getArticles(), getContext());
                        recentlyView.setAdapter(newsModuleAdapter);
                    } else {

                        Toast.makeText(getContext(), "jobs are empty", Toast.LENGTH_SHORT).show();
//                        getActivity().getSupportFragmentManager().beginTransaction()
//                                .replace(R.id.nav_host_fragment_activity_main, new EmptyFragment()).addToBackStack(null)
//                                .commit();
                    }
                } else if (response.body().getStatus().equals("error")) {
                    Toast.makeText(getContext(), response.body().getStatus(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<NewsModule> call, Throwable t) {

                Toast.makeText(getContext(), "error something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }


}