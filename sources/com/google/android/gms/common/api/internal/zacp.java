package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001authapi.zzk;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zacp {
    public static final Status zalb = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult<?>[] zalc = new BasePendingResult[0];
    private final Map<Api.AnyClientKey<?>, Api.Client> zahd;
    final Set<BasePendingResult<?>> zald = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zacq zale = new zaco(this);

    public zacp(Map<Api.AnyClientKey<?>, Api.Client> map) {
        this.zahd = map;
    }

    /* access modifiers changed from: package-private */
    public final void zac(BasePendingResult<? extends Result> basePendingResult) {
        this.zald.add(basePendingResult);
        basePendingResult.zaa(this.zale);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.google.android.gms.common.api.internal.BasePendingResult[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.google.android.gms.internal.auth-api.zzk} */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.android.gms.common.api.ResultCallback, com.google.android.gms.common.api.zac, com.google.android.gms.common.api.internal.zacq, com.google.android.gms.common.api.internal.zaco] */
    public final void release() {
        BasePendingResult[] basePendingResultArr = (BasePendingResult[]) this.zald.toArray(zalc);
        for (zzk zzk : basePendingResultArr) {
            ? r5 = 0;
            zzk.zaa((zacq) r5);
            if (zzk.zal() != null) {
                zzk.setResultCallback(r5);
                IBinder serviceBrokerBinder = this.zahd.get(zzk.getClientKey()).getServiceBrokerBinder();
                if (zzk.isReady()) {
                    zzk.zaa(new zacr(zzk, r5, serviceBrokerBinder, r5));
                } else if (serviceBrokerBinder == null || !serviceBrokerBinder.isBinderAlive()) {
                    zzk.zaa((zacq) r5);
                    zzk.cancel();
                    r5.remove(zzk.zal().intValue());
                } else {
                    zacr zacr = new zacr(zzk, r5, serviceBrokerBinder, r5);
                    zzk.zaa(zacr);
                    try {
                        serviceBrokerBinder.linkToDeath(zacr, 0);
                    } catch (RemoteException unused) {
                        zzk.cancel();
                        r5.remove(zzk.zal().intValue());
                    }
                }
                this.zald.remove(zzk);
            } else if (zzk.zaq()) {
                this.zald.remove(zzk);
            }
        }
    }

    public final void zabv() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.zald.toArray(zalc)) {
            basePendingResult.zab(zalb);
        }
    }
}
