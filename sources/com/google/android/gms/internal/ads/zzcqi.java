package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzty;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcqi {
    private static final SparseArray<zzty.zzo.zzc> zzgjt;
    private final zzbrq zzfqc;
    private final zzcqf zzggx;
    private final TelephonyManager zzgjq;
    /* access modifiers changed from: private */
    public final zzcpz zzgjr;
    private zzui zzgjs;
    private final Context zzvr;

    zzcqi(Context context, zzbrq zzbrq, zzcqf zzcqf, zzcpz zzcpz) {
        this.zzvr = context;
        this.zzfqc = zzbrq;
        this.zzggx = zzcqf;
        this.zzgjr = zzcpz;
        this.zzgjq = (TelephonyManager) context.getSystemService("phone");
    }

    private static zzui zzbk(boolean z) {
        return z ? zzui.ENUM_TRUE : zzui.ENUM_FALSE;
    }

    /* access modifiers changed from: private */
    public final zzty.zzm zzk(Bundle bundle) {
        zzty.zzm.zza zza;
        zzty.zzm.zzb zzof = zzty.zzm.zzof();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.zzgjs = zzui.ENUM_TRUE;
        } else {
            this.zzgjs = zzui.ENUM_FALSE;
            if (i == 0) {
                zzof.zzb(zzty.zzm.zzc.CELL);
            } else if (i != 1) {
                zzof.zzb(zzty.zzm.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzof.zzb(zzty.zzm.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zza = zzty.zzm.zza.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zza = zzty.zzm.zza.THREE_G;
                    break;
                case 13:
                    zza = zzty.zzm.zza.LTE;
                    break;
                default:
                    zza = zzty.zzm.zza.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzof.zzb(zza);
        }
        return (zzty.zzm) ((zzegb) zzof.zzbfq());
    }

    /* access modifiers changed from: private */
    public static zzty.zzo.zzc zzl(Bundle bundle) {
        return zzgjt.get(zzdlf.zza(zzdlf.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzty.zzo.zzc.UNSPECIFIED);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zzty.zzc.zza> zzm(android.os.Bundle r7) {
        /*
            java.lang.String r0 = "ad_types"
            java.lang.Object r7 = r7.get(r0)
            boolean r0 = r7 instanceof java.util.List
            if (r0 == 0) goto L_0x000d
            java.util.List r7 = (java.util.List) r7
            goto L_0x0017
        L_0x000d:
            boolean r0 = r7 instanceof java.lang.String[]
            if (r0 == 0) goto L_0x003d
            java.lang.String[] r7 = (java.lang.String[]) r7
            java.util.List r7 = java.util.Arrays.asList(r7)
        L_0x0017:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.size()
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L_0x0024:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0038
            java.lang.Object r1 = r7.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0024
            java.lang.String r1 = (java.lang.String) r1
            r0.add(r1)
            goto L_0x0024
        L_0x0038:
            java.util.List r7 = java.util.Collections.unmodifiableList(r0)
            goto L_0x0041
        L_0x003d:
            java.util.List r7 = java.util.Collections.emptyList()
        L_0x0041:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x004a:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x00a3
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            int r3 = r1.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case -1396342996: goto L_0x0080;
                case -1052618729: goto L_0x0076;
                case -239580146: goto L_0x006c;
                case 604727084: goto L_0x0062;
                default: goto L_0x0061;
            }
        L_0x0061:
            goto L_0x0089
        L_0x0062:
            java.lang.String r3 = "interstitial"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 1
            goto L_0x0089
        L_0x006c:
            java.lang.String r3 = "rewarded"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 3
            goto L_0x0089
        L_0x0076:
            java.lang.String r3 = "native"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 2
            goto L_0x0089
        L_0x0080:
            java.lang.String r3 = "banner"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 0
        L_0x0089:
            if (r2 == 0) goto L_0x009d
            if (r2 == r6) goto L_0x009a
            if (r2 == r5) goto L_0x0097
            if (r2 == r4) goto L_0x0094
            com.google.android.gms.internal.ads.zzty$zzc$zza r1 = com.google.android.gms.internal.ads.zzty.zzc.zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto L_0x009f
        L_0x0094:
            com.google.android.gms.internal.ads.zzty$zzc$zza r1 = com.google.android.gms.internal.ads.zzty.zzc.zza.REWARD_BASED_VIDEO_AD
            goto L_0x009f
        L_0x0097:
            com.google.android.gms.internal.ads.zzty$zzc$zza r1 = com.google.android.gms.internal.ads.zzty.zzc.zza.NATIVE_APP_INSTALL
            goto L_0x009f
        L_0x009a:
            com.google.android.gms.internal.ads.zzty$zzc$zza r1 = com.google.android.gms.internal.ads.zzty.zzc.zza.INTERSTITIAL
            goto L_0x009f
        L_0x009d:
            com.google.android.gms.internal.ads.zzty$zzc$zza r1 = com.google.android.gms.internal.ads.zzty.zzc.zza.BANNER
        L_0x009f:
            r0.add(r1)
            goto L_0x004a
        L_0x00a3:
            return r0
            switch-data {-1396342996->0x0080, -1052618729->0x0076, -239580146->0x006c, 604727084->0x0062, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqi.zzm(android.os.Bundle):java.util.ArrayList");
    }

    /* access modifiers changed from: private */
    public final byte[] zza(boolean z, ArrayList<zzty.zzc.zza> arrayList, zzty.zzm zzm, zzty.zzo.zzc zzc) {
        boolean z2 = true;
        zzty.zzo.zza.C0021zza zzeu = zzty.zzo.zza.zzol().zzf(arrayList).zzh(zzbk(zzq.zzky().zzb(this.zzvr.getContentResolver()) != 0)).zzi(zzq.zzky().zza(this.zzvr, this.zzgjq)).zzev(this.zzggx.zzapj()).zzew(this.zzggx.zzapl()).zzcn(this.zzggx.getResponseCode()).zzb(zzc).zzb(zzm).zzj(this.zzgjs).zzf(zzbk(z)).zzeu(zzq.zzld().currentTimeMillis());
        if (zzq.zzky().zza(this.zzvr.getContentResolver()) == 0) {
            z2 = false;
        }
        return ((zzty.zzo.zza) ((zzegb) zzeu.zzg(zzbk(z2)).zzbfq())).toByteArray();
    }

    public final void zzbl(boolean z) {
        zzdux.zza(this.zzfqc.zzais(), new zzcql(this, z), zzbbf.zzedm);
    }

    static {
        SparseArray<zzty.zzo.zzc> sparseArray = new SparseArray<>();
        zzgjt = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzty.zzo.zzc.CONNECTED);
        zzgjt.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzty.zzo.zzc.CONNECTING);
        zzgjt.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzty.zzo.zzc.CONNECTING);
        zzgjt.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzty.zzo.zzc.CONNECTING);
        zzgjt.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzty.zzo.zzc.DISCONNECTING);
        zzgjt.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzty.zzo.zzc.DISCONNECTED);
        zzgjt.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzty.zzo.zzc.DISCONNECTED);
        zzgjt.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzty.zzo.zzc.DISCONNECTED);
        zzgjt.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzty.zzo.zzc.DISCONNECTED);
        zzgjt.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzty.zzo.zzc.DISCONNECTED);
        zzgjt.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzty.zzo.zzc.SUSPENDED);
        if (Build.VERSION.SDK_INT >= 17) {
            zzgjt.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzty.zzo.zzc.CONNECTING);
        }
        zzgjt.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzty.zzo.zzc.CONNECTING);
    }
}
