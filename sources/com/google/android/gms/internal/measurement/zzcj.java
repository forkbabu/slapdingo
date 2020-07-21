package com.google.android.gms.internal.measurement;

import android.content.Context;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
final class zzcj extends zzde {
    private final Context zza;
    private final zzdv<zzdr<zzcs>> zzb;

    zzcj(Context context, @Nullable zzdv<zzdr<zzcs>> zzdv) {
        if (context != null) {
            this.zza = context;
            this.zzb = zzdv;
            return;
        }
        throw new NullPointerException("Null context");
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzde
    public final Context zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzde
    @Nullable
    public final zzdv<zzdr<zzcs>> zzb() {
        return this.zzb;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46 + String.valueOf(valueOf2).length());
        sb.append("FlagsContext{context=");
        sb.append(valueOf);
        sb.append(", hermeticFileOverrides=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        zzdv<zzdr<zzcs>> zzdv;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzde) {
            zzde zzde = (zzde) obj;
            return this.zza.equals(zzde.zza()) && ((zzdv = this.zzb) != null ? zzdv.equals(zzde.zzb()) : zzde.zzb() == null);
        }
    }

    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzdv<zzdr<zzcs>> zzdv = this.zzb;
        return hashCode ^ (zzdv == null ? 0 : zzdv.hashCode());
    }
}
