package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzblf implements zzela<zzblc> {
    private final zzelj<zzaxx> zzexy;

    private zzblf(zzelj<zzaxx> zzelj) {
        this.zzexy = zzelj;
    }

    public static zzblf zza(zzelj<zzaxx> zzelj) {
        return new zzblf(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzblc(this.zzexy.get());
    }
}
