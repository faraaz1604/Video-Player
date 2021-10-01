package com.example.videoplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;

public class VideoFolderAdapter extends RecyclerView.Adapter<VideoFolderAdapter.MyViewHolder> {
    private Context mContext;
    static ArrayList<VideoFiles> folderVideoFiles;
    View view;

    public VideoFolderAdapter(Context mContext, ArrayList<VideoFiles> folderVideoFiles) {
        this.mContext = mContext;
        this.folderVideoFiles = folderVideoFiles;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.video_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.fileName.setText(folderVideoFiles.get(position).getTitle());
        Glide.with(mContext).load(new File(folderVideoFiles.get(position).getPath()))
                .into(holder.thumbnail);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlayerActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("sender", "FolderIsSending");
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return folderVideoFiles.size();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{
        ImageView thumbnail, menuMore;
        TextView fileName, videoDuration;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            menuMore = itemView.findViewById(R.id.menu_more);
            fileName = itemView.findViewById(R.id.video_file_name);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            videoDuration = itemView.findViewById(R.id.video_duration);

        }
    }
}
