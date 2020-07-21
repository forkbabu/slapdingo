package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdiu extends AdMetadataListener implements zzbsl, zzbsq, zzbsz, zzbua, zzbup, zzdim {
    private final zzdmi zzgwx;
    private final AtomicReference<AdMetadataListener> zzgyi = new AtomicReference<>();
    private final AtomicReference<zzauq> zzgyj = new AtomicReference<>();
    private final AtomicReference<zzauj> zzgyk = new AtomicReference<>();
    private final AtomicReference<zzatq> zzgyl = new AtomicReference<>();
    private final AtomicReference<zzaur> zzgym = new AtomicReference<>();
    private final AtomicReference<zzath> zzgyn = new AtomicReference<>();
    private final AtomicReference<zzyc> zzgyo = new AtomicReference<>();
    private zzdiu zzgyp = null;

    public zzdiu(zzdmi zzdmi) {
        this.zzgwx = zzdmi;
    }

    public static zzdiu zzb(zzdiu zzdiu) {
        zzdiu zzdiu2 = new zzdiu(zzdiu.zzgwx);
        zzdiu2.zzb((zzdim) zzdiu);
        return zzdiu2;
    }

    public final void zzb(zzauq zzauq) {
        this.zzgyj.set(zzauq);
    }

    public final void zzb(zzauj zzauj) {
        this.zzgyk.set(zzauj);
    }

    public final void zzb(zzaur zzaur) {
        this.zzgym.set(zzaur);
    }

    public final void zza(AdMetadataListener adMetadataListener) {
        this.zzgyi.set(adMetadataListener);
    }

    public final void zzc(zzyc zzyc) {
        this.zzgyo.set(zzyc);
    }

    @Deprecated
    public final void zzb(zzatq zzatq) {
        this.zzgyl.set(zzatq);
    }

    @Deprecated
    public final void zzb(zzath zzath) {
        this.zzgyn.set(zzath);
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void onAdLoaded() {
        zzdiu zzdiu = this;
        while (true) {
            zzdiu zzdiu2 = zzdiu.zzgyp;
            if (zzdiu2 != null) {
                zzdiu = zzdiu2;
            } else {
                zzdib.zza(zzdiu.zzgyj, zzdit.zzgxc);
                zzdib.zza(zzdiu.zzgyl, zzdiw.zzgxc);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsq
    public final void onAdFailedToLoad(int i) {
        zzdiu zzdiu = this;
        while (true) {
            zzdiu zzdiu2 = zzdiu.zzgyp;
            if (zzdiu2 != null) {
                zzdiu = zzdiu2;
            } else {
                zzdib.zza(zzdiu.zzgyj, new zzdjg(i));
                zzdib.zza(zzdiu.zzgyl, new zzdjf(i));
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdOpened() {
        zzdiu zzdiu = this;
        while (true) {
            zzdiu zzdiu2 = zzdiu.zzgyp;
            if (zzdiu2 != null) {
                zzdiu = zzdiu2;
            } else {
                zzdib.zza(zzdiu.zzgyk, zzdji.zzgxc);
                zzdib.zza(zzdiu.zzgyl, zzdjh.zzgxc);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdClosed() {
        zzdiu zzdiu = this;
        while (true) {
            zzdiu zzdiu2 = zzdiu.zzgyp;
            if (zzdiu2 != null) {
                zzdiu = zzdiu2;
            } else {
                zzdiu.zzgwx.onAdClosed();
                zzdib.zza(zzdiu.zzgyk, zzdjk.zzgxc);
                zzdib.zza(zzdiu.zzgyl, zzdjj.zzgxc);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdLeftApplication() {
        zzdiu zzdiu = this;
        while (true) {
            zzdiu zzdiu2 = zzdiu.zzgyp;
            if (zzdiu2 != null) {
                zzdiu = zzdiu2;
            } else {
                zzdib.zza(zzdiu.zzgyl, zzdjm.zzgxc);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onRewardedVideoStarted() {
        zzdiu zzdiu = this;
        while (true) {
            zzdiu zzdiu2 = zzdiu.zzgyp;
            if (zzdiu2 != null) {
                zzdiu = zzdiu2;
            } else {
                zzdib.zza(zzdiu.zzgyl, zzdjl.zzgxc);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void zzb(zzatg zzatg, String str, String str2) {
        zzdiu zzdiu = this;
        while (true) {
            zzdiu zzdiu2 = zzdiu.zzgyp;
            if (zzdiu2 != null) {
                zzdiu = zzdiu2;
            } else {
                zzdib.zza(zzdiu.zzgyk, new zzdiv(zzatg));
                zzdib.zza(zzdiu.zzgym, new zzdiy(zzatg, str, str2));
                zzdib.zza(zzdiu.zzgyl, new zzdix(zzatg));
                zzdib.zza(zzdiu.zzgyn, new zzdja(zzatg, str, str2));
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onRewardedVideoCompleted() {
        zzdiu zzdiu = this;
        while (true) {
            zzdiu zzdiu2 = zzdiu.zzgyp;
            if (zzdiu2 != null) {
                zzdiu = zzdiu2;
            } else {
                zzdib.zza(zzdiu.zzgyl, zzdiz.zzgxc);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzd(zzuy zzuy) {
        zzdiu zzdiu = this;
        while (true) {
            zzdiu zzdiu2 = zzdiu.zzgyp;
            if (zzdiu2 != null) {
                zzdiu = zzdiu2;
            } else {
                zzdib.zza(zzdiu.zzgyk, new zzdjc(zzuy));
                zzdib.zza(zzdiu.zzgyk, new zzdjb(zzuy));
                return;
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zzdiu zzdiu = this.zzgyp;
        if (zzdiu != null) {
            zzdiu.onAdMetadataChanged();
        } else {
            zzdib.zza(this.zzgyi, zzdje.zzgxc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbup
    public final void zzb(zzvj zzvj) {
        zzdiu zzdiu = this;
        while (true) {
            zzdiu zzdiu2 = zzdiu.zzgyp;
            if (zzdiu2 != null) {
                zzdiu = zzdiu2;
            } else {
                zzdib.zza(zzdiu.zzgyo, new zzdjd(zzvj));
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdim
    public final void zzb(zzdim zzdim) {
        this.zzgyp = (zzdiu) zzdim;
    }
}
