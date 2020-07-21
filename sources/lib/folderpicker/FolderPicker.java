package lib.folderpicker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.applex.snaplingo.util.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FolderPicker extends Activity {
    Comparator<FilePojo> comparatorAscending = new Comparator<FilePojo>() {
        /* class lib.folderpicker.FolderPicker.AnonymousClass1 */

        public int compare(FilePojo filePojo, FilePojo filePojo2) {
            return filePojo.getName().compareTo(filePojo2.getName());
        }
    };
    ArrayList<FilePojo> filesList;
    ArrayList<FilePojo> folderAndFileList;
    ArrayList<FilePojo> foldersList;
    String location = Environment.getExternalStorageDirectory().getAbsolutePath();
    boolean pickFiles;
    Intent receivedIntent;
    TextView tv_location;
    TextView tv_title;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String string;
        String string2;
        super.onCreate(bundle);
        setContentView(R.layout.fp_main_layout);
        if (!isExternalStorageReadable()) {
            Toast.makeText(this, "Storage access permission not given", 1).show();
            finish();
        }
        this.tv_title = (TextView) findViewById(R.id.fp_tv_title);
        this.tv_location = (TextView) findViewById(R.id.fp_tv_location);
        try {
            Intent intent = getIntent();
            this.receivedIntent = intent;
            if (intent.hasExtra("title") && (string2 = this.receivedIntent.getExtras().getString("title")) != null) {
                this.tv_title.setText(string2);
            }
            if (this.receivedIntent.hasExtra(FirebaseAnalytics.Param.LOCATION) && (string = this.receivedIntent.getExtras().getString(FirebaseAnalytics.Param.LOCATION)) != null && new File(string).exists()) {
                this.location = string;
            }
            if (this.receivedIntent.hasExtra("pickFiles")) {
                boolean z = this.receivedIntent.getExtras().getBoolean("pickFiles");
                this.pickFiles = z;
                if (z) {
                    findViewById(R.id.fp_btn_select).setVisibility(8);
                    findViewById(R.id.fp_btn_new).setVisibility(8);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadLists(this.location);
    }

    /* access modifiers changed from: package-private */
    public boolean isExternalStorageReadable() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    /* access modifiers changed from: package-private */
    public void loadLists(String str) {
        try {
            File file = new File(str);
            if (!file.isDirectory()) {
                exit();
            }
            this.tv_location.setText("Location : " + file.getAbsolutePath());
            File[] listFiles = file.listFiles();
            this.foldersList = new ArrayList<>();
            this.filesList = new ArrayList<>();
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    this.foldersList.add(new FilePojo(file2.getName(), true));
                } else {
                    this.filesList.add(new FilePojo(file2.getName(), false));
                }
            }
            Collections.sort(this.foldersList, this.comparatorAscending);
            ArrayList<FilePojo> arrayList = new ArrayList<>();
            this.folderAndFileList = arrayList;
            arrayList.addAll(this.foldersList);
            if (this.pickFiles) {
                Collections.sort(this.filesList, this.comparatorAscending);
                this.folderAndFileList.addAll(this.filesList);
            }
            showList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void showList() {
        try {
            FolderAdapter folderAdapter = new FolderAdapter(this, this.folderAndFileList);
            ListView listView = (ListView) findViewById(R.id.fp_listView);
            listView.setAdapter((ListAdapter) folderAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class lib.folderpicker.FolderPicker.AnonymousClass2 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    FolderPicker.this.listClick(i);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void listClick(int i) {
        if (!this.pickFiles || this.folderAndFileList.get(i).isFolder()) {
            String str = this.location + File.separator + this.folderAndFileList.get(i).getName();
            this.location = str;
            loadLists(str);
            return;
        }
        this.receivedIntent.putExtra("data", this.location + File.separator + this.folderAndFileList.get(i).getName());
        setResult(-1, this.receivedIntent);
        finish();
    }

    public void onBackPressed() {
        goBack(null);
    }

    public void goBack(View view) {
        String str = this.location;
        if (str == null || str.equals("") || this.location.equals(Constants.PATH_SEPERATOR)) {
            exit();
            return;
        }
        String substring = this.location.substring(0, this.location.lastIndexOf(47));
        this.location = substring;
        loadLists(substring);
    }

    /* access modifiers changed from: package-private */
    public void exit() {
        setResult(0, this.receivedIntent);
        finish();
    }

    /* access modifiers changed from: package-private */
    public void createNewFolder(String str) {
        try {
            new File(this.location + File.separator + str).mkdirs();
            loadLists(this.location);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error:" + e.toString(), 1).show();
        }
    }

    public void newFolderDialog(View view) {
        AlertDialog create = new AlertDialog.Builder(this).create();
        create.setTitle("Enter Folder Name");
        final EditText editText = new EditText(this);
        create.setView(editText);
        create.setButton(-1, "Create", new DialogInterface.OnClickListener() {
            /* class lib.folderpicker.FolderPicker.AnonymousClass3 */

            public void onClick(DialogInterface dialogInterface, int i) {
                FolderPicker.this.createNewFolder(editText.getText().toString());
            }
        });
        create.setButton(-2, "Cancel", new DialogInterface.OnClickListener() {
            /* class lib.folderpicker.FolderPicker.AnonymousClass4 */

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        create.show();
    }

    public void select(View view) {
        if (this.pickFiles) {
            Toast.makeText(this, "You have to select a file", 1).show();
            return;
        }
        Intent intent = this.receivedIntent;
        if (intent != null) {
            intent.putExtra("data", this.location);
            setResult(-1, this.receivedIntent);
            finish();
        }
    }

    public void cancel(View view) {
        exit();
    }
}
