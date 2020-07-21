package com.itextpdf.xmp.properties;

import com.itextpdf.xmp.options.PropertyOptions;

public interface XMPPropertyInfo extends XMPProperty {
    String getNamespace();

    @Override // com.itextpdf.xmp.properties.XMPProperty
    PropertyOptions getOptions();

    String getPath();

    @Override // com.itextpdf.xmp.properties.XMPProperty
    String getValue();
}
