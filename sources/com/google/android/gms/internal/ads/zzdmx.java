package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdmx implements zzdmv {
    private final String zzcn;

    public zzdmx(String str) {
        this.zzcn = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdmv
    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdmx)) {
            return false;
        }
        return this.zzcn.equals(((zzdmx) obj).zzcn);
    }

    @Override // com.google.android.gms.internal.ads.zzdmv
    public final int hashCode() {
        return this.zzcn.hashCode();
    }

    public final String toString() {
        return this.zzcn;
    }
}
