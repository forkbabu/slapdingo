package com.itextpdf.text.pdf.parser;

import androidx.exifinterface.media.ExifInterface;
import com.itextpdf.text.exceptions.UnsupportedPdfException;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.FilterHandlers;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfContentParser;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class InlineImageUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(InlineImageUtils.class.getName());
    private static final Map<PdfName, PdfName> inlineImageColorSpaceAbbreviationMap;
    private static final Map<PdfName, PdfName> inlineImageEntryAbbreviationMap;
    private static final Map<PdfName, PdfName> inlineImageFilterAbbreviationMap;

    static {
        HashMap hashMap = new HashMap();
        inlineImageEntryAbbreviationMap = hashMap;
        hashMap.put(PdfName.BITSPERCOMPONENT, PdfName.BITSPERCOMPONENT);
        inlineImageEntryAbbreviationMap.put(PdfName.COLORSPACE, PdfName.COLORSPACE);
        inlineImageEntryAbbreviationMap.put(PdfName.DECODE, PdfName.DECODE);
        inlineImageEntryAbbreviationMap.put(PdfName.DECODEPARMS, PdfName.DECODEPARMS);
        inlineImageEntryAbbreviationMap.put(PdfName.FILTER, PdfName.FILTER);
        inlineImageEntryAbbreviationMap.put(PdfName.HEIGHT, PdfName.HEIGHT);
        inlineImageEntryAbbreviationMap.put(PdfName.IMAGEMASK, PdfName.IMAGEMASK);
        inlineImageEntryAbbreviationMap.put(PdfName.INTENT, PdfName.INTENT);
        inlineImageEntryAbbreviationMap.put(PdfName.INTERPOLATE, PdfName.INTERPOLATE);
        inlineImageEntryAbbreviationMap.put(PdfName.WIDTH, PdfName.WIDTH);
        inlineImageEntryAbbreviationMap.put(new PdfName("BPC"), PdfName.BITSPERCOMPONENT);
        inlineImageEntryAbbreviationMap.put(new PdfName("CS"), PdfName.COLORSPACE);
        inlineImageEntryAbbreviationMap.put(new PdfName("D"), PdfName.DECODE);
        inlineImageEntryAbbreviationMap.put(new PdfName("DP"), PdfName.DECODEPARMS);
        inlineImageEntryAbbreviationMap.put(new PdfName("F"), PdfName.FILTER);
        inlineImageEntryAbbreviationMap.put(new PdfName("H"), PdfName.HEIGHT);
        inlineImageEntryAbbreviationMap.put(new PdfName("IM"), PdfName.IMAGEMASK);
        inlineImageEntryAbbreviationMap.put(new PdfName("I"), PdfName.INTERPOLATE);
        inlineImageEntryAbbreviationMap.put(new PdfName(ExifInterface.LONGITUDE_WEST), PdfName.WIDTH);
        HashMap hashMap2 = new HashMap();
        inlineImageColorSpaceAbbreviationMap = hashMap2;
        hashMap2.put(new PdfName("G"), PdfName.DEVICEGRAY);
        inlineImageColorSpaceAbbreviationMap.put(new PdfName("RGB"), PdfName.DEVICERGB);
        inlineImageColorSpaceAbbreviationMap.put(new PdfName("CMYK"), PdfName.DEVICECMYK);
        inlineImageColorSpaceAbbreviationMap.put(new PdfName("I"), PdfName.INDEXED);
        HashMap hashMap3 = new HashMap();
        inlineImageFilterAbbreviationMap = hashMap3;
        hashMap3.put(new PdfName("AHx"), PdfName.ASCIIHEXDECODE);
        inlineImageFilterAbbreviationMap.put(new PdfName("A85"), PdfName.ASCII85DECODE);
        inlineImageFilterAbbreviationMap.put(new PdfName("LZW"), PdfName.LZWDECODE);
        inlineImageFilterAbbreviationMap.put(new PdfName("Fl"), PdfName.FLATEDECODE);
        inlineImageFilterAbbreviationMap.put(new PdfName("RL"), PdfName.RUNLENGTHDECODE);
        inlineImageFilterAbbreviationMap.put(new PdfName("CCF"), PdfName.CCITTFAXDECODE);
        inlineImageFilterAbbreviationMap.put(new PdfName("DCT"), PdfName.DCTDECODE);
    }

    private InlineImageUtils() {
    }

    public static class InlineImageParseException extends IOException {
        private static final long serialVersionUID = 233760879000268548L;

        public InlineImageParseException(String str) {
            super(str);
        }
    }

    public static InlineImageInfo parseInlineImage(PdfContentParser pdfContentParser, PdfDictionary pdfDictionary) throws IOException {
        PdfDictionary parseInlineImageDictionary = parseInlineImageDictionary(pdfContentParser);
        return new InlineImageInfo(parseInlineImageSamples(parseInlineImageDictionary, pdfDictionary, pdfContentParser), parseInlineImageDictionary);
    }

    private static PdfDictionary parseInlineImageDictionary(PdfContentParser pdfContentParser) throws IOException {
        PdfDictionary pdfDictionary = new PdfDictionary();
        while (true) {
            PdfObject readPRObject = pdfContentParser.readPRObject();
            if (readPRObject == null || "ID".equals(readPRObject.toString())) {
                int read = pdfContentParser.getTokeniser().read();
            } else {
                PdfObject readPRObject2 = pdfContentParser.readPRObject();
                PdfName pdfName = inlineImageEntryAbbreviationMap.get(readPRObject);
                if (pdfName == null) {
                    pdfName = (PdfName) readPRObject;
                }
                pdfDictionary.put(pdfName, getAlternateValue(pdfName, readPRObject2));
            }
        }
        int read2 = pdfContentParser.getTokeniser().read();
        if (PRTokeniser.isWhitespace(read2)) {
            return pdfDictionary;
        }
        throw new IOException("Unexpected character " + read2 + " found after ID in inline image");
    }

    private static PdfObject getAlternateValue(PdfName pdfName, PdfObject pdfObject) {
        PdfName pdfName2;
        if (pdfName != PdfName.FILTER) {
            return (pdfName != PdfName.COLORSPACE || (pdfName2 = inlineImageColorSpaceAbbreviationMap.get(pdfObject)) == null) ? pdfObject : pdfName2;
        }
        if (pdfObject instanceof PdfName) {
            PdfName pdfName3 = inlineImageFilterAbbreviationMap.get(pdfObject);
            if (pdfName3 != null) {
                return pdfName3;
            }
        } else if (pdfObject instanceof PdfArray) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            PdfArray pdfArray2 = new PdfArray();
            int size = pdfArray.size();
            for (int i = 0; i < size; i++) {
                pdfArray2.add(getAlternateValue(pdfName, pdfArray.getPdfObject(i)));
            }
            return pdfArray2;
        }
    }

    private static int getComponentsPerPixel(PdfName pdfName, PdfDictionary pdfDictionary) {
        if (pdfName == null || pdfName.equals(PdfName.DEVICEGRAY)) {
            return 1;
        }
        if (pdfName.equals(PdfName.DEVICERGB)) {
            return 3;
        }
        if (pdfName.equals(PdfName.DEVICECMYK)) {
            return 4;
        }
        if (pdfDictionary != null) {
            PdfArray asArray = pdfDictionary.getAsArray(pdfName);
            if (asArray == null) {
                PdfName asName = pdfDictionary.getAsName(pdfName);
                if (asName != null) {
                    return getComponentsPerPixel(asName, pdfDictionary);
                }
            } else if (PdfName.INDEXED.equals(asArray.getAsName(0))) {
                return 1;
            }
        }
        throw new IllegalArgumentException("Unexpected color space " + pdfName);
    }

    private static int computeBytesPerRow(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.WIDTH);
        PdfNumber asNumber2 = pdfDictionary.getAsNumber(PdfName.BITSPERCOMPONENT);
        return (((asNumber.intValue() * (asNumber2 != null ? asNumber2.intValue() : 1)) * getComponentsPerPixel(pdfDictionary.getAsName(PdfName.COLORSPACE), pdfDictionary2)) + 7) / 8;
    }

    private static byte[] parseUnfilteredSamples(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfContentParser pdfContentParser) throws IOException {
        if (!pdfDictionary.contains(PdfName.FILTER)) {
            int computeBytesPerRow = computeBytesPerRow(pdfDictionary, pdfDictionary2) * pdfDictionary.getAsNumber(PdfName.HEIGHT).intValue();
            byte[] bArr = new byte[computeBytesPerRow];
            PRTokeniser tokeniser = pdfContentParser.getTokeniser();
            int read = tokeniser.read();
            int i = 0;
            if (!PRTokeniser.isWhitespace(read) || read == 0) {
                bArr[0] = (byte) read;
                i = 1;
            }
            while (i < computeBytesPerRow) {
                int read2 = tokeniser.read();
                if (read2 != -1) {
                    bArr[i] = (byte) read2;
                    i++;
                } else {
                    throw new InlineImageParseException("End of content stream reached before end of image data");
                }
            }
            if (pdfContentParser.readPRObject().toString().equals("EI") || pdfContentParser.readPRObject().toString().equals("EI")) {
                return bArr;
            }
            throw new InlineImageParseException("EI not found after end of image data");
        }
        throw new IllegalArgumentException("Dictionary contains filters");
    }

    private static byte[] parseInlineImageSamples(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfContentParser pdfContentParser) throws IOException {
        int read;
        if (!pdfDictionary.contains(PdfName.FILTER)) {
            return parseUnfilteredSamples(pdfDictionary, pdfDictionary2, pdfContentParser);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        PRTokeniser tokeniser = pdfContentParser.getTokeniser();
        while (true) {
            int i = 0;
            while (true) {
                read = tokeniser.read();
                if (read == -1) {
                    throw new InlineImageParseException("Could not find image data or EI");
                } else if (i == 0 && PRTokeniser.isWhitespace(read)) {
                    i++;
                    byteArrayOutputStream2.write(read);
                } else if (i == 1 && read == 69) {
                    i++;
                    byteArrayOutputStream2.write(read);
                } else if (i == 1 && PRTokeniser.isWhitespace(read)) {
                    byteArrayOutputStream.write(byteArrayOutputStream2.toByteArray());
                    byteArrayOutputStream2.reset();
                    byteArrayOutputStream2.write(read);
                } else if (i == 2 && read == 73) {
                    i++;
                    byteArrayOutputStream2.write(read);
                }
            }
            if (i != 3 || !PRTokeniser.isWhitespace(read)) {
                byteArrayOutputStream.write(byteArrayOutputStream2.toByteArray());
                byteArrayOutputStream2.reset();
                byteArrayOutputStream.write(read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (inlineImageStreamBytesAreComplete(byteArray, pdfDictionary)) {
                    return byteArray;
                }
                byteArrayOutputStream.write(byteArrayOutputStream2.toByteArray());
                byteArrayOutputStream2.reset();
                byteArrayOutputStream.write(read);
            }
        }
    }

    private static boolean inlineImageStreamBytesAreComplete(byte[] bArr, PdfDictionary pdfDictionary) {
        try {
            PdfReader.decodeBytes(bArr, pdfDictionary, FilterHandlers.getDefaultFilterHandlers());
            return true;
        } catch (UnsupportedPdfException e) {
            LOGGER.warn(e.getMessage());
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
