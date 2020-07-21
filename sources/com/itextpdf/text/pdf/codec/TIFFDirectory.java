package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

public class TIFFDirectory implements Serializable {
    private static final long serialVersionUID = -168636766193675380L;
    private static final int[] sizeOfType = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    long IFDOffset = 8;
    Hashtable<Integer, Integer> fieldIndex = new Hashtable<>();
    TIFFField[] fields;
    boolean isBigEndian;
    long nextIFDOffset = 0;
    int numEntries;

    private static boolean isValidEndianTag(int i) {
        return i == 18761 || i == 19789;
    }

    TIFFDirectory() {
    }

    public TIFFDirectory(RandomAccessFileOrArray randomAccessFileOrArray, int i) throws IOException {
        long filePointer = randomAccessFileOrArray.getFilePointer();
        randomAccessFileOrArray.seek(0);
        int readUnsignedShort = randomAccessFileOrArray.readUnsignedShort();
        if (isValidEndianTag(readUnsignedShort)) {
            this.isBigEndian = readUnsignedShort == 19789;
            if (readUnsignedShort(randomAccessFileOrArray) == 42) {
                long readUnsignedInt = readUnsignedInt(randomAccessFileOrArray);
                int i2 = 0;
                while (i2 < i) {
                    if (readUnsignedInt != 0) {
                        randomAccessFileOrArray.seek(readUnsignedInt);
                        randomAccessFileOrArray.skip((long) (readUnsignedShort(randomAccessFileOrArray) * 12));
                        readUnsignedInt = readUnsignedInt(randomAccessFileOrArray);
                        i2++;
                    } else {
                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("directory.number.too.large", new Object[0]));
                    }
                }
                randomAccessFileOrArray.seek(readUnsignedInt);
                initialize(randomAccessFileOrArray);
                randomAccessFileOrArray.seek(filePointer);
                return;
            }
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.magic.number.should.be.42", new Object[0]));
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
    }

    public TIFFDirectory(RandomAccessFileOrArray randomAccessFileOrArray, long j, int i) throws IOException {
        long filePointer = randomAccessFileOrArray.getFilePointer();
        randomAccessFileOrArray.seek(0);
        int readUnsignedShort = randomAccessFileOrArray.readUnsignedShort();
        if (isValidEndianTag(readUnsignedShort)) {
            this.isBigEndian = readUnsignedShort == 19789;
            randomAccessFileOrArray.seek(j);
            for (int i2 = 0; i2 < i; i2++) {
                randomAccessFileOrArray.seek(j + ((long) (readUnsignedShort(randomAccessFileOrArray) * 12)));
                j = readUnsignedInt(randomAccessFileOrArray);
                randomAccessFileOrArray.seek(j);
            }
            initialize(randomAccessFileOrArray);
            randomAccessFileOrArray.seek(filePointer);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:75:0x013f */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:70:0x013f */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:69:0x013f */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:68:0x013f */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:67:0x013f */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:66:0x013f */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:65:0x013f */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:64:0x013f */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:63:0x013f */
    /* JADX DEBUG: Additional 1 move instruction added to help type inference */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.itextpdf.text.pdf.codec.TIFFDirectory] */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.itextpdf.text.pdf.RandomAccessFileOrArray] */
    /* JADX WARN: Type inference failed for: r2v0, types: [long] */
    /* JADX WARN: Type inference failed for: r4v0, types: [long] */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.itextpdf.text.pdf.codec.TIFFField[]] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [long] */
    /* JADX WARN: Type inference failed for: r7v1, types: [int] */
    /* JADX WARN: Type inference failed for: r6v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [long] */
    /* JADX WARN: Type inference failed for: r1v2, types: [long] */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r8v2, types: [int] */
    /* JADX WARN: Type inference failed for: r9v0, types: [int] */
    /* JADX WARN: Type inference failed for: r10v2, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0, types: [int] */
    /* JADX WARN: Type inference failed for: r12v0, types: [long] */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [int] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.util.Hashtable<java.lang.Integer, java.lang.Integer>, java.util.Hashtable] */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.Object, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r11v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.itextpdf.text.pdf.codec.TIFFField[]] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.itextpdf.text.pdf.codec.TIFFField] */
    /* JADX WARN: Type inference failed for: r4v6, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4, types: [int] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r11v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    /* JADX WARN: Type inference failed for: r10v8, types: [int] */
    /* JADX WARN: Type inference failed for: r10v9, types: [int] */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r10v10, types: [byte] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r4v8, types: [char[]] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [int] */
    /* JADX WARN: Type inference failed for: r10v13, types: [int] */
    /* JADX WARN: Type inference failed for: r10v14, types: [char] */
    /* JADX WARN: Type inference failed for: r5v5, types: [int] */
    /* JADX WARN: Type inference failed for: r4v9, types: [long[]] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [int] */
    /* JADX WARN: Type inference failed for: r14v6, types: [long] */
    /* JADX WARN: Type inference failed for: r5v8, types: [int] */
    /* JADX WARN: Type inference failed for: r4v10, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Class<long>, java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v12, types: [long[][]] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [int] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r17v0, types: [long] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r17v1, types: [long] */
    /* JADX WARN: Type inference failed for: r5v12, types: [int] */
    /* JADX WARN: Type inference failed for: r4v13, types: [short[]] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [int] */
    /* JADX WARN: Type inference failed for: r10v15, types: [short] */
    /* JADX WARN: Type inference failed for: r5v15, types: [int] */
    /* JADX WARN: Type inference failed for: r4v14, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17, types: [int] */
    /* JADX WARN: Type inference failed for: r10v16, types: [int] */
    /* JADX WARN: Type inference failed for: r5v18, types: [int] */
    /* JADX WARN: Type inference failed for: r4v15, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.lang.Class<int>, java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v17, types: [int[][]] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21, types: [int] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r15v3, types: [int] */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r15v4, types: [int] */
    /* JADX WARN: Type inference failed for: r5v22, types: [int] */
    /* JADX WARN: Type inference failed for: r4v18, types: [float[]] */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24, types: [int] */
    /* JADX WARN: Type inference failed for: r10v17, types: [float] */
    /* JADX WARN: Type inference failed for: r5v25, types: [int] */
    /* JADX WARN: Type inference failed for: r4v19, types: [double[]] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27, types: [int] */
    /* JADX WARN: Type inference failed for: r14v11, types: [double] */
    /* JADX WARN: Type inference failed for: r5v28, types: [int] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v14, types: [int] */
    /* JADX WARN: Type inference failed for: r14v15, types: [int] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17, types: [long] */
    /* JADX WARN: Type inference failed for: r16v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /*  JADX ERROR: JadxRuntimeException in pass: ConstInlineVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r15v5 ?
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
        	at jadx.core.dex.visitors.ConstInlineVisitor.checkForFinallyBlock(ConstInlineVisitor.java:135)
        	at jadx.core.dex.visitors.ConstInlineVisitor.checkInsn(ConstInlineVisitor.java:112)
        	at jadx.core.dex.visitors.ConstInlineVisitor.process(ConstInlineVisitor.java:53)
        	at jadx.core.dex.visitors.ConstInlineVisitor.visit(ConstInlineVisitor.java:45)
        */
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [byte[], char[], short[]], vars: [r4v4 ?, r4v5 ?, r4v6 ?, r4v7 ?, r4v8 ?, r4v9 ?, r4v12 ?, r4v13 ?, r4v14 ?, r4v17 ?, r4v18 ?, r4v19 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    /*  JADX ERROR: JadxRuntimeException in pass: PrepareForCodeGen
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r5v28 ?
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
        	at jadx.core.dex.instructions.args.RegisterArg.sameCodeVar(RegisterArg.java:189)
        	at jadx.core.dex.visitors.PrepareForCodeGen.modifyArith(PrepareForCodeGen.java:191)
        	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:72)
        */
    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v4 ?
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.collectCodeVars(ProcessVariables.java:142)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:47)
        */
    /*  JADX ERROR: Type inference failed with exception
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [char[], short[]], vars: [r4v4 ?, r4v5 ?, r4v7 ?, r4v8 ?, r4v9 ?, r4v12 ?, r4v13 ?, r4v14 ?, r4v17 ?, r4v18 ?, r4v19 ?, r4v20 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.rerun(InitCodeVariables.java:39)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.tryInsertAdditionalMove(TypeInferenceVisitor.java:497)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:94)
        */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0148 A[SYNTHETIC] */
    private void initialize(com.itextpdf.text.pdf.RandomAccessFileOrArray r20) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            long r2 = r20.length()
            long r4 = r20.getFilePointer()
            r0.IFDOffset = r4
            int r4 = r19.readUnsignedShort(r20)
            r0.numEntries = r4
            com.itextpdf.text.pdf.codec.TIFFField[] r4 = new com.itextpdf.text.pdf.codec.TIFFField[r4]
            r0.fields = r4
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x001c:
            int r10 = r0.numEntries
            if (r7 >= r10) goto L_0x0151
            int r10 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r10 >= 0) goto L_0x0151
            int r8 = r19.readUnsignedShort(r20)
            int r9 = r19.readUnsignedShort(r20)
            long r10 = r19.readUnsignedInt(r20)
            int r11 = (int) r10
            long r12 = r20.getFilePointer()
            r14 = 4
            long r12 = r12 + r14
            r10 = 1
            int[] r14 = com.itextpdf.text.pdf.codec.TIFFDirectory.sizeOfType     // Catch:{ ArrayIndexOutOfBoundsException -> 0x004f }
            r14 = r14[r9]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x004f }
            int r14 = r14 * r11
            r15 = 4
            if (r14 <= r15) goto L_0x004d
            long r14 = r19.readUnsignedInt(r20)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x004f }
            int r16 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r16 >= 0) goto L_0x004f
            r1.seek(r14)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x004f }
        L_0x004d:
            r14 = 1
            goto L_0x0050
        L_0x004f:
            r14 = 0
        L_0x0050:
            if (r14 == 0) goto L_0x0148
            java.util.Hashtable<java.lang.Integer, java.lang.Integer> r14 = r0.fieldIndex
            java.lang.Integer r15 = java.lang.Integer.valueOf(r8)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r14.put(r15, r4)
            r4 = 0
            r5 = 2
            switch(r9) {
                case 1: goto L_0x0103;
                case 2: goto L_0x0103;
                case 3: goto L_0x00f4;
                case 4: goto L_0x00e6;
                case 5: goto L_0x00c2;
                case 6: goto L_0x0103;
                case 7: goto L_0x0103;
                case 8: goto L_0x00b4;
                case 9: goto L_0x00a6;
                case 10: goto L_0x0082;
                case 11: goto L_0x0074;
                case 12: goto L_0x0066;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x013f
        L_0x0066:
            double[] r4 = new double[r11]
            r5 = 0
        L_0x0069:
            if (r5 >= r11) goto L_0x013f
            double r14 = r19.readDouble(r20)
            r4[r5] = r14
            int r5 = r5 + 1
            goto L_0x0069
        L_0x0074:
            float[] r4 = new float[r11]
            r5 = 0
        L_0x0077:
            if (r5 >= r11) goto L_0x013f
            float r10 = r19.readFloat(r20)
            r4[r5] = r10
            int r5 = r5 + 1
            goto L_0x0077
        L_0x0082:
            int[] r4 = new int[r5]
            r4[r10] = r5
            r4[r6] = r11
            java.lang.Class<int> r5 = int.class
            java.lang.Object r4 = java.lang.reflect.Array.newInstance(r5, r4)
            int[][] r4 = (int[][]) r4
            r5 = 0
        L_0x0091:
            if (r5 >= r11) goto L_0x013f
            r14 = r4[r5]
            int r15 = r19.readInt(r20)
            r14[r6] = r15
            r14 = r4[r5]
            int r15 = r19.readInt(r20)
            r14[r10] = r15
            int r5 = r5 + 1
            goto L_0x0091
        L_0x00a6:
            int[] r4 = new int[r11]
            r5 = 0
        L_0x00a9:
            if (r5 >= r11) goto L_0x013f
            int r10 = r19.readInt(r20)
            r4[r5] = r10
            int r5 = r5 + 1
            goto L_0x00a9
        L_0x00b4:
            short[] r4 = new short[r11]
            r5 = 0
        L_0x00b7:
            if (r5 >= r11) goto L_0x013f
            short r10 = r19.readShort(r20)
            r4[r5] = r10
            int r5 = r5 + 1
            goto L_0x00b7
        L_0x00c2:
            int[] r4 = new int[r5]
            r4[r10] = r5
            r4[r6] = r11
            java.lang.Class<long> r5 = long.class
            java.lang.Object r4 = java.lang.reflect.Array.newInstance(r5, r4)
            long[][] r4 = (long[][]) r4
            r5 = 0
        L_0x00d1:
            if (r5 >= r11) goto L_0x013f
            r14 = r4[r5]
            long r17 = r19.readUnsignedInt(r20)
            r14[r6] = r17
            r14 = r4[r5]
            long r17 = r19.readUnsignedInt(r20)
            r14[r10] = r17
            int r5 = r5 + 1
            goto L_0x00d1
        L_0x00e6:
            long[] r4 = new long[r11]
            r5 = 0
        L_0x00e9:
            if (r5 >= r11) goto L_0x013f
            long r14 = r19.readUnsignedInt(r20)
            r4[r5] = r14
            int r5 = r5 + 1
            goto L_0x00e9
        L_0x00f4:
            char[] r4 = new char[r11]
            r5 = 0
        L_0x00f7:
            if (r5 >= r11) goto L_0x013f
            int r10 = r19.readUnsignedShort(r20)
            char r10 = (char) r10
            r4[r5] = r10
            int r5 = r5 + 1
            goto L_0x00f7
        L_0x0103:
            byte[] r4 = new byte[r11]
            r1.readFully(r4, r6, r11)
            if (r9 != r5) goto L_0x013f
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r10 = 0
            r14 = 0
        L_0x0111:
            if (r10 >= r11) goto L_0x012b
        L_0x0113:
            if (r10 >= r11) goto L_0x011e
            int r15 = r10 + 1
            byte r10 = r4[r10]
            if (r10 == 0) goto L_0x011d
            r10 = r15
            goto L_0x0113
        L_0x011d:
            r10 = r15
        L_0x011e:
            java.lang.String r15 = new java.lang.String
            int r6 = r10 - r14
            r15.<init>(r4, r14, r6)
            r5.add(r15)
            r14 = r10
            r6 = 0
            goto L_0x0111
        L_0x012b:
            int r11 = r5.size()
            java.lang.String[] r4 = new java.lang.String[r11]
            r6 = 0
        L_0x0132:
            if (r6 >= r11) goto L_0x013f
            java.lang.Object r10 = r5.get(r6)
            java.lang.String r10 = (java.lang.String) r10
            r4[r6] = r10
            int r6 = r6 + 1
            goto L_0x0132
        L_0x013f:
            com.itextpdf.text.pdf.codec.TIFFField[] r5 = r0.fields
            com.itextpdf.text.pdf.codec.TIFFField r6 = new com.itextpdf.text.pdf.codec.TIFFField
            r6.<init>(r8, r9, r11, r4)
            r5[r7] = r6
        L_0x0148:
            r1.seek(r12)
            int r7 = r7 + 1
            r8 = r12
            r6 = 0
            goto L_0x001c
        L_0x0151:
            long r1 = r19.readUnsignedInt(r20)     // Catch:{ Exception -> 0x0158 }
            r0.nextIFDOffset = r1     // Catch:{ Exception -> 0x0158 }
            goto L_0x015c
        L_0x0158:
            r1 = 0
            r0.nextIFDOffset = r1
        L_0x015c:
            return
            switch-data {1->0x0103, 2->0x0103, 3->0x00f4, 4->0x00e6, 5->0x00c2, 6->0x0103, 7->0x0103, 8->0x00b4, 9->0x00a6, 10->0x0082, 11->0x0074, 12->0x0066, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TIFFDirectory.initialize(com.itextpdf.text.pdf.RandomAccessFileOrArray):void");
    }

    public int getNumEntries() {
        return this.numEntries;
    }

    public TIFFField getField(int i) {
        Integer num = this.fieldIndex.get(Integer.valueOf(i));
        if (num == null) {
            return null;
        }
        return this.fields[num.intValue()];
    }

    public boolean isTagPresent(int i) {
        return this.fieldIndex.containsKey(Integer.valueOf(i));
    }

    public int[] getTags() {
        int[] iArr = new int[this.fieldIndex.size()];
        Enumeration<Integer> keys = this.fieldIndex.keys();
        int i = 0;
        while (keys.hasMoreElements()) {
            iArr[i] = keys.nextElement().intValue();
            i++;
        }
        return iArr;
    }

    public TIFFField[] getFields() {
        return this.fields;
    }

    public byte getFieldAsByte(int i, int i2) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i)).intValue()].getAsBytes()[i2];
    }

    public byte getFieldAsByte(int i) {
        return getFieldAsByte(i, 0);
    }

    public long getFieldAsLong(int i, int i2) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i)).intValue()].getAsLong(i2);
    }

    public long getFieldAsLong(int i) {
        return getFieldAsLong(i, 0);
    }

    public float getFieldAsFloat(int i, int i2) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i)).intValue()].getAsFloat(i2);
    }

    public float getFieldAsFloat(int i) {
        return getFieldAsFloat(i, 0);
    }

    public double getFieldAsDouble(int i, int i2) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i)).intValue()].getAsDouble(i2);
    }

    public double getFieldAsDouble(int i) {
        return getFieldAsDouble(i, 0);
    }

    private short readShort(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readShort();
        }
        return randomAccessFileOrArray.readShortLE();
    }

    private int readUnsignedShort(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readUnsignedShort();
        }
        return randomAccessFileOrArray.readUnsignedShortLE();
    }

    private int readInt(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readInt();
        }
        return randomAccessFileOrArray.readIntLE();
    }

    private long readUnsignedInt(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readUnsignedInt();
        }
        return randomAccessFileOrArray.readUnsignedIntLE();
    }

    private long readLong(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readLong();
        }
        return randomAccessFileOrArray.readLongLE();
    }

    private float readFloat(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readFloat();
        }
        return randomAccessFileOrArray.readFloatLE();
    }

    private double readDouble(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        if (this.isBigEndian) {
            return randomAccessFileOrArray.readDouble();
        }
        return randomAccessFileOrArray.readDoubleLE();
    }

    private static int readUnsignedShort(RandomAccessFileOrArray randomAccessFileOrArray, boolean z) throws IOException {
        if (z) {
            return randomAccessFileOrArray.readUnsignedShort();
        }
        return randomAccessFileOrArray.readUnsignedShortLE();
    }

    private static long readUnsignedInt(RandomAccessFileOrArray randomAccessFileOrArray, boolean z) throws IOException {
        if (z) {
            return randomAccessFileOrArray.readUnsignedInt();
        }
        return randomAccessFileOrArray.readUnsignedIntLE();
    }

    public static int getNumDirectories(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        long filePointer = randomAccessFileOrArray.getFilePointer();
        randomAccessFileOrArray.seek(0);
        int readUnsignedShort = randomAccessFileOrArray.readUnsignedShort();
        int i = 0;
        if (isValidEndianTag(readUnsignedShort)) {
            boolean z = readUnsignedShort == 19789;
            if (readUnsignedShort(randomAccessFileOrArray, z) == 42) {
                randomAccessFileOrArray.seek(4);
                long readUnsignedInt = readUnsignedInt(randomAccessFileOrArray, z);
                while (readUnsignedInt != 0) {
                    i++;
                    try {
                        randomAccessFileOrArray.seek(readUnsignedInt);
                        randomAccessFileOrArray.skip((long) (readUnsignedShort(randomAccessFileOrArray, z) * 12));
                        readUnsignedInt = readUnsignedInt(randomAccessFileOrArray, z);
                    } catch (EOFException unused) {
                        i--;
                    }
                }
                randomAccessFileOrArray.seek(filePointer);
                return i;
            }
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.magic.number.should.be.42", new Object[0]));
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
    }

    public boolean isBigEndian() {
        return this.isBigEndian;
    }

    public long getIFDOffset() {
        return this.IFDOffset;
    }

    public long getNextIFDOffset() {
        return this.nextIFDOffset;
    }
}
