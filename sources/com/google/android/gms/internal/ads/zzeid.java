package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeid extends zzees {
    private final zzeif zzihp = new zzeif(this.zzihr, null);
    private zzeew zzihq = zzbhc();
    private final /* synthetic */ zzeie zzihr;

    zzeid(zzeie zzeie) {
        this.zzihr = zzeie;
    }

    private final zzeew zzbhc() {
        if (this.zzihp.hasNext()) {
            return (zzeew) ((zzeey) this.zzihp.next()).iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zzihq != null;
    }

    @Override // com.google.android.gms.internal.ads.zzeew
    public final byte nextByte() {
        zzeew zzeew = this.zzihq;
        if (zzeew != null) {
            byte nextByte = zzeew.nextByte();
            if (!this.zzihq.hasNext()) {
                this.zzihq = zzbhc();
            }
            return nextByte;
        }
        throw new NoSuchElementException();
    }
}
