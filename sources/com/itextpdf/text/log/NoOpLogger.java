package com.itextpdf.text.log;

public final class NoOpLogger implements Logger {
    @Override // com.itextpdf.text.log.Logger
    public void debug(String str) {
    }

    @Override // com.itextpdf.text.log.Logger
    public void error(String str) {
    }

    @Override // com.itextpdf.text.log.Logger
    public void error(String str, Exception exc) {
    }

    @Override // com.itextpdf.text.log.Logger
    public Logger getLogger(Class<?> cls) {
        return this;
    }

    @Override // com.itextpdf.text.log.Logger
    public Logger getLogger(String str) {
        return this;
    }

    @Override // com.itextpdf.text.log.Logger
    public void info(String str) {
    }

    @Override // com.itextpdf.text.log.Logger
    public boolean isLogging(Level level) {
        return false;
    }

    @Override // com.itextpdf.text.log.Logger
    public void trace(String str) {
    }

    @Override // com.itextpdf.text.log.Logger
    public void warn(String str) {
    }
}
