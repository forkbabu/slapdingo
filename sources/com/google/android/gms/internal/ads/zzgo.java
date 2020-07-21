package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public enum zzgo implements zzegg {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6);
    
    private static final zzegf<zzgo> zzes = new zzgn();
    private final int value;

    @Override // com.google.android.gms.internal.ads.zzegg
    public final int zzw() {
        return this.value;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    private zzgo(int i) {
        this.value = i;
    }
}
