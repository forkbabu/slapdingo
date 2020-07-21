package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbne extends zzbnc {
    private final View view;
    private final zzbfn zzdfp;
    private final Executor zzflp;
    private final zzdkj zzfmu;
    private final zzboy zzfni;
    private final zzccv zzfnj;
    private final zzbyk zzfnk;
    private final zzeku<zzcwo> zzfnl;
    private zzvh zzfnm;
    private final Context zzvr;

    zzbne(zzbpa zzbpa, Context context, zzdkj zzdkj, View view2, zzbfn zzbfn, zzboy zzboy, zzccv zzccv, zzbyk zzbyk, zzeku<zzcwo> zzeku, Executor executor) {
        super(zzbpa);
        this.zzvr = context;
        this.view = view2;
        this.zzdfp = zzbfn;
        this.zzfmu = zzdkj;
        this.zzfni = zzboy;
        this.zzfnj = zzccv;
        this.zzfnk = zzbyk;
        this.zzfnl = zzeku;
        this.zzflp = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbnc
    public final View zzahk() {
        return this.view;
    }

    @Override // com.google.android.gms.internal.ads.zzbnc
    public final void zza(ViewGroup viewGroup, zzvh zzvh) {
        zzbfn zzbfn;
        if (viewGroup != null && (zzbfn = this.zzdfp) != null) {
            zzbfn.zza(zzbhg.zzb(zzvh));
            viewGroup.setMinimumHeight(zzvh.heightPixels);
            viewGroup.setMinimumWidth(zzvh.widthPixels);
            this.zzfnm = zzvh;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbnc
    public final zzyi getVideoController() {
        try {
            return this.zzfni.getVideoController();
        } catch (zzdlg unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbnc
    public final zzdkj zzahj() {
        boolean z;
        zzvh zzvh = this.zzfnm;
        if (zzvh != null) {
            return zzdld.zze(zzvh);
        }
        if (this.zzfol.zzhad) {
            Iterator<String> it2 = this.zzfol.zzgzk.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                String next = it2.next();
                if (next != null && next.contains("FirstParty")) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return new zzdkj(this.view.getWidth(), this.view.getHeight(), false);
            }
        }
        return zzdld.zza(this.zzfol.zzgzq, this.zzfmu);
    }

    @Override // com.google.android.gms.internal.ads.zzbnc
    public final zzdkj zzahp() {
        return this.zzfmu;
    }

    @Override // com.google.android.gms.internal.ads.zzbnc
    public final int zzahq() {
        return this.zzfkn.zzhau.zzhar.zzhai;
    }

    @Override // com.google.android.gms.internal.ads.zzbnc
    public final void zzkg() {
        this.zzfnk.zzakb();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzahr() {
        this.zzflp.execute(new zzbnh(this));
        super.zzahr();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzahs() {
        if (this.zzfnj.zzaly() != null) {
            try {
                this.zzfnj.zzaly().zza(this.zzfnl.get(), ObjectWrapper.wrap(this.zzvr));
            } catch (RemoteException e) {
                zzaxv.zzc("RemoteException when notifyAdLoad is called", e);
            }
        }
    }
}
