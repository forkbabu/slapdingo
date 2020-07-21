package com.google.firebase.iid;

import android.os.Bundle;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
final class zzak extends zzan<Void> {
    zzak(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.zzan
    public final boolean zza() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.zzan
    public final void zza(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zza((Object) null);
        } else {
            zza(new zzam(4, "Invalid response to one way request"));
        }
    }
}
