package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzq;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.util.Map;
import org.spongycastle.i18n.ErrorBundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzapo extends zzaqd {
    private final Map<String, String> zzcyg;
    private String zzdln = zzdu(DublinCoreProperties.DESCRIPTION);
    private long zzdlo = zzdv("start_ticks");
    private long zzdlp = zzdv("end_ticks");
    private String zzdlq = zzdu(ErrorBundle.SUMMARY_ENTRY);
    private String zzdlr = zzdu(FirebaseAnalytics.Param.LOCATION);
    /* access modifiers changed from: private */
    public final Context zzvr;

    public zzapo(zzbfn zzbfn, Map<String, String> map) {
        super(zzbfn, "createCalendarEvent");
        this.zzcyg = map;
        this.zzvr = zzbfn.zzzl();
    }

    private final String zzdu(String str) {
        return TextUtils.isEmpty(this.zzcyg.get(str)) ? "" : this.zzcyg.get(str);
    }

    private final long zzdv(String str) {
        String str2 = this.zzcyg.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final void execute() {
        if (this.zzvr == null) {
            zzdw("Activity context is not available.");
            return;
        }
        zzq.zzkw();
        if (!zzaye.zzau(this.zzvr).zzra()) {
            zzdw("This feature is not available on the device.");
            return;
        }
        zzq.zzkw();
        AlertDialog.Builder zzat = zzaye.zzat(this.zzvr);
        Resources resources = zzq.zzla().getResources();
        zzat.setTitle(resources != null ? resources.getString(R.string.s5) : "Create calendar event");
        zzat.setMessage(resources != null ? resources.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        zzat.setPositiveButton(resources != null ? resources.getString(R.string.s3) : AbstractSpiCall.HEADER_ACCEPT, new zzapr(this));
        zzat.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzapq(this));
        zzat.create().show();
    }

    /* access modifiers changed from: package-private */
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzdln);
        data.putExtra("eventLocation", this.zzdlr);
        data.putExtra(DublinCoreProperties.DESCRIPTION, this.zzdlq);
        long j = this.zzdlo;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zzdlp;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }
}
