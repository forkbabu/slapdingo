package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzayn extends zzayo {
    @Override // com.google.android.gms.internal.ads.zzayj
    public final int zzxn() {
        return 14;
    }

    @Override // com.google.android.gms.internal.ads.zzayj
    public boolean isAttachedToWindow(View view) {
        return super.isAttachedToWindow(view) || view.getWindowId() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzayj
    public final long zzxr() {
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcra)).booleanValue()) {
            return -1;
        }
        return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }
}
