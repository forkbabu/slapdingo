package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import okio.Okio;

class MediaStoreRequestHandler extends ContentStreamRequestHandler {
    private static final String[] CONTENT_ORIENTATION = {"orientation"};

    MediaStoreRequestHandler(Context context) {
        super(context);
    }

    @Override // com.squareup.picasso.ContentStreamRequestHandler, com.squareup.picasso.RequestHandler
    public boolean canHandleRequest(Request request) {
        Uri uri = request.uri;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    @Override // com.squareup.picasso.ContentStreamRequestHandler, com.squareup.picasso.RequestHandler
    public RequestHandler.Result load(Request request, int i) throws IOException {
        Bitmap bitmap;
        ContentResolver contentResolver = this.context.getContentResolver();
        int exifOrientation = getExifOrientation(contentResolver, request.uri);
        String type = contentResolver.getType(request.uri);
        boolean z = type != null && type.startsWith("video/");
        if (request.hasSize()) {
            PicassoKind picassoKind = getPicassoKind(request.targetWidth, request.targetHeight);
            if (!z && picassoKind == PicassoKind.FULL) {
                return new RequestHandler.Result(null, Okio.source(getInputStream(request)), Picasso.LoadedFrom.DISK, exifOrientation);
            }
            long parseId = ContentUris.parseId(request.uri);
            BitmapFactory.Options createBitmapOptions = createBitmapOptions(request);
            createBitmapOptions.inJustDecodeBounds = true;
            calculateInSampleSize(request.targetWidth, request.targetHeight, picassoKind.width, picassoKind.height, createBitmapOptions, request);
            if (z) {
                bitmap = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, parseId, picassoKind == PicassoKind.FULL ? 1 : picassoKind.androidKind, createBitmapOptions);
            } else {
                bitmap = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, parseId, picassoKind.androidKind, createBitmapOptions);
            }
            if (bitmap != null) {
                return new RequestHandler.Result(bitmap, null, Picasso.LoadedFrom.DISK, exifOrientation);
            }
        }
        return new RequestHandler.Result(null, Okio.source(getInputStream(request)), Picasso.LoadedFrom.DISK, exifOrientation);
    }

    static PicassoKind getPicassoKind(int i, int i2) {
        if (i <= PicassoKind.MICRO.width && i2 <= PicassoKind.MICRO.height) {
            return PicassoKind.MICRO;
        }
        if (i > PicassoKind.MINI.width || i2 > PicassoKind.MINI.height) {
            return PicassoKind.FULL;
        }
        return PicassoKind.MINI;
    }

    static int getExifOrientation(ContentResolver contentResolver, Uri uri) {
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(uri, CONTENT_ORIENTATION, null, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    int i = query.getInt(0);
                    if (query != null) {
                        query.close();
                    }
                    return i;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    enum PicassoKind {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);
        
        final int androidKind;
        final int height;
        final int width;

        private PicassoKind(int i, int i2, int i3) {
            this.androidKind = i;
            this.width = i2;
            this.height = i3;
        }
    }
}
