package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.zhihu.matisse.internal.loader.AlbumLoader;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.spongycastle.crypto.tls.CipherSuite;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\tHHø\u0001\u0000"}, d2 = {"elementAtOrElse", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ReceiveChannel;", FirebaseAnalytics.Param.INDEX, "", "defaultValue", "Lkotlin/Function1;", "continuation", "Lkotlin/coroutines/Continuation;"}, k = 3, mv = {1, 1, 13})
@DebugMetadata(c = "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256, CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256}, m = "elementAtOrElse", n = {"$receiver", FirebaseAnalytics.Param.INDEX, "defaultValue", "$receiver$iv", "cause$iv", "$receiver", AlbumLoader.COLUMN_COUNT, "$receiver", FirebaseAnalytics.Param.INDEX, "defaultValue", "$receiver$iv", "cause$iv", "$receiver", AlbumLoader.COLUMN_COUNT}, s = {"L$0", "I$0", "L$1", "L$2", "L$3", "L$4", "I$1", "L$0", "I$0", "L$1", "L$2", "L$3", "L$4", "I$1"})
/* compiled from: Channels.common.kt */
public final class ChannelsKt__Channels_commonKt$elementAtOrElse$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__Channels_commonKt$elementAtOrElse$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt.elementAtOrElse(null, 0, null, this);
    }
}
