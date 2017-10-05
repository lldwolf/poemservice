package com.poem.lld.model;

import java.io.Serializable;

public class Poem implements Serializable {

    private static final long serialVersionUID = 4106780223233958986L;
    private int id;
    private String title;
    private String author;
    private String content;
    private String album;
    private String type;
    private String url;
    private int publicDegree;
    private String dynasty;
    private int authorId;
    private Author authorEntity;

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
        buffer.append(this.id);
        buffer.append('|');
        buffer.append(this.title);
        buffer.append('|');
        buffer.append(this.getDynasty());
        buffer.append('|');
        buffer.append(this.getAuthor());
        buffer.append('|');
        buffer.append(this.content);
        buffer.append('|');
        buffer.append(this.getType());
        buffer.append('|');
        buffer.append(this.getPublicDegree());
        buffer.append('|');
        buffer.append(this.getAlbum());
        buffer.append('|');
        
//        if (this.authorEntity != null) {
//            buffer.append("author: " + this.authorEntity.getName());
//        }
//        
        return buffer.toString();
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Author getAuthorEntity() {
        return authorEntity;
    }

    public void setAuthorEntity(Author authorEntity) {
        this.authorEntity = authorEntity;
    }

}
