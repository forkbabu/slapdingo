package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzpd {
    private boolean isOpen;

    public final synchronized boolean open() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean zzit() {
        boolean z;
        z = this.isOpen;
        this.isOpen = false;
        return z;
    }

    public final synchronized void block() throws InterruptedException {
        while (!this.isOpen) {
            wait();
        }
    }
}
