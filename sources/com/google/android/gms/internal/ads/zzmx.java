package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzmx implements zzna, zznb {
    private final Uri uri;
    private final Handler zzaek;
    private final zzic zzaeo;
    private zzia zzaev;
    private final int zzbde;
    private final zzmw zzbdf;
    private zzna zzbdg;
    private final String zzbdi = null;
    private final zzon zzbem;
    private final zzjy zzben;
    private final int zzbeo;
    private boolean zzbep;

    public zzmx(Uri uri2, zzon zzon, zzjy zzjy, int i, Handler handler, zzmw zzmw, String str, int i2) {
        this.uri = uri2;
        this.zzbem = zzon;
        this.zzben = zzjy;
        this.zzbde = i;
        this.zzaek = handler;
        this.zzbdf = zzmw;
        this.zzbeo = i2;
        this.zzaeo = new zzic();
    }

    @Override // com.google.android.gms.internal.ads.zznb
    public final void zzhy() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zznb
    public final void zza(zzhe zzhe, boolean z, zzna zzna) {
        this.zzbdg = zzna;
        zznp zznp = new zznp(-9223372036854775807L, false);
        this.zzaev = zznp;
        zzna.zzb(zznp, null);
    }

    @Override // com.google.android.gms.internal.ads.zznb
    public final zzmz zza(int i, zzoi zzoi) {
        zzpb.checkArgument(i == 0);
        return new zzmp(this.uri, this.zzbem.zzio(), this.zzben.zzgq(), this.zzbde, this.zzaek, this.zzbdf, this, zzoi, null, this.zzbeo);
    }

    @Override // com.google.android.gms.internal.ads.zznb
    public final void zzb(zzmz zzmz) {
        ((zzmp) zzmz).release();
    }

    @Override // com.google.android.gms.internal.ads.zznb
    public final void zzhz() {
        this.zzbdg = null;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzb(zzia zzia, Object obj) {
        boolean z = false;
        if (zzia.zza(0, this.zzaeo, false).zzaih != -9223372036854775807L) {
            z = true;
        }
        if (!this.zzbep || z) {
            this.zzaev = zzia;
            this.zzbep = z;
            this.zzbdg.zzb(zzia, null);
        }
    }
}
