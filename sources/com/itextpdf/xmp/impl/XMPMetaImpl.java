package com.itextpdf.xmp.impl;

import com.itextpdf.xmp.XMPConst;
import com.itextpdf.xmp.XMPDateTime;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPIterator;
import com.itextpdf.xmp.XMPMeta;
import com.itextpdf.xmp.XMPPathFactory;
import com.itextpdf.xmp.XMPUtils;
import com.itextpdf.xmp.impl.xpath.XMPPath;
import com.itextpdf.xmp.impl.xpath.XMPPathParser;
import com.itextpdf.xmp.options.IteratorOptions;
import com.itextpdf.xmp.options.ParseOptions;
import com.itextpdf.xmp.options.PropertyOptions;
import com.itextpdf.xmp.properties.XMPProperty;
import java.util.Calendar;

public class XMPMetaImpl implements XMPMeta, XMPConst {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int VALUE_BASE64 = 7;
    private static final int VALUE_BOOLEAN = 1;
    private static final int VALUE_CALENDAR = 6;
    private static final int VALUE_DATE = 5;
    private static final int VALUE_DOUBLE = 4;
    private static final int VALUE_INTEGER = 2;
    private static final int VALUE_LONG = 3;
    private static final int VALUE_STRING = 0;
    private String packetHeader;
    private XMPNode tree;

    public XMPMetaImpl() {
        this.packetHeader = null;
        this.tree = new XMPNode(null, null, null);
    }

    public XMPMetaImpl(XMPNode xMPNode) {
        this.packetHeader = null;
        this.tree = xMPNode;
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void appendArrayItem(String str, String str2, PropertyOptions propertyOptions, String str3, PropertyOptions propertyOptions2) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        if (propertyOptions == null) {
            propertyOptions = new PropertyOptions();
        }
        if (propertyOptions.isOnlyArrayOptions()) {
            PropertyOptions verifySetOptions = XMPNodeUtils.verifySetOptions(propertyOptions, null);
            XMPPath expandXPath = XMPPathParser.expandXPath(str, str2);
            XMPNode findNode = XMPNodeUtils.findNode(this.tree, expandXPath, false, null);
            if (findNode != null) {
                if (!findNode.getOptions().isArray()) {
                    throw new XMPException("The named property is not an array", 102);
                }
            } else if (verifySetOptions.isArray()) {
                findNode = XMPNodeUtils.findNode(this.tree, expandXPath, true, verifySetOptions);
                if (findNode == null) {
                    throw new XMPException("Failure creating array node", 102);
                }
            } else {
                throw new XMPException("Explicit arrayOptions required to create new array", 103);
            }
            doSetArrayItem(findNode, -1, str3, propertyOptions2, true);
            return;
        }
        throw new XMPException("Only array form flags allowed for arrayOptions", 103);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void appendArrayItem(String str, String str2, String str3) throws XMPException {
        appendArrayItem(str, str2, null, str3, null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public int countArrayItems(String str, String str2) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, null);
        if (findNode == null) {
            return 0;
        }
        if (findNode.getOptions().isArray()) {
            return findNode.getChildrenLength();
        }
        throw new XMPException("The named property is not an array", 102);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void deleteArrayItem(String str, String str2, int i) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertArrayName(str2);
            deleteProperty(str, XMPPathFactory.composeArrayItemPath(str2, i));
        } catch (XMPException unused) {
        }
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void deleteProperty(String str, String str2) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertPropName(str2);
            XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, null);
            if (findNode != null) {
                XMPNodeUtils.deleteNode(findNode);
            }
        } catch (XMPException unused) {
        }
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void deleteQualifier(String str, String str2, String str3, String str4) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertPropName(str2);
            deleteProperty(str, str2 + XMPPathFactory.composeQualifierPath(str3, str4));
        } catch (XMPException unused) {
        }
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void deleteStructField(String str, String str2, String str3, String str4) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertStructName(str2);
            deleteProperty(str, str2 + XMPPathFactory.composeStructFieldPath(str3, str4));
        } catch (XMPException unused) {
        }
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public boolean doesPropertyExist(String str, String str2) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertPropName(str2);
            if (XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, null) != null) {
                return true;
            }
            return false;
        } catch (XMPException unused) {
            return false;
        }
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public boolean doesArrayItemExist(String str, String str2, int i) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertArrayName(str2);
            return doesPropertyExist(str, XMPPathFactory.composeArrayItemPath(str2, i));
        } catch (XMPException unused) {
            return false;
        }
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public boolean doesStructFieldExist(String str, String str2, String str3, String str4) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertStructName(str2);
            String composeStructFieldPath = XMPPathFactory.composeStructFieldPath(str3, str4);
            return doesPropertyExist(str, str2 + composeStructFieldPath);
        } catch (XMPException unused) {
            return false;
        }
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public boolean doesQualifierExist(String str, String str2, String str3, String str4) {
        try {
            ParameterAsserts.assertSchemaNS(str);
            ParameterAsserts.assertPropName(str2);
            String composeQualifierPath = XMPPathFactory.composeQualifierPath(str3, str4);
            return doesPropertyExist(str, str2 + composeQualifierPath);
        } catch (XMPException unused) {
            return false;
        }
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public XMPProperty getArrayItem(String str, String str2, int i) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        return getProperty(str, XMPPathFactory.composeArrayItemPath(str2, i));
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public XMPProperty getLocalizedText(String str, String str2, String str3, String str4) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        ParameterAsserts.assertSpecificLang(str4);
        String normalizeLangValue = str3 != null ? Utils.normalizeLangValue(str3) : null;
        String normalizeLangValue2 = Utils.normalizeLangValue(str4);
        XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, null);
        if (findNode == null) {
            return null;
        }
        Object[] chooseLocalizedText = XMPNodeUtils.chooseLocalizedText(findNode, normalizeLangValue, normalizeLangValue2);
        int intValue = ((Integer) chooseLocalizedText[0]).intValue();
        final XMPNode xMPNode = (XMPNode) chooseLocalizedText[1];
        if (intValue != 0) {
            return new XMPProperty() {
                /* class com.itextpdf.xmp.impl.XMPMetaImpl.AnonymousClass1 */

                @Override // com.itextpdf.xmp.properties.XMPProperty
                public String getValue() {
                    return xMPNode.getValue();
                }

                @Override // com.itextpdf.xmp.properties.XMPProperty
                public PropertyOptions getOptions() {
                    return xMPNode.getOptions();
                }

                @Override // com.itextpdf.xmp.properties.XMPProperty
                public String getLanguage() {
                    return xMPNode.getQualifier(1).getValue();
                }

                public String toString() {
                    return xMPNode.getValue().toString();
                }
            };
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        if (r2 == null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a1, code lost:
        if (r8.getChildrenLength() <= 1) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a3, code lost:
        r8.removeChild(r2);
        r8.addChild(1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a9, code lost:
        r10 = com.itextpdf.xmp.impl.XMPNodeUtils.chooseLocalizedText(r8, r10, r11);
        r0 = ((java.lang.Integer) r10[0]).intValue();
        r10 = (com.itextpdf.xmp.impl.XMPNode) r10[1];
        r3 = "x-default".equals(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bd, code lost:
        if (r0 == 0) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bf, code lost:
        if (r0 == 1) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c2, code lost:
        if (r0 == 2) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c5, code lost:
        if (r0 == 3) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c8, code lost:
        if (r0 == 4) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cb, code lost:
        if (r0 != 5) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cd, code lost:
        com.itextpdf.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d0, code lost:
        if (r3 == false) goto L_0x0165;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00dd, code lost:
        throw new com.itextpdf.xmp.XMPException("Unexpected result from ChooseLocalizedText", 9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00de, code lost:
        if (r2 == null) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e4, code lost:
        if (r8.getChildrenLength() != 1) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e6, code lost:
        r2.setValue(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e9, code lost:
        com.itextpdf.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ee, code lost:
        com.itextpdf.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f1, code lost:
        if (r3 == false) goto L_0x0165;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f5, code lost:
        if (r9 == false) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f7, code lost:
        if (r2 == r10) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f9, code lost:
        if (r2 == null) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0107, code lost:
        if (r2.getValue().equals(r10.getValue()) == false) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0109, code lost:
        r2.setValue(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010c, code lost:
        r10.setValue(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0110, code lost:
        if (r3 != false) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0112, code lost:
        if (r9 == false) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0114, code lost:
        if (r2 == r10) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0116, code lost:
        if (r2 == null) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0124, code lost:
        if (r2.getValue().equals(r10.getValue()) == false) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0126, code lost:
        r2.setValue(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0129, code lost:
        r10.setValue(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x012d, code lost:
        r10 = r8.iterateChildren();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0135, code lost:
        if (r10.hasNext() == false) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0137, code lost:
        r11 = (com.itextpdf.xmp.impl.XMPNode) r10.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x013d, code lost:
        if (r11 == r2) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x013f, code lost:
        r0 = r11.getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0143, code lost:
        if (r2 == null) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0145, code lost:
        r3 = r2.getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x014a, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x014f, code lost:
        if (r0.equals(r3) != false) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0152, code lost:
        r11.setValue(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0156, code lost:
        if (r2 == null) goto L_0x0165;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0158, code lost:
        r2.setValue(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x015c, code lost:
        com.itextpdf.xmp.impl.XMPNodeUtils.appendLangItem(r8, "x-default", r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x015f, code lost:
        if (r3 != false) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0161, code lost:
        com.itextpdf.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0164, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0165, code lost:
        if (r9 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x016b, code lost:
        if (r8.getChildrenLength() != 1) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x016d, code lost:
        com.itextpdf.xmp.impl.XMPNodeUtils.appendLangItem(r8, "x-default", r12);
     */
    @Override // com.itextpdf.xmp.XMPMeta
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setLocalizedText(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, com.itextpdf.xmp.options.PropertyOptions r13) throws com.itextpdf.xmp.XMPException {
        /*
            r7 = this;
            com.itextpdf.xmp.impl.ParameterAsserts.assertSchemaNS(r8)
            com.itextpdf.xmp.impl.ParameterAsserts.assertArrayName(r9)
            com.itextpdf.xmp.impl.ParameterAsserts.assertSpecificLang(r11)
            r13 = 0
            if (r10 == 0) goto L_0x0011
            java.lang.String r10 = com.itextpdf.xmp.impl.Utils.normalizeLangValue(r10)
            goto L_0x0012
        L_0x0011:
            r10 = r13
        L_0x0012:
            java.lang.String r11 = com.itextpdf.xmp.impl.Utils.normalizeLangValue(r11)
            com.itextpdf.xmp.impl.xpath.XMPPath r8 = com.itextpdf.xmp.impl.xpath.XMPPathParser.expandXPath(r8, r9)
            com.itextpdf.xmp.impl.XMPNode r9 = r7.tree
            com.itextpdf.xmp.options.PropertyOptions r0 = new com.itextpdf.xmp.options.PropertyOptions
            r1 = 7680(0x1e00, float:1.0762E-41)
            r0.<init>(r1)
            r1 = 1
            com.itextpdf.xmp.impl.XMPNode r8 = com.itextpdf.xmp.impl.XMPNodeUtils.findNode(r9, r8, r1, r0)
            r9 = 102(0x66, float:1.43E-43)
            if (r8 == 0) goto L_0x0171
            com.itextpdf.xmp.options.PropertyOptions r0 = r8.getOptions()
            boolean r0 = r0.isArrayAltText()
            if (r0 != 0) goto L_0x0056
            boolean r0 = r8.hasChildren()
            if (r0 != 0) goto L_0x004e
            com.itextpdf.xmp.options.PropertyOptions r0 = r8.getOptions()
            boolean r0 = r0.isArrayAlternate()
            if (r0 == 0) goto L_0x004e
            com.itextpdf.xmp.options.PropertyOptions r0 = r8.getOptions()
            r0.setArrayAltText(r1)
            goto L_0x0056
        L_0x004e:
            com.itextpdf.xmp.XMPException r8 = new com.itextpdf.xmp.XMPException
            java.lang.String r10 = "Specified property is no alt-text array"
            r8.<init>(r10, r9)
            throw r8
        L_0x0056:
            java.util.Iterator r0 = r8.iterateChildren()
        L_0x005a:
            boolean r2 = r0.hasNext()
            r3 = 0
            java.lang.String r4 = "x-default"
            if (r2 == 0) goto L_0x0099
            java.lang.Object r2 = r0.next()
            com.itextpdf.xmp.impl.XMPNode r2 = (com.itextpdf.xmp.impl.XMPNode) r2
            boolean r5 = r2.hasQualifier()
            if (r5 == 0) goto L_0x0091
            com.itextpdf.xmp.impl.XMPNode r5 = r2.getQualifier(r1)
            java.lang.String r5 = r5.getName()
            java.lang.String r6 = "xml:lang"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0091
            com.itextpdf.xmp.impl.XMPNode r5 = r2.getQualifier(r1)
            java.lang.String r5 = r5.getValue()
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x005a
            r9 = 1
            goto L_0x009b
        L_0x0091:
            com.itextpdf.xmp.XMPException r8 = new com.itextpdf.xmp.XMPException
            java.lang.String r10 = "Language qualifier must be first"
            r8.<init>(r10, r9)
            throw r8
        L_0x0099:
            r2 = r13
            r9 = 0
        L_0x009b:
            if (r2 == 0) goto L_0x00a9
            int r0 = r8.getChildrenLength()
            if (r0 <= r1) goto L_0x00a9
            r8.removeChild(r2)
            r8.addChild(r1, r2)
        L_0x00a9:
            java.lang.Object[] r10 = com.itextpdf.xmp.impl.XMPNodeUtils.chooseLocalizedText(r8, r10, r11)
            r0 = r10[r3]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r10 = r10[r1]
            com.itextpdf.xmp.impl.XMPNode r10 = (com.itextpdf.xmp.impl.XMPNode) r10
            boolean r3 = r4.equals(r11)
            if (r0 == 0) goto L_0x015c
            if (r0 == r1) goto L_0x0110
            r13 = 2
            if (r0 == r13) goto L_0x00f5
            r10 = 3
            if (r0 == r10) goto L_0x00ee
            r10 = 4
            if (r0 == r10) goto L_0x00de
            r10 = 5
            if (r0 != r10) goto L_0x00d4
            com.itextpdf.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12)
            if (r3 == 0) goto L_0x0165
            goto L_0x0164
        L_0x00d4:
            com.itextpdf.xmp.XMPException r8 = new com.itextpdf.xmp.XMPException
            r9 = 9
            java.lang.String r10 = "Unexpected result from ChooseLocalizedText"
            r8.<init>(r10, r9)
            throw r8
        L_0x00de:
            if (r2 == 0) goto L_0x00e9
            int r10 = r8.getChildrenLength()
            if (r10 != r1) goto L_0x00e9
            r2.setValue(r12)
        L_0x00e9:
            com.itextpdf.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12)
            goto L_0x0165
        L_0x00ee:
            com.itextpdf.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12)
            if (r3 == 0) goto L_0x0165
            goto L_0x0164
        L_0x00f5:
            if (r9 == 0) goto L_0x010c
            if (r2 == r10) goto L_0x010c
            if (r2 == 0) goto L_0x010c
            java.lang.String r11 = r2.getValue()
            java.lang.String r13 = r10.getValue()
            boolean r11 = r11.equals(r13)
            if (r11 == 0) goto L_0x010c
            r2.setValue(r12)
        L_0x010c:
            r10.setValue(r12)
            goto L_0x0165
        L_0x0110:
            if (r3 != 0) goto L_0x012d
            if (r9 == 0) goto L_0x0129
            if (r2 == r10) goto L_0x0129
            if (r2 == 0) goto L_0x0129
            java.lang.String r11 = r2.getValue()
            java.lang.String r13 = r10.getValue()
            boolean r11 = r11.equals(r13)
            if (r11 == 0) goto L_0x0129
            r2.setValue(r12)
        L_0x0129:
            r10.setValue(r12)
            goto L_0x0165
        L_0x012d:
            java.util.Iterator r10 = r8.iterateChildren()
        L_0x0131:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0156
            java.lang.Object r11 = r10.next()
            com.itextpdf.xmp.impl.XMPNode r11 = (com.itextpdf.xmp.impl.XMPNode) r11
            if (r11 == r2) goto L_0x0131
            java.lang.String r0 = r11.getValue()
            if (r2 == 0) goto L_0x014a
            java.lang.String r3 = r2.getValue()
            goto L_0x014b
        L_0x014a:
            r3 = r13
        L_0x014b:
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0152
            goto L_0x0131
        L_0x0152:
            r11.setValue(r12)
            goto L_0x0131
        L_0x0156:
            if (r2 == 0) goto L_0x0165
            r2.setValue(r12)
            goto L_0x0165
        L_0x015c:
            com.itextpdf.xmp.impl.XMPNodeUtils.appendLangItem(r8, r4, r12)
            if (r3 != 0) goto L_0x0164
            com.itextpdf.xmp.impl.XMPNodeUtils.appendLangItem(r8, r11, r12)
        L_0x0164:
            r9 = 1
        L_0x0165:
            if (r9 != 0) goto L_0x0170
            int r9 = r8.getChildrenLength()
            if (r9 != r1) goto L_0x0170
            com.itextpdf.xmp.impl.XMPNodeUtils.appendLangItem(r8, r4, r12)
        L_0x0170:
            return
        L_0x0171:
            com.itextpdf.xmp.XMPException r8 = new com.itextpdf.xmp.XMPException
            java.lang.String r10 = "Failed to find or create array node"
            r8.<init>(r10, r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.xmp.impl.XMPMetaImpl.setLocalizedText(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.itextpdf.xmp.options.PropertyOptions):void");
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setLocalizedText(String str, String str2, String str3, String str4, String str5) throws XMPException {
        setLocalizedText(str, str2, str3, str4, str5, null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public XMPProperty getProperty(String str, String str2) throws XMPException {
        return getProperty(str, str2, 0);
    }

    /* access modifiers changed from: protected */
    public XMPProperty getProperty(String str, String str2, int i) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertPropName(str2);
        final XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, null);
        if (findNode == null) {
            return null;
        }
        if (i == 0 || !findNode.getOptions().isCompositeProperty()) {
            final Object evaluateNodeValue = evaluateNodeValue(i, findNode);
            return new XMPProperty() {
                /* class com.itextpdf.xmp.impl.XMPMetaImpl.AnonymousClass2 */

                @Override // com.itextpdf.xmp.properties.XMPProperty
                public String getLanguage() {
                    return null;
                }

                @Override // com.itextpdf.xmp.properties.XMPProperty
                public String getValue() {
                    Object obj = evaluateNodeValue;
                    if (obj != null) {
                        return obj.toString();
                    }
                    return null;
                }

                @Override // com.itextpdf.xmp.properties.XMPProperty
                public PropertyOptions getOptions() {
                    return findNode.getOptions();
                }

                public String toString() {
                    return evaluateNodeValue.toString();
                }
            };
        }
        throw new XMPException("Property must be simple when a value type is requested", 102);
    }

    /* access modifiers changed from: protected */
    public Object getPropertyObject(String str, String str2, int i) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertPropName(str2);
        XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, null);
        if (findNode == null) {
            return null;
        }
        if (i == 0 || !findNode.getOptions().isCompositeProperty()) {
            return evaluateNodeValue(i, findNode);
        }
        throw new XMPException("Property must be simple when a value type is requested", 102);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public Boolean getPropertyBoolean(String str, String str2) throws XMPException {
        return (Boolean) getPropertyObject(str, str2, 1);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setPropertyBoolean(String str, String str2, boolean z, PropertyOptions propertyOptions) throws XMPException {
        setProperty(str, str2, z ? XMPConst.TRUESTR : XMPConst.FALSESTR, propertyOptions);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setPropertyBoolean(String str, String str2, boolean z) throws XMPException {
        setProperty(str, str2, z ? XMPConst.TRUESTR : XMPConst.FALSESTR, null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public Integer getPropertyInteger(String str, String str2) throws XMPException {
        return (Integer) getPropertyObject(str, str2, 2);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setPropertyInteger(String str, String str2, int i, PropertyOptions propertyOptions) throws XMPException {
        setProperty(str, str2, new Integer(i), propertyOptions);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setPropertyInteger(String str, String str2, int i) throws XMPException {
        setProperty(str, str2, new Integer(i), null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public Long getPropertyLong(String str, String str2) throws XMPException {
        return (Long) getPropertyObject(str, str2, 3);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setPropertyLong(String str, String str2, long j, PropertyOptions propertyOptions) throws XMPException {
        setProperty(str, str2, new Long(j), propertyOptions);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setPropertyLong(String str, String str2, long j) throws XMPException {
        setProperty(str, str2, new Long(j), null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public Double getPropertyDouble(String str, String str2) throws XMPException {
        return (Double) getPropertyObject(str, str2, 4);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setPropertyDouble(String str, String str2, double d, PropertyOptions propertyOptions) throws XMPException {
        setProperty(str, str2, new Double(d), propertyOptions);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setPropertyDouble(String str, String str2, double d) throws XMPException {
        setProperty(str, str2, new Double(d), null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public XMPDateTime getPropertyDate(String str, String str2) throws XMPException {
        return (XMPDateTime) getPropertyObject(str, str2, 5);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setPropertyDate(String str, String str2, XMPDateTime xMPDateTime, PropertyOptions propertyOptions) throws XMPException {
        setProperty(str, str2, xMPDateTime, propertyOptions);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setPropertyDate(String str, String str2, XMPDateTime xMPDateTime) throws XMPException {
        setProperty(str, str2, xMPDateTime, null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public Calendar getPropertyCalendar(String str, String str2) throws XMPException {
        return (Calendar) getPropertyObject(str, str2, 6);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setPropertyCalendar(String str, String str2, Calendar calendar, PropertyOptions propertyOptions) throws XMPException {
        setProperty(str, str2, calendar, propertyOptions);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setPropertyCalendar(String str, String str2, Calendar calendar) throws XMPException {
        setProperty(str, str2, calendar, null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public byte[] getPropertyBase64(String str, String str2) throws XMPException {
        return (byte[]) getPropertyObject(str, str2, 7);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public String getPropertyString(String str, String str2) throws XMPException {
        return (String) getPropertyObject(str, str2, 0);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setPropertyBase64(String str, String str2, byte[] bArr, PropertyOptions propertyOptions) throws XMPException {
        setProperty(str, str2, bArr, propertyOptions);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setPropertyBase64(String str, String str2, byte[] bArr) throws XMPException {
        setProperty(str, str2, bArr, null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public XMPProperty getQualifier(String str, String str2, String str3, String str4) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertPropName(str2);
        return getProperty(str, str2 + XMPPathFactory.composeQualifierPath(str3, str4));
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public XMPProperty getStructField(String str, String str2, String str3, String str4) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertStructName(str2);
        return getProperty(str, str2 + XMPPathFactory.composeStructFieldPath(str3, str4));
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public XMPIterator iterator() throws XMPException {
        return iterator(null, null, null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public XMPIterator iterator(IteratorOptions iteratorOptions) throws XMPException {
        return iterator(null, null, iteratorOptions);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public XMPIterator iterator(String str, String str2, IteratorOptions iteratorOptions) throws XMPException {
        return new XMPIteratorImpl(this, str, str2, iteratorOptions);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setArrayItem(String str, String str2, int i, String str3, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, null);
        if (findNode != null) {
            doSetArrayItem(findNode, i, str3, propertyOptions, false);
            return;
        }
        throw new XMPException("Specified array does not exist", 102);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setArrayItem(String str, String str2, int i, String str3) throws XMPException {
        setArrayItem(str, str2, i, str3, null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void insertArrayItem(String str, String str2, int i, String str3, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertArrayName(str2);
        XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), false, null);
        if (findNode != null) {
            doSetArrayItem(findNode, i, str3, propertyOptions, true);
            return;
        }
        throw new XMPException("Specified array does not exist", 102);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void insertArrayItem(String str, String str2, int i, String str3) throws XMPException {
        insertArrayItem(str, str2, i, str3, null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setProperty(String str, String str2, Object obj, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertPropName(str2);
        PropertyOptions verifySetOptions = XMPNodeUtils.verifySetOptions(propertyOptions, obj);
        XMPNode findNode = XMPNodeUtils.findNode(this.tree, XMPPathParser.expandXPath(str, str2), true, verifySetOptions);
        if (findNode != null) {
            setNode(findNode, obj, verifySetOptions, false);
            return;
        }
        throw new XMPException("Specified property does not exist", 102);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setProperty(String str, String str2, Object obj) throws XMPException {
        setProperty(str, str2, obj, null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setQualifier(String str, String str2, String str3, String str4, String str5, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertPropName(str2);
        if (doesPropertyExist(str, str2)) {
            setProperty(str, str2 + XMPPathFactory.composeQualifierPath(str3, str4), str5, propertyOptions);
            return;
        }
        throw new XMPException("Specified property does not exist!", 102);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setQualifier(String str, String str2, String str3, String str4, String str5) throws XMPException {
        setQualifier(str, str2, str3, str4, str5, null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setStructField(String str, String str2, String str3, String str4, String str5, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.assertSchemaNS(str);
        ParameterAsserts.assertStructName(str2);
        setProperty(str, str2 + XMPPathFactory.composeStructFieldPath(str3, str4), str5, propertyOptions);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setStructField(String str, String str2, String str3, String str4, String str5) throws XMPException {
        setStructField(str, str2, str3, str4, str5, null);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public String getObjectName() {
        return this.tree.getName() != null ? this.tree.getName() : "";
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void setObjectName(String str) {
        this.tree.setName(str);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public String getPacketHeader() {
        return this.packetHeader;
    }

    public void setPacketHeader(String str) {
        this.packetHeader = str;
    }

    @Override // com.itextpdf.xmp.XMPMeta, java.lang.Object
    public Object clone() {
        return new XMPMetaImpl((XMPNode) this.tree.clone());
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public String dumpObject() {
        return getRoot().dumpNode(true);
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void sort() {
        this.tree.sort();
    }

    @Override // com.itextpdf.xmp.XMPMeta
    public void normalize(ParseOptions parseOptions) throws XMPException {
        if (parseOptions == null) {
            parseOptions = new ParseOptions();
        }
        XMPNormalizer.process(this, parseOptions);
    }

    public XMPNode getRoot() {
        return this.tree;
    }

    private void doSetArrayItem(XMPNode xMPNode, int i, String str, PropertyOptions propertyOptions, boolean z) throws XMPException {
        XMPNode xMPNode2 = new XMPNode(XMPConst.ARRAY_ITEM_NAME, null);
        PropertyOptions verifySetOptions = XMPNodeUtils.verifySetOptions(propertyOptions, str);
        int childrenLength = xMPNode.getChildrenLength();
        if (z) {
            childrenLength++;
        }
        if (i == -1) {
            i = childrenLength;
        }
        if (1 > i || i > childrenLength) {
            throw new XMPException("Array index out of bounds", 104);
        }
        if (!z) {
            xMPNode.removeChild(i);
        }
        xMPNode.addChild(i, xMPNode2);
        setNode(xMPNode2, str, verifySetOptions, false);
    }

    /* access modifiers changed from: package-private */
    public void setNode(XMPNode xMPNode, Object obj, PropertyOptions propertyOptions, boolean z) throws XMPException {
        if (z) {
            xMPNode.clear();
        }
        xMPNode.getOptions().mergeWith(propertyOptions);
        if (!xMPNode.getOptions().isCompositeProperty()) {
            XMPNodeUtils.setNodeValue(xMPNode, obj);
        } else if (obj == null || obj.toString().length() <= 0) {
            xMPNode.removeChildren();
        } else {
            throw new XMPException("Composite nodes can't have values", 102);
        }
    }

    private Object evaluateNodeValue(int i, XMPNode xMPNode) throws XMPException {
        String value = xMPNode.getValue();
        switch (i) {
            case 1:
                return new Boolean(XMPUtils.convertToBoolean(value));
            case 2:
                return new Integer(XMPUtils.convertToInteger(value));
            case 3:
                return new Long(XMPUtils.convertToLong(value));
            case 4:
                return new Double(XMPUtils.convertToDouble(value));
            case 5:
                return XMPUtils.convertToDate(value);
            case 6:
                return XMPUtils.convertToDate(value).getCalendar();
            case 7:
                return XMPUtils.decodeBase64(value);
            default:
                if (value == null && !xMPNode.getOptions().isCompositeProperty()) {
                    value = "";
                }
                return value;
        }
    }
}
