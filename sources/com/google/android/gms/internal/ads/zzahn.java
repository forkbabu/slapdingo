package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzahn implements zzahc<Object> {
    private final zzahm zzdek;

    public static void zza(zzbfn zzbfn, zzahm zzahm) {
        zzbfn.zza("/reward", new zzahn(zzahm));
    }

    private zzahn(zzahm zzahm) {
        this.zzdek = zzahm;
    }

    @Override // com.google.android.gms.internal.ads.zzahc
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zzaub zzaub = null;
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzaub = new zzaub(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzaxv.zzd("Unable to parse reward amount.", e);
            }
            this.zzdek.zza(zzaub);
        } else if ("video_start".equals(str)) {
            this.zzdek.zzsq();
        } else if ("video_complete".equals(str)) {
            this.zzdek.zzsr();
        }
    }
}
