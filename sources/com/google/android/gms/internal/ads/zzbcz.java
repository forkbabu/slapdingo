package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbcz extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzbda {
    private static final float[] zzegi = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private int height;
    private int width;
    private final float[] zzegf = new float[9];
    private final zzbcy zzegj;
    private final float[] zzegk = new float[9];
    private final float[] zzegl = new float[9];
    private final float[] zzegm = new float[9];
    private final float[] zzegn = new float[9];
    private final float[] zzego = new float[9];
    private final float[] zzegp = new float[9];
    private float zzegq = Float.NaN;
    private float zzegr;
    private float zzegs;
    private SurfaceTexture zzegt;
    private SurfaceTexture zzegu;
    private int zzegv;
    private int zzegw;
    private int zzegx;
    private FloatBuffer zzegy;
    private final CountDownLatch zzegz;
    private final Object zzeha;
    private EGL10 zzehb;
    private EGLDisplay zzehc;
    private EGLContext zzehd;
    private EGLSurface zzehe;
    private volatile boolean zzehf;
    private volatile boolean zzehg;

    public zzbcz(Context context) {
        super("SphericalVideoProcessor");
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(zzegi.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzegy = asFloatBuffer;
        asFloatBuffer.put(zzegi).position(0);
        zzbcy zzbcy = new zzbcy(context);
        this.zzegj = zzbcy;
        zzbcy.zza(this);
        this.zzegz = new CountDownLatch(1);
        this.zzeha = new Object();
    }

    public final void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.width = i;
        this.height = i2;
        this.zzegu = surfaceTexture;
    }

    public final void zzm(int i, int i2) {
        synchronized (this.zzeha) {
            this.width = i;
            this.height = i2;
            this.zzehf = true;
            this.zzeha.notifyAll();
        }
    }

    public final void zzzf() {
        synchronized (this.zzeha) {
            this.zzehg = true;
            this.zzegu = null;
            this.zzeha.notifyAll();
        }
    }

    public final SurfaceTexture zzzg() {
        if (this.zzegu == null) {
            return null;
        }
        try {
            this.zzegz.await();
        } catch (InterruptedException unused) {
        }
        return this.zzegt;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzegx++;
        synchronized (this.zzeha) {
            this.zzeha.notifyAll();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbda
    public final void zzup() {
        synchronized (this.zzeha) {
            this.zzeha.notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x03a6  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x03ab  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01d3 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r14 = this;
            android.graphics.SurfaceTexture r0 = r14.zzegu
            if (r0 != 0) goto L_0x000f
            java.lang.String r0 = "SphericalVideoProcessor started with no output texture."
            com.google.android.gms.internal.ads.zzaxv.zzfb(r0)
            java.util.concurrent.CountDownLatch r0 = r14.zzegz
            r0.countDown()
            return
        L_0x000f:
            javax.microedition.khronos.egl.EGL r0 = javax.microedition.khronos.egl.EGLContext.getEGL()
            javax.microedition.khronos.egl.EGL10 r0 = (javax.microedition.khronos.egl.EGL10) r0
            r14.zzehb = r0
            java.lang.Object r1 = javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY
            javax.microedition.khronos.egl.EGLDisplay r0 = r0.eglGetDisplay(r1)
            r14.zzehc = r0
            javax.microedition.khronos.egl.EGLDisplay r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            r6 = 0
            if (r0 != r1) goto L_0x002b
        L_0x0028:
            r0 = 0
            goto L_0x0096
        L_0x002b:
            int[] r0 = new int[r3]
            javax.microedition.khronos.egl.EGL10 r1 = r14.zzehb
            javax.microedition.khronos.egl.EGLDisplay r7 = r14.zzehc
            boolean r0 = r1.eglInitialize(r7, r0)
            if (r0 != 0) goto L_0x0038
            goto L_0x0028
        L_0x0038:
            int[] r0 = new int[r5]
            javax.microedition.khronos.egl.EGLConfig[] r1 = new javax.microedition.khronos.egl.EGLConfig[r5]
            r7 = 11
            int[] r9 = new int[r7]
            r9 = {x03ca: FILL_ARRAY_DATA  , data: [12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r7 = r14.zzehb
            javax.microedition.khronos.egl.EGLDisplay r8 = r14.zzehc
            r11 = 1
            r10 = r1
            r12 = r0
            boolean r7 = r7.eglChooseConfig(r8, r9, r10, r11, r12)
            if (r7 == 0) goto L_0x0057
            r0 = r0[r6]
            if (r0 <= 0) goto L_0x0057
            r0 = r1[r6]
            goto L_0x0058
        L_0x0057:
            r0 = r4
        L_0x0058:
            if (r0 != 0) goto L_0x005b
            goto L_0x0028
        L_0x005b:
            int[] r1 = new int[r2]
            r1 = {x03e4: FILL_ARRAY_DATA  , data: [12440, 2, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r7 = r14.zzehb
            javax.microedition.khronos.egl.EGLDisplay r8 = r14.zzehc
            javax.microedition.khronos.egl.EGLContext r9 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            javax.microedition.khronos.egl.EGLContext r1 = r7.eglCreateContext(r8, r0, r9, r1)
            r14.zzehd = r1
            if (r1 == 0) goto L_0x0028
            javax.microedition.khronos.egl.EGLContext r7 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            if (r1 != r7) goto L_0x0073
            goto L_0x0028
        L_0x0073:
            javax.microedition.khronos.egl.EGL10 r1 = r14.zzehb
            javax.microedition.khronos.egl.EGLDisplay r7 = r14.zzehc
            android.graphics.SurfaceTexture r8 = r14.zzegu
            javax.microedition.khronos.egl.EGLSurface r0 = r1.eglCreateWindowSurface(r7, r0, r8, r4)
            r14.zzehe = r0
            if (r0 == 0) goto L_0x0028
            javax.microedition.khronos.egl.EGLSurface r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE
            if (r0 != r1) goto L_0x0086
            goto L_0x0028
        L_0x0086:
            javax.microedition.khronos.egl.EGL10 r0 = r14.zzehb
            javax.microedition.khronos.egl.EGLDisplay r1 = r14.zzehc
            javax.microedition.khronos.egl.EGLSurface r7 = r14.zzehe
            javax.microedition.khronos.egl.EGLContext r8 = r14.zzehd
            boolean r0 = r0.eglMakeCurrent(r1, r7, r7, r8)
            if (r0 != 0) goto L_0x0095
            goto L_0x0028
        L_0x0095:
            r0 = 1
        L_0x0096:
            r1 = 35633(0x8b31, float:4.9932E-41)
            com.google.android.gms.internal.ads.zzaag<java.lang.String> r7 = com.google.android.gms.internal.ads.zzaav.zzcpf
            com.google.android.gms.internal.ads.zzaar r8 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r8 = r8.zzd(r7)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r7.zzrb()
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00ba
            com.google.android.gms.internal.ads.zzaar r8 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r7 = r8.zzd(r7)
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x00bc
        L_0x00ba:
            java.lang.String r7 = "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}"
        L_0x00bc:
            int r1 = zzd(r1, r7)
            if (r1 != 0) goto L_0x00c5
        L_0x00c2:
            r8 = 0
            goto L_0x0147
        L_0x00c5:
            r7 = 35632(0x8b30, float:4.9931E-41)
            com.google.android.gms.internal.ads.zzaag<java.lang.String> r8 = com.google.android.gms.internal.ads.zzaav.zzcpg
            com.google.android.gms.internal.ads.zzaar r9 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r9 = r9.zzd(r8)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r8.zzrb()
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00e9
            com.google.android.gms.internal.ads.zzaar r9 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r8 = r9.zzd(r8)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00eb
        L_0x00e9:
            java.lang.String r8 = "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}"
        L_0x00eb:
            int r7 = zzd(r7, r8)
            if (r7 != 0) goto L_0x00f2
            goto L_0x00c2
        L_0x00f2:
            int r8 = android.opengl.GLES20.glCreateProgram()
            java.lang.String r9 = "createProgram"
            zzfh(r9)
            if (r8 == 0) goto L_0x0147
            android.opengl.GLES20.glAttachShader(r8, r1)
            java.lang.String r1 = "attachShader"
            zzfh(r1)
            android.opengl.GLES20.glAttachShader(r8, r7)
            java.lang.String r1 = "attachShader"
            zzfh(r1)
            android.opengl.GLES20.glLinkProgram(r8)
            java.lang.String r1 = "linkProgram"
            zzfh(r1)
            int[] r1 = new int[r5]
            r7 = 35714(0x8b82, float:5.0046E-41)
            android.opengl.GLES20.glGetProgramiv(r8, r7, r1, r6)
            java.lang.String r7 = "getProgramiv"
            zzfh(r7)
            r1 = r1[r6]
            if (r1 == r5) goto L_0x013f
            java.lang.String r1 = "SphericalVideoRenderer"
            java.lang.String r7 = "Could not link program: "
            android.util.Log.e(r1, r7)
            java.lang.String r1 = "SphericalVideoRenderer"
            java.lang.String r7 = android.opengl.GLES20.glGetProgramInfoLog(r8)
            android.util.Log.e(r1, r7)
            android.opengl.GLES20.glDeleteProgram(r8)
            java.lang.String r1 = "deleteProgram"
            zzfh(r1)
            goto L_0x00c2
        L_0x013f:
            android.opengl.GLES20.glValidateProgram(r8)
            java.lang.String r1 = "validateProgram"
            zzfh(r1)
        L_0x0147:
            r14.zzegv = r8
            android.opengl.GLES20.glUseProgram(r8)
            java.lang.String r1 = "useProgram"
            zzfh(r1)
            int r1 = r14.zzegv
            java.lang.String r7 = "aPosition"
            int r1 = android.opengl.GLES20.glGetAttribLocation(r1, r7)
            r9 = 3
            r10 = 5126(0x1406, float:7.183E-42)
            r11 = 0
            r12 = 12
            java.nio.FloatBuffer r13 = r14.zzegy
            r8 = r1
            android.opengl.GLES20.glVertexAttribPointer(r8, r9, r10, r11, r12, r13)
            java.lang.String r7 = "vertexAttribPointer"
            zzfh(r7)
            android.opengl.GLES20.glEnableVertexAttribArray(r1)
            java.lang.String r1 = "enableVertexAttribArray"
            zzfh(r1)
            int[] r1 = new int[r5]
            android.opengl.GLES20.glGenTextures(r5, r1, r6)
            java.lang.String r7 = "genTextures"
            zzfh(r7)
            r1 = r1[r6]
            r7 = 36197(0x8d65, float:5.0723E-41)
            android.opengl.GLES20.glBindTexture(r7, r1)
            java.lang.String r8 = "bindTextures"
            zzfh(r8)
            r8 = 10240(0x2800, float:1.4349E-41)
            r9 = 9729(0x2601, float:1.3633E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzfh(r8)
            r8 = 10241(0x2801, float:1.435E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzfh(r8)
            r8 = 10242(0x2802, float:1.4352E-41)
            r9 = 33071(0x812f, float:4.6342E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzfh(r8)
            r8 = 10243(0x2803, float:1.4354E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r7 = "texParameteri"
            zzfh(r7)
            int r7 = r14.zzegv
            java.lang.String r8 = "uVMat"
            int r7 = android.opengl.GLES20.glGetUniformLocation(r7, r8)
            r14.zzegw = r7
            r8 = 9
            float[] r8 = new float[r8]
            r8 = {x03ee: FILL_ARRAY_DATA  , data: [1065353216, 0, 0, 0, 1065353216, 0, 0, 0, 1065353216} // fill-array
            android.opengl.GLES20.glUniformMatrix3fv(r7, r5, r6, r8, r6)
            int r7 = r14.zzegv
            if (r7 == 0) goto L_0x01d0
            r7 = 1
            goto L_0x01d1
        L_0x01d0:
            r7 = 0
        L_0x01d1:
            if (r0 == 0) goto L_0x0390
            if (r7 != 0) goto L_0x01d7
            goto L_0x0390
        L_0x01d7:
            android.graphics.SurfaceTexture r0 = new android.graphics.SurfaceTexture
            r0.<init>(r1)
            r14.zzegt = r0
            r0.setOnFrameAvailableListener(r14)
            java.util.concurrent.CountDownLatch r0 = r14.zzegz
            r0.countDown()
            com.google.android.gms.internal.ads.zzbcy r0 = r14.zzegj
            r0.start()
            r14.zzehf = r5     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
        L_0x01ed:
            boolean r0 = r14.zzehg     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            if (r0 != 0) goto L_0x033b
        L_0x01f1:
            int r0 = r14.zzegx     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            if (r0 <= 0) goto L_0x0200
            android.graphics.SurfaceTexture r0 = r14.zzegt     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r0.updateTexImage()     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            int r0 = r14.zzegx     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            int r0 = r0 - r5
            r14.zzegx = r0     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            goto L_0x01f1
        L_0x0200:
            com.google.android.gms.internal.ads.zzbcy r0 = r14.zzegj     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r1 = r14.zzegf     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            boolean r0 = r0.zza(r1)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r1 = 5
            r7 = 4
            r8 = 1070141403(0x3fc90fdb, float:1.5707964)
            if (r0 == 0) goto L_0x0286
            float r0 = r14.zzegq     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            boolean r0 = java.lang.Float.isNaN(r0)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            if (r0 == 0) goto L_0x027b
            float[] r0 = r14.zzegf     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r9 = new float[r2]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r10 = 0
            r9[r6] = r10     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r11 = 1065353216(0x3f800000, float:1.0)
            r9[r5] = r11     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r9[r3] = r10     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r10 = new float[r2]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r11 = r0[r6]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r12 = r9[r6]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r11 = r11 * r12
            r12 = r0[r5]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r13 = r9[r5]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r12 = r0[r3]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r13 = r9[r3]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r10[r6] = r11     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r11 = r0[r2]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r12 = r9[r6]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r11 = r11 * r12
            r12 = r0[r7]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r13 = r9[r5]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r12 = r0[r1]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r13 = r9[r3]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r10[r5] = r11     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r11 = 6
            r11 = r0[r11]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r12 = r9[r6]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r11 = r11 * r12
            r12 = 7
            r12 = r0[r12]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r13 = r9[r5]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r12 = 8
            r0 = r0[r12]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r9 = r9[r3]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r0 = r0 * r9
            float r11 = r11 + r0
            r10[r3] = r11     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r0 = r10[r5]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            double r11 = (double) r0     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r0 = r10[r6]     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            double r9 = (double) r0     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            double r9 = java.lang.Math.atan2(r11, r9)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r0 = (float) r9     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r0 = r0 - r8
            float r0 = -r0
            r14.zzegq = r0     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
        L_0x027b:
            float[] r0 = r14.zzego     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r9 = r14.zzegq     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r10 = r14.zzegr     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r9 = r9 + r10
            zzb(r0, r9)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            goto L_0x0295
        L_0x0286:
            float[] r0 = r14.zzegf     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r9 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            zza(r0, r9)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r0 = r14.zzego     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r9 = r14.zzegr     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            zzb(r0, r9)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
        L_0x0295:
            float[] r0 = r14.zzegk     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            zza(r0, r8)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r0 = r14.zzegl     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r8 = r14.zzego     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r9 = r14.zzegk     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            zza(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r0 = r14.zzegm     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r8 = r14.zzegf     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r9 = r14.zzegl     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            zza(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r0 = r14.zzegn     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r8 = r14.zzegs     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            zza(r0, r8)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r0 = r14.zzegp     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r8 = r14.zzegn     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r9 = r14.zzegm     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            zza(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            int r0 = r14.zzegw     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float[] r8 = r14.zzegp     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            android.opengl.GLES20.glUniformMatrix3fv(r0, r5, r6, r8, r6)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            android.opengl.GLES20.glDrawArrays(r1, r6, r7)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            java.lang.String r0 = "drawArrays"
            zzfh(r0)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            android.opengl.GLES20.glFinish()     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            javax.microedition.khronos.egl.EGL10 r0 = r14.zzehb     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            javax.microedition.khronos.egl.EGLDisplay r1 = r14.zzehc     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            javax.microedition.khronos.egl.EGLSurface r7 = r14.zzehe     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r0.eglSwapBuffers(r1, r7)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            boolean r0 = r14.zzehf     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            if (r0 == 0) goto L_0x0321
            int r0 = r14.width     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            int r1 = r14.height     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            android.opengl.GLES20.glViewport(r6, r6, r0, r1)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            java.lang.String r0 = "viewport"
            zzfh(r0)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            int r0 = r14.zzegv     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            java.lang.String r1 = "uFOVx"
            int r0 = android.opengl.GLES20.glGetUniformLocation(r0, r1)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            int r1 = r14.zzegv     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            java.lang.String r7 = "uFOVy"
            int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r7)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            int r7 = r14.width     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            int r8 = r14.height     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            r9 = 1063216883(0x3f5f66f3, float:0.87266463)
            if (r7 <= r8) goto L_0x0310
            android.opengl.GLES20.glUniform1f(r0, r9)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            int r0 = r14.height     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r0 = (float) r0     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r0 = r0 * r9
            int r7 = r14.width     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r7 = (float) r7     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r0 = r0 / r7
            android.opengl.GLES20.glUniform1f(r1, r0)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            goto L_0x031f
        L_0x0310:
            int r7 = r14.width     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r7 = (float) r7     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r7 = r7 * r9
            int r8 = r14.height     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r8 = (float) r8     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            float r7 = r7 / r8
            android.opengl.GLES20.glUniform1f(r0, r7)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
            android.opengl.GLES20.glUniform1f(r1, r9)     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
        L_0x031f:
            r14.zzehf = r6     // Catch:{ IllegalStateException -> 0x036a, all -> 0x034b }
        L_0x0321:
            java.lang.Object r0 = r14.zzeha     // Catch:{ InterruptedException -> 0x01ed }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x01ed }
            boolean r1 = r14.zzehg     // Catch:{ all -> 0x0338 }
            if (r1 != 0) goto L_0x0335
            boolean r1 = r14.zzehf     // Catch:{ all -> 0x0338 }
            if (r1 != 0) goto L_0x0335
            int r1 = r14.zzegx     // Catch:{ all -> 0x0338 }
            if (r1 != 0) goto L_0x0335
            java.lang.Object r1 = r14.zzeha     // Catch:{ all -> 0x0338 }
            r1.wait()     // Catch:{ all -> 0x0338 }
        L_0x0335:
            monitor-exit(r0)     // Catch:{ all -> 0x0338 }
            goto L_0x01ed
        L_0x0338:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0338 }
            throw r1
        L_0x033b:
            com.google.android.gms.internal.ads.zzbcy r0 = r14.zzegj
            r0.stop()
            android.graphics.SurfaceTexture r0 = r14.zzegt
            r0.setOnFrameAvailableListener(r4)
            r14.zzegt = r4
            r14.zzzh()
            return
        L_0x034b:
            r0 = move-exception
            java.lang.String r1 = "SphericalVideoProcessor died."
            com.google.android.gms.internal.ads.zzaxv.zzc(r1, r0)     // Catch:{ all -> 0x037f }
            com.google.android.gms.internal.ads.zzaxh r1 = com.google.android.gms.ads.internal.zzq.zzla()     // Catch:{ all -> 0x037f }
            java.lang.String r2 = "SphericalVideoProcessor.run.2"
            r1.zza(r0, r2)     // Catch:{ all -> 0x037f }
            com.google.android.gms.internal.ads.zzbcy r0 = r14.zzegj
            r0.stop()
            android.graphics.SurfaceTexture r0 = r14.zzegt
            r0.setOnFrameAvailableListener(r4)
            r14.zzegt = r4
            r14.zzzh()
            return
        L_0x036a:
            java.lang.String r0 = "SphericalVideoProcessor halted unexpectedly."
            com.google.android.gms.internal.ads.zzaxv.zzfd(r0)
            com.google.android.gms.internal.ads.zzbcy r0 = r14.zzegj
            r0.stop()
            android.graphics.SurfaceTexture r0 = r14.zzegt
            r0.setOnFrameAvailableListener(r4)
            r14.zzegt = r4
            r14.zzzh()
            return
        L_0x037f:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzbcy r1 = r14.zzegj
            r1.stop()
            android.graphics.SurfaceTexture r1 = r14.zzegt
            r1.setOnFrameAvailableListener(r4)
            r14.zzegt = r4
            r14.zzzh()
            throw r0
        L_0x0390:
            javax.microedition.khronos.egl.EGL10 r0 = r14.zzehb
            int r0 = r0.eglGetError()
            java.lang.String r0 = android.opengl.GLUtils.getEGLErrorString(r0)
            java.lang.String r1 = "EGL initialization failed: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r2 = r0.length()
            if (r2 == 0) goto L_0x03ab
            java.lang.String r0 = r1.concat(r0)
            goto L_0x03b0
        L_0x03ab:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
        L_0x03b0:
            com.google.android.gms.internal.ads.zzaxv.zzfb(r0)
            com.google.android.gms.internal.ads.zzaxh r1 = com.google.android.gms.ads.internal.zzq.zzla()
            java.lang.Throwable r2 = new java.lang.Throwable
            r2.<init>(r0)
            java.lang.String r0 = "SphericalVideoProcessor.run.1"
            r1.zza(r2, r0)
            r14.zzzh()
            java.util.concurrent.CountDownLatch r0 = r14.zzegz
            r0.countDown()
            return
            fill-array 0x03ca: FILL_ARRAY_DATA  , data: [12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344]
            fill-array 0x03e4: FILL_ARRAY_DATA  , data: [12440, 2, 12344]
            fill-array 0x03ee: FILL_ARRAY_DATA  , data: [1065353216, 0, 0, 0, 1065353216, 0, 0, 0, 1065353216]
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcz.run():void");
    }

    public final void zzb(float f, float f2) {
        float f3;
        float f4;
        float f5;
        int i = this.width;
        int i2 = this.height;
        if (i > i2) {
            f4 = (f * 1.7453293f) / ((float) i);
            f3 = f2 * 1.7453293f;
            f5 = (float) i;
        } else {
            f4 = (f * 1.7453293f) / ((float) i2);
            f3 = f2 * 1.7453293f;
            f5 = (float) i2;
        }
        this.zzegr -= f4;
        float f6 = this.zzegs - (f3 / f5);
        this.zzegs = f6;
        if (f6 < -1.5707964f) {
            this.zzegs = -1.5707964f;
        }
        if (this.zzegs > 1.5707964f) {
            this.zzegs = 1.5707964f;
        }
    }

    private static void zza(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static void zza(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = (double) f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    private static void zzb(float[] fArr, float f) {
        double d = (double) f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static int zzd(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        zzfh("createShader");
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        zzfh("shaderSource");
        GLES20.glCompileShader(glCreateShader);
        zzfh("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        zzfh("getShaderiv");
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Could not compile shader ");
        sb.append(i);
        sb.append(":");
        Log.e("SphericalVideoRenderer", sb.toString());
        Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        zzfh("deleteShader");
        return 0;
    }

    private final boolean zzzh() {
        EGLSurface eGLSurface = this.zzehe;
        boolean z = false;
        if (!(eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE)) {
            z = this.zzehb.eglDestroySurface(this.zzehc, this.zzehe) | this.zzehb.eglMakeCurrent(this.zzehc, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | false;
            this.zzehe = null;
        }
        EGLContext eGLContext = this.zzehd;
        if (eGLContext != null) {
            z |= this.zzehb.eglDestroyContext(this.zzehc, eGLContext);
            this.zzehd = null;
        }
        EGLDisplay eGLDisplay = this.zzehc;
        if (eGLDisplay == null) {
            return z;
        }
        boolean eglTerminate = z | this.zzehb.eglTerminate(eGLDisplay);
        this.zzehc = null;
        return eglTerminate;
    }

    private static void zzfh(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
            sb.append(str);
            sb.append(": glError ");
            sb.append(glGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }
}
