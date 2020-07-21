package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzbxa;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdjq implements zzcxn<zzchj> {
    /* access modifiers changed from: private */
    public final Executor zzflp;
    private final zzdkv zzfri;
    private final zzdlc zzgow;
    private final zzbif zzgqt;
    private final Context zzgwa;
    /* access modifiers changed from: private */
    public final zzdil<zzchm, zzchj> zzgwc;
    /* access modifiers changed from: private */
    public final zzdiu zzgys;
    private zzdvf<zzchj> zzgyt;

    public zzdjq(Context context, Executor executor, zzbif zzbif, zzdil<zzchm, zzchj> zzdil, zzdiu zzdiu, zzdlc zzdlc, zzdkv zzdkv) {
        this.zzgwa = context;
        this.zzflp = executor;
        this.zzgqt = zzbif;
        this.zzgwc = zzdil;
        this.zzgys = zzdiu;
        this.zzgow = zzdlc;
        this.zzfri = zzdkv;
    }

    @Override // com.google.android.gms.internal.ads.zzcxn
    public final boolean isLoading() {
        zzdvf<zzchj> zzdvf = this.zzgyt;
        return zzdvf != null && !zzdvf.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzcxn
    public final boolean zza(zzve zzve, String str, zzcxm zzcxm, zzcxp<? super zzchj> zzcxp) throws RemoteException {
        zzatw zzatw = new zzatw(zzve, str);
        String str2 = zzcxm instanceof zzdjn ? ((zzdjn) zzcxm).zzgyq : null;
        if (zzatw.zzbum == null) {
            zzaxv.zzfb("Ad unit ID should not be null for rewarded video ad.");
            this.zzflp.execute(new zzdjp(this));
            return false;
        }
        zzdvf<zzchj> zzdvf = this.zzgyt;
        if (zzdvf != null && !zzdvf.isDone()) {
            return false;
        }
        zzdlj.zze(this.zzgwa, zzatw.zzdpj.zzcgv);
        zzdla zzaso = this.zzgow.zzgs(zzatw.zzbum).zzd(zzvh.zzpi()).zzh(zzatw.zzdpj).zzaso();
        zzdjw zzdjw = new zzdjw(null);
        zzdjw.zzfpv = zzaso;
        zzdjw.zzgyq = str2;
        zzdvf<zzchj> zza = this.zzgwc.zza(new zzdiq(zzdjw), new zzdjs(this));
        this.zzgyt = zza;
        zzdux.zza(zza, new zzdjr(this, zzcxp, zzdjw), this.zzflp);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void zzdy(int i) {
        this.zzgow.zzasn().zzdz(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzchp zze(zzdio zzdio) {
        zzdjw zzdjw = (zzdjw) zzdio;
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcxk)).booleanValue()) {
            return this.zzgqt.zzadq().zze(new zzbrx.zza().zzce(this.zzgwa).zza(zzdjw.zzfpv).zzfw(zzdjw.zzgyq).zza(this.zzfri).zzaiz()).zze(new zzbxa.zza().zzajw());
        }
        zzdiu zzb = zzdiu.zzb(this.zzgys);
        return this.zzgqt.zzadq().zze(new zzbrx.zza().zzce(this.zzgwa).zza(zzdjw.zzfpv).zzfw(zzdjw.zzgyq).zza(this.zzfri).zzaiz()).zze(new zzbxa.zza().zza((zzbsl) zzb, this.zzflp).zza((zzbua) zzb, this.zzflp).zza((zzbsq) zzb, this.zzflp).zza((AdMetadataListener) zzb, this.zzflp).zza((zzbsz) zzb, this.zzflp).zza((zzbup) zzb, this.zzflp).zza(zzb).zzajw());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzasc() {
        this.zzgys.onAdFailedToLoad(1);
    }
}
