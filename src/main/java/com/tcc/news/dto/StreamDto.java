package com.tcc.news.dto;

public class StreamDto {
    String id;
    String title;
    String directin;
    Long update;
    Object[] alternate;
    String continuation;
    FeedDto[] items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectin() {
        return directin;
    }

    public void setDirectin(String directin) {
        this.directin = directin;
    }

    public Long getUpdate() {
        return update;
    }

    public void setUpdate(Long update) {
        this.update = update;
    }

    public Object[] getAlternate() {
        return alternate;
    }

    public void setAlternate(Object[] alternate) {
        this.alternate = alternate;
    }

    public String getContinuation() {
        return continuation;
    }

    public void setContinuation(String continuation) {
        this.continuation = continuation;
    }

    public FeedDto[] getItems() {
        return items;
    }

    public void setItems(FeedDto[] items) {
        this.items = items;
    }
}
