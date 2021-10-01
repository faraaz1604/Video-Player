package com.example.videoplayer;

public class VideoFiles {
    private String id;
    private String path;
    private String title;
    private String fileName;
    private String size;
    private String dataAdded;
    private String duration;

    public VideoFiles(String id, String path, String title, String fileName, String size,
                      String dataAdded, String duration) {
        this.id = id;
        this.path = path;
        this.title = title;
        this.fileName = fileName;
        this.size = size;
        this.dataAdded = dataAdded;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDataAdded() {
        return dataAdded;
    }

    public void setDataAdded(String dataAdded) {
        this.dataAdded = dataAdded;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
