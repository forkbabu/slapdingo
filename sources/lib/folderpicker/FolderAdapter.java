package lib.folderpicker;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class FolderAdapter extends ArrayAdapter<FilePojo> {
    Activity context;
    ArrayList<FilePojo> dataList;

    public FolderAdapter(Activity activity, ArrayList<FilePojo> arrayList) {
        super(activity, R.layout.fp_filerow, arrayList);
        this.context = activity;
        this.dataList = arrayList;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.context.getLayoutInflater().inflate(R.layout.fp_filerow, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.fp_iv_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.fp_tv_name);
        if (this.dataList.get(i).isFolder()) {
            imageView.setImageResource(R.drawable.fp_folder);
        } else {
            imageView.setImageResource(R.drawable.fp_file);
        }
        textView.setText(this.dataList.get(i).getName());
        return inflate;
    }
}
