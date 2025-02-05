package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;

public class TlsDHKeyExchange extends AbstractTlsKeyExchange {
    protected TlsAgreementCredentials agreementCredentials;
    protected DHPrivateKeyParameters dhAgreePrivateKey;
    protected DHPublicKeyParameters dhAgreePublicKey;
    protected DHParameters dhParameters;
    protected AsymmetricKeyParameter serverPublicKey;
    protected TlsSigner tlsSigner;

    /* access modifiers changed from: protected */
    public int getMinimumPrimeBits() {
        return 1024;
    }

    public TlsDHKeyExchange(int i, Vector vector, DHParameters dHParameters) {
        super(i, vector);
        if (i == 3) {
            this.tlsSigner = new TlsDSSSigner();
        } else if (i == 5) {
            this.tlsSigner = new TlsRSASigner();
        } else if (i == 7 || i == 9 || i == 11) {
            this.tlsSigner = null;
        } else {
            throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
        this.dhParameters = dHParameters;
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange, org.spongycastle.crypto.tls.AbstractTlsKeyExchange
    public void init(TlsContext tlsContext) {
        super.init(tlsContext);
        TlsSigner tlsSigner2 = this.tlsSigner;
        if (tlsSigner2 != null) {
            tlsSigner2.init(tlsContext);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void skipServerCredentials() throws IOException {
        if (this.keyExchange != 11) {
            throw new TlsFatalAlert(10);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange, org.spongycastle.crypto.tls.AbstractTlsKeyExchange
    public void processServerCertificate(Certificate certificate) throws IOException {
        if (this.keyExchange == 11) {
            throw new TlsFatalAlert(10);
        } else if (!certificate.isEmpty()) {
            Certificate certificateAt = certificate.getCertificateAt(0);
            try {
                AsymmetricKeyParameter createKey = PublicKeyFactory.createKey(certificateAt.getSubjectPublicKeyInfo());
                this.serverPublicKey = createKey;
                TlsSigner tlsSigner2 = this.tlsSigner;
                if (tlsSigner2 == null) {
                    try {
                        DHPublicKeyParameters validateDHPublicKey = TlsDHUtils.validateDHPublicKey((DHPublicKeyParameters) createKey);
                        this.dhAgreePublicKey = validateDHPublicKey;
                        this.dhParameters = validateDHParameters(validateDHPublicKey.getParameters());
                        TlsUtils.validateKeyUsage(certificateAt, 8);
                    } catch (ClassCastException e) {
                        throw new TlsFatalAlert(46, e);
                    }
                } else if (tlsSigner2.isValidPublicKey(createKey)) {
                    TlsUtils.validateKeyUsage(certificateAt, 128);
                } else {
                    throw new TlsFatalAlert(46);
                }
                super.processServerCertificate(certificate);
            } catch (RuntimeException e2) {
                throw new TlsFatalAlert(43, e2);
            }
        } else {
            throw new TlsFatalAlert(42);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange, org.spongycastle.crypto.tls.AbstractTlsKeyExchange
    public boolean requiresServerKeyExchange() {
        int i = this.keyExchange;
        return i == 3 || i == 5 || i == 11;
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange, org.spongycastle.crypto.tls.AbstractTlsKeyExchange
    public byte[] generateServerKeyExchange() throws IOException {
        if (!requiresServerKeyExchange()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.dhParameters, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange, org.spongycastle.crypto.tls.AbstractTlsKeyExchange
    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        if (requiresServerKeyExchange()) {
            DHPublicKeyParameters validateDHPublicKey = TlsDHUtils.validateDHPublicKey(ServerDHParams.parse(inputStream).getPublicKey());
            this.dhAgreePublicKey = validateDHPublicKey;
            this.dhParameters = validateDHParameters(validateDHPublicKey.getParameters());
            return;
        }
        throw new TlsFatalAlert(10);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void validateCertificateRequest(CertificateRequest certificateRequest) throws IOException {
        if (this.keyExchange != 11) {
            short[] certificateTypes = certificateRequest.getCertificateTypes();
            int i = 0;
            while (i < certificateTypes.length) {
                short s = certificateTypes[i];
                if (s == 1 || s == 2 || s == 3 || s == 4 || s == 64) {
                    i++;
                } else {
                    throw new TlsFatalAlert(47);
                }
            }
            return;
        }
        throw new TlsFatalAlert(40);
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void processClientCredentials(TlsCredentials tlsCredentials) throws IOException {
        if (this.keyExchange == 11) {
            throw new TlsFatalAlert(80);
        } else if (tlsCredentials instanceof TlsAgreementCredentials) {
            this.agreementCredentials = (TlsAgreementCredentials) tlsCredentials;
        } else if (!(tlsCredentials instanceof TlsSignerCredentials)) {
            throw new TlsFatalAlert(80);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public void generateClientKeyExchange(OutputStream outputStream) throws IOException {
        if (this.agreementCredentials == null) {
            this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.dhParameters, outputStream);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange, org.spongycastle.crypto.tls.AbstractTlsKeyExchange
    public void processClientCertificate(Certificate certificate) throws IOException {
        if (this.keyExchange == 11) {
            throw new TlsFatalAlert(10);
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange, org.spongycastle.crypto.tls.AbstractTlsKeyExchange
    public void processClientKeyExchange(InputStream inputStream) throws IOException {
        if (this.dhAgreePublicKey == null) {
            this.dhAgreePublicKey = TlsDHUtils.validateDHPublicKey(new DHPublicKeyParameters(TlsDHUtils.readDHParameter(inputStream), this.dhParameters));
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsKeyExchange
    public byte[] generatePremasterSecret() throws IOException {
        TlsAgreementCredentials tlsAgreementCredentials = this.agreementCredentials;
        if (tlsAgreementCredentials != null) {
            return tlsAgreementCredentials.generateAgreement(this.dhAgreePublicKey);
        }
        DHPrivateKeyParameters dHPrivateKeyParameters = this.dhAgreePrivateKey;
        if (dHPrivateKeyParameters != null) {
            return TlsDHUtils.calculateDHBasicAgreement(this.dhAgreePublicKey, dHPrivateKeyParameters);
        }
        throw new TlsFatalAlert(80);
    }

    /* access modifiers changed from: protected */
    public DHParameters validateDHParameters(DHParameters dHParameters) throws IOException {
        if (dHParameters.getP().bitLength() >= getMinimumPrimeBits()) {
            return TlsDHUtils.validateDHParameters(dHParameters);
        }
        throw new TlsFatalAlert(71);
    }
}
