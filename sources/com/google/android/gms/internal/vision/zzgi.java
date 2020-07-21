package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public class zzgi {
    private static volatile boolean zztk = false;
    private static boolean zztl = true;
    private static volatile zzgi zztm;
    private static volatile zzgi zztn;
    private static final zzgi zzto = new zzgi(true);
    private final Map<zza, zzgx.zzg<?, ?>> zztp;

    public static zzgi zzfl() {
        return new zzgi();
    }

    public static zzgi zzfm() {
        zzgi zzgi = zztm;
        if (zzgi == null) {
            synchronized (zzgi.class) {
                zzgi = zztm;
                if (zzgi == null) {
                    zzgi = zzto;
                    zztm = zzgi;
                }
            }
        }
        return zzgi;
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
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

    public static zzgi zzfn() {
        zzgi zzgi = zztn;
        if (zzgi != null) {
            return zzgi;
        }
        synchronized (zzgi.class) {
            zzgi zzgi2 = zztn;
            if (zzgi2 != null) {
                return zzgi2;
            }
            zzgi zzc = zzgw.zzc(zzgi.class);
            zztn = zzc;
            return zzc;
        }
    }

    public final <ContainingType extends zzih> zzgx.zzg<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zztp.get(new zza(containingtype, i));
    }

    public final void zza(zzgx.zzg<?, ?> zzg) {
        this.zztp.put(new zza(zzg.zzxo, zzg.zzxq.number), zzg);
    }

    zzgi() {
        this.zztp = new HashMap();
    }

    private zzgi(boolean z) {
        this.zztp = Collections.emptyMap();
    }
}
