package com.itextpdf.text.pdf;

import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.pdf.codec.CCITTG4Encoder;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import com.itextpdf.xmp.XMPError;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Hashtable;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.opencv.imgproc.Imgproc;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.math.Primes;

public class BarcodeDatamatrix {
    public static final int DM_ASCII = 1;
    public static final int DM_AUTO = 0;
    public static final int DM_B256 = 4;
    public static final int DM_C40 = 2;
    public static final int DM_EDIFACT = 6;
    public static final int DM_ERROR_EXTENSION = 5;
    public static final int DM_ERROR_INVALID_SQUARE = 3;
    public static final int DM_ERROR_TEXT_TOO_BIG = 1;
    public static final int DM_EXTENSION = 32;
    public static final int DM_NO_ERROR = 0;
    public static final int DM_RAW = 7;
    public static final int DM_TEST = 64;
    public static final int DM_TEXT = 3;
    public static final int DM_X21 = 5;
    private static final DmParams[] dmSizes = {new DmParams(10, 10, 10, 10, 3, 3, 5), new DmParams(12, 12, 12, 12, 5, 5, 7), new DmParams(8, 18, 8, 18, 5, 5, 7), new DmParams(14, 14, 14, 14, 8, 8, 10), new DmParams(8, 32, 8, 16, 10, 10, 11), new DmParams(16, 16, 16, 16, 12, 12, 12), new DmParams(12, 26, 12, 26, 16, 16, 14), new DmParams(18, 18, 18, 18, 18, 18, 14), new DmParams(20, 20, 20, 20, 22, 22, 18), new DmParams(12, 36, 12, 18, 22, 22, 18), new DmParams(22, 22, 22, 22, 30, 30, 20), new DmParams(16, 36, 16, 18, 32, 32, 24), new DmParams(24, 24, 24, 24, 36, 36, 24), new DmParams(26, 26, 26, 26, 44, 44, 28), new DmParams(16, 48, 16, 24, 49, 49, 28), new DmParams(32, 32, 16, 16, 62, 62, 36), new DmParams(36, 36, 18, 18, 86, 86, 42), new DmParams(40, 40, 20, 20, 114, 114, 48), new DmParams(44, 44, 22, 22, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 56), new DmParams(48, 48, 24, 24, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, 68), new DmParams(52, 52, 26, 26, 204, 102, 42), new DmParams(64, 64, 16, 16, TIFFConstants.TIFFTAG_MINSAMPLEVALUE, 140, 56), new DmParams(72, 72, 18, 18, 368, 92, 36), new DmParams(80, 80, 20, 20, 456, 114, 48), new DmParams(88, 88, 22, 22, 576, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 56), new DmParams(96, 96, 24, 24, 696, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, 68), new DmParams(104, 104, 26, 26, 816, 136, 56), new DmParams(120, 120, 20, 20, 1050, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384, 68), new DmParams(132, 132, 22, 22, 1304, CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384, 62), new DmParams(CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 24, 24, 1558, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, 62)};
    private static final String x12 = "\r*> 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int extOut;
    private boolean forceSquareSize = false;
    private int height;
    private byte[] image;
    private int options;
    private short[] place;
    private int width;
    private int ws;

    private static boolean isDigit(int i) {
        return i >= 48 && i <= 57;
    }

    private void setBit(int i, int i2, int i3) {
        byte[] bArr = this.image;
        int i4 = (i2 * i3) + (i / 8);
        bArr[i4] = (byte) (((byte) (128 >> (i & 7))) | bArr[i4]);
    }

    private void draw(byte[] bArr, int i, DmParams dmParams) {
        int i2;
        int i3 = ((dmParams.width + (this.ws * 2)) + 7) / 8;
        Arrays.fill(this.image, (byte) 0);
        int i4 = this.ws;
        while (true) {
            int i5 = dmParams.height;
            int i6 = this.ws;
            if (i4 >= i5 + i6) {
                break;
            }
            while (i6 < dmParams.width + this.ws) {
                setBit(i6, i4, i3);
                i6 += 2;
            }
            i4 += dmParams.heightSection;
        }
        int i7 = dmParams.heightSection - 1;
        int i8 = this.ws;
        while (true) {
            i7 += i8;
            int i9 = dmParams.height;
            i2 = this.ws;
            if (i7 >= i9 + i2) {
                break;
            }
            while (i2 < dmParams.width + this.ws) {
                setBit(i2, i7, i3);
                i2++;
            }
            i8 = dmParams.heightSection;
        }
        while (true) {
            int i10 = dmParams.width;
            int i11 = this.ws;
            if (i2 >= i10 + i11) {
                break;
            }
            while (i11 < dmParams.height + this.ws) {
                setBit(i2, i11, i3);
                i11++;
            }
            i2 += dmParams.widthSection;
        }
        int i12 = dmParams.widthSection - 1;
        int i13 = this.ws;
        while (true) {
            i12 += i13;
            int i14 = dmParams.width;
            int i15 = this.ws;
            if (i12 >= i14 + i15) {
                break;
            }
            for (int i16 = i15 + 1; i16 < dmParams.height + this.ws; i16 += 2) {
                setBit(i12, i16, i3);
            }
            i13 = dmParams.widthSection;
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < dmParams.height) {
            for (int i19 = 1; i19 < dmParams.heightSection - 1; i19++) {
                int i20 = 0;
                while (i20 < dmParams.width) {
                    int i21 = 1;
                    while (i21 < dmParams.widthSection - 1) {
                        int i22 = i18 + 1;
                        short s = this.place[i18];
                        if (s != 1) {
                            if (s > 1) {
                                if (((128 >> (s % 8)) & bArr[(s / 8) - 1] & UByte.MAX_VALUE) == 0) {
                                }
                            }
                            i21++;
                            i18 = i22;
                        }
                        int i23 = this.ws;
                        setBit(i21 + i20 + i23, i19 + i17 + i23, i3);
                        i21++;
                        i18 = i22;
                    }
                    i20 += dmParams.widthSection;
                }
            }
            i17 += dmParams.heightSection;
        }
    }

    private static void makePadding(byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            int i3 = i + 1;
            bArr[i] = -127;
            while (true) {
                i2--;
                if (i2 > 0) {
                    int i4 = i3 + 1;
                    int i5 = ((i4 * CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA) % 253) + 129 + 1;
                    if (i5 > 254) {
                        i5 -= 254;
                    }
                    bArr[i3] = (byte) i5;
                    i3 = i4;
                } else {
                    return;
                }
            }
        }
    }

    private static int asciiEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = i2 + i;
        int i6 = i4 + i3;
        int i7 = i3;
        while (i < i5) {
            if (i7 >= i6) {
                return -1;
            }
            int i8 = i + 1;
            byte b = bArr[i] & UByte.MAX_VALUE;
            if (!isDigit(b) || i8 >= i5 || !isDigit(bArr[i8] & UByte.MAX_VALUE)) {
                if (b > Byte.MAX_VALUE) {
                    int i9 = i7 + 1;
                    if (i9 >= i6) {
                        return -1;
                    }
                    bArr2[i7] = -21;
                    i7 = i9 + 1;
                    bArr2[i9] = (byte) (b + ByteCompanionObject.MIN_VALUE + 1);
                } else {
                    bArr2[i7] = (byte) (b + 1);
                    i7++;
                }
                i = i8;
            } else {
                bArr2[i7] = (byte) (((((b - 48) * 10) + (bArr[i8] & UByte.MAX_VALUE)) - 48) + 130);
                i7++;
                i = i8 + 1;
            }
        }
        return i7 - i3;
    }

    private static int b256Encodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 250 && i2 + 2 > i4) {
            return -1;
        }
        if (i2 >= 250 && i2 + 3 > i4) {
            return -1;
        }
        bArr2[i3] = -25;
        if (i2 < 250) {
            bArr2[i3 + 1] = (byte) i2;
            i5 = 2;
        } else {
            bArr2[i3 + 1] = (byte) ((i2 / ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + 249);
            bArr2[i3 + 2] = (byte) (i2 % ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            i5 = 3;
        }
        System.arraycopy(bArr, i, bArr2, i5 + i3, i2);
        int i6 = i5 + i2 + i3;
        int i7 = i3 + 1;
        while (i7 < i6) {
            int i8 = i7 + 1;
            int i9 = (bArr2[i7] & UByte.MAX_VALUE) + ((i8 * CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA) % 255) + 1;
            if (i9 > 255) {
                i9 += InputDeviceCompat.SOURCE_ANY;
            }
            bArr2[i7] = (byte) i9;
            i7 = i8;
        }
        return i6 - i3;
    }

    private static int X12Encodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte b;
        int i5 = 0;
        if (i2 == 0) {
            return 0;
        }
        byte[] bArr3 = new byte[i2];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            b = 100;
            if (i6 >= i2) {
                break;
            }
            int indexOf = x12.indexOf((char) bArr[i6 + i]);
            if (indexOf >= 0) {
                bArr3[i6] = (byte) indexOf;
                i7++;
            } else {
                bArr3[i6] = 100;
                if (i7 >= 6) {
                    i7 -= (i7 / 3) * 3;
                }
                for (int i8 = 0; i8 < i7; i8++) {
                    bArr3[(i6 - i8) - 1] = 100;
                }
                i7 = 0;
            }
            i6++;
        }
        if (i7 >= 6) {
            i7 -= (i7 / 3) * 3;
        }
        for (int i9 = 0; i9 < i7; i9++) {
            bArr3[(i6 - i9) - 1] = 100;
        }
        int i10 = 0;
        while (i5 < i2) {
            byte b2 = bArr3[i5];
            if (i10 >= i4) {
                break;
            }
            if (b2 < 40) {
                if (i5 == 0 || (i5 > 0 && bArr3[i5 - 1] > 40)) {
                    bArr2[i10 + i3] = -18;
                    i10++;
                }
                if (i10 + 2 > i4) {
                    break;
                }
                i5 += 2;
                int i11 = (bArr3[i5] * 1600) + (bArr3[i5 + 1] * 40) + bArr3[i5] + 1;
                int i12 = i10 + 1;
                bArr2[i10 + i3] = (byte) (i11 / 256);
                i10 = i12 + 1;
                bArr2[i12 + i3] = (byte) i11;
            } else {
                if (i5 > 0 && bArr3[i5 - 1] < 40) {
                    bArr2[i10 + i3] = -2;
                    i10++;
                }
                int i13 = bArr[i5 + i] & UByte.MAX_VALUE;
                if (i13 > 127) {
                    bArr2[i10 + i3] = -21;
                    i13 -= 128;
                    i10++;
                }
                if (i10 >= i4) {
                    break;
                }
                bArr2[i10 + i3] = (byte) (i13 + 1);
                i10++;
            }
            i5++;
        }
        if (i2 > 0) {
            b = bArr3[i2 - 1];
        }
        if (i5 != i2) {
            return -1;
        }
        if (b < 40 && i10 >= i4) {
            return -1;
        }
        if (b >= 40) {
            return i10;
        }
        int i14 = i10 + 1;
        bArr2[i3 + i10] = -2;
        return i14;
    }

    private static int EdifactEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = 0;
        if (i2 == 0) {
            return 0;
        }
        int i8 = 0;
        boolean z = true;
        int i9 = 0;
        int i10 = 18;
        int i11 = 0;
        while (i8 < i2) {
            int i12 = bArr[i8 + i] & UByte.MAX_VALUE;
            int i13 = i12 & 224;
            if ((i13 == 64 || i13 == 32) && i12 != 95) {
                if (z) {
                    int i14 = i11 + 1;
                    if (i14 > i4) {
                        break;
                    }
                    bArr2[i3 + i11] = -16;
                    i11 = i14;
                    z = false;
                }
                i9 |= (i12 & 63) << i10;
                if (i10 != 0) {
                    i10 -= 6;
                } else if (i11 + 3 > i4) {
                    break;
                } else {
                    int i15 = i11 + 1;
                    bArr2[i3 + i11] = (byte) (i9 >> 16);
                    int i16 = i15 + 1;
                    bArr2[i3 + i15] = (byte) (i9 >> 8);
                    bArr2[i3 + i16] = (byte) i9;
                    i11 = i16 + 1;
                    i9 = 0;
                    i10 = 18;
                }
            } else {
                if (!z) {
                    i9 |= 31 << i10;
                    if ((i11 + 3) - (i10 / 8) > i4) {
                        break;
                    }
                    int i17 = i11 + 1;
                    bArr2[i3 + i11] = (byte) (i9 >> 16);
                    if (i10 <= 12) {
                        bArr2[i3 + i17] = (byte) (i9 >> 8);
                        i17++;
                    }
                    if (i10 <= 6) {
                        bArr2[i3 + i17] = (byte) i9;
                        i17++;
                    }
                    i11 = i17;
                    z = true;
                    i9 = 0;
                    i10 = 18;
                }
                if (i12 > 127) {
                    if (i11 >= i4) {
                        break;
                    }
                    bArr2[i3 + i11] = -21;
                    i12 -= 128;
                    i11++;
                }
                if (i11 >= i4) {
                    break;
                }
                bArr2[i3 + i11] = (byte) (i12 + 1);
                i11++;
            }
            i8++;
        }
        if (i8 != i2) {
            return -1;
        }
        int i18 = Integer.MAX_VALUE;
        while (true) {
            DmParams[] dmParamsArr = dmSizes;
            if (i7 >= dmParamsArr.length) {
                break;
            } else if (dmParamsArr[i7].dataSize >= i3 + i11 + (3 - (i10 / 6))) {
                i18 = dmSizes[i7].dataSize;
                break;
            } else {
                i7++;
            }
        }
        if ((i18 - i3) - i11 <= 2 && i10 >= 6) {
            if (i10 <= 12) {
                byte b = (byte) ((i9 >> 18) & 63);
                if ((b & DocWriter.SPACE) == 0) {
                    b = (byte) (b | 64);
                }
                bArr2[i3 + i11] = (byte) (b + 1);
                i11++;
            }
            if (i10 > 6) {
                return i11;
            }
            byte b2 = (byte) ((i9 >> 12) & 63);
            if ((b2 & DocWriter.SPACE) == 0) {
                b2 = (byte) (b2 | 64);
            }
            i5 = i11 + 1;
            bArr2[i3 + i11] = (byte) (b2 + 1);
        } else if (z) {
            return i11;
        } else {
            int i19 = (31 << i10) | i9;
            if ((i11 + 3) - (i10 / 8) > i4) {
                return -1;
            }
            int i20 = i11 + 1;
            bArr2[i3 + i11] = (byte) (i19 >> 16);
            if (i10 <= 12) {
                bArr2[i3 + i20] = (byte) (i19 >> 8);
                i6 = i20 + 1;
            } else {
                i6 = i20;
            }
            if (i10 > 6) {
                return i6;
            }
            i5 = i6 + 1;
            bArr2[i3 + i6] = (byte) i19;
        }
        return i5;
    }

    private static int C40OrTextEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (i2 == 0) {
            return 0;
        }
        if (z) {
            bArr2[i3 + 0] = -26;
        } else {
            bArr2[i3 + 0] = -17;
        }
        if (z) {
            str2 = " 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            str = "`abcdefghijklmnopqrstuvwxyz{|}~";
        } else {
            str2 = " 0123456789abcdefghijklmnopqrstuvwxyz";
            str = "`ABCDEFGHIJKLMNOPQRSTUVWXYZ{|}~";
        }
        int[] iArr = new int[((i2 * 4) + 10)];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i5 < i2) {
            if (i6 % 3 == 0) {
                i7 = i5;
                i8 = i6;
            }
            int i9 = i5 + 1;
            int i10 = bArr[i5 + i] & UByte.MAX_VALUE;
            if (i10 > 127) {
                i10 -= 128;
                int i11 = i6 + 1;
                iArr[i6] = 1;
                i6 = i11 + 1;
                iArr[i11] = 30;
            }
            char c = (char) i10;
            int indexOf = str2.indexOf(c);
            if (indexOf >= 0) {
                iArr[i6] = indexOf + 3;
                i6++;
            } else if (i10 < 32) {
                int i12 = i6 + 1;
                iArr[i6] = 0;
                i6 = i12 + 1;
                iArr[i12] = i10;
            } else {
                int indexOf2 = "!\"#$%&'()*+,-./:;<=>?@[\\]^_".indexOf(c);
                if (indexOf2 >= 0) {
                    int i13 = i6 + 1;
                    iArr[i6] = 1;
                    i6 = i13 + 1;
                    iArr[i13] = indexOf2;
                } else {
                    int indexOf3 = str.indexOf(c);
                    if (indexOf3 >= 0) {
                        int i14 = i6 + 1;
                        iArr[i6] = 2;
                        i6 = i14 + 1;
                        iArr[i14] = indexOf3;
                    }
                }
            }
            i5 = i9;
        }
        if (i6 % 3 != 0) {
            i5 = i7;
            i6 = i8;
        }
        if ((i6 / 3) * 2 > i4 - 2) {
            return -1;
        }
        int i15 = 1;
        for (int i16 = 0; i16 < i6; i16 += 3) {
            int i17 = (iArr[i16] * 1600) + (iArr[i16 + 1] * 40) + iArr[i16 + 2] + 1;
            int i18 = i15 + 1;
            bArr2[i3 + i15] = (byte) (i17 / 256);
            i15 = i18 + 1;
            bArr2[i3 + i18] = (byte) i17;
        }
        int i19 = i15 + 1;
        bArr2[i15] = -2;
        int asciiEncodation = asciiEncodation(bArr, i5, i2 - i5, bArr2, i19, i4 - i19);
        return asciiEncodation < 0 ? asciiEncodation : i19 + asciiEncodation;
    }

    private static int getEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, boolean z) {
        int[] iArr = new int[6];
        if (i4 < 0) {
            return -1;
        }
        int i6 = i5 & 7;
        if (i6 == 0) {
            iArr[0] = asciiEncodation(bArr, i, i2, bArr2, i3, i4);
            if (z && iArr[0] >= 0) {
                return iArr[0];
            }
            iArr[1] = C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, false);
            if (z && iArr[1] >= 0) {
                return iArr[1];
            }
            iArr[2] = C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, true);
            if (z && iArr[2] >= 0) {
                return iArr[2];
            }
            iArr[3] = b256Encodation(bArr, i, i2, bArr2, i3, i4);
            if (z && iArr[3] >= 0) {
                return iArr[3];
            }
            iArr[4] = X12Encodation(bArr, i, i2, bArr2, i3, i4);
            if (z && iArr[4] >= 0) {
                return iArr[4];
            }
            iArr[5] = EdifactEncodation(bArr, i, i2, bArr2, i3, i4);
            if (z && iArr[5] >= 0) {
                return iArr[5];
            }
            if (iArr[0] < 0 && iArr[1] < 0 && iArr[2] < 0 && iArr[3] < 0 && iArr[4] < 0 && iArr[5] < 0) {
                return -1;
            }
            int i7 = 99999;
            int i8 = 0;
            for (int i9 = 0; i9 < 6; i9++) {
                if (iArr[i9] >= 0 && iArr[i9] < i7) {
                    i7 = iArr[i9];
                    i8 = i9;
                }
            }
            if (i8 == 0) {
                return asciiEncodation(bArr, i, i2, bArr2, i3, i4);
            }
            if (i8 == 1) {
                return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, false);
            }
            if (i8 == 2) {
                return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, true);
            }
            if (i8 == 3) {
                return b256Encodation(bArr, i, i2, bArr2, i3, i4);
            }
            if (i8 == 4) {
                return X12Encodation(bArr, i, i2, bArr2, i3, i4);
            }
            return i7;
        }
        switch (i6) {
            case 1:
                return asciiEncodation(bArr, i, i2, bArr2, i3, i4);
            case 2:
                return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, true);
            case 3:
                return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, false);
            case 4:
                return b256Encodation(bArr, i, i2, bArr2, i3, i4);
            case 5:
                return X12Encodation(bArr, i, i2, bArr2, i3, i4);
            case 6:
                return EdifactEncodation(bArr, i, i2, bArr2, i3, i4);
            case 7:
                if (i2 > i4) {
                    return -1;
                }
                System.arraycopy(bArr, i, bArr2, i3, i2);
                return i2;
            default:
                return -1;
        }
    }

    private static int getNumber(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + 1;
            byte b = bArr[i] & UByte.MAX_VALUE;
            if (b < 48 || b > 57) {
                return -1;
            }
            i4 = ((i4 * 10) + b) - 48;
            i3++;
            i = i5;
        }
        return i4;
    }

    private int processExtensions(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3;
        int number;
        int number2;
        int i4 = 0;
        if ((this.options & 32) == 0) {
            return 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (i4 < i2 && i5 <= 20) {
            int i7 = i4 + 1;
            byte b = bArr[i4 + i] & UByte.MAX_VALUE;
            i5++;
            if (b == 46) {
                this.extOut = i7;
                return i6;
            } else if (b != 109) {
                if (b != 112) {
                    if (b == 115) {
                        if (i5 == 1 && i7 + 9 <= i2 && (number = getNumber(bArr, i + i7, 2)) > 0 && number <= 16) {
                            int i8 = i7 + 2;
                            int number3 = getNumber(bArr, i + i8, 2);
                            if (number3 > 1 && number3 <= 16) {
                                int i9 = i8 + 2;
                                int number4 = getNumber(bArr, i + i9, 5);
                                if (number4 >= 0 && number < 64516) {
                                    i7 = i9 + 5;
                                    int i10 = i6 + 1;
                                    bArr2[i6] = -23;
                                    int i11 = i10 + 1;
                                    bArr2[i10] = (byte) (((number - 1) << 4) | (17 - number3));
                                    int i12 = i11 + 1;
                                    bArr2[i11] = (byte) ((number4 / TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                                    i6 = i12 + 1;
                                    bArr2[i12] = (byte) ((number4 % TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                                }
                            }
                        }
                        return -1;
                    } else if (b == 101) {
                        i4 = i7 + 6;
                        if (i4 > i2 || (number2 = getNumber(bArr, i7 + i, 6)) < 0) {
                            return -1;
                        }
                        int i13 = i6 + 1;
                        bArr2[i6] = -15;
                        if (number2 < 127) {
                            i6 = i13 + 1;
                            bArr2[i13] = (byte) (number2 + 1);
                        } else if (number2 < 16383) {
                            int i14 = i13 + 1;
                            int i15 = number2 - 127;
                            bArr2[i13] = (byte) ((i15 / TIFFConstants.TIFFTAG_SUBFILETYPE) + 128);
                            bArr2[i14] = (byte) ((i15 % TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                            i6 = i14 + 1;
                        } else {
                            int i16 = i13 + 1;
                            int i17 = number2 - 16383;
                            bArr2[i13] = (byte) ((i17 / 64516) + 192);
                            int i18 = i16 + 1;
                            bArr2[i16] = (byte) (((i17 / TIFFConstants.TIFFTAG_SUBFILETYPE) % TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                            i6 = i18 + 1;
                            bArr2[i18] = (byte) ((i17 % TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                        }
                    } else if (b == 102) {
                        if (i5 != 1 && (i5 != 2 || (bArr[i] != 115 && bArr[i] != 109))) {
                            return -1;
                        }
                        i3 = i6 + 1;
                        bArr2[i6] = -24;
                        i6 = i3;
                    }
                } else if (i5 != 1) {
                    return -1;
                } else {
                    i3 = i6 + 1;
                    bArr2[i6] = -22;
                    i6 = i3;
                }
                i4 = i7;
            } else if (i5 != 1 || (i4 = i7 + 1) > i2) {
                return -1;
            } else {
                byte b2 = bArr[i7 + i] & UByte.MAX_VALUE;
                if (b2 != 53 && b2 != 53) {
                    return -1;
                }
                int i19 = i6 + 1;
                bArr2[i6] = -22;
                i6 = i19 + 1;
                bArr2[i19] = (byte) (b2 == 53 ? 236 : Jpeg.M_APPD);
            }
        }
        return -1;
    }

    public int generate(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes("iso-8859-1");
        return generate(bytes, 0, bytes.length);
    }

    public int generate(byte[] bArr, int i, int i2) {
        DmParams dmParams;
        int i3;
        byte[] bArr2 = new byte[2500];
        this.extOut = 0;
        int processExtensions = processExtensions(bArr, i, i2, bArr2);
        if (processExtensions < 0) {
            return 5;
        }
        if (this.height == 0 || this.width == 0) {
            DmParams[] dmParamsArr = dmSizes;
            DmParams dmParams2 = dmParamsArr[dmParamsArr.length - 1];
            int i4 = this.extOut;
            int encodation = getEncodation(bArr, i + i4, i2 - i4, bArr2, processExtensions, dmParams2.dataSize - processExtensions, this.options, false);
            if (encodation < 0) {
                return 1;
            }
            i3 = encodation + processExtensions;
            int i5 = 0;
            while (true) {
                DmParams[] dmParamsArr2 = dmSizes;
                if (i5 >= dmParamsArr2.length || (dmParamsArr2[i5].dataSize >= i3 && (!this.forceSquareSize || dmSizes[i5].width == dmSizes[i5].height))) {
                    dmParams = dmSizes[i5];
                    this.height = dmParams.height;
                    this.width = dmParams.width;
                } else {
                    i5++;
                }
            }
            dmParams = dmSizes[i5];
            this.height = dmParams.height;
            this.width = dmParams.width;
        } else {
            int i6 = 0;
            while (true) {
                DmParams[] dmParamsArr3 = dmSizes;
                if (i6 >= dmParamsArr3.length || (this.height == dmParamsArr3[i6].height && this.width == dmSizes[i6].width)) {
                    DmParams[] dmParamsArr4 = dmSizes;
                } else {
                    i6++;
                }
            }
            DmParams[] dmParamsArr42 = dmSizes;
            if (i6 == dmParamsArr42.length) {
                return 3;
            }
            dmParams = dmParamsArr42[i6];
            int i7 = this.extOut;
            int encodation2 = getEncodation(bArr, i + i7, i2 - i7, bArr2, processExtensions, dmParams.dataSize - processExtensions, this.options, true);
            if (encodation2 < 0) {
                return 1;
            }
            i3 = encodation2 + processExtensions;
        }
        if ((this.options & 64) != 0) {
            return 0;
        }
        this.image = new byte[((((dmParams.width + (this.ws * 2)) + 7) / 8) * (dmParams.height + (this.ws * 2)))];
        makePadding(bArr2, i3, dmParams.dataSize - i3);
        this.place = Placement.doPlacement(dmParams.height - ((dmParams.height / dmParams.heightSection) * 2), dmParams.width - ((dmParams.width / dmParams.widthSection) * 2));
        int i8 = dmParams.dataSize + (((dmParams.dataSize + 2) / dmParams.dataBlock) * dmParams.errorBlock);
        ReedSolomon.generateECC(bArr2, dmParams.dataSize, dmParams.dataBlock, dmParams.errorBlock);
        draw(bArr2, i8, dmParams);
        return 0;
    }

    public Image createImage() throws BadElementException {
        byte[] bArr = this.image;
        if (bArr == null) {
            return null;
        }
        int i = this.width;
        int i2 = this.ws;
        byte[] compress = CCITTG4Encoder.compress(bArr, i + (i2 * 2), this.height + (i2 * 2));
        int i3 = this.width;
        int i4 = this.ws;
        return Image.getInstance(i3 + (i4 * 2), this.height + (i4 * 2), false, 256, 0, compress, null);
    }

    private static class DmParams {
        int dataBlock;
        int dataSize;
        int errorBlock;
        int height;
        int heightSection;
        int width;
        int widthSection;

        DmParams(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.height = i;
            this.width = i2;
            this.heightSection = i3;
            this.widthSection = i4;
            this.dataSize = i5;
            this.dataBlock = i6;
            this.errorBlock = i7;
        }
    }

    public byte[] getImage() {
        return this.image;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getWs() {
        return this.ws;
    }

    public void setWs(int i) {
        this.ws = i;
    }

    public int getOptions() {
        return this.options;
    }

    public void setOptions(int i) {
        this.options = i;
    }

    public void setForceSquareSize(boolean z) {
        this.forceSquareSize = z;
    }

    static class Placement {
        private static final Hashtable<Integer, short[]> cache = new Hashtable<>();
        private short[] array;
        private int ncol;
        private int nrow;

        private Placement() {
        }

        static short[] doPlacement(int i, int i2) {
            Integer valueOf = Integer.valueOf((i * 1000) + i2);
            short[] sArr = cache.get(valueOf);
            if (sArr != null) {
                return sArr;
            }
            Placement placement = new Placement();
            placement.nrow = i;
            placement.ncol = i2;
            placement.array = new short[(i * i2)];
            placement.ecc200();
            cache.put(valueOf, placement.array);
            return placement.array;
        }

        private void module(int i, int i2, int i3, int i4) {
            if (i < 0) {
                int i5 = this.nrow;
                i += i5;
                i2 += 4 - ((i5 + 4) % 8);
            }
            if (i2 < 0) {
                int i6 = this.ncol;
                i2 += i6;
                i += 4 - ((i6 + 4) % 8);
            }
            this.array[(i * this.ncol) + i2] = (short) ((i3 * 8) + i4);
        }

        private void utah(int i, int i2, int i3) {
            int i4 = i - 2;
            int i5 = i2 - 2;
            module(i4, i5, i3, 0);
            int i6 = i2 - 1;
            module(i4, i6, i3, 1);
            int i7 = i - 1;
            module(i7, i5, i3, 2);
            module(i7, i6, i3, 3);
            module(i7, i2, i3, 4);
            module(i, i5, i3, 5);
            module(i, i6, i3, 6);
            module(i, i2, i3, 7);
        }

        private void corner1(int i) {
            module(this.nrow - 1, 0, i, 0);
            module(this.nrow - 1, 1, i, 1);
            module(this.nrow - 1, 2, i, 2);
            module(0, this.ncol - 2, i, 3);
            module(0, this.ncol - 1, i, 4);
            module(1, this.ncol - 1, i, 5);
            module(2, this.ncol - 1, i, 6);
            module(3, this.ncol - 1, i, 7);
        }

        private void corner2(int i) {
            module(this.nrow - 3, 0, i, 0);
            module(this.nrow - 2, 0, i, 1);
            module(this.nrow - 1, 0, i, 2);
            module(0, this.ncol - 4, i, 3);
            module(0, this.ncol - 3, i, 4);
            module(0, this.ncol - 2, i, 5);
            module(0, this.ncol - 1, i, 6);
            module(1, this.ncol - 1, i, 7);
        }

        private void corner3(int i) {
            module(this.nrow - 3, 0, i, 0);
            module(this.nrow - 2, 0, i, 1);
            module(this.nrow - 1, 0, i, 2);
            module(0, this.ncol - 2, i, 3);
            module(0, this.ncol - 1, i, 4);
            module(1, this.ncol - 1, i, 5);
            module(2, this.ncol - 1, i, 6);
            module(3, this.ncol - 1, i, 7);
        }

        private void corner4(int i) {
            module(this.nrow - 1, 0, i, 0);
            module(this.nrow - 1, this.ncol - 1, i, 1);
            module(0, this.ncol - 3, i, 2);
            module(0, this.ncol - 2, i, 3);
            module(0, this.ncol - 1, i, 4);
            module(1, this.ncol - 3, i, 5);
            module(1, this.ncol - 2, i, 6);
            module(1, this.ncol - 1, i, 7);
        }

        private void ecc200() {
            int i;
            int i2;
            int i3 = 0;
            Arrays.fill(this.array, (short) 0);
            int i4 = 4;
            int i5 = 1;
            while (true) {
                if (i4 == this.nrow && i3 == 0) {
                    corner1(i5);
                    i5++;
                }
                if (i4 == this.nrow - 2 && i3 == 0 && this.ncol % 4 != 0) {
                    corner2(i5);
                    i5++;
                }
                if (i4 == this.nrow - 2 && i3 == 0 && this.ncol % 8 == 4) {
                    corner3(i5);
                    i5++;
                }
                if (i4 == this.nrow + 4 && i3 == 2 && this.ncol % 8 == 0) {
                    corner4(i5);
                    i5++;
                }
                do {
                    if (i4 < this.nrow && i3 >= 0 && this.array[(this.ncol * i4) + i3] == 0) {
                        utah(i4, i3, i5);
                        i5++;
                    }
                    i4 -= 2;
                    i3 += 2;
                    if (i4 < 0) {
                        break;
                    }
                } while (i3 < this.ncol);
                int i6 = i4 + 1;
                int i7 = i3 + 3;
                do {
                    if (i6 >= 0) {
                        int i8 = this.ncol;
                        if (i7 < i8 && this.array[(i8 * i6) + i7] == 0) {
                            utah(i6, i7, i5);
                            i5++;
                        }
                    }
                    i6 += 2;
                    i7 -= 2;
                    if (i6 >= this.nrow) {
                        break;
                    }
                } while (i7 >= 0);
                i4 = i6 + 3;
                i3 = i7 + 1;
                i = this.nrow;
                if (i4 >= i && i3 >= (i2 = this.ncol)) {
                    break;
                }
            }
            short[] sArr = this.array;
            if (sArr[(i * i2) - 1] == 0) {
                sArr[((i * i2) - i2) - 2] = 1;
                sArr[(i * i2) - 1] = 1;
            }
        }
    }

    static class ReedSolomon {
        private static final int[] alog = {1, 2, 4, 8, 16, 32, 64, 128, 45, 90, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256, 69, 138, 57, 114, 228, 229, 231, 227, 235, 251, 219, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA, 27, 54, 108, 216, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, 23, 46, 92, 184, 93, CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, 89, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA256, 73, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 9, 18, 36, 72, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 13, 26, 52, 104, 208, 141, 55, 110, 220, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, 7, 14, 28, 56, 112, 224, Jpeg.M_APPD, MetaDo.META_CREATEPALETTE, CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 123, 246, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384, 115, 230, 225, 239, 243, 203, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256, 91, CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA256, 65, 130, 41, 82, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, 101, XMPError.BADRDF, CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA384, 95, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256, 81, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, 105, 210, 137, 63, 126, 252, 213, 135, 35, 70, 140, 53, 106, 212, 133, 39, 78, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, 21, 42, 84, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, 125, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 217, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, 19, 38, 76, CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, 29, 58, 116, 232, 253, 215, Imgproc.COLOR_RGB2YUV_YV12, 43, 86, CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256, 117, 234, 249, 223, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 11, 22, 44, 88, CipherSuite.TLS_PSK_WITH_NULL_SHA256, 77, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 25, 50, 100, 200, CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256, 87, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, 113, Jpeg.M_APP2, 233, 255, Primes.SMALL_FACTOR_LIMIT, 139, 59, 118, 236, 245, 199, CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384, 107, 214, 129, 47, 94, 188, 85, CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256, 121, 242, 201, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256, 83, CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256, 97, CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384, 127, TIFFConstants.TIFFTAG_SUBFILETYPE, 209, 143, 51, 102, 204, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384, 71, 142, 49, 98, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DH_DSS_WITH_AES_256_GCM_SHA384, 103, 206, CipherSuite.TLS_PSK_WITH_NULL_SHA384, 79, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, 17, 34, 68, 136, 61, 122, 244, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DH_anon_WITH_AES_256_GCM_SHA384, 99, 198, CipherSuite.TLS_DH_RSA_WITH_AES_256_GCM_SHA384, 111, 222, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, 15, 30, 60, 120, 240, 205, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA384, 67, 134, 33, 66, 132, 37, 74, CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA, 5, 10, 20, 40, 80, CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, 109, 218, CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA, 31, 62, 124, 248, 221, CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, 3, 6, 12, 24, 48, 96, 192, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, 119, Jpeg.M_APPE, 241, 207, 179, 75, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 1};
        private static final int[] log = {0, 255, 1, 240, 2, 225, 241, 53, 3, 38, Jpeg.M_APP2, 133, 242, 43, 54, 210, 4, CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256, 39, 114, 227, 106, 134, 28, 243, 140, 44, 23, 55, 118, Primes.SMALL_FACTOR_LIMIT, 234, 5, 219, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256, 96, 40, 222, 115, 103, 228, 78, 107, 125, 135, 8, 29, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, 244, CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, 141, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256, 45, 99, 24, 49, 56, 13, 119, CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA, 212, 199, 235, 91, 6, 76, 220, 217, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, 11, 97, 184, 41, 36, 223, 253, 116, 138, 104, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, 229, 86, 79, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 108, CipherSuite.TLS_DH_DSS_WITH_AES_256_GCM_SHA384, 126, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, 136, 34, 9, 74, 30, 32, CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384, 84, 245, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256, 204, 142, 81, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256, 46, 88, 100, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, 25, 231, 50, 207, 57, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 14, 67, 120, 128, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 248, 213, CipherSuite.TLS_DH_anon_WITH_AES_256_GCM_SHA384, 200, 63, 236, 110, 92, CipherSuite.TLS_PSK_WITH_NULL_SHA256, 7, CipherSuite.TLS_DH_RSA_WITH_AES_256_GCM_SHA384, 77, 124, 221, 102, 218, 95, 198, 90, 12, CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, 98, 48, CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA384, 179, 42, 209, 37, 132, 224, 52, TIFFConstants.TIFFTAG_SUBFILETYPE, 239, 117, 233, 139, 22, 105, 27, CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256, 113, 230, 206, 87, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, 80, CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256, 203, 109, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384, CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256, 62, 127, MetaDo.META_CREATEPALETTE, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 66, 137, 192, 35, 252, 10, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA384, 75, 216, 31, 83, 33, 73, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 85, CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256, 246, 65, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, 61, 188, XMPError.BADRDF, 205, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, 143, CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384, 82, 72, CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA256, 215, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256, 251, 47, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA256, 89, CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, 101, 94, CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, 123, 26, 112, 232, 21, 51, Jpeg.M_APPE, 208, Imgproc.COLOR_RGB2YUV_YV12, 58, 69, CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA, 18, 15, 16, 68, 17, 121, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, 129, 19, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA, 59, 249, 70, 214, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, 71, 201, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, 64, 60, Jpeg.M_APPD, 130, 111, 20, 93, 122, CipherSuite.TLS_PSK_WITH_NULL_SHA384, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA};
        private static final int[] poly10 = {28, 24, CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA384, CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256, 223, 248, 116, 255, 110, 61};
        private static final int[] poly11 = {CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384, 138, 205, 12, CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, 39, 245, 60, 97, 120};
        private static final int[] poly12 = {41, CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, 91, 61, 42, 142, 213, 97, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA256, 100, 242};
        private static final int[] poly14 = {CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, 97, 192, 252, 95, 9, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, 119, 138, 45, 18, CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, 83, CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA384};
        private static final int[] poly18 = {83, CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, TIFFConstants.TIFFTAG_SUBFILETYPE, 225, 48, 90, 188};
        private static final int[] poly20 = {15, CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256, 244, 9, 233, 71, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, 2, 188, CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, 253, 79, 108, 82, 27, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256};
        private static final int[] poly24 = {52, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256, 88, 205, 109, 39, CipherSuite.TLS_PSK_WITH_NULL_SHA256, 21, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, 251, 223, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA, 21, 5, CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256, TIFFConstants.TIFFTAG_SUBFILETYPE, 124, 12, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384, 184, 96, 50, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256};
        private static final int[] poly28 = {Primes.SMALL_FACTOR_LIMIT, 231, 43, 97, 71, 96, 103, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, 37, CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, 233, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, 93, 255};
        private static final int[] poly36 = {245, 127, 242, 218, 130, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384, 102, 120, 84, 179, 220, 251, 80, CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA256, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384, 184, 59, 25, 225, 98, 81, 112};
        private static final int[] poly42 = {77, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, 137, 31, 19, 38, 22, CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA, MetaDo.META_CREATEPALETTE, 105, 122, 2, 245, 133, 242, 8, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384, 95, 100, 9, CipherSuite.TLS_DH_anon_WITH_AES_256_GCM_SHA384, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, XMPError.BADRDF, 69, 50, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, CipherSuite.TLS_PSK_WITH_NULL_SHA384, Jpeg.M_APP2, 5, 9, 5};
        private static final int[] poly48 = {245, 132, CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256, 223, 96, 32, 117, 22, Jpeg.M_APPE, 133, Jpeg.M_APPE, 231, 205, 188, Jpeg.M_APPD, 87, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256, 106, 16, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 118, 23, 37, 90, CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256, 205, Imgproc.COLOR_RGB2YUV_YV12, 88, 120, 100, 66, 138, CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, 240, 82, 44, CipherSuite.TLS_PSK_WITH_NULL_SHA256, 87, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384, 69, 213, 92, 253, 225, 19};
        private static final int[] poly5 = {228, 48, 15, 111, 62};
        private static final int[] poly56 = {CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384, 9, 223, Jpeg.M_APPE, 12, 17, 220, 208, 100, 29, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384, CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256, 230, 192, 215, 235, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, 36, 223, 38, 200, 132, 54, 228, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 218, 234, 117, 203, 29, 232, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, Jpeg.M_APPE, 22, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 201, 117, 62, 207, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, 13, 137, 245, 127, 67, MetaDo.META_CREATEPALETTE, 28, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA, 43, 203, 107, 233, 53, 143, 46};
        private static final int[] poly62 = {242, 93, CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384, 50, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 210, 39, 118, XMPError.BADRDF, 188, 201, CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256, 143, 108, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256, 37, CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA384, 112, 134, 230, 245, 63, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 106, CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA384, 221, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384, 64, 114, 71, CipherSuite.TLS_DH_RSA_WITH_AES_256_GCM_SHA384, 44, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384, 31, CipherSuite.TLS_PSK_WITH_NULL_SHA256, CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256, 4, 107, 232, 7, 94, CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256, 224, 124, 86, 47, 11, 204};
        private static final int[] poly68 = {220, 228, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, 89, 251, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, 56, 89, 33, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 244, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 36, 73, 127, 213, 136, 248, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256, 234, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_PSK_WITH_NULL_SHA384, 68, 122, 93, 213, 15, CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, 227, 236, 66, 139, CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA384, XMPError.BADRDF, CipherSuite.TLS_DH_anon_WITH_AES_256_GCM_SHA384, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384, 241, 59, 52, CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256, 25, 49, 232, Primes.SMALL_FACTOR_LIMIT, CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256, 64, 54, 108, CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA, 132, 63, 96, 103, 82, CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256};
        private static final int[] poly7 = {23, 68, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 134, 240, 92, TIFFConstants.TIFFTAG_SUBFILETYPE};

        ReedSolomon() {
        }

        private static int[] getPoly(int i) {
            switch (i) {
                case 5:
                    return poly5;
                case 7:
                    return poly7;
                case 10:
                    return poly10;
                case 11:
                    return poly11;
                case 12:
                    return poly12;
                case 14:
                    return poly14;
                case 18:
                    return poly18;
                case 20:
                    return poly20;
                case 24:
                    return poly24;
                case 28:
                    return poly28;
                case 36:
                    return poly36;
                case 42:
                    return poly42;
                case 48:
                    return poly48;
                case 56:
                    return poly56;
                case 62:
                    return poly62;
                case 68:
                    return poly68;
                default:
                    return null;
            }
        }

        private static void reedSolomonBlock(byte[] bArr, int i, byte[] bArr2, int i2, int[] iArr) {
            byte b;
            for (int i3 = 0; i3 <= i2; i3++) {
                bArr2[i3] = 0;
            }
            for (int i4 = 0; i4 < i; i4++) {
                byte b2 = (bArr2[0] ^ bArr[i4]) & UByte.MAX_VALUE;
                int i5 = 0;
                while (i5 < i2) {
                    int i6 = i5 + 1;
                    byte b3 = bArr2[i6];
                    if (b2 == 0) {
                        b = 0;
                    } else {
                        int[] iArr2 = alog;
                        int[] iArr3 = log;
                        b = (byte) iArr2[(iArr3[b2] + iArr3[iArr[(i2 - i5) - 1]]) % 255];
                    }
                    bArr2[i5] = (byte) (b3 ^ b);
                    i5 = i6;
                }
            }
        }

        static void generateECC(byte[] bArr, int i, int i2, int i3) {
            int i4 = (i + 2) / i2;
            byte[] bArr2 = new byte[256];
            byte[] bArr3 = new byte[256];
            int[] poly = getPoly(i3);
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5;
                int i7 = 0;
                while (i6 < i) {
                    bArr2[i7] = bArr[i6];
                    i6 += i4;
                    i7++;
                }
                reedSolomonBlock(bArr2, i7, bArr3, i3, poly);
                int i8 = i5;
                int i9 = 0;
                while (i8 < i3 * i4) {
                    bArr[i + i8] = bArr3[i9];
                    i8 += i4;
                    i9++;
                }
            }
        }
    }

    public void placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, float f, float f2) {
        int i = this.width;
        int i2 = this.ws;
        int i3 = i + (i2 * 2);
        int i4 = this.height + (i2 * 2);
        int i5 = (i3 + 7) / 8;
        pdfContentByte.setColorFill(baseColor);
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = i6 * i5;
            for (int i8 = 0; i8 < i3; i8++) {
                if ((((this.image[(i8 / 8) + i7] & UByte.MAX_VALUE) << (i8 % 8)) & 128) != 0) {
                    pdfContentByte.rectangle(((float) i8) * f2, ((float) ((i4 - i6) - 1)) * f, f2, f);
                }
            }
        }
        pdfContentByte.fill();
    }
}
