package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.zzq;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzckl implements zzbsp, zzbtd, zzbwk {
    private final zzdkw zzetl;
    private final zzdkk zzfko;
    private final zzckx zzfmz;
    private final zzdli zzged;
    private Boolean zzgee;
    private final boolean zzgef = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcwr)).booleanValue();
    private final Context zzvr;

    public zzckl(Context context, zzdli zzdli, zzckx zzckx, zzdkw zzdkw, zzdkk zzdkk) {
        this.zzvr = context;
        this.zzged = zzdli;
        this.zzfmz = zzckx;
        this.zzetl = zzdkw;
        this.zzfko = zzdkk;
    }

    @Override // com.google.android.gms.internal.ads.zzbtd
    public final void onAdImpression() {
        if (zzaoe()) {
            zzgg("impression").zzaoi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwk
    public final void zzaji() {
        if (zzaoe()) {
            zzgg("adapter_impression").zzaoi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwk
    public final void zzajj() {
        if (zzaoe()) {
            zzgg("adapter_shown").zzaoi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void zzc(zzuy zzuy) {
        if (this.zzgef) {
            zzckw zzgg = zzgg("ifts");
            zzgg.zzq("reason", "adapter");
            if (zzuy.errorCode >= 0) {
                zzgg.zzq("arec", String.valueOf(zzuy.errorCode));
            }
            String zzgt = this.zzged.zzgt(zzuy.zzcgo);
            if (zzgt != null) {
                zzgg.zzq("areec", zzgt);
            }
            zzgg.zzaoi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void zza(zzcap zzcap) {
        if (this.zzgef) {
            zzckw zzgg = zzgg("ifts");
            zzgg.zzq("reason", "exception");
            if (!TextUtils.isEmpty(zzcap.getMessage())) {
                zzgg.zzq(NotificationCompat.CATEGORY_MESSAGE, zzcap.getMessage());
            }
            zzgg.zzaoi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void zzaja() {
        if (this.zzgef) {
            zzckw zzgg = zzgg("ifts");
            zzgg.zzq("reason", "blocked");
            zzgg.zzaoi();
        }
    }

    private final boolean zzaoe() {
        if (this.zzgee == null) {
            synchronized (this) {
                if (this.zzgee == null) {
                    zzaag<String> zzaag = zzaav.zzcps;
                    zzq.zzkw();
                    this.zzgee = Boolean.valueOf(zzf((String) zzwg.zzpw().zzd(zzaag), zzaye.zzbe(this.zzvr)));
                }
            }
        }
        return this.zzgee.booleanValue();
    }

    private static boolean zzf(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e) {
                zzq.zzla().zza(e, "CsiActionsListener.isPatternMatched");
            }
        }
        return false;
    }

    private final zzckw zzgg(String str) {
        zzckw zzd = this.zzfmz.zzaok().zza(this.zzetl.zzhau.zzhar).zzd(this.zzfko);
        zzd.zzq("action", str);
        if (!this.zzfko.zzgzs.isEmpty()) {
            zzd.zzq("ancn", this.zzfko.zzgzs.get(0));
        }
        return zzd;
    }
}
