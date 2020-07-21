package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzty;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcqk implements zzdob {
    private final boolean zzefs;
    private final zzcql zzgjv;
    private final ArrayList zzgjw;
    private final zzty.zzm zzgjx;
    private final zzty.zzo.zzc zzgjy;

    zzcqk(zzcql zzcql, boolean z, ArrayList arrayList, zzty.zzm zzm, zzty.zzo.zzc zzc) {
        this.zzgjv = zzcql;
        this.zzefs = z;
        this.zzgjw = arrayList;
        this.zzgjx = zzm;
        this.zzgjy = zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object apply(Object obj) {
        zzcql zzcql = this.zzgjv;
        boolean z = this.zzefs;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        byte[] zza = zzcql.zzgka.zza(z, this.zzgjw, this.zzgjx, this.zzgjy);
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzq.zzld().currentTimeMillis()));
        contentValues.put("serialized_proto_data", zza);
        sQLiteDatabase.insert("offline_signal_contents", null, contentValues);
        sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "total_requests"));
        if (!z) {
            sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "failed_requests"));
        }
        return null;
    }
}
