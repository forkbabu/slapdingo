package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdbh implements zzdec<zzdbm> {
    private final Context zzaah;
    private final zzdvi zzgad;

    zzdbh(Context context, zzdvi zzdvi) {
        this.zzaah = context;
        this.zzgad = zzdvi;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdbm> zzaqm() {
        return this.zzgad.zze(new zzdbk(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdbm zzaqs() throws Exception {
        zzq.zzkw();
        String zzbb = zzaye.zzbb(this.zzaah);
        String str = "";
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcvk)).booleanValue()) {
            str = this.zzaah.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", str);
        }
        zzq.zzkw();
        return new zzdbm(zzbb, str, zzaye.zzbc(this.zzaah));
    }
}
