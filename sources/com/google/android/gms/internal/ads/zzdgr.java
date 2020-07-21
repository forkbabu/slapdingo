package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzbxa;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdgr implements zzcxn<zzbmw> {
    /* access modifiers changed from: private */
    public final Executor zzflp;
    private final ViewGroup zzfng;
    private final zzdlc zzgow;
    /* access modifiers changed from: private */
    @Nullable
    public zzdvf<zzbmw> zzgph;
    private final zzbif zzgqt;
    private final Context zzgwa;
    /* access modifiers changed from: private */
    public final zzdhi zzgwb;
    /* access modifiers changed from: private */
    public final zzdil<zzbmq, zzbmw> zzgwc;

    public zzdgr(Context context, Executor executor, zzbif zzbif, zzdil<zzbmq, zzbmw> zzdil, zzdhi zzdhi, zzdlc zzdlc) {
        this.zzgwa = context;
        this.zzflp = executor;
        this.zzgqt = zzbif;
        this.zzgwc = zzdil;
        this.zzgwb = zzdhi;
        this.zzgow = zzdlc;
        this.zzfng = new FrameLayout(context);
    }

    @Override // com.google.android.gms.internal.ads.zzcxn
    public final boolean isLoading() {
        zzdvf<zzbmw> zzdvf = this.zzgph;
        return zzdvf != null && !zzdvf.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzcxn
    public final synchronized boolean zza(zzve zzve, String str, zzcxm zzcxm, zzcxp<? super zzbmw> zzcxp) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (str == null) {
            zzaxv.zzfb("Ad unit ID should not be null for app open ad.");
            this.zzflp.execute(new zzdgu(this));
            return false;
        } else if (this.zzgph != null) {
            return false;
        } else {
            zzdlj.zze(this.zzgwa, zzve.zzcgv);
            zzdla zzaso = this.zzgow.zzgs(str).zzd(zzvh.zzpj()).zzh(zzve).zzaso();
            zzdgy zzdgy = new zzdgy(null);
            zzdgy.zzfpv = zzaso;
            zzdvf<zzbmw> zza = this.zzgwc.zza(new zzdiq(zzdgy), new zzdgt(this));
            this.zzgph = zza;
            zzdux.zza(zza, new zzdgw(this, zzcxp, zzdgy), this.zzflp);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final synchronized zzbmt zzb(zzdio zzdio) {
        zzdgy zzdgy = (zzdgy) zzdio;
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcxl)).booleanValue()) {
            return this.zzgqt.zzadm().zza(new zzbnb(this.zzfng)).zzb(new zzbrx.zza().zzce(this.zzgwa).zza(zzdgy.zzfpv).zzaiz()).zzb(new zzbxa.zza().zzajw());
        }
        zzdhi zzb = zzdhi.zzb(this.zzgwb);
        zzbxa.zza zza = new zzbxa.zza();
        zza.zza((zzbsq) zzb, this.zzflp);
        zza.zza((zzbuf) zzb, this.zzflp);
        zza.zza(zzb);
        return this.zzgqt.zzadm().zza(new zzbnb(this.zzfng)).zzb(new zzbrx.zza().zzce(this.zzgwa).zza(zzdgy.zzfpv).zzaiz()).zzb(zza.zzajw());
    }

    public final void zza(zzvo zzvo) {
        this.zzgow.zzb(zzvo);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzarq() {
        this.zzgwb.onAdFailedToLoad(1);
    }
}
