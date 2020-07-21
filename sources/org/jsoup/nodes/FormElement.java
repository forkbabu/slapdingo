package org.jsoup.nodes;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class FormElement extends Element {
    private final Elements elements = new Elements();

    public FormElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
    }

    public Elements elements() {
        return this.elements;
    }

    public FormElement addElement(Element element) {
        this.elements.add(element);
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // org.jsoup.nodes.Node
    public void removeChild(Node node) {
        super.removeChild(node);
        this.elements.remove(node);
    }

    public Connection submit() {
        String absUrl = hasAttr("action") ? absUrl("action") : baseUri();
        Validate.notEmpty(absUrl, "Could not determine a form action URL for submit. Ensure you set a base URI when parsing.");
        return Jsoup.connect(absUrl).data(formData()).method(attr(FirebaseAnalytics.Param.METHOD).toUpperCase().equals("POST") ? Connection.Method.POST : Connection.Method.GET);
    }

    public List<Connection.KeyVal> formData() {
        Element first;
        ArrayList arrayList = new ArrayList();
        Iterator it2 = this.elements.iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (element.tag().isFormSubmittable() && !element.hasAttr("disabled")) {
                String attr = element.attr(AppMeasurementSdk.ConditionalUserProperty.NAME);
                if (attr.length() != 0) {
                    String attr2 = element.attr("type");
                    if (!attr2.equalsIgnoreCase("button")) {
                        if ("select".equals(element.normalName())) {
                            boolean z = false;
                            Iterator it3 = element.select("option[selected]").iterator();
                            while (it3.hasNext()) {
                                arrayList.add(HttpConnection.KeyVal.create(attr, ((Element) it3.next()).val()));
                                z = true;
                            }
                            if (!z && (first = element.select("option").first()) != null) {
                                arrayList.add(HttpConnection.KeyVal.create(attr, first.val()));
                            }
                        } else if (!"checkbox".equalsIgnoreCase(attr2) && !"radio".equalsIgnoreCase(attr2)) {
                            arrayList.add(HttpConnection.KeyVal.create(attr, element.val()));
                        } else if (element.hasAttr("checked")) {
                            arrayList.add(HttpConnection.KeyVal.create(attr, element.val().length() > 0 ? element.val() : DebugKt.DEBUG_PROPERTY_VALUE_ON));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.Node, org.jsoup.nodes.Element, org.jsoup.nodes.Element, org.jsoup.nodes.Element, java.lang.Object
    public FormElement clone() {
        return (FormElement) super.clone();
    }
}
