package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.ICC_Profile;
import com.itextpdf.xmp.XMPError;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import kotlin.UByte;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.i18n.LocalizedMessage;
import org.spongycastle.math.Primes;

public class Jpeg extends Image {
    public static final byte[] JFIF_ID = {74, 70, 73, 70, 0};
    public static final int M_APP0 = 224;
    public static final int M_APP2 = 226;
    public static final int M_APPD = 237;
    public static final int M_APPE = 238;
    public static final int NOPARAM_MARKER = 2;
    public static final int[] NOPARAM_MARKERS = {208, 209, 210, Primes.SMALL_FACTOR_LIMIT, 212, 213, 214, 215, 216, 1};
    public static final int NOT_A_MARKER = -1;
    public static final byte[] PS_8BIM_RESO = {56, 66, 73, 77, 3, -19};
    public static final int UNSUPPORTED_MARKER = 1;
    public static final int[] UNSUPPORTED_MARKERS = {CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, 198, 199, 200, 201, XMPError.BADRDF, 203, 205, 206, 207};
    public static final int VALID_MARKER = 0;
    public static final int[] VALID_MARKERS = {192, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256};
    private byte[][] icc;

    Jpeg(Image image) {
        super(image);
    }

    public Jpeg(URL url) throws BadElementException, IOException {
        super(url);
        processParameters();
    }

    public Jpeg(byte[] bArr) throws BadElementException, IOException {
        super((URL) null);
        this.rawData = bArr;
        this.originalData = bArr;
        processParameters();
    }

    public Jpeg(byte[] bArr, float f, float f2) throws BadElementException, IOException {
        this(bArr);
        this.scaledWidth = f;
        this.scaledHeight = f2;
    }

    private static final int getShort(InputStream inputStream) throws IOException {
        return (inputStream.read() << 8) + inputStream.read();
    }

    private static final int marker(int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = VALID_MARKERS;
            if (i3 >= iArr.length) {
                int i4 = 0;
                while (true) {
                    int[] iArr2 = NOPARAM_MARKERS;
                    if (i4 >= iArr2.length) {
                        while (true) {
                            int[] iArr3 = UNSUPPORTED_MARKERS;
                            if (i2 >= iArr3.length) {
                                return -1;
                            }
                            if (i == iArr3[i2]) {
                                return 1;
                            }
                            i2++;
                        }
                    } else if (i == iArr2[i4]) {
                        return 2;
                    } else {
                        i4++;
                    }
                }
            } else if (i == iArr[i3]) {
                return 0;
            } else {
                i3++;
            }
        }
    }

    private void processParameters() throws BadElementException, IOException {
        InputStream inputStream;
        String str;
        InputStream inputStream2;
        boolean z;
        boolean z2;
        this.type = 32;
        this.originalType = 1;
        try {
            if (this.rawData == null) {
                inputStream2 = this.url.openStream();
                try {
                    str = this.url.toString();
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStream2;
                }
            } else {
                inputStream2 = new ByteArrayInputStream(this.rawData);
                str = "Byte array";
            }
            int i = 0;
            if (inputStream2.read() == 255 && inputStream2.read() == 216) {
                boolean z3 = true;
                while (true) {
                    int read = inputStream2.read();
                    if (read >= 0) {
                        if (read == 255) {
                            int read2 = inputStream2.read();
                            if (z3 && read2 == 224) {
                                int i2 = getShort(inputStream2);
                                if (i2 < 16) {
                                    Utilities.skip(inputStream2, i2 - 2);
                                } else {
                                    int length = JFIF_ID.length;
                                    byte[] bArr = new byte[length];
                                    if (inputStream2.read(bArr) == length) {
                                        int i3 = 0;
                                        while (true) {
                                            if (i3 >= length) {
                                                z2 = true;
                                                break;
                                            } else if (bArr[i3] != JFIF_ID[i3]) {
                                                z2 = false;
                                                break;
                                            } else {
                                                i3++;
                                            }
                                        }
                                        if (!z2) {
                                            Utilities.skip(inputStream2, (i2 - 2) - length);
                                        } else {
                                            Utilities.skip(inputStream2, 2);
                                            int read3 = inputStream2.read();
                                            int i4 = getShort(inputStream2);
                                            int i5 = getShort(inputStream2);
                                            if (read3 == 1) {
                                                this.dpiX = i4;
                                                this.dpiY = i5;
                                            } else if (read3 == 2) {
                                                this.dpiX = (int) ((((float) i4) * 2.54f) + 0.5f);
                                                this.dpiY = (int) ((((float) i5) * 2.54f) + 0.5f);
                                            }
                                            Utilities.skip(inputStream2, ((i2 - 2) - length) - 7);
                                        }
                                    } else {
                                        Object[] objArr = new Object[1];
                                        objArr[i] = str;
                                        throw new BadElementException(MessageLocalization.getComposedMessage("1.corrupted.jfif.marker", objArr));
                                    }
                                }
                                z3 = false;
                            } else if (read2 == 238) {
                                int i6 = getShort(inputStream2) - 2;
                                byte[] bArr2 = new byte[i6];
                                for (int i7 = 0; i7 < i6; i7++) {
                                    bArr2[i7] = (byte) inputStream2.read();
                                }
                                if (i6 >= 12 && new String(bArr2, i, 5, LocalizedMessage.DEFAULT_ENCODING).equals("Adobe")) {
                                    this.invert = true;
                                }
                            } else if (read2 == 226) {
                                int i8 = getShort(inputStream2) - 2;
                                byte[] bArr3 = new byte[i8];
                                for (int i9 = 0; i9 < i8; i9++) {
                                    bArr3[i9] = (byte) inputStream2.read();
                                }
                                if (i8 >= 14 && new String(bArr3, i, 11, LocalizedMessage.DEFAULT_ENCODING).equals("ICC_PROFILE")) {
                                    byte b = bArr3[12] & UByte.MAX_VALUE;
                                    int i10 = bArr3[13] & UByte.MAX_VALUE;
                                    if (b < 1) {
                                        b = 1;
                                    }
                                    if (i10 < 1) {
                                        i10 = 1;
                                    }
                                    if (this.icc == null) {
                                        this.icc = new byte[i10][];
                                    }
                                    this.icc[b - 1] = bArr3;
                                }
                            } else if (read2 == 237) {
                                int i11 = getShort(inputStream2) - 2;
                                byte[] bArr4 = new byte[i11];
                                for (int i12 = 0; i12 < i11; i12++) {
                                    bArr4[i12] = (byte) inputStream2.read();
                                }
                                int i13 = 0;
                                while (i13 < i11 - PS_8BIM_RESO.length) {
                                    int i14 = 0;
                                    while (true) {
                                        if (i14 >= PS_8BIM_RESO.length) {
                                            z = true;
                                            break;
                                        } else if (bArr4[i13 + i14] != PS_8BIM_RESO[i14]) {
                                            z = false;
                                            break;
                                        } else {
                                            i14++;
                                        }
                                    }
                                    if (z) {
                                        break;
                                    }
                                    i13++;
                                }
                                int length2 = i13 + PS_8BIM_RESO.length;
                                if (length2 < i11 - PS_8BIM_RESO.length) {
                                    byte b2 = (byte) (bArr4[length2] + 1);
                                    if (b2 % 2 == 1) {
                                        b2 = (byte) (b2 + 1);
                                    }
                                    int i15 = length2 + b2;
                                    if ((bArr4[i15] << 24) + (bArr4[i15 + 1] << 16) + (bArr4[i15 + 2] << 8) + bArr4[i15 + 3] == 16) {
                                        int i16 = i15 + 4;
                                        int i17 = (bArr4[i16] << 8) + (bArr4[i16 + 1] & UByte.MAX_VALUE);
                                        int i18 = i16 + 2 + 2;
                                        int i19 = (bArr4[i18] << 8) + (bArr4[i18 + 1] & UByte.MAX_VALUE);
                                        int i20 = i18 + 2 + 2;
                                        int i21 = (bArr4[i20] << 8) + (bArr4[i20 + 1] & UByte.MAX_VALUE);
                                        int i22 = i20 + 2 + 2;
                                        int i23 = (bArr4[i22] << 8) + (bArr4[i22 + 1] & UByte.MAX_VALUE);
                                        if (i19 == 1 || i19 == 2) {
                                            if (i19 == 2) {
                                                i17 = (int) ((((float) i17) * 2.54f) + 0.5f);
                                            }
                                            if (this.dpiX == 0 || this.dpiX == i17) {
                                                this.dpiX = i17;
                                            }
                                        }
                                        if (i23 == 1 || i23 == 2) {
                                            if (i23 == 2) {
                                                i21 = (int) ((((float) i21) * 2.54f) + 0.5f);
                                            }
                                            if (this.dpiY == 0 || this.dpiY == i21) {
                                                this.dpiY = i21;
                                            }
                                        }
                                    }
                                }
                            } else {
                                int marker = marker(read2);
                                if (marker == 0) {
                                    Utilities.skip(inputStream2, 2);
                                    if (inputStream2.read() == 8) {
                                        this.scaledHeight = (float) getShort(inputStream2);
                                        setTop(this.scaledHeight);
                                        this.scaledWidth = (float) getShort(inputStream2);
                                        setRight(this.scaledWidth);
                                        this.colorspace = inputStream2.read();
                                        this.bpc = 8;
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        this.plainWidth = getWidth();
                                        this.plainHeight = getHeight();
                                        if (this.icc != null) {
                                            int i24 = 0;
                                            int i25 = 0;
                                            while (true) {
                                                byte[][] bArr5 = this.icc;
                                                if (i24 >= bArr5.length) {
                                                    byte[] bArr6 = new byte[i25];
                                                    int i26 = 0;
                                                    int i27 = 0;
                                                    while (true) {
                                                        byte[][] bArr7 = this.icc;
                                                        if (i27 < bArr7.length) {
                                                            System.arraycopy(bArr7[i27], 14, bArr6, i26, bArr7[i27].length - 14);
                                                            i26 += this.icc[i27].length - 14;
                                                            i27++;
                                                        } else {
                                                            try {
                                                                break;
                                                            } catch (IllegalArgumentException unused) {
                                                            }
                                                        }
                                                    }
                                                    tagICC(ICC_Profile.getInstance(bArr6, this.colorspace));
                                                    this.icc = null;
                                                    return;
                                                } else if (bArr5[i24] == null) {
                                                    this.icc = null;
                                                    return;
                                                } else {
                                                    i25 += bArr5[i24].length - 14;
                                                    i24++;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        throw new BadElementException(MessageLocalization.getComposedMessage("1.must.have.8.bits.per.component", str));
                                    }
                                } else if (marker != 1) {
                                    if (marker != 2) {
                                        Utilities.skip(inputStream2, getShort(inputStream2) - 2);
                                    }
                                    z3 = false;
                                } else {
                                    throw new BadElementException(MessageLocalization.getComposedMessage("1.unsupported.jpeg.marker.2", str, String.valueOf(read2)));
                                }
                            }
                        }
                        i = 0;
                    } else {
                        throw new IOException(MessageLocalization.getComposedMessage("premature.eof.while.reading.jpg", new Object[0]));
                    }
                }
            } else {
                throw new BadElementException(MessageLocalization.getComposedMessage("1.is.not.a.valid.jpeg.file", str));
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }
}
