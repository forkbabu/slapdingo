package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzme;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzkb {
    private static final zzmi zzaoq = new zzka();
    private static final Pattern zzaor = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zzahj = -1;
    public int zzahk = -1;

    public final boolean zzb(zzme zzme) {
        for (int i = 0; i < zzme.length(); i++) {
            zzme.zza zzaz = zzme.zzaz(i);
            if (zzaz instanceof zzmg) {
                zzmg zzmg = (zzmg) zzaz;
                if (zzb(zzmg.description, zzmg.text)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean zzb(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = zzaor.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.zzahj = parseInt;
                    this.zzahk = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public final boolean zzgs() {
        return (this.zzahj == -1 || this.zzahk == -1) ? false : true;
    }
}
