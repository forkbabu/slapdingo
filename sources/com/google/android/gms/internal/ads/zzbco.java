package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbco extends FrameLayout implements zzbcj {
    private final zzbdb zzeez;
    private final FrameLayout zzefa;
    private final zzabi zzefb;
    private final zzbdd zzefc;
    private final long zzefd;
    private zzbcm zzefe;
    private boolean zzeff;
    private boolean zzefg;
    private boolean zzefh;
    private boolean zzefi;
    private long zzefj;
    private long zzefk;
    private String zzefl;
    private String[] zzefm;
    private Bitmap zzefn;
    private ImageView zzefo;
    private boolean zzefp;

    public static void zzb(zzbdb zzbdb) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "no_video_view");
        zzbdb.zza("onVideoEvent", hashMap);
    }

    public static void zza(zzbdb zzbdb, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
        hashMap.put("mimeTypes", map);
        zzbdb.zza("onVideoEvent", hashMap);
    }

    public static void zza(zzbdb zzbdb, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
        hashMap.put("error", str);
        zzbdb.zza("onVideoEvent", hashMap);
    }

    public zzbco(Context context, zzbdb zzbdb, int i, boolean z, zzabi zzabi, zzbdc zzbdc) {
        super(context);
        this.zzeez = zzbdb;
        this.zzefb = zzabi;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzefa = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzbdb.zzzm());
        zzbcm zza = zzbdb.zzzm().zzbnz.zza(context, zzbdb, i, z, zzabi, zzbdc);
        this.zzefe = zza;
        if (zza != null) {
            this.zzefa.addView(zza, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcmc)).booleanValue()) {
                zzza();
            }
        }
        this.zzefo = new ImageView(context);
        this.zzefd = ((Long) zzwg.zzpw().zzd(zzaav.zzcmg)).longValue();
        boolean booleanValue = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcme)).booleanValue();
        this.zzefi = booleanValue;
        zzabi zzabi2 = this.zzefb;
        if (zzabi2 != null) {
            zzabi2.zzh("spinner_used", booleanValue ? "1" : "0");
        }
        this.zzefc = new zzbdd(this);
        zzbcm zzbcm = this.zzefe;
        if (zzbcm != null) {
            zzbcm.zza(this);
        }
        if (this.zzefe == null) {
            zzm("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.zzefa.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzc(String str, String[] strArr) {
        this.zzefl = str;
        this.zzefm = strArr;
    }

    public final void zza(float f, float f2) {
        zzbcm zzbcm = this.zzefe;
        if (zzbcm != null) {
            zzbcm.zza(f, f2);
        }
    }

    public final void zzhx() {
        if (this.zzefe != null) {
            if (!TextUtils.isEmpty(this.zzefl)) {
                this.zzefe.zzb(this.zzefl, this.zzefm);
            } else {
                zzd("no_src", new String[0]);
            }
        }
    }

    public final void pause() {
        zzbcm zzbcm = this.zzefe;
        if (zzbcm != null) {
            zzbcm.pause();
        }
    }

    public final void play() {
        zzbcm zzbcm = this.zzefe;
        if (zzbcm != null) {
            zzbcm.play();
        }
    }

    public final void seekTo(int i) {
        zzbcm zzbcm = this.zzefe;
        if (zzbcm != null) {
            zzbcm.seekTo(i);
        }
    }

    public final void zzyy() {
        zzbcm zzbcm = this.zzefe;
        if (zzbcm != null) {
            zzbcm.zzeex.setMuted(true);
            zzbcm.zzys();
        }
    }

    public final void zzyz() {
        zzbcm zzbcm = this.zzefe;
        if (zzbcm != null) {
            zzbcm.zzeex.setMuted(false);
            zzbcm.zzys();
        }
    }

    public final void setVolume(float f) {
        zzbcm zzbcm = this.zzefe;
        if (zzbcm != null) {
            zzbcm.zzeex.setVolume(f);
            zzbcm.zzys();
        }
    }

    public final void zzdj(int i) {
        this.zzefe.zzdj(i);
    }

    public final void zzdk(int i) {
        this.zzefe.zzdk(i);
    }

    public final void zzdl(int i) {
        this.zzefe.zzdl(i);
    }

    public final void zzdm(int i) {
        this.zzefe.zzdm(i);
    }

    public final void zzdn(int i) {
        this.zzefe.zzdn(i);
    }

    public final void zze(MotionEvent motionEvent) {
        zzbcm zzbcm = this.zzefe;
        if (zzbcm != null) {
            zzbcm.dispatchTouchEvent(motionEvent);
        }
    }

    public final void zzza() {
        zzbcm zzbcm = this.zzefe;
        if (zzbcm != null) {
            TextView textView = new TextView(zzbcm.getContext());
            String valueOf = String.valueOf(this.zzefe.zzyo());
            textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            this.zzefa.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.zzefa.bringChildToFront(textView);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcj
    public final void zzyt() {
        this.zzefc.resume();
        zzaye.zzdzw.post(new zzbcp(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbcj
    public final void zzfa() {
        zzbcm zzbcm = this.zzefe;
        if (zzbcm != null && this.zzefk == 0) {
            zzd("canplaythrough", "duration", String.valueOf(((float) zzbcm.getDuration()) / 1000.0f), "videoWidth", String.valueOf(this.zzefe.getVideoWidth()), "videoHeight", String.valueOf(this.zzefe.getVideoHeight()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcj
    public final void zzyu() {
        if (this.zzeez.zzzl() != null && !this.zzefg) {
            boolean z = (this.zzeez.zzzl().getWindow().getAttributes().flags & 128) != 0;
            this.zzefh = z;
            if (!z) {
                this.zzeez.zzzl().getWindow().addFlags(128);
                this.zzefg = true;
            }
        }
        this.zzeff = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbcj
    public final void onPaused() {
        zzd("pause", new String[0]);
        zzzd();
        this.zzeff = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbcj
    public final void zzyv() {
        zzd("ended", new String[0]);
        zzzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbcj
    public final void zzm(String str, String str2) {
        zzd("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbcj
    public final void zzyw() {
        if (this.zzefp && this.zzefn != null && !zzzc()) {
            this.zzefo.setImageBitmap(this.zzefn);
            this.zzefo.invalidate();
            this.zzefa.addView(this.zzefo, new FrameLayout.LayoutParams(-1, -1));
            this.zzefa.bringChildToFront(this.zzefo);
        }
        this.zzefc.pause();
        this.zzefk = this.zzefj;
        zzaye.zzdzw.post(new zzbcs(this));
    }

    public final void destroy() {
        this.zzefc.pause();
        zzbcm zzbcm = this.zzefe;
        if (zzbcm != null) {
            zzbcm.stop();
        }
        zzzd();
    }

    @Override // java.lang.Object
    public final void finalize() throws Throwable {
        try {
            this.zzefc.pause();
            if (this.zzefe != null) {
                zzbcm zzbcm = this.zzefe;
                zzdvi zzdvi = zzbbf.zzedl;
                zzbcm.getClass();
                zzdvi.execute(zzbcn.zza(zzbcm));
            }
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzzb() {
        zzbcm zzbcm = this.zzefe;
        if (zzbcm != null) {
            long currentPosition = (long) zzbcm.getCurrentPosition();
            if (this.zzefj != currentPosition && currentPosition > 0) {
                zzd("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
                this.zzefj = currentPosition;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcj
    public final void zzyx() {
        if (this.zzeff && zzzc()) {
            this.zzefa.removeView(this.zzefo);
        }
        if (this.zzefn != null) {
            long elapsedRealtime = zzq.zzld().elapsedRealtime();
            if (this.zzefe.getBitmap(this.zzefn) != null) {
                this.zzefp = true;
            }
            long elapsedRealtime2 = zzq.zzld().elapsedRealtime() - elapsedRealtime;
            if (zzaxv.zzwr()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(elapsedRealtime2);
                sb.append("ms");
                zzaxv.zzeh(sb.toString());
            }
            if (elapsedRealtime2 > this.zzefd) {
                zzaxv.zzfd("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzefi = false;
                this.zzefn = null;
                zzabi zzabi = this.zzefb;
                if (zzabi != null) {
                    zzabi.zzh("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcj
    public final void zzk(int i, int i2) {
        if (this.zzefi) {
            int max = Math.max(i / ((Integer) zzwg.zzpw().zzd(zzaav.zzcmf)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzwg.zzpw().zzd(zzaav.zzcmf)).intValue(), 1);
            Bitmap bitmap = this.zzefn;
            if (bitmap == null || bitmap.getWidth() != max || this.zzefn.getHeight() != max2) {
                this.zzefn = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.zzefp = false;
            }
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zzefc.resume();
        } else {
            this.zzefc.pause();
            this.zzefk = this.zzefj;
        }
        zzaye.zzdzw.post(new zzbcq(this, z));
    }

    @Override // com.google.android.gms.internal.ads.zzbcj
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zzefc.resume();
            z = true;
        } else {
            this.zzefc.pause();
            this.zzefk = this.zzefj;
            z = false;
        }
        zzaye.zzdzw.post(new zzbcr(this, z));
    }

    private final boolean zzzc() {
        return this.zzefo.getParent() != null;
    }

    /* access modifiers changed from: private */
    public final void zzd(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzeez.zza("onVideoEvent", hashMap);
    }

    private final void zzzd() {
        if (this.zzeez.zzzl() != null && this.zzefg && !this.zzefh) {
            this.zzeez.zzzl().getWindow().clearFlags(128);
            this.zzefg = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzau(boolean z) {
        zzd("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }
}
