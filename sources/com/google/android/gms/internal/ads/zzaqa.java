package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaqa extends zzaqd implements zzahc<zzbfn> {
    private float density;
    private int maxHeight = -1;
    private int maxWidth = -1;
    private int rotation;
    private final WindowManager zzbqy;
    private final zzbfn zzdfp;
    private final zzaac zzdms;
    private int zzdmt = -1;
    private int zzdmu = -1;
    private int zzdmv = -1;
    private int zzdmw = -1;
    private final Context zzvr;
    private DisplayMetrics zzxc;

    public zzaqa(zzbfn zzbfn, Context context, zzaac zzaac) {
        super(zzbfn);
        this.zzdfp = zzbfn;
        this.zzvr = context;
        this.zzdms = zzaac;
        this.zzbqy = (WindowManager) context.getSystemService("window");
    }

    public final void zzj(int i, int i2) {
        int i3 = 0;
        if (this.zzvr instanceof Activity) {
            i3 = zzq.zzkw().zzf((Activity) this.zzvr)[0];
        }
        if (this.zzdfp.zzaax() == null || !this.zzdfp.zzaax().zzacs()) {
            int width = this.zzdfp.getWidth();
            int height = this.zzdfp.getHeight();
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcmq)).booleanValue()) {
                if (width == 0 && this.zzdfp.zzaax() != null) {
                    width = this.zzdfp.zzaax().widthPixels;
                }
                if (height == 0 && this.zzdfp.zzaax() != null) {
                    height = this.zzdfp.zzaax().heightPixels;
                }
            }
            this.zzdmv = zzwg.zzps().zzb(this.zzvr, width);
            this.zzdmw = zzwg.zzps().zzb(this.zzvr, height);
        }
        zzc(i, i2 - i3, this.zzdmv, this.zzdmw);
        this.zzdfp.zzaaz().zzi(i, i2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahc
    public final /* synthetic */ void zza(zzbfn zzbfn, Map map) {
        this.zzxc = new DisplayMetrics();
        Display defaultDisplay = this.zzbqy.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzxc);
        this.density = this.zzxc.density;
        this.rotation = defaultDisplay.getRotation();
        zzwg.zzps();
        DisplayMetrics displayMetrics = this.zzxc;
        this.zzdmt = zzbaq.zzb(displayMetrics, displayMetrics.widthPixels);
        zzwg.zzps();
        DisplayMetrics displayMetrics2 = this.zzxc;
        this.zzdmu = zzbaq.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzzl = this.zzdfp.zzzl();
        if (zzzl == null || zzzl.getWindow() == null) {
            this.maxWidth = this.zzdmt;
            this.maxHeight = this.zzdmu;
        } else {
            zzq.zzkw();
            int[] zzd = zzaye.zzd(zzzl);
            zzwg.zzps();
            this.maxWidth = zzbaq.zzb(this.zzxc, zzd[0]);
            zzwg.zzps();
            this.maxHeight = zzbaq.zzb(this.zzxc, zzd[1]);
        }
        if (this.zzdfp.zzaax().zzacs()) {
            this.zzdmv = this.zzdmt;
            this.zzdmw = this.zzdmu;
        } else {
            this.zzdfp.measure(0, 0);
        }
        zza(this.zzdmt, this.zzdmu, this.maxWidth, this.maxHeight, this.density, this.rotation);
        this.zzdfp.zzb("onDeviceFeaturesReceived", new zzapz(new zzaqb().zzae(this.zzdms.zzqx()).zzad(this.zzdms.zzqy()).zzaf(this.zzdms.zzra()).zzag(this.zzdms.zzqz()).zzah(true)).zzug());
        int[] iArr = new int[2];
        this.zzdfp.getLocationOnScreen(iArr);
        zzj(zzwg.zzps().zzb(this.zzvr, iArr[0]), zzwg.zzps().zzb(this.zzvr, iArr[1]));
        if (zzaxv.isLoggable(2)) {
            zzaxv.zzfc("Dispatching Ready Event.");
        }
        zzdx(this.zzdfp.zzzo().zzbpn);
    }
}
