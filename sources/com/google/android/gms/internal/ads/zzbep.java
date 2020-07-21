package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbep implements Iterable<zzben> {
    private final List<zzben> zzekd = new ArrayList();

    public static boolean zzc(zzbdb zzbdb) {
        zzben zzd = zzd(zzbdb);
        if (zzd == null) {
            return false;
        }
        zzd.zzekc.abort();
        return true;
    }

    static zzben zzd(zzbdb zzbdb) {
        Iterator<zzben> it2 = zzq.zzls().iterator();
        while (it2.hasNext()) {
            zzben next = it2.next();
            if (next.zzeez == zzbdb) {
                return next;
            }
        }
        return null;
    }

    public final void zza(zzben zzben) {
        this.zzekd.add(zzben);
    }

    public final void zzb(zzben zzben) {
        this.zzekd.remove(zzben);
    }

    @Override // java.lang.Iterable
    public final Iterator<zzben> iterator() {
        return this.zzekd.iterator();
    }
}
