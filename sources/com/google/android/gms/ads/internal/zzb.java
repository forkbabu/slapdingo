package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public abstract class zzb<T extends IInterface> extends BaseGmsClient<T> {
    protected zzb(Context context, Looper looper, int i, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        super(context, looper, i, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }
}
