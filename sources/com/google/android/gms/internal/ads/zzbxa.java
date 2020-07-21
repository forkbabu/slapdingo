package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbxa {
    private final zzdim zzfpb;
    private final Set<zzbyg<zzuu>> zzfsr;
    private final Set<zzbyg<zzbsl>> zzfss;
    private final Set<zzbyg<zzbtd>> zzfst;
    private final Set<zzbyg<zzbuf>> zzfsu;
    private final Set<zzbyg<zzbua>> zzfsv;
    private final Set<zzbyg<zzbsq>> zzfsw;
    private final Set<zzbyg<zzbsz>> zzfsx;
    private final Set<zzbyg<AdMetadataListener>> zzfsy;
    private final Set<zzbyg<AppEventListener>> zzfsz;
    private final Set<zzbyg<zzbup>> zzfta;
    private zzbso zzftb;
    private zzcts zzftc;

    private zzbxa(zza zza2) {
        this.zzfsr = zza2.zzfsr;
        this.zzfst = zza2.zzfst;
        this.zzfsu = zza2.zzfsu;
        this.zzfss = zza2.zzfss;
        this.zzfsv = zza2.zzfsv;
        this.zzfsw = zza2.zzfsw;
        this.zzfsx = zza2.zzfsx;
        this.zzfsy = zza2.zzfsy;
        this.zzfsz = zza2.zzfsz;
        this.zzfta = zza2.zzftf;
        this.zzfpb = zza2.zzfpb;
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static class zza {
        /* access modifiers changed from: private */
        public zzdim zzfpb;
        /* access modifiers changed from: private */
        public Set<zzbyg<zzuu>> zzfsr = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbyg<zzbsl>> zzfss = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbyg<zzbtd>> zzfst = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbyg<zzbuf>> zzfsu = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbyg<zzbua>> zzfsv = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbyg<zzbsq>> zzfsw = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbyg<zzbsz>> zzfsx = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbyg<AdMetadataListener>> zzfsy = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbyg<AppEventListener>> zzfsz = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbyg<zzbup>> zzftf = new HashSet();

        public final zza zza(zzbsl zzbsl, Executor executor) {
            this.zzfss.add(new zzbyg<>(zzbsl, executor));
            return this;
        }

        public final zza zza(zzbua zzbua, Executor executor) {
            this.zzfsv.add(new zzbyg<>(zzbua, executor));
            return this;
        }

        public final zza zza(zzbsq zzbsq, Executor executor) {
            this.zzfsw.add(new zzbyg<>(zzbsq, executor));
            return this;
        }

        public final zza zza(zzbsz zzbsz, Executor executor) {
            this.zzfsx.add(new zzbyg<>(zzbsz, executor));
            return this;
        }

        public final zza zza(AdMetadataListener adMetadataListener, Executor executor) {
            this.zzfsy.add(new zzbyg<>(adMetadataListener, executor));
            return this;
        }

        public final zza zza(AppEventListener appEventListener, Executor executor) {
            this.zzfsz.add(new zzbyg<>(appEventListener, executor));
            return this;
        }

        public final zza zza(zzxe zzxe, Executor executor) {
            if (this.zzfsz != null) {
                zzcxa zzcxa = new zzcxa();
                zzcxa.zzb(zzxe);
                this.zzfsz.add(new zzbyg<>(zzcxa, executor));
            }
            return this;
        }

        public final zza zza(zzuu zzuu, Executor executor) {
            this.zzfsr.add(new zzbyg<>(zzuu, executor));
            return this;
        }

        public final zza zza(zzbtd zzbtd, Executor executor) {
            this.zzfst.add(new zzbyg<>(zzbtd, executor));
            return this;
        }

        public final zza zza(zzbuf zzbuf, Executor executor) {
            this.zzfsu.add(new zzbyg<>(zzbuf, executor));
            return this;
        }

        public final zza zza(zzbup zzbup, Executor executor) {
            this.zzftf.add(new zzbyg<>(zzbup, executor));
            return this;
        }

        public final zza zza(zzdim zzdim) {
            this.zzfpb = zzdim;
            return this;
        }

        public final zzbxa zzajw() {
            return new zzbxa(this);
        }
    }

    public final Set<zzbyg<zzbsl>> zzajl() {
        return this.zzfss;
    }

    public final Set<zzbyg<zzbua>> zzajm() {
        return this.zzfsv;
    }

    public final Set<zzbyg<zzbsq>> zzajn() {
        return this.zzfsw;
    }

    public final Set<zzbyg<zzbsz>> zzajo() {
        return this.zzfsx;
    }

    public final Set<zzbyg<AdMetadataListener>> zzajp() {
        return this.zzfsy;
    }

    public final Set<zzbyg<AppEventListener>> zzajq() {
        return this.zzfsz;
    }

    public final Set<zzbyg<zzuu>> zzajr() {
        return this.zzfsr;
    }

    public final Set<zzbyg<zzbtd>> zzajs() {
        return this.zzfst;
    }

    public final Set<zzbyg<zzbuf>> zzajt() {
        return this.zzfsu;
    }

    public final Set<zzbyg<zzbup>> zzaju() {
        return this.zzfta;
    }

    public final zzdim zzajv() {
        return this.zzfpb;
    }

    public final zzbso zzc(Set<zzbyg<zzbsq>> set) {
        if (this.zzftb == null) {
            this.zzftb = new zzbso(set);
        }
        return this.zzftb;
    }

    public final zzcts zza(Clock clock, zzctu zzctu) {
        if (this.zzftc == null) {
            this.zzftc = new zzcts(clock, zzctu);
        }
        return this.zzftc;
    }
}
