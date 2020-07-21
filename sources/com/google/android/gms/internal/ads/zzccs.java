package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public interface zzccs {
    void cancelUnconfirmedClick();

    void destroy();

    boolean isCustomClickGestureEnabled();

    void setClickConfirmingView(View view);

    void zza(View view, MotionEvent motionEvent, View view2);

    void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z);

    void zza(View view, Map<String, WeakReference<View>> map);

    void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2);

    void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener);

    void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z);

    void zza(zzafo zzafo);

    void zza(zzxp zzxp);

    void zza(zzxt zzxt);

    void zzakv();

    void zzakw();

    void zzakx();

    void zzfy(String str);

    void zzg(Bundle bundle);

    void zzh(Bundle bundle);

    boolean zzi(Bundle bundle);

    void zzsm();
}
