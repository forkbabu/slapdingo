package kotlin.io;

import com.itextpdf.text.Annotation;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/io/TerminateException;", "Lkotlin/io/FileSystemException;", Annotation.FILE, "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: Utils.kt */
final class TerminateException extends FileSystemException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TerminateException(File file) {
        super(file, null, null, 6, null);
        Intrinsics.checkParameterIsNotNull(file, Annotation.FILE);
    }
}
