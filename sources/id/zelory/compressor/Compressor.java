package id.zelory.compressor;

import android.content.Context;
import android.graphics.Bitmap;
import io.reactivex.Flowable;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

public class Compressor {
    private Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
    private String destinationDirectoryPath;
    private int maxHeight = 816;
    private int maxWidth = 612;
    private int quality = 80;

    public Compressor(Context context) {
        this.destinationDirectoryPath = context.getCacheDir().getPath() + File.separator + "images";
    }

    public Compressor setMaxWidth(int i) {
        this.maxWidth = i;
        return this;
    }

    public Compressor setMaxHeight(int i) {
        this.maxHeight = i;
        return this;
    }

    public Compressor setCompressFormat(Bitmap.CompressFormat compressFormat2) {
        this.compressFormat = compressFormat2;
        return this;
    }

    public Compressor setQuality(int i) {
        this.quality = i;
        return this;
    }

    public Compressor setDestinationDirectoryPath(String str) {
        this.destinationDirectoryPath = str;
        return this;
    }

    public File compressToFile(File file) throws IOException {
        return compressToFile(file, file.getName());
    }

    public File compressToFile(File file, String str) throws IOException {
        int i = this.maxWidth;
        int i2 = this.maxHeight;
        Bitmap.CompressFormat compressFormat2 = this.compressFormat;
        int i3 = this.quality;
        return ImageUtil.compressImage(file, i, i2, compressFormat2, i3, this.destinationDirectoryPath + File.separator + str);
    }

    public Bitmap compressToBitmap(File file) throws IOException {
        return ImageUtil.decodeSampledBitmapFromFile(file, this.maxWidth, this.maxHeight);
    }

    public Flowable<File> compressToFileAsFlowable(File file) {
        return compressToFileAsFlowable(file, file.getName());
    }

    public Flowable<File> compressToFileAsFlowable(final File file, final String str) {
        return Flowable.defer(new Callable<Flowable<File>>() {
            /* class id.zelory.compressor.Compressor.AnonymousClass1 */

            @Override // java.util.concurrent.Callable
            public Flowable<File> call() {
                try {
                    return Flowable.just(Compressor.this.compressToFile(file, str));
                } catch (IOException e) {
                    return Flowable.error(e);
                }
            }
        });
    }

    public Flowable<Bitmap> compressToBitmapAsFlowable(final File file) {
        return Flowable.defer(new Callable<Flowable<Bitmap>>() {
            /* class id.zelory.compressor.Compressor.AnonymousClass2 */

            @Override // java.util.concurrent.Callable
            public Flowable<Bitmap> call() {
                try {
                    return Flowable.just(Compressor.this.compressToBitmap(file));
                } catch (IOException e) {
                    return Flowable.error(e);
                }
            }
        });
    }
}
