package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzccd extends zzbpb {
    private final zzbbd zzboy;
    private final zzeg zzemz;
    private final Executor zzflp;
    private final zzccv zzfnj;
    private final zzavv zzfow;
    private final zzcww zzfsh;
    private final zzcck zzfuu;
    private final zzccs zzfvy;
    private final zzcdg zzfvz;
    private final zzcco zzfwa;
    private final zzeku<zzcgj> zzfwb;
    private final zzeku<zzcgh> zzfwc;
    private final zzeku<zzcgm> zzfwd;
    private final zzeku<zzcgd> zzfwe;
    private final zzeku<zzcgl> zzfwf;
    private zzcee zzfwg;
    private boolean zzfwh;
    private final zzccj zzfwi;
    private final Context zzvr;

    public zzccd(zzbpa zzbpa, Executor executor, zzcck zzcck, zzccs zzccs, zzcdg zzcdg, zzcco zzcco, zzccv zzccv, zzeku<zzcgj> zzeku, zzeku<zzcgh> zzeku2, zzeku<zzcgm> zzeku3, zzeku<zzcgd> zzeku4, zzeku<zzcgl> zzeku5, zzavv zzavv, zzeg zzeg, zzbbd zzbbd, Context context, zzccj zzccj, zzcww zzcww) {
        super(zzbpa);
        this.zzflp = executor;
        this.zzfuu = zzcck;
        this.zzfvy = zzccs;
        this.zzfvz = zzcdg;
        this.zzfwa = zzcco;
        this.zzfnj = zzccv;
        this.zzfwb = zzeku;
        this.zzfwc = zzeku2;
        this.zzfwd = zzeku3;
        this.zzfwe = zzeku4;
        this.zzfwf = zzeku5;
        this.zzfow = zzavv;
        this.zzemz = zzeg;
        this.zzboy = zzbbd;
        this.zzvr = context;
        this.zzfwi = zzccj;
        this.zzfsh = zzcww;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzahr() {
        this.zzflp.execute(new zzccc(this));
        if (this.zzfuu.zzalg() != 7) {
            Executor executor = this.zzflp;
            zzccs zzccs = this.zzfvy;
            zzccs.getClass();
            executor.execute(zzccf.zza(zzccs));
        }
        super.zzahr();
    }

    public final synchronized void zzfy(String str) {
        this.zzfvy.zzfy(str);
    }

    public final synchronized void zzakv() {
        if (!this.zzfwh) {
            this.zzfvy.zzakv();
        }
    }

    public final synchronized void zzg(Bundle bundle) {
        this.zzfvy.zzg(bundle);
    }

    public final synchronized boolean zzi(Bundle bundle) {
        if (this.zzfwh) {
            return true;
        }
        boolean zzi = this.zzfvy.zzi(bundle);
        this.zzfwh = zzi;
        return zzi;
    }

    public final synchronized void zzh(Bundle bundle) {
        this.zzfvy.zzh(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final synchronized void destroy() {
        this.zzflp.execute(new zzcce(this));
        super.destroy();
    }

    public final synchronized void zza(zzcee zzcee) {
        zzdw zzcb;
        this.zzfwg = zzcee;
        this.zzfvz.zza(zzcee);
        this.zzfvy.zza(zzcee.zzahk(), zzcee.zzami(), zzcee.zzamj(), zzcee, zzcee);
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcqh)).booleanValue() && (zzcb = this.zzemz.zzcb()) != null) {
            zzcb.zzb(zzcee.zzahk());
        }
        if (zzcee.zzamm() != null) {
            zzcee.zzamm().zza(this.zzfow);
        }
    }

    public final synchronized void zzb(zzcee zzcee) {
        this.zzfvy.zza(zzcee.zzahk(), zzcee.zzamh());
        if (zzcee.zzaml() != null) {
            zzcee.zzaml().setClickable(false);
            zzcee.zzaml().removeAllViews();
        }
        if (zzcee.zzamm() != null) {
            zzcee.zzamm().zzb(this.zzfow);
        }
        this.zzfwg = null;
    }

    public final synchronized void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        this.zzfvz.zzc(this.zzfwg);
        this.zzfvy.zza(view, view2, map, map2, z);
    }

    public final synchronized void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzfvy.zza(view, motionEvent, view2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0069, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(android.view.View r3, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r5, boolean r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzfwh     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 1
            if (r6 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzcdg r6 = r2.zzfvz
            com.google.android.gms.internal.ads.zzcee r1 = r2.zzfwg
            r6.zzd(r1)
            com.google.android.gms.internal.ads.zzccs r6 = r2.zzfvy
            r6.zza(r3, r4, r5)
            r2.zzfwh = r0
            monitor-exit(r2)
            return
        L_0x001a:
            if (r6 != 0) goto L_0x0068
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzaav.zzcrp
            com.google.android.gms.internal.ads.zzaar r1 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r6 = r1.zzd(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0068
            if (r4 == 0) goto L_0x0068
            java.util.Set r6 = r4.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0038:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0068
            java.lang.Object r1 = r6.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r1 = r1.getValue()
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            java.lang.Object r1 = r1.get()
            android.view.View r1 = (android.view.View) r1
            if (r1 == 0) goto L_0x0038
            boolean r1 = zzz(r1)
            if (r1 == 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzcdg r6 = r2.zzfvz
            com.google.android.gms.internal.ads.zzcee r1 = r2.zzfwg
            r6.zzd(r1)
            com.google.android.gms.internal.ads.zzccs r6 = r2.zzfvy
            r6.zza(r3, r4, r5)
            r2.zzfwh = r0
            monitor-exit(r2)
            return
        L_0x0068:
            monitor-exit(r2)
            return
        L_0x006a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccd.zzb(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void setClickConfirmingView(View view) {
        this.zzfvy.setClickConfirmingView(view);
    }

    public final synchronized void zza(zzafo zzafo) {
        this.zzfvy.zza(zzafo);
    }

    public final synchronized void cancelUnconfirmedClick() {
        this.zzfvy.cancelUnconfirmedClick();
    }

    public final synchronized void zza(zzxt zzxt) {
        this.zzfvy.zza(zzxt);
    }

    public final synchronized void zza(zzxp zzxp) {
        this.zzfvy.zza(zzxp);
    }

    public final synchronized void zzsm() {
        this.zzfvy.zzsm();
    }

    public final synchronized void recordCustomClickGesture() {
        if (this.zzfwg == null) {
            zzaxv.zzee("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzflp.execute(new zzcch(this, this.zzfwg instanceof zzcdf));
        }
    }

    public final synchronized boolean isCustomClickGestureEnabled() {
        return this.zzfvy.isCustomClickGestureEnabled();
    }

    public static boolean zzz(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    public final boolean zzalb() {
        return this.zzfwa.zzalt();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0076 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(java.lang.String r11, boolean r12) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzcco r0 = r10.zzfwa
            boolean r0 = r0.zzalc()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            com.google.android.gms.internal.ads.zzcck r0 = r10.zzfuu
            com.google.android.gms.internal.ads.zzbfn r0 = r0.zzalm()
            com.google.android.gms.internal.ads.zzcck r1 = r10.zzfuu
            com.google.android.gms.internal.ads.zzbfn r1 = r1.zzall()
            if (r0 != 0) goto L_0x001a
            if (r1 != 0) goto L_0x001a
            return
        L_0x001a:
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0020
            r4 = 1
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = 0
        L_0x0025:
            r3 = 0
            if (r4 == 0) goto L_0x002a
        L_0x0028:
            r8 = r3
            goto L_0x0032
        L_0x002a:
            if (r2 == 0) goto L_0x0030
            java.lang.String r3 = "javascript"
            r0 = r1
            goto L_0x0028
        L_0x0030:
            r0 = r3
            r8 = r0
        L_0x0032:
            android.webkit.WebView r3 = r0.getWebView()
            if (r3 != 0) goto L_0x0039
            return
        L_0x0039:
            com.google.android.gms.internal.ads.zzaqf r3 = com.google.android.gms.ads.internal.zzq.zzll()
            android.content.Context r4 = r10.zzvr
            boolean r3 = r3.zzp(r4)
            if (r3 == 0) goto L_0x0097
            com.google.android.gms.internal.ads.zzbbd r3 = r10.zzboy
            int r3 = r3.zzedd
            com.google.android.gms.internal.ads.zzbbd r4 = r10.zzboy
            int r4 = r4.zzede
            r5 = 23
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r6.append(r3)
            java.lang.String r3 = "."
            r6.append(r3)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            com.google.android.gms.internal.ads.zzaqf r3 = com.google.android.gms.ads.internal.zzq.zzll()
            android.webkit.WebView r5 = r0.getWebView()
            java.lang.String r6 = ""
            java.lang.String r7 = "javascript"
            r9 = r11
            com.google.android.gms.dynamic.IObjectWrapper r11 = r3.zza(r4, r5, r6, r7, r8, r9)
            if (r11 != 0) goto L_0x0077
            return
        L_0x0077:
            com.google.android.gms.internal.ads.zzcck r3 = r10.zzfuu
            r3.zzas(r11)
            r0.zzap(r11)
            if (r2 == 0) goto L_0x008e
            android.view.View r0 = r1.getView()
            if (r0 == 0) goto L_0x008e
            com.google.android.gms.internal.ads.zzaqf r1 = com.google.android.gms.ads.internal.zzq.zzll()
            r1.zza(r11, r0)
        L_0x008e:
            if (r12 == 0) goto L_0x0097
            com.google.android.gms.internal.ads.zzaqf r12 = com.google.android.gms.ads.internal.zzq.zzll()
            r12.zzab(r11)
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccd.zzg(java.lang.String, boolean):void");
    }

    public final boolean zzalc() {
        return this.zzfwa.zzalc();
    }

    public final void zzaa(View view) {
        IObjectWrapper zzaln = this.zzfuu.zzaln();
        boolean z = this.zzfuu.zzalm() != null;
        if (this.zzfwa.zzalc() && zzaln != null && z && view != null) {
            zzq.zzll().zza(zzaln, view);
        }
    }

    public final void zzab(View view) {
        IObjectWrapper zzaln = this.zzfuu.zzaln();
        if (this.zzfwa.zzalc() && zzaln != null && view != null) {
            zzq.zzll().zzb(zzaln, view);
        }
    }

    public final zzccj zzald() {
        return this.zzfwi;
    }

    public final synchronized void zza(zzyc zzyc) {
        this.zzfsh.zzb(zzyc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzbj(boolean z) {
        this.zzfvy.zza(this.zzfwg.zzahk(), this.zzfwg.zzamh(), this.zzfwg.zzami(), z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzale() {
        this.zzfvy.destroy();
        this.zzfuu.destroy();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzalf() {
        try {
            int zzalg = this.zzfuu.zzalg();
            if (zzalg != 1) {
                if (zzalg != 2) {
                    if (zzalg != 3) {
                        if (zzalg != 6) {
                            if (zzalg != 7) {
                                zzaxv.zzfb("Wrong native template id!");
                            } else if (this.zzfnj.zzalz() != null) {
                                this.zzfnj.zzalz().zza(this.zzfwe.get());
                            }
                        } else if (this.zzfnj.zzalx() != null) {
                            zzg("Google", true);
                            this.zzfnj.zzalx().zza(this.zzfwd.get());
                        }
                    } else if (this.zzfnj.zzgc(this.zzfuu.getCustomTemplateId()) != null) {
                        if (this.zzfuu.zzall() != null) {
                            zzg("Google", true);
                        }
                        this.zzfnj.zzgc(this.zzfuu.getCustomTemplateId()).zza(this.zzfwf.get());
                    }
                } else if (this.zzfnj.zzalw() != null) {
                    zzg("Google", true);
                    this.zzfnj.zzalw().zza(this.zzfwc.get());
                }
            } else if (this.zzfnj.zzalv() != null) {
                zzg("Google", true);
                this.zzfnj.zzalv().zza(this.zzfwb.get());
            }
        } catch (RemoteException e) {
            zzaxv.zzc("RemoteException when notifyAdLoad is called", e);
        }
    }
}
