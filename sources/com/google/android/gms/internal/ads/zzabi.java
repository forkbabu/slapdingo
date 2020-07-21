package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzabi {
    private final Object lock = new Object();
    boolean zzcye = true;
    private final List<zzabg> zzcyf = new LinkedList();
    private final Map<String, String> zzcyg = new LinkedHashMap();
    private zzabi zzcyh;

    public zzabi(boolean z, String str, String str2) {
        this.zzcyg.put("action", str);
        this.zzcyg.put("ad_format", str2);
    }

    public final void zzc(zzabi zzabi) {
        synchronized (this.lock) {
            this.zzcyh = zzabi;
        }
    }

    public final zzabg zzex(long j) {
        if (!this.zzcye) {
            return null;
        }
        return new zzabg(j, null, null);
    }

    public final boolean zza(zzabg zzabg, long j, String... strArr) {
        synchronized (this.lock) {
            for (String str : strArr) {
                this.zzcyf.add(new zzabg(j, str, zzabg));
            }
        }
        return true;
    }

    public final String zzrn() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.lock) {
            for (zzabg zzabg : this.zzcyf) {
                long time = zzabg.getTime();
                String zzrl = zzabg.zzrl();
                zzabg zzrm = zzabg.zzrm();
                if (zzrm != null && time > 0) {
                    sb2.append(zzrl);
                    sb2.append('.');
                    sb2.append(time - zzrm.getTime());
                    sb2.append(',');
                }
            }
            this.zzcyf.clear();
            if (!TextUtils.isEmpty(null)) {
                sb2.append((String) null);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public final void zzh(String str, String str2) {
        zzaay zzvy;
        if (this.zzcye && !TextUtils.isEmpty(str2) && (zzvy = zzq.zzla().zzvy()) != null) {
            synchronized (this.lock) {
                zzabc zzct = zzvy.zzct(str);
                Map<String, String> map = this.zzcyg;
                map.put(str, zzct.zzg(map.get(str), str2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzro() {
        synchronized (this.lock) {
            zzaay zzvy = zzq.zzla().zzvy();
            if (zzvy != null) {
                if (this.zzcyh != null) {
                    Map<String, String> zza = zzvy.zza(this.zzcyg, this.zzcyh.zzro());
                    return zza;
                }
            }
            Map<String, String> map = this.zzcyg;
            return map;
        }
    }
}
