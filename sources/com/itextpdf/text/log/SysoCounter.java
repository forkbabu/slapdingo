package com.itextpdf.text.log;

public class SysoCounter implements Counter {
    protected String name;

    public SysoCounter() {
        this.name = "iText";
    }

    protected SysoCounter(Class<?> cls) {
        this.name = cls.getName();
    }

    @Override // com.itextpdf.text.log.Counter
    public Counter getCounter(Class<?> cls) {
        return new SysoCounter(cls);
    }

    @Override // com.itextpdf.text.log.Counter
    public void read(long j) {
        System.out.println(String.format("[%s] %s bytes read", this.name, Long.valueOf(j)));
    }

    @Override // com.itextpdf.text.log.Counter
    public void written(long j) {
        System.out.println(String.format("[%s] %s bytes written", this.name, Long.valueOf(j)));
    }
}
