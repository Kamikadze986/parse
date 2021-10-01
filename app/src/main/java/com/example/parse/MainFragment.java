package com.example.parse;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainFragment extends Fragment {
    ArrayList<Channels> channels=new ArrayList<>();
    private RecyclerView channelsList;

    public void onCreate(Bundle savedInstanceState) {
        Request request = new Request.Builder()
                .url("https://limehdads.online/playlist.json")
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call,@NotNull Response response) throws IOException {
                JSONObject main = null;
                try {
                    main = new JSONObject(response.body().string());
                    JSONArray channelsData = main.getJSONArray("channels");
                    for (int i = 0; i <channelsData.length() ; i++) {
                        JSONObject channelData = channelsData.getJSONObject(i);
                        String title=" ";
                        try {
                            JSONObject current=channelData.getJSONObject("current");
                            title=current.get("title").toString();
                        }catch (JSONException ignored){ }
                        Channels channel =new Channels(
                                channelData.get("name_ru").toString(),
                                channelData.get("image").toString(),
                                title);
                        channels.add(channel);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_main, container, false);
        channelsList = view.findViewById(R.id.recyclerView);
        channelsList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        channelsList.setAdapter(new ChannelsAdapter(channels));
        return view;
    }
}