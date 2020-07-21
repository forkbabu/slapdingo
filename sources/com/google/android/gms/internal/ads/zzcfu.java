package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcfu {
    private final Executor zzflp;
    private final zzbyj zzfuz;
    private final zzbmh zzgbf;

    zzcfu(Executor executor, zzbmh zzbmh, zzbyj zzbyj) {
        this.zzflp = executor;
        this.zzfuz = zzbyj;
        this.zzgbf = zzbmh;
    }

    public final void zzl(zzbfn zzbfn) {
        if (zzbfn != null) {
            this.zzfuz.zzv(zzbfn.getView());
            this.zzfuz.zza(new zzcfx(zzbfn), this.zzflp);
            this.zzfuz.zza(new zzcfw(zzbfn), this.zzflp);
            this.zzfuz.zza(this.zzgbf, this.zzflp);
            this.zzgbf.zzg(zzbfn);
            zzbfn.zza("/trackActiveViewUnit", new zzcfz(this));
            zzbfn.zza("/untrackActiveViewUnit", new zzcfy(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzbfn zzbfn, Map map) {
        this.zzgbf.disable();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzbfn zzbfn, Map map) {
        this.zzgbf.enable();
    }
}
