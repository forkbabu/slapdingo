package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgRaw;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BidiOrder;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfString;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.UByte;
import org.opencv.ml.DTrees;

public class BmpImage {
    private static final int BI_BITFIELDS = 3;
    private static final int BI_RGB = 0;
    private static final int BI_RLE4 = 2;
    private static final int BI_RLE8 = 1;
    private static final int LCS_CALIBRATED_RGB = 0;
    private static final int LCS_CMYK = 2;
    private static final int LCS_sRGB = 1;
    private static final int VERSION_2_1_BIT = 0;
    private static final int VERSION_2_24_BIT = 3;
    private static final int VERSION_2_4_BIT = 1;
    private static final int VERSION_2_8_BIT = 2;
    private static final int VERSION_3_1_BIT = 4;
    private static final int VERSION_3_24_BIT = 7;
    private static final int VERSION_3_4_BIT = 5;
    private static final int VERSION_3_8_BIT = 6;
    private static final int VERSION_3_NT_16_BIT = 8;
    private static final int VERSION_3_NT_32_BIT = 9;
    private static final int VERSION_4_16_BIT = 13;
    private static final int VERSION_4_1_BIT = 10;
    private static final int VERSION_4_24_BIT = 14;
    private static final int VERSION_4_32_BIT = 15;
    private static final int VERSION_4_4_BIT = 11;
    private static final int VERSION_4_8_BIT = 12;
    private int alphaMask;
    private long bitmapFileSize;
    private long bitmapOffset;
    private int bitsPerPixel;
    private int blueMask;
    private long compression;
    private int greenMask;
    int height;
    private long imageSize;
    private int imageType;
    private InputStream inputStream;
    private boolean isBottomUp;
    private int numBands;
    private byte[] palette;
    public HashMap<String, Object> properties = new HashMap<>();
    private int redMask;
    int width;
    private long xPelsPerMeter;
    private long yPelsPerMeter;

    private int findMask(int i) {
        for (int i2 = 0; i2 < 32 && (i & 1) != 1; i2++) {
            i >>>= 1;
        }
        return i;
    }

    private int findShift(int i) {
        int i2 = 0;
        while (i2 < 32 && (i & 1) != 1) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    BmpImage(InputStream inputStream2, boolean z, int i) throws IOException {
        this.bitmapFileSize = (long) i;
        this.bitmapOffset = 0;
        process(inputStream2, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.itextpdf.text.Image getImage(java.net.URL r2) throws java.io.IOException {
        /*
            java.io.InputStream r0 = r2.openStream()     // Catch:{ all -> 0x0013 }
            com.itextpdf.text.Image r1 = getImage(r0)     // Catch:{ all -> 0x0011 }
            r1.setUrl(r2)     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x0010
            r0.close()
        L_0x0010:
            return r1
        L_0x0011:
            r2 = move-exception
            goto L_0x0015
        L_0x0013:
            r2 = move-exception
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            r0.close()
        L_0x001a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.BmpImage.getImage(java.net.URL):com.itextpdf.text.Image");
    }

    public static Image getImage(InputStream inputStream2) throws IOException {
        return getImage(inputStream2, false, 0);
    }

    public static Image getImage(InputStream inputStream2, boolean z, int i) throws IOException {
        BmpImage bmpImage = new BmpImage(inputStream2, z, i);
        try {
            Image image = bmpImage.getImage();
            image.setDpi((int) ((((double) bmpImage.xPelsPerMeter) * 0.0254d) + 0.5d), (int) ((((double) bmpImage.yPelsPerMeter) * 0.0254d) + 0.5d));
            image.setOriginalType(4);
            return image;
        } catch (BadElementException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static Image getImage(String str) throws IOException {
        return getImage(Utilities.toURL(str));
    }

    public static Image getImage(byte[] bArr) throws IOException {
        Image image = getImage(new ByteArrayInputStream(bArr));
        image.setOriginalData(bArr);
        return image;
    }

    /* access modifiers changed from: protected */
    public void process(InputStream inputStream2, boolean z) throws IOException {
        int i;
        int i2;
        if (z || (inputStream2 instanceof BufferedInputStream)) {
            this.inputStream = inputStream2;
        } else {
            this.inputStream = new BufferedInputStream(inputStream2);
        }
        if (!z) {
            if (readUnsignedByte(this.inputStream) == 66 && readUnsignedByte(this.inputStream) == 77) {
                this.bitmapFileSize = readDWord(this.inputStream);
                readWord(this.inputStream);
                readWord(this.inputStream);
                this.bitmapOffset = readDWord(this.inputStream);
            } else {
                throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.magic.value.for.bmp.file", new Object[0]));
            }
        }
        long readDWord = readDWord(this.inputStream);
        int i3 = (readDWord > 12 ? 1 : (readDWord == 12 ? 0 : -1));
        if (i3 == 0) {
            this.width = readWord(this.inputStream);
            this.height = readWord(this.inputStream);
        } else {
            this.width = readLong(this.inputStream);
            this.height = readLong(this.inputStream);
        }
        int readWord = readWord(this.inputStream);
        this.bitsPerPixel = readWord(this.inputStream);
        this.properties.put("color_planes", Integer.valueOf(readWord));
        this.properties.put("bits_per_pixel", Integer.valueOf(this.bitsPerPixel));
        this.numBands = 3;
        if (this.bitmapOffset == 0) {
            this.bitmapOffset = readDWord;
        }
        if (i3 == 0) {
            this.properties.put("bmp_version", "BMP v. 2.x");
            int i4 = this.bitsPerPixel;
            if (i4 == 1) {
                this.imageType = 0;
            } else if (i4 == 4) {
                this.imageType = 1;
            } else if (i4 == 8) {
                this.imageType = 2;
            } else if (i4 == 24) {
                this.imageType = 3;
            }
            long j = this.bitmapOffset;
            int i5 = ((int) (((j - 14) - readDWord) / 3)) * 3;
            if (j == readDWord) {
                int i6 = this.imageType;
                int i7 = i6 != 0 ? i6 != 1 ? i6 != 2 ? i6 != 3 ? i5 : 0 : DTrees.PREDICT_MASK : 48 : 6;
                this.bitmapOffset = readDWord + ((long) i7);
                i5 = i7;
            }
            readPalette(i5);
        } else {
            this.compression = readDWord(this.inputStream);
            this.imageSize = readDWord(this.inputStream);
            this.xPelsPerMeter = (long) readLong(this.inputStream);
            this.yPelsPerMeter = (long) readLong(this.inputStream);
            long readDWord2 = readDWord(this.inputStream);
            long readDWord3 = readDWord(this.inputStream);
            int i8 = (int) this.compression;
            if (i8 == 0) {
                this.properties.put("compression", "BI_RGB");
            } else if (i8 == 1) {
                this.properties.put("compression", "BI_RLE8");
            } else if (i8 == 2) {
                this.properties.put("compression", "BI_RLE4");
            } else if (i8 == 3) {
                this.properties.put("compression", "BI_BITFIELDS");
            }
            this.properties.put("x_pixels_per_meter", Long.valueOf(this.xPelsPerMeter));
            this.properties.put("y_pixels_per_meter", Long.valueOf(this.yPelsPerMeter));
            this.properties.put("colors_used", Long.valueOf(readDWord2));
            this.properties.put("colors_important", Long.valueOf(readDWord3));
            if (readDWord == 40 || readDWord == 52 || readDWord == 56) {
                int i9 = (int) this.compression;
                if (i9 == 0 || i9 == 1 || i9 == 2) {
                    int i10 = this.bitsPerPixel;
                    if (i10 == 1) {
                        this.imageType = 4;
                    } else if (i10 == 4) {
                        this.imageType = 5;
                    } else if (i10 == 8) {
                        this.imageType = 6;
                    } else if (i10 == 24) {
                        this.imageType = 7;
                    } else if (i10 == 16) {
                        this.imageType = 8;
                        this.redMask = 31744;
                        this.greenMask = 992;
                        this.blueMask = 31;
                        this.properties.put("red_mask", 31744);
                        this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                        this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                    } else if (i10 == 32) {
                        this.imageType = 9;
                        this.redMask = 16711680;
                        this.greenMask = 65280;
                        this.blueMask = 255;
                        this.properties.put("red_mask", 16711680);
                        this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                        this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                    }
                    if (readDWord >= 52) {
                        this.redMask = (int) readDWord(this.inputStream);
                        this.greenMask = (int) readDWord(this.inputStream);
                        this.blueMask = (int) readDWord(this.inputStream);
                        this.properties.put("red_mask", Integer.valueOf(this.redMask));
                        this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                        this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                    }
                    if (readDWord == 56) {
                        int readDWord4 = (int) readDWord(this.inputStream);
                        this.alphaMask = readDWord4;
                        this.properties.put("alpha_mask", Integer.valueOf(readDWord4));
                    }
                    long j2 = this.bitmapOffset;
                    int i11 = ((int) (((j2 - 14) - readDWord) / 4)) * 4;
                    if (j2 == readDWord) {
                        int i12 = this.imageType;
                        if (i12 != 4) {
                            if (i12 != 5) {
                                if (i12 != 6) {
                                    i11 = 0;
                                    this.bitmapOffset = readDWord + ((long) i11);
                                } else if (readDWord2 == 0) {
                                    readDWord2 = 256;
                                }
                            } else if (readDWord2 == 0) {
                                readDWord2 = 16;
                            }
                        } else if (readDWord2 == 0) {
                            readDWord2 = 2;
                        }
                        i11 = ((int) readDWord2) * 4;
                        this.bitmapOffset = readDWord + ((long) i11);
                    }
                    readPalette(i11);
                    this.properties.put("bmp_version", "BMP v. 3.x");
                } else if (i9 == 3) {
                    int i13 = this.bitsPerPixel;
                    if (i13 == 16) {
                        this.imageType = 8;
                    } else if (i13 == 32) {
                        this.imageType = 9;
                    }
                    this.redMask = (int) readDWord(this.inputStream);
                    this.greenMask = (int) readDWord(this.inputStream);
                    this.blueMask = (int) readDWord(this.inputStream);
                    if (readDWord == 56) {
                        int readDWord5 = (int) readDWord(this.inputStream);
                        this.alphaMask = readDWord5;
                        this.properties.put("alpha_mask", Integer.valueOf(readDWord5));
                    }
                    this.properties.put("red_mask", Integer.valueOf(this.redMask));
                    this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                    this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                    if (readDWord2 != 0) {
                        readPalette(((int) readDWord2) * 4);
                    }
                    this.properties.put("bmp_version", "BMP v. 3.x NT");
                } else {
                    throw new RuntimeException("Invalid compression specified in BMP file.");
                }
            } else if (readDWord == 108) {
                this.properties.put("bmp_version", "BMP v. 4.x");
                this.redMask = (int) readDWord(this.inputStream);
                this.greenMask = (int) readDWord(this.inputStream);
                this.blueMask = (int) readDWord(this.inputStream);
                this.alphaMask = (int) readDWord(this.inputStream);
                long readDWord6 = readDWord(this.inputStream);
                int readLong = readLong(this.inputStream);
                int readLong2 = readLong(this.inputStream);
                int readLong3 = readLong(this.inputStream);
                int readLong4 = readLong(this.inputStream);
                int readLong5 = readLong(this.inputStream);
                int readLong6 = readLong(this.inputStream);
                int readLong7 = readLong(this.inputStream);
                int readLong8 = readLong(this.inputStream);
                int readLong9 = readLong(this.inputStream);
                long readDWord7 = readDWord(this.inputStream);
                long readDWord8 = readDWord(this.inputStream);
                long readDWord9 = readDWord(this.inputStream);
                int i14 = this.bitsPerPixel;
                if (i14 == 1) {
                    this.imageType = 10;
                } else if (i14 == 4) {
                    this.imageType = 11;
                } else if (i14 == 8) {
                    this.imageType = 12;
                } else if (i14 == 16) {
                    this.imageType = 13;
                    if (((int) this.compression) == 0) {
                        this.redMask = 31744;
                        this.greenMask = 992;
                        this.blueMask = 31;
                    }
                } else if (i14 == 24) {
                    this.imageType = 14;
                } else if (i14 == 32) {
                    this.imageType = 15;
                    if (((int) this.compression) == 0) {
                        this.redMask = 16711680;
                        this.greenMask = 65280;
                        this.blueMask = 255;
                    }
                }
                this.properties.put("red_mask", Integer.valueOf(this.redMask));
                this.properties.put("green_mask", Integer.valueOf(this.greenMask));
                this.properties.put("blue_mask", Integer.valueOf(this.blueMask));
                this.properties.put("alpha_mask", Integer.valueOf(this.alphaMask));
                long j3 = this.bitmapOffset;
                int i15 = ((int) (((j3 - 14) - readDWord) / 4)) * 4;
                if (j3 == readDWord) {
                    switch (this.imageType) {
                        case 10:
                            if (readDWord2 == 0) {
                                readDWord2 = 2;
                            }
                            i15 = ((int) readDWord2) * 4;
                            break;
                        case 11:
                            if (readDWord2 == 0) {
                                readDWord2 = 16;
                            }
                            i15 = ((int) readDWord2) * 4;
                            break;
                        case 12:
                            if (readDWord2 == 0) {
                                readDWord2 = 256;
                            }
                            i15 = ((int) readDWord2) * 4;
                            break;
                        default:
                            i15 = 0;
                            break;
                    }
                    this.bitmapOffset = readDWord + ((long) i15);
                }
                readPalette(i15);
                int i16 = (int) readDWord6;
                if (i16 == 0) {
                    this.properties.put("color_space", "LCS_CALIBRATED_RGB");
                    this.properties.put("redX", Integer.valueOf(readLong));
                    this.properties.put("redY", Integer.valueOf(readLong2));
                    this.properties.put("redZ", Integer.valueOf(readLong3));
                    this.properties.put("greenX", Integer.valueOf(readLong4));
                    this.properties.put("greenY", Integer.valueOf(readLong5));
                    this.properties.put("greenZ", Integer.valueOf(readLong6));
                    this.properties.put("blueX", Integer.valueOf(readLong7));
                    this.properties.put("blueY", Integer.valueOf(readLong8));
                    this.properties.put("blueZ", Integer.valueOf(readLong9));
                    this.properties.put("gamma_red", Long.valueOf(readDWord7));
                    this.properties.put("gamma_green", Long.valueOf(readDWord8));
                    this.properties.put("gamma_blue", Long.valueOf(readDWord9));
                    throw new RuntimeException("Not implemented yet.");
                } else if (i16 == 1) {
                    this.properties.put("color_space", "LCS_sRGB");
                } else if (i16 == 2) {
                    this.properties.put("color_space", "LCS_CMYK");
                    throw new RuntimeException("Not implemented yet.");
                }
            } else {
                this.properties.put("bmp_version", "BMP v. 5.x");
                throw new RuntimeException("BMP version 5 not implemented yet.");
            }
        }
        int i17 = this.height;
        if (i17 > 0) {
            i2 = 1;
            this.isBottomUp = true;
            i = 0;
        } else {
            i2 = 1;
            i = 0;
            this.isBottomUp = false;
            this.height = Math.abs(i17);
        }
        int i18 = this.bitsPerPixel;
        if (i18 == i2 || i18 == 4 || i18 == 8) {
            this.numBands = 1;
            int i19 = this.imageType;
            int i20 = 256;
            if (i19 == 0 || i19 == 1 || i19 == 2) {
                int length = this.palette.length / 3;
                if (length <= 256) {
                    i20 = length;
                }
                byte[] bArr = new byte[i20];
                byte[] bArr2 = new byte[i20];
                byte[] bArr3 = new byte[i20];
                while (i < i20) {
                    int i21 = i * 3;
                    byte[] bArr4 = this.palette;
                    bArr3[i] = bArr4[i21];
                    bArr2[i] = bArr4[i21 + 1];
                    bArr[i] = bArr4[i21 + 2];
                    i++;
                }
                return;
            }
            int length2 = this.palette.length / 4;
            if (length2 <= 256) {
                i20 = length2;
            }
            byte[] bArr5 = new byte[i20];
            byte[] bArr6 = new byte[i20];
            byte[] bArr7 = new byte[i20];
            while (i < i20) {
                int i22 = i * 4;
                byte[] bArr8 = this.palette;
                bArr7[i] = bArr8[i22];
                bArr6[i] = bArr8[i22 + 1];
                bArr5[i] = bArr8[i22 + 2];
                i++;
            }
        } else if (i18 == 16) {
            this.numBands = 3;
        } else if (i18 == 32) {
            this.numBands = this.alphaMask == 0 ? 3 : 4;
        } else {
            this.numBands = 3;
        }
    }

    private byte[] getPalette(int i) {
        byte[] bArr = this.palette;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[((bArr.length / i) * 3)];
        int length = bArr.length / i;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * i;
            int i4 = i2 * 3;
            byte[] bArr3 = this.palette;
            int i5 = i3 + 1;
            bArr2[i4 + 2] = bArr3[i3];
            bArr2[i4 + 1] = bArr3[i5];
            bArr2[i4] = bArr3[i5 + 1];
        }
        return bArr2;
    }

    private Image getImage() throws IOException, BadElementException {
        switch (this.imageType) {
            case 0:
                return read1Bit(3);
            case 1:
                return read4Bit(3);
            case 2:
                return read8Bit(3);
            case 3:
                byte[] bArr = new byte[(this.width * this.height * 3)];
                read24Bit(bArr);
                return new ImgRaw(this.width, this.height, 3, 8, bArr);
            case 4:
                return read1Bit(4);
            case 5:
                int i = (int) this.compression;
                if (i == 0) {
                    return read4Bit(4);
                }
                if (i == 2) {
                    return readRLE4();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 6:
                int i2 = (int) this.compression;
                if (i2 == 0) {
                    return read8Bit(4);
                }
                if (i2 == 1) {
                    return readRLE8();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 7:
                byte[] bArr2 = new byte[(this.width * this.height * 3)];
                read24Bit(bArr2);
                return new ImgRaw(this.width, this.height, 3, 8, bArr2);
            case 8:
                return read1632Bit(false);
            case 9:
                return read1632Bit(true);
            case 10:
                return read1Bit(4);
            case 11:
                int i3 = (int) this.compression;
                if (i3 == 0) {
                    return read4Bit(4);
                }
                if (i3 == 2) {
                    return readRLE4();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 12:
                int i4 = (int) this.compression;
                if (i4 == 0) {
                    return read8Bit(4);
                }
                if (i4 == 1) {
                    return readRLE8();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 13:
                return read1632Bit(false);
            case 14:
                byte[] bArr3 = new byte[(this.width * this.height * 3)];
                read24Bit(bArr3);
                return new ImgRaw(this.width, this.height, 3, 8, bArr3);
            case 15:
                return read1632Bit(true);
            default:
                return null;
        }
    }

    private Image indexedModel(byte[] bArr, int i, int i2) throws BadElementException {
        ImgRaw imgRaw = new ImgRaw(this.width, this.height, 1, i, bArr);
        PdfArray pdfArray = new PdfArray();
        pdfArray.add(PdfName.INDEXED);
        pdfArray.add(PdfName.DEVICERGB);
        byte[] palette2 = getPalette(i2);
        pdfArray.add(new PdfNumber((palette2.length / 3) - 1));
        pdfArray.add(new PdfString(palette2));
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.COLORSPACE, pdfArray);
        imgRaw.setAdditional(pdfDictionary);
        return imgRaw;
    }

    private void readPalette(int i) throws IOException {
        if (i != 0) {
            this.palette = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = this.inputStream.read(this.palette, i2, i - i2);
                if (read >= 0) {
                    i2 += read;
                } else {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("incomplete.palette", new Object[0]));
                }
            }
            this.properties.put("palette", this.palette);
        }
    }

    private Image read1Bit(int i) throws IOException, BadElementException {
        int i2 = this.width;
        byte[] bArr = new byte[(((i2 + 7) / 8) * this.height)];
        int ceil = (int) Math.ceil(((double) i2) / 8.0d);
        int i3 = ceil % 4;
        int i4 = 0;
        int i5 = (i3 != 0 ? 4 - i3 : 0) + ceil;
        int i6 = this.height * i5;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        while (i7 < i6) {
            i7 += this.inputStream.read(bArr2, i7, i6 - i7);
        }
        if (this.isBottomUp) {
            while (i4 < this.height) {
                int i8 = i4 + 1;
                System.arraycopy(bArr2, i6 - (i8 * i5), bArr, i4 * ceil, ceil);
                i4 = i8;
            }
        } else {
            while (i4 < this.height) {
                System.arraycopy(bArr2, i4 * i5, bArr, i4 * ceil, ceil);
                i4++;
            }
        }
        return indexedModel(bArr, 1, i);
    }

    private Image read4Bit(int i) throws IOException, BadElementException {
        int i2 = this.width;
        byte[] bArr = new byte[(((i2 + 1) / 2) * this.height)];
        int ceil = (int) Math.ceil(((double) i2) / 2.0d);
        int i3 = ceil % 4;
        int i4 = 0;
        int i5 = (i3 != 0 ? 4 - i3 : 0) + ceil;
        int i6 = this.height * i5;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        while (i7 < i6) {
            i7 += this.inputStream.read(bArr2, i7, i6 - i7);
        }
        if (this.isBottomUp) {
            while (i4 < this.height) {
                int i8 = i4 + 1;
                System.arraycopy(bArr2, i6 - (i8 * i5), bArr, i4 * ceil, ceil);
                i4 = i8;
            }
        } else {
            while (i4 < this.height) {
                System.arraycopy(bArr2, i4 * i5, bArr, i4 * ceil, ceil);
                i4++;
            }
        }
        return indexedModel(bArr, 4, i);
    }

    private Image read8Bit(int i) throws IOException, BadElementException {
        int i2 = this.width;
        byte[] bArr = new byte[(this.height * i2)];
        int i3 = i2 * 8;
        int i4 = 0;
        int ceil = i3 % 32 != 0 ? (int) Math.ceil(((double) ((((i3 / 32) + 1) * 32) - i3)) / 8.0d) : 0;
        int i5 = (this.width + ceil) * this.height;
        byte[] bArr2 = new byte[i5];
        int i6 = 0;
        while (i6 < i5) {
            i6 += this.inputStream.read(bArr2, i6, i5 - i6);
        }
        if (this.isBottomUp) {
            while (i4 < this.height) {
                int i7 = i4 + 1;
                int i8 = this.width;
                System.arraycopy(bArr2, i5 - ((i8 + ceil) * i7), bArr, i4 * i8, i8);
                i4 = i7;
            }
        } else {
            while (i4 < this.height) {
                int i9 = this.width;
                System.arraycopy(bArr2, (i9 + ceil) * i4, bArr, i4 * i9, i9);
                i4++;
            }
        }
        return indexedModel(bArr, 8, i);
    }

    private void read24Bit(byte[] bArr) {
        int i = this.width * 24;
        int ceil = i % 32 != 0 ? (int) Math.ceil(((double) ((((i / 32) + 1) * 32) - i)) / 8.0d) : 0;
        int i2 = (((this.width * 3) + 3) / 4) * 4 * this.height;
        byte[] bArr2 = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            try {
                int read = this.inputStream.read(bArr2, i3, i2 - i3);
                if (read < 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
        if (this.isBottomUp) {
            int i4 = ((this.width * this.height) * 3) - 1;
            int i5 = -ceil;
            int i6 = 0;
            while (i6 < this.height) {
                i6++;
                int i7 = (i4 - ((this.width * i6) * 3)) + 1;
                i5 += ceil;
                for (int i8 = 0; i8 < this.width; i8++) {
                    int i9 = i5 + 1;
                    bArr[i7 + 2] = bArr2[i5];
                    int i10 = i9 + 1;
                    bArr[i7 + 1] = bArr2[i9];
                    i5 = i10 + 1;
                    bArr[i7] = bArr2[i10];
                    i7 += 3;
                }
            }
            return;
        }
        int i11 = -ceil;
        int i12 = 0;
        for (int i13 = 0; i13 < this.height; i13++) {
            i11 += ceil;
            for (int i14 = 0; i14 < this.width; i14++) {
                int i15 = i11 + 1;
                bArr[i12 + 2] = bArr2[i11];
                int i16 = i15 + 1;
                bArr[i12 + 1] = bArr2[i15];
                i11 = i16 + 1;
                bArr[i12] = bArr2[i16];
                i12 += 3;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.itextpdf.text.Image read1632Bit(boolean r21) throws java.io.IOException, com.itextpdf.text.BadElementException {
        /*
            r20 = this;
            r0 = r20
            int r1 = r0.redMask
            int r1 = r0.findMask(r1)
            int r2 = r0.redMask
            int r2 = r0.findShift(r2)
            int r3 = r1 + 1
            int r4 = r0.greenMask
            int r4 = r0.findMask(r4)
            int r5 = r0.greenMask
            int r5 = r0.findShift(r5)
            int r6 = r4 + 1
            int r7 = r0.blueMask
            int r7 = r0.findMask(r7)
            int r8 = r0.blueMask
            int r8 = r0.findShift(r8)
            int r9 = r7 + 1
            int r10 = r0.width
            int r11 = r0.height
            int r11 = r11 * r10
            int r11 = r11 * 3
            byte[] r11 = new byte[r11]
            if (r21 != 0) goto L_0x004f
            int r10 = r10 * 16
            int r13 = r10 % 32
            if (r13 == 0) goto L_0x004f
            int r13 = r10 / 32
            int r13 = r13 + 1
            int r13 = r13 * 32
            int r13 = r13 - r10
            double r13 = (double) r13
            r15 = 4620693217682128896(0x4020000000000000, double:8.0)
            double r13 = r13 / r15
            double r13 = java.lang.Math.ceil(r13)
            int r10 = (int) r13
            goto L_0x0050
        L_0x004f:
            r10 = 0
        L_0x0050:
            long r13 = r0.imageSize
            int r14 = (int) r13
            boolean r13 = r0.isBottomUp
            if (r13 == 0) goto L_0x00bb
            int r13 = r0.height
            int r13 = r13 + -1
        L_0x005b:
            if (r13 < 0) goto L_0x0111
            int r14 = r0.width
            int r14 = r14 * 3
            int r14 = r14 * r13
            r15 = 0
        L_0x0064:
            int r12 = r0.width
            if (r15 >= r12) goto L_0x00a7
            if (r21 == 0) goto L_0x0074
            java.io.InputStream r12 = r0.inputStream
            r17 = r13
            long r12 = r0.readDWord(r12)
            int r13 = (int) r12
            goto L_0x007c
        L_0x0074:
            r17 = r13
            java.io.InputStream r12 = r0.inputStream
            int r13 = r0.readWord(r12)
        L_0x007c:
            int r12 = r14 + 1
            int r18 = r13 >>> r2
            r19 = r2
            r2 = r18 & r1
            int r2 = r2 * 256
            int r2 = r2 / r3
            byte r2 = (byte) r2
            r11[r14] = r2
            int r2 = r12 + 1
            int r14 = r13 >>> r5
            r14 = r14 & r4
            int r14 = r14 * 256
            int r14 = r14 / r6
            byte r14 = (byte) r14
            r11[r12] = r14
            int r14 = r2 + 1
            int r12 = r13 >>> r8
            r12 = r12 & r7
            int r12 = r12 * 256
            int r12 = r12 / r9
            byte r12 = (byte) r12
            r11[r2] = r12
            int r15 = r15 + 1
            r13 = r17
            r2 = r19
            goto L_0x0064
        L_0x00a7:
            r19 = r2
            r17 = r13
            r2 = 0
        L_0x00ac:
            if (r2 >= r10) goto L_0x00b6
            java.io.InputStream r12 = r0.inputStream
            r12.read()
            int r2 = r2 + 1
            goto L_0x00ac
        L_0x00b6:
            int r13 = r17 + -1
            r2 = r19
            goto L_0x005b
        L_0x00bb:
            r19 = r2
            r2 = 0
            r12 = 0
        L_0x00bf:
            int r13 = r0.height
            if (r2 >= r13) goto L_0x0111
            r13 = 0
        L_0x00c4:
            int r14 = r0.width
            if (r13 >= r14) goto L_0x0101
            if (r21 == 0) goto L_0x00d2
            java.io.InputStream r14 = r0.inputStream
            long r14 = r0.readDWord(r14)
            int r15 = (int) r14
            goto L_0x00d8
        L_0x00d2:
            java.io.InputStream r14 = r0.inputStream
            int r15 = r0.readWord(r14)
        L_0x00d8:
            int r14 = r12 + 1
            int r17 = r15 >>> r19
            r18 = r2
            r2 = r17 & r1
            int r2 = r2 * 256
            int r2 = r2 / r3
            byte r2 = (byte) r2
            r11[r12] = r2
            int r2 = r14 + 1
            int r12 = r15 >>> r5
            r12 = r12 & r4
            int r12 = r12 * 256
            int r12 = r12 / r6
            byte r12 = (byte) r12
            r11[r14] = r12
            int r12 = r2 + 1
            int r14 = r15 >>> r8
            r14 = r14 & r7
            int r14 = r14 * 256
            int r14 = r14 / r9
            byte r14 = (byte) r14
            r11[r2] = r14
            int r13 = r13 + 1
            r2 = r18
            goto L_0x00c4
        L_0x0101:
            r18 = r2
            r2 = 0
        L_0x0104:
            if (r2 >= r10) goto L_0x010e
            java.io.InputStream r13 = r0.inputStream
            r13.read()
            int r2 = r2 + 1
            goto L_0x0104
        L_0x010e:
            int r2 = r18 + 1
            goto L_0x00bf
        L_0x0111:
            com.itextpdf.text.ImgRaw r1 = new com.itextpdf.text.ImgRaw
            int r13 = r0.width
            int r14 = r0.height
            r15 = 3
            r16 = 8
            r12 = r1
            r17 = r11
            r12.<init>(r13, r14, r15, r16, r17)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.BmpImage.read1632Bit(boolean):com.itextpdf.text.Image");
    }

    private Image readRLE8() throws IOException, BadElementException {
        int i = (int) this.imageSize;
        if (i == 0) {
            i = (int) (this.bitmapFileSize - this.bitmapOffset);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            i3 += this.inputStream.read(bArr, i3, i - i3);
        }
        byte[] decodeRLE = decodeRLE(true, bArr);
        int i4 = this.width;
        int i5 = this.height * i4;
        if (this.isBottomUp) {
            byte[] bArr2 = new byte[decodeRLE.length];
            while (i2 < this.height) {
                int i6 = i2 + 1;
                System.arraycopy(decodeRLE, i5 - (i6 * i4), bArr2, i2 * i4, i4);
                i2 = i6;
            }
            decodeRLE = bArr2;
        }
        return indexedModel(decodeRLE, 8, 4);
    }

    private Image readRLE4() throws IOException, BadElementException {
        int i = (int) this.imageSize;
        if (i == 0) {
            i = (int) (this.bitmapFileSize - this.bitmapOffset);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            i2 += this.inputStream.read(bArr, i2, i - i2);
        }
        byte[] decodeRLE = decodeRLE(false, bArr);
        if (this.isBottomUp) {
            int i3 = this.width;
            int i4 = this.height;
            byte[] bArr2 = new byte[(i3 * i4)];
            int i5 = 0;
            for (int i6 = i4 - 1; i6 >= 0; i6--) {
                int i7 = this.width;
                int i8 = i6 * i7;
                int i9 = i7 + i5;
                while (i5 != i9) {
                    bArr2[i5] = decodeRLE[i8];
                    i5++;
                    i8++;
                }
            }
            decodeRLE = bArr2;
        }
        int i10 = (this.width + 1) / 2;
        byte[] bArr3 = new byte[(this.height * i10)];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < this.height; i13++) {
            for (int i14 = 0; i14 < this.width; i14++) {
                if ((i14 & 1) == 0) {
                    bArr3[(i14 / 2) + i12] = (byte) (decodeRLE[i11] << 4);
                    i11++;
                } else {
                    int i15 = (i14 / 2) + i12;
                    bArr3[i15] = (byte) (((byte) (decodeRLE[i11] & BidiOrder.B)) | bArr3[i15]);
                    i11++;
                }
            }
            i12 += i10;
        }
        return indexedModel(bArr3, 4, 4);
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:55:0x0011 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:62:0x0011 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:59:0x0011 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /* JADX WARN: Type inference failed for: r6v8, types: [int] */
    private byte[] decodeRLE(boolean z, byte[] bArr) {
        byte[] bArr2 = new byte[(this.width * this.height)];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            try {
                if (i >= this.height || i2 >= bArr.length) {
                    break;
                }
                int i5 = i2 + 1;
                byte b = bArr[i2] & UByte.MAX_VALUE;
                if (b != 0) {
                    int i6 = i5 + 1;
                    byte b2 = bArr[i5] & UByte.MAX_VALUE;
                    if (z) {
                        int i7 = b;
                        while (i7 != 0) {
                            bArr2[i4] = (byte) b2;
                            i7--;
                            i4++;
                        }
                    } else {
                        int i8 = 0;
                        while (i8 < b) {
                            int i9 = i4 + 1;
                            bArr2[i4] = (byte) ((i8 & 1) == 1 ? b2 & BidiOrder.B : (b2 >>> 4) & BidiOrder.B);
                            i8++;
                            i4 = i9;
                        }
                    }
                    i3 += b;
                    i2 = i6;
                } else {
                    i2 = i5 + 1;
                    byte b3 = bArr[i5] & UByte.MAX_VALUE;
                    if (b3 == 1) {
                        break;
                    } else if (b3 == 0) {
                        i++;
                        i4 = this.width * i;
                        i3 = 0;
                    } else if (b3 != 2) {
                        if (z) {
                            int i10 = b3;
                            while (i10 != 0) {
                                bArr2[i4] = (byte) (bArr[i2] & UByte.MAX_VALUE);
                                i10--;
                                i4++;
                                i2++;
                            }
                        } else {
                            int i11 = 0;
                            byte b4 = 0;
                            while (i11 < b3) {
                                int i12 = i11 & 1;
                                if (i12 == 0) {
                                    b4 = bArr[i2] & UByte.MAX_VALUE;
                                    i2++;
                                }
                                int i13 = i4 + 1;
                                bArr2[i4] = (byte) (i12 == 1 ? b4 & BidiOrder.B : (b4 >>> 4) & BidiOrder.B);
                                i11++;
                                i4 = i13;
                            }
                        }
                        i3 += b3;
                        if (!z) {
                            byte b5 = b3 & 3;
                            if (!(b5 == 1 || b5 == 2)) {
                            }
                        } else if ((b3 & 1) == 1) {
                        }
                        i2++;
                    } else {
                        int i14 = i2 + 1;
                        i3 += bArr[i2] & UByte.MAX_VALUE;
                        i2 = i14 + 1;
                        i += bArr[i14] & UByte.MAX_VALUE;
                        i4 = (this.width * i) + i3;
                    }
                }
            } catch (RuntimeException unused) {
            }
        }
        return bArr2;
    }

    private int readUnsignedByte(InputStream inputStream2) throws IOException {
        return inputStream2.read() & 255;
    }

    private int readUnsignedShort(InputStream inputStream2) throws IOException {
        return ((readUnsignedByte(inputStream2) << 8) | readUnsignedByte(inputStream2)) & 65535;
    }

    private int readShort(InputStream inputStream2) throws IOException {
        return (readUnsignedByte(inputStream2) << 8) | readUnsignedByte(inputStream2);
    }

    private int readWord(InputStream inputStream2) throws IOException {
        return readUnsignedShort(inputStream2);
    }

    private long readUnsignedInt(InputStream inputStream2) throws IOException {
        int readUnsignedByte = readUnsignedByte(inputStream2);
        int readUnsignedByte2 = readUnsignedByte(inputStream2);
        return ((long) ((readUnsignedByte(inputStream2) << 24) | (readUnsignedByte(inputStream2) << 16) | (readUnsignedByte2 << 8) | readUnsignedByte)) & -1;
    }

    private int readInt(InputStream inputStream2) throws IOException {
        int readUnsignedByte = readUnsignedByte(inputStream2);
        int readUnsignedByte2 = readUnsignedByte(inputStream2);
        return (readUnsignedByte(inputStream2) << 24) | (readUnsignedByte(inputStream2) << 16) | (readUnsignedByte2 << 8) | readUnsignedByte;
    }

    private long readDWord(InputStream inputStream2) throws IOException {
        return readUnsignedInt(inputStream2);
    }

    private int readLong(InputStream inputStream2) throws IOException {
        return readInt(inputStream2);
    }
}
