package androidx.core.content;

import com.applex.snaplingo.util.Constants;
import java.util.ArrayList;

public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    private static boolean mimeTypeAgainstFilter(String[] strArr, String[] strArr2) {
        if (strArr2.length != 2) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        } else if (strArr2[0].isEmpty() || strArr2[1].isEmpty()) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
        } else if (strArr.length != 2) {
            return false;
        } else {
            if (!"*".equals(strArr2[0]) && !strArr2[0].equals(strArr[0])) {
                return false;
            }
            if ("*".equals(strArr2[1]) || strArr2[1].equals(strArr[1])) {
                return true;
            }
            return false;
        }
    }

    public static boolean matches(String str, String str2) {
        if (str == null) {
            return false;
        }
        return mimeTypeAgainstFilter(str.split(Constants.PATH_SEPERATOR), str2.split(Constants.PATH_SEPERATOR));
    }

    public static String matches(String str, String[] strArr) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(Constants.PATH_SEPERATOR);
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(split, str2.split(Constants.PATH_SEPERATOR))) {
                return str2;
            }
        }
        return null;
    }

    public static String matches(String[] strArr, String str) {
        if (strArr == null) {
            return null;
        }
        String[] split = str.split(Constants.PATH_SEPERATOR);
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(str2.split(Constants.PATH_SEPERATOR), split)) {
                return str2;
            }
        }
        return null;
    }

    public static String[] matchesMany(String[] strArr, String str) {
        if (strArr == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        String[] split = str.split(Constants.PATH_SEPERATOR);
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(str2.split(Constants.PATH_SEPERATOR), split)) {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
