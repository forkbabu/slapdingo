package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzto;
import com.google.android.gms.internal.ads.zzty;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcqp {
    private zzbbd zzdpd;
    private zzcpz zzgjr;
    private zztm zzgkd;
    private Context zzvr;

    public zzcqp(Context context, zzbbd zzbbd, zztm zztm, zzcpz zzcpz) {
        this.zzvr = context;
        this.zzdpd = zzbbd;
        this.zzgkd = zztm;
        this.zzgjr = zzcpz;
    }

    public final void zzapn() {
        try {
            this.zzgjr.zza(new zzcqo(this));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzaxv.zzfb(valueOf.length() != 0 ? "Error in offline signals database startup: ".concat(valueOf) : new String("Error in offline signals database startup: "));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzb(SQLiteDatabase sQLiteDatabase) throws Exception {
        ArrayList<zzty.zzo.zza> zza = zzcqm.zza(sQLiteDatabase);
        int i = 0;
        zzty.zzo zzo = (zzty.zzo) ((zzegb) zzty.zzo.zzoi().zzcd(this.zzvr.getPackageName()).zzce(Build.MODEL).zzcl(zzcqm.zza(sQLiteDatabase, 0)).zze(zza).zzcm(zzcqm.zza(sQLiteDatabase, 1)).zzes(zzq.zzld().currentTimeMillis()).zzet(zzcqm.zzb(sQLiteDatabase, 2)).zzbfq());
        ArrayList<zzty.zzo.zza> arrayList = zza;
        int size = arrayList.size();
        long j = 0;
        int i2 = 0;
        while (i2 < size) {
            zzty.zzo.zza zza2 = arrayList.get(i2);
            i2++;
            zzty.zzo.zza zza3 = zza2;
            if (zza3.zzok() == zzui.ENUM_TRUE && zza3.getTimestamp() > j) {
                j = zza3.getTimestamp();
            }
        }
        if (j != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(j));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
        }
        this.zzgkd.zza(new zzcqr(zzo));
        zzty.zzu.zza zzct = zzty.zzu.zzos().zzcs(this.zzdpd.zzedd).zzct(this.zzdpd.zzede);
        if (!this.zzdpd.zzedf) {
            i = 2;
        }
        this.zzgkd.zza(new zzcqq((zzty.zzu) ((zzegb) zzct.zzcu(i).zzbfq())));
        this.zzgkd.zza(zzto.zza.C0017zza.OFFLINE_UPLOAD);
        sQLiteDatabase.delete("offline_signal_contents", null, null);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("value", (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"failed_requests"});
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("value", (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues3, "statistic_name = ?", new String[]{"total_requests"});
        return null;
    }
}
