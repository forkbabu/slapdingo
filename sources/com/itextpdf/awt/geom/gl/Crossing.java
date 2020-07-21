package com.itextpdf.awt.geom.gl;

import com.itextpdf.awt.geom.PathIterator;
import com.itextpdf.awt.geom.Shape;

public class Crossing {
    public static final int CROSSING = 255;
    static final double DELTA = 1.0E-5d;
    static final double ROOT_DELTA = 1.0E-10d;
    static final int UNKNOWN = 254;

    public static int crossLine(double d, double d2, double d3, double d4, double d5, double d6) {
        int i;
        if ((d5 < d && d5 < d3) || ((d5 > d && d5 > d3) || ((d6 > d2 && d6 > d4) || d == d3))) {
            return 0;
        }
        if ((d6 >= d2 || d6 >= d4) && ((d4 - d2) * (d5 - d)) / (d3 - d) <= d6 - d2) {
            return 0;
        }
        return i == 0 ? d < d3 ? 0 : -1 : d5 == d3 ? d < d3 ? 1 : 0 : d < d3 ? 1 : -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int intersectLine(double r11, double r13, double r15, double r17, double r19, double r21, double r23, double r25) {
        /*
            r0 = 0
            int r1 = (r23 > r11 ? 1 : (r23 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x0009
            int r1 = (r23 > r15 ? 1 : (r23 == r15 ? 0 : -1))
            if (r1 < 0) goto L_0x0019
        L_0x0009:
            int r1 = (r19 > r11 ? 1 : (r19 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x0011
            int r2 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r2 > 0) goto L_0x0019
        L_0x0011:
            int r2 = (r21 > r13 ? 1 : (r21 == r13 ? 0 : -1))
            if (r2 <= 0) goto L_0x001a
            int r2 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r2 <= 0) goto L_0x001a
        L_0x0019:
            return r0
        L_0x001a:
            int r2 = (r25 > r13 ? 1 : (r25 == r13 ? 0 : -1))
            if (r2 >= 0) goto L_0x0023
            int r2 = (r25 > r17 ? 1 : (r25 == r17 ? 0 : -1))
            if (r2 >= 0) goto L_0x0023
            goto L_0x006a
        L_0x0023:
            r2 = 255(0xff, float:3.57E-43)
            int r3 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x002a
            return r2
        L_0x002a:
            int r3 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x003f
            int r3 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r3 >= 0) goto L_0x0035
            r3 = r19
            goto L_0x0036
        L_0x0035:
            r3 = r11
        L_0x0036:
            int r5 = (r15 > r23 ? 1 : (r15 == r23 ? 0 : -1))
            if (r5 >= 0) goto L_0x003c
            r5 = r15
            goto L_0x004c
        L_0x003c:
            r5 = r23
            goto L_0x004c
        L_0x003f:
            int r3 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
            if (r3 >= 0) goto L_0x0046
            r3 = r19
            goto L_0x0047
        L_0x0046:
            r3 = r15
        L_0x0047:
            int r5 = (r11 > r23 ? 1 : (r11 == r23 ? 0 : -1))
            if (r5 >= 0) goto L_0x003c
            r5 = r11
        L_0x004c:
            double r7 = r17 - r13
            double r9 = r15 - r11
            double r7 = r7 / r9
            double r3 = r3 - r11
            double r3 = r3 * r7
            double r3 = r3 + r13
            double r5 = r5 - r11
            double r7 = r7 * r5
            double r7 = r7 + r13
            int r5 = (r3 > r21 ? 1 : (r3 == r21 ? 0 : -1))
            if (r5 >= 0) goto L_0x0062
            int r5 = (r7 > r21 ? 1 : (r7 == r21 ? 0 : -1))
            if (r5 >= 0) goto L_0x0062
            return r0
        L_0x0062:
            int r5 = (r3 > r25 ? 1 : (r3 == r25 ? 0 : -1))
            if (r5 <= 0) goto L_0x009c
            int r3 = (r7 > r25 ? 1 : (r7 == r25 ? 0 : -1))
            if (r3 <= 0) goto L_0x009c
        L_0x006a:
            int r2 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r2 != 0) goto L_0x006f
            return r0
        L_0x006f:
            r2 = -1
            if (r1 != 0) goto L_0x0079
            int r1 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r1 >= 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r0 = -1
        L_0x0078:
            return r0
        L_0x0079:
            r1 = 1
            int r3 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x0084
            int r2 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r2 >= 0) goto L_0x0083
            r0 = 1
        L_0x0083:
            return r0
        L_0x0084:
            int r3 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x0092
            int r2 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r2 >= 0) goto L_0x0091
            int r2 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r2 >= 0) goto L_0x0091
            r0 = 1
        L_0x0091:
            return r0
        L_0x0092:
            int r1 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
            if (r1 >= 0) goto L_0x009b
            int r1 = (r19 > r11 ? 1 : (r19 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x009b
            r0 = -1
        L_0x009b:
            return r0
        L_0x009c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.awt.geom.gl.Crossing.intersectLine(double, double, double, double, double, double, double, double):int");
    }

    public static boolean isInsideEvenOdd(int i) {
        return (i & 1) != 0;
    }

    public static boolean isInsideNonZero(int i) {
        return i != 0;
    }

    public static boolean isZero(double d) {
        return -1.0E-5d < d && d < 1.0E-5d;
    }

    public static int solveQuad(double[] dArr, double[] dArr2) {
        int i = 2;
        double d = dArr[2];
        double d2 = dArr[1];
        double d3 = dArr[0];
        if (d != 0.0d) {
            double d4 = (d2 * d2) - ((4.0d * d) * d3);
            if (d4 < 0.0d) {
                return 0;
            }
            double sqrt = Math.sqrt(d4);
            double d5 = -d2;
            double d6 = d * 2.0d;
            dArr2[0] = (d5 + sqrt) / d6;
            if (sqrt != 0.0d) {
                dArr2[1] = (d5 - sqrt) / d6;
                return fixRoots(dArr2, i);
            }
        } else if (d2 == 0.0d) {
            return -1;
        } else {
            dArr2[0] = (-d3) / d2;
        }
        i = 1;
        return fixRoots(dArr2, i);
    }

    public static int solveCubic(double[] dArr, double[] dArr2) {
        int i = 3;
        double d = dArr[3];
        if (d == 0.0d) {
            return solveQuad(dArr, dArr2);
        }
        double d2 = dArr[2] / d;
        double d3 = dArr[1] / d;
        double d4 = dArr[0] / d;
        double d5 = ((d2 * d2) - (d3 * 3.0d)) / 9.0d;
        double d6 = (((((d2 * 2.0d) * d2) * d2) - ((9.0d * d2) * d3)) + (d4 * 27.0d)) / 54.0d;
        double d7 = d5 * d5 * d5;
        double d8 = d6 * d6;
        double d9 = (-d2) / 3.0d;
        if (d8 < d7) {
            double acos = Math.acos(d6 / Math.sqrt(d7)) / 3.0d;
            double sqrt = Math.sqrt(d5) * -2.0d;
            dArr2[0] = (Math.cos(acos) * sqrt) + d9;
            dArr2[1] = (Math.cos(acos + 2.0943951023931953d) * sqrt) + d9;
            dArr2[2] = (sqrt * Math.cos(acos - 2.0943951023931953d)) + d9;
        } else {
            double d10 = d8 - d7;
            double pow = Math.pow(Math.sqrt(d10) + Math.abs(d6), 0.3333333333333333d);
            if (d6 > 0.0d) {
                pow = -pow;
            }
            if (-1.0E-10d >= pow || pow >= ROOT_DELTA) {
                double d11 = pow + (d5 / pow);
                dArr2[0] = d11 + d9;
                if (-1.0E-10d < d10 && d10 < ROOT_DELTA) {
                    dArr2[1] = ((-d11) / 2.0d) + d9;
                    i = 2;
                }
            } else {
                dArr2[0] = d9;
            }
            i = 1;
        }
        return fixRoots(dArr2, i);
    }

    static int fixRoots(double[] dArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            int i5 = i4;
            while (true) {
                if (i5 >= i) {
                    dArr[i3] = dArr[i2];
                    i3++;
                    break;
                } else if (isZero(dArr[i2] - dArr[i5])) {
                    break;
                } else {
                    i5++;
                }
            }
            i2 = i4;
        }
        return i3;
    }

    public static class QuadCurve {
        double Ax;
        double Ay;
        double Bx;
        double By;
        double ax;
        double ay;
        double bx;
        double by;

        public QuadCurve(double d, double d2, double d3, double d4, double d5, double d6) {
            double d7 = d5 - d;
            this.ax = d7;
            double d8 = d6 - d2;
            this.ay = d8;
            double d9 = d3 - d;
            this.bx = d9;
            double d10 = d4 - d2;
            this.by = d10;
            double d11 = d9 + d9;
            this.Bx = d11;
            this.Ax = d7 - d11;
            double d12 = d10 + d10;
            this.By = d12;
            this.Ay = d8 - d12;
        }

        /* access modifiers changed from: package-private */
        public int cross(double[] dArr, int i, double d, double d2) {
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                double d3 = dArr[i3];
                if (d3 >= -1.0E-5d && d3 <= 1.00001d) {
                    if (d3 < 1.0E-5d) {
                        if (d < 0.0d) {
                            double d4 = this.bx;
                            if (d4 == 0.0d) {
                                d4 = this.ax - d4;
                            }
                            if (d4 < 0.0d) {
                                i2--;
                            }
                        }
                    } else if (d3 > 0.99999d) {
                        if (d < this.ay) {
                            double d5 = this.ax;
                            double d6 = this.bx;
                            if (d5 != d6) {
                                d6 = d5 - d6;
                            }
                            if (d6 > 0.0d) {
                                i2++;
                            }
                        }
                    } else if (((this.Ay * d3) + this.By) * d3 > d2) {
                        double d7 = (d3 * this.Ax) + this.bx;
                        if (d7 <= -1.0E-5d || d7 >= 1.0E-5d) {
                            i2 += d7 > 0.0d ? 1 : -1;
                        }
                    }
                }
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        public int solvePoint(double[] dArr, double d) {
            return Crossing.solveQuad(new double[]{-d, this.Bx, this.Ax}, dArr);
        }

        /* access modifiers changed from: package-private */
        public int solveExtrem(double[] dArr) {
            double d = this.Ax;
            int i = 0;
            if (d != 0.0d) {
                dArr[0] = (-this.Bx) / (d + d);
                i = 1;
            }
            double d2 = this.Ay;
            if (d2 == 0.0d) {
                return i;
            }
            int i2 = i + 1;
            dArr[i] = (-this.By) / (d2 + d2);
            return i2;
        }

        /* access modifiers changed from: package-private */
        public int addBound(double[] dArr, int i, double[] dArr2, int i2, double d, double d2, boolean z, int i3) {
            int i4 = i;
            int i5 = i3;
            for (int i6 = 0; i6 < i2; i6++) {
                double d3 = dArr2[i6];
                if (d3 > -1.0E-5d && d3 < 1.00001d) {
                    double d4 = ((this.Ax * d3) + this.Bx) * d3;
                    if (d <= d4 && d4 <= d2) {
                        int i7 = i4 + 1;
                        dArr[i4] = d3;
                        int i8 = i7 + 1;
                        dArr[i7] = d4;
                        int i9 = i8 + 1;
                        dArr[i8] = d3 * ((this.Ay * d3) + this.By);
                        i4 = i9 + 1;
                        dArr[i9] = (double) i5;
                        if (z) {
                            i5++;
                        }
                    }
                }
            }
            return i4;
        }
    }

    public static class CubicCurve {
        double Ax;
        double Ax3;
        double Ay;
        double Bx;
        double Bx2;
        double By;
        double Cx;
        double Cy;
        double ax;
        double ay;
        double bx;
        double by;
        double cx;
        double cy;

        public CubicCurve(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
            double d9 = d7 - d;
            this.ax = d9;
            double d10 = d8 - d2;
            this.ay = d10;
            double d11 = d3 - d;
            this.bx = d11;
            double d12 = d4 - d2;
            this.by = d12;
            double d13 = d5 - d;
            this.cx = d13;
            double d14 = d6 - d2;
            this.cy = d14;
            double d15 = d11 + d11 + d11;
            this.Cx = d15;
            double d16 = (((d13 + d13) + d13) - d15) - d15;
            this.Bx = d16;
            double d17 = (d9 - d16) - d15;
            this.Ax = d17;
            double d18 = d12 + d12 + d12;
            this.Cy = d18;
            double d19 = (((d14 + d14) + d14) - d18) - d18;
            this.By = d19;
            this.Ay = (d10 - d19) - d18;
            this.Ax3 = d17 + d17 + d17;
            this.Bx2 = d16 + d16;
        }

        /* access modifiers changed from: package-private */
        public int cross(double[] dArr, int i, double d, double d2) {
            double d3;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                double d4 = dArr[i3];
                if (d4 >= -1.0E-5d && d4 <= 1.00001d) {
                    if (d4 < 1.0E-5d) {
                        if (d < 0.0d) {
                            double d5 = this.bx;
                            if (d5 == 0.0d) {
                                double d6 = this.cx;
                                d5 = d6 != d5 ? d6 - d5 : this.ax - d6;
                            }
                            if (d5 < 0.0d) {
                                i2--;
                            }
                        }
                    } else if (d4 > 0.99999d) {
                        if (d < this.ay) {
                            double d7 = this.ax;
                            double d8 = this.cx;
                            if (d7 != d8) {
                                d3 = d7 - d8;
                            } else {
                                d3 = this.bx;
                                if (d8 != d3) {
                                    d3 = d8 - d3;
                                }
                            }
                            if (d3 > 0.0d) {
                                i2++;
                            }
                        }
                    } else if (((((this.Ay * d4) + this.By) * d4) + this.Cy) * d4 > d2) {
                        double d9 = this.Ax3;
                        double d10 = this.Bx2;
                        double d11 = (((d4 * d9) + d10) * d4) + this.Cx;
                        if (d11 > -1.0E-5d && d11 < 1.0E-5d) {
                            double d12 = (d4 * (d9 + d9)) + d10;
                            if (d12 >= -1.0E-5d && d12 <= 1.0E-5d) {
                                d11 = this.ax;
                            }
                        }
                        i2 += d11 > 0.0d ? 1 : -1;
                    }
                }
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        public int solvePoint(double[] dArr, double d) {
            return Crossing.solveCubic(new double[]{-d, this.Cx, this.Bx, this.Ax}, dArr);
        }

        /* access modifiers changed from: package-private */
        public int solveExtremX(double[] dArr) {
            return Crossing.solveQuad(new double[]{this.Cx, this.Bx2, this.Ax3}, dArr);
        }

        /* access modifiers changed from: package-private */
        public int solveExtremY(double[] dArr) {
            double d = this.By;
            double d2 = this.Ay;
            return Crossing.solveQuad(new double[]{this.Cy, d + d, d2 + d2 + d2}, dArr);
        }

        /* access modifiers changed from: package-private */
        public int addBound(double[] dArr, int i, double[] dArr2, int i2, double d, double d2, boolean z, int i3) {
            int i4 = i;
            int i5 = i3;
            for (int i6 = 0; i6 < i2; i6++) {
                double d3 = dArr2[i6];
                if (d3 > -1.0E-5d && d3 < 1.00001d) {
                    double d4 = ((((this.Ax * d3) + this.Bx) * d3) + this.Cx) * d3;
                    if (d <= d4 && d4 <= d2) {
                        int i7 = i4 + 1;
                        dArr[i4] = d3;
                        int i8 = i7 + 1;
                        dArr[i7] = d4;
                        int i9 = i8 + 1;
                        dArr[i8] = d3 * ((((this.Ay * d3) + this.By) * d3) + this.Cy);
                        i4 = i9 + 1;
                        dArr[i9] = (double) i5;
                        if (z) {
                            i5++;
                        }
                    }
                }
            }
            return i4;
        }
    }

    public static int crossQuad(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        int i;
        int i2 = (d7 > d ? 1 : (d7 == d ? 0 : -1));
        if ((i2 < 0 && d7 < d3 && d7 < d5) || ((d7 > d && d7 > d3 && d7 > d5) || ((d8 > d2 && d8 > d4 && d8 > d6) || (d == d3 && d3 == d5)))) {
            return 0;
        }
        if (d8 < d2 && d8 < d4 && d8 < d6 && i != 0 && d7 != d5) {
            return d < d5 ? (d >= d7 || d7 >= d5) ? 0 : 1 : (d5 >= d7 || i2 >= 0) ? 0 : -1;
        }
        QuadCurve quadCurve = new QuadCurve(d, d2, d3, d4, d5, d6);
        double d9 = d8 - d2;
        double[] dArr = new double[3];
        return quadCurve.cross(dArr, quadCurve.solvePoint(dArr, d7 - d), d9, d9);
    }

    public static int crossCubic(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        int i;
        int i2 = (d9 > d ? 1 : (d9 == d ? 0 : -1));
        if ((i2 < 0 && d9 < d3 && d9 < d5 && d9 < d7) || ((d9 > d && d9 > d3 && d9 > d5 && d9 > d7) || ((d10 > d2 && d10 > d4 && d10 > d6 && d10 > d8) || (d == d3 && d3 == d5 && d5 == d7)))) {
            return 0;
        }
        if (d10 < d2 && d10 < d4 && d10 < d6 && d10 < d8 && i != 0 && d9 != d7) {
            return d < d7 ? (d >= d9 || d9 >= d7) ? 0 : 1 : (d7 >= d9 || i2 >= 0) ? 0 : -1;
        }
        CubicCurve cubicCurve = new CubicCurve(d, d2, d3, d4, d5, d6, d7, d8);
        double d11 = d10 - d2;
        double[] dArr = new double[3];
        return cubicCurve.cross(dArr, cubicCurve.solvePoint(dArr, d9 - d), d11, d11);
    }

    public static int crossPath(PathIterator pathIterator, double d, double d2) {
        double d3;
        double d4;
        double d5;
        double d6;
        char c;
        double[] dArr = new double[6];
        int i = 0;
        double d7 = 0.0d;
        double d8 = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        int i2 = 0;
        while (true) {
            if (pathIterator.isDone()) {
                d3 = d7;
                d4 = d8;
                d5 = d9;
                d6 = d10;
                i = i2;
                break;
            }
            int currentSegment = pathIterator.currentSegment(dArr);
            if (currentSegment == 0) {
                if (d8 == d7 && d9 == d10) {
                    c = 1;
                } else {
                    c = 1;
                    i2 += crossLine(d8, d9, d7, d10, d, d2);
                }
                double d11 = dArr[0];
                d10 = dArr[c];
                d9 = d10;
                d8 = d11;
                d7 = d8;
            } else if (currentSegment == 1) {
                double d12 = dArr[0];
                double d13 = dArr[1];
                i2 += crossLine(d8, d9, d12, d13, d, d2);
                d8 = d12;
                d9 = d13;
            } else if (currentSegment == 2) {
                double d14 = dArr[0];
                double d15 = dArr[1];
                double d16 = dArr[2];
                double d17 = dArr[3];
                i2 += crossQuad(d8, d9, d14, d15, d16, d17, d, d2);
                d8 = d16;
                d9 = d17;
            } else if (currentSegment == 3) {
                double d18 = dArr[0];
                double d19 = dArr[1];
                double d20 = dArr[2];
                double d21 = dArr[3];
                double d22 = dArr[4];
                double d23 = dArr[5];
                i2 += crossCubic(d8, d9, d18, d19, d20, d21, d22, d23, d, d2);
                d8 = d22;
                d9 = d23;
            } else if (currentSegment == 4 && !(d9 == d10 && d8 == d7)) {
                i2 += crossLine(d8, d9, d7, d10, d, d2);
                d8 = d7;
                d9 = d10;
            }
            if (d == d8 && d2 == d9) {
                d3 = d7;
                d4 = d8;
                d5 = d10;
                d6 = d5;
                break;
            }
            pathIterator.next();
        }
        return d5 != d6 ? i + crossLine(d4, d5, d3, d6, d, d2) : i;
    }

    public static int crossShape(Shape shape, double d, double d2) {
        if (!shape.getBounds2D().contains(d, d2)) {
            return 0;
        }
        return crossPath(shape.getPathIterator(null), d, d2);
    }

    static void sortBound(double[] dArr, int i) {
        int i2 = 0;
        while (i2 < i - 4) {
            int i3 = i2 + 4;
            int i4 = i2;
            for (int i5 = i3; i5 < i; i5 += 4) {
                if (dArr[i4] > dArr[i5]) {
                    i4 = i5;
                }
            }
            if (i4 != i2) {
                double d = dArr[i2];
                dArr[i2] = dArr[i4];
                dArr[i4] = d;
                int i6 = i2 + 1;
                double d2 = dArr[i6];
                int i7 = i4 + 1;
                dArr[i6] = dArr[i7];
                dArr[i7] = d2;
                int i8 = i2 + 2;
                double d3 = dArr[i8];
                int i9 = i4 + 2;
                dArr[i8] = dArr[i9];
                dArr[i9] = d3;
                int i10 = i2 + 3;
                double d4 = dArr[i10];
                int i11 = i4 + 3;
                dArr[i10] = dArr[i11];
                dArr[i11] = d4;
            }
            i2 = i3;
        }
    }

    static int crossBound(double[] dArr, int i, double d, double d2) {
        if (i == 0) {
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 2; i4 < i; i4 += 4) {
            if (dArr[i4] < d) {
                i3++;
            } else if (dArr[i4] <= d2) {
                return 255;
            } else {
                i2++;
            }
        }
        if (i2 == 0) {
            return 0;
        }
        if (i3 == 0) {
            return 254;
        }
        sortBound(dArr, i);
        boolean z = dArr[2] > d2;
        int i5 = 6;
        while (i5 < i) {
            boolean z2 = dArr[i5] > d2;
            if (z != z2 && dArr[i5 + 1] != dArr[i5 - 3]) {
                return 255;
            }
            i5 += 4;
            z = z2;
        }
        return 254;
    }

    public static int intersectQuad(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        int i;
        if ((d9 < d && d9 < d3 && d9 < d5) || ((d7 > d && d7 > d3 && d7 > d5) || (d8 > d2 && d8 > d4 && d8 > d6))) {
            return 0;
        }
        if (d10 < d2 && d10 < d4 && d10 < d6 && i != 0 && d7 != d5) {
            return d < d5 ? (d >= d7 || d7 >= d5) ? 0 : 1 : (d5 >= d7 || d7 >= d) ? 0 : -1;
        }
        QuadCurve quadCurve = new QuadCurve(d, d2, d3, d4, d5, d6);
        double d11 = d7 - d;
        double d12 = d8 - d2;
        double d13 = d9 - d;
        double d14 = d10 - d2;
        double[] dArr = new double[3];
        double[] dArr2 = new double[3];
        int solvePoint = quadCurve.solvePoint(dArr, d11);
        int solvePoint2 = quadCurve.solvePoint(dArr2, d13);
        if (solvePoint == 0 && solvePoint2 == 0) {
            return 0;
        }
        double d15 = d11 - 1.0E-5d;
        double d16 = d13 + 1.0E-5d;
        double[] dArr3 = new double[28];
        int addBound = quadCurve.addBound(dArr3, quadCurve.addBound(dArr3, quadCurve.addBound(dArr3, 0, dArr, solvePoint, d15, d16, false, 0), dArr2, solvePoint2, d15, d16, false, 1), dArr2, quadCurve.solveExtrem(dArr2), d15, d16, true, 2);
        if (d7 < d && d < d9) {
            int i2 = addBound + 1;
            dArr3[addBound] = 0.0d;
            int i3 = i2 + 1;
            dArr3[i2] = 0.0d;
            int i4 = i3 + 1;
            dArr3[i3] = 0.0d;
            addBound = i4 + 1;
            dArr3[i4] = 4.0d;
        }
        if (d7 < d5 && d5 < d9) {
            int i5 = addBound + 1;
            dArr3[addBound] = 1.0d;
            int i6 = i5 + 1;
            dArr3[i5] = quadCurve.ax;
            int i7 = i6 + 1;
            dArr3[i6] = quadCurve.ay;
            addBound = i7 + 1;
            dArr3[i7] = 5.0d;
        }
        int crossBound = crossBound(dArr3, addBound, d12, d14);
        if (crossBound != 254) {
            return crossBound;
        }
        return quadCurve.cross(dArr, solvePoint, d12, d14);
    }

    public static int intersectCubic(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        int i;
        if ((d11 < d && d11 < d3 && d11 < d5 && d11 < d7) || ((d9 > d && d9 > d3 && d9 > d5 && d9 > d7) || (d10 > d2 && d10 > d4 && d10 > d6 && d10 > d8))) {
            return 0;
        }
        if (d12 < d2 && d12 < d4 && d12 < d6 && d12 < d8 && i != 0 && d9 != d7) {
            return d < d7 ? (d >= d9 || d9 >= d7) ? 0 : 1 : (d7 >= d9 || d9 >= d) ? 0 : -1;
        }
        CubicCurve cubicCurve = new CubicCurve(d, d2, d3, d4, d5, d6, d7, d8);
        double d13 = d9 - d;
        double d14 = d10 - d2;
        double d15 = d11 - d;
        double d16 = d12 - d2;
        double[] dArr = new double[3];
        double[] dArr2 = new double[3];
        int solvePoint = cubicCurve.solvePoint(dArr, d13);
        int solvePoint2 = cubicCurve.solvePoint(dArr2, d15);
        if (solvePoint == 0 && solvePoint2 == 0) {
            return 0;
        }
        double d17 = d13 - 1.0E-5d;
        double d18 = d15 + 1.0E-5d;
        double[] dArr3 = new double[40];
        int addBound = cubicCurve.addBound(dArr3, cubicCurve.addBound(dArr3, cubicCurve.addBound(dArr3, cubicCurve.addBound(dArr3, 0, dArr, solvePoint, d17, d18, false, 0), dArr2, solvePoint2, d17, d18, false, 1), dArr2, cubicCurve.solveExtremX(dArr2), d17, d18, true, 2), dArr2, cubicCurve.solveExtremY(dArr2), d17, d18, true, 4);
        if (d9 < d && d < d11) {
            int i2 = addBound + 1;
            dArr3[addBound] = 0.0d;
            int i3 = i2 + 1;
            dArr3[i2] = 0.0d;
            int i4 = i3 + 1;
            dArr3[i3] = 0.0d;
            addBound = i4 + 1;
            dArr3[i4] = 6.0d;
        }
        if (d9 < d7 && d7 < d11) {
            int i5 = addBound + 1;
            dArr3[addBound] = 1.0d;
            int i6 = i5 + 1;
            dArr3[i5] = cubicCurve.ax;
            int i7 = i6 + 1;
            dArr3[i6] = cubicCurve.ay;
            addBound = i7 + 1;
            dArr3[i7] = 7.0d;
        }
        int crossBound = crossBound(dArr3, addBound, d14, d16);
        if (crossBound != 254) {
            return crossBound;
        }
        return cubicCurve.cross(dArr, solvePoint, d14, d16);
    }

    public static int intersectPath(PathIterator pathIterator, double d, double d2, double d3, double d4) {
        double d5;
        int i;
        char c;
        int intersectLine;
        double[] dArr = new double[6];
        double d6 = d + d3;
        double d7 = d2 + d4;
        double d8 = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i2 = 0;
        while (true) {
            int i3 = 255;
            if (!pathIterator.isDone()) {
                int currentSegment = pathIterator.currentSegment(dArr);
                if (currentSegment == 0) {
                    if (d8 == d10 && d9 == d11) {
                        intersectLine = 0;
                        c = 1;
                    } else {
                        c = 1;
                        intersectLine = intersectLine(d8, d9, d10, d11, d, d2, d6, d7);
                    }
                    d10 = dArr[0];
                    d11 = dArr[c];
                    i3 = 255;
                    d9 = d11;
                    d5 = d10;
                } else if (currentSegment == 1) {
                    double d12 = dArr[0];
                    double d13 = dArr[1];
                    i = intersectLine(d8, d9, d12, d13, d, d2, d6, d7);
                    d9 = d13;
                    d5 = d10;
                    i3 = 255;
                    d10 = d12;
                } else if (currentSegment != 2) {
                    if (currentSegment == 3) {
                        double d14 = dArr[0];
                        double d15 = dArr[1];
                        double d16 = dArr[2];
                        double d17 = dArr[3];
                        double d18 = dArr[4];
                        double d19 = dArr[5];
                        i = intersectCubic(d8, d9, d14, d15, d16, d17, d18, d19, d, d2, d6, d7);
                        d5 = d10;
                        d10 = d18;
                        d9 = d19;
                    } else if (currentSegment != 4) {
                        d5 = d10;
                        d10 = d8;
                        i = 0;
                    } else {
                        i = (d9 == d11 && d8 == d10) ? 0 : intersectLine(d8, d9, d10, d11, d, d2, d6, d7);
                        d5 = d10;
                        d9 = d11;
                    }
                    i3 = 255;
                } else {
                    double d20 = dArr[0];
                    double d21 = dArr[1];
                    double d22 = dArr[2];
                    double d23 = dArr[3];
                    i = intersectQuad(d8, d9, d20, d21, d22, d23, d, d2, d6, d7);
                    d9 = d23;
                    d5 = d10;
                    i3 = 255;
                    d10 = d22;
                }
                if (i == i3) {
                    return i3;
                }
                i2 += i;
                pathIterator.next();
                d8 = d10;
                d10 = d5;
            } else if (d9 == d11) {
                return i2;
            } else {
                int intersectLine2 = intersectLine(d8, d9, d10, d11, d, d2, d6, d7);
                if (intersectLine2 == 255) {
                    return 255;
                }
                return i2 + intersectLine2;
            }
        }
    }

    public static int intersectShape(Shape shape, double d, double d2, double d3, double d4) {
        if (!shape.getBounds2D().intersects(d, d2, d3, d4)) {
            return 0;
        }
        return intersectPath(shape.getPathIterator(null), d, d2, d3, d4);
    }
}
