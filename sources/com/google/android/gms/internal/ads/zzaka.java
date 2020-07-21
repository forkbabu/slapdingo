package com.google.android.gms.internal.ads;

import com.itextpdf.text.xml.xmp.XmpWriter;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzaka implements Runnable {
    private final /* synthetic */ String zzdfs;
    private final /* synthetic */ zzajw zzdft;

    zzaka(zzajw zzajw, String str) {
        this.zzdft = zzajw;
        this.zzdfs = str;
    }

    public final void run() {
        this.zzdft.zzdfp.loadData(this.zzdfs, "text/html", XmpWriter.UTF8);
    }
}
