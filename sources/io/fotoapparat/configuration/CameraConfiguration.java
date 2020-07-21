package io.fotoapparat.configuration;

import androidx.core.view.PointerIconCompat;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.fotoapparat.parameter.AntiBandingMode;
import io.fotoapparat.parameter.Flash;
import io.fotoapparat.parameter.FocusMode;
import io.fotoapparat.parameter.FpsRange;
import io.fotoapparat.parameter.Resolution;
import io.fotoapparat.preview.Frame;
import io.fotoapparat.preview.FrameProcessor;
import io.fotoapparat.selector.AntiBandingModeSelectorsKt;
import io.fotoapparat.selector.ExposureCompensationSelectorsKt;
import io.fotoapparat.selector.FlashSelectorsKt;
import io.fotoapparat.selector.FocusModeSelectorsKt;
import io.fotoapparat.selector.JpegQualitySelectorsKt;
import io.fotoapparat.selector.PreviewFpsRangeSelectorsKt;
import io.fotoapparat.selector.ResolutionSelectorsKt;
import io.fotoapparat.selector.SelectorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u0000 C2\u00020\u0001:\u0002BCB\u0003\u0012%\b\u0002\u0010\u0002\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u0006¢\u0006\u0002\b\u0007\u0012%\b\u0002\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003j\u0002`\n¢\u0006\u0002\b\u0007\u0012\u001f\b\u0002\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0003j\u0002`\u000e¢\u0006\u0002\b\u0007\u0012\u001f\b\u0002\u0010\u000f\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0003j\u0002`\u0010¢\u0006\u0002\b\u0007\u0012+\b\u0002\u0010\u0011\u001a%\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0003j\u0004\u0018\u0001`\u0017\u0012%\b\u0002\u0010\u0018\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0003j\u0002`\u001a¢\u0006\u0002\b\u0007\u0012%\b\u0002\u0010\u001b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0003j\u0002`\u001d¢\u0006\u0002\b\u0007\u0012)\b\u0002\u0010\u001e\u001a#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0003j\u0004\u0018\u0001`\u001f¢\u0006\u0002\b\u0007\u0012%\b\u0002\u0010 \u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0004\u0012\u0006\u0012\u0004\u0018\u00010!0\u0003j\u0002`\"¢\u0006\u0002\b\u0007\u0012%\b\u0002\u0010#\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0004\u0012\u0006\u0012\u0004\u0018\u00010!0\u0003j\u0002`\"¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010$J&\u00100\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u0006¢\u0006\u0002\b\u0007HÆ\u0003J&\u00101\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0004\u0012\u0006\u0012\u0004\u0018\u00010!0\u0003j\u0002`\"¢\u0006\u0002\b\u0007HÆ\u0003J&\u00102\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003j\u0002`\n¢\u0006\u0002\b\u0007HÆ\u0003J \u00103\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0003j\u0002`\u000e¢\u0006\u0002\b\u0007HÆ\u0003J \u00104\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0003j\u0002`\u0010¢\u0006\u0002\b\u0007HÆ\u0003J,\u00105\u001a%\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0003j\u0004\u0018\u0001`\u0017HÆ\u0003J&\u00106\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0003j\u0002`\u001a¢\u0006\u0002\b\u0007HÆ\u0003J&\u00107\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0003j\u0002`\u001d¢\u0006\u0002\b\u0007HÆ\u0003J*\u00108\u001a#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0003j\u0004\u0018\u0001`\u001f¢\u0006\u0002\b\u0007HÆ\u0003J&\u00109\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0004\u0012\u0006\u0012\u0004\u0018\u00010!0\u0003j\u0002`\"¢\u0006\u0002\b\u0007HÆ\u0003J\u0003\u0010:\u001a\u00020\u00002%\b\u0002\u0010\u0002\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u0006¢\u0006\u0002\b\u00072%\b\u0002\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003j\u0002`\n¢\u0006\u0002\b\u00072\u001f\b\u0002\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0003j\u0002`\u000e¢\u0006\u0002\b\u00072\u001f\b\u0002\u0010\u000f\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0003j\u0002`\u0010¢\u0006\u0002\b\u00072+\b\u0002\u0010\u0011\u001a%\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0003j\u0004\u0018\u0001`\u00172%\b\u0002\u0010\u0018\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0003j\u0002`\u001a¢\u0006\u0002\b\u00072%\b\u0002\u0010\u001b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0003j\u0002`\u001d¢\u0006\u0002\b\u00072)\b\u0002\u0010\u001e\u001a#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0003j\u0004\u0018\u0001`\u001f¢\u0006\u0002\b\u00072%\b\u0002\u0010 \u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0004\u0012\u0006\u0012\u0004\u0018\u00010!0\u0003j\u0002`\"¢\u0006\u0002\b\u00072%\b\u0002\u0010#\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0004\u0012\u0006\u0012\u0004\u0018\u00010!0\u0003j\u0002`\"¢\u0006\u0002\b\u0007HÆ\u0001J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\rHÖ\u0001J\t\u0010@\u001a\u00020AHÖ\u0001R1\u0010\u001b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0003j\u0002`\u001d¢\u0006\u0002\b\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R+\u0010\u000f\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0003j\u0002`\u0010¢\u0006\u0002\b\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R1\u0010\u0002\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u0006¢\u0006\u0002\b\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R1\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003j\u0002`\n¢\u0006\u0002\b\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R7\u0010\u0011\u001a%\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0003j\u0004\u0018\u0001`\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R+\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0003j\u0002`\u000e¢\u0006\u0002\b\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R1\u0010 \u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0004\u0012\u0006\u0012\u0004\u0018\u00010!0\u0003j\u0002`\"¢\u0006\u0002\b\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R1\u0010\u0018\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0003j\u0002`\u001a¢\u0006\u0002\b\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R1\u0010#\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0004\u0012\u0006\u0012\u0004\u0018\u00010!0\u0003j\u0002`\"¢\u0006\u0002\b\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R5\u0010\u001e\u001a#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0003j\u0004\u0018\u0001`\u001f¢\u0006\u0002\b\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&¨\u0006D"}, d2 = {"Lio/fotoapparat/configuration/CameraConfiguration;", "Lio/fotoapparat/configuration/Configuration;", "flashMode", "Lkotlin/Function1;", "", "Lio/fotoapparat/parameter/Flash;", "Lio/fotoapparat/selector/FlashSelector;", "Lkotlin/ExtensionFunctionType;", "focusMode", "Lio/fotoapparat/parameter/FocusMode;", "Lio/fotoapparat/selector/FocusModeSelector;", "jpegQuality", "Lkotlin/ranges/IntRange;", "", "Lio/fotoapparat/selector/QualitySelector;", "exposureCompensation", "Lio/fotoapparat/selector/ExposureSelector;", "frameProcessor", "Lio/fotoapparat/preview/Frame;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "frame", "", "Lio/fotoapparat/util/FrameProcessor;", "previewFpsRange", "Lio/fotoapparat/parameter/FpsRange;", "Lio/fotoapparat/selector/FpsRangeSelector;", "antiBandingMode", "Lio/fotoapparat/parameter/AntiBandingMode;", "Lio/fotoapparat/selector/AntiBandingModeSelector;", "sensorSensitivity", "Lio/fotoapparat/selector/SensorSensitivitySelector;", "pictureResolution", "Lio/fotoapparat/parameter/Resolution;", "Lio/fotoapparat/selector/ResolutionSelector;", "previewResolution", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getAntiBandingMode", "()Lkotlin/jvm/functions/Function1;", "getExposureCompensation", "getFlashMode", "getFocusMode", "getFrameProcessor", "getJpegQuality", "getPictureResolution", "getPreviewFpsRange", "getPreviewResolution", "getSensorSensitivity", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Builder", "Companion", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: CameraConfiguration.kt */
public final class CameraConfiguration implements Configuration {
    public static final Companion Companion = new Companion(null);
    private final Function1<Iterable<? extends AntiBandingMode>, AntiBandingMode> antiBandingMode;
    private final Function1<IntRange, Integer> exposureCompensation;
    private final Function1<Iterable<? extends Flash>, Flash> flashMode;
    private final Function1<Iterable<? extends FocusMode>, FocusMode> focusMode;
    private final Function1<Frame, Unit> frameProcessor;
    private final Function1<IntRange, Integer> jpegQuality;
    private final Function1<Iterable<Resolution>, Resolution> pictureResolution;
    private final Function1<Iterable<FpsRange>, FpsRange> previewFpsRange;
    private final Function1<Iterable<Resolution>, Resolution> previewResolution;
    private final Function1<Iterable<Integer>, Integer> sensorSensitivity;

    public CameraConfiguration() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @JvmStatic
    public static final Builder builder() {
        return Companion.builder();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<? extends io.fotoapparat.parameter.Flash>, io.fotoapparat.parameter.Flash>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<? extends io.fotoapparat.parameter.FocusMode>, io.fotoapparat.parameter.FocusMode>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: kotlin.jvm.functions.Function1<kotlin.ranges.IntRange, java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: kotlin.jvm.functions.Function1<kotlin.ranges.IntRange, java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: kotlin.jvm.functions.Function1<io.fotoapparat.preview.Frame, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<io.fotoapparat.parameter.FpsRange>, io.fotoapparat.parameter.FpsRange>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<? extends io.fotoapparat.parameter.AntiBandingMode>, io.fotoapparat.parameter.AntiBandingMode>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<java.lang.Integer>, java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<io.fotoapparat.parameter.Resolution>, io.fotoapparat.parameter.Resolution>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<io.fotoapparat.parameter.Resolution>, io.fotoapparat.parameter.Resolution>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<io.fotoapparat.parameter.Resolution>, io.fotoapparat.parameter.Resolution>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<io.fotoapparat.parameter.Resolution>, io.fotoapparat.parameter.Resolution>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<io.fotoapparat.parameter.Resolution>, io.fotoapparat.parameter.Resolution>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<io.fotoapparat.parameter.Resolution>, io.fotoapparat.parameter.Resolution>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<java.lang.Integer>, java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<java.lang.Integer>, java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<? extends io.fotoapparat.parameter.AntiBandingMode>, io.fotoapparat.parameter.AntiBandingMode>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<? extends io.fotoapparat.parameter.AntiBandingMode>, io.fotoapparat.parameter.AntiBandingMode>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<io.fotoapparat.parameter.FpsRange>, io.fotoapparat.parameter.FpsRange>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<io.fotoapparat.parameter.FpsRange>, io.fotoapparat.parameter.FpsRange>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: kotlin.jvm.functions.Function1<io.fotoapparat.preview.Frame, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: kotlin.jvm.functions.Function1<io.fotoapparat.preview.Frame, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlin.jvm.functions.Function1<kotlin.ranges.IntRange, java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: kotlin.jvm.functions.Function1<kotlin.ranges.IntRange, java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: kotlin.jvm.functions.Function1<kotlin.ranges.IntRange, java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: kotlin.jvm.functions.Function1<kotlin.ranges.IntRange, java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<? extends io.fotoapparat.parameter.FocusMode>, io.fotoapparat.parameter.FocusMode>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<? extends io.fotoapparat.parameter.FocusMode>, io.fotoapparat.parameter.FocusMode>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<? extends io.fotoapparat.parameter.Flash>, io.fotoapparat.parameter.Flash>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlin.jvm.functions.Function1<java.lang.Iterable<? extends io.fotoapparat.parameter.Flash>, io.fotoapparat.parameter.Flash>} */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CameraConfiguration copy$default(CameraConfiguration cameraConfiguration, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function1 function18, Function1 function19, Function1 function110, int i, Object obj) {
        return cameraConfiguration.copy((i & 1) != 0 ? cameraConfiguration.getFlashMode() : function1, (i & 2) != 0 ? cameraConfiguration.getFocusMode() : function12, (i & 4) != 0 ? cameraConfiguration.getJpegQuality() : function13, (i & 8) != 0 ? cameraConfiguration.getExposureCompensation() : function14, (i & 16) != 0 ? cameraConfiguration.getFrameProcessor() : function15, (i & 32) != 0 ? cameraConfiguration.getPreviewFpsRange() : function16, (i & 64) != 0 ? cameraConfiguration.getAntiBandingMode() : function17, (i & 128) != 0 ? cameraConfiguration.getSensorSensitivity() : function18, (i & 256) != 0 ? cameraConfiguration.getPictureResolution() : function19, (i & 512) != 0 ? cameraConfiguration.getPreviewResolution() : function110);
    }

    @JvmStatic
    /* renamed from: default  reason: not valid java name */
    public static final CameraConfiguration m0default() {
        return Companion.m1default();
    }

    @JvmStatic
    public static final CameraConfiguration standard() {
        return Companion.standard();
    }

    public final Function1<Iterable<? extends Flash>, Flash> component1() {
        return getFlashMode();
    }

    public final Function1<Iterable<Resolution>, Resolution> component10() {
        return getPreviewResolution();
    }

    public final Function1<Iterable<? extends FocusMode>, FocusMode> component2() {
        return getFocusMode();
    }

    public final Function1<IntRange, Integer> component3() {
        return getJpegQuality();
    }

    public final Function1<IntRange, Integer> component4() {
        return getExposureCompensation();
    }

    public final Function1<Frame, Unit> component5() {
        return getFrameProcessor();
    }

    public final Function1<Iterable<FpsRange>, FpsRange> component6() {
        return getPreviewFpsRange();
    }

    public final Function1<Iterable<? extends AntiBandingMode>, AntiBandingMode> component7() {
        return getAntiBandingMode();
    }

    public final Function1<Iterable<Integer>, Integer> component8() {
        return getSensorSensitivity();
    }

    public final Function1<Iterable<Resolution>, Resolution> component9() {
        return getPictureResolution();
    }

    public final CameraConfiguration copy(Function1<? super Iterable<? extends Flash>, ? extends Flash> function1, Function1<? super Iterable<? extends FocusMode>, ? extends FocusMode> function12, Function1<? super IntRange, Integer> function13, Function1<? super IntRange, Integer> function14, Function1<? super Frame, Unit> function15, Function1<? super Iterable<FpsRange>, FpsRange> function16, Function1<? super Iterable<? extends AntiBandingMode>, ? extends AntiBandingMode> function17, Function1<? super Iterable<Integer>, Integer> function18, Function1<? super Iterable<Resolution>, Resolution> function19, Function1<? super Iterable<Resolution>, Resolution> function110) {
        Intrinsics.checkParameterIsNotNull(function1, "flashMode");
        Intrinsics.checkParameterIsNotNull(function12, "focusMode");
        Intrinsics.checkParameterIsNotNull(function13, "jpegQuality");
        Intrinsics.checkParameterIsNotNull(function14, "exposureCompensation");
        Intrinsics.checkParameterIsNotNull(function16, "previewFpsRange");
        Intrinsics.checkParameterIsNotNull(function17, "antiBandingMode");
        Intrinsics.checkParameterIsNotNull(function19, "pictureResolution");
        Intrinsics.checkParameterIsNotNull(function110, "previewResolution");
        return new CameraConfiguration(function1, function12, function13, function14, function15, function16, function17, function18, function19, function110);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraConfiguration)) {
            return false;
        }
        CameraConfiguration cameraConfiguration = (CameraConfiguration) obj;
        return Intrinsics.areEqual(getFlashMode(), cameraConfiguration.getFlashMode()) && Intrinsics.areEqual(getFocusMode(), cameraConfiguration.getFocusMode()) && Intrinsics.areEqual(getJpegQuality(), cameraConfiguration.getJpegQuality()) && Intrinsics.areEqual(getExposureCompensation(), cameraConfiguration.getExposureCompensation()) && Intrinsics.areEqual(getFrameProcessor(), cameraConfiguration.getFrameProcessor()) && Intrinsics.areEqual(getPreviewFpsRange(), cameraConfiguration.getPreviewFpsRange()) && Intrinsics.areEqual(getAntiBandingMode(), cameraConfiguration.getAntiBandingMode()) && Intrinsics.areEqual(getSensorSensitivity(), cameraConfiguration.getSensorSensitivity()) && Intrinsics.areEqual(getPictureResolution(), cameraConfiguration.getPictureResolution()) && Intrinsics.areEqual(getPreviewResolution(), cameraConfiguration.getPreviewResolution());
    }

    public int hashCode() {
        Function1<Iterable<? extends Flash>, Flash> flashMode2 = getFlashMode();
        int i = 0;
        int hashCode = (flashMode2 != null ? flashMode2.hashCode() : 0) * 31;
        Function1<Iterable<? extends FocusMode>, FocusMode> focusMode2 = getFocusMode();
        int hashCode2 = (hashCode + (focusMode2 != null ? focusMode2.hashCode() : 0)) * 31;
        Function1<IntRange, Integer> jpegQuality2 = getJpegQuality();
        int hashCode3 = (hashCode2 + (jpegQuality2 != null ? jpegQuality2.hashCode() : 0)) * 31;
        Function1<IntRange, Integer> exposureCompensation2 = getExposureCompensation();
        int hashCode4 = (hashCode3 + (exposureCompensation2 != null ? exposureCompensation2.hashCode() : 0)) * 31;
        Function1<Frame, Unit> frameProcessor2 = getFrameProcessor();
        int hashCode5 = (hashCode4 + (frameProcessor2 != null ? frameProcessor2.hashCode() : 0)) * 31;
        Function1<Iterable<FpsRange>, FpsRange> previewFpsRange2 = getPreviewFpsRange();
        int hashCode6 = (hashCode5 + (previewFpsRange2 != null ? previewFpsRange2.hashCode() : 0)) * 31;
        Function1<Iterable<? extends AntiBandingMode>, AntiBandingMode> antiBandingMode2 = getAntiBandingMode();
        int hashCode7 = (hashCode6 + (antiBandingMode2 != null ? antiBandingMode2.hashCode() : 0)) * 31;
        Function1<Iterable<Integer>, Integer> sensorSensitivity2 = getSensorSensitivity();
        int hashCode8 = (hashCode7 + (sensorSensitivity2 != null ? sensorSensitivity2.hashCode() : 0)) * 31;
        Function1<Iterable<Resolution>, Resolution> pictureResolution2 = getPictureResolution();
        int hashCode9 = (hashCode8 + (pictureResolution2 != null ? pictureResolution2.hashCode() : 0)) * 31;
        Function1<Iterable<Resolution>, Resolution> previewResolution2 = getPreviewResolution();
        if (previewResolution2 != null) {
            i = previewResolution2.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "CameraConfiguration(flashMode=" + getFlashMode() + ", focusMode=" + getFocusMode() + ", jpegQuality=" + getJpegQuality() + ", exposureCompensation=" + getExposureCompensation() + ", frameProcessor=" + getFrameProcessor() + ", previewFpsRange=" + getPreviewFpsRange() + ", antiBandingMode=" + getAntiBandingMode() + ", sensorSensitivity=" + getSensorSensitivity() + ", pictureResolution=" + getPictureResolution() + ", previewResolution=" + getPreviewResolution() + ")";
    }

    public CameraConfiguration(Function1<? super Iterable<? extends Flash>, ? extends Flash> function1, Function1<? super Iterable<? extends FocusMode>, ? extends FocusMode> function12, Function1<? super IntRange, Integer> function13, Function1<? super IntRange, Integer> function14, Function1<? super Frame, Unit> function15, Function1<? super Iterable<FpsRange>, FpsRange> function16, Function1<? super Iterable<? extends AntiBandingMode>, ? extends AntiBandingMode> function17, Function1<? super Iterable<Integer>, Integer> function18, Function1<? super Iterable<Resolution>, Resolution> function19, Function1<? super Iterable<Resolution>, Resolution> function110) {
        Intrinsics.checkParameterIsNotNull(function1, "flashMode");
        Intrinsics.checkParameterIsNotNull(function12, "focusMode");
        Intrinsics.checkParameterIsNotNull(function13, "jpegQuality");
        Intrinsics.checkParameterIsNotNull(function14, "exposureCompensation");
        Intrinsics.checkParameterIsNotNull(function16, "previewFpsRange");
        Intrinsics.checkParameterIsNotNull(function17, "antiBandingMode");
        Intrinsics.checkParameterIsNotNull(function19, "pictureResolution");
        Intrinsics.checkParameterIsNotNull(function110, "previewResolution");
        this.flashMode = function1;
        this.focusMode = function12;
        this.jpegQuality = function13;
        this.exposureCompensation = function14;
        this.frameProcessor = function15;
        this.previewFpsRange = function16;
        this.antiBandingMode = function17;
        this.sensorSensitivity = function18;
        this.pictureResolution = function19;
        this.previewResolution = function110;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CameraConfiguration(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function1 function18, Function1 function19, Function1 function110, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? FlashSelectorsKt.off() : function1, (i & 2) != 0 ? SelectorsKt.firstAvailable(FocusModeSelectorsKt.continuousFocusPicture(), FocusModeSelectorsKt.autoFocus(), FocusModeSelectorsKt.fixed(), FocusModeSelectorsKt.infinity()) : function12, (i & 4) != 0 ? JpegQualitySelectorsKt.manualJpegQuality(90) : function13, (i & 8) != 0 ? ExposureCompensationSelectorsKt.manualExposure(0) : function14, (i & 16) != 0 ? null : function15, (i & 32) != 0 ? PreviewFpsRangeSelectorsKt.highestFps() : function16, (i & 64) != 0 ? SelectorsKt.firstAvailable(AntiBandingModeSelectorsKt.auto(), AntiBandingModeSelectorsKt.hz50(), AntiBandingModeSelectorsKt.hz60(), AntiBandingModeSelectorsKt.none()) : function17, (i & 128) != 0 ? null : function18, (i & 256) != 0 ? ResolutionSelectorsKt.highestResolution() : function19, (i & 512) != 0 ? ResolutionSelectorsKt.highestResolution() : function110);
    }

    @Override // io.fotoapparat.configuration.Configuration
    public Function1<Iterable<? extends Flash>, Flash> getFlashMode() {
        return this.flashMode;
    }

    @Override // io.fotoapparat.configuration.Configuration
    public Function1<Iterable<? extends FocusMode>, FocusMode> getFocusMode() {
        return this.focusMode;
    }

    @Override // io.fotoapparat.configuration.Configuration
    public Function1<IntRange, Integer> getJpegQuality() {
        return this.jpegQuality;
    }

    @Override // io.fotoapparat.configuration.Configuration
    public Function1<IntRange, Integer> getExposureCompensation() {
        return this.exposureCompensation;
    }

    @Override // io.fotoapparat.configuration.Configuration
    public Function1<Frame, Unit> getFrameProcessor() {
        return this.frameProcessor;
    }

    @Override // io.fotoapparat.configuration.Configuration
    public Function1<Iterable<FpsRange>, FpsRange> getPreviewFpsRange() {
        return this.previewFpsRange;
    }

    @Override // io.fotoapparat.configuration.Configuration
    public Function1<Iterable<? extends AntiBandingMode>, AntiBandingMode> getAntiBandingMode() {
        return this.antiBandingMode;
    }

    @Override // io.fotoapparat.configuration.Configuration
    public Function1<Iterable<Integer>, Integer> getSensorSensitivity() {
        return this.sensorSensitivity;
    }

    @Override // io.fotoapparat.configuration.Configuration
    public Function1<Iterable<Resolution>, Resolution> getPictureResolution() {
        return this.pictureResolution;
    }

    @Override // io.fotoapparat.configuration.Configuration
    public Function1<Iterable<Resolution>, Resolution> getPreviewResolution() {
        return this.previewResolution;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J+\u0010\u0005\u001a\u00020\u00002#\u0010\u0006\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\n¢\u0006\u0002\b\u000bJ\u0006\u0010\f\u001a\u00020\u0004J%\u0010\r\u001a\u00020\u00002\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0007j\u0002`\u0010¢\u0006\u0002\b\u000bJ+\u0010\u0011\u001a\u00020\u00002#\u0010\u0006\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\b\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0007j\u0002`\u0013¢\u0006\u0002\b\u000bJ+\u0010\u0014\u001a\u00020\u00002#\u0010\u0006\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\b\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0007j\u0002`\u0016¢\u0006\u0002\b\u000bJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J%\u0010\u0019\u001a\u00020\u00002\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0007j\u0002`\u001a¢\u0006\u0002\b\u000bJ+\u0010\u001b\u001a\u00020\u00002#\u0010\u0006\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0007j\u0002`\u001d¢\u0006\u0002\b\u000bJ+\u0010\u001e\u001a\u00020\u00002#\u0010\u0006\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\b\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0007j\u0002` ¢\u0006\u0002\b\u000bJ+\u0010!\u001a\u00020\u00002#\u0010\u0006\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0007j\u0002`\u001d¢\u0006\u0002\b\u000bJ+\u0010\"\u001a\u00020\u00002#\u0010\u0006\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0007j\u0002`#¢\u0006\u0002\b\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lio/fotoapparat/configuration/CameraConfiguration$Builder;", "", "()V", "cameraConfiguration", "Lio/fotoapparat/configuration/CameraConfiguration;", "antiBandingMode", "selector", "Lkotlin/Function1;", "", "Lio/fotoapparat/parameter/AntiBandingMode;", "Lio/fotoapparat/selector/AntiBandingModeSelector;", "Lkotlin/ExtensionFunctionType;", "build", "exposureCompensation", "Lkotlin/ranges/IntRange;", "", "Lio/fotoapparat/selector/ExposureSelector;", "flash", "Lio/fotoapparat/parameter/Flash;", "Lio/fotoapparat/selector/FlashSelector;", "focusMode", "Lio/fotoapparat/parameter/FocusMode;", "Lio/fotoapparat/selector/FocusModeSelector;", "frameProcessor", "Lio/fotoapparat/preview/FrameProcessor;", "jpegQuality", "Lio/fotoapparat/selector/QualitySelector;", "photoResolution", "Lio/fotoapparat/parameter/Resolution;", "Lio/fotoapparat/selector/ResolutionSelector;", "previewFpsRange", "Lio/fotoapparat/parameter/FpsRange;", "Lio/fotoapparat/selector/FpsRangeSelector;", "previewResolution", "sensorSensitivity", "Lio/fotoapparat/selector/SensorSensitivitySelector;", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: CameraConfiguration.kt */
    public static final class Builder {
        private CameraConfiguration cameraConfiguration = CameraConfiguration.Companion.m1default();

        public final Builder flash(Function1<? super Iterable<? extends Flash>, ? extends Flash> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "selector");
            Builder builder = this;
            builder.cameraConfiguration = CameraConfiguration.copy$default(builder.cameraConfiguration, function1, null, null, null, null, null, null, null, null, null, 1022, null);
            return builder;
        }

        public final Builder focusMode(Function1<? super Iterable<? extends FocusMode>, ? extends FocusMode> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "selector");
            Builder builder = this;
            builder.cameraConfiguration = CameraConfiguration.copy$default(builder.cameraConfiguration, null, function1, null, null, null, null, null, null, null, null, PointerIconCompat.TYPE_GRABBING, null);
            return builder;
        }

        public final Builder previewFpsRange(Function1<? super Iterable<FpsRange>, FpsRange> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "selector");
            Builder builder = this;
            builder.cameraConfiguration = CameraConfiguration.copy$default(builder.cameraConfiguration, null, null, null, null, null, function1, null, null, null, null, 991, null);
            return builder;
        }

        public final Builder exposureCompensation(Function1<? super IntRange, Integer> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "selector");
            Builder builder = this;
            builder.cameraConfiguration = CameraConfiguration.copy$default(builder.cameraConfiguration, null, null, null, function1, null, null, null, null, null, null, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null);
            return builder;
        }

        public final Builder antiBandingMode(Function1<? super Iterable<? extends AntiBandingMode>, ? extends AntiBandingMode> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "selector");
            Builder builder = this;
            CameraConfiguration.copy$default(builder.cameraConfiguration, null, null, null, null, null, null, function1, null, null, null, 959, null);
            return builder;
        }

        public final Builder jpegQuality(Function1<? super IntRange, Integer> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "selector");
            Builder builder = this;
            CameraConfiguration.copy$default(builder.cameraConfiguration, null, null, function1, null, null, null, null, null, null, null, PointerIconCompat.TYPE_ZOOM_OUT, null);
            return builder;
        }

        public final Builder sensorSensitivity(Function1<? super Iterable<Integer>, Integer> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "selector");
            Builder builder = this;
            builder.cameraConfiguration = CameraConfiguration.copy$default(builder.cameraConfiguration, null, null, null, null, null, null, null, function1, null, null, 895, null);
            return builder;
        }

        public final Builder previewResolution(Function1<? super Iterable<Resolution>, Resolution> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "selector");
            Builder builder = this;
            builder.cameraConfiguration = CameraConfiguration.copy$default(builder.cameraConfiguration, null, null, null, null, null, null, null, null, null, function1, 511, null);
            return builder;
        }

        public final Builder photoResolution(Function1<? super Iterable<Resolution>, Resolution> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "selector");
            Builder builder = this;
            builder.cameraConfiguration = CameraConfiguration.copy$default(builder.cameraConfiguration, null, null, null, null, null, null, null, null, function1, null, 767, null);
            return builder;
        }

        public final Builder frameProcessor(FrameProcessor frameProcessor) {
            Builder builder = this;
            builder.cameraConfiguration = CameraConfiguration.copy$default(builder.cameraConfiguration, null, null, null, null, (Function1) (frameProcessor != null ? new CameraConfiguration$Builder$frameProcessor$1$1$1(frameProcessor) : null), null, null, null, null, null, 1007, null);
            return builder;
        }

        public final CameraConfiguration build() {
            return this.cameraConfiguration;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lio/fotoapparat/configuration/CameraConfiguration$Companion;", "", "()V", "builder", "Lio/fotoapparat/configuration/CameraConfiguration$Builder;", "default", "Lio/fotoapparat/configuration/CameraConfiguration;", "standard", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: CameraConfiguration.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CameraConfiguration standard() {
            return m1default();
        }

        @JvmStatic
        /* renamed from: default  reason: not valid java name */
        public final CameraConfiguration m1default() {
            return new CameraConfiguration(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }
    }
}
