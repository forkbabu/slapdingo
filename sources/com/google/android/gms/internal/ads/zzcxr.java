package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzbxa;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcxr implements zzcxn<zzbpb> {
    /* access modifiers changed from: private */
    public final zzbif zzgmd;
    private final Context zzgov;
    private final zzdlc zzgow;
    /* access modifiers changed from: private */
    public final zzcxl zzgqg;
    private zzbpi zzgqh;

    public zzcxr(zzbif zzbif, Context context, zzcxl zzcxl, zzdlc zzdlc) {
        this.zzgmd = zzbif;
        this.zzgov = context;
        this.zzgqg = zzcxl;
        this.zzgow = zzdlc;
    }

    @Override // com.google.android.gms.internal.ads.zzcxn
    public final boolean isLoading() {
        zzbpi zzbpi = this.zzgqh;
        return zzbpi != null && zzbpi.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzcxn
    public final boolean zza(zzve zzve, String str, zzcxm zzcxm, zzcxp<? super zzbpb> zzcxp) throws RemoteException {
        zzcbc zzcbc;
        zzq.zzkw();
        if (zzaye.zzbf(this.zzgov) && zzve.zzchg == null) {
            zzaxv.zzfb("Failed to load the ad because app ID is missing.");
            this.zzgmd.zzade().execute(new zzcxq(this));
            return false;
        } else if (str == null) {
            zzaxv.zzfb("Ad unit ID should not be null for NativeAdLoader.");
            this.zzgmd.zzade().execute(new zzcxt(this));
            return false;
        } else {
            zzdlj.zze(this.zzgov, zzve.zzcgv);
            zzdla zzaso = this.zzgow.zzh(zzve).zzea(zzcxm instanceof zzcxo ? ((zzcxo) zzcxm).zzgqe : 1).zzaso();
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcxn)).booleanValue()) {
                zzcbc = this.zzgmd.zzadp().zza(new zzbrx.zza().zzce(this.zzgov).zza(zzaso).zzaiz()).zza(new zzbxa.zza().zzajw()).zza(this.zzgqg.zzapz()).zzaef();
            } else {
                zzcbc = this.zzgmd.zzadp().zza(new zzbrx.zza().zzce(this.zzgov).zza(zzaso).zzaiz()).zza(new zzbxa.zza().zza(this.zzgqg.zzaqc(), this.zzgmd.zzade()).zza(this.zzgqg.zzaqd(), this.zzgmd.zzade()).zza(this.zzgqg.zzaqe(), this.zzgmd.zzade()).zza(this.zzgqg.zzaqf(), this.zzgmd.zzade()).zza(this.zzgqg.zzaqb(), this.zzgmd.zzade()).zza(zzaso.zzhbe, this.zzgmd.zzade()).zzajw()).zza(this.zzgqg.zzapz()).zzaef();
            }
            this.zzgmd.zzadu().zzeb(1);
            zzbpi zzbpi = new zzbpi(this.zzgmd.zzadg(), this.zzgmd.zzadf(), zzcbc.zzaex().zzaiq());
            this.zzgqh = zzbpi;
            zzbpi.zza(new zzcxs(this, zzcxp, zzcbc));
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaqg() {
        this.zzgqg.zzaqd().onAdFailedToLoad(1);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaqh() {
        this.zzgqg.zzaqd().onAdFailedToLoad(8);
    }
}
