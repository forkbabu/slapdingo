package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzq;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbhm {
    public static zzbfn zza(Context context, zzbhg zzbhg, String str, boolean z, boolean z2, zzeg zzeg, zzbbd zzbbd, zzabi zzabi, zzi zzi, zza zza, zztm zztm, zzso zzso, boolean z3) throws zzbfz {
        try {
            return (zzbfn) zzbai.zza(new zzbhl(context, zzbhg, str, z, z2, zzeg, zzbbd, null, zzi, zza, zztm, zzso, z3));
        } catch (Throwable th) {
            zzq.zzla().zza(th, "AdWebViewFactory.newAdWebView2");
            throw new zzbfz("Webview initialization failed.", th);
        }
    }
}
