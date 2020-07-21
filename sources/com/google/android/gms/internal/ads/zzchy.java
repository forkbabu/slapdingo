package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zzc;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzchy {
    private final zzavr zzbof;
    private final zzeg zzemz;
    private final Executor zzflp;
    /* access modifiers changed from: private */
    public final zzbtl zzfpq;
    private final zzbui zzfty;
    private final zzbsk zzfuw;
    private final zzblu zzfux;
    private final zzbyj zzfuz;
    private final zzbtz zzgbx;
    private final zzbwj zzgby;
    private final zzc zzgcm;
    private final zzbtf zzgcn;
    /* access modifiers changed from: private */
    public final zzbwc zzgco;

    public zzchy(zzbsk zzbsk, zzbtl zzbtl, zzbtz zzbtz, zzbui zzbui, zzbwj zzbwj, Executor executor, zzbyj zzbyj, zzblu zzblu, zzc zzc, zzbtf zzbtf, zzavr zzavr, zzeg zzeg, zzbwc zzbwc) {
        this.zzfuw = zzbsk;
        this.zzfpq = zzbtl;
        this.zzgbx = zzbtz;
        this.zzfty = zzbui;
        this.zzgby = zzbwj;
        this.zzflp = executor;
        this.zzfuz = zzbyj;
        this.zzfux = zzblu;
        this.zzgcm = zzc;
        this.zzgcn = zzbtf;
        this.zzbof = zzavr;
        this.zzemz = zzeg;
        this.zzgco = zzbwc;
    }

    public final void zzb(zzbfn zzbfn, boolean z) {
        zzdw zzcb;
        zzbfn.zzaaz().zza(new zzcib(this), this.zzgbx, this.zzfty, new zzcia(this), new zzcid(this), z, null, this.zzgcm, new zzcii(this), this.zzbof);
        zzbfn.setOnTouchListener(new zzcic(this));
        zzbfn.setOnClickListener(new zzcif(this));
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcqh)).booleanValue() && (zzcb = this.zzemz.zzcb()) != null) {
            zzcb.zzb(zzbfn.getView());
        }
        this.zzfuz.zza(zzbfn, this.zzflp);
        this.zzfuz.zza(new zzcie(zzbfn), this.zzflp);
        this.zzfuz.zzv(zzbfn.getView());
        zzbfn.zza("/trackActiveViewUnit", new zzcih(this, zzbfn));
        this.zzfux.zzo(zzbfn);
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcnv)).booleanValue()) {
            zzbtf zzbtf = this.zzgcn;
            zzbfn.getClass();
            zzbtf.zza(zzcig.zzn(zzbfn), this.zzflp);
        }
    }

    public static zzdvf<?> zza(zzbfn zzbfn, String str, String str2) {
        zzbbn zzbbn = new zzbbn();
        zzbfn.zzaaz().zza(new zzcij(zzbbn));
        zzbfn.zzb(str, str2, null);
        return zzbbn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbfn zzbfn, zzbfn zzbfn2, Map map) {
        this.zzfux.zzf(zzbfn);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzae(View view) {
        this.zzgcm.recordClick();
        zzavr zzavr = this.zzbof;
        if (zzavr != null) {
            zzavr.zzvk();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean zza(View view, MotionEvent motionEvent) {
        this.zzgcm.recordClick();
        zzavr zzavr = this.zzbof;
        if (zzavr == null) {
            return false;
        }
        zzavr.zzvk();
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzang() {
        this.zzfpq.onAdLeftApplication();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(String str, String str2) {
        this.zzgby.onAppEvent(str, str2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzanh() {
        this.zzfuw.onAdClicked();
    }
}
