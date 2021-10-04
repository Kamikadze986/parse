package com.example.parse;

import java.util.ArrayList;

public class Channels {
    ArrayList<Channel> channels;
    ChannelsAdapter adapter;

    public Channels() {
        channels = new ArrayList<>();
    }

    public void addAdapter(ChannelsAdapter adapter){
        this.adapter=adapter;
    }

    public ArrayList<Channel> getChannels() {
        return channels;
    }
    public void setChannel(Channel channel){
        this.channels.add(channel);
        adapter.notifyDataSetChanged();
    }

    public void setChannels(ArrayList<Channel> channels){
        this.channels=channels;
    }
}
