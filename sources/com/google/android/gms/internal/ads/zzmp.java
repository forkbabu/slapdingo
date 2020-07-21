package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import java.io.IOException;
import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzmp implements zzjz, zzmz, zznl, zzou<zzms> {
    /* access modifiers changed from: private */
    public final Handler handler;
    private final Uri uri;
    private final Handler zzaek;
    /* access modifiers changed from: private */
    public boolean zzafn;
    private boolean zzagj;
    private long zzaih;
    private final zzok zzaoh;
    private final int zzbde;
    /* access modifiers changed from: private */
    public final zzmw zzbdf;
    private final zzna zzbdg;
    private final zzoi zzbdh;
    /* access modifiers changed from: private */
    public final String zzbdi;
    /* access modifiers changed from: private */
    public final long zzbdj;
    private final zzov zzbdk = new zzov("Loader:ExtractorMediaPeriod");
    private final zzmv zzbdl;
    private final zzpd zzbdm;
    private final Runnable zzbdn;
    /* access modifiers changed from: private */
    public final Runnable zzbdo;
    /* access modifiers changed from: private */
    public final SparseArray<zznj> zzbdp;
    /* access modifiers changed from: private */
    public zzmy zzbdq;
    private zzkc zzbdr;
    private boolean zzbds;
    private boolean zzbdt;
    private boolean zzbdu;
    private int zzbdv;
    private zznr zzbdw;
    private boolean[] zzbdx;
    private boolean[] zzbdy;
    private boolean zzbdz;
    private long zzbea;
    private long zzbeb;
    private int zzbec;
    private boolean zzbed;
    private long zzcp;

    public zzmp(Uri uri2, zzok zzok, zzjx[] zzjxArr, int i, Handler handler2, zzmw zzmw, zzna zzna, zzoi zzoi, String str, int i2) {
        this.uri = uri2;
        this.zzaoh = zzok;
        this.zzbde = i;
        this.zzaek = handler2;
        this.zzbdf = zzmw;
        this.zzbdg = zzna;
        this.zzbdh = zzoi;
        this.zzbdi = str;
        this.zzbdj = (long) i2;
        this.zzbdl = new zzmv(zzjxArr, this);
        this.zzbdm = new zzpd();
        this.zzbdn = new zzmo(this);
        this.zzbdo = new zzmr(this);
        this.handler = new Handler();
        this.zzbeb = -9223372036854775807L;
        this.zzbdp = new SparseArray<>();
        this.zzcp = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzef(long j) {
    }

    public final void release() {
        this.zzbdk.zza(new zzmq(this, this.zzbdl));
        this.handler.removeCallbacksAndMessages(null);
        this.zzafn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zza(zzmy zzmy, long j) {
        this.zzbdq = zzmy;
        this.zzbdm.open();
        startLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzhn() throws IOException {
        this.zzbdk.zzbi(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final zznr zzho() {
        return this.zzbdw;
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final long zza(zzod[] zzodArr, boolean[] zArr, zznk[] zznkArr, boolean[] zArr2, long j) {
        zzpb.checkState(this.zzagj);
        for (int i = 0; i < zzodArr.length; i++) {
            if (zznkArr[i] != null && (zzodArr[i] == null || !zArr[i])) {
                int zza = ((zzmu) zznkArr[i]).track;
                zzpb.checkState(this.zzbdx[zza]);
                this.zzbdv--;
                this.zzbdx[zza] = false;
                this.zzbdp.valueAt(zza).disable();
                zznkArr[i] = null;
            }
        }
        boolean z = false;
        for (int i2 = 0; i2 < zzodArr.length; i2++) {
            if (zznkArr[i2] == null && zzodArr[i2] != null) {
                zzod zzod = zzodArr[i2];
                zzpb.checkState(zzod.length() == 1);
                zzpb.checkState(zzod.zzbe(0) == 0);
                int zza2 = this.zzbdw.zza(zzod.zzik());
                zzpb.checkState(!this.zzbdx[zza2]);
                this.zzbdv++;
                this.zzbdx[zza2] = true;
                zznkArr[i2] = new zzmu(this, zza2);
                zArr2[i2] = true;
                z = true;
            }
        }
        if (!this.zzbdt) {
            int size = this.zzbdp.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (!this.zzbdx[i3]) {
                    this.zzbdp.valueAt(i3).disable();
                }
            }
        }
        if (this.zzbdv == 0) {
            this.zzbdu = false;
            if (this.zzbdk.isLoading()) {
                this.zzbdk.zzis();
            }
        } else if (!this.zzbdt ? j != 0 : z) {
            j = zzeg(j);
            for (int i4 = 0; i4 < zznkArr.length; i4++) {
                if (zznkArr[i4] != null) {
                    zArr2[i4] = true;
                }
            }
        }
        this.zzbdt = true;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zznn, com.google.android.gms.internal.ads.zzmz
    public final boolean zzee(long j) {
        if (this.zzbed) {
            return false;
        }
        if (this.zzagj && this.zzbdv == 0) {
            return false;
        }
        boolean open = this.zzbdm.open();
        if (this.zzbdk.isLoading()) {
            return open;
        }
        startLoading();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zznn, com.google.android.gms.internal.ads.zzmz
    public final long zzhm() {
        if (this.zzbdv == 0) {
            return Long.MIN_VALUE;
        }
        return zzhq();
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final long zzhp() {
        if (!this.zzbdu) {
            return -9223372036854775807L;
        }
        this.zzbdu = false;
        return this.zzbea;
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final long zzhq() {
        long j;
        if (this.zzbed) {
            return Long.MIN_VALUE;
        }
        if (zzhv()) {
            return this.zzbeb;
        }
        if (this.zzbdz) {
            j = LongCompanionObject.MAX_VALUE;
            int size = this.zzbdp.size();
            for (int i = 0; i < size; i++) {
                if (this.zzbdy[i]) {
                    j = Math.min(j, this.zzbdp.valueAt(i).zzhu());
                }
            }
        } else {
            j = zzhu();
        }
        return j == Long.MIN_VALUE ? this.zzbea : j;
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final long zzeg(long j) {
        if (!this.zzbdr.isSeekable()) {
            j = 0;
        }
        this.zzbea = j;
        int size = this.zzbdp.size();
        boolean z = !zzhv();
        int i = 0;
        while (z && i < size) {
            if (this.zzbdx[i]) {
                z = this.zzbdp.valueAt(i).zze(j, false);
            }
            i++;
        }
        if (!z) {
            this.zzbeb = j;
            this.zzbed = false;
            if (this.zzbdk.isLoading()) {
                this.zzbdk.zzis();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.zzbdp.valueAt(i2).zzk(this.zzbdx[i2]);
                }
            }
        }
        this.zzbdu = false;
        return j;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzba(int i) {
        if (!this.zzbed) {
            return !zzhv() && this.zzbdp.valueAt(i).zzid();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void zzhr() throws IOException {
        this.zzbdk.zzbi(Integer.MIN_VALUE);
    }

    /* access modifiers changed from: package-private */
    public final int zza(int i, zzhs zzhs, zzjm zzjm, boolean z) {
        if (this.zzbdu || zzhv()) {
            return -3;
        }
        return this.zzbdp.valueAt(i).zza(zzhs, zzjm, z, this.zzbed, this.zzbea);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i, long j) {
        zznj valueAt = this.zzbdp.valueAt(i);
        if (!this.zzbed || j <= valueAt.zzhu()) {
            valueAt.zze(j, true);
        } else {
            valueAt.zzih();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final zzke zzc(int i, int i2) {
        zznj zznj = this.zzbdp.get(i);
        if (zznj != null) {
            return zznj;
        }
        zznj zznj2 = new zznj(this.zzbdh);
        zznj2.zza(this);
        this.zzbdp.put(i, zznj2);
        return zznj2;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void zzgr() {
        this.zzbds = true;
        this.handler.post(this.zzbdn);
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void zza(zzkc zzkc) {
        this.zzbdr = zzkc;
        this.handler.post(this.zzbdn);
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final void zzf(zzhq zzhq) {
        this.handler.post(this.zzbdn);
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.android.gms.internal.ads.zzmz, com.google.android.gms.internal.ads.zzmp] */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.ads.zzkc] */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.util.SparseArray, android.util.SparseArray<com.google.android.gms.internal.ads.zznj>] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.android.gms.internal.ads.zzpd] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.android.gms.internal.ads.zzno[]] */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean[]] */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean[]] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.google.android.gms.internal.ads.zzkc] */
    /* JADX WARN: Type inference failed for: r3v3, types: [long] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.google.android.gms.internal.ads.zznr] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.google.android.gms.internal.ads.zzna] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzia, com.google.android.gms.internal.ads.zznp] */
    /* JADX WARN: Type inference failed for: r2v4, types: [long] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.google.android.gms.internal.ads.zzkc] */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.google.android.gms.internal.ads.zzmy] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.util.SparseArray, android.util.SparseArray<com.google.android.gms.internal.ads.zznj>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.android.gms.internal.ads.zznj] */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.google.android.gms.internal.ads.zzhq] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.android.gms.internal.ads.zzno] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.google.android.gms.internal.ads.zzhq[]] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v5, types: [boolean[]] */
    /* JADX WARN: Type inference failed for: r5v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v6, types: [int] */
    /* JADX WARN: Type inference failed for: r5v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.util.SparseArray, android.util.SparseArray<com.google.android.gms.internal.ads.zznj>] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.google.android.gms.internal.ads.zznj] */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.google.android.gms.internal.ads.zzhq] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: ConstInlineVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v0 ?
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
        	at jadx.core.dex.visitors.ConstInlineVisitor.checkForFinallyBlock(ConstInlineVisitor.java:135)
        	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:112)
        	at jadx.core.dex.visitors.ConstInlineVisitor.process(ConstInlineVisitor.java:53)
        	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:45)
        */
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r4v0 ?, r4v3 ?, r4v5 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v0 ?
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.collectCodeVars(ProcessVariables.java:142)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:47)
        */
    /*  JADX ERROR: Type inference failed with exception
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r4v0 ?, r4v3 ?, r4v5 ?, r4v6 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.rerun(InitCodeVariables.java:39)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.trySplitConstInsns(TypeInferenceVisitor.java:453)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:94)
        */
    public final void zzhs() {
        /*
            r8 = this;
            boolean r0 = r8.zzafn
            if (r0 != 0) goto L_0x009d
            boolean r0 = r8.zzagj
            if (r0 != 0) goto L_0x009d
            com.google.android.gms.internal.ads.zzkc r0 = r8.zzbdr
            if (r0 == 0) goto L_0x009d
            boolean r0 = r8.zzbds
            if (r0 != 0) goto L_0x0012
            goto L_0x009d
        L_0x0012:
            android.util.SparseArray<com.google.android.gms.internal.ads.zznj> r0 = r8.zzbdp
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x001a:
            if (r2 >= r0) goto L_0x002e
            android.util.SparseArray<com.google.android.gms.internal.ads.zznj> r3 = r8.zzbdp
            java.lang.Object r3 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zznj r3 = (com.google.android.gms.internal.ads.zznj) r3
            com.google.android.gms.internal.ads.zzhq r3 = r3.zzie()
            if (r3 != 0) goto L_0x002b
            return
        L_0x002b:
            int r2 = r2 + 1
            goto L_0x001a
        L_0x002e:
            com.google.android.gms.internal.ads.zzpd r2 = r8.zzbdm
            r2.zzit()
            com.google.android.gms.internal.ads.zzno[] r2 = new com.google.android.gms.internal.ads.zzno[r0]
            boolean[] r3 = new boolean[r0]
            r8.zzbdy = r3
            boolean[] r3 = new boolean[r0]
            r8.zzbdx = r3
            com.google.android.gms.internal.ads.zzkc r3 = r8.zzbdr
            long r3 = r3.getDurationUs()
            r8.zzaih = r3
            r3 = 0
        L_0x0046:
            r4 = 1
            if (r3 >= r0) goto L_0x007c
            android.util.SparseArray<com.google.android.gms.internal.ads.zznj> r5 = r8.zzbdp
            java.lang.Object r5 = r5.valueAt(r3)
            com.google.android.gms.internal.ads.zznj r5 = (com.google.android.gms.internal.ads.zznj) r5
            com.google.android.gms.internal.ads.zzhq r5 = r5.zzie()
            com.google.android.gms.internal.ads.zzno r6 = new com.google.android.gms.internal.ads.zzno
            com.google.android.gms.internal.ads.zzhq[] r7 = new com.google.android.gms.internal.ads.zzhq[r4]
            r7[r1] = r5
            r6.<init>(r7)
            r2[r3] = r6
            java.lang.String r5 = r5.zzagw
            boolean r6 = com.google.android.gms.internal.ads.zzpe.zzbf(r5)
            if (r6 != 0) goto L_0x0070
            boolean r5 = com.google.android.gms.internal.ads.zzpe.zzbe(r5)
            if (r5 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r4 = 0
        L_0x0070:
            boolean[] r5 = r8.zzbdy
            r5[r3] = r4
            boolean r5 = r8.zzbdz
            r4 = r4 | r5
            r8.zzbdz = r4
            int r3 = r3 + 1
            goto L_0x0046
        L_0x007c:
            com.google.android.gms.internal.ads.zznr r0 = new com.google.android.gms.internal.ads.zznr
            r0.<init>(r2)
            r8.zzbdw = r0
            r8.zzagj = r4
            com.google.android.gms.internal.ads.zzna r0 = r8.zzbdg
            com.google.android.gms.internal.ads.zznp r1 = new com.google.android.gms.internal.ads.zznp
            long r2 = r8.zzaih
            com.google.android.gms.internal.ads.zzkc r4 = r8.zzbdr
            boolean r4 = r4.isSeekable()
            r1.<init>(r2, r4)
            r2 = 0
            r0.zzb(r1, r2)
            com.google.android.gms.internal.ads.zzmy r0 = r8.zzbdq
            r0.zza(r8)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmp.zzhs():void");
    }

    private final void zza(zzms zzms) {
        if (this.zzcp == -1) {
            this.zzcp = zzms.zzcp;
        }
    }

    private final void startLoading() {
        zzkc zzkc;
        zzms zzms = new zzms(this, this.uri, this.zzaoh, this.zzbdl, this.zzbdm);
        if (this.zzagj) {
            zzpb.checkState(zzhv());
            long j = this.zzaih;
            if (j == -9223372036854775807L || this.zzbeb < j) {
                zzms.zze(this.zzbdr.zzdz(this.zzbeb), this.zzbeb);
                this.zzbeb = -9223372036854775807L;
            } else {
                this.zzbed = true;
                this.zzbeb = -9223372036854775807L;
                return;
            }
        }
        this.zzbec = zzht();
        int i = this.zzbde;
        if (i == -1) {
            i = (this.zzagj && this.zzcp == -1 && ((zzkc = this.zzbdr) == null || zzkc.getDurationUs() == -9223372036854775807L)) ? 6 : 3;
        }
        this.zzbdk.zza(zzms, this, i);
    }

    private final int zzht() {
        int size = this.zzbdp.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.zzbdp.valueAt(i2).zzic();
        }
        return i;
    }

    private final long zzhu() {
        int size = this.zzbdp.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.zzbdp.valueAt(i).zzhu());
        }
        return j;
    }

    private final boolean zzhv() {
        return this.zzbeb != -9223372036854775807L;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzow, long, long, java.io.IOException] */
    @Override // com.google.android.gms.internal.ads.zzou
    public final /* synthetic */ int zza(zzms zzms, long j, long j2, IOException iOException) {
        zzkc zzkc;
        zzms zzms2 = zzms;
        zza(zzms2);
        Handler handler2 = this.zzaek;
        if (!(handler2 == null || this.zzbdf == null)) {
            handler2.post(new zzmt(this, iOException));
        }
        if (iOException instanceof zznq) {
            return 3;
        }
        boolean z = zzht() > this.zzbec;
        if (this.zzcp == -1 && ((zzkc = this.zzbdr) == null || zzkc.getDurationUs() == -9223372036854775807L)) {
            this.zzbea = 0;
            this.zzbdu = this.zzagj;
            int size = this.zzbdp.size();
            for (int i = 0; i < size; i++) {
                this.zzbdp.valueAt(i).zzk(!this.zzagj || this.zzbdx[i]);
            }
            zzms2.zze(0, 0);
        }
        this.zzbec = zzht();
        return z ? 1 : 0;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzow, long, long, boolean] */
    @Override // com.google.android.gms.internal.ads.zzou
    public final /* synthetic */ void zza(zzms zzms, long j, long j2, boolean z) {
        zza(zzms);
        if (!z && this.zzbdv > 0) {
            int size = this.zzbdp.size();
            for (int i = 0; i < size; i++) {
                this.zzbdp.valueAt(i).zzk(this.zzbdx[i]);
            }
            this.zzbdq.zza((zznn) this);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzow, long, long] */
    @Override // com.google.android.gms.internal.ads.zzou
    public final /* synthetic */ void zza(zzms zzms, long j, long j2) {
        zza(zzms);
        this.zzbed = true;
        if (this.zzaih == -9223372036854775807L) {
            long zzhu = zzhu();
            this.zzaih = zzhu == Long.MIN_VALUE ? 0 : zzhu + 10000;
            this.zzbdg.zzb(new zznp(this.zzaih, this.zzbdr.isSeekable()), null);
        }
        this.zzbdq.zza((zznn) this);
    }
}
