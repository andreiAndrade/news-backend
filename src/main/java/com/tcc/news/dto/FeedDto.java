package com.tcc.news.dto;

public class FeedDto {
    String id;
    String originId;
    Long recrawled;
    String fingerprint;
    String title;
    Long published;
    Long crawled;
    Object origin;
    Object[] alternate;
    String author;
    Object summary;
    Object[] enclosure;
    Object visual;
    String canonicalUrl;
    Boolean unread;
    Object[] categories;
    Integer engagement;
    Double engagementRate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public Long getRecrawled() {
        return recrawled;
    }

    public void setRecrawled(Long recrawled) {
        this.recrawled = recrawled;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPublished() {
        return published;
    }

    public void setPublished(Long published) {
        this.published = published;
    }

    public Long getCrawled() {
        return crawled;
    }

    public void setCrawled(Long crawled) {
        this.crawled = crawled;
    }

    public Object getOrigin() {
        return origin;
    }

    public void setOrigin(Object origin) {
        this.origin = origin;
    }

    public Object[] getAlternate() {
        return alternate;
    }

    public void setAlternate(Object[] alternate) {
        this.alternate = alternate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Object getSummary() {
        return summary;
    }

    public void setSummary(Object summary) {
        this.summary = summary;
    }

    public Object[] getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Object[] enclosure) {
        this.enclosure = enclosure;
    }

    public Object getVisual() {
        return visual;
    }

    public void setVisual(Object visual) {
        this.visual = visual;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public Boolean getUnread() {
        return unread;
    }

    public void setUnread(Boolean unread) {
        this.unread = unread;
    }

    public Object[] getCategories() {
        return categories;
    }

    public void setCategories(Object[] categories) {
        this.categories = categories;
    }

    public Integer getEngagement() {
        return engagement;
    }

    public void setEngagement(Integer engagement) {
        this.engagement = engagement;
    }

    public Double getEngagementRate() {
        return engagementRate;
    }

    public void setEngagementRate(Double engagementRate) {
        this.engagementRate = engagementRate;
    }
}
