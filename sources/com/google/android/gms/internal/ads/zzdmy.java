package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.text.Meta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdmy implements zzdmv {
    private final Object[] zzhef;

    public zzdmy(zzve zzve, String str, int i, String str2, zzvo zzvo) {
        HashSet hashSet = new HashSet(Arrays.asList(str2.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzve.zzcgs));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(zzr(zzve.extras));
        } else if (hashSet.contains("npa")) {
            arrayList.add(zzve.extras.getString("npa"));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzve.zzcgt));
        }
        if (hashSet.contains(Meta.KEYWORDS)) {
            if (zzve.zzcgu != null) {
                arrayList.add(zzve.zzcgu.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzve.zzcgv));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzve.zzadg));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzve.zzbnr));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzve.zzcgw);
        }
        if (hashSet.contains(FirebaseAnalytics.Param.LOCATION)) {
            if (zzve.zznb != null) {
                arrayList.add(zzve.zznb.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzve.zzcgy);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zzr(zzve.zzcgz));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zzr(zzve.zzcha));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (zzve.zzchb != null) {
                arrayList.add(zzve.zzchb.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzve.zzchc);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzve.zzchd);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzve.zzche));
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(Integer.valueOf(zzve.zzadh));
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(zzve.zzadi);
        }
        if (hashSet.contains("orientation")) {
            if (zzvo != null) {
                arrayList.add(Integer.valueOf(zzvo.orientation));
            } else {
                arrayList.add(null);
            }
        }
        this.zzhef = arrayList.toArray();
    }

    @Override // com.google.android.gms.internal.ads.zzdmv
    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdmy)) {
            return false;
        }
        return Arrays.equals(this.zzhef, ((zzdmy) obj).zzhef);
    }

    @Override // com.google.android.gms.internal.ads.zzdmv
    public final int hashCode() {
        return Arrays.hashCode(this.zzhef);
    }

    public final String toString() {
        int hashCode = hashCode();
        String arrays = Arrays.toString(this.zzhef);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 22);
        sb.append("[PoolKey#");
        sb.append(hashCode);
        sb.append(" ");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }

    private static String zzr(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it2 = new TreeSet(bundle.keySet()).iterator();
        while (it2.hasNext()) {
            Object obj = bundle.get((String) it2.next());
            if (obj == null) {
                str = "null";
            } else if (obj instanceof Bundle) {
                str = zzr((Bundle) obj);
            } else {
                str = obj.toString();
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
