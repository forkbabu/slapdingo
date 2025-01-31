package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.4 */
final class zzbq extends zzag.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzt zzd;
    private final /* synthetic */ zzag.zzc zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbq(zzag.zzc zzc2, Activity activity, zzt zzt) {
        super(zzag.this);
        this.zze = zzc2;
        this.zzc = activity;
        this.zzd = zzt;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() throws RemoteException {
        zzag.this.zzm.onActivitySaveInstanceState(ObjectWrapper.wrap(this.zzc), this.zzd, this.zzb);
    }
}
