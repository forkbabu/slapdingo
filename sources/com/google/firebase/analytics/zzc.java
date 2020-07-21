package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.internal.zzhc;
import com.google.android.gms.measurement.internal.zzhf;
import com.google.android.gms.measurement.internal.zzif;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.4 */
final class zzc implements zzif {
    private final /* synthetic */ zzag zza;

    zzc(zzag zzag) {
        this.zza = zzag;
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final void zza(String str, String str2, Bundle bundle, long j) {
        this.zza.zza(str, str2, bundle, j);
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final void zza(String str, String str2, Object obj) {
        this.zza.zza(str, str2, obj);
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final void zza(boolean z) {
        this.zza.zza(z);
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final Map<String, Object> zza(String str, String str2, boolean z) {
        return this.zza.zza(str, str2, z);
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final void zza(zzhc zzhc) {
        this.zza.zza(zzhc);
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final void zza(zzhf zzhf) {
        this.zza.zza(zzhf);
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final void zzb(zzhf zzhf) {
        this.zza.zzb(zzhf);
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final String zza() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final String zzb() {
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final String zzc() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final String zzd() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final long zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final void zza(String str) {
        this.zza.zzb(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final void zzb(String str) {
        this.zza.zzc(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final void zza(Bundle bundle) {
        this.zza.zza(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final void zzb(String str, String str2, Bundle bundle) {
        this.zza.zzb(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final List<Bundle> zza(String str, String str2) {
        return this.zza.zzb(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final int zzc(String str) {
        return this.zza.zzd(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzif
    public final Object zza(int i) {
        return this.zza.zza(i);
    }
}
