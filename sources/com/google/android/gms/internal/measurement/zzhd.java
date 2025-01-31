package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
class zzhd extends zzha {
    protected final byte[] zzb;

    zzhd(byte[] bArr) {
        if (bArr != null) {
            this.zzb = bArr;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public byte zza(int i) {
        return this.zzb[i];
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzgt
    public byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final zzgt zza(int i, int i2) {
        int zzb2 = zzb(0, i2, zza());
        if (zzb2 == 0) {
            return zzgt.zza;
        }
        return new zzgw(this.zzb, zze(), zzb2);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzgt
    public final void zza(zzgq zzgq) throws IOException {
        zzgq.zza(this.zzb, zze(), zza());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzgt
    public final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final boolean zzc() {
        int zze = zze();
        return zzlc.zza(this.zzb, zze, zza() + zze);
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgt) || zza() != ((zzgt) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof zzhd)) {
            return obj.equals(this);
        }
        zzhd zzhd = (zzhd) obj;
        int zzd = zzd();
        int zzd2 = zzhd.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return zza(zzhd, 0, zza());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzha
    public final boolean zza(zzgt zzgt, int i, int i2) {
        if (i2 > zzgt.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzgt.zza()) {
            int zza2 = zzgt.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(zza2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzgt instanceof zzhd)) {
            return zzgt.zza(0, i2).equals(zza(0, i2));
        } else {
            zzhd zzhd = (zzhd) zzgt;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzhd.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzhd.zze();
            while (zze2 < zze) {
                if (bArr[zze2] != bArr2[zze3]) {
                    return false;
                }
                zze2++;
                zze3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzgt
    public final int zza(int i, int i2, int i3) {
        return zzie.zza(i, this.zzb, zze(), i3);
    }
}
