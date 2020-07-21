package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzme implements Parcelable {
    public static final Parcelable.Creator<zzme> CREATOR = new zzmd();
    private final zza[] zzbcz;

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public interface zza extends Parcelable {
    }

    public zzme(List<? extends zza> list) {
        zza[] zzaArr = new zza[list.size()];
        this.zzbcz = zzaArr;
        list.toArray(zzaArr);
    }

    public final int describeContents() {
        return 0;
    }

    zzme(Parcel parcel) {
        this.zzbcz = new zza[parcel.readInt()];
        int i = 0;
        while (true) {
            zza[] zzaArr = this.zzbcz;
            if (i < zzaArr.length) {
                zzaArr[i] = (zza) parcel.readParcelable(zza.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public final int length() {
        return this.zzbcz.length;
    }

    public final zza zzaz(int i) {
        return this.zzbcz[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbcz, ((zzme) obj).zzbcz);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzbcz);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzbcz.length);
        for (zza zza2 : this.zzbcz) {
            parcel.writeParcelable(zza2, 0);
        }
    }
}
