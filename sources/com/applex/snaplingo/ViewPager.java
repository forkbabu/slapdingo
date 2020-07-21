package com.applex.snaplingo;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.ViewPager;
import com.applex.snaplingo.adapters.AdapterViewPager;
import com.applex.snaplingo.util.Constants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.labters.documentscanner.ApplyFilters;
import com.labters.documentscanner.ImageCropActivity;
import com.labters.documentscanner.helpers.ScannerConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ViewPager extends AppCompatActivity {
    AdapterViewPager adapter;
    LinearLayout applyFilters;
    ImageView back;
    TextView count;
    LinearLayout crop;
    TextView doc_name;
    String document_name;
    LinearLayout done;
    ImageView editName;
    Uri image;
    /* access modifiers changed from: private */
    public String mHomePath;
    ArrayList<String> mImagesuri;
    /* access modifiers changed from: private */
    public Dialog mydialogue;
    LinearLayout ocr;
    int pos;
    androidx.viewpager.widget.ViewPager viewPager;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_view_pager);
        this.editName = (ImageView) findViewById(R.id.edit_name);
        this.back = (ImageView) findViewById(R.id.back);
        this.doc_name = (TextView) findViewById(R.id.doc_name);
        this.viewPager = (androidx.viewpager.widget.ViewPager) findViewById(R.id.viewPager);
        this.done = (LinearLayout) findViewById(R.id.done);
        this.crop = (LinearLayout) findViewById(R.id.crop);
        this.applyFilters = (LinearLayout) findViewById(R.id.filters);
        this.ocr = (LinearLayout) findViewById(R.id.ocr);
        this.count = (TextView) findViewById(R.id.page_count);
        this.viewPager.setPadding(130, 0, 130, 0);
        this.viewPager.setPageMargin(70);
        this.mImagesuri = new ArrayList<>();
        this.mHomePath = Environment.getExternalStorageDirectory() + "/SnapLingo/.documents/";
        this.editName.setVisibility(8);
        this.editName.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.$$Lambda$ViewPager$YNQnDYko9nRQ9R4zAXpqGEDDbQ4 */

            public final void onClick(View view) {
                ViewPager.this.lambda$onCreate$0$ViewPager(view);
            }
        });
        String stringExtra = getIntent().getStringExtra("docName");
        this.document_name = stringExtra;
        this.doc_name.setText(stringExtra);
        createList(this.document_name);
        AdapterViewPager adapterViewPager = new AdapterViewPager(this.mImagesuri, this, 1);
        this.adapter = adapterViewPager;
        this.viewPager.setAdapter(adapterViewPager);
        if (getIntent().getStringExtra("from").matches("1")) {
            String stringExtra2 = getIntent().getStringExtra("docName");
            this.document_name = stringExtra2;
            this.doc_name.setText(stringExtra2);
            createList(this.document_name);
            AdapterViewPager adapterViewPager2 = new AdapterViewPager(this.mImagesuri, this, 1);
            this.adapter = adapterViewPager2;
            this.viewPager.setAdapter(adapterViewPager2);
            this.viewPager.setCurrentItem(0);
            TextView textView = this.count;
            textView.setText("Page 1 of " + this.mImagesuri.size());
        } else if (getIntent().getStringExtra("from").matches(ExifInterface.GPS_MEASUREMENT_2D)) {
            String stringExtra3 = getIntent().getStringExtra("docName");
            this.document_name = stringExtra3;
            this.doc_name.setText(stringExtra3);
            createList(this.document_name);
            AdapterViewPager adapterViewPager3 = new AdapterViewPager(this.mImagesuri, this, 1);
            this.adapter = adapterViewPager3;
            this.viewPager.setAdapter(adapterViewPager3);
            if (getIntent().getStringExtra("pos") != null) {
                int parseInt = Integer.parseInt(getIntent().getStringExtra("pos"));
                this.pos = parseInt;
                this.viewPager.setCurrentItem(parseInt);
                TextView textView2 = this.count;
                textView2.setText("Page " + (this.pos + 1) + " of " + this.mImagesuri.size());
            }
        } else if (getIntent().getStringExtra("from").matches(ExifInterface.GPS_MEASUREMENT_3D)) {
            String stringExtra4 = getIntent().getStringExtra("docName");
            this.document_name = stringExtra4;
            this.doc_name.setText(stringExtra4);
            createList(this.document_name);
            AdapterViewPager adapterViewPager4 = new AdapterViewPager(this.mImagesuri, this, 1);
            this.adapter = adapterViewPager4;
            this.viewPager.setAdapter(adapterViewPager4);
            if (getIntent().getStringExtra("pos") != null) {
                int parseInt2 = Integer.parseInt(getIntent().getStringExtra("pos"));
                this.pos = parseInt2;
                this.viewPager.setCurrentItem(parseInt2);
                TextView textView3 = this.count;
                textView3.setText("Page " + (this.pos + 1) + " of " + this.mImagesuri.size());
            }
        }
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.applex.snaplingo.ViewPager.AnonymousClass1 */

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                ViewPager.this.pos = i;
                TextView textView = ViewPager.this.count;
                textView.setText("Page " + (ViewPager.this.pos + 1) + " of " + ViewPager.this.mImagesuri.size());
            }
        });
        this.crop.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ViewPager.AnonymousClass2 */

            public void onClick(View view) {
                Intent intent = new Intent(ViewPager.this.getApplicationContext(), ImageCropActivity.class);
                ScannerConstants.selectedImageBitmap = BitmapFactory.decodeFile(ViewPager.this.mHomePath + ViewPager.this.document_name + Constants.PATH_SEPERATOR + ViewPager.this.pos + ".jpg");
                intent.putExtra("position", String.valueOf(ViewPager.this.pos));
                StringBuilder sb = new StringBuilder();
                sb.append(ViewPager.this.mHomePath);
                sb.append(ViewPager.this.document_name);
                sb.append(Constants.PATH_SEPERATOR);
                intent.putExtra("path", sb.toString());
                intent.putExtra("imageName", ViewPager.this.pos + ".jpg");
                ViewPager.this.startActivityForResult(intent, 1234);
            }
        });
        this.applyFilters.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ViewPager.AnonymousClass3 */

            public void onClick(View view) {
                Intent intent = new Intent(ViewPager.this.getApplicationContext(), ApplyFilters.class);
                ScannerConstants.selectedImageBitmap = BitmapFactory.decodeFile(ViewPager.this.mHomePath + ViewPager.this.document_name + Constants.PATH_SEPERATOR + ViewPager.this.pos + ".jpg");
                intent.putExtra("position", String.valueOf(ViewPager.this.pos));
                StringBuilder sb = new StringBuilder();
                sb.append(ViewPager.this.mHomePath);
                sb.append(ViewPager.this.document_name);
                sb.append(Constants.PATH_SEPERATOR);
                intent.putExtra("path", sb.toString());
                intent.putExtra("imageName", ViewPager.this.pos + ".jpg");
                ViewPager.this.startActivityForResult(intent, 1234);
            }
        });
        this.ocr.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ViewPager.AnonymousClass4 */

            public void onClick(View view) {
                Intent intent = new Intent(ViewPager.this, MainActivity.class);
                intent.putExtra("selection", "6");
                intent.putExtra("path", ViewPager.this.mHomePath + ViewPager.this.document_name + Constants.PATH_SEPERATOR + ViewPager.this.pos + ".jpg");
                ViewPager.this.startActivity(intent);
            }
        });
        this.done.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ViewPager.AnonymousClass5 */

            public void onClick(View view) {
                if (ViewPager.this.getIntent().getStringExtra("from").matches("1")) {
                    Intent intent = new Intent(ViewPager.this, ActivityGrid.class);
                    intent.putExtra("path", ViewPager.this.mHomePath + ViewPager.this.document_name);
                    intent.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, ViewPager.this.document_name);
                    ViewPager.this.startActivity(intent);
                    ViewPager.this.finish();
                    return;
                }
                ViewPager.super.onBackPressed();
            }
        });
        this.back.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.$$Lambda$ViewPager$itS_odwRv953PwWXA_fCt_GfXs */

            public final void onClick(View view) {
                ViewPager.this.lambda$onCreate$1$ViewPager(view);
            }
        });
        this.adapter.onClickListener(new AdapterViewPager.OnClickListener() {
            /* class com.applex.snaplingo.$$Lambda$ViewPager$CFMdIAZahYTApj7h_l2d7GMVpcQ */

            @Override // com.applex.snaplingo.adapters.AdapterViewPager.OnClickListener
            public final void onClickListener(int i) {
                ViewPager.this.lambda$onCreate$2$ViewPager(i);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$ViewPager(View view) {
        openDialog(this.doc_name.getText().toString());
    }

    public /* synthetic */ void lambda$onCreate$1$ViewPager(View view) {
        super.onBackPressed();
    }

    public /* synthetic */ void lambda$onCreate$2$ViewPager(int i) {
        Intent intent = new Intent(getApplicationContext(), ImageCropActivity.class);
        ScannerConstants.selectedImageBitmap = BitmapFactory.decodeFile(this.mHomePath + this.document_name + Constants.PATH_SEPERATOR + i + ".jpg");
        intent.putExtra("position", String.valueOf(i));
        StringBuilder sb = new StringBuilder();
        sb.append(this.mHomePath);
        sb.append(this.document_name);
        sb.append(Constants.PATH_SEPERATOR);
        intent.putExtra("path", sb.toString());
        intent.putExtra("imageName", i + ".jpg");
        startActivityForResult(intent, 1234);
    }

    private void createList(String str) {
        this.mImagesuri.clear();
        File[] listFiles = new File(this.mHomePath + Constants.PATH_SEPERATOR + str + Constants.PATH_SEPERATOR).listFiles();
        if (listFiles != null && listFiles.length > 1) {
            Arrays.sort(listFiles, new Comparator<File>() {
                /* class com.applex.snaplingo.ViewPager.AnonymousClass6 */

                public int compare(File file, File file2) {
                    return file.getName().compareTo(file2.getName());
                }
            });
        }
        if (listFiles != null) {
            for (File file : listFiles) {
                this.mImagesuri.add(Uri.fromFile(new File(file.getAbsolutePath())).toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1234 && i2 == -1) {
            createList(this.document_name);
            AdapterViewPager adapterViewPager = new AdapterViewPager(this.mImagesuri, this, 1);
            this.adapter = adapterViewPager;
            this.viewPager.setAdapter(adapterViewPager);
        }
    }

    private void openDialog(final String str) {
        Dialog dialog = new Dialog(this);
        this.mydialogue = dialog;
        dialog.setContentView(R.layout.dialog_doc_name_edit);
        this.mydialogue.setCanceledOnTouchOutside(Boolean.TRUE.booleanValue());
        this.mydialogue.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        final EditText editText = (EditText) this.mydialogue.findViewById(R.id.enter_name);
        editText.setText(str);
        this.mydialogue.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ViewPager.AnonymousClass7 */

            public void onClick(View view) {
                ViewPager.this.mydialogue.dismiss();
            }
        });
        this.mydialogue.findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.ViewPager.AnonymousClass8 */

            public void onClick(View view) {
                String trim = editText.getText().toString().trim();
                if (trim.isEmpty()) {
                    Toast.makeText(ViewPager.this.getApplicationContext(), "Enter Name", 0).show();
                    return;
                }
                File file = new File(ViewPager.this.mHomePath, str);
                File file2 = new File(ViewPager.this.mHomePath, trim);
                if (file.exists()) {
                    file.renameTo(file2);
                }
                ViewPager.this.doc_name.setText(trim);
                ViewPager.this.document_name = trim;
                ActivityGrid.document_name = ViewPager.this.document_name;
                ViewPager.this.mydialogue.dismiss();
            }
        });
        this.mydialogue.show();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        createList(this.document_name);
        AdapterViewPager adapterViewPager = new AdapterViewPager(this.mImagesuri, this, 1);
        this.adapter = adapterViewPager;
        this.viewPager.setAdapter(adapterViewPager);
        if (ScannerConstants.position != -1) {
            this.viewPager.setCurrentItem(ScannerConstants.position);
            TextView textView = this.count;
            textView.setText("Page " + (ScannerConstants.position + 1) + " of " + this.mImagesuri.size());
            ScannerConstants.position = -1;
        }
        if (getIntent().getStringExtra("pos") != null) {
            int parseInt = Integer.parseInt(getIntent().getStringExtra("pos"));
            this.pos = parseInt;
            this.viewPager.setCurrentItem(parseInt);
            TextView textView2 = this.count;
            textView2.setText("Page " + (this.pos + 1) + " of " + this.mImagesuri.size());
        }
        this.adapter.onClickListener(new AdapterViewPager.OnClickListener() {
            /* class com.applex.snaplingo.$$Lambda$ViewPager$ol1qWiI0_hBJTib5nPh22_1doR8 */

            @Override // com.applex.snaplingo.adapters.AdapterViewPager.OnClickListener
            public final void onClickListener(int i) {
                ViewPager.this.lambda$onResume$3$ViewPager(i);
            }
        });
    }

    public /* synthetic */ void lambda$onResume$3$ViewPager(int i) {
        Intent intent = new Intent(getApplicationContext(), ImageCropActivity.class);
        ScannerConstants.selectedImageBitmap = BitmapFactory.decodeFile(this.mHomePath + this.document_name + Constants.PATH_SEPERATOR + i + ".jpg");
        intent.putExtra("position", String.valueOf(i));
        StringBuilder sb = new StringBuilder();
        sb.append(this.mHomePath);
        sb.append(this.document_name);
        sb.append(Constants.PATH_SEPERATOR);
        intent.putExtra("path", sb.toString());
        intent.putExtra("imageName", i + ".jpg");
        startActivityForResult(intent, 1234);
    }
}
