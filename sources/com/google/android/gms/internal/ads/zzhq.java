package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzhq implements Parcelable {
    public static final Parcelable.Creator<zzhq> CREATOR = new zzhp();
    public final int height;
    public final int width;
    private final String zzagr;
    public final int zzags;
    public final String zzagt;
    private final zzme zzagu;
    private final String zzagv;
    public final String zzagw;
    public final int zzagx;
    public final List<byte[]> zzagy;
    public final zzjl zzagz;
    public final float zzaha;
    public final int zzahb;
    public final float zzahc;
    private final int zzahd;
    private final byte[] zzahe;
    private final zzpt zzahf;
    public final int zzahg;
    public final int zzahh;
    public final int zzahi;
    private final int zzahj;
    private final int zzahk;
    public final long zzahl;
    public final int zzahm;
    public final String zzahn;
    private final int zzaho;
    private int zzahp;

    public static zzhq zza(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, zzpt zzpt, zzjl zzjl) {
        return new zzhq(str, null, str2, null, -1, i2, i3, i4, -1.0f, i5, f2, bArr, i6, zzpt, -1, -1, -1, -1, -1, 0, null, -1, LongCompanionObject.MAX_VALUE, list, zzjl, null);
    }

    public final int describeContents() {
        return 0;
    }

    public static zzhq zza(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, zzjl zzjl, int i5, String str4) {
        return zza(str, str2, null, -1, -1, i3, i4, -1, null, zzjl, 0, str4);
    }

    public static zzhq zza(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, zzjl zzjl, int i6, String str4) {
        return new zzhq(str, null, str2, null, -1, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, -1, -1, i6, str4, -1, LongCompanionObject.MAX_VALUE, list, zzjl, null);
    }

    public static zzhq zza(String str, String str2, String str3, int i, int i2, String str4, zzjl zzjl) {
        return zza(str, str2, null, -1, i2, str4, -1, zzjl, LongCompanionObject.MAX_VALUE, Collections.emptyList());
    }

    public static zzhq zza(String str, String str2, String str3, int i, int i2, String str4, int i3, zzjl zzjl, long j, List<byte[]> list) {
        return new zzhq(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, -1, j, list, zzjl, null);
    }

    public static zzhq zza(String str, String str2, String str3, int i, List<byte[]> list, String str4, zzjl zzjl) {
        return new zzhq(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, LongCompanionObject.MAX_VALUE, list, zzjl, null);
    }

    public static zzhq zza(String str, String str2, long j) {
        return new zzhq(null, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, LongCompanionObject.MAX_VALUE, null, null, null);
    }

    public static zzhq zza(String str, String str2, String str3, int i, zzjl zzjl) {
        return new zzhq(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, LongCompanionObject.MAX_VALUE, null, zzjl, null);
    }

    private zzhq(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, zzpt zzpt, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, zzjl zzjl, zzme zzme) {
        this.zzagr = str;
        this.zzagv = str2;
        this.zzagw = str3;
        this.zzagt = str4;
        this.zzags = i;
        this.zzagx = i2;
        this.width = i3;
        this.height = i4;
        this.zzaha = f;
        this.zzahb = i5;
        this.zzahc = f2;
        this.zzahe = bArr;
        this.zzahd = i6;
        this.zzahf = zzpt;
        this.zzahg = i7;
        this.zzahh = i8;
        this.zzahi = i9;
        this.zzahj = i10;
        this.zzahk = i11;
        this.zzahm = i12;
        this.zzahn = str5;
        this.zzaho = i13;
        this.zzahl = j;
        this.zzagy = list == null ? Collections.emptyList() : list;
        this.zzagz = zzjl;
        this.zzagu = zzme;
    }

    zzhq(Parcel parcel) {
        this.zzagr = parcel.readString();
        this.zzagv = parcel.readString();
        this.zzagw = parcel.readString();
        this.zzagt = parcel.readString();
        this.zzags = parcel.readInt();
        this.zzagx = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.zzaha = parcel.readFloat();
        this.zzahb = parcel.readInt();
        this.zzahc = parcel.readFloat();
        this.zzahe = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.zzahd = parcel.readInt();
        this.zzahf = (zzpt) parcel.readParcelable(zzpt.class.getClassLoader());
        this.zzahg = parcel.readInt();
        this.zzahh = parcel.readInt();
        this.zzahi = parcel.readInt();
        this.zzahj = parcel.readInt();
        this.zzahk = parcel.readInt();
        this.zzahm = parcel.readInt();
        this.zzahn = parcel.readString();
        this.zzaho = parcel.readInt();
        this.zzahl = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzagy = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.zzagy.add(parcel.createByteArray());
        }
        this.zzagz = (zzjl) parcel.readParcelable(zzjl.class.getClassLoader());
        this.zzagu = (zzme) parcel.readParcelable(zzme.class.getClassLoader());
    }

    public final zzhq zzu(int i) {
        return new zzhq(this.zzagr, this.zzagv, this.zzagw, this.zzagt, this.zzags, i, this.width, this.height, this.zzaha, this.zzahb, this.zzahc, this.zzahe, this.zzahd, this.zzahf, this.zzahg, this.zzahh, this.zzahi, this.zzahj, this.zzahk, this.zzahm, this.zzahn, this.zzaho, this.zzahl, this.zzagy, this.zzagz, this.zzagu);
    }

    public final zzhq zzds(long j) {
        return new zzhq(this.zzagr, this.zzagv, this.zzagw, this.zzagt, this.zzags, this.zzagx, this.width, this.height, this.zzaha, this.zzahb, this.zzahc, this.zzahe, this.zzahd, this.zzahf, this.zzahg, this.zzahh, this.zzahi, this.zzahj, this.zzahk, this.zzahm, this.zzahn, this.zzaho, j, this.zzagy, this.zzagz, this.zzagu);
    }

    public final zzhq zzb(int i, int i2) {
        return new zzhq(this.zzagr, this.zzagv, this.zzagw, this.zzagt, this.zzags, this.zzagx, this.width, this.height, this.zzaha, this.zzahb, this.zzahc, this.zzahe, this.zzahd, this.zzahf, this.zzahg, this.zzahh, this.zzahi, i, i2, this.zzahm, this.zzahn, this.zzaho, this.zzahl, this.zzagy, this.zzagz, this.zzagu);
    }

    public final zzhq zza(zzjl zzjl) {
        return new zzhq(this.zzagr, this.zzagv, this.zzagw, this.zzagt, this.zzags, this.zzagx, this.width, this.height, this.zzaha, this.zzahb, this.zzahc, this.zzahe, this.zzahd, this.zzahf, this.zzahg, this.zzahh, this.zzahi, this.zzahj, this.zzahk, this.zzahm, this.zzahn, this.zzaho, this.zzahl, this.zzagy, zzjl, this.zzagu);
    }

    public final zzhq zza(zzme zzme) {
        return new zzhq(this.zzagr, this.zzagv, this.zzagw, this.zzagt, this.zzags, this.zzagx, this.width, this.height, this.zzaha, this.zzahb, this.zzahc, this.zzahe, this.zzahd, this.zzahf, this.zzahg, this.zzahh, this.zzahi, this.zzahj, this.zzahk, this.zzahm, this.zzahn, this.zzaho, this.zzahl, this.zzagy, this.zzagz, zzme);
    }

    public final int zzey() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final MediaFormat zzez() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(Annotation.MIMETYPE, this.zzagw);
        String str = this.zzahn;
        if (str != null) {
            mediaFormat.setString(DublinCoreProperties.LANGUAGE, str);
        }
        zza(mediaFormat, "max-input-size", this.zzagx);
        zza(mediaFormat, HtmlTags.WIDTH, this.width);
        zza(mediaFormat, HtmlTags.HEIGHT, this.height);
        float f = this.zzaha;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        zza(mediaFormat, "rotation-degrees", this.zzahb);
        zza(mediaFormat, "channel-count", this.zzahg);
        zza(mediaFormat, "sample-rate", this.zzahh);
        zza(mediaFormat, "encoder-delay", this.zzahj);
        zza(mediaFormat, "encoder-padding", this.zzahk);
        for (int i = 0; i < this.zzagy.size(); i++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.zzagy.get(i)));
        }
        zzpt zzpt = this.zzahf;
        if (zzpt != null) {
            zza(mediaFormat, "color-transfer", zzpt.zzaro);
            zza(mediaFormat, "color-standard", zzpt.zzarn);
            zza(mediaFormat, "color-range", zzpt.zzarp);
            byte[] bArr = zzpt.zzbkk;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final String toString() {
        String str = this.zzagr;
        String str2 = this.zzagv;
        String str3 = this.zzagw;
        int i = this.zzags;
        String str4 = this.zzahn;
        int i2 = this.width;
        int i3 = this.height;
        float f = this.zzaha;
        int i4 = this.zzahg;
        int i5 = this.zzahh;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 100 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(str4);
        sb.append(", [");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        sb.append("], [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.zzahp == 0) {
            String str = this.zzagr;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + MetaDo.META_OFFSETWINDOWORG) * 31;
            String str2 = this.zzagv;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzagw;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.zzagt;
            int hashCode4 = (((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.zzags) * 31) + this.width) * 31) + this.height) * 31) + this.zzahg) * 31) + this.zzahh) * 31;
            String str5 = this.zzahn;
            int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.zzaho) * 31;
            zzjl zzjl = this.zzagz;
            int hashCode6 = (hashCode5 + (zzjl == null ? 0 : zzjl.hashCode())) * 31;
            zzme zzme = this.zzagu;
            if (zzme != null) {
                i = zzme.hashCode();
            }
            this.zzahp = hashCode6 + i;
        }
        return this.zzahp;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzhq zzhq = (zzhq) obj;
            if (this.zzags == zzhq.zzags && this.zzagx == zzhq.zzagx && this.width == zzhq.width && this.height == zzhq.height && this.zzaha == zzhq.zzaha && this.zzahb == zzhq.zzahb && this.zzahc == zzhq.zzahc && this.zzahd == zzhq.zzahd && this.zzahg == zzhq.zzahg && this.zzahh == zzhq.zzahh && this.zzahi == zzhq.zzahi && this.zzahj == zzhq.zzahj && this.zzahk == zzhq.zzahk && this.zzahl == zzhq.zzahl && this.zzahm == zzhq.zzahm && zzpo.zza(this.zzagr, zzhq.zzagr) && zzpo.zza(this.zzahn, zzhq.zzahn) && this.zzaho == zzhq.zzaho && zzpo.zza(this.zzagv, zzhq.zzagv) && zzpo.zza(this.zzagw, zzhq.zzagw) && zzpo.zza(this.zzagt, zzhq.zzagt) && zzpo.zza(this.zzagz, zzhq.zzagz) && zzpo.zza(this.zzagu, zzhq.zzagu) && zzpo.zza(this.zzahf, zzhq.zzahf) && Arrays.equals(this.zzahe, zzhq.zzahe) && this.zzagy.size() == zzhq.zzagy.size()) {
                for (int i = 0; i < this.zzagy.size(); i++) {
                    if (!Arrays.equals(this.zzagy.get(i), zzhq.zzagy.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static void zza(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzagr);
        parcel.writeString(this.zzagv);
        parcel.writeString(this.zzagw);
        parcel.writeString(this.zzagt);
        parcel.writeInt(this.zzags);
        parcel.writeInt(this.zzagx);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.zzaha);
        parcel.writeInt(this.zzahb);
        parcel.writeFloat(this.zzahc);
        parcel.writeInt(this.zzahe != null ? 1 : 0);
        byte[] bArr = this.zzahe;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.zzahd);
        parcel.writeParcelable(this.zzahf, i);
        parcel.writeInt(this.zzahg);
        parcel.writeInt(this.zzahh);
        parcel.writeInt(this.zzahi);
        parcel.writeInt(this.zzahj);
        parcel.writeInt(this.zzahk);
        parcel.writeInt(this.zzahm);
        parcel.writeString(this.zzahn);
        parcel.writeInt(this.zzaho);
        parcel.writeLong(this.zzahl);
        int size = this.zzagy.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.zzagy.get(i2));
        }
        parcel.writeParcelable(this.zzagz, 0);
        parcel.writeParcelable(this.zzagu, 0);
    }
}
