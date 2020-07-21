package io.fotoapparat.exception.camera;

import io.fotoapparat.parameter.Parameter;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\tB/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\u0005\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lio/fotoapparat/exception/camera/InvalidConfigurationException;", "Lio/fotoapparat/exception/camera/CameraException;", "value", "", "klass", "Ljava/lang/Class;", "Lio/fotoapparat/parameter/Parameter;", "supportedParameters", "", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/util/Collection;)V", "", "supportedRange", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Object;Ljava/lang/Class;Lkotlin/ranges/ClosedRange;)V", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: InvalidConfigurationException.kt */
public final class InvalidConfigurationException extends CameraException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidConfigurationException(Object obj, Class<? extends Parameter> cls, Collection<? extends Parameter> collection) {
        super(cls.getSimpleName() + " configuration selector selected value " + obj + ". " + "However it's not in the supported set of values. " + "Supported parameters: " + collection, null, 2, null);
        Intrinsics.checkParameterIsNotNull(obj, "value");
        Intrinsics.checkParameterIsNotNull(cls, "klass");
        Intrinsics.checkParameterIsNotNull(collection, "supportedParameters");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidConfigurationException(Object obj, Class<? extends Comparable<?>> cls, ClosedRange<?> closedRange) {
        super(cls.getSimpleName() + " configuration selector selected value " + obj + ". " + "However it's not in the supported set of values. " + "Supported parameters from: " + closedRange.getStart() + " to " + closedRange.getEndInclusive() + '.', null, 2, null);
        Intrinsics.checkParameterIsNotNull(obj, "value");
        Intrinsics.checkParameterIsNotNull(cls, "klass");
        Intrinsics.checkParameterIsNotNull(closedRange, "supportedRange");
    }
}
