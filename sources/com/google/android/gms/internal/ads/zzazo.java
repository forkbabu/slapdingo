package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.zhihu.matisse.internal.loader.AlbumLoader;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzazo {
    public final int count;
    public final String name;
    private final double zzebe;
    private final double zzebf;
    public final double zzebg;

    public zzazo(String str, double d, double d2, double d3, int i) {
        this.name = str;
        this.zzebf = d;
        this.zzebe = d2;
        this.zzebg = d3;
        this.count = i;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).add("minBound", Double.valueOf(this.zzebf)).add("maxBound", Double.valueOf(this.zzebe)).add("percent", Double.valueOf(this.zzebg)).add(AlbumLoader.COLUMN_COUNT, Integer.valueOf(this.count)).toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzazo)) {
            return false;
        }
        zzazo zzazo = (zzazo) obj;
        if (Objects.equal(this.name, zzazo.name) && this.zzebe == zzazo.zzebe && this.zzebf == zzazo.zzebf && this.count == zzazo.count && Double.compare(this.zzebg, zzazo.zzebg) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.name, Double.valueOf(this.zzebe), Double.valueOf(this.zzebf), Double.valueOf(this.zzebg), Integer.valueOf(this.count));
    }
}
