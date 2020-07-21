package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzsx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsx> CREATOR = new zzsw();
    private ParcelFileDescriptor zzbuv;

    public zzsx() {
        this(null);
    }

    public zzsx(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzbuv = parcelFileDescriptor;
    }

    public final synchronized boolean zzmv() {
        return this.zzbuv != null;
    }

    public final synchronized InputStream zzmw() {
        if (this.zzbuv == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbuv);
        this.zzbuv = null;
        return autoCloseInputStream;
    }

    private final synchronized ParcelFileDescriptor zzmx() {
        return this.zzbuv;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, zzmx(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
