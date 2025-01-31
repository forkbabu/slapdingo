package org.spongycastle.crypto.tls;

import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.IOException;
import org.opencv.ml.DTrees;
import org.spongycastle.util.Strings;

public final class ProtocolVersion {
    public static final ProtocolVersion DTLSv10 = new ProtocolVersion(65279, "DTLS 1.0");
    public static final ProtocolVersion DTLSv12 = new ProtocolVersion(65277, "DTLS 1.2");
    public static final ProtocolVersion SSLv3 = new ProtocolVersion(DTrees.PREDICT_MASK, "SSL 3.0");
    public static final ProtocolVersion TLSv10 = new ProtocolVersion(769, "TLS 1.0");
    public static final ProtocolVersion TLSv11 = new ProtocolVersion(770, "TLS 1.1");
    public static final ProtocolVersion TLSv12 = new ProtocolVersion(771, "TLS 1.2");
    private String name;
    private int version;

    private ProtocolVersion(int i, String str) {
        this.version = i & 65535;
        this.name = str;
    }

    public int getFullVersion() {
        return this.version;
    }

    public int getMajorVersion() {
        return this.version >> 8;
    }

    public int getMinorVersion() {
        return this.version & 255;
    }

    public boolean isDTLS() {
        return getMajorVersion() == 254;
    }

    public boolean isSSL() {
        return this == SSLv3;
    }

    public boolean isTLS() {
        return getMajorVersion() == 3;
    }

    public ProtocolVersion getEquivalentTLSVersion() {
        if (!isDTLS()) {
            return this;
        }
        if (this == DTLSv10) {
            return TLSv11;
        }
        return TLSv12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0021 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEqualOrEarlierVersionOf(org.spongycastle.crypto.tls.ProtocolVersion r4) {
        /*
            r3 = this;
            int r0 = r3.getMajorVersion()
            int r1 = r4.getMajorVersion()
            r2 = 0
            if (r0 == r1) goto L_0x000c
            return r2
        L_0x000c:
            int r4 = r4.getMinorVersion()
            int r0 = r3.getMinorVersion()
            int r4 = r4 - r0
            boolean r0 = r3.isDTLS()
            r1 = 1
            if (r0 == 0) goto L_0x001f
            if (r4 > 0) goto L_0x0022
            goto L_0x0021
        L_0x001f:
            if (r4 < 0) goto L_0x0022
        L_0x0021:
            r2 = 1
        L_0x0022:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.ProtocolVersion.isEqualOrEarlierVersionOf(org.spongycastle.crypto.tls.ProtocolVersion):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0021 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isLaterVersionOf(org.spongycastle.crypto.tls.ProtocolVersion r4) {
        /*
            r3 = this;
            int r0 = r3.getMajorVersion()
            int r1 = r4.getMajorVersion()
            r2 = 0
            if (r0 == r1) goto L_0x000c
            return r2
        L_0x000c:
            int r4 = r4.getMinorVersion()
            int r0 = r3.getMinorVersion()
            int r4 = r4 - r0
            boolean r0 = r3.isDTLS()
            r1 = 1
            if (r0 == 0) goto L_0x001f
            if (r4 <= 0) goto L_0x0022
            goto L_0x0021
        L_0x001f:
            if (r4 >= 0) goto L_0x0022
        L_0x0021:
            r2 = 1
        L_0x0022:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.ProtocolVersion.isLaterVersionOf(org.spongycastle.crypto.tls.ProtocolVersion):boolean");
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ProtocolVersion) && equals((ProtocolVersion) obj));
    }

    public boolean equals(ProtocolVersion protocolVersion) {
        return protocolVersion != null && this.version == protocolVersion.version;
    }

    public int hashCode() {
        return this.version;
    }

    public static ProtocolVersion get(int i, int i2) throws IOException {
        if (i != 3) {
            if (i == 254) {
                switch (i2) {
                    case 253:
                        return DTLSv12;
                    case TIFFConstants.TIFFTAG_SUBFILETYPE:
                        throw new TlsFatalAlert(47);
                    case 255:
                        return DTLSv10;
                    default:
                        return getUnknownVersion(i, i2, "DTLS");
                }
            } else {
                throw new TlsFatalAlert(47);
            }
        } else if (i2 == 0) {
            return SSLv3;
        } else {
            if (i2 == 1) {
                return TLSv10;
            }
            if (i2 == 2) {
                return TLSv11;
            }
            if (i2 != 3) {
                return getUnknownVersion(i, i2, "TLS");
            }
            return TLSv12;
        }
    }

    public String toString() {
        return this.name;
    }

    private static ProtocolVersion getUnknownVersion(int i, int i2, String str) throws IOException {
        TlsUtils.checkUint8(i);
        TlsUtils.checkUint8(i2);
        int i3 = (i << 8) | i2;
        String upperCase = Strings.toUpperCase(Integer.toHexString(65536 | i3).substring(1));
        return new ProtocolVersion(i3, str + " 0x" + upperCase);
    }
}
