package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdps extends zzdpn {
    private final String zzhhs;
    private final boolean zzxi;
    private final boolean zzze;

    private zzdps(String str, boolean z, boolean z2) {
        this.zzhhs = str;
        this.zzxi = z;
        this.zzze = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzdpn
    public final String zzaut() {
        return this.zzhhs;
    }

    @Override // com.google.android.gms.internal.ads.zzdpn
    public final boolean zzauu() {
        return this.zzxi;
    }

    @Override // com.google.android.gms.internal.ads.zzdpn
    public final boolean zzcn() {
        return this.zzze;
    }

    public final String toString() {
        String str = this.zzhhs;
        boolean z = this.zzxi;
        boolean z2 = this.zzze;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 99);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdpn) {
            zzdpn zzdpn = (zzdpn) obj;
            return this.zzhhs.equals(zzdpn.zzaut()) && this.zzxi == zzdpn.zzauu() && this.zzze == zzdpn.zzcn();
        }
    }

    public final int hashCode() {
        int i = 1231;
        int hashCode = (((this.zzhhs.hashCode() ^ 1000003) * 1000003) ^ (this.zzxi ? 1231 : 1237)) * 1000003;
        if (!this.zzze) {
            i = 1237;
        }
        return hashCode ^ i;
    }
}
