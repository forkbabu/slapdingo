package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zztj implements Runnable {
    private final zztg zzbvj;
    private final zzsz zzbvk;
    private final zzsy zzbvl;
    private final zzbbn zzbvm;

    zztj(zztg zztg, zzsz zzsz, zzsy zzsy, zzbbn zzbbn) {
        this.zzbvj = zztg;
        this.zzbvk = zzsz;
        this.zzbvl = zzsy;
        this.zzbvm = zzbbn;
    }

    public final void run() {
        zztg zztg = this.zzbvj;
        zzsz zzsz = this.zzbvk;
        zzsy zzsy = this.zzbvl;
        zzbbn zzbbn = this.zzbvm;
        try {
            zzsx zza = zzsz.zzmy().zza(zzsy);
            if (!zza.zzmv()) {
                zzbbn.setException(new RuntimeException("No entry contents."));
                zztg.zzbvg.disconnect();
                return;
            }
            zztl zztl = new zztl(zztg, zza.zzmw(), 1);
            int read = zztl.read();
            if (read != -1) {
                zztl.unread(read);
                zzbbn.set(zztl);
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zzaxv.zzc("Unable to obtain a cache service instance.", e);
            zzbbn.setException(e);
            zztg.zzbvg.disconnect();
        }
    }
}
