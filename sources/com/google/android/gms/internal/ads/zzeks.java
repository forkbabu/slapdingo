package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzeks {
    public abstract void zzii(String str);

    public static zzeks zzn(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzekl(cls.getSimpleName());
        }
        return new zzekn(cls.getSimpleName());
    }
}
