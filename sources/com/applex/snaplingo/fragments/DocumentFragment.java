package com.applex.snaplingo.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.applex.snaplingo.CameraActivity;
import com.applex.snaplingo.MainActivity2;
import com.applex.snaplingo.R;
import com.applex.snaplingo.ViewPager;
import com.applex.snaplingo.adapters.DocAdapter;
import com.applex.snaplingo.adapters.DocModel;
import com.applex.snaplingo.fragments.DocumentFragment;
import com.applex.snaplingo.interfaces.OnPDFCreatedInterface;
import com.applex.snaplingo.util.Constants;
import com.applex.snaplingo.util.CreatePdf;
import com.applex.snaplingo.util.ImageToPDFOptions;
import com.applex.snaplingo.util.ImageUtils;
import com.applex.snaplingo.util.PermissionsUtils;
import com.applex.snaplingo.util.PicassoEngine;
import com.applex.snaplingo.util.Watermark;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import id.zelory.compressor.Compressor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

public class DocumentFragment extends Fragment {
    private static final int INTENT_REQUEST_GET_IMAGES = 13;
    private static final int REQUEST_PERMISSIONS_CODE = 124;
    public static int swipe;
    /* access modifiers changed from: private */
    public LottieAnimationView animationView;
    /* access modifiers changed from: private */
    public String doc_name;
    ArrayList<DocModel> docs;
    String fileName;
    private LinearLayoutManager layoutManager;
    /* access modifiers changed from: private */
    public DocAdapter mDocAdapter;
    /* access modifiers changed from: private */
    public RecyclerView mDocumentsList;
    /* access modifiers changed from: private */
    public String mHomePath;
    /* access modifiers changed from: private */
    public ArrayList<Uri> mImages = new ArrayList<>();
    private ArrayList<String> mImagesUri = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<String> mImgShareUri = new ArrayList<>();
    private int mPageColor;
    private String mPageNumStyle;
    private String mPath;
    private ImageToPDFOptions mPdfOptions;
    private boolean mPermissionGranted = false;
    private SharedPreferences mSharedPreferences;
    private final ArrayList<String> mUnarrangedImagesUri = new ArrayList<>();
    private OnPDFCreatedInterface onPDFCreatedInterface;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_document, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        getRuntimePermissions();
        this.mPermissionGranted = PermissionsUtils.getInstance().checkRuntimePermissions(this, Constants.READ_WRITE_CAMERA_PERMISSIONS);
        this.mDocumentsList = (RecyclerView) view.findViewById(R.id.image_recycler);
        this.animationView = (LottieAnimationView) view.findViewById(R.id.animation_view);
        this.mDocumentsList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.layoutManager = linearLayoutManager;
        this.mDocumentsList.setLayoutManager(linearLayoutManager);
    }

    private void createList() {
        File file = new File(Environment.getExternalStorageDirectory() + "/SnapLingo", ".documents");
        file.mkdirs();
        if (file.exists()) {
            file.mkdir();
        }
        this.mHomePath = Environment.getExternalStorageDirectory() + "/SnapLingo/.documents/";
        File[] listFiles = new File(this.mHomePath).listFiles();
        if (listFiles == null) {
            this.animationView.setVisibility(0);
            this.mDocumentsList.setVisibility(8);
        } else if (listFiles.length == 0) {
            this.animationView.setVisibility(0);
            this.mDocumentsList.setVisibility(8);
        } else {
            if (listFiles != null && listFiles.length > 1) {
                Arrays.sort(listFiles, $$Lambda$DocumentFragment$x8Gw1q3rfFp355nCj6KKIMAnOsM.INSTANCE);
            }
            for (File file2 : listFiles) {
                DocModel docModel = new DocModel();
                docModel.setDocName(file2.getName());
                docModel.setPath(file2.getAbsolutePath());
                docModel.setDate(new SimpleDateFormat("dd MMMM, yyyy").format(new Date(file2.lastModified())));
                File[] listFiles2 = new File(this.mHomePath + Constants.PATH_SEPERATOR + file2.getName()).listFiles();
                if (listFiles2 != null && listFiles2.length > 1) {
                    Arrays.sort(listFiles2, $$Lambda$DocumentFragment$Mmura9_bAMuSpRCcL9Tnn_BG2G4.INSTANCE);
                }
                if (listFiles2 != null && listFiles2.length > 0) {
                    docModel.setImageUri(Uri.fromFile(new File(listFiles2[0].getAbsolutePath())));
                    this.docs.add(docModel);
                }
            }
            Collections.reverse(this.docs);
        }
    }

    /* access modifiers changed from: private */
    public void buildRecyclerView(final ArrayList<DocModel> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.animationView.setVisibility(0);
            this.mDocumentsList.setVisibility(8);
            return;
        }
        this.mDocumentsList.setVisibility(0);
        this.animationView.setVisibility(8);
        DocAdapter docAdapter = new DocAdapter(getActivity(), arrayList);
        this.mDocAdapter = docAdapter;
        docAdapter.setOnItemClickListener(new DocAdapter.OnItemClickListener() {
            /* class com.applex.snaplingo.fragments.DocumentFragment.AnonymousClass1 */

            @Override // com.applex.snaplingo.adapters.DocAdapter.OnItemClickListener
            public void onDeleteClick(int i) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DocumentFragment.this.getActivity());
                builder.setTitle("Delete document " + ((DocModel) arrayList.get(i)).getDocName()).setMessage("Are your sure?").setPositiveButton("Delete", new DialogInterface.OnClickListener(arrayList, i) {
                    /* class com.applex.snaplingo.fragments.$$Lambda$DocumentFragment$1$42MNEXJht_mWJU9aL545iN8g7rw */
                    public final /* synthetic */ ArrayList f$1;
                    public final /* synthetic */ int f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        DocumentFragment.AnonymousClass1.this.lambda$onDeleteClick$0$DocumentFragment$1(this.f$1, this.f$2, dialogInterface, i);
                    }
                }).setNegativeButton("Cancel", $$Lambda$DocumentFragment$1$qrxLNpRdGaDZjZBRh5MIsJ7S3mU.INSTANCE).setCancelable(true).show();
            }

            public /* synthetic */ void lambda$onDeleteClick$0$DocumentFragment$1(ArrayList arrayList, int i, DialogInterface dialogInterface, int i2) {
                String[] list;
                File file = new File(DocumentFragment.this.mHomePath + Constants.PATH_SEPERATOR + ((DocModel) arrayList.get(i)).getDocName());
                if (file.isDirectory()) {
                    for (String str : file.list()) {
                        new File(file, str).delete();
                    }
                    file.delete();
                    arrayList.remove(i);
                    DocumentFragment.this.mDocAdapter.notifyItemRemoved(i);
                } else {
                    Toast.makeText(DocumentFragment.this.getActivity(), "Not found", 0);
                }
                if (new File(DocumentFragment.this.mHomePath).listFiles().length != 0) {
                    File[] listFiles = new File(DocumentFragment.this.mHomePath).listFiles();
                    for (int i3 = 0; i3 < listFiles.length; i3++) {
                        File file2 = new File(DocumentFragment.this.mHomePath + Constants.PATH_SEPERATOR + listFiles[i3].getName());
                        File[] listFiles2 = file2.listFiles();
                        if (listFiles2 != null && listFiles2.length == 0) {
                            file2.delete();
                        }
                    }
                    if (listFiles.length == 0) {
                        DocumentFragment.this.mDocumentsList.setVisibility(8);
                        DocumentFragment.this.animationView.setVisibility(0);
                        DocumentFragment.this.animationView.playAnimation();
                        return;
                    }
                    return;
                }
                DocumentFragment.this.mDocumentsList.setVisibility(8);
                DocumentFragment.this.animationView.setVisibility(0);
                DocumentFragment.this.animationView.playAnimation();
            }

            @Override // com.applex.snaplingo.adapters.DocAdapter.OnItemClickListener
            public void onShareClick(int i) {
                String unused = DocumentFragment.this.doc_name = ((DocModel) arrayList.get(i)).getDocName();
                DocumentFragment.this.mImgShareUri.clear();
                File[] listFiles = new File(((DocModel) arrayList.get(i)).getPath() + Constants.PATH_SEPERATOR).listFiles();
                if (listFiles != null && listFiles.length > 1) {
                    Arrays.sort(listFiles, new Comparator<File>() {
                        /* class com.applex.snaplingo.fragments.DocumentFragment.AnonymousClass1.AnonymousClass1 */

                        public int compare(File file, File file2) {
                            return file.getName().compareTo(file2.getName());
                        }
                    });
                }
                if (listFiles != null) {
                    for (File file : listFiles) {
                        DocumentFragment.this.mImgShareUri.add(Uri.fromFile(new File(file.getAbsolutePath())).toString());
                    }
                }
                DocumentFragment.this.resetValues();
                DocumentFragment.this.createPdf(false);
            }
        });
        this.mDocumentsList.setAdapter(this.mDocAdapter);
    }

    /* access modifiers changed from: package-private */
    public void startAddingImages() {
        boolean checkRuntimePermissions = PermissionsUtils.getInstance().checkRuntimePermissions(this, Constants.READ_WRITE_CAMERA_PERMISSIONS);
        this.mPermissionGranted = checkRuntimePermissions;
        if (!checkRuntimePermissions) {
            getRuntimePermissions();
        } else {
            selectImages();
        }
    }

    /* access modifiers changed from: package-private */
    public void startCamera() {
        boolean checkRuntimePermissions = PermissionsUtils.getInstance().checkRuntimePermissions(this, Constants.READ_WRITE_CAMERA_PERMISSIONS);
        this.mPermissionGranted = checkRuntimePermissions;
        if (!checkRuntimePermissions) {
            getRuntimePermissions();
        } else {
            selectCamera();
        }
    }

    private void selectImages() {
        Matisse.from(this).choose(MimeType.ofImage(), true).countable(true).maxSelectable(25).thumbnailScale(1.0f).theme(2131951857).imageEngine(new PicassoEngine()).forResult(13);
    }

    private void selectCamera() {
        startActivity(new Intent(getActivity(), CameraActivity.class).putExtra("boolcam", "1").putExtra("firstTime", "1"));
    }

    private void getRuntimePermissions() {
        PermissionsUtils.getInstance().requestRuntimePermissions(this, Constants.READ_WRITE_CAMERA_PERMISSIONS, 124);
        this.mPermissionGranted = PermissionsUtils.getInstance().checkRuntimePermissions(this, Constants.READ_WRITE_CAMERA_PERMISSIONS);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null && i == 13) {
            this.mImagesUri.clear();
            this.mImagesUri.addAll(Matisse.obtainPathResult(intent));
            this.fileName = String.valueOf(System.currentTimeMillis());
            File file = new File(Environment.getExternalStorageDirectory() + "/SnapLingo/.documents", this.fileName);
            file.mkdirs();
            if (!file.exists()) {
                file.mkdir();
            }
            if (this.mImagesUri.size() > 0) {
                for (int i3 = 0; i3 < this.mImagesUri.size(); i3++) {
                    File file2 = new File(this.mImagesUri.get(i3));
                    File file3 = new File(Environment.getExternalStorageDirectory() + "/SnapLingo/.documents/" + this.fileName + Constants.PATH_SEPERATOR, i3 + ".jpg");
                    File file4 = null;
                    try {
                        file4 = new Compressor(getActivity()).compressToFile(file2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    copy(file4, file3);
                    if (i3 == this.mImagesUri.size() - 1) {
                        Intent intent2 = new Intent(getActivity(), ViewPager.class);
                        intent2.putExtra("from", "1");
                        intent2.putExtra("docName", this.fileName);
                        startActivity(intent2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        r4.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0033, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0034, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0037, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void copy(java.io.File r3, java.io.File r4) {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0038 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0038 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x002c }
            r3.<init>(r4)     // Catch:{ all -> 0x002c }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0020 }
        L_0x000e:
            int r1 = r0.read(r4)     // Catch:{ all -> 0x0020 }
            if (r1 <= 0) goto L_0x0019
            r2 = 0
            r3.write(r4, r2, r1)     // Catch:{ all -> 0x0020 }
            goto L_0x000e
        L_0x0019:
            r3.close()
            r0.close()
            goto L_0x003c
        L_0x0020:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r1 = move-exception
            r3.close()     // Catch:{ all -> 0x0027 }
            goto L_0x002b
        L_0x0027:
            r3 = move-exception
            r4.addSuppressed(r3)
        L_0x002b:
            throw r1
        L_0x002c:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x002e }
        L_0x002e:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x0037:
            throw r4
        L_0x0038:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applex.snaplingo.fragments.DocumentFragment.copy(java.io.File, java.io.File):void");
    }

    /* access modifiers changed from: private */
    public void createPdf(boolean z) {
        File file = new File(Environment.getExternalStorageDirectory() + "/SnapLingo", "Pdf");
        file.mkdirs();
        if (file.exists()) {
            file.mkdir();
        }
        this.mPath = Environment.getExternalStorageDirectory() + "/SnapLingo/Pdf/";
        Watermark watermark = new Watermark();
        watermark.setWatermarkText("Scanned by SnapLingo");
        this.mPdfOptions.setImagesUri(this.mImgShareUri);
        this.mPdfOptions.setImageScaleType(ImageUtils.getInstance().mImageScaleType);
        this.mPdfOptions.setPageNumStyle(this.mPageNumStyle);
        this.mPdfOptions.setWatermark(watermark);
        this.mPdfOptions.setWatermarkAdded(true);
        this.mPdfOptions.setMasterPwd(this.mSharedPreferences.getString(Constants.MASTER_PWD_STRING, Constants.appName));
        this.mPdfOptions.setPageColor(this.mPageColor);
        this.mPdfOptions.setOutFileName(this.doc_name);
        new CreatePdf(this.mPdfOptions, this.mPath, this.onPDFCreatedInterface, getActivity(), ExifInterface.GPS_MEASUREMENT_2D).execute(new String[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.onPDFCreatedInterface = (OnPDFCreatedInterface) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement MyInterface ");
        }
    }

    /* access modifiers changed from: private */
    public void resetValues() {
        ImageToPDFOptions imageToPDFOptions = new ImageToPDFOptions();
        this.mPdfOptions = imageToPDFOptions;
        imageToPDFOptions.setBorderWidth(this.mSharedPreferences.getInt(Constants.DEFAULT_IMAGE_BORDER_TEXT, 0));
        this.mPdfOptions.setQualityString(Integer.toString(this.mSharedPreferences.getInt(Constants.DEFAULT_COMPRESSION, 30)));
        this.mPdfOptions.setPageSize(this.mSharedPreferences.getString(Constants.DEFAULT_PAGE_SIZE_TEXT, Constants.DEFAULT_PAGE_SIZE));
        this.mPdfOptions.setPasswordProtected(false);
        this.mPdfOptions.setWatermarkAdded(false);
        ImageUtils.getInstance().mImageScaleType = this.mSharedPreferences.getString(Constants.DEFAULT_IMAGE_SCALE_TYPE_TEXT, Constants.IMAGE_SCALE_TYPE_ASPECT_RATIO);
        this.mPdfOptions.setMargins(0, 80, 0, 0);
        this.mPageNumStyle = this.mSharedPreferences.getString(Constants.PREF_PAGE_STYLE, null);
        this.mPageColor = this.mSharedPreferences.getInt(Constants.DEFAULT_PAGE_COLOR_ITP, -1);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && isResumed()) {
            onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.search) {
            SearchView searchView = (SearchView) menuItem.getActionView();
            searchView.setQueryHint("Search");
            final ArrayList arrayList = new ArrayList();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                /* class com.applex.snaplingo.fragments.DocumentFragment.AnonymousClass2 */

                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextSubmit(String str) {
                    return false;
                }

                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextChange(String str) {
                    arrayList.clear();
                    Iterator<DocModel> it2 = DocumentFragment.this.docs.iterator();
                    while (it2.hasNext()) {
                        DocModel next = it2.next();
                        if (next.getDocName().contains(str)) {
                            arrayList.add(next);
                        }
                    }
                    DocumentFragment.this.buildRecyclerView(arrayList);
                    return false;
                }
            });
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (swipe != 0) {
            swipe = 0;
        } else {
            this.docs = new ArrayList<>();
            createList();
            buildRecyclerView(this.docs);
        }
        if (getUserVisibleHint()) {
            MainActivity2 mainActivity2 = (MainActivity2) getActivity();
            if (mainActivity2 != null) {
                mainActivity2.btnGall.setOnClickListener(new View.OnClickListener() {
                    /* class com.applex.snaplingo.fragments.$$Lambda$DocumentFragment$1g2byyT0sKM3a8VjvsNfilh33Ig */

                    public final void onClick(View view) {
                        DocumentFragment.this.lambda$onResume$2$DocumentFragment(view);
                    }
                });
            }
            if (mainActivity2 != null) {
                mainActivity2.btnCamera.setOnClickListener(new View.OnClickListener() {
                    /* class com.applex.snaplingo.fragments.$$Lambda$DocumentFragment$kX6Oynewmm1grFdyUi8j04lf0IE */

                    public final void onClick(View view) {
                        DocumentFragment.this.lambda$onResume$3$DocumentFragment(view);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$onResume$2$DocumentFragment(View view) {
        startAddingImages();
    }

    public /* synthetic */ void lambda$onResume$3$DocumentFragment(View view) {
        startCamera();
    }

    class ImageCompressor extends AsyncTask<Void, Void, byte[]> {
        private int i;
        private final float maxHeight = 816.0f;
        private final float maxWidth = 612.0f;
        private byte[] pic2;

        public ImageCompressor(byte[] bArr, int i2) {
            this.pic2 = bArr;
            this.i = i2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        public byte[] doInBackground(Void... voidArr) {
            Bitmap bitmap;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            byte[] bArr = this.pic2;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outHeight;
            int i3 = options.outWidth;
            float f = (float) i3;
            float f2 = (float) i2;
            float f3 = f / f2;
            if (f2 > 816.0f || f > 612.0f) {
                if (f3 < 0.75f) {
                    i3 = (int) ((816.0f / f2) * f);
                    i2 = 816;
                } else {
                    i2 = f3 > 0.75f ? (int) ((612.0f / f) * f2) : 816;
                    i3 = 612;
                }
            }
            options.inSampleSize = calculateInSampleSize(options, i3, i2);
            options.inJustDecodeBounds = false;
            options.inDither = false;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inTempStorage = new byte[16384];
            try {
                decodeByteArray = BitmapFactory.decodeByteArray(this.pic2, 0, this.pic2.length, options);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
            try {
                bitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                bitmap = null;
            }
            float f4 = (float) i3;
            float f5 = f4 / ((float) options.outWidth);
            float f6 = (float) i2;
            float f7 = f6 / ((float) options.outHeight);
            float f8 = f4 / 2.0f;
            float f9 = f6 / 2.0f;
            Matrix matrix = new Matrix();
            matrix.setScale(f5, f7, f8, f9);
            Canvas canvas = new Canvas(bitmap);
            canvas.setMatrix(matrix);
            canvas.drawBitmap(decodeByteArray, f8 - ((float) (decodeByteArray.getWidth() / 2)), f9 - ((float) (decodeByteArray.getHeight() / 2)), new Paint(2));
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(byte[] bArr) {
            if (bArr != null) {
                DocumentFragment.this.saveToInternalStorage(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), new File(Environment.getExternalStorageDirectory() + "/SnapLingo/.documents/" + DocumentFragment.this.fileName + Constants.PATH_SEPERATOR, this.i + ".jpg"));
                if (this.i == DocumentFragment.this.mImages.size() - 1) {
                    Intent intent = new Intent(DocumentFragment.this.getActivity(), ViewPager.class);
                    intent.putExtra("from", "1");
                    intent.putExtra("docName", DocumentFragment.this.fileName);
                    DocumentFragment.this.startActivity(intent);
                }
            }
        }

        private int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
            int i4;
            int i5 = options.outHeight;
            int i6 = options.outWidth;
            if (i5 > i3 || i6 > i2) {
                i4 = Math.round(((float) i5) / ((float) i3));
                int round = Math.round(((float) i6) / ((float) i2));
                if (i4 >= round) {
                    i4 = round;
                }
            } else {
                i4 = 1;
            }
            while (((float) (i6 * i5)) / ((float) (i4 * i4)) > ((float) (i2 * i3 * 4))) {
                i4++;
            }
            return i4;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r4 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveToInternalStorage(android.graphics.Bitmap r3, java.io.File r4) {
        /*
            r2 = this;
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x001c }
            r0.<init>(r4)     // Catch:{ IOException -> 0x001c }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x0010 }
            r1 = 100
            r3.compress(r4, r1, r0)     // Catch:{ all -> 0x0010 }
            r0.close()
            goto L_0x0020
        L_0x0010:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x0017 }
            goto L_0x001b
        L_0x0017:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x001b:
            throw r4
        L_0x001c:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applex.snaplingo.fragments.DocumentFragment.saveToInternalStorage(android.graphics.Bitmap, java.io.File):void");
    }
}
