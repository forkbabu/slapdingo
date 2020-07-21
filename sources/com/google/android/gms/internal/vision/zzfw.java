package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
class zzfw extends zzfx {
    protected final byte[] zzst;

    zzfw(byte[] bArr) {
        if (bArr != null) {
            this.zzst = bArr;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public int zzev() {
        return 0;
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    public byte zzao(int i) {
        return this.zzst[i];
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzfm
    public byte zzap(int i) {
        return this.zzst[i];
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    public int size() {
        return this.zzst.length;
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    public final zzfm zzg(int i, int i2) {
        int zzc = zzc(0, i2, size());
        if (zzc == 0) {
            return zzfm.zzsm;
        }
        return new zzft(this.zzst, zzev(), zzc);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzfm
    public void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzst, 0, bArr, 0, i3);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzfm
    public final void zza(zzfn zzfn) throws IOException {
        zzfn.zzc(this.zzst, zzev(), size());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzfm
    public final String zza(Charset charset) {
        return new String(this.zzst, zzev(), size(), charset);
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    public final boolean zzet() {
        int zzev = zzev();
        return zzjx.zzf(this.zzst, zzev, size() + zzev);
    }

    @Override // com.google.android.gms.internal.vision.zzfm
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfm) || size() != ((zzfm) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzfw)) {
            return obj.equals(this);
        }
        zzfw zzfw = (zzfw) obj;
        int zzeu = zzeu();
        int zzeu2 = zzfw.zzeu();
        if (zzeu == 0 || zzeu2 == 0 || zzeu == zzeu2) {
            return zza(zzfw, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzfx
    public final boolean zza(zzfm zzfm, int i, int i2) {
        if (i2 > zzfm.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzfm.size()) {
            int size2 = zzfm.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzfm instanceof zzfw)) {
            return zzfm.zzg(0, i2).equals(zzg(0, i2));
        } else {
            zzfw zzfw = (zzfw) zzfm;
            byte[] bArr = this.zzst;
            byte[] bArr2 = zzfw.zzst;
            int zzev = zzev() + i2;
            int zzev2 = zzev();
            int zzev3 = zzfw.zzev();
            while (zzev2 < zzev) {
                if (bArr[zzev2] != bArr2[zzev3]) {
                    return false;
                }
                zzev2++;
                zzev3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzfm
    public final int zzb(int i, int i2, int i3) {
        return zzgy.zza(i, this.zzst, zzev(), i3);
    }
}
