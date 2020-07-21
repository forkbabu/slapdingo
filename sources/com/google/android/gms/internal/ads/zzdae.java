package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdae implements zzdec<Object> {
    private static final Object lock = new Object();
    private final String zzcio;
    private final String zzdpm;
    private final zzdla zzfpv;
    private final zzbqk zzgse;
    private final zzdlv zzgsf;

    public zzdae(String str, String str2, zzbqk zzbqk, zzdlv zzdlv, zzdla zzdla) {
        this.zzdpm = str;
        this.zzcio = str2;
        this.zzgse = zzbqk;
        this.zzgsf = zzdlv;
        this.zzfpv = zzdla;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<Object> zzaqm() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcuj)).booleanValue()) {
            this.zzgse.zzf(this.zzfpv.zzhay);
            bundle.putAll(this.zzgsf.zzasu());
        }
        return zzdux.zzaf(new zzdad(this, bundle));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Bundle bundle, Bundle bundle2) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcuj)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcui)).booleanValue()) {
                synchronized (lock) {
                    this.zzgse.zzf(this.zzfpv.zzhay);
                    bundle2.putBundle("quality_signals", this.zzgsf.zzasu());
                }
            } else {
                this.zzgse.zzf(this.zzfpv.zzhay);
                bundle2.putBundle("quality_signals", this.zzgsf.zzasu());
            }
        }
        bundle2.putString("seq_num", this.zzdpm);
        bundle2.putString("session_id", this.zzcio);
    }
}
