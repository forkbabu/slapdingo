package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbu;
import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzoe;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.itextpdf.text.Annotation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
final class zzad extends zzkl {
    /* access modifiers changed from: private */
    public static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzae zzj = new zzae(this, zzn(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final zzkh zzk = new zzkh(zzm());

    zzad(zzkk zzkk) {
        super(zzkk);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzkl
    public final boolean zze() {
        return false;
    }

    public final void zzf() {
        zzak();
        c_().beginTransaction();
    }

    public final void b_() {
        zzak();
        c_().setTransactionSuccessful();
    }

    public final void zzh() {
        zzak();
        c_().endTransaction();
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase c_() {
        zzd();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            zzr().zzi().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzak zza(java.lang.String r26, java.lang.String r27) {
        /*
            r25 = this;
            r15 = r27
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r27)
            r25.zzd()
            r25.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r1 = "lifetime_count"
            java.lang.String r2 = "current_bundle_count"
            java.lang.String r3 = "last_fire_timestamp"
            java.lang.String r4 = "last_bundled_timestamp"
            java.lang.String r5 = "last_bundled_day"
            java.lang.String r6 = "last_sampled_complex_event_id"
            java.lang.String r7 = "last_sampling_rate"
            java.lang.String r8 = "last_exempt_from_sampling"
            java.lang.String r9 = "current_session_count"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2, r3, r4, r5, r6, r7, r8, r9}
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            r18 = 0
            android.database.sqlite.SQLiteDatabase r1 = r25.c_()     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            java.lang.String r2 = "events"
            r9 = 0
            java.lang.String[] r3 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            java.lang.Object[] r0 = r0.toArray(r3)     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r3 = r0
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            java.lang.String r4 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r5[r9] = r26     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r10 = 1
            r5[r10] = r15     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            if (r1 != 0) goto L_0x005c
            if (r14 == 0) goto L_0x005b
            r14.close()
        L_0x005b:
            return r18
        L_0x005c:
            long r4 = r14.getLong(r9)
            long r6 = r14.getLong(r10)
            long r11 = r14.getLong(r0)
            r0 = 3
            boolean r1 = r14.isNull(r0)
            r2 = 0
            if (r1 == 0) goto L_0x0074
            r16 = r2
            goto L_0x007a
        L_0x0074:
            long r0 = r14.getLong(r0)
            r16 = r0
        L_0x007a:
            r0 = 4
            boolean r1 = r14.isNull(r0)
            if (r1 == 0) goto L_0x0084
            r0 = r18
            goto L_0x008c
        L_0x0084:
            long r0 = r14.getLong(r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L_0x008c:
            r1 = 5
            boolean r8 = r14.isNull(r1)
            if (r8 == 0) goto L_0x0096
            r19 = r18
            goto L_0x00a0
        L_0x0096:
            long r19 = r14.getLong(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r19)
            r19 = r1
        L_0x00a0:
            r1 = 6
            boolean r8 = r14.isNull(r1)
            if (r8 == 0) goto L_0x00aa
            r20 = r18
            goto L_0x00b4
        L_0x00aa:
            long r20 = r14.getLong(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r20)
            r20 = r1
        L_0x00b4:
            r1 = 7
            boolean r8 = r14.isNull(r1)
            if (r8 != 0) goto L_0x00d0
            long r21 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x00cd }
            r23 = 1
            int r1 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r1 != 0) goto L_0x00c6
            r9 = 1
        L_0x00c6:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)     // Catch:{ SQLiteException -> 0x00cd }
            r21 = r1
            goto L_0x00d2
        L_0x00cd:
            r0 = move-exception
            goto L_0x012a
        L_0x00d0:
            r21 = r18
        L_0x00d2:
            r1 = 8
            boolean r8 = r14.isNull(r1)
            if (r8 == 0) goto L_0x00dc
            r8 = r2
            goto L_0x00e1
        L_0x00dc:
            long r1 = r14.getLong(r1)
            r8 = r1
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzak r22 = new com.google.android.gms.measurement.internal.zzak
            r1 = r22
            r2 = r26
            r3 = r27
            r10 = r11
            r12 = r16
            r23 = r14
            r14 = r0
            r15 = r19
            r16 = r20
            r17 = r21
            r1.<init>(r2, r3, r4, r6, r8, r10, r12, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            boolean r0 = r23.moveToNext()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            if (r0 == 0) goto L_0x010f
            com.google.android.gms.measurement.internal.zzez r0 = r25.zzr()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            java.lang.String r1 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzez.zza(r26)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
        L_0x010f:
            if (r23 == 0) goto L_0x0114
            r23.close()
        L_0x0114:
            return r22
        L_0x0115:
            r0 = move-exception
            goto L_0x011e
        L_0x0117:
            r0 = move-exception
            r14 = r23
            goto L_0x012a
        L_0x011b:
            r0 = move-exception
            r23 = r14
        L_0x011e:
            r18 = r23
            goto L_0x014e
        L_0x0121:
            r0 = move-exception
            r23 = r14
            goto L_0x012a
        L_0x0125:
            r0 = move-exception
            goto L_0x014e
        L_0x0127:
            r0 = move-exception
            r14 = r18
        L_0x012a:
            com.google.android.gms.measurement.internal.zzez r1 = r25.zzr()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x014b }
            java.lang.String r2 = "Error querying events. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza(r26)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzex r4 = r25.zzo()     // Catch:{ all -> 0x014b }
            r5 = r27
            java.lang.String r4 = r4.zza(r5)     // Catch:{ all -> 0x014b }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x014b }
            if (r14 == 0) goto L_0x014a
            r14.close()
        L_0x014a:
            return r18
        L_0x014b:
            r0 = move-exception
            r18 = r14
        L_0x014e:
            if (r18 == 0) goto L_0x0153
            r18.close()
        L_0x0153:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzak");
    }

    public final void zza(zzak zzak) {
        Preconditions.checkNotNull(zzak);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzak.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzak.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzak.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzak.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzak.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzak.zzg));
        contentValues.put("last_bundled_day", zzak.zzh);
        contentValues.put("last_sampled_complex_event_id", zzak.zzi);
        contentValues.put("last_sampling_rate", zzak.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzak.zze));
        contentValues.put("last_exempt_from_sampling", (zzak.zzk == null || !zzak.zzk.booleanValue()) ? null : 1L);
        try {
            if (c_().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update event aggregates (got -1). appId", zzez.zza(zzak.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event aggregates. appId", zzez.zza(zzak.zza), e);
        }
    }

    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            c_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting user property. appId", zzez.zza(str), zzo().zzc(str2), e);
        }
    }

    public final boolean zza(zzkt zzkt) {
        Preconditions.checkNotNull(zzkt);
        zzd();
        zzak();
        if (zzc(zzkt.zza, zzkt.zzc) == null) {
            if (zzkw.zza(zzkt.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzkt.zza}) >= ((long) zzt().zzd(zzkt.zza))) {
                    return false;
                }
            } else if (!"_npa".equals(zzkt.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzkt.zza, zzkt.zzb}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkt.zza);
        contentValues.put("origin", zzkt.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzkt.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzkt.zzd));
        zza(contentValues, "value", zzkt.zze);
        try {
            if (c_().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update user property (got -1). appId", zzez.zza(zzkt.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing user property. appId", zzez.zza(zzkt.zza), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzkt zzc(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzd()
            r18.zzak()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.c_()     // Catch:{ SQLiteException -> 0x0084, all -> 0x0080 }
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch:{ SQLiteException -> 0x0084, all -> 0x0080 }
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0084, all -> 0x0080 }
            r1 = 0
            r14[r1] = r19     // Catch:{ SQLiteException -> 0x0084, all -> 0x0080 }
            r2 = 1
            r14[r2] = r8     // Catch:{ SQLiteException -> 0x0084, all -> 0x0080 }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0080 }
            boolean r3 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x007c, all -> 0x0078 }
            if (r3 != 0) goto L_0x0041
            if (r10 == 0) goto L_0x0040
            r10.close()
        L_0x0040:
            return r9
        L_0x0041:
            long r5 = r10.getLong(r1)
            r11 = r18
            java.lang.Object r7 = r11.zza(r10, r2)     // Catch:{ SQLiteException -> 0x0076 }
            java.lang.String r3 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.measurement.internal.zzkt r0 = new com.google.android.gms.measurement.internal.zzkt     // Catch:{ SQLiteException -> 0x0076 }
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x0076 }
            boolean r1 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0076 }
            if (r1 == 0) goto L_0x0070
            com.google.android.gms.measurement.internal.zzez r1 = r18.zzr()     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ SQLiteException -> 0x0076 }
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza(r19)     // Catch:{ SQLiteException -> 0x0076 }
            r1.zza(r2, r3)     // Catch:{ SQLiteException -> 0x0076 }
        L_0x0070:
            if (r10 == 0) goto L_0x0075
            r10.close()
        L_0x0075:
            return r0
        L_0x0076:
            r0 = move-exception
            goto L_0x0088
        L_0x0078:
            r0 = move-exception
            r11 = r18
            goto L_0x00a8
        L_0x007c:
            r0 = move-exception
            r11 = r18
            goto L_0x0088
        L_0x0080:
            r0 = move-exception
            r11 = r18
            goto L_0x00a9
        L_0x0084:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L_0x0088:
            com.google.android.gms.measurement.internal.zzez r1 = r18.zzr()     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza(r19)     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.measurement.internal.zzex r4 = r18.zzo()     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r4.zzc(r8)     // Catch:{ all -> 0x00a7 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x00a7 }
            if (r10 == 0) goto L_0x00a6
            r10.close()
        L_0x00a6:
            return r9
        L_0x00a7:
            r0 = move-exception
        L_0x00a8:
            r9 = r10
        L_0x00a9:
            if (r9 == 0) goto L_0x00ae
            r9.close()
        L_0x00ae:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzkt");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzkt> zza(java.lang.String r14) {
        /*
            r13 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r13.zzd()
            r13.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.c_()     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            java.lang.String r5 = "app_id=?"
            r11 = 1
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r12 = 0
            r6[r12] = r14     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0082 }
            if (r3 != 0) goto L_0x0041
            if (r2 == 0) goto L_0x0040
            r2.close()
        L_0x0040:
            return r0
        L_0x0041:
            java.lang.String r7 = r2.getString(r12)
            java.lang.String r3 = r2.getString(r11)
            if (r3 != 0) goto L_0x004d
            java.lang.String r3 = ""
        L_0x004d:
            r6 = r3
            r3 = 2
            long r8 = r2.getLong(r3)
            r3 = 3
            java.lang.Object r10 = r13.zza(r2, r3)
            if (r10 != 0) goto L_0x006c
            com.google.android.gms.measurement.internal.zzez r3 = r13.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza(r14)
            r3.zza(r4, r5)
            goto L_0x0076
        L_0x006c:
            com.google.android.gms.measurement.internal.zzkt r3 = new com.google.android.gms.measurement.internal.zzkt
            r4 = r3
            r5 = r14
            r4.<init>(r5, r6, r7, r8, r10)
            r0.add(r3)
        L_0x0076:
            boolean r3 = r2.moveToNext()
            if (r3 != 0) goto L_0x0041
            if (r2 == 0) goto L_0x0081
            r2.close()
        L_0x0081:
            return r0
        L_0x0082:
            r0 = move-exception
            goto L_0x0088
        L_0x0084:
            r14 = move-exception
            goto L_0x00bd
        L_0x0086:
            r0 = move-exception
            r2 = r1
        L_0x0088:
            com.google.android.gms.measurement.internal.zzez r3 = r13.zzr()     // Catch:{ all -> 0x00bb }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza(r14)     // Catch:{ all -> 0x00bb }
            r3.zza(r4, r5, r0)     // Catch:{ all -> 0x00bb }
            boolean r0 = com.google.android.gms.internal.measurement.zznm.zzb()     // Catch:{ all -> 0x00bb }
            if (r0 == 0) goto L_0x00b5
            com.google.android.gms.measurement.internal.zzy r0 = r13.zzt()     // Catch:{ all -> 0x00bb }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch:{ all -> 0x00bb }
            boolean r14 = r0.zze(r14, r3)     // Catch:{ all -> 0x00bb }
            if (r14 == 0) goto L_0x00b5
            java.util.List r14 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00bb }
            if (r2 == 0) goto L_0x00b4
            r2.close()
        L_0x00b4:
            return r14
        L_0x00b5:
            if (r2 == 0) goto L_0x00ba
            r2.close()
        L_0x00ba:
            return r1
        L_0x00bb:
            r14 = move-exception
            r1 = r2
        L_0x00bd:
            if (r1 == 0) goto L_0x00c2
            r1.close()
        L_0x00c2:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00fd, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0101, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0102, code lost:
        r3 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013e, code lost:
        r9.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fd A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0011] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011e A[Catch:{ all -> 0x013a }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzkt> zza(java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            r20 = this;
            r8 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r21)
            r20.zzd()
            r20.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0101, all -> 0x00fd }
            r10 = 3
            r1.<init>(r10)     // Catch:{ SQLiteException -> 0x0101, all -> 0x00fd }
            r1.add(r8)     // Catch:{ SQLiteException -> 0x0101, all -> 0x00fd }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0101, all -> 0x00fd }
            java.lang.String r3 = "app_id=?"
            r2.<init>(r3)     // Catch:{ SQLiteException -> 0x0101, all -> 0x00fd }
            boolean r3 = android.text.TextUtils.isEmpty(r22)     // Catch:{ SQLiteException -> 0x0101, all -> 0x00fd }
            if (r3 != 0) goto L_0x0032
            r3 = r22
            r1.add(r3)     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
            java.lang.String r4 = " and origin=?"
            r2.append(r4)     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
            goto L_0x0034
        L_0x0032:
            r3 = r22
        L_0x0034:
            boolean r4 = android.text.TextUtils.isEmpty(r23)     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
            if (r4 != 0) goto L_0x004c
            java.lang.String r4 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
            java.lang.String r5 = "*"
            java.lang.String r4 = r4.concat(r5)     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
            r1.add(r4)     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
            java.lang.String r4 = " and name glob ?"
            r2.append(r4)     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
        L_0x004c:
            int r4 = r1.size()     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
            java.lang.Object[] r1 = r1.toArray(r4)     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
            r15 = r1
            java.lang.String[] r15 = (java.lang.String[]) r15     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
            android.database.sqlite.SQLiteDatabase r11 = r20.c_()     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
            java.lang.String r12 = "user_attributes"
            java.lang.String r1 = "name"
            java.lang.String r4 = "set_timestamp"
            java.lang.String r5 = "value"
            java.lang.String r6 = "origin"
            java.lang.String[] r13 = new java.lang.String[]{r1, r4, r5, r6}     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
            java.lang.String r14 = r2.toString()     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = "1001"
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x00f9, all -> 0x00fd }
            boolean r1 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x00f5, all -> 0x00f1 }
            if (r1 != 0) goto L_0x0089
            if (r11 == 0) goto L_0x0088
            r11.close()
        L_0x0088:
            return r0
        L_0x0089:
            int r1 = r0.size()
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r1 < r2) goto L_0x00a5
            com.google.android.gms.measurement.internal.zzez r1 = r20.zzr()
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()
            java.lang.String r4 = "Read more than the max allowed user properties, ignoring excess"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.zza(r4, r2)
            r12 = r20
            goto L_0x00e4
        L_0x00a5:
            r1 = 0
            java.lang.String r4 = r11.getString(r1)
            r1 = 1
            long r5 = r11.getLong(r1)
            r1 = 2
            r12 = r20
            java.lang.Object r7 = r12.zza(r11, r1)     // Catch:{ SQLiteException -> 0x00ef }
            java.lang.String r13 = r11.getString(r10)     // Catch:{ SQLiteException -> 0x00ef }
            if (r7 != 0) goto L_0x00d0
            com.google.android.gms.measurement.internal.zzez r1 = r20.zzr()     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.String r2 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza(r21)     // Catch:{ SQLiteException -> 0x00ec }
            r14 = r23
            r1.zza(r2, r3, r13, r14)     // Catch:{ SQLiteException -> 0x00ec }
            goto L_0x00de
        L_0x00d0:
            r14 = r23
            com.google.android.gms.measurement.internal.zzkt r15 = new com.google.android.gms.measurement.internal.zzkt     // Catch:{ SQLiteException -> 0x00ec }
            r1 = r15
            r2 = r21
            r3 = r13
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x00ec }
            r0.add(r15)     // Catch:{ SQLiteException -> 0x00ec }
        L_0x00de:
            boolean r1 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x00ec }
            if (r1 != 0) goto L_0x00ea
        L_0x00e4:
            if (r11 == 0) goto L_0x00e9
            r11.close()
        L_0x00e9:
            return r0
        L_0x00ea:
            r3 = r13
            goto L_0x0089
        L_0x00ec:
            r0 = move-exception
            r3 = r13
            goto L_0x0107
        L_0x00ef:
            r0 = move-exception
            goto L_0x0107
        L_0x00f1:
            r0 = move-exception
            r12 = r20
            goto L_0x013b
        L_0x00f5:
            r0 = move-exception
            r12 = r20
            goto L_0x0107
        L_0x00f9:
            r0 = move-exception
            r12 = r20
            goto L_0x0106
        L_0x00fd:
            r0 = move-exception
            r12 = r20
            goto L_0x013c
        L_0x0101:
            r0 = move-exception
            r12 = r20
            r3 = r22
        L_0x0106:
            r11 = r9
        L_0x0107:
            com.google.android.gms.measurement.internal.zzez r1 = r20.zzr()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x013a }
            java.lang.String r2 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza(r21)     // Catch:{ all -> 0x013a }
            r1.zza(r2, r4, r3, r0)     // Catch:{ all -> 0x013a }
            boolean r0 = com.google.android.gms.internal.measurement.zznm.zzb()     // Catch:{ all -> 0x013a }
            if (r0 == 0) goto L_0x0134
            com.google.android.gms.measurement.internal.zzy r0 = r20.zzt()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch:{ all -> 0x013a }
            boolean r0 = r0.zze(r8, r1)     // Catch:{ all -> 0x013a }
            if (r0 == 0) goto L_0x0134
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x013a }
            if (r11 == 0) goto L_0x0133
            r11.close()
        L_0x0133:
            return r0
        L_0x0134:
            if (r11 == 0) goto L_0x0139
            r11.close()
        L_0x0139:
            return r9
        L_0x013a:
            r0 = move-exception
        L_0x013b:
            r9 = r11
        L_0x013c:
            if (r9 == 0) goto L_0x0141
            r9.close()
        L_0x0141:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean zza(zzw zzw) {
        Preconditions.checkNotNull(zzw);
        zzd();
        zzak();
        if (zzc(zzw.zza, zzw.zzc.zza) == null) {
            if (zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzw.zza}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzw.zza);
        contentValues.put("origin", zzw.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzw.zzc.zza);
        zza(contentValues, "value", zzw.zzc.zza());
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzw.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzw.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzw.zzh));
        zzp();
        contentValues.put("timed_out_event", zzkw.zza((Parcelable) zzw.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzw.zzd));
        zzp();
        contentValues.put("triggered_event", zzkw.zza((Parcelable) zzw.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzw.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzw.zzj));
        zzp();
        contentValues.put("expired_event", zzkw.zza((Parcelable) zzw.zzk));
        try {
            if (c_().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update conditional user property (got -1)", zzez.zza(zzw.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing conditional user property", zzez.zza(zzw.zza), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzw zzd(java.lang.String r30, java.lang.String r31) {
        /*
            r29 = this;
            r7 = r31
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r30)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            r29.zzd()
            r29.zzak()
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r29.c_()     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fb }
            java.lang.String r10 = "conditional_properties"
            java.lang.String r11 = "origin"
            java.lang.String r12 = "value"
            java.lang.String r13 = "active"
            java.lang.String r14 = "trigger_event_name"
            java.lang.String r15 = "trigger_timeout"
            java.lang.String r16 = "timed_out_event"
            java.lang.String r17 = "creation_timestamp"
            java.lang.String r18 = "triggered_event"
            java.lang.String r19 = "triggered_timestamp"
            java.lang.String r20 = "time_to_live"
            java.lang.String r21 = "expired_event"
            java.lang.String[] r11 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fb }
            java.lang.String r12 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r13 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fb }
            r1 = 0
            r13[r1] = r30     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fb }
            r2 = 1
            r13[r2] = r7     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fb }
            r14 = 0
            r15 = 0
            r16 = 0
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fb }
            boolean r3 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00f3 }
            if (r3 != 0) goto L_0x004f
            if (r9 == 0) goto L_0x004e
            r9.close()
        L_0x004e:
            return r8
        L_0x004f:
            java.lang.String r16 = r9.getString(r1)
            r10 = r29
            java.lang.Object r5 = r10.zza(r9, r2)     // Catch:{ SQLiteException -> 0x00f1 }
            int r0 = r9.getInt(r0)     // Catch:{ SQLiteException -> 0x00f1 }
            if (r0 == 0) goto L_0x0062
            r20 = 1
            goto L_0x0064
        L_0x0062:
            r20 = 0
        L_0x0064:
            r0 = 3
            java.lang.String r21 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00f1 }
            r0 = 4
            long r23 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f1 }
            com.google.android.gms.measurement.internal.zzks r0 = r29.zzg()     // Catch:{ SQLiteException -> 0x00f1 }
            r1 = 5
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f1 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzao> r2 = com.google.android.gms.measurement.internal.zzao.CREATOR     // Catch:{ SQLiteException -> 0x00f1 }
            android.os.Parcelable r0 = r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x00f1 }
            r22 = r0
            com.google.android.gms.measurement.internal.zzao r22 = (com.google.android.gms.measurement.internal.zzao) r22     // Catch:{ SQLiteException -> 0x00f1 }
            r0 = 6
            long r18 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f1 }
            com.google.android.gms.measurement.internal.zzks r0 = r29.zzg()     // Catch:{ SQLiteException -> 0x00f1 }
            r1 = 7
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f1 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzao> r2 = com.google.android.gms.measurement.internal.zzao.CREATOR     // Catch:{ SQLiteException -> 0x00f1 }
            android.os.Parcelable r0 = r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x00f1 }
            r25 = r0
            com.google.android.gms.measurement.internal.zzao r25 = (com.google.android.gms.measurement.internal.zzao) r25     // Catch:{ SQLiteException -> 0x00f1 }
            r0 = 8
            long r3 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f1 }
            r0 = 9
            long r26 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f1 }
            com.google.android.gms.measurement.internal.zzks r0 = r29.zzg()     // Catch:{ SQLiteException -> 0x00f1 }
            r1 = 10
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f1 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzao> r2 = com.google.android.gms.measurement.internal.zzao.CREATOR     // Catch:{ SQLiteException -> 0x00f1 }
            android.os.Parcelable r0 = r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x00f1 }
            r28 = r0
            com.google.android.gms.measurement.internal.zzao r28 = (com.google.android.gms.measurement.internal.zzao) r28     // Catch:{ SQLiteException -> 0x00f1 }
            com.google.android.gms.measurement.internal.zzkr r17 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ SQLiteException -> 0x00f1 }
            r1 = r17
            r2 = r31
            r6 = r16
            r1.<init>(r2, r3, r5, r6)     // Catch:{ SQLiteException -> 0x00f1 }
            com.google.android.gms.measurement.internal.zzw r0 = new com.google.android.gms.measurement.internal.zzw     // Catch:{ SQLiteException -> 0x00f1 }
            r14 = r0
            r15 = r30
            r14.<init>(r15, r16, r17, r18, r20, r21, r22, r23, r25, r26, r28)     // Catch:{ SQLiteException -> 0x00f1 }
            boolean r1 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x00f1 }
            if (r1 == 0) goto L_0x00eb
            com.google.android.gms.measurement.internal.zzez r1 = r29.zzr()     // Catch:{ SQLiteException -> 0x00f1 }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ SQLiteException -> 0x00f1 }
            java.lang.String r2 = "Got multiple records for conditional property, expected one"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza(r30)     // Catch:{ SQLiteException -> 0x00f1 }
            com.google.android.gms.measurement.internal.zzex r4 = r29.zzo()     // Catch:{ SQLiteException -> 0x00f1 }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ SQLiteException -> 0x00f1 }
            r1.zza(r2, r3, r4)     // Catch:{ SQLiteException -> 0x00f1 }
        L_0x00eb:
            if (r9 == 0) goto L_0x00f0
            r9.close()
        L_0x00f0:
            return r0
        L_0x00f1:
            r0 = move-exception
            goto L_0x0103
        L_0x00f3:
            r0 = move-exception
            r10 = r29
            goto L_0x0123
        L_0x00f7:
            r0 = move-exception
            r10 = r29
            goto L_0x0103
        L_0x00fb:
            r0 = move-exception
            r10 = r29
            goto L_0x0124
        L_0x00ff:
            r0 = move-exception
            r10 = r29
            r9 = r8
        L_0x0103:
            com.google.android.gms.measurement.internal.zzez r1 = r29.zzr()     // Catch:{ all -> 0x0122 }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x0122 }
            java.lang.String r2 = "Error querying conditional property"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza(r30)     // Catch:{ all -> 0x0122 }
            com.google.android.gms.measurement.internal.zzex r4 = r29.zzo()     // Catch:{ all -> 0x0122 }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ all -> 0x0122 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x0122 }
            if (r9 == 0) goto L_0x0121
            r9.close()
        L_0x0121:
            return r8
        L_0x0122:
            r0 = move-exception
        L_0x0123:
            r8 = r9
        L_0x0124:
            if (r8 == 0) goto L_0x0129
            r8.close()
        L_0x0129:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzd(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzw");
    }

    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            return c_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting conditional property", zzez.zza(str), zzo().zzc(str2), e);
            return 0;
        }
    }

    public final List<zzw> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List<zzw> zza(String str, String[] strArr) {
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = c_().query("conditional_properties", new String[]{"app_id", "origin", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, str, strArr, null, null, "rowid", NativeContentAd.ASSET_HEADLINE);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < 1000) {
                    boolean z = false;
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object zza = zza(cursor, 3);
                    if (cursor.getInt(4) != 0) {
                        z = true;
                    }
                    String string4 = cursor.getString(5);
                    long j = cursor.getLong(6);
                    long j2 = cursor.getLong(8);
                    arrayList.add(new zzw(string, string2, new zzkr(string3, cursor.getLong(10), zza, string2), j2, z, string4, (zzao) zzg().zza(cursor.getBlob(7), zzao.CREATOR), j, (zzao) zzg().zza(cursor.getBlob(9), zzao.CREATOR), cursor.getLong(11), (zzao) zzg().zza(cursor.getBlob(12), zzao.CREATOR)));
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    zzr().zzf().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
                    break;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error querying conditional user property value", e);
            List<zzw> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x011b A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x011f A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0159 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0172 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0187 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01a3 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01a4 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01b3 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01e9 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x022d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzf zzb(java.lang.String r35) {
        /*
            r34 = this;
            r1 = r35
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r35)
            r34.zzd()
            r34.zzak()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r34.c_()     // Catch:{ SQLiteException -> 0x020e, all -> 0x020a }
            java.lang.String r4 = "apps"
            java.lang.String r5 = "app_instance_id"
            java.lang.String r6 = "gmp_app_id"
            java.lang.String r7 = "resettable_device_id_hash"
            java.lang.String r8 = "last_bundle_index"
            java.lang.String r9 = "last_bundle_start_timestamp"
            java.lang.String r10 = "last_bundle_end_timestamp"
            java.lang.String r11 = "app_version"
            java.lang.String r12 = "app_store"
            java.lang.String r13 = "gmp_version"
            java.lang.String r14 = "dev_cert_hash"
            java.lang.String r15 = "measurement_enabled"
            java.lang.String r16 = "day"
            java.lang.String r17 = "daily_public_events_count"
            java.lang.String r18 = "daily_events_count"
            java.lang.String r19 = "daily_conversions_count"
            java.lang.String r20 = "config_fetched_time"
            java.lang.String r21 = "failed_config_fetch_time"
            java.lang.String r22 = "app_version_int"
            java.lang.String r23 = "firebase_instance_id"
            java.lang.String r24 = "daily_error_events_count"
            java.lang.String r25 = "daily_realtime_events_count"
            java.lang.String r26 = "health_monitor_sample"
            java.lang.String r27 = "android_id"
            java.lang.String r28 = "adid_reporting_enabled"
            java.lang.String r29 = "ssaid_reporting_enabled"
            java.lang.String r30 = "admob_app_id"
            java.lang.String r31 = "dynamite_version"
            java.lang.String r32 = "safelisted_events"
            java.lang.String r33 = "ga_app_id"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33}     // Catch:{ SQLiteException -> 0x020e, all -> 0x020a }
            java.lang.String r6 = "app_id=?"
            r0 = 1
            java.lang.String[] r7 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x020e, all -> 0x020a }
            r11 = 0
            r7[r11] = r1     // Catch:{ SQLiteException -> 0x020e, all -> 0x020a }
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x020e, all -> 0x020a }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0206, all -> 0x0202 }
            if (r4 != 0) goto L_0x006b
            if (r3 == 0) goto L_0x006a
            r3.close()
        L_0x006a:
            return r2
        L_0x006b:
            com.google.android.gms.measurement.internal.zzf r4 = new com.google.android.gms.measurement.internal.zzf
            r5 = r34
            com.google.android.gms.measurement.internal.zzkk r6 = r5.zza     // Catch:{ SQLiteException -> 0x0200 }
            com.google.android.gms.measurement.internal.zzgd r6 = r6.zzs()     // Catch:{ SQLiteException -> 0x0200 }
            r4.<init>(r6, r1)     // Catch:{ SQLiteException -> 0x0200 }
            java.lang.String r6 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zza(r6)     // Catch:{ SQLiteException -> 0x0200 }
            java.lang.String r6 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzb(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 2
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zze(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 3
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzg(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 4
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zza(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 5
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzb(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 6
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzg(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 7
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzh(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 8
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzd(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 9
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zze(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 10
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r7 != 0) goto L_0x00d9
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r6 == 0) goto L_0x00d7
            goto L_0x00d9
        L_0x00d7:
            r6 = 0
            goto L_0x00da
        L_0x00d9:
            r6 = 1
        L_0x00da:
            r4.zza(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 11
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzj(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 12
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzk(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 13
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzl(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 14
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzm(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 15
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzh(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 16
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzi(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 17
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r7 == 0) goto L_0x011f
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0124
        L_0x011f:
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0200 }
            long r6 = (long) r6     // Catch:{ SQLiteException -> 0x0200 }
        L_0x0124:
            r4.zzc(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 18
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzf(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 19
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzo(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 20
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzn(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 21
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzi(r6)     // Catch:{ SQLiteException -> 0x0200 }
            com.google.android.gms.measurement.internal.zzy r6 = r34.zzt()     // Catch:{ SQLiteException -> 0x0200 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzaq.zzcl     // Catch:{ SQLiteException -> 0x0200 }
            boolean r6 = r6.zza(r7)     // Catch:{ SQLiteException -> 0x0200 }
            r7 = 0
            if (r6 != 0) goto L_0x016a
            r6 = 22
            boolean r9 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r9 == 0) goto L_0x0163
            r9 = r7
            goto L_0x0167
        L_0x0163:
            long r9 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
        L_0x0167:
            r4.zzp(r9)     // Catch:{ SQLiteException -> 0x0200 }
        L_0x016a:
            r6 = 23
            boolean r9 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r9 != 0) goto L_0x017b
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r6 == 0) goto L_0x0179
            goto L_0x017b
        L_0x0179:
            r6 = 0
            goto L_0x017c
        L_0x017b:
            r6 = 1
        L_0x017c:
            r4.zzb(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 24
            boolean r9 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r9 != 0) goto L_0x018f
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r6 == 0) goto L_0x018e
            goto L_0x018f
        L_0x018e:
            r0 = 0
        L_0x018f:
            r4.zzc(r0)     // Catch:{ SQLiteException -> 0x0200 }
            r0 = 25
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzc(r0)     // Catch:{ SQLiteException -> 0x0200 }
            r0 = 26
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0200 }
            if (r6 == 0) goto L_0x01a4
            goto L_0x01a8
        L_0x01a4:
            long r7 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0200 }
        L_0x01a8:
            r4.zzf(r7)     // Catch:{ SQLiteException -> 0x0200 }
            r0 = 27
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0200 }
            if (r6 != 0) goto L_0x01c5
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0200 }
            java.lang.String r6 = ","
            r7 = -1
            java.lang.String[] r0 = r0.split(r6, r7)     // Catch:{ SQLiteException -> 0x0200 }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zza(r0)     // Catch:{ SQLiteException -> 0x0200 }
        L_0x01c5:
            boolean r0 = com.google.android.gms.internal.measurement.zzoe.zzb()     // Catch:{ SQLiteException -> 0x0200 }
            if (r0 == 0) goto L_0x01e0
            com.google.android.gms.measurement.internal.zzy r0 = r34.zzt()     // Catch:{ SQLiteException -> 0x0200 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzaq.zzbn     // Catch:{ SQLiteException -> 0x0200 }
            boolean r0 = r0.zze(r1, r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r0 == 0) goto L_0x01e0
            r0 = 28
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzd(r0)     // Catch:{ SQLiteException -> 0x0200 }
        L_0x01e0:
            r4.zzb()     // Catch:{ SQLiteException -> 0x0200 }
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0200 }
            if (r0 == 0) goto L_0x01fa
            com.google.android.gms.measurement.internal.zzez r0 = r34.zzr()     // Catch:{ SQLiteException -> 0x0200 }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x0200 }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzez.zza(r35)     // Catch:{ SQLiteException -> 0x0200 }
            r0.zza(r6, r7)     // Catch:{ SQLiteException -> 0x0200 }
        L_0x01fa:
            if (r3 == 0) goto L_0x01ff
            r3.close()
        L_0x01ff:
            return r4
        L_0x0200:
            r0 = move-exception
            goto L_0x0212
        L_0x0202:
            r0 = move-exception
            r5 = r34
            goto L_0x022a
        L_0x0206:
            r0 = move-exception
            r5 = r34
            goto L_0x0212
        L_0x020a:
            r0 = move-exception
            r5 = r34
            goto L_0x022b
        L_0x020e:
            r0 = move-exception
            r5 = r34
            r3 = r2
        L_0x0212:
            com.google.android.gms.measurement.internal.zzez r4 = r34.zzr()     // Catch:{ all -> 0x0229 }
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzf()     // Catch:{ all -> 0x0229 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzez.zza(r35)     // Catch:{ all -> 0x0229 }
            r4.zza(r6, r1, r0)     // Catch:{ all -> 0x0229 }
            if (r3 == 0) goto L_0x0228
            r3.close()
        L_0x0228:
            return r2
        L_0x0229:
            r0 = move-exception
        L_0x022a:
            r2 = r3
        L_0x022b:
            if (r2 == 0) goto L_0x0230
            r2.close()
        L_0x0230:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzb(java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    public final void zza(zzf zzf2) {
        Preconditions.checkNotNull(zzf2);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzf2.zzc());
        contentValues.put("app_instance_id", zzf2.zzd());
        contentValues.put("gmp_app_id", zzf2.zze());
        contentValues.put("resettable_device_id_hash", zzf2.zzh());
        contentValues.put("last_bundle_index", Long.valueOf(zzf2.zzs()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzf2.zzj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzf2.zzk()));
        contentValues.put("app_version", zzf2.zzl());
        contentValues.put("app_store", zzf2.zzn());
        contentValues.put("gmp_version", Long.valueOf(zzf2.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzf2.zzp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzf2.zzr()));
        contentValues.put("day", Long.valueOf(zzf2.zzw()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzf2.zzx()));
        contentValues.put("daily_events_count", Long.valueOf(zzf2.zzy()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzf2.zzz()));
        contentValues.put("config_fetched_time", Long.valueOf(zzf2.zzt()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzf2.zzu()));
        contentValues.put("app_version_int", Long.valueOf(zzf2.zzm()));
        contentValues.put("firebase_instance_id", zzf2.zzi());
        contentValues.put("daily_error_events_count", Long.valueOf(zzf2.zzab()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzf2.zzaa()));
        contentValues.put("health_monitor_sample", zzf2.zzac());
        contentValues.put("android_id", Long.valueOf(zzf2.zzae()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzf2.zzaf()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzf2.zzag()));
        contentValues.put("admob_app_id", zzf2.zzf());
        contentValues.put("dynamite_version", Long.valueOf(zzf2.zzq()));
        if (zzf2.zzai() != null) {
            if (zzf2.zzai().size() == 0) {
                zzr().zzi().zza("Safelisted events should not be an empty list. appId", zzf2.zzc());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzf2.zzai()));
            }
        }
        if (zzoe.zzb() && zzt().zze(zzf2.zzc(), zzaq.zzbn)) {
            contentValues.put("ga_app_id", zzf2.zzg());
        }
        try {
            SQLiteDatabase c_ = c_();
            if (((long) c_.update("apps", contentValues, "app_id = ?", new String[]{zzf2.zzc()})) == 0 && c_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update app (got -1). appId", zzez.zza(zzf2.zzc()));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing app. appId", zzez.zza(zzf2.zzc()), e);
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        try {
            return (long) c_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzt().zzb(str, zzaq.zzo))))});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting over the limit events. appId", zzez.zza(str), e);
            return 0;
        }
    }

    public final zzac zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zza(j, str, 1, false, false, z3, false, z5);
    }

    public final zzac zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        String[] strArr = {str};
        zzac zzac = new zzac();
        Cursor cursor = null;
        try {
            SQLiteDatabase c_ = c_();
            Cursor query = c_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            if (!query.moveToFirst()) {
                zzr().zzi().zza("Not updating daily counts, app is not known. appId", zzez.zza(str));
                if (query != null) {
                    query.close();
                }
                return zzac;
            }
            if (query.getLong(0) == j) {
                zzac.zzb = query.getLong(1);
                zzac.zza = query.getLong(2);
                zzac.zzc = query.getLong(3);
                zzac.zzd = query.getLong(4);
                zzac.zze = query.getLong(5);
            }
            if (z) {
                zzac.zzb += j2;
            }
            if (z2) {
                zzac.zza += j2;
            }
            if (z3) {
                zzac.zzc += j2;
            }
            if (z4) {
                zzac.zzd += j2;
            }
            if (z5) {
                zzac.zze += j2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j));
            contentValues.put("daily_public_events_count", Long.valueOf(zzac.zza));
            contentValues.put("daily_events_count", Long.valueOf(zzac.zzb));
            contentValues.put("daily_conversions_count", Long.valueOf(zzac.zzc));
            contentValues.put("daily_error_events_count", Long.valueOf(zzac.zzd));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzac.zze));
            c_.update("apps", contentValues, "app_id=?", strArr);
            if (query != null) {
                query.close();
            }
            return zzac;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error updating daily counts. appId", zzez.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return zzac;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzd(java.lang.String r11) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            r10.zzd()
            r10.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.c_()     // Catch:{ SQLiteException -> 0x0056, all -> 0x0054 }
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0056, all -> 0x0054 }
            java.lang.String r4 = "app_id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0056, all -> 0x0054 }
            r9 = 0
            r5[r9] = r11     // Catch:{ SQLiteException -> 0x0056, all -> 0x0054 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0056, all -> 0x0054 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0052 }
            if (r2 != 0) goto L_0x0031
            if (r1 == 0) goto L_0x0030
            r1.close()
        L_0x0030:
            return r0
        L_0x0031:
            byte[] r2 = r1.getBlob(r9)
            boolean r3 = r1.moveToNext()
            if (r3 == 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzez r3 = r10.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza(r11)
            r3.zza(r4, r5)
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r1.close()
        L_0x0051:
            return r2
        L_0x0052:
            r2 = move-exception
            goto L_0x0058
        L_0x0054:
            r11 = move-exception
            goto L_0x0071
        L_0x0056:
            r2 = move-exception
            r1 = r0
        L_0x0058:
            com.google.android.gms.measurement.internal.zzez r3 = r10.zzr()     // Catch:{ all -> 0x006f }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()     // Catch:{ all -> 0x006f }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzez.zza(r11)     // Catch:{ all -> 0x006f }
            r3.zza(r4, r11, r2)     // Catch:{ all -> 0x006f }
            if (r1 == 0) goto L_0x006e
            r1.close()
        L_0x006e:
            return r0
        L_0x006f:
            r11 = move-exception
            r0 = r1
        L_0x0071:
            if (r0 == 0) goto L_0x0076
            r0.close()
        L_0x0076:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzd(java.lang.String):byte[]");
    }

    public final boolean zza(zzcc.zzg zzg2, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        Preconditions.checkState(zzg2.zzk());
        zzv();
        long currentTimeMillis = zzm().currentTimeMillis();
        if (zzg2.zzl() < currentTimeMillis - zzy.zzk() || zzg2.zzl() > zzy.zzk() + currentTimeMillis) {
            zzr().zzi().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzez.zza(zzg2.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzg2.zzl()));
        }
        try {
            byte[] zzc2 = zzg().zzc(zzg2.zzbi());
            zzr().zzx().zza("Saving bundle, size", Integer.valueOf(zzc2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzg2.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzg2.zzl()));
            contentValues.put("data", zzc2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzg2.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzg2.zzba()));
            }
            try {
                if (c_().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzr().zzf().zza("Failed to insert bundle (got -1). appId", zzez.zza(zzg2.zzx()));
                return false;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error storing bundle. appId", zzez.zza(zzg2.zzx()), e);
                return false;
            }
        } catch (IOException e2) {
            zzr().zzf().zza("Data loss. Failed to serialize bundle. appId", zzez.zza(zzg2.zzx()), e2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String d_() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.c_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0029, all -> 0x0024 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0022 }
            if (r2 == 0) goto L_0x001c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0022 }
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            return r1
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()
        L_0x0021:
            return r1
        L_0x0022:
            r2 = move-exception
            goto L_0x002b
        L_0x0024:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003f
        L_0x0029:
            r2 = move-exception
            r0 = r1
        L_0x002b:
            com.google.android.gms.measurement.internal.zzez r3 = r6.zzr()     // Catch:{ all -> 0x003e }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003d
            r0.close()
        L_0x003d:
            return r1
        L_0x003e:
            r1 = move-exception
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.d_():java.lang.String");
    }

    public final boolean zzk() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final List<Pair<zzcc.zzg, Long>> zza(String str, int i, int i2) {
        zzd();
        zzak();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            Cursor query = c_().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            if (!query.moveToFirst()) {
                List<Pair<zzcc.zzg, Long>> emptyList = Collections.emptyList();
                if (query != null) {
                    query.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            do {
                long j = query.getLong(0);
                try {
                    byte[] zzb2 = zzg().zzb(query.getBlob(1));
                    if (!arrayList.isEmpty() && zzb2.length + i3 > i2) {
                        break;
                    }
                    try {
                        zzcc.zzg.zza zza = (zzcc.zzg.zza) zzks.zza(zzcc.zzg.zzbf(), zzb2);
                        if (!query.isNull(2)) {
                            zza.zzi(query.getInt(2));
                        }
                        i3 += zzb2.length;
                        arrayList.add(Pair.create((zzcc.zzg) ((zzib) zza.zzv()), Long.valueOf(j)));
                    } catch (IOException e) {
                        zzr().zzf().zza("Failed to merge queued bundle. appId", zzez.zza(str), e);
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } catch (IOException e2) {
                    zzr().zzf().zza("Failed to unzip queued bundle. appId", zzez.zza(str), e2);
                }
            } while (i3 <= i2);
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e3) {
            zzr().zzf().zza("Error querying bundles. appId", zzez.zza(str), e3);
            List<Pair<zzcc.zzg, Long>> emptyList2 = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzv() {
        int delete;
        zzd();
        zzak();
        if (zzam()) {
            long zza = zzs().zzf.zza();
            long elapsedRealtime = zzm().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza) > zzaq.zzx.zza(null).longValue()) {
                zzs().zzf.zza(elapsedRealtime);
                zzd();
                zzak();
                if (zzam() && (delete = c_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzm().currentTimeMillis()), String.valueOf(zzy.zzk())})) > 0) {
                    zzr().zzx().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(List<Long> list) {
        zzd();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzam()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzb(sb3.toString(), (String[]) null) > 0) {
                zzr().zzi().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase c_ = c_();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                c_.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error incrementing retry count. error", e);
            }
        }
    }

    private final boolean zza(String str, int i, zzbu.zzb zzb2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzb2);
        Integer num = null;
        if (TextUtils.isEmpty(zzb2.zzc())) {
            zzfb zzi2 = zzr().zzi();
            Object zza = zzez.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zzb2.zza()) {
                num = Integer.valueOf(zzb2.zzb());
            }
            zzi2.zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbi = zzb2.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzb2.zza() ? Integer.valueOf(zzb2.zzb()) : null);
        contentValues.put("event_name", zzb2.zzc());
        contentValues.put("session_scoped", zzb2.zzj() ? Boolean.valueOf(zzb2.zzk()) : null);
        contentValues.put("data", zzbi);
        try {
            if (c_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert event filter (got -1). appId", zzez.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event filter. appId", zzez.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzbu.zze zze2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zze2);
        Integer num = null;
        if (TextUtils.isEmpty(zze2.zzc())) {
            zzfb zzi2 = zzr().zzi();
            Object zza = zzez.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zze2.zza()) {
                num = Integer.valueOf(zze2.zzb());
            }
            zzi2.zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbi = zze2.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zze2.zza() ? Integer.valueOf(zze2.zzb()) : null);
        contentValues.put("property_name", zze2.zzc());
        contentValues.put("session_scoped", zze2.zzg() ? Boolean.valueOf(zze2.zzh()) : null);
        contentValues.put("data", zzbi);
        try {
            if (c_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert property filter (got -1). appId", zzez.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing property filter. appId", zzez.zza(str), e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbu.zzb>> zzf(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzak()
            r12.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.c_()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x009a, all -> 0x0098 }
            java.lang.String r4 = "app_id=? AND event_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x009a, all -> 0x0098 }
            r10 = 0
            r5[r10] = r13     // Catch:{ SQLiteException -> 0x009a, all -> 0x0098 }
            r11 = 1
            r5[r11] = r14     // Catch:{ SQLiteException -> 0x009a, all -> 0x0098 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x009a, all -> 0x0098 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0096 }
            if (r1 != 0) goto L_0x0042
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0096 }
            if (r14 == 0) goto L_0x0041
            r14.close()
        L_0x0041:
            return r13
        L_0x0042:
            byte[] r1 = r14.getBlob(r11)
            com.google.android.gms.internal.measurement.zzbu$zzb$zza r2 = com.google.android.gms.internal.measurement.zzbu.zzb.zzl()     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzjm r1 = com.google.android.gms.measurement.internal.zzks.zza(r2, r1)     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzbu$zzb$zza r1 = (com.google.android.gms.internal.measurement.zzbu.zzb.zza) r1     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzjj r1 = r1.zzv()     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzbu$zzb r1 = (com.google.android.gms.internal.measurement.zzbu.zzb) r1     // Catch:{ IOException -> 0x0078 }
            int r2 = r14.getInt(r10)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.Object r3 = r0.get(r3)
            java.util.List r3 = (java.util.List) r3
            if (r3 != 0) goto L_0x0074
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r2, r3)
        L_0x0074:
            r3.add(r1)
            goto L_0x008a
        L_0x0078:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzez r2 = r12.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza(r13)
            r2.zza(r3, r4, r1)
        L_0x008a:
            boolean r1 = r14.moveToNext()
            if (r1 != 0) goto L_0x0042
            if (r14 == 0) goto L_0x0095
            r14.close()
        L_0x0095:
            return r0
        L_0x0096:
            r0 = move-exception
            goto L_0x009c
        L_0x0098:
            r13 = move-exception
            goto L_0x00d1
        L_0x009a:
            r0 = move-exception
            r14 = r9
        L_0x009c:
            com.google.android.gms.measurement.internal.zzez r1 = r12.zzr()     // Catch:{ all -> 0x00cf }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x00cf }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza(r13)     // Catch:{ all -> 0x00cf }
            r1.zza(r2, r3, r0)     // Catch:{ all -> 0x00cf }
            boolean r0 = com.google.android.gms.internal.measurement.zznm.zzb()     // Catch:{ all -> 0x00cf }
            if (r0 == 0) goto L_0x00c9
            com.google.android.gms.measurement.internal.zzy r0 = r12.zzt()     // Catch:{ all -> 0x00cf }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch:{ all -> 0x00cf }
            boolean r13 = r0.zze(r13, r1)     // Catch:{ all -> 0x00cf }
            if (r13 == 0) goto L_0x00c9
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x00cf }
            if (r14 == 0) goto L_0x00c8
            r14.close()
        L_0x00c8:
            return r13
        L_0x00c9:
            if (r14 == 0) goto L_0x00ce
            r14.close()
        L_0x00ce:
            return r9
        L_0x00cf:
            r13 = move-exception
            r9 = r14
        L_0x00d1:
            if (r9 == 0) goto L_0x00d6
            r9.close()
        L_0x00d6:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzf(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<zzbu.zzb>> zze(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            Cursor query = c_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
            if (!query.moveToFirst()) {
                Map<Integer, List<zzbu.zzb>> emptyMap = Collections.emptyMap();
                if (query != null) {
                    query.close();
                }
                return emptyMap;
            }
            do {
                try {
                    zzbu.zzb zzb2 = (zzbu.zzb) ((zzib) ((zzbu.zzb.zza) zzks.zza(zzbu.zzb.zzl(), query.getBlob(1))).zzv());
                    if (zzb2.zzf()) {
                        int i = query.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzb2);
                    }
                } catch (IOException e) {
                    zzr().zzf().zza("Failed to merge filter. appId", zzez.zza(str), e);
                }
            } while (query.moveToNext());
            if (query != null) {
                query.close();
            }
            return arrayMap;
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Database error querying filters. appId", zzez.zza(str), e2);
            Map<Integer, List<zzbu.zzb>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbu.zze>> zzg(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzak()
            r12.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.c_()
            r9 = 0
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x009a, all -> 0x0098 }
            java.lang.String r4 = "app_id=? AND property_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x009a, all -> 0x0098 }
            r10 = 0
            r5[r10] = r13     // Catch:{ SQLiteException -> 0x009a, all -> 0x0098 }
            r11 = 1
            r5[r11] = r14     // Catch:{ SQLiteException -> 0x009a, all -> 0x0098 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x009a, all -> 0x0098 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0096 }
            if (r1 != 0) goto L_0x0042
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0096 }
            if (r14 == 0) goto L_0x0041
            r14.close()
        L_0x0041:
            return r13
        L_0x0042:
            byte[] r1 = r14.getBlob(r11)
            com.google.android.gms.internal.measurement.zzbu$zze$zza r2 = com.google.android.gms.internal.measurement.zzbu.zze.zzi()     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzjm r1 = com.google.android.gms.measurement.internal.zzks.zza(r2, r1)     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzbu$zze$zza r1 = (com.google.android.gms.internal.measurement.zzbu.zze.zza) r1     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzjj r1 = r1.zzv()     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzbu$zze r1 = (com.google.android.gms.internal.measurement.zzbu.zze) r1     // Catch:{ IOException -> 0x0078 }
            int r2 = r14.getInt(r10)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.Object r3 = r0.get(r3)
            java.util.List r3 = (java.util.List) r3
            if (r3 != 0) goto L_0x0074
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r2, r3)
        L_0x0074:
            r3.add(r1)
            goto L_0x008a
        L_0x0078:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzez r2 = r12.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza(r13)
            r2.zza(r3, r4, r1)
        L_0x008a:
            boolean r1 = r14.moveToNext()
            if (r1 != 0) goto L_0x0042
            if (r14 == 0) goto L_0x0095
            r14.close()
        L_0x0095:
            return r0
        L_0x0096:
            r0 = move-exception
            goto L_0x009c
        L_0x0098:
            r13 = move-exception
            goto L_0x00d1
        L_0x009a:
            r0 = move-exception
            r14 = r9
        L_0x009c:
            com.google.android.gms.measurement.internal.zzez r1 = r12.zzr()     // Catch:{ all -> 0x00cf }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x00cf }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzez.zza(r13)     // Catch:{ all -> 0x00cf }
            r1.zza(r2, r3, r0)     // Catch:{ all -> 0x00cf }
            boolean r0 = com.google.android.gms.internal.measurement.zznm.zzb()     // Catch:{ all -> 0x00cf }
            if (r0 == 0) goto L_0x00c9
            com.google.android.gms.measurement.internal.zzy r0 = r12.zzt()     // Catch:{ all -> 0x00cf }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch:{ all -> 0x00cf }
            boolean r13 = r0.zze(r13, r1)     // Catch:{ all -> 0x00cf }
            if (r13 == 0) goto L_0x00c9
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x00cf }
            if (r14 == 0) goto L_0x00c8
            r14.close()
        L_0x00c8:
            return r13
        L_0x00c9:
            if (r14 == 0) goto L_0x00ce
            r14.close()
        L_0x00ce:
            return r9
        L_0x00cf:
            r13 = move-exception
            r9 = r14
        L_0x00d1:
            if (r9 == 0) goto L_0x00d6
            r9.close()
        L_0x00d6:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzg(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> zzf(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzak()
            r7.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.c_()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0069, all -> 0x0067 }
            r5 = 0
            r4[r5] = r8     // Catch:{ SQLiteException -> 0x0069, all -> 0x0067 }
            r6 = 1
            r4[r6] = r8     // Catch:{ SQLiteException -> 0x0069, all -> 0x0067 }
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x0069, all -> 0x0067 }
            boolean r3 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0065 }
            if (r3 != 0) goto L_0x0032
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0065 }
            if (r1 == 0) goto L_0x0031
            r1.close()
        L_0x0031:
            return r8
        L_0x0032:
            int r3 = r1.getInt(r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            java.lang.Object r4 = r0.get(r4)
            java.util.List r4 = (java.util.List) r4
            if (r4 != 0) goto L_0x004e
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.put(r3, r4)
        L_0x004e:
            int r3 = r1.getInt(r6)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4.add(r3)
            boolean r3 = r1.moveToNext()
            if (r3 != 0) goto L_0x0032
            if (r1 == 0) goto L_0x0064
            r1.close()
        L_0x0064:
            return r0
        L_0x0065:
            r0 = move-exception
            goto L_0x006b
        L_0x0067:
            r8 = move-exception
            goto L_0x00a0
        L_0x0069:
            r0 = move-exception
            r1 = r2
        L_0x006b:
            com.google.android.gms.measurement.internal.zzez r3 = r7.zzr()     // Catch:{ all -> 0x009e }
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()     // Catch:{ all -> 0x009e }
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzez.zza(r8)     // Catch:{ all -> 0x009e }
            r3.zza(r4, r5, r0)     // Catch:{ all -> 0x009e }
            boolean r0 = com.google.android.gms.internal.measurement.zznm.zzb()     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x0098
            com.google.android.gms.measurement.internal.zzy r0 = r7.zzt()     // Catch:{ all -> 0x009e }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch:{ all -> 0x009e }
            boolean r8 = r0.zze(r8, r3)     // Catch:{ all -> 0x009e }
            if (r8 == 0) goto L_0x0098
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x0097
            r1.close()
        L_0x0097:
            return r8
        L_0x0098:
            if (r1 == 0) goto L_0x009d
            r1.close()
        L_0x009d:
            return r2
        L_0x009e:
            r8 = move-exception
            r2 = r1
        L_0x00a0:
            if (r2 == 0) goto L_0x00a5
            r2.close()
        L_0x00a5:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzf(java.lang.String):java.util.Map");
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzd();
        SQLiteDatabase c_ = c_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzt().zzb(str, zzaq.zzae)));
            if (zzb2 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return c_.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error querying filters. appId", zzez.zza(str), e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzcc.zzi> zzg(java.lang.String r12) {
        /*
            r11 = this;
            r11.zzak()
            r11.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.c_()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            java.lang.String r2 = "audience_id"
            java.lang.String r3 = "current_results"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ SQLiteException -> 0x009c, all -> 0x009a }
            java.lang.String r3 = "app_id=?"
            r9 = 1
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x009c, all -> 0x009a }
            r10 = 0
            r4[r10] = r12     // Catch:{ SQLiteException -> 0x009c, all -> 0x009a }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x009c, all -> 0x009a }
            boolean r1 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0098 }
            if (r1 != 0) goto L_0x004f
            boolean r1 = com.google.android.gms.internal.measurement.zznm.zzb()     // Catch:{ SQLiteException -> 0x0098 }
            if (r1 == 0) goto L_0x0049
            com.google.android.gms.measurement.internal.zzy r1 = r11.zzt()     // Catch:{ SQLiteException -> 0x0098 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch:{ SQLiteException -> 0x0098 }
            boolean r1 = r1.zze(r12, r2)     // Catch:{ SQLiteException -> 0x0098 }
            if (r1 == 0) goto L_0x0049
            java.util.Map r12 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0098 }
            if (r0 == 0) goto L_0x0048
            r0.close()
        L_0x0048:
            return r12
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r0.close()
        L_0x004e:
            return r8
        L_0x004f:
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap
            r1.<init>()
        L_0x0054:
            int r2 = r0.getInt(r10)
            byte[] r3 = r0.getBlob(r9)
            com.google.android.gms.internal.measurement.zzcc$zzi$zza r4 = com.google.android.gms.internal.measurement.zzcc.zzi.zzi()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzjm r3 = com.google.android.gms.measurement.internal.zzks.zza(r4, r3)     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzcc$zzi$zza r3 = (com.google.android.gms.internal.measurement.zzcc.zzi.zza) r3     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzjj r3 = r3.zzv()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzib r3 = (com.google.android.gms.internal.measurement.zzib) r3     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzcc$zzi r3 = (com.google.android.gms.internal.measurement.zzcc.zzi) r3     // Catch:{ IOException -> 0x0076 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.put(r2, r3)
            goto L_0x008c
        L_0x0076:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzez r4 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzf()
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzez.zza(r12)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4.zza(r5, r6, r2, r3)
        L_0x008c:
            boolean r2 = r0.moveToNext()
            if (r2 != 0) goto L_0x0054
            if (r0 == 0) goto L_0x0097
            r0.close()
        L_0x0097:
            return r1
        L_0x0098:
            r1 = move-exception
            goto L_0x009e
        L_0x009a:
            r12 = move-exception
            goto L_0x00d3
        L_0x009c:
            r1 = move-exception
            r0 = r8
        L_0x009e:
            com.google.android.gms.measurement.internal.zzez r2 = r11.zzr()     // Catch:{ all -> 0x00d1 }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()     // Catch:{ all -> 0x00d1 }
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzez.zza(r12)     // Catch:{ all -> 0x00d1 }
            r2.zza(r3, r4, r1)     // Catch:{ all -> 0x00d1 }
            boolean r1 = com.google.android.gms.internal.measurement.zznm.zzb()     // Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x00cb
            com.google.android.gms.measurement.internal.zzy r1 = r11.zzt()     // Catch:{ all -> 0x00d1 }
            com.google.android.gms.measurement.internal.zzeo<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch:{ all -> 0x00d1 }
            boolean r12 = r1.zze(r12, r2)     // Catch:{ all -> 0x00d1 }
            if (r12 == 0) goto L_0x00cb
            java.util.Map r12 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x00d1 }
            if (r0 == 0) goto L_0x00ca
            r0.close()
        L_0x00ca:
            return r12
        L_0x00cb:
            if (r0 == 0) goto L_0x00d0
            r0.close()
        L_0x00d0:
            return r8
        L_0x00d1:
            r12 = move-exception
            r8 = r0
        L_0x00d3:
            if (r8 == 0) goto L_0x00d8
            r8.close()
        L_0x00d8:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzg(java.lang.String):java.util.Map");
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzr().zzf().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzr().zzf().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzr().zzf().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    public final long zzw() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    /* access modifiers changed from: protected */
    public final long zzh(String str, String str2) {
        long zza;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        SQLiteDatabase c_ = c_();
        c_.beginTransaction();
        long j = 0;
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str2);
            sb.append(" from app2 where app_id=?");
            try {
                zza = zza(sb.toString(), new String[]{str}, -1);
                if (zza == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (c_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzr().zzf().zza("Failed to insert column (got -1). appId", zzez.zza(str), str2);
                        c_.endTransaction();
                        return -1;
                    }
                    zza = 0;
                }
            } catch (SQLiteException e) {
                e = e;
                try {
                    zzr().zzf().zza("Error inserting column. appId", zzez.zza(str), str2, e);
                    c_.endTransaction();
                    return j;
                } catch (Throwable th) {
                    th = th;
                    c_.endTransaction();
                    throw th;
                }
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + zza));
                if (((long) c_.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    zzr().zzf().zza("Failed to update column (got 0). appId", zzez.zza(str), str2);
                    c_.endTransaction();
                    return -1;
                }
                c_.setTransactionSuccessful();
                c_.endTransaction();
                return zza;
            } catch (SQLiteException e2) {
                e = e2;
                j = zza;
                zzr().zzf().zza("Error inserting column. appId", zzez.zza(str), str2, e);
                c_.endTransaction();
                return j;
            }
        } catch (SQLiteException e3) {
            e = e3;
            zzr().zzf().zza("Error inserting column. appId", zzez.zza(str), str2, e);
            c_.endTransaction();
            return j;
        } catch (Throwable th2) {
            th = th2;
            c_.endTransaction();
            throw th;
        }
    }

    public final long zzx() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long zza(zzcc.zzg zzg2) throws IOException {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        byte[] zzbi = zzg2.zzbi();
        long zza = zzg().zza(zzbi);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg2.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza));
        contentValues.put("metadata", zzbi);
        try {
            c_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return zza;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event metadata. appId", zzez.zza(zzg2.zzx()), e);
            throw e;
        }
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(long r5) {
        /*
            r4 = this;
            r4.zzd()
            r4.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.c_()     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x003e }
            if (r1 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzez r6 = r4.zzr()     // Catch:{ SQLiteException -> 0x003e }
            com.google.android.gms.measurement.internal.zzfb r6 = r6.zzx()     // Catch:{ SQLiteException -> 0x003e }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch:{ SQLiteException -> 0x003e }
            if (r5 == 0) goto L_0x0033
            r5.close()
        L_0x0033:
            return r0
        L_0x0034:
            java.lang.String r6 = r5.getString(r6)
            if (r5 == 0) goto L_0x003d
            r5.close()
        L_0x003d:
            return r6
        L_0x003e:
            r6 = move-exception
            goto L_0x0044
        L_0x0040:
            r6 = move-exception
            goto L_0x0059
        L_0x0042:
            r6 = move-exception
            r5 = r0
        L_0x0044:
            com.google.android.gms.measurement.internal.zzez r1 = r4.zzr()     // Catch:{ all -> 0x0057 }
            com.google.android.gms.measurement.internal.zzfb r1 = r1.zzf()     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch:{ all -> 0x0057 }
            if (r5 == 0) goto L_0x0056
            r5.close()
        L_0x0056:
            return r0
        L_0x0057:
            r6 = move-exception
            r0 = r5
        L_0x0059:
            if (r0 == 0) goto L_0x005e
            r0.close()
        L_0x005e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(long):java.lang.String");
    }

    public final long zzaa() {
        Cursor cursor = null;
        try {
            cursor = c_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzcc.zzc, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzd()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.c_()     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            r6 = 1
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0077 }
            if (r2 != 0) goto L_0x0037
            com.google.android.gms.measurement.internal.zzez r8 = r7.zzr()     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzx()     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch:{ SQLiteException -> 0x0077 }
            if (r1 == 0) goto L_0x0036
            r1.close()
        L_0x0036:
            return r0
        L_0x0037:
            byte[] r2 = r1.getBlob(r4)
            long r3 = r1.getLong(r6)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r4 = com.google.android.gms.internal.measurement.zzcc.zzc.zzj()     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzjm r2 = com.google.android.gms.measurement.internal.zzks.zza(r4, r2)     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzjj r2 = r2.zzv()     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzib r2 = (com.google.android.gms.internal.measurement.zzib) r2     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzcc$zzc r2 = (com.google.android.gms.internal.measurement.zzcc.zzc) r2     // Catch:{ IOException -> 0x005f }
            android.util.Pair r8 = android.util.Pair.create(r2, r3)
            if (r1 == 0) goto L_0x005e
            r1.close()
        L_0x005e:
            return r8
        L_0x005f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzez r3 = r7.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzez.zza(r8)
            r3.zza(r4, r8, r9, r2)
            if (r1 == 0) goto L_0x0076
            r1.close()
        L_0x0076:
            return r0
        L_0x0077:
            r8 = move-exception
            goto L_0x007d
        L_0x0079:
            r8 = move-exception
            goto L_0x0092
        L_0x007b:
            r8 = move-exception
            r1 = r0
        L_0x007d:
            com.google.android.gms.measurement.internal.zzez r9 = r7.zzr()     // Catch:{ all -> 0x0090 }
            com.google.android.gms.measurement.internal.zzfb r9 = r9.zzf()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x008f
            r1.close()
        L_0x008f:
            return r0
        L_0x0090:
            r8 = move-exception
            r0 = r1
        L_0x0092:
            if (r0 == 0) goto L_0x0097
            r0.close()
        L_0x0097:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean zza(String str, Long l, long j, zzcc.zzc zzc2) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzc2);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbi = zzc2.zzbi();
        zzr().zzx().zza("Saving complex main event, appId, data size", zzo().zza(str), Integer.valueOf(zzbi.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbi);
        try {
            if (c_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert complex main event (got -1). appId", zzez.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing complex main event. appId", zzez.zza(str), e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, Bundle bundle) {
        zzd();
        zzak();
        byte[] zzbi = zzg().zza(new zzal(this.zzy, "", str, "dep", 0, 0, bundle)).zzbi();
        zzr().zzx().zza("Saving default event parameters, appId, data size", zzo().zza(str), Integer.valueOf(zzbi.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(Annotation.PARAMETERS, zzbi);
        try {
            if (c_().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert default event parameters (got -1). appId", zzez.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing default event parameters. appId", zzez.zza(str), e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzi(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzd()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.c_()     // Catch:{ SQLiteException -> 0x00c0, all -> 0x00be }
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00c0, all -> 0x00be }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x00c0, all -> 0x00be }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x00c0, all -> 0x00be }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00bc }
            if (r2 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzez r8 = r7.zzr()     // Catch:{ SQLiteException -> 0x00bc }
            com.google.android.gms.measurement.internal.zzfb r8 = r8.zzx()     // Catch:{ SQLiteException -> 0x00bc }
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch:{ SQLiteException -> 0x00bc }
            if (r1 == 0) goto L_0x002f
            r1.close()
        L_0x002f:
            return r0
        L_0x0030:
            byte[] r2 = r1.getBlob(r4)
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r3 = com.google.android.gms.internal.measurement.zzcc.zzc.zzj()     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzjm r2 = com.google.android.gms.measurement.internal.zzks.zza(r3, r2)     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzcc$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcc.zzc.zza) r2     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzjj r2 = r2.zzv()     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzib r2 = (com.google.android.gms.internal.measurement.zzib) r2     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzcc$zzc r2 = (com.google.android.gms.internal.measurement.zzcc.zzc) r2     // Catch:{ IOException -> 0x00a4 }
            r7.zzg()
            java.util.List r8 = r2.zza()
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x0056:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x009e
            java.lang.Object r3 = r8.next()
            com.google.android.gms.internal.measurement.zzcc$zze r3 = (com.google.android.gms.internal.measurement.zzcc.zze) r3
            java.lang.String r4 = r3.zzb()
            boolean r5 = r3.zzi()
            if (r5 == 0) goto L_0x0074
            double r5 = r3.zzj()
            r2.putDouble(r4, r5)
            goto L_0x0056
        L_0x0074:
            boolean r5 = r3.zzg()
            if (r5 == 0) goto L_0x0082
            float r3 = r3.zzh()
            r2.putFloat(r4, r3)
            goto L_0x0056
        L_0x0082:
            boolean r5 = r3.zzc()
            if (r5 == 0) goto L_0x0090
            java.lang.String r3 = r3.zzd()
            r2.putString(r4, r3)
            goto L_0x0056
        L_0x0090:
            boolean r5 = r3.zze()
            if (r5 == 0) goto L_0x0056
            long r5 = r3.zzf()
            r2.putLong(r4, r5)
            goto L_0x0056
        L_0x009e:
            if (r1 == 0) goto L_0x00a3
            r1.close()
        L_0x00a3:
            return r2
        L_0x00a4:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzez r3 = r7.zzr()
            com.google.android.gms.measurement.internal.zzfb r3 = r3.zzf()
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzez.zza(r8)
            r3.zza(r4, r8, r2)
            if (r1 == 0) goto L_0x00bb
            r1.close()
        L_0x00bb:
            return r0
        L_0x00bc:
            r8 = move-exception
            goto L_0x00c2
        L_0x00be:
            r8 = move-exception
            goto L_0x00d7
        L_0x00c0:
            r8 = move-exception
            r1 = r0
        L_0x00c2:
            com.google.android.gms.measurement.internal.zzez r2 = r7.zzr()     // Catch:{ all -> 0x00d5 }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r8)     // Catch:{ all -> 0x00d5 }
            if (r1 == 0) goto L_0x00d4
            r1.close()
        L_0x00d4:
            return r0
        L_0x00d5:
            r8 = move-exception
            r0 = r1
        L_0x00d7:
            if (r0 == 0) goto L_0x00dc
            r0.close()
        L_0x00dc:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzi(java.lang.String):android.os.Bundle");
    }

    public final boolean zza(zzal zzal, long j, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzal);
        Preconditions.checkNotEmpty(zzal.zza);
        byte[] zzbi = zzg().zza(zzal).zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzal.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzal.zzb);
        contentValues.put("timestamp", Long.valueOf(zzal.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", zzbi);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (c_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert raw event (got -1). appId", zzez.zza(zzal.zza));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event. appId", zzez.zza(zzal.zza), e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, List<zzbu.zza> list) {
        boolean z;
        boolean z2;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzbu.zza.C0028zza zza = (zzbu.zza.C0028zza) list.get(i).zzbl();
            if (zza.zzb() != 0) {
                for (int i2 = 0; i2 < zza.zzb(); i2++) {
                    zzbu.zzb.zza zza2 = (zzbu.zzb.zza) zza.zzb(i2).zzbl();
                    zzbu.zzb.zza zza3 = (zzbu.zzb.zza) ((zzib.zza) zza2.clone());
                    String zzb2 = zzhb.zzb(zza2.zza());
                    if (zzb2 != null) {
                        zza3.zza(zzb2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zza2.zzb(); i3++) {
                        zzbu.zzc zza4 = zza2.zza(i3);
                        String zza5 = zzha.zza(zza4.zzh());
                        if (zza5 != null) {
                            zza3.zza(i3, (zzbu.zzc) ((zzib) ((zzbu.zzc.zza) zza4.zzbl()).zza(zza5).zzv()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zza = zza.zza(i2, zza3);
                        list.set(i, (zzbu.zza) ((zzib) zza.zzv()));
                    }
                }
            }
            if (zza.zza() != 0) {
                for (int i4 = 0; i4 < zza.zza(); i4++) {
                    zzbu.zze zza6 = zza.zza(i4);
                    String zza7 = zzhd.zza(zza6.zzc());
                    if (zza7 != null) {
                        zza = zza.zza(i4, ((zzbu.zze.zza) zza6.zzbl()).zza(zza7));
                        list.set(i, (zzbu.zza) ((zzib) zza.zzv()));
                    }
                }
            }
        }
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase c_ = c_();
        c_.beginTransaction();
        try {
            zzak();
            zzd();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase c_2 = c_();
            c_2.delete("property_filters", "app_id=?", new String[]{str});
            c_2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzbu.zza zza8 : list) {
                zzak();
                zzd();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zza8);
                if (!zza8.zza()) {
                    zzr().zzi().zza("Audience with no ID. appId", zzez.zza(str));
                } else {
                    int zzb3 = zza8.zzb();
                    Iterator<zzbu.zzb> it2 = zza8.zze().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!it2.next().zza()) {
                                zzr().zzi().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzez.zza(str), Integer.valueOf(zzb3));
                                break;
                            }
                        } else {
                            Iterator<zzbu.zze> it3 = zza8.zzc().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    if (!it3.next().zza()) {
                                        zzr().zzi().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzez.zza(str), Integer.valueOf(zzb3));
                                        break;
                                    }
                                } else {
                                    Iterator<zzbu.zzb> it4 = zza8.zze().iterator();
                                    while (true) {
                                        if (it4.hasNext()) {
                                            if (!zza(str, zzb3, it4.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzbu.zze> it5 = zza8.zzc().iterator();
                                        while (true) {
                                            if (it5.hasNext()) {
                                                if (!zza(str, zzb3, it5.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzak();
                                        zzd();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase c_3 = c_();
                                        c_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zzb3)});
                                        c_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zzb3)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbu.zza zza9 : list) {
                arrayList.add(zza9.zza() ? Integer.valueOf(zza9.zzb()) : null);
            }
            zzb(str, arrayList);
            c_.setTransactionSuccessful();
        } finally {
            c_.endTransaction();
        }
    }

    private final boolean zzam() {
        return zzn().getDatabasePath("google_app_measurement.db").exists();
    }
}
