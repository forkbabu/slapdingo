package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ListIterator;

public class ContentByteUtils {
    private ContentByteUtils() {
    }

    public static byte[] getContentBytesFromContentObject(PdfObject pdfObject) throws IOException {
        int type = pdfObject.type();
        if (type == 5) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ListIterator<PdfObject> listIterator = ((PdfArray) pdfObject).listIterator();
            while (listIterator.hasNext()) {
                byteArrayOutputStream.write(getContentBytesFromContentObject(listIterator.next()));
                byteArrayOutputStream.write(32);
            }
            return byteArrayOutputStream.toByteArray();
        } else if (type == 7) {
            return PdfReader.getStreamBytes((PRStream) PdfReader.getPdfObjectRelease(pdfObject));
        } else {
            if (type == 10) {
                return getContentBytesFromContentObject(PdfReader.getPdfObjectRelease((PRIndirectReference) pdfObject));
            }
            throw new IllegalStateException("Unable to handle Content of type " + pdfObject.getClass());
        }
    }

    public static byte[] getContentBytesForPage(PdfReader pdfReader, int i) throws IOException {
        PdfObject pdfObject = pdfReader.getPageN(i).get(PdfName.CONTENTS);
        if (pdfObject == null) {
            return new byte[0];
        }
        return getContentBytesFromContentObject(pdfObject);
    }
}
