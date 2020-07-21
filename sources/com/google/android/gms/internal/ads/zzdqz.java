package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.util.HashMap;
import java.util.Map;
import org.opencv.features2d.FeatureDetector;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdqz implements zzdpp {
    private final Object zzhjf;
    private final zzdrc zzhjg;
    private final zzdrl zzhjh;
    private final zzdpm zzvv;

    zzdqz(Object obj, zzdrc zzdrc, zzdrl zzdrl, zzdpm zzdpm) {
        this.zzhjf = obj;
        this.zzhjg = zzdrc;
        this.zzhjh = zzdrl;
        this.zzvv = zzdpm;
    }

    /* access modifiers changed from: package-private */
    public final zzdrc zzavp() {
        return this.zzhjg;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzavq() throws zzdrj {
        try {
        } catch (Exception e) {
            throw new zzdrj((int) FeatureDetector.PYRAMID_FAST, e);
        }
        return ((Boolean) this.zzhjf.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.zzhjf, new Object[0])).booleanValue();
    }

    public final synchronized void close() throws zzdrj {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.zzhjf.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zzhjf, new Object[0]);
            this.zzvv.zzg(3001, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzdrj((int) FeatureDetector.PYRAMID_SIFT, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpp
    public final synchronized String zzv(Context context, String str) {
        Map<String, Object> zzce;
        zzce = this.zzhjh.zzce();
        zzce.put("f", "q");
        zzce.put("ctx", context);
        zzce.put("aid", null);
        return zzk(zzb(null, zzce));
    }

    @Override // com.google.android.gms.internal.ads.zzdpp
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map<String, Object> zzcf;
        zzcf = this.zzhjh.zzcf();
        zzcf.put("f", "v");
        zzcf.put("ctx", context);
        zzcf.put("aid", null);
        zzcf.put("view", view);
        zzcf.put("act", activity);
        return zzk(zzb(null, zzcf));
    }

    @Override // com.google.android.gms.internal.ads.zzdpp
    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map<String, Object> zzcg;
        zzcg = this.zzhjh.zzcg();
        zzcg.put("f", "c");
        zzcg.put("ctx", context);
        zzcg.put("cs", str2);
        zzcg.put("aid", null);
        zzcg.put("view", view);
        zzcg.put("act", activity);
        return zzk(zzb(null, zzcg));
    }

    @Override // com.google.android.gms.internal.ads.zzdpp
    public final synchronized void zza(String str, MotionEvent motionEvent) throws zzdrj {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("aid", null);
            hashMap.put("evt", motionEvent);
            this.zzhjf.getClass().getDeclaredMethod("he", Map.class).invoke(this.zzhjf, hashMap);
            this.zzvv.zzg(3003, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzdrj((int) FeatureDetector.PYRAMID_ORB, e);
        }
    }

    public final synchronized int zzavr() throws zzdrj {
        try {
        } catch (Exception e) {
            throw new zzdrj((int) FeatureDetector.PYRAMID_MSER, e);
        }
        return ((Integer) this.zzhjf.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zzhjf, new Object[0])).intValue();
    }

    private static String zzk(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(((zzcf.zzf) ((zzegb) zzcf.zzf.zzbm().zzb(zzcm.DG).zzj(zzeer.zzu(bArr)).zzbfq())).toByteArray(), 11);
    }

    private final synchronized byte[] zzb(Map<String, String> map, Map<String, Object> map2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            this.zzvv.zza(FeatureDetector.PYRAMID_GFTT, System.currentTimeMillis() - currentTimeMillis, e);
            return null;
        }
        return (byte[]) this.zzhjf.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(this.zzhjf, null, map2);
    }
}
