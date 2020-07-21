package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class zzare {
    private static zzawr zzdou;
    private final zzyq zzacs;
    private final AdFormat zzdot;
    private final Context zzvr;

    public static zzawr zzs(Context context) {
        zzawr zzawr;
        synchronized (zzare.class) {
            if (zzdou == null) {
                zzdou = zzwg.zzpt().zza(context, new zzamo());
            }
            zzawr = zzdou;
        }
        return zzawr;
    }

    public zzare(Context context, AdFormat adFormat, zzyq zzyq) {
        this.zzvr = context;
        this.zzdot = adFormat;
        this.zzacs = zzyq;
    }

    public final void zza(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzve zzve;
        zzawr zzs = zzs(this.zzvr);
        if (zzs == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzvr);
        zzyq zzyq = this.zzacs;
        if (zzyq == null) {
            zzve = new zzvd().zzpg();
        } else {
            zzve = zzvf.zza(this.zzvr, zzyq);
        }
        try {
            zzs.zza(wrap, new zzawx(null, this.zzdot.name(), null, zzve), new zzard(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
