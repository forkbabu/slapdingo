package com.applex.snaplingo;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import com.applex.snaplingo.util.Constants;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.snackbar.Snackbar;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DocView extends AppCompatActivity {
    ImageButton collapse;
    FloatingActionMenu flmenu;
    private AdView mAdView;
    EditText mResultEt;
    DatabaseHelper myDB;
    Dialog mydialogue;
    Uri path;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_doc_view);
        this.mydialogue = new Dialog(this);
        this.mAdView = (AdView) findViewById(R.id.ad_view);
        this.mAdView.loadAd(new AdRequest.Builder().build());
        this.myDB = new DatabaseHelper(this);
        this.mResultEt = (EditText) findViewById(R.id.docViewer);
        this.mResultEt.setText(getIntent().getStringExtra("OCRtext"));
        this.mResultEt = (EditText) findViewById(R.id.docViewer);
        ImageButton imageButton = (ImageButton) findViewById(R.id.collapse);
        this.collapse = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.DocView.AnonymousClass1 */

            public void onClick(View view) {
                MainActivity.mResultEt.setText(DocView.this.mResultEt.getText().toString());
                DocView.super.onBackPressed();
            }
        });
        FloatingActionMenu floatingActionMenu = (FloatingActionMenu) findViewById(R.id.menu);
        this.flmenu = floatingActionMenu;
        floatingActionMenu.close(true);
        ((FloatingActionButton) findViewById(R.id.doc)).setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.DocView.AnonymousClass2 */

            public void onClick(View view) {
                if (DocView.this.mResultEt.length() != 0) {
                    DocView.this.saveDoc();
                } else {
                    Toast.makeText(DocView.this, "Field empty...", 0).show();
                }
            }
        });
        ((FloatingActionButton) findViewById(R.id.pdf)).setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.DocView.AnonymousClass3 */

            public void onClick(View view) {
                if (DocView.this.mResultEt.length() != 0) {
                    DocView.this.savePdf();
                } else {
                    Toast.makeText(DocView.this, "Field empty...", 0).show();
                }
            }
        });
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.qr);
    }

    public void savePdf() {
        this.mydialogue.setContentView(R.layout.dialog_file_name);
        this.mydialogue.setCanceledOnTouchOutside(Boolean.TRUE.booleanValue());
        ((TextView) this.mydialogue.findViewById(R.id.extension)).setText(Constants.pdfExtension);
        final EditText editText = (EditText) this.mydialogue.findViewById(R.id.fname);
        final String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
        editText.setHint(format);
        ((Button) this.mydialogue.findViewById(R.id.save)).setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.DocView.AnonymousClass4 */

            public void onClick(View view) {
                if (editText.length() != 0) {
                    Document document = new Document();
                    final String replaceAll = editText.getText().toString().trim().replaceAll(" ", "_");
                    new File(Environment.getExternalStorageDirectory() + "/SnapLingo", "Pdf").mkdirs();
                    final String str = Environment.getExternalStorageDirectory() + "/SnapLingo/Pdf/" + replaceAll + Constants.pdfExtension;
                    try {
                        PdfWriter.getInstance(document, new FileOutputStream(str));
                        document.open();
                        document.add(new Paragraph(DocView.this.mResultEt.getText().toString().replaceAll("\n", " ")));
                        document.close();
                        Snackbar.make(DocView.this.flmenu, "PDF has been saved", 0).setAction("Share", new View.OnClickListener() {
                            /* class com.applex.snaplingo.DocView.AnonymousClass4.AnonymousClass1 */

                            public void onClick(View view) {
                                File file = new File(str);
                                if (file.exists()) {
                                    DocView.this.path = FileProvider.getUriForFile(DocView.this, "com.sourajit.snaptext.fileprovider", file);
                                    Intent intent = new Intent();
                                    intent.setAction("android.intent.action.SEND");
                                    intent.putExtra("android.intent.extra.TEXT", "sharing");
                                    intent.putExtra("android.intent.extra.STREAM", DocView.this.path);
                                    intent.addFlags(1);
                                    intent.setType("Document/*");
                                    DocView.this.startActivity(Intent.createChooser(intent, "SHARE"));
                                    return;
                                }
                                DocView docView = DocView.this;
                                Toast.makeText(docView, replaceAll + " missing " + str, 1).show();
                            }
                        }).show();
                    } catch (Exception e) {
                        Toast.makeText(DocView.this, e.getMessage(), 0).show();
                    }
                } else {
                    Document document2 = new Document();
                    final String str2 = format;
                    new File(Environment.getExternalStorageDirectory() + "/SnapLingo", "Pdf").mkdirs();
                    final String str3 = Environment.getExternalStorageDirectory() + "/SnapLingo/Pdf/" + str2 + Constants.pdfExtension;
                    try {
                        PdfWriter.getInstance(document2, new FileOutputStream(str3));
                        document2.open();
                        document2.add(new Paragraph(DocView.this.mResultEt.getText().toString().replaceAll("\n", " ")));
                        document2.close();
                        Snackbar.make(DocView.this.flmenu, "PDF has been saved", 0).setAction("Share", new View.OnClickListener() {
                            /* class com.applex.snaplingo.DocView.AnonymousClass4.AnonymousClass2 */

                            public void onClick(View view) {
                                File file = new File(str3);
                                if (file.exists()) {
                                    DocView.this.path = FileProvider.getUriForFile(DocView.this, "com.sourajit.snaptext.fileprovider", file);
                                    Intent intent = new Intent();
                                    intent.setAction("android.intent.action.SEND");
                                    intent.putExtra("android.intent.extra.TEXT", "sharing");
                                    intent.putExtra("android.intent.extra.STREAM", DocView.this.path);
                                    intent.addFlags(1);
                                    intent.setType("Document/*");
                                    DocView.this.startActivity(Intent.createChooser(intent, "SHARE"));
                                    return;
                                }
                                DocView docView = DocView.this;
                                Toast.makeText(docView, str2 + " missing " + str3, 1).show();
                            }
                        }).show();
                    } catch (Exception e2) {
                        Toast.makeText(DocView.this, e2.getMessage(), 0).show();
                    }
                }
                DocView.this.mydialogue.dismiss();
                DocView.this.flmenu.close(true);
            }
        });
        this.mydialogue.show();
    }

    public void saveDoc() {
        this.mydialogue.setContentView(R.layout.dialog_file_name);
        this.mydialogue.setCanceledOnTouchOutside(Boolean.TRUE.booleanValue());
        ((TextView) this.mydialogue.findViewById(R.id.extension)).setText(Constants.textExtension);
        final EditText editText = (EditText) this.mydialogue.findViewById(R.id.fname);
        final String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
        editText.setHint(format);
        ((Button) this.mydialogue.findViewById(R.id.save)).setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.DocView.AnonymousClass5 */

            /* JADX WARNING: Removed duplicated region for block: B:18:0x00da  */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x00e7 A[SYNTHETIC, Splitter:B:22:0x00e7] */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x019b  */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x01b5 A[SYNTHETIC, Splitter:B:49:0x01b5] */
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
                    com.applex.snaplingo.DocView r8 = com.applex.snaplingo.DocView.this     // Catch:{ Exception -> 0x00ca }
                    android.widget.EditText r8 = r8.mResultEt     // Catch:{ Exception -> 0x00ca }
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
                    com.applex.snaplingo.DocView r6 = com.applex.snaplingo.DocView.this     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    java.io.File r6 = r6.getFilesDir()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    r5.append(r6)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    r5.append(r2)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    r5.append(r14)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    com.applex.snaplingo.DocView r5 = com.applex.snaplingo.DocView.this     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    com.github.clans.fab.FloatingActionMenu r5 = r5.flmenu     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    com.google.android.material.snackbar.Snackbar r1 = com.google.android.material.snackbar.Snackbar.make(r5, r1, r10)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                    com.applex.snaplingo.DocView$5$1 r5 = new com.applex.snaplingo.DocView$5$1     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
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
                    com.applex.snaplingo.DocView r0 = com.applex.snaplingo.DocView.this     // Catch:{ all -> 0x00c8 }
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
                    com.applex.snaplingo.DocView r8 = com.applex.snaplingo.DocView.this     // Catch:{ Exception -> 0x018b }
                    android.widget.EditText r8 = r8.mResultEt     // Catch:{ Exception -> 0x018b }
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
                    com.applex.snaplingo.DocView r6 = com.applex.snaplingo.DocView.this     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    java.io.File r6 = r6.getFilesDir()     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r5.append(r6)     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r5.append(r2)     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r5.append(r14)     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    com.applex.snaplingo.DocView r5 = com.applex.snaplingo.DocView.this     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    com.github.clans.fab.FloatingActionMenu r5 = r5.flmenu     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    com.google.android.material.snackbar.Snackbar r1 = com.google.android.material.snackbar.Snackbar.make(r5, r1, r10)     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    com.applex.snaplingo.DocView$5$2 r5 = new com.applex.snaplingo.DocView$5$2     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r5.<init>(r4, r14, r2)     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    com.google.android.material.snackbar.Snackbar r14 = r1.setAction(r0, r5)     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r14.show()     // Catch:{ Exception -> 0x0186, all -> 0x0183 }
                    r3.close()     // Catch:{ IOException -> 0x019f }
                    goto L_0x01a3
                L_0x0183:
                    r14 = move-exception
                    r7 = r3
                    goto L_0x01b3
                L_0x0186:
                    r14 = move-exception
                    r7 = r3
                    goto L_0x018c
                L_0x0189:
                    r14 = move-exception
                    goto L_0x01b3
                L_0x018b:
                    r14 = move-exception
                L_0x018c:
                    com.applex.snaplingo.DocView r0 = com.applex.snaplingo.DocView.this     // Catch:{ all -> 0x0189 }
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
                    com.applex.snaplingo.DocView r14 = com.applex.snaplingo.DocView.this
                    android.app.Dialog r14 = r14.mydialogue
                    r14.dismiss()
                    com.applex.snaplingo.DocView r14 = com.applex.snaplingo.DocView.this
                    com.github.clans.fab.FloatingActionMenu r14 = r14.flmenu
                    r0 = 1
                    r14.close(r0)
                    return
                L_0x01b3:
                    if (r7 == 0) goto L_0x01bd
                    r7.close()     // Catch:{ IOException -> 0x01b9 }
                    goto L_0x01bd
                L_0x01b9:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x01bd:
                    throw r14
                */
                throw new UnsupportedOperationException("Method not decompiled: com.applex.snaplingo.DocView.AnonymousClass5.onClick(android.view.View):void");
            }
        });
        this.mydialogue.show();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.flmenu.isOpened()) {
            this.flmenu.close(true);
        } else {
            super.onBackPressed();
        }
    }
}
