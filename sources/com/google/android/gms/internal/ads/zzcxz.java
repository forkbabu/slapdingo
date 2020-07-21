package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzbxa;
import com.google.android.gms.internal.ads.zzcym;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcxz extends zzawu {
    private static final List<String> zzgqp = new ArrayList(Arrays.asList("/aclk", "/pcs/click"));
    private static final List<String> zzgqq = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    private static final List<String> zzgqr = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion"));
    private static final List<String> zzgqs = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    /* access modifiers changed from: private */
    public zzbbd zzbov;
    private final ScheduledExecutorService zzfkm;
    private zzeg zzfkq;
    private Point zzfve = new Point();
    private Point zzfvf = new Point();
    private final zzdvi zzgad;
    private zzdll<zzcgr> zzglw;
    private zzbif zzgqt;
    private zzark zzgqu;
    private Context zzvr;

    public zzcxz(zzbif zzbif, Context context, zzeg zzeg, zzbbd zzbbd, zzdll<zzcgr> zzdll, zzdvi zzdvi, ScheduledExecutorService scheduledExecutorService) {
        this.zzgqt = zzbif;
        this.zzvr = context;
        this.zzfkq = zzeg;
        this.zzbov = zzbbd;
        this.zzglw = zzdll;
        this.zzgad = zzdvi;
        this.zzfkm = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final IObjectWrapper zzao(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zza(IObjectWrapper iObjectWrapper, zzawx zzawx, zzawq zzawq) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzvr = context;
        String str = zzawx.zzbum;
        String str2 = zzawx.zzbpk;
        zzvh zzvh = zzawx.zzdww;
        zzve zzve = zzawx.zzdwx;
        zzcxw zzads = this.zzgqt.zzads();
        zzbrx.zza zzce = new zzbrx.zza().zzce(context);
        zzdlc zzdlc = new zzdlc();
        if (str == null) {
            str = "adUnitId";
        }
        zzdlc zzgs = zzdlc.zzgs(str);
        if (zzve == null) {
            zzve = new zzvd().zzpg();
        }
        zzdlc zzh = zzgs.zzh(zzve);
        if (zzvh == null) {
            zzvh = new zzvh();
        }
        zzdux.zza(zzads.zzf(zzce.zza(zzh.zzd(zzvh).zzaso()).zzaiz()).zza(new zzcym(new zzcym.zza().zzgr(str2))).zzf(new zzbxa.zza().zzajw()).zzagh().zzagg(), new zzcyi(this, zzawq), this.zzgqt.zzade());
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zzan(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcwu)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzark zzark = this.zzgqu;
            this.zzfve = zzbae.zza(motionEvent, zzark == null ? null : zzark.zzaas);
            if (motionEvent.getAction() == 0) {
                this.zzfvf = this.zzfve;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation((float) this.zzfve.x, (float) this.zzfve.y);
            this.zzfkq.zza(obtain);
            obtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zza(zzark zzark) {
        this.zzgqu = zzark;
        this.zzglw.zzeb(1);
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zza(List<Uri> list, IObjectWrapper iObjectWrapper, zzaqz zzaqz) {
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcwu)).booleanValue()) {
            try {
                zzaqz.onError("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzbba.zzc("", e);
            }
        } else {
            zzdvf zze = this.zzgad.zze(new zzcxy(this, list, iObjectWrapper));
            if (zzaqi()) {
                zze = zzdux.zzb(zze, new zzcyb(this), this.zzgad);
            } else {
                zzaxv.zzfc("Asset view map is empty.");
            }
            zzdux.zza(zze, new zzcyl(this, zzaqz), this.zzgqt.zzade());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zzb(List<Uri> list, IObjectWrapper iObjectWrapper, zzaqz zzaqz) {
        try {
            if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcwu)).booleanValue()) {
                zzaqz.onError("The updating URL feature is not enabled.");
            } else if (list.size() != 1) {
                zzaqz.onError("There should be only 1 click URL.");
            } else {
                Uri uri = list.get(0);
                if (!zza(uri, zzgqp, zzgqq)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzaxv.zzfd(sb.toString());
                    zzaqz.onSuccess(list);
                    return;
                }
                zzdvf zze = this.zzgad.zze(new zzcya(this, uri, iObjectWrapper));
                if (zzaqi()) {
                    zze = zzdux.zzb(zze, new zzcyd(this), this.zzgad);
                } else {
                    zzaxv.zzfc("Asset view map is empty.");
                }
                zzdux.zza(zze, new zzcyk(this, zzaqz), this.zzgqt.zzade());
            }
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    private static boolean zzk(Uri uri) {
        return zza(uri, zzgqr, zzgqs);
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final Uri zzb(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        try {
            uri = this.zzfkq.zza(uri, this.zzvr, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
        } catch (zzef e) {
            zzbba.zzd("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    private static boolean zza(Uri uri, List<String> list, List<String> list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (!(host == null || path == null)) {
            for (String str : list) {
                if (path.contains(str)) {
                    for (String str2 : list2) {
                        if (host.endsWith(str2)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    private final zzdvf<String> zzgq(String str) {
        zzcgr[] zzcgrArr = new zzcgr[1];
        zzdvf zzb = zzdux.zzb(this.zzglw.zzass(), new zzcyg(this, zzcgrArr, str), this.zzgad);
        zzb.addListener(new zzcyj(this, zzcgrArr), this.zzgad);
        return zzduo.zzg(zzb).zza((long) ((Integer) zzwg.zzpw().zzd(zzaav.zzcwv)).intValue(), TimeUnit.MILLISECONDS, this.zzfkm).zza(zzcye.zzdvt, this.zzgad).zza(Exception.class, zzcyh.zzdvt, this.zzgad);
    }

    private static Uri zza(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = indexOf + 1;
        return Uri.parse(uri2.substring(0, i) + str + "=" + str2 + "&" + uri2.substring(i));
    }

    private final boolean zzaqi() {
        zzark zzark = this.zzgqu;
        return (zzark == null || zzark.zzdow == null || this.zzgqu.zzdow.isEmpty()) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzcgr[] zzcgrArr) {
        if (zzcgrArr[0] != null) {
            this.zzglw.zzd(zzdux.zzaf(zzcgrArr[0]));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zza(zzcgr[] zzcgrArr, String str, zzcgr zzcgr) throws Exception {
        zzcgrArr[0] = zzcgr;
        JSONObject zza = zzbae.zza(this.zzvr, this.zzgqu.zzdow, this.zzgqu.zzdow, this.zzgqu.zzaas);
        JSONObject zza2 = zzbae.zza(this.zzvr, this.zzgqu.zzaas);
        JSONObject zzt = zzbae.zzt(this.zzgqu.zzaas);
        JSONObject zzb = zzbae.zzb(this.zzvr, this.zzgqu.zzaas);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zza);
        jSONObject.put("ad_view_signal", zza2);
        jSONObject.put("scroll_view_signal", zzt);
        jSONObject.put("lock_screen_signal", zzb);
        if (str == "google.afma.nativeAds.getPublisherCustomRenderedClickSignals") {
            jSONObject.put("click_signal", zzbae.zza((String) null, this.zzvr, this.zzfvf, this.zzfve));
        }
        return zzcgr.zzc(str, jSONObject);
    }

    static /* synthetic */ Uri zzc(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zza(uri, "nas", str) : uri;
    }

    static /* synthetic */ ArrayList zza(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Uri uri = (Uri) it2.next();
            if (!zzk(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zza(uri, "nas", str));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzl(Uri uri) throws Exception {
        return zzdux.zzb(zzgq("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzcyf(this, uri), this.zzgad);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzb(ArrayList arrayList) throws Exception {
        return zzdux.zzb(zzgq("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzcyc(this, arrayList), this.zzgad);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zza(List list, IObjectWrapper iObjectWrapper) throws Exception {
        String zza = this.zzfkq.zzcb() != null ? this.zzfkq.zzcb().zza(this.zzvr, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null) : "";
        if (!TextUtils.isEmpty(zza)) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Uri uri = (Uri) it2.next();
                if (!zzk(uri)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzaxv.zzfd(sb.toString());
                    arrayList.add(uri);
                } else {
                    arrayList.add(zza(uri, "ms", zza));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }
}
