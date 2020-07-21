package com.google.android.gms.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class AdError {
    private final int code;
    private final String zzacl;
    private final String zzacm;

    public AdError(int i, String str, String str2) {
        this.code = i;
        this.zzacl = str;
        this.zzacm = str2;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.zzacl;
    }
}
