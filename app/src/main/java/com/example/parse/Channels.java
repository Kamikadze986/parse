package com.example.parse;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class Channels {
    public ArrayList<Channel> channels;
    public MutableLiveData<ArrayList<Channel>> channelsLive= new MutableLiveData<>();

    public Channels() {

        channels = new ArrayList<>();
        initializeChannels();
        channelsLive.setValue(channels);
    }

    public ArrayList<Channel> getChannels() {
        return channels;
    }


    public void initializeChannels(){
        this.channels=Inic.initializecomponent();
    }
}
