package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbhd extends MutableContextWrapper {
    private Context zzaah;
    private Activity zzeci;
    private Context zzeoz;

    public zzbhd(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final void setBaseContext(Context context) {
        this.zzaah = context.getApplicationContext();
        this.zzeci = context instanceof Activity ? (Activity) context : null;
        this.zzeoz = context;
        super.setBaseContext(this.zzaah);
    }

    public final void startActivity(Intent intent) {
        Activity activity = this.zzeci;
        if (activity != null) {
            activity.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.zzaah.startActivity(intent);
    }

    public final Activity zzzl() {
        return this.zzeci;
    }

    @Override // android.content.Context, android.content.ContextWrapper
    public final Object getSystemService(String str) {
        return this.zzeoz.getSystemService(str);
    }

    public final Context zzaau() {
        return this.zzeoz;
    }
}
