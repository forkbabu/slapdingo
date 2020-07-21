package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzbba;
import com.google.android.gms.internal.ads.zzeg;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzp extends AsyncTask<Void, Void, String> {
    private final /* synthetic */ zzl zzbox;

    private zzp(zzl zzl) {
        this.zzbox = zzl;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final String doInBackground(Void... voidArr) {
        try {
            zzeg unused = this.zzbox.zzbpe = (zzeg) this.zzbox.zzbpa.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzbba.zzd("", e);
        }
        return this.zzbox.zzkm();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        if (this.zzbox.zzbpc != null && str2 != null) {
            this.zzbox.zzbpc.loadUrl(str2);
        }
    }

    /* synthetic */ zzp(zzl zzl, zzk zzk) {
        this(zzl);
    }
}
