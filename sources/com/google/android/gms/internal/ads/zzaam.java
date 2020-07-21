package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzaam {
    private final Collection<zzaag<?>> zzcks = new ArrayList();
    private final Collection<zzaag<String>> zzckt = new ArrayList();
    private final Collection<zzaag<String>> zzcku = new ArrayList();

    public final void zza(zzaag zzaag) {
        this.zzcks.add(zzaag);
    }

    public final void zzb(zzaag<String> zzaag) {
        this.zzckt.add(zzaag);
    }

    public final void zzc(zzaag<String> zzaag) {
        this.zzcku.add(zzaag);
    }

    public final void zza(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzaag<?> zzaag : this.zzcks) {
            if (zzaag.getSource() == 1) {
                zzaag.zza(editor, zzaag.zzb(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzbba.zzfb("Flag Json is null.");
        }
    }

    public final List<String> zzrc() {
        ArrayList arrayList = new ArrayList();
        for (zzaag<String> zzaag : this.zzckt) {
            String str = (String) zzwg.zzpw().zzd(zzaag);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzaaw.zzrg());
        return arrayList;
    }

    public final List<String> zzrd() {
        List<String> zzrc = zzrc();
        for (zzaag<String> zzaag : this.zzcku) {
            String str = (String) zzwg.zzpw().zzd(zzaag);
            if (!TextUtils.isEmpty(str)) {
                zzrc.add(str);
            }
        }
        zzrc.addAll(zzaaw.zzrh());
        return zzrc;
    }
}
