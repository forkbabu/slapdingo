package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.zzq;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzahw implements zzx {
    /* access modifiers changed from: private */
    public volatile zzahp zzdeo;
    private final Context zzvr;

    public zzahw(Context context) {
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzx
    public final zzy zzc(zzaa<?> zzaa) throws zzao {
        zzaho zzh = zzaho.zzh(zzaa);
        long elapsedRealtime = zzq.zzld().elapsedRealtime();
        try {
            zzbbn zzbbn = new zzbbn();
            this.zzdeo = new zzahp(this.zzvr, zzq.zzlk().zzya(), new zzaia(this, zzbbn), new zzaid(this, zzbbn));
            this.zzdeo.checkAvailabilityAndConnect();
            zzdvf zza = zzdux.zza(zzdux.zzb(zzbbn, new zzahz(this, zzh), zzbbf.zzedh), (long) ((Integer) zzwg.zzpw().zzd(zzaav.zzcsq)).intValue(), TimeUnit.MILLISECONDS, zzbbf.zzedk);
            zza.addListener(new zzaib(this), zzbbf.zzedh);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zza.get();
            long elapsedRealtime2 = zzq.zzld().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(elapsedRealtime2);
            sb.append("ms");
            zzaxv.zzeh(sb.toString());
            zzahq zzahq = (zzahq) new zzash(parcelFileDescriptor).zza(zzahq.CREATOR);
            if (zzahq == null) {
                return null;
            }
            if (zzahq.zzden) {
                throw new zzao(zzahq.zzcgo);
            } else if (zzahq.zzdel.length != zzahq.zzdem.length) {
                return null;
            } else {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < zzahq.zzdel.length; i++) {
                    hashMap.put(zzahq.zzdel[i], zzahq.zzdem[i]);
                }
                return new zzy(zzahq.statusCode, zzahq.data, hashMap, zzahq.zzan, zzahq.zzao);
            }
        } catch (InterruptedException | ExecutionException unused) {
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(zzq.zzld().elapsedRealtime() - elapsedRealtime);
            sb2.append("ms");
            zzaxv.zzeh(sb2.toString());
            return null;
        } catch (Throwable th) {
            long elapsedRealtime3 = zzq.zzld().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(elapsedRealtime3);
            sb3.append("ms");
            zzaxv.zzeh(sb3.toString());
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        if (this.zzdeo != null) {
            this.zzdeo.disconnect();
            Binder.flushPendingCommands();
        }
    }
}
