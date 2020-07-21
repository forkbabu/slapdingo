package com.applex.snaplingo.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.zhihu.matisse.engine.ImageEngine;

public class PicassoEngine implements ImageEngine {
    @Override // com.zhihu.matisse.engine.ImageEngine
    public boolean supportAnimatedGif() {
        return false;
    }

    @Override // com.zhihu.matisse.engine.ImageEngine
    public void loadThumbnail(Context context, int i, Drawable drawable, ImageView imageView, Uri uri) {
        Picasso.get().load(uri).placeholder(drawable).resize(i, i).centerCrop().into(imageView);
    }

    @Override // com.zhihu.matisse.engine.ImageEngine
    public void loadGifThumbnail(Context context, int i, Drawable drawable, ImageView imageView, Uri uri) {
        loadThumbnail(context, i, drawable, imageView, uri);
    }

    @Override // com.zhihu.matisse.engine.ImageEngine
    public void loadImage(Context context, int i, int i2, ImageView imageView, Uri uri) {
        Picasso.get().load(uri).resize(i, i2).priority(Picasso.Priority.HIGH).centerInside().into(imageView);
    }

    @Override // com.zhihu.matisse.engine.ImageEngine
    public void loadGifImage(Context context, int i, int i2, ImageView imageView, Uri uri) {
        loadImage(context, i, i2, imageView, uri);
    }
}
