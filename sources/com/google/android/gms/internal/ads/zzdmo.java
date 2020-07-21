package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzty;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdmo implements zzdml {
    private final ConcurrentHashMap<zzdmv, zzdmm> zzhcq;
    private zzdms zzhcr;
    private zzdmq zzhcs = new zzdmq();

    public zzdmo(zzdms zzdms) {
        this.zzhcq = new ConcurrentHashMap<>(zzdms.zzhdl);
        this.zzhcr = zzdms;
    }

    @Override // com.google.android.gms.internal.ads.zzdml
    public final synchronized zzdmw<?> zza(zzdmv zzdmv) {
        zzdmw<?> zzdmw;
        zzdmm zzdmm = this.zzhcq.get(zzdmv);
        zzdmw = null;
        if (zzdmm != null) {
            zzdmw = zzdmm.zzasz();
            if (zzdmw == null) {
                this.zzhcs.zzath();
            }
            zza(zzdmw, zzdmm.zzatd());
        } else {
            this.zzhcs.zzatg();
            zza((zzdmw<?>) null, (zzdnm) null);
        }
        return zzdmw;
    }

    @Override // com.google.android.gms.internal.ads.zzdml
    public final synchronized boolean zza(zzdmv zzdmv, zzdmw<?> zzdmw) {
        boolean zzb;
        zzdmm zzdmm = this.zzhcq.get(zzdmv);
        zzdmw.zzhee = zzq.zzld().currentTimeMillis();
        if (zzdmm == null) {
            zzdmm = new zzdmm(this.zzhcr.zzhdl, this.zzhcr.zzhdm * 1000);
            if (this.zzhcq.size() == this.zzhcr.zzhdk) {
                int i = zzdmn.zzhcp[this.zzhcr.zzhdp - 1];
                long j = LongCompanionObject.MAX_VALUE;
                zzdmv zzdmv2 = null;
                if (i == 1) {
                    for (Map.Entry<zzdmv, zzdmm> entry : this.zzhcq.entrySet()) {
                        if (entry.getValue().getCreationTimeMillis() < j) {
                            j = entry.getValue().getCreationTimeMillis();
                            zzdmv2 = entry.getKey();
                        }
                    }
                    if (zzdmv2 != null) {
                        this.zzhcq.remove(zzdmv2);
                    }
                } else if (i == 2) {
                    for (Map.Entry<zzdmv, zzdmm> entry2 : this.zzhcq.entrySet()) {
                        if (entry2.getValue().zzata() < j) {
                            j = entry2.getValue().zzata();
                            zzdmv2 = entry2.getKey();
                        }
                    }
                    if (zzdmv2 != null) {
                        this.zzhcq.remove(zzdmv2);
                    }
                } else if (i == 3) {
                    int i2 = Integer.MAX_VALUE;
                    for (Map.Entry<zzdmv, zzdmm> entry3 : this.zzhcq.entrySet()) {
                        if (entry3.getValue().zzatb() < i2) {
                            i2 = entry3.getValue().zzatb();
                            zzdmv2 = entry3.getKey();
                        }
                    }
                    if (zzdmv2 != null) {
                        this.zzhcq.remove(zzdmv2);
                    }
                }
                this.zzhcs.zzatj();
            }
            this.zzhcq.put(zzdmv, zzdmm);
            this.zzhcs.zzati();
        }
        zzb = zzdmm.zzb(zzdmw);
        this.zzhcs.zzatk();
        zzdmp zzatl = this.zzhcs.zzatl();
        zzdnm zzatd = zzdmm.zzatd();
        if (zzdmw != null) {
            zzdmw.zzhec.zzair().zzd((zzty.zzb) ((zzegb) zzty.zzb.zznf().zza(zzty.zzb.zza.zznh().zza(zzty.zzb.C0020zzb.IN_MEMORY).zza(zzty.zzb.zze.zznl().zzs(zzatl.zzhct).zzt(zzatl.zzhcu).zzcc(zzatd.zzhez))).zzbfq()));
        }
        dumpToLog();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdml
    public final synchronized boolean zzb(zzdmv zzdmv) {
        zzdmm zzdmm = this.zzhcq.get(zzdmv);
        if (zzdmm == null) {
            return true;
        }
        if (zzdmm.size() < this.zzhcr.zzhdl) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdml
    @Deprecated
    public final zzdmv zza(zzve zzve, String str, zzvo zzvo) {
        return new zzdmy(zzve, str, new zzasu(this.zzhcr.zzvr).zzvf().zzdtk, this.zzhcr.zzhdn, zzvo);
    }

    @Override // com.google.android.gms.internal.ads.zzdml
    public final zzdms zzasy() {
        return this.zzhcr;
    }

    private final void zza(zzdmw<?> zzdmw, zzdnm zzdnm) {
        if (zzdmw != null) {
            zzdmw.zzhec.zzair().zzc((zzty.zzb) ((zzegb) zzty.zzb.zznf().zza(zzty.zzb.zza.zznh().zza(zzty.zzb.C0020zzb.IN_MEMORY).zza(zzty.zzb.zzd.zznj().zzq(zzdnm.zzhfa).zzca(zzdnm.zzhez))).zzbfq()));
        }
        dumpToLog();
    }

    private final void dumpToLog() {
        if (zzdms.zzatn()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzhcr.zzhdj);
            sb.append(" PoolCollection");
            sb.append(this.zzhcs.zzatm());
            int i = 0;
            for (Map.Entry<zzdmv, zzdmm> entry : this.zzhcq.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(entry.getKey().hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < entry.getValue().size(); i2++) {
                    sb.append("[O]");
                }
                for (int size = entry.getValue().size(); size < this.zzhcr.zzhdl; size++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(entry.getValue().zzatc());
                sb.append("\n");
            }
            while (i < this.zzhcr.zzhdk) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzaxv.zzee(sb.toString());
        }
    }
}
