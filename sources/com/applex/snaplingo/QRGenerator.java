package com.applex.snaplingo;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.zxing.WriterException;
import java.io.ByteArrayOutputStream;

public class QRGenerator extends AppCompatActivity {
    Bitmap bitmap;
    Dialog mydialogue;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_q_r_generator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolb);
        toolbar.setTitle("Generate QR");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        final EditText editText = (EditText) findViewById(R.id.edittext);
        ((Button) findViewById(R.id.done)).setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.QRGenerator.AnonymousClass1 */

            public void onClick(View view) {
                if (editText.getText().toString().length() != 0) {
                    QRGenerator.this.GenerateQR(editText.getText().toString());
                } else {
                    Toast.makeText(QRGenerator.this, "No Text Found", 0).show();
                }
            }
        });
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
        } catch (WriterException unused) {
        }
        this.mydialogue.show();
        imageView2.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.QRGenerator.AnonymousClass2 */

            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("*/*");
                QRGenerator.this.bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new ByteArrayOutputStream());
                Uri parse = Uri.parse(MediaStore.Images.Media.insertImage(QRGenerator.this.getContentResolver(), QRGenerator.this.bitmap, String.valueOf(System.currentTimeMillis()), (String) null));
                intent.putExtra("android.intent.extra.TEXT", "Generate QRs with SnapLingo! If you haven't downloaded yet, click here: https://play.google.com/store/apps/details?id=com.applex.snaplingo ");
                intent.putExtra("android.intent.extra.STREAM", parse);
                QRGenerator.this.startActivity(Intent.createChooser(intent, "Share QR"));
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_web, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
