package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzaby<T> extends zzabx<T> {
    @Override // com.google.android.gms.internal.ads.zzabx
    public static zzabx<Boolean> zzf(String str, boolean z) {
        return new zzaby(str, true, zzabz.zzcyq);
    }

    protected zzaby(String str, T t, Integer num) {
        super(str, t, num);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final T get() {
        if (zzacy.zzdbq.get()) {
            return super.get();
        }
        throw new IllegalStateException("Striped code is accessed: 54c42518-856a-44fb-aae0-cd6676d514e5");
    }
}
