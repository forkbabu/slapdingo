package com.applex.snaplingo.fragments;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.applex.snaplingo.fragments.-$$Lambda$DocumentFragment$Mmura9_bAMuSpRCcL9Tnn_BG2G4  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DocumentFragment$Mmura9_bAMuSpRCcL9Tnn_BG2G4 implements Comparator {
    public static final /* synthetic */ $$Lambda$DocumentFragment$Mmura9_bAMuSpRCcL9Tnn_BG2G4 INSTANCE = new $$Lambda$DocumentFragment$Mmura9_bAMuSpRCcL9Tnn_BG2G4();

    private /* synthetic */ $$Lambda$DocumentFragment$Mmura9_bAMuSpRCcL9Tnn_BG2G4() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((File) obj).getName().compareTo(((File) obj2).getName());
    }
}
