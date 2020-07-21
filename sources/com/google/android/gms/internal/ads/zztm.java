package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzto;
import com.google.android.gms.internal.ads.zzty;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zztm {
    private final zztr zzbvo;
    private final zzty.zzi.zza zzbvp;
    private final boolean zzbvq;

    public static zztm zzmz() {
        return new zztm();
    }

    public zztm(zztr zztr) {
        this.zzbvp = zzty.zzi.zznz();
        this.zzbvo = zztr;
        this.zzbvq = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcte)).booleanValue();
    }

    private zztm() {
        this.zzbvp = zzty.zzi.zznz();
        this.zzbvq = false;
        this.zzbvo = new zztr();
    }

    public final synchronized void zza(zzto.zza.C0017zza zza) {
        if (this.zzbvq) {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzctf)).booleanValue()) {
                zzc(zza);
            } else {
                zzb(zza);
            }
        }
    }

    private final synchronized void zzb(zzto.zza.C0017zza zza) {
        this.zzbvp.zzoc().zzb(zzna());
        this.zzbvo.zzf(((zzty.zzi) ((zzegb) this.zzbvp.zzbfq())).toByteArray()).zzbx(zza.zzw()).zzdx();
        String valueOf = String.valueOf(Integer.toString(zza.zzw(), 10));
        zzaxv.zzeh(valueOf.length() != 0 ? "Logging Event with event code : ".concat(valueOf) : new String("Logging Event with event code : "));
    }

    private final synchronized void zzc(zzto.zza.C0017zza zza) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
                try {
                    fileOutputStream.write(zzd(zza).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zzaxv.zzeh("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zzaxv.zzeh("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zzaxv.zzeh("Could not close Clearcut output stream.");
                    }
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused4) {
                        zzaxv.zzeh("Could not close Clearcut output stream.");
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused5) {
                zzaxv.zzeh("Could not find file for Clearcut");
            }
        }
    }

    private final synchronized String zzd(zzto.zza.C0017zza zza) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", this.zzbvp.zznv(), Long.valueOf(zzq.zzld().elapsedRealtime()), Integer.valueOf(zza.zzw()), Base64.encodeToString(((zzty.zzi) ((zzegb) this.zzbvp.zzbfq())).toByteArray(), 3));
    }

    public final synchronized void zza(zztp zztp) {
        if (this.zzbvq) {
            try {
                zztp.zza(this.zzbvp);
            } catch (NullPointerException e) {
                zzq.zzla().zza(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    private static List<Long> zzna() {
        List<String> zzrd = zzaav.zzrd();
        ArrayList arrayList = new ArrayList();
        for (String str : zzrd) {
            for (String str2 : str.split(",")) {
                try {
                    arrayList.add(Long.valueOf(str2));
                } catch (NumberFormatException unused) {
                    zzaxv.zzeh("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }
}
