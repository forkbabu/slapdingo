package kotlin.collections.unsigned;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.text.html.HtmlTags;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0002ø\u0001\u0000J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\nH\u0016J\u001a\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$1", "Lkotlin/collections/AbstractList;", "Lkotlin/UInt;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", HtmlTags.SIZE, "", "getSize", "()I", "contains", "", "element", "contains-WZ4Q5Ns", "(I)Z", "get", FirebaseAnalytics.Param.INDEX, "indexOf", "indexOf-WZ4Q5Ns", "(I)I", "isEmpty", "lastIndexOf", "lastIndexOf-WZ4Q5Ns", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: _UArraysJvm.kt */
public final class UArraysKt___UArraysJvmKt$asList$1 extends AbstractList<UInt> implements RandomAccess {
    final /* synthetic */ int[] $this_asList;

    UArraysKt___UArraysJvmKt$asList$1(int[] iArr) {
        this.$this_asList = iArr;
    }

    @Override // kotlin.collections.AbstractCollection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return m372containsWZ4Q5Ns(((UInt) obj).m133unboximpl());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof UInt) {
            return m373indexOfWZ4Q5Ns(((UInt) obj).m133unboximpl());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof UInt) {
            return m374lastIndexOfWZ4Q5Ns(((UInt) obj).m133unboximpl());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return UIntArray.m142getSizeimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractCollection
    public boolean isEmpty() {
        return UIntArray.m144isEmptyimpl(this.$this_asList);
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public boolean m372containsWZ4Q5Ns(int i) {
        return UIntArray.m137containsWZ4Q5Ns(this.$this_asList, i);
    }

    @Override // java.util.List, kotlin.collections.AbstractList
    public UInt get(int i) {
        return UInt.m84boximpl(UIntArray.m141getimpl(this.$this_asList, i));
    }

    /* renamed from: indexOf-WZ4Q5Ns  reason: not valid java name */
    public int m373indexOfWZ4Q5Ns(int i) {
        return ArraysKt.indexOf(this.$this_asList, i);
    }

    /* renamed from: lastIndexOf-WZ4Q5Ns  reason: not valid java name */
    public int m374lastIndexOfWZ4Q5Ns(int i) {
        return ArraysKt.lastIndexOf(this.$this_asList, i);
    }
}
