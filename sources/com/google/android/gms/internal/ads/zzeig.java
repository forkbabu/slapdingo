package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeig {
    private final ArrayDeque<zzeer> zziia;

    private zzeig() {
        this.zziia = new ArrayDeque<>();
    }

    /* access modifiers changed from: private */
    public final zzeer zzc(zzeer zzeer, zzeer zzeer2) {
        zzal(zzeer);
        zzal(zzeer2);
        zzeer pop = this.zziia.pop();
        while (!this.zziia.isEmpty()) {
            pop = new zzeie(this.zziia.pop(), pop, null);
        }
        return pop;
    }

    private final void zzal(zzeer zzeer) {
        while (!zzeer.zzbdh()) {
            if (zzeer instanceof zzeie) {
                zzeie zzeie = (zzeie) zzeer;
                zzal(zzeie.zzihu);
                zzeer = zzeie.zzihv;
            } else {
                String valueOf = String.valueOf(zzeer.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        int zzhm = zzhm(zzeer.size());
        int zzhl = zzeie.zzhl(zzhm + 1);
        if (this.zziia.isEmpty() || this.zziia.peek().size() >= zzhl) {
            this.zziia.push(zzeer);
            return;
        }
        int zzhl2 = zzeie.zzhl(zzhm);
        zzeer pop = this.zziia.pop();
        while (!this.zziia.isEmpty() && this.zziia.peek().size() < zzhl2) {
            pop = new zzeie(this.zziia.pop(), pop, null);
        }
        zzeie zzeie2 = new zzeie(pop, zzeer, null);
        while (!this.zziia.isEmpty() && this.zziia.peek().size() < zzeie.zzhl(zzhm(zzeie2.size()) + 1)) {
            zzeie2 = new zzeie(this.zziia.pop(), zzeie2, null);
        }
        this.zziia.push(zzeie2);
    }

    private static int zzhm(int i) {
        int binarySearch = Arrays.binarySearch(zzeie.zzihs, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ zzeig(zzeid zzeid) {
        this();
    }
}
