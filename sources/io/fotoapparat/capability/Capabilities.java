package io.fotoapparat.capability;

import io.fotoapparat.parameter.AntiBandingMode;
import io.fotoapparat.parameter.Flash;
import io.fotoapparat.parameter.FocusMode;
import io.fotoapparat.parameter.FpsRange;
import io.fotoapparat.parameter.Resolution;
import io.fotoapparat.parameter.Zoom;
import io.fotoapparat.util.StringExtensionsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\u0010\u0019J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005HÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\f0\u0005HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\t\u00106\u001a\u00020\u000fHÆ\u0003J\t\u00107\u001a\u00020\u000fHÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005HÆ\u0003Jµ\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00052\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00052\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0005HÆ\u0001J\u0013\u0010:\u001a\u00020\n2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\fHÖ\u0001J\b\u0010=\u001a\u00020>H\u0016R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006?"}, d2 = {"Lio/fotoapparat/capability/Capabilities;", "", "zoom", "Lio/fotoapparat/parameter/Zoom;", "flashModes", "", "Lio/fotoapparat/parameter/Flash;", "focusModes", "Lio/fotoapparat/parameter/FocusMode;", "canSmoothZoom", "", "maxFocusAreas", "", "maxMeteringAreas", "jpegQualityRange", "Lkotlin/ranges/IntRange;", "exposureCompensationRange", "previewFpsRanges", "Lio/fotoapparat/parameter/FpsRange;", "antiBandingModes", "Lio/fotoapparat/parameter/AntiBandingMode;", "pictureResolutions", "Lio/fotoapparat/parameter/Resolution;", "previewResolutions", "sensorSensitivities", "(Lio/fotoapparat/parameter/Zoom;Ljava/util/Set;Ljava/util/Set;ZIILkotlin/ranges/IntRange;Lkotlin/ranges/IntRange;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;)V", "getAntiBandingModes", "()Ljava/util/Set;", "getCanSmoothZoom", "()Z", "getExposureCompensationRange", "()Lkotlin/ranges/IntRange;", "getFlashModes", "getFocusModes", "getJpegQualityRange", "getMaxFocusAreas", "()I", "getMaxMeteringAreas", "getPictureResolutions", "getPreviewFpsRanges", "getPreviewResolutions", "getSensorSensitivities", "getZoom", "()Lio/fotoapparat/parameter/Zoom;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Capabilities.kt */
public final class Capabilities {
    private final Set<AntiBandingMode> antiBandingModes;
    private final boolean canSmoothZoom;
    private final IntRange exposureCompensationRange;
    private final Set<Flash> flashModes;
    private final Set<FocusMode> focusModes;
    private final IntRange jpegQualityRange;
    private final int maxFocusAreas;
    private final int maxMeteringAreas;
    private final Set<Resolution> pictureResolutions;
    private final Set<FpsRange> previewFpsRanges;
    private final Set<Resolution> previewResolutions;
    private final Set<Integer> sensorSensitivities;
    private final Zoom zoom;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.util.Set<io.fotoapparat.parameter.Flash>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.util.Set<io.fotoapparat.parameter.FocusMode>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.util.Set<io.fotoapparat.parameter.FpsRange>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.util.Set<io.fotoapparat.parameter.AntiBandingMode>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.util.Set<io.fotoapparat.parameter.Resolution>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: java.util.Set<io.fotoapparat.parameter.Resolution>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.Set<java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.util.Set<java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.util.Set<java.lang.Integer>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: java.util.Set<io.fotoapparat.parameter.Resolution>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: java.util.Set<io.fotoapparat.parameter.Resolution>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.util.Set<io.fotoapparat.parameter.Resolution>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.util.Set<io.fotoapparat.parameter.Resolution>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.util.Set<io.fotoapparat.parameter.AntiBandingMode>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.util.Set<io.fotoapparat.parameter.AntiBandingMode>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.util.Set<io.fotoapparat.parameter.FpsRange>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.util.Set<io.fotoapparat.parameter.FpsRange>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.util.Set<io.fotoapparat.parameter.FocusMode>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.util.Set<io.fotoapparat.parameter.FocusMode>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.util.Set<io.fotoapparat.parameter.Flash>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.util.Set<io.fotoapparat.parameter.Flash>} */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Capabilities copy$default(Capabilities capabilities, Zoom zoom2, Set set, Set set2, boolean z, int i, int i2, IntRange intRange, IntRange intRange2, Set set3, Set set4, Set set5, Set set6, Set set7, int i3, Object obj) {
        return capabilities.copy((i3 & 1) != 0 ? capabilities.zoom : zoom2, (i3 & 2) != 0 ? capabilities.flashModes : set, (i3 & 4) != 0 ? capabilities.focusModes : set2, (i3 & 8) != 0 ? capabilities.canSmoothZoom : z, (i3 & 16) != 0 ? capabilities.maxFocusAreas : i, (i3 & 32) != 0 ? capabilities.maxMeteringAreas : i2, (i3 & 64) != 0 ? capabilities.jpegQualityRange : intRange, (i3 & 128) != 0 ? capabilities.exposureCompensationRange : intRange2, (i3 & 256) != 0 ? capabilities.previewFpsRanges : set3, (i3 & 512) != 0 ? capabilities.antiBandingModes : set4, (i3 & 1024) != 0 ? capabilities.pictureResolutions : set5, (i3 & 2048) != 0 ? capabilities.previewResolutions : set6, (i3 & 4096) != 0 ? capabilities.sensorSensitivities : set7);
    }

    public final Zoom component1() {
        return this.zoom;
    }

    public final Set<AntiBandingMode> component10() {
        return this.antiBandingModes;
    }

    public final Set<Resolution> component11() {
        return this.pictureResolutions;
    }

    public final Set<Resolution> component12() {
        return this.previewResolutions;
    }

    public final Set<Integer> component13() {
        return this.sensorSensitivities;
    }

    public final Set<Flash> component2() {
        return this.flashModes;
    }

    public final Set<FocusMode> component3() {
        return this.focusModes;
    }

    public final boolean component4() {
        return this.canSmoothZoom;
    }

    public final int component5() {
        return this.maxFocusAreas;
    }

    public final int component6() {
        return this.maxMeteringAreas;
    }

    public final IntRange component7() {
        return this.jpegQualityRange;
    }

    public final IntRange component8() {
        return this.exposureCompensationRange;
    }

    public final Set<FpsRange> component9() {
        return this.previewFpsRanges;
    }

    public final Capabilities copy(Zoom zoom2, Set<? extends Flash> set, Set<? extends FocusMode> set2, boolean z, int i, int i2, IntRange intRange, IntRange intRange2, Set<FpsRange> set3, Set<? extends AntiBandingMode> set4, Set<Resolution> set5, Set<Resolution> set6, Set<Integer> set7) {
        Intrinsics.checkParameterIsNotNull(zoom2, "zoom");
        Intrinsics.checkParameterIsNotNull(set, "flashModes");
        Intrinsics.checkParameterIsNotNull(set2, "focusModes");
        Intrinsics.checkParameterIsNotNull(intRange, "jpegQualityRange");
        Intrinsics.checkParameterIsNotNull(intRange2, "exposureCompensationRange");
        Intrinsics.checkParameterIsNotNull(set3, "previewFpsRanges");
        Intrinsics.checkParameterIsNotNull(set4, "antiBandingModes");
        Intrinsics.checkParameterIsNotNull(set5, "pictureResolutions");
        Intrinsics.checkParameterIsNotNull(set6, "previewResolutions");
        Intrinsics.checkParameterIsNotNull(set7, "sensorSensitivities");
        return new Capabilities(zoom2, set, set2, z, i, i2, intRange, intRange2, set3, set4, set5, set6, set7);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Capabilities) {
                Capabilities capabilities = (Capabilities) obj;
                if (Intrinsics.areEqual(this.zoom, capabilities.zoom) && Intrinsics.areEqual(this.flashModes, capabilities.flashModes) && Intrinsics.areEqual(this.focusModes, capabilities.focusModes)) {
                    if (this.canSmoothZoom == capabilities.canSmoothZoom) {
                        if (this.maxFocusAreas == capabilities.maxFocusAreas) {
                            if (!(this.maxMeteringAreas == capabilities.maxMeteringAreas) || !Intrinsics.areEqual(this.jpegQualityRange, capabilities.jpegQualityRange) || !Intrinsics.areEqual(this.exposureCompensationRange, capabilities.exposureCompensationRange) || !Intrinsics.areEqual(this.previewFpsRanges, capabilities.previewFpsRanges) || !Intrinsics.areEqual(this.antiBandingModes, capabilities.antiBandingModes) || !Intrinsics.areEqual(this.pictureResolutions, capabilities.pictureResolutions) || !Intrinsics.areEqual(this.previewResolutions, capabilities.previewResolutions) || !Intrinsics.areEqual(this.sensorSensitivities, capabilities.sensorSensitivities)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Zoom zoom2 = this.zoom;
        int i = 0;
        int hashCode = (zoom2 != null ? zoom2.hashCode() : 0) * 31;
        Set<Flash> set = this.flashModes;
        int hashCode2 = (hashCode + (set != null ? set.hashCode() : 0)) * 31;
        Set<FocusMode> set2 = this.focusModes;
        int hashCode3 = (hashCode2 + (set2 != null ? set2.hashCode() : 0)) * 31;
        boolean z = this.canSmoothZoom;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = (((((hashCode3 + i2) * 31) + this.maxFocusAreas) * 31) + this.maxMeteringAreas) * 31;
        IntRange intRange = this.jpegQualityRange;
        int hashCode4 = (i4 + (intRange != null ? intRange.hashCode() : 0)) * 31;
        IntRange intRange2 = this.exposureCompensationRange;
        int hashCode5 = (hashCode4 + (intRange2 != null ? intRange2.hashCode() : 0)) * 31;
        Set<FpsRange> set3 = this.previewFpsRanges;
        int hashCode6 = (hashCode5 + (set3 != null ? set3.hashCode() : 0)) * 31;
        Set<AntiBandingMode> set4 = this.antiBandingModes;
        int hashCode7 = (hashCode6 + (set4 != null ? set4.hashCode() : 0)) * 31;
        Set<Resolution> set5 = this.pictureResolutions;
        int hashCode8 = (hashCode7 + (set5 != null ? set5.hashCode() : 0)) * 31;
        Set<Resolution> set6 = this.previewResolutions;
        int hashCode9 = (hashCode8 + (set6 != null ? set6.hashCode() : 0)) * 31;
        Set<Integer> set7 = this.sensorSensitivities;
        if (set7 != null) {
            i = set7.hashCode();
        }
        return hashCode9 + i;
    }

    public Capabilities(Zoom zoom2, Set<? extends Flash> set, Set<? extends FocusMode> set2, boolean z, int i, int i2, IntRange intRange, IntRange intRange2, Set<FpsRange> set3, Set<? extends AntiBandingMode> set4, Set<Resolution> set5, Set<Resolution> set6, Set<Integer> set7) {
        Intrinsics.checkParameterIsNotNull(zoom2, "zoom");
        Intrinsics.checkParameterIsNotNull(set, "flashModes");
        Intrinsics.checkParameterIsNotNull(set2, "focusModes");
        Intrinsics.checkParameterIsNotNull(intRange, "jpegQualityRange");
        Intrinsics.checkParameterIsNotNull(intRange2, "exposureCompensationRange");
        Intrinsics.checkParameterIsNotNull(set3, "previewFpsRanges");
        Intrinsics.checkParameterIsNotNull(set4, "antiBandingModes");
        Intrinsics.checkParameterIsNotNull(set5, "pictureResolutions");
        Intrinsics.checkParameterIsNotNull(set6, "previewResolutions");
        Intrinsics.checkParameterIsNotNull(set7, "sensorSensitivities");
        this.zoom = zoom2;
        this.flashModes = set;
        this.focusModes = set2;
        this.canSmoothZoom = z;
        this.maxFocusAreas = i;
        this.maxMeteringAreas = i2;
        this.jpegQualityRange = intRange;
        this.exposureCompensationRange = intRange2;
        this.previewFpsRanges = set3;
        this.antiBandingModes = set4;
        this.pictureResolutions = set5;
        this.previewResolutions = set6;
        this.sensorSensitivities = set7;
        if (set.isEmpty()) {
            throw new IllegalArgumentException("Capabilities cannot have an empty Set<" + Flash.class.getSimpleName() + ">.");
        } else if (this.focusModes.isEmpty()) {
            throw new IllegalArgumentException("Capabilities cannot have an empty Set<" + FocusMode.class.getSimpleName() + ">.");
        } else if (this.antiBandingModes.isEmpty()) {
            throw new IllegalArgumentException("Capabilities cannot have an empty Set<" + AntiBandingMode.class.getSimpleName() + ">.");
        } else if (this.previewFpsRanges.isEmpty()) {
            throw new IllegalArgumentException("Capabilities cannot have an empty Set<" + FpsRange.class.getSimpleName() + ">.");
        } else if (this.pictureResolutions.isEmpty()) {
            throw new IllegalArgumentException("Capabilities cannot have an empty Set<" + Resolution.class.getSimpleName() + ">.");
        } else if (this.previewResolutions.isEmpty()) {
            throw new IllegalArgumentException("Capabilities cannot have an empty Set<" + Resolution.class.getSimpleName() + ">.");
        }
    }

    public final Zoom getZoom() {
        return this.zoom;
    }

    public final Set<Flash> getFlashModes() {
        return this.flashModes;
    }

    public final Set<FocusMode> getFocusModes() {
        return this.focusModes;
    }

    public final boolean getCanSmoothZoom() {
        return this.canSmoothZoom;
    }

    public final int getMaxFocusAreas() {
        return this.maxFocusAreas;
    }

    public final int getMaxMeteringAreas() {
        return this.maxMeteringAreas;
    }

    public final IntRange getJpegQualityRange() {
        return this.jpegQualityRange;
    }

    public final IntRange getExposureCompensationRange() {
        return this.exposureCompensationRange;
    }

    public final Set<FpsRange> getPreviewFpsRanges() {
        return this.previewFpsRanges;
    }

    public final Set<AntiBandingMode> getAntiBandingModes() {
        return this.antiBandingModes;
    }

    public final Set<Resolution> getPictureResolutions() {
        return this.pictureResolutions;
    }

    public final Set<Resolution> getPreviewResolutions() {
        return this.previewResolutions;
    }

    public final Set<Integer> getSensorSensitivities() {
        return this.sensorSensitivities;
    }

    public String toString() {
        return "Capabilities" + StringExtensionsKt.getLineSeparator() + "zoom:" + StringExtensionsKt.wrap(this.zoom) + "flashModes:" + StringExtensionsKt.wrap((Set<? extends Object>) this.flashModes) + "focusModes:" + StringExtensionsKt.wrap((Set<? extends Object>) this.focusModes) + "canSmoothZoom:" + StringExtensionsKt.wrap(Boolean.valueOf(this.canSmoothZoom)) + "maxFocusAreas:" + StringExtensionsKt.wrap(Integer.valueOf(this.maxFocusAreas)) + "maxMeteringAreas:" + StringExtensionsKt.wrap(Integer.valueOf(this.maxMeteringAreas)) + "jpegQualityRange:" + StringExtensionsKt.wrap(this.jpegQualityRange) + "exposureCompensationRange:" + StringExtensionsKt.wrap(this.exposureCompensationRange) + "antiBandingModes:" + StringExtensionsKt.wrap((Set<? extends Object>) this.antiBandingModes) + "previewFpsRanges:" + StringExtensionsKt.wrap((Set<? extends Object>) this.previewFpsRanges) + "pictureResolutions:" + StringExtensionsKt.wrap((Set<? extends Object>) this.pictureResolutions) + "previewResolutions:" + StringExtensionsKt.wrap((Set<? extends Object>) this.previewResolutions) + "sensorSensitivities:" + StringExtensionsKt.wrap((Set<? extends Object>) this.sensorSensitivities);
    }
}
