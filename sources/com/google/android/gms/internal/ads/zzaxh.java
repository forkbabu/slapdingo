package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaxh {
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public zzbbd zzboy;
    private final zzaxs zzdxc = new zzaxs(zzwg.zzpx(), this.zzdxl);
    private zzqp zzdxk;
    private final zzaya zzdxl = new zzaya();
    /* access modifiers changed from: private */
    public zzaay zzdxm = null;
    private Boolean zzdxn = null;
    private final AtomicInteger zzdxo = new AtomicInteger(0);
    private final zzaxm zzdxp = new zzaxm(null);
    private final Object zzdxq = new Object();
    private zzdvf<ArrayList<String>> zzdxr;
    /* access modifiers changed from: private */
    public Context zzvr;
    private boolean zzzg = false;

    public final zzaay zzvy() {
        zzaay zzaay;
        synchronized (this.lock) {
            zzaay = this.zzdxm;
        }
        return zzaay;
    }

    public final void zza(Boolean bool) {
        synchronized (this.lock) {
            this.zzdxn = bool;
        }
    }

    public final Boolean zzvz() {
        Boolean bool;
        synchronized (this.lock) {
            bool = this.zzdxn;
        }
        return bool;
    }

    public final void zzwa() {
        this.zzdxp.zzwa();
    }

    public final void zzd(Context context, zzbbd zzbbd) {
        synchronized (this.lock) {
            if (!this.zzzg) {
                this.zzvr = context.getApplicationContext();
                this.zzboy = zzbbd;
                zzq.zzkz().zza(this.zzdxc);
                zzaay zzaay = null;
                this.zzdxl.zza(this.zzvr, (String) null, true);
                zzarl.zzc(this.zzvr, this.zzboy);
                this.zzdxk = new zzqp(context.getApplicationContext(), this.zzboy);
                zzq.zzlf();
                if (!zzace.zzczj.get().booleanValue()) {
                    zzaxv.zzeh("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                } else {
                    zzaay = new zzaay();
                }
                this.zzdxm = zzaay;
                if (zzaay != null) {
                    zzbbj.zza(new zzaxj(this).zzwq(), "AppState.registerCsiReporter");
                }
                this.zzzg = true;
                zzwf();
            }
        }
        zzq.zzkw().zzs(context, zzbbd.zzbpn);
    }

    public final Resources getResources() {
        if (this.zzboy.zzedf) {
            return this.zzvr.getResources();
        }
        try {
            zzbaz.zzbu(this.zzvr).getResources();
            return null;
        } catch (zzbbb e) {
            zzaxv.zzd("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void zza(Throwable th, String str) {
        zzarl.zzc(this.zzvr, this.zzboy).zza(th, str);
    }

    public final void zzb(Throwable th, String str) {
        zzarl.zzc(this.zzvr, this.zzboy).zza(th, str, zzacq.zzdba.get().floatValue());
    }

    public final void zzwb() {
        this.zzdxo.incrementAndGet();
    }

    public final void zzwc() {
        this.zzdxo.decrementAndGet();
    }

    public final int zzwd() {
        return this.zzdxo.get();
    }

    public final zzaxx zzwe() {
        zzaya zzaya;
        synchronized (this.lock) {
            zzaya = this.zzdxl;
        }
        return zzaya;
    }

    public final Context getApplicationContext() {
        return this.zzvr;
    }

    public final zzdvf<ArrayList<String>> zzwf() {
        if (PlatformVersion.isAtLeastJellyBean() && this.zzvr != null) {
            if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcqk)).booleanValue()) {
                synchronized (this.zzdxq) {
                    if (this.zzdxr != null) {
                        zzdvf<ArrayList<String>> zzdvf = this.zzdxr;
                        return zzdvf;
                    }
                    zzdvf<ArrayList<String>> zze = zzbbf.zzedh.zze(new zzaxk(this));
                    this.zzdxr = zze;
                    return zze;
                }
            }
        }
        return zzdux.zzaf(new ArrayList());
    }

    private static ArrayList<String> zzam(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(context.getApplicationInfo().packageName, 4096);
            if (!(packageInfo.requestedPermissions == null || packageInfo.requestedPermissionsFlags == null)) {
                for (int i = 0; i < packageInfo.requestedPermissions.length; i++) {
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(packageInfo.requestedPermissions[i]);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final zzaxs zzwg() {
        return this.zzdxc;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzwh() throws Exception {
        return zzam(zzatd.zzab(this.zzvr));
    }
}
