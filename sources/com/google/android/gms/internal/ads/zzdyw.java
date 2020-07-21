package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebf;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdyw extends zzdwj<zzeax> {
    public zzdyw() {
        super(zzeax.class, new zzdyv(zzdwp.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzebf.zza zzaxl() {
        return zzebf.zza.SYMMETRIC;
    }

    /* access modifiers changed from: private */
    public static void zza(zzebc zzebc) throws GeneralSecurityException {
        if (zzebc.zzayg() >= 10) {
            int i = zzdyx.zzhrm[zzebc.zzbao().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new GeneralSecurityException("unknown hash type");
                    } else if (zzebc.zzayg() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzebc.zzayg() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzebc.zzayg() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdwm<com.google.android.gms.internal.ads.zzebb, com.google.android.gms.internal.ads.zzeax>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final zzdwm<?, zzeax> zzaxo() {
        return new zzdyy(this, zzebb.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehl] */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ void zzc(zzeax zzeax) throws GeneralSecurityException {
        zzeax zzeax2 = zzeax;
        zzedv.zzy(zzeax2.getVersion(), 0);
        if (zzeax2.zzayb().size() >= 16) {
            zza(zzeax2.zzbai());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehl' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwj
    public final /* synthetic */ zzeax zzp(zzeer zzeer) throws zzegl {
        return zzeax.zzq(zzeer, zzefo.zzbeq());
    }
}
