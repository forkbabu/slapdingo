package it.sephiroth.android.library.easing;

public class Sine implements Easing {
    @Override // it.sephiroth.android.library.easing.Easing
    public double easeOut(double d, double d2, double d3, double d4) {
        return (d3 * Math.sin((d / d4) * 1.5707963267948966d)) + d2;
    }

    @Override // it.sephiroth.android.library.easing.Easing
    public double easeIn(double d, double d2, double d3, double d4) {
        return ((-d3) * Math.cos((d / d4) * 1.5707963267948966d)) + d3 + d2;
    }

    @Override // it.sephiroth.android.library.easing.Easing
    public double easeInOut(double d, double d2, double d3, double d4) {
        return (((-d3) / 2.0d) * (Math.cos((d * 3.141592653589793d) / d4) - 1.0d)) + d2;
    }
}
