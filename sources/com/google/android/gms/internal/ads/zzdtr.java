package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdtr implements FilenameFilter {
    private final Pattern zzhbi;

    public zzdtr(Pattern pattern) {
        this.zzhbi = (Pattern) zzdsh.checkNotNull(pattern);
    }

    public final boolean accept(@NullableDecl File file, String str) {
        return this.zzhbi.matcher(str).matches();
    }
}
