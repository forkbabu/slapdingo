package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
class zzgx implements zzgz {
    protected final zzgd zzy;

    zzgx(zzgd zzgd) {
        Preconditions.checkNotNull(zzgd);
        this.zzy = zzgd;
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public zzx zzu() {
        return this.zzy.zzu();
    }

    public zzy zzt() {
        return this.zzy.zzb();
    }

    public zzfl zzs() {
        return this.zzy.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public zzez zzr() {
        return this.zzy.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public zzfw zzq() {
        return this.zzy.zzq();
    }

    public zzkw zzp() {
        return this.zzy.zzi();
    }

    public zzex zzo() {
        return this.zzy.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public Context zzn() {
        return this.zzy.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public Clock zzm() {
        return this.zzy.zzm();
    }

    public zzai zzl() {
        return this.zzy.zzx();
    }

    public void zzd() {
        this.zzy.zzq().zzd();
    }

    public void zzc() {
        this.zzy.zzq().zzc();
    }

    public void zzb() {
        this.zzy.zzad();
    }

    public void zza() {
        this.zzy.zzae();
    }
}
