package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FdfWriter {
    /* access modifiers changed from: private */
    public static final byte[] HEADER_FDF = DocWriter.getISOBytes("%FDF-1.4\n%âãÏÓ\n");
    protected Counter COUNTER = CounterFactory.getCounter(FdfWriter.class);
    HashMap<String, Object> fields = new HashMap<>();
    /* access modifiers changed from: private */
    public String file;
    /* access modifiers changed from: private */
    public String statusMessage;
    Wrt wrt = null;

    public FdfWriter() {
    }

    public FdfWriter(OutputStream outputStream) throws IOException {
        this.wrt = new Wrt(outputStream, this);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (this.wrt == null) {
            this.wrt = new Wrt(outputStream, this);
        }
        this.wrt.write();
    }

    public void write() throws IOException {
        this.wrt.write();
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    /* access modifiers changed from: package-private */
    public boolean setField(String str, PdfObject pdfObject) {
        HashMap<String, Object> hashMap = this.fields;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        while (true) {
            String nextToken = stringTokenizer.nextToken();
            Object obj = hashMap.get(nextToken);
            if (stringTokenizer.hasMoreTokens()) {
                if (obj == null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap.put(nextToken, hashMap2);
                    hashMap = hashMap2;
                } else if (!(obj instanceof HashMap)) {
                    return false;
                } else {
                    hashMap = (HashMap) obj;
                }
            } else if (obj instanceof HashMap) {
                return false;
            } else {
                hashMap.put(nextToken, pdfObject);
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void iterateFields(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, String str) {
        for (Map.Entry<String, Object> entry : hashMap2.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof HashMap) {
                iterateFields(hashMap, (HashMap) value, str + "." + key);
            } else {
                hashMap.put((str + "." + key).substring(1), value);
            }
        }
    }

    public boolean removeField(String str) {
        HashMap<String, Object> hashMap = this.fields;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            String nextToken = stringTokenizer.nextToken();
            Object obj = hashMap.get(nextToken);
            if (obj == null) {
                return false;
            }
            arrayList.add(hashMap);
            arrayList.add(nextToken);
            if (stringTokenizer.hasMoreTokens()) {
                if (!(obj instanceof HashMap)) {
                    return false;
                }
                hashMap = (HashMap) obj;
            } else if (obj instanceof HashMap) {
                return false;
            } else {
                for (int size = arrayList.size() - 2; size >= 0; size -= 2) {
                    HashMap hashMap2 = (HashMap) arrayList.get(size);
                    hashMap2.remove((String) arrayList.get(size + 1));
                    if (!hashMap2.isEmpty()) {
                        return true;
                    }
                }
                return true;
            }
        }
    }

    public HashMap<String, Object> getFields() {
        HashMap<String, Object> hashMap = new HashMap<>();
        iterateFields(hashMap, this.fields, "");
        return hashMap;
    }

    public String getField(String str) {
        HashMap<String, Object> hashMap = this.fields;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        while (true) {
            Object obj = hashMap.get(stringTokenizer.nextToken());
            if (obj == null) {
                return null;
            }
            if (stringTokenizer.hasMoreTokens()) {
                if (!(obj instanceof HashMap)) {
                    return null;
                }
                hashMap = (HashMap) obj;
            } else if (obj instanceof HashMap) {
                return null;
            } else {
                if (((PdfObject) obj).isString()) {
                    return ((PdfString) obj).toUnicodeString();
                }
                return PdfName.decodeName(obj.toString());
            }
        }
    }

    public boolean setFieldAsName(String str, String str2) {
        return setField(str, new PdfName(str2));
    }

    public boolean setFieldAsString(String str, String str2) {
        return setField(str, new PdfString(str2, PdfObject.TEXT_UNICODE));
    }

    public boolean setFieldAsAction(String str, PdfAction pdfAction) {
        return setField(str, pdfAction);
    }

    public boolean setFieldAsTemplate(String str, PdfTemplate pdfTemplate) {
        try {
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (pdfTemplate instanceof PdfImportedPage) {
                pdfDictionary.put(PdfName.N, pdfTemplate.getIndirectReference());
            } else {
                pdfDictionary.put(PdfName.N, this.wrt.addToBody(pdfTemplate.getFormXObject(0)).getIndirectReference());
            }
            return setField(str, pdfDictionary);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean setFieldAsImage(String str, Image image) {
        try {
            if (Float.isNaN(image.getAbsoluteX())) {
                image.setAbsolutePosition(0.0f, image.getAbsoluteY());
            }
            if (Float.isNaN(image.getAbsoluteY())) {
                image.setAbsolutePosition(image.getAbsoluteY(), 0.0f);
            }
            PdfTemplate createTemplate = PdfTemplate.createTemplate(this.wrt, image.getWidth(), image.getHeight());
            createTemplate.addImage(image);
            PdfObject indirectReference = this.wrt.addToBody(createTemplate.getFormXObject(0)).getIndirectReference();
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.N, indirectReference);
            return setField(str, pdfDictionary);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean setFieldAsJavascript(String str, PdfName pdfName, String str2) {
        PdfAnnotation createAnnotation = this.wrt.createAnnotation(null, null);
        createAnnotation.put(pdfName, PdfAction.javaScript(str2, this.wrt));
        return setField(str, createAnnotation);
    }

    public PdfImportedPage getImportedPage(PdfReader pdfReader, int i) {
        return this.wrt.getImportedPage(pdfReader, i);
    }

    public PdfTemplate createTemplate(float f, float f2) {
        return PdfTemplate.createTemplate(this.wrt, f, f2);
    }

    public void setFields(FdfReader fdfReader) {
        for (Map.Entry<String, PdfDictionary> entry : fdfReader.getFields().entrySet()) {
            String key = entry.getKey();
            PdfDictionary value = entry.getValue();
            PdfObject pdfObject = value.get(PdfName.V);
            if (pdfObject != null) {
                setField(key, pdfObject);
            }
            PdfObject pdfObject2 = value.get(PdfName.A);
            if (pdfObject2 != null) {
                setField(key, pdfObject2);
            }
        }
    }

    public void setFields(PdfReader pdfReader) {
        setFields(pdfReader.getAcroFields());
    }

    public void setFields(AcroFields acroFields) {
        PdfObject pdfObjectRelease;
        for (Map.Entry<String, AcroFields.Item> entry : acroFields.getFields().entrySet()) {
            String key = entry.getKey();
            PdfDictionary merged = entry.getValue().getMerged(0);
            PdfObject pdfObjectRelease2 = PdfReader.getPdfObjectRelease(merged.get(PdfName.V));
            if (!(pdfObjectRelease2 == null || (pdfObjectRelease = PdfReader.getPdfObjectRelease(merged.get(PdfName.FT))) == null || PdfName.SIG.equals(pdfObjectRelease))) {
                setField(key, pdfObjectRelease2);
            }
        }
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String str) {
        this.file = str;
    }

    static class Wrt extends PdfWriter {
        private FdfWriter fdf;

        Wrt(OutputStream outputStream, FdfWriter fdfWriter) throws IOException {
            super(new PdfDocument(), outputStream);
            this.fdf = fdfWriter;
            this.os.write(FdfWriter.HEADER_FDF);
            this.body = new PdfWriter.PdfBody(this);
        }

        /* access modifiers changed from: package-private */
        public void write() throws IOException {
            for (PdfReaderInstance pdfReaderInstance : this.readerInstances.values()) {
                this.currentPdfReaderInstance = pdfReaderInstance;
                this.currentPdfReaderInstance.writeAllPages();
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.FIELDS, calculate(this.fdf.fields));
            if (this.fdf.file != null) {
                pdfDictionary.put(PdfName.F, new PdfString(this.fdf.file, PdfObject.TEXT_UNICODE));
            }
            if (!(this.fdf.statusMessage == null || this.fdf.statusMessage.trim().length() == 0)) {
                pdfDictionary.put(PdfName.STATUS, new PdfString(this.fdf.statusMessage));
            }
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary2.put(PdfName.FDF, pdfDictionary);
            PdfObject indirectReference = addToBody(pdfDictionary2).getIndirectReference();
            this.os.write(getISOBytes("trailer\n"));
            PdfDictionary pdfDictionary3 = new PdfDictionary();
            pdfDictionary3.put(PdfName.ROOT, indirectReference);
            pdfDictionary3.toPdf(null, this.os);
            this.os.write(getISOBytes("\n%%EOF\n"));
            this.os.close();
        }

        /* access modifiers changed from: package-private */
        public PdfArray calculate(HashMap<String, Object> hashMap) throws IOException {
            PdfArray pdfArray = new PdfArray();
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                Object value = entry.getValue();
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.put(PdfName.T, new PdfString(entry.getKey(), PdfObject.TEXT_UNICODE));
                if (value instanceof HashMap) {
                    pdfDictionary.put(PdfName.KIDS, calculate((HashMap) value));
                } else if (value instanceof PdfAction) {
                    pdfDictionary.put(PdfName.A, (PdfAction) value);
                } else if (value instanceof PdfAnnotation) {
                    pdfDictionary.put(PdfName.AA, (PdfAnnotation) value);
                } else {
                    if (value instanceof PdfDictionary) {
                        PdfDictionary pdfDictionary2 = (PdfDictionary) value;
                        if (pdfDictionary2.size() == 1 && pdfDictionary2.contains(PdfName.N)) {
                            pdfDictionary.put(PdfName.AP, pdfDictionary2);
                        }
                    }
                    pdfDictionary.put(PdfName.V, (PdfObject) value);
                }
                pdfArray.add(pdfDictionary);
            }
            return pdfArray;
        }
    }

    /* access modifiers changed from: protected */
    public Counter getCounter() {
        return this.COUNTER;
    }
}
