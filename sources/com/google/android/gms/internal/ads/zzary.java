package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzary implements Parcelable.Creator<zzarv> {
    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzarv[] newArray(int i) {
        return new zzarv[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzarv createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        ArrayList<String> arrayList3 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        zzash zzash = null;
        String str7 = null;
        String str8 = null;
        zzaub zzaub = null;
        ArrayList<String> arrayList4 = null;
        ArrayList<String> arrayList5 = null;
        zzarx zzarx = null;
        String str9 = null;
        ArrayList<String> arrayList6 = null;
        String str10 = null;
        zzavq zzavq = null;
        String str11 = null;
        Bundle bundle = null;
        ArrayList<String> arrayList7 = null;
        String str12 = null;
        String str13 = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        int i4 = 0;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    arrayList = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 5:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    arrayList2 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 7:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 8:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    j2 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 10:
                    arrayList3 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 11:
                    j3 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 12:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 13:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 14:
                    j4 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 15:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 16:
                case 17:
                case 20:
                case 27:
                case 41:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 18:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 19:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 21:
                    str6 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 22:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 23:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 24:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 25:
                    z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 26:
                    z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 28:
                    zzash = (zzash) SafeParcelReader.createParcelable(parcel, readHeader, zzash.CREATOR);
                    break;
                case 29:
                    str7 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 30:
                    str8 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 31:
                    z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 32:
                    z9 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 33:
                    zzaub = (zzaub) SafeParcelReader.createParcelable(parcel, readHeader, zzaub.CREATOR);
                    break;
                case 34:
                    arrayList4 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 35:
                    arrayList5 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 36:
                    z10 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 37:
                    zzarx = (zzarx) SafeParcelReader.createParcelable(parcel, readHeader, zzarx.CREATOR);
                    break;
                case 38:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 39:
                    str9 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 40:
                    arrayList6 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 42:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 43:
                    str10 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 44:
                    zzavq = (zzavq) SafeParcelReader.createParcelable(parcel, readHeader, zzavq.CREATOR);
                    break;
                case 45:
                    str11 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 46:
                    z13 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 47:
                    z14 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 48:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 49:
                    z15 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 50:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 51:
                    z16 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 52:
                    arrayList7 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 53:
                    z17 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 54:
                    str12 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 55:
                    str13 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 56:
                    z18 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 57:
                    z19 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzarv(i, str, str2, arrayList, i2, arrayList2, j, z, j2, arrayList3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, zzash, str7, str8, z8, z9, zzaub, arrayList4, arrayList5, z10, zzarx, z11, str9, arrayList6, z12, str10, zzavq, str11, z13, z14, bundle, z15, i4, z16, arrayList7, z17, str12, str13, z18, z19);
    }
}
