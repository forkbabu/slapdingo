package com.applex.snaplingo.LinkPreview;

public class MetaData {
    private String description = "";
    private String favicon = "";
    private String imageurl = "";
    private String mediatype = "";
    private String sitename = "";
    private String title = "";
    private String url = "";

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getImageurl() {
        return this.imageurl;
    }

    public void setImageurl(String str) {
        this.imageurl = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getSitename() {
        return this.sitename;
    }

    public void setSitename(String str) {
        this.sitename = str;
    }

    public String getMediatype() {
        return this.mediatype;
    }

    public void setMediatype(String str) {
        this.mediatype = str;
    }

    public String getFavicon() {
        return this.favicon;
    }

    public void setFavicon(String str) {
        this.favicon = str;
    }
}
