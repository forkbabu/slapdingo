package com.zhihu.matisse.filter;

import android.content.Context;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.IncapableCause;
import com.zhihu.matisse.internal.entity.Item;
import java.util.Set;

public abstract class Filter {
    public static final int K = 1024;
    public static final int MAX = Integer.MAX_VALUE;
    public static final int MIN = 0;

    /* access modifiers changed from: protected */
    public abstract Set<MimeType> constraintTypes();

    public abstract IncapableCause filter(Context context, Item item);

    /* access modifiers changed from: protected */
    public boolean needFiltering(Context context, Item item) {
        for (MimeType mimeType : constraintTypes()) {
            if (mimeType.checkType(context.getContentResolver(), item.getContentUri())) {
                return true;
            }
        }
        return false;
    }
}
