package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class zzapd {
    public static zzaox zzdt(String str) throws RemoteException {
        try {
            return new zzapc((RtbAdapter) Class.forName(str, false, zzapd.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Throwable unused) {
            throw new RemoteException();
        }
    }
}
