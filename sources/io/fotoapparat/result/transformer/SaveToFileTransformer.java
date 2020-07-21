package io.fotoapparat.result.transformer;

import com.itextpdf.text.Annotation;
import io.fotoapparat.exception.FileSaveException;
import io.fotoapparat.exif.ExifOrientationWriter;
import io.fotoapparat.result.Photo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/fotoapparat/result/transformer/SaveToFileTransformer;", "Lkotlin/Function1;", "Lio/fotoapparat/result/Photo;", "", Annotation.FILE, "Ljava/io/File;", "exifOrientationWriter", "Lio/fotoapparat/exif/ExifOrientationWriter;", "(Ljava/io/File;Lio/fotoapparat/exif/ExifOrientationWriter;)V", "invoke", "input", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: SaveToFileTransformer.kt */
public final class SaveToFileTransformer implements Function1<Photo, Unit> {
    private final ExifOrientationWriter exifOrientationWriter;
    private final File file;

    public SaveToFileTransformer(File file2, ExifOrientationWriter exifOrientationWriter2) {
        Intrinsics.checkParameterIsNotNull(file2, Annotation.FILE);
        Intrinsics.checkParameterIsNotNull(exifOrientationWriter2, "exifOrientationWriter");
        this.file = file2;
        this.exifOrientationWriter = exifOrientationWriter2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Photo photo) {
        invoke(photo);
        return Unit.INSTANCE;
    }

    public void invoke(Photo photo) {
        Intrinsics.checkParameterIsNotNull(photo, "input");
        try {
            OutputStream fileOutputStream = new FileOutputStream(this.file);
            try {
                SaveToFileTransformerKt.saveImage(photo, fileOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) fileOutputStream : new BufferedOutputStream(fileOutputStream, 8192));
                this.exifOrientationWriter.writeExifOrientation(this.file, photo.rotationDegrees);
            } catch (IOException e) {
                throw new FileSaveException(e);
            }
        } catch (FileNotFoundException e2) {
            throw new FileSaveException(e2);
        }
    }
}
