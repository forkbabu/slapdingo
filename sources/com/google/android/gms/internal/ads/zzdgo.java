package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdgo implements zzela<zzdeb<JSONObject>> {
    public static zzdeb<JSONObject> zza(zzawz zzawz, Object obj, zzdew zzdew, zzdft zzdft, zzeku<zzdeq> zzeku, zzeku<zzdfa> zzeku2, zzeku<zzdfe> zzeku3, zzeku<zzdfk> zzeku4, zzeku<zzdfp> zzeku5, zzeku<zzdfy> zzeku6, zzeku<zzdgc> zzeku7, zzeku<zzdgq> zzeku8, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzdfl) obj);
        hashSet.add(zzdew);
        hashSet.add(zzdft);
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcup)).booleanValue()) {
            hashSet.add(zzeku.get());
        }
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcuq)).booleanValue()) {
            hashSet.add(zzeku2.get());
        }
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcur)).booleanValue()) {
            hashSet.add(zzeku3.get());
        }
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcus)).booleanValue()) {
            hashSet.add(zzeku4.get());
        }
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcuw)).booleanValue()) {
            hashSet.add(new zzdcn(zzeku6.get(), ((Long) zzwg.zzpw().zzd(zzaav.zzcru)).longValue(), scheduledExecutorService));
        }
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcuy)).booleanValue()) {
            hashSet.add(zzeku7.get());
        }
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcuz)).booleanValue()) {
            hashSet.add(zzeku8.get());
        }
        return (zzdeb) zzelg.zza(new zzdeb(executor, hashSet), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}
