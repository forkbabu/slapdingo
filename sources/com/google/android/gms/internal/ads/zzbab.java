package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbab {
    private Map<Integer, Bitmap> zzebt = new ConcurrentHashMap();
    private AtomicInteger zzebu = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return this.zzebt.get(num);
    }
}
