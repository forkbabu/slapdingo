package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdrc {
    private final zzgr zzhjk;
    private final File zzhjl;
    private final File zzhjm;
    private final File zzhjn;
    private byte[] zzhjo;

    public zzdrc(zzgr zzgr, File file, File file2, File file3) {
        this.zzhjk = zzgr;
        this.zzhjl = file;
        this.zzhjm = file3;
        this.zzhjn = file2;
    }

    public final zzgr zzavv() {
        return this.zzhjk;
    }

    public final File zzavw() {
        return this.zzhjl;
    }

    public final File zzavx() {
        return this.zzhjm;
    }

    public final byte[] zzavy() {
        if (this.zzhjo == null) {
            this.zzhjo = zzdre.zzf(this.zzhjn);
        }
        byte[] bArr = this.zzhjo;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final boolean zza() {
        return System.currentTimeMillis() / 1000 > this.zzhjk.zzdj();
    }

    public final boolean zzfg(long j) {
        return this.zzhjk.zzdj() - (System.currentTimeMillis() / 1000) < 3600;
    }
}
