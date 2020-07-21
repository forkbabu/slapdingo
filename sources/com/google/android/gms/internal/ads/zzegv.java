package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
abstract class zzegv {
    private static final zzegv zzigd = new zzegx();
    private static final zzegv zzige = new zzeha();

    private zzegv() {
    }

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);

    static zzegv zzbgi() {
        return zzigd;
    }

    static zzegv zzbgj() {
        return zzige;
    }
}
