package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcqf {
    private int responseCode = 0;
    private long zzgjh = 0;
    private long zzgji = 0;
    private long zzgjj = 0;
    private final Object zzgjk = new Object();
    private final Object zzgjl = new Object();
    private final Object zzgjm = new Object();
    private final Object zzgjn = new Object();

    public final void zzdx(int i) {
        synchronized (this.zzgjk) {
            this.responseCode = i;
        }
    }

    public final int getResponseCode() {
        int i;
        synchronized (this.zzgjk) {
            i = this.responseCode;
        }
        return i;
    }

    public final void zzeq(long j) {
        synchronized (this.zzgjl) {
            this.zzgjh = j;
        }
    }

    public final long zzapj() {
        long j;
        synchronized (this.zzgjl) {
            j = this.zzgjh;
        }
        return j;
    }

    public final synchronized void zzff(long j) {
        synchronized (this.zzgjm) {
            this.zzgji = j;
        }
    }

    public final synchronized long zzapk() {
        long j;
        synchronized (this.zzgjm) {
            j = this.zzgji;
        }
        return j;
    }

    public final synchronized void zzer(long j) {
        synchronized (this.zzgjn) {
            this.zzgjj = j;
        }
    }

    public final synchronized long zzapl() {
        long j;
        synchronized (this.zzgjn) {
            j = this.zzgjj;
        }
        return j;
    }
}
