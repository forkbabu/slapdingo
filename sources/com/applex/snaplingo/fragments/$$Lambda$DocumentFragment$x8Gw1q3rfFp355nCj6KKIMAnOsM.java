package com.applex.snaplingo.fragments;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.applex.snaplingo.fragments.-$$Lambda$DocumentFragment$x8Gw1q3rfFp355nCj6KKIMAnOsM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DocumentFragment$x8Gw1q3rfFp355nCj6KKIMAnOsM implements Comparator {
    public static final /* synthetic */ $$Lambda$DocumentFragment$x8Gw1q3rfFp355nCj6KKIMAnOsM INSTANCE = new $$Lambda$DocumentFragment$x8Gw1q3rfFp355nCj6KKIMAnOsM();

    private /* synthetic */ $$Lambda$DocumentFragment$x8Gw1q3rfFp355nCj6KKIMAnOsM() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return String.valueOf(((File) obj).lastModified()).compareTo(String.valueOf(((File) obj2).lastModified()));
    }
}
