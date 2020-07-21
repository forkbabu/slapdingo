package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzapx implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzapu zzdmk;
    private final /* synthetic */ String zzdml;
    private final /* synthetic */ String zzdmm;

    zzapx(zzapu zzapu, String str, String str2) {
        this.zzdmk = zzapu;
        this.zzdml = str;
        this.zzdmm = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DownloadManager downloadManager = (DownloadManager) this.zzdmk.zzvr.getSystemService("download");
        try {
            String str = this.zzdml;
            String str2 = this.zzdmm;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzq.zzky();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.zzdmk.zzdw("Could not store picture.");
        }
    }
}
