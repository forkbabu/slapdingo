package com.google.android.gms.internal.ads;

import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzgk {
    private static final String TAG = zzgk.class.getSimpleName();
    private final String className;
    private final String zzabj;
    private final int zzabk = 2;
    private volatile Method zzabl = null;
    private final Class<?>[] zzabm;
    private CountDownLatch zzabn = new CountDownLatch(1);
    private final zzex zzwf;

    public zzgk(zzex zzex, String str, String str2, Class<?>... clsArr) {
        this.zzwf = zzex;
        this.className = str;
        this.zzabj = str2;
        this.zzabm = clsArr;
        zzex.zzch().submit(new zzgj(this));
    }

    /* access modifiers changed from: private */
    public final void zzdb() {
        try {
            Class loadClass = this.zzwf.zzci().loadClass(zzb(this.zzwf.zzck(), this.className));
            if (loadClass != null) {
                this.zzabl = loadClass.getMethod(zzb(this.zzwf.zzck(), this.zzabj), this.zzabm);
                if (this.zzabl == null) {
                    this.zzabn.countDown();
                } else {
                    this.zzabn.countDown();
                }
            }
        } catch (zzeh unused) {
        } catch (UnsupportedEncodingException unused2) {
        } catch (ClassNotFoundException unused3) {
        } catch (NoSuchMethodException unused4) {
        } catch (NullPointerException unused5) {
        } finally {
            this.zzabn.countDown();
        }
    }

    private final String zzb(byte[] bArr, String str) throws zzeh, UnsupportedEncodingException {
        return new String(this.zzwf.zzcj().zza(bArr, str), XmpWriter.UTF8);
    }

    public final Method zzdc() {
        if (this.zzabl != null) {
            return this.zzabl;
        }
        try {
            if (!this.zzabn.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zzabl;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
