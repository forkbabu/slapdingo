package com.afollestad.materialdialogs.util;

import android.content.Context;
import android.graphics.Typeface;
import androidx.collection.SimpleArrayMap;

public class TypefaceHelper {
    private static final SimpleArrayMap<String, Typeface> cache = new SimpleArrayMap<>();

    public static Typeface get(Context context, String str) {
        synchronized (cache) {
            if (!cache.containsKey(str)) {
                try {
                    Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s", str));
                    cache.put(str, createFromAsset);
                    return createFromAsset;
                } catch (RuntimeException unused) {
                    return null;
                }
            } else {
                Typeface typeface = cache.get(str);
                return typeface;
            }
        }
    }
}
