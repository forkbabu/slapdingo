package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzow;
import java.io.IOException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzox<T extends zzow> extends Handler implements Runnable {
    private volatile boolean zzafn;
    private final T zzbjc;
    private final zzou<T> zzbjd;
    public final int zzbje;
    private final long zzbjf;
    private IOException zzbjg;
    private int zzbjh;
    private volatile Thread zzbji;
    private final /* synthetic */ zzov zzbjj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzox(zzov zzov, Looper looper, T t, zzou<T> zzou, int i, long j) {
        super(looper);
        this.zzbjj = zzov;
        this.zzbjc = t;
        this.zzbjd = zzou;
        this.zzbje = i;
        this.zzbjf = j;
    }

    public final void zzbi(int i) throws IOException {
        IOException iOException = this.zzbjg;
        if (iOException != null && this.zzbjh > i) {
            throw iOException;
        }
    }

    public final void zzek(long j) {
        zzpb.checkState(this.zzbjj.zzbja == null);
        zzox unused = this.zzbjj.zzbja = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            execute();
        }
    }

    public final void zzl(boolean z) {
        this.zzafn = z;
        this.zzbjg = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.zzbjc.cancelLoad();
            if (this.zzbji != null) {
                this.zzbji.interrupt();
            }
        }
        if (z) {
            finish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbjd.zza((zzow) this.zzbjc, elapsedRealtime, elapsedRealtime - this.zzbjf, true);
        }
    }

    public final void run() {
        try {
            this.zzbji = Thread.currentThread();
            if (!this.zzbjc.zzhw()) {
                String valueOf = String.valueOf(this.zzbjc.getClass().getSimpleName());
                zzpp.beginSection(valueOf.length() != 0 ? "load:".concat(valueOf) : new String("load:"));
                try {
                    this.zzbjc.zzhx();
                } finally {
                    zzpp.endSection();
                }
            }
            if (!this.zzafn) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.zzafn) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException unused) {
            zzpb.checkState(this.zzbjc.zzhw());
            if (!this.zzafn) {
                sendEmptyMessage(2);
            }
        } catch (Exception e2) {
            Log.e("LoadTask", "Unexpected exception loading stream", e2);
            if (!this.zzafn) {
                obtainMessage(3, new zzoz(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e3);
            if (!this.zzafn) {
                obtainMessage(3, new zzoz(e3)).sendToTarget();
            }
        } catch (Error e4) {
            Log.e("LoadTask", "Unexpected error loading stream", e4);
            if (!this.zzafn) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        }
    }

    public final void handleMessage(Message message) {
        int i;
        if (!this.zzafn) {
            if (message.what == 0) {
                execute();
            } else if (message.what != 4) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.zzbjf;
                if (this.zzbjc.zzhw()) {
                    this.zzbjd.zza((zzow) this.zzbjc, elapsedRealtime, j, false);
                    return;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    this.zzbjd.zza((zzow) this.zzbjc, elapsedRealtime, j, false);
                } else if (i2 == 2) {
                    this.zzbjd.zza(this.zzbjc, elapsedRealtime, j);
                } else if (i2 == 3) {
                    IOException iOException = (IOException) message.obj;
                    this.zzbjg = iOException;
                    int zza = this.zzbjd.zza(this.zzbjc, elapsedRealtime, j, iOException);
                    if (zza == 3) {
                        IOException unused = this.zzbjj.zzbjb = this.zzbjg;
                    } else if (zza != 2) {
                        if (zza == 1) {
                            i = 1;
                        } else {
                            i = this.zzbjh + 1;
                        }
                        this.zzbjh = i;
                        zzek((long) Math.min((i - 1) * 1000, 5000));
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    private final void execute() {
        this.zzbjg = null;
        this.zzbjj.zzbiz.execute(this.zzbjj.zzbja);
    }

    private final void finish() {
        zzox unused = this.zzbjj.zzbja = (zzox) null;
    }
}
