package com.applex.snaplingo.LinkPreview;

import android.os.AsyncTask;
import android.webkit.URLUtil;
import com.itextpdf.text.html.HtmlTags;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RichPreview {
    MetaData metaData = new MetaData();
    ResponseListener responseListener;
    String url;

    public RichPreview(ResponseListener responseListener2) {
        this.responseListener = responseListener2;
    }

    public void getPreview(String str) {
        this.url = str;
        new getData().execute(new Void[0]);
    }

    private class getData extends AsyncTask<Void, Void, Void> {
        private getData() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            String str;
            URI uri;
            try {
                Document document = Jsoup.connect(RichPreview.this.url).timeout(30000).get();
                Elements elementsByTag = document.getElementsByTag("meta");
                String attr = document.select("meta[property=og:title]").attr("content");
                if (attr == null || attr.isEmpty()) {
                    attr = document.title();
                }
                RichPreview.this.metaData.setTitle(attr);
                String attr2 = document.select("meta[name=description]").attr("content");
                if (attr2.isEmpty() || attr2 == null) {
                    attr2 = document.select("meta[name=Description]").attr("content");
                }
                if (attr2.isEmpty() || attr2 == null) {
                    attr2 = document.select("meta[property=og:description]").attr("content");
                }
                if (attr2.isEmpty() || attr2 == null) {
                    attr2 = "";
                }
                RichPreview.this.metaData.setDescription(attr2);
                Elements select = document.select("meta[name=medium]");
                if (select.size() > 0) {
                    str = select.attr("content");
                    if (str.equals("image")) {
                        str = "photo";
                    }
                } else {
                    str = document.select("meta[property=og:type]").attr("content");
                }
                RichPreview.this.metaData.setMediatype(str);
                Elements select2 = document.select("meta[property=og:image]");
                if (select2.size() > 0) {
                    String attr3 = select2.attr("content");
                    if (!attr3.isEmpty()) {
                        RichPreview.this.metaData.setImageurl(RichPreview.this.resolveURL(RichPreview.this.url, attr3));
                    }
                }
                if (RichPreview.this.metaData.getImageurl().isEmpty()) {
                    String attr4 = document.select("link[rel=image_src]").attr(HtmlTags.HREF);
                    if (!attr4.isEmpty()) {
                        RichPreview.this.metaData.setImageurl(RichPreview.this.resolveURL(RichPreview.this.url, attr4));
                    } else {
                        String attr5 = document.select("link[rel=apple-touch-icon]").attr(HtmlTags.HREF);
                        if (!attr5.isEmpty()) {
                            RichPreview.this.metaData.setImageurl(RichPreview.this.resolveURL(RichPreview.this.url, attr5));
                            RichPreview.this.metaData.setFavicon(RichPreview.this.resolveURL(RichPreview.this.url, attr5));
                        } else {
                            String attr6 = document.select("link[rel=icon]").attr(HtmlTags.HREF);
                            if (!attr6.isEmpty()) {
                                RichPreview.this.metaData.setImageurl(RichPreview.this.resolveURL(RichPreview.this.url, attr6));
                                RichPreview.this.metaData.setFavicon(RichPreview.this.resolveURL(RichPreview.this.url, attr6));
                            }
                        }
                    }
                }
                String attr7 = document.select("link[rel=apple-touch-icon]").attr(HtmlTags.HREF);
                if (!attr7.isEmpty()) {
                    RichPreview.this.metaData.setFavicon(RichPreview.this.resolveURL(RichPreview.this.url, attr7));
                } else {
                    String attr8 = document.select("link[rel=icon]").attr(HtmlTags.HREF);
                    if (!attr8.isEmpty()) {
                        RichPreview.this.metaData.setFavicon(RichPreview.this.resolveURL(RichPreview.this.url, attr8));
                    }
                }
                Iterator it2 = elementsByTag.iterator();
                while (it2.hasNext()) {
                    Element element = (Element) it2.next();
                    if (element.hasAttr("property")) {
                        String trim = element.attr("property").toString().trim();
                        if (trim.equals("og:url")) {
                            RichPreview.this.metaData.setUrl(element.attr("content").toString());
                        }
                        if (trim.equals("og:site_name")) {
                            RichPreview.this.metaData.setSitename(element.attr("content").toString());
                        }
                    }
                }
                if (RichPreview.this.metaData.getUrl().equals("") || RichPreview.this.metaData.getUrl().isEmpty()) {
                    try {
                        uri = new URI(RichPreview.this.url);
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                        uri = null;
                    }
                    if (RichPreview.this.url == null) {
                        RichPreview.this.metaData.setUrl(RichPreview.this.url);
                    } else {
                        RichPreview.this.metaData.setUrl(uri.getHost());
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                RichPreview.this.responseListener.onError(new Exception("No Html Received from " + RichPreview.this.url + " Check your Internet " + e2.getLocalizedMessage()));
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            super.onPostExecute((Object) voidR);
            RichPreview.this.responseListener.onData(RichPreview.this.metaData);
        }
    }

    /* access modifiers changed from: private */
    public String resolveURL(String str, String str2) {
        if (URLUtil.isValidUrl(str2)) {
            return str2;
        }
        URI uri = null;
        try {
            uri = new URI(str);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri.toString();
    }
}
