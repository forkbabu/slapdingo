package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzbba;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class RequestConfiguration {
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    public static final String MAX_AD_CONTENT_RATING_UNSPECIFIED = "";
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
    public static final List<String> zzadk = Arrays.asList("MA", "T", "PG", "G");
    private final int zzadg;
    private final int zzadh;
    private final String zzadi;
    private final List<String> zzadj;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public @interface MaxAdContentRating {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public @interface TagForChildDirectedTreatment {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public @interface TagForUnderAgeOfConsent {
    }

    private RequestConfiguration(int i, int i2, String str, List<String> list) {
        this.zzadg = i;
        this.zzadh = i2;
        this.zzadi = str;
        this.zzadj = list;
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public static class Builder {
        private int zzadg = -1;
        private int zzadh = -1;
        private String zzadi = null;
        private final List<String> zzadj = new ArrayList();

        public RequestConfiguration build() {
            return new RequestConfiguration(this.zzadg, this.zzadh, this.zzadi, this.zzadj);
        }

        public Builder setTagForChildDirectedTreatment(int i) {
            if (i == -1 || i == 0 || i == 1) {
                this.zzadg = i;
            } else {
                StringBuilder sb = new StringBuilder(68);
                sb.append("Invalid value passed to setTagForChildDirectedTreatment: ");
                sb.append(i);
                zzbba.zzfd(sb.toString());
            }
            return this;
        }

        public Builder setTagForUnderAgeOfConsent(int i) {
            if (i == -1 || i == 0 || i == 1) {
                this.zzadh = i;
            } else {
                StringBuilder sb = new StringBuilder(63);
                sb.append("Invalid value passed to setTagForUnderAgeOfConsent: ");
                sb.append(i);
                zzbba.zzfd(sb.toString());
            }
            return this;
        }

        public Builder setMaxAdContentRating(String str) {
            if (str == null || "".equals(str)) {
                this.zzadi = null;
            } else if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
                this.zzadi = str;
            } else {
                String valueOf = String.valueOf(str);
                zzbba.zzfd(valueOf.length() != 0 ? "Invalid value passed to setMaxAdContentRating: ".concat(valueOf) : new String("Invalid value passed to setMaxAdContentRating: "));
            }
            return this;
        }

        public Builder setTestDeviceIds(@Nullable List<String> list) {
            this.zzadj.clear();
            if (list != null) {
                this.zzadj.addAll(list);
            }
            return this;
        }
    }

    public int getTagForChildDirectedTreatment() {
        return this.zzadg;
    }

    public int getTagForUnderAgeOfConsent() {
        return this.zzadh;
    }

    public String getMaxAdContentRating() {
        String str = this.zzadi;
        return str == null ? "" : str;
    }

    public List<String> getTestDeviceIds() {
        return new ArrayList(this.zzadj);
    }

    public Builder toBuilder() {
        return new Builder().setTagForChildDirectedTreatment(this.zzadg).setTagForUnderAgeOfConsent(this.zzadh).setMaxAdContentRating(this.zzadi).setTestDeviceIds(this.zzadj);
    }
}
