package com.zhihu.matisse.internal.ui;

import android.os.Bundle;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.entity.SelectionSpec;
import com.zhihu.matisse.internal.model.SelectedItemCollection;
import java.util.ArrayList;

public class SelectedPreviewActivity extends BasePreviewActivity {
    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.zhihu.matisse.internal.ui.BasePreviewActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!SelectionSpec.getInstance().hasInited) {
            setResult(0);
            finish();
            return;
        }
        ArrayList parcelableArrayList = getIntent().getBundleExtra(BasePreviewActivity.EXTRA_DEFAULT_BUNDLE).getParcelableArrayList(SelectedItemCollection.STATE_SELECTION);
        this.mAdapter.addAll(parcelableArrayList);
        this.mAdapter.notifyDataSetChanged();
        if (this.mSpec.countable) {
            this.mCheckView.setCheckedNum(1);
        } else {
            this.mCheckView.setChecked(true);
        }
        this.mPreviousPos = 0;
        updateSize((Item) parcelableArrayList.get(0));
    }
}
