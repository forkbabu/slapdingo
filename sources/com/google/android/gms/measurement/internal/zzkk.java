package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zznn;
import com.google.android.gms.internal.measurement.zzoe;
import com.google.android.gms.internal.measurement.zzof;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
public class zzkk implements zzgz {
    private static volatile zzkk zza;
    private zzfx zzb;
    private zzfc zzc;
    private zzad zzd;
    private zzfj zze;
    private zzkg zzf;
    private zzo zzg;
    private final zzks zzh;
    private zzii zzi;
    private final zzgd zzj;
    private boolean zzk;
    private boolean zzl;
    private long zzm;
    private List<Runnable> zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private FileLock zzt;
    private FileChannel zzu;
    private List<Long> zzv;
    private List<Long> zzw;
    private long zzx;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
    class zza implements zzaf {
        zzcc.zzg zza;
        List<Long> zzb;
        List<zzcc.zzc> zzc;
        private long zzd;

        private zza() {
        }

        @Override // com.google.android.gms.measurement.internal.zzaf
        public final void zza(zzcc.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zza = zzg;
        }

        @Override // com.google.android.gms.measurement.internal.zzaf
        public final boolean zza(long j, zzcc.zzc zzc2) {
            Preconditions.checkNotNull(zzc2);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzc2)) {
                return false;
            }
            long zzbm = this.zzd + ((long) zzc2.zzbm());
            if (zzbm >= ((long) Math.max(0, zzaq.zzh.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzbm;
            this.zzc.add(zzc2);
            this.zzb.add(Long.valueOf(j));
            if (this.zzc.size() >= Math.max(1, zzaq.zzi.zza(null).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzcc.zzc zzc2) {
            return ((zzc2.zze() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzkk zzkk, zzkn zzkn) {
            this();
        }
    }

    public static zzkk zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzkk.class) {
                if (zza == null) {
                    zza = new zzkk(new zzkq(context));
                }
            }
        }
        return zza;
    }

    private zzkk(zzkq zzkq) {
        this(zzkq, null);
    }

    private zzkk(zzkq zzkq, zzgd zzgd) {
        this.zzk = false;
        Preconditions.checkNotNull(zzkq);
        this.zzj = zzgd.zza(zzkq.zza, null, null);
        this.zzx = -1;
        zzks zzks = new zzks(this);
        zzks.zzal();
        this.zzh = zzks;
        zzfc zzfc = new zzfc(this);
        zzfc.zzal();
        this.zzc = zzfc;
        zzfx zzfx = new zzfx(this);
        zzfx.zzal();
        this.zzb = zzfx;
        this.zzj.zzq().zza(new zzkn(this, zzkq));
    }

    /* access modifiers changed from: private */
    public final void zza(zzkq zzkq) {
        this.zzj.zzq().zzd();
        zzad zzad = new zzad(this);
        zzad.zzal();
        this.zzd = zzad;
        this.zzj.zzb().zza(this.zzb);
        zzo zzo2 = new zzo(this);
        zzo2.zzal();
        this.zzg = zzo2;
        zzii zzii = new zzii(this);
        zzii.zzal();
        this.zzi = zzii;
        zzkg zzkg = new zzkg(this);
        zzkg.zzal();
        this.zzf = zzkg;
        this.zze = new zzfj(this);
        if (this.zzo != this.zzp) {
            this.zzj.zzr().zzf().zza("Not all upload components initialized", Integer.valueOf(this.zzo), Integer.valueOf(this.zzp));
        }
        this.zzk = true;
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        this.zzj.zzq().zzd();
        zze().zzv();
        if (this.zzj.zzc().zzc.zza() == 0) {
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        zzz();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final zzx zzu() {
        return this.zzj.zzu();
    }

    public final zzy zzb() {
        return this.zzj.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final zzez zzr() {
        return this.zzj.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final zzfw zzq() {
        return this.zzj.zzq();
    }

    public final zzfx zzc() {
        zzb(this.zzb);
        return this.zzb;
    }

    public final zzfc zzd() {
        zzb(this.zzc);
        return this.zzc;
    }

    public final zzad zze() {
        zzb(this.zzd);
        return this.zzd;
    }

    private final zzfj zzt() {
        zzfj zzfj = this.zze;
        if (zzfj != null) {
            return zzfj;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzkg zzv() {
        zzb(this.zzf);
        return this.zzf;
    }

    public final zzo zzf() {
        zzb(this.zzg);
        return this.zzg;
    }

    public final zzii zzg() {
        zzb(this.zzi);
        return this.zzi;
    }

    public final zzks zzh() {
        zzb(this.zzh);
        return this.zzh;
    }

    public final zzex zzi() {
        return this.zzj.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final Context zzn() {
        return this.zzj.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final Clock zzm() {
        return this.zzj.zzm();
    }

    public final zzkw zzj() {
        return this.zzj.zzi();
    }

    private final void zzw() {
        this.zzj.zzq().zzd();
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        if (!this.zzk) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zzb(zzkl zzkl) {
        if (zzkl == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzkl.zzaj()) {
            String valueOf = String.valueOf(zzkl.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private final long zzx() {
        long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
        zzfl zzc2 = this.zzj.zzc();
        zzc2.zzaa();
        zzc2.zzd();
        long zza2 = zzc2.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + ((long) zzc2.zzp().zzh().nextInt(86400000));
            zzc2.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzao zzao, String str) {
        zzf zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping event", str);
            return;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null) {
            if (!"_ui".equals(zzao.zza)) {
                this.zzj.zzr().zzi().zza("Could not find package. appId", zzez.zza(str));
            }
        } else if (!zzb3.booleanValue()) {
            this.zzj.zzr().zzf().zza("App version does not match; dropping event. appId", zzez.zza(str));
            return;
        }
        zzb(zzao, new zzn(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0L, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zzoe.zzb() || !this.zzj.zzb().zze(zzb2.zzc(), zzaq.zzbn)) ? null : zzb2.zzg()));
    }

    private final void zzb(zzao zzao, zzn zzn2) {
        if (zzof.zzb() && this.zzj.zzb().zza(zzaq.zzcn)) {
            zzfd zza2 = zzfd.zza(zzao);
            this.zzj.zzi().zza(zza2.zzb, zze().zzi(zzn2.zza));
            this.zzj.zzi().zza(zza2, this.zzj.zzb().zza(zzn2.zza));
            zzao = zza2.zza();
        }
        zza(zzao, zzn2);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzao zzao, zzn zzn2) {
        List<zzw> list;
        List<zzw> list2;
        List<zzw> list3;
        zzao zzao2 = zzao;
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn2.zza);
        zzw();
        zzk();
        String str = zzn2.zza;
        long j = zzao2.zzd;
        zzh();
        if (zzks.zza(zzao, zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            if (this.zzj.zzb().zze(str, zzaq.zzbb) && zzn2.zzu != null) {
                if (zzn2.zzu.contains(zzao2.zza)) {
                    Bundle zzb2 = zzao2.zzb.zzb();
                    zzb2.putLong("ga_safelisted", 1);
                    zzao2 = new zzao(zzao2.zza, new zzan(zzb2), zzao2.zzc, zzao2.zzd);
                } else {
                    this.zzj.zzr().zzw().zza("Dropping non-safelisted event. appId, event name, origin", str, zzao2.zza, zzao2.zzc);
                    return;
                }
            }
            zze().zzf();
            try {
                zzad zze2 = zze();
                Preconditions.checkNotEmpty(str);
                zze2.zzd();
                zze2.zzak();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zze2.zzr().zzi().zza("Invalid time querying timed out conditional properties", zzez.zza(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zze2.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzw zzw2 : list) {
                    if (zzw2 != null) {
                        this.zzj.zzr().zzx().zza("User property timed out", zzw2.zza, this.zzj.zzj().zzc(zzw2.zzc.zza), zzw2.zzc.zza());
                        if (zzw2.zzg != null) {
                            zzc(new zzao(zzw2.zzg, j), zzn2);
                        }
                        zze().zze(str, zzw2.zzc.zza);
                    }
                }
                zzad zze3 = zze();
                Preconditions.checkNotEmpty(str);
                zze3.zzd();
                zze3.zzak();
                if (i < 0) {
                    zze3.zzr().zzi().zza("Invalid time querying expired conditional properties", zzez.zza(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zze3.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzw zzw3 : list2) {
                    if (zzw3 != null) {
                        this.zzj.zzr().zzx().zza("User property expired", zzw3.zza, this.zzj.zzj().zzc(zzw3.zzc.zza), zzw3.zzc.zza());
                        zze().zzb(str, zzw3.zzc.zza);
                        if (zzw3.zzk != null) {
                            arrayList.add(zzw3.zzk);
                        }
                        zze().zze(str, zzw3.zzc.zza);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    zzc(new zzao((zzao) obj, j), zzn2);
                }
                zzad zze4 = zze();
                String str2 = zzao2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zze4.zzd();
                zze4.zzak();
                if (i < 0) {
                    zze4.zzr().zzi().zza("Invalid time querying triggered conditional properties", zzez.zza(str), zze4.zzo().zza(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zze4.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzw zzw4 : list3) {
                    if (zzw4 != null) {
                        zzkr zzkr = zzw4.zzc;
                        zzkt zzkt = new zzkt(zzw4.zza, zzw4.zzb, zzkr.zza, j, zzkr.zza());
                        if (zze().zza(zzkt)) {
                            this.zzj.zzr().zzx().zza("User property triggered", zzw4.zza, this.zzj.zzj().zzc(zzkt.zzc), zzkt.zze);
                        } else {
                            this.zzj.zzr().zzf().zza("Too many active user properties, ignoring", zzez.zza(zzw4.zza), this.zzj.zzj().zzc(zzkt.zzc), zzkt.zze);
                        }
                        if (zzw4.zzi != null) {
                            arrayList3.add(zzw4.zzi);
                        }
                        zzw4.zzc = new zzkr(zzkt);
                        zzw4.zze = true;
                        zze().zza(zzw4);
                    }
                }
                zzc(zzao2, zzn2);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList4.get(i3);
                    i3++;
                    zzc(new zzao((zzao) obj2, j), zzn2);
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0319  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(com.google.android.gms.measurement.internal.zzao r27, com.google.android.gms.measurement.internal.zzn r28) {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            r3 = r28
            java.lang.String r4 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r28)
            java.lang.String r5 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            long r5 = java.lang.System.nanoTime()
            r26.zzw()
            r26.zzk()
            java.lang.String r15 = r3.zza
            r26.zzh()
            boolean r7 = com.google.android.gms.measurement.internal.zzks.zza(r27, r28)
            if (r7 != 0) goto L_0x0026
            return
        L_0x0026:
            boolean r7 = r3.zzh
            if (r7 != 0) goto L_0x002e
            r1.zzc(r3)
            return
        L_0x002e:
            com.google.android.gms.measurement.internal.zzfx r7 = r26.zzc()
            java.lang.String r8 = r2.zza
            boolean r7 = r7.zzb(r15, r8)
            java.lang.String r14 = "_err"
            r13 = 0
            if (r7 == 0) goto L_0x00d9
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzi()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza(r15)
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzj
            com.google.android.gms.measurement.internal.zzex r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zza(r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfx r3 = r26.zzc()
            boolean r3 = r3.zzg(r15)
            if (r3 != 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzfx r3 = r26.zzc()
            boolean r3 = r3.zzh(r15)
            if (r3 == 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            r3 = 0
            goto L_0x0074
        L_0x0073:
            r3 = 1
        L_0x0074:
            if (r3 != 0) goto L_0x008f
            java.lang.String r4 = r2.zza
            boolean r4 = r14.equals(r4)
            if (r4 != 0) goto L_0x008f
            com.google.android.gms.measurement.internal.zzgd r4 = r1.zzj
            com.google.android.gms.measurement.internal.zzkw r7 = r4.zzi()
            r9 = 11
            java.lang.String r11 = r2.zza
            r12 = 0
            java.lang.String r10 = "_ev"
            r8 = r15
            r7.zza(r8, r9, r10, r11, r12)
        L_0x008f:
            if (r3 == 0) goto L_0x00d8
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            com.google.android.gms.measurement.internal.zzf r2 = r2.zzb(r15)
            if (r2 == 0) goto L_0x00d8
            long r3 = r2.zzu()
            long r5 = r2.zzt()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzj
            com.google.android.gms.common.util.Clock r5 = r5.zzm()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzaq.zzy
            java.lang.Object r5 = r5.zza(r13)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00d8
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzw()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zza(r4)
            r1.zza(r2)
        L_0x00d8:
            return
        L_0x00d9:
            boolean r7 = com.google.android.gms.internal.measurement.zzmd.zzb()
            if (r7 == 0) goto L_0x0108
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzaq.zzcj
            boolean r7 = r7.zza(r8)
            if (r7 == 0) goto L_0x0108
            com.google.android.gms.measurement.internal.zzfd r2 = com.google.android.gms.measurement.internal.zzfd.zza(r27)
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzi()
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r8 = r8.zzb()
            int r8 = r8.zza(r15)
            r7.zza(r2, r8)
            com.google.android.gms.measurement.internal.zzao r2 = r2.zza()
        L_0x0108:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()
            r8 = 2
            boolean r7 = r7.zza(r8)
            if (r7 == 0) goto L_0x012e
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzx()
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzj
            com.google.android.gms.measurement.internal.zzex r9 = r9.zzj()
            java.lang.String r9 = r9.zza(r2)
            java.lang.String r10 = "Logging event"
            r7.zza(r10, r9)
        L_0x012e:
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()
            r7.zzf()
            r1.zzc(r3)     // Catch:{ all -> 0x0945 }
            boolean r7 = com.google.android.gms.internal.measurement.zzmo.zzb()     // Catch:{ all -> 0x0945 }
            if (r7 == 0) goto L_0x014e
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj     // Catch:{ all -> 0x0945 }
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()     // Catch:{ all -> 0x0945 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzaq.zzci     // Catch:{ all -> 0x0945 }
            boolean r7 = r7.zza(r9)     // Catch:{ all -> 0x0945 }
            if (r7 == 0) goto L_0x014e
            r7 = 1
            goto L_0x014f
        L_0x014e:
            r7 = 0
        L_0x014f:
            java.lang.String r9 = "ecommerce_purchase"
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x0945 }
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0945 }
            java.lang.String r10 = "refund"
            if (r9 != 0) goto L_0x0172
            if (r7 == 0) goto L_0x0170
            java.lang.String r7 = "purchase"
            java.lang.String r9 = r2.zza
            boolean r7 = r7.equals(r9)
            if (r7 != 0) goto L_0x0172
            java.lang.String r7 = r2.zza
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x0170
            goto L_0x0172
        L_0x0170:
            r7 = 0
            goto L_0x0173
        L_0x0172:
            r7 = 1
        L_0x0173:
            java.lang.String r9 = "_iap"
            java.lang.String r11 = r2.zza
            boolean r9 = r9.equals(r11)
            if (r9 != 0) goto L_0x0182
            if (r7 == 0) goto L_0x0180
            goto L_0x0182
        L_0x0180:
            r9 = 0
            goto L_0x0183
        L_0x0182:
            r9 = 1
        L_0x0183:
            if (r9 == 0) goto L_0x0328
            com.google.android.gms.measurement.internal.zzan r9 = r2.zzb
            java.lang.String r11 = "currency"
            java.lang.String r9 = r9.zzd(r11)
            java.lang.String r11 = "value"
            if (r7 == 0) goto L_0x0201
            com.google.android.gms.measurement.internal.zzan r7 = r2.zzb
            java.lang.Double r7 = r7.zzc(r11)
            double r17 = r7.doubleValue()
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r7 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r7 != 0) goto L_0x01b6
            com.google.android.gms.measurement.internal.zzan r7 = r2.zzb
            java.lang.Long r7 = r7.zzb(r11)
            long r12 = r7.longValue()
            double r11 = (double) r12
            double r17 = r11 * r19
        L_0x01b6:
            r11 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r7 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r7 > 0) goto L_0x01e4
            r11 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r7 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r7 < 0) goto L_0x01e4
            long r11 = java.lang.Math.round(r17)
            boolean r7 = com.google.android.gms.internal.measurement.zzmo.zzb()
            if (r7 == 0) goto L_0x020b
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzaq.zzci
            boolean r7 = r7.zza(r13)
            if (r7 == 0) goto L_0x020b
            java.lang.String r7 = r2.zza
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x020b
            long r11 = -r11
            goto L_0x020b
        L_0x01e4:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzi()
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzez.zza(r15)
            java.lang.Double r10 = java.lang.Double.valueOf(r17)
            r7.zza(r8, r9, r10)
            r23 = r5
            r5 = 0
            r11 = 0
            goto L_0x0317
        L_0x0201:
            com.google.android.gms.measurement.internal.zzan r7 = r2.zzb
            java.lang.Long r7 = r7.zzb(r11)
            long r11 = r7.longValue()
        L_0x020b:
            boolean r7 = android.text.TextUtils.isEmpty(r9)
            if (r7 != 0) goto L_0x0313
            java.util.Locale r7 = java.util.Locale.US
            java.lang.String r7 = r9.toUpperCase(r7)
            java.lang.String r9 = "[A-Z]{3}"
            boolean r9 = r7.matches(r9)
            if (r9 == 0) goto L_0x0313
            java.lang.String r9 = "_ltv_"
            java.lang.String r7 = java.lang.String.valueOf(r7)
            int r10 = r7.length()
            if (r10 == 0) goto L_0x0230
            java.lang.String r7 = r9.concat(r7)
            goto L_0x0235
        L_0x0230:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r9)
        L_0x0235:
            r10 = r7
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()
            com.google.android.gms.measurement.internal.zzkt r7 = r7.zzc(r15, r10)
            if (r7 == 0) goto L_0x0271
            java.lang.Object r9 = r7.zze
            boolean r9 = r9 instanceof java.lang.Long
            if (r9 != 0) goto L_0x0247
            goto L_0x0271
        L_0x0247:
            java.lang.Object r7 = r7.zze
            java.lang.Long r7 = (java.lang.Long) r7
            long r7 = r7.longValue()
            com.google.android.gms.measurement.internal.zzkt r17 = new com.google.android.gms.measurement.internal.zzkt
            java.lang.String r9 = r2.zzc
            com.google.android.gms.measurement.internal.zzgd r13 = r1.zzj
            com.google.android.gms.common.util.Clock r13 = r13.zzm()
            long r18 = r13.currentTimeMillis()
            long r7 = r7 + r11
            java.lang.Long r13 = java.lang.Long.valueOf(r7)
            r7 = r17
            r8 = r15
            r23 = r5
            r5 = 0
            r6 = 1
            r11 = r18
            r7.<init>(r8, r9, r10, r11, r13)
        L_0x026e:
            r6 = r17
            goto L_0x02d8
        L_0x0271:
            r23 = r5
            r5 = 0
            r6 = 1
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r9 = r9.zzb()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r13 = com.google.android.gms.measurement.internal.zzaq.zzad
            int r9 = r9.zzb(r15, r13)
            int r9 = r9 - r6
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)
            r7.zzd()
            r7.zzak()
            android.database.sqlite.SQLiteDatabase r13 = r7.c_()     // Catch:{ SQLiteException -> 0x02aa }
            java.lang.String r8 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r6 = 3
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x02aa }
            r6[r5] = r15     // Catch:{ SQLiteException -> 0x02aa }
            r16 = 1
            r6[r16] = r15     // Catch:{ SQLiteException -> 0x02aa }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x02aa }
            r16 = 2
            r6[r16] = r9     // Catch:{ SQLiteException -> 0x02aa }
            r13.execSQL(r8, r6)     // Catch:{ SQLiteException -> 0x02aa }
            goto L_0x02bd
        L_0x02aa:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzf()
            java.lang.String r8 = "Error pruning currencies. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzez.zza(r15)
            r7.zza(r8, r9, r6)
        L_0x02bd:
            com.google.android.gms.measurement.internal.zzkt r17 = new com.google.android.gms.measurement.internal.zzkt
            java.lang.String r9 = r2.zzc
            com.google.android.gms.measurement.internal.zzgd r6 = r1.zzj
            com.google.android.gms.common.util.Clock r6 = r6.zzm()
            long r18 = r6.currentTimeMillis()
            java.lang.Long r13 = java.lang.Long.valueOf(r11)
            r7 = r17
            r8 = r15
            r11 = r18
            r7.<init>(r8, r9, r10, r11, r13)
            goto L_0x026e
        L_0x02d8:
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()
            boolean r7 = r7.zza(r6)
            if (r7 != 0) goto L_0x0316
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzf()
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzez.zza(r15)
            com.google.android.gms.measurement.internal.zzgd r10 = r1.zzj
            com.google.android.gms.measurement.internal.zzex r10 = r10.zzj()
            java.lang.String r11 = r6.zzc
            java.lang.String r10 = r10.zzc(r11)
            java.lang.Object r6 = r6.zze
            r7.zza(r8, r9, r10, r6)
            com.google.android.gms.measurement.internal.zzgd r6 = r1.zzj
            com.google.android.gms.measurement.internal.zzkw r7 = r6.zzi()
            r9 = 9
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r15
            r7.zza(r8, r9, r10, r11, r12)
            goto L_0x0316
        L_0x0313:
            r23 = r5
            r5 = 0
        L_0x0316:
            r11 = 1
        L_0x0317:
            if (r11 != 0) goto L_0x032b
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.b_()
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.zzh()
            return
        L_0x0328:
            r23 = r5
            r5 = 0
        L_0x032b:
            java.lang.String r6 = r2.zza
            boolean r6 = com.google.android.gms.measurement.internal.zzkw.zza(r6)
            java.lang.String r7 = r2.zza
            boolean r18 = r14.equals(r7)
            boolean r7 = com.google.android.gms.internal.measurement.zzmo.zzb()
            r19 = 1
            if (r7 == 0) goto L_0x035e
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()
            java.lang.String r8 = r3.zza
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzaq.zzce
            boolean r7 = r7.zze(r8, r9)
            if (r7 == 0) goto L_0x035e
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            r7.zzi()
            com.google.android.gms.measurement.internal.zzan r7 = r2.zzb
            long r7 = com.google.android.gms.measurement.internal.zzkw.zza(r7)
            long r7 = r7 + r19
            r11 = r7
            goto L_0x0360
        L_0x035e:
            r11 = r19
        L_0x0360:
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()
            long r8 = r26.zzx()
            r13 = 1
            r16 = 0
            r17 = 0
            r10 = r15
            r14 = r6
            r27 = r15
            r15 = r16
            r16 = r18
            com.google.android.gms.measurement.internal.zzac r7 = r7.zza(r8, r10, r11, r13, r14, r15, r16, r17)
            long r8 = r7.zzb
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzaq.zzj
            r14 = 0
            java.lang.Object r10 = r10.zza(r14)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            long r10 = (long) r10
            long r8 = r8 - r10
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 0
            int r15 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r15 <= 0) goto L_0x03bf
            long r8 = r8 % r10
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x03b0
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza(r27)
            long r5 = r7.zzb
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r2.zza(r3, r4, r5)
        L_0x03b0:
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.b_()
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.zzh()
            return
        L_0x03bf:
            if (r6 == 0) goto L_0x0414
            long r8 = r7.zza
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r15 = com.google.android.gms.measurement.internal.zzaq.zzl
            java.lang.Object r15 = r15.zza(r14)
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            long r14 = (long) r15
            long r8 = r8 - r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x0414
            long r8 = r8 % r10
            int r3 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x03f3
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza(r27)
            long r6 = r7.zza
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r3.zza(r4, r5, r6)
        L_0x03f3:
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzkw r7 = r3.zzi()
            r9 = 16
            java.lang.String r10 = "_ev"
            java.lang.String r11 = r2.zza
            r12 = 0
            r8 = r27
            r7.zza(r8, r9, r10, r11, r12)
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.b_()
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.zzh()
            return
        L_0x0414:
            if (r18 == 0) goto L_0x0463
            long r8 = r7.zzd
            com.google.android.gms.measurement.internal.zzgd r10 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r10 = r10.zzb()
            java.lang.String r11 = r3.zza
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzaq.zzk
            int r10 = r10.zzb(r11, r14)
            r11 = 1000000(0xf4240, float:1.401298E-39)
            int r10 = java.lang.Math.min(r11, r10)
            int r10 = java.lang.Math.max(r5, r10)
            long r10 = (long) r10
            long r8 = r8 - r10
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0463
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x0454
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza(r27)
            long r5 = r7.zzd
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r2.zza(r3, r4, r5)
        L_0x0454:
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.b_()
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.zzh()
            return
        L_0x0463:
            com.google.android.gms.measurement.internal.zzan r7 = r2.zzb
            android.os.Bundle r14 = r7.zzb()
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzi()
            java.lang.String r8 = "_o"
            java.lang.String r9 = r2.zzc
            r7.zza(r14, r8, r9)
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzi()
            r15 = r27
            boolean r7 = r7.zzf(r15)
            java.lang.String r11 = "_r"
            if (r7 == 0) goto L_0x04a2
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzi()
            java.lang.String r8 = "_dbg"
            java.lang.Long r9 = java.lang.Long.valueOf(r19)
            r7.zza(r14, r8, r9)
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzi()
            java.lang.Long r8 = java.lang.Long.valueOf(r19)
            r7.zza(r14, r11, r8)
        L_0x04a2:
            java.lang.String r7 = "_s"
            java.lang.String r8 = r2.zza
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x04c9
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()
            java.lang.String r8 = r3.zza
            com.google.android.gms.measurement.internal.zzkt r7 = r7.zzc(r8, r4)
            if (r7 == 0) goto L_0x04c9
            java.lang.Object r8 = r7.zze
            boolean r8 = r8 instanceof java.lang.Long
            if (r8 == 0) goto L_0x04c9
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzkw r8 = r8.zzi()
            java.lang.Object r7 = r7.zze
            r8.zza(r14, r4, r7)
        L_0x04c9:
            com.google.android.gms.measurement.internal.zzad r4 = r26.zze()
            long r7 = r4.zzc(r15)
            int r4 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x04ec
            com.google.android.gms.measurement.internal.zzgd r4 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzr()
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzi()
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzez.zza(r15)
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r4.zza(r9, r10, r7)
        L_0x04ec:
            com.google.android.gms.measurement.internal.zzal r4 = new com.google.android.gms.measurement.internal.zzal
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj
            java.lang.String r9 = r2.zzc
            java.lang.String r10 = r2.zza
            long r12 = r2.zzd
            r18 = 0
            r7 = r4
            r2 = r10
            r10 = r15
            r5 = r11
            r11 = r2
            r16 = r14
            r2 = r15
            r25 = 0
            r14 = r18
            r7.<init>(r8, r9, r10, r11, r12, r14, r16)
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()
            java.lang.String r8 = r4.zzb
            com.google.android.gms.measurement.internal.zzak r7 = r7.zza(r2, r8)
            if (r7 != 0) goto L_0x058a
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()
            long r7 = r7.zzh(r2)
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r9 = r9.zzb()
            int r9 = r9.zzb(r2)
            long r9 = (long) r9
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x0570
            if (r6 == 0) goto L_0x0570
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()
            java.lang.String r5 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzez.zza(r2)
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzex r7 = r7.zzj()
            java.lang.String r4 = r4.zzb
            java.lang.String r4 = r7.zza(r4)
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()
            int r7 = r7.zzb(r2)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r3.zza(r5, r6, r4, r7)
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzkw r7 = r3.zzi()
            r9 = 8
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r2
            r7.zza(r8, r9, r10, r11, r12)
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.zzh()
            return
        L_0x0570:
            com.google.android.gms.measurement.internal.zzak r6 = new com.google.android.gms.measurement.internal.zzak
            java.lang.String r9 = r4.zzb
            r10 = 0
            r12 = 0
            long r14 = r4.zzc
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r7 = r6
            r8 = r2
            r7.<init>(r8, r9, r10, r12, r14, r16, r18, r19, r20, r21)
            goto L_0x0598
        L_0x058a:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            long r8 = r7.zzf
            com.google.android.gms.measurement.internal.zzal r4 = r4.zza(r2, r8)
            long r8 = r4.zzc
            com.google.android.gms.measurement.internal.zzak r6 = r7.zza(r8)
        L_0x0598:
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.zza(r6)
            r26.zzw()
            r26.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r28)
            java.lang.String r2 = r4.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)
            java.lang.String r2 = r4.zza
            java.lang.String r6 = r3.zza
            boolean r2 = r2.equals(r6)
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r2 = com.google.android.gms.internal.measurement.zzcc.zzg.zzbf()
            r6 = 1
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r2 = r2.zza(r6)
            java.lang.String r7 = "android"
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r2 = r2.zza(r7)
            java.lang.String r7 = r3.zza
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x05d7
            java.lang.String r7 = r3.zza
            r2.zzf(r7)
        L_0x05d7:
            java.lang.String r7 = r3.zzd
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x05e4
            java.lang.String r7 = r3.zzd
            r2.zze(r7)
        L_0x05e4:
            java.lang.String r7 = r3.zzc
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x05f1
            java.lang.String r7 = r3.zzc
            r2.zzg(r7)
        L_0x05f1:
            long r7 = r3.zzj
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0600
            long r7 = r3.zzj
            int r8 = (int) r7
            r2.zzh(r8)
        L_0x0600:
            long r7 = r3.zze
            r2.zzf(r7)
            java.lang.String r7 = r3.zzb
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0612
            java.lang.String r7 = r3.zzb
            r2.zzk(r7)
        L_0x0612:
            boolean r7 = com.google.android.gms.internal.measurement.zzoe.zzb()
            if (r7 == 0) goto L_0x0661
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()
            java.lang.String r8 = r3.zza
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzaq.zzbn
            boolean r7 = r7.zze(r8, r9)
            if (r7 == 0) goto L_0x0661
            java.lang.String r7 = r2.zzl()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x063f
            java.lang.String r7 = r3.zzv
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x063f
            java.lang.String r7 = r3.zzv
            r2.zzp(r7)
        L_0x063f:
            java.lang.String r7 = r2.zzl()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0678
            java.lang.String r7 = r2.zzo()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0678
            java.lang.String r7 = r3.zzr
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0678
            java.lang.String r7 = r3.zzr
            r2.zzo(r7)
            goto L_0x0678
        L_0x0661:
            java.lang.String r7 = r2.zzl()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0678
            java.lang.String r7 = r3.zzr
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0678
            java.lang.String r7 = r3.zzr
            r2.zzo(r7)
        L_0x0678:
            long r7 = r3.zzf
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0685
            long r7 = r3.zzf
            r2.zzh(r7)
        L_0x0685:
            long r7 = r3.zzt
            r2.zzk(r7)
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()
            java.lang.String r8 = r3.zza
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzaq.zzaw
            boolean r7 = r7.zze(r8, r11)
            if (r7 == 0) goto L_0x06a7
            com.google.android.gms.measurement.internal.zzks r7 = r26.zzh()
            java.util.List r7 = r7.zzf()
            if (r7 == 0) goto L_0x06a7
            r2.zzd(r7)
        L_0x06a7:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzfl r7 = r7.zzc()
            java.lang.String r8 = r3.zza
            android.util.Pair r7 = r7.zza(r8)
            if (r7 == 0) goto L_0x06da
            java.lang.Object r8 = r7.first
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x06da
            boolean r8 = r3.zzo
            if (r8 == 0) goto L_0x073c
            java.lang.Object r8 = r7.first
            java.lang.String r8 = (java.lang.String) r8
            r2.zzh(r8)
            java.lang.Object r8 = r7.second
            if (r8 == 0) goto L_0x073c
            java.lang.Object r7 = r7.second
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r2.zza(r7)
            goto L_0x073c
        L_0x06da:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzai r7 = r7.zzx()
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj
            android.content.Context r8 = r8.zzn()
            boolean r7 = r7.zza(r8)
            if (r7 != 0) goto L_0x073c
            boolean r7 = r3.zzp
            if (r7 == 0) goto L_0x073c
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            android.content.Context r7 = r7.zzn()
            android.content.ContentResolver r7 = r7.getContentResolver()
            java.lang.String r8 = "android_id"
            java.lang.String r7 = android.provider.Settings.Secure.getString(r7, r8)
            if (r7 != 0) goto L_0x071c
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzi()
            java.lang.String r8 = "null secure ID. appId"
            java.lang.String r11 = r2.zzj()
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzez.zza(r11)
            r7.zza(r8, r11)
            java.lang.String r7 = "null"
            goto L_0x0739
        L_0x071c:
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x0739
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzr()
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzi()
            java.lang.String r11 = "empty secure ID. appId"
            java.lang.String r12 = r2.zzj()
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzez.zza(r12)
            r8.zza(r11, r12)
        L_0x0739:
            r2.zzm(r7)
        L_0x073c:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzai r7 = r7.zzx()
            r7.zzaa()
            java.lang.String r7 = android.os.Build.MODEL
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r7 = r2.zzc(r7)
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzai r8 = r8.zzx()
            r8.zzaa()
            java.lang.String r8 = android.os.Build.VERSION.RELEASE
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r7 = r7.zzb(r8)
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzai r8 = r8.zzx()
            long r11 = r8.zzf()
            int r8 = (int) r11
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r7 = r7.zzf(r8)
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzai r8 = r8.zzx()
            java.lang.String r8 = r8.zzg()
            r7.zzd(r8)
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzaq.zzcl
            boolean r7 = r7.zza(r8)
            if (r7 != 0) goto L_0x0789
            long r7 = r3.zzl
            r2.zzj(r7)
        L_0x0789:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            boolean r7 = r7.zzab()
            if (r7 == 0) goto L_0x079f
            r2.zzj()
            boolean r7 = android.text.TextUtils.isEmpty(r25)
            if (r7 != 0) goto L_0x079f
            r7 = r25
            r2.zzn(r7)
        L_0x079f:
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()
            java.lang.String r8 = r3.zza
            com.google.android.gms.measurement.internal.zzf r7 = r7.zzb(r8)
            if (r7 != 0) goto L_0x0820
            com.google.android.gms.measurement.internal.zzf r7 = new com.google.android.gms.measurement.internal.zzf
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj
            java.lang.String r11 = r3.zza
            r7.<init>(r8, r11)
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzkw r8 = r8.zzi()
            java.lang.String r8 = r8.zzk()
            r7.zza(r8)
            java.lang.String r8 = r3.zzk
            r7.zzf(r8)
            java.lang.String r8 = r3.zzb
            r7.zzb(r8)
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzfl r8 = r8.zzc()
            java.lang.String r11 = r3.zza
            java.lang.String r8 = r8.zzb(r11)
            r7.zze(r8)
            r7.zzg(r9)
            r7.zza(r9)
            r7.zzb(r9)
            java.lang.String r8 = r3.zzc
            r7.zzg(r8)
            long r11 = r3.zzj
            r7.zzc(r11)
            java.lang.String r8 = r3.zzd
            r7.zzh(r8)
            long r11 = r3.zze
            r7.zzd(r11)
            long r11 = r3.zzf
            r7.zze(r11)
            boolean r8 = r3.zzh
            r7.zza(r8)
            com.google.android.gms.measurement.internal.zzgd r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r8 = r8.zzb()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzaq.zzcl
            boolean r8 = r8.zza(r11)
            if (r8 != 0) goto L_0x0814
            long r11 = r3.zzl
            r7.zzp(r11)
        L_0x0814:
            long r11 = r3.zzt
            r7.zzf(r11)
            com.google.android.gms.measurement.internal.zzad r8 = r26.zze()
            r8.zza(r7)
        L_0x0820:
            java.lang.String r8 = r7.zzd()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0831
            java.lang.String r8 = r7.zzd()
            r2.zzi(r8)
        L_0x0831:
            java.lang.String r8 = r7.zzi()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0842
            java.lang.String r7 = r7.zzi()
            r2.zzl(r7)
        L_0x0842:
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()
            java.lang.String r3 = r3.zza
            java.util.List r3 = r7.zza(r3)
            r11 = 0
        L_0x084d:
            int r7 = r3.size()
            if (r11 >= r7) goto L_0x0884
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r7 = com.google.android.gms.internal.measurement.zzcc.zzk.zzj()
            java.lang.Object r8 = r3.get(r11)
            com.google.android.gms.measurement.internal.zzkt r8 = (com.google.android.gms.measurement.internal.zzkt) r8
            java.lang.String r8 = r8.zzc
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r7 = r7.zza(r8)
            java.lang.Object r8 = r3.get(r11)
            com.google.android.gms.measurement.internal.zzkt r8 = (com.google.android.gms.measurement.internal.zzkt) r8
            long r12 = r8.zzd
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r7 = r7.zza(r12)
            com.google.android.gms.measurement.internal.zzks r8 = r26.zzh()
            java.lang.Object r12 = r3.get(r11)
            com.google.android.gms.measurement.internal.zzkt r12 = (com.google.android.gms.measurement.internal.zzkt) r12
            java.lang.Object r12 = r12.zze
            r8.zza(r7, r12)
            r2.zza(r7)
            int r11 = r11 + 1
            goto L_0x084d
        L_0x0884:
            com.google.android.gms.measurement.internal.zzad r3 = r26.zze()     // Catch:{ IOException -> 0x08f9 }
            com.google.android.gms.internal.measurement.zzjj r7 = r2.zzv()     // Catch:{ IOException -> 0x08f9 }
            com.google.android.gms.internal.measurement.zzib r7 = (com.google.android.gms.internal.measurement.zzib) r7     // Catch:{ IOException -> 0x08f9 }
            com.google.android.gms.internal.measurement.zzcc$zzg r7 = (com.google.android.gms.internal.measurement.zzcc.zzg) r7     // Catch:{ IOException -> 0x08f9 }
            long r2 = r3.zza(r7)     // Catch:{ IOException -> 0x08f9 }
            com.google.android.gms.measurement.internal.zzad r7 = r26.zze()
            com.google.android.gms.measurement.internal.zzan r8 = r4.zze
            if (r8 == 0) goto L_0x08ef
            com.google.android.gms.measurement.internal.zzan r8 = r4.zze
            java.util.Iterator r8 = r8.iterator()
        L_0x08a2:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x08b6
            java.lang.Object r11 = r8.next()
            java.lang.String r11 = (java.lang.String) r11
            boolean r11 = r5.equals(r11)
            if (r11 == 0) goto L_0x08a2
        L_0x08b4:
            r11 = 1
            goto L_0x08f0
        L_0x08b6:
            com.google.android.gms.measurement.internal.zzfx r5 = r26.zzc()
            java.lang.String r8 = r4.zza
            java.lang.String r11 = r4.zzb
            boolean r5 = r5.zzc(r8, r11)
            com.google.android.gms.measurement.internal.zzad r11 = r26.zze()
            long r12 = r26.zzx()
            java.lang.String r14 = r4.zza
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            com.google.android.gms.measurement.internal.zzac r8 = r11.zza(r12, r14, r15, r16, r17, r18, r19)
            if (r5 == 0) goto L_0x08ef
            long r11 = r8.zze
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r5 = r5.zzb()
            java.lang.String r8 = r4.zza
            int r5 = r5.zzc(r8)
            long r13 = (long) r5
            int r5 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x08ef
            goto L_0x08b4
        L_0x08ef:
            r11 = 0
        L_0x08f0:
            boolean r2 = r7.zza(r4, r2, r11)
            if (r2 == 0) goto L_0x0912
            r1.zzm = r9
            goto L_0x0912
        L_0x08f9:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzgd r4 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzr()
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzf()
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzj()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzez.zza(r2)
            r4.zza(r5, r2, r3)
        L_0x0912:
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.b_()
            com.google.android.gms.measurement.internal.zzad r2 = r26.zze()
            r2.zzh()
            r26.zzz()
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzx()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r23
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zza(r4, r3)
            return
        L_0x0945:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzad r3 = r26.zze()
            r3.zzh()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zzc(com.google.android.gms.measurement.internal.zzao, com.google.android.gms.measurement.internal.zzn):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzl() {
        zzf zzb2;
        String str;
        zzw();
        zzk();
        this.zzs = true;
        try {
            this.zzj.zzu();
            Boolean zzag = this.zzj.zzw().zzag();
            if (zzag == null) {
                this.zzj.zzr().zzi().zza("Upload data called on the client side before use of service was decided");
            } else if (zzag.booleanValue()) {
                this.zzj.zzr().zzf().zza("Upload called in the client side when service should be used");
                this.zzs = false;
                zzaa();
            } else if (this.zzm > 0) {
                zzz();
                this.zzs = false;
                zzaa();
            } else {
                zzw();
                if (this.zzv != null) {
                    this.zzj.zzr().zzx().zza("Uploading requested multiple times");
                    this.zzs = false;
                    zzaa();
                } else if (!zzd().zzf()) {
                    this.zzj.zzr().zzx().zza("Network not connected, ignoring upload request");
                    zzz();
                    this.zzs = false;
                    zzaa();
                } else {
                    long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
                    int zzb3 = this.zzj.zzb().zzb(null, zzaq.zzap);
                    long zzv2 = currentTimeMillis - zzy.zzv();
                    for (int i = 0; i < zzb3 && zza((String) null, zzv2); i++) {
                    }
                    long zza2 = this.zzj.zzc().zzc.zza();
                    if (zza2 != 0) {
                        this.zzj.zzr().zzw().zza("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza2)));
                    }
                    String d_ = zze().d_();
                    if (!TextUtils.isEmpty(d_)) {
                        if (this.zzx == -1) {
                            this.zzx = zze().zzaa();
                        }
                        List<Pair<zzcc.zzg, Long>> zza3 = zze().zza(d_, this.zzj.zzb().zzb(d_, zzaq.zzf), Math.max(0, this.zzj.zzb().zzb(d_, zzaq.zzg)));
                        if (!zza3.isEmpty()) {
                            Iterator<Pair<zzcc.zzg, Long>> it2 = zza3.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    str = null;
                                    break;
                                }
                                zzcc.zzg zzg2 = (zzcc.zzg) it2.next().first;
                                if (!TextUtils.isEmpty(zzg2.zzad())) {
                                    str = zzg2.zzad();
                                    break;
                                }
                            }
                            if (str != null) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= zza3.size()) {
                                        break;
                                    }
                                    zzcc.zzg zzg3 = (zzcc.zzg) zza3.get(i2).first;
                                    if (!TextUtils.isEmpty(zzg3.zzad()) && !zzg3.zzad().equals(str)) {
                                        zza3 = zza3.subList(0, i2);
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            zzcc.zzf.zza zzb4 = zzcc.zzf.zzb();
                            int size = zza3.size();
                            ArrayList arrayList = new ArrayList(zza3.size());
                            boolean zzg4 = this.zzj.zzb().zzg(d_);
                            for (int i3 = 0; i3 < size; i3++) {
                                zzcc.zzg.zza zza4 = (zzcc.zzg.zza) ((zzcc.zzg) zza3.get(i3).first).zzbl();
                                arrayList.add((Long) zza3.get(i3).second);
                                zzcc.zzg.zza zza5 = zza4.zzg(this.zzj.zzb().zzf()).zza(currentTimeMillis);
                                this.zzj.zzu();
                                zza5.zzb(false);
                                if (!zzg4) {
                                    zza4.zzn();
                                }
                                if (this.zzj.zzb().zze(d_, zzaq.zzay)) {
                                    zza4.zzl(zzh().zza(((zzcc.zzg) ((zzib) zza4.zzv())).zzbi()));
                                }
                                zzb4.zza(zza4);
                            }
                            String zza6 = this.zzj.zzr().zza(2) ? zzh().zza((zzcc.zzf) ((zzib) zzb4.zzv())) : null;
                            zzh();
                            byte[] zzbi = ((zzcc.zzf) ((zzib) zzb4.zzv())).zzbi();
                            String zza7 = zzaq.zzp.zza(null);
                            try {
                                URL url = new URL(zza7);
                                Preconditions.checkArgument(!arrayList.isEmpty());
                                if (this.zzv != null) {
                                    this.zzj.zzr().zzf().zza("Set uploading progress before finishing the previous upload");
                                } else {
                                    this.zzv = new ArrayList(arrayList);
                                }
                                this.zzj.zzc().zzd.zza(currentTimeMillis);
                                String str2 = "?";
                                if (size > 0) {
                                    str2 = zzb4.zza(0).zzx();
                                }
                                this.zzj.zzr().zzx().zza("Uploading data. app, uncompressed size, data", str2, Integer.valueOf(zzbi.length), zza6);
                                this.zzr = true;
                                zzfc zzd2 = zzd();
                                zzkm zzkm = new zzkm(this, d_);
                                zzd2.zzd();
                                zzd2.zzak();
                                Preconditions.checkNotNull(url);
                                Preconditions.checkNotNull(zzbi);
                                Preconditions.checkNotNull(zzkm);
                                zzd2.zzq().zzb(new zzfg(zzd2, d_, url, zzbi, null, zzkm));
                            } catch (MalformedURLException unused) {
                                this.zzj.zzr().zzf().zza("Failed to parse upload URL. Not uploading. appId", zzez.zza(d_), zza7);
                            }
                        }
                    } else {
                        this.zzx = -1;
                        String zza8 = zze().zza(currentTimeMillis - zzy.zzv());
                        if (!TextUtils.isEmpty(zza8) && (zzb2 = zze().zzb(zza8)) != null) {
                            zza(zzb2);
                        }
                    }
                    this.zzs = false;
                    zzaa();
                }
            }
        } finally {
            this.zzs = false;
            zzaa();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x03a7  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x05af  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0687  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0822  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x083e  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x0858  */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x0b9b  */
    /* JADX WARNING: Removed duplicated region for block: B:399:0x0bae  */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x0bb1  */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x0bd8  */
    /* JADX WARNING: Removed duplicated region for block: B:512:0x0f41  */
    /* JADX WARNING: Removed duplicated region for block: B:517:0x0f58  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0266  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(java.lang.String r44, long r45) {
        /*
            r43 = this;
            r1 = r43
            java.lang.String r2 = "_npa"
            java.lang.String r3 = ""
            com.google.android.gms.measurement.internal.zzad r4 = r43.zze()
            r4.zzf()
            com.google.android.gms.measurement.internal.zzkk$zza r4 = new com.google.android.gms.measurement.internal.zzkk$zza     // Catch:{ all -> 0x0f5e }
            r5 = 0
            r4.<init>(r1, r5)     // Catch:{ all -> 0x0f5e }
            com.google.android.gms.measurement.internal.zzad r6 = r43.zze()     // Catch:{ all -> 0x0f5e }
            long r7 = r1.zzx     // Catch:{ all -> 0x0f5e }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0f5e }
            r6.zzd()     // Catch:{ all -> 0x0f5e }
            r6.zzak()     // Catch:{ all -> 0x0f5e }
            r10 = -1
            r12 = 2
            r13 = 0
            r14 = 1
            android.database.sqlite.SQLiteDatabase r15 = r6.c_()     // Catch:{ SQLiteException -> 0x023a, all -> 0x0234 }
            boolean r16 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteException -> 0x023a, all -> 0x0234 }
            if (r16 == 0) goto L_0x0095
            int r16 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r16 == 0) goto L_0x0049
            java.lang.String[] r9 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0044 }
            java.lang.String r17 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0044 }
            r9[r13] = r17     // Catch:{ SQLiteException -> 0x0044 }
            java.lang.String r17 = java.lang.String.valueOf(r45)     // Catch:{ SQLiteException -> 0x0044 }
            r9[r14] = r17     // Catch:{ SQLiteException -> 0x0044 }
            goto L_0x0051
        L_0x0044:
            r0 = move-exception
            r7 = r0
            r9 = r5
            goto L_0x023e
        L_0x0049:
            java.lang.String[] r9 = new java.lang.String[r14]
            java.lang.String r17 = java.lang.String.valueOf(r45)
            r9[r13] = r17
        L_0x0051:
            if (r16 == 0) goto L_0x0058
            java.lang.String r16 = "rowid <= ? and "
            r45 = r16
            goto L_0x005a
        L_0x0058:
            r45 = r3
        L_0x005a:
            int r5 = r45.length()
            int r5 = r5 + 148
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r5)
            java.lang.String r5 = "select app_id, metadata_fingerprint from raw_events where "
            r12.append(r5)
            r5 = r45
            r12.append(r5)
            java.lang.String r5 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r12.append(r5)
            java.lang.String r5 = r12.toString()
            android.database.Cursor r5 = r15.rawQuery(r5, r9)
            boolean r9 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0231 }
            if (r9 != 0) goto L_0x0089
            if (r5 == 0) goto L_0x0254
            r5.close()
            goto L_0x0254
        L_0x0089:
            java.lang.String r9 = r5.getString(r13)
            java.lang.String r12 = r5.getString(r14)     // Catch:{ SQLiteException -> 0x022e }
            r5.close()     // Catch:{ SQLiteException -> 0x022e }
            goto L_0x00e6
        L_0x0095:
            int r5 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x00a6
            r9 = 2
            java.lang.String[] r12 = new java.lang.String[r9]
            r9 = 0
            r12[r13] = r9
            java.lang.String r9 = java.lang.String.valueOf(r7)
            r12[r14] = r9
            goto L_0x00ab
        L_0x00a6:
            r9 = 0
            java.lang.String[] r12 = new java.lang.String[]{r9}
        L_0x00ab:
            if (r5 == 0) goto L_0x00b0
            java.lang.String r5 = " and rowid <= ?"
            goto L_0x00b1
        L_0x00b0:
            r5 = r3
        L_0x00b1:
            int r9 = r5.length()
            int r9 = r9 + 84
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r9)
            java.lang.String r9 = "select metadata_fingerprint from raw_events where app_id = ?"
            r10.append(r9)
            r10.append(r5)
            java.lang.String r5 = " order by rowid limit 1;"
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            android.database.Cursor r5 = r15.rawQuery(r5, r12)
            boolean r9 = r5.moveToFirst()
            if (r9 != 0) goto L_0x00de
            if (r5 == 0) goto L_0x0254
            r5.close()
            goto L_0x0254
        L_0x00de:
            java.lang.String r12 = r5.getString(r13)
            r5.close()
            r9 = 0
        L_0x00e6:
            java.lang.String r16 = "raw_events_metadata"
            java.lang.String r10 = "metadata"
            java.lang.String[] r17 = new java.lang.String[]{r10}
            java.lang.String r18 = "app_id = ? and metadata_fingerprint = ?"
            r10 = 2
            java.lang.String[] r11 = new java.lang.String[r10]
            r11[r13] = r9
            r11[r14] = r12
            r20 = 0
            r21 = 0
            java.lang.String r22 = "rowid"
            java.lang.String r23 = "2"
            r10 = r15
            r15 = r10
            r19 = r11
            android.database.Cursor r5 = r15.query(r16, r17, r18, r19, r20, r21, r22, r23)
            boolean r11 = r5.moveToFirst()
            if (r11 != 0) goto L_0x0125
            com.google.android.gms.measurement.internal.zzez r7 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzf()
            java.lang.String r8 = "Raw event metadata record is missing. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzez.zza(r9)
            r7.zza(r8, r10)
            if (r5 == 0) goto L_0x0254
            r5.close()
            goto L_0x0254
        L_0x0125:
            byte[] r11 = r5.getBlob(r13)
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r15 = com.google.android.gms.internal.measurement.zzcc.zzg.zzbf()     // Catch:{ IOException -> 0x0215 }
            com.google.android.gms.internal.measurement.zzjm r11 = com.google.android.gms.measurement.internal.zzks.zza(r15, r11)     // Catch:{ IOException -> 0x0215 }
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r11 = (com.google.android.gms.internal.measurement.zzcc.zzg.zza) r11     // Catch:{ IOException -> 0x0215 }
            com.google.android.gms.internal.measurement.zzjj r11 = r11.zzv()     // Catch:{ IOException -> 0x0215 }
            com.google.android.gms.internal.measurement.zzib r11 = (com.google.android.gms.internal.measurement.zzib) r11     // Catch:{ IOException -> 0x0215 }
            com.google.android.gms.internal.measurement.zzcc$zzg r11 = (com.google.android.gms.internal.measurement.zzcc.zzg) r11     // Catch:{ IOException -> 0x0215 }
            boolean r15 = r5.moveToNext()
            if (r15 == 0) goto L_0x0152
            com.google.android.gms.measurement.internal.zzez r15 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfb r15 = r15.zzi()
            java.lang.String r14 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzez.zza(r9)
            r15.zza(r14, r13)
        L_0x0152:
            r5.close()
            r4.zza(r11)
            r13 = -1
            int r11 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r11 == 0) goto L_0x0175
            java.lang.String r11 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r13 = 3
            java.lang.String[] r14 = new java.lang.String[r13]
            r13 = 0
            r14[r13] = r9
            r13 = 1
            r14[r13] = r12
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r8 = 2
            r14[r8] = r7
            r18 = r11
            r19 = r14
            goto L_0x0184
        L_0x0175:
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ?"
            r8 = 2
            java.lang.String[] r11 = new java.lang.String[r8]
            r8 = 0
            r11[r8] = r9
            r8 = 1
            r11[r8] = r12
            r18 = r7
            r19 = r11
        L_0x0184:
            java.lang.String r16 = "raw_events"
            java.lang.String r7 = "rowid"
            java.lang.String r8 = "name"
            java.lang.String r11 = "timestamp"
            java.lang.String r12 = "data"
            java.lang.String[] r17 = new java.lang.String[]{r7, r8, r11, r12}
            r20 = 0
            r21 = 0
            java.lang.String r22 = "rowid"
            r23 = 0
            r15 = r10
            android.database.Cursor r5 = r15.query(r16, r17, r18, r19, r20, r21, r22, r23)
            boolean r7 = r5.moveToFirst()
            if (r7 != 0) goto L_0x01bd
            com.google.android.gms.measurement.internal.zzez r7 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzi()
            java.lang.String r8 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzez.zza(r9)
            r7.zza(r8, r10)
            if (r5 == 0) goto L_0x0254
            r5.close()
            goto L_0x0254
        L_0x01bd:
            r7 = 0
            long r10 = r5.getLong(r7)
            r7 = 3
            byte[] r8 = r5.getBlob(r7)
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r7 = com.google.android.gms.internal.measurement.zzcc.zzc.zzj()     // Catch:{ IOException -> 0x01f6 }
            com.google.android.gms.internal.measurement.zzjm r7 = com.google.android.gms.measurement.internal.zzks.zza(r7, r8)     // Catch:{ IOException -> 0x01f6 }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r7     // Catch:{ IOException -> 0x01f6 }
            r8 = 1
            java.lang.String r12 = r5.getString(r8)
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r8 = r7.zza(r12)
            r12 = 2
            long r13 = r5.getLong(r12)
            r8.zza(r13)
            com.google.android.gms.internal.measurement.zzjj r7 = r7.zzv()
            com.google.android.gms.internal.measurement.zzib r7 = (com.google.android.gms.internal.measurement.zzib) r7
            com.google.android.gms.internal.measurement.zzcc$zzc r7 = (com.google.android.gms.internal.measurement.zzcc.zzc) r7
            boolean r7 = r4.zza(r10, r7)
            if (r7 != 0) goto L_0x0209
            if (r5 == 0) goto L_0x0254
            r5.close()
            goto L_0x0254
        L_0x01f6:
            r0 = move-exception
            r7 = r0
            com.google.android.gms.measurement.internal.zzez r8 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzf()
            java.lang.String r10 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzez.zza(r9)
            r8.zza(r10, r11, r7)
        L_0x0209:
            boolean r7 = r5.moveToNext()
            if (r7 != 0) goto L_0x01bd
            if (r5 == 0) goto L_0x0254
            r5.close()
            goto L_0x0254
        L_0x0215:
            r0 = move-exception
            r7 = r0
            com.google.android.gms.measurement.internal.zzez r8 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzf()
            java.lang.String r10 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzez.zza(r9)
            r8.zza(r10, r11, r7)
            if (r5 == 0) goto L_0x0254
            r5.close()
            goto L_0x0254
        L_0x022e:
            r0 = move-exception
            r7 = r0
            goto L_0x023e
        L_0x0231:
            r0 = move-exception
            r7 = r0
            goto L_0x023d
        L_0x0234:
            r0 = move-exception
            r2 = r1
            r5 = 0
        L_0x0237:
            r1 = r0
            goto L_0x0f56
        L_0x023a:
            r0 = move-exception
            r7 = r0
            r5 = 0
        L_0x023d:
            r9 = 0
        L_0x023e:
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzr()     // Catch:{ all -> 0x0f52 }
            com.google.android.gms.measurement.internal.zzfb r6 = r6.zzf()     // Catch:{ all -> 0x0f52 }
            java.lang.String r8 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzez.zza(r9)     // Catch:{ all -> 0x0f52 }
            r6.zza(r8, r9, r7)     // Catch:{ all -> 0x0f52 }
            if (r5 == 0) goto L_0x0254
            r5.close()
        L_0x0254:
            java.util.List<com.google.android.gms.internal.measurement.zzcc$zzc> r5 = r4.zzc
            if (r5 == 0) goto L_0x0263
            java.util.List<com.google.android.gms.internal.measurement.zzcc$zzc> r5 = r4.zzc
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0261
            goto L_0x0263
        L_0x0261:
            r5 = 0
            goto L_0x0264
        L_0x0263:
            r5 = 1
        L_0x0264:
            if (r5 != 0) goto L_0x0f41
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r4.zza
            com.google.android.gms.internal.measurement.zzib$zza r5 = r5.zzbl()
            com.google.android.gms.internal.measurement.zzib$zza r5 = (com.google.android.gms.internal.measurement.zzib.zza) r5
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r5 = (com.google.android.gms.internal.measurement.zzcc.zzg.zza) r5
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r5 = r5.zzc()
            com.google.android.gms.measurement.internal.zzgd r6 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r6 = r6.zzb()
            com.google.android.gms.internal.measurement.zzcc$zzg r7 = r4.zza
            java.lang.String r7 = r7.zzx()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzaq.zzau
            boolean r6 = r6.zze(r7, r8)
            r7 = -1
            r8 = -1
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x028f:
            java.util.List<com.google.android.gms.internal.measurement.zzcc$zzc> r9 = r4.zzc
            int r9 = r9.size()
            r18 = r3
            java.lang.String r3 = "_fr"
            r19 = r13
            java.lang.String r13 = "_et"
            r20 = r2
            java.lang.String r2 = "_e"
            r21 = r14
            r22 = r15
            if (r12 >= r9) goto L_0x08b4
            java.util.List<com.google.android.gms.internal.measurement.zzcc$zzc> r9 = r4.zzc
            java.lang.Object r9 = r9.get(r12)
            com.google.android.gms.internal.measurement.zzcc$zzc r9 = (com.google.android.gms.internal.measurement.zzcc.zzc) r9
            com.google.android.gms.internal.measurement.zzib$zza r9 = r9.zzbl()
            com.google.android.gms.internal.measurement.zzib$zza r9 = (com.google.android.gms.internal.measurement.zzib.zza) r9
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r9 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r9
            com.google.android.gms.measurement.internal.zzfx r14 = r43.zzc()
            com.google.android.gms.internal.measurement.zzcc$zzg r15 = r4.zza
            java.lang.String r15 = r15.zzx()
            r16 = r12
            java.lang.String r12 = r9.zzd()
            boolean r12 = r14.zzb(r15, r12)
            java.lang.String r14 = "_err"
            if (r12 == 0) goto L_0x034c
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzi()
            java.lang.String r3 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r12 = r4.zza
            java.lang.String r12 = r12.zzx()
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzez.zza(r12)
            com.google.android.gms.measurement.internal.zzgd r13 = r1.zzj
            com.google.android.gms.measurement.internal.zzex r13 = r13.zzj()
            java.lang.String r15 = r9.zzd()
            java.lang.String r13 = r13.zza(r15)
            r2.zza(r3, r12, r13)
            com.google.android.gms.measurement.internal.zzfx r2 = r43.zzc()
            com.google.android.gms.internal.measurement.zzcc$zzg r3 = r4.zza
            java.lang.String r3 = r3.zzx()
            boolean r2 = r2.zzg(r3)
            if (r2 != 0) goto L_0x0319
            com.google.android.gms.measurement.internal.zzfx r2 = r43.zzc()
            com.google.android.gms.internal.measurement.zzcc$zzg r3 = r4.zza
            java.lang.String r3 = r3.zzx()
            boolean r2 = r2.zzh(r3)
            if (r2 == 0) goto L_0x0317
            goto L_0x0319
        L_0x0317:
            r2 = 0
            goto L_0x031a
        L_0x0319:
            r2 = 1
        L_0x031a:
            if (r2 != 0) goto L_0x033f
            java.lang.String r2 = r9.zzd()
            boolean r2 = r14.equals(r2)
            if (r2 != 0) goto L_0x033f
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzkw r24 = r2.zzi()
            com.google.android.gms.internal.measurement.zzcc$zzg r2 = r4.zza
            java.lang.String r25 = r2.zzx()
            r26 = 11
            java.lang.String r27 = "_ev"
            java.lang.String r28 = r9.zzd()
            r29 = 0
            r24.zza(r25, r26, r27, r28, r29)
        L_0x033f:
            r26 = r6
            r12 = r16
            r13 = r19
            r14 = r21
            r15 = r22
            r6 = r5
            goto L_0x08a9
        L_0x034c:
            com.google.android.gms.measurement.internal.zzfx r12 = r43.zzc()
            com.google.android.gms.internal.measurement.zzcc$zzg r15 = r4.zza
            java.lang.String r15 = r15.zzx()
            r26 = r6
            java.lang.String r6 = r9.zzd()
            boolean r6 = r12.zzc(r15, r6)
            java.lang.String r12 = "_c"
            if (r6 != 0) goto L_0x03be
            r43.zzh()
            java.lang.String r15 = r9.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)
            r27 = r7
            int r7 = r15.hashCode()
            r28 = r10
            r10 = 94660(0x171c4, float:1.32647E-40)
            if (r7 == r10) goto L_0x039a
            r10 = 95025(0x17331, float:1.33158E-40)
            if (r7 == r10) goto L_0x0390
            r10 = 95027(0x17333, float:1.33161E-40)
            if (r7 == r10) goto L_0x0386
            goto L_0x03a4
        L_0x0386:
            java.lang.String r7 = "_ui"
            boolean r7 = r15.equals(r7)
            if (r7 == 0) goto L_0x03a4
            r7 = 1
            goto L_0x03a5
        L_0x0390:
            java.lang.String r7 = "_ug"
            boolean r7 = r15.equals(r7)
            if (r7 == 0) goto L_0x03a4
            r7 = 2
            goto L_0x03a5
        L_0x039a:
            java.lang.String r7 = "_in"
            boolean r7 = r15.equals(r7)
            if (r7 == 0) goto L_0x03a4
            r7 = 0
            goto L_0x03a5
        L_0x03a4:
            r7 = -1
        L_0x03a5:
            if (r7 == 0) goto L_0x03af
            r10 = 1
            if (r7 == r10) goto L_0x03af
            r10 = 2
            if (r7 == r10) goto L_0x03af
            r7 = 0
            goto L_0x03b0
        L_0x03af:
            r7 = 1
        L_0x03b0:
            if (r7 == 0) goto L_0x03b3
            goto L_0x03c2
        L_0x03b3:
            r30 = r5
            r31 = r8
            r10 = r11
            r29 = r13
            r13 = r2
            r11 = r3
            goto L_0x05ad
        L_0x03be:
            r27 = r7
            r28 = r10
        L_0x03c2:
            r29 = r13
            r7 = 0
            r10 = 0
            r15 = 0
        L_0x03c7:
            int r13 = r9.zzb()
            r30 = r5
            java.lang.String r5 = "_r"
            if (r15 >= r13) goto L_0x0437
            com.google.android.gms.internal.measurement.zzcc$zze r13 = r9.zza(r15)
            java.lang.String r13 = r13.zzb()
            boolean r13 = r12.equals(r13)
            if (r13 == 0) goto L_0x0400
            com.google.android.gms.internal.measurement.zzcc$zze r5 = r9.zza(r15)
            com.google.android.gms.internal.measurement.zzib$zza r5 = r5.zzbl()
            com.google.android.gms.internal.measurement.zzib$zza r5 = (com.google.android.gms.internal.measurement.zzib.zza) r5
            com.google.android.gms.internal.measurement.zzcc$zze$zza r5 = (com.google.android.gms.internal.measurement.zzcc.zze.zza) r5
            r13 = r8
            r7 = 1
            com.google.android.gms.internal.measurement.zzcc$zze$zza r5 = r5.zza(r7)
            com.google.android.gms.internal.measurement.zzjj r5 = r5.zzv()
            com.google.android.gms.internal.measurement.zzib r5 = (com.google.android.gms.internal.measurement.zzib) r5
            com.google.android.gms.internal.measurement.zzcc$zze r5 = (com.google.android.gms.internal.measurement.zzcc.zze) r5
            r9.zza(r15, r5)
            r8 = r11
            r7 = 1
            goto L_0x0430
        L_0x0400:
            r13 = r8
            com.google.android.gms.internal.measurement.zzcc$zze r8 = r9.zza(r15)
            java.lang.String r8 = r8.zzb()
            boolean r5 = r5.equals(r8)
            if (r5 == 0) goto L_0x042f
            com.google.android.gms.internal.measurement.zzcc$zze r5 = r9.zza(r15)
            com.google.android.gms.internal.measurement.zzib$zza r5 = r5.zzbl()
            com.google.android.gms.internal.measurement.zzib$zza r5 = (com.google.android.gms.internal.measurement.zzib.zza) r5
            com.google.android.gms.internal.measurement.zzcc$zze$zza r5 = (com.google.android.gms.internal.measurement.zzcc.zze.zza) r5
            r8 = r11
            r10 = 1
            com.google.android.gms.internal.measurement.zzcc$zze$zza r5 = r5.zza(r10)
            com.google.android.gms.internal.measurement.zzjj r5 = r5.zzv()
            com.google.android.gms.internal.measurement.zzib r5 = (com.google.android.gms.internal.measurement.zzib) r5
            com.google.android.gms.internal.measurement.zzcc$zze r5 = (com.google.android.gms.internal.measurement.zzcc.zze) r5
            r9.zza(r15, r5)
            r10 = 1
            goto L_0x0430
        L_0x042f:
            r8 = r11
        L_0x0430:
            int r15 = r15 + 1
            r11 = r8
            r8 = r13
            r5 = r30
            goto L_0x03c7
        L_0x0437:
            r13 = r8
            r8 = r11
            if (r7 != 0) goto L_0x0470
            if (r6 == 0) goto L_0x0470
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzx()
            java.lang.String r11 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzgd r15 = r1.zzj
            com.google.android.gms.measurement.internal.zzex r15 = r15.zzj()
            r31 = r13
            java.lang.String r13 = r9.zzd()
            java.lang.String r13 = r15.zza(r13)
            r7.zza(r11, r13)
            com.google.android.gms.internal.measurement.zzcc$zze$zza r7 = com.google.android.gms.internal.measurement.zzcc.zze.zzm()
            com.google.android.gms.internal.measurement.zzcc$zze$zza r7 = r7.zza(r12)
            r13 = r2
            r11 = r3
            r2 = 1
            com.google.android.gms.internal.measurement.zzcc$zze$zza r7 = r7.zza(r2)
            r9.zza(r7)
            goto L_0x0474
        L_0x0470:
            r11 = r3
            r31 = r13
            r13 = r2
        L_0x0474:
            if (r10 != 0) goto L_0x04a6
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzx()
            java.lang.String r3 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzex r7 = r7.zzj()
            java.lang.String r10 = r9.zzd()
            java.lang.String r7 = r7.zza(r10)
            r2.zza(r3, r7)
            com.google.android.gms.internal.measurement.zzcc$zze$zza r2 = com.google.android.gms.internal.measurement.zzcc.zze.zzm()
            com.google.android.gms.internal.measurement.zzcc$zze$zza r2 = r2.zza(r5)
            r3 = r8
            r7 = 1
            com.google.android.gms.internal.measurement.zzcc$zze$zza r2 = r2.zza(r7)
            r9.zza(r2)
            goto L_0x04a7
        L_0x04a6:
            r3 = r8
        L_0x04a7:
            com.google.android.gms.measurement.internal.zzad r32 = r43.zze()
            long r33 = r43.zzx()
            com.google.android.gms.internal.measurement.zzcc$zzg r2 = r4.zza
            java.lang.String r35 = r2.zzx()
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 1
            com.google.android.gms.measurement.internal.zzac r2 = r32.zza(r33, r35, r36, r37, r38, r39, r40)
            long r7 = r2.zze
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r2 = r2.zzb()
            com.google.android.gms.internal.measurement.zzcc$zzg r10 = r4.zza
            java.lang.String r10 = r10.zzx()
            int r2 = r2.zzc(r10)
            r10 = r3
            long r2 = (long) r2
            int r15 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r15 <= 0) goto L_0x04df
            zza(r9, r5)
            goto L_0x04e1
        L_0x04df:
            r19 = 1
        L_0x04e1:
            java.lang.String r2 = r9.zzd()
            boolean r2 = com.google.android.gms.measurement.internal.zzkw.zza(r2)
            if (r2 == 0) goto L_0x05ad
            if (r6 == 0) goto L_0x05ad
            com.google.android.gms.measurement.internal.zzad r32 = r43.zze()
            long r33 = r43.zzx()
            com.google.android.gms.internal.measurement.zzcc$zzg r2 = r4.zza
            java.lang.String r35 = r2.zzx()
            r36 = 0
            r37 = 0
            r38 = 1
            r39 = 0
            r40 = 0
            com.google.android.gms.measurement.internal.zzac r2 = r32.zza(r33, r35, r36, r37, r38, r39, r40)
            long r2 = r2.zzc
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r5 = r5.zzb()
            com.google.android.gms.internal.measurement.zzcc$zzg r7 = r4.zza
            java.lang.String r7 = r7.zzx()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzaq.zzm
            int r5 = r5.zzb(r7, r8)
            long r7 = (long) r5
            int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x05ad
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzi()
            java.lang.String r3 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r4.zza
            java.lang.String r5 = r5.zzx()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza(r5)
            r2.zza(r3, r5)
            r2 = -1
            r3 = 0
            r5 = 0
            r7 = 0
        L_0x053f:
            int r8 = r9.zzb()
            if (r7 >= r8) goto L_0x056c
            com.google.android.gms.internal.measurement.zzcc$zze r8 = r9.zza(r7)
            java.lang.String r15 = r8.zzb()
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x055e
            com.google.android.gms.internal.measurement.zzib$zza r2 = r8.zzbl()
            com.google.android.gms.internal.measurement.zzib$zza r2 = (com.google.android.gms.internal.measurement.zzib.zza) r2
            com.google.android.gms.internal.measurement.zzcc$zze$zza r2 = (com.google.android.gms.internal.measurement.zzcc.zze.zza) r2
            r3 = r2
            r2 = r7
            goto L_0x0569
        L_0x055e:
            java.lang.String r8 = r8.zzb()
            boolean r8 = r14.equals(r8)
            if (r8 == 0) goto L_0x0569
            r5 = 1
        L_0x0569:
            int r7 = r7 + 1
            goto L_0x053f
        L_0x056c:
            if (r5 == 0) goto L_0x0574
            if (r3 == 0) goto L_0x0574
            r9.zzb(r2)
            goto L_0x05ad
        L_0x0574:
            if (r3 == 0) goto L_0x0594
            java.lang.Object r3 = r3.clone()
            com.google.android.gms.internal.measurement.zzib$zza r3 = (com.google.android.gms.internal.measurement.zzib.zza) r3
            com.google.android.gms.internal.measurement.zzcc$zze$zza r3 = (com.google.android.gms.internal.measurement.zzcc.zze.zza) r3
            com.google.android.gms.internal.measurement.zzcc$zze$zza r3 = r3.zza(r14)
            r7 = 10
            com.google.android.gms.internal.measurement.zzcc$zze$zza r3 = r3.zza(r7)
            com.google.android.gms.internal.measurement.zzjj r3 = r3.zzv()
            com.google.android.gms.internal.measurement.zzib r3 = (com.google.android.gms.internal.measurement.zzib) r3
            com.google.android.gms.internal.measurement.zzcc$zze r3 = (com.google.android.gms.internal.measurement.zzcc.zze) r3
            r9.zza(r2, r3)
            goto L_0x05ad
        L_0x0594:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()
            java.lang.String r3 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r4.zza
            java.lang.String r5 = r5.zzx()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza(r5)
            r2.zza(r3, r5)
        L_0x05ad:
            if (r6 == 0) goto L_0x0671
            java.util.ArrayList r2 = new java.util.ArrayList
            java.util.List r3 = r9.zza()
            r2.<init>(r3)
            r3 = 0
            r5 = -1
            r6 = -1
        L_0x05bb:
            int r7 = r2.size()
            java.lang.String r8 = "currency"
            java.lang.String r14 = "value"
            if (r3 >= r7) goto L_0x05ec
            java.lang.Object r7 = r2.get(r3)
            com.google.android.gms.internal.measurement.zzcc$zze r7 = (com.google.android.gms.internal.measurement.zzcc.zze) r7
            java.lang.String r7 = r7.zzb()
            boolean r7 = r14.equals(r7)
            if (r7 == 0) goto L_0x05d8
            r5 = r3
            goto L_0x05e9
        L_0x05d8:
            java.lang.Object r7 = r2.get(r3)
            com.google.android.gms.internal.measurement.zzcc$zze r7 = (com.google.android.gms.internal.measurement.zzcc.zze) r7
            java.lang.String r7 = r7.zzb()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x05e9
            r6 = r3
        L_0x05e9:
            int r3 = r3 + 1
            goto L_0x05bb
        L_0x05ec:
            r3 = -1
            if (r5 == r3) goto L_0x0672
            java.lang.Object r3 = r2.get(r5)
            com.google.android.gms.internal.measurement.zzcc$zze r3 = (com.google.android.gms.internal.measurement.zzcc.zze) r3
            boolean r3 = r3.zze()
            if (r3 != 0) goto L_0x0622
            java.lang.Object r3 = r2.get(r5)
            com.google.android.gms.internal.measurement.zzcc$zze r3 = (com.google.android.gms.internal.measurement.zzcc.zze) r3
            boolean r3 = r3.zzi()
            if (r3 != 0) goto L_0x0622
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzk()
            java.lang.String r3 = "Value must be specified with a numeric type."
            r2.zza(r3)
            r9.zzb(r5)
            zza(r9, r12)
            r2 = 18
            zza(r9, r2, r14)
            goto L_0x0671
        L_0x0622:
            r3 = -1
            if (r6 != r3) goto L_0x0628
            r2 = 1
            r7 = 3
            goto L_0x0654
        L_0x0628:
            java.lang.Object r2 = r2.get(r6)
            com.google.android.gms.internal.measurement.zzcc$zze r2 = (com.google.android.gms.internal.measurement.zzcc.zze) r2
            java.lang.String r2 = r2.zzd()
            int r6 = r2.length()
            r7 = 3
            if (r6 == r7) goto L_0x063b
        L_0x0639:
            r2 = 1
            goto L_0x0654
        L_0x063b:
            r6 = 0
        L_0x063c:
            int r14 = r2.length()
            if (r6 >= r14) goto L_0x0653
            int r14 = r2.codePointAt(r6)
            boolean r15 = java.lang.Character.isLetter(r14)
            if (r15 != 0) goto L_0x064d
            goto L_0x0639
        L_0x064d:
            int r14 = java.lang.Character.charCount(r14)
            int r6 = r6 + r14
            goto L_0x063c
        L_0x0653:
            r2 = 0
        L_0x0654:
            if (r2 == 0) goto L_0x0673
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzk()
            java.lang.String r6 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r6)
            r9.zzb(r5)
            zza(r9, r12)
            r2 = 19
            zza(r9, r2, r8)
            goto L_0x0673
        L_0x0671:
            r3 = -1
        L_0x0672:
            r7 = 3
        L_0x0673:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r2 = r2.zzb()
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r4.zza
            java.lang.String r5 = r5.zzx()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzaq.zzat
            boolean r2 = r2.zze(r5, r6)
            if (r2 == 0) goto L_0x0822
            java.lang.String r2 = r9.zzd()
            r5 = r13
            boolean r2 = r5.equals(r2)
            r12 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x06ed
            r43.zzh()
            com.google.android.gms.internal.measurement.zzjj r2 = r9.zzv()
            com.google.android.gms.internal.measurement.zzib r2 = (com.google.android.gms.internal.measurement.zzib) r2
            com.google.android.gms.internal.measurement.zzcc$zzc r2 = (com.google.android.gms.internal.measurement.zzcc.zzc) r2
            com.google.android.gms.internal.measurement.zzcc$zze r2 = com.google.android.gms.measurement.internal.zzks.zza(r2, r11)
            if (r2 != 0) goto L_0x06e3
            if (r10 == 0) goto L_0x06d7
            long r14 = r10.zzf()
            long r24 = r9.zzf()
            long r14 = r14 - r24
            long r14 = java.lang.Math.abs(r14)
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x06d7
            java.lang.Object r2 = r10.clone()
            com.google.android.gms.internal.measurement.zzib$zza r2 = (com.google.android.gms.internal.measurement.zzib.zza) r2
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2
            boolean r6 = r1.zza(r9, r2)
            if (r6 == 0) goto L_0x06d7
            r6 = r30
            r8 = r31
            r6.zza(r8, r2)
            r7 = r27
            r14 = r29
        L_0x06d2:
            r10 = 0
        L_0x06d3:
            r28 = 0
            goto L_0x082c
        L_0x06d7:
            r6 = r30
            r8 = r31
            r28 = r9
            r7 = r21
            r14 = r29
            goto L_0x082c
        L_0x06e3:
            r6 = r30
            r8 = r31
            r11 = r27
            r14 = r29
            goto L_0x082b
        L_0x06ed:
            r6 = r30
            r8 = r31
            java.lang.String r2 = "_vs"
            java.lang.String r11 = r9.zzd()
            boolean r2 = r2.equals(r11)
            if (r2 == 0) goto L_0x0745
            r43.zzh()
            com.google.android.gms.internal.measurement.zzjj r2 = r9.zzv()
            com.google.android.gms.internal.measurement.zzib r2 = (com.google.android.gms.internal.measurement.zzib) r2
            com.google.android.gms.internal.measurement.zzcc$zzc r2 = (com.google.android.gms.internal.measurement.zzcc.zzc) r2
            r14 = r29
            com.google.android.gms.internal.measurement.zzcc$zze r2 = com.google.android.gms.measurement.internal.zzks.zza(r2, r14)
            if (r2 != 0) goto L_0x0741
            if (r28 == 0) goto L_0x0739
            long r10 = r28.zzf()
            long r24 = r9.zzf()
            long r10 = r10 - r24
            long r10 = java.lang.Math.abs(r10)
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x0739
            java.lang.Object r2 = r28.clone()
            com.google.android.gms.internal.measurement.zzib$zza r2 = (com.google.android.gms.internal.measurement.zzib.zza) r2
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2
            boolean r10 = r1.zza(r2, r9)
            if (r10 == 0) goto L_0x0739
            r11 = r27
            r6.zza(r11, r2)
            r7 = r11
            goto L_0x06d2
        L_0x0739:
            r11 = r27
            r10 = r9
            r7 = r11
            r8 = r21
            goto L_0x082c
        L_0x0741:
            r11 = r27
            goto L_0x082b
        L_0x0745:
            r11 = r27
            r14 = r29
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r2 = r2.zzb()
            com.google.android.gms.internal.measurement.zzcc$zzg r12 = r4.zza
            java.lang.String r12 = r12.zzx()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzaq.zzbr
            boolean r2 = r2.zze(r12, r13)
            if (r2 == 0) goto L_0x082b
            java.lang.String r2 = "_ab"
            java.lang.String r12 = r9.zzd()
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x082b
            r43.zzh()
            com.google.android.gms.internal.measurement.zzjj r2 = r9.zzv()
            com.google.android.gms.internal.measurement.zzib r2 = (com.google.android.gms.internal.measurement.zzib) r2
            com.google.android.gms.internal.measurement.zzcc$zzc r2 = (com.google.android.gms.internal.measurement.zzcc.zzc) r2
            com.google.android.gms.internal.measurement.zzcc$zze r2 = com.google.android.gms.measurement.internal.zzks.zza(r2, r14)
            if (r2 != 0) goto L_0x082b
            if (r28 == 0) goto L_0x082b
            long r12 = r28.zzf()
            long r24 = r9.zzf()
            long r12 = r12 - r24
            long r12 = java.lang.Math.abs(r12)
            r24 = 4000(0xfa0, double:1.9763E-320)
            int r2 = (r12 > r24 ? 1 : (r12 == r24 ? 0 : -1))
            if (r2 > 0) goto L_0x082b
            java.lang.Object r2 = r28.clone()
            com.google.android.gms.internal.measurement.zzib$zza r2 = (com.google.android.gms.internal.measurement.zzib.zza) r2
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2
            r1.zzb(r2, r9)
            java.lang.String r12 = r2.zzd()
            boolean r12 = r5.equals(r12)
            com.google.android.gms.common.internal.Preconditions.checkArgument(r12)
            r43.zzh()
            com.google.android.gms.internal.measurement.zzjj r12 = r2.zzv()
            com.google.android.gms.internal.measurement.zzib r12 = (com.google.android.gms.internal.measurement.zzib) r12
            com.google.android.gms.internal.measurement.zzcc$zzc r12 = (com.google.android.gms.internal.measurement.zzcc.zzc) r12
            java.lang.String r13 = "_sn"
            com.google.android.gms.internal.measurement.zzcc$zze r12 = com.google.android.gms.measurement.internal.zzks.zza(r12, r13)
            r43.zzh()
            com.google.android.gms.internal.measurement.zzjj r13 = r2.zzv()
            com.google.android.gms.internal.measurement.zzib r13 = (com.google.android.gms.internal.measurement.zzib) r13
            com.google.android.gms.internal.measurement.zzcc$zzc r13 = (com.google.android.gms.internal.measurement.zzcc.zzc) r13
            java.lang.String r15 = "_sc"
            com.google.android.gms.internal.measurement.zzcc$zze r13 = com.google.android.gms.measurement.internal.zzks.zza(r13, r15)
            r43.zzh()
            com.google.android.gms.internal.measurement.zzjj r15 = r2.zzv()
            com.google.android.gms.internal.measurement.zzib r15 = (com.google.android.gms.internal.measurement.zzib) r15
            com.google.android.gms.internal.measurement.zzcc$zzc r15 = (com.google.android.gms.internal.measurement.zzcc.zzc) r15
            java.lang.String r3 = "_si"
            com.google.android.gms.internal.measurement.zzcc$zze r3 = com.google.android.gms.measurement.internal.zzks.zza(r15, r3)
            if (r12 == 0) goto L_0x07e0
            java.lang.String r12 = r12.zzd()
            goto L_0x07e2
        L_0x07e0:
            r12 = r18
        L_0x07e2:
            boolean r15 = android.text.TextUtils.isEmpty(r12)
            if (r15 != 0) goto L_0x07f1
            com.google.android.gms.measurement.internal.zzks r15 = r43.zzh()
            java.lang.String r7 = "_sn"
            r15.zza(r9, r7, r12)
        L_0x07f1:
            if (r13 == 0) goto L_0x07f8
            java.lang.String r7 = r13.zzd()
            goto L_0x07fa
        L_0x07f8:
            r7 = r18
        L_0x07fa:
            boolean r12 = android.text.TextUtils.isEmpty(r7)
            if (r12 != 0) goto L_0x0809
            com.google.android.gms.measurement.internal.zzks r12 = r43.zzh()
            java.lang.String r13 = "_sc"
            r12.zza(r9, r13, r7)
        L_0x0809:
            if (r3 == 0) goto L_0x081c
            com.google.android.gms.measurement.internal.zzks r7 = r43.zzh()
            java.lang.String r12 = "_si"
            long r24 = r3.zzf()
            java.lang.Long r3 = java.lang.Long.valueOf(r24)
            r7.zza(r9, r12, r3)
        L_0x081c:
            r6.zza(r11, r2)
            r7 = r11
            goto L_0x06d3
        L_0x0822:
            r5 = r13
            r11 = r27
            r14 = r29
            r6 = r30
            r8 = r31
        L_0x082b:
            r7 = r11
        L_0x082c:
            if (r26 != 0) goto L_0x088d
            java.lang.String r2 = r9.zzd()
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x088d
            int r2 = r9.zzb()
            if (r2 != 0) goto L_0x0858
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzi()
            java.lang.String r3 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r4.zza
            java.lang.String r5 = r5.zzx()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza(r5)
            r2.zza(r3, r5)
            goto L_0x088d
        L_0x0858:
            com.google.android.gms.measurement.internal.zzks r2 = r43.zzh()
            com.google.android.gms.internal.measurement.zzjj r3 = r9.zzv()
            com.google.android.gms.internal.measurement.zzib r3 = (com.google.android.gms.internal.measurement.zzib) r3
            com.google.android.gms.internal.measurement.zzcc$zzc r3 = (com.google.android.gms.internal.measurement.zzcc.zzc) r3
            java.lang.Object r2 = r2.zzb(r3, r14)
            java.lang.Long r2 = (java.lang.Long) r2
            if (r2 != 0) goto L_0x0886
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzi()
            java.lang.String r3 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r4.zza
            java.lang.String r5 = r5.zzx()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza(r5)
            r2.zza(r3, r5)
            goto L_0x088d
        L_0x0886:
            long r2 = r2.longValue()
            long r2 = r22 + r2
            goto L_0x088f
        L_0x088d:
            r2 = r22
        L_0x088f:
            java.util.List<com.google.android.gms.internal.measurement.zzcc$zzc> r5 = r4.zzc
            com.google.android.gms.internal.measurement.zzjj r11 = r9.zzv()
            com.google.android.gms.internal.measurement.zzib r11 = (com.google.android.gms.internal.measurement.zzib) r11
            com.google.android.gms.internal.measurement.zzcc$zzc r11 = (com.google.android.gms.internal.measurement.zzcc.zzc) r11
            r12 = r16
            r5.set(r12, r11)
            int r14 = r21 + 1
            r6.zza(r9)
            r15 = r2
            r11 = r10
            r13 = r19
            r10 = r28
        L_0x08a9:
            int r12 = r12 + 1
            r5 = r6
            r3 = r18
            r2 = r20
            r6 = r26
            goto L_0x028f
        L_0x08b4:
            r11 = r3
            r26 = r6
            r14 = r13
            r6 = r5
            r5 = r2
            if (r26 == 0) goto L_0x0911
            r2 = r21
            r15 = r22
            r3 = 0
        L_0x08c1:
            if (r3 >= r2) goto L_0x090f
            com.google.android.gms.internal.measurement.zzcc$zzc r7 = r6.zzb(r3)
            java.lang.String r8 = r7.zzc()
            boolean r8 = r5.equals(r8)
            if (r8 == 0) goto L_0x08e2
            r43.zzh()
            com.google.android.gms.internal.measurement.zzcc$zze r8 = com.google.android.gms.measurement.internal.zzks.zza(r7, r11)
            if (r8 == 0) goto L_0x08e2
            r6.zzc(r3)
            int r2 = r2 + -1
            int r3 = r3 + -1
            goto L_0x090c
        L_0x08e2:
            r43.zzh()
            com.google.android.gms.internal.measurement.zzcc$zze r7 = com.google.android.gms.measurement.internal.zzks.zza(r7, r14)
            if (r7 == 0) goto L_0x090c
            boolean r8 = r7.zze()
            if (r8 == 0) goto L_0x08fa
            long r7 = r7.zzf()
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            goto L_0x08fb
        L_0x08fa:
            r7 = 0
        L_0x08fb:
            if (r7 == 0) goto L_0x090c
            long r8 = r7.longValue()
            r12 = 0
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x090c
            long r7 = r7.longValue()
            long r15 = r15 + r7
        L_0x090c:
            r7 = 1
            int r3 = r3 + r7
            goto L_0x08c1
        L_0x090f:
            r2 = r15
            goto L_0x0913
        L_0x0911:
            r2 = r22
        L_0x0913:
            r5 = 0
            r1.zza(r6, r2, r5)
            java.util.List r5 = r6.zza()
            java.util.Iterator r5 = r5.iterator()
        L_0x091f:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0939
            java.lang.Object r7 = r5.next()
            com.google.android.gms.internal.measurement.zzcc$zzc r7 = (com.google.android.gms.internal.measurement.zzcc.zzc) r7
            java.lang.String r8 = "_s"
            java.lang.String r7 = r7.zzc()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x091f
            r5 = 1
            goto L_0x093a
        L_0x0939:
            r5 = 0
        L_0x093a:
            java.lang.String r7 = "_se"
            if (r5 == 0) goto L_0x0949
            com.google.android.gms.measurement.internal.zzad r5 = r43.zze()
            java.lang.String r8 = r6.zzj()
            r5.zzb(r8, r7)
        L_0x0949:
            java.lang.String r5 = "_sid"
            int r5 = com.google.android.gms.measurement.internal.zzks.zza(r6, r5)
            if (r5 < 0) goto L_0x0953
            r5 = 1
            goto L_0x0954
        L_0x0953:
            r5 = 0
        L_0x0954:
            if (r5 == 0) goto L_0x095b
            r5 = 1
            r1.zza(r6, r2, r5)
            goto L_0x097d
        L_0x095b:
            int r2 = com.google.android.gms.measurement.internal.zzks.zza(r6, r7)
            if (r2 < 0) goto L_0x097d
            r6.zze(r2)
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()
            java.lang.String r3 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r4.zza
            java.lang.String r5 = r5.zzx()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza(r5)
            r2.zza(r3, r5)
        L_0x097d:
            com.google.android.gms.measurement.internal.zzks r2 = r43.zzh()
            com.google.android.gms.measurement.internal.zzez r3 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzx()
            java.lang.String r5 = "Checking account type status for ad personalization signals"
            r3.zza(r5)
            com.google.android.gms.measurement.internal.zzfx r3 = r2.zzj()
            java.lang.String r5 = r6.zzj()
            boolean r3 = r3.zze(r5)
            if (r3 == 0) goto L_0x0a0e
            com.google.android.gms.measurement.internal.zzad r3 = r2.zzi()
            java.lang.String r5 = r6.zzj()
            com.google.android.gms.measurement.internal.zzf r3 = r3.zzb(r5)
            if (r3 == 0) goto L_0x0a0e
            boolean r3 = r3.zzaf()
            if (r3 == 0) goto L_0x0a0e
            com.google.android.gms.measurement.internal.zzai r3 = r2.zzl()
            boolean r3 = r3.zzj()
            if (r3 == 0) goto L_0x0a0e
            com.google.android.gms.measurement.internal.zzez r3 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzw()
            java.lang.String r5 = "Turning off ad personalization due to account type"
            r3.zza(r5)
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r3 = com.google.android.gms.internal.measurement.zzcc.zzk.zzj()
            r5 = r20
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r3 = r3.zza(r5)
            com.google.android.gms.measurement.internal.zzai r2 = r2.zzl()
            long r7 = r2.zzh()
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r2 = r3.zza(r7)
            r7 = 1
            com.google.android.gms.internal.measurement.zzcc$zzk$zza r2 = r2.zzb(r7)
            com.google.android.gms.internal.measurement.zzjj r2 = r2.zzv()
            com.google.android.gms.internal.measurement.zzib r2 = (com.google.android.gms.internal.measurement.zzib) r2
            com.google.android.gms.internal.measurement.zzcc$zzk r2 = (com.google.android.gms.internal.measurement.zzcc.zzk) r2
            r3 = 0
        L_0x09ec:
            int r7 = r6.zze()
            if (r3 >= r7) goto L_0x0a08
            com.google.android.gms.internal.measurement.zzcc$zzk r7 = r6.zzd(r3)
            java.lang.String r7 = r7.zzc()
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0a05
            r6.zza(r3, r2)
            r3 = 1
            goto L_0x0a09
        L_0x0a05:
            int r3 = r3 + 1
            goto L_0x09ec
        L_0x0a08:
            r3 = 0
        L_0x0a09:
            if (r3 != 0) goto L_0x0a0e
            r6.zza(r2)
        L_0x0a0e:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r2 = r2.zzb()
            java.lang.String r3 = r6.zzj()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzaq.zzbm
            boolean r2 = r2.zze(r3, r5)
            if (r2 == 0) goto L_0x0a23
            zza(r6)
        L_0x0a23:
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r2 = r6.zzm()
            com.google.android.gms.measurement.internal.zzo r7 = r43.zzf()
            java.lang.String r8 = r6.zzj()
            java.util.List r9 = r6.zza()
            java.util.List r10 = r6.zzd()
            long r11 = r6.zzf()
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            long r12 = r6.zzg()
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            java.util.List r3 = r7.zza(r8, r9, r10, r11, r12)
            r2.zzc(r3)
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r2 = r2.zzb()
            com.google.android.gms.internal.measurement.zzcc$zzg r3 = r4.zza
            java.lang.String r3 = r3.zzx()
            boolean r2 = r2.zzh(r3)
            if (r2 == 0) goto L_0x0d99
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0d94 }
            r2.<init>()     // Catch:{ all -> 0x0d94 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0d94 }
            r3.<init>()     // Catch:{ all -> 0x0d94 }
            com.google.android.gms.measurement.internal.zzgd r5 = r1.zzj     // Catch:{ all -> 0x0d94 }
            com.google.android.gms.measurement.internal.zzkw r5 = r5.zzi()     // Catch:{ all -> 0x0d94 }
            java.security.SecureRandom r5 = r5.zzh()     // Catch:{ all -> 0x0d94 }
            r7 = 0
        L_0x0a75:
            int r8 = r6.zzb()     // Catch:{ all -> 0x0d94 }
            if (r7 >= r8) goto L_0x0d5e
            com.google.android.gms.internal.measurement.zzcc$zzc r8 = r6.zzb(r7)     // Catch:{ all -> 0x0d94 }
            com.google.android.gms.internal.measurement.zzib$zza r8 = r8.zzbl()     // Catch:{ all -> 0x0d94 }
            com.google.android.gms.internal.measurement.zzib$zza r8 = (com.google.android.gms.internal.measurement.zzib.zza) r8     // Catch:{ all -> 0x0d94 }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r8 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r8     // Catch:{ all -> 0x0d94 }
            java.lang.String r9 = r8.zzd()     // Catch:{ all -> 0x0d94 }
            java.lang.String r10 = "_ep"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0d94 }
            java.lang.String r10 = "_sr"
            if (r9 == 0) goto L_0x0b0b
            com.google.android.gms.measurement.internal.zzks r9 = r43.zzh()
            com.google.android.gms.internal.measurement.zzjj r11 = r8.zzv()
            com.google.android.gms.internal.measurement.zzib r11 = (com.google.android.gms.internal.measurement.zzib) r11
            com.google.android.gms.internal.measurement.zzcc$zzc r11 = (com.google.android.gms.internal.measurement.zzcc.zzc) r11
            java.lang.String r12 = "_en"
            java.lang.Object r9 = r9.zzb(r11, r12)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r11 = r2.get(r9)
            com.google.android.gms.measurement.internal.zzak r11 = (com.google.android.gms.measurement.internal.zzak) r11
            if (r11 != 0) goto L_0x0ac2
            com.google.android.gms.measurement.internal.zzad r11 = r43.zze()
            com.google.android.gms.internal.measurement.zzcc$zzg r12 = r4.zza
            java.lang.String r12 = r12.zzx()
            com.google.android.gms.measurement.internal.zzak r11 = r11.zza(r12, r9)
            r2.put(r9, r11)
        L_0x0ac2:
            java.lang.Long r9 = r11.zzi
            if (r9 != 0) goto L_0x0b01
            java.lang.Long r9 = r11.zzj
            long r12 = r9.longValue()
            r14 = 1
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x0adb
            com.google.android.gms.measurement.internal.zzks r9 = r43.zzh()
            java.lang.Long r12 = r11.zzj
            r9.zza(r8, r10, r12)
        L_0x0adb:
            java.lang.Boolean r9 = r11.zzk
            if (r9 == 0) goto L_0x0af6
            java.lang.Boolean r9 = r11.zzk
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0af6
            com.google.android.gms.measurement.internal.zzks r9 = r43.zzh()
            java.lang.String r10 = "_efs"
            r11 = 1
            java.lang.Long r13 = java.lang.Long.valueOf(r11)
            r9.zza(r8, r10, r13)
        L_0x0af6:
            com.google.android.gms.internal.measurement.zzjj r9 = r8.zzv()
            com.google.android.gms.internal.measurement.zzib r9 = (com.google.android.gms.internal.measurement.zzib) r9
            com.google.android.gms.internal.measurement.zzcc$zzc r9 = (com.google.android.gms.internal.measurement.zzcc.zzc) r9
            r3.add(r9)
        L_0x0b01:
            r6.zza(r7, r8)
        L_0x0b04:
            r44 = r4
            r15 = r5
            r1 = r6
            r4 = r7
            goto L_0x0d54
        L_0x0b0b:
            com.google.android.gms.measurement.internal.zzfx r9 = r43.zzc()
            com.google.android.gms.internal.measurement.zzcc$zzg r11 = r4.zza
            java.lang.String r11 = r11.zzx()
            long r11 = r9.zzf(r11)
            com.google.android.gms.measurement.internal.zzgd r9 = r1.zzj
            r9.zzi()
            long r13 = r8.zzf()
            long r13 = com.google.android.gms.measurement.internal.zzkw.zza(r13, r11)
            com.google.android.gms.internal.measurement.zzjj r9 = r8.zzv()
            com.google.android.gms.internal.measurement.zzib r9 = (com.google.android.gms.internal.measurement.zzib) r9
            com.google.android.gms.internal.measurement.zzcc$zzc r9 = (com.google.android.gms.internal.measurement.zzcc.zzc) r9
            java.lang.String r15 = "_dbg"
            r20 = r11
            r16 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r16)
            boolean r12 = android.text.TextUtils.isEmpty(r15)
            if (r12 != 0) goto L_0x0b98
            if (r11 != 0) goto L_0x0b41
            goto L_0x0b98
        L_0x0b41:
            java.util.List r9 = r9.zza()
            java.util.Iterator r9 = r9.iterator()
        L_0x0b49:
            boolean r12 = r9.hasNext()
            if (r12 == 0) goto L_0x0b98
            java.lang.Object r12 = r9.next()
            com.google.android.gms.internal.measurement.zzcc$zze r12 = (com.google.android.gms.internal.measurement.zzcc.zze) r12
            r44 = r9
            java.lang.String r9 = r12.zzb()
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L_0x0b95
            boolean r9 = r11 instanceof java.lang.Long
            if (r9 == 0) goto L_0x0b73
            long r15 = r12.zzf()
            java.lang.Long r9 = java.lang.Long.valueOf(r15)
            boolean r9 = r11.equals(r9)
            if (r9 != 0) goto L_0x0b93
        L_0x0b73:
            boolean r9 = r11 instanceof java.lang.String
            if (r9 == 0) goto L_0x0b81
            java.lang.String r9 = r12.zzd()
            boolean r9 = r11.equals(r9)
            if (r9 != 0) goto L_0x0b93
        L_0x0b81:
            boolean r9 = r11 instanceof java.lang.Double
            if (r9 == 0) goto L_0x0b98
            double r15 = r12.zzj()
            java.lang.Double r9 = java.lang.Double.valueOf(r15)
            boolean r9 = r11.equals(r9)
            if (r9 == 0) goto L_0x0b98
        L_0x0b93:
            r9 = 1
            goto L_0x0b99
        L_0x0b95:
            r9 = r44
            goto L_0x0b49
        L_0x0b98:
            r9 = 0
        L_0x0b99:
            if (r9 != 0) goto L_0x0bae
            com.google.android.gms.measurement.internal.zzfx r9 = r43.zzc()
            com.google.android.gms.internal.measurement.zzcc$zzg r11 = r4.zza
            java.lang.String r11 = r11.zzx()
            java.lang.String r12 = r8.zzd()
            int r9 = r9.zzd(r11, r12)
            goto L_0x0baf
        L_0x0bae:
            r9 = 1
        L_0x0baf:
            if (r9 > 0) goto L_0x0bd8
            com.google.android.gms.measurement.internal.zzgd r10 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r10 = r10.zzr()
            com.google.android.gms.measurement.internal.zzfb r10 = r10.zzi()
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r8.zzd()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r10.zza(r11, r12, r9)
            com.google.android.gms.internal.measurement.zzjj r9 = r8.zzv()
            com.google.android.gms.internal.measurement.zzib r9 = (com.google.android.gms.internal.measurement.zzib) r9
            com.google.android.gms.internal.measurement.zzcc$zzc r9 = (com.google.android.gms.internal.measurement.zzcc.zzc) r9
            r3.add(r9)
            r6.zza(r7, r8)
            goto L_0x0b04
        L_0x0bd8:
            java.lang.String r11 = r8.zzd()
            java.lang.Object r11 = r2.get(r11)
            com.google.android.gms.measurement.internal.zzak r11 = (com.google.android.gms.measurement.internal.zzak) r11
            if (r11 != 0) goto L_0x0c36
            com.google.android.gms.measurement.internal.zzad r11 = r43.zze()
            com.google.android.gms.internal.measurement.zzcc$zzg r12 = r4.zza
            java.lang.String r12 = r12.zzx()
            java.lang.String r15 = r8.zzd()
            com.google.android.gms.measurement.internal.zzak r11 = r11.zza(r12, r15)
            if (r11 != 0) goto L_0x0c36
            com.google.android.gms.measurement.internal.zzgd r11 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r11 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfb r11 = r11.zzi()
            java.lang.String r12 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzcc$zzg r15 = r4.zza
            java.lang.String r15 = r15.zzx()
            java.lang.String r1 = r8.zzd()
            r11.zza(r12, r15, r1)
            com.google.android.gms.measurement.internal.zzak r11 = new com.google.android.gms.measurement.internal.zzak
            com.google.android.gms.internal.measurement.zzcc$zzg r1 = r4.zza
            java.lang.String r27 = r1.zzx()
            java.lang.String r28 = r8.zzd()
            r29 = 1
            r31 = 1
            r33 = 1
            long r35 = r8.zzf()
            r37 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r26 = r11
            r26.<init>(r27, r28, r29, r31, r33, r35, r37, r39, r40, r41, r42)
        L_0x0c36:
            com.google.android.gms.measurement.internal.zzks r1 = r43.zzh()
            com.google.android.gms.internal.measurement.zzjj r12 = r8.zzv()
            com.google.android.gms.internal.measurement.zzib r12 = (com.google.android.gms.internal.measurement.zzib) r12
            com.google.android.gms.internal.measurement.zzcc$zzc r12 = (com.google.android.gms.internal.measurement.zzcc.zzc) r12
            java.lang.String r15 = "_eid"
            java.lang.Object r1 = r1.zzb(r12, r15)
            java.lang.Long r1 = (java.lang.Long) r1
            if (r1 == 0) goto L_0x0c4e
            r12 = 1
            goto L_0x0c4f
        L_0x0c4e:
            r12 = 0
        L_0x0c4f:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            r15 = 1
            if (r9 != r15) goto L_0x0c84
            com.google.android.gms.internal.measurement.zzjj r1 = r8.zzv()
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1
            com.google.android.gms.internal.measurement.zzcc$zzc r1 = (com.google.android.gms.internal.measurement.zzcc.zzc) r1
            r3.add(r1)
            boolean r1 = r12.booleanValue()
            if (r1 == 0) goto L_0x0c7f
            java.lang.Long r1 = r11.zzi
            if (r1 != 0) goto L_0x0c73
            java.lang.Long r1 = r11.zzj
            if (r1 != 0) goto L_0x0c73
            java.lang.Boolean r1 = r11.zzk
            if (r1 == 0) goto L_0x0c7f
        L_0x0c73:
            r1 = 0
            com.google.android.gms.measurement.internal.zzak r9 = r11.zza(r1, r1, r1)
            java.lang.String r1 = r8.zzd()
            r2.put(r1, r9)
        L_0x0c7f:
            r6.zza(r7, r8)
            goto L_0x0b04
        L_0x0c84:
            int r15 = r5.nextInt(r9)
            if (r15 != 0) goto L_0x0cc6
            com.google.android.gms.measurement.internal.zzks r1 = r43.zzh()
            r44 = r4
            r15 = r5
            long r4 = (long) r9
            java.lang.Long r9 = java.lang.Long.valueOf(r4)
            r1.zza(r8, r10, r9)
            com.google.android.gms.internal.measurement.zzjj r1 = r8.zzv()
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1
            com.google.android.gms.internal.measurement.zzcc$zzc r1 = (com.google.android.gms.internal.measurement.zzcc.zzc) r1
            r3.add(r1)
            boolean r1 = r12.booleanValue()
            if (r1 == 0) goto L_0x0cb3
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            r4 = 0
            com.google.android.gms.measurement.internal.zzak r11 = r11.zza(r4, r1, r4)
        L_0x0cb3:
            java.lang.String r1 = r8.zzd()
            long r4 = r8.zzf()
            com.google.android.gms.measurement.internal.zzak r4 = r11.zza(r4, r13)
            r2.put(r1, r4)
            r1 = r6
            r4 = r7
            goto L_0x0d51
        L_0x0cc6:
            r44 = r4
            r15 = r5
            java.lang.Long r4 = r11.zzh
            if (r4 == 0) goto L_0x0cd8
            java.lang.Long r4 = r11.zzh
            long r4 = r4.longValue()
            r30 = r6
            r16 = r7
            goto L_0x0ced
        L_0x0cd8:
            r4 = r43
            com.google.android.gms.measurement.internal.zzgd r5 = r4.zzj
            r5.zzi()
            long r4 = r8.zzg()
            r30 = r6
            r16 = r7
            r6 = r20
            long r4 = com.google.android.gms.measurement.internal.zzkw.zza(r4, r6)
        L_0x0ced:
            int r6 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r6 == 0) goto L_0x0d3b
            com.google.android.gms.measurement.internal.zzks r1 = r43.zzh()
            java.lang.String r4 = "_efs"
            r5 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r5)
            r1.zza(r8, r4, r7)
            com.google.android.gms.measurement.internal.zzks r1 = r43.zzh()
            long r5 = (long) r9
            java.lang.Long r4 = java.lang.Long.valueOf(r5)
            r1.zza(r8, r10, r4)
            com.google.android.gms.internal.measurement.zzjj r1 = r8.zzv()
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1
            com.google.android.gms.internal.measurement.zzcc$zzc r1 = (com.google.android.gms.internal.measurement.zzcc.zzc) r1
            r3.add(r1)
            boolean r1 = r12.booleanValue()
            if (r1 == 0) goto L_0x0d2b
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            r4 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
            r4 = 0
            com.google.android.gms.measurement.internal.zzak r11 = r11.zza(r4, r1, r5)
        L_0x0d2b:
            java.lang.String r1 = r8.zzd()
            long r4 = r8.zzf()
            com.google.android.gms.measurement.internal.zzak r4 = r11.zza(r4, r13)
            r2.put(r1, r4)
            goto L_0x0d4d
        L_0x0d3b:
            boolean r4 = r12.booleanValue()
            if (r4 == 0) goto L_0x0d4d
            java.lang.String r4 = r8.zzd()
            r5 = 0
            com.google.android.gms.measurement.internal.zzak r1 = r11.zza(r1, r5, r5)
            r2.put(r4, r1)
        L_0x0d4d:
            r4 = r16
            r1 = r30
        L_0x0d51:
            r1.zza(r4, r8)
        L_0x0d54:
            int r7 = r4 + 1
            r4 = r44
            r6 = r1
            r5 = r15
            r1 = r43
            goto L_0x0a75
        L_0x0d5e:
            r44 = r4
            r1 = r6
            int r4 = r3.size()
            int r5 = r1.zzb()
            if (r4 >= r5) goto L_0x0d72
            com.google.android.gms.internal.measurement.zzcc$zzg$zza r4 = r1.zzc()
            r4.zza(r3)
        L_0x0d72:
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0d7a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0d9c
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            com.google.android.gms.measurement.internal.zzad r4 = r43.zze()
            java.lang.Object r3 = r3.getValue()
            com.google.android.gms.measurement.internal.zzak r3 = (com.google.android.gms.measurement.internal.zzak) r3
            r4.zza(r3)
            goto L_0x0d7a
        L_0x0d94:
            r0 = move-exception
            r2 = r43
            goto L_0x0f60
        L_0x0d99:
            r44 = r4
            r1 = r6
        L_0x0d9c:
            r2 = r43
            com.google.android.gms.measurement.internal.zzgd r3 = r2.zzj     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.measurement.internal.zzy r3 = r3.zzb()     // Catch:{ all -> 0x0f5c }
            java.lang.String r4 = r1.zzj()     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzaq.zzbm     // Catch:{ all -> 0x0f5c }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x0f5c }
            if (r3 != 0) goto L_0x0db3
            zza(r1)     // Catch:{ all -> 0x0f5c }
        L_0x0db3:
            r3 = r44
            com.google.android.gms.internal.measurement.zzcc$zzg r4 = r3.zza     // Catch:{ all -> 0x0f5c }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.measurement.internal.zzad r5 = r43.zze()     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.measurement.internal.zzf r5 = r5.zzb(r4)     // Catch:{ all -> 0x0f5c }
            if (r5 != 0) goto L_0x0ddf
            com.google.android.gms.measurement.internal.zzgd r5 = r2.zzj     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzr()     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzf()     // Catch:{ all -> 0x0f5c }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r7 = r3.zza     // Catch:{ all -> 0x0f5c }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0f5c }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzez.zza(r7)     // Catch:{ all -> 0x0f5c }
            r5.zza(r6, r7)     // Catch:{ all -> 0x0f5c }
            goto L_0x0e3a
        L_0x0ddf:
            int r6 = r1.zzb()     // Catch:{ all -> 0x0f5c }
            if (r6 <= 0) goto L_0x0e3a
            long r6 = r5.zzk()     // Catch:{ all -> 0x0f5c }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0df3
            r1.zze(r6)     // Catch:{ all -> 0x0f5c }
            goto L_0x0df6
        L_0x0df3:
            r1.zzi()     // Catch:{ all -> 0x0f5c }
        L_0x0df6:
            long r8 = r5.zzj()     // Catch:{ all -> 0x0f5c }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0e01
            goto L_0x0e02
        L_0x0e01:
            r6 = r8
        L_0x0e02:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0e0a
            r1.zzd(r6)     // Catch:{ all -> 0x0f5c }
            goto L_0x0e0d
        L_0x0e0a:
            r1.zzh()     // Catch:{ all -> 0x0f5c }
        L_0x0e0d:
            r5.zzv()     // Catch:{ all -> 0x0f5c }
            long r6 = r5.zzs()     // Catch:{ all -> 0x0f5c }
            int r7 = (int) r6     // Catch:{ all -> 0x0f5c }
            r1.zzg(r7)     // Catch:{ all -> 0x0f5c }
            long r6 = r1.zzf()     // Catch:{ all -> 0x0f5c }
            r5.zza(r6)     // Catch:{ all -> 0x0f5c }
            long r6 = r1.zzg()     // Catch:{ all -> 0x0f5c }
            r5.zzb(r6)     // Catch:{ all -> 0x0f5c }
            java.lang.String r6 = r5.zzad()     // Catch:{ all -> 0x0f5c }
            if (r6 == 0) goto L_0x0e30
            r1.zzj(r6)     // Catch:{ all -> 0x0f5c }
            goto L_0x0e33
        L_0x0e30:
            r1.zzk()     // Catch:{ all -> 0x0f5c }
        L_0x0e33:
            com.google.android.gms.measurement.internal.zzad r6 = r43.zze()     // Catch:{ all -> 0x0f5c }
            r6.zza(r5)     // Catch:{ all -> 0x0f5c }
        L_0x0e3a:
            int r5 = r1.zzb()     // Catch:{ all -> 0x0f5c }
            if (r5 <= 0) goto L_0x0ea0
            com.google.android.gms.measurement.internal.zzgd r5 = r2.zzj     // Catch:{ all -> 0x0f5c }
            r5.zzu()     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.measurement.internal.zzfx r5 = r43.zzc()     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.internal.measurement.zzcc$zzg r6 = r3.zza     // Catch:{ all -> 0x0f5c }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.internal.measurement.zzca$zzb r5 = r5.zza(r6)     // Catch:{ all -> 0x0f5c }
            if (r5 == 0) goto L_0x0e64
            boolean r6 = r5.zza()     // Catch:{ all -> 0x0f5c }
            if (r6 != 0) goto L_0x0e5c
            goto L_0x0e64
        L_0x0e5c:
            long r5 = r5.zzb()     // Catch:{ all -> 0x0f5c }
            r1.zzi(r5)     // Catch:{ all -> 0x0f5c }
            goto L_0x0e8f
        L_0x0e64:
            com.google.android.gms.internal.measurement.zzcc$zzg r5 = r3.zza     // Catch:{ all -> 0x0f5c }
            java.lang.String r5 = r5.zzam()     // Catch:{ all -> 0x0f5c }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0f5c }
            if (r5 == 0) goto L_0x0e76
            r5 = -1
            r1.zzi(r5)     // Catch:{ all -> 0x0f5c }
            goto L_0x0e8f
        L_0x0e76:
            com.google.android.gms.measurement.internal.zzgd r5 = r2.zzj     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzr()     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzi()     // Catch:{ all -> 0x0f5c }
            java.lang.String r6 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzcc$zzg r7 = r3.zza     // Catch:{ all -> 0x0f5c }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0f5c }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzez.zza(r7)     // Catch:{ all -> 0x0f5c }
            r5.zza(r6, r7)     // Catch:{ all -> 0x0f5c }
        L_0x0e8f:
            com.google.android.gms.measurement.internal.zzad r5 = r43.zze()     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.internal.measurement.zzjj r1 = r1.zzv()     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.internal.measurement.zzcc$zzg r1 = (com.google.android.gms.internal.measurement.zzcc.zzg) r1     // Catch:{ all -> 0x0f5c }
            r13 = r19
            r5.zza(r1, r13)     // Catch:{ all -> 0x0f5c }
        L_0x0ea0:
            com.google.android.gms.measurement.internal.zzad r1 = r43.zze()     // Catch:{ all -> 0x0f5c }
            java.util.List<java.lang.Long> r3 = r3.zzb     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0f5c }
            r1.zzd()     // Catch:{ all -> 0x0f5c }
            r1.zzak()     // Catch:{ all -> 0x0f5c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0f5c }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0f5c }
            r6 = 0
        L_0x0eb7:
            int r7 = r3.size()     // Catch:{ all -> 0x0f5c }
            if (r6 >= r7) goto L_0x0ed4
            if (r6 == 0) goto L_0x0ec4
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0f5c }
        L_0x0ec4:
            java.lang.Object r7 = r3.get(r6)     // Catch:{ all -> 0x0f5c }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0f5c }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0f5c }
            r5.append(r7)     // Catch:{ all -> 0x0f5c }
            int r6 = r6 + 1
            goto L_0x0eb7
        L_0x0ed4:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0f5c }
            android.database.sqlite.SQLiteDatabase r6 = r1.c_()     // Catch:{ all -> 0x0f5c }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0f5c }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0f5c }
            int r6 = r3.size()     // Catch:{ all -> 0x0f5c }
            if (r5 == r6) goto L_0x0f07
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()     // Catch:{ all -> 0x0f5c }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x0f5c }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0f5c }
            int r3 = r3.size()     // Catch:{ all -> 0x0f5c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0f5c }
            r1.zza(r6, r5, r3)     // Catch:{ all -> 0x0f5c }
        L_0x0f07:
            com.google.android.gms.measurement.internal.zzad r1 = r43.zze()     // Catch:{ all -> 0x0f5c }
            android.database.sqlite.SQLiteDatabase r3 = r1.c_()     // Catch:{ all -> 0x0f5c }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0f1e }
            r7 = 0
            r6[r7] = r4     // Catch:{ SQLiteException -> 0x0f1e }
            r7 = 1
            r6[r7] = r4     // Catch:{ SQLiteException -> 0x0f1e }
            r3.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0f1e }
            goto L_0x0f31
        L_0x0f1e:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza(r4)
            r1.zza(r5, r4, r3)
        L_0x0f31:
            com.google.android.gms.measurement.internal.zzad r1 = r43.zze()
            r1.b_()
            com.google.android.gms.measurement.internal.zzad r1 = r43.zze()
            r1.zzh()
            r1 = 1
            return r1
        L_0x0f41:
            r2 = r1
            com.google.android.gms.measurement.internal.zzad r1 = r43.zze()
            r1.b_()
            com.google.android.gms.measurement.internal.zzad r1 = r43.zze()
            r1.zzh()
            r1 = 0
            return r1
        L_0x0f52:
            r0 = move-exception
            r2 = r1
            goto L_0x0237
        L_0x0f56:
            if (r5 == 0) goto L_0x0f5b
            r5.close()
        L_0x0f5b:
            throw r1
        L_0x0f5c:
            r0 = move-exception
            goto L_0x0f60
        L_0x0f5e:
            r0 = move-exception
            r2 = r1
        L_0x0f60:
            r1 = r0
            com.google.android.gms.measurement.internal.zzad r3 = r43.zze()
            r3.zzh()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zza(java.lang.String, long):boolean");
    }

    private static void zza(zzcc.zzg.zza zza2) {
        zza2.zzb(LongCompanionObject.MAX_VALUE).zzc(Long.MIN_VALUE);
        for (int i = 0; i < zza2.zzb(); i++) {
            zzcc.zzc zzb2 = zza2.zzb(i);
            if (zzb2.zze() < zza2.zzf()) {
                zza2.zzb(zzb2.zze());
            }
            if (zzb2.zze() > zza2.zzg()) {
                zza2.zzc(zzb2.zze());
            }
        }
    }

    private final void zza(zzcc.zzg.zza zza2, long j, boolean z) {
        zzkt zzkt;
        String str = z ? "_se" : "_lte";
        zzkt zzc2 = zze().zzc(zza2.zzj(), str);
        if (zzc2 == null || zzc2.zze == null) {
            zzkt = new zzkt(zza2.zzj(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzkt = new zzkt(zza2.zzj(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j));
        }
        zzcc.zzk zzk2 = (zzcc.zzk) ((zzib) zzcc.zzk.zzj().zza(str).zza(this.zzj.zzm().currentTimeMillis()).zzb(((Long) zzkt.zze).longValue()).zzv());
        boolean z2 = false;
        int zza3 = zzks.zza(zza2, str);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzk2);
            z2 = true;
        }
        if (!z2) {
            zza2.zza(zzk2);
        }
        if (j > 0) {
            zze().zza(zzkt);
            this.zzj.zzr().zzx().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzkt.zze);
        }
    }

    private final boolean zza(zzcc.zzc.zza zza2, zzcc.zzc.zza zza3) {
        String str;
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzcc.zze zza4 = zzks.zza((zzcc.zzc) ((zzib) zza2.zzv()), "_sc");
        String str2 = null;
        if (zza4 == null) {
            str = null;
        } else {
            str = zza4.zzd();
        }
        zzh();
        zzcc.zze zza5 = zzks.zza((zzcc.zzc) ((zzib) zza3.zzv()), "_pc");
        if (zza5 != null) {
            str2 = zza5.zzd();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        zzb(zza2, zza3);
        return true;
    }

    private final void zzb(zzcc.zzc.zza zza2, zzcc.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzcc.zze zza4 = zzks.zza((zzcc.zzc) ((zzib) zza2.zzv()), "_et");
        if (zza4.zze() && zza4.zzf() > 0) {
            long zzf2 = zza4.zzf();
            zzh();
            zzcc.zze zza5 = zzks.zza((zzcc.zzc) ((zzib) zza3.zzv()), "_et");
            if (zza5 != null && zza5.zzf() > 0) {
                zzf2 += zza5.zzf();
            }
            zzh().zza(zza3, "_et", Long.valueOf(zzf2));
            zzh().zza(zza2, "_fr", (Object) 1L);
        }
    }

    private static void zza(zzcc.zzc.zza zza2, String str) {
        List<zzcc.zze> zza3 = zza2.zza();
        for (int i = 0; i < zza3.size(); i++) {
            if (str.equals(zza3.get(i).zzb())) {
                zza2.zzb(i);
                return;
            }
        }
    }

    private static void zza(zzcc.zzc.zza zza2, int i, String str) {
        List<zzcc.zze> zza3 = zza2.zza();
        int i2 = 0;
        while (i2 < zza3.size()) {
            if (!"_err".equals(zza3.get(i2).zzb())) {
                i2++;
            } else {
                return;
            }
        }
        zza2.zza((zzcc.zze) ((zzib) zzcc.zze.zzm().zza("_err").zza(Long.valueOf((long) i).longValue()).zzv())).zza((zzcc.zze) ((zzib) zzcc.zze.zzm().zza("_ev").zzb(str).zzv()));
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzw();
        zzk();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzr = false;
                zzaa();
                throw th2;
            }
        }
        List<Long> list = this.zzv;
        this.zzv = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
                this.zzj.zzc().zzd.zza(0);
                zzz();
                this.zzj.zzr().zzx().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zzf();
                try {
                    for (Long l : list) {
                        try {
                            zzad zze2 = zze();
                            long longValue = l.longValue();
                            zze2.zzd();
                            zze2.zzak();
                            try {
                                if (zze2.c_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                                }
                            } catch (SQLiteException e) {
                                zze2.zzr().zzf().zza("Failed to delete a bundle in a queue table", e);
                                throw e;
                            }
                        } catch (SQLiteException e2) {
                            if (this.zzw == null || !this.zzw.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zze().b_();
                    zze().zzh();
                    this.zzw = null;
                    if (!zzd().zzf() || !zzy()) {
                        this.zzx = -1;
                        zzz();
                    } else {
                        zzl();
                    }
                    this.zzm = 0;
                } catch (Throwable th3) {
                    zze().zzh();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzj.zzr().zzf().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzm = this.zzj.zzm().elapsedRealtime();
                this.zzj.zzr().zzx().zza("Disable upload, time", Long.valueOf(this.zzm));
            }
        } else {
            this.zzj.zzr().zzx().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
            if (!(i == 503 || i == 429)) {
                z = false;
            }
            if (z) {
                this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
            }
            zze().zza(list);
            zzz();
        }
        this.zzr = false;
        zzaa();
    }

    private final boolean zzy() {
        zzw();
        zzk();
        return zze().zzy() || !TextUtils.isEmpty(zze().d_());
    }

    private final void zza(zzf zzf2) {
        ArrayMap arrayMap;
        zzw();
        if (!zzoe.zzb() || !this.zzj.zzb().zze(zzf2.zzc(), zzaq.zzbn)) {
            if (TextUtils.isEmpty(zzf2.zze()) && TextUtils.isEmpty(zzf2.zzf())) {
                zza(zzf2.zzc(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(zzf2.zze()) && TextUtils.isEmpty(zzf2.zzg()) && TextUtils.isEmpty(zzf2.zzf())) {
            zza(zzf2.zzc(), 204, null, null, null);
            return;
        }
        String zza2 = this.zzj.zzb().zza(zzf2);
        try {
            URL url = new URL(zza2);
            this.zzj.zzr().zzx().zza("Fetching remote configuration", zzf2.zzc());
            zzca.zzb zza3 = zzc().zza(zzf2.zzc());
            String zzb2 = zzc().zzb(zzf2.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb2)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", zzb2);
                arrayMap = arrayMap2;
            }
            this.zzq = true;
            zzfc zzd2 = zzd();
            String zzc2 = zzf2.zzc();
            zzkp zzkp = new zzkp(this);
            zzd2.zzd();
            zzd2.zzak();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkp);
            zzd2.zzq().zzb(new zzfg(zzd2, zzc2, url, null, arrayMap, zzkp));
        } catch (MalformedURLException unused) {
            this.zzj.zzr().zzf().zza("Failed to parse config URL. Not fetching. appId", zzez.zza(zzf2.zzc()), zza2);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzw()
            r6.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0196 }
        L_0x000e:
            com.google.android.gms.measurement.internal.zzgd r1 = r6.zzj     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x0196 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0196 }
            r1.zza(r2, r3)     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzad r1 = r6.zze()     // Catch:{ all -> 0x0196 }
            r1.zzf()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzad r1 = r6.zze()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzf r1 = r1.zzb(r7)     // Catch:{ all -> 0x018d }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003e
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003e
            if (r8 != r3) goto L_0x0042
        L_0x003e:
            if (r9 != 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            if (r1 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzgd r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzr()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzi()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzez.zza(r7)     // Catch:{ all -> 0x018d }
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x005a:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ca
            if (r8 != r5) goto L_0x0061
            goto L_0x00ca
        L_0x0061:
            com.google.android.gms.measurement.internal.zzgd r10 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r10 = r10.zzm()     // Catch:{ all -> 0x018d }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzi(r10)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzad r10 = r6.zze()     // Catch:{ all -> 0x018d }
            r10.zza(r1)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzgd r10 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzez r10 = r10.zzr()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfb r10 = r10.zzx()     // Catch:{ all -> 0x018d }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            r10.zza(r11, r1, r9)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfx r9 = r6.zzc()     // Catch:{ all -> 0x018d }
            r9.zzc(r7)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzgd r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfl r7 = r7.zzc()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfp r7 = r7.zzd     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzgd r9 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzm()     // Catch:{ all -> 0x018d }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.zza(r9)     // Catch:{ all -> 0x018d }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00ae
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r4 = 0
        L_0x00ae:
            if (r4 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzgd r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfl r7 = r7.zzc()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfp r7 = r7.zze     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzgd r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r8 = r8.zzm()     // Catch:{ all -> 0x018d }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.zza(r8)     // Catch:{ all -> 0x018d }
        L_0x00c5:
            r6.zzz()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x00ca:
            r9 = 0
            if (r11 == 0) goto L_0x00d6
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x018d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x018d }
            goto L_0x00d7
        L_0x00d6:
            r11 = r9
        L_0x00d7:
            if (r11 == 0) goto L_0x00e6
            int r2 = r11.size()     // Catch:{ all -> 0x018d }
            if (r2 <= 0) goto L_0x00e6
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x018d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x018d }
            goto L_0x00e7
        L_0x00e6:
            r11 = r9
        L_0x00e7:
            if (r8 == r5) goto L_0x0103
            if (r8 != r3) goto L_0x00ec
            goto L_0x0103
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzfx r9 = r6.zzc()     // Catch:{ all -> 0x018d }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzad r7 = r6.zze()
            r7.zzh()
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x0103:
            com.google.android.gms.measurement.internal.zzfx r11 = r6.zzc()
            com.google.android.gms.internal.measurement.zzca$zzb r11 = r11.zza(r7)
            if (r11 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzfx r11 = r6.zzc()
            boolean r9 = r11.zza(r7, r9, r9)
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzad r7 = r6.zze()
            r7.zzh()
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x0124:
            com.google.android.gms.measurement.internal.zzgd r9 = r6.zzj
            com.google.android.gms.common.util.Clock r9 = r9.zzm()
            long r2 = r9.currentTimeMillis()
            r1.zzh(r2)
            com.google.android.gms.measurement.internal.zzad r9 = r6.zze()
            r9.zza(r1)
            if (r8 != r5) goto L_0x014a
            com.google.android.gms.measurement.internal.zzgd r8 = r6.zzj
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzr()
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzk()
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zza(r9, r7)
            goto L_0x0162
        L_0x014a:
            com.google.android.gms.measurement.internal.zzgd r7 = r6.zzj
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzr()
            com.google.android.gms.measurement.internal.zzfb r7 = r7.zzx()
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            int r10 = r10.length
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r7.zza(r9, r8, r10)
        L_0x0162:
            com.google.android.gms.measurement.internal.zzfc r7 = r6.zzd()
            boolean r7 = r7.zzf()
            if (r7 == 0) goto L_0x0176
            boolean r7 = r6.zzy()
            if (r7 == 0) goto L_0x0176
            r6.zzl()
            goto L_0x0179
        L_0x0176:
            r6.zzz()
        L_0x0179:
            com.google.android.gms.measurement.internal.zzad r7 = r6.zze()
            r7.b_()
            com.google.android.gms.measurement.internal.zzad r7 = r6.zze()
            r7.zzh()
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x018d:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzad r8 = r6.zze()
            r8.zzh()
            throw r7
        L_0x0196:
            r7 = move-exception
            r6.zzq = r0
            r6.zzaa()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzz() {
        /*
            r21 = this;
            r0 = r21
            r21.zzw()
            r21.zzk()
            long r1 = r0.zzm
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004d
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.elapsedRealtime()
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r0.zzm
            long r1 = r1 - r7
            long r1 = java.lang.Math.abs(r1)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004b
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            java.lang.String r3 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzfj r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkg r1 = r21.zzv()
            r1.zzf()
            return
        L_0x004b:
            r0.zzm = r3
        L_0x004d:
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            boolean r1 = r1.zzag()
            if (r1 == 0) goto L_0x0255
            boolean r1 = r21.zzy()
            if (r1 != 0) goto L_0x005d
            goto L_0x0255
        L_0x005d:
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzaq.zzz
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzad r5 = r21.zze()
            boolean r5 = r5.zzz()
            if (r5 != 0) goto L_0x008f
            com.google.android.gms.measurement.internal.zzad r5 = r21.zze()
            boolean r5 = r5.zzk()
            if (r5 == 0) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            r5 = 0
            goto L_0x0090
        L_0x008f:
            r5 = 1
        L_0x0090:
            if (r5 == 0) goto L_0x00cc
            com.google.android.gms.measurement.internal.zzgd r10 = r0.zzj
            com.google.android.gms.measurement.internal.zzy r10 = r10.zzb()
            java.lang.String r10 = r10.zzw()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x00bb
            java.lang.String r11 = ".none."
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00bb
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzaq.zzu
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00dc
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzaq.zzt
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00dc
        L_0x00cc:
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzaq.zzs
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzgd r12 = r0.zzj
            com.google.android.gms.measurement.internal.zzfl r12 = r12.zzc()
            com.google.android.gms.measurement.internal.zzfp r12 = r12.zzc
            long r12 = r12.zza()
            com.google.android.gms.measurement.internal.zzgd r14 = r0.zzj
            com.google.android.gms.measurement.internal.zzfl r14 = r14.zzc()
            com.google.android.gms.measurement.internal.zzfp r14 = r14.zzd
            long r14 = r14.zza()
            com.google.android.gms.measurement.internal.zzad r16 = r21.zze()
            r17 = r10
            long r9 = r16.zzw()
            com.google.android.gms.measurement.internal.zzad r11 = r21.zze()
            r19 = r7
            long r6 = r11.zzx()
            long r6 = java.lang.Math.max(r9, r6)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0113
        L_0x0110:
            r10 = r3
            goto L_0x0188
        L_0x0113:
            long r6 = r6 - r1
            long r6 = java.lang.Math.abs(r6)
            long r6 = r1 - r6
            long r12 = r12 - r1
            long r8 = java.lang.Math.abs(r12)
            long r8 = r1 - r8
            long r14 = r14 - r1
            long r10 = java.lang.Math.abs(r14)
            long r1 = r1 - r10
            long r8 = java.lang.Math.max(r8, r1)
            long r10 = r6 + r19
            if (r5 == 0) goto L_0x0139
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0139
            long r10 = java.lang.Math.min(r6, r8)
            long r10 = r10 + r17
        L_0x0139:
            com.google.android.gms.measurement.internal.zzks r5 = r21.zzh()
            r12 = r17
            boolean r5 = r5.zza(r8, r12)
            if (r5 != 0) goto L_0x0147
            long r10 = r8 + r12
        L_0x0147:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0188
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x0188
            r5 = 0
        L_0x0150:
            r6 = 20
            com.google.android.gms.measurement.internal.zzeo<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzaq.zzab
            r8 = 0
            java.lang.Object r7 = r7.zza(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r9 = 0
            int r7 = java.lang.Math.max(r9, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x0110
            r6 = 1
            long r6 = r6 << r5
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r12 = com.google.android.gms.measurement.internal.zzaq.zzaa
            java.lang.Object r12 = r12.zza(r8)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            long r12 = r12 * r6
            long r10 = r10 + r12
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x0185
            goto L_0x0188
        L_0x0185:
            int r5 = r5 + 1
            goto L_0x0150
        L_0x0188:
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x01aa
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfj r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkg r1 = r21.zzv()
            r1.zzf()
            return
        L_0x01aa:
            com.google.android.gms.measurement.internal.zzfc r1 = r21.zzd()
            boolean r1 = r1.zzf()
            if (r1 != 0) goto L_0x01d2
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfj r1 = r21.zzt()
            r1.zza()
            com.google.android.gms.measurement.internal.zzkg r1 = r21.zzv()
            r1.zzf()
            return
        L_0x01d2:
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzfl r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzfp r1 = r1.zze
            long r1 = r1.zza()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzaq.zzq
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzks r7 = r21.zzh()
            boolean r7 = r7.zza(r1, r5)
            if (r7 != 0) goto L_0x01fe
            long r1 = r1 + r5
            long r10 = java.lang.Math.max(r10, r1)
        L_0x01fe:
            com.google.android.gms.measurement.internal.zzfj r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.currentTimeMillis()
            long r10 = r10 - r1
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x023a
            com.google.android.gms.measurement.internal.zzeo<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzaq.zzv
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r10 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzfl r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzfp r1 = r1.zzc
            com.google.android.gms.measurement.internal.zzgd r2 = r0.zzj
            com.google.android.gms.common.util.Clock r2 = r2.zzm()
            long r2 = r2.currentTimeMillis()
            r1.zza(r2)
        L_0x023a:
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzkg r1 = r21.zzv()
            r1.zza(r10)
            return
        L_0x0255:
            com.google.android.gms.measurement.internal.zzgd r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzx()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfj r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkg r1 = r21.zzv()
            r1.zzf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zzz():void");
    }

    /* access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        zzw();
        if (this.zzn == null) {
            this.zzn = new ArrayList();
        }
        this.zzn.add(runnable);
    }

    private final void zzaa() {
        zzw();
        if (this.zzq || this.zzr || this.zzs) {
            this.zzj.zzr().zzx().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs));
            return;
        }
        this.zzj.zzr().zzx().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzn;
        if (list != null) {
            for (Runnable runnable : list) {
                runnable.run();
            }
            this.zzn.clear();
        }
    }

    private final Boolean zzb(zzf zzf2) {
        try {
            if (zzf2.zzm() != -2147483648L) {
                if (zzf2.zzm() == ((long) Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzf2.zzc(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzf2.zzc(), 0).versionName;
                if (zzf2.zzl() != null && zzf2.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzo() {
        zzw();
        zzk();
        if (!this.zzl) {
            this.zzl = true;
            if (zzab()) {
                int zza2 = zza(this.zzu);
                int zzaf = this.zzj.zzy().zzaf();
                zzw();
                if (zza2 > zzaf) {
                    this.zzj.zzr().zzf().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                } else if (zza2 >= zzaf) {
                } else {
                    if (zza(zzaf, this.zzu)) {
                        this.zzj.zzr().zzx().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    } else {
                        this.zzj.zzr().zzf().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    }
                }
            }
        }
    }

    private final boolean zzab() {
        FileLock fileLock;
        zzw();
        if (!this.zzj.zzb().zza(zzaq.zzbl) || (fileLock = this.zzt) == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzj.zzn().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzu = channel;
                FileLock tryLock = channel.tryLock();
                this.zzt = tryLock;
                if (tryLock != null) {
                    this.zzj.zzr().zzx().zza("Storage concurrent access okay");
                    return true;
                }
                this.zzj.zzr().zzf().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                this.zzj.zzr().zzf().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                this.zzj.zzr().zzf().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                this.zzj.zzr().zzi().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            this.zzj.zzr().zzx().zza("Storage concurrent access okay");
            return true;
        }
    }

    private final int zza(FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzj.zzr().zzi().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to read from channel", e);
            return 0;
        }
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            if (this.zzj.zzb().zza(zzaq.zzby) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0L);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzr().zzf().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzn zzn2) {
        if (this.zzv != null) {
            ArrayList arrayList = new ArrayList();
            this.zzw = arrayList;
            arrayList.addAll(this.zzv);
        }
        zzad zze2 = zze();
        String str = zzn2.zza;
        Preconditions.checkNotEmpty(str);
        zze2.zzd();
        zze2.zzak();
        try {
            SQLiteDatabase c_ = zze2.c_();
            String[] strArr = {str};
            int delete = c_.delete("apps", "app_id=?", strArr) + 0 + c_.delete("events", "app_id=?", strArr) + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("queue", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("main_event_params", "app_id=?", strArr) + c_.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze2.zzr().zzx().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze2.zzr().zzf().zza("Error resetting analytics data. appId, error", zzez.zza(str), e);
        }
        if (zzn2.zzh) {
            zzb(zzn2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkr zzkr, zzn zzn2) {
        zzw();
        zzk();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            int zzc2 = this.zzj.zzi().zzc(zzkr.zza);
            if (zzc2 != 0) {
                this.zzj.zzi();
                this.zzj.zzi().zza(zzn2.zza, zzc2, "_ev", zzkw.zza(zzkr.zza, 24, true), zzkr.zza != null ? zzkr.zza.length() : 0);
                return;
            }
            int zzb2 = this.zzj.zzi().zzb(zzkr.zza, zzkr.zza());
            if (zzb2 != 0) {
                this.zzj.zzi();
                String zza2 = zzkw.zza(zzkr.zza, 24, true);
                Object zza3 = zzkr.zza();
                this.zzj.zzi().zza(zzn2.zza, zzb2, "_ev", zza2, (zza3 == null || (!(zza3 instanceof String) && !(zza3 instanceof CharSequence))) ? 0 : String.valueOf(zza3).length());
                return;
            }
            Object zzc3 = this.zzj.zzi().zzc(zzkr.zza, zzkr.zza());
            if (zzc3 != null) {
                if ("_sid".equals(zzkr.zza)) {
                    long j = zzkr.zzb;
                    String str = zzkr.zze;
                    long j2 = 0;
                    zzkt zzc4 = zze().zzc(zzn2.zza, "_sno");
                    if (zzc4 == null || !(zzc4.zze instanceof Long)) {
                        if (zzc4 != null) {
                            this.zzj.zzr().zzi().zza("Retrieved last session number from database does not contain a valid (long) value", zzc4.zze);
                        }
                        zzak zza4 = zze().zza(zzn2.zza, "_s");
                        if (zza4 != null) {
                            j2 = zza4.zzc;
                            this.zzj.zzr().zzx().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                        }
                    } else {
                        j2 = ((Long) zzc4.zze).longValue();
                    }
                    zza(new zzkr("_sno", j, Long.valueOf(j2 + 1), str), zzn2);
                }
                zzkt zzkt = new zzkt(zzn2.zza, zzkr.zze, zzkr.zza, zzkr.zzb, zzc3);
                this.zzj.zzr().zzx().zza("Setting user property", this.zzj.zzj().zzc(zzkt.zzc), zzc3);
                zze().zzf();
                try {
                    zzc(zzn2);
                    boolean zza5 = zze().zza(zzkt);
                    zze().b_();
                    if (!zza5) {
                        this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzj().zzc(zzkt.zzc), zzkt.zze);
                        this.zzj.zzi().zza(zzn2.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zze().zzh();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzkr zzkr, zzn zzn2) {
        zzw();
        zzk();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
            } else if (!"_npa".equals(zzkr.zza) || zzn2.zzs == null) {
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkr.zza));
                zze().zzf();
                try {
                    zzc(zzn2);
                    zze().zzb(zzn2.zza, zzkr.zza);
                    zze().b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkr.zza));
                } finally {
                    zze().zzh();
                }
            } else {
                this.zzj.zzr().zzw().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzkr("_npa", this.zzj.zzm().currentTimeMillis(), Long.valueOf(zzn2.zzs.booleanValue() ? 1 : 0), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzn2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkl zzkl) {
        this.zzo++;
    }

    /* access modifiers changed from: package-private */
    public final void zzp() {
        this.zzp++;
    }

    /* access modifiers changed from: package-private */
    public final zzgd zzs() {
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x048d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011b A[Catch:{ all -> 0x04b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x024f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.measurement.internal.zzn r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "_uwa"
            java.lang.String r0 = "app_id=?"
            r21.zzw()
            r21.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r22)
            java.lang.String r7 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            boolean r7 = r21.zze(r22)
            if (r7 != 0) goto L_0x0023
            return
        L_0x0023:
            com.google.android.gms.measurement.internal.zzad r7 = r21.zze()
            java.lang.String r8 = r2.zza
            com.google.android.gms.measurement.internal.zzf r7 = r7.zzb(r8)
            r8 = 0
            if (r7 == 0) goto L_0x0056
            java.lang.String r10 = r7.zze()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0056
            java.lang.String r10 = r2.zzb
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0056
            r7.zzh(r8)
            com.google.android.gms.measurement.internal.zzad r10 = r21.zze()
            r10.zza(r7)
            com.google.android.gms.measurement.internal.zzfx r7 = r21.zzc()
            java.lang.String r10 = r2.zza
            r7.zzd(r10)
        L_0x0056:
            boolean r7 = r2.zzh
            if (r7 != 0) goto L_0x005e
            r21.zzc(r22)
            return
        L_0x005e:
            long r10 = r2.zzm
            int r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x006e
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.common.util.Clock r7 = r7.zzm()
            long r10 = r7.currentTimeMillis()
        L_0x006e:
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzai r7 = r7.zzx()
            r7.zzi()
            int r7 = r2.zzn
            r15 = 1
            if (r7 == 0) goto L_0x0098
            if (r7 == r15) goto L_0x0098
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r12 = r12.zzr()
            com.google.android.gms.measurement.internal.zzfb r12 = r12.zzi()
            java.lang.String r13 = r2.zza
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzez.zza(r13)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r14 = "Incorrect app type, assuming installed app. appId, appType"
            r12.zza(r14, r13, r7)
            r7 = 0
        L_0x0098:
            com.google.android.gms.measurement.internal.zzad r12 = r21.zze()
            r12.zzf()
            com.google.android.gms.measurement.internal.zzad r12 = r21.zze()     // Catch:{ all -> 0x04b9 }
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x04b9 }
            java.lang.String r14 = "_npa"
            com.google.android.gms.measurement.internal.zzkt r14 = r12.zzc(r13, r14)     // Catch:{ all -> 0x04b9 }
            if (r14 == 0) goto L_0x00bc
            java.lang.String r12 = "auto"
            java.lang.String r13 = r14.zzb     // Catch:{ all -> 0x04b9 }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x04b9 }
            if (r12 == 0) goto L_0x00b8
            goto L_0x00bc
        L_0x00b8:
            r18 = r3
            r3 = 1
            goto L_0x010f
        L_0x00bc:
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x04b9 }
            if (r12 == 0) goto L_0x00f9
            com.google.android.gms.measurement.internal.zzkr r13 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ all -> 0x04b9 }
            java.lang.String r18 = "_npa"
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x04b9 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x04b9 }
            if (r12 == 0) goto L_0x00cf
            r19 = 1
            goto L_0x00d1
        L_0x00cf:
            r19 = r8
        L_0x00d1:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x04b9 }
            java.lang.String r20 = "auto"
            r8 = 1
            r12 = r13
            r8 = r13
            r13 = r18
            r18 = r3
            r9 = r14
            r3 = 1
            r14 = r10
            r16 = r19
            r17 = r20
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04b9 }
            if (r9 == 0) goto L_0x00f5
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x04b9 }
            java.lang.Long r12 = r8.zzc     // Catch:{ all -> 0x04b9 }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x04b9 }
            if (r9 != 0) goto L_0x010f
        L_0x00f5:
            r1.zza(r8, r2)     // Catch:{ all -> 0x04b9 }
            goto L_0x010f
        L_0x00f9:
            r18 = r3
            r9 = r14
            r3 = 1
            if (r9 == 0) goto L_0x010f
            com.google.android.gms.measurement.internal.zzkr r8 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ all -> 0x04b9 }
            java.lang.String r13 = "_npa"
            r16 = 0
            java.lang.String r17 = "auto"
            r12 = r8
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04b9 }
            r1.zzb(r8, r2)     // Catch:{ all -> 0x04b9 }
        L_0x010f:
            com.google.android.gms.measurement.internal.zzad r8 = r21.zze()     // Catch:{ all -> 0x04b9 }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04b9 }
            com.google.android.gms.measurement.internal.zzf r8 = r8.zzb(r9)     // Catch:{ all -> 0x04b9 }
            if (r8 == 0) goto L_0x01ca
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzj     // Catch:{ all -> 0x04b9 }
            r12.zzi()     // Catch:{ all -> 0x04b9 }
            java.lang.String r12 = r2.zzb     // Catch:{ all -> 0x04b9 }
            java.lang.String r13 = r8.zze()     // Catch:{ all -> 0x04b9 }
            java.lang.String r14 = r2.zzr     // Catch:{ all -> 0x04b9 }
            java.lang.String r15 = r8.zzf()     // Catch:{ all -> 0x04b9 }
            boolean r12 = com.google.android.gms.measurement.internal.zzkw.zza(r12, r13, r14, r15)     // Catch:{ all -> 0x04b9 }
            if (r12 == 0) goto L_0x01ca
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzj     // Catch:{ all -> 0x04b9 }
            com.google.android.gms.measurement.internal.zzez r12 = r12.zzr()     // Catch:{ all -> 0x04b9 }
            com.google.android.gms.measurement.internal.zzfb r12 = r12.zzi()     // Catch:{ all -> 0x04b9 }
            java.lang.String r13 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r14 = r8.zzc()     // Catch:{ all -> 0x04b9 }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzez.zza(r14)     // Catch:{ all -> 0x04b9 }
            r12.zza(r13, r14)     // Catch:{ all -> 0x04b9 }
            com.google.android.gms.measurement.internal.zzad r12 = r21.zze()     // Catch:{ all -> 0x04b9 }
            java.lang.String r8 = r8.zzc()     // Catch:{ all -> 0x04b9 }
            r12.zzak()     // Catch:{ all -> 0x04b9 }
            r12.zzd()     // Catch:{ all -> 0x04b9 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x04b9 }
            android.database.sqlite.SQLiteDatabase r13 = r12.c_()     // Catch:{ SQLiteException -> 0x01b7 }
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x01b7 }
            r15 = 0
            r14[r15] = r8     // Catch:{ SQLiteException -> 0x01b7 }
            java.lang.String r9 = "events"
            int r9 = r13.delete(r9, r0, r14)     // Catch:{ SQLiteException -> 0x01b7 }
            int r9 = r9 + r15
            java.lang.String r15 = "user_attributes"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b7 }
            int r9 = r9 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b7 }
            int r9 = r9 + r15
            java.lang.String r15 = "apps"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b7 }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b7 }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b7 }
            int r9 = r9 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b7 }
            int r9 = r9 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b7 }
            int r9 = r9 + r15
            java.lang.String r15 = "audience_filter_values"
            int r0 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b7 }
            int r9 = r9 + r0
            if (r9 <= 0) goto L_0x01c9
            com.google.android.gms.measurement.internal.zzez r0 = r12.zzr()     // Catch:{ SQLiteException -> 0x01b7 }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzx()     // Catch:{ SQLiteException -> 0x01b7 }
            java.lang.String r13 = "Deleted application data. app, records"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ SQLiteException -> 0x01b7 }
            r0.zza(r13, r8, r9)     // Catch:{ SQLiteException -> 0x01b7 }
            goto L_0x01c9
        L_0x01b7:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzez r9 = r12.zzr()
            com.google.android.gms.measurement.internal.zzfb r9 = r9.zzf()
            java.lang.String r12 = "Error deleting application data. appId, error"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzez.zza(r8)
            r9.zza(r12, r8, r0)
        L_0x01c9:
            r8 = 0
        L_0x01ca:
            if (r8 == 0) goto L_0x0229
            long r12 = r8.zzm()
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x01e4
            long r12 = r8.zzm()
            r9 = r4
            long r3 = r2.zzj
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x01e5
            r0 = 1
            goto L_0x01e6
        L_0x01e4:
            r9 = r4
        L_0x01e5:
            r0 = 0
        L_0x01e6:
            long r3 = r8.zzm()
            int r12 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r12 != 0) goto L_0x0202
            java.lang.String r3 = r8.zzl()
            if (r3 == 0) goto L_0x0202
            java.lang.String r3 = r8.zzl()
            java.lang.String r4 = r2.zzc
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0202
            r14 = 1
            goto L_0x0203
        L_0x0202:
            r14 = 0
        L_0x0203:
            r0 = r0 | r14
            if (r0 == 0) goto L_0x022a
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r3 = "_pv"
            java.lang.String r4 = r8.zzl()
            r0.putString(r3, r4)
            com.google.android.gms.measurement.internal.zzao r3 = new com.google.android.gms.measurement.internal.zzao
            java.lang.String r13 = "_au"
            com.google.android.gms.measurement.internal.zzan r14 = new com.google.android.gms.measurement.internal.zzan
            r14.<init>(r0)
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)
            r1.zza(r3, r2)
            goto L_0x022a
        L_0x0229:
            r9 = r4
        L_0x022a:
            r21.zzc(r22)
            if (r7 != 0) goto L_0x023c
            com.google.android.gms.measurement.internal.zzad r0 = r21.zze()
            java.lang.String r3 = r2.zza
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzak r0 = r0.zza(r3, r4)
            goto L_0x024d
        L_0x023c:
            r3 = 1
            if (r7 != r3) goto L_0x024c
            com.google.android.gms.measurement.internal.zzad r0 = r21.zze()
            java.lang.String r3 = r2.zza
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.zzak r0 = r0.zza(r3, r4)
            goto L_0x024d
        L_0x024c:
            r0 = 0
        L_0x024d:
            if (r0 != 0) goto L_0x048d
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r12 = r10 / r3
            r14 = 1
            long r12 = r12 + r14
            long r12 = r12 * r3
            java.lang.String r0 = "_dac"
            java.lang.String r3 = "_r"
            java.lang.String r4 = "_c"
            java.lang.String r8 = "_et"
            if (r7 != 0) goto L_0x03eb
            com.google.android.gms.measurement.internal.zzkr r7 = new com.google.android.gms.measurement.internal.zzkr
            java.lang.String r14 = "_fot"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)
            java.lang.String r17 = "auto"
            r12 = r7
            r13 = r14
            r14 = r10
            r12.<init>(r13, r14, r16, r17)
            r1.zza(r7, r2)
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r7 = r7.zzb()
            java.lang.String r12 = r2.zzb
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzaq.zzar
            boolean r7 = r7.zze(r12, r13)
            if (r7 == 0) goto L_0x0294
            r21.zzw()
            com.google.android.gms.measurement.internal.zzgd r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzfq r7 = r7.zzf()
            java.lang.String r12 = r2.zza
            r7.zza(r12)
        L_0x0294:
            r21.zzw()
            r21.zzk()
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            r12 = 1
            r7.putLong(r4, r12)
            r7.putLong(r3, r12)
            r3 = 0
            r7.putLong(r6, r3)
            r7.putLong(r5, r3)
            r7.putLong(r9, r3)
            r14 = r18
            r7.putLong(r14, r3)
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r3 = r3.zzb()
            java.lang.String r4 = r2.zza
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzaq.zzat
            boolean r3 = r3.zze(r4, r12)
            if (r3 == 0) goto L_0x02cd
            r3 = 1
            r7.putLong(r8, r3)
            goto L_0x02cf
        L_0x02cd:
            r3 = 1
        L_0x02cf:
            boolean r12 = r2.zzq
            if (r12 == 0) goto L_0x02d6
            r7.putLong(r0, r3)
        L_0x02d6:
            com.google.android.gms.measurement.internal.zzad r0 = r21.zze()
            java.lang.String r3 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            r0.zzd()
            r0.zzak()
            java.lang.String r4 = "first_open_count"
            long r3 = r0.zzh(r3, r4)
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj
            android.content.Context r0 = r0.zzn()
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            if (r0 != 0) goto L_0x0310
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()
            java.lang.String r6 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r9 = r2.zza
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzez.zza(r9)
            r0.zza(r6, r9)
        L_0x030c:
            r12 = 0
            goto L_0x03cf
        L_0x0310:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x0322 }
            android.content.Context r0 = r0.zzn()     // Catch:{ NameNotFoundException -> 0x0322 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0322 }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x0322 }
            r13 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x0322 }
            goto L_0x0339
        L_0x0322:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r12 = r12.zzr()
            com.google.android.gms.measurement.internal.zzfb r12 = r12.zzf()
            java.lang.String r13 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r15 = r2.zza
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzez.zza(r15)
            r12.zza(r13, r15, r0)
            r0 = 0
        L_0x0339:
            if (r0 == 0) goto L_0x038b
            long r12 = r0.firstInstallTime
            r15 = 0
            int r17 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x038b
            long r12 = r0.firstInstallTime
            r18 = r14
            long r14 = r0.lastUpdateTime
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x036e
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r0 = r0.zzb()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzaq.zzbs
            boolean r0 = r0.zza(r12)
            if (r0 == 0) goto L_0x0367
            r12 = 0
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x036c
            r12 = 1
            r7.putLong(r6, r12)
            goto L_0x036c
        L_0x0367:
            r12 = 1
            r7.putLong(r6, r12)
        L_0x036c:
            r14 = 0
            goto L_0x036f
        L_0x036e:
            r14 = 1
        L_0x036f:
            com.google.android.gms.measurement.internal.zzkr r0 = new com.google.android.gms.measurement.internal.zzkr
            java.lang.String r13 = "_fi"
            if (r14 == 0) goto L_0x0378
            r14 = 1
            goto L_0x037a
        L_0x0378:
            r14 = 0
        L_0x037a:
            java.lang.Long r16 = java.lang.Long.valueOf(r14)
            java.lang.String r17 = "auto"
            r12 = r0
            r6 = r18
            r14 = r10
            r12.<init>(r13, r14, r16, r17)
            r1.zza(r0, r2)
            goto L_0x038c
        L_0x038b:
            r6 = r14
        L_0x038c:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x039e }
            android.content.Context r0 = r0.zzn()     // Catch:{ NameNotFoundException -> 0x039e }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x039e }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x039e }
            r13 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x039e }
            goto L_0x03b5
        L_0x039e:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzj
            com.google.android.gms.measurement.internal.zzez r12 = r12.zzr()
            com.google.android.gms.measurement.internal.zzfb r12 = r12.zzf()
            java.lang.String r13 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r14 = r2.zza
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzez.zza(r14)
            r12.zza(r13, r14, r0)
            r0 = 0
        L_0x03b5:
            if (r0 == 0) goto L_0x030c
            int r12 = r0.flags
            r13 = 1
            r12 = r12 & r13
            if (r12 == 0) goto L_0x03c2
            r12 = 1
            r7.putLong(r9, r12)
        L_0x03c2:
            int r0 = r0.flags
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x030c
            r12 = 1
            r7.putLong(r6, r12)
            goto L_0x030c
        L_0x03cf:
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 < 0) goto L_0x03d6
            r7.putLong(r5, r3)
        L_0x03d6:
            com.google.android.gms.measurement.internal.zzao r0 = new com.google.android.gms.measurement.internal.zzao
            java.lang.String r13 = "_f"
            com.google.android.gms.measurement.internal.zzan r14 = new com.google.android.gms.measurement.internal.zzan
            r14.<init>(r7)
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)
            r1.zzb(r0, r2)
            goto L_0x0447
        L_0x03eb:
            r5 = 1
            if (r7 != r5) goto L_0x0447
            com.google.android.gms.measurement.internal.zzkr r5 = new com.google.android.gms.measurement.internal.zzkr
            java.lang.String r6 = "_fvt"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)
            java.lang.String r17 = "auto"
            r12 = r5
            r13 = r6
            r14 = r10
            r12.<init>(r13, r14, r16, r17)
            r1.zza(r5, r2)
            r21.zzw()
            r21.zzk()
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            r6 = 1
            r5.putLong(r4, r6)
            r5.putLong(r3, r6)
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r3 = r3.zzb()
            java.lang.String r4 = r2.zza
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzaq.zzat
            boolean r3 = r3.zze(r4, r6)
            if (r3 == 0) goto L_0x042a
            r3 = 1
            r5.putLong(r8, r3)
            goto L_0x042c
        L_0x042a:
            r3 = 1
        L_0x042c:
            boolean r6 = r2.zzq
            if (r6 == 0) goto L_0x0433
            r5.putLong(r0, r3)
        L_0x0433:
            com.google.android.gms.measurement.internal.zzao r0 = new com.google.android.gms.measurement.internal.zzao
            java.lang.String r13 = "_v"
            com.google.android.gms.measurement.internal.zzan r14 = new com.google.android.gms.measurement.internal.zzan
            r14.<init>(r5)
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)
            r1.zzb(r0, r2)
        L_0x0447:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r0 = r0.zzb()
            java.lang.String r3 = r2.zza
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzaq.zzau
            boolean r0 = r0.zze(r3, r4)
            if (r0 != 0) goto L_0x04aa
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r3 = 1
            r0.putLong(r8, r3)
            com.google.android.gms.measurement.internal.zzgd r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzy r3 = r3.zzb()
            java.lang.String r4 = r2.zza
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzaq.zzat
            boolean r3 = r3.zze(r4, r5)
            if (r3 == 0) goto L_0x0478
            java.lang.String r3 = "_fr"
            r4 = 1
            r0.putLong(r3, r4)
        L_0x0478:
            com.google.android.gms.measurement.internal.zzao r3 = new com.google.android.gms.measurement.internal.zzao
            java.lang.String r13 = "_e"
            com.google.android.gms.measurement.internal.zzan r14 = new com.google.android.gms.measurement.internal.zzan
            r14.<init>(r0)
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)
            r1.zzb(r3, r2)
            goto L_0x04aa
        L_0x048d:
            boolean r0 = r2.zzi
            if (r0 == 0) goto L_0x04aa
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            com.google.android.gms.measurement.internal.zzao r3 = new com.google.android.gms.measurement.internal.zzao
            java.lang.String r13 = "_cd"
            com.google.android.gms.measurement.internal.zzan r14 = new com.google.android.gms.measurement.internal.zzan
            r14.<init>(r0)
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)
            r1.zzb(r3, r2)
        L_0x04aa:
            com.google.android.gms.measurement.internal.zzad r0 = r21.zze()
            r0.b_()
            com.google.android.gms.measurement.internal.zzad r0 = r21.zze()
            r0.zzh()
            return
        L_0x04b9:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzad r2 = r21.zze()
            r2.zzh()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zzb(com.google.android.gms.measurement.internal.zzn):void");
    }

    private final zzn zza(String str) {
        zzf zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping", str);
            return null;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null || zzb3.booleanValue()) {
            return new zzn(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0L, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zzoe.zzb() || !this.zzj.zzb().zze(str, zzaq.zzbn)) ? null : zzb2.zzg());
        }
        this.zzj.zzr().zzf().zza("App version does not match; dropping. appId", zzez.zza(str));
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzw zzw2) {
        zzn zza2 = zza(zzw2.zza);
        if (zza2 != null) {
            zza(zzw2, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzw zzw2, zzn zzn2) {
        Preconditions.checkNotNull(zzw2);
        Preconditions.checkNotEmpty(zzw2.zza);
        Preconditions.checkNotNull(zzw2.zzb);
        Preconditions.checkNotNull(zzw2.zzc);
        Preconditions.checkNotEmpty(zzw2.zzc.zza);
        zzw();
        zzk();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            zzw zzw3 = new zzw(zzw2);
            boolean z = false;
            zzw3.zze = false;
            zze().zzf();
            try {
                zzw zzd2 = zze().zzd(zzw3.zza, zzw3.zzc.zza);
                if (zzd2 != null && !zzd2.zzb.equals(zzw3.zzb)) {
                    this.zzj.zzr().zzi().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzj().zzc(zzw3.zzc.zza), zzw3.zzb, zzd2.zzb);
                }
                if (zzd2 != null && zzd2.zze) {
                    zzw3.zzb = zzd2.zzb;
                    zzw3.zzd = zzd2.zzd;
                    zzw3.zzh = zzd2.zzh;
                    zzw3.zzf = zzd2.zzf;
                    zzw3.zzi = zzd2.zzi;
                    zzw3.zze = zzd2.zze;
                    zzw3.zzc = new zzkr(zzw3.zzc.zza, zzd2.zzc.zzb, zzw3.zzc.zza(), zzd2.zzc.zze);
                } else if (TextUtils.isEmpty(zzw3.zzf)) {
                    zzw3.zzc = new zzkr(zzw3.zzc.zza, zzw3.zzd, zzw3.zzc.zza(), zzw3.zzc.zze);
                    zzw3.zze = true;
                    z = true;
                }
                if (zzw3.zze) {
                    zzkr zzkr = zzw3.zzc;
                    zzkt zzkt = new zzkt(zzw3.zza, zzw3.zzb, zzkr.zza, zzkr.zzb, zzkr.zza());
                    if (zze().zza(zzkt)) {
                        this.zzj.zzr().zzw().zza("User property updated immediately", zzw3.zza, this.zzj.zzj().zzc(zzkt.zzc), zzkt.zze);
                    } else {
                        this.zzj.zzr().zzf().zza("(2)Too many active user properties, ignoring", zzez.zza(zzw3.zza), this.zzj.zzj().zzc(zzkt.zzc), zzkt.zze);
                    }
                    if (z && zzw3.zzi != null) {
                        zzc(new zzao(zzw3.zzi, zzw3.zzd), zzn2);
                    }
                }
                if (zze().zza(zzw3)) {
                    this.zzj.zzr().zzw().zza("Conditional property added", zzw3.zza, this.zzj.zzj().zzc(zzw3.zzc.zza), zzw3.zzc.zza());
                } else {
                    this.zzj.zzr().zzf().zza("Too many conditional properties, ignoring", zzez.zza(zzw3.zza), this.zzj.zzj().zzc(zzw3.zzc.zza), zzw3.zzc.zza());
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzw zzw2) {
        zzn zza2 = zza(zzw2.zza);
        if (zza2 != null) {
            zzb(zzw2, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzw zzw2, zzn zzn2) {
        Preconditions.checkNotNull(zzw2);
        Preconditions.checkNotEmpty(zzw2.zza);
        Preconditions.checkNotNull(zzw2.zzc);
        Preconditions.checkNotEmpty(zzw2.zzc.zza);
        zzw();
        zzk();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            zze().zzf();
            try {
                zzc(zzn2);
                zzw zzd2 = zze().zzd(zzw2.zza, zzw2.zzc.zza);
                if (zzd2 != null) {
                    this.zzj.zzr().zzw().zza("Removing conditional user property", zzw2.zza, this.zzj.zzj().zzc(zzw2.zzc.zza));
                    zze().zze(zzw2.zza, zzw2.zzc.zza);
                    if (zzd2.zze) {
                        zze().zzb(zzw2.zza, zzw2.zzc.zza);
                    }
                    if (zzw2.zzk != null) {
                        Bundle bundle = null;
                        if (zzw2.zzk.zzb != null) {
                            bundle = zzw2.zzk.zzb.zzb();
                        }
                        zzc(this.zzj.zzi().zza(zzw2.zza, zzw2.zzk.zza, bundle, zzd2.zzb, zzw2.zzk.zzd, true, false), zzn2);
                    }
                } else {
                    this.zzj.zzr().zzi().zza("Conditional user property doesn't exist", zzez.zza(zzw2.zza), this.zzj.zzj().zzc(zzw2.zzc.zza));
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0193  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.zzf zza(com.google.android.gms.measurement.internal.zzn r9, com.google.android.gms.measurement.internal.zzf r10, java.lang.String r11) {
        /*
            r8 = this;
            r0 = 1
            if (r10 != 0) goto L_0x001e
            com.google.android.gms.measurement.internal.zzf r10 = new com.google.android.gms.measurement.internal.zzf
            com.google.android.gms.measurement.internal.zzgd r1 = r8.zzj
            java.lang.String r2 = r9.zza
            r10.<init>(r1, r2)
            com.google.android.gms.measurement.internal.zzgd r1 = r8.zzj
            com.google.android.gms.measurement.internal.zzkw r1 = r1.zzi()
            java.lang.String r1 = r1.zzk()
            r10.zza(r1)
            r10.zze(r11)
        L_0x001c:
            r11 = 1
            goto L_0x003a
        L_0x001e:
            java.lang.String r1 = r10.zzh()
            boolean r1 = r11.equals(r1)
            if (r1 != 0) goto L_0x0039
            r10.zze(r11)
            com.google.android.gms.measurement.internal.zzgd r11 = r8.zzj
            com.google.android.gms.measurement.internal.zzkw r11 = r11.zzi()
            java.lang.String r11 = r11.zzk()
            r10.zza(r11)
            goto L_0x001c
        L_0x0039:
            r11 = 0
        L_0x003a:
            java.lang.String r1 = r9.zzb
            java.lang.String r2 = r10.zze()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x004c
            java.lang.String r11 = r9.zzb
            r10.zzb(r11)
            r11 = 1
        L_0x004c:
            java.lang.String r1 = r9.zzr
            java.lang.String r2 = r10.zzf()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x005e
            java.lang.String r11 = r9.zzr
            r10.zzc(r11)
            r11 = 1
        L_0x005e:
            boolean r1 = com.google.android.gms.internal.measurement.zzoe.zzb()
            if (r1 == 0) goto L_0x0088
            com.google.android.gms.measurement.internal.zzgd r1 = r8.zzj
            com.google.android.gms.measurement.internal.zzy r1 = r1.zzb()
            java.lang.String r2 = r10.zzc()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaq.zzbn
            boolean r1 = r1.zze(r2, r3)
            if (r1 == 0) goto L_0x0088
            java.lang.String r1 = r9.zzv
            java.lang.String r2 = r10.zzg()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x0088
            java.lang.String r11 = r9.zzv
            r10.zzd(r11)
            r11 = 1
        L_0x0088:
            java.lang.String r1 = r9.zzk
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00a2
            java.lang.String r1 = r9.zzk
            java.lang.String r2 = r10.zzi()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00a2
            java.lang.String r11 = r9.zzk
            r10.zzf(r11)
            r11 = 1
        L_0x00a2:
            long r1 = r9.zze
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00ba
            long r1 = r9.zze
            long r5 = r10.zzo()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00ba
            long r1 = r9.zze
            r10.zzd(r1)
            r11 = 1
        L_0x00ba:
            java.lang.String r1 = r9.zzc
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00d4
            java.lang.String r1 = r9.zzc
            java.lang.String r2 = r10.zzl()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00d4
            java.lang.String r11 = r9.zzc
            r10.zzg(r11)
            r11 = 1
        L_0x00d4:
            long r1 = r9.zzj
            long r5 = r10.zzm()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00e4
            long r1 = r9.zzj
            r10.zzc(r1)
            r11 = 1
        L_0x00e4:
            java.lang.String r1 = r9.zzd
            if (r1 == 0) goto L_0x00fa
            java.lang.String r1 = r9.zzd
            java.lang.String r2 = r10.zzn()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00fa
            java.lang.String r11 = r9.zzd
            r10.zzh(r11)
            r11 = 1
        L_0x00fa:
            long r1 = r9.zzf
            long r5 = r10.zzp()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x010a
            long r1 = r9.zzf
            r10.zze(r1)
            r11 = 1
        L_0x010a:
            boolean r1 = r9.zzh
            boolean r2 = r10.zzr()
            if (r1 == r2) goto L_0x0118
            boolean r11 = r9.zzh
            r10.zza(r11)
            r11 = 1
        L_0x0118:
            java.lang.String r1 = r9.zzg
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0132
            java.lang.String r1 = r9.zzg
            java.lang.String r2 = r10.zzac()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0132
            java.lang.String r11 = r9.zzg
            r10.zzi(r11)
            r11 = 1
        L_0x0132:
            com.google.android.gms.measurement.internal.zzgd r1 = r8.zzj
            com.google.android.gms.measurement.internal.zzy r1 = r1.zzb()
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzaq.zzcl
            boolean r1 = r1.zza(r2)
            if (r1 != 0) goto L_0x0150
            long r1 = r9.zzl
            long r5 = r10.zzae()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0150
            long r1 = r9.zzl
            r10.zzp(r1)
            r11 = 1
        L_0x0150:
            boolean r1 = r9.zzo
            boolean r2 = r10.zzaf()
            if (r1 == r2) goto L_0x015e
            boolean r11 = r9.zzo
            r10.zzb(r11)
            r11 = 1
        L_0x015e:
            boolean r1 = r9.zzp
            boolean r2 = r10.zzag()
            if (r1 == r2) goto L_0x016c
            boolean r11 = r9.zzp
            r10.zzc(r11)
            r11 = 1
        L_0x016c:
            java.lang.Boolean r1 = r9.zzs
            java.lang.Boolean r2 = r10.zzah()
            if (r1 == r2) goto L_0x017a
            java.lang.Boolean r11 = r9.zzs
            r10.zza(r11)
            r11 = 1
        L_0x017a:
            long r1 = r9.zzt
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0190
            long r1 = r9.zzt
            long r3 = r10.zzq()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0190
            long r1 = r9.zzt
            r10.zzf(r1)
            goto L_0x0191
        L_0x0190:
            r0 = r11
        L_0x0191:
            if (r0 == 0) goto L_0x019a
            com.google.android.gms.measurement.internal.zzad r9 = r8.zze()
            r9.zza(r10)
        L_0x019a:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkk.zza(com.google.android.gms.measurement.internal.zzn, com.google.android.gms.measurement.internal.zzf, java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    /* access modifiers changed from: package-private */
    public final zzf zzc(zzn zzn2) {
        zzw();
        zzk();
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn2.zza);
        zzf zzb2 = zze().zzb(zzn2.zza);
        String zzb3 = this.zzj.zzc().zzb(zzn2.zza);
        if (!zznn.zzb() || !this.zzj.zzb().zza(zzaq.zzbt)) {
            return zza(zzn2, zzb2, zzb3);
        }
        if (zzb2 == null) {
            zzb2 = new zzf(this.zzj, zzn2.zza);
            zzb2.zza(this.zzj.zzi().zzk());
            zzb2.zze(zzb3);
        } else if (!zzb3.equals(zzb2.zzh())) {
            zzb2.zze(zzb3);
            zzb2.zza(this.zzj.zzi().zzk());
        }
        zzb2.zzb(zzn2.zzb);
        zzb2.zzc(zzn2.zzr);
        if (zzoe.zzb() && this.zzj.zzb().zze(zzb2.zzc(), zzaq.zzbn)) {
            zzb2.zzd(zzn2.zzv);
        }
        if (!TextUtils.isEmpty(zzn2.zzk)) {
            zzb2.zzf(zzn2.zzk);
        }
        if (zzn2.zze != 0) {
            zzb2.zzd(zzn2.zze);
        }
        if (!TextUtils.isEmpty(zzn2.zzc)) {
            zzb2.zzg(zzn2.zzc);
        }
        zzb2.zzc(zzn2.zzj);
        if (zzn2.zzd != null) {
            zzb2.zzh(zzn2.zzd);
        }
        zzb2.zze(zzn2.zzf);
        zzb2.zza(zzn2.zzh);
        if (!TextUtils.isEmpty(zzn2.zzg)) {
            zzb2.zzi(zzn2.zzg);
        }
        if (!this.zzj.zzb().zza(zzaq.zzcl)) {
            zzb2.zzp(zzn2.zzl);
        }
        zzb2.zzb(zzn2.zzo);
        zzb2.zzc(zzn2.zzp);
        zzb2.zza(zzn2.zzs);
        zzb2.zzf(zzn2.zzt);
        if (zzb2.zza()) {
            zze().zza(zzb2);
        }
        return zzb2;
    }

    /* access modifiers changed from: package-private */
    public final String zzd(zzn zzn2) {
        try {
            return (String) this.zzj.zzq().zza(new zzko(this, zzn2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzr().zzf().zza("Failed to get app instance id. appId", zzez.zza(zzn2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzz();
    }

    private final boolean zze(zzn zzn2) {
        return (!zzoe.zzb() || !this.zzj.zzb().zze(zzn2.zza, zzaq.zzbn)) ? !TextUtils.isEmpty(zzn2.zzb) || !TextUtils.isEmpty(zzn2.zzr) : !TextUtils.isEmpty(zzn2.zzb) || !TextUtils.isEmpty(zzn2.zzv) || !TextUtils.isEmpty(zzn2.zzr);
    }
}
