package jp.wasabeef.picasso.transformations.internal;

public class RSBlur {
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap blur(android.content.Context r5, android.graphics.Bitmap r6, int r7) throws android.renderscript.RSRuntimeException {
        /*
            r0 = 0
            android.renderscript.RenderScript r5 = android.renderscript.RenderScript.create(r5)     // Catch:{ all -> 0x0054 }
            android.renderscript.RenderScript$RSMessageHandler r1 = new android.renderscript.RenderScript$RSMessageHandler     // Catch:{ all -> 0x004e }
            r1.<init>()     // Catch:{ all -> 0x004e }
            r5.setMessageHandler(r1)     // Catch:{ all -> 0x004e }
            android.renderscript.Allocation$MipmapControl r1 = android.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch:{ all -> 0x004e }
            r2 = 1
            android.renderscript.Allocation r1 = android.renderscript.Allocation.createFromBitmap(r5, r6, r1, r2)     // Catch:{ all -> 0x004e }
            android.renderscript.Type r2 = r1.getType()     // Catch:{ all -> 0x004b }
            android.renderscript.Allocation r2 = android.renderscript.Allocation.createTyped(r5, r2)     // Catch:{ all -> 0x004b }
            android.renderscript.Element r3 = android.renderscript.Element.U8_4(r5)     // Catch:{ all -> 0x0046 }
            android.renderscript.ScriptIntrinsicBlur r0 = android.renderscript.ScriptIntrinsicBlur.create(r5, r3)     // Catch:{ all -> 0x0046 }
            r0.setInput(r1)     // Catch:{ all -> 0x0046 }
            float r7 = (float) r7     // Catch:{ all -> 0x0046 }
            r0.setRadius(r7)     // Catch:{ all -> 0x0046 }
            r0.forEach(r2)     // Catch:{ all -> 0x0046 }
            r2.copyTo(r6)     // Catch:{ all -> 0x0046 }
            if (r5 == 0) goto L_0x0036
            r5.destroy()
        L_0x0036:
            if (r1 == 0) goto L_0x003b
            r1.destroy()
        L_0x003b:
            if (r2 == 0) goto L_0x0040
            r2.destroy()
        L_0x0040:
            if (r0 == 0) goto L_0x0045
            r0.destroy()
        L_0x0045:
            return r6
        L_0x0046:
            r6 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x0058
        L_0x004b:
            r6 = move-exception
            r2 = r0
            goto L_0x0051
        L_0x004e:
            r6 = move-exception
            r1 = r0
            r2 = r1
        L_0x0051:
            r0 = r5
            r5 = r2
            goto L_0x0058
        L_0x0054:
            r6 = move-exception
            r5 = r0
            r1 = r5
            r2 = r1
        L_0x0058:
            if (r0 == 0) goto L_0x005d
            r0.destroy()
        L_0x005d:
            if (r1 == 0) goto L_0x0062
            r1.destroy()
        L_0x0062:
            if (r2 == 0) goto L_0x0067
            r2.destroy()
        L_0x0067:
            if (r5 == 0) goto L_0x006c
            r5.destroy()
        L_0x006c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.wasabeef.picasso.transformations.internal.RSBlur.blur(android.content.Context, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}
