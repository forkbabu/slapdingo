package com.google.android.gms.internal.ads;

import com.itextpdf.text.DocWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
abstract class zzecr implements zzedp {
    private static final int[] zzhxe = zzr(new byte[]{101, 120, 112, 97, 110, 100, DocWriter.SPACE, 51, 50, 45, 98, 121, 116, 101, DocWriter.SPACE, 107});
    int[] zzhxf;
    private final int zzhxg;

    zzecr(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.zzhxf = zzr(bArr);
            this.zzhxg = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    private static int rotateLeft(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    /* access modifiers changed from: package-private */
    public abstract int[] zzb(int[] iArr, int i);

    /* access modifiers changed from: package-private */
    public abstract int zzbcl();

    @Override // com.google.android.gms.internal.ads.zzedp
    public final byte[] zzo(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length <= Integer.MAX_VALUE - zzbcl()) {
            ByteBuffer allocate = ByteBuffer.allocate(zzbcl() + bArr.length);
            zza(allocate, bArr);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    /* access modifiers changed from: package-private */
    public final void zza(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - zzbcl() >= bArr.length) {
            byte[] zzfn = zzedu.zzfn(zzbcl());
            byteBuffer.put(zzfn);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int remaining = wrap.remaining();
            int i = (remaining / 64) + 1;
            for (int i2 = 0; i2 < i; i2++) {
                ByteBuffer zzd = zzd(zzfn, this.zzhxg + i2);
                if (i2 == i - 1) {
                    zzecp.zza(byteBuffer, wrap, zzd, remaining % 64);
                } else {
                    zzecp.zza(byteBuffer, wrap, zzd, 64);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    /* access modifiers changed from: package-private */
    public final ByteBuffer zzd(byte[] bArr, int i) {
        int[] zzb = zzb(zzr(bArr), i);
        int[] iArr = (int[]) zzb.clone();
        zzc(iArr);
        for (int i2 = 0; i2 < zzb.length; i2++) {
            zzb[i2] = zzb[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zzb, 0, 16);
        return order;
    }

    static void zza(int[] iArr, int[] iArr2) {
        int[] iArr3 = zzhxe;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, zzhxe.length, 8);
    }

    static void zzc(int[] iArr) {
        for (int i = 0; i < 10; i++) {
            zza(iArr, 0, 4, 8, 12);
            zza(iArr, 1, 5, 9, 13);
            zza(iArr, 2, 6, 10, 14);
            zza(iArr, 3, 7, 11, 15);
            zza(iArr, 0, 5, 10, 15);
            zza(iArr, 1, 6, 11, 12);
            zza(iArr, 2, 7, 8, 13);
            zza(iArr, 3, 4, 9, 14);
        }
    }

    private static void zza(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = rotateLeft(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = rotateLeft(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = rotateLeft(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = rotateLeft(iArr[i2] ^ iArr[i3], 7);
    }

    private static int[] zzr(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }
}
