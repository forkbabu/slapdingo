package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdzi;
import com.google.android.gms.internal.ads.zzdzm;
import com.google.android.gms.internal.ads.zzdzy;
import com.google.android.gms.internal.ads.zzeax;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdys implements zzecw {
    private final String zzhrp;
    private final int zzhrq;
    private zzdzy zzhrr;
    private zzdzi zzhrs;
    private int zzhrt;

    zzdys(zzebi zzebi) throws GeneralSecurityException {
        String zzbar = zzebi.zzbar();
        this.zzhrp = zzbar;
        if (zzbar.equals(zzdxe.zzhqn)) {
            try {
                zzeab zzk = zzeab.zzk(zzebi.zzbas(), zzefo.zzbeq());
                this.zzhrr = (zzdzy) zzdwy.zzb(zzebi);
                this.zzhrq = zzk.getKeySize();
            } catch (zzegl e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (this.zzhrp.equals(zzdxe.zzhqm)) {
            try {
                zzdzl zze = zzdzl.zze(zzebi.zzbas(), zzefo.zzbeq());
                this.zzhrs = (zzdzi) zzdwy.zzb(zzebi);
                this.zzhrt = zze.zzayn().getKeySize();
                this.zzhrq = this.zzhrt + zze.zzayo().getKeySize();
            } catch (zzegl e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else {
            String valueOf = String.valueOf(this.zzhrp);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzecw
    public final int zzaya() {
        return this.zzhrq;
    }

    @Override // com.google.android.gms.internal.ads.zzecw
    public final zzdwc zzn(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.zzhrq) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.zzhrp.equals(zzdxe.zzhqn)) {
            return (zzdwc) zzdwy.zza(this.zzhrp, (zzdzy) ((zzegb) ((zzdzy.zza) zzdzy.zzazf().zza(this.zzhrr)).zzw(zzeer.zzi(bArr, 0, this.zzhrq)).zzbfq()), zzdwc.class);
        } else if (this.zzhrp.equals(zzdxe.zzhqm)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zzhrt);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zzhrt, this.zzhrq);
            zzdzi.zza zzb = zzdzi.zzayl().zzes(this.zzhrs.getVersion()).zzb((zzdzm) ((zzegb) ((zzdzm.zza) zzdzm.zzayr().zza(this.zzhrs.zzayj())).zzu(zzeer.zzu(copyOfRange)).zzbfq()));
            return (zzdwc) zzdwy.zza(this.zzhrp, (zzdzi) ((zzegb) zzb.zzb((zzeax) ((zzegb) ((zzeax.zza) zzeax.zzbaj().zza(this.zzhrs.zzayk())).zzad(zzeer.zzu(copyOfRange2)).zzbfq())).zzbfq()), zzdwc.class);
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
