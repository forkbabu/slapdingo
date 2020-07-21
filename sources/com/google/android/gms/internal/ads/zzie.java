package com.google.android.gms.internal.ads;

import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.nio.ByteBuffer;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzie {
    private static final int[] zzaio = {1, 2, 3, 6};
    private static final int[] zzaip = {48000, 44100, 32000};
    private static final int[] zzaiq = {24000, 22050, 16000};
    private static final int[] zzair = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzais = {32, 40, 48, 56, 64, 80, 96, 112, 128, CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, 192, 224, 256, TIFFConstants.TIFFTAG_COLORMAP, 384, 448, 512, 576, 640};
    private static final int[] zzait = {69, 87, 104, 121, 139, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, 208, 243, TIFFConstants.TIFFTAG_ROWSPERSTRIP, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzhq zza(zzpi zzpi, String str, String str2, zzjl zzjl) {
        int i = zzaip[(zzpi.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzpi.readUnsignedByte();
        int i2 = zzair[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return zzhq.zza(str, "audio/ac3", null, -1, -1, i2, i, null, zzjl, 0, str2);
    }

    public static int zzfh() {
        return 1536;
    }

    public static zzhq zzb(zzpi zzpi, String str, String str2, zzjl zzjl) {
        zzpi.zzbl(2);
        int i = zzaip[(zzpi.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzpi.readUnsignedByte();
        int i2 = zzair[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return zzhq.zza(str, "audio/eac3", null, -1, -1, i2, i, null, zzjl, 0, str2);
    }

    public static int zzm(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = zzaio[(byteBuffer.get(byteBuffer.position() + 4) & com.itextpdf.text.pdf.ByteBuffer.ZERO) >> 4];
        }
        return i * 256;
    }
}
