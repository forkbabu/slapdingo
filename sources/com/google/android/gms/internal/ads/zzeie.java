package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeie extends zzeer {
    static final int[] zzihs = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zziht;
    /* access modifiers changed from: private */
    public final zzeer zzihu;
    /* access modifiers changed from: private */
    public final zzeer zzihv;
    private final int zzihw;
    private final int zzihx;

    private zzeie(zzeer zzeer, zzeer zzeer2) {
        this.zzihu = zzeer;
        this.zzihv = zzeer2;
        int size = zzeer.size();
        this.zzihw = size;
        this.zziht = size + zzeer2.size();
        this.zzihx = Math.max(zzeer.zzbdg(), zzeer2.zzbdg()) + 1;
    }

    static zzeer zza(zzeer zzeer, zzeer zzeer2) {
        if (zzeer2.size() == 0) {
            return zzeer;
        }
        if (zzeer.size() == 0) {
            return zzeer2;
        }
        int size = zzeer.size() + zzeer2.size();
        if (size < 128) {
            return zzb(zzeer, zzeer2);
        }
        if (zzeer instanceof zzeie) {
            zzeie zzeie = (zzeie) zzeer;
            if (zzeie.zzihv.size() + zzeer2.size() < 128) {
                return new zzeie(zzeie.zzihu, zzb(zzeie.zzihv, zzeer2));
            } else if (zzeie.zzihu.zzbdg() > zzeie.zzihv.zzbdg() && zzeie.zzbdg() > zzeer2.zzbdg()) {
                return new zzeie(zzeie.zzihu, new zzeie(zzeie.zzihv, zzeer2));
            }
        }
        if (size >= zzhl(Math.max(zzeer.zzbdg(), zzeer2.zzbdg()) + 1)) {
            return new zzeie(zzeer, zzeer2);
        }
        return new zzeig(null).zzc(zzeer, zzeer2);
    }

    private static zzeer zzb(zzeer zzeer, zzeer zzeer2) {
        int size = zzeer.size();
        int size2 = zzeer2.size();
        byte[] bArr = new byte[(size + size2)];
        zzeer.zza(bArr, 0, 0, size);
        zzeer2.zza(bArr, 0, size, size2);
        return zzeer.zzv(bArr);
    }

    static int zzhl(int i) {
        int[] iArr = zzihs;
        if (i >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeer
    public final byte zzft(int i) {
        zzaa(i, this.zziht);
        return zzfu(i);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeer
    public final byte zzfu(int i) {
        int i2 = this.zzihw;
        if (i < i2) {
            return this.zzihu.zzfu(i);
        }
        return this.zzihv.zzfu(i - i2);
    }

    @Override // com.google.android.gms.internal.ads.zzeer
    public final int size() {
        return this.zziht;
    }

    @Override // com.google.android.gms.internal.ads.zzeer
    public final zzeew zzbdb() {
        return new zzeid(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeer
    public final int zzbdg() {
        return this.zzihx;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeer
    public final boolean zzbdh() {
        return this.zziht >= zzhl(this.zzihx);
    }

    @Override // com.google.android.gms.internal.ads.zzeer
    public final zzeer zzz(int i, int i2) {
        int zzi = zzi(i, i2, this.zziht);
        if (zzi == 0) {
            return zzeer.zzhzv;
        }
        if (zzi == this.zziht) {
            return this;
        }
        int i3 = this.zzihw;
        if (i2 <= i3) {
            return this.zzihu.zzz(i, i2);
        }
        if (i >= i3) {
            return this.zzihv.zzz(i - i3, i2 - i3);
        }
        zzeer zzeer = this.zzihu;
        return new zzeie(zzeer.zzz(i, zzeer.size()), this.zzihv.zzz(0, i2 - this.zzihw));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeer
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzihw;
        if (i4 <= i5) {
            this.zzihu.zzb(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.zzihv.zzb(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.zzihu.zzb(bArr, i, i2, i6);
            this.zzihv.zzb(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeer
    public final void zza(zzeeo zzeeo) throws IOException {
        this.zzihu.zza(zzeeo);
        this.zzihv.zza(zzeeo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeer
    public final String zza(Charset charset) {
        return new String(toByteArray(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzeer
    public final boolean zzbdd() {
        int zzg = this.zzihu.zzg(0, 0, this.zzihw);
        zzeer zzeer = this.zzihv;
        if (zzeer.zzg(zzg, 0, zzeer.size()) == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeer
    public final int zzg(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzihw;
        if (i4 <= i5) {
            return this.zzihu.zzg(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzihv.zzg(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzihv.zzg(this.zzihu.zzg(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzeer
    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeer)) {
            return false;
        }
        zzeer zzeer = (zzeer) obj;
        if (this.zziht != zzeer.size()) {
            return false;
        }
        if (this.zziht == 0) {
            return true;
        }
        int zzbdi = zzbdi();
        int zzbdi2 = zzeer.zzbdi();
        if (zzbdi != 0 && zzbdi2 != 0 && zzbdi != zzbdi2) {
            return false;
        }
        zzeif zzeif = new zzeif(this, null);
        zzeey zzeey = (zzeey) zzeif.next();
        zzeif zzeif2 = new zzeif(zzeer, null);
        zzeey zzeey2 = (zzeey) zzeif2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = zzeey.size() - i;
            int size2 = zzeey2.size() - i2;
            int min = Math.min(size, size2);
            if (i == 0) {
                z = zzeey.zza(zzeey2, i2, min);
            } else {
                z = zzeey2.zza(zzeey, i, min);
            }
            if (!z) {
                return false;
            }
            i3 += min;
            int i4 = this.zziht;
            if (i3 < i4) {
                if (min == size) {
                    zzeey = (zzeey) zzeif.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    zzeey2 = (zzeey) zzeif2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeer
    public final int zzh(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzihw;
        if (i4 <= i5) {
            return this.zzihu.zzh(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzihv.zzh(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzihv.zzh(this.zzihu.zzh(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzeer
    public final zzefc zzbde() {
        return new zzefh(new zzeii(this));
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // com.google.android.gms.internal.ads.zzeer, java.lang.Iterable
    public final /* synthetic */ Iterator<Byte> iterator() {
        return iterator();
    }

    /* synthetic */ zzeie(zzeer zzeer, zzeer zzeer2, zzeid zzeid) {
        this(zzeer, zzeer2);
    }
}
