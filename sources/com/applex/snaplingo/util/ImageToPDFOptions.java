package com.applex.snaplingo.util;

import java.util.ArrayList;

public class ImageToPDFOptions extends PDFOptions {
    private String mImageScaleType;
    private ArrayList<String> mImagesUri;
    private int mMarginBottom = 0;
    private int mMarginLeft = 0;
    private int mMarginRight = 0;
    private int mMarginTop = 0;
    private String mMasterPwd;
    private String mPageNumStyle;
    private String mQualityString;

    public ImageToPDFOptions() {
        setPasswordProtected(false);
        setWatermarkAdded(true);
        setBorderWidth(0);
    }

    public ImageToPDFOptions(String str, String str2, boolean z, String str3, String str4, int i, String str5, ArrayList<String> arrayList, boolean z2, Watermark watermark, int i2) {
        super(str, str2, z, str3, i, z2, watermark, i2);
        this.mQualityString = str4;
        this.mImagesUri = arrayList;
        this.mMasterPwd = str5;
    }

    public String getQualityString() {
        return this.mQualityString;
    }

    public ArrayList<String> getImagesUri() {
        return this.mImagesUri;
    }

    public void setQualityString(String str) {
        this.mQualityString = str;
    }

    public void setImagesUri(ArrayList<String> arrayList) {
        this.mImagesUri = arrayList;
    }

    public void setMargins(int i, int i2, int i3, int i4) {
        this.mMarginTop = i;
        this.mMarginBottom = i2;
        this.mMarginRight = i3;
        this.mMarginLeft = i4;
    }

    public void setMasterPwd(String str) {
        this.mMasterPwd = str;
    }

    public int getMarginTop() {
        return this.mMarginTop;
    }

    public int getMarginBottom() {
        return this.mMarginBottom;
    }

    public int getMarginRight() {
        return this.mMarginRight;
    }

    public int getMarginLeft() {
        return this.mMarginLeft;
    }

    public String getImageScaleType() {
        return this.mImageScaleType;
    }

    public void setImageScaleType(String str) {
        this.mImageScaleType = str;
    }

    public String getPageNumStyle() {
        return this.mPageNumStyle;
    }

    public void setPageNumStyle(String str) {
        this.mPageNumStyle = str;
    }

    public String getMasterPwd() {
        return this.mMasterPwd;
    }
}
