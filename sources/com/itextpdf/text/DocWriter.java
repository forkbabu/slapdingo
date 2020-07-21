package com.itextpdf.text;

import com.itextpdf.text.pdf.OutputStreamCounter;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public abstract class DocWriter implements DocListener {
    public static final byte EQUALS = 61;
    public static final byte FORWARD = 47;
    public static final byte GT = 62;
    public static final byte LT = 60;
    public static final byte NEWLINE = 10;
    public static final byte QUOTE = 34;
    public static final byte SPACE = 32;
    public static final byte TAB = 9;
    protected boolean closeStream = true;
    protected Document document;
    protected boolean open = false;
    protected OutputStreamCounter os;
    protected Rectangle pageSize;
    protected boolean pause = false;

    @Override // com.itextpdf.text.ElementListener
    public boolean add(Element element) throws DocumentException {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public void resetPageCount() {
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMarginMirroring(boolean z) {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMarginMirroringTopBottom(boolean z) {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMargins(float f, float f2, float f3, float f4) {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public void setPageCount(int i) {
    }

    protected DocWriter() {
    }

    protected DocWriter(Document document2, OutputStream outputStream) {
        this.document = document2;
        this.os = new OutputStreamCounter(new BufferedOutputStream(outputStream));
    }

    @Override // com.itextpdf.text.DocListener
    public void open() {
        this.open = true;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setPageSize(Rectangle rectangle) {
        this.pageSize = rectangle;
        return true;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean newPage() {
        return this.open;
    }

    @Override // com.itextpdf.text.DocListener
    public void close() {
        this.open = false;
        try {
            this.os.flush();
            if (this.closeStream) {
                this.os.close();
            }
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static final byte[] getISOBytes(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public void pause() {
        this.pause = true;
    }

    public boolean isPaused() {
        return this.pause;
    }

    public void resume() {
        this.pause = false;
    }

    public void flush() {
        try {
            this.os.flush();
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    public void write(String str) throws IOException {
        this.os.write(getISOBytes(str));
    }

    /* access modifiers changed from: protected */
    public void addTabs(int i) throws IOException {
        this.os.write(10);
        for (int i2 = 0; i2 < i; i2++) {
            this.os.write(9);
        }
    }

    /* access modifiers changed from: protected */
    public void write(String str, String str2) throws IOException {
        this.os.write(32);
        write(str);
        this.os.write(61);
        this.os.write(34);
        write(str2);
        this.os.write(34);
    }

    /* access modifiers changed from: protected */
    public void writeStart(String str) throws IOException {
        this.os.write(60);
        write(str);
    }

    /* access modifiers changed from: protected */
    public void writeEnd(String str) throws IOException {
        this.os.write(60);
        this.os.write(47);
        write(str);
        this.os.write(62);
    }

    /* access modifiers changed from: protected */
    public void writeEnd() throws IOException {
        this.os.write(32);
        this.os.write(47);
        this.os.write(62);
    }

    /* access modifiers changed from: protected */
    public boolean writeMarkupAttributes(Properties properties) throws IOException {
        if (properties == null) {
            return false;
        }
        for (Object obj : properties.keySet()) {
            String valueOf = String.valueOf(obj);
            write(valueOf, properties.getProperty(valueOf));
        }
        properties.clear();
        return true;
    }

    public boolean isCloseStream() {
        return this.closeStream;
    }

    public void setCloseStream(boolean z) {
        this.closeStream = z;
    }
}
