package com.applex.snaplingo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.MDButton;
import com.applex.snaplingo.ActivityGrid;
import com.applex.snaplingo.adapters.ImageGridAdapter;
import com.applex.snaplingo.interfaces.OnPDFCreatedInterface;
import com.applex.snaplingo.util.Constants;
import com.applex.snaplingo.util.CreatePdf;
import com.applex.snaplingo.util.DialogUtils;
import com.applex.snaplingo.util.ImageToPDFOptions;
import com.applex.snaplingo.util.ImageUtils;
import com.applex.snaplingo.util.PermissionsUtils;
import com.applex.snaplingo.util.PicassoEngine;
import com.applex.snaplingo.util.Watermark;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import id.zelory.compressor.Compressor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class ActivityGrid extends AppCompatActivity implements OnPDFCreatedInterface {
    private static final int INTENT_REQUEST_APPLY_FILTER = 10;
    private static final int INTENT_REQUEST_GET_IMAGES = 13;
    private static final int INTENT_REQUEST_PREVIEW_IMAGE = 11;
    private static final int INTENT_REQUEST_REARRANGE_IMAGE = 12;
    private static final int REQUEST_PERMISSIONS_CODE = 124;
    public static String document_name;
    private ImageView back;
    private FloatingActionButton camera;
    private CoordinatorLayout coordinatorLayout;
    /* access modifiers changed from: private */
    public TextView doc_name;
    private ImageView download;
    private ImageView editName;
    private FloatingActionButton gallery;
    private int gridImagePos;
    private ItemTouchHelper helper;
    private ImageGridAdapter imageAdapter;
    private GridLayoutManager layoutManager;
    private ImageView lock;
    /* access modifiers changed from: private */
    public String mHomePath;
    /* access modifiers changed from: private */
    public ArrayList<Uri> mImages = new ArrayList<>();
    private RecyclerView mImagesGrid;
    public ArrayList<String> mImagesUri;
    /* access modifiers changed from: private */
    public MaterialDialog mMaterialDialog;
    private int mPageColor;
    private String mPageNumStyle;
    private ImageToPDFOptions mPdfOptions;
    private boolean mPermissionGranted = false;
    private SharedPreferences mSharedPreferences;
    /* access modifiers changed from: private */
    public FloatingActionMenu menu;
    /* access modifiers changed from: private */
    public Dialog mydialogue;
    private OnPDFCreatedInterface onPDFCreatedInterface = this;
    /* access modifiers changed from: private */
    public BottomSheetDialog postMenuDialog;
    /* access modifiers changed from: private */
    public String textDocName;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_grid);
        this.download = (ImageView) findViewById(R.id.download);
        this.editName = (ImageView) findViewById(R.id.edit_name);
        this.lock = (ImageView) findViewById(R.id.lock);
        this.back = (ImageView) findViewById(R.id.back);
        this.doc_name = (TextView) findViewById(R.id.doc_name);
        this.coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        this.gallery = (FloatingActionButton) findViewById(R.id.grid_gallery);
        this.camera = (FloatingActionButton) findViewById(R.id.grid_camera);
        this.menu = (FloatingActionMenu) findViewById(R.id.grid_menu);
        this.mPermissionGranted = PermissionsUtils.getInstance().checkRuntimePermissions(this, Constants.READ_WRITE_CAMERA_PERMISSIONS);
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        resetValues();
        this.mHomePath = Environment.getExternalStorageDirectory() + "/SnapLingo/.documents/";
        if (getIntent().getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME) != null) {
            this.textDocName = getIntent().getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME);
            this.doc_name.setText(getIntent().getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME));
            document_name = this.textDocName;
        } else {
            this.textDocName = getIntent().getStringExtra(String.valueOf(System.currentTimeMillis()));
            this.doc_name.setText(String.valueOf(System.currentTimeMillis()));
            document_name = this.textDocName;
        }
        this.doc_name.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ActivityGrid.AnonymousClass1 */

            public void onClick(View view) {
                ActivityGrid activityGrid = ActivityGrid.this;
                activityGrid.renameDocumentDialog(activityGrid.doc_name.getText().toString());
            }
        });
        this.editName.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ActivityGrid.AnonymousClass2 */

            public void onClick(View view) {
                ActivityGrid activityGrid = ActivityGrid.this;
                activityGrid.renameDocumentDialog(activityGrid.doc_name.getText().toString());
            }
        });
        this.mImagesUri = new ArrayList<>();
        this.mImagesGrid = (RecyclerView) findViewById(R.id.image_recycler);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        this.layoutManager = gridLayoutManager;
        this.mImagesGrid.setLayoutManager(gridLayoutManager);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(3, 12) {
            /* class com.applex.snaplingo.ActivityGrid.AnonymousClass3 */

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
                return true;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback, androidx.recyclerview.widget.ItemTouchHelper.Callback
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return makeMovementFlags(51, 0);
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
                super.onMoved(recyclerView, viewHolder, i, viewHolder2, i2, i3, i4);
                ActivityGrid.this.buildRecyclerView();
                String str = Environment.getExternalStorageDirectory() + "/SnapLingo/.documents/" + ActivityGrid.this.textDocName + Constants.PATH_SEPERATOR;
                File file = new File(str, i + ".jpg");
                File file2 = new File(str, "temp.jpg");
                if (file.exists() && file.renameTo(file2)) {
                    File file3 = new File(str, i2 + ".jpg");
                    File file4 = new File(str, i + ".jpg");
                    if (file3.exists() && file3.renameTo(file4)) {
                        File file5 = new File(str, "temp.jpg");
                        File file6 = new File(str, i2 + ".jpg");
                        if (file5.exists()) {
                            file5.renameTo(file6);
                        }
                    }
                }
            }
        });
        this.helper = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.mImagesGrid);
        this.back.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ActivityGrid.AnonymousClass4 */

            public void onClick(View view) {
                ActivityGrid.super.onBackPressed();
            }
        });
        File file = new File(Environment.getExternalStorageDirectory() + "/SnapLingo", "Pdf");
        file.mkdirs();
        if (file.exists()) {
            file.mkdir();
        }
        this.camera.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ActivityGrid.AnonymousClass5 */

            public void onClick(View view) {
                ActivityGrid.this.startCamera();
            }
        });
        this.gallery.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ActivityGrid.AnonymousClass6 */

            public void onClick(View view) {
                ActivityGrid.this.menu.close(true);
                ActivityGrid.this.startAddingImages();
            }
        });
        this.download.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ActivityGrid.AnonymousClass7 */

            public void onClick(View view) {
                ActivityGrid activityGrid = ActivityGrid.this;
                activityGrid.createPdf(false, activityGrid.mImagesUri);
            }
        });
        this.lock.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ActivityGrid.AnonymousClass8 */

            public void onClick(View view) {
                ActivityGrid.this.passwordProtectPDF();
            }
        });
    }

    @Override // com.applex.snaplingo.interfaces.OnPDFCreatedInterface
    public void onPDFCreationStarted() {
        MaterialDialog createAnimationDialog = DialogUtils.getInstance().createAnimationDialog(this);
        this.mMaterialDialog = createAnimationDialog;
        createAnimationDialog.show();
    }

    @Override // com.applex.snaplingo.interfaces.OnPDFCreatedInterface
    public void onPDFCreated(boolean z, final String str) {
        new Handler().postDelayed(new Runnable() {
            /* class com.applex.snaplingo.ActivityGrid.AnonymousClass9 */

            public void run() {
                if (ActivityGrid.this.mMaterialDialog != null && ActivityGrid.this.mMaterialDialog.isShowing()) {
                    ActivityGrid.this.mMaterialDialog.dismiss();
                }
                BottomSheetDialog unused = ActivityGrid.this.postMenuDialog = new BottomSheetDialog(ActivityGrid.this);
                ActivityGrid.this.postMenuDialog.setContentView(R.layout.document_share_dialog);
                ActivityGrid.this.postMenuDialog.setCanceledOnTouchOutside(Boolean.TRUE.booleanValue());
                ActivityGrid.this.postMenuDialog.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
                    /* class com.applex.snaplingo.ActivityGrid.AnonymousClass9.AnonymousClass1 */

                    public void onClick(View view) {
                        ActivityGrid.this.postMenuDialog.dismiss();
                    }
                });
                ActivityGrid.this.postMenuDialog.findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
                    /* class com.applex.snaplingo.ActivityGrid.AnonymousClass9.AnonymousClass2 */

                    public void onClick(View view) {
                        File file = new File(str);
                        if (file.exists()) {
                            Uri uriForFile = FileProvider.getUriForFile(ActivityGrid.this, Constants.AUTHORITY_APP, file);
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.SEND");
                            intent.putExtra("android.intent.extra.TEXT", "sharing");
                            intent.putExtra("android.intent.extra.STREAM", uriForFile);
                            intent.addFlags(1);
                            intent.setType("Document/*");
                            ActivityGrid.this.startActivity(Intent.createChooser(intent, "SHARE"));
                        } else {
                            ActivityGrid activityGrid = ActivityGrid.this;
                            Toast.makeText(activityGrid, ActivityGrid.document_name + " missing " + str, 1).show();
                        }
                        ActivityGrid.this.postMenuDialog.dismiss();
                    }
                });
                ActivityGrid.this.postMenuDialog.findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {
                    /* class com.applex.snaplingo.ActivityGrid.AnonymousClass9.AnonymousClass3 */

                    public void onClick(View view) {
                        File file = new File(str);
                        if (file.exists()) {
                            Uri uriForFile = FileProvider.getUriForFile(ActivityGrid.this, Constants.AUTHORITY_APP, file);
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.addFlags(1);
                            intent.setDataAndType(uriForFile, "application/pdf");
                            Intent createChooser = Intent.createChooser(intent, "Open File");
                            try {
                                createChooser.setFlags(268435456);
                                ActivityGrid.this.startActivity(createChooser);
                            } catch (ActivityNotFoundException unused) {
                                Toast.makeText(ActivityGrid.this.getApplicationContext(), "Something went wrong...", 0).show();
                            }
                        }
                        ActivityGrid.this.postMenuDialog.dismiss();
                    }
                });
                ((Window) Objects.requireNonNull(ActivityGrid.this.postMenuDialog.getWindow())).setBackgroundDrawable(new ColorDrawable(0));
                ActivityGrid.this.postMenuDialog.show();
            }
        }, 2000);
    }

    /* access modifiers changed from: private */
    public void createPdf(boolean z, ArrayList<String> arrayList) {
        File file = new File(Environment.getExternalStorageDirectory() + "/SnapLingo", "Pdf");
        file.mkdirs();
        if (file.exists()) {
            file.mkdir();
        }
        Watermark watermark = new Watermark();
        watermark.setWatermarkText("Scanned by SnapLingo");
        this.mPdfOptions.setImagesUri(arrayList);
        this.mPdfOptions.setImageScaleType(ImageUtils.getInstance().mImageScaleType);
        this.mPdfOptions.setPageNumStyle(this.mPageNumStyle);
        this.mPdfOptions.setWatermark(watermark);
        this.mPdfOptions.setWatermarkAdded(true);
        this.mPdfOptions.setMasterPwd(this.mSharedPreferences.getString(Constants.MASTER_PWD_STRING, Constants.appName));
        this.mPdfOptions.setPageColor(this.mPageColor);
        this.mPdfOptions.setOutFileName(this.doc_name.getText().toString());
        new CreatePdf(this.mPdfOptions, Environment.getExternalStorageDirectory() + "/SnapLingo/Pdf/", this.onPDFCreatedInterface, this, ExifInterface.GPS_MEASUREMENT_2D).execute(new String[0]);
    }

    private void resetValues() {
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

    private void selectImages() {
        Matisse.from(this).choose(MimeType.ofImage(), true).countable(true).maxSelectable(25).thumbnailScale(1.0f).theme(2131951857).imageEngine(new PicassoEngine()).forResult(13);
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

    private void selectCamera() {
        Intent intent = new Intent(this, CameraActivity.class);
        intent.putExtra("boolcam", ExifInterface.GPS_MEASUREMENT_2D);
        intent.putExtra("prevDocName", this.doc_name.getText().toString());
        intent.putExtra("imageCount", Integer.toString(this.mImagesUri.size()));
        startActivity(intent);
        this.menu.close(true);
    }

    private void getRuntimePermissions() {
        PermissionsUtils.getInstance().requestRuntimePermissions(this, Constants.READ_WRITE_CAMERA_PERMISSIONS, 124);
        this.mPermissionGranted = PermissionsUtils.getInstance().checkRuntimePermissions(this, Constants.READ_WRITE_CAMERA_PERMISSIONS);
    }

    /* access modifiers changed from: private */
    public void renameDocumentDialog(final String str) {
        Dialog dialog = new Dialog(this);
        this.mydialogue = dialog;
        dialog.setContentView(R.layout.dialog_doc_name_edit);
        this.mydialogue.setCanceledOnTouchOutside(Boolean.TRUE.booleanValue());
        this.mydialogue.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        final EditText editText = (EditText) this.mydialogue.findViewById(R.id.enter_name);
        editText.setText(str);
        this.mydialogue.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ActivityGrid.AnonymousClass10 */

            public void onClick(View view) {
                ActivityGrid.this.mydialogue.dismiss();
            }
        });
        this.mydialogue.findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ActivityGrid.AnonymousClass11 */

            public void onClick(View view) {
                String trim = editText.getText().toString().trim();
                if (trim.isEmpty()) {
                    Toast.makeText(ActivityGrid.this.getApplicationContext(), "Enter Name", 0).show();
                    return;
                }
                File file = new File(ActivityGrid.this.mHomePath, str);
                File file2 = new File(ActivityGrid.this.mHomePath, trim);
                if (file.exists()) {
                    file.renameTo(file2);
                }
                ActivityGrid.this.doc_name.setText(trim);
                ActivityGrid.document_name = trim;
                String unused = ActivityGrid.this.textDocName = ActivityGrid.document_name;
                ActivityGrid.this.buildRecyclerView();
                ActivityGrid.this.mydialogue.dismiss();
            }
        });
        this.mydialogue.show();
    }

    /* access modifiers changed from: private */
    public void passwordProtectPDF() {
        MaterialDialog build = new MaterialDialog.Builder(this).title("Set Password").customView(R.layout.dialog_password, true).positiveText(17039370).negativeText(17039360).neutralText("Remove").build();
        final MDButton actionButton = build.getActionButton(DialogAction.POSITIVE);
        MDButton actionButton2 = build.getActionButton(DialogAction.NEUTRAL);
        EditText editText = (EditText) build.getCustomView().findViewById(R.id.password);
        editText.setText(this.mPdfOptions.getPassword());
        editText.addTextChangedListener(new TextWatcher() {
            /* class com.applex.snaplingo.ActivityGrid.AnonymousClass12 */

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                actionButton.setEnabled(charSequence.toString().trim().length() > 0);
            }
        });
        actionButton.setOnClickListener(new View.OnClickListener(editText, build) {
            /* class com.applex.snaplingo.$$Lambda$ActivityGrid$hSMis1PEvzBzeG5CHpHBAPjZ2M */
            public final /* synthetic */ EditText f$1;
            public final /* synthetic */ MaterialDialog f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                ActivityGrid.this.lambda$passwordProtectPDF$0$ActivityGrid(this.f$1, this.f$2, view);
            }
        });
        if (this.mPdfOptions.getPassword() != null && !this.mPdfOptions.getPassword().isEmpty()) {
            actionButton2.setOnClickListener(new View.OnClickListener(build) {
                /* class com.applex.snaplingo.$$Lambda$ActivityGrid$D0YvIM7d3vbvAjblATYXpRkJZqo */
                public final /* synthetic */ MaterialDialog f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    ActivityGrid.this.lambda$passwordProtectPDF$1$ActivityGrid(this.f$1, view);
                }
            });
        }
        build.show();
        actionButton.setEnabled(false);
    }

    public /* synthetic */ void lambda$passwordProtectPDF$0$ActivityGrid(EditText editText, MaterialDialog materialDialog, View view) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Password can not be empty", 0).show();
            return;
        }
        Toast.makeText(this, "Password set", 0).show();
        this.mPdfOptions.setPassword(editText.getText().toString());
        this.mPdfOptions.setPasswordProtected(true);
        this.lock.setColorFilter(getResources().getColor(R.color.colorRed), PorterDuff.Mode.SRC_IN);
        materialDialog.dismiss();
    }

    public /* synthetic */ void lambda$passwordProtectPDF$1$ActivityGrid(MaterialDialog materialDialog, View view) {
        this.mPdfOptions.setPassword(null);
        this.mPdfOptions.setPasswordProtected(false);
        this.lock.setColorFilter(getResources().getColor(R.color.colorAtt), PorterDuff.Mode.SRC_IN);
        materialDialog.dismiss();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null && i == 13) {
            int size = this.mImagesUri.size();
            this.mImagesUri.addAll(Matisse.obtainPathResult(intent));
            File file = new File(Environment.getExternalStorageDirectory() + "/SnapLingo/.documents", this.textDocName);
            file.mkdirs();
            if (!file.exists()) {
                file.mkdir();
            }
            if (this.mImagesUri.size() > 0) {
                for (int i3 = size; i3 < this.mImagesUri.size(); i3++) {
                    File file2 = new File(this.mImagesUri.get(i3));
                    File file3 = new File(Environment.getExternalStorageDirectory() + "/SnapLingo/.documents/" + this.textDocName + Constants.PATH_SEPERATOR, i3 + ".jpg");
                    File file4 = null;
                    try {
                        file4 = new Compressor(this).compressToFile(file2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    copy(file4, file3);
                    if (i3 == this.mImagesUri.size() - 1) {
                        Intent intent2 = new Intent(this, ViewPager.class);
                        intent2.putExtra("from", ExifInterface.GPS_MEASUREMENT_3D);
                        intent2.putExtra("pos", Integer.toString(size));
                        intent2.putExtra("docName", this.textDocName);
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
        throw new UnsupportedOperationException("Method not decompiled: com.applex.snaplingo.ActivityGrid.copy(java.io.File, java.io.File):void");
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
                ActivityGrid.this.saveToInternalStorage(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), new File(Environment.getExternalStorageDirectory() + "/SnapLingo/.documents/" + ActivityGrid.this.textDocName + Constants.PATH_SEPERATOR, this.i + ".jpg"));
                if (this.i == (ActivityGrid.this.mImagesUri.size() + ActivityGrid.this.mImages.size()) - 1) {
                    Intent intent = new Intent(ActivityGrid.this, ViewPager.class);
                    intent.putExtra("from", ExifInterface.GPS_MEASUREMENT_3D);
                    intent.putExtra("pos", Integer.toString(ActivityGrid.this.mImagesUri.size()));
                    intent.putExtra("docName", ActivityGrid.this.doc_name.getText().toString());
                    ActivityGrid.this.startActivity(intent);
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

    private void createList() {
        this.mImagesUri.clear();
        if (getIntent().getStringExtra("path") != null) {
            File[] listFiles = new File(Environment.getExternalStorageDirectory() + "/SnapLingo/.documents/" + document_name + Constants.PATH_SEPERATOR).listFiles();
            if (listFiles != null && listFiles.length > 1) {
                Arrays.sort(listFiles, new Comparator<File>() {
                    /* class com.applex.snaplingo.ActivityGrid.AnonymousClass13 */

                    public int compare(File file, File file2) {
                        return file.getName().compareTo(file2.getName());
                    }
                });
            }
            if (listFiles != null) {
                for (File file : listFiles) {
                    this.mImagesUri.add(Uri.fromFile(new File(file.getAbsolutePath())).toString());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void buildRecyclerView() {
        createList();
        ImageGridAdapter imageGridAdapter = new ImageGridAdapter(this.mImagesUri, this);
        this.imageAdapter = imageGridAdapter;
        imageGridAdapter.onClickListener(new ImageGridAdapter.OnClickListener() {
            /* class com.applex.snaplingo.ActivityGrid.AnonymousClass14 */

            @Override // com.applex.snaplingo.adapters.ImageGridAdapter.OnClickListener
            public void onClickListener(int i) {
                new AlertDialog.Builder(ActivityGrid.this).setTitle("Delete page").setMessage("Are your sure?").setPositiveButton("Delete", new DialogInterface.OnClickListener(i) {
                    /* class com.applex.snaplingo.$$Lambda$ActivityGrid$14$EjSjxgeWiBuOEakYUeTaE6dJqqA */
                    public final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ActivityGrid.AnonymousClass14.this.lambda$onClickListener$0$ActivityGrid$14(this.f$1, dialogInterface, i);
                    }
                }).setNegativeButton("Cancel", $$Lambda$ActivityGrid$14$RQjIEqAxNVGomwNZHWbRpW6WNY.INSTANCE).setCancelable(true).show();
            }

            public /* synthetic */ void lambda$onClickListener$0$ActivityGrid$14(int i, DialogInterface dialogInterface, int i2) {
                String str = Environment.getExternalStorageDirectory() + "/SnapLingo/.documents/" + ActivityGrid.document_name + Constants.PATH_SEPERATOR;
                new File(str, i + ".jpg").delete();
                ActivityGrid.this.mImagesUri.remove(i);
                File file = new File(str);
                if (file.exists()) {
                    String[] list = file.list();
                    while (i < list.length) {
                        new File(file, list[i]).renameTo(new File(str, i + ".jpg"));
                        i++;
                    }
                }
                ActivityGrid.this.buildRecyclerView();
            }
        });
        this.mImagesGrid.setAdapter(this.imageAdapter);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        buildRecyclerView();
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
        throw new UnsupportedOperationException("Method not decompiled: com.applex.snaplingo.ActivityGrid.saveToInternalStorage(android.graphics.Bitmap, java.io.File):void");
    }
}
