package com.google.zxing.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import org.spongycastle.crypto.tls.CipherSuite;

final class Base256Encoder implements Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 5;
    }

    Base256Encoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            sb.append(encoderContext.getCurrentChar());
            encoderContext.pos++;
            int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
            if (lookAheadTest != getEncodingMode()) {
                encoderContext.signalEncoderChange(lookAheadTest);
                break;
            }
        }
        int length = sb.length() - 1;
        int codewordCount = encoderContext.getCodewordCount() + length + 1;
        encoderContext.updateSymbolInfo(codewordCount);
        boolean z = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount > 0;
        if (encoderContext.hasMoreCharacters() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 249 || length > 1555) {
                throw new IllegalStateException("Message length not in valid ranges: " + length);
            } else {
                sb.setCharAt(0, (char) ((length / ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + 249));
                sb.insert(1, (char) (length % ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            encoderContext.writeCodeword(randomize255State(sb.charAt(i), encoderContext.getCodewordCount() + 1));
        }
    }

    private static char randomize255State(char c, int i) {
        int i2 = c + ((i * CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 + InputDeviceCompat.SOURCE_ANY);
    }
}
