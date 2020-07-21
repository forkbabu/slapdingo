package io.fotoapparat.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@ø\u0001\u0000"}, d2 = {"getValue", "", "T", "continuation", "Lkotlin/coroutines/Continuation;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "io/fotoapparat/coroutines/AwaitBroadcastChannel", f = "AwaitBroadcastChannel.kt", i = {0}, l = {19, 21}, m = "getValue", n = {"this"}, s = {"L$0"})
/* compiled from: AwaitBroadcastChannel.kt */
final class AwaitBroadcastChannel$getValue$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AwaitBroadcastChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AwaitBroadcastChannel$getValue$1(AwaitBroadcastChannel awaitBroadcastChannel, Continuation continuation) {
        super(continuation);
        this.this$0 = awaitBroadcastChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getValue(this);
    }
}
