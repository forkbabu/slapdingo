package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class zzabx<T> {
    private final T zzckr;
    private final String zzcn;
    private final int zzcyp;

    public static zzabx<Boolean> zzf(String str, boolean z) {
        return new zzabx<>(str, Boolean.valueOf(z), zzabz.zzcyq);
    }

    public static zzabx<Long> zzb(String str, long j) {
        return new zzabx<>(str, Long.valueOf(j), zzabz.zzcyr);
    }

    public static zzabx<Double> zzb(String str, double d) {
        return new zzabx<>(str, Double.valueOf(d), zzabz.zzcys);
    }

    public static zzabx<String> zzi(String str, String str2) {
        return new zzabx<>(str, str2, zzabz.zzcyt);
    }

    protected zzabx(String str, T t, Integer num) {
        this.zzcn = str;
        this.zzckr = t;
        this.zzcyp = num;
    }

    public T get() {
        zzacz zzrs = zzacy.zzrs();
        if (zzrs != null) {
            int i = zzabw.zzcyo[this.zzcyp - 1];
            if (i == 1) {
                return zzrs.zze(this.zzcn, this.zzckr.booleanValue());
            }
            if (i == 2) {
                return zzrs.getLong(this.zzcn, this.zzckr.longValue());
            }
            if (i == 3) {
                return zzrs.zza(this.zzcn, this.zzckr.doubleValue());
            }
            if (i == 4) {
                return zzrs.get(this.zzcn, this.zzckr);
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException("Flag is not initialized.");
    }
}
