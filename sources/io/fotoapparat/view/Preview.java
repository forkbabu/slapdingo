package io.fotoapparat.view;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lio/fotoapparat/view/Preview;", "", "()V", "Surface", "Texture", "Lio/fotoapparat/view/Preview$Texture;", "Lio/fotoapparat/view/Preview$Surface;", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Preview.kt */
public abstract class Preview {
    private Preview() {
    }

    public /* synthetic */ Preview(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/fotoapparat/view/Preview$Texture;", "Lio/fotoapparat/view/Preview;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;)V", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: Preview.kt */
    public static final class Texture extends Preview {
        private final SurfaceTexture surfaceTexture;

        public static /* synthetic */ Texture copy$default(Texture texture, SurfaceTexture surfaceTexture2, int i, Object obj) {
            if ((i & 1) != 0) {
                surfaceTexture2 = texture.surfaceTexture;
            }
            return texture.copy(surfaceTexture2);
        }

        public final SurfaceTexture component1() {
            return this.surfaceTexture;
        }

        public final Texture copy(SurfaceTexture surfaceTexture2) {
            Intrinsics.checkParameterIsNotNull(surfaceTexture2, "surfaceTexture");
            return new Texture(surfaceTexture2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Texture) && Intrinsics.areEqual(this.surfaceTexture, ((Texture) obj).surfaceTexture);
            }
            return true;
        }

        public int hashCode() {
            SurfaceTexture surfaceTexture2 = this.surfaceTexture;
            if (surfaceTexture2 != null) {
                return surfaceTexture2.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Texture(surfaceTexture=" + this.surfaceTexture + ")";
        }

        public final SurfaceTexture getSurfaceTexture() {
            return this.surfaceTexture;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Texture(SurfaceTexture surfaceTexture2) {
            super(null);
            Intrinsics.checkParameterIsNotNull(surfaceTexture2, "surfaceTexture");
            this.surfaceTexture = surfaceTexture2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/fotoapparat/view/Preview$Surface;", "Lio/fotoapparat/view/Preview;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;)V", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: Preview.kt */
    public static final class Surface extends Preview {
        private final SurfaceHolder surfaceHolder;

        public static /* synthetic */ Surface copy$default(Surface surface, SurfaceHolder surfaceHolder2, int i, Object obj) {
            if ((i & 1) != 0) {
                surfaceHolder2 = surface.surfaceHolder;
            }
            return surface.copy(surfaceHolder2);
        }

        public final SurfaceHolder component1() {
            return this.surfaceHolder;
        }

        public final Surface copy(SurfaceHolder surfaceHolder2) {
            Intrinsics.checkParameterIsNotNull(surfaceHolder2, "surfaceHolder");
            return new Surface(surfaceHolder2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Surface) && Intrinsics.areEqual(this.surfaceHolder, ((Surface) obj).surfaceHolder);
            }
            return true;
        }

        public int hashCode() {
            SurfaceHolder surfaceHolder2 = this.surfaceHolder;
            if (surfaceHolder2 != null) {
                return surfaceHolder2.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Surface(surfaceHolder=" + this.surfaceHolder + ")";
        }

        public final SurfaceHolder getSurfaceHolder() {
            return this.surfaceHolder;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Surface(SurfaceHolder surfaceHolder2) {
            super(null);
            Intrinsics.checkParameterIsNotNull(surfaceHolder2, "surfaceHolder");
            this.surfaceHolder = surfaceHolder2;
        }
    }
}
