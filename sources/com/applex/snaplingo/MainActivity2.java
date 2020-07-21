package com.applex.snaplingo;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.applex.snaplingo.adapters.HomeTabAdapter;
import com.applex.snaplingo.fragments.DocumentFragment;
import com.applex.snaplingo.fragments.OcrFragment;
import com.applex.snaplingo.interfaces.OnPDFCreatedInterface;
import com.applex.snaplingo.util.Constants;
import com.applex.snaplingo.util.DialogUtils;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.theartofdev.edmodo.cropper.CropImage;
import java.io.File;
import java.io.IOException;
import org.spongycastle.i18n.TextBundle;

public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnPDFCreatedInterface {
    private static final int CAMERA_REQUEST_CODE = 200;
    static MainActivity2 instance;
    private Bitmap bitmap;
    public LinearLayout btnCamera;
    public LinearLayout btnGall;
    /* access modifiers changed from: private */
    public LinearLayout btnScan;
    private String[] cameraPermission;
    /* access modifiers changed from: private */
    public Boolean doubleBackPressed = false;
    /* access modifiers changed from: private */
    public ImageButton down;
    DrawerLayout drawer;
    /* access modifiers changed from: private */
    public ImageButton edit;
    /* access modifiers changed from: private */
    public MaterialDialog mMaterialDialog;
    private Dialog mydialogue;
    /* access modifiers changed from: private */
    public ImageButton up;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolb);
        setSupportActionBar(toolbar);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            /* class com.applex.snaplingo.MainActivity2.AnonymousClass1 */

            @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        this.cameraPermission = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
        this.drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        ((NavigationView) findViewById(R.id.nav_view)).setNavigationItemSelectedListener(this);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0);
        tabLayout.getTabAt(1);
        this.up = (ImageButton) findViewById(R.id.up);
        this.down = (ImageButton) findViewById(R.id.down);
        this.btnCamera = (LinearLayout) findViewById(R.id.button_snap);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.button_gallery);
        this.btnGall = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity2.AnonymousClass2 */

            public void onClick(View view) {
                MainActivity2.this.btnGall.startAnimation(AnimationUtils.loadAnimation(MainActivity2.this, R.anim.bounce));
                Toast.makeText(MainActivity2.this.getApplicationContext(), "HAHA", 0).show();
            }
        });
        this.btnCamera.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity2.AnonymousClass3 */

            public void onClick(View view) {
                MainActivity2.this.btnCamera.startAnimation(AnimationUtils.loadAnimation(MainActivity2.this, R.anim.bounce));
                Toast.makeText(MainActivity2.this.getApplicationContext(), "HAHA", 0).show();
            }
        });
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.button_scan);
        this.btnScan = linearLayout2;
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity2.AnonymousClass4 */

            public void onClick(View view) {
                MainActivity2.this.btnScan.startAnimation(AnimationUtils.loadAnimation(MainActivity2.this, R.anim.bounce));
                if (!MainActivity2.this.checkCameraPermission()) {
                    MainActivity2.this.requestCameraPermission();
                } else {
                    MainActivity2.this.startActivity(new Intent(MainActivity2.this, ScannerActivity.class));
                }
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(R.id.text_edit);
        this.edit = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity2.AnonymousClass5 */

            public void onClick(View view) {
                MainActivity2.this.edit.startAnimation(AnimationUtils.loadAnimation(MainActivity2.this, R.anim.bounce));
                MainActivity2.this.startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });
        this.down.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity2.AnonymousClass6 */

            public void onClick(View view) {
                Animation loadAnimation = AnimationUtils.loadAnimation(MainActivity2.this, R.anim.fade_in_rotate);
                Animation loadAnimation2 = AnimationUtils.loadAnimation(MainActivity2.this, R.anim.fade_out_rotate);
                Animation loadAnimation3 = AnimationUtils.loadAnimation(MainActivity2.this, R.anim.slide_down);
                Animation loadAnimation4 = AnimationUtils.loadAnimation(MainActivity2.this, R.anim.edit_slide_out);
                MainActivity2.this.down.startAnimation(loadAnimation2);
                MainActivity2.this.down.setVisibility(8);
                MainActivity2.this.up.startAnimation(loadAnimation);
                MainActivity2.this.up.setVisibility(0);
                MainActivity2.this.btnCamera.startAnimation(loadAnimation3);
                MainActivity2.this.btnScan.startAnimation(loadAnimation3);
                MainActivity2.this.btnGall.startAnimation(loadAnimation3);
                MainActivity2.this.edit.startAnimation(loadAnimation4);
                MainActivity2.this.btnGall.setVisibility(8);
                MainActivity2.this.btnScan.setVisibility(8);
                MainActivity2.this.btnCamera.setVisibility(8);
                MainActivity2.this.edit.setVisibility(8);
            }
        });
        this.up.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.MainActivity2.AnonymousClass7 */

            public void onClick(View view) {
                Animation loadAnimation = AnimationUtils.loadAnimation(MainActivity2.this, R.anim.fade_in_rotate_clocwise);
                Animation loadAnimation2 = AnimationUtils.loadAnimation(MainActivity2.this, R.anim.fade_out_rotate_clockwise);
                Animation loadAnimation3 = AnimationUtils.loadAnimation(MainActivity2.this, R.anim.slide_up);
                Animation loadAnimation4 = AnimationUtils.loadAnimation(MainActivity2.this, R.anim.edit_slide_in);
                MainActivity2.this.up.startAnimation(loadAnimation2);
                MainActivity2.this.down.startAnimation(loadAnimation);
                MainActivity2.this.up.setVisibility(8);
                MainActivity2.this.down.setVisibility(0);
                MainActivity2.this.up.setVisibility(8);
                MainActivity2.this.btnCamera.setVisibility(0);
                MainActivity2.this.btnCamera.startAnimation(loadAnimation3);
                MainActivity2.this.btnScan.setVisibility(0);
                MainActivity2.this.btnScan.startAnimation(loadAnimation3);
                MainActivity2.this.btnGall.setVisibility(0);
                MainActivity2.this.btnGall.startAnimation(loadAnimation3);
                MainActivity2.this.edit.startAnimation(loadAnimation4);
                MainActivity2.this.edit.setVisibility(0);
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        HomeTabAdapter homeTabAdapter = new HomeTabAdapter(this, getSupportFragmentManager());
        homeTabAdapter.addFragment(new DocumentFragment(), "Document");
        homeTabAdapter.addFragment(new OcrFragment(), "OCR");
        viewPager.setAdapter(homeTabAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.applex.snaplingo.MainActivity2.AnonymousClass8 */

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                DocumentFragment.swipe = 1;
            }
        });
    }

    /* access modifiers changed from: private */
    public void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, this.cameraPermission, 200);
    }

    /* access modifiers changed from: private */
    public boolean checkCameraPermission() {
        boolean z = ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0;
        boolean z2 = ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback, androidx.fragment.app.FragmentActivity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 200 && iArr.length > 0) {
            boolean z = true;
            boolean z2 = iArr[0] == 0;
            if (iArr[0] != 0) {
                z = false;
            }
            if (!z2 || !z) {
                Toast.makeText(this, "permission denied", 0).show();
            } else {
                startActivity(new Intent(this, ScannerActivity.class));
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 203) {
            Toast.makeText(this, "CropMain", 0).show();
            CropImage.ActivityResult activityResult = CropImage.getActivityResult(intent);
            if (i2 == -1) {
                MainActivity.resultUri = activityResult.getUri();
                Bitmap bitmap2 = null;
                try {
                    bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(), MainActivity.resultUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                TextRecognizer build = new TextRecognizer.Builder(this).build();
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
                Intent intent2 = new Intent(this, MainActivity.class);
                intent2.putExtra("Text", sb.toString().trim());
                intent2.putExtra("selection", "1");
                startActivity(intent2);
            }
        } else if (i2 == 204) {
            Toast.makeText(this, "+error", 0).show();
        }
    }

    public static MainActivity2 getInstance() {
        return instance;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.about_us) {
            new Handler().postDelayed(new Runnable() {
                /* class com.applex.snaplingo.MainActivity2.AnonymousClass9 */

                public void run() {
                    MainActivity2.this.startActivity(new Intent(MainActivity2.this, AboutUs.class));
                }
            }, 200);
        }
        if (itemId == R.id.privacy) {
            new Handler().postDelayed(new Runnable() {
                /* class com.applex.snaplingo.MainActivity2.AnonymousClass10 */

                public void run() {
                    MainActivity2.this.startActivity(new Intent(MainActivity2.this, PrivacyPolicy.class));
                }
            }, 200);
        }
        if (itemId == R.id.generateQR) {
            new Handler().postDelayed(new Runnable() {
                /* class com.applex.snaplingo.MainActivity2.AnonymousClass11 */

                public void run() {
                    MainActivity2.this.drawer.closeDrawers();
                    MainActivity2.this.startActivity(new Intent(MainActivity2.this, QRGenerator.class));
                }
            }, 200);
        }
        if (itemId == R.id.contact_us) {
            new Handler().postDelayed(new Runnable() {
                /* class com.applex.snaplingo.MainActivity2.AnonymousClass12 */

                public void run() {
                    Intent intent = new Intent(MainActivity2.this, WebView.class);
                    intent.putExtra(TextBundle.TEXT_ENTRY, "https://applex.in/contact/");
                    intent.putExtra("bool", "1");
                    MainActivity2.this.startActivity(intent);
                }
            }, 200);
        }
        if (itemId == R.id.cloud) {
            new Handler().postDelayed(new Runnable() {
                /* class com.applex.snaplingo.MainActivity2.AnonymousClass13 */

                public void run() {
                    Toast.makeText(MainActivity2.this, "Coming soon...", 0).show();
                }
            }, 200);
        }
        if (itemId == R.id.pdf) {
            new Handler().postDelayed(new Runnable() {
                /* class com.applex.snaplingo.MainActivity2.AnonymousClass14 */

                public void run() {
                    Toast.makeText(MainActivity2.this, "Coming soon...", 0).show();
                }
            }, 200);
        }
        if (itemId == R.id.share) {
            new Handler().postDelayed(new Runnable() {
                /* class com.applex.snaplingo.MainActivity2.AnonymousClass15 */

                public void run() {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", "Hey! Are you still using foreign apps? SnapLingo is a Made in India application that Scans Documents, performs OCR, scans & generates QR codes and lot more without any privacy breech!\n\nDownload now! https://play.google.com/store/apps/details?id=com.applex.snaplingo");
                    intent.setType("text/plain");
                    MainActivity2.this.startActivity(Intent.createChooser(intent, "Share with"));
                }
            }, 200);
        }
        if (itemId == R.id.rate) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getApplicationContext().getPackageName()));
            intent.addFlags(1208483840);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));
            }
        }
        this.drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (this.doubleBackPressed.booleanValue()) {
            super.onBackPressed();
        } else {
            this.doubleBackPressed = true;
            Toast.makeText(this, "Press BACK again to exit", 0).show();
            new Handler().postDelayed(new Runnable() {
                /* class com.applex.snaplingo.MainActivity2.AnonymousClass16 */

                public void run() {
                    Boolean unused = MainActivity2.this.doubleBackPressed = false;
                }
            }, 3000);
        }
    }

    @Override // com.applex.snaplingo.interfaces.OnPDFCreatedInterface
    public void onPDFCreationStarted() {
        MaterialDialog createAnimationDialog2 = DialogUtils.getInstance().createAnimationDialog2(this);
        this.mMaterialDialog = createAnimationDialog2;
        createAnimationDialog2.show();
    }

    @Override // com.applex.snaplingo.interfaces.OnPDFCreatedInterface
    public void onPDFCreated(boolean z, final String str) {
        new Handler().postDelayed(new Runnable() {
            /* class com.applex.snaplingo.MainActivity2.AnonymousClass17 */

            public void run() {
                if (MainActivity2.this.mMaterialDialog != null && MainActivity2.this.mMaterialDialog.isShowing()) {
                    MainActivity2.this.mMaterialDialog.dismiss();
                }
                File file = new File(str);
                if (file.exists()) {
                    Uri uriForFile = FileProvider.getUriForFile(MainActivity2.this, Constants.AUTHORITY_APP, file);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", "sharing");
                    intent.putExtra("android.intent.extra.STREAM", uriForFile);
                    intent.addFlags(1);
                    intent.setType("Document/*");
                    MainActivity2.this.startActivity(Intent.createChooser(intent, "SHARE"));
                    return;
                }
                Toast.makeText(MainActivity2.this, "Pdf missing", 1).show();
            }
        }, 2000);
    }
}
