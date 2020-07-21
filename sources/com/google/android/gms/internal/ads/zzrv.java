package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzrv extends zzro {
    private MessageDigest zzbtz;

    @Override // com.google.android.gms.internal.ads.zzro
    public final byte[] zzbs(String str) {
        byte[] bArr;
        byte[] bArr2;
        String[] split = str.split(" ");
        int i = 4;
        if (split.length == 1) {
            int zzbu = zzrs.zzbu(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zzbu);
            bArr = allocate.array();
        } else {
            if (split.length < 5) {
                bArr2 = new byte[(split.length << 1)];
                for (int i2 = 0; i2 < split.length; i2++) {
                    int zzbu2 = zzrs.zzbu(split[i2]);
                    int i3 = (zzbu2 >> 16) ^ (65535 & zzbu2);
                    byte[] bArr3 = {(byte) i3, (byte) (i3 >> 8)};
                    int i4 = i2 << 1;
                    bArr2[i4] = bArr3[0];
                    bArr2[i4 + 1] = bArr3[1];
                }
            } else {
                bArr2 = new byte[split.length];
                for (int i5 = 0; i5 < split.length; i5++) {
                    int zzbu3 = zzrs.zzbu(split[i5]);
                    bArr2[i5] = (byte) ((zzbu3 >> 24) ^ (((zzbu3 & 255) ^ ((zzbu3 >> 8) & 255)) ^ ((zzbu3 >> 16) & 255)));
                }
            }
            bArr = bArr2;
        }
        this.zzbtz = zzmm();
        synchronized (this.mLock) {
            if (this.zzbtz == null) {
                byte[] bArr4 = new byte[0];
                return bArr4;
            }
            this.zzbtz.reset();
            this.zzbtz.update(bArr);
            byte[] digest = this.zzbtz.digest();
            if (digest.length <= 4) {
                i = digest.length;
            }
            byte[] bArr5 = new byte[i];
            System.arraycopy(digest, 0, bArr5, 0, i);
            return bArr5;
        }
    }
}
