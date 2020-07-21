package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzxy implements MuteThisAdReason {
    private final String description;
    private zzxt zzciw;

    public zzxy(zzxt zzxt) {
        String str;
        this.zzciw = zzxt;
        try {
            str = zzxt.getDescription();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            str = null;
        }
        this.description = str;
    }

    @Override // com.google.android.gms.ads.MuteThisAdReason
    public final String getDescription() {
        return this.description;
    }

    public final zzxt zzqh() {
        return this.zzciw;
    }

    public final String toString() {
        return this.description;
    }
}
