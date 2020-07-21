package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzji {
    public byte[] iv;
    private byte[] key;
    private int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    private int numSubSamples;
    private int zzano;
    private int zzanp;
    private final MediaCodec.CryptoInfo zzanq;
    private final zzjk zzanr;

    public zzji() {
        zzjk zzjk = null;
        this.zzanq = zzpo.SDK_INT >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.zzanr = zzpo.SDK_INT >= 24 ? new zzjk(this.zzanq) : zzjk;
    }

    public final void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.zzano = 0;
        this.zzanp = 0;
        if (zzpo.SDK_INT >= 16) {
            this.zzanq.numSubSamples = this.numSubSamples;
            this.zzanq.numBytesOfClearData = this.numBytesOfClearData;
            this.zzanq.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
            this.zzanq.key = this.key;
            this.zzanq.iv = this.iv;
            this.zzanq.mode = this.mode;
            if (zzpo.SDK_INT >= 24) {
                this.zzanr.set(0, 0);
            }
        }
    }

    public final MediaCodec.CryptoInfo zzgl() {
        return this.zzanq;
    }
}
