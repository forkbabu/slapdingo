package io.fotoapparat.capability;

import androidx.exifinterface.media.ExifInterface;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u001a\u001b\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\b¨\u0006\u0004"}, d2 = {"ensureNotEmpty", "", ExifInterface.LONGITUDE_EAST, "", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: Capabilities.kt */
public final class CapabilitiesKt {
    private static final <E> void ensureNotEmpty(Set<? extends E> set) {
        if (set.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Capabilities cannot have an empty Set<");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.LONGITUDE_EAST);
            sb.append(Object.class.getSimpleName());
            sb.append(">.");
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
