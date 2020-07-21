package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class ParametersWithID implements CipherParameters {

    /* renamed from: id  reason: collision with root package name */
    private byte[] f74id;
    private CipherParameters parameters;

    public ParametersWithID(CipherParameters cipherParameters, byte[] bArr) {
        this.parameters = cipherParameters;
        this.f74id = bArr;
    }

    public byte[] getID() {
        return this.f74id;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
