package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzahz implements zzduh<zzahu, ParcelFileDescriptor> {
    private final /* synthetic */ zzaho zzdep;

    zzahz(zzahw zzahw, zzaho zzaho) {
        this.zzdep = zzaho;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdvf' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduh
    public final /* synthetic */ zzdvf<ParcelFileDescriptor> zzf(zzahu zzahu) throws Exception {
        zzbbn zzbbn = new zzbbn();
        zzahu.zza(this.zzdep, new zzahy(this, zzbbn));
        return zzbbn;
    }
}
