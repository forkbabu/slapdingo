package com.google.android.gms.internal.vision;

import com.itextpdf.text.xml.xmp.XmpWriter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.spongycastle.i18n.LocalizedMessage;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzgy {
    private static final Charset ISO_8859_1 = Charset.forName(LocalizedMessage.DEFAULT_ENCODING);
    static final Charset UTF_8 = Charset.forName(XmpWriter.UTF8);
    public static final byte[] zzxr;
    private static final ByteBuffer zzxs;
    private static final zzfy zzxt;

    public static int zzab(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zzm(boolean z) {
        return z ? 1231 : 1237;
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzg(byte[] bArr) {
        return zzjx.zzg(bArr);
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static boolean zzf(zzih zzih) {
        if (!(zzih instanceof zzfa)) {
            return false;
        }
        zzfa zzfa = (zzfa) zzih;
        return false;
    }

    static Object zzb(Object obj, Object obj2) {
        return ((zzih) obj).zzgj().zza((zzih) obj2).zzgc();
    }

    static {
        byte[] bArr = new byte[0];
        zzxr = bArr;
        zzxs = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzxr;
        zzxt = zzfy.zza(bArr2, 0, bArr2.length, false);
    }
}
