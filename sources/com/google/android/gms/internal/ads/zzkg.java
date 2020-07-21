package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Stack;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzkg implements zzkl {
    private final byte[] zzaos = new byte[8];
    private final Stack<zzki> zzaot = new Stack<>();
    private final zzkq zzaou = new zzkq();
    private zzkk zzaov;
    private int zzaow;
    private int zzaox;
    private long zzaoy;

    zzkg() {
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zza(zzkk zzkk) {
        this.zzaov = zzkk;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void reset() {
        this.zzaow = 0;
        this.zzaot.clear();
        this.zzaou.reset();
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final boolean zzb(zzjw zzjw) throws IOException, InterruptedException {
        String str;
        double d;
        int zzap;
        int zza;
        zzpb.checkState(this.zzaov != null);
        while (true) {
            if (this.zzaot.isEmpty() || zzjw.getPosition() < this.zzaot.peek().zzapb) {
                if (this.zzaow == 0) {
                    long zza2 = this.zzaou.zza(zzjw, true, false, 4);
                    if (zza2 == -2) {
                        zzjw.zzgp();
                        while (true) {
                            zzjw.zza(this.zzaos, 0, 4);
                            zzap = zzkq.zzap(this.zzaos[0]);
                            if (zzap != -1 && zzap <= 4) {
                                zza = (int) zzkq.zza(this.zzaos, zzap, false);
                                if (this.zzaov.zzan(zza)) {
                                    break;
                                }
                            }
                            zzjw.zzah(1);
                        }
                        zzjw.zzah(zzap);
                        zza2 = (long) zza;
                    }
                    if (zza2 == -1) {
                        return false;
                    }
                    this.zzaox = (int) zza2;
                    this.zzaow = 1;
                }
                if (this.zzaow == 1) {
                    this.zzaoy = this.zzaou.zza(zzjw, false, true, 8);
                    this.zzaow = 2;
                }
                int zzam = this.zzaov.zzam(this.zzaox);
                if (zzam == 0) {
                    zzjw.zzah((int) this.zzaoy);
                    this.zzaow = 0;
                } else if (zzam == 1) {
                    long position = zzjw.getPosition();
                    this.zzaot.add(new zzki(this.zzaox, this.zzaoy + position));
                    this.zzaov.zzd(this.zzaox, position, this.zzaoy);
                    this.zzaow = 0;
                    return true;
                } else if (zzam == 2) {
                    long j = this.zzaoy;
                    if (j <= 8) {
                        this.zzaov.zzc(this.zzaox, zza(zzjw, (int) j));
                        this.zzaow = 0;
                        return true;
                    }
                    long j2 = this.zzaoy;
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j2);
                    throw new zzht(sb.toString());
                } else if (zzam == 3) {
                    long j3 = this.zzaoy;
                    if (j3 <= 2147483647L) {
                        zzkk zzkk = this.zzaov;
                        int i = this.zzaox;
                        int i2 = (int) j3;
                        if (i2 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i2];
                            zzjw.readFully(bArr, 0, i2);
                            str = new String(bArr);
                        }
                        zzkk.zza(i, str);
                        this.zzaow = 0;
                        return true;
                    }
                    long j4 = this.zzaoy;
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("String element size: ");
                    sb2.append(j4);
                    throw new zzht(sb2.toString());
                } else if (zzam == 4) {
                    this.zzaov.zza(this.zzaox, (int) this.zzaoy, zzjw);
                    this.zzaow = 0;
                    return true;
                } else if (zzam == 5) {
                    long j5 = this.zzaoy;
                    if (j5 == 4 || j5 == 8) {
                        zzkk zzkk2 = this.zzaov;
                        int i3 = this.zzaox;
                        int i4 = (int) this.zzaoy;
                        long zza3 = zza(zzjw, i4);
                        if (i4 == 4) {
                            d = (double) Float.intBitsToFloat((int) zza3);
                        } else {
                            d = Double.longBitsToDouble(zza3);
                        }
                        zzkk2.zza(i3, d);
                        this.zzaow = 0;
                        return true;
                    }
                    long j6 = this.zzaoy;
                    StringBuilder sb3 = new StringBuilder(40);
                    sb3.append("Invalid float size: ");
                    sb3.append(j6);
                    throw new zzht(sb3.toString());
                } else {
                    StringBuilder sb4 = new StringBuilder(32);
                    sb4.append("Invalid element type ");
                    sb4.append(zzam);
                    throw new zzht(sb4.toString());
                }
            } else {
                this.zzaov.zzao(this.zzaot.pop().zzaox);
                return true;
            }
        }
    }

    private final long zza(zzjw zzjw, int i) throws IOException, InterruptedException {
        zzjw.readFully(this.zzaos, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.zzaos[i2] & UByte.MAX_VALUE));
        }
        return j;
    }
}
