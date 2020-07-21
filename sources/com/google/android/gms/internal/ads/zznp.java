package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zznp extends zzia {
    private static final Object zzbgi = new Object();
    private final boolean zzaic;
    private final boolean zzaid;
    private final long zzbgj;
    private final long zzbgk;
    private final long zzbgl;
    private final long zzbgm;

    public zznp(long j, boolean z) {
        this(j, j, 0, 0, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzia
    public final int zzfe() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzia
    public final int zzff() {
        return 1;
    }

    private zznp(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.zzbgj = j;
        this.zzbgk = j2;
        this.zzbgl = 0;
        this.zzbgm = 0;
        this.zzaic = z;
        this.zzaid = false;
    }

    @Override // com.google.android.gms.internal.ads.zzia
    public final zzib zza(int i, zzib zzib, boolean z, long j) {
        zzpb.zzc(i, 0, 1);
        boolean z2 = this.zzaic;
        long j2 = this.zzbgk;
        zzib.zzahz = null;
        zzib.zzaia = -9223372036854775807L;
        zzib.zzaib = -9223372036854775807L;
        zzib.zzaic = z2;
        zzib.zzaid = false;
        zzib.zzaig = 0;
        zzib.zzaih = j2;
        zzib.zzaie = 0;
        zzib.zzaif = 0;
        zzib.zzaii = 0;
        return zzib;
    }

    @Override // com.google.android.gms.internal.ads.zzia
    public final zzic zza(int i, zzic zzic, boolean z) {
        zzpb.zzc(i, 0, 1);
        Object obj = z ? zzbgi : null;
        return zzic.zza(obj, obj, 0, this.zzbgj, 0, false);
    }

    @Override // com.google.android.gms.internal.ads.zzia
    public final int zzc(Object obj) {
        return zzbgi.equals(obj) ? 0 : -1;
    }
}
