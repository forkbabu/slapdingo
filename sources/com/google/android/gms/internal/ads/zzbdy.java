package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbdy implements zzhd, zzmw, zzoy<zzok>, zzqf {
    private static int zzejh;
    private static int zzeji;
    private int bytesTransferred;
    private final zzbdc zzeij;
    private final zzbdv zzejj;
    private final zzhv zzejk;
    private final zzhv zzejl;
    private final zzny zzejm;
    private zzhe zzejn;
    private ByteBuffer zzejo;
    private boolean zzejp;
    private zzbef zzejq;
    private Set<WeakReference<zzbdr>> zzejr = new HashSet();
    private final Context zzvr;

    public zzbdy(Context context, zzbdc zzbdc) {
        this.zzvr = context;
        this.zzeij = zzbdc;
        this.zzejj = new zzbdv();
        this.zzejk = new zzpz(this.zzvr, zzlu.zzbcm, 0, zzaye.zzdzw, this, -1);
        this.zzejl = new zziz(zzlu.zzbcm);
        this.zzejm = new zznx();
        if (zzaxv.zzwr()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zzaxv.zzeh(sb.toString());
        }
        zzejh++;
        zzhe zza = zzhi.zza(new zzhv[]{this.zzejl, this.zzejk}, this.zzejm, this.zzejj);
        this.zzejn = zza;
        zza.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void zza(zzhw zzhw) {
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void zza(zzia zzia, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void zza(zznr zznr, zzof zzof) {
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzb(Surface surface) {
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzd(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zze(zzjj zzjj) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzoy
    public final /* bridge */ /* synthetic */ void zze(zzok zzok) {
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void zzej() {
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzf(int i, long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzf(zzjj zzjj) {
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void zzf(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzk(zzhq zzhq) {
    }

    public final zzhe zzaal() {
        return this.zzejn;
    }

    public static int zzaam() {
        return zzejh;
    }

    public static int zzaan() {
        return zzeji;
    }

    public final void zza(zzbef zzbef) {
        this.zzejq = zzbef;
    }

    public final zzbdv zzaao() {
        return this.zzejj;
    }

    public final void zza(Uri[] uriArr, String str) {
        zza(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zza(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zznb zznb;
        if (this.zzejn != null) {
            this.zzejo = byteBuffer;
            this.zzejp = z;
            if (uriArr.length == 1) {
                zznb = zzb(uriArr[0], str);
            } else {
                zznb[] zznbArr = new zznb[uriArr.length];
                for (int i = 0; i < uriArr.length; i++) {
                    zznbArr[i] = zzb(uriArr[i], str);
                }
                zznb = new zznc(zznbArr);
            }
            this.zzejn.zza(zznb);
            zzeji++;
        }
    }

    public final void release() {
        zzhe zzhe = this.zzejn;
        if (zzhe != null) {
            zzhe.zzb(this);
            this.zzejn.release();
            this.zzejn = null;
            zzeji--;
        }
    }

    public final long getBytesTransferred() {
        return (long) this.bytesTransferred;
    }

    @Override // com.google.android.gms.internal.ads.zzmw
    public final void zzb(IOException iOException) {
        zzbef zzbef = this.zzejq;
        if (zzbef != null) {
            zzbef.zza("onLoadError", iOException);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzb(int i, int i2, int i3, float f) {
        zzbef zzbef = this.zzejq;
        if (zzbef != null) {
            zzbef.zzn(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void zza(boolean z, int i) {
        zzbef zzbef = this.zzejq;
        if (zzbef != null) {
            zzbef.zzdo(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void zza(zzhb zzhb) {
        zzbef zzbef = this.zzejq;
        if (zzbef != null) {
            zzbef.zza("onPlayerError", zzhb);
        }
    }

    public final void zzdn(int i) {
        for (WeakReference<zzbdr> weakReference : this.zzejr) {
            zzbdr zzbdr = weakReference.get();
            if (zzbdr != null) {
                zzbdr.setReceiveBufferSize(i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Surface surface, boolean z) {
        if (this.zzejn != null) {
            zzhf zzhf = new zzhf(this.zzejk, 1, surface);
            if (z) {
                this.zzejn.zzb(zzhf);
                return;
            }
            this.zzejn.zza(zzhf);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(float f, boolean z) {
        if (this.zzejn != null) {
            zzhf zzhf = new zzhf(this.zzejl, 2, Float.valueOf(f));
            if (z) {
                this.zzejn.zzb(zzhf);
                return;
            }
            this.zzejn.zza(zzhf);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzaw(boolean z) {
        if (this.zzejn != null) {
            for (int i = 0; i < this.zzejn.zzel(); i++) {
                this.zzejm.zzf(i, !z);
            }
        }
    }

    private final zznb zzb(Uri uri, String str) {
        zzon zzon;
        zzjy zzjy;
        if (!this.zzejp || this.zzejo.limit() <= 0) {
            if (this.zzeij.zzehp > 0) {
                zzon = new zzbea(this, str);
            } else {
                zzon = new zzbdz(this, str);
            }
            if (this.zzeij.zzehq) {
                zzon = new zzbec(this, zzon);
            }
            if (this.zzejo.limit() > 0) {
                byte[] bArr = new byte[this.zzejo.limit()];
                this.zzejo.get(bArr);
                zzon = new zzbeb(zzon, bArr);
            }
        } else {
            byte[] bArr2 = new byte[this.zzejo.limit()];
            this.zzejo.get(bArr2);
            zzon = new zzbdx(bArr2);
        }
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzclt)).booleanValue()) {
            zzjy = zzbee.zzejv;
        } else {
            zzjy = zzbed.zzejv;
        }
        return new zzmx(uri, zzon, zzjy, this.zzeij.zzehr, zzaye.zzdzw, this, null, this.zzeij.zzehn);
    }

    public final void finalize() throws Throwable {
        zzejh--;
        if (zzaxv.zzwr()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zzaxv.zzeh(sb.toString());
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.google.android.gms.internal.ads.zzoy
    public final /* synthetic */ void zzc(zzok zzok, int i) {
        this.bytesTransferred += i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.android.gms.internal.ads.zzop] */
    @Override // com.google.android.gms.internal.ads.zzoy
    public final /* synthetic */ void zza(zzok zzok, zzop zzop) {
        this.bytesTransferred = 0;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzok zza(zzon zzon) {
        return new zzbdt(this.zzvr, zzon.zzio(), this, new zzbeg(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(boolean z, long j) {
        zzbef zzbef = this.zzejq;
        if (zzbef != null) {
            zzbef.zzb(z, j);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzok zzfk(String str) {
        return new zzor(str, null, this.zzeij.zzehq ? null : this, this.zzeij.zzehk, this.zzeij.zzehm, true, null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzok zzfl(String str) {
        zzbdr zzbdr = new zzbdr(str, this.zzeij.zzehq ? null : this, this.zzeij.zzehk, this.zzeij.zzehm, this.zzeij.zzehp);
        this.zzejr.add(new WeakReference<>(zzbdr));
        return zzbdr;
    }
}
