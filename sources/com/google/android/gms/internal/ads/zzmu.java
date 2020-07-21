package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzmu implements zznk {
    /* access modifiers changed from: private */
    public final int track;
    private final /* synthetic */ zzmp zzbdd;

    public zzmu(zzmp zzmp, int i) {
        this.zzbdd = zzmp;
        this.track = i;
    }

    @Override // com.google.android.gms.internal.ads.zznk
    public final boolean isReady() {
        return this.zzbdd.zzba(this.track);
    }

    @Override // com.google.android.gms.internal.ads.zznk
    public final void zzhr() throws IOException {
        this.zzbdd.zzhr();
    }

    @Override // com.google.android.gms.internal.ads.zznk
    public final int zzb(zzhs zzhs, zzjm zzjm, boolean z) {
        return this.zzbdd.zza(this.track, zzhs, zzjm, z);
    }

    @Override // com.google.android.gms.internal.ads.zznk
    public final void zzeh(long j) {
        this.zzbdd.zzd(this.track, j);
    }
}
