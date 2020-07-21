package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcob extends zzasf {
    private final /* synthetic */ zzcny zzghn;

    protected zzcob(zzcny zzcny) {
        this.zzghn = zzcny;
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzghn.zzdhu.set(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final void zza(zzazi zzazi) {
        this.zzghn.zzdhu.setException(new zzazh(zzazi.zzacl, zzazi.errorCode));
    }
}
