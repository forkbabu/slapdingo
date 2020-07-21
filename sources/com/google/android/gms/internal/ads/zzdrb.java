package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.util.Hex;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdrb {
    private final SharedPreferences zzclb;
    private final File zzhji;
    private final File zzhjj;
    private final zzgo zzvx;

    public zzdrb(Context context, zzgo zzgo) {
        this.zzclb = context.getSharedPreferences("pcvmspf", 0);
        this.zzhji = zzdre.zza(context.getDir("pccache", 0), false);
        this.zzhjj = zzdre.zza(context.getDir("tmppccache", 0), true);
        this.zzvx = zzgo;
    }

    public final zzdrc zzeg(int i) {
        zzgr zzeh = zzeh(i);
        if (zzeh == null) {
            return null;
        }
        String zzdh = zzeh.zzdh();
        return new zzdrc(zzeh, zzdre.zza(zzdh, "pcam", zzavs()), zzdre.zza(zzdh, "pcbc", zzavs()), zzdre.zza(zzdh, "pcopt", zzavs()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0140, code lost:
        if (r0.commit() != false) goto L_0x0144;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0172  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzgq r9, com.google.android.gms.internal.ads.zzdrh r10) {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzgr r0 = r9.zzdd()
            java.lang.String r0 = r0.zzdh()
            com.google.android.gms.internal.ads.zzeer r1 = r9.zzde()
            byte[] r1 = r1.toByteArray()
            com.google.android.gms.internal.ads.zzeer r2 = r9.zzdf()
            byte[] r2 = r2.toByteArray()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r4 = "pcbc"
            java.lang.String r5 = "pcam"
            r6 = 0
            if (r3 != 0) goto L_0x0059
            if (r2 == 0) goto L_0x0059
            int r3 = r2.length
            if (r3 != 0) goto L_0x0029
            goto L_0x0059
        L_0x0029:
            java.io.File r3 = r8.zzhjj
            com.google.android.gms.internal.ads.zzdre.zze(r3)
            java.io.File r3 = r8.zzhjj
            r3.mkdirs()
            java.io.File r3 = r8.zzhjj
            java.io.File r3 = com.google.android.gms.internal.ads.zzdre.zza(r0, r3)
            r3.mkdirs()
            java.io.File r3 = r8.zzhjj
            java.io.File r3 = com.google.android.gms.internal.ads.zzdre.zza(r0, r5, r3)
            if (r1 == 0) goto L_0x004e
            int r7 = r1.length
            if (r7 <= 0) goto L_0x004e
            boolean r1 = com.google.android.gms.internal.ads.zzdre.zza(r3, r1)
            if (r1 != 0) goto L_0x004e
            goto L_0x0059
        L_0x004e:
            java.io.File r1 = r8.zzhjj
            java.io.File r0 = com.google.android.gms.internal.ads.zzdre.zza(r0, r4, r1)
            boolean r0 = com.google.android.gms.internal.ads.zzdre.zza(r0, r2)
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            if (r0 != 0) goto L_0x005d
            return r6
        L_0x005d:
            com.google.android.gms.internal.ads.zzgr r0 = r9.zzdd()
            java.lang.String r0 = r0.zzdh()
            java.io.File r1 = r8.zzhjj
            java.io.File r0 = com.google.android.gms.internal.ads.zzdre.zza(r0, r5, r1)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x007a
            if (r10 == 0) goto L_0x007a
            boolean r10 = r10.zzb(r0)
            if (r10 != 0) goto L_0x007a
            return r6
        L_0x007a:
            com.google.android.gms.internal.ads.zzgr r10 = r9.zzdd()
            java.lang.String r10 = r10.zzdh()
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r1 = 1
            if (r0 != 0) goto L_0x00bf
            java.io.File r0 = r8.zzhjj
            java.io.File r0 = com.google.android.gms.internal.ads.zzdre.zza(r10, r5, r0)
            java.io.File r2 = r8.zzhjj
            java.io.File r2 = com.google.android.gms.internal.ads.zzdre.zza(r10, r4, r2)
            java.io.File r3 = r8.zzavs()
            java.io.File r3 = com.google.android.gms.internal.ads.zzdre.zza(r10, r5, r3)
            java.io.File r5 = r8.zzavs()
            java.io.File r10 = com.google.android.gms.internal.ads.zzdre.zza(r10, r4, r5)
            boolean r4 = r0.exists()
            if (r4 == 0) goto L_0x00b1
            boolean r0 = r0.renameTo(r3)
            if (r0 == 0) goto L_0x00bf
        L_0x00b1:
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x00bf
            boolean r10 = r2.renameTo(r10)
            if (r10 == 0) goto L_0x00bf
            r10 = 1
            goto L_0x00c0
        L_0x00bf:
            r10 = 0
        L_0x00c0:
            if (r10 == 0) goto L_0x0143
            com.google.android.gms.internal.ads.zzgr$zza r10 = com.google.android.gms.internal.ads.zzgr.zzdm()
            com.google.android.gms.internal.ads.zzgr r0 = r9.zzdd()
            java.lang.String r0 = r0.zzdh()
            com.google.android.gms.internal.ads.zzgr$zza r10 = r10.zzav(r0)
            com.google.android.gms.internal.ads.zzgr r0 = r9.zzdd()
            java.lang.String r0 = r0.zzdi()
            com.google.android.gms.internal.ads.zzgr$zza r10 = r10.zzaw(r0)
            com.google.android.gms.internal.ads.zzgr r0 = r9.zzdd()
            long r2 = r0.zzdk()
            com.google.android.gms.internal.ads.zzgr$zza r10 = r10.zzdk(r2)
            com.google.android.gms.internal.ads.zzgr r0 = r9.zzdd()
            long r2 = r0.zzdl()
            com.google.android.gms.internal.ads.zzgr$zza r10 = r10.zzdl(r2)
            com.google.android.gms.internal.ads.zzgr r9 = r9.zzdd()
            long r2 = r9.zzdj()
            com.google.android.gms.internal.ads.zzgr$zza r9 = r10.zzdj(r2)
            com.google.android.gms.internal.ads.zzehl r9 = r9.zzbfq()
            com.google.android.gms.internal.ads.zzegb r9 = (com.google.android.gms.internal.ads.zzegb) r9
            com.google.android.gms.internal.ads.zzgr r9 = (com.google.android.gms.internal.ads.zzgr) r9
            int r10 = com.google.android.gms.internal.ads.zzdrk.zzhjs
            com.google.android.gms.internal.ads.zzgr r10 = r8.zzeh(r10)
            android.content.SharedPreferences r0 = r8.zzclb
            android.content.SharedPreferences$Editor r0 = r0.edit()
            if (r10 == 0) goto L_0x0131
            java.lang.String r2 = r9.zzdh()
            java.lang.String r3 = r10.zzdh()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0131
            java.lang.String r2 = r8.zzavt()
            java.lang.String r10 = zza(r10)
            r0.putString(r2, r10)
        L_0x0131:
            java.lang.String r10 = r8.zzavu()
            java.lang.String r9 = zza(r9)
            r0.putString(r10, r9)
            boolean r9 = r0.commit()
            if (r9 == 0) goto L_0x0143
            goto L_0x0144
        L_0x0143:
            r1 = 0
        L_0x0144:
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            int r10 = com.google.android.gms.internal.ads.zzdrk.zzhjs
            com.google.android.gms.internal.ads.zzgr r10 = r8.zzeh(r10)
            if (r10 == 0) goto L_0x0158
            java.lang.String r10 = r10.zzdh()
            r9.add(r10)
        L_0x0158:
            int r10 = com.google.android.gms.internal.ads.zzdrk.zzhjt
            com.google.android.gms.internal.ads.zzgr r10 = r8.zzeh(r10)
            if (r10 == 0) goto L_0x0167
            java.lang.String r10 = r10.zzdh()
            r9.add(r10)
        L_0x0167:
            java.io.File r10 = r8.zzavs()
            java.io.File[] r10 = r10.listFiles()
            int r0 = r10.length
        L_0x0170:
            if (r6 >= r0) goto L_0x018c
            r2 = r10[r6]
            java.lang.String r2 = r2.getName()
            boolean r3 = r9.contains(r2)
            if (r3 != 0) goto L_0x0189
            java.io.File r3 = r8.zzavs()
            java.io.File r2 = com.google.android.gms.internal.ads.zzdre.zza(r2, r3)
            com.google.android.gms.internal.ads.zzdre.zze(r2)
        L_0x0189:
            int r6 = r6 + 1
            goto L_0x0170
        L_0x018c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdrb.zza(com.google.android.gms.internal.ads.zzgq, com.google.android.gms.internal.ads.zzdrh):boolean");
    }

    private final File zzavs() {
        File file = new File(this.zzhji, Integer.toString(this.zzvx.zzw()));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private static String zza(zzgr zzgr) {
        return Hex.bytesToStringLowercase(zzgr.zzbct().toByteArray());
    }

    private final String zzavt() {
        int zzw = this.zzvx.zzw();
        StringBuilder sb = new StringBuilder(17);
        sb.append("FBAMTD");
        sb.append(zzw);
        return sb.toString();
    }

    private final String zzavu() {
        int zzw = this.zzvx.zzw();
        StringBuilder sb = new StringBuilder(17);
        sb.append("LATMTD");
        sb.append(zzw);
        return sb.toString();
    }

    private final zzgr zzeh(int i) {
        String str;
        if (i == zzdrk.zzhjs) {
            str = this.zzclb.getString(zzavu(), null);
        } else {
            str = i == zzdrk.zzhjt ? this.zzclb.getString(zzavt(), null) : null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            zzgr zzl = zzgr.zzl(zzeer.zzu(Hex.stringToBytes(str)));
            String zzdh = zzl.zzdh();
            if (zzdre.zza(zzdh, "pcam", zzavs()).exists() && zzdre.zza(zzdh, "pcbc", zzavs()).exists()) {
                return zzl;
            }
            return null;
        } catch (zzegl unused) {
        }
    }
}
