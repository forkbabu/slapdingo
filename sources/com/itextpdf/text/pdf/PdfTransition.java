package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.codec.TIFFConstants;
import org.spongycastle.crypto.tls.CipherSuite;

public class PdfTransition {
    public static final int BLINDH = 6;
    public static final int BLINDV = 5;
    public static final int BTWIPE = 11;
    public static final int DGLITTER = 16;
    public static final int DISSOLVE = 13;
    public static final int INBOX = 7;
    public static final int LRGLITTER = 14;
    public static final int LRWIPE = 9;
    public static final int OUTBOX = 8;
    public static final int RLWIPE = 10;
    public static final int SPLITHIN = 4;
    public static final int SPLITHOUT = 2;
    public static final int SPLITVIN = 3;
    public static final int SPLITVOUT = 1;
    public static final int TBGLITTER = 15;
    public static final int TBWIPE = 12;
    protected int duration;
    protected int type;

    public PdfTransition() {
        this(6);
    }

    public PdfTransition(int i) {
        this(i, 1);
    }

    public PdfTransition(int i, int i2) {
        this.duration = i2;
        this.type = i;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getType() {
        return this.type;
    }

    public PdfDictionary getTransitionDictionary() {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.TRANS);
        switch (this.type) {
            case 1:
                pdfDictionary.put(PdfName.S, PdfName.SPLIT);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.DM, PdfName.V);
                pdfDictionary.put(PdfName.M, PdfName.O);
                break;
            case 2:
                pdfDictionary.put(PdfName.S, PdfName.SPLIT);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.DM, PdfName.H);
                pdfDictionary.put(PdfName.M, PdfName.O);
                break;
            case 3:
                pdfDictionary.put(PdfName.S, PdfName.SPLIT);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.DM, PdfName.V);
                pdfDictionary.put(PdfName.M, PdfName.I);
                break;
            case 4:
                pdfDictionary.put(PdfName.S, PdfName.SPLIT);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.DM, PdfName.H);
                pdfDictionary.put(PdfName.M, PdfName.I);
                break;
            case 5:
                pdfDictionary.put(PdfName.S, PdfName.BLINDS);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.DM, PdfName.V);
                break;
            case 6:
                pdfDictionary.put(PdfName.S, PdfName.BLINDS);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.DM, PdfName.H);
                break;
            case 7:
                pdfDictionary.put(PdfName.S, PdfName.BOX);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.M, PdfName.I);
                break;
            case 8:
                pdfDictionary.put(PdfName.S, PdfName.BOX);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.M, PdfName.O);
                break;
            case 9:
                pdfDictionary.put(PdfName.S, PdfName.WIPE);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.DI, new PdfNumber(0));
                break;
            case 10:
                pdfDictionary.put(PdfName.S, PdfName.WIPE);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.DI, new PdfNumber((int) CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256));
                break;
            case 11:
                pdfDictionary.put(PdfName.S, PdfName.WIPE);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.DI, new PdfNumber(90));
                break;
            case 12:
                pdfDictionary.put(PdfName.S, PdfName.WIPE);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.DI, new PdfNumber((int) TIFFConstants.TIFFTAG_IMAGEDESCRIPTION));
                break;
            case 13:
                pdfDictionary.put(PdfName.S, PdfName.DISSOLVE);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                break;
            case 14:
                pdfDictionary.put(PdfName.S, PdfName.GLITTER);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.DI, new PdfNumber(0));
                break;
            case 15:
                pdfDictionary.put(PdfName.S, PdfName.GLITTER);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.DI, new PdfNumber((int) TIFFConstants.TIFFTAG_IMAGEDESCRIPTION));
                break;
            case 16:
                pdfDictionary.put(PdfName.S, PdfName.GLITTER);
                pdfDictionary.put(PdfName.D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.DI, new PdfNumber((int) TIFFConstants.TIFFTAG_ARTIST));
                break;
        }
        return pdfDictionary;
    }
}
