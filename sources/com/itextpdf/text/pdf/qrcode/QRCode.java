package com.itextpdf.text.pdf.qrcode;

public final class QRCode {
    public static final int NUM_MASK_PATTERNS = 8;
    private ErrorCorrectionLevel ecLevel = null;
    private int maskPattern = -1;
    private ByteMatrix matrix = null;
    private int matrixWidth = -1;
    private Mode mode = null;
    private int numDataBytes = -1;
    private int numECBytes = -1;
    private int numRSBlocks = -1;
    private int numTotalBytes = -1;
    private int version = -1;

    public static boolean isValidMaskPattern(int i) {
        return i >= 0 && i < 8;
    }

    public Mode getMode() {
        return this.mode;
    }

    public ErrorCorrectionLevel getECLevel() {
        return this.ecLevel;
    }

    public int getVersion() {
        return this.version;
    }

    public int getMatrixWidth() {
        return this.matrixWidth;
    }

    public int getMaskPattern() {
        return this.maskPattern;
    }

    public int getNumTotalBytes() {
        return this.numTotalBytes;
    }

    public int getNumDataBytes() {
        return this.numDataBytes;
    }

    public int getNumECBytes() {
        return this.numECBytes;
    }

    public int getNumRSBlocks() {
        return this.numRSBlocks;
    }

    public ByteMatrix getMatrix() {
        return this.matrix;
    }

    public int at(int i, int i2) {
        byte b = this.matrix.get(i, i2);
        if (b == 0 || b == 1) {
            return b;
        }
        throw new RuntimeException("Bad value");
    }

    public boolean isValid() {
        int i;
        ByteMatrix byteMatrix;
        return (this.mode == null || this.ecLevel == null || this.version == -1 || this.matrixWidth == -1 || (i = this.maskPattern) == -1 || this.numTotalBytes == -1 || this.numDataBytes == -1 || this.numECBytes == -1 || this.numRSBlocks == -1 || !isValidMaskPattern(i) || this.numTotalBytes != this.numDataBytes + this.numECBytes || (byteMatrix = this.matrix) == null || this.matrixWidth != byteMatrix.getWidth() || this.matrix.getWidth() != this.matrix.getHeight()) ? false : true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("<<\n");
        stringBuffer.append(" mode: ");
        stringBuffer.append(this.mode);
        stringBuffer.append("\n ecLevel: ");
        stringBuffer.append(this.ecLevel);
        stringBuffer.append("\n version: ");
        stringBuffer.append(this.version);
        stringBuffer.append("\n matrixWidth: ");
        stringBuffer.append(this.matrixWidth);
        stringBuffer.append("\n maskPattern: ");
        stringBuffer.append(this.maskPattern);
        stringBuffer.append("\n numTotalBytes: ");
        stringBuffer.append(this.numTotalBytes);
        stringBuffer.append("\n numDataBytes: ");
        stringBuffer.append(this.numDataBytes);
        stringBuffer.append("\n numECBytes: ");
        stringBuffer.append(this.numECBytes);
        stringBuffer.append("\n numRSBlocks: ");
        stringBuffer.append(this.numRSBlocks);
        if (this.matrix == null) {
            stringBuffer.append("\n matrix: null\n");
        } else {
            stringBuffer.append("\n matrix:\n");
            stringBuffer.append(this.matrix.toString());
        }
        stringBuffer.append(">>\n");
        return stringBuffer.toString();
    }

    public void setMode(Mode mode2) {
        this.mode = mode2;
    }

    public void setECLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        this.ecLevel = errorCorrectionLevel;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public void setMatrixWidth(int i) {
        this.matrixWidth = i;
    }

    public void setMaskPattern(int i) {
        this.maskPattern = i;
    }

    public void setNumTotalBytes(int i) {
        this.numTotalBytes = i;
    }

    public void setNumDataBytes(int i) {
        this.numDataBytes = i;
    }

    public void setNumECBytes(int i) {
        this.numECBytes = i;
    }

    public void setNumRSBlocks(int i) {
        this.numRSBlocks = i;
    }

    public void setMatrix(ByteMatrix byteMatrix) {
        this.matrix = byteMatrix;
    }
}
