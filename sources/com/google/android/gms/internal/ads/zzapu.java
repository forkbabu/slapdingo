package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzq;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzapu extends zzaqd {
    private final Map<String, String> zzcyg;
    /* access modifiers changed from: private */
    public final Context zzvr;

    public zzapu(zzbfn zzbfn, Map<String, String> map) {
        super(zzbfn, "storePicture");
        this.zzcyg = map;
        this.zzvr = zzbfn.zzzl();
    }

    public final void execute() {
        if (this.zzvr == null) {
            zzdw("Activity context is not available");
            return;
        }
        zzq.zzkw();
        if (!zzaye.zzau(this.zzvr).zzqz()) {
            zzdw("Feature is not supported by the device.");
            return;
        }
        String str = this.zzcyg.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzdw("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzdw(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            zzq.zzkw();
            if (!zzaye.zzen(lastPathSegment)) {
                String valueOf2 = String.valueOf(lastPathSegment);
                zzdw(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
                return;
            }
            Resources resources = zzq.zzla().getResources();
            zzq.zzkw();
            AlertDialog.Builder zzat = zzaye.zzat(this.zzvr);
            zzat.setTitle(resources != null ? resources.getString(R.string.s1) : "Save image");
            zzat.setMessage(resources != null ? resources.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
            zzat.setPositiveButton(resources != null ? resources.getString(R.string.s3) : AbstractSpiCall.HEADER_ACCEPT, new zzapx(this, str, lastPathSegment));
            zzat.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzapw(this));
            zzat.create().show();
        }
    }
}
