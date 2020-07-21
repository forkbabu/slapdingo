package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public interface zzhv extends zzhg {
    void disable();

    int getState();

    int getTrackType();

    boolean isReady();

    void setIndex(int i);

    void start() throws zzhb;

    void stop() throws zzhb;

    void zza(zzhx zzhx, zzhq[] zzhqArr, zznk zznk, long j, boolean z, long j2) throws zzhb;

    void zza(zzhq[] zzhqArr, zznk zznk, long j) throws zzhb;

    void zzb(long j, long j2) throws zzhb;

    void zzdm(long j) throws zzhb;

    zzhy zzdy();

    zzpf zzdz();

    zznk zzea();

    boolean zzeb();

    void zzec();

    boolean zzed();

    void zzee() throws IOException;

    boolean zzfd();
}
