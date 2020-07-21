package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcwh {
    private final zzcix zzgfm;
    private final ConcurrentHashMap<String, zzaox> zzgom = new ConcurrentHashMap<>();

    public zzcwh(zzcix zzcix) {
        this.zzgfm = zzcix;
    }

    public final void zzgn(String str) {
        try {
            this.zzgom.put(str, this.zzgfm.zzdl(str));
        } catch (RemoteException e) {
            zzaxv.zzc("Couldn't create RTB adapter : ", e);
        }
    }

    @CheckForNull
    public final zzaox zzgo(String str) {
        if (this.zzgom.containsKey(str)) {
            return this.zzgom.get(str);
        }
        return null;
    }
}
