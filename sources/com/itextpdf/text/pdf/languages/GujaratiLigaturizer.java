package com.itextpdf.text.pdf.languages;

public class GujaratiLigaturizer extends IndicLigaturizer {
    public static final char GUJR_HALANTA = 2765;
    public static final char GUJR_LETTER_A = 2693;
    public static final char GUJR_LETTER_AU = 2708;
    public static final char GUJR_LETTER_HA = 2745;
    public static final char GUJR_LETTER_KA = 2709;
    public static final char GUJR_MATRA_AA = 2750;
    public static final char GUJR_MATRA_AI = 2760;
    public static final char GUJR_MATRA_E = 2759;
    public static final char GUJR_MATRA_HLR = 2786;
    public static final char GUJR_MATRA_HLRR = 2787;
    public static final char GUJR_MATRA_I = 2751;

    public GujaratiLigaturizer() {
        this.langTable = new char[11];
        this.langTable[0] = GUJR_MATRA_AA;
        this.langTable[1] = GUJR_MATRA_I;
        this.langTable[2] = GUJR_MATRA_E;
        this.langTable[3] = GUJR_MATRA_AI;
        this.langTable[4] = GUJR_MATRA_HLR;
        this.langTable[5] = GUJR_MATRA_HLRR;
        this.langTable[6] = GUJR_LETTER_A;
        this.langTable[7] = GUJR_LETTER_AU;
        this.langTable[8] = GUJR_LETTER_KA;
        this.langTable[9] = GUJR_LETTER_HA;
        this.langTable[10] = GUJR_HALANTA;
    }
}
