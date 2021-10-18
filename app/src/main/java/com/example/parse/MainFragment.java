package com.example.parse;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainFragment extends Fragment implements View.OnClickListener {
    Channels channels;

    private RecyclerView channelsList;
    private ChannelsAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        channels=new Channels();
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        channelsList = view.findViewById(R.id.recyclerView);
        channelsList.setOnClickListener(this);
        channelsList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter=new ChannelsAdapter(channels.getChannels());
        channelsList.setAdapter(adapter);

        swipeRefreshLayout=view.findViewById(R.id.refreshView);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        channels.channelsLive.observe(this, new Observer<ArrayList<Channel>>() {
            @Override
            public void onChanged(ArrayList<Channel> channels) {
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {}

}