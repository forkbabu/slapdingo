package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzhh implements zzhe {
    private int repeatMode;
    private final zzhv[] zzaeh;
    private final zzoe zzaei;
    private final zzof zzaej;
    private final Handler zzaek;
    private final zzhj zzael;
    private final CopyOnWriteArraySet<zzhd> zzaem;
    private final zzib zzaen;
    private final zzic zzaeo;
    private boolean zzaep;
    private boolean zzaeq;
    private int zzaer;
    private int zzaes;
    private int zzaet;
    private boolean zzaeu;
    private zzia zzaev;
    private Object zzaew;
    private zznr zzaex;
    private zzof zzaey;
    private zzhw zzaez;
    private zzhl zzafa;
    private int zzafb;
    private int zzafc;
    private long zzafd;

    public zzhh(zzhv[] zzhvArr, zzoe zzoe, zzhu zzhu) {
        String str = zzpo.zzbke;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zzpb.checkState(zzhvArr.length > 0);
        this.zzaeh = (zzhv[]) zzpb.checkNotNull(zzhvArr);
        this.zzaei = (zzoe) zzpb.checkNotNull(zzoe);
        this.zzaeq = false;
        this.repeatMode = 0;
        this.zzaer = 1;
        this.zzaem = new CopyOnWriteArraySet<>();
        this.zzaej = new zzof(new zzod[zzhvArr.length]);
        this.zzaev = zzia.zzahy;
        this.zzaen = new zzib();
        this.zzaeo = new zzic();
        this.zzaex = zznr.zzbgn;
        this.zzaey = this.zzaej;
        this.zzaez = zzhw.zzahs;
        this.zzaek = new zzhk(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        zzhl zzhl = new zzhl(0, 0);
        this.zzafa = zzhl;
        this.zzael = new zzhj(zzhvArr, zzoe, zzhu, this.zzaeq, 0, this.zzaek, zzhl, this);
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void zza(zzhd zzhd) {
        this.zzaem.add(zzhd);
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void zzb(zzhd zzhd) {
        this.zzaem.remove(zzhd);
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final int getPlaybackState() {
        return this.zzaer;
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void zza(zznb zznb) {
        if (!this.zzaev.isEmpty() || this.zzaew != null) {
            this.zzaev = zzia.zzahy;
            this.zzaew = null;
            Iterator<zzhd> it2 = this.zzaem.iterator();
            while (it2.hasNext()) {
                it2.next().zza(this.zzaev, this.zzaew);
            }
        }
        if (this.zzaep) {
            this.zzaep = false;
            this.zzaex = zznr.zzbgn;
            this.zzaey = this.zzaej;
            this.zzaei.zzd(null);
            Iterator<zzhd> it3 = this.zzaem.iterator();
            while (it3.hasNext()) {
                it3.next().zza(this.zzaex, this.zzaey);
            }
        }
        this.zzaet++;
        this.zzael.zza(zznb, true);
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void zzg(boolean z) {
        if (this.zzaeq != z) {
            this.zzaeq = z;
            this.zzael.zzg(z);
            Iterator<zzhd> it2 = this.zzaem.iterator();
            while (it2.hasNext()) {
                it2.next().zza(z, this.zzaer);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final boolean zzek() {
        return this.zzaeq;
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void seekTo(long j) {
        long j2;
        int zzen = zzen();
        if (zzen < 0 || (!this.zzaev.isEmpty() && zzen >= this.zzaev.zzfe())) {
            throw new zzhr(this.zzaev, zzen, j);
        }
        this.zzaes++;
        this.zzafb = zzen;
        if (!this.zzaev.isEmpty()) {
            this.zzaev.zza(zzen, this.zzaen, false);
            if (j == -9223372036854775807L) {
                j2 = this.zzaen.zzaig;
            } else {
                j2 = zzhc.zzdp(j);
            }
            long j3 = this.zzaen.zzaii + j2;
            long j4 = this.zzaev.zza(0, this.zzaeo, false).zzaih;
            if (j4 != -9223372036854775807L) {
                int i = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
            }
        }
        this.zzafc = 0;
        if (j == -9223372036854775807L) {
            this.zzafd = 0;
            this.zzael.zza(this.zzaev, zzen, -9223372036854775807L);
            return;
        }
        this.zzafd = j;
        this.zzael.zza(this.zzaev, zzen, zzhc.zzdp(j));
        Iterator<zzhd> it2 = this.zzaem.iterator();
        while (it2.hasNext()) {
            it2.next().zzej();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void stop() {
        this.zzael.stop();
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void release() {
        this.zzael.release();
        this.zzaek.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void zza(zzhf... zzhfArr) {
        this.zzael.zza(zzhfArr);
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final void zzb(zzhf... zzhfArr) {
        this.zzael.zzb(zzhfArr);
    }

    private final int zzen() {
        if (this.zzaev.isEmpty() || this.zzaes > 0) {
            return this.zzafb;
        }
        this.zzaev.zza(this.zzafa.zzafz, this.zzaeo, false);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final long getDuration() {
        if (this.zzaev.isEmpty()) {
            return -9223372036854775807L;
        }
        return zzhc.zzdo(this.zzaev.zza(zzen(), this.zzaen, false).zzaih);
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final long zzem() {
        if (this.zzaev.isEmpty() || this.zzaes > 0) {
            return this.zzafd;
        }
        this.zzaev.zza(this.zzafa.zzafz, this.zzaeo, false);
        return this.zzaeo.zzfg() + zzhc.zzdo(this.zzafa.zzagb);
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final long getBufferedPosition() {
        if (this.zzaev.isEmpty() || this.zzaes > 0) {
            return this.zzafd;
        }
        this.zzaev.zza(this.zzafa.zzafz, this.zzaeo, false);
        return this.zzaeo.zzfg() + zzhc.zzdo(this.zzafa.zzagc);
    }

    @Override // com.google.android.gms.internal.ads.zzhe
    public final int zzel() {
        return this.zzaeh.length;
    }

    /* access modifiers changed from: package-private */
    public final void zza(Message message) {
        boolean z = true;
        switch (message.what) {
            case 0:
                this.zzaet--;
                return;
            case 1:
                this.zzaer = message.arg1;
                Iterator<zzhd> it2 = this.zzaem.iterator();
                while (it2.hasNext()) {
                    it2.next().zza(this.zzaeq, this.zzaer);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z = false;
                }
                this.zzaeu = z;
                Iterator<zzhd> it3 = this.zzaem.iterator();
                while (it3.hasNext()) {
                    it3.next().zzf(this.zzaeu);
                }
                return;
            case 3:
                if (this.zzaet == 0) {
                    zzog zzog = (zzog) message.obj;
                    this.zzaep = true;
                    this.zzaex = zzog.zzbhp;
                    this.zzaey = zzog.zzbhq;
                    this.zzaei.zzd(zzog.zzbhr);
                    Iterator<zzhd> it4 = this.zzaem.iterator();
                    while (it4.hasNext()) {
                        it4.next().zza(this.zzaex, this.zzaey);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.zzaes - 1;
                this.zzaes = i;
                if (i == 0) {
                    this.zzafa = (zzhl) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzhd> it5 = this.zzaem.iterator();
                        while (it5.hasNext()) {
                            it5.next().zzej();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.zzaes == 0) {
                    this.zzafa = (zzhl) message.obj;
                    Iterator<zzhd> it6 = this.zzaem.iterator();
                    while (it6.hasNext()) {
                        it6.next().zzej();
                    }
                    return;
                }
                return;
            case 6:
                zzhn zzhn = (zzhn) message.obj;
                this.zzaes -= zzhn.zzago;
                if (this.zzaet == 0) {
                    this.zzaev = zzhn.zzaev;
                    this.zzaew = zzhn.zzaew;
                    this.zzafa = zzhn.zzafa;
                    Iterator<zzhd> it7 = this.zzaem.iterator();
                    while (it7.hasNext()) {
                        it7.next().zza(this.zzaev, this.zzaew);
                    }
                    return;
                }
                return;
            case 7:
                zzhw zzhw = (zzhw) message.obj;
                if (!this.zzaez.equals(zzhw)) {
                    this.zzaez = zzhw;
                    Iterator<zzhd> it8 = this.zzaem.iterator();
                    while (it8.hasNext()) {
                        it8.next().zza(zzhw);
                    }
                    return;
                }
                return;
            case 8:
                zzhb zzhb = (zzhb) message.obj;
                Iterator<zzhd> it9 = this.zzaem.iterator();
                while (it9.hasNext()) {
                    it9.next().zza(zzhb);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
