package kotlin.collections;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.zhihu.matisse.internal.loader.AlbumLoader;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"kotlin/collections/RingBuffer$iterator$1", "Lkotlin/collections/AbstractIterator;", AlbumLoader.COLUMN_COUNT, "", FirebaseAnalytics.Param.INDEX, "computeNext", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: SlidingWindow.kt */
public final class RingBuffer$iterator$1 extends AbstractIterator<T> {
    private int count;
    private int index;
    final /* synthetic */ RingBuffer this$0;

    RingBuffer$iterator$1(RingBuffer ringBuffer) {
        this.this$0 = ringBuffer;
        this.count = ringBuffer.size();
        this.index = ringBuffer.startIndex;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.collections.AbstractIterator
    public void computeNext() {
        if (this.count == 0) {
            done();
            return;
        }
        setNext(this.this$0.buffer[this.index]);
        this.index = (this.index + 1) % this.this$0.capacity;
        this.count--;
    }
}
