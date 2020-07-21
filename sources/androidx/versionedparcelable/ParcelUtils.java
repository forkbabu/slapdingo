package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParcelUtils {
    private static final String INNER_BUNDLE_KEY = "a";

    private ParcelUtils() {
    }

    public static Parcelable toParcelable(VersionedParcelable versionedParcelable) {
        return new ParcelImpl(versionedParcelable);
    }

    public static <T extends VersionedParcelable> T fromParcelable(Parcelable parcelable) {
        if (parcelable instanceof ParcelImpl) {
            return ((ParcelImpl) parcelable).getVersionedParcel();
        }
        throw new IllegalArgumentException("Invalid parcel");
    }

    public static void toOutputStream(VersionedParcelable versionedParcelable, OutputStream outputStream) {
        VersionedParcelStream versionedParcelStream = new VersionedParcelStream(null, outputStream);
        versionedParcelStream.writeVersionedParcelable(versionedParcelable);
        versionedParcelStream.closeField();
    }

    public static <T extends VersionedParcelable> T fromInputStream(InputStream inputStream) {
        return new VersionedParcelStream(inputStream, null).readVersionedParcelable();
    }

    public static void putVersionedParcelable(Bundle bundle, String str, VersionedParcelable versionedParcelable) {
        if (versionedParcelable != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("a", toParcelable(versionedParcelable));
            bundle.putParcelable(str, bundle2);
        }
    }

    public static <T extends VersionedParcelable> T getVersionedParcelable(Bundle bundle, String str) {
        try {
            T parcelable = bundle.getParcelable(str);
            if (parcelable == null) {
                return null;
            }
            parcelable.setClassLoader(ParcelUtils.class.getClassLoader());
            return fromParcelable(parcelable.getParcelable("a"));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static void putVersionedParcelableList(Bundle bundle, String str, List<? extends VersionedParcelable> list) {
        Bundle bundle2 = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (VersionedParcelable versionedParcelable : list) {
            arrayList.add(toParcelable(versionedParcelable));
        }
        bundle2.putParcelableArrayList("a", arrayList);
        bundle.putParcelable(str, bundle2);
    }

    public static <T extends VersionedParcelable> List<T> getVersionedParcelableList(Bundle bundle, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            T parcelable = bundle.getParcelable(str);
            parcelable.setClassLoader(ParcelUtils.class.getClassLoader());
            Iterator<T> it2 = parcelable.getParcelableArrayList("a").iterator();
            while (it2.hasNext()) {
                arrayList.add(fromParcelable(it2.next()));
            }
            return arrayList;
        } catch (RuntimeException unused) {
            return null;
        }
    }
}
