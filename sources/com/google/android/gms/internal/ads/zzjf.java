package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzjf {
    private int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean zzgg() {
        return zzac(Integer.MIN_VALUE);
    }

    public final boolean zzgh() {
        return zzac(4);
    }

    public final boolean zzgi() {
        return zzac(1);
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public final void zzab(int i) {
        this.flags |= Integer.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public final boolean zzac(int i) {
        return (this.flags & i) == i;
    }
}
