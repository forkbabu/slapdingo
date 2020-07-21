package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzaag<T> {
    private final int zzckq;
    private final T zzckr;
    private final String zzcn;

    private zzaag(int i, String str, T t) {
        this.zzckq = i;
        this.zzcn = str;
        this.zzckr = t;
        zzwg.zzpv().zza(this);
    }

    /* access modifiers changed from: protected */
    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract T zza(Bundle bundle);

    public abstract void zza(SharedPreferences.Editor editor, T t);

    /* access modifiers changed from: protected */
    public abstract T zzb(JSONObject jSONObject);

    public final String getKey() {
        return this.zzcn;
    }

    public final T zzrb() {
        return this.zzckr;
    }

    public static zzaag<Boolean> zza(int i, String str, Boolean bool) {
        return new zzaaj(i, str, bool);
    }

    public static zzaag<Integer> zza(int i, String str, int i2) {
        return new zzaai(1, str, Integer.valueOf(i2));
    }

    public static zzaag<Long> zzb(int i, String str, long j) {
        return new zzaal(1, str, Long.valueOf(j));
    }

    public static zzaag<Float> zza(int i, String str, float f) {
        return new zzaak(1, str, Float.valueOf(f));
    }

    public static zzaag<String> zza(int i, String str, String str2) {
        return new zzaan(1, str, str2);
    }

    public static zzaag<String> zzb(int i, String str) {
        zzaag<String> zza = zza(1, str, (String) null);
        zzwg.zzpv().zzc(zza);
        return zza;
    }

    public final int getSource() {
        return this.zzckq;
    }

    /* synthetic */ zzaag(int i, String str, Object obj, zzaaj zzaaj) {
        this(i, str, obj);
    }
}
