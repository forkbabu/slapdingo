package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.tls.TlsProtocol;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.Arrays;

public class TlsServerProtocol extends TlsProtocol {
    protected CertificateRequest certificateRequest = null;
    protected short clientCertificateType = -1;
    protected TlsKeyExchange keyExchange = null;
    protected TlsHandshakeHash prepareFinishHash = null;
    protected TlsCredentials serverCredentials = null;
    protected TlsServer tlsServer = null;
    TlsServerContextImpl tlsServerContext = null;

    public TlsServerProtocol(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom) {
        super(inputStream, outputStream, secureRandom);
    }

    public TlsServerProtocol(SecureRandom secureRandom) {
        super(secureRandom);
    }

    public void accept(TlsServer tlsServer2) throws IOException {
        if (tlsServer2 == null) {
            throw new IllegalArgumentException("'tlsServer' cannot be null");
        } else if (this.tlsServer == null) {
            this.tlsServer = tlsServer2;
            this.securityParameters = new SecurityParameters();
            this.securityParameters.entity = 0;
            this.tlsServerContext = new TlsServerContextImpl(this.secureRandom, this.securityParameters);
            this.securityParameters.serverRandom = createRandomBlock(tlsServer2.shouldUseGMTUnixTime(), this.tlsServerContext.getNonceRandomGenerator());
            this.tlsServer.init(this.tlsServerContext);
            this.recordStream.init(this.tlsServerContext);
            this.recordStream.setRestrictReadVersion(false);
            blockForHandshake();
        } else {
            throw new IllegalStateException("'accept' can only be called once");
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public void cleanupHandshake() {
        super.cleanupHandshake();
        this.keyExchange = null;
        this.serverCredentials = null;
        this.certificateRequest = null;
        this.prepareFinishHash = null;
    }

    /* access modifiers changed from: protected */
    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public TlsContext getContext() {
        return this.tlsServerContext;
    }

    /* access modifiers changed from: package-private */
    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public AbstractTlsContext getContextAdmin() {
        return this.tlsServerContext;
    }

    /* access modifiers changed from: protected */
    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public TlsPeer getPeer() {
        return this.tlsServer;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
    @Override // org.spongycastle.crypto.tls.TlsProtocol
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleHandshakeMessage(short r10, java.io.ByteArrayInputStream r11) throws java.io.IOException {
        /*
            r9 = this;
            r0 = 16
            r1 = 0
            r2 = 8
            r3 = 1
            r4 = 10
            if (r10 == r3) goto L_0x0106
            r3 = 9
            r5 = 11
            if (r10 == r5) goto L_0x00e3
            r6 = 20
            r7 = 12
            r8 = 15
            if (r10 == r6) goto L_0x00a5
            r6 = 23
            if (r10 == r6) goto L_0x008e
            if (r10 == r8) goto L_0x0071
            if (r10 != r0) goto L_0x006b
            short r10 = r9.connection_state
            switch(r10) {
                case 8: goto L_0x002b;
                case 9: goto L_0x0030;
                case 10: goto L_0x005e;
                default: goto L_0x0025;
            }
        L_0x0025:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r10.<init>(r4)
            throw r10
        L_0x002b:
            org.spongycastle.crypto.tls.TlsServer r10 = r9.tlsServer
            r10.processClientSupplementalData(r1)
        L_0x0030:
            org.spongycastle.crypto.tls.CertificateRequest r10 = r9.certificateRequest
            if (r10 != 0) goto L_0x003a
            org.spongycastle.crypto.tls.TlsKeyExchange r10 = r9.keyExchange
            r10.skipClientCredentials()
            goto L_0x005e
        L_0x003a:
            org.spongycastle.crypto.tls.TlsContext r10 = r9.getContext()
            boolean r10 = org.spongycastle.crypto.tls.TlsUtils.isTLSv12(r10)
            if (r10 != 0) goto L_0x0065
            org.spongycastle.crypto.tls.TlsContext r10 = r9.getContext()
            boolean r10 = org.spongycastle.crypto.tls.TlsUtils.isSSL(r10)
            if (r10 == 0) goto L_0x0059
            org.spongycastle.crypto.tls.Certificate r10 = r9.peerCertificate
            if (r10 == 0) goto L_0x0053
            goto L_0x005e
        L_0x0053:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r10.<init>(r4)
            throw r10
        L_0x0059:
            org.spongycastle.crypto.tls.Certificate r10 = org.spongycastle.crypto.tls.Certificate.EMPTY_CHAIN
            r9.notifyClientCertificate(r10)
        L_0x005e:
            r9.receiveClientKeyExchangeMessage(r11)
            r9.connection_state = r5
            goto L_0x01e7
        L_0x0065:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r10.<init>(r4)
            throw r10
        L_0x006b:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r10.<init>(r4)
            throw r10
        L_0x0071:
            short r10 = r9.connection_state
            if (r10 != r5) goto L_0x0088
            boolean r10 = r9.expectCertificateVerifyMessage()
            if (r10 == 0) goto L_0x0082
            r9.receiveCertificateVerifyMessage(r11)
            r9.connection_state = r7
            goto L_0x01e7
        L_0x0082:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r10.<init>(r4)
            throw r10
        L_0x0088:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r10.<init>(r4)
            throw r10
        L_0x008e:
            short r10 = r9.connection_state
            if (r10 != r2) goto L_0x009f
            org.spongycastle.crypto.tls.TlsServer r10 = r9.tlsServer
            java.util.Vector r11 = readSupplementalDataMessage(r11)
            r10.processClientSupplementalData(r11)
            r9.connection_state = r3
            goto L_0x01e7
        L_0x009f:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r10.<init>(r4)
            throw r10
        L_0x00a5:
            short r10 = r9.connection_state
            if (r10 == r5) goto L_0x00b2
            if (r10 != r7) goto L_0x00ac
            goto L_0x00b8
        L_0x00ac:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r10.<init>(r4)
            throw r10
        L_0x00b2:
            boolean r10 = r9.expectCertificateVerifyMessage()
            if (r10 != 0) goto L_0x00dd
        L_0x00b8:
            r9.processFinishedMessage(r11)
            r10 = 13
            r9.connection_state = r10
            boolean r10 = r9.expectSessionTicket
            if (r10 == 0) goto L_0x00cf
            org.spongycastle.crypto.tls.TlsServer r10 = r9.tlsServer
            org.spongycastle.crypto.tls.NewSessionTicket r10 = r10.getNewSessionTicket()
            r9.sendNewSessionTicketMessage(r10)
            r9.sendChangeCipherSpecMessage()
        L_0x00cf:
            r10 = 14
            r9.connection_state = r10
            r9.sendFinishedMessage()
            r9.connection_state = r8
            r9.completeHandshake()
            goto L_0x01e7
        L_0x00dd:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r10.<init>(r4)
            throw r10
        L_0x00e3:
            short r10 = r9.connection_state
            if (r10 == r2) goto L_0x00f0
            if (r10 != r3) goto L_0x00ea
            goto L_0x00f5
        L_0x00ea:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r10.<init>(r4)
            throw r10
        L_0x00f0:
            org.spongycastle.crypto.tls.TlsServer r10 = r9.tlsServer
            r10.processClientSupplementalData(r1)
        L_0x00f5:
            org.spongycastle.crypto.tls.CertificateRequest r10 = r9.certificateRequest
            if (r10 == 0) goto L_0x0100
            r9.receiveCertificateMessage(r11)
            r9.connection_state = r4
            goto L_0x01e7
        L_0x0100:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r10.<init>(r4)
            throw r10
        L_0x0106:
            short r10 = r9.connection_state
            if (r10 == 0) goto L_0x0117
            if (r10 != r0) goto L_0x0111
            r9.refuseRenegotiation()
            goto L_0x01e7
        L_0x0111:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r10.<init>(r4)
            throw r10
        L_0x0117:
            r9.receiveClientHelloMessage(r11)
            r9.connection_state = r3
            r9.sendServerHelloMessage()
            r10 = 2
            r9.connection_state = r10
            org.spongycastle.crypto.tls.RecordStream r10 = r9.recordStream
            r10.notifyHelloComplete()
            org.spongycastle.crypto.tls.TlsServer r10 = r9.tlsServer
            java.util.Vector r10 = r10.getServerSupplementalData()
            if (r10 == 0) goto L_0x0132
            r9.sendSupplementalDataMessage(r10)
        L_0x0132:
            r10 = 3
            r9.connection_state = r10
            org.spongycastle.crypto.tls.TlsServer r10 = r9.tlsServer
            org.spongycastle.crypto.tls.TlsKeyExchange r10 = r10.getKeyExchange()
            r9.keyExchange = r10
            org.spongycastle.crypto.tls.TlsContext r11 = r9.getContext()
            r10.init(r11)
            org.spongycastle.crypto.tls.TlsServer r10 = r9.tlsServer
            org.spongycastle.crypto.tls.TlsCredentials r10 = r10.getCredentials()
            r9.serverCredentials = r10
            if (r10 != 0) goto L_0x0154
            org.spongycastle.crypto.tls.TlsKeyExchange r10 = r9.keyExchange
            r10.skipServerCredentials()
            goto L_0x0162
        L_0x0154:
            org.spongycastle.crypto.tls.TlsKeyExchange r11 = r9.keyExchange
            r11.processServerCredentials(r10)
            org.spongycastle.crypto.tls.TlsCredentials r10 = r9.serverCredentials
            org.spongycastle.crypto.tls.Certificate r1 = r10.getCertificate()
            r9.sendCertificateMessage(r1)
        L_0x0162:
            r10 = 4
            r9.connection_state = r10
            r10 = 0
            if (r1 == 0) goto L_0x016e
            boolean r11 = r1.isEmpty()
            if (r11 == 0) goto L_0x0170
        L_0x016e:
            r9.allowCertificateStatus = r10
        L_0x0170:
            boolean r11 = r9.allowCertificateStatus
            if (r11 == 0) goto L_0x017f
            org.spongycastle.crypto.tls.TlsServer r11 = r9.tlsServer
            org.spongycastle.crypto.tls.CertificateStatus r11 = r11.getCertificateStatus()
            if (r11 == 0) goto L_0x017f
            r9.sendCertificateStatusMessage(r11)
        L_0x017f:
            r11 = 5
            r9.connection_state = r11
            org.spongycastle.crypto.tls.TlsKeyExchange r11 = r9.keyExchange
            byte[] r11 = r11.generateServerKeyExchange()
            if (r11 == 0) goto L_0x018d
            r9.sendServerKeyExchangeMessage(r11)
        L_0x018d:
            r11 = 6
            r9.connection_state = r11
            org.spongycastle.crypto.tls.TlsCredentials r11 = r9.serverCredentials
            if (r11 == 0) goto L_0x01d6
            org.spongycastle.crypto.tls.TlsServer r11 = r9.tlsServer
            org.spongycastle.crypto.tls.CertificateRequest r11 = r11.getCertificateRequest()
            r9.certificateRequest = r11
            if (r11 == 0) goto L_0x01d6
            org.spongycastle.crypto.tls.TlsContext r11 = r9.getContext()
            boolean r11 = org.spongycastle.crypto.tls.TlsUtils.isTLSv12(r11)
            org.spongycastle.crypto.tls.CertificateRequest r0 = r9.certificateRequest
            java.util.Vector r0 = r0.getSupportedSignatureAlgorithms()
            if (r0 == 0) goto L_0x01af
            goto L_0x01b0
        L_0x01af:
            r3 = 0
        L_0x01b0:
            if (r11 != r3) goto L_0x01ce
            org.spongycastle.crypto.tls.TlsKeyExchange r10 = r9.keyExchange
            org.spongycastle.crypto.tls.CertificateRequest r11 = r9.certificateRequest
            r10.validateCertificateRequest(r11)
            org.spongycastle.crypto.tls.CertificateRequest r10 = r9.certificateRequest
            r9.sendCertificateRequestMessage(r10)
            org.spongycastle.crypto.tls.RecordStream r10 = r9.recordStream
            org.spongycastle.crypto.tls.TlsHandshakeHash r10 = r10.getHandshakeHash()
            org.spongycastle.crypto.tls.CertificateRequest r11 = r9.certificateRequest
            java.util.Vector r11 = r11.getSupportedSignatureAlgorithms()
            org.spongycastle.crypto.tls.TlsUtils.trackHashAlgorithms(r10, r11)
            goto L_0x01d6
        L_0x01ce:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r11 = 80
            r10.<init>(r11)
            throw r10
        L_0x01d6:
            r10 = 7
            r9.connection_state = r10
            r9.sendServerHelloDoneMessage()
            r9.connection_state = r2
            org.spongycastle.crypto.tls.RecordStream r10 = r9.recordStream
            org.spongycastle.crypto.tls.TlsHandshakeHash r10 = r10.getHandshakeHash()
            r10.sealHashAlgorithms()
        L_0x01e7:
            return
            switch-data {8->0x002b, 9->0x0030, 10->0x005e, }
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsServerProtocol.handleHandshakeMessage(short, java.io.ByteArrayInputStream):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        if (r3 == 9) goto L_0x0029;
     */
    @Override // org.spongycastle.crypto.tls.TlsProtocol
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleAlertWarningMessage(short r3) throws java.io.IOException {
        /*
            r2 = this;
            super.handleAlertWarningMessage(r3)
            r0 = 41
            if (r3 == r0) goto L_0x0008
            return
        L_0x0008:
            org.spongycastle.crypto.tls.TlsContext r3 = r2.getContext()
            boolean r3 = org.spongycastle.crypto.tls.TlsUtils.isSSL(r3)
            r0 = 10
            if (r3 == 0) goto L_0x0031
            org.spongycastle.crypto.tls.CertificateRequest r3 = r2.certificateRequest
            if (r3 == 0) goto L_0x0031
            short r3 = r2.connection_state
            r1 = 8
            if (r3 == r1) goto L_0x0023
            r1 = 9
            if (r3 != r1) goto L_0x0031
            goto L_0x0029
        L_0x0023:
            org.spongycastle.crypto.tls.TlsServer r3 = r2.tlsServer
            r1 = 0
            r3.processClientSupplementalData(r1)
        L_0x0029:
            org.spongycastle.crypto.tls.Certificate r3 = org.spongycastle.crypto.tls.Certificate.EMPTY_CHAIN
            r2.notifyClientCertificate(r3)
            r2.connection_state = r0
            return
        L_0x0031:
            org.spongycastle.crypto.tls.TlsFatalAlert r3 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsServerProtocol.handleAlertWarningMessage(short):void");
    }

    /* access modifiers changed from: protected */
    public void notifyClientCertificate(Certificate certificate) throws IOException {
        if (this.certificateRequest == null) {
            throw new IllegalStateException();
        } else if (this.peerCertificate == null) {
            this.peerCertificate = certificate;
            if (certificate.isEmpty()) {
                this.keyExchange.skipClientCredentials();
            } else {
                this.clientCertificateType = TlsUtils.getClientCertificateType(certificate, this.serverCredentials.getCertificate());
                this.keyExchange.processClientCertificate(certificate);
            }
            this.tlsServer.notifyClientCertificate(certificate);
        } else {
            throw new TlsFatalAlert(10);
        }
    }

    /* access modifiers changed from: protected */
    public void receiveCertificateMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        Certificate parse = Certificate.parse(byteArrayInputStream);
        assertEmpty(byteArrayInputStream);
        notifyClientCertificate(parse);
    }

    /* access modifiers changed from: protected */
    public void receiveCertificateVerifyMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        byte[] bArr;
        if (this.certificateRequest != null) {
            DigitallySigned parse = DigitallySigned.parse(getContext(), byteArrayInputStream);
            assertEmpty(byteArrayInputStream);
            try {
                SignatureAndHashAlgorithm algorithm = parse.getAlgorithm();
                if (TlsUtils.isTLSv12(getContext())) {
                    TlsUtils.verifySupportedSignatureAlgorithm(this.certificateRequest.getSupportedSignatureAlgorithms(), algorithm);
                    bArr = this.prepareFinishHash.getFinalHash(algorithm.getHash());
                } else {
                    bArr = this.securityParameters.getSessionHash();
                }
                AsymmetricKeyParameter createKey = PublicKeyFactory.createKey(this.peerCertificate.getCertificateAt(0).getSubjectPublicKeyInfo());
                TlsSigner createTlsSigner = TlsUtils.createTlsSigner(this.clientCertificateType);
                createTlsSigner.init(getContext());
                if (!createTlsSigner.verifyRawSignature(algorithm, parse.getSignature(), createKey, bArr)) {
                    throw new TlsFatalAlert(51);
                }
            } catch (TlsFatalAlert e) {
                throw e;
            } catch (Exception e2) {
                throw new TlsFatalAlert(51, e2);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: protected */
    public void receiveClientHelloMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        ProtocolVersion readVersion = TlsUtils.readVersion(byteArrayInputStream);
        this.recordStream.setWriteVersion(readVersion);
        if (!readVersion.isDTLS()) {
            byte[] readFully = TlsUtils.readFully(32, byteArrayInputStream);
            if (TlsUtils.readOpaque8(byteArrayInputStream).length <= 32) {
                int readUint16 = TlsUtils.readUint16(byteArrayInputStream);
                if (readUint16 < 2 || (readUint16 & 1) != 0) {
                    throw new TlsFatalAlert(50);
                }
                this.offeredCipherSuites = TlsUtils.readUint16Array(readUint16 / 2, byteArrayInputStream);
                short readUint8 = TlsUtils.readUint8(byteArrayInputStream);
                if (readUint8 >= 1) {
                    this.offeredCompressionMethods = TlsUtils.readUint8Array(readUint8, byteArrayInputStream);
                    this.clientExtensions = readExtensions(byteArrayInputStream);
                    this.securityParameters.extendedMasterSecret = TlsExtensionsUtils.hasExtendedMasterSecretExtension(this.clientExtensions);
                    getContextAdmin().setClientVersion(readVersion);
                    this.tlsServer.notifyClientVersion(readVersion);
                    this.tlsServer.notifyFallback(Arrays.contains(this.offeredCipherSuites, (int) CipherSuite.TLS_FALLBACK_SCSV));
                    this.securityParameters.clientRandom = readFully;
                    this.tlsServer.notifyOfferedCipherSuites(this.offeredCipherSuites);
                    this.tlsServer.notifyOfferedCompressionMethods(this.offeredCompressionMethods);
                    if (Arrays.contains(this.offeredCipherSuites, 255)) {
                        this.secure_renegotiation = true;
                    }
                    byte[] extensionData = TlsUtils.getExtensionData(this.clientExtensions, EXT_RenegotiationInfo);
                    if (extensionData != null) {
                        this.secure_renegotiation = true;
                        if (!Arrays.constantTimeAreEqual(extensionData, createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                            throw new TlsFatalAlert(40);
                        }
                    }
                    this.tlsServer.notifySecureRenegotiation(this.secure_renegotiation);
                    if (this.clientExtensions != null) {
                        TlsExtensionsUtils.getPaddingExtension(this.clientExtensions);
                        this.tlsServer.processClientExtensions(this.clientExtensions);
                        return;
                    }
                    return;
                }
                throw new TlsFatalAlert(47);
            }
            throw new TlsFatalAlert(47);
        }
        throw new TlsFatalAlert(47);
    }

    /* access modifiers changed from: protected */
    public void receiveClientKeyExchangeMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        this.keyExchange.processClientKeyExchange(byteArrayInputStream);
        assertEmpty(byteArrayInputStream);
        if (TlsUtils.isSSL(getContext())) {
            establishMasterSecret(getContext(), this.keyExchange);
        }
        this.prepareFinishHash = this.recordStream.prepareToFinish();
        this.securityParameters.sessionHash = getCurrentPRFHash(getContext(), this.prepareFinishHash, null);
        if (!TlsUtils.isSSL(getContext())) {
            establishMasterSecret(getContext(), this.keyExchange);
        }
        this.recordStream.setPendingConnectionState(getPeer().getCompression(), getPeer().getCipher());
        if (!this.expectSessionTicket) {
            sendChangeCipherSpecMessage();
        }
    }

    /* access modifiers changed from: protected */
    public void sendCertificateRequestMessage(CertificateRequest certificateRequest2) throws IOException {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, 13);
        certificateRequest2.encode(handshakeMessage);
        handshakeMessage.writeToRecordStream();
    }

    /* access modifiers changed from: protected */
    public void sendCertificateStatusMessage(CertificateStatus certificateStatus) throws IOException {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, 22);
        certificateStatus.encode(handshakeMessage);
        handshakeMessage.writeToRecordStream();
    }

    /* access modifiers changed from: protected */
    public void sendNewSessionTicketMessage(NewSessionTicket newSessionTicket) throws IOException {
        if (newSessionTicket != 0) {
            TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, 4);
            newSessionTicket.encode(handshakeMessage);
            handshakeMessage.writeToRecordStream();
            return;
        }
        throw new TlsFatalAlert(80);
    }

    /* access modifiers changed from: protected */
    public void sendServerHelloMessage() throws IOException {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, 2);
        ProtocolVersion serverVersion = this.tlsServer.getServerVersion();
        if (serverVersion.isEqualOrEarlierVersionOf(getContext().getClientVersion())) {
            this.recordStream.setReadVersion(serverVersion);
            this.recordStream.setWriteVersion(serverVersion);
            boolean z = true;
            this.recordStream.setRestrictReadVersion(true);
            getContextAdmin().setServerVersion(serverVersion);
            TlsUtils.writeVersion(serverVersion, handshakeMessage);
            handshakeMessage.write(this.securityParameters.serverRandom);
            TlsUtils.writeOpaque8(TlsUtils.EMPTY_BYTES, handshakeMessage);
            int selectedCipherSuite = this.tlsServer.getSelectedCipherSuite();
            if (!Arrays.contains(this.offeredCipherSuites, selectedCipherSuite) || selectedCipherSuite == 0 || CipherSuite.isSCSV(selectedCipherSuite) || !TlsUtils.isValidCipherSuiteForVersion(selectedCipherSuite, getContext().getServerVersion())) {
                throw new TlsFatalAlert(80);
            }
            this.securityParameters.cipherSuite = selectedCipherSuite;
            short selectedCompressionMethod = this.tlsServer.getSelectedCompressionMethod();
            if (Arrays.contains(this.offeredCompressionMethods, selectedCompressionMethod)) {
                this.securityParameters.compressionAlgorithm = selectedCompressionMethod;
                TlsUtils.writeUint16(selectedCipherSuite, handshakeMessage);
                TlsUtils.writeUint8(selectedCompressionMethod, (OutputStream) handshakeMessage);
                this.serverExtensions = this.tlsServer.getServerExtensions();
                if (this.secure_renegotiation) {
                    if (TlsUtils.getExtensionData(this.serverExtensions, EXT_RenegotiationInfo) == null) {
                        this.serverExtensions = TlsExtensionsUtils.ensureExtensionsInitialised(this.serverExtensions);
                        this.serverExtensions.put(EXT_RenegotiationInfo, createRenegotiationInfo(TlsUtils.EMPTY_BYTES));
                    }
                }
                if (this.securityParameters.extendedMasterSecret) {
                    this.serverExtensions = TlsExtensionsUtils.ensureExtensionsInitialised(this.serverExtensions);
                    TlsExtensionsUtils.addExtendedMasterSecretExtension(this.serverExtensions);
                }
                if (this.serverExtensions != null) {
                    this.securityParameters.encryptThenMAC = TlsExtensionsUtils.hasEncryptThenMACExtension(this.serverExtensions);
                    this.securityParameters.maxFragmentLength = processMaxFragmentLengthExtension(this.clientExtensions, this.serverExtensions, 80);
                    this.securityParameters.truncatedHMac = TlsExtensionsUtils.hasTruncatedHMacExtension(this.serverExtensions);
                    this.allowCertificateStatus = !this.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(this.serverExtensions, TlsExtensionsUtils.EXT_status_request, 80);
                    if (this.resumedSession || !TlsUtils.hasExpectedEmptyExtensionData(this.serverExtensions, TlsProtocol.EXT_SessionTicket, 80)) {
                        z = false;
                    }
                    this.expectSessionTicket = z;
                    writeExtensions(handshakeMessage, this.serverExtensions);
                }
                this.securityParameters.prfAlgorithm = getPRFAlgorithm(getContext(), this.securityParameters.getCipherSuite());
                this.securityParameters.verifyDataLength = 12;
                applyMaxFragmentLengthExtension();
                handshakeMessage.writeToRecordStream();
                return;
            }
            throw new TlsFatalAlert(80);
        }
        throw new TlsFatalAlert(80);
    }

    /* access modifiers changed from: protected */
    public void sendServerHelloDoneMessage() throws IOException {
        byte[] bArr = new byte[4];
        TlsUtils.writeUint8((short) 14, bArr, 0);
        TlsUtils.writeUint24(0, bArr, 1);
        writeHandshakeMessage(bArr, 0, 4);
    }

    /* access modifiers changed from: protected */
    public void sendServerKeyExchangeMessage(byte[] bArr) throws IOException {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(12, bArr.length);
        handshakeMessage.write(bArr);
        handshakeMessage.writeToRecordStream();
    }

    /* access modifiers changed from: protected */
    public boolean expectCertificateVerifyMessage() {
        short s = this.clientCertificateType;
        return s >= 0 && TlsUtils.hasSigningCapability(s);
    }
}
