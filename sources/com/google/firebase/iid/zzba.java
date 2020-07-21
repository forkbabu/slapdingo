package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
final class zzba extends BroadcastReceiver {
    @Nullable
    private zzbb zza;

    public zzba(zzbb zzbb) {
        this.zza = zzbb;
    }

    public final void zza() {
        if (FirebaseInstanceId.zzd()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.zza.zza().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void onReceive(Context context, Intent intent) {
        zzbb zzbb = this.zza;
        if (zzbb != null && zzbb.zzb()) {
            if (FirebaseInstanceId.zzd()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.zza(this.zza, 0);
            this.zza.zza().unregisterReceiver(this);
            this.zza = null;
        }
    }
}
