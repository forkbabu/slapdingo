package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzate extends zzatf {
    private final String type;
    private final int zzdun;

    public zzate(String str, int i) {
        this.type = str;
        this.zzdun = i;
    }

    @Override // com.google.android.gms.internal.ads.zzatg
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzatg
    public final int getAmount() {
        return this.zzdun;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzate)) {
            zzate zzate = (zzate) obj;
            if (!Objects.equal(this.type, zzate.type) || !Objects.equal(Integer.valueOf(this.zzdun), Integer.valueOf(zzate.zzdun))) {
                return false;
            }
            return true;
        }
        return false;
    }
}
