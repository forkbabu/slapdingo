package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdnf implements zzduu<zzdmw<AdT>> {
    private final /* synthetic */ zzdne zzhes;

    zzdnf(zzdne zzdne) {
        this.zzhes = zzdne;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        synchronized (this.zzhes) {
            this.zzhes.zzhep.zzb(th);
            this.zzhes.zzhem.setException(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(Object obj) {
        zzdmw<?> zzdmw = (zzdmw) obj;
        synchronized (this.zzhes) {
            this.zzhes.zzhep.zza(zzdmw);
            if (this.zzhes.zzheo != zzdmu.zzhdz) {
                this.zzhes.zzgxz.zza(this.zzhes.zzhel.zzary(), zzdmw);
            }
            if (this.zzhes.zzheo == zzdmu.zzhdy) {
                this.zzhes.zzd(this.zzhes.zzhel);
            }
            int unused = this.zzhes.zzheo = zzdmu.zzhdy;
            this.zzhes.zzhem.set(zzdmw);
        }
    }
}
