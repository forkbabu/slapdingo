package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeic implements zzehj {
    private final int flags;
    private final String info;
    private final Object[] zzigt;
    private final zzehl zzigw;

    zzeic(zzehl zzehl, String str, Object[] objArr) {
        this.zzigw = zzehl;
        this.info = str;
        this.zzigt = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzbha() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzbhb() {
        return this.zzigt;
    }

    @Override // com.google.android.gms.internal.ads.zzehj
    public final zzehl zzbgr() {
        return this.zzigw;
    }

    @Override // com.google.android.gms.internal.ads.zzehj
    public final int zzbgp() {
        return (this.flags & 1) == 1 ? zzegb.zze.zziew : zzegb.zze.zziex;
    }

    @Override // com.google.android.gms.internal.ads.zzehj
    public final boolean zzbgq() {
        return (this.flags & 2) == 2;
    }
}
