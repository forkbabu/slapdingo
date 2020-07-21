package io.fotoapparat.log;

import com.itextpdf.text.Annotation;
import io.fotoapparat.log.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lio/fotoapparat/log/FileLogger;", "Lio/fotoapparat/log/Logger;", Annotation.FILE, "Ljava/io/File;", "(Ljava/io/File;)V", "writer", "Ljava/io/FileWriter;", "getWriter", "()Ljava/io/FileWriter;", "writer$delegate", "Lkotlin/Lazy;", "log", "", "message", "", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: FileLogger.kt */
public final class FileLogger implements Logger {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(FileLogger.class), "writer", "getWriter()Ljava/io/FileWriter;"))};
    /* access modifiers changed from: private */
    public final File file;
    private final Lazy writer$delegate = LazyKt.lazy(new FileLogger$writer$2(this));

    private final FileWriter getWriter() {
        Lazy lazy = this.writer$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (FileWriter) lazy.getValue();
    }

    public FileLogger(File file2) {
        Intrinsics.checkParameterIsNotNull(file2, Annotation.FILE);
        this.file = file2;
    }

    @Override // io.fotoapparat.log.Logger
    public void recordMethod() {
        Logger.DefaultImpls.recordMethod(this);
    }

    @Override // io.fotoapparat.log.Logger
    public void log(String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        try {
            FileWriter writer = getWriter();
            writer.write(str + "\n");
            getWriter().flush();
        } catch (IOException unused) {
        }
    }
}
