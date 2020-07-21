package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdqv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdqv> CREATOR = new zzdqy();
    private final int versionCode;
    private zzcf.zza zzhjd = null;
    private byte[] zzhje;

    zzdqv(int i, byte[] bArr) {
        this.versionCode = i;
        this.zzhje = bArr;
        zzavo();
    }

    public final zzcf.zza zzavn() {
        if (!(this.zzhjd != null)) {
            try {
                this.zzhjd = zzcf.zza.zza(this.zzhje, zzefo.zzber());
                this.zzhje = null;
            } catch (zzegl e) {
                throw new IllegalStateException(e);
            }
        }
        zzavo();
        return this.zzhjd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        byte[] bArr = this.zzhje;
        if (bArr == null) {
            bArr = this.zzhjd.toByteArray();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private final void zzavo() {
        if (this.zzhjd == null && this.zzhje != null) {
            return;
        }
        if (this.zzhjd != null && this.zzhje == null) {
            return;
        }
        if (this.zzhjd != null && this.zzhje != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.zzhjd == null && this.zzhje == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }
}
