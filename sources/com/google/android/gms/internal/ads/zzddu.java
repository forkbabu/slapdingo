package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzddu implements zzela<zzdds> {
    private final zzelj<zzdir> zzfuh;

    private zzddu(zzelj<zzdir> zzelj) {
        this.zzfuh = zzelj;
    }

    public static zzddu zzaq(zzelj<zzdir> zzelj) {
        return new zzddu(zzelj);
    }

    public static zzdds zzb(zzdir zzdir) {
        return new zzdds(zzdir);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzb(this.zzfuh.get());
    }
}
