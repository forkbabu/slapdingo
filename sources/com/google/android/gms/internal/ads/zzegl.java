package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class zzegl extends IOException {
    private zzehl zzifg = null;

    public zzegl(String str) {
        super(str);
    }

    public final zzegl zzl(zzehl zzehl) {
        this.zzifg = zzehl;
        return this;
    }

    static zzegl zzbfu() {
        return new zzegl("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzegl zzbfv() {
        return new zzegl("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzegl zzbfw() {
        return new zzegl("CodedInputStream encountered a malformed varint.");
    }

    static zzegl zzbfx() {
        return new zzegl("Protocol message contained an invalid tag (zero).");
    }

    static zzegl zzbfy() {
        return new zzegl("Protocol message end-group tag did not match expected tag.");
    }

    static zzego zzbfz() {
        return new zzego("Protocol message tag had invalid wire type.");
    }

    static zzegl zzbga() {
        return new zzegl("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzegl zzbgb() {
        return new zzegl("Failed to parse the message.");
    }

    static zzegl zzbgc() {
        return new zzegl("Protocol message had invalid UTF-8.");
    }
}
