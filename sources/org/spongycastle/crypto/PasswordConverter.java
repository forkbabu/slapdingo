package org.spongycastle.crypto;

public enum PasswordConverter implements CharToByteConverter {
    ASCII {
        @Override // org.spongycastle.crypto.CharToByteConverter
        public String getType() {
            return "ASCII";
        }

        @Override // org.spongycastle.crypto.CharToByteConverter
        public byte[] convert(char[] cArr) {
            return PBEParametersGenerator.PKCS5PasswordToBytes(cArr);
        }
    },
    UTF8 {
        @Override // org.spongycastle.crypto.CharToByteConverter
        public String getType() {
            return "UTF8";
        }

        @Override // org.spongycastle.crypto.CharToByteConverter
        public byte[] convert(char[] cArr) {
            return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(cArr);
        }
    },
    PKCS12 {
        @Override // org.spongycastle.crypto.CharToByteConverter
        public String getType() {
            return "PKCS12";
        }

        @Override // org.spongycastle.crypto.CharToByteConverter
        public byte[] convert(char[] cArr) {
            return PBEParametersGenerator.PKCS12PasswordToBytes(cArr);
        }
    }
}
