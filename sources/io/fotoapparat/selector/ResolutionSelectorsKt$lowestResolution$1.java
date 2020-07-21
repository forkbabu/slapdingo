package io.fotoapparat.selector;

import io.fotoapparat.parameter.Resolution;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lio/fotoapparat/parameter/Resolution;", "", "invoke"}, k = 3, mv = {1, 1, 13})
/* compiled from: ResolutionSelectors.kt */
final class ResolutionSelectorsKt$lowestResolution$1 extends Lambda implements Function1<Iterable<? extends Resolution>, Resolution> {
    public static final ResolutionSelectorsKt$lowestResolution$1 INSTANCE = new ResolutionSelectorsKt$lowestResolution$1();

    ResolutionSelectorsKt$lowestResolution$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Resolution invoke(Iterable<? extends Resolution> iterable) {
        return invoke((Iterable<Resolution>) iterable);
    }

    public final Resolution invoke(Iterable<Resolution> iterable) {
        Resolution resolution;
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Iterator<Resolution> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            resolution = null;
        } else {
            Resolution next = it2.next();
            int area = next.getArea();
            while (it2.hasNext()) {
                Resolution next2 = it2.next();
                int area2 = next2.getArea();
                if (area > area2) {
                    next = next2;
                    area = area2;
                }
            }
            resolution = next;
        }
        return resolution;
    }
}
