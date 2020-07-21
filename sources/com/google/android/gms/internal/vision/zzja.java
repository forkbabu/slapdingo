package com.google.android.gms.internal.vision;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzja extends zzjb<FieldDescriptorType, Object> {
    zzja(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.vision.zzjb
    public final void zzdq() {
        if (!isImmutable()) {
            for (int i = 0; i < zzhy(); i++) {
                Map.Entry zzbv = zzbv(i);
                if (((zzgp) zzbv.getKey()).zzfv()) {
                    zzbv.setValue(Collections.unmodifiableList((List) zzbv.getValue()));
                }
            }
            for (Map.Entry entry : zzhz()) {
                if (((zzgp) entry.getKey()).zzfv()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzdq();
    }
}
