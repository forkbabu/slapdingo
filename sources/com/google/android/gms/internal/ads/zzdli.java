package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdli {
    private final Pattern zzhbi;

    public zzdli() {
        Pattern pattern;
        try {
            pattern = Pattern.compile((String) zzwg.zzpw().zzd(zzaav.zzcwt));
        } catch (PatternSyntaxException unused) {
            pattern = null;
        }
        this.zzhbi = pattern;
    }

    public final String zzgt(String str) {
        Pattern pattern = this.zzhbi;
        if (!(pattern == null || str == null)) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
        }
        return null;
    }
}
