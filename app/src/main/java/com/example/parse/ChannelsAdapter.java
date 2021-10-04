package com.example.parse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChannelsAdapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<Channel>channels;
    ChannelsAdapter(ArrayList<Channel> channel){
        channels=channel;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.channels_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(channels.get(position).name_ru);
        holder.title.setText(channels.get(position).title);
        holder.downloadImg(channels.get(position).urlImg);
    }

    @Override
    public int getItemCount() {
        return channels.size();
    }
}
