package io.fotoapparat.result.transformer;

import io.fotoapparat.parameter.Resolution;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003\u001a\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u0006*\"\u0010\u0007\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\b"}, d2 = {"originalResolution", "Lkotlin/Function1;", "Lio/fotoapparat/parameter/Resolution;", "Lio/fotoapparat/result/transformer/ResolutionTransformer;", "scaled", "scaleFactor", "", "ResolutionTransformer", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: ResolutionTransformers.kt */
public final class ResolutionTransformersKt {
    public static final Function1<Resolution, Resolution> originalResolution() {
        return ResolutionTransformersKt$originalResolution$1.INSTANCE;
    }

    public static final Function1<Resolution, Resolution> scaled(float f) {
        return new ResolutionTransformersKt$scaled$1(f);
    }
}
