package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\f\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001\u0000J\u0010\u0010\u0005\u001a\u00020\u0002H&ø\u0001\u0000¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lkotlin/collections/UByteIterator;", "", "Lkotlin/UByte;", "()V", "next", "nextUByte", "()B", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: UIterators.kt */
public abstract class UByteIterator implements Iterator<UByte>, KMappedMarker {
    public abstract byte nextUByte();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final UByte next() {
        return UByte.m17boximpl(nextUByte());
    }
}
