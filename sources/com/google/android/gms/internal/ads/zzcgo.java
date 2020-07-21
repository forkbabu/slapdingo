package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcgo implements zzahc<Object> {
    private final zzeku<zzcgl> zzfwf;
    private final zzcgr zzfyt;
    private final zzaez zzgbn;

    public zzcgo(zzccv zzccv, zzcck zzcck, zzcgr zzcgr, zzeku<zzcgl> zzeku) {
        this.zzgbn = zzccv.zzgd(zzcck.getCustomTemplateId());
        this.zzfyt = zzcgr;
        this.zzfwf = zzeku;
    }

    public final void zzamy() {
        if (this.zzgbn != null) {
            this.zzfyt.zza("/nativeAdCustomClick", this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahc
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("asset");
        try {
            this.zzgbn.zza(this.zzfwf.get(), str);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzaxv.zzd(sb.toString(), e);
        }
    }
}
