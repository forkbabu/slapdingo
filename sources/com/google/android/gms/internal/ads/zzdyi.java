package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdyi extends zzdwl<zzdwf, zzeaq> {
    zzdyi(Class cls) {
        super(cls);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdwl
    public final /* synthetic */ zzdwf zzag(zzeaq zzeaq) throws GeneralSecurityException {
        zzeaq zzeaq2 = zzeaq;
        zzeam zzazo = zzeaq2.zzazo();
        zzeat zzazq = zzazo.zzazq();
        return new zzecy(zzedc.zza(zzdyq.zza(zzazq.zzbad()), zzeaq2.zzazy().toByteArray(), zzeaq2.zzazz().toByteArray()), zzazq.zzbaf().toByteArray(), zzdyq.zza(zzazq.zzbae()), zzdyq.zza(zzazo.zzazs()), new zzdys(zzazo.zzazr().zzazl()));
    }
}
