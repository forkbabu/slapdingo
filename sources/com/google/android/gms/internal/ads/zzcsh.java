package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcsh implements Runnable {
    private final zzcim zzgln;

    private zzcsh(zzcim zzcim) {
        this.zzgln = zzcim;
    }

    static Runnable zza(zzcim zzcim) {
        return new zzcsh(zzcim);
    }

    public final void run() {
        this.zzgln.zzani();
    }
}
