package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.io.StreamUtil;
import com.itextpdf.text.pdf.CJKFont;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.IOException;
import java.io.InputStream;

public class CidResource implements CidLocation {
    @Override // com.itextpdf.text.pdf.fonts.cmaps.CidLocation
    public PRTokeniser getLocation(String str) throws IOException {
        String str2 = CJKFont.RESOURCE_PATH_CMAP + str;
        InputStream resourceStream = StreamUtil.getResourceStream(str2);
        if (resourceStream != null) {
            return new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().createSource(resourceStream)));
        }
        throw new IOException(MessageLocalization.getComposedMessage("the.cmap.1.was.not.found", str2));
    }
}
