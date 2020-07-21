package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzju implements zzjw {
    private static final byte[] zzaog = new byte[4096];
    private long position;
    private final zzok zzaoh;
    private final long zzaoi;
    private byte[] zzaoj = new byte[65536];
    private int zzaok;
    private int zzaol;

    public zzju(zzok zzok, long j, long j2) {
        this.zzaoh = zzok;
        this.position = j;
        this.zzaoi = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int zzb = zzb(bArr, i, i2);
        if (zzb == 0) {
            zzb = zza(bArr, i, i2, 0, true);
        }
        zzal(zzb);
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final boolean zza(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int zzb = zzb(bArr, i, i2);
        while (zzb < i2 && zzb != -1) {
            zzb = zza(bArr, i, i2, zzb, z);
        }
        zzal(zzb);
        return zzb != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        zza(bArr, i, i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final int zzag(int i) throws IOException, InterruptedException {
        int zzaj = zzaj(i);
        if (zzaj == 0) {
            byte[] bArr = zzaog;
            zzaj = zza(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        zzal(zzaj);
        return zzaj;
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final void zzah(int i) throws IOException, InterruptedException {
        int zzaj = zzaj(i);
        while (zzaj < i && zzaj != -1) {
            byte[] bArr = zzaog;
            zzaj = zza(bArr, -zzaj, Math.min(i, bArr.length + zzaj), zzaj, false);
        }
        zzal(zzaj);
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final void zza(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        if (zzd(i2, false)) {
            System.arraycopy(this.zzaoj, this.zzaok - i2, bArr, i, i2);
        }
    }

    private final boolean zzd(int i, boolean z) throws IOException, InterruptedException {
        int i2 = this.zzaok + i;
        byte[] bArr = this.zzaoj;
        if (i2 > bArr.length) {
            this.zzaoj = Arrays.copyOf(this.zzaoj, zzpo.zzd(bArr.length << 1, 65536 + i2, i2 + 524288));
        }
        int min = Math.min(this.zzaol - this.zzaok, i);
        while (min < i) {
            min = zza(this.zzaoj, this.zzaok, i, min, false);
            if (min == -1) {
                return false;
            }
        }
        int i3 = this.zzaok + i;
        this.zzaok = i3;
        this.zzaol = Math.max(this.zzaol, i3);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final void zzai(int i) throws IOException, InterruptedException {
        zzd(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final void zzgp() {
        this.zzaok = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final long getPosition() {
        return this.position;
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final long getLength() {
        return this.zzaoi;
    }

    private final int zzaj(int i) {
        int min = Math.min(this.zzaol, i);
        zzak(min);
        return min;
    }

    private final int zzb(byte[] bArr, int i, int i2) {
        int i3 = this.zzaol;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.zzaoj, 0, bArr, i, min);
        zzak(min);
        return min;
    }

    private final void zzak(int i) {
        int i2 = this.zzaol - i;
        this.zzaol = i2;
        this.zzaok = 0;
        byte[] bArr = this.zzaoj;
        if (i2 < bArr.length - 524288) {
            bArr = new byte[(i2 + 65536)];
        }
        System.arraycopy(this.zzaoj, i, bArr, 0, this.zzaol);
        this.zzaoj = bArr;
    }

    private final int zza(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int read = this.zzaoh.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                return i3 + read;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    private final void zzal(int i) {
        if (i != -1) {
            this.position += (long) i;
        }
    }
}
