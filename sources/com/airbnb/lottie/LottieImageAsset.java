package com.airbnb.lottie;

import android.graphics.Bitmap;

public class LottieImageAsset {
    private Bitmap bitmap;
    private final String dirName;
    private final String fileName;
    private final int height;

    /* renamed from: id  reason: collision with root package name */
    private final String f23id;
    private final int width;

    public LottieImageAsset(int i, int i2, String str, String str2, String str3) {
        this.width = i;
        this.height = i2;
        this.f23id = str;
        this.fileName = str2;
        this.dirName = str3;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.f23id;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getDirName() {
        return this.dirName;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap2) {
        this.bitmap = bitmap2;
    }
}
