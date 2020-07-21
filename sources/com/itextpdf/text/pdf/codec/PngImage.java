package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgRaw;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.ICC_Profile;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfLiteral;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import kotlin.UByte;

public class PngImage {
    public static final String IDAT = "IDAT";
    public static final String IEND = "IEND";
    public static final String IHDR = "IHDR";
    public static final String PLTE = "PLTE";
    public static final int[] PNGID = {137, 80, 78, 71, 13, 10, 26, 10};
    private static final int PNG_FILTER_AVERAGE = 3;
    private static final int PNG_FILTER_NONE = 0;
    private static final int PNG_FILTER_PAETH = 4;
    private static final int PNG_FILTER_SUB = 1;
    private static final int PNG_FILTER_UP = 2;
    private static final int TRANSFERSIZE = 4096;
    public static final String cHRM = "cHRM";
    public static final String gAMA = "gAMA";
    public static final String iCCP = "iCCP";
    private static final PdfName[] intents = {PdfName.PERCEPTUAL, PdfName.RELATIVECOLORIMETRIC, PdfName.SATURATION, PdfName.ABSOLUTECOLORIMETRIC};
    public static final String pHYs = "pHYs";
    public static final String sRGB = "sRGB";
    public static final String tRNS = "tRNS";
    float XYRatio;
    PdfDictionary additional = new PdfDictionary();
    int bitDepth;
    int bytesPerPixel;
    byte[] colorTable;
    int colorType;
    int compressionMethod;
    DataInputStream dataStream;
    int dpiX;
    int dpiY;
    int filterMethod;
    float gamma = 1.0f;
    boolean genBWMask;
    boolean hasCHRM = false;
    int height;
    ICC_Profile icc_profile;
    NewByteArrayOutputStream idat = new NewByteArrayOutputStream();
    byte[] image;
    int inputBands;
    PdfName intent;
    int interlaceMethod;
    InputStream is;
    boolean palShades;
    byte[] smask;
    byte[] trans;
    int transBlue = -1;
    int transGreen = -1;
    int transRedGray = -1;
    int width;
    float xB;
    float xG;
    float xR;
    float xW;
    float yB;
    float yG;
    float yR;
    float yW;

    PngImage(InputStream inputStream) {
        this.is = inputStream;
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
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.PngImage.getImage(java.net.URL):com.itextpdf.text.Image");
    }

    public static Image getImage(InputStream inputStream) throws IOException {
        return new PngImage(inputStream).getImage();
    }

    public static Image getImage(String str) throws IOException {
        return getImage(Utilities.toURL(str));
    }

    public static Image getImage(byte[] bArr) throws IOException {
        Image image2 = getImage(new ByteArrayInputStream(bArr));
        image2.setOriginalData(bArr);
        return image2;
    }

    /* access modifiers changed from: package-private */
    public boolean checkMarker(String str) {
        if (str.length() != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void readPng() throws IOException {
        int i = 0;
        while (true) {
            int[] iArr = PNGID;
            if (i >= iArr.length) {
                int i2 = 4096;
                byte[] bArr = new byte[4096];
                while (true) {
                    int i3 = getInt(this.is);
                    String string = getString(this.is);
                    if (i3 >= 0 && checkMarker(string)) {
                        if (IDAT.equals(string)) {
                            while (i3 != 0) {
                                int read = this.is.read(bArr, 0, Math.min(i3, i2));
                                if (read >= 0) {
                                    this.idat.write(bArr, 0, read);
                                    i3 -= read;
                                } else {
                                    return;
                                }
                            }
                            continue;
                        } else if (tRNS.equals(string)) {
                            int i4 = this.colorType;
                            if (i4 != 0) {
                                if (i4 != 2) {
                                    if (i4 == 3 && i3 > 0) {
                                        this.trans = new byte[i3];
                                        for (int i5 = 0; i5 < i3; i5++) {
                                            this.trans[i5] = (byte) this.is.read();
                                        }
                                        i3 = 0;
                                    }
                                } else if (i3 >= 6) {
                                    i3 -= 6;
                                    int word = getWord(this.is);
                                    int word2 = getWord(this.is);
                                    int word3 = getWord(this.is);
                                    if (this.bitDepth == 16) {
                                        this.transRedGray = word;
                                        this.transGreen = word2;
                                        this.transBlue = word3;
                                    } else {
                                        this.additional.put(PdfName.MASK, new PdfLiteral("[" + word + " " + word + " " + word2 + " " + word2 + " " + word3 + " " + word3 + "]"));
                                    }
                                }
                            } else if (i3 >= 2) {
                                i3 -= 2;
                                int word4 = getWord(this.is);
                                if (this.bitDepth == 16) {
                                    this.transRedGray = word4;
                                } else {
                                    this.additional.put(PdfName.MASK, new PdfLiteral("[" + word4 + " " + word4 + "]"));
                                }
                            }
                            Utilities.skip(this.is, i3);
                        } else if (IHDR.equals(string)) {
                            this.width = getInt(this.is);
                            this.height = getInt(this.is);
                            this.bitDepth = this.is.read();
                            this.colorType = this.is.read();
                            this.compressionMethod = this.is.read();
                            this.filterMethod = this.is.read();
                            this.interlaceMethod = this.is.read();
                        } else {
                            boolean z = true;
                            if (PLTE.equals(string)) {
                                if (this.colorType == 3) {
                                    PdfArray pdfArray = new PdfArray();
                                    pdfArray.add(PdfName.INDEXED);
                                    pdfArray.add(getColorspace());
                                    pdfArray.add(new PdfNumber((i3 / 3) - 1));
                                    ByteBuffer byteBuffer = new ByteBuffer();
                                    while (true) {
                                        int i6 = i3 - 1;
                                        if (i3 <= 0) {
                                            break;
                                        }
                                        byteBuffer.append_i(this.is.read());
                                        i3 = i6;
                                    }
                                    byte[] byteArray = byteBuffer.toByteArray();
                                    this.colorTable = byteArray;
                                    pdfArray.add(new PdfString(byteArray));
                                    this.additional.put(PdfName.COLORSPACE, pdfArray);
                                } else {
                                    Utilities.skip(this.is, i3);
                                }
                            } else if (pHYs.equals(string)) {
                                int i7 = getInt(this.is);
                                int i8 = getInt(this.is);
                                if (this.is.read() == 1) {
                                    this.dpiX = (int) ((((float) i7) * 0.0254f) + 0.5f);
                                    this.dpiY = (int) ((((float) i8) * 0.0254f) + 0.5f);
                                } else if (i8 != 0) {
                                    this.XYRatio = ((float) i7) / ((float) i8);
                                }
                            } else if (cHRM.equals(string)) {
                                this.xW = ((float) getInt(this.is)) / 100000.0f;
                                this.yW = ((float) getInt(this.is)) / 100000.0f;
                                this.xR = ((float) getInt(this.is)) / 100000.0f;
                                this.yR = ((float) getInt(this.is)) / 100000.0f;
                                this.xG = ((float) getInt(this.is)) / 100000.0f;
                                this.yG = ((float) getInt(this.is)) / 100000.0f;
                                this.xB = ((float) getInt(this.is)) / 100000.0f;
                                this.yB = ((float) getInt(this.is)) / 100000.0f;
                                if (Math.abs(this.xW) < 1.0E-4f || Math.abs(this.yW) < 1.0E-4f || Math.abs(this.xR) < 1.0E-4f || Math.abs(this.yR) < 1.0E-4f || Math.abs(this.xG) < 1.0E-4f || Math.abs(this.yG) < 1.0E-4f || Math.abs(this.xB) < 1.0E-4f || Math.abs(this.yB) < 1.0E-4f) {
                                    z = false;
                                }
                                this.hasCHRM = z;
                            } else if (sRGB.equals(string)) {
                                this.intent = intents[this.is.read()];
                                this.gamma = 2.2f;
                                this.xW = 0.3127f;
                                this.yW = 0.329f;
                                this.xR = 0.64f;
                                this.yR = 0.33f;
                                this.xG = 0.3f;
                                this.yG = 0.6f;
                                this.xB = 0.15f;
                                this.yB = 0.06f;
                                this.hasCHRM = true;
                            } else if (gAMA.equals(string)) {
                                int i9 = getInt(this.is);
                                if (i9 != 0) {
                                    this.gamma = 100000.0f / ((float) i9);
                                    if (!this.hasCHRM) {
                                        this.xW = 0.3127f;
                                        this.yW = 0.329f;
                                        this.xR = 0.64f;
                                        this.yR = 0.33f;
                                        this.xG = 0.3f;
                                        this.yG = 0.6f;
                                        this.xB = 0.15f;
                                        this.yB = 0.06f;
                                        this.hasCHRM = true;
                                    }
                                }
                            } else if (iCCP.equals(string)) {
                                do {
                                    i3--;
                                } while (this.is.read() != 0);
                                this.is.read();
                                int i10 = i3 - 1;
                                byte[] bArr2 = new byte[i10];
                                int i11 = 0;
                                while (i10 > 0) {
                                    int read2 = this.is.read(bArr2, i11, i10);
                                    if (read2 >= 0) {
                                        i11 += read2;
                                        i10 -= read2;
                                    } else {
                                        throw new IOException(MessageLocalization.getComposedMessage("premature.end.of.file", new Object[0]));
                                    }
                                }
                                try {
                                    this.icc_profile = ICC_Profile.getInstance(PdfReader.FlateDecode(bArr2, true));
                                } catch (RuntimeException unused) {
                                    this.icc_profile = null;
                                }
                            } else if (!IEND.equals(string)) {
                                Utilities.skip(this.is, i3);
                            } else {
                                return;
                            }
                        }
                        Utilities.skip(this.is, 4);
                        i2 = 4096;
                    }
                }
                throw new IOException(MessageLocalization.getComposedMessage("corrupted.png.file", new Object[0]));
            } else if (iArr[i] == this.is.read()) {
                i++;
            } else {
                throw new IOException(MessageLocalization.getComposedMessage("file.is.not.a.valid.png", new Object[0]));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.itextpdf.text.pdf.PdfLiteral} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.itextpdf.text.pdf.PdfLiteral} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: com.itextpdf.text.pdf.PdfLiteral} */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public PdfObject getColorspace() {
        if (this.icc_profile != null) {
            if ((this.colorType & 2) == 0) {
                return PdfName.DEVICEGRAY;
            }
            return PdfName.DEVICERGB;
        } else if (this.gamma != 1.0f || this.hasCHRM) {
            PdfArray pdfArray = new PdfArray();
            PdfDictionary pdfDictionary = new PdfDictionary();
            if ((this.colorType & 2) != 0) {
                PdfObject pdfLiteral = new PdfLiteral("[1 1 1]");
                pdfArray.add(PdfName.CALRGB);
                if (this.gamma != 1.0f) {
                    PdfArray pdfArray2 = new PdfArray();
                    PdfNumber pdfNumber = new PdfNumber(this.gamma);
                    pdfArray2.add(pdfNumber);
                    pdfArray2.add(pdfNumber);
                    pdfArray2.add(pdfNumber);
                    pdfDictionary.put(PdfName.GAMMA, pdfArray2);
                }
                if (this.hasCHRM) {
                    float f = this.yW;
                    float f2 = this.xG;
                    float f3 = this.xB;
                    float f4 = this.yR;
                    float f5 = this.xR;
                    float f6 = this.yG;
                    float f7 = this.yB;
                    float f8 = ((((f2 - f3) * f4) - ((f5 - f3) * f6)) + ((f5 - f2) * f7)) * f;
                    float f9 = this.xW;
                    float f10 = (((((f2 - f3) * f) - ((f9 - f3) * f6)) + ((f9 - f2) * f7)) * f4) / f8;
                    float f11 = (f10 * f5) / f4;
                    float f12 = (((1.0f - f5) / f4) - 1.0f) * f10;
                    float f13 = ((-f6) * ((((f5 - f3) * f) - ((f9 - f3) * f4)) + ((f9 - f5) * f7))) / f8;
                    float f14 = (f13 * f2) / f6;
                    float f15 = f13 * (((1.0f - f2) / f6) - 1.0f);
                    float f16 = (((((f5 - f2) * f) - ((f9 - f2) * f)) + ((f9 - f5) * f6)) * f7) / f8;
                    float f17 = (f16 * f3) / f7;
                    float f18 = (((1.0f - f3) / f7) - 1.0f) * f16;
                    PdfArray pdfArray3 = new PdfArray();
                    pdfArray3.add(new PdfNumber(f11 + f14 + f17));
                    pdfArray3.add(new PdfNumber(1.0f));
                    pdfArray3.add(new PdfNumber(f12 + f15 + f18));
                    PdfArray pdfArray4 = new PdfArray();
                    pdfArray4.add(new PdfNumber(f11));
                    pdfArray4.add(new PdfNumber(f10));
                    pdfArray4.add(new PdfNumber(f12));
                    pdfArray4.add(new PdfNumber(f14));
                    pdfArray4.add(new PdfNumber(f13));
                    pdfArray4.add(new PdfNumber(f15));
                    pdfArray4.add(new PdfNumber(f17));
                    pdfArray4.add(new PdfNumber(f16));
                    pdfArray4.add(new PdfNumber(f18));
                    pdfDictionary.put(PdfName.MATRIX, pdfArray4);
                    pdfLiteral = pdfArray3;
                }
                pdfDictionary.put(PdfName.WHITEPOINT, pdfLiteral);
                pdfArray.add(pdfDictionary);
            } else if (this.gamma == 1.0f) {
                return PdfName.DEVICEGRAY;
            } else {
                pdfArray.add(PdfName.CALGRAY);
                pdfDictionary.put(PdfName.GAMMA, new PdfNumber(this.gamma));
                pdfDictionary.put(PdfName.WHITEPOINT, new PdfLiteral("[1 1 1]"));
                pdfArray.add(pdfDictionary);
            }
            return pdfArray;
        } else if ((this.colorType & 2) == 0) {
            return PdfName.DEVICEGRAY;
        } else {
            return PdfName.DEVICERGB;
        }
    }

    /* access modifiers changed from: package-private */
    public Image getImage() throws IOException {
        int i;
        int i2;
        Image image2;
        readPng();
        boolean z = false;
        try {
            this.palShades = false;
            if (this.trans != null) {
                int i3 = 0;
                i2 = 0;
                i = 0;
                while (true) {
                    if (i3 < this.trans.length) {
                        byte b = this.trans[i3] & UByte.MAX_VALUE;
                        if (b == 0) {
                            i2++;
                            i = i3;
                        }
                        if (b != 0 && b != 255) {
                            this.palShades = true;
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                }
            } else {
                i2 = 0;
                i = 0;
            }
            if ((this.colorType & 4) != 0) {
                this.palShades = true;
            }
            boolean z2 = !this.palShades && (i2 > 1 || this.transRedGray >= 0);
            this.genBWMask = z2;
            if (!this.palShades && !z2 && i2 == 1) {
                this.additional.put(PdfName.MASK, new PdfLiteral("[" + i + " " + i + "]"));
            }
            if (this.interlaceMethod == 1 || this.bitDepth == 16 || (this.colorType & 4) != 0 || this.palShades || this.genBWMask) {
                z = true;
            }
            int i4 = this.colorType;
            int i5 = 3;
            if (i4 == 0) {
                this.inputBands = 1;
            } else if (i4 == 6) {
                this.inputBands = 4;
            } else if (i4 == 2) {
                this.inputBands = 3;
            } else if (i4 == 3) {
                this.inputBands = 1;
            } else if (i4 == 4) {
                this.inputBands = 2;
            }
            if (z) {
                decodeIdat();
            }
            int i6 = this.inputBands;
            if ((this.colorType & 4) != 0) {
                i6--;
            }
            int i7 = this.bitDepth;
            int i8 = i7 == 16 ? 8 : i7;
            if (this.image == null) {
                image2 = new ImgRaw(this.width, this.height, i6, i8, this.idat.toByteArray());
                image2.setDeflated(true);
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.put(PdfName.BITSPERCOMPONENT, new PdfNumber(this.bitDepth));
                pdfDictionary.put(PdfName.PREDICTOR, new PdfNumber(15));
                pdfDictionary.put(PdfName.COLUMNS, new PdfNumber(this.width));
                PdfName pdfName = PdfName.COLORS;
                if (this.colorType == 3 || (this.colorType & 2) == 0) {
                    i5 = 1;
                }
                pdfDictionary.put(pdfName, new PdfNumber(i5));
                this.additional.put(PdfName.DECODEPARMS, pdfDictionary);
            } else if (this.colorType == 3) {
                image2 = new ImgRaw(this.width, this.height, i6, i8, this.image);
            } else {
                image2 = Image.getInstance(this.width, this.height, i6, i8, this.image);
            }
            if (this.additional.get(PdfName.COLORSPACE) == null) {
                this.additional.put(PdfName.COLORSPACE, getColorspace());
            }
            if (this.intent != null) {
                this.additional.put(PdfName.INTENT, this.intent);
            }
            if (this.additional.size() > 0) {
                image2.setAdditional(this.additional);
            }
            if (this.icc_profile != null) {
                image2.tagICC(this.icc_profile);
            }
            if (this.palShades) {
                Image instance = Image.getInstance(this.width, this.height, 1, 8, this.smask);
                instance.makeMask();
                image2.setImageMask(instance);
            }
            if (this.genBWMask) {
                Image instance2 = Image.getInstance(this.width, this.height, 1, 1, this.smask);
                instance2.makeMask();
                image2.setImageMask(instance2);
            }
            image2.setDpi(this.dpiX, this.dpiY);
            image2.setXYRatio(this.XYRatio);
            image2.setOriginalType(2);
            return image2;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void decodeIdat() {
        int i = this.bitDepth;
        if (i == 16) {
            i = 8;
        }
        int i2 = -1;
        int i3 = this.bitDepth == 16 ? 2 : 1;
        this.bytesPerPixel = i3;
        int i4 = this.colorType;
        if (i4 == 0) {
            i2 = (((i * this.width) + 7) / 8) * this.height;
        } else if (i4 == 6) {
            i2 = this.height * this.width * 3;
            this.bytesPerPixel = i3 * 4;
        } else if (i4 == 2) {
            i2 = this.height * this.width * 3;
            this.bytesPerPixel = i3 * 3;
        } else if (i4 == 3) {
            if (this.interlaceMethod == 1) {
                i2 = (((i * this.width) + 7) / 8) * this.height;
            }
            this.bytesPerPixel = 1;
        } else if (i4 == 4) {
            i2 = this.height * this.width;
            this.bytesPerPixel = i3 * 2;
        }
        if (i2 >= 0) {
            this.image = new byte[i2];
        }
        if (this.palShades) {
            this.smask = new byte[(this.width * this.height)];
        } else if (this.genBWMask) {
            this.smask = new byte[(((this.width + 7) / 8) * this.height)];
        }
        this.dataStream = new DataInputStream(new InflaterInputStream(new ByteArrayInputStream(this.idat.getBuf(), 0, this.idat.size()), new Inflater()));
        if (this.interlaceMethod != 1) {
            decodePass(0, 0, 1, 1, this.width, this.height);
            return;
        }
        decodePass(0, 0, 8, 8, (this.width + 7) / 8, (this.height + 7) / 8);
        decodePass(4, 0, 8, 8, (this.width + 3) / 8, (this.height + 7) / 8);
        decodePass(0, 4, 4, 8, (this.width + 3) / 4, (this.height + 3) / 8);
        decodePass(2, 0, 4, 4, (this.width + 1) / 4, (this.height + 3) / 4);
        decodePass(0, 2, 2, 4, (this.width + 1) / 2, (this.height + 1) / 4);
        decodePass(1, 0, 2, 2, this.width / 2, (this.height + 1) / 2);
        decodePass(0, 1, 1, 2, this.width, this.height / 2);
    }

    /* access modifiers changed from: package-private */
    public void decodePass(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        if (i5 != 0 && i6 != 0) {
            int i8 = (((this.inputBands * i5) * this.bitDepth) + 7) / 8;
            int i9 = i2;
            byte[] bArr = new byte[i8];
            byte[] bArr2 = new byte[i8];
            int i10 = 0;
            while (i10 < i6) {
                try {
                    i7 = this.dataStream.read();
                    try {
                        this.dataStream.readFully(bArr, 0, i8);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i7 = 0;
                }
                if (i7 != 0) {
                    if (i7 == 1) {
                        decodeSubFilter(bArr, i8, this.bytesPerPixel);
                    } else if (i7 == 2) {
                        decodeUpFilter(bArr, bArr2, i8);
                    } else if (i7 == 3) {
                        decodeAverageFilter(bArr, bArr2, i8, this.bytesPerPixel);
                    } else if (i7 == 4) {
                        decodePaethFilter(bArr, bArr2, i8, this.bytesPerPixel);
                    } else {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("png.filter.unknown", new Object[0]));
                    }
                }
                processPixels(bArr, i, i3, i9, i5);
                i10++;
                i9 += i4;
                bArr2 = bArr;
                bArr = bArr2;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: int[]} */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processPixels(byte[] r27, int r28, int r29, int r30, int r31) {
        /*
            r26 = this;
            r0 = r26
            r1 = r31
            int[] r10 = r26.getPixel(r27)
            int r2 = r0.colorType
            r11 = 4
            r12 = 3
            r13 = 2
            r14 = 1
            r15 = 0
            if (r2 == 0) goto L_0x0020
            r3 = 6
            if (r2 == r3) goto L_0x001d
            if (r2 == r13) goto L_0x001d
            if (r2 == r12) goto L_0x0020
            if (r2 == r11) goto L_0x0020
            r16 = 0
            goto L_0x0022
        L_0x001d:
            r16 = 3
            goto L_0x0022
        L_0x0020:
            r16 = 1
        L_0x0022:
            byte[] r2 = r0.image
            r9 = 16
            r17 = 8
            if (r2 == 0) goto L_0x0063
            int r2 = r0.width
            int r2 = r2 * r16
            int r3 = r0.bitDepth
            if (r3 != r9) goto L_0x0034
            r3 = 8
        L_0x0034:
            int r2 = r2 * r3
            int r2 = r2 + 7
            int r18 = r2 / 8
            r19 = r28
            r8 = 0
        L_0x003d:
            if (r8 >= r1) goto L_0x0063
            byte[] r2 = r0.image
            int r3 = r0.inputBands
            int r4 = r3 * r8
            int r7 = r0.bitDepth
            r3 = r10
            r5 = r16
            r6 = r19
            r20 = r7
            r7 = r30
            r21 = r8
            r8 = r20
            r12 = 16
            r9 = r18
            setPixel(r2, r3, r4, r5, r6, r7, r8, r9)
            int r19 = r19 + r29
            int r8 = r21 + 1
            r9 = 16
            r12 = 3
            goto L_0x003d
        L_0x0063:
            r12 = 16
            boolean r2 = r0.palShades
            if (r2 == 0) goto L_0x00ce
            int r2 = r0.colorType
            r2 = r2 & r11
            if (r2 == 0) goto L_0x00a2
            int r2 = r0.bitDepth
            if (r2 != r12) goto L_0x0084
            r2 = 0
        L_0x0073:
            if (r2 >= r1) goto L_0x0084
            int r3 = r0.inputBands
            int r3 = r3 * r2
            int r3 = r3 + r16
            r4 = r10[r3]
            int r4 = r4 >>> 8
            r10[r3] = r4
            int r2 = r2 + 1
            goto L_0x0073
        L_0x0084:
            int r11 = r0.width
            r12 = r28
        L_0x0088:
            if (r15 >= r1) goto L_0x018c
            byte[] r2 = r0.smask
            int r3 = r0.inputBands
            int r3 = r3 * r15
            int r4 = r3 + r16
            r5 = 1
            r8 = 8
            r3 = r10
            r6 = r12
            r7 = r30
            r9 = r11
            setPixel(r2, r3, r4, r5, r6, r7, r8, r9)
            int r12 = r12 + r29
            int r15 = r15 + 1
            goto L_0x0088
        L_0x00a2:
            int r11 = r0.width
            int[] r12 = new int[r14]
            r13 = r28
            r14 = 0
        L_0x00a9:
            if (r14 >= r1) goto L_0x018c
            r2 = r10[r14]
            byte[] r3 = r0.trans
            int r4 = r3.length
            if (r2 >= r4) goto L_0x00b7
            byte r2 = r3[r2]
            r12[r15] = r2
            goto L_0x00bb
        L_0x00b7:
            r2 = 255(0xff, float:3.57E-43)
            r12[r15] = r2
        L_0x00bb:
            byte[] r2 = r0.smask
            r4 = 0
            r5 = 1
            r8 = 8
            r3 = r12
            r6 = r13
            r7 = r30
            r9 = r11
            setPixel(r2, r3, r4, r5, r6, r7, r8, r9)
            int r13 = r13 + r29
            int r14 = r14 + 1
            goto L_0x00a9
        L_0x00ce:
            boolean r2 = r0.genBWMask
            if (r2 == 0) goto L_0x018c
            int r2 = r0.colorType
            if (r2 == 0) goto L_0x015a
            if (r2 == r13) goto L_0x0114
            r3 = 3
            if (r2 == r3) goto L_0x00dd
            goto L_0x018c
        L_0x00dd:
            int r2 = r0.width
            int r2 = r2 + 7
            int r2 = r2 / 8
            int[] r3 = new int[r14]
            r4 = r28
            r5 = 0
        L_0x00e8:
            if (r5 >= r1) goto L_0x018c
            r6 = r10[r5]
            byte[] r7 = r0.trans
            int r8 = r7.length
            if (r6 >= r8) goto L_0x00f7
            byte r6 = r7[r6]
            if (r6 != 0) goto L_0x00f7
            r6 = 1
            goto L_0x00f8
        L_0x00f7:
            r6 = 0
        L_0x00f8:
            r3[r15] = r6
            byte[] r6 = r0.smask
            r20 = 0
            r21 = 1
            r24 = 1
            r18 = r6
            r19 = r3
            r22 = r4
            r23 = r30
            r25 = r2
            setPixel(r18, r19, r20, r21, r22, r23, r24, r25)
            int r4 = r4 + r29
            int r5 = r5 + 1
            goto L_0x00e8
        L_0x0114:
            int r2 = r0.width
            int r2 = r2 + 7
            int r2 = r2 / 8
            int[] r3 = new int[r14]
            r4 = r28
            r5 = 0
        L_0x011f:
            if (r5 >= r1) goto L_0x018c
            int r6 = r0.inputBands
            int r6 = r6 * r5
            r7 = r10[r6]
            int r8 = r0.transRedGray
            if (r7 != r8) goto L_0x013d
            int r7 = r6 + 1
            r7 = r10[r7]
            int r8 = r0.transGreen
            if (r7 != r8) goto L_0x013d
            int r6 = r6 + 2
            r6 = r10[r6]
            int r7 = r0.transBlue
            if (r6 != r7) goto L_0x013d
            r6 = 1
            goto L_0x013e
        L_0x013d:
            r6 = 0
        L_0x013e:
            r3[r15] = r6
            byte[] r6 = r0.smask
            r20 = 0
            r21 = 1
            r24 = 1
            r18 = r6
            r19 = r3
            r22 = r4
            r23 = r30
            r25 = r2
            setPixel(r18, r19, r20, r21, r22, r23, r24, r25)
            int r4 = r4 + r29
            int r5 = r5 + 1
            goto L_0x011f
        L_0x015a:
            int r2 = r0.width
            int r2 = r2 + 7
            int r2 = r2 / 8
            int[] r3 = new int[r14]
            r4 = r28
            r5 = 0
        L_0x0165:
            if (r5 >= r1) goto L_0x018c
            r6 = r10[r5]
            int r7 = r0.transRedGray
            if (r6 != r7) goto L_0x016f
            r6 = 1
            goto L_0x0170
        L_0x016f:
            r6 = 0
        L_0x0170:
            r3[r15] = r6
            byte[] r6 = r0.smask
            r20 = 0
            r21 = 1
            r24 = 1
            r18 = r6
            r19 = r3
            r22 = r4
            r23 = r30
            r25 = r2
            setPixel(r18, r19, r20, r21, r22, r23, r24, r25)
            int r4 = r4 + r29
            int r5 = r5 + 1
            goto L_0x0165
        L_0x018c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.PngImage.processPixels(byte[], int, int, int, int):void");
    }

    static int getPixel(byte[] bArr, int i, int i2, int i3, int i4) {
        if (i3 == 8) {
            return bArr[(i4 * i2) + i] & UByte.MAX_VALUE;
        }
        int i5 = i4 * i2;
        int i6 = 8 / i3;
        return (bArr[i5 + (i / i6)] >> ((8 - ((i % i6) * i3)) - i3)) & ((1 << i3) - 1);
    }

    static void setPixel(byte[] bArr, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        if (i5 == 8) {
            int i8 = (i6 * i4) + (i3 * i2);
            while (i7 < i2) {
                bArr[i8 + i7] = (byte) iArr[i7 + i];
                i7++;
            }
        } else if (i5 == 16) {
            int i9 = (i6 * i4) + (i3 * i2);
            while (i7 < i2) {
                bArr[i9 + i7] = (byte) (iArr[i7 + i] >>> 8);
                i7++;
            }
        } else {
            int i10 = 8 / i5;
            int i11 = (i6 * i4) + (i3 / i10);
            bArr[i11] = (byte) ((iArr[i] << ((8 - ((i3 % i10) * i5)) - i5)) | bArr[i11]);
        }
    }

    /* access modifiers changed from: package-private */
    public int[] getPixel(byte[] bArr) {
        int i = this.bitDepth;
        int i2 = 0;
        if (i == 8) {
            int length = bArr.length;
            int[] iArr = new int[length];
            while (i2 < length) {
                iArr[i2] = bArr[i2] & UByte.MAX_VALUE;
                i2++;
            }
            return iArr;
        } else if (i != 16) {
            int[] iArr2 = new int[((bArr.length * 8) / i)];
            int i3 = 8 / i;
            int i4 = (1 << i) - 1;
            int i5 = 0;
            while (i2 < bArr.length) {
                int i6 = i3 - 1;
                while (i6 >= 0) {
                    iArr2[i5] = (bArr[i2] >>> (this.bitDepth * i6)) & i4;
                    i6--;
                    i5++;
                }
                i2++;
            }
            return iArr2;
        } else {
            int length2 = bArr.length / 2;
            int[] iArr3 = new int[length2];
            while (i2 < length2) {
                int i7 = i2 * 2;
                iArr3[i2] = ((bArr[i7] & UByte.MAX_VALUE) << 8) + (bArr[i7 + 1] & UByte.MAX_VALUE);
                i2++;
            }
            return iArr3;
        }
    }

    private static void decodeSubFilter(byte[] bArr, int i, int i2) {
        for (int i3 = i2; i3 < i; i3++) {
            bArr[i3] = (byte) ((bArr[i3] & UByte.MAX_VALUE) + (bArr[i3 - i2] & UByte.MAX_VALUE));
        }
    }

    private static void decodeUpFilter(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((bArr[i2] & UByte.MAX_VALUE) + (bArr2[i2] & UByte.MAX_VALUE));
        }
    }

    private static void decodeAverageFilter(byte[] bArr, byte[] bArr2, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((bArr[i3] & UByte.MAX_VALUE) + ((bArr2[i3] & UByte.MAX_VALUE) / 2));
        }
        for (int i4 = i2; i4 < i; i4++) {
            bArr[i4] = (byte) ((bArr[i4] & UByte.MAX_VALUE) + (((bArr[i4 - i2] & UByte.MAX_VALUE) + (bArr2[i4] & UByte.MAX_VALUE)) / 2));
        }
    }

    private static int paethPredictor(int i, int i2, int i3) {
        int i4 = (i + i2) - i3;
        int abs = Math.abs(i4 - i);
        int abs2 = Math.abs(i4 - i2);
        int abs3 = Math.abs(i4 - i3);
        if (abs > abs2 || abs > abs3) {
            return abs2 <= abs3 ? i2 : i3;
        }
        return i;
    }

    private static void decodePaethFilter(byte[] bArr, byte[] bArr2, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((bArr[i3] & UByte.MAX_VALUE) + (bArr2[i3] & UByte.MAX_VALUE));
        }
        for (int i4 = i2; i4 < i; i4++) {
            int i5 = i4 - i2;
            bArr[i4] = (byte) ((bArr[i4] & UByte.MAX_VALUE) + paethPredictor(bArr[i5] & UByte.MAX_VALUE, bArr2[i4] & UByte.MAX_VALUE, bArr2[i5] & UByte.MAX_VALUE));
        }
    }

    static class NewByteArrayOutputStream extends ByteArrayOutputStream {
        NewByteArrayOutputStream() {
        }

        public byte[] getBuf() {
            return this.buf;
        }
    }

    public static final int getInt(InputStream inputStream) throws IOException {
        return (inputStream.read() << 24) + (inputStream.read() << 16) + (inputStream.read() << 8) + inputStream.read();
    }

    public static final int getWord(InputStream inputStream) throws IOException {
        return (inputStream.read() << 8) + inputStream.read();
    }

    public static final String getString(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            stringBuffer.append((char) inputStream.read());
        }
        return stringBuffer.toString();
    }
}
