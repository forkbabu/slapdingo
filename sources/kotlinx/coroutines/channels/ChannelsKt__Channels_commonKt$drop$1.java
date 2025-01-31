package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$drop$1", f = "Channels.common.kt", i = {0, 1, 2, 3, 4, 4}, l = {584, 584, 589, 584, 594, 593}, m = "invokeSuspend", n = {"remaining", "remaining", "remaining", "remaining", "remaining", "e"}, s = {"I$0", "I$0", "I$0", "I$0", "I$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$drop$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel $this_drop;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private ProducerScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$drop$1(ReceiveChannel receiveChannel, int i, Continuation continuation) {
        super(2, continuation);
        this.$this_drop = receiveChannel;
        this.$n = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$drop$1 channelsKt__Channels_commonKt$drop$1 = new ChannelsKt__Channels_commonKt$drop$1(this.$this_drop, this.$n, continuation);
        channelsKt__Channels_commonKt$drop$1.p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$drop$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__Channels_commonKt$drop$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00fb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0123 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0124  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x008e
            if (r1 == r6) goto L_0x0078
            if (r1 == r5) goto L_0x0061
            if (r1 == r4) goto L_0x004b
            if (r1 == r3) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            java.lang.Object r1 = r12.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r5 = r12.I$0
            java.lang.Object r6 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            boolean r7 = r13 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x0028
            r8 = r12
            goto L_0x00ed
        L_0x0028:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r13 = r13.exception
            throw r13
        L_0x002d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0035:
            java.lang.Object r1 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r5 = r12.I$0
            java.lang.Object r6 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            boolean r7 = r13 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x0046
            r8 = r12
            goto L_0x0113
        L_0x0046:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r13 = r13.exception
            throw r13
        L_0x004b:
            java.lang.Object r1 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r5 = r12.I$0
            java.lang.Object r6 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            boolean r7 = r13 instanceof kotlin.Result.Failure
            if (r7 != 0) goto L_0x005c
            r8 = r12
            goto L_0x00fc
        L_0x005c:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r13 = r13.exception
            throw r13
        L_0x0061:
            java.lang.Object r1 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r7 = r12.I$0
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            boolean r9 = r13 instanceof kotlin.Result.Failure
            if (r9 != 0) goto L_0x0073
            r13 = r8
            r8 = r12
            goto L_0x00d5
        L_0x0073:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r13 = r13.exception
            throw r13
        L_0x0078:
            java.lang.Object r1 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r7 = r12.I$0
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            boolean r9 = r13 instanceof kotlin.Result.Failure
            if (r9 != 0) goto L_0x0089
            r9 = r8
            r8 = r12
            goto L_0x00bd
        L_0x0089:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r13 = r13.exception
            throw r13
        L_0x008e:
            boolean r1 = r13 instanceof kotlin.Result.Failure
            if (r1 != 0) goto L_0x014b
            kotlinx.coroutines.channels.ProducerScope r13 = r12.p$
            int r1 = r12.$n
            if (r1 < 0) goto L_0x009a
            r1 = 1
            goto L_0x009b
        L_0x009a:
            r1 = 0
        L_0x009b:
            if (r1 == 0) goto L_0x0127
            int r1 = r12.$n
            if (r1 <= 0) goto L_0x00e2
            kotlinx.coroutines.channels.ReceiveChannel r7 = r12.$this_drop
            kotlinx.coroutines.channels.ChannelIterator r7 = r7.iterator()
            r8 = r12
        L_0x00a8:
            r8.L$0 = r13
            r8.I$0 = r1
            r8.L$1 = r7
            r8.label = r6
            java.lang.Object r9 = r7.hasNext(r8)
            if (r9 != r0) goto L_0x00b7
            return r0
        L_0x00b7:
            r10 = r9
            r9 = r13
            r13 = r10
            r11 = r7
            r7 = r1
            r1 = r11
        L_0x00bd:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x00df
            r8.L$0 = r9
            r8.I$0 = r7
            r8.L$1 = r1
            r8.label = r5
            java.lang.Object r13 = r1.next(r8)
            if (r13 != r0) goto L_0x00d4
            return r0
        L_0x00d4:
            r13 = r9
        L_0x00d5:
            int r7 = r7 + -1
            if (r7 != 0) goto L_0x00db
            r1 = r7
            goto L_0x00e3
        L_0x00db:
            r10 = r7
            r7 = r1
            r1 = r10
            goto L_0x00a8
        L_0x00df:
            r1 = r7
            r13 = r9
            goto L_0x00e3
        L_0x00e2:
            r8 = r12
        L_0x00e3:
            kotlinx.coroutines.channels.ReceiveChannel r5 = r8.$this_drop
            kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
            r6 = r13
            r10 = r5
            r5 = r1
            r1 = r10
        L_0x00ed:
            r8.L$0 = r6
            r8.I$0 = r5
            r8.L$1 = r1
            r8.label = r4
            java.lang.Object r13 = r1.hasNext(r8)
            if (r13 != r0) goto L_0x00fc
            return r0
        L_0x00fc:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x0124
            r8.L$0 = r6
            r8.I$0 = r5
            r8.L$1 = r1
            r8.label = r3
            java.lang.Object r13 = r1.next(r8)
            if (r13 != r0) goto L_0x0113
            return r0
        L_0x0113:
            r8.L$0 = r6
            r8.I$0 = r5
            r8.L$1 = r13
            r8.L$2 = r1
            r8.label = r2
            java.lang.Object r13 = r6.send(r13, r8)
            if (r13 != r0) goto L_0x00ed
            return r0
        L_0x0124:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x0127:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "Requested element count "
            r13.append(r0)
            int r0 = r12.$n
            r13.append(r0)
            java.lang.String r0 = " is less than zero."
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r13 = r13.toString()
            r0.<init>(r13)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x014b:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r13 = r13.exception
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$drop$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
