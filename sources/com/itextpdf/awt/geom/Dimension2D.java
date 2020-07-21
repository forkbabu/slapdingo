package com.itextpdf.awt.geom;

public abstract class Dimension2D implements Cloneable {
    public abstract double getHeight();

    public abstract double getWidth();

    public abstract void setSize(double d, double d2);

    protected Dimension2D() {
    }

    public void setSize(Dimension2D dimension2D) {
        setSize(dimension2D.getWidth(), dimension2D.getHeight());
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
