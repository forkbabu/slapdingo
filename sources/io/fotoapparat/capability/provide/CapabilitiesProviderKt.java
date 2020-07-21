package io.fotoapparat.capability.provide;

import android.hardware.Camera;
import com.itextpdf.text.Annotation;
import io.fotoapparat.capability.Capabilities;
import io.fotoapparat.parameter.Resolution;
import io.fotoapparat.parameter.SupportedParameters;
import io.fotoapparat.parameter.Zoom;
import io.fotoapparat.parameter.camera.convert.ResolutionConverterKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0007H\u0002\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\u000bH\u0002\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001*\f\u0012\b\u0012\u00060\u000fR\u00020\n0\u000eH\u0002¨\u0006\u0010"}, d2 = {"extract", "", "Parameter", "", "Code", "", "converter", "Lkotlin/Function1;", "getCapabilities", "Lio/fotoapparat/capability/Capabilities;", "Landroid/hardware/Camera;", "Lio/fotoapparat/parameter/SupportedParameters;", "mapSizes", "Lio/fotoapparat/parameter/Resolution;", "", "Landroid/hardware/Camera$Size;", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: CapabilitiesProvider.kt */
public final class CapabilitiesProviderKt {
    public static final Capabilities getCapabilities(Camera camera) {
        Intrinsics.checkParameterIsNotNull(camera, "receiver$0");
        Camera.Parameters parameters = camera.getParameters();
        Intrinsics.checkExpressionValueIsNotNull(parameters, Annotation.PARAMETERS);
        return getCapabilities(new SupportedParameters(parameters));
    }

    private static final Capabilities getCapabilities(SupportedParameters supportedParameters) {
        Zoom supportedZoom = supportedParameters.getSupportedZoom();
        Set extract = extract(supportedParameters.getFlashModes(), CapabilitiesProviderKt$getCapabilities$1.INSTANCE);
        Set extract2 = extract(supportedParameters.getFocusModes(), CapabilitiesProviderKt$getCapabilities$2.INSTANCE);
        int maxNumFocusAreas = supportedParameters.getMaxNumFocusAreas();
        return new Capabilities(supportedZoom, extract, extract2, supportedParameters.getSupportedSmoothZoom(), maxNumFocusAreas, supportedParameters.getMaxNumMeteringAreas(), supportedParameters.getJpegQualityRange(), supportedParameters.getExposureCompensationRange(), extract(supportedParameters.getSupportedPreviewFpsRanges(), CapabilitiesProviderKt$getCapabilities$4.INSTANCE), extract(supportedParameters.getSupportedAutoBandingModes(), CapabilitiesProviderKt$getCapabilities$3.INSTANCE), mapSizes(supportedParameters.getPictureResolutions()), mapSizes(supportedParameters.getPreviewResolutions()), CollectionsKt.toSet(supportedParameters.getSensorSensitivities()));
    }

    private static final <Parameter, Code> Set<Parameter> extract(List<? extends Code> list, Function1<? super Code, ? extends Parameter> function1) {
        Collection arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Object invoke = function1.invoke(it2.next());
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return CollectionsKt.toSet((List) arrayList);
    }

    private static final Set<Resolution> mapSizes(Collection<? extends Camera.Size> collection) {
        Iterable<Camera.Size> iterable = collection;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Camera.Size size : iterable) {
            arrayList.add(ResolutionConverterKt.toResolution(size));
        }
        return CollectionsKt.toSet((List) arrayList);
    }
}
