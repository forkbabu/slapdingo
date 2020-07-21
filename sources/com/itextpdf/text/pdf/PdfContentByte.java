package com.itextpdf.text.pdf;

import androidx.exifinterface.media.ExifInterface;
import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.IllegalPdfSyntaxException;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.spongycastle.crypto.tls.CipherSuite;

public class PdfContentByte {
    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_RIGHT = 2;
    public static final int LINE_CAP_BUTT = 0;
    public static final int LINE_CAP_PROJECTING_SQUARE = 2;
    public static final int LINE_CAP_ROUND = 1;
    public static final int LINE_JOIN_BEVEL = 2;
    public static final int LINE_JOIN_MITER = 0;
    public static final int LINE_JOIN_ROUND = 1;
    public static final int TEXT_RENDER_MODE_CLIP = 7;
    public static final int TEXT_RENDER_MODE_FILL = 0;
    public static final int TEXT_RENDER_MODE_FILL_CLIP = 4;
    public static final int TEXT_RENDER_MODE_FILL_STROKE = 2;
    public static final int TEXT_RENDER_MODE_FILL_STROKE_CLIP = 6;
    public static final int TEXT_RENDER_MODE_INVISIBLE = 3;
    public static final int TEXT_RENDER_MODE_STROKE = 1;
    public static final int TEXT_RENDER_MODE_STROKE_CLIP = 5;
    private static HashMap<PdfName, String> abrev;
    private static final float[] unitRect = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    protected ByteBuffer content = new ByteBuffer();
    protected PdfContentByte duplicatedFrom = null;
    private boolean inText = false;
    protected ArrayList<Integer> layerDepth;
    protected int markedContentSize = 0;
    private int mcDepth = 0;
    private ArrayList<IAccessibleElement> mcElements = new ArrayList<>();
    protected PdfDocument pdf;
    protected int separator = 10;
    protected GraphicState state = new GraphicState();
    protected ArrayList<GraphicState> stateList = new ArrayList<>();
    private boolean suppressTagging = false;
    protected PdfWriter writer;

    public static class GraphicState {
        protected AffineTransform CTM = new AffineTransform();
        protected float aTLM = 1.0f;
        protected float bTLM = 0.0f;
        protected float cTLM = 0.0f;
        protected float charSpace = 0.0f;
        ColorDetails colorDetails;
        protected BaseColor colorFill = new GrayColor(0);
        protected BaseColor colorStroke = new GrayColor(0);
        protected float dTLM = 1.0f;
        protected PdfObject extGState = null;
        FontDetails fontDetails;
        protected float leading = 0.0f;
        protected float scale = 100.0f;
        float size;
        protected int textRenderMode = 0;
        protected float tx = 0.0f;
        protected float wordSpace = 0.0f;
        protected float xTLM = 0.0f;
        protected float yTLM = 0.0f;

        GraphicState() {
        }

        GraphicState(GraphicState graphicState) {
            copyParameters(graphicState);
        }

        /* access modifiers changed from: package-private */
        public void copyParameters(GraphicState graphicState) {
            this.fontDetails = graphicState.fontDetails;
            this.colorDetails = graphicState.colorDetails;
            this.size = graphicState.size;
            this.xTLM = graphicState.xTLM;
            this.yTLM = graphicState.yTLM;
            this.aTLM = graphicState.aTLM;
            this.bTLM = graphicState.bTLM;
            this.cTLM = graphicState.cTLM;
            this.dTLM = graphicState.dTLM;
            this.tx = graphicState.tx;
            this.leading = graphicState.leading;
            this.scale = graphicState.scale;
            this.charSpace = graphicState.charSpace;
            this.wordSpace = graphicState.wordSpace;
            this.colorFill = graphicState.colorFill;
            this.colorStroke = graphicState.colorStroke;
            this.CTM = new AffineTransform(graphicState.CTM);
            this.textRenderMode = graphicState.textRenderMode;
            this.extGState = graphicState.extGState;
        }

        /* access modifiers changed from: package-private */
        public void restore(GraphicState graphicState) {
            copyParameters(graphicState);
        }
    }

    static {
        HashMap<PdfName, String> hashMap = new HashMap<>();
        abrev = hashMap;
        hashMap.put(PdfName.BITSPERCOMPONENT, "/BPC ");
        abrev.put(PdfName.COLORSPACE, "/CS ");
        abrev.put(PdfName.DECODE, "/D ");
        abrev.put(PdfName.DECODEPARMS, "/DP ");
        abrev.put(PdfName.FILTER, "/F ");
        abrev.put(PdfName.HEIGHT, "/H ");
        abrev.put(PdfName.IMAGEMASK, "/IM ");
        abrev.put(PdfName.INTENT, "/Intent ");
        abrev.put(PdfName.INTERPOLATE, "/I ");
        abrev.put(PdfName.WIDTH, "/W ");
    }

    public PdfContentByte(PdfWriter pdfWriter) {
        if (pdfWriter != null) {
            this.writer = pdfWriter;
            this.pdf = pdfWriter.getPdfDocument();
        }
    }

    public String toString() {
        return this.content.toString();
    }

    public boolean isTaggingSuppressed() {
        return this.suppressTagging;
    }

    public PdfContentByte setSuppressTagging(boolean z) {
        this.suppressTagging = z;
        return this;
    }

    public boolean isTagged() {
        PdfWriter pdfWriter = this.writer;
        return pdfWriter != null && pdfWriter.isTagged() && !isTaggingSuppressed();
    }

    public ByteBuffer getInternalBuffer() {
        return this.content;
    }

    public byte[] toPdf(PdfWriter pdfWriter) {
        sanityCheck();
        return this.content.toByteArray();
    }

    public void add(PdfContentByte pdfContentByte) {
        PdfWriter pdfWriter = pdfContentByte.writer;
        if (pdfWriter == null || this.writer == pdfWriter) {
            this.content.append(pdfContentByte.content);
            this.markedContentSize += pdfContentByte.markedContentSize;
            return;
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("inconsistent.writers.are.you.mixing.two.documents", new Object[0]));
    }

    public float getXTLM() {
        return this.state.xTLM;
    }

    public float getYTLM() {
        return this.state.yTLM;
    }

    public float getLeading() {
        return this.state.leading;
    }

    public float getCharacterSpacing() {
        return this.state.charSpace;
    }

    public float getWordSpacing() {
        return this.state.wordSpace;
    }

    public float getHorizontalScaling() {
        return this.state.scale;
    }

    public void setFlatness(float f) {
        setFlatness((double) f);
    }

    public void setFlatness(double d) {
        if (d >= 0.0d && d <= 100.0d) {
            this.content.append(d).append(" i").append_i(this.separator);
        }
    }

    public void setLineCap(int i) {
        if (i >= 0 && i <= 2) {
            this.content.append(i).append(" J").append_i(this.separator);
        }
    }

    public void setRenderingIntent(PdfName pdfName) {
        this.content.append(pdfName.getBytes()).append(" ri").append_i(this.separator);
    }

    public void setLineDash(float f) {
        setLineDash((double) f);
    }

    public void setLineDash(double d) {
        this.content.append("[] ").append(d).append(" d").append_i(this.separator);
    }

    public void setLineDash(float f, float f2) {
        setLineDash((double) f, (double) f2);
    }

    public void setLineDash(double d, double d2) {
        this.content.append("[").append(d).append("] ").append(d2).append(" d").append_i(this.separator);
    }

    public void setLineDash(float f, float f2, float f3) {
        setLineDash((double) f, (double) f2, (double) f3);
    }

    public void setLineDash(double d, double d2, double d3) {
        this.content.append("[").append(d).append(' ').append(d2).append("] ").append(d3).append(" d").append_i(this.separator);
    }

    public final void setLineDash(float[] fArr, float f) {
        this.content.append("[");
        for (int i = 0; i < fArr.length; i++) {
            this.content.append(fArr[i]);
            if (i < fArr.length - 1) {
                this.content.append(' ');
            }
        }
        this.content.append("] ").append(f).append(" d").append_i(this.separator);
    }

    public final void setLineDash(double[] dArr, double d) {
        this.content.append("[");
        for (int i = 0; i < dArr.length; i++) {
            this.content.append(dArr[i]);
            if (i < dArr.length - 1) {
                this.content.append(' ');
            }
        }
        this.content.append("] ").append(d).append(" d").append_i(this.separator);
    }

    public void setLineJoin(int i) {
        if (i >= 0 && i <= 2) {
            this.content.append(i).append(" j").append_i(this.separator);
        }
    }

    public void setLineWidth(float f) {
        setLineWidth((double) f);
    }

    public void setLineWidth(double d) {
        this.content.append(d).append(" w").append_i(this.separator);
    }

    public void setMiterLimit(float f) {
        setMiterLimit((double) f);
    }

    public void setMiterLimit(double d) {
        if (d > 1.0d) {
            this.content.append(d).append(" M").append_i(this.separator);
        }
    }

    public void clip() {
        if (this.inText && isTagged()) {
            endText();
        }
        this.content.append(ExifInterface.LONGITUDE_WEST).append_i(this.separator);
    }

    public void eoClip() {
        if (this.inText && isTagged()) {
            endText();
        }
        this.content.append("W*").append_i(this.separator);
    }

    public void setGrayFill(float f) {
        saveColor(new GrayColor(f), true);
        this.content.append(f).append(" g").append_i(this.separator);
    }

    public void resetGrayFill() {
        saveColor(new GrayColor(0), true);
        this.content.append("0 g").append_i(this.separator);
    }

    public void setGrayStroke(float f) {
        saveColor(new GrayColor(f), false);
        this.content.append(f).append(" G").append_i(this.separator);
    }

    public void resetGrayStroke() {
        saveColor(new GrayColor(0), false);
        this.content.append("0 G").append_i(this.separator);
    }

    private void HelperRGB(float f, float f2, float f3) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        this.content.append(f).append(' ').append(f2).append(' ').append(f3);
    }

    public void setRGBColorFillF(float f, float f2, float f3) {
        saveColor(new BaseColor(f, f2, f3), true);
        HelperRGB(f, f2, f3);
        this.content.append(" rg").append_i(this.separator);
    }

    public void resetRGBColorFill() {
        resetGrayFill();
    }

    public void setRGBColorStrokeF(float f, float f2, float f3) {
        saveColor(new BaseColor(f, f2, f3), false);
        HelperRGB(f, f2, f3);
        this.content.append(" RG").append_i(this.separator);
    }

    public void resetRGBColorStroke() {
        resetGrayStroke();
    }

    private void HelperCMYK(float f, float f2, float f3, float f4) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        if (f4 < 0.0f) {
            f4 = 0.0f;
        } else if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        this.content.append(f).append(' ').append(f2).append(' ').append(f3).append(' ').append(f4);
    }

    public void setCMYKColorFillF(float f, float f2, float f3, float f4) {
        saveColor(new CMYKColor(f, f2, f3, f4), true);
        HelperCMYK(f, f2, f3, f4);
        this.content.append(" k").append_i(this.separator);
    }

    public void resetCMYKColorFill() {
        saveColor(new CMYKColor(0, 0, 0, 1), true);
        this.content.append("0 0 0 1 k").append_i(this.separator);
    }

    public void setCMYKColorStrokeF(float f, float f2, float f3, float f4) {
        saveColor(new CMYKColor(f, f2, f3, f4), false);
        HelperCMYK(f, f2, f3, f4);
        this.content.append(" K").append_i(this.separator);
    }

    public void resetCMYKColorStroke() {
        saveColor(new CMYKColor(0, 0, 0, 1), false);
        this.content.append("0 0 0 1 K").append_i(this.separator);
    }

    public void moveTo(float f, float f2) {
        moveTo((double) f, (double) f2);
    }

    public void moveTo(double d, double d2) {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.content.append(d).append(' ').append(d2).append(" m").append_i(this.separator);
    }

    public void lineTo(float f, float f2) {
        lineTo((double) f, (double) f2);
    }

    public void lineTo(double d, double d2) {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.content.append(d).append(' ').append(d2).append(" l").append_i(this.separator);
    }

    public void curveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        curveTo((double) f, (double) f2, (double) f3, (double) f4, (double) f5, (double) f6);
    }

    public void curveTo(double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.content.append(d).append(' ').append(d2).append(' ').append(d3).append(' ').append(d4).append(' ').append(d5).append(' ').append(d6).append(" c").append_i(this.separator);
    }

    public void curveTo(float f, float f2, float f3, float f4) {
        curveTo((double) f, (double) f2, (double) f3, (double) f4);
    }

    public void curveTo(double d, double d2, double d3, double d4) {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.content.append(d).append(' ').append(d2).append(' ').append(d3).append(' ').append(d4).append(" v").append_i(this.separator);
    }

    public void curveFromTo(float f, float f2, float f3, float f4) {
        curveFromTo((double) f, (double) f2, (double) f3, (double) f4);
    }

    public void curveFromTo(double d, double d2, double d3, double d4) {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.content.append(d).append(' ').append(d2).append(' ').append(d3).append(' ').append(d4).append(" y").append_i(this.separator);
    }

    public void circle(float f, float f2, float f3) {
        circle((double) f, (double) f2, (double) f3);
    }

    public void circle(double d, double d2, double d3) {
        double d4 = d + d3;
        moveTo(d4, d2);
        double d5 = d3 * ((double) 0.5523f);
        double d6 = d2 + d5;
        double d7 = d + d5;
        double d8 = d2 + d3;
        curveTo(d4, d6, d7, d8, d, d8);
        double d9 = d - d5;
        double d10 = d - d3;
        curveTo(d9, d8, d10, d6, d10, d2);
        double d11 = d2 - d5;
        double d12 = d2 - d3;
        curveTo(d10, d11, d9, d12, d, d12);
        curveTo(d7, d12, d4, d11, d4, d2);
    }

    public void rectangle(float f, float f2, float f3, float f4) {
        rectangle((double) f, (double) f2, (double) f3, (double) f4);
    }

    public void rectangle(double d, double d2, double d3, double d4) {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.content.append(d).append(' ').append(d2).append(' ').append(d3).append(' ').append(d4).append(" re").append_i(this.separator);
    }

    private boolean compareColors(BaseColor baseColor, BaseColor baseColor2) {
        if (baseColor == null && baseColor2 == null) {
            return true;
        }
        if (baseColor == null || baseColor2 == null) {
            return false;
        }
        if (baseColor instanceof ExtendedColor) {
            return baseColor.equals(baseColor2);
        }
        return baseColor2.equals(baseColor);
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void variableRectangle(com.itextpdf.text.Rectangle r25) {
        /*
            r24 = this;
            r0 = r24
            float r1 = r25.getTop()
            float r2 = r25.getBottom()
            float r3 = r25.getRight()
            float r4 = r25.getLeft()
            float r5 = r25.getBorderWidthTop()
            float r6 = r25.getBorderWidthBottom()
            float r7 = r25.getBorderWidthRight()
            float r8 = r25.getBorderWidthLeft()
            com.itextpdf.text.BaseColor r9 = r25.getBorderColorTop()
            com.itextpdf.text.BaseColor r10 = r25.getBorderColorBottom()
            com.itextpdf.text.BaseColor r11 = r25.getBorderColorRight()
            com.itextpdf.text.BaseColor r12 = r25.getBorderColorLeft()
            r24.saveState()
            r13 = 0
            r0.setLineCap(r13)
            r0.setLineJoin(r13)
            r15 = 1073741824(0x40000000, float:2.0)
            r16 = 1
            r17 = 0
            int r18 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r18 <= 0) goto L_0x0064
            r0.setLineWidth(r5)
            if (r9 != 0) goto L_0x004f
            r24.resetRGBColorStroke()
            goto L_0x0052
        L_0x004f:
            r0.setColorStroke(r9)
        L_0x0052:
            float r18 = r5 / r15
            float r13 = r1 - r18
            r0.moveTo(r4, r13)
            r0.lineTo(r3, r13)
            r24.stroke()
            r13 = r5
            r14 = r9
            r18 = 1
            goto L_0x0068
        L_0x0064:
            r13 = 0
            r14 = 0
            r18 = 0
        L_0x0068:
            int r19 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r19 <= 0) goto L_0x0095
            int r19 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r19 == 0) goto L_0x0074
            r0.setLineWidth(r6)
            r13 = r6
        L_0x0074:
            if (r18 == 0) goto L_0x007c
            boolean r19 = r0.compareColors(r14, r10)
            if (r19 != 0) goto L_0x0088
        L_0x007c:
            if (r10 != 0) goto L_0x0082
            r24.resetRGBColorStroke()
            goto L_0x0085
        L_0x0082:
            r0.setColorStroke(r10)
        L_0x0085:
            r14 = r10
            r18 = 1
        L_0x0088:
            float r19 = r6 / r15
            float r15 = r2 + r19
            r0.moveTo(r3, r15)
            r0.lineTo(r4, r15)
            r24.stroke()
        L_0x0095:
            int r15 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x011b
            int r15 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r15 == 0) goto L_0x00a1
            r0.setLineWidth(r7)
            r13 = r7
        L_0x00a1:
            if (r18 == 0) goto L_0x00a9
            boolean r15 = r0.compareColors(r14, r11)
            if (r15 != 0) goto L_0x00b5
        L_0x00a9:
            if (r11 != 0) goto L_0x00af
            r24.resetRGBColorStroke()
            goto L_0x00b2
        L_0x00af:
            r0.setColorStroke(r11)
        L_0x00b2:
            r14 = r11
            r18 = 1
        L_0x00b5:
            boolean r15 = r0.compareColors(r9, r11)
            boolean r19 = r0.compareColors(r10, r11)
            r20 = 1073741824(0x40000000, float:2.0)
            float r21 = r7 / r20
            r22 = r13
            float r13 = r3 - r21
            if (r15 == 0) goto L_0x00cb
            r23 = r14
            r14 = r1
            goto L_0x00d1
        L_0x00cb:
            float r21 = r1 - r5
            r23 = r14
            r14 = r21
        L_0x00d1:
            r0.moveTo(r13, r14)
            if (r19 == 0) goto L_0x00d8
            r14 = r2
            goto L_0x00da
        L_0x00d8:
            float r14 = r2 + r6
        L_0x00da:
            r0.lineTo(r13, r14)
            r24.stroke()
            if (r15 == 0) goto L_0x00ea
            if (r19 != 0) goto L_0x00e5
            goto L_0x00ea
        L_0x00e5:
            r13 = r22
            r14 = r23
            goto L_0x011b
        L_0x00ea:
            if (r11 != 0) goto L_0x00f0
            r24.resetRGBColorFill()
            goto L_0x00f3
        L_0x00f0:
            r0.setColorFill(r11)
        L_0x00f3:
            if (r15 != 0) goto L_0x0105
            r0.moveTo(r3, r1)
            float r13 = r1 - r5
            r0.lineTo(r3, r13)
            float r14 = r3 - r7
            r0.lineTo(r14, r13)
            r24.fill()
        L_0x0105:
            if (r19 != 0) goto L_0x0116
            r0.moveTo(r3, r2)
            float r13 = r2 + r6
            r0.lineTo(r3, r13)
            float r3 = r3 - r7
            r0.lineTo(r3, r13)
            r24.fill()
        L_0x0116:
            r13 = r22
            r14 = r23
            goto L_0x011e
        L_0x011b:
            r11 = 0
            r16 = 0
        L_0x011e:
            int r3 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r3 <= 0) goto L_0x0192
            int r3 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x0129
            r0.setLineWidth(r8)
        L_0x0129:
            if (r18 == 0) goto L_0x0131
            boolean r3 = r0.compareColors(r14, r12)
            if (r3 != 0) goto L_0x013a
        L_0x0131:
            if (r12 != 0) goto L_0x0137
            r24.resetRGBColorStroke()
            goto L_0x013a
        L_0x0137:
            r0.setColorStroke(r12)
        L_0x013a:
            boolean r3 = r0.compareColors(r9, r12)
            boolean r7 = r0.compareColors(r10, r12)
            r9 = 1073741824(0x40000000, float:2.0)
            float r9 = r8 / r9
            float r9 = r9 + r4
            if (r3 == 0) goto L_0x014b
            r10 = r1
            goto L_0x014d
        L_0x014b:
            float r10 = r1 - r5
        L_0x014d:
            r0.moveTo(r9, r10)
            if (r7 == 0) goto L_0x0154
            r10 = r2
            goto L_0x0156
        L_0x0154:
            float r10 = r2 + r6
        L_0x0156:
            r0.lineTo(r9, r10)
            r24.stroke()
            if (r3 == 0) goto L_0x0160
            if (r7 != 0) goto L_0x0192
        L_0x0160:
            if (r16 == 0) goto L_0x0168
            boolean r9 = r0.compareColors(r11, r12)
            if (r9 != 0) goto L_0x0171
        L_0x0168:
            if (r12 != 0) goto L_0x016e
            r24.resetRGBColorFill()
            goto L_0x0171
        L_0x016e:
            r0.setColorFill(r12)
        L_0x0171:
            if (r3 != 0) goto L_0x0182
            r0.moveTo(r4, r1)
            float r1 = r1 - r5
            r0.lineTo(r4, r1)
            float r3 = r4 + r8
            r0.lineTo(r3, r1)
            r24.fill()
        L_0x0182:
            if (r7 != 0) goto L_0x0192
            r0.moveTo(r4, r2)
            float r2 = r2 + r6
            r0.lineTo(r4, r2)
            float r4 = r4 + r8
            r0.lineTo(r4, r2)
            r24.fill()
        L_0x0192:
            r24.restoreState()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfContentByte.variableRectangle(com.itextpdf.text.Rectangle):void");
    }

    public void rectangle(Rectangle rectangle) {
        float left = rectangle.getLeft();
        float bottom = rectangle.getBottom();
        float right = rectangle.getRight();
        float top = rectangle.getTop();
        BaseColor backgroundColor = rectangle.getBackgroundColor();
        if (backgroundColor != null) {
            saveState();
            setColorFill(backgroundColor);
            rectangle(left, bottom, right - left, top - bottom);
            fill();
            restoreState();
        }
        if (rectangle.hasBorders()) {
            if (rectangle.isUseVariableBorders()) {
                variableRectangle(rectangle);
                return;
            }
            if (rectangle.getBorderWidth() != -1.0f) {
                setLineWidth(rectangle.getBorderWidth());
            }
            BaseColor borderColor = rectangle.getBorderColor();
            if (borderColor != null) {
                setColorStroke(borderColor);
            }
            if (rectangle.hasBorder(15)) {
                rectangle(left, bottom, right - left, top - bottom);
            } else {
                if (rectangle.hasBorder(8)) {
                    moveTo(right, bottom);
                    lineTo(right, top);
                }
                if (rectangle.hasBorder(4)) {
                    moveTo(left, bottom);
                    lineTo(left, top);
                }
                if (rectangle.hasBorder(2)) {
                    moveTo(left, bottom);
                    lineTo(right, bottom);
                }
                if (rectangle.hasBorder(1)) {
                    moveTo(left, top);
                    lineTo(right, top);
                }
            }
            stroke();
            if (borderColor != null) {
                resetRGBColorStroke();
            }
        }
    }

    public void closePath() {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.content.append("h").append_i(this.separator);
    }

    public void newPath() {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.content.append("n").append_i(this.separator);
    }

    public void stroke() {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorStroke);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append(ExifInterface.LATITUDE_SOUTH).append_i(this.separator);
    }

    public void closePathStroke() {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorStroke);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append(HtmlTags.S).append_i(this.separator);
    }

    public void fill() {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorFill);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append("f").append_i(this.separator);
    }

    public void eoFill() {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorFill);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append("f*").append_i(this.separator);
    }

    public void fillStroke() {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorFill);
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorStroke);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append("B").append_i(this.separator);
    }

    public void closePathFillStroke() {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorFill);
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorStroke);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append(HtmlTags.B).append_i(this.separator);
    }

    public void eoFillStroke() {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorFill);
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorStroke);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append("B*").append_i(this.separator);
    }

    public void closePathEoFillStroke() {
        if (this.inText) {
            if (isTagged()) {
                endText();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorFill);
        PdfWriter.checkPdfIsoConformance(this.writer, 1, this.state.colorStroke);
        PdfWriter.checkPdfIsoConformance(this.writer, 6, this.state.extGState);
        this.content.append("b*").append_i(this.separator);
    }

    public void addImage(Image image) throws DocumentException {
        addImage(image, false);
    }

    public void addImage(Image image, boolean z) throws DocumentException {
        if (image.hasAbsoluteY()) {
            float[] matrix = image.matrix();
            matrix[4] = image.getAbsoluteX() - matrix[4];
            matrix[5] = image.getAbsoluteY() - matrix[5];
            addImage(image, matrix[0], matrix[1], matrix[2], matrix[3], matrix[4], matrix[5], z);
            return;
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("the.image.must.have.absolute.positioning", new Object[0]));
    }

    public void addImage(Image image, float f, float f2, float f3, float f4, float f5, float f6) throws DocumentException {
        addImage(image, f, f2, f3, f4, f5, f6, false);
    }

    public void addImage(Image image, double d, double d2, double d3, double d4, double d5, double d6) throws DocumentException {
        addImage(image, d, d2, d3, d4, d5, d6, false);
    }

    public void addImage(Image image, AffineTransform affineTransform) throws DocumentException {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        addImage(image, dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], false);
    }

    public void addImage(Image image, float f, float f2, float f3, float f4, float f5, float f6, boolean z) throws DocumentException {
        addImage(image, (double) f, (double) f2, (double) f3, (double) f4, (double) f5, (double) f6, z);
    }

    public void addImage(Image image, double d, double d2, double d3, double d4, double d5, double d6, boolean z) throws DocumentException {
        addImage(image, d, d2, d3, d4, d5, d6, z, false);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0383 A[Catch:{ IOException -> 0x0414 }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x038b A[Catch:{ IOException -> 0x0414 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0394 A[Catch:{ IOException -> 0x0414 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0395 A[Catch:{ IOException -> 0x0414 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0354  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addImage(com.itextpdf.text.Image r31, double r32, double r34, double r36, double r38, double r40, double r42, boolean r44, boolean r45) throws com.itextpdf.text.DocumentException {
        /*
            r30 = this;
            r15 = r30
            r13 = r31
            r11 = r32
            r9 = r34
            r7 = r36
            r5 = r38
            r3 = r40
            r0 = r42
            com.itextpdf.awt.geom.AffineTransform r29 = new com.itextpdf.awt.geom.AffineTransform     // Catch:{ IOException -> 0x0418 }
            r16 = r29
            r17 = r32
            r19 = r34
            r21 = r36
            r23 = r38
            r25 = r40
            r27 = r42
            r16.<init>(r17, r19, r21, r23, r25, r27)     // Catch:{ IOException -> 0x0418 }
            com.itextpdf.text.pdf.PdfOCG r16 = r31.getLayer()     // Catch:{ IOException -> 0x0418 }
            if (r16 == 0) goto L_0x0030
            com.itextpdf.text.pdf.PdfOCG r14 = r31.getLayer()     // Catch:{ IOException -> 0x0418 }
            r15.beginLayer(r14)     // Catch:{ IOException -> 0x0418 }
        L_0x0030:
            boolean r14 = r30.isTagged()     // Catch:{ IOException -> 0x0418 }
            if (r14 == 0) goto L_0x00f2
            boolean r14 = r15.inText     // Catch:{ IOException -> 0x0418 }
            if (r14 == 0) goto L_0x003d
            r30.endText()     // Catch:{ IOException -> 0x0418 }
        L_0x003d:
            r14 = 4
            com.itextpdf.awt.geom.Point2D$Float[] r2 = new com.itextpdf.awt.geom.Point2D.Float[r14]     // Catch:{ IOException -> 0x0418 }
            com.itextpdf.awt.geom.Point2D$Float r14 = new com.itextpdf.awt.geom.Point2D$Float     // Catch:{ IOException -> 0x0418 }
            r0 = 0
            r14.<init>(r0, r0)     // Catch:{ IOException -> 0x0418 }
            r1 = 0
            r2[r1] = r14     // Catch:{ IOException -> 0x0418 }
            com.itextpdf.awt.geom.Point2D$Float r1 = new com.itextpdf.awt.geom.Point2D$Float     // Catch:{ IOException -> 0x0418 }
            r14 = 1065353216(0x3f800000, float:1.0)
            r1.<init>(r14, r0)     // Catch:{ IOException -> 0x0418 }
            r16 = 1
            r2[r16] = r1     // Catch:{ IOException -> 0x0418 }
            com.itextpdf.awt.geom.Point2D$Float r1 = new com.itextpdf.awt.geom.Point2D$Float     // Catch:{ IOException -> 0x0418 }
            r1.<init>(r14, r14)     // Catch:{ IOException -> 0x0418 }
            r16 = 2
            r2[r16] = r1     // Catch:{ IOException -> 0x0418 }
            com.itextpdf.awt.geom.Point2D$Float r1 = new com.itextpdf.awt.geom.Point2D$Float     // Catch:{ IOException -> 0x0418 }
            r1.<init>(r0, r14)     // Catch:{ IOException -> 0x0418 }
            r0 = 3
            r2[r0] = r1     // Catch:{ IOException -> 0x0418 }
            r0 = 4
            com.itextpdf.awt.geom.Point2D$Float[] r1 = new com.itextpdf.awt.geom.Point2D.Float[r0]     // Catch:{ IOException -> 0x0418 }
            r18 = 0
            r20 = 0
            r21 = 4
            r16 = r29
            r17 = r2
            r19 = r1
            r16.transform(r17, r18, r19, r20, r21)     // Catch:{ IOException -> 0x0418 }
            r0 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r2 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r3 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r4 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r5 = 4
            r14 = 0
        L_0x0088:
            if (r14 >= r5) goto L_0x00d8
            r5 = r1[r14]     // Catch:{ IOException -> 0x0418 }
            double r5 = r5.getX()     // Catch:{ IOException -> 0x0418 }
            double r7 = (double) r3     // Catch:{ IOException -> 0x0418 }
            int r16 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r16 >= 0) goto L_0x009c
            r3 = r1[r14]     // Catch:{ IOException -> 0x0418 }
            double r5 = r3.getX()     // Catch:{ IOException -> 0x0418 }
            float r3 = (float) r5     // Catch:{ IOException -> 0x0418 }
        L_0x009c:
            r5 = r1[r14]     // Catch:{ IOException -> 0x0418 }
            double r5 = r5.getX()     // Catch:{ IOException -> 0x0418 }
            double r7 = (double) r0     // Catch:{ IOException -> 0x0418 }
            int r16 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r16 <= 0) goto L_0x00ae
            r0 = r1[r14]     // Catch:{ IOException -> 0x0418 }
            double r5 = r0.getX()     // Catch:{ IOException -> 0x0418 }
            float r0 = (float) r5     // Catch:{ IOException -> 0x0418 }
        L_0x00ae:
            r5 = r1[r14]     // Catch:{ IOException -> 0x0418 }
            double r5 = r5.getY()     // Catch:{ IOException -> 0x0418 }
            double r7 = (double) r4     // Catch:{ IOException -> 0x0418 }
            int r16 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r16 >= 0) goto L_0x00c0
            r4 = r1[r14]     // Catch:{ IOException -> 0x0418 }
            double r4 = r4.getY()     // Catch:{ IOException -> 0x0418 }
            float r4 = (float) r4     // Catch:{ IOException -> 0x0418 }
        L_0x00c0:
            r5 = r1[r14]     // Catch:{ IOException -> 0x0418 }
            double r5 = r5.getY()     // Catch:{ IOException -> 0x0418 }
            double r7 = (double) r2     // Catch:{ IOException -> 0x0418 }
            int r16 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r16 <= 0) goto L_0x00d2
            r2 = r1[r14]     // Catch:{ IOException -> 0x0418 }
            double r5 = r2.getY()     // Catch:{ IOException -> 0x0418 }
            float r2 = (float) r5     // Catch:{ IOException -> 0x0418 }
        L_0x00d2:
            int r14 = r14 + 1
            r7 = r36
            r5 = 4
            goto L_0x0088
        L_0x00d8:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.BBOX     // Catch:{ IOException -> 0x0418 }
            com.itextpdf.text.pdf.PdfArray r5 = new com.itextpdf.text.pdf.PdfArray     // Catch:{ IOException -> 0x0418 }
            r6 = 4
            float[] r7 = new float[r6]     // Catch:{ IOException -> 0x0418 }
            r6 = 0
            r7[r6] = r3     // Catch:{ IOException -> 0x0418 }
            r14 = 1
            r7[r14] = r4     // Catch:{ IOException -> 0x0418 }
            r3 = 2
            r7[r3] = r0     // Catch:{ IOException -> 0x0418 }
            r0 = 3
            r7[r0] = r2     // Catch:{ IOException -> 0x0418 }
            r5.<init>(r7)     // Catch:{ IOException -> 0x0418 }
            r13.setAccessibleAttribute(r1, r5)     // Catch:{ IOException -> 0x0418 }
            goto L_0x00f5
        L_0x00f2:
            r3 = 2
            r6 = 0
            r14 = 1
        L_0x00f5:
            com.itextpdf.text.pdf.PdfWriter r0 = r15.writer     // Catch:{ IOException -> 0x0418 }
            if (r0 == 0) goto L_0x0170
            boolean r0 = r31.isImgTemplate()     // Catch:{ IOException -> 0x016b }
            if (r0 == 0) goto L_0x0170
            com.itextpdf.text.pdf.PdfWriter r0 = r15.writer     // Catch:{ IOException -> 0x016b }
            r0.addDirectImageSimple(r13)     // Catch:{ IOException -> 0x016b }
            com.itextpdf.text.pdf.PdfTemplate r2 = r31.getTemplateData()     // Catch:{ IOException -> 0x016b }
            java.util.HashMap r0 = r31.getAccessibleAttributes()     // Catch:{ IOException -> 0x016b }
            if (r0 == 0) goto L_0x012e
            java.util.HashMap r0 = r31.getAccessibleAttributes()
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x011a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x012e
            java.lang.Object r1 = r0.next()
            com.itextpdf.text.pdf.PdfName r1 = (com.itextpdf.text.pdf.PdfName) r1
            com.itextpdf.text.pdf.PdfObject r4 = r13.getAccessibleAttribute(r1)
            r2.setAccessibleAttribute(r1, r4)
            goto L_0x011a
        L_0x012e:
            float r0 = r2.getWidth()
            float r1 = r2.getHeight()
            double r4 = (double) r0
            double r7 = r11 / r4
            double r16 = r9 / r4
            double r0 = (double) r1
            double r18 = r36 / r0
            double r20 = r38 / r0
            r0 = 0
            r22 = 0
            r4 = r42
            r1 = r30
            r3 = 0
            r6 = 2
            r5 = 0
            r3 = r7
            r7 = r38
            r5 = r16
            r7 = r18
            r9 = r20
            r11 = r40
            r13 = r42
            r15 = r0
            r16 = r22
            r1.addTemplate(r2, r3, r5, r7, r9, r11, r13, r15, r16)
            r14 = r30
            r4 = r31
            r12 = r32
            r10 = r34
            r8 = r36
            r1 = 0
            r15 = 1
            goto L_0x034e
        L_0x016b:
            r0 = move-exception
            r14 = r30
            goto L_0x041a
        L_0x0170:
            r14 = r30
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.content     // Catch:{ IOException -> 0x0416 }
            java.lang.String r1 = "q "
            r0.append(r1)     // Catch:{ IOException -> 0x0416 }
            boolean r0 = r29.isIdentity()     // Catch:{ IOException -> 0x0416 }
            r1 = 32
            if (r0 != 0) goto L_0x01c6
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.content     // Catch:{ IOException -> 0x0416 }
            r12 = r32
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.append(r12)     // Catch:{ IOException -> 0x0416 }
            r0.append(r1)     // Catch:{ IOException -> 0x0416 }
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.content     // Catch:{ IOException -> 0x0416 }
            r10 = r34
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.append(r10)     // Catch:{ IOException -> 0x0416 }
            r0.append(r1)     // Catch:{ IOException -> 0x0416 }
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.content     // Catch:{ IOException -> 0x0416 }
            r8 = r36
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.append(r8)     // Catch:{ IOException -> 0x0416 }
            r0.append(r1)     // Catch:{ IOException -> 0x0416 }
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.content     // Catch:{ IOException -> 0x0416 }
            r6 = r38
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.append(r6)     // Catch:{ IOException -> 0x0416 }
            r0.append(r1)     // Catch:{ IOException -> 0x0416 }
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.content     // Catch:{ IOException -> 0x0416 }
            r4 = r40
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.append(r4)     // Catch:{ IOException -> 0x0416 }
            r0.append(r1)     // Catch:{ IOException -> 0x0416 }
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.content     // Catch:{ IOException -> 0x0416 }
            r2 = r42
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.append(r2)     // Catch:{ IOException -> 0x0416 }
            java.lang.String r15 = " cm"
            r0.append(r15)     // Catch:{ IOException -> 0x0416 }
            goto L_0x01d2
        L_0x01c6:
            r12 = r32
            r10 = r34
            r8 = r36
            r6 = r38
            r4 = r40
            r2 = r42
        L_0x01d2:
            if (r44 == 0) goto L_0x0306
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.content     // Catch:{ IOException -> 0x0301 }
            java.lang.String r1 = "\nBI\n"
            r0.append(r1)     // Catch:{ IOException -> 0x0301 }
            com.itextpdf.text.pdf.PdfImage r0 = new com.itextpdf.text.pdf.PdfImage     // Catch:{ IOException -> 0x0301 }
            java.lang.String r1 = ""
            r15 = 0
            r4 = r31
            r0.<init>(r4, r1, r15)
            boolean r1 = r4 instanceof com.itextpdf.text.ImgJBIG2
            if (r1 == 0) goto L_0x0207
            r1 = r4
            com.itextpdf.text.ImgJBIG2 r1 = (com.itextpdf.text.ImgJBIG2) r1
            byte[] r1 = r1.getGlobalBytes()
            if (r1 == 0) goto L_0x0207
            com.itextpdf.text.pdf.PdfDictionary r5 = new com.itextpdf.text.pdf.PdfDictionary
            r5.<init>()
            com.itextpdf.text.pdf.PdfName r15 = com.itextpdf.text.pdf.PdfName.JBIG2GLOBALS
            com.itextpdf.text.pdf.PdfWriter r2 = r14.writer
            com.itextpdf.text.pdf.PdfIndirectReference r1 = r2.getReferenceJBIG2Globals(r1)
            r5.put(r15, r1)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.DECODEPARMS
            r0.put(r1, r5)
        L_0x0207:
            com.itextpdf.text.pdf.PdfWriter r1 = r14.writer
            r2 = 17
            com.itextpdf.text.pdf.PdfWriter.checkPdfIsoConformance(r1, r2, r0)
            java.util.Set r1 = r0.getKeys()
            java.util.Iterator r1 = r1.iterator()
        L_0x0216:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x02c5
            java.lang.Object r2 = r1.next()
            com.itextpdf.text.pdf.PdfName r2 = (com.itextpdf.text.pdf.PdfName) r2
            com.itextpdf.text.pdf.PdfObject r3 = r0.get(r2)
            java.util.HashMap<com.itextpdf.text.pdf.PdfName, java.lang.String> r5 = com.itextpdf.text.pdf.PdfContentByte.abrev
            java.lang.Object r5 = r5.get(r2)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L_0x0231
            goto L_0x0216
        L_0x0231:
            com.itextpdf.text.pdf.ByteBuffer r15 = r14.content
            r15.append(r5)
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.COLORSPACE
            boolean r5 = r2.equals(r5)
            if (r5 == 0) goto L_0x0283
            boolean r5 = r3.isArray()
            if (r5 == 0) goto L_0x0283
            r5 = r3
            com.itextpdf.text.pdf.PdfArray r5 = (com.itextpdf.text.pdf.PdfArray) r5
            int r15 = r5.size()
            r45 = r1
            r1 = 4
            if (r15 != r1) goto L_0x0285
            com.itextpdf.text.pdf.PdfName r15 = com.itextpdf.text.pdf.PdfName.INDEXED
            r1 = 0
            com.itextpdf.text.pdf.PdfName r6 = r5.getAsName(r1)
            boolean r6 = r15.equals(r6)
            if (r6 == 0) goto L_0x0286
            r15 = 1
            com.itextpdf.text.pdf.PdfObject r6 = r5.getPdfObject(r15)
            boolean r6 = r6.isName()
            if (r6 == 0) goto L_0x0280
            r6 = 2
            com.itextpdf.text.pdf.PdfObject r7 = r5.getPdfObject(r6)
            boolean r7 = r7.isNumber()
            if (r7 == 0) goto L_0x0281
            r7 = 3
            com.itextpdf.text.pdf.PdfObject r5 = r5.getPdfObject(r7)
            boolean r5 = r5.isString()
            if (r5 == 0) goto L_0x0289
            r5 = 0
            goto L_0x028a
        L_0x0280:
            r6 = 2
        L_0x0281:
            r7 = 3
            goto L_0x0289
        L_0x0283:
            r45 = r1
        L_0x0285:
            r1 = 0
        L_0x0286:
            r6 = 2
            r7 = 3
            r15 = 1
        L_0x0289:
            r5 = 1
        L_0x028a:
            if (r5 == 0) goto L_0x02b2
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.COLORSPACE
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x02b2
            boolean r2 = r3.isName()
            if (r2 != 0) goto L_0x02b2
            com.itextpdf.text.pdf.PdfWriter r2 = r14.writer
            com.itextpdf.text.pdf.PdfName r2 = r2.getColorspaceName()
            com.itextpdf.text.pdf.PageResources r5 = r30.getPageResources()
            com.itextpdf.text.pdf.PdfWriter r6 = r14.writer
            com.itextpdf.text.pdf.PdfIndirectObject r3 = r6.addToBody(r3)
            com.itextpdf.text.pdf.PdfIndirectReference r3 = r3.getIndirectReference()
            r5.addColor(r2, r3)
            r3 = r2
        L_0x02b2:
            com.itextpdf.text.pdf.ByteBuffer r2 = r14.content
            r5 = 0
            r3.toPdf(r5, r2)
            com.itextpdf.text.pdf.ByteBuffer r2 = r14.content
            r3 = 10
            r2.append(r3)
            r6 = r38
            r1 = r45
            goto L_0x0216
        L_0x02c5:
            r1 = 0
            r15 = 1
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            r0.writeContent(r2)
            byte[] r0 = r2.toByteArray()
            com.itextpdf.text.pdf.ByteBuffer r2 = r14.content
            java.lang.String r3 = "/L %s\n"
            java.lang.Object[] r5 = new java.lang.Object[r15]
            int r6 = r0.length
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5[r1] = r6
            java.lang.String r3 = java.lang.String.format(r3, r5)
            r2.append(r3)
            com.itextpdf.text.pdf.ByteBuffer r2 = r14.content
            java.lang.String r3 = "ID\n"
            r2.append(r3)
            com.itextpdf.text.pdf.ByteBuffer r2 = r14.content
            r2.append(r0)
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.content
            java.lang.String r2 = "\nEI\nQ"
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.append(r2)
            int r2 = r14.separator
            r0.append_i(r2)
            goto L_0x034e
        L_0x0301:
            r0 = move-exception
            r4 = r31
            goto L_0x041a
        L_0x0306:
            r4 = r31
            r0 = 32
            r1 = 0
            r15 = 1
            com.itextpdf.text.pdf.PageResources r2 = r30.getPageResources()
            com.itextpdf.text.Image r3 = r31.getImageMask()
            if (r3 == 0) goto L_0x0325
            com.itextpdf.text.pdf.PdfWriter r5 = r14.writer
            com.itextpdf.text.pdf.PdfName r3 = r5.addDirectImageSimple(r3)
            com.itextpdf.text.pdf.PdfWriter r5 = r14.writer
            com.itextpdf.text.pdf.PdfIndirectReference r5 = r5.getImageReference(r3)
            r2.addXObject(r3, r5)
        L_0x0325:
            com.itextpdf.text.pdf.PdfWriter r3 = r14.writer
            com.itextpdf.text.pdf.PdfName r3 = r3.addDirectImageSimple(r4)
            com.itextpdf.text.pdf.PdfWriter r5 = r14.writer
            com.itextpdf.text.pdf.PdfIndirectReference r5 = r5.getImageReference(r3)
            com.itextpdf.text.pdf.PdfName r2 = r2.addXObject(r3, r5)
            com.itextpdf.text.pdf.ByteBuffer r3 = r14.content
            com.itextpdf.text.pdf.ByteBuffer r0 = r3.append(r0)
            byte[] r2 = r2.getBytes()
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.append(r2)
            java.lang.String r2 = " Do Q"
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.append(r2)
            int r2 = r14.separator
            r0.append_i(r2)
        L_0x034e:
            boolean r0 = r31.hasBorders()
            if (r0 == 0) goto L_0x0383
            r30.saveState()
            float r0 = r31.getWidth()
            float r2 = r31.getHeight()
            double r5 = (double) r0
            double r16 = r12 / r5
            double r5 = r10 / r5
            double r2 = (double) r2
            double r18 = r8 / r2
            double r20 = r38 / r2
            r7 = 0
            r1 = r30
            r2 = r16
            r4 = r5
            r0 = 2
            r15 = 0
            r6 = r18
            r8 = r20
            r10 = r40
            r12 = r42
            r1.concatCTM(r2, r4, r6, r8, r10, r12)     // Catch:{ IOException -> 0x0414 }
            r30.rectangle(r31)     // Catch:{ IOException -> 0x0414 }
            r30.restoreState()     // Catch:{ IOException -> 0x0414 }
            goto L_0x0385
        L_0x0383:
            r0 = 2
            r15 = 0
        L_0x0385:
            com.itextpdf.text.pdf.PdfOCG r1 = r31.getLayer()     // Catch:{ IOException -> 0x0414 }
            if (r1 == 0) goto L_0x038e
            r30.endLayer()     // Catch:{ IOException -> 0x0414 }
        L_0x038e:
            com.itextpdf.text.Annotation r1 = r31.getAnnotation()     // Catch:{ IOException -> 0x0414 }
            if (r1 != 0) goto L_0x0395
            return
        L_0x0395:
            float[] r2 = com.itextpdf.text.pdf.PdfContentByte.unitRect     // Catch:{ IOException -> 0x0414 }
            int r2 = r2.length     // Catch:{ IOException -> 0x0414 }
            double[] r3 = new double[r2]     // Catch:{ IOException -> 0x0414 }
            r4 = 0
        L_0x039b:
            float[] r5 = com.itextpdf.text.pdf.PdfContentByte.unitRect     // Catch:{ IOException -> 0x0414 }
            int r5 = r5.length     // Catch:{ IOException -> 0x0414 }
            if (r4 >= r5) goto L_0x03cb
            float[] r5 = com.itextpdf.text.pdf.PdfContentByte.unitRect     // Catch:{ IOException -> 0x0414 }
            r5 = r5[r4]     // Catch:{ IOException -> 0x0414 }
            double r5 = (double) r5     // Catch:{ IOException -> 0x0414 }
            double r5 = r5 * r32
            float[] r7 = com.itextpdf.text.pdf.PdfContentByte.unitRect     // Catch:{ IOException -> 0x0414 }
            int r8 = r4 + 1
            r7 = r7[r8]     // Catch:{ IOException -> 0x0414 }
            double r9 = (double) r7     // Catch:{ IOException -> 0x0414 }
            double r9 = r9 * r36
            double r5 = r5 + r9
            double r5 = r5 + r40
            r3[r4] = r5     // Catch:{ IOException -> 0x0414 }
            float[] r5 = com.itextpdf.text.pdf.PdfContentByte.unitRect     // Catch:{ IOException -> 0x0414 }
            r5 = r5[r4]     // Catch:{ IOException -> 0x0414 }
            double r5 = (double) r5     // Catch:{ IOException -> 0x0414 }
            double r5 = r5 * r34
            float[] r7 = com.itextpdf.text.pdf.PdfContentByte.unitRect     // Catch:{ IOException -> 0x0414 }
            r7 = r7[r8]     // Catch:{ IOException -> 0x0414 }
            double r9 = (double) r7     // Catch:{ IOException -> 0x0414 }
            double r9 = r9 * r38
            double r5 = r5 + r9
            double r5 = r5 + r42
            r3[r8] = r5     // Catch:{ IOException -> 0x0414 }
            int r4 = r4 + 2
            goto L_0x039b
        L_0x03cb:
            r4 = r3[r15]     // Catch:{ IOException -> 0x0414 }
            r6 = 1
            r7 = r3[r6]     // Catch:{ IOException -> 0x0414 }
            r10 = r7
            r6 = r4
            r8 = r10
        L_0x03d3:
            if (r0 >= r2) goto L_0x03f6
            r12 = r3[r0]     // Catch:{ IOException -> 0x0414 }
            double r4 = java.lang.Math.min(r4, r12)     // Catch:{ IOException -> 0x0414 }
            int r12 = r0 + 1
            r32 = r4
            r4 = r3[r12]     // Catch:{ IOException -> 0x0414 }
            double r8 = java.lang.Math.min(r8, r4)     // Catch:{ IOException -> 0x0414 }
            r4 = r3[r0]     // Catch:{ IOException -> 0x0414 }
            double r6 = java.lang.Math.max(r6, r4)     // Catch:{ IOException -> 0x0414 }
            r4 = r3[r12]     // Catch:{ IOException -> 0x0414 }
            double r10 = java.lang.Math.max(r10, r4)     // Catch:{ IOException -> 0x0414 }
            int r0 = r0 + 2
            r4 = r32
            goto L_0x03d3
        L_0x03f6:
            com.itextpdf.text.Annotation r0 = new com.itextpdf.text.Annotation     // Catch:{ IOException -> 0x0414 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0414 }
            float r1 = (float) r4     // Catch:{ IOException -> 0x0414 }
            float r2 = (float) r8     // Catch:{ IOException -> 0x0414 }
            float r3 = (float) r6     // Catch:{ IOException -> 0x0414 }
            float r4 = (float) r10     // Catch:{ IOException -> 0x0414 }
            r0.setDimensions(r1, r2, r3, r4)     // Catch:{ IOException -> 0x0414 }
            com.itextpdf.text.pdf.PdfWriter r5 = r14.writer     // Catch:{ IOException -> 0x0414 }
            com.itextpdf.text.Rectangle r6 = new com.itextpdf.text.Rectangle     // Catch:{ IOException -> 0x0414 }
            r6.<init>(r1, r2, r3, r4)     // Catch:{ IOException -> 0x0414 }
            com.itextpdf.text.pdf.PdfAnnotation r0 = com.itextpdf.text.pdf.internal.PdfAnnotationsImp.convertAnnotation(r5, r0, r6)     // Catch:{ IOException -> 0x0414 }
            if (r0 != 0) goto L_0x0410
            return
        L_0x0410:
            r14.addAnnotation(r0)     // Catch:{ IOException -> 0x0414 }
            return
        L_0x0414:
            r0 = move-exception
            goto L_0x041b
        L_0x0416:
            r0 = move-exception
            goto L_0x041a
        L_0x0418:
            r0 = move-exception
            r14 = r15
        L_0x041a:
            r15 = 0
        L_0x041b:
            if (r31 == 0) goto L_0x042c
            java.net.URL r1 = r31.getUrl()
            if (r1 == 0) goto L_0x042c
            java.net.URL r1 = r31.getUrl()
            java.lang.String r1 = r1.getPath()
            goto L_0x0435
        L_0x042c:
            java.lang.Object[] r1 = new java.lang.Object[r15]
            java.lang.String r2 = "unknown"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r2, r1)
        L_0x0435:
            com.itextpdf.text.DocumentException r2 = new com.itextpdf.text.DocumentException
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r15] = r1
            java.lang.String r1 = "add.image.exception"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r1, r3)
            r2.<init>(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfContentByte.addImage(com.itextpdf.text.Image, double, double, double, double, double, double, boolean, boolean):void");
    }

    public void reset() {
        reset(true);
    }

    public void reset(boolean z) {
        this.content.reset();
        this.markedContentSize = 0;
        if (z) {
            sanityCheck();
        }
        this.state = new GraphicState();
        this.stateList = new ArrayList<>();
    }

    /* access modifiers changed from: protected */
    public void beginText(boolean z) {
        if (!this.inText) {
            this.inText = true;
            this.content.append("BT").append_i(this.separator);
            if (z) {
                float f = this.state.xTLM;
                float f2 = this.state.tx;
                setTextMatrix(this.state.aTLM, this.state.bTLM, this.state.cTLM, this.state.dTLM, this.state.tx, this.state.yTLM);
                this.state.xTLM = f;
                this.state.tx = f2;
                return;
            }
            this.state.xTLM = 0.0f;
            this.state.yTLM = 0.0f;
            this.state.tx = 0.0f;
        } else if (!isTagged()) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.begin.end.text.operators", new Object[0]));
        }
    }

    public void beginText() {
        beginText(false);
    }

    public void endText() {
        if (this.inText) {
            this.inText = false;
            this.content.append("ET").append_i(this.separator);
        } else if (!isTagged()) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.begin.end.text.operators", new Object[0]));
        }
    }

    public void saveState() {
        PdfWriter.checkPdfIsoConformance(this.writer, 12, "q");
        if (this.inText && isTagged()) {
            endText();
        }
        this.content.append("q").append_i(this.separator);
        this.stateList.add(new GraphicState(this.state));
    }

    public void restoreState() {
        PdfWriter.checkPdfIsoConformance(this.writer, 12, "Q");
        if (this.inText && isTagged()) {
            endText();
        }
        this.content.append("Q").append_i(this.separator);
        int size = this.stateList.size() - 1;
        if (size >= 0) {
            this.state.restore(this.stateList.get(size));
            this.stateList.remove(size);
            return;
        }
        throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.save.restore.state.operators", new Object[0]));
    }

    public void setCharacterSpacing(float f) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.charSpace = f;
        this.content.append(f).append(" Tc").append_i(this.separator);
    }

    public void setWordSpacing(float f) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.wordSpace = f;
        this.content.append(f).append(" Tw").append_i(this.separator);
    }

    public void setHorizontalScaling(float f) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.scale = f;
        this.content.append(f).append(" Tz").append_i(this.separator);
    }

    public void setLeading(float f) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.leading = f;
        this.content.append(f).append(" TL").append_i(this.separator);
    }

    public void setFontAndSize(BaseFont baseFont, float f) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        checkWriter();
        if (f >= 1.0E-4f || f <= -1.0E-4f) {
            this.state.size = f;
            this.state.fontDetails = this.writer.addSimple(baseFont);
            this.content.append(getPageResources().addFont(this.state.fontDetails.getFontName(), this.state.fontDetails.getIndirectReference()).getBytes()).append(' ').append(f).append(" Tf").append_i(this.separator);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("font.size.too.small.1", String.valueOf(f)));
    }

    public void setTextRenderingMode(int i) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.textRenderMode = i;
        this.content.append(i).append(" Tr").append_i(this.separator);
    }

    public void setTextRise(float f) {
        setTextRise((double) f);
    }

    public void setTextRise(double d) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.content.append(d).append(" Ts").append_i(this.separator);
    }

    private void showText2(String str) {
        if (this.state.fontDetails != null) {
            StringUtils.escapeString(this.state.fontDetails.convertToBytes(str), this.content);
            return;
        }
        throw new NullPointerException(MessageLocalization.getComposedMessage("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
    }

    public void showText(String str) {
        checkState();
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        showText2(str);
        updateTx(str, 0.0f);
        this.content.append("Tj").append_i(this.separator);
    }

    public void showTextGid(String str) {
        checkState();
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        if (this.state.fontDetails != null) {
            Object[] convertToBytesGid = this.state.fontDetails.convertToBytesGid(str);
            StringUtils.escapeString((byte[]) convertToBytesGid[0], this.content);
            this.state.tx += ((float) ((Integer) convertToBytesGid[2]).intValue()) * 0.001f * this.state.size;
            this.content.append("Tj").append_i(this.separator);
            return;
        }
        throw new NullPointerException(MessageLocalization.getComposedMessage("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
    }

    public static PdfTextArray getKernArray(String str, BaseFont baseFont) {
        PdfTextArray pdfTextArray = new PdfTextArray();
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length() - 1;
        char[] charArray = str.toCharArray();
        if (length >= 0) {
            stringBuffer.append(charArray, 0, 1);
        }
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char c = charArray[i2];
            int kerning = baseFont.getKerning(charArray[i], c);
            if (kerning == 0) {
                stringBuffer.append(c);
            } else {
                pdfTextArray.add(stringBuffer.toString());
                stringBuffer.setLength(0);
                stringBuffer.append(charArray, i2, 1);
                pdfTextArray.add((float) (-kerning));
            }
            i = i2;
        }
        pdfTextArray.add(stringBuffer.toString());
        return pdfTextArray;
    }

    public void showTextKerned(String str) {
        if (this.state.fontDetails != null) {
            BaseFont baseFont = this.state.fontDetails.getBaseFont();
            if (baseFont.hasKernPairs()) {
                showText(getKernArray(str, baseFont));
            } else {
                showText(str);
            }
        } else {
            throw new NullPointerException(MessageLocalization.getComposedMessage("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
        }
    }

    public void newlineShowText(String str) {
        checkState();
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.yTLM -= this.state.leading;
        showText2(str);
        this.content.append("'").append_i(this.separator);
        GraphicState graphicState = this.state;
        graphicState.tx = graphicState.xTLM;
        updateTx(str, 0.0f);
    }

    public void newlineShowText(float f, float f2, String str) {
        checkState();
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.yTLM -= this.state.leading;
        this.content.append(f).append(' ').append(f2);
        showText2(str);
        this.content.append("\"").append_i(this.separator);
        this.state.charSpace = f2;
        this.state.wordSpace = f;
        GraphicState graphicState = this.state;
        graphicState.tx = graphicState.xTLM;
        updateTx(str, 0.0f);
    }

    public void setTextMatrix(float f, float f2, float f3, float f4, float f5, float f6) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.xTLM = f5;
        this.state.yTLM = f6;
        this.state.aTLM = f;
        this.state.bTLM = f2;
        this.state.cTLM = f3;
        this.state.dTLM = f4;
        GraphicState graphicState = this.state;
        graphicState.tx = graphicState.xTLM;
        this.content.append(f).append(' ').append(f2).append_i(32).append(f3).append_i(32).append(f4).append_i(32).append(f5).append_i(32).append(f6).append(" Tm").append_i(this.separator);
    }

    public void setTextMatrix(AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        setTextMatrix((float) dArr[0], (float) dArr[1], (float) dArr[2], (float) dArr[3], (float) dArr[4], (float) dArr[5]);
    }

    public void setTextMatrix(float f, float f2) {
        setTextMatrix(1.0f, 0.0f, 0.0f, 1.0f, f, f2);
    }

    public void moveText(float f, float f2) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.xTLM += f;
        this.state.yTLM += f2;
        if (!isTagged() || this.state.xTLM == this.state.tx) {
            this.content.append(f).append(' ').append(f2).append(" Td").append_i(this.separator);
        } else {
            setTextMatrix(this.state.aTLM, this.state.bTLM, this.state.cTLM, this.state.dTLM, this.state.xTLM, this.state.yTLM);
        }
    }

    public void moveTextWithLeading(float f, float f2) {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        this.state.xTLM += f;
        this.state.yTLM += f2;
        this.state.leading = -f2;
        if (!isTagged() || this.state.xTLM == this.state.tx) {
            this.content.append(f).append(' ').append(f2).append(" TD").append_i(this.separator);
        } else {
            setTextMatrix(this.state.aTLM, this.state.bTLM, this.state.cTLM, this.state.dTLM, this.state.xTLM, this.state.yTLM);
        }
    }

    public void newlineText() {
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        if (isTagged() && this.state.xTLM != this.state.tx) {
            setTextMatrix(this.state.aTLM, this.state.bTLM, this.state.cTLM, this.state.dTLM, this.state.xTLM, this.state.yTLM);
        }
        this.state.yTLM -= this.state.leading;
        this.content.append("T*").append_i(this.separator);
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return size(true);
    }

    /* access modifiers changed from: package-private */
    public int size(boolean z) {
        if (z) {
            return this.content.size();
        }
        return this.content.size() - this.markedContentSize;
    }

    public void addOutline(PdfOutline pdfOutline, String str) {
        checkWriter();
        this.pdf.addOutline(pdfOutline, str);
    }

    public PdfOutline getRootOutline() {
        checkWriter();
        return this.pdf.getRootOutline();
    }

    public float getEffectiveStringWidth(String str, boolean z) {
        float f;
        BaseFont baseFont = this.state.fontDetails.getBaseFont();
        if (z) {
            f = baseFont.getWidthPointKerned(str, this.state.size);
        } else {
            f = baseFont.getWidthPoint(str, this.state.size);
        }
        if (this.state.charSpace != 0.0f && str.length() > 1) {
            f += this.state.charSpace * ((float) (str.length() - 1));
        }
        if (this.state.wordSpace != 0.0f && !baseFont.isVertical()) {
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == ' ') {
                    f += this.state.wordSpace;
                }
            }
        }
        return ((double) this.state.scale) != 100.0d ? (f * this.state.scale) / 100.0f : f;
    }

    private float getEffectiveStringWidth(String str, boolean z, float f) {
        float f2;
        BaseFont baseFont = this.state.fontDetails.getBaseFont();
        if (z) {
            f2 = baseFont.getWidthPointKerned(str, this.state.size);
        } else {
            f2 = baseFont.getWidthPoint(str, this.state.size);
        }
        if (this.state.charSpace != 0.0f && str.length() > 0) {
            f2 += this.state.charSpace * ((float) str.length());
        }
        if (this.state.wordSpace != 0.0f && !baseFont.isVertical()) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    f2 += this.state.wordSpace;
                }
            }
        }
        float f3 = f2 - ((f / 1000.0f) * this.state.size);
        return ((double) this.state.scale) != 100.0d ? (f3 * this.state.scale) / 100.0f : f3;
    }

    public void showTextAligned(int i, String str, float f, float f2, float f3) {
        showTextAligned(i, str, f, f2, f3, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void showTextAligned(int r16, java.lang.String r17, float r18, float r19, float r20, boolean r21) {
        /*
            r15 = this;
            r7 = r15
            r0 = r16
            r8 = r17
            r1 = r19
            r2 = r20
            r9 = r21
            com.itextpdf.text.pdf.PdfContentByte$GraphicState r3 = r7.state
            com.itextpdf.text.pdf.FontDetails r3 = r3.fontDetails
            if (r3 == 0) goto L_0x0083
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 2
            r5 = 1
            r10 = 0
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 != 0) goto L_0x003a
            if (r0 == r5) goto L_0x0026
            if (r0 == r4) goto L_0x0021
            r0 = r18
            goto L_0x002d
        L_0x0021:
            float r0 = r15.getEffectiveStringWidth(r8, r9)
            goto L_0x002b
        L_0x0026:
            float r0 = r15.getEffectiveStringWidth(r8, r9)
            float r0 = r0 / r3
        L_0x002b:
            float r0 = r18 - r0
        L_0x002d:
            r15.setTextMatrix(r0, r1)
            if (r9 == 0) goto L_0x0036
            r15.showTextKerned(r8)
            goto L_0x0082
        L_0x0036:
            r15.showText(r8)
            goto L_0x0082
        L_0x003a:
            double r11 = (double) r2
            r13 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r11 = r11 * r13
            r13 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r11 = r11 / r13
            double r13 = java.lang.Math.cos(r11)
            float r6 = (float) r13
            double r11 = java.lang.Math.sin(r11)
            float r2 = (float) r11
            if (r0 == r5) goto L_0x005f
            if (r0 == r4) goto L_0x005a
            r5 = r18
            r11 = r1
            goto L_0x006e
        L_0x005a:
            float r0 = r15.getEffectiveStringWidth(r8, r9)
            goto L_0x0064
        L_0x005f:
            float r0 = r15.getEffectiveStringWidth(r8, r9)
            float r0 = r0 / r3
        L_0x0064:
            float r3 = r0 * r6
            float r3 = r18 - r3
            float r0 = r0 * r2
            float r0 = r1 - r0
            r11 = r0
            r5 = r3
        L_0x006e:
            float r3 = -r2
            r0 = r15
            r1 = r6
            r4 = r6
            r6 = r11
            r0.setTextMatrix(r1, r2, r3, r4, r5, r6)
            if (r9 == 0) goto L_0x007c
            r15.showTextKerned(r8)
            goto L_0x007f
        L_0x007c:
            r15.showText(r8)
        L_0x007f:
            r15.setTextMatrix(r10, r10)
        L_0x0082:
            return
        L_0x0083:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "font.and.size.must.be.set.before.writing.any.text"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r2, r1)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfContentByte.showTextAligned(int, java.lang.String, float, float, float, boolean):void");
    }

    public void showTextAlignedKerned(int i, String str, float f, float f2, float f3) {
        showTextAligned(i, str, f, f2, f3, true);
    }

    public void concatCTM(float f, float f2, float f3, float f4, float f5, float f6) {
        concatCTM((double) f, (double) f2, (double) f3, (double) f4, (double) f5, (double) f6);
    }

    public void concatCTM(double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.inText && isTagged()) {
            endText();
        }
        this.state.CTM.concatenate(new AffineTransform(d, d2, d3, d4, d5, d6));
        this.content.append(d).append(' ').append(d2).append(' ').append(d3).append(' ');
        this.content.append(d4).append(' ').append(d5).append(' ').append(d6).append(" cm").append_i(this.separator);
    }

    public void concatCTM(AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        concatCTM(dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5]);
    }

    public static ArrayList<double[]> bezierArc(float f, float f2, float f3, float f4, float f5, float f6) {
        return bezierArc((double) f, (double) f2, (double) f3, (double) f4, (double) f5, (double) f6);
    }

    public static ArrayList<double[]> bezierArc(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        int i;
        if (d > d3) {
            d7 = d;
            d8 = d3;
        } else {
            d8 = d;
            d7 = d3;
        }
        if (d4 > d2) {
            d9 = d2;
            d10 = d4;
        } else {
            d10 = d2;
            d9 = d4;
        }
        if (Math.abs(d6) <= 90.0d) {
            d11 = d6;
            i = 1;
        } else {
            i = (int) Math.ceil(Math.abs(d6) / 90.0d);
            d11 = d6 / ((double) i);
        }
        double d12 = (d8 + d7) / 2.0d;
        double d13 = (d10 + d9) / 2.0d;
        double d14 = (d7 - d8) / 2.0d;
        double d15 = (d9 - d10) / 2.0d;
        double d16 = (d11 * 3.141592653589793d) / 360.0d;
        double abs = Math.abs(((1.0d - Math.cos(d16)) * 1.3333333333333333d) / Math.sin(d16));
        ArrayList<double[]> arrayList = new ArrayList<>();
        int i2 = 0;
        while (i2 < i) {
            double d17 = ((d5 + (((double) i2) * d11)) * 3.141592653589793d) / 180.0d;
            i2++;
            double d18 = ((d5 + (((double) i2) * d11)) * 3.141592653589793d) / 180.0d;
            double cos = Math.cos(d17);
            double cos2 = Math.cos(d18);
            double sin = Math.sin(d17);
            double sin2 = Math.sin(d18);
            if (d11 > 0.0d) {
                arrayList.add(new double[]{d12 + (d14 * cos), d13 - (d15 * sin), d12 + ((cos - (abs * sin)) * d14), d13 - ((sin + (cos * abs)) * d15), ((cos2 + (abs * sin2)) * d14) + d12, d13 - ((sin2 - (abs * cos2)) * d15), d12 + (cos2 * d14), d13 - (sin2 * d15)});
            } else {
                arrayList.add(new double[]{d12 + (d14 * cos), d13 - (d15 * sin), d12 + ((cos + (abs * sin)) * d14), d13 - ((sin - (cos * abs)) * d15), ((cos2 - (abs * sin2)) * d14) + d12, d13 - (((abs * cos2) + sin2) * d15), d12 + (cos2 * d14), d13 - (sin2 * d15)});
            }
            abs = abs;
        }
        return arrayList;
    }

    public void arc(float f, float f2, float f3, float f4, float f5, float f6) {
        arc((double) f, (double) f2, (double) f3, (double) f4, (double) f5, (double) f6);
    }

    public void arc(double d, double d2, double d3, double d4, double d5, double d6) {
        ArrayList<double[]> bezierArc = bezierArc(d, d2, d3, d4, d5, d6);
        if (!bezierArc.isEmpty()) {
            double[] dArr = bezierArc.get(0);
            moveTo(dArr[0], dArr[1]);
            for (int i = 0; i < bezierArc.size(); i++) {
                double[] dArr2 = bezierArc.get(i);
                curveTo(dArr2[2], dArr2[3], dArr2[4], dArr2[5], dArr2[6], dArr2[7]);
            }
        }
    }

    public void ellipse(float f, float f2, float f3, float f4) {
        ellipse((double) f, (double) f2, (double) f3, (double) f4);
    }

    public void ellipse(double d, double d2, double d3, double d4) {
        arc(d, d2, d3, d4, 0.0d, 360.0d);
    }

    public PdfPatternPainter createPattern(float f, float f2, float f3, float f4) {
        checkWriter();
        if (f3 == 0.0f || f4 == 0.0f) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("xstep.or.ystep.can.not.be.zero", new Object[0]));
        }
        PdfPatternPainter pdfPatternPainter = new PdfPatternPainter(this.writer);
        pdfPatternPainter.setWidth(f);
        pdfPatternPainter.setHeight(f2);
        pdfPatternPainter.setXStep(f3);
        pdfPatternPainter.setYStep(f4);
        this.writer.addSimplePattern(pdfPatternPainter);
        return pdfPatternPainter;
    }

    public PdfPatternPainter createPattern(float f, float f2) {
        return createPattern(f, f2, f, f2);
    }

    public PdfPatternPainter createPattern(float f, float f2, float f3, float f4, BaseColor baseColor) {
        checkWriter();
        if (f3 == 0.0f || f4 == 0.0f) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("xstep.or.ystep.can.not.be.zero", new Object[0]));
        }
        PdfPatternPainter pdfPatternPainter = new PdfPatternPainter(this.writer, baseColor);
        pdfPatternPainter.setWidth(f);
        pdfPatternPainter.setHeight(f2);
        pdfPatternPainter.setXStep(f3);
        pdfPatternPainter.setYStep(f4);
        this.writer.addSimplePattern(pdfPatternPainter);
        return pdfPatternPainter;
    }

    public PdfPatternPainter createPattern(float f, float f2, BaseColor baseColor) {
        return createPattern(f, f2, f, f2, baseColor);
    }

    public PdfTemplate createTemplate(float f, float f2) {
        return createTemplate(f, f2, null);
    }

    /* access modifiers changed from: package-private */
    public PdfTemplate createTemplate(float f, float f2, PdfName pdfName) {
        checkWriter();
        PdfTemplate pdfTemplate = new PdfTemplate(this.writer);
        pdfTemplate.setWidth(f);
        pdfTemplate.setHeight(f2);
        this.writer.addDirectTemplateSimple(pdfTemplate, pdfName);
        return pdfTemplate;
    }

    public PdfAppearance createAppearance(float f, float f2) {
        return createAppearance(f, f2, null);
    }

    /* access modifiers changed from: package-private */
    public PdfAppearance createAppearance(float f, float f2, PdfName pdfName) {
        checkWriter();
        PdfAppearance pdfAppearance = new PdfAppearance(this.writer);
        pdfAppearance.setWidth(f);
        pdfAppearance.setHeight(f2);
        this.writer.addDirectTemplateSimple(pdfAppearance, pdfName);
        return pdfAppearance;
    }

    public void addPSXObject(PdfPSXObject pdfPSXObject) {
        if (this.inText && isTagged()) {
            endText();
        }
        checkWriter();
        this.content.append(getPageResources().addXObject(this.writer.addDirectTemplateSimple(pdfPSXObject, null), pdfPSXObject.getIndirectReference()).getBytes()).append(" Do").append_i(this.separator);
    }

    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2, float f3, float f4, float f5, float f6) {
        addTemplate(pdfTemplate, f, f2, f3, f4, f5, f6, false);
    }

    public void addTemplate(PdfTemplate pdfTemplate, double d, double d2, double d3, double d4, double d5, double d6) {
        addTemplate(pdfTemplate, d, d2, d3, d4, d5, d6, false);
    }

    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
        addTemplate(pdfTemplate, (double) f, (double) f2, (double) f3, (double) f4, (double) f5, (double) f6, z);
    }

    public void addTemplate(PdfTemplate pdfTemplate, double d, double d2, double d3, double d4, double d5, double d6, boolean z) {
        addTemplate(pdfTemplate, d, d2, d3, d4, d5, d6, true, z);
    }

    private void addTemplate(PdfTemplate pdfTemplate, double d, double d2, double d3, double d4, double d5, double d6, boolean z, boolean z2) {
        checkWriter();
        checkNoPattern(pdfTemplate);
        PdfWriter.checkPdfIsoConformance(this.writer, 20, pdfTemplate);
        PdfName addXObject = getPageResources().addXObject(this.writer.addDirectTemplateSimple(pdfTemplate, null), pdfTemplate.getIndirectReference());
        if (isTagged() && z) {
            if (this.inText) {
                endText();
            }
            if (pdfTemplate.isContentTagged() || (pdfTemplate.getPageReference() != null && z2)) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("template.with.tagged.could.not.be.used.more.than.once", new Object[0]));
            }
            pdfTemplate.setPageReference(this.writer.getCurrentPage());
            if (z2) {
                pdfTemplate.setContentTagged(true);
                ensureDocumentTagIsOpen();
                ArrayList<IAccessibleElement> mcElements2 = getMcElements();
                if (mcElements2 != null && mcElements2.size() > 0) {
                    pdfTemplate.getMcElements().add(mcElements2.get(mcElements2.size() - 1));
                }
            } else {
                openMCBlock(pdfTemplate);
            }
        }
        this.content.append("q ");
        this.content.append(d).append(' ');
        this.content.append(d2).append(' ');
        this.content.append(d3).append(' ');
        this.content.append(d4).append(' ');
        this.content.append(d5).append(' ');
        this.content.append(d6).append(" cm ");
        this.content.append(addXObject.getBytes()).append(" Do Q").append_i(this.separator);
        if (isTagged() && z && !z2) {
            closeMCBlock(pdfTemplate);
            pdfTemplate.setId(null);
        }
    }

    public PdfName addFormXObj(PdfStream pdfStream, PdfName pdfName, float f, float f2, float f3, float f4, float f5, float f6) throws IOException {
        return addFormXObj(pdfStream, pdfName, (double) f, (double) f2, (double) f3, (double) f4, (double) f5, (double) f6);
    }

    public PdfName addFormXObj(PdfStream pdfStream, PdfName pdfName, double d, double d2, double d3, double d4, double d5, double d6) throws IOException {
        PdfArtifact pdfArtifact;
        checkWriter();
        PdfWriter.checkPdfIsoConformance(this.writer, 9, pdfStream);
        PdfName addXObject = getPageResources().addXObject(pdfName, this.writer.addToBody(pdfStream).getIndirectReference());
        if (isTagged()) {
            if (this.inText) {
                endText();
            }
            pdfArtifact = new PdfArtifact();
            openMCBlock(pdfArtifact);
        } else {
            pdfArtifact = null;
        }
        this.content.append("q ");
        this.content.append(d).append(' ');
        this.content.append(d2).append(' ');
        this.content.append(d3).append(' ');
        this.content.append(d4).append(' ');
        this.content.append(d5).append(' ');
        this.content.append(d6).append(" cm ");
        this.content.append(addXObject.getBytes()).append(" Do Q").append_i(this.separator);
        if (isTagged()) {
            closeMCBlock(pdfArtifact);
        }
        return addXObject;
    }

    public void addTemplate(PdfTemplate pdfTemplate, AffineTransform affineTransform) {
        addTemplate(pdfTemplate, affineTransform, false);
    }

    public void addTemplate(PdfTemplate pdfTemplate, AffineTransform affineTransform, boolean z) {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        addTemplate(pdfTemplate, dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], z);
    }

    /* access modifiers changed from: package-private */
    public void addTemplateReference(PdfIndirectReference pdfIndirectReference, PdfName pdfName, float f, float f2, float f3, float f4, float f5, float f6) {
        addTemplateReference(pdfIndirectReference, pdfName, (double) f, (double) f2, (double) f3, (double) f4, (double) f5, (double) f6);
    }

    /* access modifiers changed from: package-private */
    public void addTemplateReference(PdfIndirectReference pdfIndirectReference, PdfName pdfName, double d, double d2, double d3, double d4, double d5, double d6) {
        if (this.inText && isTagged()) {
            endText();
        }
        checkWriter();
        PdfName addXObject = getPageResources().addXObject(pdfName, pdfIndirectReference);
        this.content.append("q ");
        this.content.append(d).append(' ');
        this.content.append(d2).append(' ');
        this.content.append(d3).append(' ');
        this.content.append(d4).append(' ');
        this.content.append(d5).append(' ');
        this.content.append(d6).append(" cm ");
        this.content.append(addXObject.getBytes()).append(" Do Q").append_i(this.separator);
    }

    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2) {
        addTemplate(pdfTemplate, 1.0f, 0.0f, 0.0f, 1.0f, f, f2);
    }

    public void addTemplate(PdfTemplate pdfTemplate, double d, double d2) {
        addTemplate(pdfTemplate, 1.0d, 0.0d, 0.0d, 1.0d, d, d2);
    }

    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2, boolean z) {
        addTemplate(pdfTemplate, 1.0f, 0.0f, 0.0f, 1.0f, f, f2, z);
    }

    public void addTemplate(PdfTemplate pdfTemplate, double d, double d2, boolean z) {
        addTemplate(pdfTemplate, 1.0d, 0.0d, 0.0d, 1.0d, d, d2, z);
    }

    public void setCMYKColorFill(int i, int i2, int i3, int i4) {
        saveColor(new CMYKColor(i, i2, i3, i4), true);
        this.content.append(((float) (i & 255)) / 255.0f);
        this.content.append(' ');
        this.content.append(((float) (i2 & 255)) / 255.0f);
        this.content.append(' ');
        this.content.append(((float) (i3 & 255)) / 255.0f);
        this.content.append(' ');
        this.content.append(((float) (i4 & 255)) / 255.0f);
        this.content.append(" k").append_i(this.separator);
    }

    public void setCMYKColorStroke(int i, int i2, int i3, int i4) {
        saveColor(new CMYKColor(i, i2, i3, i4), false);
        this.content.append(((float) (i & 255)) / 255.0f);
        this.content.append(' ');
        this.content.append(((float) (i2 & 255)) / 255.0f);
        this.content.append(' ');
        this.content.append(((float) (i3 & 255)) / 255.0f);
        this.content.append(' ');
        this.content.append(((float) (i4 & 255)) / 255.0f);
        this.content.append(" K").append_i(this.separator);
    }

    public void setRGBColorFill(int i, int i2, int i3) {
        saveColor(new BaseColor(i, i2, i3), true);
        HelperRGB(((float) (i & 255)) / 255.0f, ((float) (i2 & 255)) / 255.0f, ((float) (i3 & 255)) / 255.0f);
        this.content.append(" rg").append_i(this.separator);
    }

    public void setRGBColorStroke(int i, int i2, int i3) {
        saveColor(new BaseColor(i, i2, i3), false);
        HelperRGB(((float) (i & 255)) / 255.0f, ((float) (i2 & 255)) / 255.0f, ((float) (i3 & 255)) / 255.0f);
        this.content.append(" RG").append_i(this.separator);
    }

    public void setColorStroke(BaseColor baseColor) {
        switch (ExtendedColor.getType(baseColor)) {
            case 1:
                setGrayStroke(((GrayColor) baseColor).getGray());
                break;
            case 2:
                CMYKColor cMYKColor = (CMYKColor) baseColor;
                setCMYKColorStrokeF(cMYKColor.getCyan(), cMYKColor.getMagenta(), cMYKColor.getYellow(), cMYKColor.getBlack());
                break;
            case 3:
                SpotColor spotColor = (SpotColor) baseColor;
                setColorStroke(spotColor.getPdfSpotColor(), spotColor.getTint());
                break;
            case 4:
                setPatternStroke(((PatternColor) baseColor).getPainter());
                break;
            case 5:
                setShadingStroke(((ShadingColor) baseColor).getPdfShadingPattern());
                break;
            case 6:
                DeviceNColor deviceNColor = (DeviceNColor) baseColor;
                setColorStroke(deviceNColor.getPdfDeviceNColor(), deviceNColor.getTints());
                break;
            case 7:
                LabColor labColor = (LabColor) baseColor;
                setColorStroke(labColor.getLabColorSpace(), labColor.getL(), labColor.getA(), labColor.getB());
                break;
            default:
                setRGBColorStroke(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue());
                break;
        }
        int alpha = baseColor.getAlpha();
        if (alpha < 255) {
            PdfGState pdfGState = new PdfGState();
            pdfGState.setStrokeOpacity(((float) alpha) / 255.0f);
            setGState(pdfGState);
        }
    }

    public void setColorFill(BaseColor baseColor) {
        switch (ExtendedColor.getType(baseColor)) {
            case 1:
                setGrayFill(((GrayColor) baseColor).getGray());
                break;
            case 2:
                CMYKColor cMYKColor = (CMYKColor) baseColor;
                setCMYKColorFillF(cMYKColor.getCyan(), cMYKColor.getMagenta(), cMYKColor.getYellow(), cMYKColor.getBlack());
                break;
            case 3:
                SpotColor spotColor = (SpotColor) baseColor;
                setColorFill(spotColor.getPdfSpotColor(), spotColor.getTint());
                break;
            case 4:
                setPatternFill(((PatternColor) baseColor).getPainter());
                break;
            case 5:
                setShadingFill(((ShadingColor) baseColor).getPdfShadingPattern());
                break;
            case 6:
                DeviceNColor deviceNColor = (DeviceNColor) baseColor;
                setColorFill(deviceNColor.getPdfDeviceNColor(), deviceNColor.getTints());
                break;
            case 7:
                LabColor labColor = (LabColor) baseColor;
                setColorFill(labColor.getLabColorSpace(), labColor.getL(), labColor.getA(), labColor.getB());
                break;
            default:
                setRGBColorFill(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue());
                break;
        }
        int alpha = baseColor.getAlpha();
        if (alpha < 255) {
            PdfGState pdfGState = new PdfGState();
            pdfGState.setFillOpacity(((float) alpha) / 255.0f);
            setGState(pdfGState);
        }
    }

    public void setColorFill(PdfSpotColor pdfSpotColor, float f) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfSpotColor);
        PdfName addColor = getPageResources().addColor(this.state.colorDetails.getColorSpaceName(), this.state.colorDetails.getIndirectReference());
        saveColor(new SpotColor(pdfSpotColor, f), true);
        this.content.append(addColor.getBytes()).append(" cs ").append(f).append(" scn").append_i(this.separator);
    }

    public void setColorFill(PdfDeviceNColor pdfDeviceNColor, float[] fArr) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfDeviceNColor);
        PdfName addColor = getPageResources().addColor(this.state.colorDetails.getColorSpaceName(), this.state.colorDetails.getIndirectReference());
        saveColor(new DeviceNColor(pdfDeviceNColor, fArr), true);
        this.content.append(addColor.getBytes()).append(" cs ");
        for (float f : fArr) {
            this.content.append(f + " ");
        }
        this.content.append("scn").append_i(this.separator);
    }

    public void setColorFill(PdfLabColor pdfLabColor, float f, float f2, float f3) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfLabColor);
        PdfName addColor = getPageResources().addColor(this.state.colorDetails.getColorSpaceName(), this.state.colorDetails.getIndirectReference());
        saveColor(new LabColor(pdfLabColor, f, f2, f3), true);
        this.content.append(addColor.getBytes()).append(" cs ");
        ByteBuffer byteBuffer = this.content;
        byteBuffer.append(f + " " + f2 + " " + f3 + " ");
        this.content.append("scn").append_i(this.separator);
    }

    public void setColorStroke(PdfSpotColor pdfSpotColor, float f) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfSpotColor);
        PdfName addColor = getPageResources().addColor(this.state.colorDetails.getColorSpaceName(), this.state.colorDetails.getIndirectReference());
        saveColor(new SpotColor(pdfSpotColor, f), false);
        this.content.append(addColor.getBytes()).append(" CS ").append(f).append(" SCN").append_i(this.separator);
    }

    public void setColorStroke(PdfDeviceNColor pdfDeviceNColor, float[] fArr) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfDeviceNColor);
        PdfName addColor = getPageResources().addColor(this.state.colorDetails.getColorSpaceName(), this.state.colorDetails.getIndirectReference());
        saveColor(new DeviceNColor(pdfDeviceNColor, fArr), true);
        this.content.append(addColor.getBytes()).append(" CS ");
        for (float f : fArr) {
            this.content.append(f + " ");
        }
        this.content.append("SCN").append_i(this.separator);
    }

    public void setColorStroke(PdfLabColor pdfLabColor, float f, float f2, float f3) {
        checkWriter();
        this.state.colorDetails = this.writer.addSimple(pdfLabColor);
        PdfName addColor = getPageResources().addColor(this.state.colorDetails.getColorSpaceName(), this.state.colorDetails.getIndirectReference());
        saveColor(new LabColor(pdfLabColor, f, f2, f3), true);
        this.content.append(addColor.getBytes()).append(" CS ");
        ByteBuffer byteBuffer = this.content;
        byteBuffer.append(f + " " + f2 + " " + f3 + " ");
        this.content.append("SCN").append_i(this.separator);
    }

    public void setPatternFill(PdfPatternPainter pdfPatternPainter) {
        if (pdfPatternPainter.isStencil()) {
            setPatternFill(pdfPatternPainter, pdfPatternPainter.getDefaultColor());
            return;
        }
        checkWriter();
        PdfName addPattern = getPageResources().addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference());
        saveColor(new PatternColor(pdfPatternPainter), true);
        this.content.append(PdfName.PATTERN.getBytes()).append(" cs ").append(addPattern.getBytes()).append(" scn").append_i(this.separator);
    }

    /* access modifiers changed from: package-private */
    public void outputColorNumbers(BaseColor baseColor, float f) {
        PdfWriter.checkPdfIsoConformance(this.writer, 1, baseColor);
        int type = ExtendedColor.getType(baseColor);
        if (type == 0) {
            this.content.append(((float) baseColor.getRed()) / 255.0f);
            this.content.append(' ');
            this.content.append(((float) baseColor.getGreen()) / 255.0f);
            this.content.append(' ');
            this.content.append(((float) baseColor.getBlue()) / 255.0f);
        } else if (type == 1) {
            this.content.append(((GrayColor) baseColor).getGray());
        } else if (type == 2) {
            CMYKColor cMYKColor = (CMYKColor) baseColor;
            this.content.append(cMYKColor.getCyan()).append(' ').append(cMYKColor.getMagenta());
            this.content.append(' ').append(cMYKColor.getYellow()).append(' ').append(cMYKColor.getBlack());
        } else if (type == 3) {
            this.content.append(f);
        } else {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.color.type", new Object[0]));
        }
    }

    public void setPatternFill(PdfPatternPainter pdfPatternPainter, BaseColor baseColor) {
        if (ExtendedColor.getType(baseColor) == 3) {
            setPatternFill(pdfPatternPainter, baseColor, ((SpotColor) baseColor).getTint());
        } else {
            setPatternFill(pdfPatternPainter, baseColor, 0.0f);
        }
    }

    public void setPatternFill(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f) {
        checkWriter();
        if (pdfPatternPainter.isStencil()) {
            PageResources pageResources = getPageResources();
            PdfName addPattern = pageResources.addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference());
            ColorDetails addSimplePatternColorspace = this.writer.addSimplePatternColorspace(baseColor);
            PdfName addColor = pageResources.addColor(addSimplePatternColorspace.getColorSpaceName(), addSimplePatternColorspace.getIndirectReference());
            saveColor(new UncoloredPattern(pdfPatternPainter, baseColor, f), true);
            this.content.append(addColor.getBytes()).append(" cs").append_i(this.separator);
            outputColorNumbers(baseColor, f);
            this.content.append(' ').append(addPattern.getBytes()).append(" scn").append_i(this.separator);
            return;
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("an.uncolored.pattern.was.expected", new Object[0]));
    }

    public void setPatternStroke(PdfPatternPainter pdfPatternPainter, BaseColor baseColor) {
        if (ExtendedColor.getType(baseColor) == 3) {
            setPatternStroke(pdfPatternPainter, baseColor, ((SpotColor) baseColor).getTint());
        } else {
            setPatternStroke(pdfPatternPainter, baseColor, 0.0f);
        }
    }

    public void setPatternStroke(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f) {
        checkWriter();
        if (pdfPatternPainter.isStencil()) {
            PageResources pageResources = getPageResources();
            PdfName addPattern = pageResources.addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference());
            ColorDetails addSimplePatternColorspace = this.writer.addSimplePatternColorspace(baseColor);
            PdfName addColor = pageResources.addColor(addSimplePatternColorspace.getColorSpaceName(), addSimplePatternColorspace.getIndirectReference());
            saveColor(new UncoloredPattern(pdfPatternPainter, baseColor, f), false);
            this.content.append(addColor.getBytes()).append(" CS").append_i(this.separator);
            outputColorNumbers(baseColor, f);
            this.content.append(' ').append(addPattern.getBytes()).append(" SCN").append_i(this.separator);
            return;
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("an.uncolored.pattern.was.expected", new Object[0]));
    }

    public void setPatternStroke(PdfPatternPainter pdfPatternPainter) {
        if (pdfPatternPainter.isStencil()) {
            setPatternStroke(pdfPatternPainter, pdfPatternPainter.getDefaultColor());
            return;
        }
        checkWriter();
        PdfName addPattern = getPageResources().addPattern(this.writer.addSimplePattern(pdfPatternPainter), pdfPatternPainter.getIndirectReference());
        saveColor(new PatternColor(pdfPatternPainter), false);
        this.content.append(PdfName.PATTERN.getBytes()).append(" CS ").append(addPattern.getBytes()).append(" SCN").append_i(this.separator);
    }

    public void paintShading(PdfShading pdfShading) {
        this.writer.addSimpleShading(pdfShading);
        PageResources pageResources = getPageResources();
        this.content.append(pageResources.addShading(pdfShading.getShadingName(), pdfShading.getShadingReference()).getBytes()).append(" sh").append_i(this.separator);
        ColorDetails colorDetails = pdfShading.getColorDetails();
        if (colorDetails != null) {
            pageResources.addColor(colorDetails.getColorSpaceName(), colorDetails.getIndirectReference());
        }
    }

    public void paintShading(PdfShadingPattern pdfShadingPattern) {
        paintShading(pdfShadingPattern.getShading());
    }

    public void setShadingFill(PdfShadingPattern pdfShadingPattern) {
        this.writer.addSimpleShadingPattern(pdfShadingPattern);
        PageResources pageResources = getPageResources();
        PdfName addPattern = pageResources.addPattern(pdfShadingPattern.getPatternName(), pdfShadingPattern.getPatternReference());
        saveColor(new ShadingColor(pdfShadingPattern), true);
        this.content.append(PdfName.PATTERN.getBytes()).append(" cs ").append(addPattern.getBytes()).append(" scn").append_i(this.separator);
        ColorDetails colorDetails = pdfShadingPattern.getColorDetails();
        if (colorDetails != null) {
            pageResources.addColor(colorDetails.getColorSpaceName(), colorDetails.getIndirectReference());
        }
    }

    public void setShadingStroke(PdfShadingPattern pdfShadingPattern) {
        this.writer.addSimpleShadingPattern(pdfShadingPattern);
        PageResources pageResources = getPageResources();
        PdfName addPattern = pageResources.addPattern(pdfShadingPattern.getPatternName(), pdfShadingPattern.getPatternReference());
        saveColor(new ShadingColor(pdfShadingPattern), false);
        this.content.append(PdfName.PATTERN.getBytes()).append(" CS ").append(addPattern.getBytes()).append(" SCN").append_i(this.separator);
        ColorDetails colorDetails = pdfShadingPattern.getColorDetails();
        if (colorDetails != null) {
            pageResources.addColor(colorDetails.getColorSpaceName(), colorDetails.getIndirectReference());
        }
    }

    /* access modifiers changed from: protected */
    public void checkWriter() {
        if (this.writer == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("the.writer.in.pdfcontentbyte.is.null", new Object[0]));
        }
    }

    public void showText(PdfTextArray pdfTextArray) {
        checkState();
        if (!this.inText && isTagged()) {
            beginText(true);
        }
        if (this.state.fontDetails != null) {
            this.content.append("[");
            Iterator<Object> it2 = pdfTextArray.getArrayList().iterator();
            while (true) {
                boolean z = false;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (next instanceof String) {
                        String str = (String) next;
                        showText2(str);
                        updateTx(str, 0.0f);
                    } else {
                        if (z) {
                            this.content.append(' ');
                        } else {
                            z = true;
                        }
                        Float f = (Float) next;
                        this.content.append(f.floatValue());
                        updateTx("", f.floatValue());
                    }
                }
                this.content.append("]TJ").append_i(this.separator);
                return;
            }
        }
        throw new NullPointerException(MessageLocalization.getComposedMessage("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
    }

    public PdfWriter getPdfWriter() {
        return this.writer;
    }

    public PdfDocument getPdfDocument() {
        return this.pdf;
    }

    public void localGoto(String str, float f, float f2, float f3, float f4) {
        this.pdf.localGoto(str, f, f2, f3, f4);
    }

    public boolean localDestination(String str, PdfDestination pdfDestination) {
        return this.pdf.localDestination(str, pdfDestination);
    }

    public PdfContentByte getDuplicate() {
        PdfContentByte pdfContentByte = new PdfContentByte(this.writer);
        pdfContentByte.duplicatedFrom = this;
        return pdfContentByte;
    }

    public PdfContentByte getDuplicate(boolean z) {
        PdfContentByte duplicate = getDuplicate();
        if (z) {
            duplicate.state = this.state;
            duplicate.stateList = this.stateList;
        }
        return duplicate;
    }

    public void inheritGraphicState(PdfContentByte pdfContentByte) {
        this.state = pdfContentByte.state;
        this.stateList = pdfContentByte.stateList;
    }

    public void remoteGoto(String str, String str2, float f, float f2, float f3, float f4) {
        this.pdf.remoteGoto(str, str2, f, f2, f3, f4);
    }

    public void remoteGoto(String str, int i, float f, float f2, float f3, float f4) {
        this.pdf.remoteGoto(str, i, f, f2, f3, f4);
    }

    public void roundRectangle(float f, float f2, float f3, float f4, float f5) {
        roundRectangle((double) f, (double) f2, (double) f3, (double) f4, (double) f5);
    }

    public void roundRectangle(double d, double d2, double d3, double d4, double d5) {
        double d6;
        double d7;
        double d8;
        double d9 = d3;
        if (d9 < 0.0d) {
            double d10 = d + d9;
            d9 = -d9;
            d6 = d10;
        } else {
            d6 = d;
        }
        if (d4 < 0.0d) {
            d7 = -d4;
            d8 = d2 + d4;
        } else {
            d8 = d2;
            d7 = d4;
        }
        double d11 = d5 < 0.0d ? -d5 : d5;
        double d12 = d6 + d11;
        moveTo(d12, d8);
        double d13 = d6 + d9;
        double d14 = d13 - d11;
        lineTo(d14, d8);
        double d15 = d11 * ((double) 0.4477f);
        double d16 = d13 - d15;
        double d17 = d8 + d15;
        double d18 = d8 + d11;
        curveTo(d16, d8, d13, d17, d13, d18);
        double d19 = d8 + d7;
        double d20 = d19 - d11;
        lineTo(d13, d20);
        double d21 = d19 - d15;
        curveTo(d13, d21, d16, d19, d14, d19);
        lineTo(d12, d19);
        double d22 = d6 + d15;
        curveTo(d22, d19, d6, d21, d6, d20);
        lineTo(d6, d18);
        curveTo(d6, d17, d22, d8, d12, d8);
    }

    public void setAction(PdfAction pdfAction, float f, float f2, float f3, float f4) {
        this.pdf.setAction(pdfAction, f, f2, f3, f4);
    }

    public void setLiteral(String str) {
        this.content.append(str);
    }

    public void setLiteral(char c) {
        this.content.append(c);
    }

    public void setLiteral(float f) {
        this.content.append(f);
    }

    /* access modifiers changed from: package-private */
    public void checkNoPattern(PdfTemplate pdfTemplate) {
        if (pdfTemplate.getType() == 3) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.use.of.a.pattern.a.template.was.expected", new Object[0]));
        }
    }

    public void drawRadioField(float f, float f2, float f3, float f4, boolean z) {
        drawRadioField((double) f, (double) f2, (double) f3, (double) f4, z);
    }

    public void drawRadioField(double d, double d2, double d3, double d4, boolean z) {
        double d5;
        double d6;
        double d7;
        double d8;
        if (d > d3) {
            d5 = d;
            d6 = d3;
        } else {
            d6 = d;
            d5 = d3;
        }
        if (d2 > d4) {
            d7 = d2;
            d8 = d4;
        } else {
            d8 = d2;
            d7 = d4;
        }
        saveState();
        setLineWidth(1.0f);
        setLineCap(1);
        setColorStroke(new BaseColor(192, 192, 192));
        arc(d6 + 1.0d, d8 + 1.0d, d5 - 1.0d, d7 - 1.0d, 0.0d, 360.0d);
        stroke();
        setLineWidth(1.0f);
        setLineCap(1);
        setColorStroke(new BaseColor((int) CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, (int) CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, (int) CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256));
        arc(d6 + 0.5d, d8 + 0.5d, d5 - 0.5d, d7 - 0.5d, 45.0d, 180.0d);
        stroke();
        setLineWidth(1.0f);
        setLineCap(1);
        setColorStroke(new BaseColor(0, 0, 0));
        arc(d6 + 1.5d, d8 + 1.5d, d5 - 1.5d, d7 - 1.5d, 45.0d, 180.0d);
        stroke();
        if (z) {
            setLineWidth(1.0f);
            setLineCap(1);
            setColorFill(new BaseColor(0, 0, 0));
            arc(d6 + 4.0d, d8 + 4.0d, d5 - 4.0d, d7 - 4.0d, 0.0d, 360.0d);
            fill();
        }
        restoreState();
    }

    public void drawTextField(float f, float f2, float f3, float f4) {
        drawTextField((double) f, (double) f2, (double) f3, (double) f4);
    }

    public void drawTextField(double d, double d2, double d3, double d4) {
        double d5;
        double d6;
        double d7;
        double d8;
        if (d > d3) {
            d5 = d;
            d6 = d3;
        } else {
            d6 = d;
            d5 = d3;
        }
        if (d2 > d4) {
            d7 = d2;
            d8 = d4;
        } else {
            d8 = d2;
            d7 = d4;
        }
        saveState();
        setColorStroke(new BaseColor(192, 192, 192));
        setLineWidth(1.0f);
        setLineCap(0);
        double d9 = d5 - d6;
        double d10 = d7 - d8;
        rectangle(d6, d8, d9, d10);
        stroke();
        setLineWidth(1.0f);
        setLineCap(0);
        setColorFill(new BaseColor(255, 255, 255));
        rectangle(d6 + 0.5d, d8 + 0.5d, d9 - 1.0d, d10 - 1.0d);
        fill();
        setColorStroke(new BaseColor(192, 192, 192));
        setLineWidth(1.0f);
        setLineCap(0);
        double d11 = d6 + 1.0d;
        double d12 = d8 + 1.5d;
        moveTo(d11, d12);
        double d13 = d5 - 1.5d;
        lineTo(d13, d12);
        double d14 = d7 - 1.0d;
        lineTo(d13, d14);
        stroke();
        setColorStroke(new BaseColor((int) CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, (int) CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, (int) CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256));
        setLineWidth(1.0f);
        setLineCap(0);
        moveTo(d11, d8 + 1.0d);
        lineTo(d11, d14);
        lineTo(d5 - 1.0d, d14);
        stroke();
        setColorStroke(new BaseColor(0, 0, 0));
        setLineWidth(1.0f);
        setLineCap(0);
        double d15 = d6 + 2.0d;
        moveTo(d15, d8 + 2.0d);
        double d16 = d7 - 2.0d;
        lineTo(d15, d16);
        lineTo(d5 - 2.0d, d16);
        stroke();
        restoreState();
    }

    public void drawButton(float f, float f2, float f3, float f4, String str, BaseFont baseFont, float f5) {
        drawButton((double) f, (double) f2, (double) f3, (double) f4, str, baseFont, f5);
    }

    public void drawButton(double d, double d2, double d3, double d4, String str, BaseFont baseFont, float f) {
        double d5;
        double d6;
        double d7;
        double d8;
        if (d > d3) {
            d5 = d;
            d6 = d3;
        } else {
            d6 = d;
            d5 = d3;
        }
        if (d2 > d4) {
            d7 = d2;
            d8 = d4;
        } else {
            d8 = d2;
            d7 = d4;
        }
        saveState();
        setColorStroke(new BaseColor(0, 0, 0));
        setLineWidth(1.0f);
        setLineCap(0);
        double d9 = d5 - d6;
        double d10 = d7 - d8;
        rectangle(d6, d8, d9, d10);
        stroke();
        setLineWidth(1.0f);
        setLineCap(0);
        setColorFill(new BaseColor(192, 192, 192));
        rectangle(d6 + 0.5d, d8 + 0.5d, d9 - 1.0d, d10 - 1.0d);
        fill();
        setColorStroke(new BaseColor(255, 255, 255));
        setLineWidth(1.0f);
        setLineCap(0);
        double d11 = d6 + 1.0d;
        double d12 = d8 + 1.0d;
        moveTo(d11, d12);
        double d13 = d7 - 1.0d;
        lineTo(d11, d13);
        double d14 = d5 - 1.0d;
        lineTo(d14, d13);
        stroke();
        setColorStroke(new BaseColor((int) CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, (int) CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, (int) CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256));
        setLineWidth(1.0f);
        setLineCap(0);
        moveTo(d11, d12);
        lineTo(d14, d12);
        lineTo(d14, d13);
        stroke();
        resetRGBColorFill();
        beginText();
        setFontAndSize(baseFont, f);
        showTextAligned(1, str, (float) (d6 + (d9 / 2.0d)), (float) (d8 + ((d10 - ((double) f)) / 2.0d)), 0.0f);
        endText();
        restoreState();
    }

    /* access modifiers changed from: package-private */
    public PageResources getPageResources() {
        return this.pdf.getPageResources();
    }

    public void setGState(PdfGState pdfGState) {
        PdfObject[] addSimpleExtGState = this.writer.addSimpleExtGState(pdfGState);
        PdfName addExtGState = getPageResources().addExtGState((PdfName) addSimpleExtGState[0], (PdfIndirectReference) addSimpleExtGState[1]);
        this.state.extGState = pdfGState;
        this.content.append(addExtGState.getBytes()).append(" gs").append_i(this.separator);
    }

    public void beginLayer(PdfOCG pdfOCG) {
        int i = 0;
        if (!(pdfOCG instanceof PdfLayer) || ((PdfLayer) pdfOCG).getTitle() == null) {
            if (this.layerDepth == null) {
                this.layerDepth = new ArrayList<>();
            }
            if (pdfOCG instanceof PdfLayerMembership) {
                this.layerDepth.add(1);
                beginLayer2(pdfOCG);
                return;
            }
            for (PdfLayer pdfLayer = (PdfLayer) pdfOCG; pdfLayer != null; pdfLayer = pdfLayer.getParent()) {
                if (pdfLayer.getTitle() == null) {
                    beginLayer2(pdfLayer);
                    i++;
                }
            }
            this.layerDepth.add(Integer.valueOf(i));
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("a.title.is.not.a.layer", new Object[0]));
    }

    private void beginLayer2(PdfOCG pdfOCG) {
        this.content.append("/OC ").append(getPageResources().addProperty((PdfName) this.writer.addSimpleProperty(pdfOCG, pdfOCG.getRef())[0], pdfOCG.getRef()).getBytes()).append(" BDC").append_i(this.separator);
    }

    public void endLayer() {
        ArrayList<Integer> arrayList = this.layerDepth;
        if (arrayList == null || arrayList.isEmpty()) {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.layer.operators", new Object[0]));
        }
        ArrayList<Integer> arrayList2 = this.layerDepth;
        int intValue = arrayList2.get(arrayList2.size() - 1).intValue();
        ArrayList<Integer> arrayList3 = this.layerDepth;
        arrayList3.remove(arrayList3.size() - 1);
        while (true) {
            int i = intValue - 1;
            if (intValue > 0) {
                this.content.append("EMC").append_i(this.separator);
                intValue = i;
            } else {
                return;
            }
        }
    }

    public void transform(AffineTransform affineTransform) {
        if (this.inText && isTagged()) {
            endText();
        }
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        this.state.CTM.concatenate(affineTransform);
        this.content.append(dArr[0]).append(' ').append(dArr[1]).append(' ').append(dArr[2]).append(' ');
        this.content.append(dArr[3]).append(' ').append(dArr[4]).append(' ').append(dArr[5]).append(" cm").append_i(this.separator);
    }

    /* access modifiers changed from: package-private */
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        boolean z = isTagged() && pdfAnnotation.getRole() != null && (!(pdfAnnotation instanceof PdfFormField) || ((PdfFormField) pdfAnnotation).getKids() == null);
        if (z) {
            openMCBlock(pdfAnnotation);
        }
        this.writer.addAnnotation(pdfAnnotation);
        if (z) {
            PdfStructureElement structElement = this.pdf.getStructElement(pdfAnnotation.getId());
            if (structElement != null) {
                int structParentIndex = this.pdf.getStructParentIndex(pdfAnnotation);
                pdfAnnotation.put(PdfName.STRUCTPARENT, new PdfNumber(structParentIndex));
                structElement.setAnnotation(pdfAnnotation, getCurrentPage());
                this.writer.getStructureTreeRoot().setAnnotationMark(structParentIndex, structElement.getReference());
            }
            closeMCBlock(pdfAnnotation);
        }
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation, boolean z) {
        if (z && this.state.CTM.getType() != 0) {
            pdfAnnotation.applyCTM(this.state.CTM);
        }
        addAnnotation(pdfAnnotation);
    }

    public void setDefaultColorspace(PdfName pdfName, PdfObject pdfObject) {
        getPageResources().addDefaultColor(pdfName, pdfObject);
    }

    public void beginMarkedContentSequence(PdfStructureElement pdfStructureElement) {
        beginMarkedContentSequence(pdfStructureElement, null);
    }

    private void beginMarkedContentSequence(PdfStructureElement pdfStructureElement, String str) {
        PdfArray pdfArray;
        PdfObject pdfObject = pdfStructureElement.get(PdfName.K);
        int[] structParentIndexAndNextMarkPoint = this.pdf.getStructParentIndexAndNextMarkPoint(getCurrentPage());
        int i = structParentIndexAndNextMarkPoint[0];
        int i2 = structParentIndexAndNextMarkPoint[1];
        if (pdfObject != null) {
            if (pdfObject.isNumber()) {
                pdfArray = new PdfArray();
                pdfArray.add(pdfObject);
                pdfStructureElement.put(PdfName.K, pdfArray);
            } else if (pdfObject.isArray()) {
                pdfArray = (PdfArray) pdfObject;
            } else {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("unknown.object.at.k.1", pdfObject.getClass().toString()));
            }
            if (pdfArray.getAsNumber(0) != null) {
                PdfDictionary pdfDictionary = new PdfDictionary(PdfName.MCR);
                pdfDictionary.put(PdfName.PG, getCurrentPage());
                pdfDictionary.put(PdfName.MCID, new PdfNumber(i2));
                pdfArray.add(pdfDictionary);
            }
            pdfStructureElement.setPageMark(this.pdf.getStructParentIndex(getCurrentPage()), -1);
        } else {
            pdfStructureElement.setPageMark(i, i2);
            pdfStructureElement.put(PdfName.PG, getCurrentPage());
        }
        setMcDepth(getMcDepth() + 1);
        int size = this.content.size();
        this.content.append(pdfStructureElement.get(PdfName.S).getBytes()).append(" <</MCID ").append(i2);
        if (str != null) {
            this.content.append("/E (").append(str).append(")");
        }
        this.content.append(">> BDC").append_i(this.separator);
        this.markedContentSize += this.content.size() - size;
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference getCurrentPage() {
        return this.writer.getCurrentPage();
    }

    public void endMarkedContentSequence() {
        if (getMcDepth() != 0) {
            int size = this.content.size();
            setMcDepth(getMcDepth() - 1);
            this.content.append("EMC").append_i(this.separator);
            this.markedContentSize += this.content.size() - size;
            return;
        }
        throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.begin.end.marked.content.operators", new Object[0]));
    }

    public void beginMarkedContentSequence(PdfName pdfName, PdfDictionary pdfDictionary, boolean z) {
        PdfObject[] pdfObjectArr;
        int size = this.content.size();
        if (pdfDictionary == null) {
            this.content.append(pdfName.getBytes()).append(" BMC").append_i(this.separator);
            setMcDepth(getMcDepth() + 1);
        } else {
            this.content.append(pdfName.getBytes()).append(' ');
            if (z) {
                try {
                    pdfDictionary.toPdf(this.writer, this.content);
                } catch (Exception e) {
                    throw new ExceptionConverter(e);
                }
            } else {
                if (this.writer.propertyExists(pdfDictionary)) {
                    pdfObjectArr = this.writer.addSimpleProperty(pdfDictionary, null);
                } else {
                    PdfWriter pdfWriter = this.writer;
                    pdfObjectArr = pdfWriter.addSimpleProperty(pdfDictionary, pdfWriter.getPdfIndirectReference());
                }
                this.content.append(getPageResources().addProperty((PdfName) pdfObjectArr[0], (PdfIndirectReference) pdfObjectArr[1]).getBytes());
            }
            this.content.append(" BDC").append_i(this.separator);
            setMcDepth(getMcDepth() + 1);
        }
        this.markedContentSize += this.content.size() - size;
    }

    public void beginMarkedContentSequence(PdfName pdfName) {
        beginMarkedContentSequence(pdfName, null, false);
    }

    public void sanityCheck() {
        if (getMcDepth() == 0) {
            if (this.inText) {
                if (isTagged()) {
                    endText();
                } else {
                    throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.begin.end.text.operators", new Object[0]));
                }
            }
            ArrayList<Integer> arrayList = this.layerDepth;
            if (arrayList != null && !arrayList.isEmpty()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.layer.operators", new Object[0]));
            } else if (!this.stateList.isEmpty()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.save.restore.state.operators", new Object[0]));
            }
        } else {
            throw new IllegalPdfSyntaxException(MessageLocalization.getComposedMessage("unbalanced.marked.content.operators", new Object[0]));
        }
    }

    public void openMCBlock(IAccessibleElement iAccessibleElement) {
        if (isTagged()) {
            ensureDocumentTagIsOpen();
            if (iAccessibleElement != null && !getMcElements().contains(iAccessibleElement)) {
                PdfStructureElement openMCBlockInt = openMCBlockInt(iAccessibleElement);
                getMcElements().add(iAccessibleElement);
                if (openMCBlockInt != null) {
                    this.pdf.saveStructElement(iAccessibleElement.getId(), openMCBlockInt);
                }
            }
        }
    }

    private PdfDictionary getParentStructureElement() {
        PdfStructureElement structElement = getMcElements().size() > 0 ? this.pdf.getStructElement(getMcElements().get(getMcElements().size() - 1).getId()) : null;
        return structElement == null ? this.writer.getStructureTreeRoot() : structElement;
    }

    private PdfStructureElement openMCBlockInt(IAccessibleElement iAccessibleElement) {
        PdfStructureElement pdfStructureElement;
        PdfDictionary pdfDictionary = null;
        if (!isTagged()) {
            return null;
        }
        this.writer.checkElementRole(iAccessibleElement, getMcElements().size() > 0 ? getMcElements().get(getMcElements().size() - 1) : null);
        if (iAccessibleElement.getRole() == null) {
            return null;
        }
        if (!PdfName.ARTIFACT.equals(iAccessibleElement.getRole())) {
            pdfStructureElement = this.pdf.getStructElement(iAccessibleElement.getId());
            if (pdfStructureElement == null) {
                pdfStructureElement = new PdfStructureElement(getParentStructureElement(), iAccessibleElement.getRole(), iAccessibleElement.getId());
            }
        } else {
            pdfStructureElement = null;
        }
        if (PdfName.ARTIFACT.equals(iAccessibleElement.getRole())) {
            HashMap<PdfName, PdfObject> accessibleAttributes = iAccessibleElement.getAccessibleAttributes();
            if (accessibleAttributes != null && !accessibleAttributes.isEmpty()) {
                pdfDictionary = new PdfDictionary();
                for (Map.Entry<PdfName, PdfObject> entry : accessibleAttributes.entrySet()) {
                    pdfDictionary.put(entry.getKey(), entry.getValue());
                }
            }
            boolean z = this.inText;
            if (z) {
                endText();
            }
            beginMarkedContentSequence(iAccessibleElement.getRole(), pdfDictionary, true);
            if (z) {
                beginText(true);
            }
        } else if (this.writer.needToBeMarkedInContent(iAccessibleElement)) {
            boolean z2 = this.inText;
            if (z2) {
                endText();
            }
            if (iAccessibleElement.getAccessibleAttributes() == null || iAccessibleElement.getAccessibleAttribute(PdfName.E) == null) {
                beginMarkedContentSequence(pdfStructureElement);
            } else {
                beginMarkedContentSequence(pdfStructureElement, iAccessibleElement.getAccessibleAttribute(PdfName.E).toString());
                iAccessibleElement.setAccessibleAttribute(PdfName.E, null);
            }
            if (z2) {
                beginText(true);
            }
        }
        return pdfStructureElement;
    }

    public void closeMCBlock(IAccessibleElement iAccessibleElement) {
        if (isTagged() && iAccessibleElement != null && getMcElements().contains(iAccessibleElement)) {
            closeMCBlockInt(iAccessibleElement);
            getMcElements().remove(iAccessibleElement);
        }
    }

    private void closeMCBlockInt(IAccessibleElement iAccessibleElement) {
        if (isTagged() && iAccessibleElement.getRole() != null) {
            PdfStructureElement structElement = this.pdf.getStructElement(iAccessibleElement.getId());
            if (structElement != null) {
                structElement.writeAttributes(iAccessibleElement);
            }
            if (this.writer.needToBeMarkedInContent(iAccessibleElement)) {
                boolean z = this.inText;
                if (z) {
                    endText();
                }
                endMarkedContentSequence();
                if (z) {
                    beginText(true);
                }
            }
        }
    }

    private void ensureDocumentTagIsOpen() {
        if (this.pdf.openMCDocument) {
            this.pdf.openMCDocument = false;
            this.writer.getDirectContentUnder().openMCBlock(this.pdf);
        }
    }

    /* access modifiers changed from: protected */
    public ArrayList<IAccessibleElement> saveMCBlocks() {
        ArrayList<IAccessibleElement> arrayList = new ArrayList<>();
        if (isTagged()) {
            arrayList = getMcElements();
            for (int i = 0; i < arrayList.size(); i++) {
                closeMCBlockInt(arrayList.get(i));
            }
            setMcElements(new ArrayList<>());
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void restoreMCBlocks(ArrayList<IAccessibleElement> arrayList) {
        if (isTagged() && arrayList != null) {
            setMcElements(arrayList);
            for (int i = 0; i < getMcElements().size(); i++) {
                openMCBlockInt(getMcElements().get(i));
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getMcDepth() {
        PdfContentByte pdfContentByte = this.duplicatedFrom;
        if (pdfContentByte != null) {
            return pdfContentByte.getMcDepth();
        }
        return this.mcDepth;
    }

    /* access modifiers changed from: protected */
    public void setMcDepth(int i) {
        PdfContentByte pdfContentByte = this.duplicatedFrom;
        if (pdfContentByte != null) {
            pdfContentByte.setMcDepth(i);
        } else {
            this.mcDepth = i;
        }
    }

    /* access modifiers changed from: protected */
    public ArrayList<IAccessibleElement> getMcElements() {
        PdfContentByte pdfContentByte = this.duplicatedFrom;
        if (pdfContentByte != null) {
            return pdfContentByte.getMcElements();
        }
        return this.mcElements;
    }

    /* access modifiers changed from: protected */
    public void setMcElements(ArrayList<IAccessibleElement> arrayList) {
        PdfContentByte pdfContentByte = this.duplicatedFrom;
        if (pdfContentByte != null) {
            pdfContentByte.setMcElements(arrayList);
        } else {
            this.mcElements = arrayList;
        }
    }

    /* access modifiers changed from: protected */
    public void updateTx(String str, float f) {
        this.state.tx += getEffectiveStringWidth(str, false, f);
    }

    private void saveColor(BaseColor baseColor, boolean z) {
        if (z) {
            this.state.colorFill = baseColor;
        } else {
            this.state.colorStroke = baseColor;
        }
    }

    static class UncoloredPattern extends PatternColor {
        protected BaseColor color;
        protected float tint;

        protected UncoloredPattern(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f) {
            super(pdfPatternPainter);
            this.color = baseColor;
            this.tint = f;
        }

        @Override // com.itextpdf.text.BaseColor, com.itextpdf.text.pdf.PatternColor
        public boolean equals(Object obj) {
            if (obj instanceof UncoloredPattern) {
                UncoloredPattern uncoloredPattern = (UncoloredPattern) obj;
                return uncoloredPattern.painter.equals(this.painter) && uncoloredPattern.color.equals(this.color) && uncoloredPattern.tint == this.tint;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean getInText() {
        return this.inText;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkState() {
        /*
            r4 = this;
            com.itextpdf.text.pdf.PdfContentByte$GraphicState r0 = r4.state
            int r0 = r0.textRenderMode
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000b
            r0 = 0
        L_0x0009:
            r1 = 1
            goto L_0x001d
        L_0x000b:
            com.itextpdf.text.pdf.PdfContentByte$GraphicState r0 = r4.state
            int r0 = r0.textRenderMode
            if (r0 != r2) goto L_0x0013
            r0 = 1
            goto L_0x001d
        L_0x0013:
            com.itextpdf.text.pdf.PdfContentByte$GraphicState r0 = r4.state
            int r0 = r0.textRenderMode
            r3 = 2
            if (r0 != r3) goto L_0x001c
            r0 = 1
            goto L_0x0009
        L_0x001c:
            r0 = 0
        L_0x001d:
            if (r1 == 0) goto L_0x0028
            com.itextpdf.text.pdf.PdfWriter r1 = r4.writer
            com.itextpdf.text.pdf.PdfContentByte$GraphicState r3 = r4.state
            com.itextpdf.text.BaseColor r3 = r3.colorFill
            com.itextpdf.text.pdf.PdfWriter.checkPdfIsoConformance(r1, r2, r3)
        L_0x0028:
            if (r0 == 0) goto L_0x0033
            com.itextpdf.text.pdf.PdfWriter r0 = r4.writer
            com.itextpdf.text.pdf.PdfContentByte$GraphicState r1 = r4.state
            com.itextpdf.text.BaseColor r1 = r1.colorStroke
            com.itextpdf.text.pdf.PdfWriter.checkPdfIsoConformance(r0, r2, r1)
        L_0x0033:
            com.itextpdf.text.pdf.PdfWriter r0 = r4.writer
            r1 = 6
            com.itextpdf.text.pdf.PdfContentByte$GraphicState r2 = r4.state
            com.itextpdf.text.pdf.PdfObject r2 = r2.extGState
            com.itextpdf.text.pdf.PdfWriter.checkPdfIsoConformance(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfContentByte.checkState():void");
    }
}
