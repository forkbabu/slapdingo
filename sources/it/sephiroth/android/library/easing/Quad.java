package it.sephiroth.android.library.easing;

public class Quad implements Easing {
    @Override // it.sephiroth.android.library.easing.Easing
    public double easeIn(double d, double d2, double d3, double d4) {
        double d5 = d / d4;
        return (d3 * d5 * d5) + d2;
    }

    @Override // it.sephiroth.android.library.easing.Easing
    public double easeInOut(double d, double d2, double d3, double d4) {
        double d5;
        double d6 = d / (d4 / 2.0d);
        if (d6 < 1.0d) {
            d5 = (d3 / 2.0d) * d6;
        } else {
            d5 = (-d3) / 2.0d;
            double d7 = d6 - 1.0d;
            d6 = (d7 * (d7 - 2.0d)) - 1.0d;
        }
        return (d5 * d6) + d2;
    }

    @Override // it.sephiroth.android.library.easing.Easing
    public double easeOut(double d, double d2, double d3, double d4) {
        double d5 = d / d4;
        return ((-d3) * d5 * (d5 - 2.0d)) + d2;
    }
}
