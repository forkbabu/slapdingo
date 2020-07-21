package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaya implements zzaxx {
    private final Object lock = new Object();
    private SharedPreferences zzclb;
    private boolean zzdpq = true;
    private boolean zzdqd = false;
    private String zzdqg = "";
    private boolean zzdrp = true;
    private boolean zzdsb = true;
    private boolean zzdyz;
    private final List<Runnable> zzdza = new ArrayList();
    private zzdvf<?> zzdzb;
    private zzri zzdzc = null;
    private SharedPreferences.Editor zzdzd;
    private boolean zzdze = false;
    private String zzdzf;
    private String zzdzg;
    private long zzdzh = 0;
    private long zzdzi = 0;
    private long zzdzj = 0;
    private int zzdzk = -1;
    private int zzdzl = 0;
    private Set<String> zzdzm = Collections.emptySet();
    private JSONObject zzdzn = new JSONObject();
    private String zzdzo = null;
    private int zzdzp = -1;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000f, code lost:
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (r4.length() == 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        r4 = "admob__".concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        r4 = new java.lang.String("admob__");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r2.zzdzb = com.google.android.gms.internal.ads.zzbbf.zzedh.zzf(new com.google.android.gms.internal.ads.zzaxz(r2, r3, r4));
        r2.zzdyz = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
        if (r4 != null) goto L_0x000f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
        r4 = "admob";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.content.Context r3, java.lang.String r4, boolean r5) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r2.zzclb     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            if (r4 != 0) goto L_0x000f
            java.lang.String r4 = "admob"
            goto L_0x0025
        L_0x000f:
            java.lang.String r0 = "admob__"
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r1 = r4.length()
            if (r1 == 0) goto L_0x0020
            java.lang.String r4 = r0.concat(r4)
            goto L_0x0025
        L_0x0020:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r0)
        L_0x0025:
            com.google.android.gms.internal.ads.zzdvi r0 = com.google.android.gms.internal.ads.zzbbf.zzedh
            com.google.android.gms.internal.ads.zzaxz r1 = new com.google.android.gms.internal.ads.zzaxz
            r1.<init>(r2, r3, r4)
            com.google.android.gms.internal.ads.zzdvf r3 = r0.zzf(r1)
            r2.zzdzb = r3
            r2.zzdyz = r5
            return
        L_0x0035:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaya.zza(android.content.Context, java.lang.String, boolean):void");
    }

    private final void zzxg() {
        zzdvf<?> zzdvf = this.zzdzb;
        if (zzdvf != null && !zzdvf.isDone()) {
            try {
                this.zzdzb.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                zzaxv.zzd("Interrupted while waiting for preferences loaded.", e);
            } catch (CancellationException | ExecutionException | TimeoutException e2) {
                zzaxv.zzc("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    private final Bundle zzxh() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("listener_registration_bundle", true);
        synchronized (this.lock) {
            bundle.putBoolean("use_https", this.zzdpq);
            bundle.putBoolean("content_url_opted_out", this.zzdrp);
            bundle.putBoolean("content_vertical_opted_out", this.zzdsb);
            bundle.putBoolean("auto_collect_location", this.zzdqd);
            bundle.putInt("version_code", this.zzdzl);
            bundle.putStringArray("never_pool_slots", (String[]) this.zzdzm.toArray(new String[0]));
            bundle.putString("app_settings_json", this.zzdqg);
            bundle.putLong("app_settings_last_update_ms", this.zzdzh);
            bundle.putLong("app_last_background_time_ms", this.zzdzi);
            bundle.putInt("request_in_session_count", this.zzdzk);
            bundle.putLong("first_ad_req_time_ms", this.zzdzj);
            bundle.putString("native_advanced_settings", this.zzdzn.toString());
            bundle.putString("display_cutout", this.zzdzo);
            bundle.putInt("app_measurement_npa", this.zzdzp);
            if (this.zzdzf != null) {
                bundle.putString("content_url_hashes", this.zzdzf);
            }
            if (this.zzdzg != null) {
                bundle.putString("content_vertical_hashes", this.zzdzg);
            }
        }
        return bundle;
    }

    private final void zzc(Bundle bundle) {
        zzbbf.zzedh.execute(new zzayc(this));
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final zzri zzws() {
        if (!this.zzdyz) {
            return null;
        }
        if ((zzwt() && zzwv()) || !zzacf.zzczl.get().booleanValue()) {
            return null;
        }
        synchronized (this.lock) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zzdzc == null) {
                this.zzdzc = new zzri();
            }
            this.zzdzc.zzmh();
            zzaxv.zzfc("start fetching content...");
            zzri zzri = this.zzdzc;
            return zzri;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zzao(boolean z) {
        zzxg();
        synchronized (this.lock) {
            if (this.zzdrp != z) {
                this.zzdrp = z;
                if (this.zzdzd != null) {
                    this.zzdzd.putBoolean("content_url_opted_out", z);
                    this.zzdzd.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", this.zzdrp);
                bundle.putBoolean("content_vertical_opted_out", this.zzdsb);
                zzc(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final boolean zzwt() {
        boolean z;
        zzxg();
        synchronized (this.lock) {
            z = this.zzdrp;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        return;
     */
    @Override // com.google.android.gms.internal.ads.zzaxx
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzei(java.lang.String r4) {
        /*
            r3 = this;
            r3.zzxg()
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0032
            java.lang.String r1 = r3.zzdzf     // Catch:{ all -> 0x0034 }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0011
            goto L_0x0032
        L_0x0011:
            r3.zzdzf = r4     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.zzdzd     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0023
            android.content.SharedPreferences$Editor r1 = r3.zzdzd     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_url_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.zzdzd     // Catch:{ all -> 0x0034 }
            r1.apply()     // Catch:{ all -> 0x0034 }
        L_0x0023:
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0034 }
            r1.<init>()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_url_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            r3.zzc(r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaya.zzei(java.lang.String):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final String zzwu() {
        String str;
        zzxg();
        synchronized (this.lock) {
            str = this.zzdzf;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zzap(boolean z) {
        zzxg();
        synchronized (this.lock) {
            if (this.zzdsb != z) {
                this.zzdsb = z;
                if (this.zzdzd != null) {
                    this.zzdzd.putBoolean("content_vertical_opted_out", z);
                    this.zzdzd.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", this.zzdrp);
                bundle.putBoolean("content_vertical_opted_out", this.zzdsb);
                zzc(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final boolean zzwv() {
        boolean z;
        zzxg();
        synchronized (this.lock) {
            z = this.zzdsb;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        return;
     */
    @Override // com.google.android.gms.internal.ads.zzaxx
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzej(java.lang.String r4) {
        /*
            r3 = this;
            r3.zzxg()
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0032
            java.lang.String r1 = r3.zzdzg     // Catch:{ all -> 0x0034 }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0011
            goto L_0x0032
        L_0x0011:
            r3.zzdzg = r4     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.zzdzd     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0023
            android.content.SharedPreferences$Editor r1 = r3.zzdzd     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_vertical_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.zzdzd     // Catch:{ all -> 0x0034 }
            r1.apply()     // Catch:{ all -> 0x0034 }
        L_0x0023:
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0034 }
            r1.<init>()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_vertical_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            r3.zzc(r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaya.zzej(java.lang.String):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final String zzww() {
        String str;
        zzxg();
        synchronized (this.lock) {
            str = this.zzdzg;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zzaq(boolean z) {
        zzxg();
        synchronized (this.lock) {
            if (this.zzdqd != z) {
                this.zzdqd = z;
                if (this.zzdzd != null) {
                    this.zzdzd.putBoolean("auto_collect_location", z);
                    this.zzdzd.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("auto_collect_location", z);
                zzc(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final boolean zzwx() {
        boolean z;
        zzxg();
        synchronized (this.lock) {
            z = this.zzdqd;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zzdd(int i) {
        zzxg();
        synchronized (this.lock) {
            if (this.zzdzl != i) {
                this.zzdzl = i;
                if (this.zzdzd != null) {
                    this.zzdzd.putInt("version_code", i);
                    this.zzdzd.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("version_code", i);
                zzc(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final int zzwy() {
        int i;
        zzxg();
        synchronized (this.lock) {
            i = this.zzdzl;
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        return;
     */
    @Override // com.google.android.gms.internal.ads.zzaxx
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzek(java.lang.String r6) {
        /*
            r5 = this;
            r5.zzxg()
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzq.zzld()     // Catch:{ all -> 0x0060 }
            long r1 = r1.currentTimeMillis()     // Catch:{ all -> 0x0060 }
            r5.zzdzh = r1     // Catch:{ all -> 0x0060 }
            if (r6 == 0) goto L_0x005e
            java.lang.String r3 = r5.zzdqg     // Catch:{ all -> 0x0060 }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x001b
            goto L_0x005e
        L_0x001b:
            r5.zzdqg = r6     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.zzdzd     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0034
            android.content.SharedPreferences$Editor r3 = r5.zzdzd     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_json"
            r3.putString(r4, r6)     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.zzdzd     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_last_update_ms"
            r3.putLong(r4, r1)     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.zzdzd     // Catch:{ all -> 0x0060 }
            r3.apply()     // Catch:{ all -> 0x0060 }
        L_0x0034:
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x0060 }
            r3.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_json"
            r3.putString(r4, r6)     // Catch:{ all -> 0x0060 }
            java.lang.String r6 = "app_settings_last_update_ms"
            r3.putLong(r6, r1)     // Catch:{ all -> 0x0060 }
            r5.zzc(r3)     // Catch:{ all -> 0x0060 }
            java.util.List<java.lang.Runnable> r6 = r5.zzdza     // Catch:{ all -> 0x0060 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0060 }
        L_0x004c:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x005c
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x0060 }
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ all -> 0x0060 }
            r1.run()     // Catch:{ all -> 0x0060 }
            goto L_0x004c
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x0060:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaya.zzek(java.lang.String):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final zzaxi zzwz() {
        zzaxi zzaxi;
        zzxg();
        synchronized (this.lock) {
            zzaxi = new zzaxi(this.zzdqg, this.zzdzh);
        }
        return zzaxi;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zzb(Runnable runnable) {
        this.zzdza.add(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zzez(long j) {
        zzxg();
        synchronized (this.lock) {
            if (this.zzdzi != j) {
                this.zzdzi = j;
                if (this.zzdzd != null) {
                    this.zzdzd.putLong("app_last_background_time_ms", j);
                    this.zzdzd.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("app_last_background_time_ms", j);
                zzc(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final long zzxa() {
        long j;
        zzxg();
        synchronized (this.lock) {
            j = this.zzdzi;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zzde(int i) {
        zzxg();
        synchronized (this.lock) {
            if (this.zzdzk != i) {
                this.zzdzk = i;
                if (this.zzdzd != null) {
                    this.zzdzd.putInt("request_in_session_count", i);
                    this.zzdzd.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("request_in_session_count", i);
                zzc(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final int zzxb() {
        int i;
        zzxg();
        synchronized (this.lock) {
            i = this.zzdzk;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zzfa(long j) {
        zzxg();
        synchronized (this.lock) {
            if (this.zzdzj != j) {
                this.zzdzj = j;
                if (this.zzdzd != null) {
                    this.zzdzd.putLong("first_ad_req_time_ms", j);
                    this.zzdzd.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("first_ad_req_time_ms", j);
                zzc(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final long zzxc() {
        long j;
        zzxg();
        synchronized (this.lock) {
            j = this.zzdzj;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza(String str, String str2, boolean z) {
        zzxg();
        synchronized (this.lock) {
            JSONArray optJSONArray = this.zzdzn.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                if (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        if (!str2.equals(optJSONObject.optString("template_id"))) {
                            i++;
                        } else if (!z || !optJSONObject.optBoolean("uses_media_view", false)) {
                            length = i;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzq.zzld().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzdzn.put(str, optJSONArray);
            } catch (JSONException e) {
                zzaxv.zzd("Could not update native advanced settings", e);
            }
            if (this.zzdzd != null) {
                this.zzdzd.putString("native_advanced_settings", this.zzdzn.toString());
                this.zzdzd.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", this.zzdzn.toString());
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final JSONObject zzxd() {
        JSONObject jSONObject;
        zzxg();
        synchronized (this.lock) {
            jSONObject = this.zzdzn;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zzxe() {
        zzxg();
        synchronized (this.lock) {
            this.zzdzn = new JSONObject();
            if (this.zzdzd != null) {
                this.zzdzd.remove("native_advanced_settings");
                this.zzdzd.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", "{}");
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final String zzxf() {
        String str;
        zzxg();
        synchronized (this.lock) {
            str = this.zzdzo;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zzel(String str) {
        zzxg();
        synchronized (this.lock) {
            if (!TextUtils.equals(this.zzdzo, str)) {
                this.zzdzo = str;
                if (this.zzdzd != null) {
                    this.zzdzd.putString("display_cutout", str);
                    this.zzdzd.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putString("display_cutout", str);
                zzc(bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.lock) {
            this.zzclb = sharedPreferences;
            this.zzdzd = edit;
            if (PlatformVersion.isAtLeastM() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.zzdze = z;
            this.zzdpq = this.zzclb.getBoolean("use_https", this.zzdpq);
            this.zzdrp = this.zzclb.getBoolean("content_url_opted_out", this.zzdrp);
            this.zzdzf = this.zzclb.getString("content_url_hashes", this.zzdzf);
            this.zzdqd = this.zzclb.getBoolean("auto_collect_location", this.zzdqd);
            this.zzdsb = this.zzclb.getBoolean("content_vertical_opted_out", this.zzdsb);
            this.zzdzg = this.zzclb.getString("content_vertical_hashes", this.zzdzg);
            this.zzdzl = this.zzclb.getInt("version_code", this.zzdzl);
            this.zzdqg = this.zzclb.getString("app_settings_json", this.zzdqg);
            this.zzdzh = this.zzclb.getLong("app_settings_last_update_ms", this.zzdzh);
            this.zzdzi = this.zzclb.getLong("app_last_background_time_ms", this.zzdzi);
            this.zzdzk = this.zzclb.getInt("request_in_session_count", this.zzdzk);
            this.zzdzj = this.zzclb.getLong("first_ad_req_time_ms", this.zzdzj);
            this.zzdzm = this.zzclb.getStringSet("never_pool_slots", this.zzdzm);
            this.zzdzo = this.zzclb.getString("display_cutout", this.zzdzo);
            this.zzdzp = this.zzclb.getInt("app_measurement_npa", this.zzdzp);
            try {
                this.zzdzn = new JSONObject(this.zzclb.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                zzaxv.zzd("Could not convert native advanced settings to json object", e);
            }
            zzc(zzxh());
        }
    }
}
