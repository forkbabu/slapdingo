package com.itextpdf.text.xml.simpleparser;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.text.xml.simpleparser.handler.HTMLNewLineHandler;
import com.itextpdf.text.xml.simpleparser.handler.NeverNewLineHandler;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Stack;

public final class SimpleXMLParser {
    private static final int ATTRIBUTE_EQUAL = 13;
    private static final int ATTRIBUTE_KEY = 12;
    private static final int ATTRIBUTE_VALUE = 14;
    private static final int CDATA = 7;
    private static final int COMMENT = 8;
    private static final int ENTITY = 10;
    private static final int EXAMIN_TAG = 3;
    private static final int IN_CLOSETAG = 5;
    private static final int PI = 9;
    private static final int QUOTE = 11;
    private static final int SINGLE_TAG = 6;
    private static final int TAG_ENCOUNTERED = 2;
    private static final int TAG_EXAMINED = 4;
    private static final int TEXT = 1;
    private static final int UNKNOWN = 0;
    private String attributekey = null;
    private HashMap<String, String> attributes = null;
    private String attributevalue = null;
    private int character = 0;
    private int columns = 0;
    private final SimpleXMLDocHandlerComment comment;
    private final SimpleXMLDocHandler doc;
    private final StringBuffer entity = new StringBuffer();
    private boolean eol = false;
    private final boolean html;
    private int lines = 1;
    private int nested = 0;
    private NewLineHandler newLineHandler;
    private boolean nowhite = false;
    private int previousCharacter = -1;
    private int quoteCharacter = 34;
    private final Stack<Integer> stack;
    private int state;
    private String tag = null;
    private final StringBuffer text = new StringBuffer();

    private SimpleXMLParser(SimpleXMLDocHandler simpleXMLDocHandler, SimpleXMLDocHandlerComment simpleXMLDocHandlerComment, boolean z) {
        this.doc = simpleXMLDocHandler;
        this.comment = simpleXMLDocHandlerComment;
        this.html = z;
        if (z) {
            this.newLineHandler = new HTMLNewLineHandler();
        } else {
            this.newLineHandler = new NeverNewLineHandler();
        }
        this.stack = new Stack<>();
        this.state = z ? 1 : 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0016, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void go(java.io.Reader r17) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            boolean r2 = r1 instanceof java.io.BufferedReader
            if (r2 == 0) goto L_0x000b
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1
            goto L_0x0011
        L_0x000b:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            r2.<init>(r1)
            r1 = r2
        L_0x0011:
            com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler r2 = r0.doc
            r2.startDocument()
        L_0x0016:
            int r2 = r0.previousCharacter
            r3 = -1
            if (r2 != r3) goto L_0x0022
            int r2 = r1.read()
            r0.character = r2
            goto L_0x0026
        L_0x0022:
            r0.character = r2
            r0.previousCharacter = r3
        L_0x0026:
            int r2 = r0.character
            r4 = 1
            r5 = 0
            if (r2 != r3) goto L_0x004b
            boolean r1 = r0.html
            if (r1 == 0) goto L_0x003f
            if (r1 == 0) goto L_0x0039
            int r1 = r0.state
            if (r1 != r4) goto L_0x0039
            r16.flush()
        L_0x0039:
            com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler r1 = r0.doc
            r1.endDocument()
            goto L_0x004a
        L_0x003f:
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = "missing.end.tag"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r2, r1)
            r0.throwException(r1)
        L_0x004a:
            return
        L_0x004b:
            r3 = 10
            if (r2 != r3) goto L_0x0056
            boolean r2 = r0.eol
            if (r2 == 0) goto L_0x0056
            r0.eol = r5
            goto L_0x0016
        L_0x0056:
            boolean r2 = r0.eol
            r6 = 13
            if (r2 == 0) goto L_0x005f
            r0.eol = r5
            goto L_0x007e
        L_0x005f:
            int r2 = r0.character
            if (r2 != r3) goto L_0x006b
            int r2 = r0.lines
            int r2 = r2 + r4
            r0.lines = r2
            r0.columns = r5
            goto L_0x007e
        L_0x006b:
            if (r2 != r6) goto L_0x0079
            r0.eol = r4
            r0.character = r3
            int r2 = r0.lines
            int r2 = r2 + r4
            r0.lines = r2
            r0.columns = r5
            goto L_0x007e
        L_0x0079:
            int r2 = r0.columns
            int r2 = r2 + r4
            r0.columns = r2
        L_0x007e:
            int r2 = r0.state
            java.lang.String r7 = "error.in.attribute.processing"
            r8 = 12
            r11 = 14
            r12 = 61
            r14 = 4
            r15 = 6
            r13 = 38
            r10 = 47
            r9 = 32
            r3 = 62
            switch(r2) {
                case 0: goto L_0x04a3;
                case 1: goto L_0x0432;
                case 2: goto L_0x040e;
                case 3: goto L_0x0385;
                case 4: goto L_0x0358;
                case 5: goto L_0x032c;
                case 6: goto L_0x02f7;
                case 7: goto L_0x02c5;
                case 8: goto L_0x0293;
                case 9: goto L_0x0283;
                case 10: goto L_0x0200;
                case 11: goto L_0x0181;
                case 12: goto L_0x0143;
                case 13: goto L_0x00ea;
                case 14: goto L_0x0096;
                default: goto L_0x0095;
            }
        L_0x0095:
            goto L_0x0016
        L_0x0096:
            int r2 = r0.character
            r6 = 34
            r8 = 11
            if (r2 == r6) goto L_0x00e2
            r6 = 39
            if (r2 != r6) goto L_0x00a3
            goto L_0x00e2
        L_0x00a3:
            char r2 = (char) r2
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x00ac
            goto L_0x0016
        L_0x00ac:
            boolean r2 = r0.html
            if (r2 == 0) goto L_0x00c5
            int r2 = r0.character
            if (r2 != r3) goto L_0x00c5
            r16.flush()
            r0.processTag(r4)
            r16.initTag()
            int r2 = r16.restoreState()
            r0.state = r2
            goto L_0x0016
        L_0x00c5:
            boolean r2 = r0.html
            if (r2 == 0) goto L_0x00d7
            java.lang.StringBuffer r2 = r0.text
            int r3 = r0.character
            char r3 = (char) r3
            r2.append(r3)
            r0.quoteCharacter = r9
            r0.state = r8
            goto L_0x0016
        L_0x00d7:
            java.lang.Object[] r2 = new java.lang.Object[r5]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r7, r2)
            r0.throwException(r2)
            goto L_0x0016
        L_0x00e2:
            int r2 = r0.character
            r0.quoteCharacter = r2
            r0.state = r8
            goto L_0x0016
        L_0x00ea:
            int r2 = r0.character
            if (r2 != r12) goto L_0x00f2
            r0.state = r11
            goto L_0x0016
        L_0x00f2:
            char r2 = (char) r2
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x00fb
            goto L_0x0016
        L_0x00fb:
            boolean r2 = r0.html
            if (r2 == 0) goto L_0x0116
            int r2 = r0.character
            if (r2 != r3) goto L_0x0116
            java.lang.StringBuffer r2 = r0.text
            r2.setLength(r5)
            r0.processTag(r4)
            r16.initTag()
            int r2 = r16.restoreState()
            r0.state = r2
            goto L_0x0016
        L_0x0116:
            boolean r2 = r0.html
            if (r2 == 0) goto L_0x0125
            int r2 = r0.character
            if (r2 != r10) goto L_0x0125
            r16.flush()
            r0.state = r15
            goto L_0x0016
        L_0x0125:
            boolean r2 = r0.html
            if (r2 == 0) goto L_0x0138
            r16.flush()
            java.lang.StringBuffer r2 = r0.text
            int r3 = r0.character
            char r3 = (char) r3
            r2.append(r3)
            r0.state = r8
            goto L_0x0016
        L_0x0138:
            java.lang.Object[] r2 = new java.lang.Object[r5]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r7, r2)
            r0.throwException(r2)
            goto L_0x0016
        L_0x0143:
            int r2 = r0.character
            char r2 = (char) r2
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x0153
            r16.flush()
            r0.state = r6
            goto L_0x0016
        L_0x0153:
            int r2 = r0.character
            if (r2 != r12) goto L_0x015e
            r16.flush()
            r0.state = r11
            goto L_0x0016
        L_0x015e:
            boolean r6 = r0.html
            if (r6 == 0) goto L_0x0177
            if (r2 != r3) goto L_0x0177
            java.lang.StringBuffer r2 = r0.text
            r2.setLength(r5)
            r0.processTag(r4)
            r16.initTag()
            int r2 = r16.restoreState()
            r0.state = r2
            goto L_0x0016
        L_0x0177:
            java.lang.StringBuffer r2 = r0.text
            int r3 = r0.character
            char r3 = (char) r3
            r2.append(r3)
            goto L_0x0016
        L_0x0181:
            boolean r2 = r0.html
            if (r2 == 0) goto L_0x019e
            int r2 = r0.quoteCharacter
            if (r2 != r9) goto L_0x019e
            int r2 = r0.character
            if (r2 != r3) goto L_0x019e
            r16.flush()
            r0.processTag(r4)
            r16.initTag()
            int r2 = r16.restoreState()
            r0.state = r2
            goto L_0x0016
        L_0x019e:
            boolean r2 = r0.html
            if (r2 == 0) goto L_0x01b6
            int r2 = r0.quoteCharacter
            if (r2 != r9) goto L_0x01b6
            int r2 = r0.character
            char r2 = (char) r2
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x01b6
            r16.flush()
            r0.state = r14
            goto L_0x0016
        L_0x01b6:
            boolean r2 = r0.html
            if (r2 == 0) goto L_0x01c8
            int r2 = r0.quoteCharacter
            if (r2 != r9) goto L_0x01c8
            java.lang.StringBuffer r2 = r0.text
            int r3 = r0.character
            char r3 = (char) r3
            r2.append(r3)
            goto L_0x0016
        L_0x01c8:
            int r2 = r0.character
            int r3 = r0.quoteCharacter
            if (r2 != r3) goto L_0x01d5
            r16.flush()
            r0.state = r14
            goto L_0x0016
        L_0x01d5:
            java.lang.String r3 = " \r\n\t"
            int r2 = r3.indexOf(r2)
            if (r2 < 0) goto L_0x01e4
            java.lang.StringBuffer r2 = r0.text
            r2.append(r9)
            goto L_0x0016
        L_0x01e4:
            int r2 = r0.character
            if (r2 != r13) goto L_0x01f8
            int r2 = r0.state
            r0.saveState(r2)
            r2 = 10
            r0.state = r2
            java.lang.StringBuffer r2 = r0.entity
            r2.setLength(r5)
            goto L_0x0016
        L_0x01f8:
            java.lang.StringBuffer r3 = r0.text
            char r2 = (char) r2
            r3.append(r2)
            goto L_0x0016
        L_0x0200:
            int r2 = r0.character
            r3 = 59
            if (r2 != r3) goto L_0x0231
            int r2 = r16.restoreState()
            r0.state = r2
            java.lang.StringBuffer r2 = r0.entity
            java.lang.String r2 = r2.toString()
            java.lang.StringBuffer r4 = r0.entity
            r4.setLength(r5)
            char r4 = com.itextpdf.text.xml.simpleparser.EntitiesToUnicode.decodeEntity(r2)
            if (r4 != 0) goto L_0x022a
            java.lang.StringBuffer r4 = r0.text
            r4.append(r13)
            r4.append(r2)
            r4.append(r3)
            goto L_0x0016
        L_0x022a:
            java.lang.StringBuffer r2 = r0.text
            r2.append(r4)
            goto L_0x0016
        L_0x0231:
            r3 = 35
            if (r2 == r3) goto L_0x0251
            r3 = 48
            if (r2 < r3) goto L_0x023d
            r3 = 57
            if (r2 <= r3) goto L_0x0251
        L_0x023d:
            int r2 = r0.character
            r3 = 97
            if (r2 < r3) goto L_0x0247
            r3 = 122(0x7a, float:1.71E-43)
            if (r2 <= r3) goto L_0x0251
        L_0x0247:
            int r2 = r0.character
            r3 = 65
            if (r2 < r3) goto L_0x025a
            r3 = 90
            if (r2 > r3) goto L_0x025a
        L_0x0251:
            java.lang.StringBuffer r2 = r0.entity
            int r2 = r2.length()
            r3 = 7
            if (r2 < r3) goto L_0x0279
        L_0x025a:
            int r2 = r16.restoreState()
            r0.state = r2
            int r2 = r0.character
            r0.previousCharacter = r2
            java.lang.StringBuffer r2 = r0.text
            r2.append(r13)
            java.lang.StringBuffer r3 = r0.entity
            java.lang.String r3 = r3.toString()
            r2.append(r3)
            java.lang.StringBuffer r2 = r0.entity
            r2.setLength(r5)
            goto L_0x0016
        L_0x0279:
            java.lang.StringBuffer r2 = r0.entity
            int r3 = r0.character
            char r3 = (char) r3
            r2.append(r3)
            goto L_0x0016
        L_0x0283:
            int r2 = r0.character
            if (r2 != r3) goto L_0x0016
            int r2 = r16.restoreState()
            r0.state = r2
            if (r2 != r4) goto L_0x0016
            r0.state = r5
            goto L_0x0016
        L_0x0293:
            int r2 = r0.character
            if (r2 != r3) goto L_0x02bb
            java.lang.StringBuffer r2 = r0.text
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "--"
            boolean r2 = r2.endsWith(r3)
            if (r2 == 0) goto L_0x02bb
            java.lang.StringBuffer r2 = r0.text
            int r3 = r2.length()
            r4 = 2
            int r3 = r3 - r4
            r2.setLength(r3)
            r16.flush()
            int r2 = r16.restoreState()
            r0.state = r2
            goto L_0x0016
        L_0x02bb:
            java.lang.StringBuffer r2 = r0.text
            int r3 = r0.character
            char r3 = (char) r3
            r2.append(r3)
            goto L_0x0016
        L_0x02c5:
            int r2 = r0.character
            if (r2 != r3) goto L_0x02ed
            java.lang.StringBuffer r2 = r0.text
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "]]"
            boolean r2 = r2.endsWith(r3)
            if (r2 == 0) goto L_0x02ed
            java.lang.StringBuffer r2 = r0.text
            int r3 = r2.length()
            r4 = 2
            int r3 = r3 - r4
            r2.setLength(r3)
            r16.flush()
            int r2 = r16.restoreState()
            r0.state = r2
            goto L_0x0016
        L_0x02ed:
            java.lang.StringBuffer r2 = r0.text
            int r3 = r0.character
            char r3 = (char) r3
            r2.append(r3)
            goto L_0x0016
        L_0x02f7:
            int r2 = r0.character
            if (r2 == r3) goto L_0x030a
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r3 = r0.tag
            r2[r5] = r3
            java.lang.String r3 = "expected.gt.for.tag.lt.1.gt"
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r3, r2)
            r0.throwException(r2)
        L_0x030a:
            r16.doTag()
            r0.processTag(r4)
            r0.processTag(r5)
            r16.initTag()
            boolean r2 = r0.html
            if (r2 != 0) goto L_0x0324
            int r2 = r0.nested
            if (r2 != 0) goto L_0x0324
            com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler r1 = r0.doc
            r1.endDocument()
            return
        L_0x0324:
            int r2 = r16.restoreState()
            r0.state = r2
            goto L_0x0016
        L_0x032c:
            int r2 = r0.character
            if (r2 != r3) goto L_0x0347
            r16.doTag()
            r0.processTag(r5)
            boolean r2 = r0.html
            if (r2 != 0) goto L_0x033f
            int r2 = r0.nested
            if (r2 != 0) goto L_0x033f
            return
        L_0x033f:
            int r2 = r16.restoreState()
            r0.state = r2
            goto L_0x0016
        L_0x0347:
            char r2 = (char) r2
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 != 0) goto L_0x0016
            java.lang.StringBuffer r2 = r0.text
            int r3 = r0.character
            char r3 = (char) r3
            r2.append(r3)
            goto L_0x0016
        L_0x0358:
            int r2 = r0.character
            if (r2 != r3) goto L_0x036a
            r0.processTag(r4)
            r16.initTag()
            int r2 = r16.restoreState()
            r0.state = r2
            goto L_0x0016
        L_0x036a:
            if (r2 != r10) goto L_0x0370
            r0.state = r15
            goto L_0x0016
        L_0x0370:
            char r2 = (char) r2
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x0379
            goto L_0x0016
        L_0x0379:
            java.lang.StringBuffer r2 = r0.text
            int r3 = r0.character
            char r3 = (char) r3
            r2.append(r3)
            r0.state = r8
            goto L_0x0016
        L_0x0385:
            int r2 = r0.character
            if (r2 != r3) goto L_0x039a
            r16.doTag()
            r0.processTag(r4)
            r16.initTag()
            int r2 = r16.restoreState()
            r0.state = r2
            goto L_0x0016
        L_0x039a:
            if (r2 != r10) goto L_0x03a0
            r0.state = r15
            goto L_0x0016
        L_0x03a0:
            r3 = 45
            if (r2 != r3) goto L_0x03bb
            java.lang.StringBuffer r2 = r0.text
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "!-"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x03bb
            r16.flush()
            r2 = 8
            r0.state = r2
            goto L_0x0016
        L_0x03bb:
            int r2 = r0.character
            r3 = 91
            if (r2 != r3) goto L_0x03d7
            java.lang.StringBuffer r2 = r0.text
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "![CDATA"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x03d7
            r16.flush()
            r2 = 7
            r0.state = r2
            goto L_0x0016
        L_0x03d7:
            int r2 = r0.character
            r3 = 69
            if (r2 != r3) goto L_0x03f4
            java.lang.StringBuffer r2 = r0.text
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "!DOCTYP"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x03f4
            r16.flush()
            r2 = 9
            r0.state = r2
            goto L_0x0016
        L_0x03f4:
            int r2 = r0.character
            char r2 = (char) r2
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x0404
            r16.doTag()
            r0.state = r14
            goto L_0x0016
        L_0x0404:
            java.lang.StringBuffer r2 = r0.text
            int r3 = r0.character
            char r3 = (char) r3
            r2.append(r3)
            goto L_0x0016
        L_0x040e:
            r16.initTag()
            int r2 = r0.character
            if (r2 != r10) goto L_0x041a
            r2 = 5
            r0.state = r2
            goto L_0x0016
        L_0x041a:
            r3 = 63
            if (r2 != r3) goto L_0x0427
            r16.restoreState()
            r2 = 9
            r0.state = r2
            goto L_0x0016
        L_0x0427:
            java.lang.StringBuffer r3 = r0.text
            char r2 = (char) r2
            r3.append(r2)
            r2 = 3
            r0.state = r2
            goto L_0x0016
        L_0x0432:
            int r3 = r0.character
            r6 = 60
            if (r3 != r6) goto L_0x0445
            r16.flush()
            int r2 = r0.state
            r0.saveState(r2)
            r2 = 2
            r0.state = r2
            goto L_0x0016
        L_0x0445:
            if (r3 != r13) goto L_0x0457
            r0.saveState(r2)
            java.lang.StringBuffer r2 = r0.entity
            r2.setLength(r5)
            r2 = 10
            r0.state = r2
            r0.nowhite = r4
            goto L_0x0016
        L_0x0457:
            if (r3 != r9) goto L_0x047a
            boolean r2 = r0.html
            if (r2 == 0) goto L_0x046a
            boolean r2 = r0.nowhite
            if (r2 == 0) goto L_0x046a
            java.lang.StringBuffer r2 = r0.text
            r2.append(r9)
            r0.nowhite = r5
            goto L_0x0016
        L_0x046a:
            boolean r2 = r0.nowhite
            if (r2 == 0) goto L_0x0476
            java.lang.StringBuffer r2 = r0.text
            int r3 = r0.character
            char r3 = (char) r3
            r2.append(r3)
        L_0x0476:
            r0.nowhite = r5
            goto L_0x0016
        L_0x047a:
            char r2 = (char) r3
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x0497
            boolean r2 = r0.html
            if (r2 == 0) goto L_0x0487
            goto L_0x0016
        L_0x0487:
            boolean r2 = r0.nowhite
            if (r2 == 0) goto L_0x0493
            java.lang.StringBuffer r2 = r0.text
            int r3 = r0.character
            char r3 = (char) r3
            r2.append(r3)
        L_0x0493:
            r0.nowhite = r5
            goto L_0x0016
        L_0x0497:
            java.lang.StringBuffer r2 = r0.text
            int r3 = r0.character
            char r3 = (char) r3
            r2.append(r3)
            r0.nowhite = r4
            goto L_0x0016
        L_0x04a3:
            int r2 = r0.character
            r3 = 60
            if (r2 != r3) goto L_0x0016
            r0.saveState(r4)
            r2 = 2
            r0.state = r2
            goto L_0x0016
            switch-data {0->0x04a3, 1->0x0432, 2->0x040e, 3->0x0385, 4->0x0358, 5->0x032c, 6->0x02f7, 7->0x02c5, 8->0x0293, 9->0x0283, 10->0x0200, 11->0x0181, 12->0x0143, 13->0x00ea, 14->0x0096, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.xml.simpleparser.SimpleXMLParser.go(java.io.Reader):void");
    }

    private int restoreState() {
        if (!this.stack.empty()) {
            return this.stack.pop().intValue();
        }
        return 0;
    }

    private void saveState(int i) {
        this.stack.push(Integer.valueOf(i));
    }

    private void flush() {
        int i = this.state;
        if (i != 1) {
            if (i != 14) {
                if (i != 7) {
                    if (i == 8) {
                        SimpleXMLDocHandlerComment simpleXMLDocHandlerComment = this.comment;
                        if (simpleXMLDocHandlerComment != null) {
                            simpleXMLDocHandlerComment.comment(this.text.toString());
                        }
                    } else if (i != 11) {
                        if (i == 12) {
                            String stringBuffer = this.text.toString();
                            this.attributekey = stringBuffer;
                            if (this.html) {
                                this.attributekey = stringBuffer.toLowerCase();
                            }
                        }
                    }
                    this.text.setLength(0);
                }
            }
            String stringBuffer2 = this.text.toString();
            this.attributevalue = stringBuffer2;
            this.attributes.put(this.attributekey, stringBuffer2);
            this.text.setLength(0);
        }
        if (this.text.length() > 0) {
            this.doc.text(this.text.toString());
        }
        this.text.setLength(0);
    }

    private void initTag() {
        this.tag = null;
        this.attributes = new HashMap<>();
    }

    private void doTag() {
        if (this.tag == null) {
            this.tag = this.text.toString();
        }
        if (this.html) {
            this.tag = this.tag.toLowerCase();
        }
        this.text.setLength(0);
    }

    private void processTag(boolean z) {
        if (z) {
            this.nested++;
            this.doc.startElement(this.tag, this.attributes);
            return;
        }
        if (this.newLineHandler.isNewLineTag(this.tag)) {
            this.nowhite = false;
        }
        this.nested--;
        this.doc.endElement(this.tag);
    }

    private void throwException(String str) throws IOException {
        throw new IOException(MessageLocalization.getComposedMessage("1.near.line.2.column.3", str, String.valueOf(this.lines), String.valueOf(this.columns)));
    }

    public static void parse(SimpleXMLDocHandler simpleXMLDocHandler, SimpleXMLDocHandlerComment simpleXMLDocHandlerComment, Reader reader, boolean z) throws IOException {
        new SimpleXMLParser(simpleXMLDocHandler, simpleXMLDocHandlerComment, z).go(reader);
    }

    public static void parse(SimpleXMLDocHandler simpleXMLDocHandler, InputStream inputStream) throws IOException {
        String declaredEncoding;
        byte[] bArr = new byte[4];
        if (inputStream.read(bArr) == 4) {
            String encodingName = XMLUtil.getEncodingName(bArr);
            String str = null;
            if (encodingName.equals(XmpWriter.UTF8)) {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int read = inputStream.read();
                    if (read == -1 || read == 62) {
                        str = stringBuffer.toString();
                    } else {
                        stringBuffer.append((char) read);
                    }
                }
                str = stringBuffer.toString();
            } else if (encodingName.equals("CP037")) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read2 = inputStream.read();
                    if (read2 == -1 || read2 == 110) {
                        str = new String(byteArrayOutputStream.toByteArray(), "CP037");
                    } else {
                        byteArrayOutputStream.write(read2);
                    }
                }
                str = new String(byteArrayOutputStream.toByteArray(), "CP037");
            }
            if (!(str == null || (declaredEncoding = getDeclaredEncoding(str)) == null)) {
                encodingName = declaredEncoding;
            }
            parse(simpleXMLDocHandler, new InputStreamReader(inputStream, IanaEncodings.getJavaEncoding(encodingName)));
            return;
        }
        throw new IOException(MessageLocalization.getComposedMessage("insufficient.length", new Object[0]));
    }

    private static String getDeclaredEncoding(String str) {
        int indexOf;
        int indexOf2;
        int indexOf3;
        int i;
        int indexOf4;
        if (str == null || (indexOf = str.indexOf(HtmlTags.ENCODING)) < 0 || (indexOf2 = str.indexOf(34, indexOf)) == (indexOf3 = str.indexOf(39, indexOf))) {
            return null;
        }
        if ((indexOf2 < 0 && indexOf3 > 0) || (indexOf3 > 0 && indexOf3 < indexOf2)) {
            int i2 = indexOf3 + 1;
            int indexOf5 = str.indexOf(39, i2);
            if (indexOf5 < 0) {
                return null;
            }
            return str.substring(i2, indexOf5);
        } else if (((indexOf3 >= 0 || indexOf2 <= 0) && (indexOf2 <= 0 || indexOf2 >= indexOf3)) || (indexOf4 = str.indexOf(34, (i = indexOf2 + 1))) < 0) {
            return null;
        } else {
            return str.substring(i, indexOf4);
        }
    }

    public static void parse(SimpleXMLDocHandler simpleXMLDocHandler, Reader reader) throws IOException {
        parse(simpleXMLDocHandler, null, reader, false);
    }

    @Deprecated
    public static String escapeXML(String str, boolean z) {
        return XMLUtil.escapeXML(str, z);
    }
}
