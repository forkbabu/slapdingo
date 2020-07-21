package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaa implements OnDelegateCreatedListener<T> {
    private final /* synthetic */ DeferredLifecycleHelper zart;

    zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zart = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.OnDelegateCreatedListener
    public final void onDelegateCreated(T t) {
        LifecycleDelegate unused = this.zart.zaru = (LifecycleDelegate) t;
        Iterator it2 = this.zart.zarw.iterator();
        while (it2.hasNext()) {
            ((DeferredLifecycleHelper.zaa) it2.next()).zaa(this.zart.zaru);
        }
        this.zart.zarw.clear();
        Bundle unused2 = this.zart.zarv = null;
    }
}
