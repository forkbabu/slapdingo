package com.applex.snaplingo.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.applex.snaplingo.CameraActivity;
import com.applex.snaplingo.DatabaseHelper;
import com.applex.snaplingo.Items;
import com.applex.snaplingo.MainActivity;
import com.applex.snaplingo.MainActivity2;
import com.applex.snaplingo.R;
import com.applex.snaplingo.adapters.ProgrammingAdapter;
import com.applex.snaplingo.util.Constants;
import com.applex.snaplingo.util.PermissionsUtils;
import com.applex.snaplingo.util.PicassoEngine;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class OcrFragment extends Fragment {
    private final int INTENT_REQUEST_GET_IMAGES = 13;
    private final int REQUEST_PERMISSIONS_CODE = 124;
    /* access modifiers changed from: private */
    public ActionMode mActionMode;
    /* access modifiers changed from: private */
    public ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        /* class com.applex.snaplingo.fragments.OcrFragment.AnonymousClass3 */

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.context_menu, menu);
            actionMode.setTitle("Select");
            return true;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.delete) {
                Toast.makeText(OcrFragment.this.getActivity(), "Deleted", 1).show();
                OcrFragment ocrFragment = OcrFragment.this;
                ocrFragment.mSelectionList = ocrFragment.mAdapter.getSelected();
                for (int i = 0; i < OcrFragment.this.mSelectionList.size(); i++) {
                    Cursor itemId2 = OcrFragment.this.myDB.getItemId(OcrFragment.this.mSelectionList.get(i).getmText1().replaceAll("'", "''"));
                    int i2 = -1;
                    while (itemId2.moveToNext()) {
                        i2 = itemId2.getInt(0);
                    }
                    if (i2 > -1) {
                        OcrFragment.this.myDB.deleteItem(i2);
                    }
                }
                actionMode.finish();
                OcrFragment.this.createList();
                OcrFragment ocrFragment2 = OcrFragment.this;
                ocrFragment2.buildRecyclerView(ocrFragment2.mList);
                return true;
            } else if (itemId != R.id.merge) {
                return false;
            } else {
                Toast.makeText(OcrFragment.this.getActivity(), "Merged", 1).show();
                StringBuilder sb = new StringBuilder();
                if (OcrFragment.this.mAdapter.getSelected().size() > 1) {
                    for (int i3 = 0; i3 < OcrFragment.this.mAdapter.getSelected().size(); i3++) {
                        sb.append(OcrFragment.this.mAdapter.getSelected().get(i3).getmText1());
                        sb.append("\n");
                    }
                    String format = DateFormat.getDateInstance().format(Calendar.getInstance().getTime());
                    if (!OcrFragment.this.myDB.addData2(sb.toString(), format)) {
                        Toast.makeText(OcrFragment.this.getActivity(), "Something went wrong :(", 0).show();
                        OcrFragment ocrFragment3 = OcrFragment.this;
                        ocrFragment3.buildRecyclerView(ocrFragment3.mList);
                    } else {
                        OcrFragment.this.mList.add(0, new Items(sb.toString(), format));
                        OcrFragment.this.mAdapter.notifyItemInserted(0);
                    }
                } else {
                    Toast.makeText(OcrFragment.this.getActivity(), "Minimum two items required for merging", 1).show();
                }
                actionMode.finish();
                return true;
            }
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            ActionMode unused = OcrFragment.this.mActionMode = null;
            OcrFragment.this.createList();
            OcrFragment ocrFragment = OcrFragment.this;
            ocrFragment.buildRecyclerView(ocrFragment.mList);
        }
    };
    public ProgrammingAdapter mAdapter;
    public RecyclerView.LayoutManager mLayoutManager;
    public ArrayList<Items> mList;
    private boolean mPermissionGranted = false;
    public RecyclerView mRecyclerView;
    public ArrayList<Items> mSelectionList;
    /* access modifiers changed from: private */
    public DatabaseHelper myDB;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_ocr, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getRuntimePermissions();
        this.mPermissionGranted = PermissionsUtils.getInstance().checkRuntimePermissions(this, Constants.READ_WRITE_CAMERA_PERMISSIONS);
        this.myDB = new DatabaseHelper(getActivity());
        this.mRecyclerView = (RecyclerView) view.findViewById(R.id.history);
        createList();
        buildRecyclerView(this.mList);
    }

    public void AddData(int i, String str, String str2) {
        if (!this.myDB.addData(i, str, str2)) {
            Toast.makeText(getActivity(), "Something went wrong :(", 0).show();
        }
    }

    /* access modifiers changed from: package-private */
    public void startCamera() {
        boolean checkRuntimePermissions = PermissionsUtils.getInstance().checkRuntimePermissions(this, Constants.READ_WRITE_CAMERA_PERMISSIONS);
        this.mPermissionGranted = checkRuntimePermissions;
        if (!checkRuntimePermissions) {
            getRuntimePermissions();
        } else {
            selectCamera();
        }
    }

    private void selectImages() {
        Matisse.from(this).choose(MimeType.ofImage(), false).countable(true).maxSelectable(1).showSingleMediaType(true).thumbnailScale(1.0f).theme(2131951857).imageEngine(new PicassoEngine()).forResult(13);
    }

    private void selectCamera() {
        startActivity(new Intent(getActivity(), CameraActivity.class));
    }

    /* access modifiers changed from: package-private */
    public void startAddingImages() {
        boolean checkRuntimePermissions = PermissionsUtils.getInstance().checkRuntimePermissions(this, Constants.READ_WRITE_CAMERA_PERMISSIONS);
        this.mPermissionGranted = checkRuntimePermissions;
        if (!checkRuntimePermissions) {
            getRuntimePermissions();
        } else {
            selectImages();
        }
    }

    private void getRuntimePermissions() {
        PermissionsUtils.getInstance().requestRuntimePermissions(this, Constants.READ_WRITE_CAMERA_PERMISSIONS, 124);
        this.mPermissionGranted = PermissionsUtils.getInstance().checkRuntimePermissions(this, Constants.READ_WRITE_CAMERA_PERMISSIONS);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 13) {
            CropImage.activity(Matisse.obtainResult(intent).get(0)).setActivityTitle("SnapCrop").setAllowRotation(Boolean.TRUE.booleanValue()).setAllowCounterRotation(Boolean.TRUE.booleanValue()).setAllowFlipping(Boolean.TRUE.booleanValue()).setAutoZoomEnabled(Boolean.TRUE.booleanValue()).setMultiTouchEnabled(Boolean.FALSE.booleanValue()).setGuidelines(CropImageView.Guidelines.ON).start(getActivity());
        }
    }

    public void buildRecyclerView(final ArrayList<Items> arrayList) {
        this.mRecyclerView.setHasFixedSize(true);
        this.mLayoutManager = new LinearLayoutManager(getActivity());
        this.mAdapter = new ProgrammingAdapter(arrayList, getActivity());
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
        if (this.myDB.getListContents().getCount() != 0) {
            this.mAdapter.setOnItemClickListener(new ProgrammingAdapter.OnItemClickListener() {
                /* class com.applex.snaplingo.fragments.OcrFragment.AnonymousClass1 */

                @Override // com.applex.snaplingo.adapters.ProgrammingAdapter.OnItemClickListener
                public void onItemClick(int i) {
                    Items items = (Items) arrayList.get(i);
                    if (OcrFragment.this.mActionMode == null) {
                        String str = items.getmText1();
                        String replaceAll = str.replaceAll("'", "''");
                        OcrFragment.this.mAdapter.notifyItemRemoved(i);
                        Cursor itemId = OcrFragment.this.myDB.getItemId(replaceAll);
                        int i2 = -1;
                        while (itemId.moveToNext()) {
                            i2 = itemId.getInt(0);
                        }
                        if (i2 > -1) {
                            Intent intent = new Intent(OcrFragment.this.getActivity(), MainActivity.class);
                            intent.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
                            intent.putExtra("selection", ExifInterface.GPS_MEASUREMENT_3D);
                            OcrFragment.this.startActivity(intent);
                            return;
                        }
                        return;
                    }
                    items.setChecked(!items.isChecked());
                    if (OcrFragment.this.mAdapter.getSelected().size() == 0) {
                        OcrFragment.this.mActionMode.finish();
                        ActionMode unused = OcrFragment.this.mActionMode = null;
                        OcrFragment.this.createList();
                        OcrFragment ocrFragment = OcrFragment.this;
                        ocrFragment.buildRecyclerView(ocrFragment.mList);
                    }
                    OcrFragment.this.mAdapter.notifyDataSetChanged();
                }

                @Override // com.applex.snaplingo.adapters.ProgrammingAdapter.OnItemClickListener
                public void onShareClick(int i) {
                    String str = ((Items) arrayList.get(i)).getmText1();
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", str);
                    intent.setType("text/plain");
                    OcrFragment.this.startActivity(intent);
                }
            });
            this.mAdapter.setOnItemLongClickListener(new ProgrammingAdapter.OnItemLongClickListener() {
                /* class com.applex.snaplingo.fragments.OcrFragment.AnonymousClass2 */

                @Override // com.applex.snaplingo.adapters.ProgrammingAdapter.OnItemLongClickListener
                public void onItemLongClick(int i) {
                    ((Items) arrayList.get(i)).setChecked(true);
                    if (OcrFragment.this.mActionMode == null) {
                        OcrFragment ocrFragment = OcrFragment.this;
                        ActionMode unused = ocrFragment.mActionMode = ((MainActivity2) OcrFragment.this.getActivity()).startActionMode(ocrFragment.mActionModeCallback);
                        OcrFragment.this.mAdapter.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    public void createList() {
        this.mList = new ArrayList<>();
        Cursor listContents = this.myDB.getListContents();
        if (listContents.getCount() == 0) {
            this.mList.add(new Items("Welcome To SnapLingo \n Snap to start extracting text", DateFormat.getDateInstance().format(Calendar.getInstance().getTime())));
            return;
        }
        listContents.moveToPosition(listContents.getCount());
        while (listContents.moveToPrevious()) {
            this.mList.add(new Items(listContents.getString(1), listContents.getString(2)));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.search) {
            SearchView searchView = (SearchView) menuItem.getActionView();
            searchView.setQueryHint("Search");
            final ArrayList arrayList = new ArrayList();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                /* class com.applex.snaplingo.fragments.OcrFragment.AnonymousClass4 */

                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextSubmit(String str) {
                    return false;
                }

                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextChange(String str) {
                    arrayList.clear();
                    Iterator<Items> it2 = OcrFragment.this.mList.iterator();
                    while (it2.hasNext()) {
                        Items next = it2.next();
                        if (next.getmText1().toLowerCase().contains(str.toLowerCase())) {
                            arrayList.add(next);
                        }
                    }
                    OcrFragment.this.buildRecyclerView(arrayList);
                    return false;
                }
            });
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z || !isResumed()) {
            ActionMode actionMode = this.mActionMode;
            if (actionMode != null) {
                actionMode.finish();
                this.mActionMode = null;
                return;
            }
            return;
        }
        onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
            this.mActionMode = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (DocumentFragment.swipe != 0) {
            DocumentFragment.swipe = 0;
        } else {
            createList();
            buildRecyclerView(this.mList);
        }
        if (getUserVisibleHint()) {
            final MainActivity2 mainActivity2 = (MainActivity2) getActivity();
            mainActivity2.btnGall.setOnClickListener(new View.OnClickListener(mainActivity2) {
                /* class com.applex.snaplingo.fragments.$$Lambda$OcrFragment$rND8G2o7uWFSOlrMEdjUXXKftc */
                public final /* synthetic */ MainActivity2 f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    OcrFragment.this.lambda$onResume$0$OcrFragment(this.f$1, view);
                }
            });
            mainActivity2.btnCamera.setOnClickListener(new View.OnClickListener() {
                /* class com.applex.snaplingo.fragments.OcrFragment.AnonymousClass5 */

                public void onClick(View view) {
                    mainActivity2.btnCamera.startAnimation(AnimationUtils.loadAnimation(OcrFragment.this.getActivity(), R.anim.bounce));
                    OcrFragment.this.startCamera();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onResume$0$OcrFragment(MainActivity2 mainActivity2, View view) {
        mainActivity2.btnGall.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.bounce));
        startAddingImages();
    }
}
