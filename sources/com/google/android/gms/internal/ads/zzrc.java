package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import org.spongycastle.crypto.tls.CipherSuite;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzrc {
    private final Object lock = new Object();
    private int score;
    private final int zzbrw;
    private final int zzbrx;
    private final int zzbry;
    private final boolean zzbrz;
    private final zzrr zzbsa;
    private final zzry zzbsb;
    private ArrayList<String> zzbsc = new ArrayList<>();
    private ArrayList<String> zzbsd = new ArrayList<>();
    private ArrayList<zzrp> zzbse = new ArrayList<>();
    private int zzbsf = 0;
    private int zzbsg = 0;
    private int zzbsh = 0;
    private String zzbsi = "";
    private String zzbsj = "";
    private String zzbsk = "";

    public zzrc(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.zzbrw = i;
        this.zzbrx = i2;
        this.zzbry = i3;
        this.zzbrz = z;
        this.zzbsa = new zzrr(i4);
        this.zzbsb = new zzry(i5, i6, i7);
    }

    public final boolean zzlx() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbsh == 0;
        }
        return z;
    }

    public final String zzly() {
        return this.zzbsi;
    }

    public final String zzlz() {
        return this.zzbsj;
    }

    public final String zzma() {
        return this.zzbsk;
    }

    public final void zzmb() {
        synchronized (this.lock) {
            this.score -= 100;
        }
    }

    public final void zzmc() {
        synchronized (this.lock) {
            this.zzbsh--;
        }
    }

    public final void zzmd() {
        synchronized (this.lock) {
            this.zzbsh++;
        }
    }

    public final void zza(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
        synchronized (this.lock) {
            if (this.zzbsh < 0) {
                zzaxv.zzee("ActivityContent: negative number of WebViews.");
            }
            zzmf();
        }
    }

    public final void zzb(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
    }

    private final void zzc(String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null && str.length() >= this.zzbry) {
            synchronized (this.lock) {
                this.zzbsc.add(str);
                this.zzbsf += str.length();
                if (z) {
                    this.zzbsd.add(str);
                    this.zzbse.add(new zzrp(f, f2, f3, f4, this.zzbsd.size() - 1));
                }
            }
        }
    }

    public final void zzme() {
        synchronized (this.lock) {
            int zzh = zzh(this.zzbsf, this.zzbsg);
            if (zzh > this.score) {
                this.score = zzh;
            }
        }
    }

    public final void zzmf() {
        synchronized (this.lock) {
            int zzh = zzh(this.zzbsf, this.zzbsg);
            if (zzh > this.score) {
                this.score = zzh;
                if (!zzq.zzla().zzwe().zzwt()) {
                    this.zzbsi = this.zzbsa.zza(this.zzbsc);
                    this.zzbsj = this.zzbsa.zza(this.zzbsd);
                }
                if (!zzq.zzla().zzwe().zzwv()) {
                    this.zzbsk = this.zzbsb.zza(this.zzbsd, this.zzbse);
                }
            }
        }
    }

    private final int zzh(int i, int i2) {
        if (this.zzbrz) {
            return this.zzbrx;
        }
        return (i * this.zzbrw) + (i2 * this.zzbrx);
    }

    public final int getScore() {
        return this.score;
    }

    public final void zzbv(int i) {
        this.zzbsg = i;
    }

    private static String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayList2.get(i2);
            i2++;
            sb.append(str);
            sb.append(' ');
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        if (sb2.length() < 100) {
            return sb2;
        }
        return sb2.substring(0, 100);
    }

    public final String toString() {
        int i = this.zzbsg;
        int i2 = this.score;
        int i3 = this.zzbsf;
        String zza = zza(this.zzbsc, 100);
        String zza2 = zza(this.zzbsd, 100);
        String str = this.zzbsi;
        String str2 = this.zzbsj;
        String str3 = this.zzbsk;
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + CipherSuite.TLS_DH_DSS_WITH_AES_256_GCM_SHA384 + String.valueOf(zza2).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(zza);
        sb.append("\n viewableText");
        sb.append(zza2);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final int zzmg() {
        return this.zzbsf;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzrc)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzrc) obj).zzbsi;
        return str != null && str.equals(this.zzbsi);
    }

    public final int hashCode() {
        return this.zzbsi.hashCode();
    }
}
