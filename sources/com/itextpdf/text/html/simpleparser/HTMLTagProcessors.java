package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.HtmlTags;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class HTMLTagProcessors extends HashMap<String, HTMLTagProcessor> {
    public static final HTMLTagProcessor A = new HTMLTagProcessor() {
        /* class com.itextpdf.text.html.simpleparser.HTMLTagProcessors.AnonymousClass2 */

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.updateChain(str, map);
            hTMLWorker.flushContent();
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.processLink();
            hTMLWorker.updateChain(str);
        }
    };
    public static final HTMLTagProcessor BR = new HTMLTagProcessor() {
        /* class com.itextpdf.text.html.simpleparser.HTMLTagProcessors.AnonymousClass3 */

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.newLine();
        }
    };
    public static final HTMLTagProcessor DIV = new HTMLTagProcessor() {
        /* class com.itextpdf.text.html.simpleparser.HTMLTagProcessors.AnonymousClass10 */

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str, map);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str);
        }
    };
    public static final HTMLTagProcessor EM_STRONG_STRIKE_SUP_SUP = new HTMLTagProcessor() {
        /* class com.itextpdf.text.html.simpleparser.HTMLTagProcessors.AnonymousClass1 */

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            String mapTag = mapTag(str);
            map.put(mapTag, null);
            hTMLWorker.updateChain(mapTag, map);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.updateChain(mapTag(str));
        }

        private String mapTag(String str) {
            if (HtmlTags.EM.equalsIgnoreCase(str)) {
                return HtmlTags.I;
            }
            if (HtmlTags.STRONG.equalsIgnoreCase(str)) {
                return HtmlTags.B;
            }
            return HtmlTags.STRIKE.equalsIgnoreCase(str) ? HtmlTags.S : str;
        }
    };
    public static final HTMLTagProcessor H = new HTMLTagProcessor() {
        /* class com.itextpdf.text.html.simpleparser.HTMLTagProcessors.AnonymousClass7 */

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (!map.containsKey(HtmlTags.SIZE)) {
                map.put(HtmlTags.SIZE, Integer.toString(7 - Integer.parseInt(str.substring(1))));
            }
            hTMLWorker.updateChain(str, map);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str);
        }
    };
    public static final HTMLTagProcessor HR = new HTMLTagProcessor() {
        /* class com.itextpdf.text.html.simpleparser.HTMLTagProcessors.AnonymousClass5 */

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.pushToStack(hTMLWorker.createLineSeparator(map));
        }
    };
    public static final HTMLTagProcessor IMG = new HTMLTagProcessor() {
        /* class com.itextpdf.text.html.simpleparser.HTMLTagProcessors.AnonymousClass14 */

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException, IOException {
            hTMLWorker.updateChain(str, map);
            hTMLWorker.processImage(hTMLWorker.createImage(map), map);
            hTMLWorker.updateChain(str);
        }
    };
    public static final HTMLTagProcessor LI = new HTMLTagProcessor() {
        /* class com.itextpdf.text.html.simpleparser.HTMLTagProcessors.AnonymousClass8 */

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingLI()) {
                hTMLWorker.endElement(str);
            }
            hTMLWorker.setSkipText(false);
            hTMLWorker.setPendingLI(true);
            hTMLWorker.updateChain(str, map);
            hTMLWorker.pushToStack(hTMLWorker.createListItem());
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.setPendingLI(false);
            hTMLWorker.setSkipText(true);
            hTMLWorker.updateChain(str);
            hTMLWorker.processListItem();
        }
    };
    public static final HTMLTagProcessor PRE = new HTMLTagProcessor() {
        /* class com.itextpdf.text.html.simpleparser.HTMLTagProcessors.AnonymousClass9 */

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (!map.containsKey(HtmlTags.FACE)) {
                map.put(HtmlTags.FACE, "Courier");
            }
            hTMLWorker.updateChain(str, map);
            hTMLWorker.setInsidePRE(true);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.updateChain(str);
            hTMLWorker.setInsidePRE(false);
        }
    };
    public static final HTMLTagProcessor SPAN = new HTMLTagProcessor() {
        /* class com.itextpdf.text.html.simpleparser.HTMLTagProcessors.AnonymousClass6 */

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) {
            hTMLWorker.updateChain(str, map);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) {
            hTMLWorker.updateChain(str);
        }
    };
    public static final HTMLTagProcessor TABLE = new HTMLTagProcessor() {
        /* class com.itextpdf.text.html.simpleparser.HTMLTagProcessors.AnonymousClass11 */

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.pushToStack(new TableWrapper(map));
            hTMLWorker.pushTableState();
            hTMLWorker.setPendingTD(false);
            hTMLWorker.setPendingTR(false);
            hTMLWorker.setSkipText(true);
            map.remove(HtmlTags.ALIGN);
            map.put(HtmlTags.COLSPAN, "1");
            map.put(HtmlTags.ROWSPAN, "1");
            hTMLWorker.updateChain(str, map);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTR()) {
                hTMLWorker.endElement(HtmlTags.TR);
            }
            hTMLWorker.updateChain(str);
            hTMLWorker.processTable();
            hTMLWorker.popTableState();
            hTMLWorker.setSkipText(false);
        }
    };
    public static final HTMLTagProcessor TD = new HTMLTagProcessor() {
        /* class com.itextpdf.text.html.simpleparser.HTMLTagProcessors.AnonymousClass13 */

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTD()) {
                hTMLWorker.endElement(str);
            }
            hTMLWorker.setSkipText(false);
            hTMLWorker.setPendingTD(true);
            hTMLWorker.updateChain(HtmlTags.TD, map);
            hTMLWorker.pushToStack(hTMLWorker.createCell(str));
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            hTMLWorker.setPendingTD(false);
            hTMLWorker.updateChain(HtmlTags.TD);
            hTMLWorker.setSkipText(true);
        }
    };
    public static final HTMLTagProcessor TR = new HTMLTagProcessor() {
        /* class com.itextpdf.text.html.simpleparser.HTMLTagProcessors.AnonymousClass12 */

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTR()) {
                hTMLWorker.endElement(str);
            }
            hTMLWorker.setSkipText(true);
            hTMLWorker.setPendingTR(true);
            hTMLWorker.updateChain(str, map);
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingTD()) {
                hTMLWorker.endElement(HtmlTags.TD);
            }
            hTMLWorker.setPendingTR(false);
            hTMLWorker.updateChain(str);
            hTMLWorker.processRow();
            hTMLWorker.setSkipText(true);
        }
    };
    public static final HTMLTagProcessor UL_OL = new HTMLTagProcessor() {
        /* class com.itextpdf.text.html.simpleparser.HTMLTagProcessors.AnonymousClass4 */

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingLI()) {
                hTMLWorker.endElement(HtmlTags.LI);
            }
            hTMLWorker.setSkipText(true);
            hTMLWorker.updateChain(str, map);
            hTMLWorker.pushToStack(hTMLWorker.createList(str));
        }

        @Override // com.itextpdf.text.html.simpleparser.HTMLTagProcessor
        public void endElement(HTMLWorker hTMLWorker, String str) throws DocumentException {
            hTMLWorker.carriageReturn();
            if (hTMLWorker.isPendingLI()) {
                hTMLWorker.endElement(HtmlTags.LI);
            }
            hTMLWorker.setSkipText(false);
            hTMLWorker.updateChain(str);
            hTMLWorker.processList();
        }
    };
    private static final long serialVersionUID = -959260811961222824L;

    public HTMLTagProcessors() {
        put(HtmlTags.A, A);
        put(HtmlTags.B, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.BODY, DIV);
        put(HtmlTags.BR, BR);
        put(HtmlTags.DIV, DIV);
        put(HtmlTags.EM, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.FONT, SPAN);
        put(HtmlTags.H1, H);
        put(HtmlTags.H2, H);
        put(HtmlTags.H3, H);
        put(HtmlTags.H4, H);
        put(HtmlTags.H5, H);
        put(HtmlTags.H6, H);
        put(HtmlTags.HR, HR);
        put(HtmlTags.I, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.IMG, IMG);
        put(HtmlTags.LI, LI);
        put(HtmlTags.OL, UL_OL);
        put(HtmlTags.P, DIV);
        put(HtmlTags.PRE, PRE);
        put(HtmlTags.S, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.SPAN, SPAN);
        put(HtmlTags.STRIKE, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.STRONG, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.SUB, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.SUP, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.TABLE, TABLE);
        put(HtmlTags.TD, TD);
        put(HtmlTags.TH, TD);
        put(HtmlTags.TR, TR);
        put(HtmlTags.U, EM_STRONG_STRIKE_SUP_SUP);
        put(HtmlTags.UL, UL_OL);
    }
}
