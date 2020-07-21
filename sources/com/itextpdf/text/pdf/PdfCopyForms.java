package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.List;

public class PdfCopyForms implements PdfViewerPreferences, PdfEncryptionSettings {
    private PdfCopyFormsImp fc;

    public PdfCopyForms(OutputStream outputStream) throws DocumentException {
        this.fc = new PdfCopyFormsImp(outputStream);
    }

    public void addDocument(PdfReader pdfReader) throws DocumentException, IOException {
        this.fc.addDocument(pdfReader);
    }

    public void addDocument(PdfReader pdfReader, List<Integer> list) throws DocumentException, IOException {
        this.fc.addDocument(pdfReader, list);
    }

    public void addDocument(PdfReader pdfReader, String str) throws DocumentException, IOException {
        this.fc.addDocument(pdfReader, SequenceList.expand(str, pdfReader.getNumberOfPages()));
    }

    public void copyDocumentFields(PdfReader pdfReader) throws DocumentException {
        this.fc.copyDocumentFields(pdfReader);
    }

    public void setEncryption(byte[] bArr, byte[] bArr2, int i, boolean z) throws DocumentException {
        this.fc.setEncryption(bArr, bArr2, i, z ? 1 : 0);
    }

    public void setEncryption(boolean z, String str, String str2, int i) throws DocumentException {
        setEncryption(DocWriter.getISOBytes(str), DocWriter.getISOBytes(str2), i, z);
    }

    public void close() {
        this.fc.close();
    }

    public void open() {
        this.fc.openDoc();
    }

    public void addJavaScript(String str) {
        this.fc.addJavaScript(str, !PdfEncodings.isPdfDocEncoding(str));
    }

    public void setOutlines(List<HashMap<String, Object>> list) {
        this.fc.setOutlines(list);
    }

    public PdfWriter getWriter() {
        return this.fc;
    }

    public boolean isFullCompression() {
        return this.fc.isFullCompression();
    }

    public void setFullCompression() throws DocumentException {
        this.fc.setFullCompression();
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings
    public void setEncryption(byte[] bArr, byte[] bArr2, int i, int i2) throws DocumentException {
        this.fc.setEncryption(bArr, bArr2, i, i2);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.fc.addViewerPreference(pdfName, pdfObject);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void setViewerPreferences(int i) {
        this.fc.setViewerPreferences(i);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings
    public void setEncryption(Certificate[] certificateArr, int[] iArr, int i) throws DocumentException {
        this.fc.setEncryption(certificateArr, iArr, i);
    }
}
