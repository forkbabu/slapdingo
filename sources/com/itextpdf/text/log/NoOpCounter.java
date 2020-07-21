package com.itextpdf.text.log;

public class NoOpCounter implements Counter {
    @Override // com.itextpdf.text.log.Counter
    public Counter getCounter(Class<?> cls) {
        return this;
    }

    @Override // com.itextpdf.text.log.Counter
    public void read(long j) {
    }

    @Override // com.itextpdf.text.log.Counter
    public void written(long j) {
    }
}
