package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzdx {
    private static final zzea zzmp;
    private static final int zzmq;

    public static void zza(Throwable th, Throwable th2) {
        zzmp.zza(th, th2);
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    static final class zza extends zzea {
        zza() {
        }

        @Override // com.google.android.gms.internal.vision.zzea
        public final void zza(Throwable th, Throwable th2) {
        }

        @Override // com.google.android.gms.internal.vision.zzea
        public final void zza(Throwable th) {
            th.printStackTrace();
        }
    }

    public static void zza(Throwable th) {
        zzmp.zza(th);
    }

    private static Integer zzcj() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    static {
        /*
            r0 = 1
            java.lang.Integer r1 = zzcj()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0015
            int r2 = r1.intValue()     // Catch:{ all -> 0x002a }
            r3 = 19
            if (r2 < r3) goto L_0x0015
            com.google.android.gms.internal.vision.zzed r2 = new com.google.android.gms.internal.vision.zzed     // Catch:{ all -> 0x002a }
            r2.<init>()     // Catch:{ all -> 0x002a }
            goto L_0x0063
        L_0x0015:
            java.lang.String r2 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch:{ all -> 0x002a }
            r2 = r2 ^ r0
            if (r2 == 0) goto L_0x0024
            com.google.android.gms.internal.vision.zzeb r2 = new com.google.android.gms.internal.vision.zzeb     // Catch:{ all -> 0x002a }
            r2.<init>()     // Catch:{ all -> 0x002a }
            goto L_0x0063
        L_0x0024:
            com.google.android.gms.internal.vision.zzdx$zza r2 = new com.google.android.gms.internal.vision.zzdx$zza     // Catch:{ all -> 0x002a }
            r2.<init>()     // Catch:{ all -> 0x002a }
            goto L_0x0063
        L_0x002a:
            r2 = move-exception
            goto L_0x002e
        L_0x002c:
            r2 = move-exception
            r1 = 0
        L_0x002e:
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.Class<com.google.android.gms.internal.vision.zzdx$zza> r4 = com.google.android.gms.internal.vision.zzdx.zza.class
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            int r5 = r5 + 133
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = "will be used. The error is: "
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r3.println(r4)
            java.io.PrintStream r3 = java.lang.System.err
            r2.printStackTrace(r3)
            com.google.android.gms.internal.vision.zzdx$zza r2 = new com.google.android.gms.internal.vision.zzdx$zza
            r2.<init>()
        L_0x0063:
            com.google.android.gms.internal.vision.zzdx.zzmp = r2
            if (r1 != 0) goto L_0x0068
            goto L_0x006c
        L_0x0068:
            int r0 = r1.intValue()
        L_0x006c:
            com.google.android.gms.internal.vision.zzdx.zzmq = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzdx.<clinit>():void");
    }
}
