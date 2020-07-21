package com.applex.snaplingo.util;

public class PDFOptions {
    private int mBorderWidth;
    private String mOutFileName;
    private int mPageColor;
    private String mPageSize;
    private String mPassword;
    private boolean mPasswordProtected;
    private Watermark mWatermark;
    private boolean mWatermarkAdded;

    PDFOptions() {
    }

    PDFOptions(String str, String str2, boolean z, String str3, int i, boolean z2, Watermark watermark, int i2) {
        this.mOutFileName = str;
        this.mPageSize = str2;
        this.mPasswordProtected = z;
        this.mPassword = str3;
        this.mBorderWidth = i;
        this.mWatermarkAdded = z2;
        this.mWatermark = watermark;
        this.mPageColor = i2;
    }

    public String getOutFileName() {
        return this.mOutFileName;
    }

    public String getPageSize() {
        return this.mPageSize;
    }

    public boolean isPasswordProtected() {
        return this.mPasswordProtected;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setOutFileName(String str) {
        this.mOutFileName = str;
    }

    public void setPasswordProtected(boolean z) {
        this.mPasswordProtected = z;
    }

    public void setPassword(String str) {
        this.mPassword = str;
    }

    public void setPageSize(String str) {
        this.mPageSize = str;
    }

    public void setBorderWidth(int i) {
        this.mBorderWidth = i;
    }

    public boolean isWatermarkAdded() {
        return this.mWatermarkAdded;
    }

    public void setWatermarkAdded(boolean z) {
        this.mWatermarkAdded = z;
    }

    public Watermark getWatermark() {
        return this.mWatermark;
    }

    public void setWatermark(Watermark watermark) {
        this.mWatermark = watermark;
    }

    public int getPageColor() {
        return this.mPageColor;
    }

    public void setPageColor(int i) {
        this.mPageColor = i;
    }
}
