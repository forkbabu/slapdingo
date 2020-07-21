package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class zzefo {
    private static volatile boolean zzibc = false;
    private static boolean zzibd = true;
    private static volatile zzefo zzibe;
    private static volatile zzefo zzibf;
    private static final zzefo zzibg = new zzefo(true);
    private final Map<zza, zzegb.zzf<?, ?>> zzibh;

    public static zzefo zzbeq() {
        zzefo zzefo = zzibe;
        if (zzefo == null) {
            synchronized (zzefo.class) {
                zzefo = zzibe;
                if (zzefo == null) {
                    zzefo = zzibg;
                    zzibe = zzefo;
                }
            }
        }
        return zzefo;
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }
    }

    public static zzefo zzber() {
        zzefo zzefo = zzibf;
        if (zzefo != null) {
            return zzefo;
        }
        synchronized (zzefo.class) {
            zzefo zzefo2 = zzibf;
            if (zzefo2 != null) {
                return zzefo2;
            }
            zzefo zzc = zzefz.zzc(zzefo.class);
            zzibf = zzc;
            return zzc;
        }
    }

    public final <ContainingType extends zzehl> zzegb.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzibh.get(new zza(containingtype, i));
    }

    zzefo() {
        this.zzibh = new HashMap();
    }

    private zzefo(boolean z) {
        this.zzibh = Collections.emptyMap();
    }
}
