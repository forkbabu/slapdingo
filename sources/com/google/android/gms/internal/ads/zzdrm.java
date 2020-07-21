package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import org.opencv.features2d.FeatureDetector;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdrm {
    private static final HashMap<String, Class<?>> zzhjw = new HashMap<>();
    private final zzdrl zzhjh;
    private final zzdpk zzhjx;
    private zzdqz zzhjy;
    private final Object zzhjz = new Object();
    private final Context zzvr;
    private final zzdpm zzvv;

    public zzdrm(Context context, zzdrl zzdrl, zzdpm zzdpm, zzdpk zzdpk) {
        this.zzvr = context;
        this.zzhjh = zzdrl;
        this.zzvv = zzdpm;
        this.zzhjx = zzdpk;
    }

    private final synchronized Class<?> zza(zzdrc zzdrc) throws zzdrj {
        if (zzdrc.zzavv() != null) {
            String zzdh = zzdrc.zzavv().zzdh();
            Class<?> cls = zzhjw.get(zzdh);
            if (cls != null) {
                return cls;
            }
            try {
                if (this.zzhjx.zzb(zzdrc.zzavw())) {
                    try {
                        File zzavx = zzdrc.zzavx();
                        if (!zzavx.exists()) {
                            zzavx.mkdirs();
                        }
                        Class<?> loadClass = new DexClassLoader(zzdrc.zzavw().getAbsolutePath(), zzavx.getAbsolutePath(), null, this.zzvr.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                        zzhjw.put(zzdh, loadClass);
                        return loadClass;
                    } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e) {
                        throw new zzdrj((int) FeatureDetector.PYRAMID_HARRIS, e);
                    }
                } else {
                    throw new zzdrj(2026, "VM did not pass signature verification");
                }
            } catch (GeneralSecurityException e2) {
                throw new zzdrj(2026, e2);
            }
        } else {
            throw new zzdrj(4010, "mc");
        }
    }

    private final Object zza(Class<?> cls, zzdrc zzdrc) throws zzdrj {
        try {
            return cls.getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzvr, "msa-r", zzdrc.zzavy(), null, new Bundle(), 2);
        } catch (Exception e) {
            throw new zzdrj((int) FeatureDetector.PYRAMID_SURF, e);
        }
    }

    public final void zzb(zzdrc zzdrc) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzdqz zzdqz = new zzdqz(zza(zza(zzdrc), zzdrc), zzdrc, this.zzhjh, this.zzvv);
            if (zzdqz.zzavq()) {
                int zzavr = zzdqz.zzavr();
                if (zzavr == 0) {
                    synchronized (this.zzhjz) {
                        if (this.zzhjy != null) {
                            try {
                                this.zzhjy.close();
                            } catch (zzdrj e) {
                                this.zzvv.zza(e.zzavz(), -1, e);
                            }
                        }
                        this.zzhjy = zzdqz;
                    }
                    this.zzvv.zzg(3000, System.currentTimeMillis() - currentTimeMillis);
                    return;
                }
                StringBuilder sb = new StringBuilder(15);
                sb.append("ci: ");
                sb.append(zzavr);
                throw new zzdrj(4001, sb.toString());
            }
            throw new zzdrj(4000, "init failed");
        } catch (zzdrj e2) {
            this.zzvv.zza(e2.zzavz(), System.currentTimeMillis() - currentTimeMillis, e2);
        } catch (Exception e3) {
            this.zzvv.zza(4010, System.currentTimeMillis() - currentTimeMillis, e3);
        }
    }

    public final zzdpp zzawa() {
        zzdqz zzdqz;
        synchronized (this.zzhjz) {
            zzdqz = this.zzhjy;
        }
        return zzdqz;
    }

    public final zzdrc zzawb() {
        synchronized (this.zzhjz) {
            if (this.zzhjy == null) {
                return null;
            }
            zzdrc zzavp = this.zzhjy.zzavp();
            return zzavp;
        }
    }
}
