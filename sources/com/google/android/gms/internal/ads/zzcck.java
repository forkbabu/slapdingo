package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.text.html.HtmlTags;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcck {
    private Bundle extras;
    private zzadl zzdch;
    private List<zzza> zzdcv = Collections.emptyList();
    private List<?> zzepv;
    private double zzeqa;
    private float zzeql;
    private IObjectWrapper zzfom;
    private int zzfws;
    private zzyi zzfwt;
    private View zzfwu;
    private zzza zzfwv;
    private zzbfn zzfww;
    private zzbfn zzfwx;
    private View zzfwy;
    private IObjectWrapper zzfwz;
    private zzadt zzfxa;
    private zzadt zzfxb;
    private String zzfxc;
    private SimpleArrayMap<String, zzadf> zzfxd = new SimpleArrayMap<>();
    private SimpleArrayMap<String, String> zzfxe = new SimpleArrayMap<>();
    private String zzfxf;

    public final synchronized void zzdw(int i) {
        this.zzfws = i;
    }

    public final synchronized void zzb(zzyi zzyi) {
        this.zzfwt = zzyi;
    }

    public final synchronized void zza(zzadl zzadl) {
        this.zzdch = zzadl;
    }

    public final synchronized void setImages(List<zzadf> list) {
        this.zzepv = list;
    }

    public final synchronized void zzh(List<zzza> list) {
        this.zzdcv = list;
    }

    public final synchronized void zza(zzza zzza) {
        this.zzfwv = zzza;
    }

    public final synchronized void zzac(View view) {
        this.zzfwy = view;
    }

    public final synchronized void setStarRating(double d) {
        this.zzeqa = d;
    }

    public final synchronized void zza(zzadt zzadt) {
        this.zzfxa = zzadt;
    }

    public final synchronized void zzb(zzadt zzadt) {
        this.zzfxb = zzadt;
    }

    public final synchronized void zzfz(String str) {
        this.zzfxc = str;
    }

    public final synchronized void zzi(zzbfn zzbfn) {
        this.zzfww = zzbfn;
    }

    public final synchronized void zzj(zzbfn zzbfn) {
        this.zzfwx = zzbfn;
    }

    public final synchronized void zzas(IObjectWrapper iObjectWrapper) {
        this.zzfom = iObjectWrapper;
    }

    public final synchronized void zzn(String str, String str2) {
        if (str2 == null) {
            this.zzfxe.remove(str);
        } else {
            this.zzfxe.put(str, str2);
        }
    }

    public final synchronized void zza(String str, zzadf zzadf) {
        if (zzadf == null) {
            this.zzfxd.remove(str);
        } else {
            this.zzfxd.put(str, zzadf);
        }
    }

    private final synchronized void setMediaContentAspectRatio(float f) {
        this.zzeql = f;
    }

    public final synchronized void zzga(String str) {
        this.zzfxf = str;
    }

    private final synchronized String zzgb(String str) {
        return this.zzfxe.get(str);
    }

    public final synchronized int zzalg() {
        return this.zzfws;
    }

    public final synchronized zzyi getVideoController() {
        return this.zzfwt;
    }

    public final synchronized zzadl zzsd() {
        return this.zzdch;
    }

    public final synchronized View zzalh() {
        return this.zzfwu;
    }

    public final synchronized String getHeadline() {
        return zzgb("headline");
    }

    public final synchronized List<?> getImages() {
        return this.zzepv;
    }

    public final zzadt zzali() {
        List<?> list = this.zzepv;
        if (!(list == null || list.size() == 0)) {
            Object obj = this.zzepv.get(0);
            if (obj instanceof IBinder) {
                return zzads.zzo((IBinder) obj);
            }
        }
        return null;
    }

    public final synchronized List<zzza> getMuteThisAdReasons() {
        return this.zzdcv;
    }

    public final synchronized zzza zzalj() {
        return this.zzfwv;
    }

    public final synchronized String getBody() {
        return zzgb(HtmlTags.BODY);
    }

    public final synchronized Bundle getExtras() {
        if (this.extras == null) {
            this.extras = new Bundle();
        }
        return this.extras;
    }

    public final synchronized String getCallToAction() {
        return zzgb("call_to_action");
    }

    public final synchronized View zzalk() {
        return this.zzfwy;
    }

    public final synchronized IObjectWrapper zzse() {
        return this.zzfwz;
    }

    public final synchronized String getStore() {
        return zzgb("store");
    }

    public final synchronized String getPrice() {
        return zzgb(FirebaseAnalytics.Param.PRICE);
    }

    public final synchronized double getStarRating() {
        return this.zzeqa;
    }

    public final synchronized zzadt zzsc() {
        return this.zzfxa;
    }

    public final synchronized String getAdvertiser() {
        return zzgb("advertiser");
    }

    public final synchronized zzadt zzsf() {
        return this.zzfxb;
    }

    public final synchronized String getCustomTemplateId() {
        return this.zzfxc;
    }

    public final synchronized zzbfn zzall() {
        return this.zzfww;
    }

    public final synchronized zzbfn zzalm() {
        return this.zzfwx;
    }

    public final synchronized IObjectWrapper zzaln() {
        return this.zzfom;
    }

    public final synchronized SimpleArrayMap<String, zzadf> zzalo() {
        return this.zzfxd;
    }

    public final synchronized float getMediaContentAspectRatio() {
        return this.zzeql;
    }

    public final synchronized String zzalp() {
        return this.zzfxf;
    }

    public final synchronized SimpleArrayMap<String, String> zzalq() {
        return this.zzfxe;
    }

    public final synchronized void destroy() {
        if (this.zzfww != null) {
            this.zzfww.destroy();
            this.zzfww = null;
        }
        if (this.zzfwx != null) {
            this.zzfwx.destroy();
            this.zzfwx = null;
        }
        this.zzfom = null;
        this.zzfxd.clear();
        this.zzfxe.clear();
        this.zzfwt = null;
        this.zzdch = null;
        this.zzfwu = null;
        this.zzepv = null;
        this.extras = null;
        this.zzfwy = null;
        this.zzfwz = null;
        this.zzfxa = null;
        this.zzfxb = null;
        this.zzfxc = null;
    }

    public static zzcck zza(zzanf zzanf) {
        try {
            zzccl zza = zza(zzanf.getVideoController(), (zzang) null);
            zzadl zzsd = zzanf.zzsd();
            String headline = zzanf.getHeadline();
            List<?> images = zzanf.getImages();
            String body = zzanf.getBody();
            Bundle extras2 = zzanf.getExtras();
            String callToAction = zzanf.getCallToAction();
            IObjectWrapper zzse = zzanf.zzse();
            String advertiser = zzanf.getAdvertiser();
            zzadt zzsf = zzanf.zzsf();
            zzcck zzcck = new zzcck();
            zzcck.zzfws = 1;
            zzcck.zzfwt = zza;
            zzcck.zzdch = zzsd;
            zzcck.zzfwu = (View) zzat(zzanf.zztv());
            zzcck.zzn("headline", headline);
            zzcck.zzepv = images;
            zzcck.zzn(HtmlTags.BODY, body);
            zzcck.extras = extras2;
            zzcck.zzn("call_to_action", callToAction);
            zzcck.zzfwy = (View) zzat(zzanf.zztw());
            zzcck.zzfwz = zzse;
            zzcck.zzn("advertiser", advertiser);
            zzcck.zzfxb = zzsf;
            return zzcck;
        } catch (RemoteException e) {
            zzaxv.zzd("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzcck zza(zzana zzana) {
        try {
            zzccl zza = zza(zzana.getVideoController(), (zzang) null);
            zzadl zzsd = zzana.zzsd();
            String headline = zzana.getHeadline();
            List<?> images = zzana.getImages();
            String body = zzana.getBody();
            Bundle extras2 = zzana.getExtras();
            String callToAction = zzana.getCallToAction();
            IObjectWrapper zzse = zzana.zzse();
            String store = zzana.getStore();
            String price = zzana.getPrice();
            double starRating = zzana.getStarRating();
            zzadt zzsc = zzana.zzsc();
            zzcck zzcck = new zzcck();
            zzcck.zzfws = 2;
            zzcck.zzfwt = zza;
            zzcck.zzdch = zzsd;
            zzcck.zzfwu = (View) zzat(zzana.zztv());
            zzcck.zzn("headline", headline);
            zzcck.zzepv = images;
            zzcck.zzn(HtmlTags.BODY, body);
            zzcck.extras = extras2;
            zzcck.zzn("call_to_action", callToAction);
            zzcck.zzfwy = (View) zzat(zzana.zztw());
            zzcck.zzfwz = zzse;
            zzcck.zzn("store", store);
            zzcck.zzn(FirebaseAnalytics.Param.PRICE, price);
            zzcck.zzeqa = starRating;
            zzcck.zzfxa = zzsc;
            return zzcck;
        } catch (RemoteException e) {
            zzaxv.zzd("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzcck zzb(zzang zzang) {
        try {
            return zza(zza(zzang.getVideoController(), zzang), zzang.zzsd(), (View) zzat(zzang.zztv()), zzang.getHeadline(), zzang.getImages(), zzang.getBody(), zzang.getExtras(), zzang.getCallToAction(), (View) zzat(zzang.zztw()), zzang.zzse(), zzang.getStore(), zzang.getPrice(), zzang.getStarRating(), zzang.zzsc(), zzang.getAdvertiser(), zzang.getMediaContentAspectRatio());
        } catch (RemoteException e) {
            zzaxv.zzd("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public static zzcck zzb(zzana zzana) {
        try {
            return zza(zza(zzana.getVideoController(), (zzang) null), zzana.zzsd(), (View) zzat(zzana.zztv()), zzana.getHeadline(), zzana.getImages(), zzana.getBody(), zzana.getExtras(), zzana.getCallToAction(), (View) zzat(zzana.zztw()), zzana.zzse(), zzana.getStore(), zzana.getPrice(), zzana.getStarRating(), zzana.zzsc(), null, 0.0f);
        } catch (RemoteException e) {
            zzaxv.zzd("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzcck zzb(zzanf zzanf) {
        try {
            return zza(zza(zzanf.getVideoController(), (zzang) null), zzanf.zzsd(), (View) zzat(zzanf.zztv()), zzanf.getHeadline(), zzanf.getImages(), zzanf.getBody(), zzanf.getExtras(), zzanf.getCallToAction(), (View) zzat(zzanf.zztw()), zzanf.zzse(), null, null, -1.0d, zzanf.zzsf(), zzanf.getAdvertiser(), 0.0f);
        } catch (RemoteException e) {
            zzaxv.zzd("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzcck zza(zzyi zzyi, zzadl zzadl, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzadt zzadt, String str6, float f) {
        zzcck zzcck = new zzcck();
        zzcck.zzfws = 6;
        zzcck.zzfwt = zzyi;
        zzcck.zzdch = zzadl;
        zzcck.zzfwu = view;
        zzcck.zzn("headline", str);
        zzcck.zzepv = list;
        zzcck.zzn(HtmlTags.BODY, str2);
        zzcck.extras = bundle;
        zzcck.zzn("call_to_action", str3);
        zzcck.zzfwy = view2;
        zzcck.zzfwz = iObjectWrapper;
        zzcck.zzn("store", str4);
        zzcck.zzn(FirebaseAnalytics.Param.PRICE, str5);
        zzcck.zzeqa = d;
        zzcck.zzfxa = zzadt;
        zzcck.zzn("advertiser", str6);
        zzcck.setMediaContentAspectRatio(f);
        return zzcck;
    }

    private static <T> T zzat(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    private static zzccl zza(zzyi zzyi, zzang zzang) {
        if (zzyi == null) {
            return null;
        }
        return new zzccl(zzyi, zzang);
    }
}
