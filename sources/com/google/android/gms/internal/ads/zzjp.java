package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzjl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzjp implements Parcelable.Creator<zzjl.zza> {
    zzjp() {
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjl.zza[] newArray(int i) {
        return new zzjl.zza[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzjl.zza createFromParcel(Parcel parcel) {
        return new zzjl.zza(parcel);
    }
}
