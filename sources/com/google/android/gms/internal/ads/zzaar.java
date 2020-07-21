package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzaar implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Object lock = new Object();
    private Bundle metaData = new Bundle();
    private final ConditionVariable zzckz = new ConditionVariable();
    private volatile boolean zzcla = false;
    /* access modifiers changed from: private */
    public SharedPreferences zzclb = null;
    private Context zzclc;
    private JSONObject zzcld = new JSONObject();
    private volatile boolean zzzg = false;

    public final void initialize(Context context) {
        if (!this.zzzg) {
            synchronized (this.lock) {
                if (!this.zzzg) {
                    if (!this.zzcla) {
                        this.zzcla = true;
                    }
                    Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
                    this.zzclc = applicationContext;
                    try {
                        this.metaData = Wrappers.packageManager(applicationContext).getApplicationInfo(this.zzclc.getPackageName(), 128).metaData;
                    } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                    }
                    try {
                        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                        if (remoteContext == null && context != null) {
                            Context applicationContext2 = context.getApplicationContext();
                            if (applicationContext2 != null) {
                                context = applicationContext2;
                            }
                            remoteContext = context;
                        }
                        if (remoteContext != null) {
                            zzwg.zzpu();
                            SharedPreferences sharedPreferences = remoteContext.getSharedPreferences("google_ads_flags", 0);
                            this.zzclb = sharedPreferences;
                            if (sharedPreferences != null) {
                                sharedPreferences.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzacy.zza(new zzaas(this));
                            zzre();
                            this.zzzg = true;
                            this.zzcla = false;
                            this.zzckz.open();
                        }
                    } finally {
                        this.zzcla = false;
                        this.zzckz.open();
                    }
                }
            }
        }
    }

    public final <T> T zzd(zzaag<T> zzaag) {
        if (!this.zzckz.block(5000)) {
            synchronized (this.lock) {
                if (!this.zzcla) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzzg || this.zzclb == null) {
            synchronized (this.lock) {
                if (this.zzzg) {
                    if (this.zzclb == null) {
                    }
                }
                T zzrb = zzaag.zzrb();
                return zzrb;
            }
        }
        if (zzaag.getSource() == 2) {
            Bundle bundle = this.metaData;
            if (bundle == null) {
                return zzaag.zzrb();
            }
            return zzaag.zza(bundle);
        } else if (zzaag.getSource() != 1 || !this.zzcld.has(zzaag.getKey())) {
            return zzbai.zza(new zzaaq(this, zzaag));
        } else {
            return zzaag.zzb(this.zzcld);
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzre();
        }
    }

    private final void zzre() {
        if (this.zzclb != null) {
            try {
                this.zzcld = new JSONObject((String) zzbai.zza(new zzaat(this)));
            } catch (JSONException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzrf() {
        return this.zzclb.getString("flag_configuration", "{}");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zze(zzaag zzaag) {
        return zzaag.zza(this.zzclb);
    }
}
