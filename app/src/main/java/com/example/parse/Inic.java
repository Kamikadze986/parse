package com.example.parse;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Inic {
    static ArrayList<Channel> initializecomponent(){
        ArrayList<Channel> channelsD =new ArrayList<>();
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
                        Channel channel =new Channel(
                                channelData.get("name_ru").toString(),
                                channelData.get("image").toString(),
                                title);
                        channelsD.add(channel);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            Thread.sleep(222);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return channelsD;
    }
}
