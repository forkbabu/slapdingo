package it.sephiroth.android.library.easing;

public class Linear implements Easing {
    @Override // it.sephiroth.android.library.easing.Easing
    public double easeIn(double d, double d2, double d3, double d4) {
        return ((d3 * d) / d4) + d2;
    }

    @Override // it.sephiroth.android.library.easing.Easing
    public double easeInOut(double d, double d2, double d3, double d4) {
        return ((d3 * d) / d4) + d2;
    }

    public double easeNone(double d, double d2, double d3, double d4) {
        return ((d3 * d) / d4) + d2;
    }

    @Override // it.sephiroth.android.library.easing.Easing
    public double easeOut(double d, double d2, double d3, double d4) {
        return ((d3 * d) / d4) + d2;
    }
}
