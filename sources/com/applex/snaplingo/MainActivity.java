package com.applex.snaplingo;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.SparseArray;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.applex.snaplingo.LinkPreview.ApplexLinkPreviewShort;
import com.applex.snaplingo.LinkPreview.ViewListener;
import com.applex.snaplingo.util.Constants;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.WriterException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.i18n.TextBundle;

public class MainActivity extends AppCompatActivity {
    static String OCRtext = "";
    public static Uri image_uri = null;
    public static int itemID = -1;
    public static EditText mResultEt;
    public static Uri resultUri;
    Bitmap bitmap;
    private LinearLayout btnLocate;
    private LinearLayout btnSearch;
    private LinearLayout btnTranslate;
    private Button btnVisit;
    private CardView cd;
    private ConnectivityManager cm;
    private ImageButton cpy_btn;
    /* access modifiers changed from: private */
    public FloatingActionMenu flmenu;
    private LinearLayout fullView;
    private TextView imgprev;
    /* access modifiers changed from: private */
    public ApplexLinkPreviewShort linkPreviewShort;
    private AdView mAdView;
    private DatabaseHelper myDB;
    /* access modifiers changed from: private */
    public Dialog mydialogue;
    /* access modifiers changed from: private */
    public Uri path;
    private PhotoView pv;
    /* access modifiers changed from: private */
    public RelativeLayout relativeLayout;
    private int sel = 5;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolb));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        this.mAdView = (AdView) findViewById(R.id.ad_view);
        this.mAdView.loadAd(new AdRequest.Builder().build());
        this.cm = (ConnectivityManager) getSystemService("connectivity");
        this.mydialogue = new Dialog(this);
        this.myDB = new DatabaseHelper(this);
        this.relativeLayout = (RelativeLayout) findViewById(R.id.rel_main);
        this.btnLocate = (LinearLayout) findViewById(R.id.button1);
        this.btnTranslate = (LinearLayout) findViewById(R.id.button2);
        this.btnSearch = (LinearLayout) findViewById(R.id.button3);
        this.btnVisit = (Button) findViewById(R.id.visitButton);
        this.cpy_btn = (ImageButton) findViewById(R.id.etbtn_copy);
        this.fullView = (LinearLayout) findViewById(R.id.expand);
        this.linkPreviewShort = (ApplexLinkPreviewShort) findViewById(R.id.link_preview);
        this.cd = (CardView) findViewById(R.id.card);
        this.imgprev = (TextView) findViewById(R.id.imgprev);
        mResultEt = (EditText) findViewById(R.id.resultEt);
        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        this.pv = photoView;
        photoView.setZoomable(true);
        this.pv.setAdjustViewBounds(Boolean.FALSE.booleanValue());
        this.pv.setFitsSystemWindows(Boolean.TRUE.booleanValue());
        if (this.pv.getImageMatrix() == null) {
            this.imgprev.setVisibility(8);
            this.pv.setVisibility(8);
        } else {
            this.imgprev.setVisibility(0);
            this.pv.setVisibility(0);
        }
        FloatingActionMenu floatingActionMenu = (FloatingActionMenu) findViewById(R.id.menu);
        this.flmenu = floatingActionMenu;
        floatingActionMenu.close(true);
        ((FloatingActionButton) findViewById(R.id.doc)).setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity.AnonymousClass1 */

            public void onClick(View view) {
                if (MainActivity.mResultEt.length() != 0) {
                    MainActivity.this.databaseAdder(0);
                    MainActivity.this.saveDoc();
                    return;
                }
                Toast.makeText(MainActivity.this, "Field empty...", 0).show();
            }
        });
        ((FloatingActionButton) findViewById(R.id.pdf)).setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity.AnonymousClass2 */

            public void onClick(View view) {
                if (MainActivity.mResultEt.length() != 0) {
                    MainActivity.this.databaseAdder(0);
                    MainActivity.this.savePdf();
                    return;
                }
                Toast.makeText(MainActivity.this, "Field empty...", 0).show();
            }
        });
        ((FloatingActionButton) findViewById(R.id.qr)).setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity.AnonymousClass3 */

            public void onClick(View view) {
                if (MainActivity.mResultEt.length() != 0) {
                    MainActivity.this.GenerateQR(MainActivity.mResultEt.getText().toString());
                } else {
                    Toast.makeText(MainActivity.this, "Field empty...", 0).show();
                }
            }
        });
        this.btnLocate.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity.AnonymousClass4 */

            public void onClick(View view) {
                if (MainActivity.mResultEt.length() != 0) {
                    MainActivity.this.databaseAdder(0);
                    MainActivity.this.Locate();
                    return;
                }
                Toast.makeText(MainActivity.this, "Field empty...", 0).show();
            }
        });
        this.btnTranslate.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity.AnonymousClass5 */

            public void onClick(View view) {
                if (MainActivity.mResultEt.length() != 0) {
                    MainActivity.this.databaseAdder(0);
                    MainActivity.this.Translate();
                    return;
                }
                Toast.makeText(MainActivity.this, "Field empty...", 0).show();
            }
        });
        this.btnSearch.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity.AnonymousClass6 */

            public void onClick(View view) {
                if (MainActivity.mResultEt.length() != 0) {
                    MainActivity.this.databaseAdder(0);
                    MainActivity.this.Search();
                    return;
                }
                Toast.makeText(MainActivity.this, "Field empty...", 0).show();
            }
        });
        this.cpy_btn.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity.AnonymousClass7 */

            public void onClick(View view) {
                if (MainActivity.mResultEt.length() != 0) {
                    MainActivity.this.databaseAdder(0);
                    ((ClipboardManager) MainActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Copied", MainActivity.mResultEt.getText().toString().replaceAll("\n", " ")));
                    Toast.makeText(MainActivity.this, "Copied to clipboard", 0).show();
                    return;
                }
                Toast.makeText(MainActivity.this, "Field empty...", 0).show();
            }
        });
        this.fullView.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity.AnonymousClass8 */

            public void onClick(View view) {
                MainActivity.this.flmenu.close(true);
                Intent intent = new Intent(MainActivity.this, DocView.class);
                ActivityOptionsCompat makeSceneTransitionAnimation = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, MainActivity.mResultEt, ViewCompat.getTransitionName(MainActivity.mResultEt));
                intent.putExtra("OCRtext", MainActivity.mResultEt.getText().toString());
                MainActivity.this.startActivity(intent, makeSceneTransitionAnimation.toBundle());
            }
        });
        this.pv.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity.AnonymousClass9 */

            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Tap & hold to crop", 0).show();
            }
        });
        this.pv.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.applex.snaplingo.MainActivity.AnonymousClass10 */

            public boolean onLongClick(View view) {
                CropImage.activity(MainActivity.image_uri).setActivityTitle("SnapCrop").setCropMenuCropButtonTitle("Set").setAllowRotation(Boolean.TRUE.booleanValue()).setAllowCounterRotation(Boolean.TRUE.booleanValue()).setAllowFlipping(Boolean.TRUE.booleanValue()).setAutoZoomEnabled(Boolean.TRUE.booleanValue()).setMultiTouchEnabled(Boolean.FALSE.booleanValue()).setGuidelines(CropImageView.Guidelines.ON).start(MainActivity.this);
                return true;
            }
        });
        Intent intent = getIntent();
        if (intent.getStringExtra("selection") != null) {
            this.sel = Integer.parseInt(intent.getStringExtra("selection"));
        }
        String action = intent.getAction();
        String type = intent.getType();
        if (!"android.intent.action.SEND".equals(action) || type == null) {
            int i = this.sel;
            if (i == 3) {
                this.btnVisit.setVisibility(8);
                this.pv.setVisibility(8);
                this.imgprev.setVisibility(8);
                mResultEt.setMinHeight(CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA);
                mResultEt.setText(getIntent().getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME));
                OCRtext = mResultEt.getText().toString();
                if (mResultEt.length() != 0) {
                    if (mResultEt.getUrls().length > 0) {
                        String url = mResultEt.getUrls()[0].getURL();
                        if (url.contains("http")) {
                            this.linkPreviewShort.setVisibility(0);
                            this.linkPreviewShort.setLink(url, new ViewListener() {
                                /* class com.applex.snaplingo.MainActivity.AnonymousClass12 */

                                @Override // com.applex.snaplingo.LinkPreview.ViewListener
                                public void onSuccess(boolean z) {
                                }

                                @Override // com.applex.snaplingo.LinkPreview.ViewListener
                                public void onError(Exception exc) {
                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                        /* class com.applex.snaplingo.MainActivity.AnonymousClass12.AnonymousClass1 */

                                        public void run() {
                                            MainActivity.this.linkPreviewShort.setVisibility(8);
                                        }
                                    });
                                }
                            });
                        }
                    }
                    databaseAdder(0);
                }
            } else if (i == 2) {
                this.pv.setVisibility(8);
                this.imgprev.setVisibility(8);
                mResultEt.setMinHeight(CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA);
                final String stringExtra = getIntent().getStringExtra(TextBundle.TEXT_ENTRY);
                mResultEt.setText(stringExtra);
                if (mResultEt.length() != 0) {
                    if (mResultEt.getUrls().length > 0) {
                        String url2 = mResultEt.getUrls()[0].getURL();
                        if (url2.contains("http")) {
                            this.btnVisit.setVisibility(0);
                            this.linkPreviewShort.setVisibility(0);
                            this.linkPreviewShort.setLink(url2, new ViewListener() {
                                /* class com.applex.snaplingo.MainActivity.AnonymousClass13 */

                                @Override // com.applex.snaplingo.LinkPreview.ViewListener
                                public void onSuccess(boolean z) {
                                }

                                @Override // com.applex.snaplingo.LinkPreview.ViewListener
                                public void onError(Exception exc) {
                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                        /* class com.applex.snaplingo.MainActivity.AnonymousClass13.AnonymousClass1 */

                                        public void run() {
                                            MainActivity.this.linkPreviewShort.setVisibility(8);
                                        }
                                    });
                                }
                            });
                        }
                    }
                    databaseAdder(0);
                }
                this.btnVisit.setOnClickListener(new View.OnClickListener() {
                    /* class com.applex.snaplingo.MainActivity.AnonymousClass14 */

                    public void onClick(View view) {
                        MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringExtra)));
                    }
                });
            } else if (i == 1) {
                this.btnVisit.setVisibility(8);
                this.pv.setVisibility(0);
                this.imgprev.setVisibility(0);
                this.pv.setImageURI(resultUri);
                String stringExtra2 = getIntent().getStringExtra("Text");
                OCRtext = stringExtra2;
                mResultEt.setText(stringExtra2);
                if (mResultEt.getUrls().length > 0) {
                    String url3 = mResultEt.getUrls()[0].getURL();
                    if (url3.contains("http")) {
                        this.linkPreviewShort.setVisibility(0);
                        this.linkPreviewShort.setLink(url3, new ViewListener() {
                            /* class com.applex.snaplingo.MainActivity.AnonymousClass15 */

                            @Override // com.applex.snaplingo.LinkPreview.ViewListener
                            public void onSuccess(boolean z) {
                            }

                            @Override // com.applex.snaplingo.LinkPreview.ViewListener
                            public void onError(Exception exc) {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    /* class com.applex.snaplingo.MainActivity.AnonymousClass15.AnonymousClass1 */

                                    public void run() {
                                        MainActivity.this.linkPreviewShort.setVisibility(8);
                                    }
                                });
                            }
                        });
                    }
                }
            } else if (i == 5) {
                mResultEt.setHint("Start typing...");
                this.pv.setVisibility(8);
                this.imgprev.setVisibility(8);
                this.btnVisit.setVisibility(8);
                mResultEt.setMinHeight(CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA);
            } else if (i == 6) {
                this.btnVisit.setVisibility(8);
                if (intent.getStringExtra("path") != null) {
                    Uri fromFile = Uri.fromFile(new File(getIntent().getStringExtra("path")));
                    image_uri = fromFile;
                    if (fromFile != null) {
                        CropImage.activity(fromFile).setActivityTitle("SnapCrop").setCropMenuCropButtonTitle("Set").setAllowRotation(Boolean.TRUE.booleanValue()).setAllowCounterRotation(Boolean.TRUE.booleanValue()).setAllowFlipping(Boolean.TRUE.booleanValue()).setAutoZoomEnabled(Boolean.TRUE.booleanValue()).setMultiTouchEnabled(Boolean.FALSE.booleanValue()).setGuidelines(CropImageView.Guidelines.ON).start(this);
                        return;
                    }
                    return;
                }
                Toast.makeText(getApplicationContext(), "Failed", 0).show();
            }
        } else {
            this.btnVisit.setVisibility(8);
            this.pv.setVisibility(0);
            this.imgprev.setVisibility(0);
            if ("text/plain".equals(type)) {
                String stringExtra3 = intent.getStringExtra("android.intent.extra.TEXT");
                if (stringExtra3 != null) {
                    mResultEt.setText(stringExtra3);
                    if (mResultEt.getUrls().length > 0) {
                        String url4 = mResultEt.getUrls()[0].getURL();
                        if (url4.contains("http")) {
                            this.linkPreviewShort.setVisibility(0);
                            this.linkPreviewShort.setLink(url4, new ViewListener() {
                                /* class com.applex.snaplingo.MainActivity.AnonymousClass11 */

                                @Override // com.applex.snaplingo.LinkPreview.ViewListener
                                public void onSuccess(boolean z) {
                                }

                                @Override // com.applex.snaplingo.LinkPreview.ViewListener
                                public void onError(Exception exc) {
                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                        /* class com.applex.snaplingo.MainActivity.AnonymousClass11.AnonymousClass1 */

                                        public void run() {
                                            MainActivity.this.linkPreviewShort.setVisibility(8);
                                        }
                                    });
                                }
                            });
                        }
                    }
                    OCRtext = mResultEt.getText().toString();
                    databaseAdder(0);
                }
            } else if (type.startsWith("image/")) {
                Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
                image_uri = uri;
                if (uri != null) {
                    CropImage.activity(uri).setActivityTitle("SnapCrop").setCropMenuCropButtonTitle("Set").setAllowRotation(Boolean.TRUE.booleanValue()).setAllowCounterRotation(Boolean.TRUE.booleanValue()).setAllowFlipping(Boolean.TRUE.booleanValue()).setAutoZoomEnabled(Boolean.TRUE.booleanValue()).setMultiTouchEnabled(Boolean.FALSE.booleanValue()).setGuidelines(CropImageView.Guidelines.ON).start(this);
                }
            }
        }
    }

    public void Search() {
        if (this.cm.getActiveNetworkInfo() == null) {
            Toast.makeText(this, "Please check your internet connection and try again...", 0).show();
        } else if (mResultEt.length() != 0) {
            try {
                Intent intent = new Intent("android.intent.action.WEB_SEARCH");
                intent.putExtra(SearchIntents.EXTRA_QUERY, mResultEt.getText().toString());
                startActivity(intent);
            } catch (Exception unused) {
            }
        } else {
            Toast.makeText(this, "No text found :(", 0).show();
        }
    }

    public void Translate() {
        if (this.cm.getActiveNetworkInfo() == null) {
            Toast.makeText(this, "Please check your internet connection and try again...", 0).show();
        } else if (mResultEt.length() != 0) {
            ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Copied", mResultEt.getText().toString()));
            String replaceAll = mResultEt.getText().toString().replaceAll(" ", "+");
            Intent intent = new Intent(this, WebViewTranslate.class);
            intent.putExtra("bool", ExifInterface.GPS_MEASUREMENT_3D);
            intent.putExtra(TextBundle.TEXT_ENTRY, replaceAll);
            startActivity(intent);
        } else {
            Toast.makeText(this, "No text found :(", 0).show();
        }
    }

    public void Locate() {
        if (this.cm.getActiveNetworkInfo() == null) {
            Toast.makeText(this, "Please check your internet connection and try again...", 0).show();
        } else if (mResultEt.length() != 0) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?z=15&q=" + Uri.encode(mResultEt.getText().toString())));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        } else {
            Toast.makeText(this, "Field Empty", 0).show();
        }
    }

    /* access modifiers changed from: private */
    public void savePdf() {
        Dialog dialog = new Dialog(this);
        this.mydialogue = dialog;
        dialog.setContentView(R.layout.dialog_file_name);
        this.mydialogue.setCanceledOnTouchOutside(Boolean.TRUE.booleanValue());
        this.mydialogue.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) this.mydialogue.findViewById(R.id.extension)).setText(getString(R.string.pdf));
        final EditText editText = (EditText) this.mydialogue.findViewById(R.id.fname);
        final String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
        editText.setHint(format);
        ((TextView) this.mydialogue.findViewById(R.id.save)).setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity.AnonymousClass16 */

            public void onClick(View view) {
                if (editText.length() != 0) {
                    Document document = new Document();
                    final String replaceAll = editText.getText().toString().trim().replaceAll(" ", "_");
                    new File(Environment.getExternalStorageDirectory() + "/SnapLingo", "Pdf").mkdirs();
                    final String str = Environment.getExternalStorageDirectory() + "/SnapLingo/Pdf/" + replaceAll + Constants.pdfExtension;
                    try {
                        PdfWriter.getInstance(document, new FileOutputStream(str));
                        document.open();
                        document.add(new Paragraph(MainActivity.mResultEt.getText().toString().replaceAll("\n", " ")));
                        document.close();
                        Snackbar.make(MainActivity.this.flmenu, "PDF has been saved", 0).setAction("Share", new View.OnClickListener() {
                            /* class com.applex.snaplingo.MainActivity.AnonymousClass16.AnonymousClass1 */

                            public void onClick(View view) {
                                File file = new File(str);
                                if (file.exists()) {
                                    Uri unused = MainActivity.this.path = FileProvider.getUriForFile(MainActivity.this, Constants.AUTHORITY_APP, file);
                                    Intent intent = new Intent();
                                    intent.setAction("android.intent.action.SEND");
                                    intent.putExtra("android.intent.extra.TEXT", "sharing");
                                    intent.putExtra("android.intent.extra.STREAM", MainActivity.this.path);
                                    intent.addFlags(1);
                                    intent.setType("Document/*");
                                    MainActivity.this.startActivity(Intent.createChooser(intent, "SHARE"));
                                    return;
                                }
                                MainActivity mainActivity = MainActivity.this;
                                Toast.makeText(mainActivity, replaceAll + " missing " + str, 1).show();
                            }
                        }).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), 0).show();
                    }
                } else {
                    Document document2 = new Document();
                    final String str2 = format;
                    new File(Environment.getExternalStorageDirectory() + "/SnapLingo", "Pdf").mkdirs();
                    final String str3 = Environment.getExternalStorageDirectory() + "/SnapLingo/Pdf/" + str2 + Constants.pdfExtension;
                    try {
                        PdfWriter.getInstance(document2, new FileOutputStream(str3));
                        document2.open();
                        document2.add(new Paragraph(MainActivity.mResultEt.getText().toString().replaceAll("\n", " ")));
                        document2.close();
                        Snackbar.make(MainActivity.this.flmenu, "PDF has been saved", 0).setAction("Share", new View.OnClickListener() {
                            /* class com.applex.snaplingo.MainActivity.AnonymousClass16.AnonymousClass2 */

                            public void onClick(View view) {
                                File file = new File(str3);
                                if (file.exists()) {
                                    Uri unused = MainActivity.this.path = FileProvider.getUriForFile(MainActivity.this, "com.sourajit.snaptext.fileprovider", file);
                                    Intent intent = new Intent();
                                    intent.setAction("android.intent.action.SEND");
                                    intent.putExtra("android.intent.extra.TEXT", "sharing");
                                    intent.putExtra("android.intent.extra.STREAM", MainActivity.this.path);
                                    intent.addFlags(1);
                                    intent.setType("Document/*");
                                    MainActivity.this.startActivity(Intent.createChooser(intent, "SHARE"));
                                    return;
                                }
                                MainActivity mainActivity = MainActivity.this;
                                Toast.makeText(mainActivity, str2 + " missing " + str3, 1).show();
                            }
                        }).show();
                    } catch (Exception e2) {
                        Toast.makeText(MainActivity.this, e2.getMessage(), 0).show();
                    }
                }
                MainActivity.this.mydialogue.dismiss();
                MainActivity.this.flmenu.close(true);
            }
        });
        this.mydialogue.show();
    }

    /* access modifiers changed from: private */
    public void saveDoc() {
        Dialog dialog = new Dialog(this);
        this.mydialogue = dialog;
        dialog.setContentView(R.layout.dialog_file_name);
        this.mydialogue.setCanceledOnTouchOutside(Boolean.TRUE.booleanValue());
        this.mydialogue.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) this.mydialogue.findViewById(R.id.extension)).setText(getString(R.string.txt));
        final EditText editText = (EditText) this.mydialogue.findViewById(R.id.fname);
        final String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
        editText.setHint(format);
        ((TextView) this.mydialogue.findViewById(R.id.save)).setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity.AnonymousClass17 */

            /* JADX WARNING: Removed duplicated region for block: B:18:0x00da  */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x00e7 A[SYNTHETIC, Splitter:B:22:0x00e7] */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x019b  */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x01b9 A[SYNTHETIC, Splitter:B:49:0x01b9] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r14) {
                /*
                    r13 = this;
                    android.widget.EditText r14 = r1
                    int r14 = r14.length()
                    java.lang.String r0 = "Share"
                    java.lang.String r1 = "Doc. has been saved"
                    java.lang.String r2 = "/"
                    java.lang.String r3 = "/SnapLingo/Text doc"
                    java.lang.String r4 = "Text doc"
                    java.lang.String r5 = "/SnapLingo"
                    java.lang.String r6 = "\n"
                    r7 = 0
                    java.lang.String r8 = ".txt"
                    java.lang.String r9 = " "
                    r10 = 0
                    if (r14 == 0) goto L_0x00f0
                    java.lang.StringBuilder r14 = new java.lang.StringBuilder
                    r14.<init>()
                    android.widget.EditText r11 = r1
                    android.text.Editable r11 = r11.getText()
                    java.lang.String r11 = r11.toString()
                    java.lang.String r11 = r11.trim()
                    java.lang.String r12 = "_"
                    java.lang.String r11 = r11.replaceAll(r9, r12)
                    r14.append(r11)
                    r14.append(r8)
                    java.lang.String r14 = r14.toString()
                    android.widget.EditText r8 = com.applex.snaplingo.MainActivity.mResultEt     // Catch:{ Exception -> 0x00ca }
                    android.text.Editable r8 = r8.getText()     // Catch:{ Exception -> 0x00ca }
                    java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00ca }
                    java.lang.String r6 = r8.replaceAll(r6, r9)     // Catch:{ Exception -> 0x00ca }
                    java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x00ca }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ca }
                    r9.<init>()     // Catch:{ Exception -> 0x00ca }
                    java.io.File r11 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00ca }
                    r9.append(r11)     // Catch:{ Exception -> 0x00ca }
                    r9.append(r5)     // Catch:{ Exception -> 0x00ca }
                    java.lang.String r5 = r9.toString()     // Catch:{ Exception -> 0x00ca }
                    r8.<init>(r5, r4)     // Catch:{ Exception -> 0x00ca }
                    r8.mkdirs()     // Catch:{ Exception -> 0x00ca }
                    java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00ca }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ca }
                    r5.<init>()     // Catch:{ Exception -> 0x00ca }
                    java.io.File r8 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00ca }
                    r5.append(r8)     // Catch:{ Exception -> 0x00ca }
                    r5.append(r3)     // Catch:{ Exception -> 0x00ca }
                    java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x00ca }
                    r4.<init>(r3, r14)     // Catch:{ Exception -> 0x00ca }
                    java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00ca }
                    r3.<init>(r4)     // Catch:{ Exception -> 0x00ca }
                    byte[] r5 = r6.getBytes()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    r3.write(r5)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    r3.close()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    r5.<init>()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    com.applex.snaplingo.MainActivity r6 = com.applex.snaplingo.MainActivity.this     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    java.io.File r6 = r6.getFilesDir()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    r5.append(r6)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    r5.append(r2)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    r5.append(r14)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    com.applex.snaplingo.MainActivity r5 = com.applex.snaplingo.MainActivity.this     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    android.widget.RelativeLayout r5 = r5.relativeLayout     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    com.google.android.material.snackbar.Snackbar r1 = com.google.android.material.snackbar.Snackbar.make(r5, r1, r10)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    com.applex.snaplingo.MainActivity$17$1 r5 = new com.applex.snaplingo.MainActivity$17$1     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    r5.<init>(r4, r14, r2)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    com.google.android.material.snackbar.Snackbar r14 = r1.setAction(r0, r5)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    r14.show()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    r3.close()     // Catch:{ IOException -> 0x00df }
                    goto L_0x01a3
                L_0x00c2:
                    r14 = move-exception
                    r7 = r3
                    goto L_0x00e5
                L_0x00c5:
                    r14 = move-exception
                    r7 = r3
                    goto L_0x00cb
                L_0x00c8:
                    r14 = move-exception
                    goto L_0x00e5
                L_0x00ca:
                    r14 = move-exception
                L_0x00cb:
                    com.applex.snaplingo.MainActivity r0 = com.applex.snaplingo.MainActivity.this     // Catch:{ all -> 0x00c8 }
                    java.lang.String r14 = r14.getMessage()     // Catch:{ all -> 0x00c8 }
                    android.widget.Toast r14 = android.widget.Toast.makeText(r0, r14, r10)     // Catch:{ all -> 0x00c8 }
                    r14.show()     // Catch:{ all -> 0x00c8 }
                    if (r7 == 0) goto L_0x01a3
                    r7.close()
                    goto L_0x01a3
                L_0x00df:
                    r14 = move-exception
                    r14.printStackTrace()
                    goto L_0x01a3
                L_0x00e5:
                    if (r7 == 0) goto L_0x00ef
                    r7.close()     // Catch:{ IOException -> 0x00eb }
                    goto L_0x00ef
                L_0x00eb:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x00ef:
                    throw r14
                L_0x00f0:
                    java.lang.StringBuilder r14 = new java.lang.StringBuilder
                    r14.<init>()
                    java.lang.String r11 = r2
                    r14.append(r11)
                    r14.append(r8)
                    java.lang.String r14 = r14.toString()
                    android.widget.EditText r8 = com.applex.snaplingo.MainActivity.mResultEt     // Catch:{ Exception -> 0x018b }
                    android.text.Editable r8 = r8.getText()     // Catch:{ Exception -> 0x018b }
                    java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x018b }
                    java.lang.String r6 = r8.replaceAll(r6, r9)     // Catch:{ Exception -> 0x018b }
                    java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x018b }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018b }
                    r9.<init>()     // Catch:{ Exception -> 0x018b }
                    java.io.File r11 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x018b }
                    r9.append(r11)     // Catch:{ Exception -> 0x018b }
                    r9.append(r5)     // Catch:{ Exception -> 0x018b }
                    java.lang.String r5 = r9.toString()     // Catch:{ Exception -> 0x018b }
                    r8.<init>(r5, r4)     // Catch:{ Exception -> 0x018b }
                    r8.mkdirs()     // Catch:{ Exception -> 0x018b }
                    java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x018b }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018b }
                    r5.<init>()     // Catch:{ Exception -> 0x018b }
                    java.io.File r8 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x018b }
                    r5.append(r8)     // Catch:{ Exception -> 0x018b }
                    r5.append(r3)     // Catch:{ Exception -> 0x018b }
                    java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x018b }
                    r4.<init>(r3, r14)     // Catch:{ Exception -> 0x018b }
                    java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x018b }
                    r3.<init>(r4)     // Catch:{ Exception -> 0x018b }
                    byte[] r5 = r6.getBytes()     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r3.write(r5)     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r3.close()     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r5.<init>()     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    com.applex.snaplingo.MainActivity r6 = com.applex.snaplingo.MainActivity.this     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    java.io.File r6 = r6.getFilesDir()     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r5.append(r6)     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r5.append(r2)     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r5.append(r14)     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    com.applex.snaplingo.MainActivity r5 = com.applex.snaplingo.MainActivity.this     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    android.widget.RelativeLayout r5 = r5.relativeLayout     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    com.google.android.material.snackbar.Snackbar r1 = com.google.android.material.snackbar.Snackbar.make(r5, r1, r10)     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    com.applex.snaplingo.MainActivity$17$2 r5 = new com.applex.snaplingo.MainActivity$17$2     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r5.<init>(r4, r14, r2)     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    com.google.android.material.snackbar.Snackbar r14 = r1.setAction(r0, r5)     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r14.show()     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r3.close()     // Catch:{ IOException -> 0x019f }
                    goto L_0x01a3
                L_0x0183:
                    r14 = move-exception
                    r7 = r3
                    goto L_0x01b7
                L_0x0186:
                    r14 = move-exception
                    r7 = r3
                    goto L_0x018c
                L_0x0189:
                    r14 = move-exception
                    goto L_0x01b7
                L_0x018b:
                    r14 = move-exception
                L_0x018c:
                    com.applex.snaplingo.MainActivity r0 = com.applex.snaplingo.MainActivity.this     // Catch:{ all -> 0x0189 }
                    java.lang.String r14 = r14.getMessage()     // Catch:{ all -> 0x0189 }
                    android.widget.Toast r14 = android.widget.Toast.makeText(r0, r14, r10)     // Catch:{ all -> 0x0189 }
                    r14.show()     // Catch:{ all -> 0x0189 }
                    if (r7 == 0) goto L_0x01a3
                    r7.close()
                    goto L_0x01a3
                L_0x019f:
                    r14 = move-exception
                    r14.printStackTrace()
                L_0x01a3:
                    com.applex.snaplingo.MainActivity r14 = com.applex.snaplingo.MainActivity.this
                    android.app.Dialog r14 = r14.mydialogue
                    r14.dismiss()
                    com.applex.snaplingo.MainActivity r14 = com.applex.snaplingo.MainActivity.this
                    com.github.clans.fab.FloatingActionMenu r14 = r14.flmenu
                    r0 = 1
                    r14.close(r0)
                    return
                L_0x01b7:
                    if (r7 == 0) goto L_0x01c1
                    r7.close()     // Catch:{ IOException -> 0x01bd }
                    goto L_0x01c1
                L_0x01bd:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x01c1:
                    throw r14
                */
                throw new UnsupportedOperationException("Method not decompiled: com.applex.snaplingo.MainActivity.AnonymousClass17.onClick(android.view.View):void");
            }
        });
        this.mydialogue.show();
    }

    /* access modifiers changed from: private */
    public void GenerateQR(String str) {
        Dialog dialog = new Dialog(this);
        this.mydialogue = dialog;
        dialog.setContentView(R.layout.qrdialog);
        this.mydialogue.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        ImageView imageView = (ImageView) this.mydialogue.findViewById(R.id.qrImageview);
        ImageView imageView2 = (ImageView) this.mydialogue.findViewById(R.id.shareQr);
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getSize(point);
        int i = point.x;
        int i2 = point.y;
        if (i >= i2) {
            i = i2;
        }
        try {
            Bitmap encodeAsBitmap = new QRGEncoder(str, null, QRGContents.Type.TEXT, i).encodeAsBitmap();
            this.bitmap = encodeAsBitmap;
            imageView.setImageBitmap(encodeAsBitmap);
            this.flmenu.close(true);
        } catch (WriterException unused) {
        }
        this.mydialogue.show();
        imageView2.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity.AnonymousClass18 */

            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("*/*");
                MainActivity.this.bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new ByteArrayOutputStream());
                Uri parse = Uri.parse(MediaStore.Images.Media.insertImage(MainActivity.this.getContentResolver(), MainActivity.this.bitmap, String.valueOf(System.currentTimeMillis()), (String) null));
                intent.putExtra("android.intent.extra.TEXT", "Generate QRs with SnapLingo! If you haven't downloaded yet, click here: https://play.google.com/store/apps/details?id=com.applex.snaplingo ");
                intent.putExtra("android.intent.extra.STREAM", parse);
                MainActivity.this.startActivity(Intent.createChooser(intent, "Share QR"));
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 203) {
            CropImage.ActivityResult activityResult = CropImage.getActivityResult(intent);
            if (i2 == -1) {
                Uri uri = activityResult.getUri();
                resultUri = uri;
                this.pv.setImageURI(uri);
                Bitmap bitmap2 = ((BitmapDrawable) this.pv.getDrawable()).getBitmap();
                TextRecognizer build = new TextRecognizer.Builder(getApplicationContext()).build();
                if (!build.isOperational()) {
                    Toast.makeText(this, "Error", 0).show();
                    return;
                }
                SparseArray<TextBlock> detect = build.detect(new Frame.Builder().setBitmap(bitmap2).build());
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < detect.size(); i3++) {
                    sb.append(detect.valueAt(i3).getValue());
                    if (i3 != detect.size() - 1) {
                        sb.append("\n");
                    }
                }
                mResultEt.setText(sb.toString());
                if (mResultEt.length() != 0) {
                    OCRtext = mResultEt.getText().toString();
                    databaseAdder(0);
                }
            }
        } else if (i2 == 204) {
            Toast.makeText(this, "+error", 0).show();
        }
    }

    public void AddData(String str, String str2) {
        if (!this.myDB.addData2(str, str2)) {
            Toast.makeText(this, "Something went wrong :(", 0).show();
        }
    }

    public void databaseAdder(int i) {
        itemID = -1;
        String replaceAll = mResultEt.getText().toString().replaceAll("'", "''");
        if (this.sel == 3) {
            replaceAll = getIntent().getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME).replaceAll("'", "''");
        }
        Cursor itemId = this.myDB.getItemId(replaceAll);
        while (itemId.moveToNext()) {
            itemID = itemId.getInt(0);
        }
        if (itemID == -1 && this.sel != 3) {
            AddData(mResultEt.getText().toString(), DateFormat.getDateInstance().format(Calendar.getInstance().getTime()));
            Cursor itemId2 = this.myDB.getItemId(mResultEt.getText().toString().replaceAll("'", "''"));
            while (itemId2.moveToNext()) {
                itemID = itemId2.getInt(0);
            }
        } else if (itemID > -1 && i == 1) {
            String format = DateFormat.getDateInstance().format(Calendar.getInstance().getTime());
            this.myDB.deleteItem(itemID);
            AddData(mResultEt.getText().toString(), format);
            Cursor itemId3 = this.myDB.getItemId(mResultEt.getText().toString().replaceAll("'", "''"));
            while (itemId3.moveToNext()) {
                itemID = itemId3.getInt(0);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.Save && mResultEt.length() != 0) {
            databaseAdder(1);
            Toast.makeText(this, "Saved", 1).show();
            super.onBackPressed();
        }
        if (itemId == 16908332) {
            if (mResultEt.length() != 0) {
                databaseAdder(0);
            }
            if (isTaskRoot()) {
                startActivity(new Intent(this, MainActivity2.class));
            } else {
                super.onBackPressed();
            }
        } else if (itemId == R.id.share) {
            if (mResultEt.length() > 0) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", mResultEt.getText().toString());
                intent.setType("text/plain");
                startActivity(intent);
            } else {
                Toast.makeText(this, "No text found :(", 0).show();
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.flmenu.isOpened()) {
            this.flmenu.close(true);
            return;
        }
        if (mResultEt.length() != 0) {
            databaseAdder(0);
        }
        if (isTaskRoot()) {
            startActivity(new Intent(this, MainActivity2.class));
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        if (mResultEt.length() != 0) {
            OCRtext = mResultEt.getText().toString();
            databaseAdder(0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        if (mResultEt.length() != 0) {
            OCRtext = mResultEt.getText().toString();
            databaseAdder(0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        if (this.sel == 1 && resultUri == null) {
            Toast.makeText(this, "Image not Detected...", 0).show();
            startActivity(new Intent(this, MainActivity2.class));
        }
    }
}
