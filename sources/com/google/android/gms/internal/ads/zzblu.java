package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.common.util.Clock;
import com.itextpdf.text.html.HtmlTags;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzblu implements zzo, zzbtd, zzbtg, zzqs {
    private final Clock zzbqd;
    private final zzblp zzfll;
    private final zzbls zzflm;
    private final Set<zzbfn> zzfln = new HashSet();
    private final zzamd<JSONObject, JSONObject> zzflo;
    private final Executor zzflp;
    private final AtomicBoolean zzflq = new AtomicBoolean(false);
    private final zzblw zzflr = new zzblw();
    private boolean zzfls = false;
    private WeakReference<?> zzflt = new WeakReference<>(this);

    public zzblu(zzalw zzalw, zzbls zzbls, Executor executor, zzblp zzblp, Clock clock) {
        this.zzfll = zzblp;
        this.zzflo = zzalw.zzb("google.afma.activeView.handleUpdate", zzalm.zzdhf, zzalm.zzdhf);
        this.zzflm = zzbls;
        this.zzflp = executor;
        this.zzbqd = clock;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzud() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzue() {
    }

    public final synchronized void zzagt() {
        if (!(this.zzflt.get() != null)) {
            zzagv();
        } else if (!this.zzfls && this.zzflq.get()) {
            try {
                this.zzflr.timestamp = this.zzbqd.elapsedRealtime();
                JSONObject zza = this.zzflm.zzj(this.zzflr);
                for (zzbfn zzbfn : this.zzfln) {
                    this.zzflp.execute(new zzblx(zzbfn, zza));
                }
                zzbbj.zzb(this.zzflo.zzf(zza), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e) {
                zzaxv.zza("Failed to call ActiveViewJS", e);
            }
        }
    }

    private final void zzagu() {
        for (zzbfn zzbfn : this.zzfln) {
            this.zzfll.zze(zzbfn);
        }
        this.zzfll.zzags();
    }

    public final synchronized void zzagv() {
        zzagu();
        this.zzfls = true;
    }

    public final synchronized void zzf(zzbfn zzbfn) {
        this.zzfln.add(zzbfn);
        this.zzfll.zzd(zzbfn);
    }

    public final void zzo(Object obj) {
        this.zzflt = new WeakReference<>(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzqs
    public final synchronized void zza(zzqt zzqt) {
        this.zzflr.zzbrd = zzqt.zzbrd;
        this.zzflr.zzfly = zzqt;
        zzagt();
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final synchronized void zzca(Context context) {
        this.zzflr.zzflv = true;
        zzagt();
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final synchronized void zzcb(Context context) {
        this.zzflr.zzflv = false;
        zzagt();
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final synchronized void zzcc(Context context) {
        this.zzflr.zzflx = HtmlTags.U;
        zzagt();
        zzagu();
        this.zzfls = true;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onPause() {
        this.zzflr.zzflv = true;
        zzagt();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onResume() {
        this.zzflr.zzflv = false;
        zzagt();
    }

    @Override // com.google.android.gms.internal.ads.zzbtd
    public final synchronized void onAdImpression() {
        if (this.zzflq.compareAndSet(false, true)) {
            this.zzfll.zza(this);
            zzagt();
        }
    }
}
