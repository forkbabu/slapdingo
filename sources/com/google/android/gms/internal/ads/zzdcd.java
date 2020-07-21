package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdcd implements zzdec<zzdce> {
    private final PackageInfo zzdpk;
    private final zzaxx zzdyn;
    private final zzdla zzfpv;
    private final zzdvi zzgad;

    public zzdcd(zzdvi zzdvi, zzdla zzdla, PackageInfo packageInfo, zzaxx zzaxx) {
        this.zzgad = zzdvi;
        this.zzfpv = zzdla;
        this.zzdpk = packageInfo;
        this.zzdyn = zzaxx;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdce> zzaqm() {
        return this.zzgad.zze(new zzdcg(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f9, code lost:
        if (r9 == 3) goto L_0x0120;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(java.util.ArrayList r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.String r0 = "native_version"
            r1 = 3
            r10.putInt(r0, r1)
            java.lang.String r0 = "native_templates"
            r10.putStringArrayList(r0, r9)
            com.google.android.gms.internal.ads.zzdla r9 = r8.zzfpv
            java.util.ArrayList<java.lang.String> r9 = r9.zzhbb
            java.lang.String r0 = "native_custom_templates"
            r10.putStringArrayList(r0, r9)
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r9 = com.google.android.gms.internal.ads.zzaav.zzcrj
            com.google.android.gms.internal.ads.zzaar r0 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r9 = r0.zzd(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            java.lang.String r0 = "landscape"
            java.lang.String r2 = "portrait"
            java.lang.String r3 = "any"
            java.lang.String r4 = "unknown"
            r5 = 2
            r6 = 1
            if (r9 == 0) goto L_0x0061
            com.google.android.gms.internal.ads.zzdla r9 = r8.zzfpv
            com.google.android.gms.internal.ads.zzadj r9 = r9.zzdkn
            int r9 = r9.versionCode
            if (r9 <= r1) goto L_0x0061
            java.lang.String r9 = "enable_native_media_orientation"
            r10.putBoolean(r9, r6)
            com.google.android.gms.internal.ads.zzdla r9 = r8.zzfpv
            com.google.android.gms.internal.ads.zzadj r9 = r9.zzdkn
            int r9 = r9.zzbnh
            if (r9 == r6) goto L_0x0055
            if (r9 == r5) goto L_0x0053
            if (r9 == r1) goto L_0x0051
            r7 = 4
            if (r9 == r7) goto L_0x004e
            r9 = r4
            goto L_0x0056
        L_0x004e:
            java.lang.String r9 = "square"
            goto L_0x0056
        L_0x0051:
            r9 = r2
            goto L_0x0056
        L_0x0053:
            r9 = r0
            goto L_0x0056
        L_0x0055:
            r9 = r3
        L_0x0056:
            boolean r7 = r4.equals(r9)
            if (r7 != 0) goto L_0x0061
            java.lang.String r7 = "native_media_orientation"
            r10.putString(r7, r9)
        L_0x0061:
            com.google.android.gms.internal.ads.zzdla r9 = r8.zzfpv
            com.google.android.gms.internal.ads.zzadj r9 = r9.zzdkn
            int r9 = r9.zzbng
            if (r9 == 0) goto L_0x0071
            if (r9 == r6) goto L_0x006f
            if (r9 == r5) goto L_0x0072
            r0 = r4
            goto L_0x0072
        L_0x006f:
            r0 = r2
            goto L_0x0072
        L_0x0071:
            r0 = r3
        L_0x0072:
            boolean r9 = r4.equals(r0)
            if (r9 != 0) goto L_0x007d
            java.lang.String r9 = "native_image_orientation"
            r10.putString(r9, r0)
        L_0x007d:
            com.google.android.gms.internal.ads.zzdla r9 = r8.zzfpv
            com.google.android.gms.internal.ads.zzadj r9 = r9.zzdkn
            boolean r9 = r9.zzbni
            java.lang.String r0 = "native_multiple_images"
            r10.putBoolean(r0, r9)
            com.google.android.gms.internal.ads.zzdla r9 = r8.zzfpv
            com.google.android.gms.internal.ads.zzadj r9 = r9.zzdkn
            boolean r9 = r9.zzbnl
            java.lang.String r0 = "use_custom_mute"
            r10.putBoolean(r0, r9)
            android.content.pm.PackageInfo r9 = r8.zzdpk
            if (r9 != 0) goto L_0x0099
            r9 = 0
            goto L_0x009b
        L_0x0099:
            int r9 = r9.versionCode
        L_0x009b:
            com.google.android.gms.internal.ads.zzaxx r0 = r8.zzdyn
            int r0 = r0.zzwy()
            if (r9 <= r0) goto L_0x00ad
            com.google.android.gms.internal.ads.zzaxx r0 = r8.zzdyn
            r0.zzxe()
            com.google.android.gms.internal.ads.zzaxx r0 = r8.zzdyn
            r0.zzdd(r9)
        L_0x00ad:
            com.google.android.gms.internal.ads.zzaxx r9 = r8.zzdyn
            org.json.JSONObject r9 = r9.zzxd()
            if (r9 == 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzdla r0 = r8.zzfpv
            java.lang.String r0 = r0.zzhaz
            org.json.JSONArray r9 = r9.optJSONArray(r0)
            if (r9 == 0) goto L_0x00c4
            java.lang.String r9 = r9.toString()
            goto L_0x00c5
        L_0x00c4:
            r9 = 0
        L_0x00c5:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x00d0
            java.lang.String r0 = "native_advanced_settings"
            r10.putString(r0, r9)
        L_0x00d0:
            com.google.android.gms.internal.ads.zzdla r9 = r8.zzfpv
            int r9 = r9.zzgqe
            if (r9 <= r6) goto L_0x00df
            com.google.android.gms.internal.ads.zzdla r9 = r8.zzfpv
            int r9 = r9.zzgqe
            java.lang.String r0 = "max_num_ads"
            r10.putInt(r0, r9)
        L_0x00df:
            com.google.android.gms.internal.ads.zzdla r9 = r8.zzfpv
            com.google.android.gms.internal.ads.zzaio r9 = r9.zzdra
            if (r9 == 0) goto L_0x0132
            java.lang.String r0 = r9.zzdey
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0126
            int r0 = r9.versionCode
            java.lang.String r2 = "p"
            java.lang.String r3 = "l"
            if (r0 < r5) goto L_0x00fc
            int r9 = r9.zzbnh
            if (r9 == r5) goto L_0x011f
            if (r9 == r1) goto L_0x0120
            goto L_0x011f
        L_0x00fc:
            int r0 = r9.zzdex
            if (r0 == r6) goto L_0x011f
            if (r0 == r5) goto L_0x0120
            int r9 = r9.zzdex
            r0 = 52
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Instream ad video aspect ratio "
            r1.append(r0)
            r1.append(r9)
            java.lang.String r9 = " is wrong."
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.google.android.gms.internal.ads.zzbba.zzfb(r9)
        L_0x011f:
            r2 = r3
        L_0x0120:
            java.lang.String r9 = "ia_var"
            r10.putString(r9, r2)
            goto L_0x012d
        L_0x0126:
            java.lang.String r9 = r9.zzdey
            java.lang.String r0 = "ad_tag"
            r10.putString(r0, r9)
        L_0x012d:
            java.lang.String r9 = "instr"
            r10.putBoolean(r9, r6)
        L_0x0132:
            com.google.android.gms.internal.ads.zzdla r9 = r8.zzfpv
            com.google.android.gms.internal.ads.zzafn r9 = r9.zzasj()
            if (r9 == 0) goto L_0x013f
            java.lang.String r9 = "has_delayed_banner_listener"
            r10.putBoolean(r9, r6)
        L_0x013f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdcd.zza(java.util.ArrayList, android.os.Bundle):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdce zzaqu() throws Exception {
        ArrayList<String> arrayList = this.zzfpv.zzhba;
        if (arrayList == null) {
            return zzdcf.zzgtf;
        }
        if (arrayList.isEmpty()) {
            return zzdci.zzgtf;
        }
        return new zzdch(this, arrayList);
    }
}
