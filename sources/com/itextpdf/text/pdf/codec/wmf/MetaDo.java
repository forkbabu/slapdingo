package com.itextpdf.text.pdf.codec.wmf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.codec.BmpImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.opencv.ml.DTrees;

public class MetaDo {
    public static final int META_ANIMATEPALETTE = 1078;
    public static final int META_ARC = 2071;
    public static final int META_BITBLT = 2338;
    public static final int META_CHORD = 2096;
    public static final int META_CREATEBRUSHINDIRECT = 764;
    public static final int META_CREATEFONTINDIRECT = 763;
    public static final int META_CREATEPALETTE = 247;
    public static final int META_CREATEPATTERNBRUSH = 505;
    public static final int META_CREATEPENINDIRECT = 762;
    public static final int META_CREATEREGION = 1791;
    public static final int META_DELETEOBJECT = 496;
    public static final int META_DIBBITBLT = 2368;
    public static final int META_DIBCREATEPATTERNBRUSH = 322;
    public static final int META_DIBSTRETCHBLT = 2881;
    public static final int META_ELLIPSE = 1048;
    public static final int META_ESCAPE = 1574;
    public static final int META_EXCLUDECLIPRECT = 1045;
    public static final int META_EXTFLOODFILL = 1352;
    public static final int META_EXTTEXTOUT = 2610;
    public static final int META_FILLREGION = 552;
    public static final int META_FLOODFILL = 1049;
    public static final int META_FRAMEREGION = 1065;
    public static final int META_INTERSECTCLIPRECT = 1046;
    public static final int META_INVERTREGION = 298;
    public static final int META_LINETO = 531;
    public static final int META_MOVETO = 532;
    public static final int META_OFFSETCLIPRGN = 544;
    public static final int META_OFFSETVIEWPORTORG = 529;
    public static final int META_OFFSETWINDOWORG = 527;
    public static final int META_PAINTREGION = 299;
    public static final int META_PATBLT = 1565;
    public static final int META_PIE = 2074;
    public static final int META_POLYGON = 804;
    public static final int META_POLYLINE = 805;
    public static final int META_POLYPOLYGON = 1336;
    public static final int META_REALIZEPALETTE = 53;
    public static final int META_RECTANGLE = 1051;
    public static final int META_RESIZEPALETTE = 313;
    public static final int META_RESTOREDC = 295;
    public static final int META_ROUNDRECT = 1564;
    public static final int META_SAVEDC = 30;
    public static final int META_SCALEVIEWPORTEXT = 1042;
    public static final int META_SCALEWINDOWEXT = 1040;
    public static final int META_SELECTCLIPREGION = 300;
    public static final int META_SELECTOBJECT = 301;
    public static final int META_SELECTPALETTE = 564;
    public static final int META_SETBKCOLOR = 513;
    public static final int META_SETBKMODE = 258;
    public static final int META_SETDIBTODEV = 3379;
    public static final int META_SETMAPMODE = 259;
    public static final int META_SETMAPPERFLAGS = 561;
    public static final int META_SETPALENTRIES = 55;
    public static final int META_SETPIXEL = 1055;
    public static final int META_SETPOLYFILLMODE = 262;
    public static final int META_SETRELABS = 261;
    public static final int META_SETROP2 = 260;
    public static final int META_SETSTRETCHBLTMODE = 263;
    public static final int META_SETTEXTALIGN = 302;
    public static final int META_SETTEXTCHAREXTRA = 264;
    public static final int META_SETTEXTCOLOR = 521;
    public static final int META_SETTEXTJUSTIFICATION = 522;
    public static final int META_SETVIEWPORTEXT = 526;
    public static final int META_SETVIEWPORTORG = 525;
    public static final int META_SETWINDOWEXT = 524;
    public static final int META_SETWINDOWORG = 523;
    public static final int META_STRETCHBLT = 2851;
    public static final int META_STRETCHDIB = 3907;
    public static final int META_TEXTOUT = 1313;
    int bottom;
    public PdfContentByte cb;
    public InputMeta in;
    int inch;
    int left;
    int right;
    MetaState state = new MetaState();
    int top;

    public MetaDo(InputStream inputStream, PdfContentByte pdfContentByte) {
        this.cb = pdfContentByte;
        this.in = new InputMeta(inputStream);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void readAll() throws IOException, DocumentException {
        int i;
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str2;
        int i7;
        MetaDo metaDo = this;
        int i8 = 0;
        if (metaDo.in.readInt() == -1698247209) {
            metaDo.in.readWord();
            metaDo.left = metaDo.in.readShort();
            metaDo.top = metaDo.in.readShort();
            metaDo.right = metaDo.in.readShort();
            metaDo.bottom = metaDo.in.readShort();
            int readWord = metaDo.in.readWord();
            metaDo.inch = readWord;
            metaDo.state.setScalingX((((float) (metaDo.right - metaDo.left)) / ((float) readWord)) * 72.0f);
            metaDo.state.setScalingY((((float) (metaDo.bottom - metaDo.top)) / ((float) metaDo.inch)) * 72.0f);
            metaDo.state.setOffsetWx(metaDo.left);
            metaDo.state.setOffsetWy(metaDo.top);
            metaDo.state.setExtentWx(metaDo.right - metaDo.left);
            metaDo.state.setExtentWy(metaDo.bottom - metaDo.top);
            metaDo.in.readInt();
            metaDo.in.readWord();
            metaDo.in.skip(18);
            boolean z = true;
            metaDo.cb.setLineCap(1);
            metaDo.cb.setLineJoin(1);
            while (true) {
                int length = metaDo.in.getLength();
                int readInt = metaDo.in.readInt();
                if (readInt < 3) {
                    metaDo.state.cleanup(metaDo.cb);
                    return;
                }
                int readWord2 = metaDo.in.readWord();
                switch (readWord2) {
                    case 30:
                        i = length;
                        metaDo.state.saveState(metaDo.cb);
                        continue;
                        InputMeta inputMeta = metaDo.in;
                        inputMeta.skip((readInt * 2) - (inputMeta.getLength() - i));
                        i8 = 0;
                        z = true;
                    case META_CREATEPALETTE /*{ENCODED_INT: 247}*/:
                    case 322:
                    case META_CREATEREGION /*{ENCODED_INT: 1791}*/:
                        i = length;
                        metaDo.state.addMetaObject(new MetaObject());
                        continue;
                        InputMeta inputMeta2 = metaDo.in;
                        inputMeta2.skip((readInt * 2) - (inputMeta2.getLength() - i));
                        i8 = 0;
                        z = true;
                    case 258:
                        i = length;
                        metaDo.state.setBackgroundMode(metaDo.in.readWord());
                        continue;
                        InputMeta inputMeta22 = metaDo.in;
                        inputMeta22.skip((readInt * 2) - (inputMeta22.getLength() - i));
                        i8 = 0;
                        z = true;
                    case 262:
                        i = length;
                        metaDo.state.setPolyFillMode(metaDo.in.readWord());
                        continue;
                        InputMeta inputMeta222 = metaDo.in;
                        inputMeta222.skip((readInt * 2) - (inputMeta222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case META_RESTOREDC /*{ENCODED_INT: 295}*/:
                        i = length;
                        metaDo.state.restoreState(metaDo.in.readShort(), metaDo.cb);
                        continue;
                        InputMeta inputMeta2222 = metaDo.in;
                        inputMeta2222.skip((readInt * 2) - (inputMeta2222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case 301:
                        i = length;
                        metaDo.state.selectMetaObject(metaDo.in.readWord(), metaDo.cb);
                        continue;
                        InputMeta inputMeta22222 = metaDo.in;
                        inputMeta22222.skip((readInt * 2) - (inputMeta22222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case 302:
                        i = length;
                        metaDo.state.setTextAlign(metaDo.in.readWord());
                        continue;
                        InputMeta inputMeta222222 = metaDo.in;
                        inputMeta222222.skip((readInt * 2) - (inputMeta222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case META_DELETEOBJECT /*{ENCODED_INT: 496}*/:
                        i = length;
                        metaDo.state.deleteMetaObject(metaDo.in.readWord());
                        continue;
                        InputMeta inputMeta2222222 = metaDo.in;
                        inputMeta2222222.skip((readInt * 2) - (inputMeta2222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case 513:
                        i = length;
                        metaDo.state.setCurrentBackgroundColor(metaDo.in.readColor());
                        continue;
                        InputMeta inputMeta22222222 = metaDo.in;
                        inputMeta22222222.skip((readInt * 2) - (inputMeta22222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case 521:
                        i = length;
                        metaDo.state.setCurrentTextColor(metaDo.in.readColor());
                        continue;
                        InputMeta inputMeta222222222 = metaDo.in;
                        inputMeta222222222.skip((readInt * 2) - (inputMeta222222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case META_SETWINDOWORG /*{ENCODED_INT: 523}*/:
                        i = length;
                        metaDo.state.setOffsetWy(metaDo.in.readShort());
                        metaDo.state.setOffsetWx(metaDo.in.readShort());
                        continue;
                        InputMeta inputMeta2222222222 = metaDo.in;
                        inputMeta2222222222.skip((readInt * 2) - (inputMeta2222222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case META_SETWINDOWEXT /*{ENCODED_INT: 524}*/:
                        i = length;
                        metaDo.state.setExtentWy(metaDo.in.readShort());
                        metaDo.state.setExtentWx(metaDo.in.readShort());
                        continue;
                        InputMeta inputMeta22222222222 = metaDo.in;
                        inputMeta22222222222.skip((readInt * 2) - (inputMeta22222222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case 531:
                        i = length;
                        int readShort = metaDo.in.readShort();
                        int readShort2 = metaDo.in.readShort();
                        Point currentPoint = metaDo.state.getCurrentPoint();
                        metaDo.cb.moveTo(metaDo.state.transformX(currentPoint.x), metaDo.state.transformY(currentPoint.y));
                        metaDo.cb.lineTo(metaDo.state.transformX(readShort2), metaDo.state.transformY(readShort));
                        metaDo.cb.stroke();
                        metaDo.state.setCurrentPoint(new Point(readShort2, readShort));
                        continue;
                        InputMeta inputMeta222222222222 = metaDo.in;
                        inputMeta222222222222.skip((readInt * 2) - (inputMeta222222222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case 532:
                        i = length;
                        metaDo.state.setCurrentPoint(new Point(metaDo.in.readShort(), metaDo.in.readShort()));
                        continue;
                        InputMeta inputMeta2222222222222 = metaDo.in;
                        inputMeta2222222222222.skip((readInt * 2) - (inputMeta2222222222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case META_CREATEPENINDIRECT /*{ENCODED_INT: 762}*/:
                        i = length;
                        MetaPen metaPen = new MetaPen();
                        metaPen.init(metaDo.in);
                        metaDo.state.addMetaObject(metaPen);
                        continue;
                        InputMeta inputMeta22222222222222 = metaDo.in;
                        inputMeta22222222222222.skip((readInt * 2) - (inputMeta22222222222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case META_CREATEFONTINDIRECT /*{ENCODED_INT: 763}*/:
                        i = length;
                        MetaFont metaFont = new MetaFont();
                        metaFont.init(metaDo.in);
                        metaDo.state.addMetaObject(metaFont);
                        continue;
                        InputMeta inputMeta222222222222222 = metaDo.in;
                        inputMeta222222222222222.skip((readInt * 2) - (inputMeta222222222222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case META_CREATEBRUSHINDIRECT /*{ENCODED_INT: 764}*/:
                        i = length;
                        MetaBrush metaBrush = new MetaBrush();
                        metaBrush.init(metaDo.in);
                        metaDo.state.addMetaObject(metaBrush);
                        continue;
                        InputMeta inputMeta2222222222222222 = metaDo.in;
                        inputMeta2222222222222222.skip((readInt * 2) - (inputMeta2222222222222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case META_POLYGON /*{ENCODED_INT: 804}*/:
                        i = length;
                        if (!metaDo.isNullStrokeFill(false)) {
                            int readWord3 = metaDo.in.readWord();
                            int readShort3 = metaDo.in.readShort();
                            int readShort4 = metaDo.in.readShort();
                            metaDo.cb.moveTo(metaDo.state.transformX(readShort3), metaDo.state.transformY(readShort4));
                            for (int i9 = 1; i9 < readWord3; i9++) {
                                metaDo.cb.lineTo(metaDo.state.transformX(metaDo.in.readShort()), metaDo.state.transformY(metaDo.in.readShort()));
                            }
                            metaDo.cb.lineTo(metaDo.state.transformX(readShort3), metaDo.state.transformY(readShort4));
                            strokeAndFill();
                            continue;
                        }
                        InputMeta inputMeta22222222222222222 = metaDo.in;
                        inputMeta22222222222222222.skip((readInt * 2) - (inputMeta22222222222222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case META_POLYLINE /*{ENCODED_INT: 805}*/:
                        i = length;
                        metaDo.state.setLineJoinPolygon(metaDo.cb);
                        int readWord4 = metaDo.in.readWord();
                        metaDo.cb.moveTo(metaDo.state.transformX(metaDo.in.readShort()), metaDo.state.transformY(metaDo.in.readShort()));
                        for (int i10 = 1; i10 < readWord4; i10++) {
                            metaDo.cb.lineTo(metaDo.state.transformX(metaDo.in.readShort()), metaDo.state.transformY(metaDo.in.readShort()));
                        }
                        metaDo.cb.stroke();
                        continue;
                        InputMeta inputMeta222222222222222222 = metaDo.in;
                        inputMeta222222222222222222.skip((readInt * 2) - (inputMeta222222222222222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case META_INTERSECTCLIPRECT /*{ENCODED_INT: 1046}*/:
                        i = length;
                        float transformY = metaDo.state.transformY(metaDo.in.readShort());
                        float transformX = metaDo.state.transformX(metaDo.in.readShort());
                        float transformY2 = metaDo.state.transformY(metaDo.in.readShort());
                        float transformX2 = metaDo.state.transformX(metaDo.in.readShort());
                        metaDo.cb.rectangle(transformX2, transformY, transformX - transformX2, transformY2 - transformY);
                        metaDo.cb.eoClip();
                        metaDo.cb.newPath();
                        continue;
                        InputMeta inputMeta2222222222222222222 = metaDo.in;
                        inputMeta2222222222222222222.skip((readInt * 2) - (inputMeta2222222222222222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case META_ELLIPSE /*{ENCODED_INT: 1048}*/:
                        i = length;
                        if (!metaDo.isNullStrokeFill(metaDo.state.getLineNeutral())) {
                            int readShort5 = metaDo.in.readShort();
                            int readShort6 = metaDo.in.readShort();
                            int readShort7 = metaDo.in.readShort();
                            metaDo.cb.arc(metaDo.state.transformX(metaDo.in.readShort()), metaDo.state.transformY(readShort5), metaDo.state.transformX(readShort6), metaDo.state.transformY(readShort7), 0.0f, 360.0f);
                            strokeAndFill();
                            continue;
                        }
                        InputMeta inputMeta22222222222222222222 = metaDo.in;
                        inputMeta22222222222222222222.skip((readInt * 2) - (inputMeta22222222222222222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case META_RECTANGLE /*{ENCODED_INT: 1051}*/:
                        i = length;
                        if (!metaDo.isNullStrokeFill(true)) {
                            float transformY3 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX3 = metaDo.state.transformX(metaDo.in.readShort());
                            float transformY4 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX4 = metaDo.state.transformX(metaDo.in.readShort());
                            metaDo.cb.rectangle(transformX4, transformY3, transformX3 - transformX4, transformY4 - transformY3);
                            strokeAndFill();
                            continue;
                        }
                        InputMeta inputMeta222222222222222222222 = metaDo.in;
                        inputMeta222222222222222222222.skip((readInt * 2) - (inputMeta222222222222222222222.getLength() - i));
                        i8 = 0;
                        z = true;
                    case META_SETPIXEL /*{ENCODED_INT: 1055}*/:
                        i = length;
                        BaseColor readColor = metaDo.in.readColor();
                        int readShort8 = metaDo.in.readShort();
                        int readShort9 = metaDo.in.readShort();
                        metaDo.cb.saveState();
                        metaDo.cb.setColorFill(readColor);
                        metaDo.cb.rectangle(metaDo.state.transformX(readShort9), metaDo.state.transformY(readShort8), 0.2f, 0.2f);
                        metaDo.cb.fill();
                        metaDo.cb.restoreState();
                        break;
                    case META_TEXTOUT /*{ENCODED_INT: 1313}*/:
                        i = length;
                        int readWord5 = metaDo.in.readWord();
                        byte[] bArr = new byte[readWord5];
                        int i11 = 0;
                        while (i11 < readWord5) {
                            byte readByte = (byte) metaDo.in.readByte();
                            if (readByte != 0) {
                                bArr[i11] = readByte;
                                i11++;
                            }
                        }
                        try {
                            i2 = 0;
                            try {
                                str = new String(bArr, 0, i11, "Cp1252");
                            } catch (UnsupportedEncodingException unused) {
                            }
                        } catch (UnsupportedEncodingException unused2) {
                            i2 = 0;
                            str = new String(bArr, i2, i11);
                            metaDo.in.skip(((readWord5 + 1) & 65534) - i11);
                            outputText(metaDo.in.readShort(), metaDo.in.readShort(), 0, 0, 0, 0, 0, str);
                            InputMeta inputMeta2222222222222222222222 = metaDo.in;
                            inputMeta2222222222222222222222.skip((readInt * 2) - (inputMeta2222222222222222222222.getLength() - i));
                            i8 = 0;
                            z = true;
                        }
                        metaDo.in.skip(((readWord5 + 1) & 65534) - i11);
                        outputText(metaDo.in.readShort(), metaDo.in.readShort(), 0, 0, 0, 0, 0, str);
                    case META_POLYPOLYGON /*{ENCODED_INT: 1336}*/:
                        i = length;
                        if (!metaDo.isNullStrokeFill(false)) {
                            int readWord6 = metaDo.in.readWord();
                            int[] iArr = new int[readWord6];
                            for (int i12 = 0; i12 < readWord6; i12++) {
                                iArr[i12] = metaDo.in.readWord();
                            }
                            for (int i13 = 0; i13 < readWord6; i13++) {
                                int i14 = iArr[i13];
                                int readShort10 = metaDo.in.readShort();
                                int readShort11 = metaDo.in.readShort();
                                metaDo.cb.moveTo(metaDo.state.transformX(readShort10), metaDo.state.transformY(readShort11));
                                for (int i15 = 1; i15 < i14; i15++) {
                                    metaDo.cb.lineTo(metaDo.state.transformX(metaDo.in.readShort()), metaDo.state.transformY(metaDo.in.readShort()));
                                }
                                metaDo.cb.lineTo(metaDo.state.transformX(readShort10), metaDo.state.transformY(readShort11));
                            }
                            strokeAndFill();
                            break;
                        }
                        break;
                    case META_ROUNDRECT /*{ENCODED_INT: 1564}*/:
                        i = length;
                        if (!metaDo.isNullStrokeFill(true)) {
                            float transformY5 = metaDo.state.transformY(0) - metaDo.state.transformY(metaDo.in.readShort());
                            float transformX5 = metaDo.state.transformX(metaDo.in.readShort()) - metaDo.state.transformX(0);
                            float transformY6 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX6 = metaDo.state.transformX(metaDo.in.readShort());
                            float transformY7 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX7 = metaDo.state.transformX(metaDo.in.readShort());
                            metaDo.cb.roundRectangle(transformX7, transformY6, transformX6 - transformX7, transformY7 - transformY6, (transformY5 + transformX5) / 4.0f);
                            strokeAndFill();
                            break;
                        }
                        break;
                    case META_ARC /*{ENCODED_INT: 2071}*/:
                        i = length;
                        if (!metaDo.isNullStrokeFill(metaDo.state.getLineNeutral())) {
                            float transformY8 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX8 = metaDo.state.transformX(metaDo.in.readShort());
                            float transformY9 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX9 = metaDo.state.transformX(metaDo.in.readShort());
                            float transformY10 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX10 = metaDo.state.transformX(metaDo.in.readShort());
                            float transformY11 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX11 = metaDo.state.transformX(metaDo.in.readShort());
                            float f = (transformX10 + transformX11) / 2.0f;
                            float f2 = (transformY11 + transformY10) / 2.0f;
                            float arc = getArc(f, f2, transformX9, transformY9);
                            float arc2 = getArc(f, f2, transformX8, transformY8) - arc;
                            if (arc2 <= 0.0f) {
                                arc2 += 360.0f;
                            }
                            metaDo.cb.arc(transformX11, transformY10, transformX10, transformY11, arc, arc2);
                            metaDo.cb.stroke();
                            break;
                        }
                        break;
                    case META_PIE /*{ENCODED_INT: 2074}*/:
                        i = length;
                        if (!metaDo.isNullStrokeFill(metaDo.state.getLineNeutral())) {
                            float transformY12 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX12 = metaDo.state.transformX(metaDo.in.readShort());
                            float transformY13 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX13 = metaDo.state.transformX(metaDo.in.readShort());
                            float transformY14 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX14 = metaDo.state.transformX(metaDo.in.readShort());
                            float transformY15 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX15 = metaDo.state.transformX(metaDo.in.readShort());
                            float f3 = (transformX14 + transformX15) / 2.0f;
                            float f4 = (transformY15 + transformY14) / 2.0f;
                            double arc3 = (double) getArc(f3, f4, transformX13, transformY13);
                            double arc4 = ((double) getArc(f3, f4, transformX12, transformY12)) - arc3;
                            if (arc4 <= 0.0d) {
                                arc4 += 360.0d;
                            }
                            ArrayList<double[]> bezierArc = PdfContentByte.bezierArc((double) transformX15, (double) transformY14, (double) transformX14, (double) transformY15, arc3, arc4);
                            if (!bezierArc.isEmpty()) {
                                double[] dArr = bezierArc.get(0);
                                metaDo.cb.moveTo(f3, f4);
                                metaDo.cb.lineTo(dArr[0], dArr[1]);
                                for (int i16 = 0; i16 < bezierArc.size(); i16++) {
                                    double[] dArr2 = bezierArc.get(i16);
                                    metaDo.cb.curveTo(dArr2[2], dArr2[3], dArr2[4], dArr2[5], dArr2[6], dArr2[7]);
                                }
                                metaDo.cb.lineTo(f3, f4);
                                strokeAndFill();
                                break;
                            }
                        }
                        break;
                    case META_CHORD /*{ENCODED_INT: 2096}*/:
                        if (!metaDo.isNullStrokeFill(metaDo.state.getLineNeutral())) {
                            float transformY16 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX16 = metaDo.state.transformX(metaDo.in.readShort());
                            float transformY17 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX17 = metaDo.state.transformX(metaDo.in.readShort());
                            float transformY18 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX18 = metaDo.state.transformX(metaDo.in.readShort());
                            float transformY19 = metaDo.state.transformY(metaDo.in.readShort());
                            float transformX19 = metaDo.state.transformX(metaDo.in.readShort());
                            double d = (double) ((transformX18 + transformX19) / 2.0f);
                            double d2 = (double) ((transformY19 + transformY18) / 2.0f);
                            i = length;
                            double arc5 = getArc(d, d2, (double) transformX17, (double) transformY17);
                            double arc6 = getArc(d, d2, (double) transformX16, (double) transformY16) - arc5;
                            if (arc6 <= 0.0d) {
                                arc6 += 360.0d;
                            }
                            ArrayList<double[]> bezierArc2 = PdfContentByte.bezierArc((double) transformX19, (double) transformY18, (double) transformX18, (double) transformY19, arc5, arc6);
                            if (!bezierArc2.isEmpty()) {
                                double[] dArr3 = bezierArc2.get(0);
                                double d3 = dArr3[0];
                                double d4 = dArr3[1];
                                metaDo = this;
                                metaDo.cb.moveTo(d3, d4);
                                for (int i17 = 0; i17 < bezierArc2.size(); i17++) {
                                    double[] dArr4 = bezierArc2.get(i17);
                                    metaDo.cb.curveTo(dArr4[2], dArr4[3], dArr4[4], dArr4[5], dArr4[6], dArr4[7]);
                                }
                                metaDo.cb.lineTo(d3, d4);
                                strokeAndFill();
                                break;
                            } else {
                                metaDo = this;
                                continue;
                                InputMeta inputMeta22222222222222222222222 = metaDo.in;
                                inputMeta22222222222222222222222.skip((readInt * 2) - (inputMeta22222222222222222222222.getLength() - i));
                                i8 = 0;
                                z = true;
                            }
                        }
                        i = length;
                        break;
                    case META_EXTTEXTOUT /*{ENCODED_INT: 2610}*/:
                        int readShort12 = metaDo.in.readShort();
                        int readShort13 = metaDo.in.readShort();
                        int readWord7 = metaDo.in.readWord();
                        int readWord8 = metaDo.in.readWord();
                        if ((readWord8 & 6) != 0) {
                            i6 = metaDo.in.readShort();
                            i5 = metaDo.in.readShort();
                            i4 = metaDo.in.readShort();
                            i3 = metaDo.in.readShort();
                        } else {
                            i6 = 0;
                            i5 = 0;
                            i4 = 0;
                            i3 = 0;
                        }
                        byte[] bArr2 = new byte[readWord7];
                        int i18 = 0;
                        while (i18 < readWord7) {
                            byte readByte2 = (byte) metaDo.in.readByte();
                            if (readByte2 != 0) {
                                bArr2[i18] = readByte2;
                                i18++;
                            }
                        }
                        try {
                            i7 = 0;
                            try {
                                str2 = new String(bArr2, 0, i18, "Cp1252");
                            } catch (UnsupportedEncodingException unused3) {
                            }
                        } catch (UnsupportedEncodingException unused4) {
                            i7 = 0;
                            str2 = new String(bArr2, i7, i18);
                            outputText(readShort13, readShort12, readWord8, i6, i5, i4, i3, str2);
                            i = length;
                            InputMeta inputMeta222222222222222222222222 = metaDo.in;
                            inputMeta222222222222222222222222.skip((readInt * 2) - (inputMeta222222222222222222222222.getLength() - i));
                            i8 = 0;
                            z = true;
                        }
                        outputText(readShort13, readShort12, readWord8, i6, i5, i4, i3, str2);
                        i = length;
                    case META_DIBSTRETCHBLT /*{ENCODED_INT: 2881}*/:
                    case META_STRETCHDIB /*{ENCODED_INT: 3907}*/:
                        metaDo.in.readInt();
                        if (readWord2 == 3907) {
                            metaDo.in.readWord();
                        }
                        int readShort14 = metaDo.in.readShort();
                        int readShort15 = metaDo.in.readShort();
                        int readShort16 = metaDo.in.readShort();
                        int readShort17 = metaDo.in.readShort();
                        float transformY20 = metaDo.state.transformY(metaDo.in.readShort()) - metaDo.state.transformY(i8);
                        float transformX20 = metaDo.state.transformX(metaDo.in.readShort()) - metaDo.state.transformX(i8);
                        float transformY21 = metaDo.state.transformY(metaDo.in.readShort());
                        float transformX21 = metaDo.state.transformX(metaDo.in.readShort());
                        int length2 = (readInt * 2) - (metaDo.in.getLength() - length);
                        byte[] bArr3 = new byte[length2];
                        for (int i19 = 0; i19 < length2; i19++) {
                            bArr3[i19] = (byte) metaDo.in.readByte();
                        }
                        try {
                            Image image = BmpImage.getImage(new ByteArrayInputStream(bArr3), z, length2);
                            metaDo.cb.saveState();
                            metaDo.cb.rectangle(transformX21, transformY21, transformX20, transformY20);
                            metaDo.cb.clip();
                            metaDo.cb.newPath();
                            float f5 = (float) readShort15;
                            float f6 = (float) readShort14;
                            image.scaleAbsolute((image.getWidth() * transformX20) / f5, ((-transformY20) * image.getHeight()) / f6);
                            image.setAbsolutePosition(transformX21 - ((transformX20 * ((float) readShort17)) / f5), (transformY21 + ((transformY20 * ((float) readShort16)) / f6)) - image.getScaledHeight());
                            metaDo.cb.addImage(image);
                            metaDo.cb.restoreState();
                        } catch (Exception unused5) {
                        }
                        i = length;
                        break;
                    default:
                        i = length;
                        break;
                }
                InputMeta inputMeta2222222222222222222222222 = metaDo.in;
                inputMeta2222222222222222222222222.skip((readInt * 2) - (inputMeta2222222222222222222222222.getLength() - i));
                i8 = 0;
                z = true;
            }
        } else {
            throw new DocumentException(MessageLocalization.getComposedMessage("not.a.placeable.windows.metafile", new Object[0]));
        }
    }

    public void outputText(int i, int i2, int i3, int i4, int i5, int i6, int i7, String str) {
        MetaFont currentFont = this.state.getCurrentFont();
        float transformX = this.state.transformX(i);
        float transformY = this.state.transformY(i2);
        double transformAngle = (double) this.state.transformAngle(currentFont.getAngle());
        float sin = (float) Math.sin(transformAngle);
        float cos = (float) Math.cos(transformAngle);
        float fontSize = currentFont.getFontSize(this.state);
        BaseFont font = currentFont.getFont();
        int textAlign = this.state.getTextAlign();
        float widthPoint = font.getWidthPoint(str, fontSize);
        float fontDescriptor = font.getFontDescriptor(3, fontSize);
        float fontDescriptor2 = font.getFontDescriptor(8, fontSize);
        this.cb.saveState();
        this.cb.concatCTM(cos, sin, -sin, cos, transformX, transformY);
        float f = 0.0f;
        float f2 = (textAlign & 6) == 6 ? (-widthPoint) / 2.0f : (textAlign & 2) == 2 ? -widthPoint : 0.0f;
        if ((textAlign & 24) != 24) {
            f = (textAlign & 8) == 8 ? -fontDescriptor : -fontDescriptor2;
        }
        if (this.state.getBackgroundMode() == 2) {
            this.cb.setColorFill(this.state.getCurrentBackgroundColor());
            this.cb.rectangle(f2, f + fontDescriptor, widthPoint, fontDescriptor2 - fontDescriptor);
            this.cb.fill();
        }
        this.cb.setColorFill(this.state.getCurrentTextColor());
        this.cb.beginText();
        this.cb.setFontAndSize(font, fontSize);
        this.cb.setTextMatrix(f2, f);
        this.cb.showText(str);
        this.cb.endText();
        if (currentFont.isUnderline()) {
            this.cb.rectangle(f2, f - (fontSize / 4.0f), widthPoint, fontSize / 15.0f);
            this.cb.fill();
        }
        if (currentFont.isStrikeout()) {
            this.cb.rectangle(f2, f + (fontSize / 3.0f), widthPoint, fontSize / 15.0f);
            this.cb.fill();
        }
        this.cb.restoreState();
    }

    public boolean isNullStrokeFill(boolean z) {
        MetaPen currentPen = this.state.getCurrentPen();
        MetaBrush currentBrush = this.state.getCurrentBrush();
        boolean z2 = true;
        boolean z3 = currentPen.getStyle() == 5;
        int style = currentBrush.getStyle();
        boolean z4 = style == 0 || (style == 2 && this.state.getBackgroundMode() == 2);
        if (!z3 || z4) {
            z2 = false;
        }
        if (!z3) {
            if (z) {
                this.state.setLineJoinRectangle(this.cb);
            } else {
                this.state.setLineJoinPolygon(this.cb);
            }
        }
        return z2;
    }

    public void strokeAndFill() {
        MetaPen currentPen = this.state.getCurrentPen();
        MetaBrush currentBrush = this.state.getCurrentBrush();
        int style = currentPen.getStyle();
        int style2 = currentBrush.getStyle();
        if (style == 5) {
            this.cb.closePath();
            if (this.state.getPolyFillMode() == 1) {
                this.cb.eoFill();
            } else {
                this.cb.fill();
            }
        } else {
            if (!(style2 == 0 || (style2 == 2 && this.state.getBackgroundMode() == 2))) {
                this.cb.closePathStroke();
            } else if (this.state.getPolyFillMode() == 1) {
                this.cb.closePathEoFillStroke();
            } else {
                this.cb.closePathFillStroke();
            }
        }
    }

    static float getArc(float f, float f2, float f3, float f4) {
        return (float) getArc((double) f, (double) f2, (double) f3, (double) f4);
    }

    static double getArc(double d, double d2, double d3, double d4) {
        double atan2 = Math.atan2(d4 - d2, d3 - d);
        if (atan2 < 0.0d) {
            atan2 += 6.283185307179586d;
        }
        return (double) ((float) ((atan2 / 3.141592653589793d) * 180.0d));
    }

    public static byte[] wrapBMP(Image image) throws IOException {
        byte[] bArr;
        if (image.getOriginalType() == 4) {
            if (image.getOriginalData() == null) {
                InputStream openStream = image.getUrl().openStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = openStream.read();
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(read);
                }
                openStream.close();
                bArr = byteArrayOutputStream.toByteArray();
            } else {
                bArr = image.getOriginalData();
            }
            int length = ((bArr.length - 14) + 1) >>> 1;
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            writeWord(byteArrayOutputStream2, 1);
            writeWord(byteArrayOutputStream2, 9);
            writeWord(byteArrayOutputStream2, DTrees.PREDICT_MASK);
            writeDWord(byteArrayOutputStream2, length + 36 + 3);
            writeWord(byteArrayOutputStream2, 1);
            writeDWord(byteArrayOutputStream2, length + 14);
            writeWord(byteArrayOutputStream2, 0);
            writeDWord(byteArrayOutputStream2, 4);
            writeWord(byteArrayOutputStream2, 259);
            writeWord(byteArrayOutputStream2, 8);
            writeDWord(byteArrayOutputStream2, 5);
            writeWord(byteArrayOutputStream2, META_SETWINDOWORG);
            writeWord(byteArrayOutputStream2, 0);
            writeWord(byteArrayOutputStream2, 0);
            writeDWord(byteArrayOutputStream2, 5);
            writeWord(byteArrayOutputStream2, META_SETWINDOWEXT);
            writeWord(byteArrayOutputStream2, (int) image.getHeight());
            writeWord(byteArrayOutputStream2, (int) image.getWidth());
            writeDWord(byteArrayOutputStream2, length + 13);
            writeWord(byteArrayOutputStream2, META_DIBSTRETCHBLT);
            writeDWord(byteArrayOutputStream2, 13369376);
            writeWord(byteArrayOutputStream2, (int) image.getHeight());
            writeWord(byteArrayOutputStream2, (int) image.getWidth());
            writeWord(byteArrayOutputStream2, 0);
            writeWord(byteArrayOutputStream2, 0);
            writeWord(byteArrayOutputStream2, (int) image.getHeight());
            writeWord(byteArrayOutputStream2, (int) image.getWidth());
            writeWord(byteArrayOutputStream2, 0);
            writeWord(byteArrayOutputStream2, 0);
            byteArrayOutputStream2.write(bArr, 14, bArr.length - 14);
            if ((bArr.length & 1) == 1) {
                byteArrayOutputStream2.write(0);
            }
            writeDWord(byteArrayOutputStream2, 3);
            writeWord(byteArrayOutputStream2, 0);
            byteArrayOutputStream2.close();
            return byteArrayOutputStream2.toByteArray();
        }
        throw new IOException(MessageLocalization.getComposedMessage("only.bmp.can.be.wrapped.in.wmf", new Object[0]));
    }

    public static void writeWord(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >>> 8) & 255);
    }

    public static void writeDWord(OutputStream outputStream, int i) throws IOException {
        writeWord(outputStream, i & 65535);
        writeWord(outputStream, (i >>> 16) & 65535);
    }
}
