package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzev extends zzg {
    private final zzeu zza = new zzeu(this, zzn(), "google_app_measurement_local.db");
    private boolean zzb;

    zzev(zzgd zzgd) {
        super(zzgd);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zzz() {
        return false;
    }

    public final void zzab() {
        zzb();
        zzd();
        try {
            int delete = zzae().delete("messages", null, null) + 0;
            if (delete > 0) {
                zzr().zzx().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error resetting local analytics data. error", e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: android.database.Cursor} */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c4 A[SYNTHETIC, Splitter:B:45:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x011a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x011a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x011a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.zzb()
            r16.zzd()
            boolean r0 = r1.zzb
            r2 = 0
            if (r0 == 0) goto L_0x000e
            return r2
        L_0x000e:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            java.lang.String r4 = "type"
            r3.put(r4, r0)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            r4 = 5
            r5 = 0
            r6 = 5
        L_0x0026:
            if (r5 >= r4) goto L_0x012c
            r7 = 0
            r8 = 1
            android.database.sqlite.SQLiteDatabase r9 = r16.zzae()     // Catch:{ SQLiteFullException -> 0x00fe, SQLiteDatabaseLockedException -> 0x00ec, SQLiteException -> 0x00c0, all -> 0x00bd }
            if (r9 != 0) goto L_0x0038
            r1.zzb = r8     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ed, SQLiteException -> 0x00b7 }
            if (r9 == 0) goto L_0x0037
            r9.close()
        L_0x0037:
            return r2
        L_0x0038:
            r9.beginTransaction()
            r10 = 0
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r12 = r9.rawQuery(r0, r7)
            if (r12 == 0) goto L_0x0059
            boolean r0 = r12.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            if (r0 == 0) goto L_0x0059
            long r10 = r12.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            goto L_0x0059
        L_0x0050:
            r0 = move-exception
            goto L_0x00ea
        L_0x0053:
            r0 = move-exception
            goto L_0x00b9
        L_0x0055:
            r0 = move-exception
            r7 = r12
            goto L_0x0100
        L_0x0059:
            java.lang.String r0 = "messages"
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x00a0
            com.google.android.gms.measurement.internal.zzez r15 = r16.zzr()
            com.google.android.gms.measurement.internal.zzfb r15 = r15.zzf()
            java.lang.String r4 = "Data loss, local db full"
            r15.zza(r4)
            long r13 = r13 - r10
            r10 = 1
            long r13 = r13 + r10
            java.lang.String r4 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r10 = new java.lang.String[r8]
            java.lang.String r11 = java.lang.Long.toString(r13)
            r10[r2] = r11
            int r4 = r9.delete(r0, r4, r10)
            long r10 = (long) r4
            int r4 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x00a0
            com.google.android.gms.measurement.internal.zzez r4 = r16.zzr()
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzf()
            java.lang.String r15 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r13)
            java.lang.Long r8 = java.lang.Long.valueOf(r10)
            long r13 = r13 - r10
            java.lang.Long r10 = java.lang.Long.valueOf(r13)
            r4.zza(r15, r2, r8, r10)
        L_0x00a0:
            r9.insertOrThrow(r0, r7, r3)
            r9.setTransactionSuccessful()
            r9.endTransaction()
            if (r12 == 0) goto L_0x00ae
            r12.close()
        L_0x00ae:
            if (r9 == 0) goto L_0x00b3
            r9.close()
        L_0x00b3:
            r2 = 1
            return r2
        L_0x00b5:
            r7 = r12
            goto L_0x00ed
        L_0x00b7:
            r0 = move-exception
            r12 = r7
        L_0x00b9:
            r7 = r9
            goto L_0x00c2
        L_0x00bb:
            r0 = move-exception
            goto L_0x0100
        L_0x00bd:
            r0 = move-exception
            r9 = r7
            goto L_0x0121
        L_0x00c0:
            r0 = move-exception
            r12 = r7
        L_0x00c2:
            if (r7 == 0) goto L_0x00cd
            boolean r2 = r7.inTransaction()     // Catch:{ all -> 0x00e8 }
            if (r2 == 0) goto L_0x00cd
            r7.endTransaction()     // Catch:{ all -> 0x00e8 }
        L_0x00cd:
            com.google.android.gms.measurement.internal.zzez r2 = r16.zzr()     // Catch:{ all -> 0x00e8 }
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()     // Catch:{ all -> 0x00e8 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zza(r4, r0)     // Catch:{ all -> 0x00e8 }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x00e8 }
            if (r12 == 0) goto L_0x00e2
            r12.close()
        L_0x00e2:
            if (r7 == 0) goto L_0x011a
            r7.close()
            goto L_0x011a
        L_0x00e8:
            r0 = move-exception
            r9 = r7
        L_0x00ea:
            r7 = r12
            goto L_0x0121
        L_0x00ec:
            r9 = r7
        L_0x00ed:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x0120 }
            int r6 = r6 + 20
            if (r7 == 0) goto L_0x00f8
            r7.close()
        L_0x00f8:
            if (r9 == 0) goto L_0x011a
            r9.close()
            goto L_0x011a
        L_0x00fe:
            r0 = move-exception
            r9 = r7
        L_0x0100:
            com.google.android.gms.measurement.internal.zzez r2 = r16.zzr()
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzf()
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zza(r4, r0)
            r2 = 1
            r1.zzb = r2
            if (r7 == 0) goto L_0x0115
            r7.close()
        L_0x0115:
            if (r9 == 0) goto L_0x011a
            r9.close()
        L_0x011a:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0026
        L_0x0120:
            r0 = move-exception
        L_0x0121:
            if (r7 == 0) goto L_0x0126
            r7.close()
        L_0x0126:
            if (r9 == 0) goto L_0x012b
            r9.close()
        L_0x012b:
            throw r0
        L_0x012c:
            com.google.android.gms.measurement.internal.zzez r0 = r16.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzx()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzev.zza(int, byte[]):boolean");
    }

    public final boolean zza(zzao zzao) {
        Parcel obtain = Parcel.obtain();
        zzao.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzr().zzg().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzkr zzkr) {
        Parcel obtain = Parcel.obtain();
        zzkr.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzr().zzg().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zza(zzw zzw) {
        zzp();
        byte[] zza2 = zzkw.zza((Parcelable) zzw);
        if (zza2.length <= 131072) {
            return zza(2, zza2);
        }
        zzr().zzg().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:51|52|53) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:40|41|42|159) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        zzr().zzf().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b5, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b8, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        zzr().zzf().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e1, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00eb, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ee, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0108, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        zzr().zzf().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0117, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0122, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0125, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x018f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0196, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00a4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00d4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x010a */
    /* JADX WARNING: Removed duplicated region for block: B:100:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01a6 A[SYNTHETIC, Splitter:B:113:0x01a6] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01f4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01f4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01f4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x018f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:12:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zza(int r22) {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r2 = "Error reading entries from local database"
            r21.zzd()
            r21.zzb()
            boolean r0 = r1.zzb
            r3 = 0
            if (r0 == 0) goto L_0x0010
            return r3
        L_0x0010:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r0 = r21.zzaf()
            if (r0 != 0) goto L_0x001c
            return r4
        L_0x001c:
            r5 = 5
            r6 = 0
            r7 = 0
            r8 = 5
        L_0x0020:
            if (r7 >= r5) goto L_0x0207
            r9 = 1
            android.database.sqlite.SQLiteDatabase r15 = r21.zzae()     // Catch:{ SQLiteFullException -> 0x01da, SQLiteDatabaseLockedException -> 0x01c7, SQLiteException -> 0x01a1, all -> 0x019e }
            if (r15 != 0) goto L_0x0037
            r1.zzb = r9     // Catch:{ SQLiteFullException -> 0x0034, SQLiteDatabaseLockedException -> 0x0196, SQLiteException -> 0x0031, all -> 0x018f }
            if (r15 == 0) goto L_0x0030
            r15.close()
        L_0x0030:
            return r3
        L_0x0031:
            r0 = move-exception
            goto L_0x0194
        L_0x0034:
            r0 = move-exception
            goto L_0x019c
        L_0x0037:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x019a, SQLiteDatabaseLockedException -> 0x0196, SQLiteException -> 0x0192, all -> 0x018f }
            long r10 = zza(r15)     // Catch:{ SQLiteFullException -> 0x019a, SQLiteDatabaseLockedException -> 0x0196, SQLiteException -> 0x0192, all -> 0x018f }
            r19 = -1
            int r0 = (r10 > r19 ? 1 : (r10 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r12 = new java.lang.String[r9]
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r12[r6] = r10
            r13 = r0
            r14 = r12
            goto L_0x0053
        L_0x0051:
            r13 = r3
            r14 = r13
        L_0x0053:
            java.lang.String r11 = "messages"
            java.lang.String r0 = "rowid"
            java.lang.String r10 = "type"
            java.lang.String r12 = "entry"
            java.lang.String[] r12 = new java.lang.String[]{r0, r10, r12}
            r0 = 0
            r16 = 0
            java.lang.String r17 = "rowid asc"
            r10 = 100
            java.lang.String r18 = java.lang.Integer.toString(r10)
            r10 = r15
            r5 = r15
            r15 = r0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x018a, SQLiteDatabaseLockedException -> 0x0197, SQLiteException -> 0x0186, all -> 0x0183 }
        L_0x0071:
            boolean r0 = r10.moveToNext()     // Catch:{ SQLiteFullException -> 0x0181, SQLiteDatabaseLockedException -> 0x0198, SQLiteException -> 0x017f, all -> 0x017b }
            if (r0 == 0) goto L_0x0147
            long r19 = r10.getLong(r6)     // Catch:{ SQLiteFullException -> 0x0181, SQLiteDatabaseLockedException -> 0x0198, SQLiteException -> 0x017f, all -> 0x017b }
            int r0 = r10.getInt(r9)     // Catch:{ SQLiteFullException -> 0x0181, SQLiteDatabaseLockedException -> 0x0198, SQLiteException -> 0x017f, all -> 0x017b }
            r11 = 2
            byte[] r12 = r10.getBlob(r11)     // Catch:{ SQLiteFullException -> 0x0181, SQLiteDatabaseLockedException -> 0x0198, SQLiteException -> 0x017f, all -> 0x017b }
            if (r0 != 0) goto L_0x00b9
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0181, SQLiteDatabaseLockedException -> 0x0198, SQLiteException -> 0x017f, all -> 0x017b }
            int r0 = r12.length     // Catch:{ ParseException -> 0x00a4 }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x00a4 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x00a4 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzao> r0 = com.google.android.gms.measurement.internal.zzao.CREATOR     // Catch:{ ParseException -> 0x00a4 }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x00a4 }
            com.google.android.gms.measurement.internal.zzao r0 = (com.google.android.gms.measurement.internal.zzao) r0     // Catch:{ ParseException -> 0x00a4 }
            r11.recycle()
            if (r0 == 0) goto L_0x0071
            r4.add(r0)
            goto L_0x0071
        L_0x00a2:
            r0 = move-exception
            goto L_0x00b5
        L_0x00a4:
            com.google.android.gms.measurement.internal.zzez r0 = r21.zzr()     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ all -> 0x00a2 }
            java.lang.String r12 = "Failed to load event from local database"
            r0.zza(r12)     // Catch:{ all -> 0x00a2 }
            r11.recycle()
            goto L_0x0071
        L_0x00b5:
            r11.recycle()
            throw r0
        L_0x00b9:
            if (r0 != r9) goto L_0x00ef
            android.os.Parcel r11 = android.os.Parcel.obtain()
            int r0 = r12.length     // Catch:{ ParseException -> 0x00d4 }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x00d4 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x00d4 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkr> r0 = com.google.android.gms.measurement.internal.zzkr.CREATOR     // Catch:{ ParseException -> 0x00d4 }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x00d4 }
            com.google.android.gms.measurement.internal.zzkr r0 = (com.google.android.gms.measurement.internal.zzkr) r0     // Catch:{ ParseException -> 0x00d4 }
            r11.recycle()
            goto L_0x00e5
        L_0x00d2:
            r0 = move-exception
            goto L_0x00eb
        L_0x00d4:
            com.google.android.gms.measurement.internal.zzez r0 = r21.zzr()     // Catch:{ all -> 0x00d2 }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ all -> 0x00d2 }
            java.lang.String r12 = "Failed to load user property from local database"
            r0.zza(r12)     // Catch:{ all -> 0x00d2 }
            r11.recycle()
            r0 = r3
        L_0x00e5:
            if (r0 == 0) goto L_0x0071
            r4.add(r0)
            goto L_0x0071
        L_0x00eb:
            r11.recycle()
            throw r0
        L_0x00ef:
            if (r0 != r11) goto L_0x0126
            android.os.Parcel r11 = android.os.Parcel.obtain()
            int r0 = r12.length     // Catch:{ ParseException -> 0x010a }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x010a }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x010a }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzw> r0 = com.google.android.gms.measurement.internal.zzw.CREATOR     // Catch:{ ParseException -> 0x010a }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x010a }
            com.google.android.gms.measurement.internal.zzw r0 = (com.google.android.gms.measurement.internal.zzw) r0     // Catch:{ ParseException -> 0x010a }
            r11.recycle()
            goto L_0x011b
        L_0x0108:
            r0 = move-exception
            goto L_0x0122
        L_0x010a:
            com.google.android.gms.measurement.internal.zzez r0 = r21.zzr()     // Catch:{ all -> 0x0108 }
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()     // Catch:{ all -> 0x0108 }
            java.lang.String r12 = "Failed to load conditional user property from local database"
            r0.zza(r12)     // Catch:{ all -> 0x0108 }
            r11.recycle()
            r0 = r3
        L_0x011b:
            if (r0 == 0) goto L_0x0071
            r4.add(r0)
            goto L_0x0071
        L_0x0122:
            r11.recycle()
            throw r0
        L_0x0126:
            r11 = 3
            if (r0 != r11) goto L_0x0138
            com.google.android.gms.measurement.internal.zzez r0 = r21.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzi()
            java.lang.String r11 = "Skipping app launch break"
            r0.zza(r11)
            goto L_0x0071
        L_0x0138:
            com.google.android.gms.measurement.internal.zzez r0 = r21.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()
            java.lang.String r11 = "Unknown record type in local database"
            r0.zza(r11)
            goto L_0x0071
        L_0x0147:
            java.lang.String r0 = "messages"
            java.lang.String r11 = "rowid <= ?"
            java.lang.String[] r12 = new java.lang.String[r9]
            java.lang.String r13 = java.lang.Long.toString(r19)
            r12[r6] = r13
            int r0 = r5.delete(r0, r11, r12)
            int r11 = r4.size()
            if (r0 >= r11) goto L_0x016a
            com.google.android.gms.measurement.internal.zzez r0 = r21.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzf()
            java.lang.String r11 = "Fewer entries removed from local database than expected"
            r0.zza(r11)
        L_0x016a:
            r5.setTransactionSuccessful()
            r5.endTransaction()
            if (r10 == 0) goto L_0x0175
            r10.close()
        L_0x0175:
            if (r5 == 0) goto L_0x017a
            r5.close()
        L_0x017a:
            return r4
        L_0x017b:
            r0 = move-exception
            r3 = r10
            goto L_0x01fc
        L_0x017f:
            r0 = move-exception
            goto L_0x0188
        L_0x0181:
            r0 = move-exception
            goto L_0x018c
        L_0x0183:
            r0 = move-exception
            goto L_0x01fc
        L_0x0186:
            r0 = move-exception
            r10 = r3
        L_0x0188:
            r15 = r5
            goto L_0x01a4
        L_0x018a:
            r0 = move-exception
            r10 = r3
        L_0x018c:
            r15 = r5
            goto L_0x01dd
        L_0x018f:
            r0 = move-exception
            goto L_0x01fb
        L_0x0192:
            r0 = move-exception
            r5 = r15
        L_0x0194:
            r10 = r3
            goto L_0x01a4
        L_0x0196:
            r5 = r15
        L_0x0197:
            r10 = r3
        L_0x0198:
            r15 = r5
            goto L_0x01c9
        L_0x019a:
            r0 = move-exception
            r5 = r15
        L_0x019c:
            r10 = r3
            goto L_0x01dd
        L_0x019e:
            r0 = move-exception
            r5 = r3
            goto L_0x01fc
        L_0x01a1:
            r0 = move-exception
            r10 = r3
            r15 = r10
        L_0x01a4:
            if (r15 == 0) goto L_0x01af
            boolean r5 = r15.inTransaction()     // Catch:{ all -> 0x01f9 }
            if (r5 == 0) goto L_0x01af
            r15.endTransaction()     // Catch:{ all -> 0x01f9 }
        L_0x01af:
            com.google.android.gms.measurement.internal.zzez r5 = r21.zzr()     // Catch:{ all -> 0x01f9 }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzf()     // Catch:{ all -> 0x01f9 }
            r5.zza(r2, r0)     // Catch:{ all -> 0x01f9 }
            r1.zzb = r9     // Catch:{ all -> 0x01f9 }
            if (r10 == 0) goto L_0x01c1
            r10.close()
        L_0x01c1:
            if (r15 == 0) goto L_0x01f4
            r15.close()
            goto L_0x01f4
        L_0x01c7:
            r10 = r3
            r15 = r10
        L_0x01c9:
            long r11 = (long) r8
            android.os.SystemClock.sleep(r11)
            int r8 = r8 + 20
            if (r10 == 0) goto L_0x01d4
            r10.close()
        L_0x01d4:
            if (r15 == 0) goto L_0x01f4
            r15.close()
            goto L_0x01f4
        L_0x01da:
            r0 = move-exception
            r10 = r3
            r15 = r10
        L_0x01dd:
            com.google.android.gms.measurement.internal.zzez r5 = r21.zzr()
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzf()
            r5.zza(r2, r0)
            r1.zzb = r9
            if (r10 == 0) goto L_0x01ef
            r10.close()
        L_0x01ef:
            if (r15 == 0) goto L_0x01f4
            r15.close()
        L_0x01f4:
            int r7 = r7 + 1
            r5 = 5
            goto L_0x0020
        L_0x01f9:
            r0 = move-exception
            r3 = r10
        L_0x01fb:
            r5 = r15
        L_0x01fc:
            if (r3 == 0) goto L_0x0201
            r3.close()
        L_0x0201:
            if (r5 == 0) goto L_0x0206
            r5.close()
        L_0x0206:
            throw r0
        L_0x0207:
            com.google.android.gms.measurement.internal.zzez r0 = r21.zzr()
            com.google.android.gms.measurement.internal.zzfb r0 = r0.zzi()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zza(r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzev.zza(int):java.util.List");
    }

    public final boolean zzac() {
        return zza(3, new byte[0]);
    }

    public final boolean zzad() {
        zzd();
        zzb();
        if (this.zzb || !zzaf()) {
            return false;
        }
        int i = 0;
        int i2 = 5;
        while (i < 5) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase zzae = zzae();
                if (zzae == null) {
                    this.zzb = true;
                    if (zzae != null) {
                        zzae.close();
                    }
                    return false;
                }
                zzae.beginTransaction();
                zzae.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                zzae.setTransactionSuccessful();
                zzae.endTransaction();
                if (zzae != null) {
                    zzae.close();
                }
                return true;
            } catch (SQLiteFullException e) {
                zzr().zzf().zza("Error deleting app launch break from local database", e);
                this.zzb = true;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i++;
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep((long) i2);
                i2 += 20;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i++;
            } catch (SQLiteException e2) {
                if (sQLiteDatabase != null) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                }
                zzr().zzf().zza("Error deleting app launch break from local database", e2);
                this.zzb = true;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i++;
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
        zzr().zzi().zza("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, null, null, "rowid desc", "1");
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final SQLiteDatabase zzae() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    private final boolean zzaf() {
        return zzn().getDatabasePath("google_app_measurement_local.db").exists();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzhh zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzes zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzis zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzin zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzev zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzjw zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzai zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzex zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzkw zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzfw zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzez zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzfl zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzy zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzx zzu() {
        return super.zzu();
    }
}
