package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaxg {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final Clock zzbqd;
    private final String zzdpv;
    private boolean zzdrf = false;
    private long zzdrj = -1;
    private final zzaxs zzdxc;
    private final LinkedList<zzaxf> zzdxd;
    private final String zzdxe;
    private long zzdxf = -1;
    private long zzdxg = -1;
    private long zzdxh = 0;
    private long zzdxi = -1;
    private long zzdxj = -1;

    zzaxg(Clock clock, zzaxs zzaxs, String str, String str2) {
        this.zzbqd = clock;
        this.zzdxc = zzaxs;
        this.zzdxe = str;
        this.zzdpv = str2;
        this.zzdxd = new LinkedList<>();
    }

    public final void zze(zzve zzve) {
        synchronized (this.lock) {
            long elapsedRealtime = this.zzbqd.elapsedRealtime();
            this.zzdxi = elapsedRealtime;
            this.zzdxc.zza(zzve, elapsedRealtime);
        }
    }

    public final void zzey(long j) {
        synchronized (this.lock) {
            this.zzdxj = j;
            if (j != -1) {
                this.zzdxc.zzb(this);
            }
        }
    }

    public final void zzvu() {
        synchronized (this.lock) {
            if (this.zzdxj != -1 && this.zzdxf == -1) {
                this.zzdxf = this.zzbqd.elapsedRealtime();
                this.zzdxc.zzb(this);
            }
            this.zzdxc.zzvu();
        }
    }

    public final void zzvv() {
        synchronized (this.lock) {
            if (this.zzdxj != -1) {
                zzaxf zzaxf = new zzaxf(this);
                zzaxf.zzvt();
                this.zzdxd.add(zzaxf);
                this.zzdxh++;
                this.zzdxc.zzvv();
                this.zzdxc.zzb(this);
            }
        }
    }

    public final void zzvw() {
        synchronized (this.lock) {
            if (this.zzdxj != -1 && !this.zzdxd.isEmpty()) {
                zzaxf last = this.zzdxd.getLast();
                if (last.zzvr() == -1) {
                    last.zzvs();
                    this.zzdxc.zzb(this);
                }
            }
        }
    }

    public final void zzan(boolean z) {
        synchronized (this.lock) {
            if (this.zzdxj != -1) {
                this.zzdxg = this.zzbqd.elapsedRealtime();
            }
        }
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzdxe);
            bundle.putString("slotid", this.zzdpv);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.zzdxi);
            bundle.putLong("tresponse", this.zzdxj);
            bundle.putLong("timp", this.zzdxf);
            bundle.putLong("tload", this.zzdxg);
            bundle.putLong("pcc", this.zzdxh);
            bundle.putLong("tfetch", this.zzdrj);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zzaxf> it2 = this.zzdxd.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final String zzvx() {
        return this.zzdxe;
    }
}
