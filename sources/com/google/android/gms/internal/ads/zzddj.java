package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzddj implements zzdec<zzddk> {
    private final zzavy zzbqt;
    private final zzdvi zzgad;
    private final Context zzvr;

    public zzddj(zzavy zzavy, zzdvi zzdvi, Context context) {
        this.zzbqt = zzavy;
        this.zzgad = zzdvi;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzddk> zzaqm() {
        return this.zzgad.zze(new zzddm(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzddk zzaqz() throws Exception {
        String str;
        String str2;
        String str3;
        if (!this.zzbqt.zzac(this.zzvr)) {
            return new zzddk(null, null, null, null, null);
        }
        String zzaf = this.zzbqt.zzaf(this.zzvr);
        String str4 = zzaf == null ? "" : zzaf;
        String zzag = this.zzbqt.zzag(this.zzvr);
        if (zzag == null) {
            str = "";
        } else {
            str = zzag;
        }
        String zzah = this.zzbqt.zzah(this.zzvr);
        if (zzah == null) {
            str2 = "";
        } else {
            str2 = zzah;
        }
        String zzai = this.zzbqt.zzai(this.zzvr);
        if (zzai == null) {
            str3 = "";
        } else {
            str3 = zzai;
        }
        return new zzddk(str4, str, str2, str3, "TIME_OUT".equals(str) ? (Long) zzwg.zzpw().zzd(zzaav.zzcne) : null);
    }
}
