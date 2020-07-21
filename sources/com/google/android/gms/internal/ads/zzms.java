package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzms implements zzow {
    private final Uri uri;
    private final zzok zzaoh;
    private final /* synthetic */ zzmp zzbdd;
    private final zzmv zzbdl;
    private final zzpd zzbdm;
    private final zzkd zzbef = new zzkd();
    private volatile boolean zzbeg;
    private boolean zzbeh = true;
    private long zzbei;
    /* access modifiers changed from: private */
    public long zzcp = -1;

    public zzms(zzmp zzmp, Uri uri2, zzok zzok, zzmv zzmv, zzpd zzpd) {
        this.zzbdd = zzmp;
        this.uri = (Uri) zzpb.checkNotNull(uri2);
        this.zzaoh = (zzok) zzpb.checkNotNull(zzok);
        this.zzbdl = (zzmv) zzpb.checkNotNull(zzmv);
        this.zzbdm = zzpd;
    }

    public final void zze(long j, long j2) {
        this.zzbef.position = j;
        this.zzbei = j2;
        this.zzbeh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzow
    public final void cancelLoad() {
        this.zzbeg = true;
    }

    @Override // com.google.android.gms.internal.ads.zzow
    public final boolean zzhw() {
        return this.zzbeg;
    }

    @Override // com.google.android.gms.internal.ads.zzow
    public final void zzhx() throws IOException, InterruptedException {
        int i = 0;
        while (i == 0 && !this.zzbeg) {
            zzju zzju = null;
            try {
                long j = this.zzbef.position;
                long zza = this.zzaoh.zza(new zzop(this.uri, j, -1, this.zzbdd.zzbdi));
                this.zzcp = zza;
                if (zza != -1) {
                    this.zzcp = zza + j;
                }
                zzju zzju2 = new zzju(this.zzaoh, j, this.zzcp);
                try {
                    zzjx zza2 = this.zzbdl.zza(zzju2, this.zzaoh.getUri());
                    if (this.zzbeh) {
                        zza2.zzc(j, this.zzbei);
                        this.zzbeh = false;
                    }
                    while (i == 0 && !this.zzbeg) {
                        this.zzbdm.block();
                        i = zza2.zza(zzju2, this.zzbef);
                        if (zzju2.getPosition() > this.zzbdd.zzbdj + j) {
                            j = zzju2.getPosition();
                            this.zzbdm.zzit();
                            this.zzbdd.handler.post(this.zzbdd.zzbdo);
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.zzbef.position = zzju2.getPosition();
                    }
                    zzpo.zza(this.zzaoh);
                } catch (Throwable th) {
                    th = th;
                    zzju = zzju2;
                    this.zzbef.position = zzju.getPosition();
                    zzpo.zza(this.zzaoh);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (!(i == 1 || zzju == null)) {
                    this.zzbef.position = zzju.getPosition();
                }
                zzpo.zza(this.zzaoh);
                throw th;
            }
        }
    }
}
