package com.applex.snaplingo;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.exifinterface.media.ExifInterface;
import com.applex.snaplingo.util.Constants;
import org.spongycastle.i18n.TextBundle;

public class WebView extends AppCompatActivity {
    /* access modifiers changed from: private */
    public ProgressBar progressBar;
    /* access modifiers changed from: private */
    public android.webkit.WebView wv;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_web_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolb);
        toolbar.setTitle(Constants.appName);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        android.webkit.WebView webView = (android.webkit.WebView) findViewById(R.id.webview);
        this.wv = webView;
        webView.setVisibility(4);
        this.wv.setWebChromeClient(new WebChromeClient());
        this.wv.getSettings().setJavaScriptEnabled(true);
        this.wv.setWebViewClient(new WebViewClient() {
            /* class com.applex.snaplingo.WebView.AnonymousClass1 */

            public void onPageStarted(android.webkit.WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                WebView.this.progressBar.setVisibility(0);
                Toast.makeText(WebView.this, "Loading...", 0).show();
            }

            public void onPageFinished(android.webkit.WebView webView, String str) {
                super.onPageFinished(webView, str);
                WebView.this.wv.setVisibility(0);
                WebView.this.progressBar.setVisibility(8);
            }
        });
        String stringExtra = getIntent().getStringExtra(TextBundle.TEXT_ENTRY);
        if (getIntent().getStringExtra("bool") != null && getIntent().getStringExtra("bool").matches("1")) {
            this.wv.loadUrl(stringExtra);
            toolbar.setTitle("applex.in");
        } else if (getIntent().getStringExtra("bool") != null && getIntent().getStringExtra("bool").matches(ExifInterface.GPS_MEASUREMENT_3D)) {
            toolbar.setTitle("Translate");
            android.webkit.WebView webView2 = this.wv;
            webView2.loadUrl("https://translate.google.com/#auto/hi/" + stringExtra);
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.wv.canGoBack()) {
            this.wv.goBack();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Return to home").setMessage("Are you sure?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            /* class com.applex.snaplingo.WebView.AnonymousClass2 */

            public void onClick(DialogInterface dialogInterface, int i) {
                WebView.super.onBackPressed();
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null);
        builder.create().show();
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
