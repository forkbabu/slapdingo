package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdpd {
    private final Executor executor;
    private final String zzbpn;
    private final Clock zzbqd;
    private final String zzcio;
    private final String zzdpm;
    private final zzeg zzfkq;
    private final zzdkv zzfri;
    private final zzcts zzftc;
    private final zzbbe zzhgy;
    private final Context zzvr;

    public zzdpd(Executor executor2, zzbbe zzbbe, zzcts zzcts, zzbbd zzbbd, String str, String str2, Context context, zzdkv zzdkv, Clock clock, zzeg zzeg) {
        this.executor = executor2;
        this.zzhgy = zzbbe;
        this.zzftc = zzcts;
        this.zzbpn = zzbbd.zzbpn;
        this.zzdpm = str;
        this.zzcio = str2;
        this.zzvr = context;
        this.zzfri = zzdkv;
        this.zzbqd = clock;
        this.zzfkq = zzeg;
    }

    public final void zza(zzdkw zzdkw, zzdkk zzdkk, List<String> list) {
        zza(zzdkw, zzdkk, false, "", "", list);
    }

    public final void zza(zzdkw zzdkw, zzdkk zzdkk, boolean z, String str, String str2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str3 = z ? "1" : "0";
        for (String str4 : list) {
            String zzc = zzc(zzc(zzc(str4, "@gw_adlocid@", zzdkw.zzhat.zzfpv.zzhaz), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.zzbpn);
            if (zzdkk != null) {
                zzc = zzawn.zzc(zzc(zzc(zzc(zzc, "@gw_qdata@", zzdkk.zzdil), "@gw_adnetid@", zzdkk.zzagr), "@gw_allocid@", zzdkk.zzdjb), this.zzvr, zzdkk.zzdsh);
            }
            String zzc2 = zzc(zzc(zzc(zzc, "@gw_adnetstatus@", this.zzftc.zzapp()), "@gw_seqnum@", this.zzdpm), "@gw_sessid@", this.zzcio);
            boolean z2 = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcqz)).booleanValue() && !TextUtils.isEmpty(str);
            boolean isEmpty = true ^ TextUtils.isEmpty(str2);
            if (z2 || isEmpty) {
                if (this.zzfkq.zzb(Uri.parse(zzc2))) {
                    Uri.Builder buildUpon = Uri.parse(zzc2).buildUpon();
                    if (z2) {
                        buildUpon = buildUpon.appendQueryParameter("ms", str);
                    }
                    if (isEmpty) {
                        buildUpon = buildUpon.appendQueryParameter("attok", str2);
                    }
                    zzc2 = buildUpon.build().toString();
                }
            }
            arrayList.add(zzc2);
        }
        zzi(arrayList);
    }

    public final void zza(zzdkw zzdkw, zzdkk zzdkk, List<String> list, zzatg zzatg) {
        long currentTimeMillis = this.zzbqd.currentTimeMillis();
        try {
            String type = zzatg.getType();
            String num = Integer.toString(zzatg.getAmount());
            ArrayList arrayList = new ArrayList();
            zzdkv zzdkv = this.zzfri;
            String str = "";
            String zzgx = zzdkv == null ? str : zzgx(zzdkv.zzdur);
            zzdkv zzdkv2 = this.zzfri;
            if (zzdkv2 != null) {
                str = zzgx(zzdkv2.zzdus);
            }
            for (String str2 : list) {
                arrayList.add(zzawn.zzc(zzc(zzc(zzc(zzc(zzc(zzc(str2, "@gw_rwd_userid@", Uri.encode(zzgx)), "@gw_rwd_custom_data@", Uri.encode(str)), "@gw_tmstmp@", Long.toString(currentTimeMillis)), "@gw_rwd_itm@", Uri.encode(type)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.zzbpn), this.zzvr, zzdkk.zzdsh));
            }
            zzi(arrayList);
        } catch (RemoteException unused) {
        }
    }

    public final void zzi(List<String> list) {
        for (String str : list) {
            zzer(str);
        }
    }

    public final void zzer(String str) {
        this.executor.execute(new zzdpg(this, str));
    }

    private static String zzc(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    private static String zzgx(String str) {
        return (TextUtils.isEmpty(str) || !zzbau.isEnabled()) ? str : "fakeForAdDebugLog";
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzgy(String str) {
        this.zzhgy.zzer(str);
    }
}
