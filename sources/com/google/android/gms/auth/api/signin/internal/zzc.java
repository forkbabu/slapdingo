package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.jsoup.helper.HttpConnection;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
public final class zzc implements Runnable {
    private static final Logger zzby = new Logger("RevokeAccessOperation", new String[0]);
    private final String zzbz;
    private final StatusPendingResult zzca = new StatusPendingResult((GoogleApiClient) null);

    private zzc(String str) {
        this.zzbz = Preconditions.checkNotEmpty(str);
    }

    public final void run() {
        Status status = Status.RESULT_INTERNAL_ERROR;
        try {
            String valueOf = String.valueOf(this.zzbz);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(valueOf.length() != 0 ? "https://accounts.google.com/o/oauth2/revoke?token=".concat(valueOf) : new String("https://accounts.google.com/o/oauth2/revoke?token=")).openConnection();
            httpURLConnection.setRequestProperty(HttpConnection.CONTENT_TYPE, HttpConnection.FORM_URL_ENCODED);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.RESULT_SUCCESS;
            } else {
                zzby.e("Unable to revoke access!", new Object[0]);
            }
            Logger logger = zzby;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            logger.d(sb.toString(), new Object[0]);
        } catch (IOException e) {
            Logger logger2 = zzby;
            String valueOf2 = String.valueOf(e.toString());
            logger2.e(valueOf2.length() != 0 ? "IOException when revoking access: ".concat(valueOf2) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e2) {
            Logger logger3 = zzby;
            String valueOf3 = String.valueOf(e2.toString());
            logger3.e(valueOf3.length() != 0 ? "Exception when revoking access: ".concat(valueOf3) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.zzca.setResult(status);
    }

    public static PendingResult<Status> zzf(String str) {
        if (str == null) {
            return PendingResults.immediateFailedResult(new Status(4), null);
        }
        zzc zzc = new zzc(str);
        new Thread(zzc).start();
        return zzc.zzca;
    }
}
