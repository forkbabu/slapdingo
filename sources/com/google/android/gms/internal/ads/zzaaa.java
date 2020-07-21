package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzaaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaaa> CREATOR = new zzaad();
    public final boolean zzado;
    public final boolean zzadp;
    public final boolean zzadq;

    public zzaaa(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    public zzaaa(boolean z, boolean z2, boolean z3) {
        this.zzado = z;
        this.zzadp = z2;
        this.zzadq = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzado);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzadp);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzadq);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
