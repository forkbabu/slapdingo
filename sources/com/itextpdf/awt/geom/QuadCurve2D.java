package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.Point2D;
import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.awt.geom.gl.Crossing;
import com.itextpdf.awt.geom.misc.Messages;
import java.util.NoSuchElementException;

public abstract class QuadCurve2D implements Shape, Cloneable {
    public abstract Point2D getCtrlPt();

    public abstract double getCtrlX();

    public abstract double getCtrlY();

    public abstract Point2D getP1();

    public abstract Point2D getP2();

    public abstract double getX1();

    public abstract double getX2();

    public abstract double getY1();

    public abstract double getY2();

    public abstract void setCurve(double d, double d2, double d3, double d4, double d5, double d6);

    public static class Float extends QuadCurve2D {
        public float ctrlx;
        public float ctrly;
        public float x1;
        public float x2;
        public float y1;
        public float y2;

        public Float() {
        }

        public Float(float f, float f2, float f3, float f4, float f5, float f6) {
            setCurve(f, f2, f3, f4, f5, f6);
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public double getX1() {
            return (double) this.x1;
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public double getY1() {
            return (double) this.y1;
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public double getCtrlX() {
            return (double) this.ctrlx;
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public double getCtrlY() {
            return (double) this.ctrly;
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public double getX2() {
            return (double) this.x2;
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public double getY2() {
            return (double) this.y2;
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public Point2D getP1() {
            return new Point2D.Float(this.x1, this.y1);
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public Point2D getCtrlPt() {
            return new Point2D.Float(this.ctrlx, this.ctrly);
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public Point2D getP2() {
            return new Point2D.Float(this.x2, this.y2);
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public void setCurve(double d, double d2, double d3, double d4, double d5, double d6) {
            this.x1 = (float) d;
            this.y1 = (float) d2;
            this.ctrlx = (float) d3;
            this.ctrly = (float) d4;
            this.x2 = (float) d5;
            this.y2 = (float) d6;
        }

        public void setCurve(float f, float f2, float f3, float f4, float f5, float f6) {
            this.x1 = f;
            this.y1 = f2;
            this.ctrlx = f3;
            this.ctrly = f4;
            this.x2 = f5;
            this.y2 = f6;
        }

        @Override // com.itextpdf.awt.geom.Shape
        public Rectangle2D getBounds2D() {
            float min = Math.min(Math.min(this.x1, this.x2), this.ctrlx);
            float min2 = Math.min(Math.min(this.y1, this.y2), this.ctrly);
            return new Rectangle2D.Float(min, min2, Math.max(Math.max(this.x1, this.x2), this.ctrlx) - min, Math.max(Math.max(this.y1, this.y2), this.ctrly) - min2);
        }
    }

    public static class Double extends QuadCurve2D {
        public double ctrlx;
        public double ctrly;
        public double x1;
        public double x2;
        public double y1;
        public double y2;

        public Double() {
        }

        public Double(double d, double d2, double d3, double d4, double d5, double d6) {
            setCurve(d, d2, d3, d4, d5, d6);
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public double getX1() {
            return this.x1;
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public double getY1() {
            return this.y1;
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public double getCtrlX() {
            return this.ctrlx;
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public double getCtrlY() {
            return this.ctrly;
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public double getX2() {
            return this.x2;
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public double getY2() {
            return this.y2;
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public Point2D getP1() {
            return new Point2D.Double(this.x1, this.y1);
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public Point2D getCtrlPt() {
            return new Point2D.Double(this.ctrlx, this.ctrly);
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public Point2D getP2() {
            return new Point2D.Double(this.x2, this.y2);
        }

        @Override // com.itextpdf.awt.geom.QuadCurve2D
        public void setCurve(double d, double d2, double d3, double d4, double d5, double d6) {
            this.x1 = d;
            this.y1 = d2;
            this.ctrlx = d3;
            this.ctrly = d4;
            this.x2 = d5;
            this.y2 = d6;
        }

        @Override // com.itextpdf.awt.geom.Shape
        public Rectangle2D getBounds2D() {
            double min = Math.min(Math.min(this.x1, this.x2), this.ctrlx);
            double min2 = Math.min(Math.min(this.y1, this.y2), this.ctrly);
            return new Rectangle2D.Double(min, min2, Math.max(Math.max(this.x1, this.x2), this.ctrlx) - min, Math.max(Math.max(this.y1, this.y2), this.ctrly) - min2);
        }
    }

    class Iterator implements PathIterator {
        QuadCurve2D c;
        int index;
        AffineTransform t;

        @Override // com.itextpdf.awt.geom.PathIterator
        public int getWindingRule() {
            return 1;
        }

        Iterator(QuadCurve2D quadCurve2D, AffineTransform affineTransform) {
            this.c = quadCurve2D;
            this.t = affineTransform;
        }

        @Override // com.itextpdf.awt.geom.PathIterator
        public boolean isDone() {
            return this.index > 1;
        }

        @Override // com.itextpdf.awt.geom.PathIterator
        public void next() {
            this.index++;
        }

        @Override // com.itextpdf.awt.geom.PathIterator
        public int currentSegment(double[] dArr) {
            int i;
            if (!isDone()) {
                int i2 = 0;
                if (this.index == 0) {
                    dArr[0] = this.c.getX1();
                    dArr[1] = this.c.getY1();
                    i = 1;
                } else {
                    dArr[0] = this.c.getCtrlX();
                    dArr[1] = this.c.getCtrlY();
                    dArr[2] = this.c.getX2();
                    dArr[3] = this.c.getY2();
                    i2 = 2;
                    i = 2;
                }
                AffineTransform affineTransform = this.t;
                if (affineTransform != null) {
                    affineTransform.transform(dArr, 0, dArr, 0, i);
                }
                return i2;
            }
            throw new NoSuchElementException(Messages.getString("awt.4B"));
        }

        @Override // com.itextpdf.awt.geom.PathIterator
        public int currentSegment(float[] fArr) {
            int i;
            if (!isDone()) {
                int i2 = 0;
                if (this.index == 0) {
                    fArr[0] = (float) this.c.getX1();
                    fArr[1] = (float) this.c.getY1();
                    i = 1;
                } else {
                    fArr[0] = (float) this.c.getCtrlX();
                    fArr[1] = (float) this.c.getCtrlY();
                    fArr[2] = (float) this.c.getX2();
                    fArr[3] = (float) this.c.getY2();
                    i2 = 2;
                    i = 2;
                }
                AffineTransform affineTransform = this.t;
                if (affineTransform != null) {
                    affineTransform.transform(fArr, 0, fArr, 0, i);
                }
                return i2;
            }
            throw new NoSuchElementException(Messages.getString("awt.4B"));
        }
    }

    protected QuadCurve2D() {
    }

    public void setCurve(Point2D point2D, Point2D point2D2, Point2D point2D3) {
        setCurve(point2D.getX(), point2D.getY(), point2D2.getX(), point2D2.getY(), point2D3.getX(), point2D3.getY());
    }

    public void setCurve(double[] dArr, int i) {
        setCurve(dArr[i + 0], dArr[i + 1], dArr[i + 2], dArr[i + 3], dArr[i + 4], dArr[i + 5]);
    }

    public void setCurve(Point2D[] point2DArr, int i) {
        int i2 = i + 0;
        double x = point2DArr[i2].getX();
        double y = point2DArr[i2].getY();
        int i3 = i + 1;
        double x2 = point2DArr[i3].getX();
        double y2 = point2DArr[i3].getY();
        int i4 = i + 2;
        setCurve(x, y, x2, y2, point2DArr[i4].getX(), point2DArr[i4].getY());
    }

    public void setCurve(QuadCurve2D quadCurve2D) {
        setCurve(quadCurve2D.getX1(), quadCurve2D.getY1(), quadCurve2D.getCtrlX(), quadCurve2D.getCtrlY(), quadCurve2D.getX2(), quadCurve2D.getY2());
    }

    public double getFlatnessSq() {
        return Line2D.ptSegDistSq(getX1(), getY1(), getX2(), getY2(), getCtrlX(), getCtrlY());
    }

    public static double getFlatnessSq(double d, double d2, double d3, double d4, double d5, double d6) {
        return Line2D.ptSegDistSq(d, d2, d5, d6, d3, d4);
    }

    public static double getFlatnessSq(double[] dArr, int i) {
        return Line2D.ptSegDistSq(dArr[i + 0], dArr[i + 1], dArr[i + 4], dArr[i + 5], dArr[i + 2], dArr[i + 3]);
    }

    public double getFlatness() {
        return Line2D.ptSegDist(getX1(), getY1(), getX2(), getY2(), getCtrlX(), getCtrlY());
    }

    public static double getFlatness(double d, double d2, double d3, double d4, double d5, double d6) {
        return Line2D.ptSegDist(d, d2, d5, d6, d3, d4);
    }

    public static double getFlatness(double[] dArr, int i) {
        return Line2D.ptSegDist(dArr[i + 0], dArr[i + 1], dArr[i + 4], dArr[i + 5], dArr[i + 2], dArr[i + 3]);
    }

    public void subdivide(QuadCurve2D quadCurve2D, QuadCurve2D quadCurve2D2) {
        subdivide(this, quadCurve2D, quadCurve2D2);
    }

    public static void subdivide(QuadCurve2D quadCurve2D, QuadCurve2D quadCurve2D2, QuadCurve2D quadCurve2D3) {
        double x1 = quadCurve2D.getX1();
        double y1 = quadCurve2D.getY1();
        double ctrlX = quadCurve2D.getCtrlX();
        double ctrlY = quadCurve2D.getCtrlY();
        double x2 = quadCurve2D.getX2();
        double y2 = quadCurve2D.getY2();
        double d = (x1 + ctrlX) / 2.0d;
        double d2 = (y1 + ctrlY) / 2.0d;
        double d3 = (x2 + ctrlX) / 2.0d;
        double d4 = (y2 + ctrlY) / 2.0d;
        double d5 = (d + d3) / 2.0d;
        double d6 = (d2 + d4) / 2.0d;
        if (quadCurve2D2 != null) {
            quadCurve2D2.setCurve(x1, y1, d, d2, d5, d6);
        }
        if (quadCurve2D3 != null) {
            quadCurve2D3.setCurve(d5, d6, d3, d4, x2, y2);
        }
    }

    public static void subdivide(double[] dArr, int i, double[] dArr2, int i2, double[] dArr3, int i3) {
        double d = dArr[i + 0];
        double d2 = dArr[i + 1];
        double d3 = dArr[i + 2];
        double d4 = dArr[i + 3];
        double d5 = dArr[i + 4];
        double d6 = dArr[i + 5];
        double d7 = (d + d3) / 2.0d;
        double d8 = (d2 + d4) / 2.0d;
        double d9 = (d3 + d5) / 2.0d;
        double d10 = (d4 + d6) / 2.0d;
        double d11 = (d7 + d9) / 2.0d;
        double d12 = (d8 + d10) / 2.0d;
        if (dArr2 != null) {
            dArr2[i2 + 0] = d;
            dArr2[i2 + 1] = d2;
            dArr2[i2 + 2] = d7;
            dArr2[i2 + 3] = d8;
            dArr2[i2 + 4] = d11;
            dArr2[i2 + 5] = d12;
        }
        if (dArr3 != null) {
            dArr3[i3 + 0] = d11;
            dArr3[i3 + 1] = d12;
            dArr3[i3 + 2] = d9;
            dArr3[i3 + 3] = d10;
            dArr3[i3 + 4] = d5;
            dArr3[i3 + 5] = d6;
        }
    }

    public static int solveQuadratic(double[] dArr) {
        return solveQuadratic(dArr, dArr);
    }

    public static int solveQuadratic(double[] dArr, double[] dArr2) {
        return Crossing.solveQuad(dArr, dArr2);
    }

    @Override // com.itextpdf.awt.geom.Shape
    public boolean contains(double d, double d2) {
        return Crossing.isInsideEvenOdd(Crossing.crossShape(this, d, d2));
    }

    @Override // com.itextpdf.awt.geom.Shape
    public boolean contains(double d, double d2, double d3, double d4) {
        int intersectShape = Crossing.intersectShape(this, d, d2, d3, d4);
        return intersectShape != 255 && Crossing.isInsideEvenOdd(intersectShape);
    }

    @Override // com.itextpdf.awt.geom.Shape
    public boolean intersects(double d, double d2, double d3, double d4) {
        int intersectShape = Crossing.intersectShape(this, d, d2, d3, d4);
        return intersectShape == 255 || Crossing.isInsideEvenOdd(intersectShape);
    }

    @Override // com.itextpdf.awt.geom.Shape
    public boolean contains(Point2D point2D) {
        return contains(point2D.getX(), point2D.getY());
    }

    @Override // com.itextpdf.awt.geom.Shape
    public boolean intersects(Rectangle2D rectangle2D) {
        return intersects(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    @Override // com.itextpdf.awt.geom.Shape
    public boolean contains(Rectangle2D rectangle2D) {
        return contains(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    @Override // com.itextpdf.awt.geom.Shape
    public Rectangle getBounds() {
        return getBounds2D().getBounds();
    }

    @Override // com.itextpdf.awt.geom.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new Iterator(this, affineTransform);
    }

    @Override // com.itextpdf.awt.geom.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return new FlatteningPathIterator(getPathIterator(affineTransform), d);
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }
}
