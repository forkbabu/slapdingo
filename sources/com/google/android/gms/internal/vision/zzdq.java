package com.google.android.gms.internal.vision;

import java.util.Map;
import kotlin.UByte;
import kotlin.UShort;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzdq<K, V> extends zzdl<K, V> {
    private static final zzdl<Object, Object> zzmm = new zzdq(null, new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzmk;
    private final transient Object zzmn;

    /* JADX WARN: Type inference failed for: r10v0, types: [int] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int] */
    /* JADX WARN: Type inference failed for: r10v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int, short, byte] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v6, types: [com.google.android.gms.internal.vision.zzdq<K, V>, com.google.android.gms.internal.vision.zzdq] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int[]] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [int] */
    /* JADX WARN: Type inference failed for: r7v1, types: [int] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [int] */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Throwable, java.lang.IllegalArgumentException] */
    /* JADX WARN: Type inference failed for: r7v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [short[]] */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v3, types: [int] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* JADX WARN: Type inference failed for: r7v5, types: [short] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r7v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [short] */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.Throwable, java.lang.IllegalArgumentException] */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r3v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /* JADX WARN: Type inference failed for: r6v8, types: [int] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r6v10, types: [int] */
    /* JADX WARN: Type inference failed for: r7v7, types: [byte] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r7v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [byte] */
    /* JADX WARN: Type inference failed for: r3v6, types: [int] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.Throwable, java.lang.IllegalArgumentException] */
    /* JADX WARN: Type inference failed for: r6v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r4v4, types: [double] */
    /* JADX WARN: Type inference failed for: r6v12, types: [double] */
    /* JADX WARN: Type inference failed for: r4v5, types: [double] */
    /* JADX WARN: Type inference failed for: r6v13, types: [double] */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*  JADX ERROR: JadxRuntimeException in pass: ConstInlineVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v12 ?
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
        	at jadx.core.dex.visitors.ConstInlineVisitor.checkForFinallyBlock(ConstInlineVisitor.java:135)
        	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:112)
        	at jadx.core.dex.visitors.ConstInlineVisitor.process(ConstInlineVisitor.java:53)
        	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:45)
        */
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [short[], byte[]], vars: [r0v4 ?, r0v2 ?, r0v5 ?, r0v6 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    /*  JADX ERROR: JadxRuntimeException in pass: PrepareForCodeGen
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v11 ?
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
        	at jadx.core.dex.instructions.args.RegisterArg.sameCodeVar(RegisterArg.java:189)
        	at jadx.core.dex.visitors.PrepareForCodeGen.modifyArith(PrepareForCodeGen.java:191)
        	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:72)
        */
    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v4 ?
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.collectCodeVars(ProcessVariables.java:142)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:47)
        */
    /*  JADX ERROR: Type inference failed with exception
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [short[], byte[]], vars: [r0v4 ?, r0v2 ?, r0v5 ?, r0v6 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.rerun(InitCodeVariables.java:39)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.trySplitConstInsns(TypeInferenceVisitor.java:453)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:94)
        */
    static <K, V> com.google.android.gms.internal.vision.zzdq<K, V> zza(int r10, java.lang.Object[] r11) {
        /*
            int r10 = r11.length
            r0 = 1
            int r10 = r10 >> r0
            r1 = 4
            com.google.android.gms.internal.vision.zzcy.zze(r1, r10)
            r10 = 2
            int r10 = java.lang.Math.max(r1, r10)
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 0
            r4 = 751619276(0x2ccccccc, float:5.8207657E-12)
            if (r10 >= r4) goto L_0x002d
            int r2 = r10 + -1
            int r2 = java.lang.Integer.highestOneBit(r2)
            int r0 = r2 << 1
            r2 = r0
        L_0x001d:
            double r4 = (double) r2
            r6 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            double r4 = r4 * r6
            double r6 = (double) r10
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0036
            int r2 = r2 << 1
            goto L_0x001d
        L_0x002d:
            if (r10 >= r2) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            java.lang.String r10 = "collection too large"
            com.google.android.gms.internal.vision.zzcy.checkArgument(r0, r10)
        L_0x0036:
            int r10 = r2 + -1
            r0 = 128(0x80, float:1.794E-43)
            r4 = -1
            if (r2 > r0) goto L_0x0075
            byte[] r0 = new byte[r2]
            java.util.Arrays.fill(r0, r4)
        L_0x0042:
            if (r3 >= r1) goto L_0x00e7
            int r2 = r3 * 2
            r4 = r11[r2]
            r5 = r2 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.vision.zzdf.zza(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.vision.zzdi.zzs(r6)
        L_0x0057:
            r6 = r6 & r10
            byte r7 = r0[r6]
            r8 = 255(0xff, float:3.57E-43)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x0065
            byte r2 = (byte) r2
            r0[r6] = r2
            int r3 = r3 + 1
            goto L_0x0042
        L_0x0065:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0070
            int r6 = r6 + 1
            goto L_0x0057
        L_0x0070:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x0075:
            r0 = 32768(0x8000, float:4.5918E-41)
            if (r2 > r0) goto L_0x00b3
            short[] r0 = new short[r2]
            java.util.Arrays.fill(r0, r4)
        L_0x007f:
            if (r3 >= r1) goto L_0x00e7
            int r2 = r3 * 2
            r4 = r11[r2]
            r5 = r2 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.vision.zzdf.zza(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.vision.zzdi.zzs(r6)
        L_0x0094:
            r6 = r6 & r10
            short r7 = r0[r6]
            r8 = 65535(0xffff, float:9.1834E-41)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x00a3
            short r2 = (short) r2
            r0[r6] = r2
            int r3 = r3 + 1
            goto L_0x007f
        L_0x00a3:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00ae
            int r6 = r6 + 1
            goto L_0x0094
        L_0x00ae:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x00b3:
            int[] r0 = new int[r2]
            java.util.Arrays.fill(r0, r4)
        L_0x00b8:
            if (r3 >= r1) goto L_0x00e7
            int r2 = r3 * 2
            r5 = r11[r2]
            r6 = r2 ^ 1
            r6 = r11[r6]
            com.google.android.gms.internal.vision.zzdf.zza(r5, r6)
            int r7 = r5.hashCode()
            int r7 = com.google.android.gms.internal.vision.zzdi.zzs(r7)
        L_0x00cd:
            r7 = r7 & r10
            r8 = r0[r7]
            if (r8 != r4) goto L_0x00d7
            r0[r7] = r2
            int r3 = r3 + 1
            goto L_0x00b8
        L_0x00d7:
            r9 = r11[r8]
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x00e2
            int r7 = r7 + 1
            goto L_0x00cd
        L_0x00e2:
            java.lang.IllegalArgumentException r10 = zza(r5, r6, r11, r8)
            throw r10
        L_0x00e7:
            com.google.android.gms.internal.vision.zzdq r10 = new com.google.android.gms.internal.vision.zzdq
            r10.<init>(r0, r11, r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzdq.zza(int, java.lang.Object[]):com.google.android.gms.internal.vision.zzdq");
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    private zzdq(Object obj, Object[] objArr, int i) {
        this.zzmn = obj;
        this.zzmk = objArr;
        this.size = i;
    }

    public final int size() {
        return this.size;
    }

    @Override // java.util.Map, com.google.android.gms.internal.vision.zzdl
    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.zzmn;
        V[] vArr = this.zzmk;
        int i = this.size;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (vArr[0].equals(obj)) {
                return vArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int zzs = zzdi.zzs(obj.hashCode());
                while (true) {
                    int i2 = zzs & length;
                    byte b = bArr[i2] & UByte.MAX_VALUE;
                    if (b == 255) {
                        return null;
                    }
                    if (vArr[b].equals(obj)) {
                        return vArr[b ^ 1];
                    }
                    zzs = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int zzs2 = zzdi.zzs(obj.hashCode());
                while (true) {
                    int i3 = zzs2 & length2;
                    short s = sArr[i3] & UShort.MAX_VALUE;
                    if (s == 65535) {
                        return null;
                    }
                    if (vArr[s].equals(obj)) {
                        return vArr[s ^ 1];
                    }
                    zzs2 = i3 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int zzs3 = zzdi.zzs(obj.hashCode());
                while (true) {
                    int i4 = zzs3 & length3;
                    int i5 = iArr[i4];
                    if (i5 == -1) {
                        return null;
                    }
                    if (vArr[i5].equals(obj)) {
                        return vArr[i5 ^ 1];
                    }
                    zzs3 = i4 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdl
    public final zzdo<Map.Entry<K, V>> zzcf() {
        return new zzdp(this, this.zzmk, 0, this.size);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdl
    public final zzdo<K> zzcg() {
        return new zzdr(this, new zzdu(this.zzmk, 0, this.size));
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdl
    public final zzdh<V> zzch() {
        return new zzdu(this.zzmk, 1, this.size);
    }
}
