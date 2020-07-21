package com.applex.snaplingo.util;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import com.applex.snaplingo.interfaces.OnPDFCreatedInterface;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class CreatePdf extends AsyncTask<String, String, String> {
    public static ArrayList<Integer> create = new ArrayList<>();
    private String bool;
    private Context context;
    private Image image;
    private final int mBorderWidth;
    private final String mFileName;
    private ArrayList<String> mImageFinalUri;
    private final String mImageScaleType;
    private final ArrayList<String> mImagesUri;
    private final int mMarginBottom;
    private final int mMarginLeft;
    private final int mMarginRight;
    private final int mMarginTop;
    private final String mMasterPwd;
    private final OnPDFCreatedInterface mOnPDFCreatedInterface;
    private final int mPageColor;
    private final String mPageNumStyle;
    private final String mPageSize;
    private final String mPassword;
    private final boolean mPasswordProtected;
    private String mPath;
    private final String mQualityString;
    private boolean mSuccess;
    private final Watermark mWatermark;
    private final Boolean mWatermarkAdded;

    public CreatePdf(ImageToPDFOptions imageToPDFOptions, String str, OnPDFCreatedInterface onPDFCreatedInterface, Context context2, String str2) {
        this.mImagesUri = imageToPDFOptions.getImagesUri();
        this.mFileName = imageToPDFOptions.getOutFileName();
        this.mPassword = imageToPDFOptions.getPassword();
        this.mQualityString = imageToPDFOptions.getQualityString();
        this.mOnPDFCreatedInterface = onPDFCreatedInterface;
        this.mPageSize = imageToPDFOptions.getPageSize();
        this.mPasswordProtected = imageToPDFOptions.isPasswordProtected();
        this.mBorderWidth = imageToPDFOptions.getBorderWidth();
        this.mWatermarkAdded = Boolean.valueOf(imageToPDFOptions.isWatermarkAdded());
        this.mWatermark = imageToPDFOptions.getWatermark();
        this.mMarginTop = imageToPDFOptions.getMarginTop();
        this.mMarginBottom = imageToPDFOptions.getMarginBottom();
        this.mMarginRight = imageToPDFOptions.getMarginRight();
        this.mMarginLeft = imageToPDFOptions.getMarginLeft();
        this.mImageScaleType = imageToPDFOptions.getImageScaleType();
        this.mPageNumStyle = imageToPDFOptions.getPageNumStyle();
        this.mMasterPwd = imageToPDFOptions.getMasterPwd();
        this.mPageColor = imageToPDFOptions.getPageColor();
        this.context = context2;
        this.mPath = str;
        this.bool = str2;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        this.mSuccess = true;
        this.mOnPDFCreatedInterface.onPDFCreationStarted();
    }

    private void setFilePath() {
        File file = new File(this.mPath);
        if (!file.exists()) {
            file.mkdir();
        }
        this.mPath += this.mFileName + Constants.pdfExtension;
    }

    /* access modifiers changed from: protected */
    public String doInBackground(String... strArr) {
        setFilePath();
        Log.v("stage 1", "store the pdf in sd card");
        Rectangle rectangle = new Rectangle(PageSize.getRectangle(this.mPageSize));
        rectangle.setBackgroundColor(getBaseColor(this.mPageColor));
        Document document = new Document(rectangle, (float) this.mMarginLeft, (float) this.mMarginRight, (float) this.mMarginTop, (float) this.mMarginBottom);
        Log.v("stage 2", "Document Created");
        document.setMargins((float) this.mMarginLeft, (float) this.mMarginRight, (float) this.mMarginTop, (float) this.mMarginBottom);
        Rectangle pageSize = document.getPageSize();
        try {
            PdfWriter instance = PdfWriter.getInstance(document, new FileOutputStream(this.mPath));
            Log.v("Stage 3", "Pdf writer");
            if (this.mPasswordProtected) {
                instance.setEncryption(this.mPassword.getBytes(), this.mMasterPwd.getBytes(), 2068, 2);
                Log.v("Stage 3.1", "Set Encryption");
            }
            if (this.mWatermarkAdded.booleanValue()) {
                WatermarkPageEvent watermarkPageEvent = new WatermarkPageEvent();
                watermarkPageEvent.setWatermark(this.mWatermark);
                instance.setPageEvent(watermarkPageEvent);
            }
            document.open();
            Log.v("Stage 4", "Document opened");
            for (int i = 0; i < this.mImagesUri.size(); i++) {
                Image instance2 = Image.getInstance(this.mImagesUri.get(i));
                this.image = instance2;
                instance2.setCompressionLevel(9);
                this.image.setBorder(15);
                this.image.setBorderWidth((float) this.mBorderWidth);
                Log.v("Stage 5", "Image compressed " + (((double) 30) * 0.09d));
                BitmapFactory.decodeFile(this.mImagesUri.get(i), new BitmapFactory.Options());
                Log.v("Stage 6", "Image path adding");
                float width = document.getPageSize().getWidth() - ((float) (this.mMarginLeft + this.mMarginRight));
                float height = document.getPageSize().getHeight() - ((float) (this.mMarginBottom + this.mMarginTop));
                if (this.mImageScaleType.equals(Constants.IMAGE_SCALE_TYPE_ASPECT_RATIO)) {
                    this.image.scaleToFit(width, height);
                } else {
                    this.image.scaleAbsolute(width, height);
                }
                this.image.setAbsolutePosition((pageSize.getWidth() - this.image.getScaledWidth()) / 2.0f, (pageSize.getHeight() - this.image.getScaledHeight()) / 2.0f);
                Log.v("Stage 7", "Image Alignments");
                addPageNumber(pageSize, instance);
                document.add(this.image);
                document.newPage();
            }
            Log.v("Stage 8", "Image adding");
            document.close();
            Log.v("Stage 7", "Document Closed" + this.mPath);
            Log.v("Stage 8", "Record inserted in database");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            this.mSuccess = false;
            return null;
        }
    }

    private void addPageNumber(Rectangle rectangle, PdfWriter pdfWriter) {
        if (this.mPageNumStyle != null) {
            ColumnText.showTextAligned(pdfWriter.getDirectContent(), 6, getPhrase(pdfWriter, this.mPageNumStyle, this.mImagesUri.size()), (rectangle.getRight() + rectangle.getLeft()) / 2.0f, rectangle.getBottom() + 25.0f, 0.0f);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.itextpdf.text.Phrase getPhrase(com.itextpdf.text.pdf.PdfWriter r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            int r0 = r6.hashCode()
            r1 = -992766770(0xffffffffc4d394ce, float:-1692.6501)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x001b
            r1 = 197645084(0xbc7d31c, float:7.6969654E-32)
            if (r0 == r1) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            java.lang.String r0 = "pg_num_style_x_of_n"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0025
            r6 = 1
            goto L_0x0026
        L_0x001b:
            java.lang.String r0 = "pg_num_style_page_x_of_n"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0025
            r6 = 0
            goto L_0x0026
        L_0x0025:
            r6 = -1
        L_0x0026:
            r0 = 2
            if (r6 == 0) goto L_0x0061
            if (r6 == r3) goto L_0x0043
            com.itextpdf.text.Phrase r6 = new com.itextpdf.text.Phrase
            java.lang.Object[] r7 = new java.lang.Object[r3]
            int r5 = r5.getPageNumber()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r7[r2] = r5
            java.lang.String r5 = "%d"
            java.lang.String r5 = java.lang.String.format(r5, r7)
            r6.<init>(r5)
            goto L_0x007e
        L_0x0043:
            com.itextpdf.text.Phrase r6 = new com.itextpdf.text.Phrase
            java.lang.Object[] r0 = new java.lang.Object[r0]
            int r5 = r5.getPageNumber()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0[r2] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r0[r3] = r5
            java.lang.String r5 = "%d of %d"
            java.lang.String r5 = java.lang.String.format(r5, r0)
            r6.<init>(r5)
            goto L_0x007e
        L_0x0061:
            com.itextpdf.text.Phrase r6 = new com.itextpdf.text.Phrase
            java.lang.Object[] r0 = new java.lang.Object[r0]
            int r5 = r5.getPageNumber()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0[r2] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r0[r3] = r5
            java.lang.String r5 = "Page %d of %d"
            java.lang.String r5 = java.lang.String.format(r5, r0)
            r6.<init>(r5)
        L_0x007e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applex.snaplingo.util.CreatePdf.getPhrase(com.itextpdf.text.pdf.PdfWriter, java.lang.String, int):com.itextpdf.text.Phrase");
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        super.onPostExecute((Object) str);
        this.mOnPDFCreatedInterface.onPDFCreated(this.mSuccess, this.mPath);
    }

    private BaseColor getBaseColor(int i) {
        return new BaseColor(Color.red(i), Color.green(i), Color.blue(i));
    }
}
