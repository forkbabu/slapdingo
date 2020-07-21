package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzfp extends zzfr {
    private final int limit = this.zzsp.size();
    private int position = 0;
    private final /* synthetic */ zzfm zzsp;

    zzfp(zzfm zzfm) {
        this.zzsp = zzfm;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.vision.zzfv
    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzsp.zzap(i);
        }
        throw new NoSuchElementException();
    }
}
