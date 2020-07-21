package com.google.android.gms.internal.ads;

import java.io.IOException;
import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzha implements zzhv, zzhy {
    private int index;
    private int state;
    private final int zzadu;
    private zzhx zzadv;
    private zznk zzadw;
    private long zzadx;
    private boolean zzady = true;
    private boolean zzadz;

    public zzha(int i) {
        this.zzadu = i;
    }

    /* access modifiers changed from: protected */
    public void onStarted() throws zzhb {
    }

    /* access modifiers changed from: protected */
    public void onStopped() throws zzhb {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public void zza(int i, Object obj) throws zzhb {
    }

    /* access modifiers changed from: protected */
    public void zza(long j, boolean z) throws zzhb {
    }

    /* access modifiers changed from: protected */
    public void zza(zzhq[] zzhqArr, long j) throws zzhb {
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final zzhy zzdy() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public zzpf zzdz() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void zze(boolean z) throws zzhb {
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public int zzef() throws zzhb {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void zzeg() {
    }

    @Override // com.google.android.gms.internal.ads.zzhv, com.google.android.gms.internal.ads.zzhy
    public final int getTrackType() {
        return this.zzadu;
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final void zza(zzhx zzhx, zzhq[] zzhqArr, zznk zznk, long j, boolean z, long j2) throws zzhb {
        zzpb.checkState(this.state == 0);
        this.zzadv = zzhx;
        this.state = 1;
        zze(z);
        zza(zzhqArr, zznk, j2);
        zza(j, z);
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final void start() throws zzhb {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zzpb.checkState(z);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final void zza(zzhq[] zzhqArr, zznk zznk, long j) throws zzhb {
        zzpb.checkState(!this.zzadz);
        this.zzadw = zznk;
        this.zzady = false;
        this.zzadx = j;
        zza(zzhqArr, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final zznk zzea() {
        return this.zzadw;
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final boolean zzeb() {
        return this.zzady;
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final void zzec() {
        this.zzadz = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final boolean zzed() {
        return this.zzadz;
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final void zzee() throws IOException {
        this.zzadw.zzhr();
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final void zzdm(long j) throws zzhb {
        this.zzadz = false;
        this.zzady = false;
        zza(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final void stop() throws zzhb {
        zzpb.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final void disable() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zzpb.checkState(z);
        this.state = 0;
        this.zzadw = null;
        this.zzadz = false;
        zzeg();
    }

    /* access modifiers changed from: protected */
    public final zzhx zzeh() {
        return this.zzadv;
    }

    /* access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* access modifiers changed from: protected */
    public final int zza(zzhs zzhs, zzjm zzjm, boolean z) {
        int zzb = this.zzadw.zzb(zzhs, zzjm, z);
        if (zzb == -4) {
            if (zzjm.zzgh()) {
                this.zzady = true;
                if (this.zzadz) {
                    return -4;
                }
                return -3;
            }
            zzjm.zzaod += this.zzadx;
        } else if (zzb == -5) {
            zzhq zzhq = zzhs.zzahr;
            if (zzhq.zzahl != LongCompanionObject.MAX_VALUE) {
                zzhs.zzahr = zzhq.zzds(zzhq.zzahl + this.zzadx);
            }
        }
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzdn(long j) {
        this.zzadw.zzeh(j - this.zzadx);
    }

    /* access modifiers changed from: protected */
    public final boolean zzei() {
        return this.zzady ? this.zzadz : this.zzadw.isReady();
    }
}
