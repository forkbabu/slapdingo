package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzasw implements Callable<zzasr> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzast zzdug;

    zzasw(zzast zzast, Context context) {
        this.zzdug = zzast;
        this.val$context = context;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzasr call() throws Exception {
        zzasr zzasr;
        zzasv zzasv = (zzasv) this.zzdug.zzdud.get(this.val$context);
        if (zzasv != null) {
            if (!(zzasv.zzdue + zzacd.zzczg.get().longValue() < zzq.zzld().currentTimeMillis())) {
                zzasr = new zzasu(this.val$context, zzasv.zzduf).zzvf();
                this.zzdug.zzdud.put(this.val$context, new zzasv(this.zzdug, zzasr));
                return zzasr;
            }
        }
        zzasr = new zzasu(this.val$context).zzvf();
        this.zzdug.zzdud.put(this.val$context, new zzasv(this.zzdug, zzasr));
        return zzasr;
    }
}
