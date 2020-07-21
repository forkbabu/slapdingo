package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeeq extends zzees {
    private final int limit = this.zzhzu.size();
    private int position = 0;
    private final /* synthetic */ zzeer zzhzu;

    zzeeq(zzeer zzeer) {
        this.zzhzu = zzeer;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.ads.zzeew
    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzhzu.zzfu(i);
        }
        throw new NoSuchElementException();
    }
}
