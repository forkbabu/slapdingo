package com.itextpdf.text.pdf.hyphenation;

import com.itextpdf.text.pdf.BidiOrder;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class HyphenationTree extends TernaryTree implements PatternConsumer {
    private static final long serialVersionUID = -7763254239309429432L;
    protected TernaryTree classmap = new TernaryTree();
    private transient TernaryTree ivalues;
    protected HashMap<String, ArrayList<Object>> stoplist = new HashMap<>(23);
    protected ByteVector vspace;

    public HyphenationTree() {
        ByteVector byteVector = new ByteVector();
        this.vspace = byteVector;
        byteVector.alloc(1);
    }

    /* access modifiers changed from: protected */
    public int packValues(String str) {
        int length = str.length();
        int i = (length & 1) == 1 ? (length >> 1) + 2 : (length >> 1) + 1;
        int alloc = this.vspace.alloc(i);
        byte[] array = this.vspace.getArray();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 >> 1;
            byte charAt = (byte) (((str.charAt(i2) - '0') + 1) & 15);
            if ((i2 & 1) == 1) {
                int i4 = i3 + alloc;
                array[i4] = (byte) (charAt | array[i4]);
            } else {
                array[i3 + alloc] = (byte) (charAt << 4);
            }
        }
        array[(i - 1) + alloc] = 0;
        return alloc;
    }

    /* access modifiers changed from: protected */
    public String unpackValues(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = i + 1;
        byte b = this.vspace.get(i);
        while (b != 0) {
            stringBuffer.append((char) (((b >>> 4) - 1) + 48));
            char c = (char) (b & BidiOrder.B);
            if (c == 0) {
                break;
            }
            stringBuffer.append((char) ((c - 1) + 48));
            b = this.vspace.get(i2);
            i2++;
        }
        return stringBuffer.toString();
    }

    public void loadSimplePatterns(InputStream inputStream) {
        SimplePatternParser simplePatternParser = new SimplePatternParser();
        this.ivalues = new TernaryTree();
        simplePatternParser.parse(inputStream, this);
        trimToSize();
        this.vspace.trimToSize();
        this.classmap.trimToSize();
        this.ivalues = null;
    }

    public String findPattern(String str) {
        int find = super.find(str);
        return find >= 0 ? unpackValues(find) : "";
    }

    /* access modifiers changed from: protected */
    public int hstrcmp(char[] cArr, int i, char[] cArr2, int i2) {
        while (cArr[i] == cArr2[i2]) {
            if (cArr[i] == 0) {
                return 0;
            }
            i++;
            i2++;
        }
        if (cArr2[i2] == 0) {
            return 0;
        }
        return cArr[i] - cArr2[i2];
    }

    /* access modifiers changed from: protected */
    public byte[] getValues(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = i + 1;
        byte b = this.vspace.get(i);
        while (b != 0) {
            stringBuffer.append((char) ((b >>> 4) - 1));
            char c = (char) (b & BidiOrder.B);
            if (c == 0) {
                break;
            }
            stringBuffer.append((char) (c - 1));
            b = this.vspace.get(i2);
            i2++;
        }
        int length = stringBuffer.length();
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = (byte) stringBuffer.charAt(i3);
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public void searchPatterns(char[] cArr, int i, byte[] bArr) {
        char c = cArr[i];
        char c2 = this.root;
        int i2 = i;
        while (c2 > 0 && c2 < this.sc.length) {
            int i3 = 0;
            if (this.sc[c2] != 65535) {
                int i4 = c - this.sc[c2];
                if (i4 == 0) {
                    if (c != 0) {
                        i2++;
                        c = cArr[i2];
                        c2 = this.eq[c2];
                        char c3 = c2;
                        while (true) {
                            if (c3 <= 0 || c3 >= this.sc.length || this.sc[c3] == 65535) {
                                break;
                            } else if (this.sc[c3] == 0) {
                                byte[] values = getValues(this.eq[c3]);
                                int length = values.length;
                                int i5 = i;
                                while (i3 < length) {
                                    byte b = values[i3];
                                    if (i5 < bArr.length && b > bArr[i5]) {
                                        bArr[i5] = b;
                                    }
                                    i5++;
                                    i3++;
                                }
                            } else {
                                c3 = this.lo[c3];
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    c2 = i4 < 0 ? this.lo[c2] : this.hi[c2];
                }
            } else if (hstrcmp(cArr, i2, this.kv.getArray(), this.lo[c2]) == 0) {
                byte[] values2 = getValues(this.eq[c2]);
                int length2 = values2.length;
                while (i3 < length2) {
                    byte b2 = values2[i3];
                    if (i < bArr.length && b2 > bArr[i]) {
                        bArr[i] = b2;
                    }
                    i++;
                    i3++;
                }
                return;
            } else {
                return;
            }
        }
    }

    public Hyphenation hyphenate(String str, int i, int i2) {
        char[] charArray = str.toCharArray();
        return hyphenate(charArray, 0, charArray.length, i, i2);
    }

    public Hyphenation hyphenate(char[] cArr, int i, int i2, int i3, int i4) {
        int i5;
        char[] cArr2 = new char[(i2 + 3)];
        char[] cArr3 = new char[2];
        int i6 = i2;
        boolean z = false;
        int i7 = 0;
        for (int i8 = 1; i8 <= i2; i8++) {
            cArr3[0] = cArr[(i + i8) - 1];
            int find = this.classmap.find(cArr3, 0);
            if (find < 0) {
                int i9 = i7 + 1;
                if (i8 == i9) {
                    i7 = i9;
                } else {
                    z = true;
                }
                i6--;
            } else if (z) {
                return null;
            } else {
                cArr2[i8 - i7] = (char) find;
            }
        }
        if (i6 < i3 + i4) {
            return null;
        }
        int i10 = i6 + 1;
        int[] iArr = new int[i10];
        String str = new String(cArr2, 1, i6);
        if (this.stoplist.containsKey(str)) {
            ArrayList<Object> arrayList = this.stoplist.get(str);
            int i11 = 0;
            i5 = 0;
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                Object obj = arrayList.get(i12);
                if ((obj instanceof String) && (i11 = i11 + ((String) obj).length()) >= i3 && i11 < i6 - i4) {
                    iArr[i5] = i11 + i7;
                    i5++;
                }
            }
        } else {
            cArr2[0] = '.';
            cArr2[i10] = '.';
            cArr2[i6 + 2] = 0;
            byte[] bArr = new byte[(i6 + 3)];
            for (int i13 = 0; i13 < i10; i13++) {
                searchPatterns(cArr2, i13, bArr);
            }
            int i14 = 0;
            int i15 = 0;
            while (i15 < i6) {
                int i16 = i15 + 1;
                if ((bArr[i16] & 1) == 1 && i15 >= i3 && i15 <= i6 - i4) {
                    iArr[i14] = i15 + i7;
                    i14++;
                }
                i15 = i16;
            }
            i5 = i14;
        }
        if (i5 <= 0) {
            return null;
        }
        int[] iArr2 = new int[i5];
        System.arraycopy(iArr, 0, iArr2, 0, i5);
        return new Hyphenation(new String(cArr, i, i2), iArr2);
    }

    @Override // com.itextpdf.text.pdf.hyphenation.PatternConsumer
    public void addClass(String str) {
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            char[] cArr = new char[2];
            cArr[1] = 0;
            for (int i = 0; i < str.length(); i++) {
                cArr[0] = str.charAt(i);
                this.classmap.insert(cArr, 0, charAt);
            }
        }
    }

    @Override // com.itextpdf.text.pdf.hyphenation.PatternConsumer
    public void addException(String str, ArrayList<Object> arrayList) {
        this.stoplist.put(str, arrayList);
    }

    @Override // com.itextpdf.text.pdf.hyphenation.PatternConsumer
    public void addPattern(String str, String str2) {
        int find = this.ivalues.find(str2);
        if (find <= 0) {
            find = packValues(str2);
            this.ivalues.insert(str2, (char) find);
        }
        insert(str, (char) find);
    }

    @Override // com.itextpdf.text.pdf.hyphenation.TernaryTree
    public void printStats() {
        PrintStream printStream = System.out;
        printStream.println("Value space size = " + Integer.toString(this.vspace.length()));
        super.printStats();
    }
}
