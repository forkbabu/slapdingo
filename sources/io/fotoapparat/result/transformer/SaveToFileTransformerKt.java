package io.fotoapparat.result.transformer;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"saveImage", "", "input", "Lio/fotoapparat/result/Photo;", "outputStream", "Ljava/io/BufferedOutputStream;", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: SaveToFileTransformer.kt */
public final class SaveToFileTransformerKt {
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void saveImage(io.fotoapparat.result.Photo r2, java.io.BufferedOutputStream r3) throws java.io.IOException {
        /*
            java.io.Closeable r3 = (java.io.Closeable) r3
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1 = r3
            java.io.BufferedOutputStream r1 = (java.io.BufferedOutputStream) r1     // Catch:{ all -> 0x0016 }
            byte[] r2 = r2.encodedImage     // Catch:{ all -> 0x0016 }
            r1.write(r2)     // Catch:{ all -> 0x0016 }
            r1.flush()     // Catch:{ all -> 0x0016 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0016 }
            kotlin.io.CloseableKt.closeFinally(r3, r0)
            return
        L_0x0016:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0018 }
        L_0x0018:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fotoapparat.result.transformer.SaveToFileTransformerKt.saveImage(io.fotoapparat.result.Photo, java.io.BufferedOutputStream):void");
    }
}
