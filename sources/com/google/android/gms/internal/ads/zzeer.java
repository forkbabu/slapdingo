package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzeer implements Serializable, Iterable<Byte> {
    public static final zzeer zzhzv = new zzefb(zzegd.zziab);
    private static final zzeex zzhzw = (zzeek.zzbcw() ? new zzefd(null) : new zzeev(null));
    private static final Comparator<zzeer> zzhzx = new zzeet();
    private int zzhzb = 0;

    zzeer() {
    }

    /* access modifiers changed from: private */
    public static int zzb(byte b) {
        return b & UByte.MAX_VALUE;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzeeo zzeeo) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void zzb(byte[] bArr, int i, int i2, int i3);

    public abstract boolean zzbdd();

    public abstract zzefc zzbde();

    /* access modifiers changed from: protected */
    public abstract int zzbdg();

    /* access modifiers changed from: protected */
    public abstract boolean zzbdh();

    public abstract byte zzft(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzfu(int i);

    /* access modifiers changed from: protected */
    public abstract int zzg(int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract int zzh(int i, int i2, int i3);

    public abstract zzeer zzz(int i, int i2);

    /* renamed from: zzbdb */
    public zzeew iterator() {
        return new zzeeq(this);
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public static zzeer zzi(byte[] bArr, int i, int i2) {
        zzi(i, i + i2, bArr.length);
        return new zzefb(zzhzw.zzj(bArr, i, i2));
    }

    public static zzeer zzu(byte[] bArr) {
        return zzi(bArr, 0, bArr.length);
    }

    static zzeer zzv(byte[] bArr) {
        return new zzefb(bArr);
    }

    public static zzeer zzhs(String str) {
        return new zzefb(str.getBytes(zzegd.UTF_8));
    }

    public static zzeer zzg(InputStream inputStream) throws IOException {
        zzeer zzeer;
        ArrayList arrayList = new ArrayList();
        int i = 256;
        while (true) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == 0) {
                zzeer = null;
            } else {
                zzeer = zzi(bArr, 0, i2);
            }
            if (zzeer == null) {
                return zzl(arrayList);
            }
            arrayList.add(zzeer);
            i = Math.min(i << 1, 8192);
        }
    }

    public static zzeer zzl(Iterable<zzeer> iterable) {
        int i;
        if (!(iterable instanceof Collection)) {
            i = 0;
            Iterator<zzeer> it2 = iterable.iterator();
            while (it2.hasNext()) {
                it2.next();
                i++;
            }
        } else {
            i = ((Collection) iterable).size();
        }
        if (i == 0) {
            return zzhzv;
        }
        return zza(iterable.iterator(), i);
    }

    private static zzeer zza(Iterator<zzeer> it2, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i)));
        } else if (i == 1) {
            return it2.next();
        } else {
            int i2 = i >>> 1;
            zzeer zza = zza(it2, i2);
            zzeer zza2 = zza(it2, i - i2);
            if (Integer.MAX_VALUE - zza.size() >= zza2.size()) {
                return zzeie.zza(zza, zza2);
            }
            int size = zza.size();
            int size2 = zza2.size();
            StringBuilder sb = new StringBuilder(53);
            sb.append("ByteString would be too long: ");
            sb.append(size);
            sb.append("+");
            sb.append(size2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Deprecated
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        zzi(i, i + i3, size());
        zzi(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zzb(bArr, i, i2, i3);
        }
    }

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzegd.zziab;
        }
        byte[] bArr = new byte[size];
        zzb(bArr, 0, 0, size);
        return bArr;
    }

    public final String zzbdc() {
        return size() == 0 ? "" : zza(zzegd.UTF_8);
    }

    public final int hashCode() {
        int i = this.zzhzb;
        if (i == 0) {
            int size = size();
            i = zzh(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzhzb = i;
        }
        return i;
    }

    public static zzefa zzbdf() {
        return new zzefa(128);
    }

    static zzeez zzfv(int i) {
        return new zzeez(i, null);
    }

    /* access modifiers changed from: protected */
    public final int zzbdi() {
        return this.zzhzb;
    }

    static void zzaa(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    static int zzi(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? zzeiv.zzam(this) : String.valueOf(zzeiv.zzam(zzz(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }
}
