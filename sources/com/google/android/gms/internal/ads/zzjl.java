package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzjl implements Parcelable, Comparator<zza> {
    public static final Parcelable.Creator<zzjl> CREATOR = new zzjn();
    private int zzahp;
    private final zza[] zzaoa;
    public final int zzaob;

    public zzjl(List<zza> list) {
        this(false, (zza[]) list.toArray(new zza[list.size()]));
    }

    public final int describeContents() {
        return 0;
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza implements Parcelable {
        public static final Parcelable.Creator<zza> CREATOR = new zzjp();
        private final byte[] data;
        private final String mimeType;
        /* access modifiers changed from: private */
        public final UUID uuid;
        private int zzahp;
        public final boolean zzaof;

        public zza(UUID uuid2, String str, byte[] bArr) {
            this(uuid2, str, bArr, false);
        }

        public final int describeContents() {
            return 0;
        }

        private zza(UUID uuid2, String str, byte[] bArr, boolean z) {
            this.uuid = (UUID) zzpb.checkNotNull(uuid2);
            this.mimeType = (String) zzpb.checkNotNull(str);
            this.data = (byte[]) zzpb.checkNotNull(bArr);
            this.zzaof = false;
        }

        zza(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.zzaof = parcel.readByte() != 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            zza zza = (zza) obj;
            return this.mimeType.equals(zza.mimeType) && zzpo.zza(this.uuid, zza.uuid) && Arrays.equals(this.data, zza.data);
        }

        public final int hashCode() {
            if (this.zzahp == 0) {
                this.zzahp = (((this.uuid.hashCode() * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            return this.zzahp;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte(this.zzaof ? (byte) 1 : 0);
        }
    }

    public zzjl(zza... zzaArr) {
        this(true, zzaArr);
    }

    private zzjl(boolean z, zza... zzaArr) {
        zzaArr = z ? (zza[]) zzaArr.clone() : zzaArr;
        Arrays.sort(zzaArr, this);
        int i = 1;
        while (i < zzaArr.length) {
            if (!zzaArr[i - 1].uuid.equals(zzaArr[i].uuid)) {
                i++;
            } else {
                String valueOf = String.valueOf(zzaArr[i].uuid);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
                sb.append("Duplicate data for uuid: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.zzaoa = zzaArr;
        this.zzaob = zzaArr.length;
    }

    zzjl(Parcel parcel) {
        zza[] zzaArr = (zza[]) parcel.createTypedArray(zza.CREATOR);
        this.zzaoa = zzaArr;
        this.zzaob = zzaArr.length;
    }

    public final zza zzad(int i) {
        return this.zzaoa[i];
    }

    public final int hashCode() {
        if (this.zzahp == 0) {
            this.zzahp = Arrays.hashCode(this.zzaoa);
        }
        return this.zzahp;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzaoa, ((zzjl) obj).zzaoa);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.zzaoa, 0);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zza zza2, zza zza3) {
        zza zza4 = zza2;
        zza zza5 = zza3;
        if (zzhc.UUID_NIL.equals(zza4.uuid)) {
            return zzhc.UUID_NIL.equals(zza5.uuid) ? 0 : 1;
        }
        return zza4.uuid.compareTo(zza5.uuid);
    }
}
