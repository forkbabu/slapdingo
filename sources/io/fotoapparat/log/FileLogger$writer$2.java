package io.fotoapparat.log;

import java.io.FileWriter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/FileWriter;", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: FileLogger.kt */
final class FileLogger$writer$2 extends Lambda implements Function0<FileWriter> {
    final /* synthetic */ FileLogger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileLogger$writer$2(FileLogger fileLogger) {
        super(0);
        this.this$0 = fileLogger;
    }

    @Override // kotlin.jvm.functions.Function0
    public final FileWriter invoke() {
        return new FileWriter(this.this$0.file);
    }
}
