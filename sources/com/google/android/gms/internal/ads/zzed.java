package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzed extends zzdy {
    public static zzed zzb(String str, Context context, boolean z) {
        return zzb(str, context, false, zzcw.zznj);
    }

    public static zzed zzb(String str, Context context, boolean z, int i) {
        zza(context, z);
        zza(str, context, z, i);
        return new zzed(context, str, z, i);
    }

    private zzed(Context context, String str, boolean z, int i) {
        super(context, str, z, i);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdy
    public final List<Callable<Void>> zza(zzex zzex, Context context, zzcf.zza.C0006zza zza, zzby.zza zza2) {
        if (zzex.zzch() == null || !this.zzxi) {
            return super.zza(zzex, context, zza, zza2);
        }
        int zzbv = zzex.zzbv();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zza(zzex, context, zza, zza2));
        arrayList.add(new zzfr(zzex, "dB9nU8T59ryKJmWsX8227JmprxMTr/BJUpIu7gXDsZZaHmbsnoTSiUl5TzUnFlE8", "5lhN2r0HBs7T9NDv68OqYdEED6z/p5KbOT380l1QTlE=", zza, zzbv, 24));
        return arrayList;
    }
}
