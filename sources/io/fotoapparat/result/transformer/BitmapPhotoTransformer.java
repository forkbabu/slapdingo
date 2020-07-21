package io.fotoapparat.result.transformer;

import android.graphics.Bitmap;
import io.fotoapparat.exception.UnableToDecodeBitmapException;
import io.fotoapparat.parameter.Resolution;
import io.fotoapparat.result.BitmapPhoto;
import io.fotoapparat.result.Photo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/fotoapparat/result/transformer/BitmapPhotoTransformer;", "Lkotlin/Function1;", "Lio/fotoapparat/result/Photo;", "Lio/fotoapparat/result/BitmapPhoto;", "sizeTransformer", "Lio/fotoapparat/parameter/Resolution;", "Lio/fotoapparat/result/transformer/ResolutionTransformer;", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "input", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: BitmapPhotoTransformer.kt */
public final class BitmapPhotoTransformer implements Function1<Photo, BitmapPhoto> {
    private final Function1<Resolution, Resolution> sizeTransformer;

    public BitmapPhotoTransformer(Function1<? super Resolution, Resolution> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "sizeTransformer");
        this.sizeTransformer = function1;
    }

    public BitmapPhoto invoke(Photo photo) {
        Intrinsics.checkParameterIsNotNull(photo, "input");
        Resolution access$readResolution = BitmapPhotoTransformerKt.readResolution(photo);
        Resolution invoke = this.sizeTransformer.invoke(access$readResolution);
        Bitmap access$decodeBitmap = BitmapPhotoTransformerKt.decodeBitmap(photo, BitmapPhotoTransformerKt.computeScaleFactor(access$readResolution, invoke));
        if (access$decodeBitmap != null) {
            if (!(access$decodeBitmap.getWidth() == invoke.width && access$decodeBitmap.getHeight() == invoke.height)) {
                access$decodeBitmap = Bitmap.createScaledBitmap(access$decodeBitmap, invoke.width, invoke.height, true);
            }
            Intrinsics.checkExpressionValueIsNotNull(access$decodeBitmap, "bitmap");
            return new BitmapPhoto(access$decodeBitmap, photo.rotationDegrees);
        }
        throw new UnableToDecodeBitmapException();
    }
}
