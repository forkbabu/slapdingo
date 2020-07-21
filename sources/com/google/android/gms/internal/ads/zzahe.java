package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzahe implements zzahc<Object> {
    private final Context zzvr;

    public zzahe(Context context) {
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzahc
    public final void zza(Object obj, Map<String, String> map) {
        if (zzq.zzlu().zzac(this.zzvr)) {
            String str = map.get("eventName");
            String str2 = map.get("eventId");
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 94399) {
                if (hashCode != 94401) {
                    if (hashCode == 94407 && str.equals("_ai")) {
                        c = 1;
                    }
                } else if (str.equals("_ac")) {
                    c = 0;
                }
            } else if (str.equals("_aa")) {
                c = 2;
            }
            if (c == 0) {
                zzq.zzlu().zzi(this.zzvr, str2);
            } else if (c == 1) {
                zzq.zzlu().zzj(this.zzvr, str2);
            } else if (c != 2) {
                zzaxv.zzfb("logScionEvent gmsg contained unsupported eventName");
            } else {
                zzq.zzlu().zzl(this.zzvr, str2);
            }
        }
    }
}
