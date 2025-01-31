package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.4 */
final class zzbk extends zzag.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ boolean zzf;
    private final /* synthetic */ zzag zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbk(zzag zzag, String str, String str2, Object obj, boolean z) {
        super(zzag);
        this.zzg = zzag;
        this.zzc = str;
        this.zzd = str2;
        this.zze = obj;
        this.zzf = z;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() throws RemoteException {
        this.zzg.zzm.setUserProperty(this.zzc, this.zzd, ObjectWrapper.wrap(this.zze), this.zzf, this.zza);
    }
}
