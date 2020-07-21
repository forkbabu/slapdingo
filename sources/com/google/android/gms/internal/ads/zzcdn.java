package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcdn implements View.OnClickListener {
    private final Clock zzbqd;
    private final zzcgr zzfyt;
    private zzafo zzfyu;
    private zzahc<Object> zzfyv;
    String zzfyw;
    Long zzfyx;
    WeakReference<View> zzfyy;

    public zzcdn(zzcgr zzcgr, Clock clock) {
        this.zzfyt = zzcgr;
        this.zzbqd = clock;
    }

    public final void zza(zzafo zzafo) {
        this.zzfyu = zzafo;
        zzahc<Object> zzahc = this.zzfyv;
        if (zzahc != null) {
            this.zzfyt.zzb("/unconfirmedClick", zzahc);
        }
        zzcdm zzcdm = new zzcdm(this, zzafo);
        this.zzfyv = zzcdm;
        this.zzfyt.zza("/unconfirmedClick", zzcdm);
    }

    public final zzafo zzamp() {
        return this.zzfyu;
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzfyu != null && this.zzfyx != null) {
            zzamq();
            try {
                this.zzfyu.onUnconfirmedClickCancelled();
            } catch (RemoteException e) {
                zzbba.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void onClick(View view) {
        WeakReference<View> weakReference = this.zzfyy;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.zzfyw == null || this.zzfyx == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zzfyw);
                hashMap.put("time_interval", String.valueOf(this.zzbqd.currentTimeMillis() - this.zzfyx.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.zzfyt.zza("sendMessageToNativeJs", hashMap);
            }
            zzamq();
        }
    }

    private final void zzamq() {
        View view;
        this.zzfyw = null;
        this.zzfyx = null;
        WeakReference<View> weakReference = this.zzfyy;
        if (weakReference != null && (view = weakReference.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener(null);
            this.zzfyy = null;
        }
    }
}
