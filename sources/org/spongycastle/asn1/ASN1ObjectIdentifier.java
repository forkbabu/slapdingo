package org.spongycastle.asn1;

import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.spongycastle.util.Arrays;

public class ASN1ObjectIdentifier extends ASN1Primitive {
    private static final long LONG_LIMIT = 72057594037927808L;
    private static final ConcurrentMap<OidHandle, ASN1ObjectIdentifier> pool = new ConcurrentHashMap();
    private byte[] body;
    private final String identifier;

    /* access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public static ASN1ObjectIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1ObjectIdentifier)) {
            return (ASN1ObjectIdentifier) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Encodable aSN1Encodable = (ASN1Encodable) obj;
            if (aSN1Encodable.toASN1Primitive() instanceof ASN1ObjectIdentifier) {
                return (ASN1ObjectIdentifier) aSN1Encodable.toASN1Primitive();
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1ObjectIdentifier) fromByteArray((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1ObjectIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof ASN1ObjectIdentifier)) {
            return getInstance(object);
        }
        return fromOctetString(ASN1OctetString.getInstance(aSN1TaggedObject.getObject()).getOctets());
    }

    ASN1ObjectIdentifier(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        long j = 0;
        BigInteger bigInteger = null;
        for (int i = 0; i != bArr.length; i++) {
            byte b = bArr[i] & UByte.MAX_VALUE;
            if (j <= LONG_LIMIT) {
                long j2 = j + ((long) (b & ByteCompanionObject.MAX_VALUE));
                if ((b & ByteCompanionObject.MIN_VALUE) == 0) {
                    if (z) {
                        if (j2 < 40) {
                            stringBuffer.append('0');
                        } else if (j2 < 80) {
                            stringBuffer.append('1');
                            j2 -= 40;
                        } else {
                            stringBuffer.append(PdfWriter.VERSION_1_2);
                            j2 -= 80;
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                    j = 0;
                } else {
                    j = j2 << 7;
                }
            } else {
                BigInteger or = (bigInteger == null ? BigInteger.valueOf(j) : bigInteger).or(BigInteger.valueOf((long) (b & ByteCompanionObject.MAX_VALUE)));
                if ((b & ByteCompanionObject.MIN_VALUE) == 0) {
                    if (z) {
                        stringBuffer.append(PdfWriter.VERSION_1_2);
                        or = or.subtract(BigInteger.valueOf(80));
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(or);
                    j = 0;
                    bigInteger = null;
                } else {
                    bigInteger = or.shiftLeft(7);
                }
            }
        }
        this.identifier = stringBuffer.toString();
        this.body = Arrays.clone(bArr);
    }

    public ASN1ObjectIdentifier(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'identifier' cannot be null");
        } else if (isValidIdentifier(str)) {
            this.identifier = str;
        } else {
            throw new IllegalArgumentException("string " + str + " not an OID");
        }
    }

    ASN1ObjectIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (isValidBranchID(str, 0)) {
            this.identifier = aSN1ObjectIdentifier.getId() + "." + str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not a valid OID branch");
    }

    public String getId() {
        return this.identifier;
    }

    public ASN1ObjectIdentifier branch(String str) {
        return new ASN1ObjectIdentifier(this, str);
    }

    public boolean on(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String id2 = getId();
        String id3 = aSN1ObjectIdentifier.getId();
        return id2.length() > id3.length() && id2.charAt(id3.length()) == '.' && id2.startsWith(id3);
    }

    private void writeField(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & 127) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    private void writeField(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        int i = bitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & ByteCompanionObject.MAX_VALUE);
        byteArrayOutputStream.write(bArr, 0, bitLength);
    }

    private void doOutput(ByteArrayOutputStream byteArrayOutputStream) {
        OIDTokenizer oIDTokenizer = new OIDTokenizer(this.identifier);
        int parseInt = Integer.parseInt(oIDTokenizer.nextToken()) * 40;
        String nextToken = oIDTokenizer.nextToken();
        if (nextToken.length() <= 18) {
            writeField(byteArrayOutputStream, ((long) parseInt) + Long.parseLong(nextToken));
        } else {
            writeField(byteArrayOutputStream, new BigInteger(nextToken).add(BigInteger.valueOf((long) parseInt)));
        }
        while (oIDTokenizer.hasMoreTokens()) {
            String nextToken2 = oIDTokenizer.nextToken();
            if (nextToken2.length() <= 18) {
                writeField(byteArrayOutputStream, Long.parseLong(nextToken2));
            } else {
                writeField(byteArrayOutputStream, new BigInteger(nextToken2));
            }
        }
    }

    private synchronized byte[] getBody() {
        if (this.body == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            doOutput(byteArrayOutputStream);
            this.body = byteArrayOutputStream.toByteArray();
        }
        return this.body;
    }

    /* access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        int length = getBody().length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    /* access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] body2 = getBody();
        aSN1OutputStream.write(6);
        aSN1OutputStream.writeLength(body2.length);
        aSN1OutputStream.write(body2);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return this.identifier.hashCode();
    }

    /* access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive == this) {
            return true;
        }
        if (!(aSN1Primitive instanceof ASN1ObjectIdentifier)) {
            return false;
        }
        return this.identifier.equals(((ASN1ObjectIdentifier) aSN1Primitive).identifier);
    }

    public String toString() {
        return getId();
    }

    private static boolean isValidBranchID(String str, int i) {
        boolean z;
        char charAt;
        int length = str.length();
        do {
            z = false;
            while (true) {
                length--;
                if (length < i) {
                    return z;
                }
                charAt = str.charAt(length);
                if ('0' <= charAt && charAt <= '9') {
                    z = true;
                }
            }
            if (charAt != '.') {
                break;
            }
        } while (z);
        return false;
    }

    private static boolean isValidIdentifier(String str) {
        char charAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (charAt = str.charAt(0)) < '0' || charAt > '2') {
            return false;
        }
        return isValidBranchID(str, 2);
    }

    public ASN1ObjectIdentifier intern() {
        OidHandle oidHandle = new OidHandle(getBody());
        ASN1ObjectIdentifier aSN1ObjectIdentifier = pool.get(oidHandle);
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        ASN1ObjectIdentifier putIfAbsent = pool.putIfAbsent(oidHandle, this);
        return putIfAbsent == null ? this : putIfAbsent;
    }

    private static class OidHandle {
        private final byte[] enc;
        private final int key;

        OidHandle(byte[] bArr) {
            this.key = Arrays.hashCode(bArr);
            this.enc = bArr;
        }

        public int hashCode() {
            return this.key;
        }

        public boolean equals(Object obj) {
            if (obj instanceof OidHandle) {
                return Arrays.areEqual(this.enc, ((OidHandle) obj).enc);
            }
            return false;
        }
    }

    static ASN1ObjectIdentifier fromOctetString(byte[] bArr) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = pool.get(new OidHandle(bArr));
        return aSN1ObjectIdentifier == null ? new ASN1ObjectIdentifier(bArr) : aSN1ObjectIdentifier;
    }
}
