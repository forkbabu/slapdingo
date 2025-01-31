package kotlin;

import com.itextpdf.text.html.HtmlTags;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u000bH\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\b\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u000eH\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\f\u001a\u00020\rH\b\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u000fH\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\b\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u0010H\b\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\f\u001a\u00020\rH\b\u001a\r\u0010\u0011\u001a\u00020\u0001*\u00020\u0001H\n¨\u0006\u0012"}, d2 = {"dec", "Ljava/math/BigDecimal;", HtmlTags.DIV, "other", "inc", "minus", "mod", "plus", "rem", "times", "toBigDecimal", "", "mathContext", "Ljava/math/MathContext;", "", "", "", "unaryMinus", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/NumbersKt")
/* compiled from: BigDecimals.kt */
class NumbersKt__BigDecimalsKt {
    private static final BigDecimal plus(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, "$this$plus");
        BigDecimal add = bigDecimal.add(bigDecimal2);
        Intrinsics.checkExpressionValueIsNotNull(add, "this.add(other)");
        return add;
    }

    private static final BigDecimal minus(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, "$this$minus");
        BigDecimal subtract = bigDecimal.subtract(bigDecimal2);
        Intrinsics.checkExpressionValueIsNotNull(subtract, "this.subtract(other)");
        return subtract;
    }

    private static final BigDecimal times(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, "$this$times");
        BigDecimal multiply = bigDecimal.multiply(bigDecimal2);
        Intrinsics.checkExpressionValueIsNotNull(multiply, "this.multiply(other)");
        return multiply;
    }

    private static final BigDecimal div(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, "$this$div");
        BigDecimal divide = bigDecimal.divide(bigDecimal2, RoundingMode.HALF_EVEN);
        Intrinsics.checkExpressionValueIsNotNull(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use rem(other) instead", replaceWith = @ReplaceWith(expression = "rem(other)", imports = {}))
    private static final BigDecimal mod(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, "$this$mod");
        BigDecimal remainder = bigDecimal.remainder(bigDecimal2);
        Intrinsics.checkExpressionValueIsNotNull(remainder, "this.remainder(other)");
        return remainder;
    }

    private static final BigDecimal rem(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, "$this$rem");
        BigDecimal remainder = bigDecimal.remainder(bigDecimal2);
        Intrinsics.checkExpressionValueIsNotNull(remainder, "this.remainder(other)");
        return remainder;
    }

    private static final BigDecimal unaryMinus(BigDecimal bigDecimal) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, "$this$unaryMinus");
        BigDecimal negate = bigDecimal.negate();
        Intrinsics.checkExpressionValueIsNotNull(negate, "this.negate()");
        return negate;
    }

    private static final BigDecimal inc(BigDecimal bigDecimal) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, "$this$inc");
        BigDecimal add = bigDecimal.add(BigDecimal.ONE);
        Intrinsics.checkExpressionValueIsNotNull(add, "this.add(BigDecimal.ONE)");
        return add;
    }

    private static final BigDecimal dec(BigDecimal bigDecimal) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, "$this$dec");
        BigDecimal subtract = bigDecimal.subtract(BigDecimal.ONE);
        Intrinsics.checkExpressionValueIsNotNull(subtract, "this.subtract(BigDecimal.ONE)");
        return subtract;
    }

    private static final BigDecimal toBigDecimal(int i) {
        BigDecimal valueOf = BigDecimal.valueOf((long) i);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "BigDecimal.valueOf(this.toLong())");
        return valueOf;
    }

    private static final BigDecimal toBigDecimal(int i, MathContext mathContext) {
        return new BigDecimal(i, mathContext);
    }

    private static final BigDecimal toBigDecimal(long j) {
        BigDecimal valueOf = BigDecimal.valueOf(j);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "BigDecimal.valueOf(this)");
        return valueOf;
    }

    private static final BigDecimal toBigDecimal(long j, MathContext mathContext) {
        return new BigDecimal(j, mathContext);
    }

    private static final BigDecimal toBigDecimal(float f) {
        return new BigDecimal(String.valueOf(f));
    }

    private static final BigDecimal toBigDecimal(float f, MathContext mathContext) {
        return new BigDecimal(String.valueOf(f), mathContext);
    }

    private static final BigDecimal toBigDecimal(double d) {
        return new BigDecimal(String.valueOf(d));
    }

    private static final BigDecimal toBigDecimal(double d, MathContext mathContext) {
        return new BigDecimal(String.valueOf(d), mathContext);
    }
}
