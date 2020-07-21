package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzalh implements zzajp, zzale {
    private final zzalf zzdgz;
    private final HashSet<AbstractMap.SimpleEntry<String, zzahc<? super zzalf>>> zzdha = new HashSet<>();

    public zzalh(zzalf zzalf) {
        this.zzdgz = zzalf;
    }

    @Override // com.google.android.gms.internal.ads.zzajh
    public final void zza(String str, Map map) {
        zzajo.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzake
    public final void zza(String str, JSONObject jSONObject) {
        zzajo.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajh, com.google.android.gms.internal.ads.zzajp
    public final void zzb(String str, JSONObject jSONObject) {
        zzajo.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajp
    public final void zzj(String str, String str2) {
        zzajo.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzajp, com.google.android.gms.internal.ads.zzake
    public final void zzdb(String str) {
        this.zzdgz.zzdb(str);
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void zza(String str, zzahc<? super zzalf> zzahc) {
        this.zzdgz.zza(str, zzahc);
        this.zzdha.add(new AbstractMap.SimpleEntry<>(str, zzahc));
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void zzb(String str, zzahc<? super zzalf> zzahc) {
        this.zzdgz.zzb(str, zzahc);
        this.zzdha.remove(new AbstractMap.SimpleEntry(str, zzahc));
    }

    @Override // com.google.android.gms.internal.ads.zzale
    public final void zztf() {
        Iterator<AbstractMap.SimpleEntry<String, zzahc<? super zzalf>>> it2 = this.zzdha.iterator();
        while (it2.hasNext()) {
            AbstractMap.SimpleEntry<String, zzahc<? super zzalf>> next = it2.next();
            String valueOf = String.valueOf(next.getValue().toString());
            zzaxv.zzeh(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzdgz.zzb(next.getKey(), next.getValue());
        }
        this.zzdha.clear();
    }
}
