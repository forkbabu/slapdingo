package io.fotoapparat.parameter.camera.provide;

import io.fotoapparat.capability.Capabilities;
import io.fotoapparat.configuration.CameraConfiguration;
import io.fotoapparat.exception.camera.InvalidConfigurationException;
import io.fotoapparat.exception.camera.UnsupportedConfigurationException;
import io.fotoapparat.parameter.AntiBandingMode;
import io.fotoapparat.parameter.Flash;
import io.fotoapparat.parameter.FocusMode;
import io.fotoapparat.parameter.FpsRange;
import io.fotoapparat.parameter.Parameter;
import io.fotoapparat.parameter.Resolution;
import io.fotoapparat.parameter.camera.CameraParameters;
import io.fotoapparat.selector.AspectRatioSelectorsKt;
import io.fotoapparat.selector.SelectorsKt;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001aN\u0010\u0006\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u00020\t2#\u0010\f\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0002`\r¢\u0006\u0002\b\nH\u0002\u001a,\u0010\u000e\u001a\u0002H\u000f\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\u0010*\u0002H\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0012H\b¢\u0006\u0002\u0010\u0013\u001a2\u0010\u000e\u001a\u0002H\u000f\"\u0010\b\u0000\u0010\u000f\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u000f0\u0014*\u0002H\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0016H\b¢\u0006\u0002\u0010\u0017\u001a.\u0010\u0018\u001a\u0002H\u000f\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\u0010*\u0004\u0018\u0001H\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019H\b¢\u0006\u0002\u0010\u001a\u001a<\u0010\u0018\u001a\u0002H\u000f\"\u0010\b\u0000\u0010\u000f\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u000f0\u0014*\u0004\u0018\u0001H\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\b¢\u0006\u0002\u0010\u001d\u001a,\u0010\u001e\u001a\u00020\u001f*\u0019\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0007j\u0002`!¢\u0006\u0002\b\n2\u0006\u0010\u0011\u001a\u00020 H\u0004\u001aE\u0010\u001e\u001a\u0002H\"\"\n\b\u0000\u0010\"\u0018\u0001*\u00020\u0010*\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0\u0019\u0012\u0006\u0012\u0004\u0018\u0001H\"0\u0007¢\u0006\u0002\b\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\"0\u0012H\f¢\u0006\u0002\u0010#\u001aC\u0010$\u001a\u0004\u0018\u0001H\"\"\u0004\b\u0000\u0010\"*\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0\u0019\u0012\u0006\u0012\u0004\u0018\u0001H\"\u0018\u00010\u0007¢\u0006\u0002\b\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\"0\u0012H\u0004¢\u0006\u0002\u0010%¨\u0006&"}, d2 = {"getCameraParameters", "Lio/fotoapparat/parameter/camera/CameraParameters;", "capabilities", "Lio/fotoapparat/capability/Capabilities;", "cameraConfiguration", "Lio/fotoapparat/configuration/CameraConfiguration;", "validPreviewSizeSelector", "Lkotlin/Function1;", "", "Lio/fotoapparat/parameter/Resolution;", "Lkotlin/ExtensionFunctionType;", "resolution", "original", "Lio/fotoapparat/selector/ResolutionSelector;", "ensureInCollection", "Param", "Lio/fotoapparat/parameter/Parameter;", "supportedParameters", "", "(Lio/fotoapparat/parameter/Parameter;Ljava/util/Set;)Lio/fotoapparat/parameter/Parameter;", "", "supportedRange", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "ensureSelected", "", "(Lio/fotoapparat/parameter/Parameter;Ljava/util/Collection;)Lio/fotoapparat/parameter/Parameter;", "configurationName", "", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;Ljava/lang/String;)Ljava/lang/Comparable;", "selectFrom", "", "Lkotlin/ranges/IntRange;", "Lio/fotoapparat/selector/QualitySelector;", "T", "(Lkotlin/jvm/functions/Function1;Ljava/util/Set;)Lio/fotoapparat/parameter/Parameter;", "selectOptionalFrom", "(Lkotlin/jvm/functions/Function1;Ljava/util/Set;)Ljava/lang/Object;", "fotoapparat_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: CameraParametersProvider.kt */
public final class CameraParametersProviderKt {
    public static final CameraParameters getCameraParameters(Capabilities capabilities, CameraConfiguration cameraConfiguration) {
        Intrinsics.checkParameterIsNotNull(capabilities, "capabilities");
        Intrinsics.checkParameterIsNotNull(cameraConfiguration, "cameraConfiguration");
        Function1<Iterable<Resolution>, Resolution> pictureResolution = cameraConfiguration.getPictureResolution();
        Set<Resolution> pictureResolutions = capabilities.getPictureResolutions();
        Parameter invoke = pictureResolution.invoke(pictureResolutions);
        if (invoke == null) {
            throw new UnsupportedConfigurationException(Resolution.class, pictureResolutions);
        } else if (pictureResolutions.contains(invoke)) {
            Resolution resolution = (Resolution) invoke;
            Function1<Iterable<Resolution>, Resolution> validPreviewSizeSelector = validPreviewSizeSelector(resolution, cameraConfiguration.getPreviewResolution());
            Function1<Iterable<? extends Flash>, Flash> flashMode = cameraConfiguration.getFlashMode();
            Set<Flash> flashModes = capabilities.getFlashModes();
            Parameter invoke2 = flashMode.invoke(flashModes);
            if (invoke2 == null) {
                throw new UnsupportedConfigurationException(Flash.class, flashModes);
            } else if (flashModes.contains(invoke2)) {
                Flash flash = (Flash) invoke2;
                Function1<Iterable<? extends FocusMode>, FocusMode> focusMode = cameraConfiguration.getFocusMode();
                Set<FocusMode> focusModes = capabilities.getFocusModes();
                Parameter invoke3 = focusMode.invoke(focusModes);
                if (invoke3 == null) {
                    throw new UnsupportedConfigurationException(FocusMode.class, focusModes);
                } else if (focusModes.contains(invoke3)) {
                    FocusMode focusMode2 = (FocusMode) invoke3;
                    int selectFrom = selectFrom(cameraConfiguration.getJpegQuality(), capabilities.getJpegQualityRange());
                    int selectFrom2 = selectFrom(cameraConfiguration.getExposureCompensation(), capabilities.getExposureCompensationRange());
                    Function1<Iterable<FpsRange>, FpsRange> previewFpsRange = cameraConfiguration.getPreviewFpsRange();
                    Set<FpsRange> previewFpsRanges = capabilities.getPreviewFpsRanges();
                    Parameter invoke4 = previewFpsRange.invoke(previewFpsRanges);
                    if (invoke4 == null) {
                        throw new UnsupportedConfigurationException(FpsRange.class, previewFpsRanges);
                    } else if (previewFpsRanges.contains(invoke4)) {
                        FpsRange fpsRange = (FpsRange) invoke4;
                        Function1<Iterable<? extends AntiBandingMode>, AntiBandingMode> antiBandingMode = cameraConfiguration.getAntiBandingMode();
                        Set<AntiBandingMode> antiBandingModes = capabilities.getAntiBandingModes();
                        Parameter invoke5 = antiBandingMode.invoke(antiBandingModes);
                        if (invoke5 == null) {
                            throw new UnsupportedConfigurationException(AntiBandingMode.class, antiBandingModes);
                        } else if (antiBandingModes.contains(invoke5)) {
                            AntiBandingMode antiBandingMode2 = (AntiBandingMode) invoke5;
                            Set<Resolution> previewResolutions = capabilities.getPreviewResolutions();
                            Parameter invoke6 = validPreviewSizeSelector.invoke(previewResolutions);
                            if (invoke6 == null) {
                                throw new UnsupportedConfigurationException(Resolution.class, previewResolutions);
                            } else if (previewResolutions.contains(invoke6)) {
                                return new CameraParameters(flash, focusMode2, selectFrom, selectFrom2, fpsRange, antiBandingMode2, (Integer) selectOptionalFrom(cameraConfiguration.getSensorSensitivity(), capabilities.getSensorSensitivities()), resolution, (Resolution) invoke6);
                            } else {
                                throw new InvalidConfigurationException(invoke6, Resolution.class, previewResolutions);
                            }
                        } else {
                            throw new InvalidConfigurationException(invoke5, AntiBandingMode.class, antiBandingModes);
                        }
                    } else {
                        throw new InvalidConfigurationException(invoke4, FpsRange.class, previewFpsRanges);
                    }
                } else {
                    throw new InvalidConfigurationException(invoke3, FocusMode.class, focusModes);
                }
            } else {
                throw new InvalidConfigurationException(invoke2, Flash.class, flashModes);
            }
        } else {
            throw new InvalidConfigurationException(invoke, Resolution.class, pictureResolutions);
        }
    }

    private static final Function1<Iterable<Resolution>, Resolution> validPreviewSizeSelector(Resolution resolution, Function1<? super Iterable<Resolution>, Resolution> function1) {
        return SelectorsKt.firstAvailable(SelectorsKt.filtered(AspectRatioSelectorsKt.aspectRatio$default(resolution.getAspectRatio(), function1, 0.0d, 4, null), new CameraParametersProviderKt$validPreviewSizeSelector$1(resolution)), function1);
    }

    private static final <T> T selectOptionalFrom(Function1<? super Collection<? extends T>, ? extends T> function1, Set<? extends T> set) {
        if (function1 != null) {
            return function1.invoke(set);
        }
        return null;
    }

    private static final <T extends Parameter> T selectFrom(Function1<? super Collection<? extends T>, ? extends T> function1, Set<? extends T> set) {
        T invoke = function1.invoke(set);
        if (invoke == null) {
            Intrinsics.reifiedOperationMarker(4, "T");
            throw new UnsupportedConfigurationException(Parameter.class, set);
        } else if (set.contains(invoke)) {
            return invoke;
        } else {
            Intrinsics.reifiedOperationMarker(4, "T");
            throw new InvalidConfigurationException(invoke, Parameter.class, set);
        }
    }

    private static final int selectFrom(Function1<? super IntRange, Integer> function1, IntRange intRange) {
        Comparable invoke = function1.invoke(intRange);
        if (invoke != null) {
            ClosedRange closedRange = intRange;
            if (closedRange.contains(invoke)) {
                return ((Number) invoke).intValue();
            }
            throw new InvalidConfigurationException(invoke, Integer.class, closedRange);
        }
        throw new UnsupportedConfigurationException("Jpeg quality", intRange);
    }

    private static final <Param extends Parameter> Param ensureInCollection(Param param, Set<? extends Param> set) {
        if (set.contains(param)) {
            return param;
        }
        Intrinsics.reifiedOperationMarker(4, "Param");
        throw new InvalidConfigurationException(param, Parameter.class, set);
    }

    private static final <Param extends Comparable<? super Param>> Param ensureInCollection(Param param, ClosedRange<Param> closedRange) {
        if (closedRange.contains(param)) {
            return param;
        }
        Intrinsics.reifiedOperationMarker(4, "Param");
        throw new InvalidConfigurationException((Object) param, (Class<? extends Comparable<?>>) Comparable.class, (ClosedRange<?>) closedRange);
    }

    private static final <Param extends Parameter> Param ensureSelected(Param param, Collection<? extends Parameter> collection) {
        if (param != null) {
            return param;
        }
        Intrinsics.reifiedOperationMarker(4, "Param");
        throw new UnsupportedConfigurationException(Parameter.class, collection);
    }

    private static final <Param extends Comparable<? super Param>> Param ensureSelected(Param param, ClosedRange<Param> closedRange, String str) {
        if (param != null) {
            return param;
        }
        throw new UnsupportedConfigurationException(str, (ClosedRange<?>) closedRange);
    }
}
