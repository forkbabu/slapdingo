package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaxs implements zzrj {
    private final Object lock = new Object();
    private final zzaxx zzdyn;
    private final zzaxq zzdyt;
    private final zzaxo zzdyu;
    private final HashSet<zzaxg> zzdyv = new HashSet<>();
    private final HashSet<zzaxp> zzdyw = new HashSet<>();

    public zzaxs(String str, zzaxx zzaxx) {
        this.zzdyu = new zzaxo(str, zzaxx);
        this.zzdyn = zzaxx;
        this.zzdyt = new zzaxq();
    }

    public final void zzb(zzaxg zzaxg) {
        synchronized (this.lock) {
            this.zzdyv.add(zzaxg);
        }
    }

    public final void zzb(HashSet<zzaxg> hashSet) {
        synchronized (this.lock) {
            this.zzdyv.addAll(hashSet);
        }
    }

    public final Bundle zza(Context context, zzaxn zzaxn) {
        HashSet<zzaxg> hashSet = new HashSet<>();
        synchronized (this.lock) {
            hashSet.addAll(this.zzdyv);
            this.zzdyv.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zzdyu.zzp(context, this.zzdyt.zzwp()));
        Bundle bundle2 = new Bundle();
        Iterator<zzaxp> it2 = this.zzdyw.iterator();
        if (!it2.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zzaxg> it3 = hashSet.iterator();
            while (it3.hasNext()) {
                arrayList.add(it3.next().toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzaxn.zza(hashSet);
            return bundle;
        }
        it2.next();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzrj
    public final void zzp(boolean z) {
        long currentTimeMillis = zzq.zzld().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.zzdyn.zzxa() > ((Long) zzwg.zzpw().zzd(zzaav.zzcod)).longValue()) {
                this.zzdyu.zzdyk = -1;
                return;
            }
            this.zzdyu.zzdyk = this.zzdyn.zzxb();
            return;
        }
        this.zzdyn.zzez(currentTimeMillis);
        this.zzdyn.zzde(this.zzdyu.zzdyk);
    }

    public final void zzvv() {
        synchronized (this.lock) {
            this.zzdyu.zzvv();
        }
    }

    public final void zzvu() {
        synchronized (this.lock) {
            this.zzdyu.zzvu();
        }
    }

    public final void zza(zzve zzve, long j) {
        synchronized (this.lock) {
            this.zzdyu.zza(zzve, j);
        }
    }

    public final zzaxg zza(Clock clock, String str) {
        return new zzaxg(clock, this, this.zzdyt.zzwo(), str);
    }
}
