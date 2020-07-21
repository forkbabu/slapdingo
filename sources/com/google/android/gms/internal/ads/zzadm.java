package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzadm extends NativeAd.AdChoicesInfo {
    private String text;
    private final List<NativeAd.Image> zzdbw = new ArrayList();
    private final zzadl zzdch;

    public zzadm(zzadl zzadl) {
        zzadt zzadt;
        IBinder iBinder;
        this.zzdch = zzadl;
        try {
            this.text = zzadl.getText();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            this.text = "";
        }
        try {
            for (zzadt zzadt2 : zzadl.zzrt()) {
                if (!(zzadt2 instanceof IBinder) || (iBinder = (IBinder) zzadt2) == null) {
                    zzadt = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzadt = queryLocalInterface instanceof zzadt ? (zzadt) queryLocalInterface : new zzadv(iBinder);
                }
                if (zzadt != null) {
                    this.zzdbw.add(new zzadu(zzadt));
                }
            }
        } catch (RemoteException e2) {
            zzbba.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.text;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzdbw;
    }
}
