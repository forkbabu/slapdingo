package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzckx {
    /* access modifiers changed from: private */
    public final Executor executor;
    /* access modifiers changed from: private */
    public final zzclc zzgeh;
    /* access modifiers changed from: private */
    public final Map<String, String> zzgel;

    public zzckx(zzclc zzclc, Executor executor2) {
        this.zzgeh = zzclc;
        this.zzgel = zzclc.zzaol();
        this.executor = executor2;
    }

    public final zzckw zzaok() {
        return new zzckw(this).zzaoh();
    }
}
