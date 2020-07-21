package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdqg implements zzdqf {
    private static final zzcf.zza zzhij = ((zzcf.zza) ((zzegb) zzcf.zza.zzar().zzv(ExifInterface.LONGITUDE_EAST).zzbfq()));

    zzdqg() {
    }

    @Override // com.google.android.gms.internal.ads.zzdqf
    public final zzcf.zza zzck(Context context) throws PackageManager.NameNotFoundException {
        return zzdpt.zzj(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    @Override // com.google.android.gms.internal.ads.zzdqf
    public final zzcf.zza zzave() {
        return zzhij;
    }
}
