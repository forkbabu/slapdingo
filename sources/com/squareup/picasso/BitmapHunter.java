package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.os.Build;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.squareup.picasso.NetworkRequestHandler;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.spongycastle.crypto.tls.CipherSuite;

class BitmapHunter implements Runnable {
    private static final Object DECODE_LOCK = new Object();
    private static final RequestHandler ERRORING_HANDLER = new RequestHandler() {
        /* class com.squareup.picasso.BitmapHunter.AnonymousClass2 */

        @Override // com.squareup.picasso.RequestHandler
        public boolean canHandleRequest(Request request) {
            return true;
        }

        @Override // com.squareup.picasso.RequestHandler
        public RequestHandler.Result load(Request request, int i) throws IOException {
            throw new IllegalStateException("Unrecognized type of request: " + request);
        }
    };
    private static final ThreadLocal<StringBuilder> NAME_BUILDER = new ThreadLocal<StringBuilder>() {
        /* class com.squareup.picasso.BitmapHunter.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    };
    private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
    Action action;
    List<Action> actions;
    final Cache cache;
    final Request data;
    final Dispatcher dispatcher;
    Exception exception;
    int exifOrientation;
    Future<?> future;
    final String key;
    Picasso.LoadedFrom loadedFrom;
    final int memoryPolicy;
    int networkPolicy;
    final Picasso picasso;
    Picasso.Priority priority;
    final RequestHandler requestHandler;
    Bitmap result;
    int retryCount;
    final int sequence = SEQUENCE_GENERATOR.incrementAndGet();
    final Stats stats;

    static int getExifRotation(int i) {
        switch (i) {
            case 3:
            case 4:
                return CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
            default:
                return 0;
        }
    }

    static int getExifTranslation(int i) {
        return (i == 2 || i == 7 || i == 4 || i == 5) ? -1 : 1;
    }

    private static boolean shouldResize(boolean z, int i, int i2, int i3, int i4) {
        return !z || (i3 != 0 && i > i3) || (i4 != 0 && i2 > i4);
    }

    BitmapHunter(Picasso picasso2, Dispatcher dispatcher2, Cache cache2, Stats stats2, Action action2, RequestHandler requestHandler2) {
        this.picasso = picasso2;
        this.dispatcher = dispatcher2;
        this.cache = cache2;
        this.stats = stats2;
        this.action = action2;
        this.key = action2.getKey();
        this.data = action2.getRequest();
        this.priority = action2.getPriority();
        this.memoryPolicy = action2.getMemoryPolicy();
        this.networkPolicy = action2.getNetworkPolicy();
        this.requestHandler = requestHandler2;
        this.retryCount = requestHandler2.getRetryCount();
    }

    static Bitmap decodeStream(Source source, Request request) throws IOException {
        BufferedSource buffer = Okio.buffer(source);
        boolean isWebPFile = Utils.isWebPFile(buffer);
        boolean z = request.purgeable && Build.VERSION.SDK_INT < 21;
        BitmapFactory.Options createBitmapOptions = RequestHandler.createBitmapOptions(request);
        boolean requiresInSampleSize = RequestHandler.requiresInSampleSize(createBitmapOptions);
        if (isWebPFile || z) {
            byte[] readByteArray = buffer.readByteArray();
            if (requiresInSampleSize) {
                BitmapFactory.decodeByteArray(readByteArray, 0, readByteArray.length, createBitmapOptions);
                RequestHandler.calculateInSampleSize(request.targetWidth, request.targetHeight, createBitmapOptions, request);
            }
            return BitmapFactory.decodeByteArray(readByteArray, 0, readByteArray.length, createBitmapOptions);
        }
        InputStream inputStream = buffer.inputStream();
        if (requiresInSampleSize) {
            MarkableInputStream markableInputStream = new MarkableInputStream(inputStream);
            markableInputStream.allowMarksToExpire(false);
            long savePosition = markableInputStream.savePosition(1024);
            BitmapFactory.decodeStream(markableInputStream, null, createBitmapOptions);
            RequestHandler.calculateInSampleSize(request.targetWidth, request.targetHeight, createBitmapOptions, request);
            markableInputStream.reset(savePosition);
            markableInputStream.allowMarksToExpire(true);
            inputStream = markableInputStream;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, createBitmapOptions);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    public void run() {
        try {
            updateThreadName(this.data);
            if (this.picasso.loggingEnabled) {
                Utils.log("Hunter", "executing", Utils.getLogIdsForHunter(this));
            }
            Bitmap hunt = hunt();
            this.result = hunt;
            if (hunt == null) {
                this.dispatcher.dispatchFailed(this);
            } else {
                this.dispatcher.dispatchComplete(this);
            }
        } catch (NetworkRequestHandler.ResponseException e) {
            if (!NetworkPolicy.isOfflineOnly(e.networkPolicy) || e.code != 504) {
                this.exception = e;
            }
            this.dispatcher.dispatchFailed(this);
        } catch (IOException e2) {
            this.exception = e2;
            this.dispatcher.dispatchRetry(this);
        } catch (OutOfMemoryError e3) {
            StringWriter stringWriter = new StringWriter();
            this.stats.createSnapshot().dump(new PrintWriter(stringWriter));
            this.exception = new RuntimeException(stringWriter.toString(), e3);
            this.dispatcher.dispatchFailed(this);
        } catch (Exception e4) {
            this.exception = e4;
            this.dispatcher.dispatchFailed(this);
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
            throw th;
        }
        Thread.currentThread().setName("Picasso-Idle");
    }

    /* access modifiers changed from: package-private */
    public Bitmap hunt() throws IOException {
        Bitmap bitmap;
        if (MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy)) {
            bitmap = this.cache.get(this.key);
            if (bitmap != null) {
                this.stats.dispatchCacheHit();
                this.loadedFrom = Picasso.LoadedFrom.MEMORY;
                if (this.picasso.loggingEnabled) {
                    Utils.log("Hunter", "decoded", this.data.logId(), "from cache");
                }
                return bitmap;
            }
        } else {
            bitmap = null;
        }
        int i = this.retryCount == 0 ? NetworkPolicy.OFFLINE.index : this.networkPolicy;
        this.networkPolicy = i;
        RequestHandler.Result load = this.requestHandler.load(this.data, i);
        if (load != null) {
            this.loadedFrom = load.getLoadedFrom();
            this.exifOrientation = load.getExifOrientation();
            bitmap = load.getBitmap();
            if (bitmap == null) {
                Source source = load.getSource();
                try {
                    bitmap = decodeStream(source, this.data);
                } finally {
                    try {
                        source.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
        if (bitmap != null) {
            if (this.picasso.loggingEnabled) {
                Utils.log("Hunter", "decoded", this.data.logId());
            }
            this.stats.dispatchBitmapDecoded(bitmap);
            if (this.data.needsTransformation() || this.exifOrientation != 0) {
                synchronized (DECODE_LOCK) {
                    if (this.data.needsMatrixTransform() || this.exifOrientation != 0) {
                        bitmap = transformResult(this.data, bitmap, this.exifOrientation);
                        if (this.picasso.loggingEnabled) {
                            Utils.log("Hunter", "transformed", this.data.logId());
                        }
                    }
                    if (this.data.hasCustomTransformations()) {
                        bitmap = applyCustomTransformations(this.data.transformations, bitmap);
                        if (this.picasso.loggingEnabled) {
                            Utils.log("Hunter", "transformed", this.data.logId(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.stats.dispatchBitmapTransformed(bitmap);
                }
            }
        }
        return bitmap;
    }

    /* access modifiers changed from: package-private */
    public void attach(Action action2) {
        boolean z = this.picasso.loggingEnabled;
        Request request = action2.request;
        if (this.action == null) {
            this.action = action2;
            if (z) {
                List<Action> list = this.actions;
                if (list == null || list.isEmpty()) {
                    Utils.log("Hunter", "joined", request.logId(), "to empty hunter");
                } else {
                    Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to "));
                }
            }
        } else {
            if (this.actions == null) {
                this.actions = new ArrayList(3);
            }
            this.actions.add(action2);
            if (z) {
                Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to "));
            }
            Picasso.Priority priority2 = action2.getPriority();
            if (priority2.ordinal() > this.priority.ordinal()) {
                this.priority = priority2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void detach(Action action2) {
        boolean z;
        if (this.action == action2) {
            this.action = null;
            z = true;
        } else {
            List<Action> list = this.actions;
            z = list != null ? list.remove(action2) : false;
        }
        if (z && action2.getPriority() == this.priority) {
            this.priority = computeNewPriority();
        }
        if (this.picasso.loggingEnabled) {
            Utils.log("Hunter", "removed", action2.request.logId(), Utils.getLogIdsForHunter(this, "from "));
        }
    }

    private Picasso.Priority computeNewPriority() {
        Picasso.Priority priority2 = Picasso.Priority.LOW;
        List<Action> list = this.actions;
        boolean z = true;
        boolean z2 = list != null && !list.isEmpty();
        if (this.action == null && !z2) {
            z = false;
        }
        if (!z) {
            return priority2;
        }
        Action action2 = this.action;
        if (action2 != null) {
            priority2 = action2.getPriority();
        }
        if (z2) {
            int size = this.actions.size();
            for (int i = 0; i < size; i++) {
                Picasso.Priority priority3 = this.actions.get(i).getPriority();
                if (priority3.ordinal() > priority2.ordinal()) {
                    priority2 = priority3;
                }
            }
        }
        return priority2;
    }

    /* access modifiers changed from: package-private */
    public boolean cancel() {
        Future<?> future2;
        if (this.action != null) {
            return false;
        }
        List<Action> list = this.actions;
        if ((list == null || list.isEmpty()) && (future2 = this.future) != null && future2.cancel(false)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isCancelled() {
        Future<?> future2 = this.future;
        return future2 != null && future2.isCancelled();
    }

    /* access modifiers changed from: package-private */
    public boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        if (!(this.retryCount > 0)) {
            return false;
        }
        this.retryCount--;
        return this.requestHandler.shouldRetry(z, networkInfo);
    }

    /* access modifiers changed from: package-private */
    public boolean supportsReplay() {
        return this.requestHandler.supportsReplay();
    }

    /* access modifiers changed from: package-private */
    public Bitmap getResult() {
        return this.result;
    }

    /* access modifiers changed from: package-private */
    public String getKey() {
        return this.key;
    }

    /* access modifiers changed from: package-private */
    public int getMemoryPolicy() {
        return this.memoryPolicy;
    }

    /* access modifiers changed from: package-private */
    public Request getData() {
        return this.data;
    }

    /* access modifiers changed from: package-private */
    public Action getAction() {
        return this.action;
    }

    /* access modifiers changed from: package-private */
    public Picasso getPicasso() {
        return this.picasso;
    }

    /* access modifiers changed from: package-private */
    public List<Action> getActions() {
        return this.actions;
    }

    /* access modifiers changed from: package-private */
    public Exception getException() {
        return this.exception;
    }

    /* access modifiers changed from: package-private */
    public Picasso.LoadedFrom getLoadedFrom() {
        return this.loadedFrom;
    }

    /* access modifiers changed from: package-private */
    public Picasso.Priority getPriority() {
        return this.priority;
    }

    static void updateThreadName(Request request) {
        String name = request.getName();
        StringBuilder sb = NAME_BUILDER.get();
        sb.ensureCapacity(name.length() + 8);
        sb.replace(8, sb.length(), name);
        Thread.currentThread().setName(sb.toString());
    }

    static BitmapHunter forRequest(Picasso picasso2, Dispatcher dispatcher2, Cache cache2, Stats stats2, Action action2) {
        Request request = action2.getRequest();
        List<RequestHandler> requestHandlers = picasso2.getRequestHandlers();
        int size = requestHandlers.size();
        for (int i = 0; i < size; i++) {
            RequestHandler requestHandler2 = requestHandlers.get(i);
            if (requestHandler2.canHandleRequest(request)) {
                return new BitmapHunter(picasso2, dispatcher2, cache2, stats2, action2, requestHandler2);
            }
        }
        return new BitmapHunter(picasso2, dispatcher2, cache2, stats2, action2, ERRORING_HANDLER);
    }

    static Bitmap applyCustomTransformations(List<Transformation> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            final Transformation transformation = list.get(i);
            try {
                Bitmap transform = transformation.transform(bitmap);
                if (transform == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(transformation.key());
                    sb.append(" returned null after ");
                    sb.append(i);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (Transformation transformation2 : list) {
                        sb.append(transformation2.key());
                        sb.append('\n');
                    }
                    Picasso.HANDLER.post(new Runnable() {
                        /* class com.squareup.picasso.BitmapHunter.AnonymousClass4 */

                        public void run() {
                            throw new NullPointerException(sb.toString());
                        }
                    });
                    return null;
                } else if (transform == bitmap && bitmap.isRecycled()) {
                    Picasso.HANDLER.post(new Runnable() {
                        /* class com.squareup.picasso.BitmapHunter.AnonymousClass5 */

                        public void run() {
                            throw new IllegalStateException("Transformation " + transformation.key() + " returned input Bitmap but recycled it.");
                        }
                    });
                    return null;
                } else if (transform == bitmap || bitmap.isRecycled()) {
                    i++;
                    bitmap = transform;
                } else {
                    Picasso.HANDLER.post(new Runnable() {
                        /* class com.squareup.picasso.BitmapHunter.AnonymousClass6 */

                        public void run() {
                            throw new IllegalStateException("Transformation " + transformation.key() + " mutated input Bitmap but failed to recycle the original.");
                        }
                    });
                    return null;
                }
            } catch (RuntimeException e) {
                Picasso.HANDLER.post(new Runnable() {
                    /* class com.squareup.picasso.BitmapHunter.AnonymousClass3 */

                    public void run() {
                        throw new RuntimeException("Transformation " + transformation.key() + " crashed with exception.", e);
                    }
                });
                return null;
            }
        }
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:89:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0285  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Bitmap transformResult(com.squareup.picasso.Request r28, android.graphics.Bitmap r29, int r30) {
        /*
            r0 = r28
            int r1 = r29.getWidth()
            int r2 = r29.getHeight()
            boolean r3 = r0.onlyScaleDown
            android.graphics.Matrix r9 = new android.graphics.Matrix
            r9.<init>()
            boolean r4 = r28.needsMatrixTransform()
            if (r4 != 0) goto L_0x001f
            if (r30 == 0) goto L_0x001a
            goto L_0x001f
        L_0x001a:
            r5 = r2
            r3 = r9
            r2 = r1
            goto L_0x0271
        L_0x001f:
            int r4 = r0.targetWidth
            int r6 = r0.targetHeight
            float r7 = r0.rotationDegrees
            r8 = 0
            int r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r8 == 0) goto L_0x0159
            double r10 = (double) r7
            double r12 = java.lang.Math.toRadians(r10)
            double r12 = java.lang.Math.cos(r12)
            double r10 = java.lang.Math.toRadians(r10)
            double r10 = java.lang.Math.sin(r10)
            boolean r4 = r0.hasRotationPivot
            if (r4 == 0) goto L_0x00e2
            float r4 = r0.rotationPivotX
            float r6 = r0.rotationPivotY
            r9.setRotate(r7, r4, r6)
            float r4 = r0.rotationPivotX
            double r6 = (double) r4
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r14 = r14 - r12
            double r6 = r6 * r14
            float r4 = r0.rotationPivotY
            double r4 = (double) r4
            double r4 = r4 * r10
            double r6 = r6 + r4
            float r4 = r0.rotationPivotY
            double r4 = (double) r4
            double r4 = r4 * r14
            float r14 = r0.rotationPivotX
            double r14 = (double) r14
            double r14 = r14 * r10
            double r4 = r4 - r14
            int r14 = r0.targetWidth
            double r14 = (double) r14
            double r14 = r14 * r12
            double r14 = r14 + r6
            int r8 = r0.targetWidth
            r17 = r2
            r18 = r3
            double r2 = (double) r8
            double r2 = r2 * r10
            double r2 = r2 + r4
            int r8 = r0.targetWidth
            r19 = r9
            double r8 = (double) r8
            double r8 = r8 * r12
            double r8 = r8 + r6
            r20 = r1
            int r1 = r0.targetHeight
            r21 = r2
            double r1 = (double) r1
            double r1 = r1 * r10
            double r8 = r8 - r1
            int r1 = r0.targetWidth
            double r1 = (double) r1
            double r1 = r1 * r10
            double r1 = r1 + r4
            int r3 = r0.targetHeight
            r23 = r8
            double r8 = (double) r3
            double r8 = r8 * r12
            double r1 = r1 + r8
            int r3 = r0.targetHeight
            double r8 = (double) r3
            double r8 = r8 * r10
            double r8 = r6 - r8
            int r3 = r0.targetHeight
            double r10 = (double) r3
            double r10 = r10 * r12
            double r10 = r10 + r4
            double r12 = java.lang.Math.max(r6, r14)
            r25 = r10
            r10 = r23
            double r12 = java.lang.Math.max(r10, r12)
            double r12 = java.lang.Math.max(r8, r12)
            double r6 = java.lang.Math.min(r6, r14)
            double r6 = java.lang.Math.min(r10, r6)
            double r6 = java.lang.Math.min(r8, r6)
            r8 = r21
            double r10 = java.lang.Math.max(r4, r8)
            double r10 = java.lang.Math.max(r1, r10)
            r14 = r25
            double r10 = java.lang.Math.max(r14, r10)
            double r3 = java.lang.Math.min(r4, r8)
            double r1 = java.lang.Math.min(r1, r3)
            double r1 = java.lang.Math.min(r14, r1)
            double r12 = r12 - r6
            double r3 = java.lang.Math.floor(r12)
            int r4 = (int) r3
            double r10 = r10 - r1
            double r1 = java.lang.Math.floor(r10)
            int r6 = (int) r1
            goto L_0x0161
        L_0x00e2:
            r20 = r1
            r17 = r2
            r18 = r3
            r1 = r9
            r1.setRotate(r7)
            int r2 = r0.targetWidth
            double r2 = (double) r2
            double r2 = r2 * r12
            int r4 = r0.targetWidth
            double r4 = (double) r4
            double r4 = r4 * r10
            int r6 = r0.targetWidth
            double r6 = (double) r6
            double r6 = r6 * r12
            int r8 = r0.targetHeight
            double r8 = (double) r8
            double r8 = r8 * r10
            double r6 = r6 - r8
            int r8 = r0.targetWidth
            double r8 = (double) r8
            double r8 = r8 * r10
            int r14 = r0.targetHeight
            double r14 = (double) r14
            double r14 = r14 * r12
            double r8 = r8 + r14
            int r14 = r0.targetHeight
            double r14 = (double) r14
            double r14 = r14 * r10
            double r10 = -r14
            int r14 = r0.targetHeight
            double r14 = (double) r14
            double r14 = r14 * r12
            r12 = 0
            r19 = r1
            double r0 = java.lang.Math.max(r12, r2)
            double r0 = java.lang.Math.max(r6, r0)
            double r0 = java.lang.Math.max(r10, r0)
            double r2 = java.lang.Math.min(r12, r2)
            double r2 = java.lang.Math.min(r6, r2)
            double r2 = java.lang.Math.min(r10, r2)
            double r6 = java.lang.Math.max(r12, r4)
            double r6 = java.lang.Math.max(r8, r6)
            double r6 = java.lang.Math.max(r14, r6)
            double r4 = java.lang.Math.min(r12, r4)
            double r4 = java.lang.Math.min(r8, r4)
            double r4 = java.lang.Math.min(r14, r4)
            double r0 = r0 - r2
            double r0 = java.lang.Math.floor(r0)
            int r0 = (int) r0
            double r6 = r6 - r4
            double r1 = java.lang.Math.floor(r6)
            int r6 = (int) r1
            r4 = r0
            goto L_0x0161
        L_0x0159:
            r20 = r1
            r17 = r2
            r18 = r3
            r19 = r9
        L_0x0161:
            if (r30 == 0) goto L_0x018d
            int r0 = getExifRotation(r30)
            int r1 = getExifTranslation(r30)
            if (r0 == 0) goto L_0x0181
            float r2 = (float) r0
            r3 = r19
            r3.preRotate(r2)
            r2 = 90
            if (r0 == r2) goto L_0x017b
            r2 = 270(0x10e, float:3.78E-43)
            if (r0 != r2) goto L_0x0183
        L_0x017b:
            r27 = r6
            r6 = r4
            r4 = r27
            goto L_0x0183
        L_0x0181:
            r3 = r19
        L_0x0183:
            r0 = 1
            if (r1 == r0) goto L_0x018f
            float r0 = (float) r1
            r1 = 1065353216(0x3f800000, float:1.0)
            r3.postScale(r0, r1)
            goto L_0x018f
        L_0x018d:
            r3 = r19
        L_0x018f:
            r0 = r28
            boolean r1 = r0.centerCrop
            if (r1 == 0) goto L_0x0226
            if (r4 == 0) goto L_0x019f
            float r1 = (float) r4
            r2 = r20
            float r5 = (float) r2
            float r1 = r1 / r5
            r5 = r17
            goto L_0x01a6
        L_0x019f:
            r2 = r20
            float r1 = (float) r6
            r5 = r17
            float r7 = (float) r5
            float r1 = r1 / r7
        L_0x01a6:
            if (r6 == 0) goto L_0x01ab
            float r7 = (float) r6
            float r8 = (float) r5
            goto L_0x01ad
        L_0x01ab:
            float r7 = (float) r4
            float r8 = (float) r2
        L_0x01ad:
            float r7 = r7 / r8
            int r8 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x01de
            float r8 = (float) r5
            float r7 = r7 / r1
            float r8 = r8 * r7
            double r7 = (double) r8
            double r7 = java.lang.Math.ceil(r7)
            int r7 = (int) r7
            int r8 = r0.centerCropGravity
            r9 = 48
            r8 = r8 & r9
            if (r8 != r9) goto L_0x01c5
            r0 = 0
            goto L_0x01d3
        L_0x01c5:
            int r0 = r0.centerCropGravity
            r8 = 80
            r0 = r0 & r8
            if (r0 != r8) goto L_0x01cf
            int r0 = r5 - r7
            goto L_0x01d3
        L_0x01cf:
            int r0 = r5 - r7
            int r0 = r0 / 2
        L_0x01d3:
            float r8 = (float) r6
            float r9 = (float) r7
            float r8 = r8 / r9
            r9 = r7
            r10 = r18
            r16 = 0
            r7 = r0
            r0 = r2
            goto L_0x0217
        L_0x01de:
            int r8 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r8 >= 0) goto L_0x020e
            float r8 = (float) r2
            float r1 = r1 / r7
            float r8 = r8 * r1
            double r8 = (double) r8
            double r8 = java.lang.Math.ceil(r8)
            int r1 = (int) r8
            int r8 = r0.centerCropGravity
            r9 = 3
            r8 = r8 & r9
            if (r8 != r9) goto L_0x01f4
            r0 = 0
            goto L_0x0201
        L_0x01f4:
            int r0 = r0.centerCropGravity
            r8 = 5
            r0 = r0 & r8
            if (r0 != r8) goto L_0x01fd
            int r0 = r2 - r1
            goto L_0x0201
        L_0x01fd:
            int r0 = r2 - r1
            int r0 = r0 / 2
        L_0x0201:
            float r8 = (float) r4
            float r9 = (float) r1
            float r8 = r8 / r9
            r16 = r0
            r0 = r1
            r9 = r5
            r1 = r8
            r10 = r18
            r8 = r7
            r7 = 0
            goto L_0x0217
        L_0x020e:
            r0 = r2
            r9 = r5
            r1 = r7
            r8 = r1
            r10 = r18
            r7 = 0
            r16 = 0
        L_0x0217:
            boolean r2 = shouldResize(r10, r2, r5, r4, r6)
            if (r2 == 0) goto L_0x0220
            r3.preScale(r1, r8)
        L_0x0220:
            r6 = r7
            r8 = r9
            r5 = r16
            r7 = r0
            goto L_0x0275
        L_0x0226:
            r5 = r17
            r10 = r18
            r2 = r20
            boolean r0 = r0.centerInside
            if (r0 == 0) goto L_0x0250
            if (r4 == 0) goto L_0x0235
            float r0 = (float) r4
            float r1 = (float) r2
            goto L_0x0237
        L_0x0235:
            float r0 = (float) r6
            float r1 = (float) r5
        L_0x0237:
            float r0 = r0 / r1
            if (r6 == 0) goto L_0x023d
            float r1 = (float) r6
            float r7 = (float) r5
            goto L_0x023f
        L_0x023d:
            float r1 = (float) r4
            float r7 = (float) r2
        L_0x023f:
            float r1 = r1 / r7
            int r7 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x0245
            goto L_0x0246
        L_0x0245:
            r0 = r1
        L_0x0246:
            boolean r1 = shouldResize(r10, r2, r5, r4, r6)
            if (r1 == 0) goto L_0x0271
            r3.preScale(r0, r0)
            goto L_0x0271
        L_0x0250:
            if (r4 != 0) goto L_0x0254
            if (r6 == 0) goto L_0x0271
        L_0x0254:
            if (r4 != r2) goto L_0x0258
            if (r6 == r5) goto L_0x0271
        L_0x0258:
            if (r4 == 0) goto L_0x025d
            float r0 = (float) r4
            float r1 = (float) r2
            goto L_0x025f
        L_0x025d:
            float r0 = (float) r6
            float r1 = (float) r5
        L_0x025f:
            float r0 = r0 / r1
            if (r6 == 0) goto L_0x0265
            float r1 = (float) r6
            float r7 = (float) r5
            goto L_0x0267
        L_0x0265:
            float r1 = (float) r4
            float r7 = (float) r2
        L_0x0267:
            float r1 = r1 / r7
            boolean r4 = shouldResize(r10, r2, r5, r4, r6)
            if (r4 == 0) goto L_0x0271
            r3.preScale(r0, r1)
        L_0x0271:
            r7 = r2
            r8 = r5
            r5 = 0
            r6 = 0
        L_0x0275:
            r10 = 1
            r4 = r29
            r9 = r3
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r4, r5, r6, r7, r8, r9, r10)
            r1 = r29
            if (r0 == r1) goto L_0x0285
            r29.recycle()
            goto L_0x0286
        L_0x0285:
            r0 = r1
        L_0x0286:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.BitmapHunter.transformResult(com.squareup.picasso.Request, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}
