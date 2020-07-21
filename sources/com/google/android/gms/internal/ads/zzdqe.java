package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final /* synthetic */ class zzdqe implements OnFailureListener {
    private final zzdpz zzhii;

    zzdqe(zzdpz zzdpz) {
        this.zzhii = zzdpz;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.zzhii.zzc(exc);
    }
}
