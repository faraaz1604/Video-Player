package com.example.videoplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.MyHolder> {
    private ArrayList<String> folderName;
    private ArrayList<VideoFiles> videoFiles;
    private Context mContext;

    public FolderAdapter(ArrayList<String> folderName, ArrayList<VideoFiles> videoFiles, Context mContext) {
        this.folderName = folderName;
        this.videoFiles = videoFiles;
        this.mContext = mContext;
    }

    @NonNull
    @NotNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.folder_item, parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyHolder holder, int position) {
        int index = folderName.get(position).lastIndexOf("/");
        String folder = folderName.get(position).substring(index + 1);
        holder.folder.setText(folder);
        holder.counterFile.setText(String.valueOf(NumberOfFiles(folderName.get(position))));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, VideoFolderActivity.class);
                intent.putExtra("folderName", folderName.get(position));
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return folderName.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        TextView folder, counterFile;
        public MyHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            folder = itemView.findViewById(R.id.folderName);
            counterFile = itemView.findViewById(R.id.count_files_folder);

        }
    }
    int NumberOfFiles(String folderName){
        int countFiles = 0;
        for (VideoFiles videoFiles : videoFiles) {
            if (videoFiles.getPath().substring(0, videoFiles.getPath().lastIndexOf("/"))
            .endsWith(folderName)) {
                countFiles++;
            }
        }
        return countFiles;
    }
}
