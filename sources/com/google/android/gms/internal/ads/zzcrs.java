package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcrs implements zzcqt<zzbzj> {
    private final zzdki zzfkk;
    private final Executor zzflp;
    private final zzcae zzgkx;
    private final Context zzvr;

    public zzcrs(Context context, Executor executor, zzcae zzcae, zzdki zzdki) {
        this.zzvr = context;
        this.zzgkx = zzcae;
        this.zzflp = executor;
        this.zzfkk = zzdki;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final boolean zza(zzdkw zzdkw, zzdkk zzdkk) {
        return (this.zzvr instanceof Activity) && PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzabs.zzk(this.zzvr) && !TextUtils.isEmpty(zze(zzdkk));
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final zzdvf<zzbzj> zzb(zzdkw zzdkw, zzdkk zzdkk) {
        String zze = zze(zzdkk);
        return zzdux.zzb(zzdux.zzaf(null), new zzcrv(this, zze != null ? Uri.parse(zze) : null, zzdkw, zzdkk), this.zzflp);
    }

    private static String zze(zzdkk zzdkk) {
        try {
            return zzdkk.zzgzu.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(Uri uri, zzdkw zzdkw, zzdkk zzdkk, Object obj) throws Exception {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            zzd zzd = new zzd(build.intent);
            zzbbn zzbbn = new zzbbn();
            zzbzl zza = this.zzgkx.zza(new zzbpr(zzdkw, zzdkk, null), new zzbzk(new zzcru(zzbbn)));
            zzbbn.set(new AdOverlayInfoParcel(zzd, null, zza.zzafx(), null, new zzbbd(0, 0, false)));
            this.zzfkk.zzwa();
            return zzdux.zzaf(zza.zzafw());
        } catch (Throwable th) {
            zzaxv.zzc("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
