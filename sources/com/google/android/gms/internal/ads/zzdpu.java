package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdpu extends zzdpq {
    private String zzhhs;
    private Boolean zzhht;
    private Boolean zzhhu;

    zzdpu() {
    }

    @Override // com.google.android.gms.internal.ads.zzdpq
    public final zzdpq zzha(String str) {
        if (str != null) {
            this.zzhhs = str;
            return this;
        }
        throw new NullPointerException("Null clientVersion");
    }

    @Override // com.google.android.gms.internal.ads.zzdpq
    public final zzdpq zzbq(boolean z) {
        this.zzhht = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdpq
    public final zzdpq zzbr(boolean z) {
        this.zzhhu = true;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdpq
    public final zzdpn zzauw() {
        String str = "";
        if (this.zzhhs == null) {
            str = str.concat(" clientVersion");
        }
        if (this.zzhht == null) {
            str = String.valueOf(str).concat(" shouldGetAdvertisingId");
        }
        if (this.zzhhu == null) {
            str = String.valueOf(str).concat(" isGooglePlayServicesAvailable");
        }
        if (str.isEmpty()) {
            return new zzdps(this.zzhhs, this.zzhht.booleanValue(), this.zzhhu.booleanValue());
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
