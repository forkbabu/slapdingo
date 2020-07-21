package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzddn implements zzdec<zzddo> {
    private final zzbbd zzboy;
    private final zzdvi zzgad;
    private final Context zzvr;

    public zzddn(zzdvi zzdvi, Context context, zzbbd zzbbd) {
        this.zzgad = zzdvi;
        this.zzvr = context;
        this.zzboy = zzbbd;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzddo> zzaqm() {
        return this.zzgad.zze(new zzddq(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzddo zzara() throws Exception {
        boolean isCallerInstantApp = Wrappers.packageManager(this.zzvr).isCallerInstantApp();
        zzq.zzkw();
        boolean zzba = zzaye.zzba(this.zzvr);
        String str = this.zzboy.zzbpn;
        zzq.zzky();
        boolean zzxp = zzayj.zzxp();
        zzq.zzkw();
        return new zzddo(isCallerInstantApp, zzba, str, zzxp, zzaye.zzax(this.zzvr), DynamiteModule.getRemoteVersion(this.zzvr, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(this.zzvr, ModuleDescriptor.MODULE_ID));
    }
}
