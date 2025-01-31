package org.spongycastle.pqc.crypto.mceliece;

import com.itextpdf.text.pdf.security.DigestAlgorithms;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;

class Utils {
    Utils() {
    }

    static Digest getDigest(String str) {
        if (str.equals(DigestAlgorithms.SHA1)) {
            return new SHA1Digest();
        }
        if (str.equals("SHA-224")) {
            return new SHA224Digest();
        }
        if (str.equals("SHA-256")) {
            return new SHA256Digest();
        }
        if (str.equals(DigestAlgorithms.SHA384)) {
            return new SHA384Digest();
        }
        if (str.equals(DigestAlgorithms.SHA512)) {
            return new SHA512Digest();
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + str);
    }
}
