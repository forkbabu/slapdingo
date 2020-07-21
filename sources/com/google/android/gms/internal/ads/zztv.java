package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zztv {
    private final byte[] zzbxs;
    private int zzbxt;
    private int zzbxu;
    private final /* synthetic */ zztr zzbxv;

    private zztv(zztr zztr, byte[] bArr) {
        this.zzbxv = zztr;
        this.zzbxs = bArr;
    }

    public final synchronized void zzdx() {
        try {
            if (this.zzbxv.zzbxq) {
                this.zzbxv.zzbxp.zzc(this.zzbxs);
                this.zzbxv.zzbxp.zzr(this.zzbxt);
                this.zzbxv.zzbxp.zzs(this.zzbxu);
                this.zzbxv.zzbxp.zza(null);
                this.zzbxv.zzbxp.zzdx();
            }
        } catch (RemoteException e) {
            zzbba.zzb("Clearcut log failed", e);
        }
    }

    public final zztv zzbw(int i) {
        this.zzbxt = i;
        return this;
    }

    public final zztv zzbx(int i) {
        this.zzbxu = i;
        return this;
    }
}
