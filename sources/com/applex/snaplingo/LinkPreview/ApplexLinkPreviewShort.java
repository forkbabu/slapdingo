package com.applex.snaplingo.LinkPreview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Spannable;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.applex.snaplingo.R;
import com.squareup.picasso.Picasso;

public class ApplexLinkPreviewShort extends RelativeLayout {
    Context context;
    ImageView imageView;
    /* access modifiers changed from: private */
    public boolean isDefaultClick = true;
    CardView linearLayout;
    private String main_url;
    /* access modifiers changed from: private */
    public MetaData meta;
    /* access modifiers changed from: private */
    public RichLinkListener richLinkListener;
    TextView textViewDesp;
    TextView textViewOriginalUrl;
    TextView textViewTitle;
    TextView textViewUrl;
    private View view;

    public ApplexLinkPreviewShort(Context context2) {
        super(context2);
        this.context = context2;
    }

    public ApplexLinkPreviewShort(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
    }

    public ApplexLinkPreviewShort(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
    }

    public ApplexLinkPreviewShort(Context context2, AttributeSet attributeSet, int i, int i2) {
        super(context2, attributeSet, i, i2);
        this.context = context2;
    }

    public void initView() {
        if (findLinearLayoutChild() != null) {
            this.view = findLinearLayoutChild();
        } else {
            this.view = this;
            inflate(this.context, R.layout.link_preview_short_layout, this);
        }
        this.linearLayout = (CardView) findViewById(R.id.rich_link_card);
        this.imageView = (ImageView) findViewById(R.id.rich_link_image);
        this.textViewTitle = (TextView) findViewById(R.id.rich_link_title);
        this.textViewDesp = (TextView) findViewById(R.id.rich_link_desp);
        this.textViewUrl = (TextView) findViewById(R.id.rich_link_url);
        TextView textView = (TextView) findViewById(R.id.rich_link_original_url);
        this.textViewOriginalUrl = textView;
        textView.setText(this.main_url);
        removeUnderlines((Spannable) this.textViewOriginalUrl.getText());
        if (this.meta.getImageurl().equals("") || this.meta.getImageurl().isEmpty()) {
            this.imageView.setVisibility(8);
        } else {
            this.imageView.setVisibility(0);
            Picasso.get().load(this.meta.getImageurl()).placeholder(R.drawable.image_background_grey).into(this.imageView);
        }
        if (this.meta.getTitle().isEmpty() || this.meta.getTitle().equals("")) {
            this.textViewTitle.setVisibility(8);
        } else {
            this.textViewTitle.setVisibility(0);
            this.textViewTitle.setText(this.meta.getTitle());
        }
        if (this.meta.getUrl().isEmpty() || this.meta.getUrl().equals("")) {
            this.textViewUrl.setVisibility(8);
        } else {
            this.textViewUrl.setVisibility(0);
            this.textViewUrl.setText(this.meta.getUrl());
        }
        if (this.meta.getDescription().isEmpty() || this.meta.getDescription().equals("")) {
            this.textViewDesp.setVisibility(8);
        } else {
            this.textViewDesp.setVisibility(0);
            this.textViewDesp.setText(this.meta.getDescription());
        }
        this.linearLayout.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.LinkPreview.ApplexLinkPreviewShort.AnonymousClass1 */

            public void onClick(View view) {
                if (ApplexLinkPreviewShort.this.isDefaultClick) {
                    ApplexLinkPreviewShort.this.richLinkClicked();
                } else if (ApplexLinkPreviewShort.this.richLinkListener != null) {
                    ApplexLinkPreviewShort.this.richLinkListener.onClicked(view, ApplexLinkPreviewShort.this.meta);
                } else {
                    ApplexLinkPreviewShort.this.richLinkClicked();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void richLinkClicked() {
        this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.main_url)));
    }

    /* access modifiers changed from: protected */
    public LinearLayout findLinearLayoutChild() {
        if (getChildCount() <= 0 || !(getChildAt(0) instanceof LinearLayout)) {
            return null;
        }
        return (LinearLayout) getChildAt(0);
    }

    public void setLinkFromMeta(MetaData metaData) {
        this.meta = metaData;
        initView();
    }

    public MetaData getMetaData() {
        return this.meta;
    }

    public void setDefaultClickListener(boolean z) {
        this.isDefaultClick = z;
    }

    public void setClickListener(RichLinkListener richLinkListener2) {
        this.richLinkListener = richLinkListener2;
    }

    public void setLink(String str, final ViewListener viewListener) {
        this.main_url = str;
        new RichPreview(new ResponseListener() {
            /* class com.applex.snaplingo.LinkPreview.ApplexLinkPreviewShort.AnonymousClass2 */

            @Override // com.applex.snaplingo.LinkPreview.ResponseListener
            public void onData(MetaData metaData) {
                MetaData unused = ApplexLinkPreviewShort.this.meta = metaData;
                if (ApplexLinkPreviewShort.this.meta.getTitle().isEmpty() || ApplexLinkPreviewShort.this.meta.getTitle().equals("")) {
                    viewListener.onSuccess(true);
                }
                ApplexLinkPreviewShort.this.initView();
            }

            @Override // com.applex.snaplingo.LinkPreview.ResponseListener
            public void onError(Exception exc) {
                viewListener.onError(exc);
            }
        }).getPreview(str);
    }

    private static void removeUnderlines(Spannable spannable) {
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (URLSpan uRLSpan : uRLSpanArr) {
            int spanStart = spannable.getSpanStart(uRLSpan);
            int spanEnd = spannable.getSpanEnd(uRLSpan);
            spannable.removeSpan(uRLSpan);
            spannable.setSpan(new URLSpanNoUnderline(uRLSpan.getURL()), spanStart, spanEnd, 0);
        }
    }
}
