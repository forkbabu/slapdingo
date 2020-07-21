package com.applex.snaplingo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.applex.snaplingo.Items;
import com.applex.snaplingo.R;
import java.util.ArrayList;

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingViewHolder> {
    private Context mContext;
    private ArrayList<Items> mList;
    private OnItemClickListener mListener;
    private OnItemLongClickListener mlonglistener;

    public interface OnItemClickListener {
        void onItemClick(int i);

        void onShareClick(int i);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(int i);
    }

    public ProgrammingAdapter(ArrayList<Items> arrayList, Context context) {
        this.mList = arrayList;
        this.mContext = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mlonglistener = onItemLongClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ProgrammingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ProgrammingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_layout, viewGroup, false), this.mListener, this.mlonglistener);
    }

    public void onBindViewHolder(ProgrammingViewHolder programmingViewHolder, int i) {
        programmingViewHolder.bind(this.mList.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mList.size();
    }

    public static class ProgrammingViewHolder extends RecyclerView.ViewHolder {
        private TextView mBulletView;
        private TextView mTextView;
        private TextView mdateView;
        private LinearLayout mlistitem;
        private ImageButton shareimg;

        public ProgrammingViewHolder(View view, final OnItemClickListener onItemClickListener, final OnItemLongClickListener onItemLongClickListener) {
            super(view);
            this.mBulletView = (TextView) view.findViewById(R.id.bullet_view);
            this.mTextView = (TextView) view.findViewById(R.id.text_title);
            this.shareimg = (ImageButton) view.findViewById(R.id.sharecard);
            this.mdateView = (TextView) view.findViewById(R.id.date_text);
            this.mlistitem = (LinearLayout) view.findViewById(R.id.list_item);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.applex.snaplingo.adapters.ProgrammingAdapter.ProgrammingViewHolder.AnonymousClass1 */

                public void onClick(View view) {
                    int adapterPosition;
                    if (onItemClickListener != null && (adapterPosition = ProgrammingViewHolder.this.getAdapterPosition()) != -1) {
                        onItemClickListener.onItemClick(adapterPosition);
                    }
                }
            });
            this.shareimg.setOnClickListener(new View.OnClickListener() {
                /* class com.applex.snaplingo.adapters.ProgrammingAdapter.ProgrammingViewHolder.AnonymousClass2 */

                public void onClick(View view) {
                    int adapterPosition;
                    if (onItemClickListener != null && (adapterPosition = ProgrammingViewHolder.this.getAdapterPosition()) != -1) {
                        onItemClickListener.onShareClick(adapterPosition);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.applex.snaplingo.adapters.ProgrammingAdapter.ProgrammingViewHolder.AnonymousClass3 */

                public boolean onLongClick(View view) {
                    int adapterPosition;
                    if (onItemLongClickListener == null || (adapterPosition = ProgrammingViewHolder.this.getAdapterPosition()) == -1) {
                        return false;
                    }
                    onItemLongClickListener.onItemLongClick(adapterPosition);
                    return false;
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void bind(Items items) {
            this.mTextView.setText(items.getmText1());
            this.mdateView.setText(items.getmText2());
            this.mBulletView.setText(items.getmText1().toUpperCase().substring(0, 1));
            if (items.isChecked()) {
                this.itemView.setBackgroundResource(R.color.colorSelection);
                this.mBulletView.setBackgroundResource(R.drawable.ic_check_circle_black_24dp);
                this.mBulletView.setText("");
                return;
            }
            this.itemView.setBackgroundResource(R.drawable.custom_ripple_list);
            this.mBulletView.setBackgroundResource(R.drawable.bullet_bg);
            this.mBulletView.setText(items.getmText1().toUpperCase().substring(0, 1));
        }
    }

    public ArrayList<Items> getSelected() {
        ArrayList<Items> arrayList = new ArrayList<>();
        for (int i = 0; i < this.mList.size(); i++) {
            if (this.mList.get(i).isChecked()) {
                arrayList.add(this.mList.get(i));
            }
        }
        return arrayList;
    }
}
