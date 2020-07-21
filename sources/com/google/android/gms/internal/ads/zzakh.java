package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzakh {
    /* access modifiers changed from: private */
    public final Object lock;
    /* access modifiers changed from: private */
    public int status;
    private final zzbbd zzboy;
    private final String zzdga;
    /* access modifiers changed from: private */
    public zzazj<zzaju> zzdgb;
    private zzazj<zzaju> zzdgc;
    /* access modifiers changed from: private */
    public zzaky zzdgd;
    private final Context zzvr;

    public zzakh(Context context, zzbbd zzbbd, String str) {
        this.lock = new Object();
        this.status = 1;
        this.zzdga = str;
        this.zzvr = context.getApplicationContext();
        this.zzboy = zzbbd;
        this.zzdgb = new zzakv();
        this.zzdgc = new zzakv();
    }

    public zzakh(Context context, zzbbd zzbbd, String str, zzazj<zzaju> zzazj, zzazj<zzaju> zzazj2) {
        this(context, zzbbd, str);
        this.zzdgb = zzazj;
        this.zzdgc = zzazj2;
    }

    /* access modifiers changed from: protected */
    public final zzaky zza(zzeg zzeg) {
        zzaky zzaky = new zzaky(this.zzdgc);
        zzbbf.zzedl.execute(new zzakg(this, zzeg, zzaky));
        zzaky.zza(new zzakq(this, zzaky), new zzakt(this, zzaky));
        return zzaky;
    }

    public final zzaku zzb(zzeg zzeg) {
        synchronized (this.lock) {
            synchronized (this.lock) {
                if (this.zzdgd != null && this.status == 0) {
                    this.zzdgd.zza(new zzakj(this), zzaki.zzdge);
                }
            }
            if (this.zzdgd == null || this.zzdgd.getStatus() == -1) {
                this.status = 2;
                zzaky zza = zza((zzeg) null);
                this.zzdgd = zza;
                zzaku zztb = zza.zztb();
                return zztb;
            } else if (this.status == 0) {
                zzaku zztb2 = this.zzdgd.zztb();
                return zztb2;
            } else if (this.status == 1) {
                this.status = 2;
                zza((zzeg) null);
                zzaku zztb3 = this.zzdgd.zztb();
                return zztb3;
            } else if (this.status == 2) {
                zzaku zztb4 = this.zzdgd.zztb();
                return zztb4;
            } else {
                zzaku zztb5 = this.zzdgd.zztb();
                return zztb5;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzaju zzaju) {
        if (zzaju.isDestroyed()) {
            this.status = 1;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzeg zzeg, zzaky zzaky) {
        zzaju zzaju;
        try {
            Context context = this.zzvr;
            zzbbd zzbbd = this.zzboy;
            if (zzacw.zzdbn.get().booleanValue()) {
                zzaju = new zzajg(context, zzbbd);
            } else {
                zzaju = new zzajw(context, zzbbd, zzeg, null);
            }
            zzaju.zza(new zzakl(this, zzaky, zzaju));
            zzaju.zza("/jsLoaded", new zzakm(this, zzaky, zzaju));
            zzbaf zzbaf = new zzbaf();
            zzakp zzakp = new zzakp(this, zzeg, zzaju, zzbaf);
            zzbaf.set(zzakp);
            zzaju.zza("/requestReload", zzakp);
            if (this.zzdga.endsWith(".js")) {
                zzaju.zzcy(this.zzdga);
            } else if (this.zzdga.startsWith("<html>")) {
                zzaju.zzcz(this.zzdga);
            } else {
                zzaju.zzda(this.zzdga);
            }
            zzaye.zzdzw.postDelayed(new zzako(this, zzaky, zzaju), (long) zzaks.zzdgo);
        } catch (Throwable th) {
            zzaxv.zzc("Error creating webview.", th);
            zzq.zzla().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzaky.reject();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzaky r4, com.google.android.gms.internal.ads.zzaju r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            int r1 = r4.getStatus()     // Catch:{ all -> 0x002a }
            r2 = -1
            if (r1 == r2) goto L_0x0028
            int r1 = r4.getStatus()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != r2) goto L_0x0012
            goto L_0x0028
        L_0x0012:
            r4.reject()     // Catch:{ all -> 0x002a }
            com.google.android.gms.internal.ads.zzdvi r4 = com.google.android.gms.internal.ads.zzbbf.zzedl     // Catch:{ all -> 0x002a }
            r5.getClass()     // Catch:{ all -> 0x002a }
            java.lang.Runnable r5 = com.google.android.gms.internal.ads.zzakn.zzb(r5)     // Catch:{ all -> 0x002a }
            r4.execute(r5)     // Catch:{ all -> 0x002a }
            java.lang.String r4 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.internal.ads.zzaxv.zzeh(r4)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakh.zza(com.google.android.gms.internal.ads.zzaky, com.google.android.gms.internal.ads.zzaju):void");
    }
}
