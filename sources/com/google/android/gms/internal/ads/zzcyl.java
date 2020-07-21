package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import java.util.ArrayList;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcyl implements zzduu<ArrayList<Uri>> {
    private final /* synthetic */ zzaqz zzgqy;

    zzcyl(zzcxz zzcxz, zzaqz zzaqz) {
        this.zzgqy = zzaqz;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        try {
            zzaqz zzaqz = this.zzgqy;
            String valueOf = String.valueOf(th.getMessage());
            zzaqz.onError(valueOf.length() != 0 ? "Internal error: ".concat(valueOf) : new String("Internal error: "));
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(@Nonnull ArrayList<Uri> arrayList) {
        try {
            this.zzgqy.onSuccess(arrayList);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }
}
