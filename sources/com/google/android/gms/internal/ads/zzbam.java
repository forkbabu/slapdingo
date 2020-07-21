package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbam {
    private Context zzaah;
    private final BroadcastReceiver zzecf = new zzbal(this);
    private final Map<BroadcastReceiver, IntentFilter> zzecg = new WeakHashMap();
    private boolean zzech;
    private boolean zzzg = false;

    public final synchronized void initialize(Context context) {
        if (!this.zzzg) {
            Context applicationContext = context.getApplicationContext();
            this.zzaah = applicationContext;
            if (applicationContext == null) {
                this.zzaah = context;
            }
            zzaav.initialize(this.zzaah);
            this.zzech = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcrn)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzaah.registerReceiver(this.zzecf, intentFilter);
            this.zzzg = true;
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.zzech) {
            this.zzecg.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.zzech) {
            this.zzecg.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void zzc(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<BroadcastReceiver, IntentFilter> entry : this.zzecg.entrySet()) {
            if (entry.getValue().hasAction(intent.getAction())) {
                arrayList.add(entry.getKey());
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((BroadcastReceiver) obj).onReceive(context, intent);
        }
    }
}
