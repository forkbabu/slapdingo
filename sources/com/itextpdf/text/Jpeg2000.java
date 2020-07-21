package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class Jpeg2000 extends Image {
    public static final int JP2_BPCC = 1651532643;
    public static final int JP2_COLR = 1668246642;
    public static final int JP2_DBTL = 1685348972;
    public static final int JP2_FTYP = 1718909296;
    public static final int JP2_IHDR = 1768449138;
    public static final int JP2_JP = 1783636000;
    public static final int JP2_JP2 = 1785737760;
    public static final int JP2_JP2C = 1785737827;
    public static final int JP2_JP2H = 1785737832;
    public static final int JP2_URL = 1970433056;
    public static final int JPIP_JPIP = 1785751920;
    int boxLength;
    int boxType;
    byte[] bpcBoxData;
    ArrayList<ColorSpecBox> colorSpecBoxes;
    InputStream inp;
    boolean isJp2;
    int numOfComps;

    Jpeg2000(Image image) {
        super(image);
        this.colorSpecBoxes = null;
        this.isJp2 = false;
        if (image instanceof Jpeg2000) {
            Jpeg2000 jpeg2000 = (Jpeg2000) image;
            this.numOfComps = jpeg2000.numOfComps;
            if (0 != 0) {
                this.colorSpecBoxes = (ArrayList) jpeg2000.colorSpecBoxes.clone();
            }
            this.isJp2 = jpeg2000.isJp2;
            if (this.bpcBoxData != null) {
                this.bpcBoxData = (byte[]) jpeg2000.bpcBoxData.clone();
            }
        }
    }

    public Jpeg2000(URL url) throws BadElementException, IOException {
        super(url);
        this.colorSpecBoxes = null;
        this.isJp2 = false;
        processParameters();
    }

    public Jpeg2000(byte[] bArr) throws BadElementException, IOException {
        super((URL) null);
        this.colorSpecBoxes = null;
        this.isJp2 = false;
        this.rawData = bArr;
        this.originalData = bArr;
        processParameters();
    }

    public Jpeg2000(byte[] bArr, float f, float f2) throws BadElementException, IOException {
        this(bArr);
        this.scaledWidth = f;
        this.scaledHeight = f2;
    }

    private int cio_read(int i) throws IOException {
        int i2 = 0;
        for (int i3 = i - 1; i3 >= 0; i3--) {
            i2 += this.inp.read() << (i3 << 3);
        }
        return i2;
    }

    public void jp2_read_boxhdr() throws IOException {
        this.boxLength = cio_read(4);
        this.boxType = cio_read(4);
        int i = this.boxLength;
        if (i == 1) {
            if (cio_read(4) == 0) {
                int cio_read = cio_read(4);
                this.boxLength = cio_read;
                if (cio_read == 0) {
                    throw new IOException(MessageLocalization.getComposedMessage("unsupported.box.size.eq.eq.0", new Object[0]));
                }
                return;
            }
            throw new IOException(MessageLocalization.getComposedMessage("cannot.handle.box.sizes.higher.than.2.32", new Object[0]));
        } else if (i == 0) {
            throw new ZeroBoxSizeException(MessageLocalization.getComposedMessage("unsupported.box.size.eq.eq.0", new Object[0]));
        }
    }

    /* JADX INFO: finally extract failed */
    private void processParameters() throws IOException {
        this.type = 33;
        this.originalType = 8;
        this.inp = null;
        try {
            if (this.rawData == null) {
                this.inp = this.url.openStream();
            } else {
                this.inp = new ByteArrayInputStream(this.rawData);
            }
            int cio_read = cio_read(4);
            this.boxLength = cio_read;
            if (cio_read == 12) {
                this.isJp2 = true;
                int cio_read2 = cio_read(4);
                this.boxType = cio_read2;
                if (1783636000 != cio_read2) {
                    throw new IOException(MessageLocalization.getComposedMessage("expected.jp.marker", new Object[0]));
                } else if (218793738 == cio_read(4)) {
                    jp2_read_boxhdr();
                    if (1718909296 == this.boxType) {
                        Utilities.skip(this.inp, this.boxLength - 8);
                        jp2_read_boxhdr();
                        do {
                            if (1785737832 != this.boxType) {
                                if (this.boxType != 1785737827) {
                                    Utilities.skip(this.inp, this.boxLength - 8);
                                    jp2_read_boxhdr();
                                } else {
                                    throw new IOException(MessageLocalization.getComposedMessage("expected.jp2h.marker", new Object[0]));
                                }
                            }
                        } while (1785737832 != this.boxType);
                        jp2_read_boxhdr();
                        if (1768449138 == this.boxType) {
                            this.scaledHeight = (float) cio_read(4);
                            setTop(this.scaledHeight);
                            this.scaledWidth = (float) cio_read(4);
                            setRight(this.scaledWidth);
                            this.numOfComps = cio_read(2);
                            this.bpc = -1;
                            this.bpc = cio_read(1);
                            Utilities.skip(this.inp, 3);
                            jp2_read_boxhdr();
                            if (this.boxType == 1651532643) {
                                byte[] bArr = new byte[(this.boxLength - 8)];
                                this.bpcBoxData = bArr;
                                this.inp.read(bArr, 0, this.boxLength - 8);
                            } else if (this.boxType == 1668246642) {
                                do {
                                    if (this.colorSpecBoxes == null) {
                                        this.colorSpecBoxes = new ArrayList<>();
                                    }
                                    this.colorSpecBoxes.add(jp2_read_colr());
                                    try {
                                        jp2_read_boxhdr();
                                    } catch (ZeroBoxSizeException unused) {
                                    }
                                } while (1668246642 == this.boxType);
                            }
                        } else {
                            throw new IOException(MessageLocalization.getComposedMessage("expected.ihdr.marker", new Object[0]));
                        }
                    } else {
                        throw new IOException(MessageLocalization.getComposedMessage("expected.ftyp.marker", new Object[0]));
                    }
                } else {
                    throw new IOException(MessageLocalization.getComposedMessage("error.with.jp.marker", new Object[0]));
                }
            } else if (cio_read == -11534511) {
                Utilities.skip(this.inp, 4);
                int cio_read3 = cio_read(4);
                int cio_read4 = cio_read(4);
                int cio_read5 = cio_read(4);
                int cio_read6 = cio_read(4);
                Utilities.skip(this.inp, 16);
                this.colorspace = cio_read(2);
                this.bpc = 8;
                this.scaledHeight = (float) (cio_read4 - cio_read6);
                setTop(this.scaledHeight);
                this.scaledWidth = (float) (cio_read3 - cio_read5);
                setRight(this.scaledWidth);
            } else {
                throw new IOException(MessageLocalization.getComposedMessage("not.a.valid.jpeg2000.file", new Object[0]));
            }
            InputStream inputStream = this.inp;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
                this.inp = null;
            }
            this.plainWidth = getWidth();
            this.plainHeight = getHeight();
        } catch (Throwable th) {
            InputStream inputStream2 = this.inp;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception unused3) {
                }
                this.inp = null;
            }
            throw th;
        }
    }

    private ColorSpecBox jp2_read_colr() throws IOException {
        ColorSpecBox colorSpecBox = new ColorSpecBox();
        int i = 8;
        for (int i2 = 0; i2 < 3; i2++) {
            colorSpecBox.add(Integer.valueOf(cio_read(1)));
            i++;
        }
        if (colorSpecBox.getMeth() == 1) {
            colorSpecBox.add(Integer.valueOf(cio_read(4)));
            i += 4;
        } else {
            colorSpecBox.add(0);
        }
        int i3 = this.boxLength;
        if (i3 - i > 0) {
            byte[] bArr = new byte[(i3 - i)];
            this.inp.read(bArr, 0, i3 - i);
            colorSpecBox.setColorProfile(bArr);
        }
        return colorSpecBox;
    }

    public int getNumOfComps() {
        return this.numOfComps;
    }

    public byte[] getBpcBoxData() {
        return this.bpcBoxData;
    }

    public ArrayList<ColorSpecBox> getColorSpecBoxes() {
        return this.colorSpecBoxes;
    }

    public boolean isJp2() {
        return this.isJp2;
    }

    public static class ColorSpecBox extends ArrayList<Integer> {
        private byte[] colorProfile;

        public int getMeth() {
            return ((Integer) get(0)).intValue();
        }

        public int getPrec() {
            return ((Integer) get(1)).intValue();
        }

        public int getApprox() {
            return ((Integer) get(2)).intValue();
        }

        public int getEnumCs() {
            return ((Integer) get(3)).intValue();
        }

        public byte[] getColorProfile() {
            return this.colorProfile;
        }

        /* access modifiers changed from: package-private */
        public void setColorProfile(byte[] bArr) {
            this.colorProfile = bArr;
        }
    }

    private class ZeroBoxSizeException extends IOException {
        public ZeroBoxSizeException() {
        }

        public ZeroBoxSizeException(String str) {
            super(str);
        }
    }
}
