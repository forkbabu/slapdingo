package com.itextpdf.text.pdf.languages;

public class DevanagariLigaturizer extends IndicLigaturizer {
    public static final char DEVA_HALANTA = 2381;
    public static final char DEVA_LETTER_A = 2309;
    public static final char DEVA_LETTER_AU = 2324;
    public static final char DEVA_LETTER_HA = 2361;
    public static final char DEVA_LETTER_KA = 2325;
    public static final char DEVA_MATRA_AA = 2366;
    public static final char DEVA_MATRA_AI = 2376;
    public static final char DEVA_MATRA_E = 2375;
    public static final char DEVA_MATRA_HLR = 2402;
    public static final char DEVA_MATRA_HLRR = 2403;
    public static final char DEVA_MATRA_I = 2367;

    public DevanagariLigaturizer() {
        this.langTable = new char[11];
        this.langTable[0] = DEVA_MATRA_AA;
        this.langTable[1] = DEVA_MATRA_I;
        this.langTable[2] = DEVA_MATRA_E;
        this.langTable[3] = DEVA_MATRA_AI;
        this.langTable[4] = DEVA_MATRA_HLR;
        this.langTable[5] = DEVA_MATRA_HLRR;
        this.langTable[6] = DEVA_LETTER_A;
        this.langTable[7] = DEVA_LETTER_AU;
        this.langTable[8] = DEVA_LETTER_KA;
        this.langTable[9] = DEVA_LETTER_HA;
        this.langTable[10] = DEVA_HALANTA;
    }
}
