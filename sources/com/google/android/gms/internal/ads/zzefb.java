package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
class zzefb extends zzeey {
    protected final byte[] zziag;

    zzefb(byte[] bArr) {
        if (bArr != null) {
            this.zziag = bArr;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public int zzbdj() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzeer
    public byte zzft(int i) {
        return this.zziag[i];
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeer
    public byte zzfu(int i) {
        return this.zziag[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeer
    public int size() {
        return this.zziag.length;
    }

    @Override // com.google.android.gms.internal.ads.zzeer
    public final zzeer zzz(int i, int i2) {
        int zzi = zzi(i, i2, size());
        if (zzi == 0) {
            return zzeer.zzhzv;
        }
        return new zzeeu(this.zziag, zzbdj() + i, zzi);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeer
    public void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zziag, i, bArr, i2, i3);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeer
    public final void zza(zzeeo zzeeo) throws IOException {
        zzeeo.zzh(this.zziag, zzbdj(), size());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeer
    public final String zza(Charset charset) {
        return new String(this.zziag, zzbdj(), size(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzeer
    public final boolean zzbdd() {
        int zzbdj = zzbdj();
        return zzeji.zzm(this.zziag, zzbdj, size() + zzbdj);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeer
    public final int zzg(int i, int i2, int i3) {
        int zzbdj = zzbdj() + i2;
        return zzeji.zzb(i, this.zziag, zzbdj, i3 + zzbdj);
    }

    @Override // com.google.android.gms.internal.ads.zzeer
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeer) || size() != ((zzeer) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzefb)) {
            return obj.equals(this);
        }
        zzefb zzefb = (zzefb) obj;
        int zzbdi = zzbdi();
        int zzbdi2 = zzefb.zzbdi();
        if (zzbdi == 0 || zzbdi2 == 0 || zzbdi == zzbdi2) {
            return zza(zzefb, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeey
    public final boolean zza(zzeer zzeer, int i, int i2) {
        if (i2 <= zzeer.size()) {
            int i3 = i + i2;
            if (i3 > zzeer.size()) {
                int size = zzeer.size();
                StringBuilder sb = new StringBuilder(59);
                sb.append("Ran off end of other: ");
                sb.append(i);
                sb.append(", ");
                sb.append(i2);
                sb.append(", ");
                sb.append(size);
                throw new IllegalArgumentException(sb.toString());
            } else if (!(zzeer instanceof zzefb)) {
                return zzeer.zzz(i, i3).equals(zzz(0, i2));
            } else {
                zzefb zzefb = (zzefb) zzeer;
                byte[] bArr = this.zziag;
                byte[] bArr2 = zzefb.zziag;
                int zzbdj = zzbdj() + i2;
                int zzbdj2 = zzbdj();
                int zzbdj3 = zzefb.zzbdj() + i;
                while (zzbdj2 < zzbdj) {
                    if (bArr[zzbdj2] != bArr2[zzbdj3]) {
                        return false;
                    }
                    zzbdj2++;
                    zzbdj3++;
                }
                return true;
            }
        } else {
            int size2 = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i2);
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeer
    public final int zzh(int i, int i2, int i3) {
        return zzegd.zza(i, this.zziag, zzbdj() + i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzeer
    public final zzefc zzbde() {
        return zzefc.zzb(this.zziag, zzbdj(), size(), true);
    }
}
