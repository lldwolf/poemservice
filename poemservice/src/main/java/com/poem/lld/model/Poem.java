package com.poem.lld.model;

import com.poem.lld.util.Constants;

public class Poem {

    private int id;
    private String title;
    private String author;
    private String content;
    private String album;
    private String type;
    private String url;
    private int publicDegree;
    private String dynasty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPublicDegree() {
        return publicDegree;
    }

    public void setPublicDegree(int publicDegree) {
        this.publicDegree = publicDegree;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("id: " + this.id);
        buffer.append(Constants.LINE_SEPARATOR);
        buffer.append("title: " + this.title);
        buffer.append(Constants.LINE_SEPARATOR);
        buffer.append("content: " + this.content);
        buffer.append(Constants.LINE_SEPARATOR);
        buffer.append("type: " + this.getType());
        buffer.append(Constants.LINE_SEPARATOR);
        buffer.append("dynasty: " + this.getDynasty());
        buffer.append(Constants.LINE_SEPARATOR);
        buffer.append("public degree: " + this.getPublicDegree());
        buffer.append(Constants.LINE_SEPARATOR);
        buffer.append("author: " + this.getAuthor());
        buffer.append(Constants.LINE_SEPARATOR);
        buffer.append("albutm:" + this.getAlbum());
        buffer.append(Constants.LINE_SEPARATOR);
        return buffer.toString();
    }

}
