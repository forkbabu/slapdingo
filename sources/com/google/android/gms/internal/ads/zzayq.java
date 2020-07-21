package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzayq extends zzayn {
    @Override // com.google.android.gms.internal.ads.zzayj, com.google.android.gms.internal.ads.zzayn
    public final boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    @Override // com.google.android.gms.internal.ads.zzayj
    public final ViewGroup.LayoutParams zzxo() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
