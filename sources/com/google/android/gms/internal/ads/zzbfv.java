package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbfv {
    public static zzdvf<zzbfn> zza(Context context, zzbbd zzbbd, String str, zzeg zzeg, zza zza) {
        return zzdux.zzb(zzdux.zzaf(null), new zzbfy(context, zzeg, zzbbd, zza, str), zzbbf.zzedl);
    }

    public static zzbfn zza(Context context, zzbhg zzbhg, String str, boolean z, boolean z2, zzeg zzeg, zzbbd zzbbd, zzabi zzabi, zzi zzi, zza zza, zztm zztm, zzso zzso, boolean z3) throws zzbfz {
        zzaav.initialize(context);
        if (zzacw.zzdbm.get().booleanValue()) {
            return zzbhm.zza(context, zzbhg, str, z, z2, zzeg, zzbbd, null, zzi, zza, zztm, zzso, z3);
        }
        try {
            return (zzbfn) zzbai.zza(new zzbfx(context, zzbhg, str, z, z2, zzeg, zzbbd, null, zzi, zza, zztm, zzso, z3));
        } catch (Throwable th) {
            throw new zzbfz("Webview initialization failed.", th);
        }
    }
}
