package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzid {
    private static final zzid zzail = new zzid(new int[]{2}, 2);
    private final int[] zzaim;
    private final int zzain = 2;

    private zzid(int[] iArr, int i) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.zzaim = copyOf;
        Arrays.sort(copyOf);
    }

    public final boolean zzv(int i) {
        return Arrays.binarySearch(this.zzaim, i) >= 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzid)) {
            return false;
        }
        zzid zzid = (zzid) obj;
        return Arrays.equals(this.zzaim, zzid.zzaim) && this.zzain == zzid.zzain;
    }

    public final int hashCode() {
        return this.zzain + (Arrays.hashCode(this.zzaim) * 31);
    }

    public final String toString() {
        int i = this.zzain;
        String arrays = Arrays.toString(this.zzaim);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
