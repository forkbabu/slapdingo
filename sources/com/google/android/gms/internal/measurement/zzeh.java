package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
final class zzeh extends zzei<Map.Entry<K, V>> {
    private final /* synthetic */ zzef zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeh(zzef zzef) {
        super(zzef, null);
        this.zza = zzef;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzei
    public final /* synthetic */ Object zza(int i) {
        return new zzek(this.zza, i);
    }
}
