package com.google.android.gms.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.internal.ads.zzyz;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class MobileAdsInitProvider extends ContentProvider {
    private final zzyz zzade = new zzyz();

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.zzade.attachInfo(context, providerInfo);
    }

    public boolean onCreate() {
        return this.zzade.onCreate();
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.zzade.query(uri, strArr, str, strArr2, str2);
    }

    public String getType(Uri uri) {
        return this.zzade.getType(uri);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.zzade.insert(uri, contentValues);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.zzade.delete(uri, str, strArr);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.zzade.update(uri, contentValues, str, strArr);
    }
}
