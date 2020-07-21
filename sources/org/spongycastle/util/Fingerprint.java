package org.spongycastle.util;

import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BidiOrder;
import com.itextpdf.text.pdf.PdfWriter;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.crypto.tls.CipherSuite;

public class Fingerprint {
    private static char[] encodingTable = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', 'a', 'b', Barcode128.CODE_AB_TO_C, Barcode128.CODE_AC_TO_B, Barcode128.CODE_BC_TO_A, Barcode128.FNC1_INDEX};
    private final byte[] fingerprint;

    public Fingerprint(byte[] bArr) {
        this.fingerprint = calculateFingerprint(bArr);
    }

    public byte[] getFingerprint() {
        return Arrays.clone(this.fingerprint);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i != this.fingerprint.length; i++) {
            if (i > 0) {
                stringBuffer.append(":");
            }
            stringBuffer.append(encodingTable[(this.fingerprint[i] >>> 4) & 15]);
            stringBuffer.append(encodingTable[this.fingerprint[i] & BidiOrder.B]);
        }
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Fingerprint) {
            return Arrays.areEqual(((Fingerprint) obj).fingerprint, this.fingerprint);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.fingerprint);
    }

    public static byte[] calculateFingerprint(byte[] bArr) {
        SHA512tDigest sHA512tDigest = new SHA512tDigest((int) CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256);
        sHA512tDigest.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[sHA512tDigest.getDigestSize()];
        sHA512tDigest.doFinal(bArr2, 0);
        return bArr2;
    }
}
