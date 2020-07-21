package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzpv extends Surface {
    private static boolean zzbkl;
    private static boolean zzbkm;
    private final boolean zzbck;
    private final zzpx zzbkn;
    private boolean zzbko;

    public static synchronized boolean zzc(Context context) {
        boolean z;
        synchronized (zzpv.class) {
            if (!zzbkm) {
                if (zzpo.SDK_INT >= 17) {
                    boolean z2 = false;
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                        if (!(zzpo.SDK_INT == 24 && (zzpo.MODEL.startsWith("SM-G950") || zzpo.MODEL.startsWith("SM-G955")) && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
                            z2 = true;
                        }
                    }
                    zzbkl = z2;
                }
                zzbkm = true;
            }
            z = zzbkl;
        }
        return z;
    }

    public static zzpv zzc(Context context, boolean z) {
        if (zzpo.SDK_INT >= 17) {
            zzpb.checkState(!z || zzc(context));
            return new zzpx().zzm(z);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }

    private zzpv(zzpx zzpx, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.zzbkn = zzpx;
        this.zzbck = z;
    }

    public final void release() {
        super.release();
        synchronized (this.zzbkn) {
            if (!this.zzbko) {
                this.zzbkn.release();
                this.zzbko = true;
            }
        }
    }
}
