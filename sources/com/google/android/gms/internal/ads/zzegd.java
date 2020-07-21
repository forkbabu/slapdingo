package com.google.android.gms.internal.ads;

import com.itextpdf.text.xml.xmp.XmpWriter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.spongycastle.i18n.LocalizedMessage;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzegd {
    private static final Charset ISO_8859_1 = Charset.forName(LocalizedMessage.DEFAULT_ENCODING);
    static final Charset UTF_8 = Charset.forName(XmpWriter.UTF8);
    public static final byte[] zziab;
    private static final ByteBuffer zzifc;
    private static final zzefc zzifd;

    public static int zzbu(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzfr(long j) {
        return (int) (j ^ (j >>> 32));
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

    public static boolean zzy(byte[] bArr) {
        return zzeji.zzy(bArr);
    }

    public static String zzz(byte[] bArr) {
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

    static boolean zzk(zzehl zzehl) {
        if (!(zzehl instanceof zzeej)) {
            return false;
        }
        zzeej zzeej = (zzeej) zzehl;
        return false;
    }

    static Object zze(Object obj, Object obj2) {
        return ((zzehl) obj).zzbfi().zzf((zzehl) obj2).zzbfp();
    }

    static {
        byte[] bArr = new byte[0];
        zziab = bArr;
        zzifc = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zziab;
        zzifd = zzefc.zzb(bArr2, 0, bArr2.length, false);
    }
}
