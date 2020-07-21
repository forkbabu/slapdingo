package com.applex.snaplingo.adapters;

import android.net.Uri;

public class DocModel {
    String DocName;
    String date;
    Uri imageUri;
    String path;

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public String getDocName() {
        return this.DocName;
    }

    public void setDocName(String str) {
        this.DocName = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }
}
