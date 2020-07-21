package com.applex.snaplingo.util;

import java.io.File;

public class PDFFile {
    private boolean mIsEncrypted;
    private File mPdfFile;

    public PDFFile(File file, boolean z) {
        this.mPdfFile = file;
        this.mIsEncrypted = z;
    }

    public File getPdfFile() {
        return this.mPdfFile;
    }

    public void setPdfFile(File file) {
        this.mPdfFile = file;
    }

    public boolean isEncrypted() {
        return this.mIsEncrypted;
    }

    public void setEncrypted(boolean z) {
        this.mIsEncrypted = z;
    }
}
