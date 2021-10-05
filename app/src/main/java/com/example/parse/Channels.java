package com.example.parse;

import java.util.ArrayList;

public class Channels {
    ArrayList<Channel> channels;
    ChannelsAdapter adapter;

    public Channels() {
        channels = new ArrayList<>();
    }

    public ArrayList<Channel> getChannels() {
        return channels;
    }


    public void setChannels(ArrayList<Channel> channels){
        this.channels=channels;
    }
}
