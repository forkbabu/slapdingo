package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeil extends zzeim<FieldDescriptorType, Object> {
    zzeil(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.ads.zzeim
    public final void zzbcz() {
        if (!isImmutable()) {
            for (int i = 0; i < zzbhj(); i++) {
                Map.Entry zzho = zzho(i);
                if (((zzefw) zzho.getKey()).zzbez()) {
                    zzho.setValue(Collections.unmodifiableList((List) zzho.getValue()));
                }
            }
            for (Map.Entry entry : zzbhk()) {
                if (((zzefw) entry.getKey()).zzbez()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbcz();
    }
}
