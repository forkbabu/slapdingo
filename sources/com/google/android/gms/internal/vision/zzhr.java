package com.google.android.gms.internal.vision;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
abstract class zzhr {
    private static final zzhr zzyt = new zzht();
    private static final zzhr zzyu = new zzhs();

    private zzhr() {
    }

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);

    static zzhr zzha() {
        return zzyt;
    }

    static zzhr zzhb() {
        return zzyu;
    }
}
