package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzarx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzarx> CREATOR = new zzasa();
    public final boolean zzdsj;
    public final List<String> zzdsk;

    public zzarx() {
        this(false, Collections.emptyList());
    }

    public zzarx(boolean z, List<String> list) {
        this.zzdsj = z;
        this.zzdsk = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdsj);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzdsk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
